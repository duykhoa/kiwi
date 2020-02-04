package io.from.source.kiwi.jsonpath

import io.from.source.kiwi.json.JsonObject
import io.from.source.kiwi.json.JsonParser
import io.from.source.kiwi.json.JsonString
import io.fromsource.kiwi.core.should
import kotlin.test.Test

class JsonPathTest {
    private val parser = JsonParser()

    @Test
    fun `should select whole json by $`() {
        val json = parser.parse("{}")

        json.evaluatePath("$").should
                .contain(json)
                .haveSize(1)
    }

    @Test
    fun `should throw exception when path does not start with $`() {
        val json = parser.parse("{}")

        runCatching {
            json.evaluatePath(".")
        }.should
                .beFailure(JsonPathException::class)
                .haveFailureMessage("Json path should start with '$'")
    }

    @Test
    fun `should select json 1st level property`() {
        val json = parser.parse("""{
            "book": "The Lord of the Rings"
        }""")

        json.evaluatePath("$.book").should
                .contain(JsonString("The Lord of the Rings"))
                .haveSize(1)
    }

    @Test
    fun `should select json n level property`() {
        val json = parser.parse("""{
            "book": {
                "title": "The Lord of the Rings"
            }
        }""")

        json.evaluatePath("$.book.title").should
                .contain(JsonString("The Lord of the Rings"))
                .haveSize(1)
    }

    @Test
    fun `should find recursive descent from root element`() {
        val json = parser.parse("""{
            "book": {
                "title": "The Lord of the Rings"
            }
        }""")

        json.evaluatePath("$..").should
                .contain(
                        json,
                        JsonObject(mapOf("title" to JsonString("The Lord of the Rings"))))
                .haveSize(2)
    }

    @Test
    fun `should find recursively all elements for single json`() {
        val json = parser.parse("""{
            "book": {
                "title": "The Lord of the Rings"
            }
        }""")

        json.evaluatePath("$..book").should
                .contain(JsonObject(mapOf("title" to JsonString("The Lord of the Rings"))))
                .haveSize(1)
    }

    @Test
    fun `should find recursively all elements for nested json`() {
        val json = parser.parse("""{
            "new": {
                "book": {
                    "title": "The Lord of the Rings"
                }
            },
            "used": {
                "comics": "Solaris",
                "details": {}
            }
        }""")

        json.evaluatePath("$..").should
                .contain(
                        json,
                        JsonObject(mapOf("book" to JsonObject(mapOf("title" to JsonString("The Lord of the Rings"))))),
                        JsonObject(mapOf("title" to JsonString("The Lord of the Rings"))),
                        JsonObject(mapOf("comics" to JsonString("Solaris"), "details" to JsonObject())),
                        JsonObject()
                )
                .haveSize(5)
    }

    @Test
    fun `should find recursively all elements by name`() {
        val json = parser.parse("""{
            "new": {
                "book": {
                    "title": "The Lord of the Rings"
                }
            },
            "used": {
                "book": "Solaris",
                "details": {}
            }
        }""")

        json.evaluatePath("$..book").should
                .contain(
                        JsonObject(mapOf("title" to JsonString("The Lord of the Rings"))),
                        JsonString("Solaris"))
                .haveSize(2)
    }

    @Test
    fun `should find recursively firstly and next by name`() {
        val json = parser.parse("""{
            "new": {
                "book": {
                    "title": "The Lord of the Rings"
                }
            },
            "used": {
                "book": "Solaris",
                "details": {}
            }
        }""")

        json.evaluatePath("$..book.title").should
                .contain(
                        JsonString("The Lord of the Rings"))
                .haveSize(1)
    }
}
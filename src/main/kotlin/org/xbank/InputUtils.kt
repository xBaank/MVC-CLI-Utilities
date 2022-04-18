package org.xbank

import java.util.function.Consumer

object InputUtils {
    @JvmStatic
    fun readToProperty(action: Consumer<String>) {
        var isOk: Boolean
        do isOk = try {
            action.accept(readlnOrNull()!!)
            true
        } catch (ex: Exception) {
            println(ex.message)
            false
        }
        while (!isOk)
    }
    @JvmStatic
    fun readToPropertyWithCustomMessage(action: Consumer<String>, message: String) {
        var isOk: Boolean
        do isOk = try {
            action.accept(readlnOrNull()!!)
            true
        } catch (ex: Exception) {
            println(message)
            false
        }
        while (!isOk)
    }
    @JvmStatic
    fun readToPropertyIfNotNullOrBlank(action: Consumer<String>) {
        var isOk: Boolean
        do isOk = try {
            val input = readlnOrNull()
            if (!input.isNullOrBlank())
                action.accept(input)
            true
        } catch (ex: Exception) {
            println(ex.message)
            false
        }
        while (!isOk)
    }

    @JvmOverloads
    @JvmStatic
    fun readWhileNoMatch(pattern: String = ".*", message: String = "Introduce un valor de los mostrados"): String {
        val regex = pattern.toRegex()
        var input: String?
        do {
            println(message)
            input = readlnOrNull()
        } while (input == null || !input.matches(regex))
        return input
    }

    @JvmStatic
    fun clearCMD() {
        val builder = StringBuilder()
        for (i in 1..50)
            builder.append("\n")
        print(builder.toString())
    }
}
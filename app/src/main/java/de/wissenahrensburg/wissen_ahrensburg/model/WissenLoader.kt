package de.wissenahrensburg.wissen_ahrensburg.model

import android.content.Context
import de.wissenahrensburg.wissen_ahrensburg.R
import java.io.BufferedReader
import java.io.InputStreamReader

object WissenLoader {
    fun loadWissen(context: Context): List<Wissendatenbank> {
        val wissenList = mutableListOf<Wissendatenbank>()
        val inputStream = context.resources.openRawResource(R.raw.wissen_datenbank)
        val reader = BufferedReader(InputStreamReader(inputStream))

        // Skip header
        reader.readLine()

        reader.useLines { lines ->
            lines.forEach { line ->
                val tokens = parseCsvLine(line)
                if (tokens.size >= 3) {
                    wissenList.add(
                        Wissendatenbank(
                            titel = tokens[0],
                            beschreibung = tokens[1],
                            adresse = tokens[2]
                        )
                    )
                }
            }
        }
        return wissenList
    }

    private fun parseCsvLine(line: String): List<String> {
        val result = mutableListOf<String>()
        var currentToken = StringBuilder()
        var inQuotes = false
        
        var i = 0
        while (i < line.length) {
            val c = line[i]
            when {
                c == '\"' -> {
                    inQuotes = !inQuotes
                }
                c == ',' && !inQuotes -> {
                    result.add(currentToken.toString().trim())
                    currentToken = StringBuilder()
                }
                else -> {
                    currentToken.append(c)
                }
            }
            i++
        }
        result.add(currentToken.toString().trim())
        return result
    }
}

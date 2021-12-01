package utils

import java.io.File

fun readFile(name: String, type: String = "main") =
    File("src/$type/resources/input/$name.txt")
        .readLines()
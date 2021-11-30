import java.io.File

fun readFile(name: String) =
    File("src/main/resources/input/$name.txt")
        .readLines()
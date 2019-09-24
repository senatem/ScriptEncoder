import java.io.File

fun main(args: Array<String>) {
    File("readable").walk().forEach {
        if(it.name.endsWith(".dec")) {
            File("script\\${it.name.substringBefore(".")}.enc").writeText("")
            encodeFile(it)
        }
    }
}

fun encodeLine(line: String) : ByteArray{
    val array = "$line\n".toByteArray()
    for(i in array.indices) {
        array[i] = (array[i].toInt() + 5).toByte()
    }
    return array
}

fun encodeFile(file: File){
    val readContent = file.readLines()

    for(line in readContent) {
        File("script\\${file.name.substringBefore(".")}.enc").appendBytes(encodeLine(line))
    }
}


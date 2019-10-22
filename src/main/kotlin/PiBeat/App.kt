package PiBeat

fun main(args: Array<String>) {
    val si = oshi.SystemInfo()
    println("""
        Network information
        ${"=".repeat(80)}

    """.trimIndent())
    si.hardware.networkIFs.forEach {
        println("""
            Interface ${it.displayName}
            Sent ${it.bytesSent}
            Recv ${it.bytesRecv}
            ${"-".repeat(80)}
        """.trimIndent())
    }
}

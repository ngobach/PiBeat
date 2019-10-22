package PiBeat

import fi.iki.elonen.NanoHTTPD

class WebServer(port: Int): NanoHTTPD(port) {
    override fun serve(session: IHTTPSession?): Response {
        if (session == null) {
            return newFixedLengthResponse("WELL WELL")
        }
        val resp = newFixedLengthResponse("""
            Hello ${session.headers.get("user-agent")?.split(" ")?.firstOrNull() ?: ""}
            Your IP address is ${session.remoteIpAddress}
        """.trimIndent())
        resp.mimeType = "text/plain"
        return resp
    }
}

fun startServer() {
    val sv = WebServer(8080)
    sv.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false)
}
package PiBeat

import java.lang.Exception


fun main() {
    val logger = org.slf4j.LoggerFactory.getLogger("PiBeat")
    val port = 8080
    try {
        val server = WebServer(port)
        server.start()
        logger.info("Server is listening at $port")
    } catch (e: Exception) {
        logger.error("Unable to start Web Server", e)
    }
}

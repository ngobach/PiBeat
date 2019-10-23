package PiBeat

import org.aeonbits.owner.ConfigFactory

class Dumb

fun main() {
    val logger = org.slf4j.LoggerFactory.getLogger("PiBeat")
    val config = ConfigFactory.create(AppConfig::class.java)
    try {
        val server = WebServer(config.port)
        server.start()
        logger.info("Server is listening at ${config.port}")
    } catch (e: Exception) {
        logger.error("Unable to start Web Server", e)
    }
}

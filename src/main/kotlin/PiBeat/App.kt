package PiBeat

import org.aeonbits.owner.ConfigFactory

fun main() {
    val logger = org.slf4j.LoggerFactory.getLogger("PiBeat")
    val config = ConfigFactory.create(AppConfig::class.java)
    try {
        Snapshooter.run()
        val server = WebServer(config.port)
        server.start()
        logger.info("Server is listening at ${config.port}")
    } catch (e: Exception) {
        logger.error("Unable to start Web Server", e)
    }
}

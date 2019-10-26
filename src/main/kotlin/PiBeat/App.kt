package PiBeat

fun main() {
    val logger = org.slf4j.LoggerFactory.getLogger("PiBeat")
    try {
        Snapshot.run()
        val server = WebServer(Config.port)
        server.start()
        logger.info("Server is listening at ${Config.port}")
    } catch (e: Exception) {
        logger.error("Unable to start Web Server", e)
    }
}

package PiBeat.handler

import PiBeat.Config
import fi.iki.elonen.NanoHTTPD
import org.slf4j.LoggerFactory
import java.io.File

class ResourceHandler : PiBeat.Handler {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val rootDir = File(System.getProperty("user.dir")).toPath().resolve("static")
    private val ready = rootDir.toFile().isDirectory

    init {
        if (ready) {
            logger.info("Static directory is {}", rootDir)
        } else {
            logger.warn("Resource handler not ready!")
        }
    }

    override fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response? {
        val requestedFile = session.uri.toString()
        val resolved = rootDir.resolve(requestedFile.substring(1)).toAbsolutePath()
        logger.debug("Resolved {}", resolved)
        if (!resolved.startsWith(rootDir)) {
            return NanoHTTPD.newFixedLengthResponse(
                    NanoHTTPD.Response.Status.FORBIDDEN,
                    "text/plain",
                    "You are not allowed to access this file"
            )
        }
        var file = resolved.toFile()
        if (Config.staticIndex && file.isDirectory) {
            file = resolved.resolve("index.html").toFile()
        }
        if (Config.staticFallback && !file.isFile) {
            file = rootDir.resolve("index.html").toFile()
        }
        if (file.isFile) {
            val mime = NanoHTTPD.getMimeTypeForFile(file.path)
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, mime, file.inputStream(), file.length())
        }
        return null
    }
}
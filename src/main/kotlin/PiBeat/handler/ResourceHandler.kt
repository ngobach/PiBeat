package PiBeat.handler

import fi.iki.elonen.NanoHTTPD

class ResourceHandler : PiBeat.Handler {
    override fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response? {
        return null
    }
}
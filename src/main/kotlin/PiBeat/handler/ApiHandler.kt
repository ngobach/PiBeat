package PiBeat.handler

import PiBeat.Handler
import PiBeat.Snapshot
import PiBeat.dto.EveryThing
import fi.iki.elonen.NanoHTTPD


class ApiHandler : Handler {
    private data class Payload(val data: EveryThing, val ts: Long)

    override fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response? {
        val uri = session.uri!!
        return when {
//            uri.contentEquals("/api/get") ->
//                jsonResponse(Payload(Snapshot.lastRecord, Snapshot.lastTime.toEpochMilli()))
            uri.contentEquals("/api/config") ->
                jsonResponse(PiBeat.Config)
            else -> null
        }
    }
}
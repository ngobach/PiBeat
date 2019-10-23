package PiBeat.extensions

import com.fasterxml.jackson.databind.ObjectMapper
import fi.iki.elonen.NanoHTTPD


val objectMapper = ObjectMapper()

fun <T> NanoHTTPD.json(obj: T, code: NanoHTTPD.Response.Status = NanoHTTPD.Response.Status.OK): NanoHTTPD.Response {
    return NanoHTTPD.newFixedLengthResponse(code, "application/json" ,objectMapper.writeValueAsString(obj))
}
package PiBeat.handler

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import fi.iki.elonen.NanoHTTPD

val objectMapper = ObjectMapper().apply {
    enable(SerializationFeature.INDENT_OUTPUT)
}

fun jsonResponse(obj: Any, code: NanoHTTPD.Response.Status = NanoHTTPD.Response.Status.OK): NanoHTTPD.Response {
    return NanoHTTPD.newFixedLengthResponse(code, "application/json" , objectMapper.writeValueAsString(obj))
}
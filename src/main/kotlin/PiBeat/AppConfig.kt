package PiBeat

import org.aeonbits.owner.Config

@Config.Sources("classpath:app.properties")
interface AppConfig : Config {
    @get:Config.Key("server.port")
    val port: Int
}
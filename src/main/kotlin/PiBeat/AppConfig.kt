package PiBeat

import org.aeonbits.owner.Config
import org.aeonbits.owner.ConfigFactory

@Config.Sources("file:app.properties", "classpath:app.properties")
interface AppConfig : Config {
    @get:Config.Key("server.port")
    @get:Config.DefaultValue("8888")
    val port: Int

    @get:Config.Key("snapshot.interval")
    @get:Config.DefaultValue("5000")
    val snapshotInterval: Long

    @get:Config.Key("json.pretty")
    @get:Config.DefaultValue("false")
    val jsonPretty: Boolean
}

val Config: AppConfig = ConfigFactory.create(AppConfig::class.java)

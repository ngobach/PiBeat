package PiBeat

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.aeonbits.owner.Config
import org.aeonbits.owner.ConfigFactory

@Config.Sources("file:app.properties", "classpath:app.properties")
@Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@JsonIgnoreProperties("mbeanInfo")
interface AppConfig : Config {
    @get:Config.Key("server.port")
    val port: Int

    @get:Config.Key("snapshot.interval")
    val snapshotInterval: Long

    @get:Config.Key("web.json.pretty")
    val jsonPretty: Boolean

    @get:Config.Key("web.static.fallback")
    val staticFallback: Boolean

    @get:Config.Key("web.static.index")
    val staticIndex: Boolean
}

val Config: AppConfig = ConfigFactory.create(AppConfig::class.java)

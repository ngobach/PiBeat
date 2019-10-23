package PiBeat
import org.aeonbits.owner.Config

@Config.Sources("classpath:app.properties")
interface AppConfig: Config{
    @Config.Key("server.port")
    fun port(): Int;
}
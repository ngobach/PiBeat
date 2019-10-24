package PiBeat.dto
import com.fasterxml.jackson.annotation.JsonIgnore
import oshi.SystemInfo

class EveryThing(si: SystemInfo) {
    val sysInfo = SysInfo(si)
    val storage = Storage(si)
}
package PiBeat.dto
import com.fasterxml.jackson.annotation.JsonIgnore
import oshi.SystemInfo

class EveryThing(@JsonIgnore val si: SystemInfo) {
    val sysInfo get() = SysInfo(si)
    val storage get() = Storage(si)
}
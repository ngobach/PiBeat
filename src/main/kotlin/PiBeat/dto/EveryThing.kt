package PiBeat.dto
import oshi.SystemInfo

class EveryThing(si: SystemInfo) {
    val sysInfo = SysInfo(si)
    val storage = Storage(si)
}
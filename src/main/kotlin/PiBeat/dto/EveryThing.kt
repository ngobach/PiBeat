package PiBeat.dto
import oshi.SystemInfo

class EveryThing(si: SystemInfo, last5: SystemInfo?, last30: SystemInfo?) {
    val sysInfo = SysInfo(si)
    val storage = Storage(si)
    val compute = Compute(si)
    val memory = Memory(si)
    val network = Network(si)
}
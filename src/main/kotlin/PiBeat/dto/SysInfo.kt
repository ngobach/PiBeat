package PiBeat.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import oshi.SystemInfo

class SysInfo(@JsonIgnore private val si: SystemInfo) {
    val machineName get() = si.hardware.computerSystem.model
    val machineVendor get() = si.hardware.computerSystem.manufacturer
    val family get() = si.operatingSystem.family
    val bitness get() = si.operatingSystem.bitness
    val manifacturer get() = si.operatingSystem.manufacturer

    val upTime get() = si.operatingSystem.systemUptime
    val bootTime get() = si.operatingSystem.systemBootTime
}
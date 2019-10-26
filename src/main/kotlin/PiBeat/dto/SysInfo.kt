package PiBeat.dto

import oshi.SystemInfo

class SysInfo(si: SystemInfo) {
    val machineName = si.hardware.computerSystem.model
    val machineVendor = si.hardware.computerSystem.manufacturer
    val family = si.operatingSystem.family
    val bitness = si.operatingSystem.bitness
    val manifacturer = si.operatingSystem.manufacturer

    val upTime = si.operatingSystem.systemUptime
    val bootTime = si.operatingSystem.systemBootTime
}
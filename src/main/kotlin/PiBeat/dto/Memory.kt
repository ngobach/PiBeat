package PiBeat.dto

import oshi.SystemInfo

class Memory(si: SystemInfo) {
    val total = si.hardware.memory.total
    val available = si.hardware.memory.available
}
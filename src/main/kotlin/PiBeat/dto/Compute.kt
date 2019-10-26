package PiBeat.dto

import oshi.SystemInfo

class Compute(si: SystemInfo) {
    val freqs = si.hardware.processor.currentFreq
    val maxFreq = si.hardware.processor.maxFreq
}
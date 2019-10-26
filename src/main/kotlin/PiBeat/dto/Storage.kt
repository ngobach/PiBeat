package PiBeat.dto

import oshi.SystemInfo

class Storage(si: SystemInfo) {
    data class Disk(
            val name: String,
            val model: String,
            val serial: String,
            val size: Long,
            val read: Long,
            val written: Long
    )

    data class Drive(
            val name: String,
            val at: String,
            val total: Long,
            val free: Long,
            val usable: Long,
            val type: String,
            val uuid: String,
            val volume: String
    )

    val disks = si.hardware.diskStores.map {
        Disk(it.name, it.model, it.serial, it.size, it.readBytes, it.writeBytes)
    }

    val drives = si.operatingSystem.fileSystem.fileStores.map {
        Drive(it.name, it.mount, it.totalSpace, it.freeSpace, it.usableSpace, it.type, it.uuid, it.volume)
    }
}
package PiBeat.dto

import oshi.SystemInfo

data class IF(
        val name: String,
        val sent: Long,
        val rect: Long,
        val ip4: List<String>,
        val ip6: List<String>
)

class Network(si: SystemInfo): ArrayList<IF>() {
    init {
        si.hardware.networkIFs.forEach {
            it.iPv4addr
            add(IF(
                    it.displayName,
                    it.bytesSent,
                    it.bytesRecv,
                    it.iPv4addr.toList(),
                    it.iPv6addr.toList()
            ))
        }
    }
}
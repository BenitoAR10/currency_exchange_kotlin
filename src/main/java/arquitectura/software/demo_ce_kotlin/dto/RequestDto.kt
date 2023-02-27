package arquitectura.software.demo_ce_kotlin.dto

data class RequestDto(
        var from: String?=null,
        var to: String?=null,
        var amount: Double?=null
        )
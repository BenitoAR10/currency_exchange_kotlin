package arquitectura.software.demo_ce_kotlin.dto

import java.math.BigDecimal


data class ExchangeDto(
        var query: RequestDto?=null,
        var result: BigDecimal?=null,
        var info: InfoDto?=null,
        var success: Boolean?=null,
        var date: String?=null
        )
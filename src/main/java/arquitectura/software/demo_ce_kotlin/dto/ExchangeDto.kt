package arquitectura.software.demo_ce_kotlin.dto

import jdk.incubator.concurrent.StructuredTaskScope.ShutdownOnSuccess
import java.math.BigDecimal


data class ExchangeDto(
        var request: RequestDto,
        var result: BigDecimal,
        var info: InfoDto,
        var success: Boolean,
        var date: String?
        )
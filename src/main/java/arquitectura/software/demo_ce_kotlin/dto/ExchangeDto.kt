package arquitectura.software.demo_ce_kotlin.dto

import java.math.BigDecimal


data class ExchangeDto(var request: ResponseDto, var result: BigDecimal, var info: InfoDto)
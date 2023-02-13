package arquitectura.software.demo_ce_kotlin.api

import arquitectura.software.demo_ce_kotlin.bl.CurrencyBl
import arquitectura.software.demo_ce_kotlin.dto.ExchangeDto
import arquitectura.software.demo_ce_kotlin.dto.ResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal


@RestController
@RequestMapping("/api/v1")
class CurrencyApi (val currencyBl: CurrencyBl){
    @GetMapping("/currency")
    fun getExchange(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): ResponseEntity<ResponseDto<ExchangeDto>>{
        val exchangeDto = currencyBl.getExchange(from, to, amount);
        val responseDto = ResponseDto(exchangeDto, true, null);
        return ResponseEntity.ok(responseDto);
    }
}
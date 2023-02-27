package arquitectura.software.demo_ce_kotlin.bl

import arquitectura.software.demo_ce_kotlin.dao.Currency
import arquitectura.software.demo_ce_kotlin.dao.Repository.CurrencyRepository
import arquitectura.software.demo_ce_kotlin.dto.ExchangeDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.util.Date


@Service
public
class CurrencyBl @Autowired constructor(private val currencyRepository: CurrencyRepository){

    companion object {
        val logger: Logger = LoggerFactory.getLogger(CurrencyBl::class.java.name)
    }

    @Value("\${currency.url}")
    private val url: String?=null

    @Value("\${currency.key}")
    private val key: String?=null


    fun getExchange(from: String, to: String, amount: BigDecimal): ExchangeDto?{
        if (amount < BigDecimal.ZERO) {
            logger.error("El monto no puede ser negativo");
            throw IllegalArgumentException("El monto no puede ser negativo");
        }

        val client = OkHttpClient().newBuilder().build()
        val request = Request.Builder()
                .url("$url?to=$to&from=$from&amount=$amount")
                .addHeader("apikey", key)
                .build();

        try{
            logger.info("Invocando a la API")
            val response = client.newCall(request).execute()
            logger.info("Procesando la respuesta")
            val responseBody = response.body().string();
            val objectMapper = ObjectMapper();
            //println(responseBody)
            val currencyDto = objectMapper.readValue(responseBody, ExchangeDto::class.java);
            val currency: Currency = Currency()
            currency.currencyFrom = from
            currency.currencyTo = to
            currency.amount = amount
            currency.result = currencyDto.result!!
            currency.date = Date()
            currencyRepository.save(currency)
            logger.info("Resultado de la conversion: ${responseBody}")
            return currencyDto;
        } catch (e: Exception){
            logger.error("Error al invocar la API", e);
            throw e;
        }


    }
}
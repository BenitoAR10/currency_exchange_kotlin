package arquitectura.software.demo_ce_kotlin.bl

import arquitectura.software.demo_ce_kotlin.dto.ExchangeDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.math.BigDecimal



@Service
public
class CurrencyBl {
    private val logger: Logger = LoggerFactory.getLogger(CurrencyBl::class.java)

    fun getExchange(from: String, to: String, amount: BigDecimal): ExchangeDto?{
        if (amount < BigDecimal.ZERO) {
            logger.error("El monto no puede ser negativo");
            throw IllegalArgumentException("El monto no puede ser negativo");
        }

        val client = OkHttpClient().newBuilder().build()
        val request = Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=$to& from=$from& amount=$amount")
                .addHeader("apikey", "YEraXsSahmYnVTklREwJ6uvCDwm3VpVS")
                .build();

        try{
            logger.info("Invocando a la API")
            val response = client.newCall(request).execute()
            logger.info("Procesando la respuesta")
            val responseBody = response.body().string();
            val objectMapper = jacksonObjectMapper();
            //println(responseBody)
            return objectMapper.readValue(responseBody, ExchangeDto::class.java);
        } catch (e: Exception){
            logger.error("Error al invocar la API", e);
            throw e;
        }

    }
}
package arquitectura.software.demo_ce_kotlin.bl

import arquitectura.software.demo_ce_kotlin.dto.ExchangeDto
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service
import java.math.BigDecimal


@Service
public
class CurrencyBl {
    fun getExchange(from: String, to: String, amount: BigDecimal): ExchangeDto?{
        val client = OkHttpClient().newBuilder().build()
        val request = Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=$to& from=$from& amount=$amount")
                .addHeader("apikey", "YEraXsSahmYnVTklREwJ6uvCDwm3VpVS")
                .build();
        val response = client.newCall(request).execute()
        val responseBody = response.body().string();
        println(responseBody)
        return null;
    }
}
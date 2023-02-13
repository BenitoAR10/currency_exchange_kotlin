package arquitectura.software.demo_ce_kotlin.dto

data class ResponseDto<T> @JvmOverloads constructor(
        var data: T? = null,
        var state: Boolean = false,
        var message: String? = null
        )
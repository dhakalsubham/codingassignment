
import com.squareup.moshi.JsonClass

sealed class NetworkResponse<out T> {
    data class Success<out T>(val data: T) : NetworkResponse<T>()
    data class Error(val error: ErrorResponse? = null) : NetworkResponse<Nothing>()
}

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val message: String,
    val statusCode: Int
)

package api.cornell

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson

private typealias Parameters = List<Pair<String, Any?>>

/**
 * [Http] is used for providing support for API access.
 *
 * @param prefix prefix for URL.
 * @param gson gson used for data deserialization.
 */
internal class Http(private val prefix: String, private val gson: Gson) {

    /**
     * [request] is a function that fetch the result from Cornell APIs without the prefix.
     *
     * @param path API path without prefix.
     * @param parameters defines a list of parameters to give. This is optional.
     * @param handler defines a handler to process result.
     */
    inline fun <reified T> request(
            path: String, parameters: Parameters? = null, crossinline handler: (T) -> Unit
    ) {
        val url = prefix + path
        url.httpGet(parameters = parameters).responseString { _, _, result ->
            when (result) {
                is Result.Success -> {
                    val str = result.value
                    val obj = gson.fromJson(str, T::class.java)
                    if (obj == null) {
                        println(str)
                        // throw Error()
                    }
                    handler(obj)
                }
                is Result.Failure -> {
                    throw(result.error.exception)
                }
            }
        }
    }

    /**
     * [blockingRequest] is a function that fetch the result from Cornell APIs without the prefix,
     * and blocks until the result is ready.
     *
     * @param path API path without prefix.
     * @param parameters defines a list of parameters to give. This is optional.
     * @param <T> the type of the object.
     */
    inline fun <reified T> blockingRequest(path: String, parameters: Parameters? = null): T {
        val url = prefix + path
        val (_, _, result) = url.httpGet(parameters = parameters).responseString()
        when (result) {
            is Result.Success -> {
                val str = result.value
                val obj = gson.fromJson(str, T::class.java)
                if (obj == null) {
                    println(str)
                }
                return obj
            }
            is Result.Failure -> {
                throw(result.error.exception)
            }
        }
    }

}

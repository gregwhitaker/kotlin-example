package com.github.gregwhitaker.kotlinexample

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

fun main(args: Array<String>) {
    "http://httpbin.org/get".httpGet().responseString { request, response, result ->
        when(result) {
            is Result.Success -> {
                println(String(response.data))
            }

            is Result.Failure -> {
                println("This thing blew up")
            }
        }
    }
}

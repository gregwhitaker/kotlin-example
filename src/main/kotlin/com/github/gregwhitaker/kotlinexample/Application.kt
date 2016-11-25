/*
 * Copyright 2016 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.gregwhitaker.kotlinexample

import com.github.gregwhitaker.kotlinexample.model.HttpBinResponse
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    "http://httpbin.org/get".httpGet().responseObject(HttpBinResponse.Deserializer()) { request, response, result ->
        when(result) {
            is Result.Success -> {
                println("The request origin was: " + result.value.origin)
                exitProcess(1)
            }

            is Result.Failure -> {
                println("This thing exploded!")
            }
        }
    }
}

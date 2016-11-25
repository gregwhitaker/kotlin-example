
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

package com.github.gregwhitaker.kotlinexample.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import java.io.Reader

data class HttpBinResponse(
        val args: Map<String, String>,
        val headers: Map<String, String>,
        val origin: String,
        val url: String) {

    class Deserializer : ResponseDeserializable<HttpBinResponse> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, HttpBinResponse::class.java)
    }
}

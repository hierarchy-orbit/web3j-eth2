/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.eth2.api.client

import org.web3j.eth2.api.schema.ErrorMessage
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType

/**
 * Beacon Node API exception containing error data.
 */
class BeaconNodeException private constructor(
    val status: Int,
    override val message: String,
    val stacktraces: List<String> = emptyList()
) : RuntimeException(message) {
    companion object {

        @JvmStatic
        fun of(exception: WebApplicationException): BeaconNodeException {
            return with(exception.response) {
                if (hasEntity() && mediaType == MediaType.APPLICATION_JSON_TYPE) {
                    readEntity(ErrorMessage::class.java).let {
                        BeaconNodeException(it.status, it.message, it.stacktraces)
                    }
                } else {
                    BeaconNodeException(
                        status = exception.response.status,
                        message = exception.response.statusInfo.reasonPhrase
                    )
                }
            }
        }
    }
}
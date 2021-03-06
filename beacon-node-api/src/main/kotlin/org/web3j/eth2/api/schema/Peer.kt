/*
 * Copyright 2020 Web3 Labs Ltd.
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
package org.web3j.eth2.api.schema

import com.fasterxml.jackson.annotation.JsonProperty

data class Peer(
    @JsonProperty("peer_id")
    val id: PeerId,
    val enr: ENR? = null,
    val address: Multiaddr,
    val state: State,
    val direction: Direction
) {
    enum class State {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        DISCONNECTING;

        override fun toString() = name.toLowerCase()

        companion object {
            @JvmStatic
            fun fromString(value: String) = valueOf(value.toUpperCase())
        }
    }

    enum class Direction {
        INBOUND,
        OUTBOUND;

        override fun toString() = name.toLowerCase()

        companion object {
            @JvmStatic
            fun fromString(value: String) = valueOf(value.toUpperCase())
        }
    }
}

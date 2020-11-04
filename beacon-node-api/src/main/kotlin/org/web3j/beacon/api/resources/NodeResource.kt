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
package org.web3j.beacon.api.resources

import org.web3j.beacon.client.infrastructure.ApiClient
import org.web3j.beacon.client.infrastructure.ClientError
import org.web3j.beacon.client.infrastructure.ClientException
import org.web3j.beacon.client.infrastructure.RequestConfig
import org.web3j.beacon.client.infrastructure.RequestMethod
import org.web3j.beacon.client.infrastructure.ResponseType
import org.web3j.beacon.client.infrastructure.ServerError
import org.web3j.beacon.client.infrastructure.ServerException
import org.web3j.beacon.client.infrastructure.Success
import org.web3j.beacon.client.models.GetNetworkIdentityResponse
import org.web3j.beacon.client.models.GetPeerResponse
import org.web3j.beacon.client.models.GetPeersResponse
import org.web3j.beacon.client.models.GetSyncingStatusResponse
import org.web3j.beacon.client.models.GetVersionResponse

class NodeResource(basePath: String = "{server_url}") : ApiClient(basePath) {

    /**
     * Get health check
     * Returns node health status in http status codes. Useful for load balancers.
     * @return void
     */
    fun getHealth() {

        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/node/health"
        )
        val response = request<Any?>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Get node network identity
     * Retrieves data about the node&#x27;s network presence
     * @return GetNetworkIdentityResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getNetworkIdentity(): GetNetworkIdentityResponse {

        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/node/identity"
        )
        val response = request<GetNetworkIdentityResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetNetworkIdentityResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Get version string of the running beacon node.
     * Requests that the beacon node identify information about its implementation in a format similar to a  [HTTP User-Agent](https://tools.ietf.org/html/rfc7231#section-5.5.3) field.
     * @return GetVersionResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getNodeVersion(): GetVersionResponse {

        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/node/version"
        )
        val response = request<GetVersionResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetVersionResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Get peer
     * Retrieves data about the given peer
     * @param peerId
     * @return GetPeerResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getPeer(peerId: String): GetPeerResponse {

        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/node/peers/{peer_id}".replace("{" + "peer_id" + "}", "$peerId")
        )
        val response = request<GetPeerResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetPeerResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Get node network peers
     * Retrieves data about the node&#x27;s network peers
     * @return GetPeersResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getPeers(): GetPeersResponse {

        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/node/peers"
        )
        val response = request<GetPeersResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetPeersResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Get node syncing status
     * Requests the beacon node to describe if it&#x27;s currently syncing or not, and if it is, what block it is up to.
     * @return GetSyncingStatusResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getSyncingStatus(): GetSyncingStatusResponse {

        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/node/syncing"
        )
        val response = request<GetSyncingStatusResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetSyncingStatusResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }
}
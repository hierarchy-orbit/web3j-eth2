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
import org.web3j.beacon.client.infrastructure.MultiValueMap
import org.web3j.beacon.client.infrastructure.RequestConfig
import org.web3j.beacon.client.infrastructure.RequestMethod
import org.web3j.beacon.client.infrastructure.ResponseType
import org.web3j.beacon.client.infrastructure.ServerError
import org.web3j.beacon.client.infrastructure.ServerException
import org.web3j.beacon.client.infrastructure.Success
import org.web3j.beacon.client.models.Body5
import org.web3j.beacon.client.models.Body6
import org.web3j.beacon.client.models.GetAggregatedAttestationResponse
import org.web3j.beacon.client.models.GetAttesterDutiesResponse
import org.web3j.beacon.client.models.GetProposerDutiesResponse
import org.web3j.beacon.client.models.ProduceAttestationDataResponse
import org.web3j.beacon.client.models.ProduceBlockResponse

class ValidatorResource(basePath: String = "{server_url}") : ApiClient(basePath) {

    /**
     * Get aggregated attestation
     * Aggregates all attestations matching given attestation data root and slot
     * @param attestationDataRoot HashTreeRoot of AttestationData that validator want&#x27;s aggregated
     * @param slot
     * @return GetAggregatedAttestationResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getAggregatedAttestation(attestationDataRoot: String, slot: String): GetAggregatedAttestationResponse {
        val localVariableQuery: MultiValueMap = mapOf("attestation_data_root" to listOf("$attestationDataRoot"), "slot" to listOf("$slot"))
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/validator/aggregate_attestation", query = localVariableQuery
        )
        val response = request<GetAggregatedAttestationResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetAggregatedAttestationResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Get attester duties
     * Requests the beacon node to provide a set of attestation duties, which should be performed by validators, for a particular epoch. Duties should only need to be checked once per epoch, however a chain reorganization (of &gt; MIN_SEED_LOOKAHEAD epochs) could occur, resulting in a change of duties. For full safety, you should monitor chain reorganizations events.
     * @param body An array of the validator indices for which to obtain the duties.
     * @param epoch Should only be allowed 1 epoch ahead
     * @return GetAttesterDutiesResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getAttesterDuties(body: Array<String>, epoch: String): GetAttesterDutiesResponse {
        val localVariableBody: Any? = body

        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/eth/v1/validator/duties/attester/{epoch}".replace("{" + "epoch" + "}", "$epoch")
        )
        val response = request<GetAttesterDutiesResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetAttesterDutiesResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Get block proposers duties
     * Request beacon node to provide all validators that are scheduled to propose a block in the given epoch
     * @param epoch
     * @return GetProposerDutiesResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun getProposerDuties(epoch: String): GetProposerDutiesResponse {

        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/validator/duties/proposer/{epoch}".replace("{" + "epoch" + "}", "$epoch")
        )
        val response = request<GetProposerDutiesResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GetProposerDutiesResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Signal beacon node to prepare for a committee subnet
     * After beacon node receives this request, search using discv5 for peers related to this subnet and replace current peers with those ones if necessary If validator &#x60;is_aggregator&#x60;, beacon node must: - announce subnet topic subscription on gossipsub - aggregate attestations received on that subnet
     * @param body (optional)
     * @return void
     */
    fun prepareBeaconCommitteeSubnet(body: Array<Body6>? = null) {
        val localVariableBody: Any? = body

        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/eth/v1/validator/beacon_committee_subscriptions"
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
     * Produce an attestation data
     * Requests that the beacon node produce an AttestationData.
     * @param slot The slot for which an attestation data should be created.
     * @param committeeIndex The committee index for which an attestation data should be created.
     * @return ProduceAttestationDataResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun produceAttestationData(slot: String, committeeIndex: String): ProduceAttestationDataResponse {
        val localVariableQuery: MultiValueMap = mapOf("slot" to listOf("$slot"), "committee_index" to listOf("$committeeIndex"))
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/validator/attestation_data", query = localVariableQuery
        )
        val response = request<ProduceAttestationDataResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ProduceAttestationDataResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Produce a new block, without signature.
     * Requests a beacon node to produce a valid block, which can then be signed by a validator.
     * @param slot The slot for which the block should be proposed.
     * @param randaoReveal The validator&#x27;s randao reveal value.
     * @param graffiti Arbitrary data validator wants to include in block. (optional)
     * @return ProduceBlockResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun produceBlock(slot: String, randaoReveal: String, graffiti: String? = null): ProduceBlockResponse {
        val localVariableQuery: MultiValueMap = mapOf("randao_reveal" to listOf("$randaoReveal"), "graffiti" to listOf("$graffiti"))
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/eth/v1/validator/blocks/{slot}".replace("{" + "slot" + "}", "$slot"), query = localVariableQuery
        )
        val response = request<ProduceBlockResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ProduceBlockResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String
                    ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message
                    ?: "Server error")
        }
    }

    /**
     * Publish multiple aggregate and proofs
     * Verifies given aggregate and proofs and publishes them on appropriate gossipsub topic.
     * @param body (optional)
     * @return void
     */
    fun publishAggregateAndProofs(body: Array<Body5>? = null) {
        val localVariableBody: Any? = body

        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/eth/v1/validator/aggregate_and_proofs"
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
}
/**
 * Eth2 Beacon Node API
 * API specification for the beacon node, which enables users to query and participate in Ethereum 2.0 phase 0 beacon chain.
 *
 * OpenAPI spec version: v0.12.2
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package org.web3j.eth2.client.models


/**
 * Group of validators assigned to attest at specific slot and that have the same committee index (shard in phase 1)
 * @param index
 * @param slot
 * @param validators List of validator indices assigned to this committee
 */
data class GetEpochCommitteesResponseData(

        val index: AllOfGetEpochCommitteesResponseDataIndex? = null,
        val slot: kotlin.String? = null,
        /* List of validator indices assigned to this committee */
        val validators: kotlin.Array<kotlin.String>? = null
) {
}
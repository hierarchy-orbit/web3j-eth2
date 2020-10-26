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
 * The [`AttesterSlashing`](https://github.com/ethereum/eth2.0-specs/blob/v0.12.2/specs/core/0_beacon-chain.md#attesterslashing) object from the Eth2.0 spec.
 * @param attestation1
 * @param attestation2
 */
data class Body2(

        val attestation1: Ethv1beaconpoolattesterSlashingsAttestation1? = null,
        val attestation2: Ethv1beaconpoolattesterSlashingsAttestation1? = null
) {
}
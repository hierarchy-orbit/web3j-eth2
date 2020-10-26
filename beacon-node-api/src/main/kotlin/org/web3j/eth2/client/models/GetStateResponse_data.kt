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
 * The [`BeaconState`](https://github.com/ethereum/eth2.0-specs/blob/v0.12.2/specs/phase0/beacon-chain.md#beaconblock) object from the Eth2.0 spec.
 * @param genesisTime
 * @param genesisValidatorsRoot
 * @param slot
 * @param fork
 * @param latestBlockHeader The [`BeaconBlockHeader`](https://github.com/ethereum/eth2.0-specs/blob/v0.12.2/specs/phase0/beacon-chain.md#beaconblockheader) object from the Eth2.0 spec.
 * @param blockRoots
 * @param stateRoots
 * @param historicalRoots
 * @param eth1Data
 * @param eth1DataVotes
 * @param eth1DepositIndex
 * @param validators
 * @param balances Validator balances in gwei
 * @param randaoMixes
 * @param slashings Per-epoch sums of slashed effective balances
 * @param previousEpochAttestations
 * @param currentEpochAttestations
 * @param justificationBits Bit set for every recent justified epoch
 * @param previousJustifiedCheckpoint
 * @param currentJustifiedCheckpoint
 * @param finalizedCheckpoint
 */
data class GetStateResponseData(

        val genesisTime: kotlin.String? = null,
        val genesisValidatorsRoot: kotlin.String? = null,
        val slot: kotlin.String? = null,
        val fork: BeaconStateFork? = null,
        /* The [`BeaconBlockHeader`](https://github.com/ethereum/eth2.0-specs/blob/v0.12.2/specs/phase0/beacon-chain.md#beaconblockheader) object from the Eth2.0 spec. */
        val latestBlockHeader: AllOfGetStateResponseDataLatestBlockHeader? = null,
        val blockRoots: kotlin.Array<AllOfGetStateResponseDataBlockRootsItems>? = null,
        val stateRoots: kotlin.Array<AllOfGetStateResponseDataStateRootsItems>? = null,
        val historicalRoots: kotlin.Array<AllOfGetStateResponseDataHistoricalRootsItems>? = null,
        val eth1Data: BeaconStateEth1Data? = null,
        val eth1DataVotes: kotlin.Array<AllOfGetStateResponseDataEth1DataVotesItems>? = null,
        val eth1DepositIndex: kotlin.String? = null,
        val validators: kotlin.Array<AllOfGetStateResponseDataValidatorsItems>? = null,
        /* Validator balances in gwei */
        val balances: kotlin.Array<AllOfGetStateResponseDataBalancesItems>? = null,
        val randaoMixes: kotlin.Array<AllOfGetStateResponseDataRandaoMixesItems>? = null,
        /* Per-epoch sums of slashed effective balances */
        val slashings: kotlin.Array<AllOfGetStateResponseDataSlashingsItems>? = null,
        val previousEpochAttestations: kotlin.Array<AllOfGetStateResponseDataPreviousEpochAttestationsItems>? = null,
        val currentEpochAttestations: kotlin.Array<AllOfGetStateResponseDataCurrentEpochAttestationsItems>? = null,
        /* Bit set for every recent justified epoch */
        val justificationBits: kotlin.String? = null,
        val previousJustifiedCheckpoint: Ethv1beaconpoolattestationsDataSource? = null,
        val currentJustifiedCheckpoint: Ethv1beaconpoolattestationsDataSource? = null,
        val finalizedCheckpoint: Ethv1beaconpoolattestationsDataSource? = null
) {
}
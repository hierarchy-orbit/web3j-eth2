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
package org.web3j.eth2.api.client

import assertk.assertThat
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.web3j.eth2.api.schema.AggregateAndProof
import org.web3j.eth2.api.schema.Attestation
import org.web3j.eth2.api.schema.AttestationData
import org.web3j.eth2.api.schema.Checkpoint
import org.web3j.eth2.api.schema.CommitteeSubnetSubscription
import org.web3j.eth2.api.schema.SignedAggregateAndProof
import javax.ws.rs.core.Response

@DisplayName("/eth/v1/validator")
class ValidatorResourceTest : BeaconNodeApiTest() {

    @Test
    @DisplayName("GET /attestation_data")
    fun `get attestation data`() {
        val exception = assertThrows<BeaconNodeException> {
            client.validator.produceAttestationData("0", "0")
        }
        assertThat(exception.status).isEqualTo(Response.Status.SERVICE_UNAVAILABLE.statusCode)
    }

    @Test
    @DisplayName("GET /aggregate_attestation")
    fun `get aggregated attestation`() {
        val exception = assertThrows<BeaconNodeException> {
            client.validator.getAggregatedAttestation("0x01", "0")
        }
        assertThat(exception.status).isEqualTo(Response.Status.SERVICE_UNAVAILABLE.statusCode)
    }

    @Test
    @DisplayName("POST /beacon_committee_subscriptions")
    fun `subscribe to a committee subnet`() {
        client.validator.subscribe(
            CommitteeSubnetSubscription(
                committeeIndex = "0",
                committeesAtSlot = "0",
                isAggregator = true,
                slot = "0"
            )
        )
    }

    @Test
    @DisplayName("POST /aggregate_and_proofs")
    fun `publish multiple aggregate and proofs`() {
        client.validator.publishAggregateAndProofs(
            SignedAggregateAndProof(
                message = AggregateAndProof(
                    aggregatorIndex = "0",
                    aggregate = Attestation(
                        aggregationBits = "0x01",
                        signature = SIGNATURE,
                        data = AttestationData(
                            slot = "0",
                            index = "0",
                            beaconBlockRoot = "0x01",
                            source = Checkpoint(
                                epoch = "0",
                                root = ROOT
                            ),
                            target = Checkpoint(
                                epoch = "0",
                                root = ROOT
                            )
                        )
                    ),
                    selectionProof = SIGNATURE
                ),
                signature = SIGNATURE
            )
        )
    }

    @Nested
    @DisplayName("/duties")
    inner class DutiesResourceTest {

        @Test
        @DisplayName("POST /attester/{epoch}")
        fun `get attester duties`() {
            val duties = client.validator.duties.attester.atEpoch("0")
                    .findByValidatorIndices("0")

            assertThat(duties.data).isEmpty()
        }

        @Test
        @DisplayName("GET /proposer/{epoch}")
        fun `get block proposers duties`() {
            val duties = client.validator.duties.proposer
                .atEpoch("0")
                .findAll()

            assertThat(duties.data).isEmpty()
        }
    }

    @Nested
    @DisplayName("/blocks")
    inner class BlocksResourceTest
}

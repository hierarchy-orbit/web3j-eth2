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

/**
 * Group of validators assigned to attest at specific slot and that have the same committee index (shard in phase 1)
 * @param index
 * @param slot
 * @param validators List of validator indices assigned to this committee
 */
data class GetEpochCommitteesResponseData(

    val index: AllOfGetEpochCommitteesResponseDataIndex? = null,
    val slot: String? = null,
        /* List of validator indices assigned to this committee */
    val validators: Array<String>? = null
)
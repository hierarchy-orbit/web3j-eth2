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
package org.web3j.eth2.api.beacon.pool

import org.web3j.eth2.api.schema.Body4
import org.web3j.eth2.api.schema.GetPoolVoluntaryExitsResponse
import javax.ws.rs.GET
import javax.ws.rs.POST

interface VoluntaryExitsResource {

    /**
     * Get [org.web3j.eth2.api.schema.SignedVoluntaryExit] from operations pool.
     *
     * Retrieves voluntary exits known by the node but not necessarily incorporated into any block.
     *
     * @throws javax.ws.rs.InternalServerErrorException Beacon node internal error.
     */
    @GET
    fun findAll(): GetPoolVoluntaryExitsResponse

    /**
     * Submits [org.web3j.eth2.api.schema.SignedVoluntaryExit] object to node's pool
     * and if passes validation node MUST broadcast it to network.
     *
     * @throws javax.ws.rs.BadRequestException Invalid voluntary exit.
     * @throws javax.ws.rs.InternalServerErrorException Beacon node internal error.
     */
    @POST
    fun submit(body: Body4)
}
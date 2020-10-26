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
 *
 * @param code Either specific error code in case of invalid request or http status code
 * @param message Message describing error
 * @param stacktraces Optional stacktraces, sent when node is in debug mode
 */
data class InlineResponse500(

        /* Either specific error code in case of invalid request or http status code */
        val code: java.math.BigDecimal? = null,
        /* Message describing error */
        val message: kotlin.String? = null,
        /* Optional stacktraces, sent when node is in debug mode */
        val stacktraces: kotlin.Array<kotlin.String>? = null
) {
}
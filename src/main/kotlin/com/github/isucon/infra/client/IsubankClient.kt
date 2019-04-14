package com.github.isucon.infra.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestOperations

interface IsuBankResponse {
    fun setStatus(code: Int)
}

class IsuBankBasicResponse(var code: Int) : IsuBankResponse {
    override fun setStatus(code: Int) {
        this.code = code
    }

    fun success(): Boolean {
        return code == 200
    }

}

class IsubankReserveResponse(val basic: IsuBankBasicResponse, var reserveId: Int) {
}

class IsubankClient(
        val endPoint: String,
        val appId: String,
        val restOperations: RestOperations = RestTemplateBuilder().build()
) {

    fun check(bankId: String, price: Int = 0): Boolean {
        val m = mapOf("bank_id" to bankId, "price" to price)
        val res = request("/check", m, IsuBankBasicResponse(404))
        return res.success()
    }

    fun <T : IsuBankResponse> request(path: String, body: Map<String, Any>, defaultResponse: T): T {
        val b = jacksonObjectMapper().writeValueAsString(body)
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val entity = HttpEntity(b, headers)

        val url = "%s%s".format(endPoint, path)
        val r = restOperations.postForObject("", entity, defaultResponse.javaClass)

        return r ?: defaultResponse
    }
}
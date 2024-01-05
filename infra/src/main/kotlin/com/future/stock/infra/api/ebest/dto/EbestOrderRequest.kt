package com.future.stock.infra.api.ebest.dto

import com.fasterxml.jackson.annotation.JsonProperty

class EbestOrderRequest(
  val cSPAT00601InBlock1: CSPAT00601InBlock1,
) {
  class CSPAT00601InBlock1(
    @JsonProperty("IsuNo")
    val isuNo: String,
    @JsonProperty("ordQty")
    val ordQty: Int,
    @JsonProperty("OrdPrc")
    val ordPrc: Double,
    @JsonProperty("BnsTpCode")
    val bnsTpCode: String,
    @JsonProperty("OrdprcPtnCode")
    val ordprcPtnCode: String,
    @JsonProperty("MgntrnCode")
    val mgntrnCode: String,
    @JsonProperty("LoanDt")
    val loanDt: String,
    @JsonProperty("OrdCndiTpCode")
    val ordCndiTpCode: String,
  )
}
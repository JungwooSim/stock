package com.stock.infrastructure.api.ebest.dto

import com.fasterxml.jackson.annotation.JsonProperty

class EbestOrderResponse(
  @JsonProperty("rsp_cd")
  val rspCd: String,

  @JsonProperty("rsp_msg")
  val rspMsg: String,

  @JsonProperty("CSPAT00601OutBlock1")
  val cSPAT00601OutBlock1: CSPAT00601OutBlock1,

  @JsonProperty("CSPAT00601OutBlock2")
  val cSPAT00601OutBlock2: CSPAT00601OutBlock2,
) {
  class CSPAT00601OutBlock1 {
    @JsonProperty("BnsTpCode")
    var bnsTpCode: String? = null

    @JsonProperty("InptPwd")
    var inptPwd: String? = null

    @JsonProperty("CommdaCode")
    var commdaCode: String? = null

    @JsonProperty("StslAbleYn")
    var stslAbleYn: String? = null

    @JsonProperty("MbrNo")
    var mbrNo: String? = null

    @JsonProperty("OrdSeqNo")
    var ordSeqNo: Int = 0

    @JsonProperty("StslOrdprcTpCode")
    var stslOrdprcTpCode: String? = null

    @JsonProperty("PtflNo")
    var ptflNo: Int = 0

    @JsonProperty("GrpId")
    var grpId: String? = null

    @JsonProperty("MgntrnCode")
    var mgntrnCode: String? = null

    @JsonProperty("OrdPrc")
    var ordPrc: String? = null

    @JsonProperty("TrchNo")
    var trchNo: Int = 0

    @JsonProperty("PrgmOrdprcPtnCode")
    var prgmOrdprcPtnCode: String? = null

    @JsonProperty("BskNo")
    var bskNo: Int = 0

    @JsonProperty("StrtgCode")
    var strtgCode: String? = null

    @JsonProperty("OrdQty")
    var ordQty: Int = 0

    @JsonProperty("RecCnt")
    var recCnt: Int = 0

    @JsonProperty("OrdprcPtnCode")
    var ordprcPtnCode: String? = null

    @JsonProperty("IsuNo")
    var isuNo: String? = null

    @JsonProperty("ItemNo")
    var itemNo: Int = 0

    @JsonProperty("OpDrtnNo")
    var opDrtnNo: String? = null

    @JsonProperty("AcntNo")
    var acntNo: String? = null

    @JsonProperty("LoanDt")
    var loanDt: String? = null

    @JsonProperty("OrdCndiTpCode")
    var ordCndiTpCode: String? = null

    @JsonProperty("CvrgTpCode")
    var cvrgTpCode: String? = null

    @JsonProperty("LpYn")
    var lpYn: String? = null
  }

  class CSPAT00601OutBlock2 {
    @JsonProperty("OrdAmt")
    var ordAmt: Int = 0

    @JsonProperty("CvrgSeqno")
    var cvrgSeqno: Int = 0

    @JsonProperty("RuseOrdQty")
    var ruseOrdQty: Int = 0

    @JsonProperty("MgempNo")
    var mgempNo: String? = null

    @JsonProperty("SpareOrdNo")
    var spareOrdNo: Int = 0

    @JsonProperty("OrdNo")
    var ordNo: Int = 0

    @JsonProperty("SpotOrdQty")
    var spotOrdQty: Int = 0

    @JsonProperty("SubstOrdAmt")
    var substOrdAmt: Int = 0

    @JsonProperty("OrdMktCode")
    var ordMktCode: String? = null

    @JsonProperty("IsuNm")
    var isuNm: String? = null

    @JsonProperty("ShtnIsuNo")
    var shtnIsuNo: String? = null

    @JsonProperty("RuseOrdAmt")
    var ruseOrdAmt: Int = 0

    @JsonProperty("RecCnt")
    var recCnt: Int = 0

    @JsonProperty("OrdTime")
    var ordTime: String? = null

    @JsonProperty("MnyOrdAmt")
    var mnyOrdAmt: Int = 0

    @JsonProperty("AcntNm")
    var acntNm: String? = null

    @JsonProperty("RsvOrdNo")
    var rsvOrdNo: Int = 0

    @JsonProperty("OrdPtnCode")
    var ordPtnCode: String? = null
  }
}


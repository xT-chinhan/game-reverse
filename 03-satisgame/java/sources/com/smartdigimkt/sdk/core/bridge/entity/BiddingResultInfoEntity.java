package com.smartdigimkt.sdk.core.bridge.entity;

import com.anythink.core.common.f.h;
import com.anythink.core.common.f.i;
import com.anythink.core.common.k;
import com.anythink.core.d.b.e;
import com.smartdigimkt.d3.c;

/* JADX INFO: loaded from: classes3.dex */
public class BiddingResultInfoEntity extends BaseInfoEntity {

    @DataField("ad_source_id")
    private String adSourceId;

    @DataField("a_r")
    private double adxRecoverRate;

    @DataField("cny_ecpm_api")
    private double cnyEcpmApi;

    @DataField("cur")
    private String curreny;

    @DataField("cur_rate")
    private double currenyRate;

    @DataField("burl")
    private String displayNoticeUrl;

    @DataField("burl_win")
    private String displayWinNoticeUrl;

    @DataField("ecpm_api")
    private double ecpmApi;

    @DataField(k.aU)
    private String ecpmEncInfo;

    @DataField("e_c_id")
    private int ecpmEncPvtKeyServerId;

    @DataField("err_code")
    private int errorCode;

    @DataField("err_msg")
    private String errorMsg;

    @DataField("expire")
    private long expireTime;

    @DataField("is_send_winurl")
    private boolean hasSendWinOrLossUrl;

    @DataField("is_success")
    private boolean isSuccess;

    @DataField("lurl")
    private String loseNoticeUrl;

    @DataField("nw_firm_id")
    private int networkFirmId;

    @DataField("unit_id")
    private String networkUnitId;

    @DataField(i.a.g)
    private String offerData;

    @DataField("origin_price")
    private double originPrice;

    @DataField("origin_request_id")
    private String originRequestId;

    @DataField("out_data_time")
    private long outDateTime;

    @DataField("deal_id")
    private String pmpOrderId;

    @DataField("deal_pri")
    private int pmpPriority;

    @DataField("deal_type_int")
    private int pmpType;

    @DataField("deal_type")
    private String pmpTypeString;

    @DataField(k.U)
    private String precision;

    @DataField(e.a.h)
    private Double price;

    @DataField("request_id")
    private String requestId;

    @DataField(h.b.d)
    private String requestUrl;

    @DataField("cny_e_c")
    private String rmbEcpmEncInfo;

    @DataField("cny_price")
    private double rmbPrice;

    @DataField(k.aq)
    private double sortPrice;

    @DataField(i.a.c)
    private String token;

    @DataField("tp_bid_id")
    private String tpBidId;

    @DataField("bd_type")
    private int useType;

    @DataField("nurl")
    private String winNoticeUrl;

    @DataField("x_c")
    private String x_c;

    public c converToBiddingResult() {
        c cVar = new c(this.isSuccess, this.sortPrice, this.price.doubleValue(), this.tpBidId, this.winNoticeUrl, this.loseNoticeUrl, this.displayNoticeUrl, this.errorMsg);
        cVar.e = this.token;
        cVar.g = this.winNoticeUrl;
        cVar.h = this.loseNoticeUrl;
        cVar.f = this.errorMsg;
        cVar.n = this.curreny;
        cVar.o = this.networkUnitId;
        cVar.p = this.networkFirmId;
        cVar.m = this.errorCode;
        cVar.q = this.expireTime;
        cVar.r = this.outDateTime;
        cVar.y = this.offerData;
        cVar.s = this.tpBidId;
        cVar.z = this.displayWinNoticeUrl;
        cVar.A = this.adSourceId;
        cVar.B = this.currenyRate;
        cVar.C = this.ecpmApi;
        cVar.D = this.cnyEcpmApi;
        cVar.E = this.precision;
        cVar.t = this.requestUrl;
        cVar.k = this.useType;
        cVar.b = this.originPrice;
        cVar.l = this.rmbPrice;
        cVar.G = this.adxRecoverRate;
        cVar.F = this.requestId;
        cVar.M = this.pmpTypeString;
        cVar.N = this.pmpType;
        cVar.O = this.pmpOrderId;
        cVar.P = this.pmpPriority;
        cVar.j = this.originRequestId;
        cVar.Q = this.x_c;
        cVar.I = this.ecpmEncInfo;
        cVar.K = this.rmbEcpmEncInfo;
        cVar.J = this.ecpmEncPvtKeyServerId;
        return cVar;
    }

    public String getToken() {
        return this.token;
    }
}

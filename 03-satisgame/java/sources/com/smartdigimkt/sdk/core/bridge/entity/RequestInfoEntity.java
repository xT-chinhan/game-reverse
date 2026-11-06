package com.smartdigimkt.sdk.core.bridge.entity;

import com.anythink.core.common.f.a;
import com.anythink.core.common.f.i;
import com.anythink.core.common.l.f;

/* JADX INFO: loaded from: classes3.dex */
public class RequestInfoEntity extends BaseInfoEntity {

    @DataField(i.a.d)
    private String adsourceId;

    @DataField(i.a.c)
    private String bidId;

    @DataField("bid_result_out_date_time")
    private long bidResultOutDateTime;

    @DataField(f.bB)
    private int channelFrom;

    @DataField(a.C0017a.d)
    private int format;

    @DataField("group_id")
    private int groupId;

    @DataField("max_exclude_id_size")
    private int maxExcludeIdSize;

    @DataField("max_install_id_size")
    private int maxInstallIdSize;

    @DataField("network_firm_id")
    private int networkFirmId;

    @DataField("network_name")
    private String networkName;

    @DataField("origin_request_id")
    private String originRequestId;

    @DataField("placement_id")
    private String placementId;

    @DataField("request_id")
    private String requestId;

    @DataField("request_url")
    private String requestUrl;

    @DataField("tp_bid_id")
    private String tpBidId;

    @DataField("traffic_group_id")
    private int trafficGroupId;

    @DataField("unit_group_content")
    private String unitGroupContent;

    @DataField("x_c")
    private String x_c;

    public com.smartdigimkt.a3.a convertToBaseAdRequestInfo() {
        com.smartdigimkt.a3.a aVar = new com.smartdigimkt.a3.a();
        aVar.b = this.placementId;
        aVar.c = this.format;
        aVar.d = this.trafficGroupId;
        aVar.e = this.groupId;
        aVar.f = this.adsourceId;
        aVar.g = this.requestId;
        aVar.h = this.originRequestId;
        aVar.i = this.x_c;
        aVar.j = this.bidId;
        aVar.k = this.networkFirmId;
        aVar.l = this.tpBidId;
        aVar.m = this.channelFrom;
        aVar.n = this.unitGroupContent;
        aVar.o = this.bidResultOutDateTime;
        aVar.p = this.requestUrl;
        aVar.q = this.maxInstallIdSize;
        aVar.r = this.maxExcludeIdSize;
        return aVar;
    }

    public int getNetworkFirmId() {
        return this.networkFirmId;
    }
}

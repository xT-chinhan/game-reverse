package com.bytedance.sdk.openadsdk.mediation.manager;

import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, TTAdConstant.IMAGE_LIST_SIZE_CODE, TTAdConstant.IMAGE_CODE})
public class MediationAdEcpmInfo {
    private String aj;
    private String c;
    private String fw;
    private String g;
    private String hn;
    private String ho;
    private String hw;
    private String k;
    private String m;
    private String nt;
    private String pr;
    private int uc;
    private String vk;
    private String w;
    private String x;
    private Map<String, String> yb;
    private String zo;

    public MediationAdEcpmInfo() {
        this.yb = new HashMap();
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map, String str15) {
        HashMap map2 = new HashMap();
        this.yb = map2;
        this.pr = str;
        this.hw = str2;
        this.hn = str3;
        this.x = str4;
        this.c = str5;
        this.uc = i;
        this.fw = str6;
        this.zo = str7;
        this.aj = str8;
        this.vk = str9;
        this.w = str10;
        this.k = str11;
        this.m = str12;
        this.g = str13;
        this.ho = str14;
        this.nt = str15;
        if (map != null) {
            this.yb = map;
        } else {
            map2.clear();
        }
    }

    public Map<String, String> getCustomData() {
        return this.yb;
    }

    public String getSdkName() {
        return this.pr;
    }

    public String getCustomSdkName() {
        return this.hw;
    }

    public String getSlotId() {
        return this.hn;
    }

    public String getLevelTag() {
        return this.x;
    }

    public String getEcpm() {
        return this.c;
    }

    public int getReqBiddingType() {
        return this.uc;
    }

    public String getErrorMsg() {
        return this.fw;
    }

    public String getRequestId() {
        return this.zo;
    }

    public String getRitType() {
        return this.aj;
    }

    public String getSegmentId() {
        return this.w;
    }

    public String getChannel() {
        return this.k;
    }

    public String getSubChannel() {
        return this.m;
    }

    public String getAbTestId() {
        return this.g;
    }

    public String getScenarioId() {
        return this.ho;
    }

    public String getSubRitType() {
        return this.vk;
    }

    public String getDiscount() {
        return this.nt;
    }
}

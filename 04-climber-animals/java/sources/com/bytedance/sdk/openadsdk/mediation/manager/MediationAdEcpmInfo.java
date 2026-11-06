package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationAdEcpmInfo {
    private String ab;
    private String ah;
    private Map<String, String> ao;
    private int c;
    private String ch;
    private String d;
    private String hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f4006ms;
    private String ny;
    private String sl;
    private String u;
    private String ub;
    private String x;
    private String xr;
    private String zb;

    public MediationAdEcpmInfo() {
        this.ao = new HashMap();
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.ao = map2;
        this.f4006ms = str;
        this.xr = str2;
        this.ah = str3;
        this.d = str4;
        this.ka = str5;
        this.c = i;
        this.ab = str6;
        this.x = str7;
        this.ny = str8;
        this.ch = str9;
        this.hi = str10;
        this.sl = str11;
        this.zb = str12;
        this.u = str13;
        this.ub = str14;
        if (map != null) {
            this.ao = map;
        } else {
            map2.clear();
        }
    }

    public Map<String, String> getCustomData() {
        return this.ao;
    }

    public String getSdkName() {
        return this.f4006ms;
    }

    public String getCustomSdkName() {
        return this.xr;
    }

    public String getSlotId() {
        return this.ah;
    }

    public String getLevelTag() {
        return this.d;
    }

    public String getEcpm() {
        return this.ka;
    }

    public int getReqBiddingType() {
        return this.c;
    }

    public String getErrorMsg() {
        return this.ab;
    }

    public String getRequestId() {
        return this.x;
    }

    public String getRitType() {
        return this.ny;
    }

    public String getSegmentId() {
        return this.hi;
    }

    public String getChannel() {
        return this.sl;
    }

    public String getSubChannel() {
        return this.zb;
    }

    public String getAbTestId() {
        return this.u;
    }

    public String getScenarioId() {
        return this.ub;
    }

    public String getSubRitType() {
        return this.ch;
    }
}

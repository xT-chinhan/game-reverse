package com.bytedance.sdk.openadsdk.mediation.manager;

import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_INTERVAL})
public class MediationAdEcpmInfo {
    private String cp;
    private String cy;
    private String d;
    private String fs;
    private Map<String, String> hd;
    private String k;
    private String l;
    private String n;
    private String oa;
    private String q;
    private String qg;
    private String rv;
    private String s;
    private String sz;
    private String tj;
    private int w;
    private String x;

    public MediationAdEcpmInfo() {
        this.hd = new HashMap();
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map, String str15) {
        HashMap map2 = new HashMap();
        this.hd = map2;
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = str4;
        this.l = str5;
        this.w = i;
        this.x = str6;
        this.fs = str7;
        this.rv = str8;
        this.tj = str9;
        this.cp = str10;
        this.d = str11;
        this.oa = str12;
        this.sz = str13;
        this.k = str14;
        this.cy = str15;
        if (map != null) {
            this.hd = map;
        } else {
            map2.clear();
        }
    }

    public Map<String, String> getCustomData() {
        return this.hd;
    }

    public String getSdkName() {
        return this.n;
    }

    public String getCustomSdkName() {
        return this.qg;
    }

    public String getSlotId() {
        return this.s;
    }

    public String getLevelTag() {
        return this.q;
    }

    public String getEcpm() {
        return this.l;
    }

    public int getReqBiddingType() {
        return this.w;
    }

    public String getErrorMsg() {
        return this.x;
    }

    public String getRequestId() {
        return this.fs;
    }

    public String getRitType() {
        return this.rv;
    }

    public String getSegmentId() {
        return this.cp;
    }

    public String getChannel() {
        return this.d;
    }

    public String getSubChannel() {
        return this.oa;
    }

    public String getAbTestId() {
        return this.sz;
    }

    public String getScenarioId() {
        return this.k;
    }

    public String getSubRitType() {
        return this.tj;
    }

    public String getDiscount() {
        return this.cy;
    }
}

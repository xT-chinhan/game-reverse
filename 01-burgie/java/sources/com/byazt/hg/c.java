package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public int c;
    public String fw;
    public String hn;
    public String hw;
    public String pr;
    public int uc;
    public int x;

    public String pr() {
        return this.fw;
    }

    public void pr(String str) {
        this.fw = str;
    }

    public String hw() {
        return this.pr;
    }

    public void hw(String str) {
        this.pr = str;
    }

    public String hn() {
        return this.hw;
    }

    public void hn(String str) {
        this.hw = str;
    }

    public String x() {
        return this.hn;
    }

    public void x(String str) {
        this.hn = str;
    }

    public int c() {
        return this.x;
    }

    public void pr(int i) {
        this.x = i;
    }

    public int uc() {
        return this.c;
    }

    public void hw(int i) {
        this.c = i;
    }

    public int fw() {
        return this.uc;
    }

    public void hn(int i) {
        this.uc = i;
    }

    public JSONObject zo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, hn());
            jSONObject.put("app_size", fw());
            jSONObject.put("comment_num", uc());
            jSONObject.put("download_url", hw());
            jSONObject.put("package_name", x());
            jSONObject.put("score", c());
        } catch (Exception e) {
            com.byazt.ca.ho.pr(e.toString());
        }
        return jSONObject;
    }
}

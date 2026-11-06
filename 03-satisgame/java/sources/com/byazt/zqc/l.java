package com.byazt.zqc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.api.loader.ApiSpUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 18})
public class l {
    public static l n;
    public boolean qg = false;
    public long s = 180000;
    public long q = 43200000;
    public long l = 3;
    public long w = 30;
    public long x = 15;

    private l() {
    }

    public static l n() {
        if (n == null) {
            synchronized (l.class) {
                if (n == null) {
                    n = new l();
                }
            }
        }
        return n;
    }

    public synchronized void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.qg = jSONObject.optBoolean("sensorenable", false);
                this.s = jSONObject.optLong(ApiSpUtils.SP_INTERVAL, 180000L);
                this.q = jSONObject.optLong("expireduation", 43200000L);
                this.l = jSONObject.optLong("showinterval", 3L);
                this.w = jSONObject.optLong("azimuth_unit", 30L);
                this.x = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }

    public boolean qg() {
        return this.qg;
    }

    public long s() {
        return this.q;
    }

    public long q() {
        return this.s;
    }

    public long l() {
        return this.l;
    }

    public long w() {
        return this.w;
    }

    public long x() {
        return this.x;
    }
}

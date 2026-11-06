package com.byazt.wqv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 399, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static c pr;
    public boolean hw = false;
    public long hn = 180000;
    public long x = 43200000;
    public long c = 3;
    public long uc = 30;
    public long fw = 15;

    private c() {
    }

    public static c pr() {
        if (pr == null) {
            synchronized (c.class) {
                if (pr == null) {
                    pr = new c();
                }
            }
        }
        return pr;
    }

    public synchronized void pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.hw = jSONObject.optBoolean("sensorenable", false);
                this.hn = jSONObject.optLong(an.aU, 180000L);
                this.x = jSONObject.optLong("expireduation", 43200000L);
                this.c = jSONObject.optLong("showinterval", 3L);
                this.uc = jSONObject.optLong("azimuth_unit", 30L);
                this.fw = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }

    public boolean hw() {
        return this.hw;
    }

    public long hn() {
        return this.x;
    }

    public long x() {
        return this.hn;
    }

    public long c() {
        return this.c;
    }

    public long uc() {
        return this.uc;
    }

    public long fw() {
        return this.fw;
    }
}

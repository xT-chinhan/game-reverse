package com.byazt.is;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 250})
public class k {
    public int aj;
    public int c;
    public int fw;
    public int hn;
    public int hw;
    public long k;
    public int pr;
    public int uc;
    public int vk;
    public long w;
    public int x;
    public int zo;

    public static k pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        k kVar = new k();
        try {
            JSONObject jSONObject = new JSONObject(str);
            kVar.pr = jSONObject.optInt(MediationConstant.RIT_TYPE_BANNER);
            kVar.hw = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH);
            kVar.hn = jSONObject.optInt("rewarded");
            kVar.x = jSONObject.optInt(MediationConstant.RIT_TYPE_FEED);
            kVar.c = jSONObject.optInt(MediationConstant.RIT_TYPE_DRAW);
            kVar.uc = jSONObject.optInt("fullscreen");
            kVar.fw = jSONObject.optInt("slide_move_max_num", 5);
            kVar.zo = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
            kVar.aj = jSONObject.optInt("sensor_interval", 3);
            int iOptInt = jSONObject.optInt("mode", 0);
            kVar.vk = iOptInt;
            if (iOptInt != 0 && iOptInt != 1) {
                kVar.vk = 0;
            }
            long jOptLong = jSONObject.optLong("delay_time", 100L);
            kVar.w = jOptLong;
            if (jOptLong <= 0) {
                kVar.w = 100L;
            }
            long jOptLong2 = jSONObject.optLong("first_delay_time", 1000L);
            kVar.k = jOptLong2;
            if (jOptLong2 <= 0) {
                kVar.k = 1000L;
            }
        } catch (Throwable th) {
        }
        return kVar;
    }

    private int x(int i) {
        switch (i) {
            case 1:
                return this.pr;
            case 2:
            case 6:
            default:
                return 0;
            case 3:
            case 4:
                return this.hw;
            case 5:
                return this.x;
            case 7:
                return this.hn;
            case 8:
            case 10:
                return this.uc;
            case 9:
                return this.c;
        }
    }

    public boolean pr(int i) {
        return pr(x(i), 2);
    }

    public boolean hw(int i) {
        return pr(x(i), 1);
    }

    public boolean hn(int i) {
        return pr(x(i), 4);
    }

    private boolean pr(int i, int i2) {
        return (i & i2) == i2;
    }

    public int pr() {
        return this.fw;
    }

    public int hw() {
        return TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
    }

    public int hn() {
        int i = this.aj;
        if (i < 0 || i > 3) {
            return 3;
        }
        return i;
    }

    public int x() {
        return this.vk;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.RIT_TYPE_BANNER, this.pr);
            jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, this.hw);
            jSONObject.put("rewarded", this.hn);
            jSONObject.put(MediationConstant.RIT_TYPE_FEED, this.x);
            jSONObject.put(MediationConstant.RIT_TYPE_DRAW, this.c);
            jSONObject.put("full_screen", this.uc);
            jSONObject.put("slide_move_max_num", this.fw);
            jSONObject.put("motion_max_num", this.zo);
            jSONObject.put("sensor_interval", this.aj);
            jSONObject.put("mode", this.vk);
            jSONObject.put("delay_time", this.w);
            jSONObject.put("first_delay_time", this.k);
            return jSONObject.toString();
        } catch (Throwable th) {
            return super.toString();
        }
    }

    public long c() {
        return this.w;
    }

    public long uc() {
        return this.k;
    }
}

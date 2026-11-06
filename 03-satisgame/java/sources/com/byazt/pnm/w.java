package com.byazt.pnm;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 13})
public class w {
    public long cp;
    public boolean cy = true;
    public long d;
    public int fs;
    public boolean k;
    public int l;
    public int n;
    public boolean oa;
    public int q;
    public int qg;
    public int rv;
    public int s;
    public boolean sz;
    public int tj;
    public int w;
    public int x;

    private boolean n(int i, int i2) {
        return (i & i2) == i2;
    }

    public int qg() {
        return TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
    }

    public static w n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        w wVar = new w();
        try {
            JSONObject jSONObject = new JSONObject(str);
            wVar.n = jSONObject.optInt(MediationConstant.RIT_TYPE_BANNER);
            wVar.qg = jSONObject.optInt(MediationConstant.RIT_TYPE_SPLASH);
            wVar.s = jSONObject.optInt("rewarded");
            wVar.q = jSONObject.optInt(MediationConstant.RIT_TYPE_FEED);
            wVar.l = jSONObject.optInt(MediationConstant.RIT_TYPE_DRAW);
            wVar.w = jSONObject.optInt("fullscreen");
            wVar.x = jSONObject.optInt("slide_move_max_num", 5);
            wVar.fs = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
            wVar.rv = jSONObject.optInt("sensor_interval", 3);
            int iOptInt = jSONObject.optInt("mode", 0);
            wVar.tj = iOptInt;
            if (iOptInt != 0 && iOptInt != 1) {
                wVar.tj = 0;
            }
            long jOptLong = jSONObject.optLong("delay_time", 100L);
            wVar.cp = jOptLong;
            if (jOptLong <= 0) {
                wVar.cp = 100L;
            }
            long jOptLong2 = jSONObject.optLong("first_delay_time", 1000L);
            wVar.d = jOptLong2;
            if (jOptLong2 <= 0) {
                wVar.d = 1000L;
            }
            wVar.oa = jSONObject.optBoolean("enable_event", false);
            wVar.sz = jSONObject.optBoolean("is_report_event", false);
            wVar.k = jSONObject.optBoolean("collect_accelerometer", false);
            wVar.cy = jSONObject.optBoolean("stop_record_sensors_when_click", true);
        } catch (Throwable unused) {
        }
        return wVar;
    }

    private int q(int i) {
        switch (i) {
            case 1:
                return this.n;
            case 2:
            case 6:
            default:
                return 0;
            case 3:
            case 4:
                return this.qg;
            case 5:
                return this.q;
            case 7:
                return this.s;
            case 8:
            case 10:
                return this.w;
            case 9:
                return this.l;
        }
    }

    public boolean n(int i) {
        return n(q(i), 2);
    }

    public boolean qg(int i) {
        return n(q(i), 1);
    }

    public boolean s(int i) {
        return n(q(i), 4);
    }

    public int n() {
        return this.x;
    }

    public int s() {
        int i = this.rv;
        if (i <= 0 || (i > 3 && i < 10000)) {
            return 3;
        }
        return i;
    }

    public int q() {
        return this.tj;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.RIT_TYPE_BANNER, this.n);
            jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, this.qg);
            jSONObject.put("rewarded", this.s);
            jSONObject.put(MediationConstant.RIT_TYPE_FEED, this.q);
            jSONObject.put(MediationConstant.RIT_TYPE_DRAW, this.l);
            jSONObject.put("full_screen", this.w);
            jSONObject.put("slide_move_max_num", this.x);
            jSONObject.put("motion_max_num", this.fs);
            jSONObject.put("sensor_interval", this.rv);
            jSONObject.put("mode", this.tj);
            jSONObject.put("delay_time", this.cp);
            jSONObject.put("first_delay_time", this.d);
            jSONObject.put("enable_event", this.oa);
            jSONObject.put("is_report_event", this.sz);
            jSONObject.put("collect_accelerometer", this.k);
            jSONObject.put("stop_record_sensors_when_click", this.cy);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return super.toString();
        }
    }

    public long l() {
        return this.cp;
    }

    public long w() {
        return this.d;
    }

    public boolean x() {
        return this.oa;
    }

    public boolean fs() {
        return this.sz;
    }

    public boolean rv() {
        return this.k;
    }

    public boolean tj() {
        return this.cy;
    }
}

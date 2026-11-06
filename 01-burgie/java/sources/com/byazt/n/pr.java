package com.byazt.n;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 37})
public class pr {
    public String hw;
    public String pr;
    public int zo;
    public long hn = -2147483648L;
    public int x = Integer.MIN_VALUE;
    public long c = -2147483648L;
    public double uc = -2.147483648E9d;
    public double fw = -2.147483648E9d;

    public JSONObject pr() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.hw)) {
                jSONObject.putOpt("audio_url", this.hw);
            }
            if (!TextUtils.isEmpty(this.pr)) {
                jSONObject.putOpt("file_hash", this.pr);
            }
            long j = this.hn;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.x;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.c;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.uc;
            if (d > 0.0d) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.fw;
            if (d2 > 0.0d) {
                jSONObject.put(TrackAction.START, d2);
            }
            int i2 = this.zo;
            if (i2 > 0) {
                jSONObject.put("repeat_count", i2);
            }
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public String hw() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public long hn() {
        return this.hn;
    }

    public void pr(long j) {
        this.hn = j;
    }

    public void pr(int i) {
        this.x = i;
    }

    public double x() {
        return this.fw;
    }

    public void pr(double d) {
        this.fw = d;
    }

    public void hw(long j) {
        this.c = j;
    }

    public String c() {
        return this.hw;
    }

    public void hw(String str) {
        this.hw = str;
    }

    public double uc() {
        return this.uc;
    }

    public void hw(double d) {
        this.uc = d;
    }

    public void hw(int i) {
        if (i < 0) {
            i = 0;
        }
        this.zo = i;
    }

    public int fw() {
        return this.zo;
    }
}

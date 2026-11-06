package com.byazt.stx;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public int hw;
    public final JSONObject pr;

    private g(JSONObject jSONObject) {
        this.pr = jSONObject;
    }

    public void pr(int i) {
        this.hw = hw(i);
    }

    public int pr() {
        return this.hw;
    }

    private int nt() {
        return this.pr.optInt("url_balance", 2);
    }

    public boolean hw() {
        return nt() > 0;
    }

    public boolean hn() {
        return nt() == 1;
    }

    public int x() {
        return this.pr.optInt("buffer_count", 512);
    }

    public int c() {
        return this.pr.optInt("buffer_size", 8192);
    }

    public boolean uc() {
        return this.pr.optInt("segment_mode", 1) == 0;
    }

    public long fw() {
        long jOptInt = ((long) this.pr.optInt("segment_min_kb", 512)) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            return PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return jOptInt;
    }

    public long zo() {
        long jOptInt = ((long) this.pr.optInt("segment_min_init_mb", 10)) * 1048576;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public long aj() {
        long jOptInt = ((long) this.pr.optInt("segment_max_kb", 0)) * 1048576;
        if (jOptInt < fw()) {
            return -1L;
        }
        return jOptInt;
    }

    public long vk() {
        long jOptInt = this.pr.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public long w() {
        long jOptInt = this.pr.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int k() {
        return this.pr.optInt("ip_strategy", 0);
    }

    private int hw(int i) {
        int iOptInt = this.pr.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            if (nt() == 1) {
                return Math.min(iOptInt, i);
            }
            return iOptInt;
        }
        if (nt() <= 0) {
            return 1;
        }
        return i;
    }

    public float m() {
        return (float) this.pr.optDouble("main_ratio", 0.0d);
    }

    public int g() {
        return this.pr.optInt("ratio_segment", 0);
    }

    public float ho() {
        return Math.min(Math.max(0.0f, (float) this.pr.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public static g pr(JSONObject jSONObject) {
        return new g(jSONObject);
    }
}

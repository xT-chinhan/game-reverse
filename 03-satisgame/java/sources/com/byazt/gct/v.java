package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 984})
public class v {
    public boolean l;
    public String n;
    public double q;
    public int qg;
    public int s;
    public String w;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public int qg() {
        return this.qg;
    }

    public void n(int i) {
        this.qg = i;
    }

    public int s() {
        return this.s;
    }

    public void qg(int i) {
        this.s = i;
    }

    public double q() {
        return this.q;
    }

    public void n(double d) {
        this.q = d;
    }

    public boolean l() {
        return !TextUtils.isEmpty(this.n) && this.qg > 0 && this.s > 0;
    }

    public boolean w() {
        return this.l;
    }

    public void n(boolean z) {
        this.l = z;
    }

    public String x() {
        return this.w;
    }

    public void qg(String str) {
        this.w = str;
    }

    public static com.byazt.fvm.d n(v vVar) {
        if (vVar == null || !vVar.l()) {
            return null;
        }
        return new n(vVar.s(), vVar.qg(), vVar.n(), vVar.q());
    }

    public static final com.byazt.fvm.d n(int i, int i2, String str, double d) {
        return new n(i, i2, str, d);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1968})
    private static final class n extends com.byazt.fvm.d {
        public int n;
        public double q;
        public int qg;
        public String s;

        public n(int i, int i2, String str, double d) {
            this.n = i;
            this.qg = i2;
            this.s = str;
            this.q = d;
        }

        @Override // com.byazt.fvm.d
        public int n() {
            return this.n;
        }

        @Override // com.byazt.fvm.d
        public int qg() {
            return this.qg;
        }

        @Override // com.byazt.fvm.d
        public String s() {
            return this.s;
        }

        @Override // com.byazt.fvm.d
        public double q() {
            return this.q;
        }

        @Override // com.byazt.fvm.d
        public boolean l() {
            String str;
            return this.n > 0 && this.qg > 0 && (str = this.s) != null && str.length() > 0;
        }
    }
}

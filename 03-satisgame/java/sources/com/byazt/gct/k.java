package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 210})
public class k {
    public String l;
    public int n;
    public double q;
    public String qg;
    public int s;
    public double w;
    public double x;

    public int n() {
        return this.n;
    }

    public void n(int i) {
        this.n = i;
    }

    public String qg() {
        return this.qg;
    }

    public void n(String str) {
        this.qg = str;
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

    public String l() {
        return this.l;
    }

    public void qg(String str) {
        this.l = str;
    }

    public double w() {
        return this.w;
    }

    public void qg(double d) {
        this.w = d;
    }

    public double x() {
        return this.x;
    }

    public void s(double d) {
        this.x = d;
    }

    public boolean fs() {
        return !TextUtils.isEmpty(this.l);
    }
}

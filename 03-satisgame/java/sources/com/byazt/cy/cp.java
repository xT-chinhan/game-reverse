package com.byazt.cy;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 29})
public class cp extends com.byazt.fvm.d {
    public String n;
    public int qg;
    public int s;

    @Override // com.byazt.fvm.d
    public double q() {
        return 0.0d;
    }

    public cp(String str) {
        this.n = str;
    }

    public cp(String str, int i, int i2) {
        this.n = str;
        this.qg = i;
        this.s = i2;
    }

    @Override // com.byazt.fvm.d
    public int n() {
        return this.s;
    }

    @Override // com.byazt.fvm.d
    public int qg() {
        return this.qg;
    }

    @Override // com.byazt.fvm.d
    public String s() {
        return !TextUtils.isEmpty(this.n) ? this.n : "";
    }

    @Override // com.byazt.fvm.d
    public boolean l() {
        return !TextUtils.isEmpty(this.n);
    }
}

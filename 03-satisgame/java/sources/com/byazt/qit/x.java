package com.byazt.qit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 21})
public abstract class x implements Comparable<x>, Runnable {
    public int n;
    public String qg;

    public x(String str, int i) {
        this.n = 0;
        this.n = i == 0 ? 5 : i;
        this.qg = str;
    }

    public x(String str) {
        this.n = 5;
        this.qg = str;
    }

    public void setPriority(int i) {
        this.n = i;
    }

    public int getPriority() {
        return this.n;
    }

    @Override // java.lang.Comparable
    public int compareTo(x xVar) {
        if (getPriority() < xVar.getPriority()) {
            return 1;
        }
        return getPriority() >= xVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.qg;
    }
}

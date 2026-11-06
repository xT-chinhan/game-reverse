package com.byazt.xlm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 62})
public abstract class fw implements Comparable<fw>, Runnable {
    public String hw;
    public int pr;

    public fw(String str, int i) {
        this.pr = 0;
        this.pr = i == 0 ? 5 : i;
        this.hw = str;
    }

    public fw(String str) {
        this.pr = 0;
        this.pr = 5;
        this.hw = str;
    }

    public void pr(int i) {
        this.pr = i;
    }

    public int pr() {
        return this.pr;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public int compareTo(fw fwVar) {
        if (pr() < fwVar.pr()) {
            return 1;
        }
        if (pr() >= fwVar.pr()) {
            return -1;
        }
        return 0;
    }
}

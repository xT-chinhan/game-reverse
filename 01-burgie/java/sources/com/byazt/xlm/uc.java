package com.byazt.xlm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 5})
public class uc<V> extends FutureTask<V> implements Comparable<uc<V>> {
    public int hw;
    public int pr;

    public uc(Callable<V> callable, int i, int i2) {
        super(callable);
        this.pr = i == -1 ? 5 : i;
        this.hw = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public int compareTo(uc ucVar) {
        if (pr() < ucVar.pr()) {
            return 1;
        }
        if (pr() > ucVar.pr()) {
            return -1;
        }
        return 0;
    }

    public int pr() {
        return this.pr;
    }
}

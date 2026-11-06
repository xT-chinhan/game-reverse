package com.byazt.qit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 13})
public class w<V> extends FutureTask<V> implements Comparable<w<V>> {
    public int n;
    public int qg;

    public w(Callable<V> callable, int i, int i2) {
        super(callable);
        this.n = i == -1 ? 5 : i;
        this.qg = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        if (n() < wVar.n()) {
            return 1;
        }
        return n() > wVar.n() ? -1 : 0;
    }

    public int n() {
        return this.n;
    }
}

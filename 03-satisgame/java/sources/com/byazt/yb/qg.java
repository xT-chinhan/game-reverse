package com.byazt.yb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 26})
public abstract class qg<T> {
    public volatile T n;

    public abstract T n(Object... objArr);

    public final T qg(Object... objArr) {
        if (this.n == null) {
            synchronized (this) {
                if (this.n == null) {
                    this.n = n(objArr);
                }
            }
        }
        return this.n;
    }
}

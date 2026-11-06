package com.byazt.nzn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public abstract class yb implements Closeable {
    public abstract vk c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract InputStream hn();

    public abstract String hw();

    public abstract long pr();

    public abstract byte[] x();
}

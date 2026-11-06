package com.byazt.tbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public abstract class hd implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract tj l();

    public abstract long n();

    public abstract byte[] q();

    public abstract String qg();

    public abstract InputStream s();
}

package com.byazt.tbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public abstract class cy implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract w fs();

    public abstract boolean l();

    public abstract long n();

    public abstract String n(String str);

    public abstract String n(String str, String str2);

    public abstract int q();

    public abstract long qg();

    public abstract cp rv();

    public abstract sz s();

    public String tj() {
        return null;
    }

    public abstract String w() throws IOException;

    public abstract hd x();
}

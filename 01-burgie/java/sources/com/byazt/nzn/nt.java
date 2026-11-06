package com.byazt.nzn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 74})
public abstract class nt implements Closeable {
    public abstract String c() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract uc fw();

    public abstract int hn();

    public abstract long hw();

    public abstract long pr();

    public abstract String pr(String str);

    public abstract String pr(String str, String str2);

    public abstract yb uc();

    public abstract boolean x();

    public abstract w zo();

    public String aj() {
        return null;
    }
}

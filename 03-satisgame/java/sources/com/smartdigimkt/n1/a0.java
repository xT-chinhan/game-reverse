package com.smartdigimkt.n1;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public final int a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;

    public a0(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = i5;
        this.e = i6;
    }

    public static a0 a(int i, int i2, int i3) {
        int i4 = i3 == 0 ? 1 : i3;
        int i5 = (i < 600 && i2 <= 100) ? 1 : 2;
        int iMax = Math.max(i, 0);
        int iMax2 = i5 == 1 ? Math.max(i2, 0) : 50;
        if (i4 == 3) {
            return i5 == 1 ? new a0(i4, i5, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 46, true, iMax, iMax2) : new a0(i4, i5, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 77, false, iMax, iMax2);
        }
        return i5 == 1 ? new a0(i4, i5, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, 41, true, iMax, iMax2) : new a0(i4, i5, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 78, false, iMax, iMax2);
    }
}

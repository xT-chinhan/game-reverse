package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ x a;

    public t(x xVar) {
        this.a = xVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        x xVar = this.a;
        xVar.a = 2;
        xVar.getClass();
        this.a.getClass();
        this.a.d = mediaPlayer.getVideoWidth();
        this.a.e = mediaPlayer.getVideoHeight();
        x xVar2 = this.a;
        y yVar = xVar2.j;
        if (xVar2.b == 3) {
            xVar2.b();
        }
        MediaPlayer.OnPreparedListener onPreparedListener = this.a.h;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(mediaPlayer);
        }
    }
}

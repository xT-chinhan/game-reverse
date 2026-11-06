package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements MediaPlayer.OnVideoSizeChangedListener {
    public final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.a.d = mediaPlayer.getVideoWidth();
        this.a.e = mediaPlayer.getVideoHeight();
        x xVar = this.a;
        y yVar = xVar.j;
        if (yVar != null) {
            int i3 = xVar.d;
            int i4 = xVar.e;
            yVar.getClass();
        }
    }
}

package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ x a;

    public v(x xVar) {
        this.a = xVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        x xVar = this.a;
        xVar.a = -1;
        xVar.b = -1;
        MediaPlayer.OnErrorListener onErrorListener = xVar.i;
        if (onErrorListener == null) {
            return true;
        }
        onErrorListener.onError(mediaPlayer, i, i2);
        return true;
    }
}

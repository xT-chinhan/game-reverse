package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements MediaPlayer.OnBufferingUpdateListener {
    public final /* synthetic */ x a;

    public r(x xVar) {
        this.a = xVar;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.a.getClass();
    }
}

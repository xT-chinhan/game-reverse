package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements MediaPlayer.OnSeekCompleteListener {
    public final /* synthetic */ x a;

    public u(x xVar) {
        this.a = xVar;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        x xVar = this.a;
        if (xVar.b == 3) {
            xVar.b();
            this.a.b = 5;
        }
    }
}

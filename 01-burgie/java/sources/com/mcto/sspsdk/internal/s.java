package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ x a;

    public s(x xVar) {
        this.a = xVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        x xVar = this.a;
        xVar.a = 5;
        xVar.b = 5;
        xVar.getClass();
    }
}

package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class cj implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ fj a;

    public cj(fj fjVar) {
        this.a = fjVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.getVideoWidth();
        mediaPlayer.getVideoHeight();
        this.a.l = mediaPlayer.getVideoWidth() / mediaPlayer.getVideoHeight();
        li liVar = this.a.o;
        if (liVar != null) {
            liVar.a(1);
        }
    }
}

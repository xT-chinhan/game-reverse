package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class qi implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ ji a;

    public qi(ji jiVar) {
        this.a = jiVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.getVideoWidth();
        mediaPlayer.getVideoHeight();
        ji jiVar = this.a;
        if (jiVar.c.f.compareAndSet(false, true)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(jiVar.a);
            ki kiVar = jiVar.c;
            if (kiVar.c != null) {
                kiVar.d.post(new c3(kiVar, arrayList));
            }
        }
    }
}

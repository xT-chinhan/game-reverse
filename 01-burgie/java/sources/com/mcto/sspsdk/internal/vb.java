package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class vb implements Runnable {
    public final /* synthetic */ zb a;

    public vb(zb zbVar) {
        this.a = zbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MediaPlayer mediaPlayer = this.a.b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        } catch (Exception e) {
            r9.a("ssp_media", this.a.a + ", start: ", e);
            zb zbVar = this.a;
            zbVar.onError(zbVar.b, -1, 0);
        }
    }
}

package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class wb implements Runnable {
    public final /* synthetic */ zb a;

    public wb(zb zbVar) {
        this.a = zbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MediaPlayer mediaPlayer = this.a.b;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
            }
        } catch (Exception e) {
            r9.a("ssp_media", this.a.a + ", reset: ", e);
            zb zbVar = this.a;
            zbVar.onError(zbVar.b, -1, 0);
        }
    }
}

package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final class hb implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ zb b;

    public hb(zb zbVar, long j) {
        this.b = zbVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MediaPlayer mediaPlayer = this.b.b;
            if (mediaPlayer != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo(this.a, 3);
                } else {
                    mediaPlayer.seekTo((int) this.a);
                }
            }
        } catch (Exception e) {
            r9.a("ssp_media", this.b.a + ", start: ", e);
            zb zbVar = this.b;
            zbVar.onError(zbVar.b, -1, 0);
        }
    }
}

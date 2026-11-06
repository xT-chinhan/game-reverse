package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
public final class sb implements Runnable {
    public final /* synthetic */ Surface a;
    public final /* synthetic */ zb b;

    public sb(zb zbVar, Surface surface) {
        this.b = zbVar;
        this.a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MediaPlayer mediaPlayer = this.b.b;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(this.a);
            }
        } catch (Exception e) {
            r9.a("ssp_media", this.b.a + ", start: ", e);
        }
    }
}

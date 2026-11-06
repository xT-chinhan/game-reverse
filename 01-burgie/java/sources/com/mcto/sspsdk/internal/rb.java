package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public final class rb implements Runnable {
    public final /* synthetic */ zb a;

    public rb(zb zbVar) {
        this.a = zbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b = new MediaPlayer();
        this.a.b.setAudioStreamType(3);
        this.a.b.setScreenOnWhilePlaying(true);
        zb zbVar = this.a;
        zbVar.b.setOnPreparedListener(zbVar);
        zb zbVar2 = this.a;
        zbVar2.b.setOnCompletionListener(zbVar2);
        zb zbVar3 = this.a;
        zbVar3.b.setOnBufferingUpdateListener(zbVar3);
        zb zbVar4 = this.a;
        zbVar4.b.setOnErrorListener(zbVar4);
        zb zbVar5 = this.a;
        zbVar5.b.setOnInfoListener(zbVar5);
        zb zbVar6 = this.a;
        zbVar6.b.setOnVideoSizeChangedListener(zbVar6);
    }
}

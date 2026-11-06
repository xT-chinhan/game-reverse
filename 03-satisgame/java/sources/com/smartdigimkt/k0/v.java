package com.smartdigimkt.k0;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends Thread {
    public final /* synthetic */ AudioTrack a;
    public final /* synthetic */ a0 b;

    public v(a0 a0Var, AudioTrack audioTrack) {
        this.b = a0Var;
        this.a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.a.flush();
            this.a.release();
        } finally {
            this.b.g.open();
        }
    }
}

package com.smartdigimkt.y;

import android.media.AudioManager;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c.a(this.a, i);
        } else {
            this.a.c.post(new a(this, i));
        }
    }
}

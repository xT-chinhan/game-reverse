package com.unity3d.player;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class AudioVolumeHandler implements InterfaceC0517p {
    private C0519q a;

    AudioVolumeHandler(Context context) {
        C0519q c0519q = new C0519q(context);
        this.a = c0519q;
        c0519q.a(this);
    }

    public final void a() {
        this.a.a();
        this.a = null;
    }

    @Override // com.unity3d.player.InterfaceC0517p
    public final native void onAudioVolumeChanged(int i);
}

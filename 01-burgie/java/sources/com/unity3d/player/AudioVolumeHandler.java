package com.unity3d.player;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class AudioVolumeHandler implements InterfaceC0394p {
    private C0396q a;

    AudioVolumeHandler(Context context) {
        C0396q c0396q = new C0396q(context);
        this.a = c0396q;
        c0396q.a(this);
    }

    public final void a() {
        this.a.a();
        this.a = null;
    }

    @Override // com.unity3d.player.InterfaceC0394p
    public final native void onAudioVolumeChanged(int i);
}

package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: renamed from: com.unity3d.player.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0396q {
    private final Context a;
    private final AudioManager b;
    private C0392o c;

    public C0396q(Context context) {
        this.a = context;
        this.b = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
    }

    public final void a() {
        if (this.c != null) {
            this.a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public final void a(InterfaceC0394p interfaceC0394p) {
        this.c = new C0392o(new Handler(Looper.getMainLooper()), this.b, interfaceC0394p);
        this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}

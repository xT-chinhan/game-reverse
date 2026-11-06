package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: com.unity3d.player.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0373e0 extends ContentObserver {
    private InterfaceC0371d0 a;

    public C0373e0(Handler handler, InterfaceC0371d0 interfaceC0371d0) {
        super(handler);
        this.a = interfaceC0371d0;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        InterfaceC0371d0 interfaceC0371d0 = this.a;
        if (interfaceC0371d0 != null) {
            ((OrientationLockListener) interfaceC0371d0).b();
        }
    }
}

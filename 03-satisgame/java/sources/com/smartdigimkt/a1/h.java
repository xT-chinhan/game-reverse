package com.smartdigimkt.a1;

import android.hardware.display.DisplayManager;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements DisplayManager.DisplayListener {
    public final DisplayManager a;
    public final /* synthetic */ j b;

    public h(j jVar, DisplayManager displayManager) {
        this.b = jVar;
        this.a = displayManager;
    }

    public final void a() {
        this.a.registerDisplayListener(this, null);
    }

    public final void b() {
        this.a.unregisterDisplayListener(this);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        if (i == 0) {
            this.b.a();
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }
}

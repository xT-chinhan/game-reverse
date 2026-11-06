package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes3.dex */
final class D extends C {
    private OnBackInvokedCallback d;
    private OnBackInvokedDispatcher e;
    private int f;

    private D(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, Runnable runnable) {
        super(runnable);
        this.d = null;
        this.f = i;
        this.e = onBackInvokedDispatcher;
    }

    public static C a(Object obj, int i, Runnable runnable) {
        C d = PlatformSupport.TIRAMISU_SUPPORT && ((obj instanceof Activity) || (obj instanceof Dialog)) ? new D(AbstractC0495e.a(obj), i, runnable) : new C(runnable);
        d.registerOnBackPressedCallback();
        return d;
    }

    @Override // com.unity3d.player.C
    protected void registerOnBackPressedCallback() {
        if (this.a != null) {
            return;
        }
        super.registerOnBackPressedCallback();
        if (PlatformSupport.TIRAMISU_SUPPORT) {
            C0493d c0493d = new C0493d(this.a);
            this.d = c0493d;
            AbstractC0495e.a(this.e, this.f, c0493d);
        }
    }

    @Override // com.unity3d.player.C
    protected void unregisterOnBackPressedCallback() {
        if (this.a != null) {
            if (PlatformSupport.TIRAMISU_SUPPORT) {
                AbstractC0495e.a(this.e, this.d);
                this.d = null;
            }
            super.unregisterOnBackPressedCallback();
        }
    }
}

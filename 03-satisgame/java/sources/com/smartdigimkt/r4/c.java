package com.smartdigimkt.r4;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static b a(Activity activity, Runnable runnable) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        a aVar = new a(runnable);
        onBackInvokedDispatcher.registerOnBackInvokedCallback(0, aVar);
        return new b(onBackInvokedDispatcher, aVar);
    }
}

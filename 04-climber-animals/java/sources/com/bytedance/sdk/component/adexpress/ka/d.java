package com.bytedance.sdk.component.adexpress.ka;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.ms.w;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<w> f881ms;

    public d(w wVar) {
        this.f881ms = new WeakReference<>(wVar);
    }

    public void ms(w wVar) {
        this.f881ms = new WeakReference<>(wVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<w> weakReference = this.f881ms;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f881ms.get().invokeMethod(str);
    }
}

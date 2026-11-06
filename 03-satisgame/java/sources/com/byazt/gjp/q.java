package com.byazt.gjp;

import android.webkit.JavascriptInterface;
import com.byazt.cf.m;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2040, 5})
public class q {
    public WeakReference<m> n;

    public q(m mVar) {
        this.n = new WeakReference<>(mVar);
    }

    public void n(m mVar) {
        this.n = new WeakReference<>(mVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<m> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get().invokeMethod(str);
    }
}

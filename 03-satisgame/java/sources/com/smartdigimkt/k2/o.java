package com.smartdigimkt.k2;

import android.view.ViewTreeObserver;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ WTWebView a;

    public o(WTWebView wTWebView) {
        this.a = wTWebView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        try {
            if (this.a.n) {
                return false;
            }
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.a.n = true;
            this.a.b();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}

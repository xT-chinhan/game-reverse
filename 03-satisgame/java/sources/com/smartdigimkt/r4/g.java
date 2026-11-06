package com.smartdigimkt.r4;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ Context a;

    public g(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            WebView webView = new WebView(this.a);
            j.a(webView);
            Context context = this.a;
            String userAgentString = webView.getSettings().getUserAgentString();
            if (TextUtils.isEmpty(userAgentString)) {
                return;
            }
            synchronized (h.Z) {
                h.f = userAgentString;
            }
            y.a(context, "sdm_adx_rp_sdk", com.smartdigimkt.k4.b.a, userAgentString);
        } catch (Throwable unused) {
            String str = h.a;
        }
    }
}

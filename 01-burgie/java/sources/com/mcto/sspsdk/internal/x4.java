package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import android.webkit.WebSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class x4 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        String defaultUserAgent;
        try {
            y4 y4Var = y4.r;
            if (TextUtils.isEmpty(y4Var.k)) {
                y4Var.k = nh.a(jd.a).a("dsua");
            }
            if (!TextUtils.isEmpty(y4Var.k) && "12.1.2.314".equals(jd.a.getPackageManager().getPackageInfo("com.huawei.webview", 128).versionName)) {
                return;
            }
        } catch (Throwable th) {
        }
        try {
            defaultUserAgent = WebSettings.getDefaultUserAgent(jd.a);
        } catch (Throwable th2) {
            r9.a("ssp_sdk", "updateDefaultUserAgentInBackground", th2);
            defaultUserAgent = null;
        }
        if (TextUtils.isEmpty(defaultUserAgent)) {
            return;
        }
        y4.r.k = defaultUserAgent;
        nh.a(jd.a).a("iad_dev", "dsua", defaultUserAgent);
    }
}

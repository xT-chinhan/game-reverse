package com.mcto.sspsdk.component.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.mcto.sspsdk.internal.gd;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements DownloadListener {
    public final /* synthetic */ QyWebViewPanel a;

    public b(QyWebViewPanel qyWebViewPanel) {
        this.a = qyWebViewPanel;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            String strGuessFileName = URLUtil.guessFileName(str, str3, null);
            if ((TextUtils.isEmpty(strGuessFileName) || !strGuessFileName.endsWith(".apk")) && this.a.a.k() != 1) {
                QyWebViewPanel.a(this.a, Uri.parse(str));
            } else {
                this.a.h = str;
                this.a.a();
                this.a.a(1);
            }
        } catch (Exception e) {
        }
        if (this.a.l != null) {
            gd gdVar = (gd) this.a.l;
            if (gdVar.n[0] == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long[] jArr = gdVar.n;
                if (jCurrentTimeMillis - jArr[1] <= 500) {
                    jArr[1] = 0;
                    jArr[0] = 0;
                    gdVar.f();
                }
            }
        }
    }
}

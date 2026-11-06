package com.smartdigimkt.j2;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements DownloadListener {
    public final /* synthetic */ WebLandPageActivity a;

    public j(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Code duplicated, block: B:16:0x0046  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        WebLandPageActivity webLandPageActivity;
        WebLandPageActivity webLandPageActivity2;
        WebLandPageActivity webLandPageActivity3 = this.a;
        com.smartdigimkt.b3.c cVar = webLandPageActivity3.s;
        if (cVar == null || webLandPageActivity3.t == null || TextUtils.isEmpty(cVar.m)) {
            WebLandPageActivity webLandPageActivity4 = this.a;
            webLandPageActivity4.getClass();
            if (System.currentTimeMillis() - webLandPageActivity4.D > 2500) {
                WebLandPageActivity.a(11, this.a, str);
                return;
            }
            WebLandPageActivity webLandPageActivity5 = this.a;
            webLandPageActivity5.getClass();
            if (!TextUtils.isEmpty(str)) {
                com.smartdigimkt.s4.e.a(str);
                webLandPageActivity5.g = 11;
            }
        } else {
            WebLandPageActivity webLandPageActivity6 = this.a;
            IOfferClickHandler iOfferClickHandler = webLandPageActivity6.v;
            if (iOfferClickHandler != null) {
                Context applicationContext = webLandPageActivity6.getApplicationContext();
                WebLandPageActivity webLandPageActivity7 = this.a;
                if (iOfferClickHandler.startDataFetchApp(applicationContext, webLandPageActivity7.s, webLandPageActivity7.t, str)) {
                    WebLandPageActivity webLandPageActivity8 = this.a;
                    webLandPageActivity8.g = 6;
                    webLandPageActivity8.C = 1;
                } else {
                    webLandPageActivity = this.a;
                    webLandPageActivity.getClass();
                    if (System.currentTimeMillis() - webLandPageActivity.D > 2500) {
                        WebLandPageActivity.a(7, this.a, str);
                        return;
                    }
                    webLandPageActivity2 = this.a;
                    webLandPageActivity2.C = 2;
                    if (!TextUtils.isEmpty(str)) {
                        com.smartdigimkt.s4.e.a(str);
                        webLandPageActivity2.g = 7;
                    }
                }
            } else {
                webLandPageActivity = this.a;
                webLandPageActivity.getClass();
                if (System.currentTimeMillis() - webLandPageActivity.D > 2500) {
                    WebLandPageActivity.a(7, this.a, str);
                    return;
                }
                webLandPageActivity2 = this.a;
                webLandPageActivity2.C = 2;
                if (!TextUtils.isEmpty(str)) {
                    com.smartdigimkt.s4.e.a(str);
                    webLandPageActivity2.g = 7;
                }
            }
        }
        WebLandPageActivity webLandPageActivity9 = this.a;
        webLandPageActivity9.n = 2;
        webLandPageActivity9.a();
    }
}

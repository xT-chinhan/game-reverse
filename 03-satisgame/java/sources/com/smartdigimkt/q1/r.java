package com.smartdigimkt.q1;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.basead.ui.animplayerview.WebLandpagePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements DownloadListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ WebLandpagePlayerView b;

    public r(WebLandpagePlayerView webLandpagePlayerView, Context context) {
        this.b = webLandpagePlayerView;
        this.a = context;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        WebLandpagePlayerView webLandpagePlayerView = this.b;
        com.smartdigimkt.b3.c cVar = webLandpagePlayerView.p;
        if (cVar == null || webLandpagePlayerView.q == null || TextUtils.isEmpty(cVar.m)) {
            this.b.H = 11;
            com.smartdigimkt.s4.e.a(str);
        } else {
            WebLandpagePlayerView webLandpagePlayerView2 = this.b;
            IOfferClickHandler iOfferClickHandler = webLandpagePlayerView2.J;
            if (iOfferClickHandler != null && (iOfferClickHandler instanceof IOfferClickHandler) && iOfferClickHandler.startDataFetchApp(this.a, webLandpagePlayerView2.p, webLandpagePlayerView2.q, str)) {
                WebLandpagePlayerView webLandpagePlayerView3 = this.b;
                webLandpagePlayerView3.H = 6;
                webLandpagePlayerView3.I = 1;
            } else {
                this.b.I = 2;
                com.smartdigimkt.s4.e.a(str);
                this.b.H = 7;
            }
        }
        this.b.Q = 2;
    }
}

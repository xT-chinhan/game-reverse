package com.anythink.basead.mraid;

import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static String a = "i";

    public interface a {
        void a();

        void a(com.anythink.basead.d.f fVar);
    }

    public static String a(x xVar, w wVar) {
        if (!TextUtils.isEmpty(wVar.p())) {
            if (com.anythink.basead.j.f.a().a(wVar, xVar)) {
                com.anythink.core.common.u.e.a(xVar, wVar, com.anythink.basead.j.f.a().e(), "1", false, "1", "can not inject omsdk js into offer_url");
            }
            return wVar.p();
        }
        if (TextUtils.isEmpty(wVar.o())) {
            return "";
        }
        File fileB = com.anythink.core.common.res.d.a(t.b().g()).b(xVar, wVar);
        if (fileB != null) {
            Log.e(a, "loadMraidResource: html exists: " + fileB.toURI().toString());
            return fileB.toURI().toString();
        }
        Log.e(a, "loadMraidResource: html no exists: ");
        return com.anythink.core.common.res.d.a(t.b().g()).a(com.anythink.basead.j.f.a().a(wVar.o(), wVar, xVar), xVar, wVar);
    }

    public static void a(final String str, final String str2, final MraidWebView mraidWebView, final a aVar, final w wVar, final x xVar, final int i, final boolean z) {
        if (mraidWebView == null) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.basead.mraid.i.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.u.e.a(xVar, wVar, i, z);
                String str3 = i.a;
                d dVar = new d();
                k kVar = new k(str2);
                kVar.a(new b() { // from class: com.anythink.basead.mraid.i.1.1
                    boolean b = false;

                    @Override // com.anythink.basead.mraid.b, com.anythink.core.express.web.c
                    public final void onPageFinished(WebView webView, String str4) {
                        if (this.b) {
                            return;
                        }
                        this.b = true;
                        if (com.anythink.core.common.res.d.a.equals(str4)) {
                            String str5 = str2;
                            if (aVar != null) {
                                aVar.a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.o, com.anythink.basead.d.g.O));
                                return;
                            }
                            return;
                        }
                        f.a();
                        f.a(webView);
                        if (mraidWebView != null) {
                            com.anythink.basead.b.c.d.a(str, mraidWebView);
                        }
                        String str6 = str2;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }

                    @Override // com.anythink.basead.mraid.b, com.anythink.core.express.web.c
                    public final void onReceivedError(WebView webView, int i2, String str4, String str5) {
                        if (this.b) {
                            return;
                        }
                        this.b = true;
                        super.onReceivedError(webView, i2, str4, str5);
                        com.anythink.basead.d.f fVarA = com.anythink.basead.d.g.a("10000", i2 + "_" + str4);
                        String str6 = str2;
                        fVarA.c();
                        if (aVar != null) {
                            aVar.a(fVarA);
                        }
                    }

                    @Override // com.anythink.basead.mraid.b, com.anythink.core.express.web.c
                    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        if (this.b) {
                            return;
                        }
                        this.b = true;
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                        com.anythink.basead.d.f fVarA = com.anythink.basead.d.g.a("10000", sslError != null ? sslError.toString() : "onReceivedSslError");
                        String str4 = str2;
                        fVarA.c();
                        if (aVar != null) {
                            aVar.a(fVarA);
                        }
                    }
                });
                mraidWebView.setWebViewClient(kVar);
                mraidWebView.setObject(dVar);
                mraidWebView.loadUrl(str2);
            }
        });
    }
}

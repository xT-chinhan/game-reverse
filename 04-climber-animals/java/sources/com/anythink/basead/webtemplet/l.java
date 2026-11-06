package com.anythink.basead.webtemplet;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = -999;
    private static final String d = "l";

    public interface a {
        void a();

        void a(com.anythink.basead.d.f fVar);
    }

    public static void a(final String str, final String str2, final WTWebView wTWebView, final a aVar, final w wVar, final x xVar, final int i, final Object obj) {
        if (wTWebView == null) {
            com.anythink.basead.d.f fVarA = com.anythink.basead.d.g.a("10000", "wtWebView is null");
            fVarA.c();
            aVar.a(fVarA);
        } else {
            if (obj == null) {
                com.anythink.basead.d.f fVarA2 = com.anythink.basead.d.g.a("10000", "h5 template not support this format");
                fVarA2.c();
                aVar.a(fVarA2);
            }
            t.b().b(new Runnable() { // from class: com.anythink.basead.webtemplet.l.1
                @Override // java.lang.Runnable
                public final void run() {
                    String unused = l.d;
                    wTWebView.initData(wVar, xVar, i == 1);
                    wTWebView.setWebViewListener(new b() { // from class: com.anythink.basead.webtemplet.l.1.1
                        boolean a = false;

                        @Override // com.anythink.basead.webtemplet.b, com.anythink.basead.webtemplet.c
                        public final void b(WebView webView) {
                            if (i == 1) {
                                com.anythink.basead.b.c.d.a(str, wTWebView);
                            }
                            if (this.a) {
                                return;
                            }
                            this.a = true;
                            String unused2 = l.d;
                            String str3 = str2;
                            if (aVar != null) {
                                aVar.a();
                            }
                        }

                        @Override // com.anythink.basead.webtemplet.b, com.anythink.basead.webtemplet.c
                        public final void a(WebView webView) {
                            super.a(webView);
                            if (this.a) {
                                return;
                            }
                            this.a = true;
                            wTWebView.release();
                            com.anythink.basead.d.f fVarA3 = com.anythink.basead.d.g.a("10000", "onRenderProcessGone");
                            String unused2 = l.d;
                            String str3 = str2;
                            fVarA3.c();
                            if (aVar != null) {
                                aVar.a(fVarA3);
                            }
                        }

                        @Override // com.anythink.basead.webtemplet.b, com.anythink.basead.webtemplet.c
                        public final void a(WebView webView, int i2, String str3, String str4) {
                            com.anythink.basead.d.f fVarA3;
                            if (this.a) {
                                return;
                            }
                            this.a = true;
                            wTWebView.release();
                            super.a(webView, i2, str3, str4);
                            if (i2 == -999) {
                                fVarA3 = com.anythink.basead.d.g.a(com.anythink.basead.d.g.u, i2 + "_" + str3);
                            } else {
                                fVarA3 = com.anythink.basead.d.g.a("10000", i2 + "_" + str3);
                            }
                            String unused2 = l.d;
                            String str5 = str2;
                            fVarA3.c();
                            if (aVar != null) {
                                aVar.a(fVarA3);
                            }
                        }

                        @Override // com.anythink.basead.webtemplet.b, com.anythink.basead.webtemplet.c
                        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                            if (this.a) {
                                return;
                            }
                            this.a = true;
                            wTWebView.release();
                            super.a(webView, sslErrorHandler, sslError);
                            com.anythink.basead.d.f fVarA3 = com.anythink.basead.d.g.a("10000", sslError != null ? sslError.toString() : "onReceivedSslError");
                            String unused2 = l.d;
                            String str3 = str2;
                            fVarA3.c();
                            if (aVar != null) {
                                aVar.a(fVarA3);
                            }
                        }
                    });
                    Object obj2 = obj;
                    if (obj2 instanceof com.anythink.basead.webtemplet.adformat.e) {
                        ((com.anythink.basead.webtemplet.adformat.e) obj2).a(wVar, xVar);
                    }
                    wTWebView.setJsCommunicationObject(obj);
                    wTWebView.loadUrl(str2);
                }
            });
        }
    }
}

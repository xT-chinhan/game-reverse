package com.smartdigimkt.k2;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends WebViewClient {
    public c a;
    public g b;

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        sslError.toString();
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(webView, sslErrorHandler, sslError);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0037, blocks: (B:7:0x0017, B:9:0x001f, B:10:0x0022, B:12:0x0026, B:13:0x002d, B:14:0x0030, B:16:0x0034), top: B:19:0x0017 }] */
    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        c cVar;
        if (("onRenderProcessGone:" + renderProcessGoneDetail) != null) {
            renderProcessGoneDetail.toString();
        }
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof WTWebView) {
                    ((WTWebView) webView).release();
                } else {
                    webView.destroy();
                }
                cVar = this.a;
                if (cVar != null) {
                    cVar.a(webView);
                }
            } catch (Throwable unused) {
            }
        } else {
            cVar = this.a;
            if (cVar != null) {
                cVar.a(webView);
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Bitmap bitmapB;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        WebResourceResponse webResourceResponse = null;
        if (str.startsWith("file:")) {
            String str2 = "";
            String strReplace = str.replace("file://", "");
            String strB = com.smartdigimkt.i3.n.a().b(6);
            try {
                File canonicalFile = new File(strReplace).getCanonicalFile();
                File canonicalFile2 = new File(strB).getCanonicalFile();
                if (canonicalFile.exists() && canonicalFile2.exists() && canonicalFile.getPath().startsWith(canonicalFile2.getPath())) {
                    if (str.endsWith(".js")) {
                        str2 = "application/javascript";
                    } else if (str.endsWith(".html")) {
                        str2 = "text/html";
                    } else if (str.endsWith(".css")) {
                        str2 = "text/css";
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        File file = new File(strReplace);
                        if (file.exists()) {
                            return new WebResourceResponse(str2, "UTF-8", new FileInputStream(file));
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str) && h.a(str).startsWith("image") && (bitmapB = com.smartdigimkt.i3.m.a(SDKContext.getInstance().d()).b(new com.smartdigimkt.i3.o(1, str), 0, 0)) != null && !bitmapB.isRecycled()) {
                String strA = h.a(str);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bitmapB.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        byteArrayInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused5) {
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
                webResourceResponse = new WebResourceResponse(strA, "utf-8", byteArrayInputStream);
            }
        } catch (Throwable th4) {
            th4.getMessage();
        }
        return webResourceResponse != null ? webResourceResponse : super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) throws com.smartdigimkt.p2.a {
        if (TextUtils.isEmpty(str) || !str.startsWith("atwt:")) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.b(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("atwt:")) {
            g gVar = this.b;
            gVar.getClass();
            if (h.a[0].equals("atwt:")) {
                gVar.a = h.b;
                this.b.a(str);
            }
        }
        return true;
    }
}

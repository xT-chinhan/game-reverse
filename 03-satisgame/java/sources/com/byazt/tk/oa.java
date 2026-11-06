package com.byazt.tk;

import android.os.Looper;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static final n n = new qg();

    @com.byazt.cp.n(n = {0, 1, 350, TTAdConstant.IMAGE_URL_CODE})
    private static class n {
        private n() {
        }

        public void n(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            oa.qg(new Runnable() { // from class: com.byazt.tk.oa.n.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @com.byazt.cp.n(n = {0, 1, 350, 716})
    private static class qg extends n {
        private qg() {
            super();
        }

        @Override // com.byazt.tk.oa.n
        public void n(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            oa.qg(new Runnable() { // from class: com.byazt.tk.oa.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    boolean z = false;
                    if (str2 != null && str2.startsWith("javascript:")) {
                        try {
                            webView.evaluateJavascript(str, null);
                            z = true;
                        } catch (Throwable th) {
                            boolean z2 = th instanceof IllegalStateException;
                        }
                    }
                    if (z) {
                        return;
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Deprecated
    public static void n(WebView webView, String str) {
        n.n(webView, str);
    }

    public static void n(com.byazt.uad.q qVar, String str) {
        n.n(qVar.getWebView(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            rv.qg().post(runnable);
        }
    }
}

package com.byazt.ca;

import android.os.Build;
import android.os.Looper;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 108})
public class m {
    public static final pr pr;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW})
    private static class pr {
        private pr() {
        }

        public void pr(final WebView webView, final String str) {
            if (webView != null) {
                m.hw(new Runnable() { // from class: com.byazt.ca.m.pr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            webView.loadUrl(str);
                        } catch (Throwable th) {
                        }
                    }
                });
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 1468})
    private static class hw extends pr {
        private hw() {
            super();
        }

        @Override // com.byazt.ca.m.pr
        public void pr(final WebView webView, final String str) {
            if (webView != null) {
                m.hw(new Runnable() { // from class: com.byazt.ca.m.hw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2 = str;
                        boolean z = false;
                        if (str2 != null && str2.startsWith("javascript:")) {
                            try {
                                webView.evaluateJavascript(str, null);
                                z = true;
                            } catch (Throwable th) {
                                if (th instanceof IllegalStateException) {
                                }
                            }
                        }
                        if (!z) {
                            try {
                                webView.loadUrl(str);
                            } catch (Throwable th2) {
                            }
                        }
                    }
                });
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            pr = new hw();
        } else {
            pr = new pr();
        }
    }

    @Deprecated
    public static void pr(WebView webView, String str) {
        pr.pr(webView, str);
    }

    public static void pr(com.byazt.son.x xVar, String str) {
        pr.pr(xVar.getWebView(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aj.hw().post(runnable);
        }
    }
}

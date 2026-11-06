package com.byazt.ew;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    private static void qg(com.byazt.uad.q qVar) {
        try {
            qVar.removeJavascriptInterface("searchBoxJavaBridge_");
            qVar.removeJavascriptInterface("accessibility");
            qVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            x.n("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void n(com.byazt.uad.q qVar) {
        qg(qVar);
        try {
            qVar.setJavaScriptEnabled(true);
            qVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            x.n("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            qVar.setSupportZoom(false);
        } catch (Throwable th2) {
            x.n("WebViewSettings", "setSupportZoom error", th2);
        }
        qVar.setLoadWithOverviewMode(true);
        qVar.setUseWideViewPort(true);
        qVar.setDomStorageEnabled(true);
        qVar.setAllowFileAccess(false);
        qVar.setBlockNetworkImage(false);
        qVar.setDisplayZoomControls(false);
        qVar.setAllowFileAccessFromFileURLs(false);
        qVar.setAllowUniversalAccessFromFileURLs(false);
        qVar.setSavePassword(false);
        boolean z = Build.VERSION.SDK_INT >= 28;
        try {
            if (!z) {
                qVar.setLayerType(0, null);
            } else {
                if (z) {
                    qVar.setLayerType(2, null);
                }
                qVar.setMixedContentMode(0);
            }
        } catch (Throwable th3) {
            x.n("WebViewSettings", "setLayerType error", th3);
        }
        qVar.setMixedContentMode(0);
    }
}

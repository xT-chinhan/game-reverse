package com.byazt.eq;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 661, 61})
public class aj {
    private static void hw(com.byazt.son.x xVar) {
        try {
            xVar.removeJavascriptInterface("searchBoxJavaBridge_");
            xVar.removeJavascriptInterface("accessibility");
            xVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            fw.pr("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void pr(com.byazt.son.x xVar) {
        hw(xVar);
        try {
            xVar.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 17) {
                xVar.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            fw.pr("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            xVar.setSupportZoom(false);
        } catch (Throwable th2) {
            fw.pr("WebViewSettings", "setSupportZoom error", th2);
        }
        xVar.setLoadWithOverviewMode(true);
        xVar.setUseWideViewPort(true);
        xVar.setDomStorageEnabled(true);
        xVar.setAllowFileAccess(false);
        xVar.setBlockNetworkImage(false);
        xVar.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT >= 16) {
            xVar.setAllowFileAccessFromFileURLs(false);
            xVar.setAllowUniversalAccessFromFileURLs(false);
        }
        xVar.setSavePassword(false);
        boolean z = Build.VERSION.SDK_INT >= 28;
        try {
            if (Build.VERSION.SDK_INT >= 11 && !z) {
                xVar.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && z) {
                xVar.setLayerType(2, null);
            }
        } catch (Throwable th3) {
            fw.pr("WebViewSettings", "setLayerType error", th3);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            xVar.setMixedContentMode(0);
        }
    }
}

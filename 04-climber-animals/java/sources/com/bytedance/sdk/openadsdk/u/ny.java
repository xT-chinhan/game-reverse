package com.bytedance.sdk.openadsdk.u;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    private static void xr(com.bytedance.sdk.component.zb.ah ahVar) {
        try {
            ahVar.removeJavascriptInterface("searchBoxJavaBridge_");
            ahVar.removeJavascriptInterface("accessibility");
            ahVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            ab.ms("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    public static void ms(com.bytedance.sdk.component.zb.ah ahVar) {
        xr(ahVar);
        try {
            ahVar.setJavaScriptEnabled(true);
            ahVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            ab.ms("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            ahVar.setSupportZoom(false);
        } catch (Throwable th2) {
            ab.ms("WebViewSettings", "setSupportZoom error", th2);
        }
        ahVar.setLoadWithOverviewMode(true);
        ahVar.setUseWideViewPort(true);
        ahVar.setDomStorageEnabled(true);
        ahVar.setAllowFileAccess(false);
        ahVar.setBlockNetworkImage(false);
        ahVar.setDisplayZoomControls(false);
        ahVar.setAllowFileAccessFromFileURLs(false);
        ahVar.setAllowUniversalAccessFromFileURLs(false);
        ahVar.setSavePassword(false);
        boolean z = Build.VERSION.SDK_INT >= 28;
        try {
            if (!z) {
                ahVar.setLayerType(0, null);
            } else {
                if (z) {
                    ahVar.setLayerType(2, null);
                }
                ahVar.setMixedContentMode(0);
            }
        } catch (Throwable th3) {
            ab.ms("WebViewSettings", "setLayerType error", th3);
        }
        ahVar.setMixedContentMode(0);
    }
}

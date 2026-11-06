package com.anythink.core.express.b;

import android.webkit.WebView;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String a = "placementType";
    public static final String b = "state";
    public static final String c = "viewable";
    public static final String d = "currentAppOrientation";
    public static final String e = "loading";
    public static final String f = "default";
    public static final String g = "expanded";
    public static final String h = "hidden";
    public static final String i = "resized";
    public static final String j = "Interstitial";
    public static final String k = "inline";

    public static a a() {
        return C0109a.a;
    }

    /* JADX INFO: renamed from: com.anythink.core.express.b.a$a, reason: collision with other inner class name */
    private static class C0109a {
        private static final a a = new a();

        private C0109a() {
        }
    }

    public static void a(WebView webView) {
        d(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public static void a(WebView webView, Map<String, Object> map) {
        if (map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String string = jSONObject.toString();
        try {
            string = URLEncoder.encode(string, "UTF-8");
        } catch (Throwable unused) {
        }
        d(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", string));
    }

    public static void a(WebView webView, String str, String str2) {
        try {
            str2 = URLEncoder.encode(str2, "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
        }
        d(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public static void a(WebView webView, float f2, float f3) {
        d(webView, String.format(Locale.US, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f2), Float.valueOf(f3)));
    }

    public static void a(WebView webView, double d2) {
        d(webView, String.format(Locale.US, "javascript:window.mraidbridge.audioVolumeChange(%s);", Double.valueOf(d2)));
    }

    public static void b(WebView webView, float f2, float f3) {
        d(webView, String.format(Locale.US, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f2), Float.valueOf(f3)));
    }

    public static void c(WebView webView, float f2, float f3) {
        d(webView, String.format(Locale.US, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f2), Float.valueOf(f3)));
    }

    public static void a(WebView webView, float f2, float f3, float f4, float f5) {
        d(webView, String.format(Locale.US, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)));
    }

    public static void b(WebView webView, float f2, float f3, float f4, float f5) {
        d(webView, String.format(Locale.US, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)));
    }

    private static void c(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
        }
        d(webView, String.format("javascript:window.mraidbridge.setPlacementType(%s);", str));
    }

    public static void a(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
        }
        d(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", str));
    }

    public static void b(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
        }
        d(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", str));
    }

    private static void d(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}

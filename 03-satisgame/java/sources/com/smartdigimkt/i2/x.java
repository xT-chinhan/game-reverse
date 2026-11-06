package com.smartdigimkt.i2;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Process;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.smartdigimkt.sdk.core.SDKContext;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x {
    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        CookieManager cookieManager = CookieManager.getInstance();
        webView.getContext();
        com.smartdigimkt.w2.c.a().getClass();
        cookieManager.setAcceptThirdPartyCookies(webView, true);
    }

    public static void a(WebView webView, com.smartdigimkt.j2.b bVar, boolean z) {
        com.smartdigimkt.j2.b bVar2;
        com.smartdigimkt.b3.c baseAdContent;
        com.smartdigimkt.b3.e eVar;
        WebSettings settings = webView.getSettings();
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.requestFocus();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setMediaPlaybackRequiresUserGesture(false);
        try {
            settings.setMixedContentMode(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod(com.smartdigimkt.r4.e.a("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, 0);
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(settings, Boolean.FALSE);
        } catch (Exception unused2) {
        }
        settings.setDatabaseEnabled(true);
        String str = SDKContext.getInstance().I;
        settings.setDatabasePath(str);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(str);
        com.smartdigimkt.j2.a aVar = new com.smartdigimkt.j2.a(bVar);
        try {
            aVar.d = z;
            if (z && (bVar2 = aVar.a) != null && (baseAdContent = bVar2.getBaseAdContent()) != null && (eVar = baseAdContent.w) != null) {
                aVar.e = eVar.Y;
            }
        } catch (Throwable unused3) {
        }
        webView.setWebViewClient(aVar);
    }

    public static void a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieSyncManager.getInstance().startSync();
    }

    public static void a(Context context, String str, GeolocationPermissions.Callback callback) {
        try {
            com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
            if (bVarE != null && bVarE.onGeolocationPermissionsShowPrompt(str, callback)) {
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            if (context.checkPermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context, com.smartdigimkt.r4.k.a(context, "system_dialog", "style"));
                builder.setMessage(context.getString(com.smartdigimkt.r4.k.a(context, "location_ask_title", "string"))).setCancelable(true).setPositiveButton(context.getString(com.smartdigimkt.r4.k.a(context, "location_allow", "string")), new w(str, callback)).setNegativeButton(context.getString(com.smartdigimkt.r4.k.a(context, "location_deny", "string")), new v(str, callback));
                builder.create().show();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

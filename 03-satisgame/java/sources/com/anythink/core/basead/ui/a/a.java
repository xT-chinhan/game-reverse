package com.anythink.core.basead.ui.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Process;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.anythink.core.basead.ui.web.b;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.u;
import com.anythink.core.common.u.j;
import com.anythink.core.common.u.p;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static void a(WebView webView, boolean z) {
        if (z) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.a.a$1, reason: invalid class name */
    final class AnonymousClass1 extends WebChromeClient {
        final /* synthetic */ WebChromeClient a;

        AnonymousClass1(WebChromeClient webChromeClient) {
            this.a = webChromeClient;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            jsPromptResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            WebChromeClient webChromeClient = this.a;
            if (webChromeClient != null) {
                webChromeClient.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }
    }

    private static void a(WebView webView, WebChromeClient webChromeClient) {
        webView.setWebChromeClient(new AnonymousClass1(webChromeClient));
    }

    private static void a() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (u.a(s.b().g()).b()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        cookieManager.removeSessionCookies(null);
        cookieManager.removeAllCookies(null);
        cookieManager.flush();
    }

    private static void b(WebView webView) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, u.a(webView.getContext()).b());
    }

    public static void a(WebView webView, Context context, b bVar) {
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
            Method declaredMethod = WebSettings.class.getDeclaredMethod(j.b("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), Integer.TYPE);
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
        String path = context.getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        webView.setWebViewClient(new com.anythink.core.basead.ui.web.a(bVar));
    }

    private static void a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieSyncManager.getInstance().startSync();
    }

    public static void a(Context context, final String str, final GeolocationPermissions.Callback callback) {
        try {
            r rVarC = s.b().c();
            if (rVarC != null && rVarC.onGeolocationPermissionsShowPrompt(str, callback)) {
                return;
            }
        } catch (Throwable unused) {
        }
        try {
            if (context.checkPermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context, p.a(context, "system_dialog", "style"));
                builder.setMessage(context.getString(p.a(context, "location_ask_title", "string"))).setCancelable(true).setPositiveButton(context.getString(p.a(context, "location_allow", "string")), new DialogInterface.OnClickListener() { // from class: com.anythink.core.basead.ui.a.a.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        GeolocationPermissions.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.invoke(str, true, false);
                        }
                    }
                }).setNegativeButton(context.getString(p.a(context, "location_deny", "string")), new DialogInterface.OnClickListener() { // from class: com.anythink.core.basead.ui.a.a.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        GeolocationPermissions.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.invoke(str, false, false);
                        }
                    }
                });
                builder.create().show();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(WebView webView) {
        webView.setWebChromeClient(new AnonymousClass1(null));
    }
}

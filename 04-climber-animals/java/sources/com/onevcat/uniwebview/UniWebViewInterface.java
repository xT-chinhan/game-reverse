package com.onevcat.uniwebview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.webkit.CookieManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.db.constant.Common;
import com.unity3d.player.UnityPlayer;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/onevcat/uniwebview/UniWebViewInterface;", "", "<init>", "()V", "Companion", "com/onevcat/uniwebview/U1", "uniwebview_release"}, k = 1, mv = {1, 6, 0})
public final class UniWebViewInterface {
    public static final U1 Companion = new U1();
    public static final long RUN_SYNC_WAIT_TIME_MS = 5000;
    private static UniWebViewNativeChannel channel;

    @JvmStatic
    public static final void addJavaScript(String str, String str2, String identifier) {
        Z.a(Companion, str, Common.System.NAME, str2, "jsString");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface addJavaScript to: ", str, c0731l, "message"));
        U1.a(str, new C0702b0(str2, identifier));
    }

    @JvmStatic
    public static final void addPermissionTrustDomain(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "domain");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface addPermissionTrustDomain: ", str, ", domain: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0705c0(str2));
    }

    @JvmStatic
    public static final void addSslExceptionDomain(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "domain");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface addSslExceptionDomain: ", str, ", domain: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0708d0(str2));
    }

    @JvmStatic
    public static final void addUrlScheme(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "scheme");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface addUrlScheme: ", str, ", scheme: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0711e0(str2));
    }

    @JvmStatic
    public static final boolean animateTo(String str, int i, int i2, int i3, int i4, float f, float f2, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "identifier");
        C0731l c0731l = C0731l.b;
        String message = "Interface animateTo: {" + i + ", " + i2 + ", " + i3 + ", " + i4 + AbstractJsonLexerKt.END_OBJ;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        Boolean bool = (Boolean) U1.c(str, new C0714f0(i, i2, i3, i4, f, f2, str2));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final void authenticationInit(String str, String str2, String scheme) {
        Z.a(Companion, str, Common.System.NAME, str2, "url");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        C0731l c0731l = C0731l.b;
        String message = "Interface authenticationInit: " + str + ", url: " + str2 + ", scheme: " + scheme;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new C0717g0(str, str2, scheme));
    }

    @JvmStatic
    public static final void authenticationSetPrivateMode(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface authenticationSetPrivateMode: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new C0720h0(name, z));
    }

    @JvmStatic
    public static final void authenticationStart(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface authenticationStart: ", name, c0731l, "message"));
        U1.a(new C0723i0(name));
    }

    @JvmStatic
    public static final void bringContentToFront(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        U1.a(name, C0726j0.a);
    }

    @JvmStatic
    public static final boolean canGoBack(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface canGoBack: ", name, c0731l, "message"));
        Boolean bool = (Boolean) U1.c(name, C0729k0.a);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final boolean canGoForward(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface canGoForward: ", name, c0731l, "message"));
        Boolean bool = (Boolean) U1.c(name, C0732l0.a);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final void captureSnapshot(String name, String str) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface captureSnapshot: ", name, ". File name: ", str, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0735m0(str));
    }

    @JvmStatic
    public static final void cleanCache(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface cleanCache: ", name, c0731l, "message"));
        U1.a(name, C0738n0.a);
    }

    @JvmStatic
    public static final void clearCookies() {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Interface clearCookies", "message");
        c0731l.a(EnumC0728k.INFO, "Interface clearCookies");
        P.a();
    }

    @JvmStatic
    public static final void clearHttpAuthUsernamePassword(String str, String str2) {
        Z.a(Companion, str, "host", str2, "realm");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface clearHttpAuthUsernamePassword. Host: ", str, ", realm: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new C0741o0(str, str2));
    }

    @JvmStatic
    public static final void destroy(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface destroy web view: ", name, c0731l, "message"));
        U1.a(name, C0744p0.a);
    }

    @JvmStatic
    public static final void evaluateJavaScript(String str, String str2, String identifier) {
        Z.a(Companion, str, Common.System.NAME, str2, "jsString");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface evaluateJavaScript in: ", str, c0731l, "message"));
        U1.a(str, new C0747q0(str2, identifier));
    }

    @JvmStatic
    public static final String getCookie(String url, String key) {
        Z.a(Companion, url, "url", key, com.anythink.core.common.e.f.a.b);
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface getCookie from: ", url, " | key: ", key, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(key, "key");
        String cookie = CookieManager.getInstance().getCookie(url);
        if (cookie == null) {
            String message2 = "The content for given url '" + url + "' is not found in cookie manager.";
            Intrinsics.checkNotNullParameter(message2, "message");
            c0731l.a(EnumC0728k.DEBUG, message2);
        } else {
            String message3 = "Cookie string is found: '" + cookie + "', for url: " + url;
            Intrinsics.checkNotNullParameter(message3, "message");
            EnumC0728k enumC0728k = EnumC0728k.VERBOSE;
            c0731l.a(enumC0728k, message3);
            String message4 = "Trying to parse cookie to find value for key: " + key;
            Intrinsics.checkNotNullParameter(message4, "message");
            c0731l.a(enumC0728k, message4);
            Iterator it = CollectionsKt.reversed(new Regex(";").split(cookie, 0)).iterator();
            while (it.hasNext()) {
                List<String> listSplit = new Regex("=").split(StringsKt.trim((CharSequence) it.next()).toString(), 0);
                if (listSplit.size() >= 2 && Intrinsics.areEqual(listSplit.get(0), key)) {
                    String str = listSplit.get(1);
                    C0731l c0731l2 = C0731l.b;
                    String message5 = O.a("Found cookie value: ", str, " for key: ", key, c0731l2);
                    Intrinsics.checkNotNullParameter(message5, "message");
                    c0731l2.a(EnumC0728k.VERBOSE, message5);
                    return str;
                }
            }
            C0731l c0731l3 = C0731l.b;
            String message6 = "Did not find the key '" + key + "' in cookie.";
            c0731l3.getClass();
            Intrinsics.checkNotNullParameter(message6, "message");
            c0731l3.a(EnumC0728k.VERBOSE, message6);
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0055  */
    @JvmStatic
    public static final byte[] getRenderedData(String name, int i, int i2, int i3, int i4) {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0710e c0710e = C0710e.b;
        c0710e.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        N n = (N) c0710e.a.get(name);
        if (n == null || (byteArrayOutputStream = n.m) == null) {
            byteArray = null;
        } else {
            byteArrayOutputStream.reset();
            Bitmap bitmap = n.n;
            if (bitmap == null) {
                byteArray = null;
            } else {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (Exception e) {
                    C0731l c0731l = C0731l.b;
                    String message = "Creating snapshot buffer exception: " + e;
                    c0731l.getClass();
                    Intrinsics.checkNotNullParameter(message, "message");
                    c0731l.a(EnumC0728k.CRITICAL, message);
                    byteArray = null;
                }
            }
        }
        U1.a(name, new C0750r0((i == -1 && i2 == -1 && i3 == -1 && i4 == -1) ? null : new Rect(i, i2, i3 + i, i4 + i2)));
        return byteArray;
    }

    @JvmStatic
    public static final String getUrl(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface getUrl: ", name, c0731l, "message"));
        String str = (String) U1.c(name, C0753s0.a);
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final String getUserAgent(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface getUserAgent: ", name, c0731l, "message"));
        String str = (String) U1.c(name, C0756t0.a);
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final float getWebViewAlpha(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface getWebViewAlpha: ", name, c0731l, "message"));
        Float f = (Float) U1.c(name, C0759u0.a);
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    @JvmStatic
    public static final void goBack(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface goBack: ", name, c0731l, "message"));
        U1.a(name, C0762v0.a);
    }

    @JvmStatic
    public static final void goForward(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface goForward: ", name, c0731l, "message"));
        U1.a(name, C0767w0.a);
    }

    @JvmStatic
    public static final boolean hide(String str, boolean z, int i, float f, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Interface hide", "message");
        c0731l.a(EnumC0728k.INFO, "Interface hide");
        Boolean bool = (Boolean) U1.c(str, new C0770x0(z, i, f, str2));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final void hideAsync(String str, boolean z, int i, float f, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Interface hideAsync", "message");
        c0731l.a(EnumC0728k.INFO, "Interface hideAsync");
        U1.a(str, new C0773y0(z, i, f, str2));
    }

    @JvmStatic
    public static final void hideSpinner(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface hideSpinner: ", name, c0731l, "message"));
        U1.a(name, C0776z0.a);
    }

    @JvmStatic
    public static final void init(String name, int i, int i2, int i3, int i4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface init: ", name, c0731l, "message"));
        U1.a(new A0(name, i, i2, i3, i4));
    }

    @JvmStatic
    public static final boolean isAuthenticationIsSupported() {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Interface authenticationIsSupported.", "message");
        c0731l.a(EnumC0728k.INFO, "Interface authenticationIsSupported.");
        Boolean bool = (Boolean) U1.c(B0.a);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isSafeBrowsingSupported() {
        Companion.getClass();
        Boolean bool = (Boolean) U1.c(B0.a);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isWebViewSupported() {
        Companion.getClass();
        Boolean bool = (Boolean) U1.c(C0.a);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final void load(String name, String str) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface load: ", name, ", url: ", str, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new D0(str));
    }

    @JvmStatic
    public static final void loadHTMLString(String name, String str, String str2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Interface loadHTMLString", "message");
        c0731l.a(EnumC0728k.INFO, "Interface loadHTMLString");
        U1.a(name, new E0(str, str2));
    }

    @JvmStatic
    public static final void prepare() {
        Companion.getClass();
        U1.c(F0.a);
    }

    @JvmStatic
    public static final void print(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface print: ", name, c0731l, "message"));
        U1.a(name, G0.a);
    }

    @JvmStatic
    public static final void registerChannel(UniWebViewNativeChannel channel2) {
        U1 u1 = Companion;
        u1.getClass();
        Intrinsics.checkNotNullParameter(channel2, "channel");
        U1.a(new H0(u1, channel2));
    }

    @JvmStatic
    public static final void reload(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface reload: ", name, c0731l, "message"));
        U1.a(name, I0.a);
    }

    @JvmStatic
    public static final void removeCookie(String str, String str2) {
        Z.a(Companion, str, "url", str2, com.anythink.core.common.e.f.a.b);
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface removeCookie: ", str, ", key: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        P.a(str, str2);
    }

    @JvmStatic
    public static final void removeCookies(String url) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface remove cookies for: ", url, c0731l, "message"));
        Intrinsics.checkNotNullParameter(url, "url");
        P.a(url, (String) null);
    }

    @JvmStatic
    public static final void removePermissionTrustDomain(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "domain");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface removePermissionTrustDomain: ", str, ", domain: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new J0(str2));
    }

    @JvmStatic
    public static final void removeSslExceptionDomain(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "domain");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface removeSslExceptionDomain: ", str, ", domain: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new K0(str2));
    }

    @JvmStatic
    public static final void removeUrlScheme(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "scheme");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface removeUrlScheme: ", str, ", scheme: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new L0(str2));
    }

    @JvmStatic
    public static final void safeBrowsingInit(String name, String str) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface safeBrowsingInit: ", name, ", url: ", str, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new O0(str, name));
    }

    @JvmStatic
    public static final void safeBrowsingSetToolbarColor(String name, float f, float f2, float f3) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface safeBrowsingSetToolbarColor: " + name + ", rgb: {" + f + ", " + f2 + ", " + f3 + ')';
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new P0(name, f, f2, f3));
    }

    @JvmStatic
    public static final void safeBrowsingShow(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface safeBrowsingShow: ", name, c0731l, "message"));
        U1.a(new Q0(name));
    }

    @JvmStatic
    public static final float screenHeight() {
        Companion.getClass();
        return UnityPlayer.currentActivity.findViewById(android.R.id.content).getHeight();
    }

    @JvmStatic
    public static final float screenWidth() {
        Companion.getClass();
        return UnityPlayer.currentActivity.findViewById(android.R.id.content).getWidth();
    }

    @JvmStatic
    public static final void scrollTo(String name, int i, int i2, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface scrollTo: " + name + ", {" + i + ", " + i2 + "}, animated: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new R0(i, i2, z));
    }

    @JvmStatic
    public static final void setAcceptThirdPartyCookies(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setAcceptThirdPartyCookies: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new S0(z));
    }

    @JvmStatic
    public static final void setAllowAutoPlay(boolean z) {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        String message = "Interface setAllowAutoPlay: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new T0(z));
    }

    @JvmStatic
    public static final void setAllowFileAccess(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setAllowFileAccess: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new U0(z));
    }

    @JvmStatic
    public static final void setAllowFileAccessFromFileURLs(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setAllowFileAccessFromFileURLs: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new V0(z));
    }

    @JvmStatic
    public static final void setAllowHTTPAuthPopUpWindow(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setAllowHTTPAuthPopUpWindow: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new W0(z));
    }

    @JvmStatic
    public static final void setAllowJavaScriptOpenWindow(boolean z) {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        String message = "Interface setAllowJavaScriptOpenWindow: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new X0(z));
    }

    @JvmStatic
    public static final void setAllowUniversalAccessFromFileURLs(boolean z) {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        String message = "Interface setAllowUniversalAccessFromFileURLs: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new Y0(z));
    }

    @JvmStatic
    public static final void setAllowUserDismissSpinnerByGesture(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setAllowUserDismissSpinnerByGesture: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new Z0(z));
    }

    @JvmStatic
    public static final void setAllowUserEditFileNameBeforeDownloading(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setAllowUserEditFileNameBeforeDownloading: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0700a1(z));
    }

    @JvmStatic
    public static final void setBackgroundColor(String name, float f, float f2, float f3, float f4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setBackgroundColor rgba: {" + f + ", " + f2 + ", " + f3 + ", " + f4 + AbstractJsonLexerKt.END_OBJ;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0703b1(f, f2, f3, f4));
    }

    @JvmStatic
    public static final void setBouncesEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setBouncesEnabled: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0706c1(z));
    }

    @JvmStatic
    public static final void setCacheMode(String name, int i) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setCacheMode: " + name + ", mode: " + i;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0709d1(i));
    }

    @JvmStatic
    public static final void setCalloutEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setCalloutEnabled: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0712e1(z));
    }

    @JvmStatic
    public static final void setCookie(String str, String str2) {
        Z.a(Companion, str, "url", str2, "cookie");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface setCookie: ", str2, " | to url: ", str, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        P.b(str, str2);
    }

    @JvmStatic
    public static final void setDefaultFontSize(String name, int i) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setDefaultFontSize: " + name + ", size: " + i;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0715f1(i));
    }

    @JvmStatic
    public static final void setDownloadEventForContextMenuEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface SetDownloadEventForContextMenuEnabled: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0718g1(z));
    }

    @JvmStatic
    public static final void setDragInteractionEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setDragInteractionEnabled: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0721h1(z));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarBackgroundColor(String name, float f, float f2, float f3, float f4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setEmbeddedToolbarBackgroundColor: " + name + ", rgba: {" + f + ", " + f2 + ", " + f3 + ", " + f4 + ')';
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0724i1(f, f2, f3, f4));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarButtonTextColor(String name, float f, float f2, float f3, float f4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setEmbeddedToolbarButtonTextColor: " + name + ", rgba: {" + f + ", " + f2 + ", " + f3 + ", " + f4 + ')';
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0727j1(f, f2, f3, f4));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarDoneButtonText(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "text");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface setEmbeddedToolbarDoneButtonText: ", str, ", text: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0730k1(str2));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarGoBackButtonText(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "text");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface setEmbeddedToolbarGoBackButtonText: ", str, ", text: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0733l1(str2));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarGoForwardButtonText(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "text");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface setEmbeddedToolbarGoForwardButtonText: ", str, ", text: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0736m1(str2));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarNavigationButtonsShow(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setEmbeddedToolbarNavigationButtonsShow: ", name, ", show: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0739n1(z));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarOnTop(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setEmbeddedToolbarOnTop: ", name, ", top: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0742o1(z));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarTitleText(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "text");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface setEmbeddedToolbarTitleText: ", str, ", text: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0745p1(str2));
    }

    @JvmStatic
    public static final void setEmbeddedToolbarTitleTextColor(String name, float f, float f2, float f3, float f4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setEmbeddedToolbarTitleTextColor: " + name + ", rgba: {" + f + ", " + f2 + ", " + f3 + ", " + f4 + ')';
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0748q1(f, f2, f3, f4));
    }

    @JvmStatic
    public static final void setEnableKeyboardAvoidance(boolean z) {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        String message = "Interface setEnableKeyboardAvoidance: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new C0751r1(z));
    }

    @JvmStatic
    public static final void setForwardWebConsoleToNativeOutput(boolean z) {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        String message = "Interface setForwardWebConsoleToNativeOutput: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new C0754s1(z));
    }

    @JvmStatic
    public static final void setFrame(String name, int i, int i2, int i3, int i4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setFrame: " + name + ", {" + i + ", " + i2 + ", " + i3 + ", " + i4 + AbstractJsonLexerKt.END_OBJ;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0757t1(i, i2, i3, i4));
    }

    @JvmStatic
    public static final void setHeaderField(String str, String str2, String str3) {
        Z.a(Companion, str, Common.System.NAME, str2, com.anythink.core.common.e.f.a.b);
        C0731l c0731l = C0731l.b;
        String message = "Interface setHeaderField: " + str + ". {key: " + str2 + ", value: " + str3 + AbstractJsonLexerKt.END_OBJ;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new C0760u1(str2, str3));
    }

    @JvmStatic
    public static final void setHorizontalScrollBarEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setHorizontalScrollBarEnabled: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0763v1(z));
    }

    @JvmStatic
    public static final void setJavaScriptEnabled(boolean z) {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        String message = "Interface setJavaScriptEnabled: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new C0768w1(z));
    }

    @JvmStatic
    public static final void setLoadWithOverviewMode(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setLoadWithOverviewMode: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0771x1(z));
    }

    @JvmStatic
    public static final void setLogLevel(int i) {
        Companion.getClass();
        C0731l.b.a = i;
    }

    @JvmStatic
    public static final void setOpenLinksInExternalBrowser(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setOpenLinksInExternalBrowser: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0774y1(z));
    }

    @JvmStatic
    public static final void setPosition(String name, int i, int i2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setPosition: " + name + ", {" + i + ", " + i2 + AbstractJsonLexerKt.END_OBJ;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C0777z1(i, i2));
    }

    @JvmStatic
    public static final void setShowEmbeddedToolbar(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setShowEmbeddedToolbar: ", name, ", show: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new A1(z));
    }

    @JvmStatic
    public static final void setShowSpinnerWhileLoading(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setShowSpinnerWhileLoading: ", name, ", show: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new B1(z));
    }

    @JvmStatic
    public static final void setSize(String name, int i, int i2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setSize: " + name + ", {" + i + ", " + i2 + AbstractJsonLexerKt.END_OBJ;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new C1(i, i2));
    }

    @JvmStatic
    public static final void setSpinnerText(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "text");
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface setSpinnerText: ", str, ", text: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new D1(str2));
    }

    @JvmStatic
    public static final void setSupportMultipleWindows(String name, boolean z, boolean z2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setSupportMultipleWindows: " + name + ", flag: " + z + ", allowJS: " + z2;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new E1(z2));
    }

    @JvmStatic
    public static final void setTextZoom(String name, int i) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setTextZoom: " + name + ", textZoom: " + i;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new F1(i));
    }

    @JvmStatic
    public static final void setTransparencyClickingThroughEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setTransparencyClickingThroughEnabled: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new G1(z));
    }

    @JvmStatic
    public static final void setUseWideViewPort(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setUseWideViewPort: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new H1(z));
    }

    @JvmStatic
    public static final void setUserAgent(String str, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, TTDownloadField.TT_USERAGENT);
        C0731l c0731l = C0731l.b;
        String message = O.a("Interface setUserAgent: ", str, ", UA: ", str2, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(str, new I1(str2));
    }

    @JvmStatic
    public static final void setUserInteractionEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setUserInteractionEnabled: ", name, ", flag: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new J1(z));
    }

    @JvmStatic
    public static final void setVerticalScrollBarEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setVerticalScrollBarEnabled: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new K1(z));
    }

    @JvmStatic
    public static final void setWebContentsDebuggingEnabled(boolean z) {
        Companion.getClass();
        C0731l c0731l = C0731l.b;
        String message = "Interface setWebContentsDebuggingEnabled: " + z;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(new L1(z));
    }

    @JvmStatic
    public static final void setWebViewAlpha(String name, float f) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = "Interface setWebViewAlpha: " + name + ", alpha: " + f;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new M1(f));
    }

    @JvmStatic
    public static final void setZoomEnabled(String name, boolean z) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String message = AbstractC0699a0.a("Interface setZoomEnabled: ", name, ", enabled: ", z, c0731l);
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        U1.a(name, new N1(z));
    }

    @JvmStatic
    public static final boolean show(String str, boolean z, int i, float f, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Interface show", "message");
        c0731l.a(EnumC0728k.INFO, "Interface show");
        Boolean bool = (Boolean) U1.c(str, new O1(z, i, f, str2));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final void showAsync(String str, boolean z, int i, float f, String str2) {
        Z.a(Companion, str, Common.System.NAME, str2, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Interface showAsync", "message");
        c0731l.a(EnumC0728k.INFO, "Interface showAsync");
        U1.a(str, new P1(z, i, f, str2));
    }

    @JvmStatic
    public static final void showSpinner(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface showSpinner: ", name, c0731l, "message"));
        U1.a(name, Q1.a);
    }

    @JvmStatic
    public static final void startSnapshotForRendering(String name, String str) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface startSnapshotForRendering: ", name, c0731l, "message"));
        U1.a(name, new R1(str));
    }

    @JvmStatic
    public static final void stop(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface stop: ", name, c0731l, "message"));
        U1.a(name, S1.a);
    }

    @JvmStatic
    public static final void stopSnapshotForRendering(String name) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Interface stopSnapshotForRendering: ", name, c0731l, "message"));
        U1.a(name, T1.a);
    }
}

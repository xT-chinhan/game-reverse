package com.onevcat.uniwebview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.onevcat.uniwebview.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0749r {
    public final Context a;
    public final InterfaceC0752s b;
    public final C0731l c;
    public final Set d;
    public boolean e;

    public C0749r(Context context, InterfaceC0752s delegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.a = context;
        this.b = delegate;
        C0731l c0731l = C0731l.b;
        this.c = C0731l.b;
        this.d = SetsKt.mutableSetOf("uniwebview");
    }

    public final boolean a(String str, boolean z) {
        if (str == null || z || !this.e || ((C0764w) this.b).getHitTestResult().getType() == 0) {
            return false;
        }
        C0731l c0731l = this.c;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("UniWebView is opening links in external browser.", "message");
        c0731l.a(EnumC0728k.DEBUG, "UniWebView is opening links in external browser.");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        a(intent);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02f1  */
    public final boolean a(String url, boolean z, String str) {
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent uri;
        Intent uri2;
        Intent intent4;
        List<ResolveInfo> listQueryIntentActivities;
        Intrinsics.checkNotNullParameter(url, "url");
        if (str != null) {
            U1 u1 = UniWebViewInterface.Companion;
            C c = new C(str, url);
            u1.getClass();
            E eA = U1.a(c);
            if (eA != null) {
                try {
                    if (!eA.b.getBoolean("result")) {
                        return true;
                    }
                } catch (Exception e) {
                    C0731l c0731l = C0731l.b;
                    String message = "Exception during parsing result for `ShouldUniWebViewHandleRequest`: " + e + ". Result from managed code: " + eA.a;
                    c0731l.getClass();
                    Intrinsics.checkNotNullParameter(message, "message");
                    c0731l.a(EnumC0728k.CRITICAL, message);
                }
            }
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String url2 = url.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(url2, "this as java.lang.String).toLowerCase(locale)");
        Intent intent5 = null;
        if (StringsKt.startsWith$default(url2, "file:", false, 2, (Object) null)) {
            C0764w c0764w = (C0764w) this.b;
            if (c0764w.getSettings().getAllowFileAccess()) {
                C0731l c0731l2 = C0731l.b;
                c0731l2.getClass();
                Intrinsics.checkNotNullParameter("Loading a local file. The local file loading will never be overridden.", "message");
                c0731l2.a(EnumC0728k.DEBUG, "Loading a local file. The local file loading will never be overridden.");
                return false;
            }
            C0731l c0731l3 = C0731l.b;
            c0731l3.getClass();
            Intrinsics.checkNotNullParameter("Local file loading is disabled. To enable loading from a `file://` URL, call `SetAllowFileAccess` with true.", "message");
            c0731l3.a(EnumC0728k.INFO, "Local file loading is disabled. To enable loading from a `file://` URL, call `SetAllowFileAccess` with true.");
            c0764w.c.a(c0764w.b, d2.PageErrorReceived, new Y1("", "-1", "Local file loading is disabled.", null));
            return true;
        }
        if (StringsKt.startsWith$default(url2, "uniwebviewinternal://", false, 2, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) url2, (CharSequence) "__uniwebview_internal_video_end", false, 2, (Object) null)) {
                ((C0764w) this.b).d.onHideCustomView();
            }
            C0731l c0731l4 = this.c;
            c0731l4.getClass();
            Intrinsics.checkNotNullParameter("Url handled internally in UniWebView", "message");
            c0731l4.a(EnumC0728k.DEBUG, "Url handled internally in UniWebView");
            return true;
        }
        Intrinsics.checkNotNullParameter(url2, "url");
        C0731l c0731l5 = this.c;
        c0731l5.a(EnumC0728k.VERBOSE, AbstractC0746q.a("Checking url could match with a defined url scheme: ", url2, c0731l5, "message"));
        Set set = this.d;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (StringsKt.startsWith$default(url2, ((String) it.next()) + "://", false, 2, (Object) null)) {
                    C0731l c0731l6 = this.c;
                    c0731l6.a(EnumC0728k.VERBOSE, AbstractC0746q.a("Found url matching scheme: ", url2, c0731l6, "message"));
                    C0731l c0731l7 = this.c;
                    String message2 = "Url handled by defined scheme. Redirected to Unity. ".concat(url);
                    c0731l7.getClass();
                    Intrinsics.checkNotNullParameter(message2, "message");
                    c0731l7.a(EnumC0728k.DEBUG, message2);
                    C0764w c0764w2 = (C0764w) this.b;
                    c0764w2.getClass();
                    Intrinsics.checkNotNullParameter(url, "url");
                    c0764w2.c.a(c0764w2.b, d2.MessageReceived, url);
                    return true;
                }
            }
        }
        C0731l c0731l8 = this.c;
        c0731l8.a(EnumC0728k.VERBOSE, AbstractC0746q.a("Did not find a matched scheme for: ", url2, c0731l8, "message"));
        if (StringsKt.startsWith$default(url2, "sms:", false, 2, (Object) null)) {
            C0731l c0731l9 = this.c;
            c0731l9.getClass();
            Intrinsics.checkNotNullParameter("Received sms url...", "message");
            c0731l9.a(EnumC0728k.DEBUG, "Received sms url...");
            intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
        } else {
            intent = null;
        }
        if (!a(intent)) {
            if (StringsKt.startsWith$default(url2, "tel:", false, 2, (Object) null)) {
                C0731l c0731l10 = this.c;
                c0731l10.getClass();
                Intrinsics.checkNotNullParameter("Received tel url...", "message");
                c0731l10.a(EnumC0728k.DEBUG, "Received tel url...");
                intent2 = new Intent("android.intent.action.DIAL", Uri.parse(url));
            } else {
                intent2 = null;
            }
            if (!a(intent2)) {
                if (StringsKt.startsWith$default(url2, "mailto:", false, 2, (Object) null)) {
                    C0731l c0731l11 = this.c;
                    c0731l11.getClass();
                    Intrinsics.checkNotNullParameter("Received mailto url...", "message");
                    c0731l11.a(EnumC0728k.DEBUG, "Received mailto url...");
                    intent3 = new Intent("android.intent.action.SENDTO", Uri.parse(url));
                } else {
                    intent3 = null;
                }
                if (!a(intent3)) {
                    if (StringsKt.startsWith$default(url2, "intent:", false, 2, (Object) null)) {
                        C0731l c0731l12 = this.c;
                        c0731l12.getClass();
                        Intrinsics.checkNotNullParameter("Received intent url...", "message");
                        c0731l12.a(EnumC0728k.DEBUG, "Received intent url...");
                        try {
                            uri = Intent.parseUri(url, 1);
                            if (this.a.getPackageManager().resolveActivity(uri, 65536) == null) {
                                String str2 = uri.getPackage();
                                if (str2 == null) {
                                    uri = null;
                                } else {
                                    Intent intent6 = new Intent("android.intent.action.VIEW");
                                    intent6.setData(Uri.parse("market://details?id=".concat(str2)));
                                    uri = intent6;
                                }
                            }
                        } catch (Exception e2) {
                            C0731l c0731l13 = this.c;
                            String message3 = "Parsing intent url error: " + e2 + ".message";
                            c0731l13.getClass();
                            Intrinsics.checkNotNullParameter(message3, "message");
                            c0731l13.a(EnumC0728k.CRITICAL, message3);
                        }
                    } else {
                        uri = null;
                    }
                    if (!a(uri)) {
                        if (StringsKt.startsWith$default(url2, "market:", false, 2, (Object) null)) {
                            C0731l c0731l14 = this.c;
                            c0731l14.getClass();
                            Intrinsics.checkNotNullParameter("Received market url...", "message");
                            c0731l14.a(EnumC0728k.DEBUG, "Received market url...");
                            try {
                                uri2 = Intent.parseUri(url, 1);
                            } catch (Exception e3) {
                                C0731l c0731l15 = this.c;
                                String message4 = "Parsing market url error. " + e3.getMessage();
                                c0731l15.getClass();
                                Intrinsics.checkNotNullParameter(message4, "message");
                                c0731l15.a(EnumC0728k.CRITICAL, message4);
                                uri2 = null;
                            }
                        } else {
                            uri2 = null;
                        }
                        if (!a(uri2)) {
                            if (a(url, z)) {
                                return true;
                            }
                            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"http:", "https:", "file:", com.anythink.core.common.res.d.a});
                            if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
                                intent4 = new Intent("android.intent.action.VIEW", Uri.parse(url));
                                listQueryIntentActivities = this.a.getPackageManager().queryIntentActivities(intent4, 0);
                                Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                                if (!listQueryIntentActivities.isEmpty()) {
                                    intent5 = intent4;
                                }
                            } else {
                                Iterator it2 = listListOf.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        intent4 = new Intent("android.intent.action.VIEW", Uri.parse(url));
                                        listQueryIntentActivities = this.a.getPackageManager().queryIntentActivities(intent4, 0);
                                        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                                        if (!listQueryIntentActivities.isEmpty()) {
                                            intent5 = intent4;
                                        }
                                    } else if (StringsKt.startsWith$default(url2, (String) it2.next(), false, 2, (Object) null)) {
                                    }
                                }
                            }
                            if (a(intent5)) {
                                C0731l c0731l16 = this.c;
                                String message5 = "Url handled by a third party app: ".concat(url);
                                c0731l16.getClass();
                                Intrinsics.checkNotNullParameter(message5, "message");
                                c0731l16.a(EnumC0728k.DEBUG, message5);
                                return true;
                            }
                            C0731l c0731l17 = this.c;
                            String message6 = "Url is opening without overridden: ".concat(url);
                            c0731l17.getClass();
                            Intrinsics.checkNotNullParameter(message6, "message");
                            c0731l17.a(EnumC0728k.DEBUG, message6);
                            return false;
                        }
                    }
                }
            }
        }
        C0731l c0731l18 = this.c;
        c0731l18.getClass();
        Intrinsics.checkNotNullParameter("Url handled by intent.", "message");
        c0731l18.a(EnumC0728k.DEBUG, "Url handled by intent.");
        return true;
    }

    public final boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            this.a.startActivity(intent);
            return true;
        } catch (Exception unused) {
            C0731l c0731l = this.c;
            String message = "No Activity found to handle Intent: " + intent.getData();
            c0731l.getClass();
            Intrinsics.checkNotNullParameter(message, "message");
            c0731l.a(EnumC0728k.CRITICAL, message);
            return false;
        }
    }
}

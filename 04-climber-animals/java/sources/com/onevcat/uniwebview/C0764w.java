package com.onevcat.uniwebview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: com.onevcat.uniwebview.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0764w extends WebView implements InterfaceC0752s {
    public static final /* synthetic */ int i = 0;
    public final Activity a;
    public final String b;
    public final c2 c;
    public final I d;
    public final J e;
    public final W f;
    public boolean g;
    public boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0764w(Activity activity, ViewGroup containerView, ViewGroup videoView, String name, c2 messageSender, V1 loadingObserver) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(messageSender, "messageSender");
        Intrinsics.checkNotNullParameter(loadingObserver, "loadingObserver");
        this.a = activity;
        this.b = name;
        this.c = messageSender;
        this.h = true;
        getSettings().setDatabaseEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAllowContentAccess(true);
        getSettings().setGeolocationEnabled(true);
        getSettings().setDisplayZoomControls(false);
        getSettings().setAllowFileAccess(true);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(AbstractC0761v.d);
        getSettings().setMixedContentMode(2);
        getSettings().setJavaScriptEnabled(AbstractC0761v.c);
        getSettings().setMediaPlaybackRequiresUserGesture(!AbstractC0761v.a);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(AbstractC0761v.b);
        String path = getContext().getCacheDir().getPath();
        WebSettings settings = getSettings();
        if (settings != null && path != null && path.length() != 0 && Build.VERSION.SDK_INT < 33) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebSettings");
                Method declaredMethod = cls.getDeclaredMethod("setAppCachePath", String.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, path);
                Method declaredMethod2 = cls.getDeclaredMethod("setAppCacheEnabled", Boolean.TYPE);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(settings, Boolean.TRUE);
            } catch (Throwable unused) {
            }
        }
        I i2 = new I(this.a, this, containerView, videoView, AbstractC0761v.f);
        this.d = i2;
        setWebChromeClient(i2);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        J j = new J(context, this, loadingObserver);
        this.e = j;
        setWebViewClient(j);
        W w = new W(this.a, this.b, this.c, new C0755t(this));
        this.f = w;
        w.a();
        a();
    }

    public static final boolean a(View view) {
        return true;
    }

    public final void a(String jsString, final String identifier) {
        Intrinsics.checkNotNullParameter(jsString, "jsString");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.DEBUG, AbstractC0746q.a("Adding JavaScript string to web view. Requesting string: ", jsString, c0731l, "message"));
        evaluateJavascript(jsString, new ValueCallback() { // from class: com.onevcat.uniwebview.w$$ExternalSyntheticLambda2
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                C0764w.a(identifier, this, (String) obj);
            }
        });
    }

    public final void b(String jsString, final String identifier) {
        Intrinsics.checkNotNullParameter(jsString, "jsString");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.DEBUG, AbstractC0746q.a("Evaluating JavaScript string within web view. Requesting string: ", jsString, c0731l, "message"));
        evaluateJavascript(jsString, new ValueCallback() { // from class: com.onevcat.uniwebview.w$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                C0764w.b(identifier, this, (String) obj);
            }
        });
    }

    public final void c() {
        Object systemService = this.a.getSystemService("print");
        PrintManager printManager = systemService instanceof PrintManager ? (PrintManager) systemService : null;
        if (printManager == null) {
            C0731l c0731l = C0731l.b;
            C0731l c0731l2 = C0731l.b;
            c0731l2.getClass();
            Intrinsics.checkNotNullParameter("Didn't find a valid print service in current activity. Abort printing...", "message");
            c0731l2.a(EnumC0728k.CRITICAL, "Didn't find a valid print service in current activity. Abort printing...");
            return;
        }
        String url = getUrl();
        if (url != null) {
            PrintDocumentAdapter printDocumentAdapterCreatePrintDocumentAdapter = createPrintDocumentAdapter(url);
            Intrinsics.checkNotNullExpressionValue(printDocumentAdapterCreatePrintDocumentAdapter, "createPrintDocumentAdapter(targetUrl)");
            printManager.print("UniWebView Printing", printDocumentAdapterCreatePrintDocumentAdapter, new PrintAttributes.Builder().build());
        } else {
            C0731l c0731l3 = C0731l.b;
            C0731l c0731l4 = C0731l.b;
            c0731l4.getClass();
            Intrinsics.checkNotNullParameter("The URL of page is null. Abort printing...", "message");
            c0731l4.a(EnumC0728k.CRITICAL, "The URL of page is null. Abort printing...");
        }
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        W w = this.f;
        w.a.unregisterReceiver(w.g);
        super.destroy();
    }

    public final boolean getCalloutEnabled() {
        return this.h;
    }

    public final W getDownloader$uniwebview_release() {
        return this.f;
    }

    public final c2 getMessageSender() {
        return this.c;
    }

    public final String getName() {
        return this.b;
    }

    public final boolean getSendDownloadEventForContextMenu() {
        return this.g;
    }

    public final String getUserAgent() {
        String userAgentString = getSettings().getUserAgentString();
        Intrinsics.checkNotNullExpressionValue(userAgentString, "settings.userAgentString");
        return userAgentString;
    }

    public final I get_webChromeClient$uniwebview_release() {
        return this.d;
    }

    public final J get_webClient$uniwebview_release() {
        return this.e;
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        C0731l c0731l = C0731l.b;
        String message = "UniWebView will load url: '" + url + "' with headers: " + this.e.g;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        J j = this.e;
        j.f = 200;
        j.d = true;
        j.c = false;
        j.e = false;
        if (j.h.a(url, true, this.b)) {
            return;
        }
        loadUrl(url, this.e.g);
    }

    @Override // android.view.View
    public final void onCreateContextMenu(ContextMenu contextMenu) {
        final String extra;
        if (this.h && contextMenu != null) {
            super.onCreateContextMenu(contextMenu);
            int type = getHitTestResult().getType();
            if ((type == 5 || type == 8) && (extra = getHitTestResult().getExtra()) != null) {
                String lowerCase = extra.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (StringsKt.startsWith$default(lowerCase, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "https://", false, 2, (Object) null)) {
                    contextMenu.setHeaderTitle(extra).add(0, 1, 0, getContext().getResources().getString(R.string.SAVE_IMAGE)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.onevcat.uniwebview.w$$ExternalSyntheticLambda1
                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            return C0764w.a(this.f$0, extra, menuItem);
                        }
                    });
                }
            }
        }
    }

    public final void setAllowHTTPAuthPopUpWindow(boolean z) {
        this.e.j = z;
    }

    public final void setCalloutEnabled(boolean z) {
        this.h = z;
    }

    public final void setDefaultFontSize(int i2) {
        getSettings().setDefaultFontSize(MathKt.roundToInt(i2 / this.a.getResources().getConfiguration().fontScale));
    }

    public final void setDragInteractionEnabled(boolean z) {
        View.OnLongClickListener onLongClickListener;
        if (z) {
            setLongClickable(false);
            onLongClickListener = null;
        } else {
            setLongClickable(true);
            onLongClickListener = new View.OnLongClickListener() { // from class: com.onevcat.uniwebview.w$$ExternalSyntheticLambda4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return C0764w.a(view);
                }
            };
        }
        setOnLongClickListener(onLongClickListener);
    }

    public final void setOpenLinksInExternalBrowser(boolean z) {
        this.e.h.e = z;
    }

    public final void setSendDownloadEventForContextMenu(boolean z) {
        this.g = z;
    }

    public final void setUserAgent(String userAgent) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        getSettings().setUserAgentString(userAgent);
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        this.e.c = true;
        super.stopLoading();
    }

    public static final void a(String identifier, C0764w this$0, String it) {
        Intrinsics.checkNotNullParameter(identifier, "$identifier");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Receive callback of adding JavaScript: ", it, c0731l, "message"));
        if (StringsKt.equals(it, AbstractJsonLexerKt.NULL, true)) {
            this$0.c.a(this$0.b, d2.AddJavaScriptFinished, new Y1(identifier, "0", "", null));
        } else {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.c.a(this$0.b, d2.AddJavaScriptFinished, new Y1(identifier, "-1", it, null));
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00f3  */
    public static final void b(String identifier, C0764w this$0, String it) {
        Intrinsics.checkNotNullParameter(identifier, "$identifier");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C0731l c0731l = C0731l.b;
        c0731l.a(EnumC0728k.INFO, AbstractC0746q.a("Receive callback of evaluating JavaScript: ", it, c0731l, "message"));
        if (StringsKt.equals(it, AbstractJsonLexerKt.NULL, true)) {
            this$0.c.a(this$0.b, d2.EvalJavaScriptFinished, new Y1(identifier, "0", "", null));
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        String strReplace = new Regex("^\"|\"$").replace(it, "");
        Intrinsics.checkNotNullParameter(strReplace, "<this>");
        StringBuilder sb = new StringBuilder(strReplace.length());
        int i2 = 0;
        while (i2 < strReplace.length()) {
            char cCharAt = strReplace.charAt(i2);
            char c = AbstractJsonLexerKt.STRING_ESC;
            if (cCharAt == '\\') {
                char cCharAt2 = i2 == strReplace.length() - 1 ? '\\' : strReplace.charAt(i2 + 1);
                if ('0' > cCharAt2 || cCharAt2 >= '8') {
                    if (cCharAt2 != '\\') {
                        if (cCharAt2 == 'b') {
                            cCharAt = '\b';
                        } else if (cCharAt2 == 'n') {
                            cCharAt = '\n';
                        } else if (cCharAt2 == 'r') {
                            cCharAt = '\r';
                        } else if (cCharAt2 == 't') {
                            cCharAt = '\t';
                        } else {
                            c = '\"';
                            if (cCharAt2 != '\"') {
                                c = '\'';
                                if (cCharAt2 != '\'') {
                                    c = AbstractJsonLexerKt.UNICODE_ESC;
                                    if (cCharAt2 == 'u') {
                                        if (i2 < strReplace.length() - 5) {
                                            sb.append(Character.toChars(Integer.parseInt("" + strReplace.charAt(i2 + 2) + strReplace.charAt(i2 + 3) + strReplace.charAt(i2 + 4) + strReplace.charAt(i2 + 5), CharsKt.checkRadix(16))));
                                            i2 += 6;
                                        }
                                    }
                                }
                            }
                        }
                        i2++;
                    }
                    cCharAt = c;
                    i2++;
                } else {
                    String str = "" + cCharAt2;
                    int i3 = i2 + 1;
                    if (i3 < strReplace.length() - 1) {
                        int i4 = i2 + 2;
                        if (Intrinsics.compare((int) strReplace.charAt(i4), 48) >= 0 && Intrinsics.compare((int) strReplace.charAt(i4), 55) <= 0) {
                            str = str + strReplace.charAt(i4);
                            if (i4 < strReplace.length() - 1) {
                                i3 = i2 + 3;
                                if (Intrinsics.compare((int) strReplace.charAt(i3), 48) < 0 || Intrinsics.compare((int) strReplace.charAt(i3), 55) > 0) {
                                    i3 = i4;
                                } else {
                                    str = str + strReplace.charAt(i3);
                                }
                            } else {
                                i3 = i4;
                            }
                        }
                    }
                    sb.append((char) Integer.parseInt(str, CharsKt.checkRadix(8)));
                    i2 = i3 + 1;
                }
            }
            sb.append(cCharAt);
            i2++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        this$0.c.a(this$0.b, d2.EvalJavaScriptFinished, new Y1(identifier, "0", string, null));
    }

    public final void a() {
        setDownloadListener(new DownloadListener() { // from class: com.onevcat.uniwebview.w$$ExternalSyntheticLambda3
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                C0764w.a(this.f$0, str, str2, str3, str4, j);
            }
        });
    }

    public static final void a(C0764w this$0, String url, String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        W w = this$0.f;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        w.a(url, str2, str3, true);
    }

    public static final boolean a(C0764w this$0, String originalUrl, MenuItem it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(originalUrl, "$originalUrl");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f.a(originalUrl, null, MimeTypeMap.getFileExtensionFromUrl(originalUrl), this$0.g);
        return true;
    }

    public final void b() {
        C0731l c0731l = C0731l.b;
        C0731l c0731l2 = C0731l.b;
        c0731l2.getClass();
        Intrinsics.checkNotNullParameter("Checking pop up web view in generalGoBack.", "message");
        EnumC0728k enumC0728k = EnumC0728k.VERBOSE;
        c0731l2.a(enumC0728k, "Checking pop up web view in generalGoBack.");
        C0764w c0764w = this.d.i;
        if (c0764w != null) {
            if (c0764w.canGoBack()) {
                c0731l2.getClass();
                Intrinsics.checkNotNullParameter("popupWebView can go back. Performing going back.", "message");
                c0731l2.a(enumC0728k, "popupWebView can go back. Performing going back.");
                c0764w.goBack();
                return;
            }
            c0731l2.getClass();
            Intrinsics.checkNotNullParameter("popupWebView cannot go back. Performing close.", "message");
            c0731l2.a(enumC0728k, "popupWebView cannot go back. Performing close.");
            c0764w.evaluateJavascript("window.close()", null);
            return;
        }
        c0731l2.getClass();
        Intrinsics.checkNotNullParameter("Checking main web view can go back...", "message");
        c0731l2.a(enumC0728k, "Checking main web view can go back...");
        if (canGoBack()) {
            goBack();
        }
    }

    public final void a(int i2, int i3, boolean z) {
        if (!z) {
            scrollTo(i2, i3);
            return;
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "scrollX", getScrollX(), i2);
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this, "scrollY", getScrollY(), i3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfInt, objectAnimatorOfInt2);
        animatorSet.setDuration(400L).start();
    }
}

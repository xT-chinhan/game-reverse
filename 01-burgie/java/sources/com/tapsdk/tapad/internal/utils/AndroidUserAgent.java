package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidUserAgent {
    private static final Pattern STANDARD_PATTERN = Pattern.compile("^Mozilla/([0-9.]+) \\(([^;]+; )+[^)]+\\) AppleWebKit/([0-9.]+) \\(KHTML, like Gecko\\) (Version/([0-9.]+) )?(Chrome|Safari|Firefox|Edge)/([0-9.]+)( Mobile Safari/([0-9.]+))?");
    private static volatile WeakReference<Context> contextRef = new WeakReference<>(null);
    private static volatile String browserUserAgent = "";

    private AndroidUserAgent() {
    }

    public static String browserUserAgent() {
        return browserUserAgent;
    }

    private static synchronized void capture() {
        if (TextUtils.isEmpty(browserUserAgent)) {
            String property = "";
            try {
                Context context = contextRef.get();
                if (context != null) {
                    property = WebSettings.getDefaultUserAgent(context);
                }
            } catch (Throwable th) {
            }
            if (TextUtils.isEmpty(property)) {
                property = System.getProperty("http.agent");
            }
            browserUserAgent = standardize(property);
        }
    }

    public static void initialize(Context context) {
        contextRef = new WeakReference<>(context == null ? null : context.getApplicationContext());
        capture();
    }

    private static String standardize(String str) {
        if (str == null) {
            return "";
        }
        Matcher matcher = STANDARD_PATTERN.matcher(str);
        return matcher.find() ? matcher.group() : str;
    }
}

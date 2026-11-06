package com.byazt.ua;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public static volatile String hn;
    public static volatile String hw;
    public static volatile String pr;
    public static final String[] x = {"android.app", "android.os", "android.view.Choreographer", "android.view.View.perform", "android.view.ViewRootImpl", "androidx.compose", "androidx.activity.compose", "android.support.v7.widget.LinearLayoutManager", "android.support.v7.widget.GridLayoutManager", "android.support.v7.widget.StaggeredGridLayoutManager", "androidx.recyclerview.widget.LinearLayoutManager", "androidx.recyclerview.widget.GridLayoutManager", "androidx.recyclerview.widget.StaggeredGridLayoutManager"};

    private zo() {
    }

    private static boolean pr(String str) {
        if (str == null) {
            return true;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'd') {
            if (str.startsWith("dalvik.")) {
                return true;
            }
        } else if (cCharAt == 'j') {
            if (str.startsWith("java.lang.Thread") || str.startsWith("java.lang.reflect.") || str.startsWith("javax")) {
                return true;
            }
        } else if (cCharAt == 'c') {
            if (str.startsWith("com.android.")) {
                return true;
            }
        } else if (cCharAt == 'a') {
            int i = 0;
            while (true) {
                String[] strArr = x;
                if (i >= strArr.length) {
                    break;
                }
                if (str.startsWith(strArr[i])) {
                    return true;
                }
                i++;
            }
        } else {
            if (cCharAt != 'k' || (!str.startsWith("kotlin.") && !str.startsWith("kotlinx."))) {
                break;
            }
            return true;
        }
        return false;
    }

    private static String pr(int i) {
        switch (i) {
            case 1:
                return pr;
            case 2:
                return hw;
            case 3:
                return hn;
            default:
                return "";
        }
    }

    private static void pr(int i, String str) {
        switch (i) {
            case 1:
                pr = str;
                break;
            case 2:
                hw = str;
                break;
            case 3:
                hn = str;
                break;
        }
    }

    private static String pr(int i, String str, int i2) {
        String strPr = pr(i);
        if (!TextUtils.isEmpty(strPr)) {
            return strPr;
        }
        String strPr2 = pr(str, i2);
        pr(i, strPr2);
        return strPr2;
    }

    private static String hw() {
        return pr(1, zo.class.getName(), 2);
    }

    private static String pr(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 2) {
            return "";
        }
        if (strArrSplit.length < i || !"com".equals(strArrSplit[0])) {
            i = Math.min(i, strArrSplit.length - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append('.');
            }
            sb.append(strArrSplit[i2]);
        }
        return sb.toString();
    }

    private static boolean pr(String str, String str2) {
        int length;
        int length2;
        if (TextUtils.isEmpty(str2) || (length = str.length()) < (length2 = str2.length()) || str.charAt(0) != str2.charAt(0)) {
            return false;
        }
        if (length2 <= 1 || length <= 1 || str.charAt(1) == str2.charAt(1)) {
            return str.startsWith(str2);
        }
        return false;
    }

    public static boolean pr(float f, String str) {
        if (f <= 0.0f) {
            return false;
        }
        if (f >= 1.0f) {
            return true;
        }
        return ((str != null ? str.hashCode() : (int) System.nanoTime()) & Integer.MAX_VALUE) % 1000000 < ((int) (f * 1000000.0f));
    }

    public static StackTraceElement[] pr() {
        return Thread.currentThread().getStackTrace();
    }

    public static JSONArray pr(StackTraceElement[] stackTraceElementArr, int i) {
        return pr(stackTraceElementArr, i, false, true);
    }

    public static String pr(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return com.byazt.ca.c.hw(jSONArray.toString());
    }

    private static JSONArray pr(StackTraceElement[] stackTraceElementArr, int i, boolean z, boolean z2) {
        String className;
        StringBuilder sb;
        JSONArray jSONArray = new JSONArray();
        if (i <= 0 || stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return jSONArray;
        }
        String strHw = hw();
        boolean z3 = !TextUtils.isEmpty(strHw);
        int i2 = 0;
        for (int i3 = 0; i3 < stackTraceElementArr.length && i2 < i; i3++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            if (stackTraceElement != null && (className = stackTraceElement.getClassName()) != null && className.length() != 0 && !pr(className) && ((!z3 || !pr(className, strHw) || pr(stackTraceElement)) && !pr(className, "com.byazt"))) {
                if (z) {
                    String fileName = stackTraceElement.getFileName();
                    int lineNumber = stackTraceElement.getLineNumber();
                    sb = new StringBuilder(className.length() + 24);
                    sb.append(className).append('.').append(stackTraceElement.getMethodName()).append('(');
                    if (fileName != null) {
                        sb.append(fileName);
                    }
                    sb.append(AbstractJsonLexerKt.COLON).append(lineNumber).append(')');
                } else {
                    sb = new StringBuilder(className.length() + 8);
                    sb.append(className).append('.').append(stackTraceElement.getMethodName());
                }
                jSONArray.put(sb.toString());
                i2++;
            }
        }
        return jSONArray;
    }

    private static boolean pr(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return false;
        }
        String methodName = stackTraceElement.getMethodName();
        if (TextUtils.isEmpty(methodName)) {
            return false;
        }
        if (methodName.startsWith("load")) {
            return methodName.endsWith("Ad") || "loadStream".equals(methodName);
        }
        return "showRewardVideoAd".equals(methodName) || "showFullScreenVideoAd".equals(methodName) || "showSplashView".equals(methodName) || "getAdView".equals(methodName) || "getExpressAdView".equals(methodName) || "getSplashView".equals(methodName) || "getSplashCardView".equals(methodName);
    }
}

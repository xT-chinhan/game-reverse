package com.taptap.sdk.kit.internal;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.kit.internal.exception.TapInvalidDataException;
import com.taptap.sdk.kit.internal.exception.TapSdkException;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: TapLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00122\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J*\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0007J\u0012\u0010\u001f\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010 \u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/taptap/sdk/kit/internal/TapLogger;", "", "()V", "TAG", "", "enableLog", "", "getEnableLog", "()Z", "setEnableLog", "(Z)V", "moduleNameCache", "", "buildWrapString", NotificationCompat.CATEGORY_MESSAGE, "e", "", "d", "", "deriveModuleNameFromPackage", BillingClientConstants.PACKAGE_NAME, "getCallerModuleName", "getModuleNameFromBuildConfig", an.aC, "logd", "tag", "loge", "logi", "logv", "logw", "needWrap", an.aE, "w", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapLogger {
    public static final String TAG = "TapTapSdk";
    private static boolean enableLog;
    public static final TapLogger INSTANCE = new TapLogger();
    private static final Map<String, String> moduleNameCache = new LinkedHashMap();

    @JvmStatic
    public static final void e() {
        e$default(null, null, 3, null);
    }

    @JvmStatic
    public static final void e(String str) {
        e$default(str, null, 2, null);
    }

    @JvmStatic
    public static final void loge() {
        loge$default(null, null, null, 7, null);
    }

    @JvmStatic
    public static final void loge(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        loge$default(tag, null, null, 6, null);
    }

    @JvmStatic
    public static final void loge(String tag, String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        loge$default(tag, str, null, 4, null);
    }

    @JvmStatic
    public static final void logi(String str) {
        logi$default(null, str, 1, null);
    }

    @JvmStatic
    public static final void w(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        w$default(msg, false, 2, null);
    }

    private TapLogger() {
    }

    public final boolean getEnableLog() {
        return enableLog;
    }

    public final void setEnableLog(boolean z) {
        enableLog = z;
    }

    public static /* synthetic */ void loge$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TAG;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            th = null;
        }
        loge(str, str2, th);
    }

    @JvmStatic
    public static final void loge(String tag, String msg, Throwable e) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (e instanceof TapInvalidDataException ? true : e instanceof TapSdkException) {
            Log.e(tag, INSTANCE.buildWrapString(msg, e), e);
        } else {
            Log.e(tag, INSTANCE.buildWrapString(msg, e), e);
        }
    }

    public static /* synthetic */ void logw$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TAG;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        logw(str, str2, z);
    }

    @JvmStatic
    public static final void logw(String tag, String msg, boolean needWrap) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        TapLogger tapLogger = INSTANCE;
        if (enableLog) {
            if (needWrap) {
                Log.w(tag, buildWrapString$default(tapLogger, msg, null, 2, null));
            } else {
                Log.w(tag, msg);
            }
        }
    }

    public static /* synthetic */ String buildWrapString$default(TapLogger tapLogger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return tapLogger.buildWrapString(str, th);
    }

    public final String buildWrapString(String msg, Throwable e) {
        String str;
        List<String> listEmptyList;
        int maxLength;
        String str2 = "";
        try {
            String str3 = msg;
            if ((str3 == null || str3.length() == 0) && e == null) {
                return "";
            }
            String errorMsg = e != null ? e.getMessage() : null;
            if (msg == null || (listEmptyList = StringsKt.lines(msg)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            try {
                if (listEmptyList.isEmpty()) {
                    maxLength = errorMsg != null ? errorMsg.length() : 0;
                } else {
                    Iterator<T> it = listEmptyList.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    String it2 = (String) it.next();
                    int length = it2.length();
                    while (it.hasNext()) {
                        String it3 = (String) it.next();
                        int length2 = it3.length();
                        if (length < length2) {
                            length = length2;
                        }
                    }
                    maxLength = RangesKt.coerceAtLeast(length, errorMsg != null ? errorMsg.length() : 0);
                }
                StringBuilder $this$buildWrapString_u24lambda_u246 = new StringBuilder();
                $this$buildWrapString_u24lambda_u246.append("┏━━━");
                for (int i = 0; i < maxLength; i++) {
                    $this$buildWrapString_u24lambda_u246.append("━");
                }
                $this$buildWrapString_u24lambda_u246.append("━━━┓\n");
                Iterable $this$forEach$iv = listEmptyList;
                for (Object element$iv : $this$forEach$iv) {
                    String it4 = (String) element$iv;
                    $this$buildWrapString_u24lambda_u246.append("┃   ");
                    $this$buildWrapString_u24lambda_u246.append(it4);
                    int length3 = maxLength - it4.length();
                    String str4 = str2;
                    for (int i2 = 0; i2 < length3; i2++) {
                        $this$buildWrapString_u24lambda_u246.append(" ");
                    }
                    $this$buildWrapString_u24lambda_u246.append("   ┃\n");
                    str2 = str4;
                }
                String str5 = errorMsg;
                if (!(str5 == null || str5.length() == 0)) {
                    $this$buildWrapString_u24lambda_u246.append("┃   ");
                    $this$buildWrapString_u24lambda_u246.append(errorMsg);
                    int length4 = maxLength - errorMsg.length();
                    for (int i3 = 0; i3 < length4; i3++) {
                        $this$buildWrapString_u24lambda_u246.append(" ");
                    }
                    $this$buildWrapString_u24lambda_u246.append("   ┃\n");
                }
                $this$buildWrapString_u24lambda_u246.append("┗━━━");
                for (int i4 = 0; i4 < maxLength; i4++) {
                    $this$buildWrapString_u24lambda_u246.append("━");
                }
                $this$buildWrapString_u24lambda_u246.append("━━━┛");
                String string = $this$buildWrapString_u24lambda_u246.toString();
                Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
                return string;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            str = str2;
        }
        e.printStackTrace();
        return msg == null ? str : msg;
    }

    public static /* synthetic */ void logi$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TAG;
        }
        logi(str, str2);
    }

    @JvmStatic
    public static final void logi(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (enableLog) {
            String threadName = Thread.currentThread().getName();
            Log.i(tag, AbstractJsonLexerKt.BEGIN_LIST + threadName + "] " + msg);
        }
    }

    @JvmStatic
    public static final void logd(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (enableLog) {
            String threadName = Thread.currentThread().getName();
            Log.d(tag, AbstractJsonLexerKt.BEGIN_LIST + threadName + "] " + msg);
        }
    }

    @JvmStatic
    public static final void logd(String tag, Throwable e) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (enableLog) {
            String threadName = Thread.currentThread().getName();
            Log.d(tag, AbstractJsonLexerKt.BEGIN_LIST + threadName + "] " + (e != null ? e.getMessage() : null), e);
        }
    }

    @JvmStatic
    public static final void logd(String tag, String msg, Throwable e) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (enableLog) {
            String threadName = Thread.currentThread().getName();
            Log.d(tag, AbstractJsonLexerKt.BEGIN_LIST + threadName + "] " + msg, e);
        }
    }

    @JvmStatic
    public static final void logv(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (enableLog) {
            String threadName = Thread.currentThread().getName();
            Log.v(tag, AbstractJsonLexerKt.BEGIN_LIST + threadName + "] " + msg);
        }
    }

    private final String getCallerModuleName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        for (int i = 4; i < length; i++) {
            String className = stackTrace[i].getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "className");
            if (!StringsKt.startsWith$default(className, "com.taptap.sdk.kit.internal.TapLogger", false, 2, (Object) null) && !Intrinsics.areEqual(className, "com.taptap.sdk.kit.internal.TapLoggerKt")) {
                String packageName = StringsKt.substringBeforeLast(className, '.', "");
                if (packageName.length() == 0) {
                    return TAG;
                }
                Map<String, String> map = moduleNameCache;
                String it = map.get(packageName);
                if (it != null) {
                    return it;
                }
                String moduleName = getModuleNameFromBuildConfig(packageName);
                map.put(packageName, moduleName);
                return moduleName;
            }
        }
        return TAG;
    }

    private final String getModuleNameFromBuildConfig(String packageName) {
        List<String> buildConfigPackages;
        String derivePackage;
        String str = ".internal";
        if (StringsKt.endsWith$default(packageName, ".internal", false, 2, (Object) null)) {
            buildConfigPackages = CollectionsKt.listOf((Object[]) new String[]{StringsKt.removeSuffix(packageName, (CharSequence) ".internal"), packageName});
        } else {
            buildConfigPackages = CollectionsKt.listOf(packageName);
        }
        for (String pkgName : buildConfigPackages) {
            try {
                Class<?> cls = Class.forName(pkgName + ".BuildConfig");
                try {
                    Field moduleNameField = cls.getDeclaredField("MODULE_NAME");
                    moduleNameField.setAccessible(true);
                    Object obj = moduleNameField.get(null);
                    String moduleName = obj instanceof String ? (String) obj : null;
                    String str2 = moduleName;
                    if (!(str2 == null || str2.length() == 0)) {
                        return moduleName;
                    }
                } catch (NoSuchFieldException e) {
                }
                try {
                    Field packageNameField = cls.getDeclaredField("LIBRARY_PACKAGE_NAME");
                    packageNameField.setAccessible(true);
                    Object obj2 = packageNameField.get(null);
                    String libraryPackageName = obj2 instanceof String ? (String) obj2 : null;
                    String str3 = libraryPackageName;
                    if (!(str3 == null || str3.length() == 0)) {
                        return deriveModuleNameFromPackage(libraryPackageName);
                    }
                    continue;
                } catch (NoSuchFieldException e2) {
                }
            } catch (ClassNotFoundException e3) {
            } catch (Exception e4) {
            }
        }
        if (StringsKt.endsWith$default(packageName, str, false, 2, (Object) null)) {
            derivePackage = StringsKt.removeSuffix(packageName, (CharSequence) str);
        } else {
            derivePackage = packageName;
        }
        return deriveModuleNameFromPackage(derivePackage);
    }

    private final String deriveModuleNameFromPackage(String packageName) {
        String capitalizedSegment;
        String lastSegment = StringsKt.substringAfterLast(packageName, '.', "");
        if (lastSegment.length() == 0) {
            return TAG;
        }
        if (lastSegment.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it = lastSegment.charAt(0);
            StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(it) ? CharsKt.titlecase(it) : String.valueOf(it)));
            String strSubstring = lastSegment.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            capitalizedSegment = sbAppend.append(strSubstring).toString();
        } else {
            capitalizedSegment = lastSegment;
        }
        return "TapSDK-" + capitalizedSegment;
    }

    public static /* synthetic */ void e$default(String str, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            th = null;
        }
        e(str, th);
    }

    @JvmStatic
    public static final void e(String msg, Throwable e) {
        loge(INSTANCE.getCallerModuleName(), msg, e);
    }

    public static /* synthetic */ void w$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        w(str, z);
    }

    @JvmStatic
    public static final void w(String msg, boolean needWrap) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        logw(INSTANCE.getCallerModuleName(), msg, needWrap);
    }

    @JvmStatic
    public static final void i(String msg) {
        logi(INSTANCE.getCallerModuleName(), msg);
    }

    @JvmStatic
    public static final void d(String msg) {
        logd(INSTANCE.getCallerModuleName(), msg);
    }

    @JvmStatic
    public static final void d(String msg, Throwable e) {
        logd(INSTANCE.getCallerModuleName(), msg, e);
    }

    @JvmStatic
    public static final void v(String msg) {
        logv(INSTANCE.getCallerModuleName(), msg);
    }
}

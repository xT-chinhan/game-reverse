package com.tapsdk.tapad.internal.runtime;

import android.os.Build;
import android.os.Process;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class CoreModuleSelector {
    private static final String ABI_ARM64_V8A = "arm64-v8a";
    private static final String ABI_ARMEABI_V7A = "armeabi-v7a";
    public static final String CORE_MODULE_NAME = "core";
    public static final int DOMAIN_CORE = 3;
    public static final int DOMAIN_NONE = 0;
    public static final String WASM_ENTRY = "core/module.wasm";

    private CoreModuleSelector() {
    }

    public static String aotEntryForAbi(String str) {
        return null;
    }

    private static boolean containsAbi(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int domainForModuleName(String str) {
        return "core".equals(str) ? 3 : 0;
    }

    private static Boolean isCurrentProcess64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Boolean.valueOf(Process.is64Bit());
        }
        String property = System.getProperty("os.arch", "");
        if (property == null) {
            return null;
        }
        String lowerCase = property.toLowerCase(Locale.US);
        if (lowerCase.contains("aarch64") || lowerCase.contains("arm64")) {
            return Boolean.TRUE;
        }
        if (lowerCase.contains("arm") || lowerCase.contains("armeabi")) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static boolean isSupportedAotAbi(String str) {
        return ABI_ARM64_V8A.equals(str) || ABI_ARMEABI_V7A.equals(str);
    }

    public static String preferredProcessAotAbi(String[] strArr) {
        return preferredProcessAotAbi(strArr, isCurrentProcess64Bit());
    }

    public static String preferredProcessAotAbi(String[] strArr, Boolean bool) {
        if (strArr == null) {
            return null;
        }
        if (Boolean.TRUE.equals(bool)) {
            if (containsAbi(strArr, ABI_ARM64_V8A)) {
                return ABI_ARM64_V8A;
            }
            return null;
        }
        if (Boolean.FALSE.equals(bool)) {
            if (containsAbi(strArr, ABI_ARMEABI_V7A)) {
                return ABI_ARMEABI_V7A;
            }
            return null;
        }
        for (String str : strArr) {
            if (isSupportedAotAbi(str)) {
                return str;
            }
        }
        return null;
    }
}

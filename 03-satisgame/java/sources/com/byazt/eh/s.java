package com.byazt.eh;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.vx.w;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2367, 8})
public class s {
    public static boolean n() {
        String[] strArr = Build.SUPPORTED_ABIS;
        w.n("abi-support: " + (strArr == null ? AbstractJsonLexerKt.NULL : strArr.toString()));
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("arm64-v8a")) {
                return true;
            }
        }
        return false;
    }

    public static boolean qg() {
        return s() && !n();
    }

    public static boolean s() {
        w.qg("isOA8A: true");
        return true;
    }
}

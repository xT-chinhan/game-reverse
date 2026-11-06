package com.byazt.ud;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.dea.uc;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1485, 20})
public class hn {
    public static boolean pr() {
        String[] strArr = Build.SUPPORTED_ABIS;
        uc.pr("abi-support: " + (strArr == null ? AbstractJsonLexerKt.NULL : strArr.toString()));
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

    public static boolean hw() {
        return hn() && !pr();
    }

    public static boolean hn() {
        uc.hw("isOA8A: true");
        return true;
    }
}

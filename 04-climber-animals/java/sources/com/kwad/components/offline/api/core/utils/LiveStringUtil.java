package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class LiveStringUtil {
    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || AbstractJsonLexerKt.NULL.equalsIgnoreCase(str);
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }
}

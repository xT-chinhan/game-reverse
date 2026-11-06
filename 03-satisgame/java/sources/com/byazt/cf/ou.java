package com.byazt.cf;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public enum ou {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    public static ou n(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals("private", lowerCase)) {
            return PRIVATE;
        }
        return PUBLIC;
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this == PRIVATE) {
            return "private";
        }
        return this == PROTECTED ? "protected" : "public";
    }
}

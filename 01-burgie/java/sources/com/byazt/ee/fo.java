package com.byazt.ee;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public enum fo {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    public static fo pr(String str) {
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
        if (this == PROTECTED) {
            return "protected";
        }
        return "public";
    }
}

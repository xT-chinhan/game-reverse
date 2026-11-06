package com.byazt.tl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 905, 37})
public class pr {
    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt < 'A' || cCharAt > 'Z') {
                    sb.append(cCharAt);
                } else {
                    if (sb.length() > 0) {
                        sb.append('_');
                    }
                    sb.append((char) (cCharAt + ' '));
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static String pr(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z) {
            str = str.substring(1);
        }
        return pr(str);
    }
}

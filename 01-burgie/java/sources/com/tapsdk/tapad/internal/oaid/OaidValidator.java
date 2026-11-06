package com.tapsdk.tapad.internal.oaid;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class OaidValidator {
    private static final Set<String> INVALID_OAID_SET;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("00000000-0000-0000-0000-000000000000");
        hashSet.add("0000000000000000000000000000000000000000000000000000000000000000");
        hashSet.add("00000-00000-00000-00000");
        INVALID_OAID_SET = Collections.unmodifiableSet(hashSet);
    }

    private OaidValidator() {
    }

    private static boolean isAllZero(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return length >= 16;
    }

    public static boolean isInvalid(String str) {
        return !isValid(str);
    }

    public static boolean isValid(String str) {
        return isValidCandidate(normalize(str));
    }

    private static boolean isValidCandidate(String str) {
        if (TextUtils.isEmpty(str) || INVALID_OAID_SET.contains(str)) {
            return false;
        }
        String strReplace = str.replace("-", "");
        return strReplace.length() <= 0 || !isAllZero(strReplace);
    }

    private static String normalize(String str) {
        return str == null ? "" : str.trim();
    }

    public static String sanitize(String str) {
        String strNormalize = normalize(str);
        return isValidCandidate(strNormalize) ? strNormalize : "";
    }
}

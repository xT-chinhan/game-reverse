package com.byazt.es;

import android.os.Build;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2064, 13})
public class hw {
    public static String pr(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        String strPr;
        if (bigDecimal == null || TextUtils.isEmpty(str) || locale == null) {
            return "";
        }
        String upperCase = str.trim().toUpperCase(Locale.ROOT);
        if (Build.VERSION.SDK_INT >= 30) {
            strPr = hn.pr(bigDecimal, upperCase, locale, i, i2, i3);
        } else {
            strPr = pr.pr(bigDecimal, upperCase, locale, i, i2, i3);
        }
        if (pr(locale)) {
            return pr(strPr);
        }
        return strPr;
    }

    private static boolean pr(Locale locale) {
        if (locale == null) {
            return false;
        }
        return "ar".equalsIgnoreCase(locale.getLanguage());
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    private static String pr(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                int numericValue = Character.getNumericValue(c);
                if (numericValue >= 0 && numericValue <= 9) {
                    sb.append((char) (numericValue + 48));
                } else {
                    sb.append(c);
                }
            } else if (c == 1644) {
                sb.append(AbstractJsonLexerKt.COMMA);
            } else if (c == 1643) {
                sb.append('.');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

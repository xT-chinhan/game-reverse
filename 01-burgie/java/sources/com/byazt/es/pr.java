package com.byazt.es;

import android.os.Build;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2064, 37})
public class pr {
    public static String pr(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        try {
            return pr(Currency.getInstance(str), locale, i, i2, i3).format(bigDecimal);
        } catch (Throwable th) {
            return "";
        }
    }

    private static DecimalFormat pr(Currency currency, Locale locale, int i, int i2, int i3) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        decimalFormat.setCurrency(currency);
        switch (i) {
            case 1:
                DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol(currency.getCurrencyCode());
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                String pattern = decimalFormat.toPattern();
                if (pattern.contains("¤#") || pattern.contains("¤0")) {
                    pattern = pattern.replace("¤#", "¤ #").replace("¤0", "¤ 0");
                }
                if (pattern.contains("#¤") || pattern.contains("0¤")) {
                    pattern = pattern.replace("#¤", "# ¤").replace("0¤", "0 ¤");
                }
                if (pattern.contains("¤-#") || pattern.contains("¤-0")) {
                    pattern = pattern.replace("¤-#", "¤ -#").replace("¤-0", "¤ -0");
                }
                if (pattern.contains("-¤#") || pattern.contains("-¤0")) {
                    pattern = pattern.replace("-¤#", "- ¤#").replace("-¤0", "- ¤0");
                }
                decimalFormat.applyPattern(pattern);
                break;
            case 4:
                String displayName = null;
                if (Build.VERSION.SDK_INT >= 19) {
                    displayName = currency.getDisplayName(locale);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    try {
                        decimalFormat.applyPattern(((android.icu.text.DecimalFormat) android.icu.text.NumberFormat.getInstance(locale, 6)).toPattern().replace("¤¤¤", "¤").replace("¤¤", "¤"));
                        break;
                    } catch (Throwable th) {
                    }
                }
                DecimalFormatSymbols decimalFormatSymbols2 = decimalFormat.getDecimalFormatSymbols();
                decimalFormatSymbols2.setCurrencySymbol(displayName);
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols2);
                break;
        }
        decimalFormat.setMaximumFractionDigits(i3);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }
}

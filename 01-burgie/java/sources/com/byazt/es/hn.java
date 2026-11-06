package com.byazt.es;

import android.icu.number.FormattedNumber;
import android.icu.number.LocalizedNumberFormatter;
import android.icu.number.Notation;
import android.icu.number.NumberFormatter;
import android.icu.number.Precision;
import android.icu.util.Currency;
import android.os.Build;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2064, 20})
public class hn {
    public static String pr(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        try {
            FormattedNumber formattedNumberHw = hw(bigDecimal, str, locale, i, i2, i3);
            if (formattedNumberHw != null) {
                return formattedNumberHw.toString();
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    private static FormattedNumber hw(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        LocalizedNumberFormatter localizedNumberFormatter;
        if (Build.VERSION.SDK_INT >= 30) {
            Currency currency = Currency.getInstance(str);
            Notation notationSimple = Notation.simple();
            if (i2 == 1) {
                notationSimple = Notation.simple();
            } else if (i2 == 2) {
                if (Build.VERSION.SDK_INT == 30) {
                    notationSimple = Notation.simple();
                } else {
                    notationSimple = Notation.compactShort();
                }
            }
            LocalizedNumberFormatter localizedNumberFormatter2 = (LocalizedNumberFormatter) ((LocalizedNumberFormatter) ((LocalizedNumberFormatter) ((LocalizedNumberFormatter) NumberFormatter.withLocale(locale).unit(currency)).notation(notationSimple)).precision(Precision.maxFraction(i3))).roundingMode(RoundingMode.HALF_UP);
            switch (i) {
                case 1:
                    localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.ISO_CODE);
                    break;
                case 2:
                default:
                    localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.SHORT);
                    break;
                case 3:
                    localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.NARROW);
                    break;
                case 4:
                    localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.FULL_NAME);
                    break;
            }
            return localizedNumberFormatter.format(bigDecimal);
        }
        return null;
    }
}

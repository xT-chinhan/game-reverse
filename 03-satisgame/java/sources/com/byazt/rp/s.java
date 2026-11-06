package com.byazt.rp;

import android.icu.number.FormattedNumber;
import android.icu.number.LocalizedNumberFormatter;
import android.icu.number.Notation;
import android.icu.number.NumberFormatter;
import android.icu.number.Precision;
import android.icu.util.Currency;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BARRAGE_MASKURL, 8})
public class s {
    public static String n(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        try {
            FormattedNumber formattedNumberQg = qg(bigDecimal, str, locale, i, i2, i3);
            return formattedNumberQg != null ? formattedNumberQg.toString() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static FormattedNumber qg(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        LocalizedNumberFormatter localizedNumberFormatter;
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
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
        if (i == 1) {
            localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.ISO_CODE);
        } else if (i == 3) {
            localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.NARROW);
        } else if (i == 4) {
            localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.FULL_NAME);
        } else {
            localizedNumberFormatter = (LocalizedNumberFormatter) localizedNumberFormatter2.unitWidth(NumberFormatter.UnitWidth.SHORT);
        }
        return localizedNumberFormatter.format(bigDecimal);
    }
}

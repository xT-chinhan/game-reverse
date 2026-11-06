package com.byazt.rp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BARRAGE_MASKURL, 19})
public class n {
    public static String n(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        try {
            return n(Currency.getInstance(str), locale, i, i2, i3).format(bigDecimal);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static DecimalFormat n(Currency currency, Locale locale, int i, int i2, int i3) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(locale);
        decimalFormat.setCurrency(currency);
        if (i == 1) {
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
        } else if (i == 4) {
            String displayName = currency.getDisplayName(locale);
            try {
                decimalFormat.applyPattern(((android.icu.text.DecimalFormat) android.icu.text.NumberFormat.getInstance(locale, 6)).toPattern().replace("¤¤¤", "¤").replace("¤¤", "¤"));
            } catch (Throwable unused) {
            }
            DecimalFormatSymbols decimalFormatSymbols2 = decimalFormat.getDecimalFormatSymbols();
            decimalFormatSymbols2.setCurrencySymbol(displayName);
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols2);
        }
        decimalFormat.setMaximumFractionDigits(i3);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }
}

package com.byazt.rp;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigDecimal;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BARRAGE_MASKURL, 26})
public class qg {
    public static String n(BigDecimal bigDecimal, String str, Locale locale, int i, int i2, int i3) {
        String strN;
        if (bigDecimal == null || TextUtils.isEmpty(str) || locale == null) {
            return "";
        }
        String upperCase = str.trim().toUpperCase(Locale.ROOT);
        if (Build.VERSION.SDK_INT >= 30) {
            strN = s.n(bigDecimal, upperCase, locale, i, i2, i3);
        } else {
            strN = n.n(bigDecimal, upperCase, locale, i, i2, i3);
        }
        return n(locale) ? n(strN) : strN;
    }

    private static boolean n(Locale locale) {
        if (locale == null) {
            return false;
        }
        return "ar".equalsIgnoreCase(locale.getLanguage());
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0043  */
    private static String n(String str) {
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

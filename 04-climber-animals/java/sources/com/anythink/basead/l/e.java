package com.anythink.basead.l;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String a = "e";
    private static final String b = "<VAST\\s.*version\\s*=\\s*\".*\"(\\s.*|)?>";

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile(b).matcher(str).find();
    }

    public static boolean a(CharSequence charSequence) {
        return !b(charSequence);
    }

    public static boolean b(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static long b(String str) {
        Date date;
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.getMessage();
            date = null;
        }
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }
}

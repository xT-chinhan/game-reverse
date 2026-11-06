package com.anythink.basead.webtemplet;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final String a = "atwt:";
    private static final String[] b = {a};
    private static final Pattern c = Pattern.compile("atwt://(.+?)#(.+?)/(.+?)(\\?(.*?))?");
    private static Map<String, String> d = new HashMap();

    static {
        for (com.anythink.core.express.d.c cVar : com.anythink.core.express.d.c.values()) {
            d.put(cVar.a(), cVar.b());
        }
    }

    public static boolean a(String str) {
        for (String str2 : b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Pattern b(String str) {
        if (a.equals(str)) {
            return c;
        }
        return null;
    }

    private static String g(String str) {
        char[] cArr = {'\'', AbstractJsonLexerKt.STRING_ESC};
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            boolean z = true;
            if (cCharAt > 255) {
                stringBuffer.append("\\u");
                String upperCase = Integer.toHexString(cCharAt >>> '\b').toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                String upperCase2 = Integer.toHexString(cCharAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        z = false;
                        break;
                    }
                    if (cArr[i2] == cCharAt) {
                        stringBuffer.append("\\".concat(String.valueOf(cCharAt)));
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    stringBuffer.append(cCharAt);
                }
            }
        }
        return new String(stringBuffer);
    }

    public static boolean c(String str) {
        return d(str).startsWith("image");
    }

    public static String d(String str) {
        String str2 = d.get(h(str));
        return str2 == null ? "" : str2;
    }

    private static String h(String str) {
        String path;
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (iLastIndexOf = path.lastIndexOf(com.anythink.core.common.d.j.z)) == -1) ? "" : path.substring(iLastIndexOf + 1);
    }

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? str : com.anythink.core.common.v.k.a(str);
    }

    public static String f(String str) {
        return TextUtils.isEmpty(str) ? str : com.anythink.core.common.v.k.b(str);
    }
}

package com.bytedance.sdk.component.ah.xr;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class nw {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Pattern f1132ms = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern xr = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String ah;
    private final String c;
    private final String d;
    private final String ka;

    private nw(String str, String str2, String str3, String str4) {
        this.ah = str;
        this.d = str2;
        this.ka = str3;
        this.c = str4;
    }

    public static nw ms(String str) {
        Matcher matcher = f1132ms.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = xr.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                String strGroup2 = matcher2.group(2);
                if (strGroup2 != null) {
                    if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                        strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                    }
                } else {
                    strGroup2 = matcher2.group(3);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = strGroup2;
            }
        }
        return new nw(str, lowerCase, lowerCase2, str2);
    }

    public String ms() {
        return this.d;
    }

    public String xr() {
        return this.ka;
    }

    public Charset ah() {
        return ms((Charset) null);
    }

    public Charset ms(Charset charset) {
        try {
            String str = this.c;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.ah;
    }

    public boolean equals(Object obj) {
        return (obj instanceof nw) && ((nw) obj).ah.equals(this.ah);
    }

    public int hashCode() {
        return this.ah.hashCode();
    }
}

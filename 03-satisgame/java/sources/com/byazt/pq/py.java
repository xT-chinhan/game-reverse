package com.byazt.pq;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 866})
public final class py {
    public static final Pattern n = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern qg = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final String l;
    public final String q;
    public final String s;
    public final String w;

    private py(String str, String str2, String str3, String str4) {
        this.s = str;
        this.q = str2;
        this.l = str3;
        this.w = str4;
    }

    public static py n(String str) {
        Matcher matcher = n.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = qg.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            if ("charset".equalsIgnoreCase(matcher2.group(1))) {
                String strGroup = matcher2.group(2);
                if (strGroup != null) {
                    if (strGroup.startsWith("'") && strGroup.endsWith("'") && strGroup.length() > 2) {
                        strGroup = strGroup.substring(1, strGroup.length() - 1);
                    }
                } else {
                    strGroup = matcher2.group(3);
                }
                if (str2 != null && !str2.equalsIgnoreCase(strGroup)) {
                    return null;
                }
                str2 = strGroup;
            }
        }
        return new py(str, lowerCase, lowerCase2, str2);
    }

    public String n() {
        return this.q;
    }

    public String qg() {
        return this.l;
    }

    public Charset s() {
        return n((Charset) null);
    }

    public Charset n(Charset charset) {
        try {
            String str = this.w;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.s;
    }

    public boolean equals(Object obj) {
        return (obj instanceof py) && ((py) obj).s.equals(this.s);
    }

    public int hashCode() {
        return this.s.hashCode();
    }
}

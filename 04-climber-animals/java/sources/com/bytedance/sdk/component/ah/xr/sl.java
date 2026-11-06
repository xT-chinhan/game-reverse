package com.bytedance.sdk.component.ah.xr;

import com.anythink.core.common.d.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class sl {
    private final long ab;
    private final String c;
    private final boolean ch;
    private final boolean hi;
    private final String ka;
    private final String ny;
    private final boolean sl;
    private final String x;
    private final boolean zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Pattern f1140ms = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern xr = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern ah = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private sl(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.ka = str;
        this.c = str2;
        this.ab = j;
        this.x = str3;
        this.ny = str4;
        this.ch = z;
        this.hi = z2;
        this.zb = z3;
        this.sl = z4;
    }

    public String ms() {
        return this.ka;
    }

    public String xr() {
        return this.c;
    }

    private static boolean ms(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.bytedance.sdk.component.ah.xr.ms.ah.ah(str);
    }

    public static sl ms(y yVar, String str) {
        return ms(System.currentTimeMillis(), yVar, str);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[PHI: r0
      0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    static sl ms(long j, y yVar, String str) {
        long j2;
        sl slVar;
        String str2;
        String strSubstring;
        int length = str.length();
        char c = ';';
        int iMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, 0, length, ';');
        char c2 = '=';
        int iMs2 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, 0, iMs, '=');
        if (iMs2 == iMs) {
            return null;
        }
        String strAh = com.bytedance.sdk.component.ah.xr.ms.ah.ah(str, 0, iMs2);
        if (strAh.isEmpty() || com.bytedance.sdk.component.ah.xr.ms.ah.xr(strAh) != -1) {
            return null;
        }
        String strAh2 = com.bytedance.sdk.component.ah.xr.ms.ah.ah(str, iMs2 + 1, iMs);
        if (com.bytedance.sdk.component.ah.xr.ms.ah.xr(strAh2) != -1) {
            return null;
        }
        int i = iMs + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String strXr = null;
        boolean z4 = true;
        long jMs = -1;
        long jMs2 = 253402300799999L;
        String str3 = null;
        while (i < length) {
            int iMs3 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, i, length, c);
            int iMs4 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, i, iMs3, c2);
            String strAh3 = com.bytedance.sdk.component.ah.xr.ms.ah.ah(str, i, iMs4);
            String strAh4 = iMs4 < iMs3 ? com.bytedance.sdk.component.ah.xr.ms.ah.ah(str, iMs4 + 1, iMs3) : "";
            if (strAh3.equalsIgnoreCase("expires")) {
                try {
                    jMs2 = ms(strAh4, 0, strAh4.length());
                    z3 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strAh3.equalsIgnoreCase("max-age")) {
                jMs = ms(strAh4);
                z3 = true;
            } else if (strAh3.equalsIgnoreCase("domain")) {
                strXr = xr(strAh4);
                z4 = false;
            } else if (strAh3.equalsIgnoreCase("path")) {
                str3 = strAh4;
            } else if (strAh3.equalsIgnoreCase("secure")) {
                z = true;
            } else if (strAh3.equalsIgnoreCase("httponly")) {
                z2 = true;
            }
            i = iMs3 + 1;
            c = ';';
            c2 = '=';
        }
        long j3 = Long.MIN_VALUE;
        if (jMs == Long.MIN_VALUE) {
            j2 = j3;
        } else if (jMs != -1) {
            j3 = j + (jMs <= 9223372036854775L ? jMs * 1000 : Long.MAX_VALUE);
            if (j3 < j || j3 > 253402300799999L) {
                j2 = 253402300799999L;
            } else {
                j2 = j3;
            }
        } else {
            j2 = jMs2;
        }
        String strAb = yVar.ab();
        if (strXr == null) {
            str2 = strAb;
            slVar = null;
        } else {
            if (!ms(strAb, strXr)) {
                return null;
            }
            slVar = null;
            str2 = strXr;
        }
        if (strAb.length() != str2.length() && com.bytedance.sdk.component.ah.xr.ms.x.ms.ms().ms(str2) == null) {
            return slVar;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String strNy = yVar.ny();
            int iLastIndexOf = strNy.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strNy.substring(0, iLastIndexOf) : "/";
        } else {
            strSubstring = str3;
        }
        return new sl(strAh, strAh2, j2, str2, strSubstring, z, z2, z4, z3);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    private static long ms(String str, int i, int i2) {
        int iMs = ms(str, i, i2, false);
        Matcher matcher = d.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iMs < i2) {
            int iMs2 = ms(str, iMs + 1, i2, true);
            matcher.region(iMs, iMs2);
            if (i4 == -1 && matcher.usePattern(d).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i6 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(ah).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = xr;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 != -1 && matcher.usePattern(f1140ms).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else if (i3 != -1) {
            }
            iMs = ms(str, iMs2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 <= 0 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.bytedance.sdk.component.ah.xr.ms.ah.ab);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i6);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static int ms(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long ms(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    private static String xr(String str) {
        if (str.endsWith(j.z)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(j.z)) {
            str = str.substring(1);
        }
        String strMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str);
        if (strMs != null) {
            return strMs;
        }
        throw new IllegalArgumentException();
    }

    public static List<sl> ms(y yVar, qv qvVar) {
        List<String> listXr = qvVar.xr("Set-Cookie");
        int size = listXr.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            sl slVarMs = ms(yVar, listXr.get(i));
            if (slVarMs != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(slVarMs);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return ms(false);
    }

    String ms(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ka);
        sb.append('=');
        sb.append(this.c);
        if (this.sl) {
            if (this.ab == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.bytedance.sdk.component.ah.xr.ms.ah.d.ms(new Date(this.ab)));
            }
        }
        if (!this.zb) {
            sb.append("; domain=");
            if (z) {
                sb.append(j.z);
            }
            sb.append(this.x);
        }
        sb.append("; path=").append(this.ny);
        if (this.ch) {
            sb.append("; secure");
        }
        if (this.hi) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof sl)) {
            return false;
        }
        sl slVar = (sl) obj;
        return slVar.ka.equals(this.ka) && slVar.c.equals(this.c) && slVar.x.equals(this.x) && slVar.ny.equals(this.ny) && slVar.ab == this.ab && slVar.ch == this.ch && slVar.hi == this.hi && slVar.sl == this.sl && slVar.zb == this.zb;
    }

    public int hashCode() {
        int iHashCode = (((((((this.ka.hashCode() + 527) * 31) + this.c.hashCode()) * 31) + this.x.hashCode()) * 31) + this.ny.hashCode()) * 31;
        long j = this.ab;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.ch ? 1 : 0)) * 31) + (!this.hi ? 1 : 0)) * 31) + (!this.sl ? 1 : 0)) * 31) + (!this.zb ? 1 : 0);
    }
}

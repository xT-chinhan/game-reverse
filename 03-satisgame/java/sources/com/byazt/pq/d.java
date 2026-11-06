package com.byazt.pq;

import com.anythink.core.common.d.i;
import com.anythink.core.e.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 113})
public final class d {
    public final boolean cp;
    public final boolean d;
    public final String fs;
    public final String l;
    public final boolean oa;
    public final String rv;
    public final boolean tj;
    public final String w;
    public final long x;
    public static final Pattern n = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern qg = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern s = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern q = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private d(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.l = str;
        this.w = str2;
        this.x = j;
        this.fs = str3;
        this.rv = str4;
        this.tj = z;
        this.cp = z2;
        this.oa = z3;
        this.d = z4;
    }

    public String n() {
        return this.l;
    }

    public String qg() {
        return this.w;
    }

    private static boolean n(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.byazt.zho.s.s(str);
    }

    public static d n(um umVar, String str) {
        return n(System.currentTimeMillis(), umVar, str);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[PHI: r0
      0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    public static d n(long j, um umVar, String str) {
        long j2;
        d dVar;
        String str2;
        String strSubstring;
        int length = str.length();
        char c = ';';
        int iN = com.byazt.zho.s.n(str, 0, length, ';');
        char c2 = '=';
        int iN2 = com.byazt.zho.s.n(str, 0, iN, '=');
        if (iN2 == iN) {
            return null;
        }
        String strS = com.byazt.zho.s.s(str, 0, iN2);
        if (strS.isEmpty() || com.byazt.zho.s.qg(strS) != -1) {
            return null;
        }
        String strS2 = com.byazt.zho.s.s(str, iN2 + 1, iN);
        if (com.byazt.zho.s.qg(strS2) != -1) {
            return null;
        }
        int i = iN + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String strQg = null;
        boolean z4 = true;
        long jN = -1;
        long jN2 = 253402300799999L;
        String str3 = null;
        while (i < length) {
            int iN3 = com.byazt.zho.s.n(str, i, length, c);
            int iN4 = com.byazt.zho.s.n(str, i, iN3, c2);
            String strS3 = com.byazt.zho.s.s(str, i, iN4);
            String strS4 = iN4 < iN3 ? com.byazt.zho.s.s(str, iN4 + 1, iN3) : "";
            if ("expires".equalsIgnoreCase(strS3)) {
                try {
                    jN2 = n(strS4, 0, strS4.length());
                    z3 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if ("max-age".equalsIgnoreCase(strS3)) {
                jN = n(strS4);
                z3 = true;
            } else if (b.a.G.equalsIgnoreCase(strS3)) {
                strQg = qg(strS4);
                z4 = false;
            } else if ("path".equalsIgnoreCase(strS3)) {
                str3 = strS4;
            } else if ("secure".equalsIgnoreCase(strS3)) {
                z = true;
            } else if ("httponly".equalsIgnoreCase(strS3)) {
                z2 = true;
            }
            i = iN3 + 1;
            c = ';';
            c2 = '=';
        }
        long j3 = Long.MIN_VALUE;
        if (jN == Long.MIN_VALUE) {
            j2 = j3;
        } else if (jN != -1) {
            j3 = j + (jN <= 9223372036854775L ? jN * 1000 : LongCompanionObject.MAX_VALUE);
            if (j3 < j || j3 > 253402300799999L) {
                j2 = 253402300799999L;
            } else {
                j2 = j3;
            }
        } else {
            j2 = jN2;
        }
        String strW = umVar.w();
        if (strQg == null) {
            str2 = strW;
            dVar = null;
        } else {
            if (!n(strW, strQg)) {
                return null;
            }
            dVar = null;
            str2 = strQg;
        }
        if (strW.length() != str2.length() && com.byazt.onh.n.n().n(str2) == null) {
            return dVar;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String strFs = umVar.fs();
            int iLastIndexOf = strFs.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strFs.substring(0, iLastIndexOf) : "/";
        } else {
            strSubstring = str3;
        }
        return new d(strS, strS2, j2, str2, strSubstring, z, z2, z4, z3);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    private static long n(String str, int i, int i2) {
        int iN = n(str, i, i2, false);
        Matcher matcher = q.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iN < i2) {
            int iN2 = n(str, iN + 1, i2, true);
            matcher.region(iN, iN2);
            if (i4 == -1 && matcher.usePattern(q).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i6 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(s).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = qg;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 != -1 && matcher.usePattern(n).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else if (i3 != -1) {
            }
            iN = n(str, iN2 + 1, i2, false);
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
        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.byazt.zho.s.x);
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

    private static int n(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long n(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (str.startsWith("-")) {
                    return Long.MIN_VALUE;
                }
                return LongCompanionObject.MAX_VALUE;
            }
            throw e;
        }
    }

    private static String qg(String str) {
        if (str.endsWith(i.E)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(i.E)) {
            str = str.substring(1);
        }
        String strN = com.byazt.zho.s.n(str);
        if (strN != null) {
            return strN;
        }
        throw new IllegalArgumentException();
    }

    public static List<d> n(um umVar, cd cdVar) {
        List<String> listQg = cdVar.qg("Set-Cookie");
        int size = listQg.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            d dVarN = n(umVar, listQg.get(i));
            if (dVarN != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(dVarN);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return n(false);
    }

    public String n(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        sb.append('=');
        sb.append(this.w);
        if (this.d) {
            if (this.x == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.byazt.cri.q.n(new Date(this.x)));
            }
        }
        if (!this.oa) {
            sb.append("; domain=");
            if (z) {
                sb.append(i.E);
            }
            sb.append(this.fs);
        }
        sb.append("; path=").append(this.rv);
        if (this.tj) {
            sb.append("; secure");
        }
        if (this.cp) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.l.equals(this.l) && dVar.w.equals(this.w) && dVar.fs.equals(this.fs) && dVar.rv.equals(this.rv) && dVar.x == this.x && dVar.tj == this.tj && dVar.cp == this.cp && dVar.d == this.d && dVar.oa == this.oa;
    }

    public int hashCode() {
        int iHashCode = (((((((this.l.hashCode() + 527) * 31) + this.w.hashCode()) * 31) + this.fs.hashCode()) * 31) + this.rv.hashCode()) * 31;
        long j = this.x;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.tj ? 1 : 0)) * 31) + (!this.cp ? 1 : 0)) * 31) + (!this.d ? 1 : 0)) * 31) + (!this.oa ? 1 : 0);
    }
}

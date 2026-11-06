package com.anythink.core.common.m.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    private static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private m(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = str;
        this.f = str2;
        this.g = j;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    m(a aVar) {
        if (aVar.a == null) {
            throw new NullPointerException("builder.name == null");
        }
        if (aVar.b == null) {
            throw new NullPointerException("builder.value == null");
        }
        if (aVar.d == null) {
            throw new NullPointerException("builder.domain == null");
        }
        this.e = aVar.a;
        this.f = aVar.b;
        this.g = aVar.c;
        this.h = aVar.d;
        this.i = aVar.e;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = aVar.h;
        this.m = aVar.i;
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.f;
    }

    private boolean c() {
        return this.l;
    }

    private long d() {
        return this.g;
    }

    private boolean e() {
        return this.m;
    }

    private String f() {
        return this.h;
    }

    private String g() {
        return this.i;
    }

    private boolean h() {
        return this.k;
    }

    private boolean i() {
        return this.j;
    }

    private boolean a(v vVar) {
        boolean zA;
        if (this.m) {
            zA = vVar.m.equals(this.h);
        } else {
            zA = a(vVar.m, this.h);
        }
        if (!zA) {
            return false;
        }
        String str = this.i;
        String strH = vVar.h();
        if (strH.equals(str) || (strH.startsWith(str) && (str.endsWith("/") || strH.charAt(str.length()) == '/'))) {
            return !this.j || vVar.c();
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.anythink.core.common.m.b.a.c.c(str);
    }

    private static boolean a(v vVar, String str) {
        String strH = vVar.h();
        if (strH.equals(str)) {
            return true;
        }
        if (strH.startsWith(str)) {
            return str.endsWith("/") || strH.charAt(str.length()) == '/';
        }
        return false;
    }

    private static m b(v vVar, String str) {
        return a(System.currentTimeMillis(), vVar, str);
    }

    /* JADX WARN: Code duplicated, block: B:122:0x023d A[PHI: r0
      0x023d: PHI (r0v15 long) = (r0v3 long), (r0v9 long) binds: [B:121:0x023b, B:132:0x0267] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00dc A[Catch: IllegalArgumentException -> 0x0127, TryCatch #3 {IllegalArgumentException -> 0x0127, blocks: (B:25:0x0087, B:27:0x0091, B:29:0x009d, B:47:0x0118, B:33:0x00c3, B:35:0x00cf, B:38:0x00dc, B:40:0x00e8, B:44:0x0103, B:46:0x010f), top: B:170:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e8 A[Catch: IllegalArgumentException -> 0x0127, TryCatch #3 {IllegalArgumentException -> 0x0127, blocks: (B:25:0x0087, B:27:0x0091, B:29:0x009d, B:47:0x0118, B:33:0x00c3, B:35:0x00cf, B:38:0x00dc, B:40:0x00e8, B:44:0x0103, B:46:0x010f), top: B:170:0x0087 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:42:0x0100  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v7, types: [boolean, int] */
    private static m a(long j, v vVar, String str) {
        long j2;
        long j3;
        m mVar;
        String str2;
        String strSubstring;
        char c2;
        int i;
        boolean z;
        int i2;
        int i3;
        Pattern pattern;
        String str3 = str;
        int length = str.length();
        ?? r3 = 0;
        char c3 = ';';
        int iA = com.anythink.core.common.m.b.a.c.a(str3, 0, length, ';');
        char c4 = '=';
        int iA2 = com.anythink.core.common.m.b.a.c.a(str3, 0, iA, '=');
        String str4 = null;
        if (iA2 == iA) {
            return null;
        }
        String strC = com.anythink.core.common.m.b.a.c.c(str3, 0, iA2);
        if (!strC.isEmpty()) {
            int i4 = -1;
            if (com.anythink.core.common.m.b.a.c.b(strC) == -1) {
                boolean z2 = true;
                String strC2 = com.anythink.core.common.m.b.a.c.c(str3, iA2 + 1, iA);
                if (com.anythink.core.common.m.b.a.c.b(strC2) != -1) {
                    return null;
                }
                int i5 = iA + 1;
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                String str5 = null;
                boolean z6 = true;
                long jA = -1;
                long timeInMillis = 253402300799999L;
                while (i5 < length) {
                    int iA3 = com.anythink.core.common.m.b.a.c.a(str3, i5, length, c3);
                    int iA4 = com.anythink.core.common.m.b.a.c.a(str3, i5, iA3, c4);
                    String strC3 = com.anythink.core.common.m.b.a.c.c(str3, i5, iA4);
                    String strC4 = iA4 < iA3 ? com.anythink.core.common.m.b.a.c.c(str3, iA4 + 1, iA3) : "";
                    if (strC3.equalsIgnoreCase("expires")) {
                        try {
                            int length2 = strC4.length();
                            int iA5 = a(strC4, r3, length2, r3);
                            Matcher matcher = d.matcher(strC4);
                            int iIndexOf = i4;
                            int i6 = iIndexOf;
                            int i7 = i6;
                            int i8 = i7;
                            int i9 = i8;
                            int i10 = i9;
                            ?? r9 = z2;
                            while (iA5 < length2) {
                                try {
                                    int iA6 = a(strC4, iA5 + 1, length2, r9);
                                    matcher.region(iA5, iA6);
                                    if (i6 == -1) {
                                        if (matcher.usePattern(d).matches()) {
                                            i6 = Integer.parseInt(matcher.group((int) r9));
                                            i9 = Integer.parseInt(matcher.group(2));
                                            i10 = Integer.parseInt(matcher.group(3));
                                            i8 = i8;
                                        } else {
                                            i2 = -1;
                                        }
                                        i8 = i8;
                                        iA5 = a(strC4, iA6 + 1, length2, false);
                                        r9 = 1;
                                    } else {
                                        i2 = -1;
                                    }
                                    if (i8 == i2) {
                                        if (matcher.usePattern(c).matches()) {
                                            i8 = Integer.parseInt(matcher.group(1));
                                        } else {
                                            i2 = -1;
                                            if (iIndexOf == i2) {
                                                pattern = b;
                                                if (matcher.usePattern(pattern).matches()) {
                                                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                                                } else {
                                                    i3 = -1;
                                                }
                                            } else {
                                                i3 = i2;
                                            }
                                            if (i7 == i3) {
                                                i7 = Integer.parseInt(matcher.group(1));
                                            }
                                        }
                                    } else {
                                        if (iIndexOf == i2) {
                                            pattern = b;
                                            if (matcher.usePattern(pattern).matches()) {
                                                iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                                            } else {
                                                i3 = -1;
                                            }
                                        } else {
                                            i3 = i2;
                                        }
                                        if (i7 == i3 && matcher.usePattern(a).matches()) {
                                            i7 = Integer.parseInt(matcher.group(1));
                                        }
                                    }
                                    i8 = i8;
                                    iA5 = a(strC4, iA6 + 1, length2, false);
                                    r9 = 1;
                                } catch (IllegalArgumentException unused) {
                                    i = -1;
                                    c2 = ';';
                                    z = true;
                                    i5 = iA3 + 1;
                                    i4 = i;
                                    c3 = c2;
                                    c4 = '=';
                                    str3 = str;
                                    z2 = z;
                                    r3 = 0;
                                }
                            }
                            int i11 = i8;
                            if (i7 >= 70 && i7 <= 99) {
                                i7 += 1900;
                            }
                            if (i7 >= 0 && i7 <= 69) {
                                i7 += 2000;
                            }
                            if (i7 < 1601) {
                                throw new IllegalArgumentException();
                            }
                            i = -1;
                            if (iIndexOf == -1) {
                                throw new IllegalArgumentException();
                            }
                            if (i11 <= 0 || i11 > 31) {
                                throw new IllegalArgumentException();
                            }
                            if (i6 < 0 || i6 > 23) {
                                throw new IllegalArgumentException();
                            }
                            int i12 = i9;
                            c2 = ';';
                            if (i12 < 0 || i12 > 59) {
                                throw new IllegalArgumentException();
                            }
                            int i13 = i10;
                            if (i13 < 0 || i13 > 59) {
                                throw new IllegalArgumentException();
                            }
                            try {
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(com.anythink.core.common.m.b.a.c.f);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, i7);
                                gregorianCalendar.set(2, iIndexOf - 1);
                                gregorianCalendar.set(5, i11);
                                gregorianCalendar.set(11, i6);
                                gregorianCalendar.set(12, i12);
                                gregorianCalendar.set(13, i13);
                                gregorianCalendar.set(14, 0);
                                timeInMillis = gregorianCalendar.getTimeInMillis();
                                z = true;
                                z5 = true;
                            } catch (NumberFormatException | IllegalArgumentException unused2) {
                                z = true;
                            }
                        } catch (IllegalArgumentException unused3) {
                            c2 = c3;
                            i = i4;
                        }
                    } else {
                        c2 = c3;
                        i = i4;
                        if (strC3.equalsIgnoreCase("max-age")) {
                            jA = a(strC4);
                            z = true;
                            z5 = true;
                        } else if (!strC3.equalsIgnoreCase(com.anythink.core.e.b.a.G)) {
                            z = true;
                            if (strC3.equalsIgnoreCase("path")) {
                                str5 = strC4;
                            } else if (strC3.equalsIgnoreCase("secure")) {
                                z3 = true;
                            } else if (strC3.equalsIgnoreCase("httponly")) {
                                z4 = true;
                            }
                        } else {
                            if (strC4.endsWith(com.anythink.core.common.d.i.E)) {
                                throw new IllegalArgumentException();
                            }
                            if (strC4.startsWith(com.anythink.core.common.d.i.E)) {
                                z = true;
                                try {
                                    strC4 = strC4.substring(1);
                                } catch (IllegalArgumentException unused4) {
                                    continue;
                                }
                            } else {
                                z = true;
                            }
                            String strA = com.anythink.core.common.m.b.a.c.a(strC4);
                            if (strA == null) {
                                throw new IllegalArgumentException();
                            }
                            str4 = strA;
                            z6 = false;
                        }
                    }
                    i5 = iA3 + 1;
                    i4 = i;
                    c3 = c2;
                    c4 = '=';
                    str3 = str;
                    z2 = z;
                    r3 = 0;
                }
                long j4 = Long.MIN_VALUE;
                if (jA == Long.MIN_VALUE) {
                    j2 = j4;
                } else if (jA != -1) {
                    j4 = j + (jA <= 9223372036854775L ? jA * 1000 : LongCompanionObject.MAX_VALUE);
                    if (j4 >= j) {
                        j3 = 253402300799999L;
                        if (j4 <= 253402300799999L) {
                            j2 = j4;
                        }
                    } else {
                        j3 = 253402300799999L;
                    }
                    j2 = j3;
                } else {
                    j2 = timeInMillis;
                }
                String str6 = vVar.m;
                if (str4 == null) {
                    str2 = str6;
                    mVar = null;
                } else {
                    if (!a(str6, str4)) {
                        return null;
                    }
                    mVar = null;
                    str2 = str4;
                }
                if (str6.length() != str2.length() && com.anythink.core.common.m.b.a.i.a.a().a(str2) == null) {
                    return mVar;
                }
                String str7 = str5;
                if (str7 == null || !str7.startsWith("/")) {
                    String strH = vVar.h();
                    int iLastIndexOf = strH.lastIndexOf(47);
                    strSubstring = iLastIndexOf != 0 ? strH.substring(0, iLastIndexOf) : "/";
                } else {
                    strSubstring = str7;
                }
                return new m(strC, strC2, j2, str2, strSubstring, z3, z4, z6, z5);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    private static long a(String str, int i) {
        int iA = a(str, 0, i, false);
        Matcher matcher = d.matcher(str);
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int iIndexOf = -1;
        int i5 = -1;
        int i6 = -1;
        while (iA < i) {
            int iA2 = a(str, iA + 1, i, true);
            matcher.region(iA, iA2);
            if (i3 == -1 && matcher.usePattern(d).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i5 = Integer.parseInt(matcher.group(2));
                i6 = Integer.parseInt(matcher.group(3));
            } else if (i4 == -1 && matcher.usePattern(c).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = b;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i2 != -1 && matcher.usePattern(a).matches()) {
                    i2 = Integer.parseInt(matcher.group(1));
                }
            } else if (i2 != -1) {
            }
            iA = a(str, iA2 + 1, i, false);
        }
        if (i2 >= 70 && i2 <= 99) {
            i2 += 1900;
        }
        if (i2 >= 0 && i2 <= 69) {
            i2 += 2000;
        }
        if (i2 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i4 <= 0 || i4 > 31) {
            throw new IllegalArgumentException();
        }
        if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        }
        if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.anythink.core.common.m.b.a.c.f);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i2);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i4);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i5);
        gregorianCalendar.set(13, i6);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static int a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long a(String str) {
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

    private static String b(String str) {
        if (str.endsWith(com.anythink.core.common.d.i.E)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(com.anythink.core.common.d.i.E)) {
            str = str.substring(1);
        }
        String strA = com.anythink.core.common.m.b.a.c.a(str);
        if (strA != null) {
            return strA;
        }
        throw new IllegalArgumentException();
    }

    public static List<m> a(v vVar, u uVar) {
        List<String> listB = uVar.b("Set-Cookie");
        int size = listB.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            m mVarA = a(System.currentTimeMillis(), vVar, listB.get(i));
            if (mVarA != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(mVarA);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static final class a {
        String a;
        String b;
        String d;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        long c = 253402300799999L;
        String e = "/";

        private a a(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.a = str;
            return this;
        }

        private a b(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.b = str;
            return this;
        }

        private a a(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > 253402300799999L) {
                j = 253402300799999L;
            }
            this.c = j;
            this.h = true;
            return this;
        }

        private a c(String str) {
            return a(str, false);
        }

        private a d(String str) {
            return a(str, true);
        }

        private a a(String str, boolean z) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String strA = com.anythink.core.common.m.b.a.c.a(str);
            if (strA == null) {
                throw new IllegalArgumentException("unexpected domain: ".concat(String.valueOf(str)));
            }
            this.d = strA;
            this.i = z;
            return this;
        }

        private a e(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.e = str;
            return this;
        }

        private a a() {
            this.f = true;
            return this;
        }

        private a b() {
            this.g = true;
            return this;
        }

        private m c() {
            return new m(this);
        }
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('=');
        sb.append(this.f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.anythink.core.common.m.b.a.c.d.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            sb.append(this.h);
        }
        sb.append("; path=").append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.e.equals(this.e) && mVar.f.equals(this.f) && mVar.h.equals(this.h) && mVar.i.equals(this.i) && mVar.g == this.g && mVar.j == this.j && mVar.k == this.k && mVar.l == this.l && mVar.m == this.m;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.e.hashCode() + 527) * 31) + this.f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        long j = this.g;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.j ? 1 : 0)) * 31) + (!this.k ? 1 : 0)) * 31) + (!this.l ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('=');
        sb.append(this.f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.anythink.core.common.m.b.a.c.d.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            sb.append(this.h);
        }
        sb.append("; path=").append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}

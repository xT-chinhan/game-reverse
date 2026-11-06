package com.anythink.core.common.m.b;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    private final String[] a;

    u(a aVar) {
        this.a = (String[]) aVar.a.toArray(new String[aVar.a.size()]);
    }

    private u(String[] strArr) {
        this.a = strArr;
    }

    public final String a(String str) {
        String[] strArr = this.a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    private Date d(String str) {
        String strA = a(str);
        if (strA != null) {
            return com.anythink.core.common.m.b.a.c.d.a(strA);
        }
        return null;
    }

    public final int a() {
        return this.a.length / 2;
    }

    public final String a(int i) {
        return this.a[i * 2];
    }

    public final String b(int i) {
        return this.a[(i * 2) + 1];
    }

    private Set<String> c() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int length = this.a.length / 2;
        for (int i = 0; i < length; i++) {
            treeSet.add(a(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    private long d() {
        String[] strArr = this.a;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i = 0; i < length2; i++) {
            length += (long) this.a[i].length();
        }
        return length;
    }

    public final a b() {
        a aVar = new a();
        Collections.addAll(aVar.a, this.a);
        return aVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u) && Arrays.equals(((u) obj).a, this.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.a.length / 2;
        for (int i = 0; i < length; i++) {
            sb.append(a(i)).append(": ").append(b(i)).append("\n");
        }
        return sb.toString();
    }

    private Map<String, List<String>> e() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int length = this.a.length / 2;
        for (int i = 0; i < length; i++) {
            String lowerCase = a(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(b(i));
        }
        return treeMap;
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static u a(String... strArr) {
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            String str = strArr2[i];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = str.trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str2 = strArr2[i2];
            String str3 = strArr2[i2 + 1];
            c(str2);
            a(str3, str2);
        }
        return new u(strArr2);
    }

    private static u a(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String strTrim = entry.getKey().trim();
            String strTrim2 = entry.getValue().trim();
            c(strTrim);
            a(strTrim2, strTrim);
            strArr[i] = strTrim;
            strArr[i + 1] = strTrim2;
            i += 2;
        }
        return new u(strArr);
    }

    static void c(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(com.anythink.core.common.m.b.a.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
            }
        }
    }

    static void a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(com.anythink.core.common.m.b.a.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str));
            }
        }
    }

    public static final class a {
        final List<String> a = new ArrayList(20);

        final a a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return c(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return c("", str.substring(1));
            }
            return c("", str);
        }

        private a d(String str) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(String.valueOf(str)));
            }
            return a(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1));
        }

        public final a a(String str, String str2) {
            u.c(str);
            u.a(str2, str);
            return c(str, str2);
        }

        public final a b(String str, String str2) {
            u.c(str);
            return c(str, str2);
        }

        private a a(u uVar) {
            int iA = uVar.a();
            for (int i = 0; i < iA; i++) {
                c(uVar.a(i), uVar.b(i));
            }
            return this;
        }

        private a a(String str, Date date) {
            a(str, com.anythink.core.common.m.b.a.c.d.a(date));
            return this;
        }

        private a a(String str, Instant instant) {
            if (instant == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            return a(str, new Date(instant.toEpochMilli()));
        }

        private a b(String str, Date date) {
            d(str, com.anythink.core.common.m.b.a.c.d.a(date));
            return this;
        }

        private a b(String str, Instant instant) {
            if (instant == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            d(str, com.anythink.core.common.m.b.a.c.d.a(new Date(instant.toEpochMilli())));
            return this;
        }

        final a c(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public final a b(String str) {
            int i = 0;
            while (i < this.a.size()) {
                if (str.equalsIgnoreCase(this.a.get(i))) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final a d(String str, String str2) {
            u.c(str);
            u.a(str2, str);
            b(str);
            c(str, str2);
            return this;
        }

        public final String c(String str) {
            for (int size = this.a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.a.get(size))) {
                    return this.a.get(size + 1);
                }
            }
            return null;
        }

        public final u a() {
            return new u(this);
        }
    }

    private Instant e(String str) {
        String strA = a(str);
        Date dateA = strA != null ? com.anythink.core.common.m.b.a.c.d.a(strA) : null;
        if (dateA != null) {
            return dateA.toInstant();
        }
        return null;
    }

    public final List<String> b(String str) {
        int length = this.a.length / 2;
        ArrayList arrayList = null;
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }
}

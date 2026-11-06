package com.anythink.core.common.n.b;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.UByte;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class v {
    static final String a = " \"':;<=>@[]^`{}|/\\?#";
    static final String b = " \"':;<=>@[]^`{}|/\\?#";
    static final String c = " \"<>^`{}|/\\?#";
    static final String d = "[]";
    static final String e = " \"'<>#";
    static final String f = " \"'<>#&=";
    static final String g = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String h = "\\^`{|}";
    static final String i = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String j = "";
    static final String k = " \"#<>\\^`{|}";
    private static final char[] o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String l;
    final String m;
    final int n;
    private final String p;
    private final String q;
    private final List<String> r;
    private final List<String> s;
    private final String t;
    private final String u;

    v(a aVar) {
        this.l = aVar.a;
        this.p = a(aVar.b, false);
        this.q = a(aVar.c, false);
        this.m = aVar.d;
        this.n = aVar.a();
        this.r = a(aVar.f, false);
        this.s = aVar.g != null ? a(aVar.g, true) : null;
        this.t = aVar.h != null ? a(aVar.h, false) : null;
        this.u = aVar.toString();
    }

    private URL m() {
        try {
            return new URL(this.u);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final String b() {
        return this.l;
    }

    public final boolean c() {
        return this.l.equals("https");
    }

    public final String d() {
        if (this.p.isEmpty()) {
            return "";
        }
        int length = this.l.length() + 3;
        String str = this.u;
        return this.u.substring(length, com.anythink.core.common.n.b.a.c.a(str, length, str.length(), ":@"));
    }

    private String n() {
        return this.p;
    }

    public final String e() {
        if (this.q.isEmpty()) {
            return "";
        }
        return this.u.substring(this.u.indexOf(58, this.l.length() + 3) + 1, this.u.indexOf(64));
    }

    private String o() {
        return this.q;
    }

    public final String f() {
        return this.m;
    }

    public final int g() {
        return this.n;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    private int p() {
        return this.r.size();
    }

    public final String h() {
        int iIndexOf = this.u.indexOf(47, this.l.length() + 3);
        String str = this.u;
        return this.u.substring(iIndexOf, com.anythink.core.common.n.b.a.c.a(str, iIndexOf, str.length(), "?#"));
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public final List<String> i() {
        int iIndexOf = this.u.indexOf(47, this.l.length() + 3);
        String str = this.u;
        int iA = com.anythink.core.common.n.b.a.c.a(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iA) {
            int i2 = iIndexOf + 1;
            int iA2 = com.anythink.core.common.n.b.a.c.a(this.u, i2, iA, '/');
            arrayList.add(this.u.substring(i2, iA2));
            iIndexOf = iA2;
        }
        return arrayList;
    }

    private List<String> q() {
        return this.r;
    }

    public final String j() {
        if (this.s == null) {
            return null;
        }
        int iIndexOf = this.u.indexOf(63) + 1;
        String str = this.u;
        return this.u.substring(iIndexOf, com.anythink.core.common.n.b.a.c.a(str, iIndexOf, str.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iIndexOf = str.indexOf(38, i2);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i2);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i2, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i2 = iIndexOf + 1;
        }
        return arrayList;
    }

    public final String k() {
        if (this.s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.s);
        return sb.toString();
    }

    private int r() {
        List<String> list = this.s;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    private String e(String str) {
        List<String> list = this.s;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.s.get(i2))) {
                return this.s.get(i2 + 1);
            }
        }
        return null;
    }

    private Set<String> s() {
        if (this.s == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            linkedHashSet.add(this.s.get(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private List<String> f(String str) {
        if (this.s == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.s.get(i2))) {
                arrayList.add(this.s.get(i2 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private String a(int i2) {
        List<String> list = this.s;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get(i2 * 2);
    }

    private String b(int i2) {
        List<String> list = this.s;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get((i2 * 2) + 1);
    }

    private String t() {
        if (this.t == null) {
            return null;
        }
        return this.u.substring(this.u.indexOf(35) + 1);
    }

    private String u() {
        return this.t;
    }

    public final String l() {
        a aVarG = g("/...");
        aVarG.b = a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        aVarG.c = a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return aVarG.b().toString();
    }

    public final v c(String str) {
        a aVarG = g(str);
        if (aVarG != null) {
            return aVarG.b();
        }
        return null;
    }

    private a v() {
        String strSubstring;
        a aVar = new a();
        aVar.a = this.l;
        aVar.b = d();
        aVar.c = e();
        aVar.d = this.m;
        aVar.e = this.n != a(this.l) ? this.n : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.b(j());
        if (this.t == null) {
            strSubstring = null;
        } else {
            strSubstring = this.u.substring(this.u.indexOf(35) + 1);
        }
        aVar.h = strSubstring;
        return aVar;
    }

    private a g(String str) {
        try {
            return new a().a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static v h(String str) {
        try {
            return d(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static v d(String str) {
        return new a().a((v) null, str).b();
    }

    private static v a(URL url) {
        return h(url.toString());
    }

    private static v a(URI uri) {
        return h(uri.toString());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof v) && ((v) obj).u.equals(this.u);
    }

    public final int hashCode() {
        return this.u.hashCode();
    }

    public final String toString() {
        return this.u;
    }

    private String w() {
        if (com.anythink.core.common.n.b.a.c.c(this.m)) {
            return null;
        }
        return com.anythink.core.common.n.b.a.i.a.a().a(this.m);
    }

    public static final class a {
        static final String i = "Invalid URL host";
        String a;
        String d;
        final List<String> f;
        List<String> g;
        String h;
        String b = "";
        String c = "";
        int e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private a c(String str) {
            if (str.equalsIgnoreCase("http")) {
                this.a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str)));
            }
            return this;
        }

        private a d(String str) {
            this.b = v.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        private a e(String str) {
            if (str == null) {
                throw new NullPointerException("encodedUsername == null");
            }
            this.b = v.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        private a f(String str) {
            this.c = v.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        private a g(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPassword == null");
            }
            this.c = v.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public final a a(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strE = e(str, 0, str.length());
            if (strE == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(str)));
            }
            this.d = strE;
            return this;
        }

        private a a(int i2) {
            if (i2 <= 0 || i2 > 65535) {
                throw new IllegalArgumentException("unexpected port: ".concat(String.valueOf(i2)));
            }
            this.e = i2;
            return this;
        }

        final int a() {
            int i2 = this.e;
            return i2 != -1 ? i2 : v.a(this.a);
        }

        private a h(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            a(str, 0, str.length(), false, false);
            return this;
        }

        private a i(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegments == null");
            }
            return a(str, false);
        }

        private a j(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            a(str, 0, str.length(), false, true);
            return this;
        }

        private a k(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegments == null");
            }
            return a(str, true);
        }

        private a a(String str, boolean z) {
            int i2 = 0;
            do {
                int iA = com.anythink.core.common.n.b.a.c.a(str, i2, str.length(), "/\\");
                a(str, i2, iA, iA < str.length(), z);
                i2 = iA + 1;
            } while (i2 <= str.length());
            return this;
        }

        private a a(int i2, String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            String strA = v.a(str, 0, str.length(), v.c, false, false, false, true, null);
            if (s(strA) || t(strA)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(String.valueOf(str)));
            }
            this.f.set(i2, strA);
            return this;
        }

        private a b(int i2, String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            String strA = v.a(str, 0, str.length(), v.c, true, false, false, true, null);
            this.f.set(i2, strA);
            if (s(strA) || t(strA)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(String.valueOf(str)));
            }
            return this;
        }

        private a b(int i2) {
            this.f.remove(i2);
            if (this.f.isEmpty()) {
                this.f.add("");
            }
            return this;
        }

        private a l(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            }
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(String.valueOf(str)));
            }
            a(str, 0, str.length());
            return this;
        }

        private a m(String str) {
            this.g = str != null ? v.b(v.a(str, v.e, false, false, true, true)) : null;
            return this;
        }

        public final a b(String str) {
            this.g = str != null ? v.b(v.a(str, v.e, true, false, true, true)) : null;
            return this;
        }

        private a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.g, false, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.g, false, false, true, true) : null);
            return this;
        }

        private a b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.f, true, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.f, true, false, true, true) : null);
            return this;
        }

        private a n(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g == null) {
                return this;
            }
            p(v.a(str, v.g, false, false, true, true));
            return this;
        }

        private a o(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                return this;
            }
            p(v.a(str, v.f, true, false, true, true));
            return this;
        }

        private void p(String str) {
            for (int size = this.g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.g.get(size))) {
                    this.g.remove(size + 1);
                    this.g.remove(size);
                    if (this.g.isEmpty()) {
                        this.g = null;
                        return;
                    }
                }
            }
        }

        private a q(String str) {
            this.h = str != null ? v.a(str, "", false, false, false, false) : null;
            return this;
        }

        private a r(String str) {
            this.h = str != null ? v.a(str, "", true, false, false, false) : null;
            return this;
        }

        private a c() {
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f.set(i2, v.a(this.f.get(i2), v.d, true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.g.get(i3);
                    if (str != null) {
                        this.g.set(i3, v.a(str, v.h, true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = v.a(str2, v.k, true, true, false, false);
            }
            return this;
        }

        public final v b() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new v(this);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(this.d);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int iA = a();
                String str3 = this.a;
                if (str3 == null || iA != v.a(str3)) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(iA);
                }
            }
            v.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                v.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        final a a(v vVar, String str) {
            int i2;
            int iA;
            int i3;
            char c;
            char cCharAt;
            int iA2 = com.anythink.core.common.n.b.a.c.a(str, 0, str.length());
            int iB = com.anythink.core.common.n.b.a.c.b(str, iA2, str.length());
            int i4 = iB - iA2;
            char c2 = AbstractJsonLexerKt.COLON;
            byte b = -1;
            if (i4 >= 2 && (((cCharAt = str.charAt(iA2)) >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                int i5 = iA2 + 1;
                while (true) {
                    if (i5 < iB) {
                        char cCharAt2 = str.charAt(i5);
                        if ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || ((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '+' || cCharAt2 == '-' || cCharAt2 == '.'))) {
                            i5++;
                        } else if (cCharAt2 == ':') {
                            i2 = i5;
                            break;
                        }
                    }
                    i2 = -1;
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
            if (i2 != -1) {
                if (str.regionMatches(true, iA2, "https:", 0, 6)) {
                    this.a = "https";
                    iA2 += 6;
                } else if (str.regionMatches(true, iA2, "http:", 0, 5)) {
                    this.a = "http";
                    iA2 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, i2) + "'");
                }
            } else if (vVar != null) {
                this.a = vVar.l;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int iC = c(str, iA2, iB);
            byte b2 = com.anythink.core.common.s.a.c.c;
            byte b3 = 35;
            if (iC >= 2 || vVar == null || !vVar.l.equals(this.a)) {
                boolean z = false;
                boolean z2 = false;
                int i6 = iA2 + iC;
                while (true) {
                    iA = com.anythink.core.common.n.b.a.c.a(str, i6, iB, "@/\\?#");
                    byte bCharAt = iA != iB ? str.charAt(iA) : b;
                    if (bCharAt == b || bCharAt == b3 || bCharAt == 47 || bCharAt == 92 || bCharAt == b2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iA3 = com.anythink.core.common.n.b.a.c.a(str, i6, iA, c2);
                            i3 = iA;
                            String strA = v.a(str, i6, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strA = this.b + "%40" + strA;
                            }
                            this.b = strA;
                            if (iA3 != i3) {
                                this.c = v.a(str, iA3 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i3 = iA;
                            this.c += "%40" + v.a(str, i6, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i6 = i3 + 1;
                        b3 = 35;
                        c2 = AbstractJsonLexerKt.COLON;
                        b = -1;
                        b2 = com.anythink.core.common.s.a.c.c;
                    }
                }
                int iD = d(str, i6, iA);
                int i7 = iD + 1;
                if (i7 < iA) {
                    this.d = e(str, i6, iD);
                    int iF = f(str, i7, iA);
                    this.e = iF;
                    if (iF == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i7, iA) + '\"');
                    }
                } else {
                    this.d = e(str, i6, iD);
                    this.e = v.a(this.a);
                }
                if (this.d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i6, iD) + '\"');
                }
                iA2 = iA;
            } else {
                this.b = vVar.d();
                this.c = vVar.e();
                this.d = vVar.m;
                this.e = vVar.n;
                this.f.clear();
                this.f.addAll(vVar.i());
                if (iA2 == iB || str.charAt(iA2) == '#') {
                    b(vVar.j());
                }
            }
            int iA4 = com.anythink.core.common.n.b.a.c.a(str, iA2, iB, "?#");
            a(str, iA2, iA4);
            if (iA4 >= iB || str.charAt(iA4) != '?') {
                c = '#';
            } else {
                c = '#';
                int iA5 = com.anythink.core.common.n.b.a.c.a(str, iA4, iB, '#');
                this.g = v.b(v.a(str, iA4 + 1, iA5, v.e, true, false, true, true, null));
                iA4 = iA5;
            }
            if (iA4 < iB && str.charAt(iA4) == c) {
                this.h = v.a(str, iA4 + 1, iB, "", true, false, false, false, null);
            }
            return this;
        }

        private void a(String str, int i2, int i3) {
            if (i2 == i3) {
                return;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f.clear();
                this.f.add("");
                i2++;
            } else {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i4 = i2;
                if (i4 >= i3) {
                    return;
                }
                i2 = com.anythink.core.common.n.b.a.c.a(str, i4, i3, "/\\");
                boolean z = i2 < i3;
                a(str, i4, i2, z, true);
                if (z) {
                    i2++;
                }
            }
        }

        private void a(String str, int i2, int i3, boolean z, boolean z2) {
            String strA = v.a(str, i2, i3, v.c, z2, false, false, true, null);
            if (s(strA)) {
                return;
            }
            if (t(strA)) {
                d();
                return;
            }
            List<String> list = this.f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, strA);
            } else {
                this.f.add(strA);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static boolean s(String str) {
            return str.equals(com.anythink.core.common.d.j.z) || str.equalsIgnoreCase("%2e");
        }

        private static boolean t(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            List<String> list = this.f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f.isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, "");
            } else {
                this.f.add("");
            }
        }

        private static int b(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i2);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private static int d(String str, int i2, int i3) {
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == ':') {
                    return i2;
                }
                if (cCharAt == '[') {
                    do {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        private static String e(String str, int i2, int i3) {
            return com.anythink.core.common.n.b.a.c.a(v.a(str, i2, i3, false));
        }

        private static int f(String str, int i2, int i3) {
            try {
                int i4 = Integer.parseInt(v.a(str, i2, i3, "", false, false, false, true, null));
                if (i4 <= 0 || i4 > 65535) {
                    return -1;
                }
                return i4;
            } catch (NumberFormatException unused) {
            }
        }

        private a c(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g != null) {
                p(v.a(str, v.g, false, false, true, true));
            }
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.g, false, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.g, false, false, true, true) : null);
            return this;
        }

        private a d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g != null) {
                p(v.a(str, v.f, true, false, true, true));
            }
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(v.a(str, v.f, true, false, true, true));
            this.g.add(str2 != null ? v.a(str2, v.f, true, false, true, true) : null);
            return this;
        }
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private static List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.anythink.core.common.n.c.c cVar = new com.anythink.core.common.n.c.c();
                cVar.b(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.u();
            }
        }
        return str.substring(i2, i3);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    private static void a(com.anythink.core.common.n.c.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (iCodePointAt == 37 && (i4 = i2 + 2) < i3) {
                int iA = com.anythink.core.common.n.b.a.c.a(str.charAt(i2 + 1));
                int iA2 = com.anythink.core.common.n.b.a.c.a(str.charAt(i4));
                if (iA != -1 && iA2 != -1) {
                    cVar.l((iA << 4) + iA2);
                    i2 = i4;
                } else {
                    cVar.m(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                cVar.l(32);
            } else {
                cVar.m(iCodePointAt);
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    private static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && com.anythink.core.common.n.b.a.c.a(str.charAt(i2 + 1)) != -1 && com.anythink.core.common.n.b.a.c.a(str.charAt(i4)) != -1;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i2;
        while (iCharCount < i3) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i4 = 43;
            if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || a(str, iCharCount, i3)))) && (iCodePointAt != 43 || !z3)))) {
                iCharCount += Character.charCount(iCodePointAt);
            } else {
                com.anythink.core.common.n.c.c cVar = new com.anythink.core.common.n.c.c();
                cVar.b(str, i2, iCharCount);
                com.anythink.core.common.n.c.c cVar2 = null;
                while (iCharCount < i3) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == i4 && z3) {
                            cVar.b(z ? "+" : "%2B");
                        } else if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || ((iCodePointAt2 >= 128 && z4) || str2.indexOf(iCodePointAt2) != -1 || (iCodePointAt2 == 37 && (!z || (z2 && !a(str, iCharCount, i3)))))) {
                            if (cVar2 == null) {
                                cVar2 = new com.anythink.core.common.n.c.c();
                            }
                            if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                                cVar2.m(iCodePointAt2);
                            } else {
                                cVar2.b(str, iCharCount, Character.charCount(iCodePointAt2) + iCharCount, charset);
                            }
                            while (!cVar2.g()) {
                                int iK = cVar2.k() & UByte.MAX_VALUE;
                                cVar.l(37);
                                char[] cArr = o;
                                cVar.l((int) cArr[(iK >> 4) & 15]);
                                cVar.l((int) cArr[iK & 15]);
                            }
                        } else {
                            cVar.m(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i4 = 43;
                }
                return cVar.u();
            }
        }
        return str.substring(i2, i3);
    }

    private static void a(com.anythink.core.common.n.c.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.anythink.core.common.n.c.c cVar2 = null;
        while (i2 < i3) {
            int iCodePointAt = str.codePointAt(i2);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    cVar.b(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new com.anythink.core.common.n.c.c();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        cVar2.m(iCodePointAt);
                    } else {
                        cVar2.b(str, i2, Character.charCount(iCodePointAt) + i2, charset);
                    }
                    while (!cVar2.g()) {
                        int iK = cVar2.k() & UByte.MAX_VALUE;
                        cVar.l(37);
                        char[] cArr = o;
                        cVar.l((int) cArr[(iK >> 4) & 15]);
                        cVar.l((int) cArr[iK & 15]);
                    }
                } else {
                    cVar.m(iCodePointAt);
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    static String a(String str, String str2, boolean z, Charset charset) {
        return a(str, 0, str.length(), str2, z, false, true, true, charset);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    public final URI a() {
        a aVar = new a();
        aVar.a = this.l;
        aVar.b = d();
        aVar.c = e();
        aVar.d = this.m;
        aVar.e = this.n != a(this.l) ? this.n : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.b(j());
        aVar.h = this.t == null ? null : this.u.substring(this.u.indexOf(35) + 1);
        int size = aVar.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            aVar.f.set(i2, a(aVar.f.get(i2), d, true, true, false, true));
        }
        if (aVar.g != null) {
            int size2 = aVar.g.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str = aVar.g.get(i3);
                if (str != null) {
                    aVar.g.set(i3, a(str, h, true, true, true, true));
                }
            }
        }
        if (aVar.h != null) {
            aVar.h = a(aVar.h, k, true, true, false, false);
        }
        String string = aVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }
}

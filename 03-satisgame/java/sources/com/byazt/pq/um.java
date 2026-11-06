package com.byazt.pq;

import com.anythink.core.common.d.i;
import com.byazt.ho.BaseConstants;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 33})
public final class um {
    public static final char[] q = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final List<String> fs;
    public final String l;
    public final String n;
    public final String qg;
    public final String rv;
    public final int s;
    public final String tj;
    public final String w;
    public final List<String> x;

    public um(n nVar) {
        this.n = nVar.n;
        this.l = n(nVar.qg, false);
        this.w = n(nVar.s, false);
        this.qg = nVar.q;
        this.s = nVar.n();
        this.x = n(nVar.w, false);
        this.fs = nVar.x != null ? n(nVar.x, true) : null;
        this.rv = nVar.fs != null ? n(nVar.fs, false) : null;
        this.tj = nVar.toString();
    }

    public URI n() {
        String string = oa().qg().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String qg() {
        return this.n;
    }

    public boolean s() {
        return BaseConstants.SCHEME_HTTPS.equals(this.n);
    }

    public String q() {
        if (this.l.isEmpty()) {
            return "";
        }
        int length = this.n.length() + 3;
        String str = this.tj;
        return this.tj.substring(length, com.byazt.zho.s.n(str, length, str.length(), ":@"));
    }

    public String l() {
        if (this.w.isEmpty()) {
            return "";
        }
        return this.tj.substring(this.tj.indexOf(58, this.n.length() + 3) + 1, this.tj.indexOf(64));
    }

    public String w() {
        return this.qg;
    }

    public int x() {
        return this.s;
    }

    public static int n(String str) {
        if ("http".equals(str)) {
            return 80;
        }
        return BaseConstants.SCHEME_HTTPS.equals(str) ? 443 : -1;
    }

    public String fs() {
        int iIndexOf = this.tj.indexOf(47, this.n.length() + 3);
        String str = this.tj;
        return this.tj.substring(iIndexOf, com.byazt.zho.s.n(str, iIndexOf, str.length(), "?#"));
    }

    public static void n(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> rv() {
        int iIndexOf = this.tj.indexOf(47, this.n.length() + 3);
        String str = this.tj;
        int iN = com.byazt.zho.s.n(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iN) {
            int i = iIndexOf + 1;
            int iN2 = com.byazt.zho.s.n(this.tj, i, iN, '/');
            arrayList.add(this.tj.substring(i, iN2));
            iIndexOf = iN2;
        }
        return arrayList;
    }

    public String tj() {
        if (this.fs == null) {
            return null;
        }
        int iIndexOf = this.tj.indexOf(63) + 1;
        String str = this.tj;
        return this.tj.substring(iIndexOf, com.byazt.zho.s.n(str, iIndexOf, str.length(), '#'));
    }

    public static void qg(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static List<String> qg(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public String query() {
        if (this.fs == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        qg(sb, this.fs);
        return sb.toString();
    }

    public String cp() {
        if (this.rv == null) {
            return null;
        }
        return this.tj.substring(this.tj.indexOf(35) + 1);
    }

    public String d() {
        return q("/...").qg("").s("").s().toString();
    }

    public um s(String str) {
        n nVarQ = q(str);
        if (nVarQ != null) {
            return nVarQ.s();
        }
        return null;
    }

    public n oa() {
        n nVar = new n();
        nVar.n = this.n;
        nVar.qg = q();
        nVar.s = l();
        nVar.q = this.qg;
        nVar.l = this.s != n(this.n) ? this.s : -1;
        nVar.w.clear();
        nVar.w.addAll(rv());
        nVar.l(tj());
        nVar.fs = cp();
        return nVar;
    }

    public n q(String str) {
        n nVar = new n();
        if (nVar.n(this, str) == n.EnumC0303n.SUCCESS) {
            return nVar;
        }
        return null;
    }

    public static um l(String str) {
        n nVar = new n();
        if (nVar.n(null, str) == n.EnumC0303n.SUCCESS) {
            return nVar.s();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof um) && ((um) obj).tj.equals(this.tj);
    }

    public int hashCode() {
        return this.tj.hashCode();
    }

    public String toString() {
        return this.tj;
    }

    @com.byazt.cp.n(n = {0, 1, 109, 1217})
    public static final class n {
        public String fs;
        public String n;
        public String q;
        public final List<String> w;
        public List<String> x;
        public String qg = "";
        public String s = "";
        public int l = -1;

        /* JADX INFO: renamed from: com.byazt.pq.um$n$n, reason: collision with other inner class name */
        enum EnumC0303n {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public n() {
            ArrayList arrayList = new ArrayList();
            this.w = arrayList;
            arrayList.add("");
        }

        public n n(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if ("http".equalsIgnoreCase(str)) {
                this.n = "http";
            } else if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(str)) {
                this.n = BaseConstants.SCHEME_HTTPS;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public n qg(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.qg = um.n(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public n s(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.s = um.n(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public n q(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strL = l(str, 0, str.length());
            if (strL == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.q = strL;
            return this;
        }

        public n n(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.l = i;
            return this;
        }

        public int n() {
            int i = this.l;
            return i != -1 ? i : um.n(this.n);
        }

        public n query(String str) {
            this.x = str != null ? um.qg(um.n(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public n l(String str) {
            this.x = str != null ? um.qg(um.n(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public n qg() {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                this.w.set(i, um.n(this.w.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.x;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.x.get(i2);
                    if (str != null) {
                        this.x.set(i2, um.n(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.fs;
            if (str2 != null) {
                this.fs = um.n(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public um s() {
            if (this.n == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.q == null) {
                throw new IllegalStateException("host == null");
            }
            return new um(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.n);
            sb.append("://");
            if (!this.qg.isEmpty() || !this.s.isEmpty()) {
                sb.append(this.qg);
                if (!this.s.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.s);
                }
                sb.append('@');
            }
            if (this.q.indexOf(58) != -1) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(this.q);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(this.q);
            }
            int iN = n();
            if (iN != um.n(this.n)) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(iN);
            }
            um.n(sb, this.w);
            if (this.x != null) {
                sb.append('?');
                um.qg(sb, this.x);
            }
            if (this.fs != null) {
                sb.append('#');
                sb.append(this.fs);
            }
            return sb.toString();
        }

        public EnumC0303n n(um umVar, String str) {
            int iN;
            int i;
            int iN2 = com.byazt.zho.s.n(str, 0, str.length());
            int iQg = com.byazt.zho.s.qg(str, iN2, str.length());
            if (qg(str, iN2, iQg) != -1) {
                if (str.regionMatches(true, iN2, "https:", 0, 6)) {
                    this.n = BaseConstants.SCHEME_HTTPS;
                    iN2 += 6;
                } else if (str.regionMatches(true, iN2, "http:", 0, 5)) {
                    this.n = "http";
                    iN2 += 5;
                } else {
                    return EnumC0303n.UNSUPPORTED_SCHEME;
                }
            } else if (umVar != null) {
                this.n = umVar.n;
            } else {
                return EnumC0303n.MISSING_SCHEME;
            }
            int iS = s(str, iN2, iQg);
            char c = '?';
            char c2 = '#';
            if (iS >= 2 || umVar == null || !umVar.n.equals(this.n)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = iN2 + iS;
                while (true) {
                    iN = com.byazt.zho.s.n(str, i2, iQg, "@/\\?#");
                    byte bCharAt = iN != iQg ? str.charAt(iN) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iN3 = com.byazt.zho.s.n(str, i2, iN, AbstractJsonLexerKt.COLON);
                            i = iN;
                            String strN = um.n(str, i2, iN3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strN = this.qg + "%40" + strN;
                            }
                            this.qg = strN;
                            if (iN3 != i) {
                                this.s = um.n(str, iN3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iN;
                            this.s += "%40" + um.n(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iQ = q(str, i2, iN);
                int i3 = iQ + 1;
                if (i3 < iN) {
                    this.q = l(str, i2, iQ);
                    int iW = w(str, i3, iN);
                    this.l = iW;
                    if (iW == -1) {
                        return EnumC0303n.INVALID_PORT;
                    }
                } else {
                    this.q = l(str, i2, iQ);
                    this.l = um.n(this.n);
                }
                if (this.q == null) {
                    return EnumC0303n.INVALID_HOST;
                }
                iN2 = iN;
            } else {
                this.qg = umVar.q();
                this.s = umVar.l();
                this.q = umVar.qg;
                this.l = umVar.s;
                this.w.clear();
                this.w.addAll(umVar.rv());
                if (iN2 == iQg || str.charAt(iN2) == '#') {
                    l(umVar.tj());
                }
            }
            int iN4 = com.byazt.zho.s.n(str, iN2, iQg, "?#");
            n(str, iN2, iN4);
            if (iN4 < iQg && str.charAt(iN4) == '?') {
                int iN5 = com.byazt.zho.s.n(str, iN4, iQg, '#');
                this.x = um.qg(um.n(str, iN4 + 1, iN5, " \"'<>#", true, false, true, true, null));
                iN4 = iN5;
            }
            if (iN4 < iQg && str.charAt(iN4) == '#') {
                this.fs = um.n(str, 1 + iN4, iQg, "", true, false, false, false, null);
            }
            return EnumC0303n.SUCCESS;
        }

        private void n(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.w.clear();
                this.w.add("");
                i++;
            } else {
                List<String> list = this.w;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.byazt.zho.s.n(str, i3, i2, "/\\");
                boolean z = i < i2;
                n(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void n(String str, int i, int i2, boolean z, boolean z2) {
            String strN = um.n(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (w(strN)) {
                return;
            }
            if (x(strN)) {
                q();
                return;
            }
            List<String> list = this.w;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.w;
                list2.set(list2.size() - 1, strN);
            } else {
                this.w.add(strN);
            }
            if (z) {
                this.w.add("");
            }
        }

        private boolean w(String str) {
            return i.E.equals(str) || "%2e".equalsIgnoreCase(str);
        }

        private boolean x(String str) {
            return "..".equals(str) || "%2e. ".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
        }

        private void q() {
            List<String> list = this.w;
            if (list.remove(list.size() - 1).isEmpty() && !this.w.isEmpty()) {
                List<String> list2 = this.w;
                list2.set(list2.size() - 1, "");
            } else {
                this.w.add("");
            }
        }

        private static int qg(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int s(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int q(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String l(String str, int i, int i2) {
            return com.byazt.zho.s.n(um.n(str, i, i2, false));
        }

        private static int w(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(um.n(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static String n(String str, boolean z) {
        return n(str, 0, str.length(), z);
    }

    private List<String> n(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? n(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String n(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.byazt.wa.s sVar = new com.byazt.wa.s();
                sVar.n(str, i, i3);
                n(sVar, str, i3, i2, z);
                return sVar.k();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public static void n(com.byazt.wa.s sVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iN = com.byazt.zho.s.n(str.charAt(i + 1));
                int iN2 = com.byazt.zho.s.n(str.charAt(i3));
                if (iN != -1 && iN2 != -1) {
                    sVar.rv((iN << 4) + iN2);
                    i = i3;
                } else {
                    sVar.n(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                sVar.rv(32);
            } else {
                sVar.n(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static boolean n(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.byazt.zho.s.n(str.charAt(i + 1)) != -1 && com.byazt.zho.s.n(str.charAt(i3)) != -1;
    }

    public static String n(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || n(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            com.byazt.wa.s sVar = new com.byazt.wa.s();
            sVar.n(str, i, iCharCount);
            n(sVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return sVar.k();
        }
        return str.substring(i, i2);
    }

    public static void n(com.byazt.wa.s sVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.byazt.wa.s sVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    sVar.qg(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !n(str, i, i2)))))) {
                    if (sVar2 == null) {
                        sVar2 = new com.byazt.wa.s();
                    }
                    if (charset == null || charset.equals(com.byazt.zho.s.l)) {
                        sVar2.n(iCodePointAt);
                    } else {
                        sVar2.n(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!sVar2.l()) {
                        int iFs = sVar2.fs() & UByte.MAX_VALUE;
                        sVar.rv(37);
                        char[] cArr = q;
                        sVar.rv((int) cArr[(iFs >> 4) & 15]);
                        sVar.rv((int) cArr[iFs & 15]);
                    }
                } else {
                    sVar.n(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static String n(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return n(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

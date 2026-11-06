package com.bytedance.sdk.component.ah.xr;

import com.anythink.core.common.d.j;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final List<String> ab;
    final int ah;
    private final String c;
    private final String ch;
    private final String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final String f1147ms;
    private final String ny;
    private final List<String> x;
    final String xr;

    y(ms msVar) {
        this.f1147ms = msVar.f1148ms;
        this.ka = ms(msVar.xr, false);
        this.c = ms(msVar.ah, false);
        this.xr = msVar.d;
        this.ah = msVar.ms();
        this.ab = ms(msVar.c, false);
        this.x = msVar.ab != null ? ms(msVar.ab, true) : null;
        this.ny = msVar.x != null ? ms(msVar.x, false) : null;
        this.ch = msVar.toString();
    }

    public URL ms() {
        try {
            return new URL(this.ch);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URI xr() {
        String string = u().xr().toString();
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

    public String ah() {
        return this.f1147ms;
    }

    public boolean d() {
        return this.f1147ms.equals("https");
    }

    public String ka() {
        if (this.ka.isEmpty()) {
            return "";
        }
        int length = this.f1147ms.length() + 3;
        String str = this.ch;
        return this.ch.substring(length, com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, length, str.length(), ":@"));
    }

    public String c() {
        if (this.c.isEmpty()) {
            return "";
        }
        return this.ch.substring(this.ch.indexOf(58, this.f1147ms.length() + 3) + 1, this.ch.indexOf(64));
    }

    public String ab() {
        return this.xr;
    }

    public int x() {
        return this.ah;
    }

    public static int ms(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String ny() {
        int iIndexOf = this.ch.indexOf(47, this.f1147ms.length() + 3);
        String str = this.ch;
        return this.ch.substring(iIndexOf, com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, iIndexOf, str.length(), "?#"));
    }

    static void ms(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> ch() {
        int iIndexOf = this.ch.indexOf(47, this.f1147ms.length() + 3);
        String str = this.ch;
        int iMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iMs) {
            int i = iIndexOf + 1;
            int iMs2 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ch, i, iMs, '/');
            arrayList.add(this.ch.substring(i, iMs2));
            iIndexOf = iMs2;
        }
        return arrayList;
    }

    public String hi() {
        if (this.x == null) {
            return null;
        }
        int iIndexOf = this.ch.indexOf(63) + 1;
        String str = this.ch;
        return this.ch.substring(iIndexOf, com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, iIndexOf, str.length(), '#'));
    }

    static void xr(StringBuilder sb, List<String> list) {
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

    static List<String> xr(String str) {
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
        if (this.x == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        xr(sb, this.x);
        return sb.toString();
    }

    public String sl() {
        if (this.ny == null) {
            return null;
        }
        return this.ch.substring(this.ch.indexOf(35) + 1);
    }

    public String zb() {
        return d("/...").xr("").ah("").ah().toString();
    }

    public y ah(String str) {
        ms msVarD = d(str);
        if (msVarD != null) {
            return msVarD.ah();
        }
        return null;
    }

    public ms u() {
        ms msVar = new ms();
        msVar.f1148ms = this.f1147ms;
        msVar.xr = ka();
        msVar.ah = c();
        msVar.d = this.xr;
        msVar.ka = this.ah != ms(this.f1147ms) ? this.ah : -1;
        msVar.c.clear();
        msVar.c.addAll(ch());
        msVar.ka(hi());
        msVar.x = sl();
        return msVar;
    }

    public ms d(String str) {
        ms msVar = new ms();
        if (msVar.ms(this, str) == ms.EnumC0242ms.SUCCESS) {
            return msVar;
        }
        return null;
    }

    public static y ka(String str) {
        ms msVar = new ms();
        if (msVar.ms(null, str) == ms.EnumC0242ms.SUCCESS) {
            return msVar.ah();
        }
        return null;
    }

    public static y ms(URL url) {
        return ka(url.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof y) && ((y) obj).ch.equals(this.ch);
    }

    public int hashCode() {
        return this.ch.hashCode();
    }

    public String toString() {
        return this.ch;
    }

    public static final class ms {
        List<String> ab;
        final List<String> c;
        String d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f1148ms;
        String x;
        String xr = "";
        String ah = "";
        int ka = -1;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.ah.xr.y$ms$ms, reason: collision with other inner class name */
        enum EnumC0242ms {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public ms() {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add("");
        }

        public ms ms(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f1148ms = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f1148ms = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public ms xr(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.xr = y.ms(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public ms ah(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.ah = y.ms(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public ms d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strKa = ka(str, 0, str.length());
            if (strKa == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.d = strKa;
            return this;
        }

        public ms ms(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.ka = i;
            return this;
        }

        int ms() {
            int i = this.ka;
            return i != -1 ? i : y.ms(this.f1148ms);
        }

        public ms query(String str) {
            this.ab = str != null ? y.xr(y.ms(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public ms ka(String str) {
            this.ab = str != null ? y.xr(y.ms(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        ms xr() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.set(i, y.ms(this.c.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.ab;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.ab.get(i2);
                    if (str != null) {
                        this.ab.set(i2, y.ms(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.x;
            if (str2 != null) {
                this.x = y.ms(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public y ah() {
            if (this.f1148ms == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new y(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1148ms);
            sb.append("://");
            if (!this.xr.isEmpty() || !this.ah.isEmpty()) {
                sb.append(this.xr);
                if (!this.ah.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.ah);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(this.d);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(this.d);
            }
            int iMs = ms();
            if (iMs != y.ms(this.f1148ms)) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(iMs);
            }
            y.ms(sb, this.c);
            if (this.ab != null) {
                sb.append('?');
                y.xr(sb, this.ab);
            }
            if (this.x != null) {
                sb.append('#');
                sb.append(this.x);
            }
            return sb.toString();
        }

        EnumC0242ms ms(y yVar, String str) {
            int iMs;
            int i;
            int iMs2 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, 0, str.length());
            int iXr = com.bytedance.sdk.component.ah.xr.ms.ah.xr(str, iMs2, str.length());
            if (xr(str, iMs2, iXr) != -1) {
                if (str.regionMatches(true, iMs2, "https:", 0, 6)) {
                    this.f1148ms = "https";
                    iMs2 += 6;
                } else if (str.regionMatches(true, iMs2, "http:", 0, 5)) {
                    this.f1148ms = "http";
                    iMs2 += 5;
                } else {
                    return EnumC0242ms.UNSUPPORTED_SCHEME;
                }
            } else if (yVar != null) {
                this.f1148ms = yVar.f1147ms;
            } else {
                return EnumC0242ms.MISSING_SCHEME;
            }
            int iAh = ah(str, iMs2, iXr);
            char c = '?';
            char c2 = '#';
            if (iAh >= 2 || yVar == null || !yVar.f1147ms.equals(this.f1148ms)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = iMs2 + iAh;
                while (true) {
                    iMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, i2, iXr, "@/\\?#");
                    byte bCharAt = iMs != iXr ? str.charAt(iMs) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iMs3 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, i2, iMs, AbstractJsonLexerKt.COLON);
                            i = iMs;
                            String strMs = y.ms(str, i2, iMs3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strMs = this.xr + "%40" + strMs;
                            }
                            this.xr = strMs;
                            if (iMs3 != i) {
                                this.ah = y.ms(str, iMs3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iMs;
                            this.ah += "%40" + y.ms(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iD = d(str, i2, iMs);
                int i3 = iD + 1;
                if (i3 < iMs) {
                    this.d = ka(str, i2, iD);
                    int iC = c(str, i3, iMs);
                    this.ka = iC;
                    if (iC == -1) {
                        return EnumC0242ms.INVALID_PORT;
                    }
                } else {
                    this.d = ka(str, i2, iD);
                    this.ka = y.ms(this.f1148ms);
                }
                if (this.d == null) {
                    return EnumC0242ms.INVALID_HOST;
                }
                iMs2 = iMs;
            } else {
                this.xr = yVar.ka();
                this.ah = yVar.c();
                this.d = yVar.xr;
                this.ka = yVar.ah;
                this.c.clear();
                this.c.addAll(yVar.ch());
                if (iMs2 == iXr || str.charAt(iMs2) == '#') {
                    ka(yVar.hi());
                }
            }
            int iMs4 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, iMs2, iXr, "?#");
            ms(str, iMs2, iMs4);
            if (iMs4 < iXr && str.charAt(iMs4) == '?') {
                int iMs5 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, iMs4, iXr, '#');
                this.ab = y.xr(y.ms(str, iMs4 + 1, iMs5, " \"'<>#", true, false, true, true, null));
                iMs4 = iMs5;
            }
            if (iMs4 < iXr && str.charAt(iMs4) == '#') {
                this.x = y.ms(str, 1 + iMs4, iXr, "", true, false, false, false, null);
            }
            return EnumC0242ms.SUCCESS;
        }

        private void ms(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.c.clear();
                this.c.add("");
                i++;
            } else {
                List<String> list = this.c;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, i3, i2, "/\\");
                boolean z = i < i2;
                ms(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void ms(String str, int i, int i2, boolean z, boolean z2) {
            String strMs = y.ms(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (c(strMs)) {
                return;
            }
            if (ab(strMs)) {
                d();
                return;
            }
            List<String> list = this.c;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.c;
                list2.set(list2.size() - 1, strMs);
            } else {
                this.c.add(strMs);
            }
            if (z) {
                this.c.add("");
            }
        }

        private boolean c(String str) {
            return str.equals(j.z) || str.equalsIgnoreCase("%2e");
        }

        private boolean ab(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            List<String> list = this.c;
            if (list.remove(list.size() - 1).isEmpty() && !this.c.isEmpty()) {
                List<String> list2 = this.c;
                list2.set(list2.size() - 1, "");
            } else {
                this.c.add("");
            }
        }

        private static int xr(String str, int i, int i2) {
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

        private static int ah(String str, int i, int i2) {
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

        private static int d(String str, int i, int i2) {
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

        private static String ka(String str, int i, int i2) {
            return com.bytedance.sdk.component.ah.xr.ms.ah.ms(y.ms(str, i, i2, false));
        }

        private static int c(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(y.ms(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
    }

    static String ms(String str, boolean z) {
        return ms(str, 0, str.length(), z);
    }

    private List<String> ms(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? ms(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String ms(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.bytedance.sdk.component.ah.ms.ah ahVar = new com.bytedance.sdk.component.ah.ms.ah();
                ahVar.ms(str, i, i3);
                ms(ahVar, str, i3, i2, z);
                return ahVar.ub();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    static void ms(com.bytedance.sdk.component.ah.ms.ah ahVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str.charAt(i + 1));
                int iMs2 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(str.charAt(i3));
                if (iMs != -1 && iMs2 != -1) {
                    ahVar.ny((iMs << 4) + iMs2);
                    i = i3;
                } else {
                    ahVar.ms(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                ahVar.ny(32);
            } else {
                ahVar.ms(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static boolean ms(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.component.ah.xr.ms.ah.ms(str.charAt(i + 1)) != -1 && com.bytedance.sdk.component.ah.xr.ms.ah.ms(str.charAt(i3)) != -1;
    }

    static String ms(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || ms(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            com.bytedance.sdk.component.ah.ms.ah ahVar = new com.bytedance.sdk.component.ah.ms.ah();
            ahVar.ms(str, i, iCharCount);
            ms(ahVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return ahVar.ub();
        }
        return str.substring(i, i2);
    }

    static void ms(com.bytedance.sdk.component.ah.ms.ah ahVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.component.ah.ms.ah ahVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    ahVar.xr(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !ms(str, i, i2)))))) {
                    if (ahVar2 == null) {
                        ahVar2 = new com.bytedance.sdk.component.ah.ms.ah();
                    }
                    if (charset == null || charset.equals(com.bytedance.sdk.component.ah.xr.ms.ah.ka)) {
                        ahVar2.ms(iCodePointAt);
                    } else {
                        ahVar2.ms(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!ahVar2.ka()) {
                        int iX = ahVar2.x() & UByte.MAX_VALUE;
                        ahVar.ny(37);
                        char[] cArr = d;
                        ahVar.ny((int) cArr[(iX >> 4) & 15]);
                        ahVar.ny((int) cArr[iX & 15]);
                    }
                } else {
                    ahVar.ms(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String ms(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return ms(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

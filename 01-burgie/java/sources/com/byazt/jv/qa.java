package com.byazt.jv;

import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 101})
public final class qa {
    public static final char[] x = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String aj;
    public final String c;
    public final List<String> fw;
    public final int hn;
    public final String hw;
    public final String pr;
    public final String uc;
    public final String vk;
    public final List<String> zo;

    public qa(pr prVar) {
        this.pr = prVar.pr;
        this.c = pr(prVar.hw, false);
        this.uc = pr(prVar.hn, false);
        this.hw = prVar.x;
        this.hn = prVar.pr();
        this.fw = pr(prVar.uc, false);
        this.zo = prVar.fw != null ? pr(prVar.fw, true) : null;
        this.aj = prVar.zo != null ? pr(prVar.zo, false) : null;
        this.vk = prVar.toString();
    }

    public URI pr() {
        String string = m().hw().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public String hw() {
        return this.pr;
    }

    public boolean hn() {
        return BaseConstants.SCHEME_HTTPS.equals(this.pr);
    }

    public String x() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.pr.length() + 3;
        String str = this.vk;
        return this.vk.substring(length, com.byazt.xx.hn.pr(str, length, str.length(), ":@"));
    }

    public String c() {
        if (this.uc.isEmpty()) {
            return "";
        }
        return this.vk.substring(this.vk.indexOf(58, this.pr.length() + 3) + 1, this.vk.indexOf(64));
    }

    public String uc() {
        return this.hw;
    }

    public int fw() {
        return this.hn;
    }

    public static int pr(String str) {
        if ("http".equals(str)) {
            return 80;
        }
        if (BaseConstants.SCHEME_HTTPS.equals(str)) {
            return 443;
        }
        return -1;
    }

    public String zo() {
        int iIndexOf = this.vk.indexOf(47, this.pr.length() + 3);
        String str = this.vk;
        return this.vk.substring(iIndexOf, com.byazt.xx.hn.pr(str, iIndexOf, str.length(), "?#"));
    }

    public static void pr(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> aj() {
        int iIndexOf = this.vk.indexOf(47, this.pr.length() + 3);
        String str = this.vk;
        int iPr = com.byazt.xx.hn.pr(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iPr) {
            int i = iIndexOf + 1;
            int iPr2 = com.byazt.xx.hn.pr(this.vk, i, iPr, '/');
            arrayList.add(this.vk.substring(i, iPr2));
            iIndexOf = iPr2;
        }
        return arrayList;
    }

    public String vk() {
        if (this.zo == null) {
            return null;
        }
        int iIndexOf = this.vk.indexOf(63) + 1;
        String str = this.vk;
        return this.vk.substring(iIndexOf, com.byazt.xx.hn.pr(str, iIndexOf, str.length(), '#'));
    }

    public static void hw(StringBuilder sb, List<String> list) {
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

    public static List<String> hw(String str) {
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
        if (this.zo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        hw(sb, this.zo);
        return sb.toString();
    }

    public String w() {
        if (this.aj == null) {
            return null;
        }
        return this.vk.substring(this.vk.indexOf(35) + 1);
    }

    public String k() {
        return x("/...").hw("").hn("").hn().toString();
    }

    public qa hn(String str) {
        pr prVarX = x(str);
        if (prVarX != null) {
            return prVarX.hn();
        }
        return null;
    }

    public pr m() {
        pr prVar = new pr();
        prVar.pr = this.pr;
        prVar.hw = x();
        prVar.hn = c();
        prVar.x = this.hw;
        prVar.c = this.hn != pr(this.pr) ? this.hn : -1;
        prVar.uc.clear();
        prVar.uc.addAll(aj());
        prVar.c(vk());
        prVar.zo = w();
        return prVar;
    }

    public pr x(String str) {
        pr prVar = new pr();
        if (prVar.pr(this, str) == pr.EnumC0112pr.SUCCESS) {
            return prVar;
        }
        return null;
    }

    public static qa c(String str) {
        pr prVar = new pr();
        if (prVar.pr(null, str) == pr.EnumC0112pr.SUCCESS) {
            return prVar.hn();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof qa) && ((qa) obj).vk.equals(this.vk);
    }

    public int hashCode() {
        return this.vk.hashCode();
    }

    public String toString() {
        return this.vk;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 1702})
    public static final class pr {
        public List<String> fw;
        public String pr;
        public final List<String> uc;
        public String x;
        public String zo;
        public String hw = "";
        public String hn = "";
        public int c = -1;

        /* JADX INFO: renamed from: com.byazt.jv.qa$pr$pr, reason: collision with other inner class name */
        enum EnumC0112pr {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public pr() {
            ArrayList arrayList = new ArrayList();
            this.uc = arrayList;
            arrayList.add("");
        }

        public pr pr(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if ("http".equalsIgnoreCase(str)) {
                this.pr = "http";
            } else if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(str)) {
                this.pr = BaseConstants.SCHEME_HTTPS;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public pr hw(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.hw = qa.pr(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public pr hn(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.hn = qa.pr(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public pr x(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strC = c(str, 0, str.length());
            if (strC == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.x = strC;
            return this;
        }

        public pr pr(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.c = i;
            return this;
        }

        public int pr() {
            int i = this.c;
            return i != -1 ? i : qa.pr(this.pr);
        }

        public pr query(String str) {
            this.fw = str != null ? qa.hw(qa.pr(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public pr c(String str) {
            this.fw = str != null ? qa.hw(qa.pr(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public pr hw() {
            int size = this.uc.size();
            for (int i = 0; i < size; i++) {
                this.uc.set(i, qa.pr(this.uc.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.fw;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.fw.get(i2);
                    if (str != null) {
                        this.fw.set(i2, qa.pr(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.zo;
            if (str2 != null) {
                this.zo = qa.pr(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public qa hn() {
            if (this.pr == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.x == null) {
                throw new IllegalStateException("host == null");
            }
            return new qa(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.pr);
            sb.append("://");
            if (!this.hw.isEmpty() || !this.hn.isEmpty()) {
                sb.append(this.hw);
                if (!this.hn.isEmpty()) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.hn);
                }
                sb.append('@');
            }
            if (this.x.indexOf(58) != -1) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(this.x);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(this.x);
            }
            int iPr = pr();
            if (iPr != qa.pr(this.pr)) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(iPr);
            }
            qa.pr(sb, this.uc);
            if (this.fw != null) {
                sb.append('?');
                qa.hw(sb, this.fw);
            }
            if (this.zo != null) {
                sb.append('#');
                sb.append(this.zo);
            }
            return sb.toString();
        }

        public EnumC0112pr pr(qa qaVar, String str) {
            int i;
            int iPr = com.byazt.xx.hn.pr(str, 0, str.length());
            int iHw = com.byazt.xx.hn.hw(str, iPr, str.length());
            byte b = -1;
            if (hw(str, iPr, iHw) != -1) {
                if (str.regionMatches(true, iPr, "https:", 0, 6)) {
                    this.pr = BaseConstants.SCHEME_HTTPS;
                    iPr += 6;
                } else if (str.regionMatches(true, iPr, "http:", 0, 5)) {
                    this.pr = "http";
                    iPr += 5;
                } else {
                    return EnumC0112pr.UNSUPPORTED_SCHEME;
                }
            } else if (qaVar != null) {
                this.pr = qaVar.pr;
            } else {
                return EnumC0112pr.MISSING_SCHEME;
            }
            int iHn = hn(str, iPr, iHw);
            char c = '#';
            if (iHn < 2 && qaVar != null && qaVar.pr.equals(this.pr)) {
                this.hw = qaVar.x();
                this.hn = qaVar.c();
                this.x = qaVar.hw;
                this.c = qaVar.hn;
                this.uc.clear();
                this.uc.addAll(qaVar.aj());
                if (iPr == iHw || str.charAt(iPr) == '#') {
                    c(qaVar.vk());
                }
            } else {
                boolean z = false;
                boolean z2 = false;
                int i2 = iPr + iHn;
                while (true) {
                    int iPr2 = com.byazt.xx.hn.pr(str, i2, iHw, "@/\\?#");
                    switch (iPr2 != iHw ? str.charAt(iPr2) : b) {
                        case -1:
                        case 35:
                        case 47:
                        case 63:
                        case 92:
                            int iX = x(str, i2, iPr2);
                            int i3 = iX + 1;
                            if (i3 < iPr2) {
                                this.x = c(str, i2, iX);
                                int iUc = uc(str, i3, iPr2);
                                this.c = iUc;
                                if (iUc == -1) {
                                    return EnumC0112pr.INVALID_PORT;
                                }
                            } else {
                                this.x = c(str, i2, iX);
                                this.c = qa.pr(this.pr);
                            }
                            if (this.x == null) {
                                return EnumC0112pr.INVALID_HOST;
                            }
                            iPr = iPr2;
                            break;
                        case 64:
                            if (!z) {
                                int iPr3 = com.byazt.xx.hn.pr(str, i2, iPr2, AbstractJsonLexerKt.COLON);
                                i = iPr2;
                                String strPr = qa.pr(str, i2, iPr3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    strPr = this.hw + "%40" + strPr;
                                }
                                this.hw = strPr;
                                if (iPr3 != i) {
                                    this.hn = qa.pr(str, iPr3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = iPr2;
                                this.hn += "%40" + qa.pr(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            }
                            i2 = i + 1;
                            b = -1;
                            c = '#';
                            continue;
                        default:
                            continue;
                    }
                }
            }
            int iPr4 = com.byazt.xx.hn.pr(str, iPr, iHw, "?#");
            pr(str, iPr, iPr4);
            if (iPr4 < iHw && str.charAt(iPr4) == '?') {
                int iPr5 = com.byazt.xx.hn.pr(str, iPr4, iHw, '#');
                this.fw = qa.hw(qa.pr(str, iPr4 + 1, iPr5, " \"'<>#", true, false, true, true, null));
                iPr4 = iPr5;
            }
            if (iPr4 < iHw && str.charAt(iPr4) == '#') {
                this.zo = qa.pr(str, iPr4 + 1, iHw, "", true, false, false, false, null);
            }
            return EnumC0112pr.SUCCESS;
        }

        private void pr(String str, int i, int i2) {
            int i3;
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.uc.clear();
                this.uc.add("");
                i3 = i + 1;
            } else {
                List<String> list = this.uc;
                list.set(list.size() - 1, "");
                i3 = i;
            }
            while (i3 < i2) {
                int iPr = com.byazt.xx.hn.pr(str, i3, i2, "/\\");
                boolean z = iPr < i2;
                pr(str, i3, iPr, z, true);
                if (z) {
                    iPr++;
                }
                i3 = iPr;
            }
        }

        private void pr(String str, int i, int i2, boolean z, boolean z2) {
            String strPr = qa.pr(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (uc(strPr)) {
                return;
            }
            if (fw(strPr)) {
                x();
                return;
            }
            List<String> list = this.uc;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.uc;
                list2.set(list2.size() - 1, strPr);
            } else {
                this.uc.add(strPr);
            }
            if (z) {
                this.uc.add("");
            }
        }

        private boolean uc(String str) {
            return ".".equals(str) || "%2e".equalsIgnoreCase(str);
        }

        private boolean fw(String str) {
            return "..".equals(str) || "%2e. ".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
        }

        private void x() {
            List<String> list = this.uc;
            if (list.remove(list.size() - 1).isEmpty() && !this.uc.isEmpty()) {
                List<String> list2 = this.uc;
                list2.set(list2.size() - 1, "");
            } else {
                this.uc.add("");
            }
        }

        private static int hw(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                if (cCharAt2 == ':') {
                                    return i;
                                }
                                return -1;
                            }
                        }
                    }
                }
            }
        }

        private static int hn(String str, int i, int i2) {
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

        private static int x(String str, int i, int i2) {
            while (i < i2) {
                switch (str.charAt(i)) {
                    case ':':
                        return i;
                    case '[':
                        break;
                    default:
                        continue;
                        i++;
                        break;
                }
                do {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                } while (str.charAt(i) != ']');
                i++;
            }
            return i2;
        }

        private static String c(String str, int i, int i2) {
            return com.byazt.xx.hn.pr(qa.pr(str, i, i2, false));
        }

        private static int uc(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(qa.pr(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    public static String pr(String str, boolean z) {
        return pr(str, 0, str.length(), z);
    }

    private List<String> pr(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? pr(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String pr(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.byazt.du.hn hnVar = new com.byazt.du.hn();
                hnVar.pr(str, i, i3);
                pr(hnVar, str, i3, i2, z);
                return hnVar.ho();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003b  */
    public static void pr(com.byazt.du.hn hnVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iPr = com.byazt.xx.hn.pr(str.charAt(i + 1));
                int iPr2 = com.byazt.xx.hn.pr(str.charAt(i3));
                if (iPr != -1 && iPr2 != -1) {
                    hnVar.aj((iPr << 4) + iPr2);
                    i = i3;
                } else {
                    hnVar.pr(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                hnVar.aj(32);
            } else {
                hnVar.pr(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static boolean pr(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.byazt.xx.hn.pr(str.charAt(i + 1)) != -1 && com.byazt.xx.hn.pr(str.charAt(i3)) != -1;
    }

    public static String pr(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127) {
                if ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || pr(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            com.byazt.du.hn hnVar = new com.byazt.du.hn();
            hnVar.pr(str, i, iCharCount);
            pr(hnVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return hnVar.ho();
        }
        return str.substring(i, i2);
    }

    public static void pr(com.byazt.du.hn hnVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.byazt.du.hn hnVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    hnVar.hw(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !pr(str, i, i2)))))) {
                    if (hnVar2 == null) {
                        hnVar2 = new com.byazt.du.hn();
                    }
                    if (charset == null || charset.equals(com.byazt.xx.hn.c)) {
                        hnVar2.pr(iCodePointAt);
                    } else {
                        hnVar2.pr(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!hnVar2.c()) {
                        int iZo = hnVar2.zo() & UByte.MAX_VALUE;
                        hnVar.aj(37);
                        char[] cArr = x;
                        hnVar.aj((int) cArr[(iZo >> 4) & 15]);
                        hnVar.aj((int) cArr[iZo & 15]);
                    }
                } else {
                    hnVar.pr(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static String pr(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return pr(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

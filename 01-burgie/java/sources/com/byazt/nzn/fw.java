package com.byazt.nzn;

import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 62})
public final class fw {
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

    public fw(pr prVar) {
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

    public String pr() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.pr.length() + 3;
        String str = this.vk;
        return this.vk.substring(length, com.byazt.qm.vk.pr(str, length, str.length(), ":@"));
    }

    public String hw() {
        if (this.uc.isEmpty()) {
            return "";
        }
        return this.vk.substring(this.vk.indexOf(58, this.pr.length() + 3) + 1, this.vk.indexOf(64));
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

    public static void pr(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> hn() {
        int iIndexOf = this.vk.indexOf(47, this.pr.length() + 3);
        String str = this.vk;
        int iPr = com.byazt.qm.vk.pr(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iPr) {
            int i = iIndexOf + 1;
            int iPr2 = com.byazt.qm.vk.pr(this.vk, i, iPr, '/');
            arrayList.add(this.vk.substring(i, iPr2));
            iIndexOf = iPr2;
        }
        return arrayList;
    }

    public String x() {
        if (this.zo == null) {
            return null;
        }
        int iIndexOf = this.vk.indexOf(63) + 1;
        String str = this.vk;
        return this.vk.substring(iIndexOf, com.byazt.qm.vk.pr(str, iIndexOf, str.length(), '#'));
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

    public static fw hn(String str) {
        pr prVar = new pr();
        if (prVar.pr((fw) null, str) == pr.EnumC0149pr.SUCCESS) {
            return prVar.hw();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof fw) && ((fw) obj).vk.equals(this.vk);
    }

    public int hashCode() {
        return this.vk.hashCode();
    }

    public String toString() {
        return this.vk;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 766})
    public static final class pr {
        public List<String> fw;
        public String pr;
        public final List<String> uc;
        public String x;
        public String zo;
        public String hw = "";
        public String hn = "";
        public int c = -1;

        /* JADX INFO: renamed from: com.byazt.nzn.fw$pr$pr, reason: collision with other inner class name */
        enum EnumC0149pr {
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
                throw new NullPointerException("host == null");
            }
            String strC = c(str, 0, str.length());
            if (strC == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.x = strC;
            return this;
        }

        public int pr() {
            int i = this.c;
            return i != -1 ? i : fw.pr(this.pr);
        }

        public pr hn(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegments == null");
            }
            return pr(str, true);
        }

        private pr pr(String str, boolean z) {
            int i = 0;
            do {
                int iPr = com.byazt.qm.vk.pr(str, i, str.length(), "/\\");
                pr(str, i, iPr, iPr < str.length(), z);
                i = iPr + 1;
            } while (i <= str.length());
            return this;
        }

        public pr query(String str) {
            this.fw = str != null ? fw.hw(fw.pr(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public pr x(String str) {
            this.fw = str != null ? fw.hw(fw.pr(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public pr pr(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.fw == null) {
                this.fw = new ArrayList();
            }
            this.fw.add(fw.pr(str, " \"'<>#&=", true, false, true, true));
            this.fw.add(str2 != null ? fw.pr(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public fw hw() {
            if (this.pr == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.x == null) {
                throw new IllegalStateException("host == null");
            }
            return new fw(this);
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
            if (iPr != fw.pr(this.pr)) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(iPr);
            }
            fw.pr(sb, this.uc);
            if (this.fw != null) {
                sb.append('?');
                fw.hw(sb, this.fw);
            }
            if (this.zo != null) {
                sb.append('#');
                sb.append(this.zo);
            }
            return sb.toString();
        }

        public EnumC0149pr pr(fw fwVar, String str) {
            int i;
            int iPr = com.byazt.qm.vk.pr(str, 0, str.length());
            int iHw = com.byazt.qm.vk.hw(str, iPr, str.length());
            byte b = -1;
            if (hw(str, iPr, iHw) != -1) {
                if (str.regionMatches(true, iPr, "https:", 0, 6)) {
                    this.pr = BaseConstants.SCHEME_HTTPS;
                    iPr += 6;
                } else if (str.regionMatches(true, iPr, "http:", 0, 5)) {
                    this.pr = "http";
                    iPr += 5;
                } else {
                    return EnumC0149pr.UNSUPPORTED_SCHEME;
                }
            } else if (fwVar != null) {
                this.pr = fwVar.pr;
            } else {
                return EnumC0149pr.MISSING_SCHEME;
            }
            int iHn = hn(str, iPr, iHw);
            char c = '#';
            if (iHn < 2 && fwVar != null && fwVar.pr.equals(this.pr)) {
                this.hw = fwVar.pr();
                this.hn = fwVar.hw();
                this.x = fwVar.hw;
                this.c = fwVar.hn;
                this.uc.clear();
                this.uc.addAll(fwVar.hn());
                if (iPr == iHw || str.charAt(iPr) == '#') {
                    x(fwVar.x());
                }
            } else {
                boolean z = false;
                boolean z2 = false;
                int i2 = iPr + iHn;
                while (true) {
                    int iPr2 = com.byazt.qm.vk.pr(str, i2, iHw, "@/\\?#");
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
                                    return EnumC0149pr.INVALID_PORT;
                                }
                            } else {
                                this.x = c(str, i2, iX);
                                this.c = fw.pr(this.pr);
                            }
                            if (this.x == null) {
                                return EnumC0149pr.INVALID_HOST;
                            }
                            iPr = iPr2;
                            break;
                        case 64:
                            if (!z) {
                                int iPr3 = com.byazt.qm.vk.pr(str, i2, iPr2, AbstractJsonLexerKt.COLON);
                                i = iPr2;
                                String strPr = fw.pr(str, i2, iPr3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    strPr = this.hw + "%40" + strPr;
                                }
                                this.hw = strPr;
                                if (iPr3 != i) {
                                    this.hn = fw.pr(str, iPr3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = iPr2;
                                this.hn += "%40" + fw.pr(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
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
            int iPr4 = com.byazt.qm.vk.pr(str, iPr, iHw, "?#");
            pr(str, iPr, iPr4);
            if (iPr4 < iHw && str.charAt(iPr4) == '?') {
                int iPr5 = com.byazt.qm.vk.pr(str, iPr4, iHw, '#');
                this.fw = fw.hw(fw.pr(str, iPr4 + 1, iPr5, " \"'<>#", true, false, true, true, null));
                iPr4 = iPr5;
            }
            if (iPr4 < iHw && str.charAt(iPr4) == '#') {
                this.zo = fw.pr(str, iPr4 + 1, iHw, "", true, false, false, false, null);
            }
            return EnumC0149pr.SUCCESS;
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
                int iPr = com.byazt.qm.vk.pr(str, i3, i2, "/\\");
                boolean z = iPr < i2;
                pr(str, i3, iPr, z, true);
                if (z) {
                    iPr++;
                }
                i3 = iPr;
            }
        }

        private void pr(String str, int i, int i2, boolean z, boolean z2) {
            String strPr = fw.pr(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (c(strPr)) {
                return;
            }
            if (uc(strPr)) {
                hn();
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

        private boolean c(String str) {
            return ".".equals(str) || "%2e".equalsIgnoreCase(str);
        }

        private boolean uc(String str) {
            return "..".equals(str) || "%2e.".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
        }

        private void hn() {
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
            return com.byazt.qm.vk.pr(fw.pr(str, i, i2, false));
        }

        private static int uc(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(fw.pr(str, i, i2, "", false, false, false, true, null));
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
                com.byazt.qm.pr prVar = new com.byazt.qm.pr();
                prVar.pr(str, i, i3);
                pr(prVar, str, i3, i2, z);
                return prVar.hn();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003b  */
    public static void pr(com.byazt.qm.pr prVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iPr = com.byazt.qm.vk.pr(str.charAt(i + 1));
                int iPr2 = com.byazt.qm.vk.pr(str.charAt(i3));
                if (iPr != -1 && iPr2 != -1) {
                    prVar.hw((iPr << 4) + iPr2);
                    i = i3;
                } else {
                    prVar.pr(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                prVar.hw(32);
            } else {
                prVar.pr(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static boolean pr(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.byazt.qm.vk.pr(str.charAt(i + 1)) != -1 && com.byazt.qm.vk.pr(str.charAt(i3)) != -1;
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
            com.byazt.qm.pr prVar = new com.byazt.qm.pr();
            prVar.pr(str, i, iCharCount);
            pr(prVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return prVar.hn();
        }
        return str.substring(i, i2);
    }

    public static void pr(com.byazt.qm.pr prVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.byazt.qm.pr prVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    prVar.pr(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !pr(str, i, i2)))))) {
                    if (prVar2 == null) {
                        prVar2 = new com.byazt.qm.pr();
                    }
                    if (charset == null || charset.equals(com.byazt.qm.vk.pr)) {
                        prVar2.pr(iCodePointAt);
                    } else {
                        prVar2.pr(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!prVar2.pr()) {
                        int iHw = prVar2.hw() & UByte.MAX_VALUE;
                        prVar.hw(37);
                        char[] cArr = x;
                        prVar.hw((int) cArr[(iHw >> 4) & 15]);
                        prVar.hw((int) cArr[iHw & 15]);
                    }
                } else {
                    prVar.pr(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    public static String pr(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return pr(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

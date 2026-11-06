package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.DownloadTask;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 250})
public final class k {
    public final String aj;
    public final String c;
    public final long fw;
    public final boolean k;
    public final boolean m;
    public final String uc;
    public final boolean vk;
    public final boolean w;
    public final String zo;
    public static final Pattern pr = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern hw = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern hn = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern x = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private k(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.c = str;
        this.uc = str2;
        this.fw = j;
        this.zo = str3;
        this.aj = str4;
        this.vk = z;
        this.w = z2;
        this.m = z3;
        this.k = z4;
    }

    public String pr() {
        return this.c;
    }

    public String hw() {
        return this.uc;
    }

    private static boolean pr(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.byazt.xx.hn.hn(str);
    }

    public static k pr(qa qaVar, String str) {
        return pr(System.currentTimeMillis(), qaVar, str);
    }

    public static k pr(long j, qa qaVar, String str) {
        long j2;
        String str2;
        String str3;
        int length = str.length();
        char c = ';';
        int iPr = com.byazt.xx.hn.pr(str, 0, length, ';');
        char c2 = '=';
        int iPr2 = com.byazt.xx.hn.pr(str, 0, iPr, '=');
        if (iPr2 == iPr) {
            return null;
        }
        String strHn = com.byazt.xx.hn.hn(str, 0, iPr2);
        if (!strHn.isEmpty() && com.byazt.xx.hn.hw(strHn) == -1) {
            String strHn2 = com.byazt.xx.hn.hn(str, iPr2 + 1, iPr);
            if (com.byazt.xx.hn.hw(strHn2) != -1) {
                return null;
            }
            int i = iPr + 1;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            String strHw = null;
            boolean z4 = true;
            long jPr = -1;
            long jPr2 = 253402300799999L;
            String str4 = null;
            while (i < length) {
                int iPr3 = com.byazt.xx.hn.pr(str, i, length, c);
                int iPr4 = com.byazt.xx.hn.pr(str, i, iPr3, c2);
                String strHn3 = com.byazt.xx.hn.hn(str, i, iPr4);
                String strHn4 = iPr4 < iPr3 ? com.byazt.xx.hn.hn(str, iPr4 + 1, iPr3) : "";
                if ("expires".equalsIgnoreCase(strHn3)) {
                    try {
                        jPr2 = pr(strHn4, 0, strHn4.length());
                        z3 = true;
                    } catch (IllegalArgumentException e) {
                    }
                } else if ("max-age".equalsIgnoreCase(strHn3)) {
                    try {
                        jPr = pr(strHn4);
                        z3 = true;
                    } catch (NumberFormatException e2) {
                    }
                } else if ("domain".equalsIgnoreCase(strHn3)) {
                    try {
                        strHw = hw(strHn4);
                        z4 = false;
                    } catch (IllegalArgumentException e3) {
                    }
                } else if ("path".equalsIgnoreCase(strHn3)) {
                    str4 = strHn4;
                } else if ("secure".equalsIgnoreCase(strHn3)) {
                    z = true;
                } else if ("httponly".equalsIgnoreCase(strHn3)) {
                    z2 = true;
                }
                i = iPr3 + 1;
                c = ';';
                c2 = '=';
            }
            if (jPr == Long.MIN_VALUE) {
                j2 = Long.MIN_VALUE;
            } else if (jPr == -1) {
                j2 = jPr2;
            } else {
                long j3 = j + (jPr <= 9223372036854775L ? jPr * 1000 : LongCompanionObject.MAX_VALUE);
                j2 = (j3 < j || j3 > 253402300799999L) ? 253402300799999L : j3;
            }
            String strUc = qaVar.uc();
            if (strHw == null) {
                str2 = strUc;
            } else if (pr(strUc, strHw)) {
                str2 = strHw;
            } else {
                return null;
            }
            if (strUc.length() != str2.length() && com.byazt.oa.pr.pr().pr(str2) == null) {
                return null;
            }
            String strSubstring = "/";
            if (str4 == null || !str4.startsWith("/")) {
                String strZo = qaVar.zo();
                int iLastIndexOf = strZo.lastIndexOf(47);
                if (iLastIndexOf != 0) {
                    strSubstring = strZo.substring(0, iLastIndexOf);
                }
                str3 = strSubstring;
            } else {
                str3 = str4;
            }
            return new k(strHn, strHn2, j2, str2, str3, z, z2, z4, z3);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0087  */
    private static long pr(String str, int i, int i2) {
        int iPr = pr(str, i, i2, false);
        Matcher matcher = x.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iPr < i2) {
            int iPr2 = pr(str, iPr + 1, i2, true);
            matcher.region(iPr, iPr2);
            if (i4 == -1 && matcher.usePattern(x).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i6 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(hn).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = hw;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 != -1 && matcher.usePattern(pr).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else if (i3 != -1) {
            }
            iPr = pr(str, iPr2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
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
        GregorianCalendar gregorianCalendar = new GregorianCalendar(com.byazt.xx.hn.fw);
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

    private static int pr(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long pr(String str) {
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

    private static String hw(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strPr = com.byazt.xx.hn.pr(str);
        if (strPr == null) {
            throw new IllegalArgumentException();
        }
        return strPr;
    }

    public static List<k> pr(qa qaVar, lb lbVar) {
        List<String> listHw = lbVar.hw("Set-Cookie");
        int size = listHw.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            k kVarPr = pr(qaVar, listHw.get(i));
            if (kVarPr != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVarPr);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return pr(false);
    }

    public String pr(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append('=');
        sb.append(this.uc);
        if (this.k) {
            if (this.fw == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(com.byazt.osx.x.pr(new Date(this.fw)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.zo);
        }
        sb.append("; path=").append(this.aj);
        if (this.vk) {
            sb.append("; secure");
        }
        if (this.w) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.c.equals(this.c) && kVar.uc.equals(this.uc) && kVar.zo.equals(this.zo) && kVar.aj.equals(this.aj) && kVar.fw == this.fw && kVar.vk == this.vk && kVar.w == this.w && kVar.k == this.k && kVar.m == this.m;
    }

    public int hashCode() {
        int iHashCode = (((((((this.c.hashCode() + 527) * 31) + this.uc.hashCode()) * 31) + this.zo.hashCode()) * 31) + this.aj.hashCode()) * 31;
        long j = this.fw;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.vk ? 1 : 0)) * 31) + (!this.w ? 1 : 0)) * 31) + (!this.k ? 1 : 0)) * 31) + (!this.m ? 1 : 0);
    }
}

package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 121})
public final class x {
    public final boolean aj;
    public final boolean c;
    public final int fw;
    public final boolean g;
    public String hn;
    public final boolean ho;
    public final int k;
    public final boolean m;
    public final int uc;
    public final boolean vk;
    public final int w;
    public final boolean x;
    public final boolean zo;
    public static final x pr = new pr().pr().hn();
    public static final x hw = new pr().hw().pr(Integer.MAX_VALUE, TimeUnit.SECONDS).hn();

    private x(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.x = z;
        this.c = z2;
        this.uc = i;
        this.fw = i2;
        this.zo = z3;
        this.aj = z4;
        this.vk = z5;
        this.w = i3;
        this.k = i4;
        this.m = z6;
        this.g = z7;
        this.ho = z8;
        this.hn = str;
    }

    public x(pr prVar) {
        this.x = prVar.pr;
        this.c = prVar.hw;
        this.uc = prVar.hn;
        this.fw = -1;
        this.zo = false;
        this.aj = false;
        this.vk = false;
        this.w = prVar.x;
        this.k = prVar.c;
        this.m = prVar.uc;
        this.g = prVar.fw;
        this.ho = prVar.zo;
    }

    public boolean pr() {
        return this.x;
    }

    public boolean hw() {
        return this.c;
    }

    public int hn() {
        return this.uc;
    }

    public boolean x() {
        return this.zo;
    }

    public boolean c() {
        return this.aj;
    }

    public boolean uc() {
        return this.vk;
    }

    public int fw() {
        return this.w;
    }

    public int zo() {
        return this.k;
    }

    public boolean aj() {
        return this.m;
    }

    public boolean vk() {
        return this.ho;
    }

    public static x pr(lb lbVar) {
        String str;
        String strTrim;
        int iPr = lbVar.pr();
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int iHw = -1;
        int iHw2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iHw3 = -1;
        int iHw4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (int i = 0; i < iPr; i++) {
            String strPr = lbVar.pr(i);
            String strHw = lbVar.hw(i);
            if ("Cache-Control".equalsIgnoreCase(strPr)) {
                if (str2 != null) {
                    z = false;
                } else {
                    str2 = strHw;
                }
            } else {
                if ("Pragma".equalsIgnoreCase(strPr)) {
                    z = false;
                }
            }
            int iPr2 = 0;
            while (iPr2 < strHw.length()) {
                int iPr3 = com.byazt.osx.c.pr(strHw, iPr2, "=,;");
                String strTrim2 = strHw.substring(iPr2, iPr3).trim();
                if (iPr3 == strHw.length() || strHw.charAt(iPr3) == ',' || strHw.charAt(iPr3) == ';') {
                    iPr2 = iPr3 + 1;
                    strTrim = null;
                } else {
                    int iPr4 = com.byazt.osx.c.pr(strHw, iPr3 + 1);
                    if (iPr4 < strHw.length() && strHw.charAt(iPr4) == '\"') {
                        int i2 = iPr4 + 1;
                        int iPr5 = com.byazt.osx.c.pr(strHw, i2, "\"");
                        strTrim = strHw.substring(i2, iPr5);
                        iPr2 = iPr5 + 1;
                    } else {
                        iPr2 = com.byazt.osx.c.pr(strHw, iPr4, ",;");
                        strTrim = strHw.substring(iPr4, iPr2).trim();
                    }
                }
                if ("no-cache".equalsIgnoreCase(strTrim2)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim2)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim2)) {
                    iHw = com.byazt.osx.c.hw(strTrim, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim2)) {
                    iHw2 = com.byazt.osx.c.hw(strTrim, -1);
                } else if ("private".equalsIgnoreCase(strTrim2)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(strTrim2)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim2)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim2)) {
                    iHw3 = com.byazt.osx.c.hw(strTrim, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim2)) {
                    iHw4 = com.byazt.osx.c.hw(strTrim, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim2)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim2)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim2)) {
                    z9 = true;
                }
            }
        }
        if (z) {
            str = str2;
        } else {
            str = null;
        }
        return new x(z2, z3, iHw, iHw2, z4, z5, z6, iHw3, iHw4, z7, z8, z9, str);
    }

    public String toString() {
        String str = this.hn;
        if (str != null) {
            return str;
        }
        String strW = w();
        this.hn = strW;
        return strW;
    }

    private String w() {
        StringBuilder sb = new StringBuilder();
        if (this.x) {
            sb.append("no-cache, ");
        }
        if (this.c) {
            sb.append("no-store, ");
        }
        if (this.uc != -1) {
            sb.append("max-age=").append(this.uc).append(", ");
        }
        if (this.fw != -1) {
            sb.append("s-maxage=").append(this.fw).append(", ");
        }
        if (this.zo) {
            sb.append("private, ");
        }
        if (this.aj) {
            sb.append("public, ");
        }
        if (this.vk) {
            sb.append("must-revalidate, ");
        }
        if (this.w != -1) {
            sb.append("max-stale=").append(this.w).append(", ");
        }
        if (this.k != -1) {
            sb.append("min-fresh=").append(this.k).append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.g) {
            sb.append("no-transform, ");
        }
        if (this.ho) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static final class pr {
        public boolean fw;
        public boolean hw;
        public boolean pr;
        public boolean uc;
        public boolean zo;
        public int hn = -1;
        public int x = -1;
        public int c = -1;

        public pr pr() {
            this.pr = true;
            return this;
        }

        public pr pr(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.x = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public pr hw() {
            this.uc = true;
            return this;
        }

        public x hn() {
            return new x(this);
        }
    }
}

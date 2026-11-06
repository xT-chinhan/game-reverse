package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 5})
public final class q {
    public static final q n = new n().n().s();
    public static final q qg = new n().qg().n(Integer.MAX_VALUE, TimeUnit.SECONDS).s();
    public final int cp;
    public final int d;
    public final boolean fs;
    public final boolean k;
    public final boolean l;
    public final boolean oa;
    public final boolean q;
    public final boolean rv;
    public String s;
    public final boolean sz;
    public final boolean tj;
    public final int w;
    public final int x;

    private q(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.q = z;
        this.l = z2;
        this.w = i;
        this.x = i2;
        this.fs = z3;
        this.rv = z4;
        this.tj = z5;
        this.cp = i3;
        this.d = i4;
        this.oa = z6;
        this.sz = z7;
        this.k = z8;
        this.s = str;
    }

    public q(n nVar) {
        this.q = nVar.n;
        this.l = nVar.qg;
        this.w = nVar.s;
        this.x = -1;
        this.fs = false;
        this.rv = false;
        this.tj = false;
        this.cp = nVar.q;
        this.d = nVar.l;
        this.oa = nVar.w;
        this.sz = nVar.x;
        this.k = nVar.fs;
    }

    public boolean n() {
        return this.q;
    }

    public boolean qg() {
        return this.l;
    }

    public int s() {
        return this.w;
    }

    public boolean q() {
        return this.fs;
    }

    public boolean l() {
        return this.rv;
    }

    public boolean w() {
        return this.tj;
    }

    public int x() {
        return this.cp;
    }

    public int fs() {
        return this.d;
    }

    public boolean rv() {
        return this.oa;
    }

    public boolean tj() {
        return this.k;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    /* JADX WARN: Code duplicated, block: B:28:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:56:0x0106  */
    /* JADX WARN: Code duplicated, block: B:57:0x010c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0115  */
    /* JADX WARN: Code duplicated, block: B:60:0x0118  */
    /* JADX WARN: Code duplicated, block: B:62:0x0120  */
    /* JADX WARN: Code duplicated, block: B:63:0x0123  */
    /* JADX WARN: Code duplicated, block: B:65:0x012b  */
    /* JADX WARN: Code duplicated, block: B:86:0x00a6 A[SYNTHETIC] */
    public static q n(cd cdVar) {
        int i;
        int iN;
        String strTrim;
        int iN2;
        String strTrim2;
        int iN3 = cdVar.n();
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int iQg = -1;
        int iQg2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int iQg3 = -1;
        int iQg4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (int i2 = 0; i2 < iN3; i2++) {
            String strN = cdVar.n(i2);
            String strQg = cdVar.qg(i2);
            if (!"Cache-Control".equalsIgnoreCase(strN)) {
                if ("Pragma".equalsIgnoreCase(strN)) {
                }
            } else {
                if (str == null) {
                    str = strQg;
                }
                for (i = 0; i < strQg.length(); i = iN2) {
                    iN = com.byazt.cri.l.n(strQg, i, "=,;");
                    strTrim = strQg.substring(i, iN).trim();
                    if (iN != strQg.length() || strQg.charAt(iN) == ',' || strQg.charAt(iN) == ';') {
                        iN2 = iN + 1;
                        strTrim2 = null;
                    } else {
                        int iN4 = com.byazt.cri.l.n(strQg, iN + 1);
                        if (iN4 < strQg.length() && strQg.charAt(iN4) == '\"') {
                            int i3 = iN4 + 1;
                            int iN5 = com.byazt.cri.l.n(strQg, i3, "\"");
                            strTrim2 = strQg.substring(i3, iN5);
                            iN2 = iN5 + 1;
                        } else {
                            iN2 = com.byazt.cri.l.n(strQg, iN4, ",;");
                            strTrim2 = strQg.substring(iN4, iN2).trim();
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(strTrim)) {
                        z2 = true;
                    } else if ("no-store".equalsIgnoreCase(strTrim)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        iQg = com.byazt.cri.l.qg(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        iQg2 = com.byazt.cri.l.qg(strTrim2, -1);
                    } else if ("private".equalsIgnoreCase(strTrim)) {
                        z4 = true;
                    } else if ("public".equalsIgnoreCase(strTrim)) {
                        z5 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                        z6 = true;
                    } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                        iQg3 = com.byazt.cri.l.qg(strTrim2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                        iQg4 = com.byazt.cri.l.qg(strTrim2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z7 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z8 = true;
                    } else if ("immutable".equalsIgnoreCase(strTrim)) {
                        z9 = true;
                    }
                }
            }
            z = false;
            while (i < strQg.length()) {
                iN = com.byazt.cri.l.n(strQg, i, "=,;");
                strTrim = strQg.substring(i, iN).trim();
                if (iN != strQg.length()) {
                    iN2 = iN + 1;
                    strTrim2 = null;
                } else {
                    iN2 = iN + 1;
                    strTrim2 = null;
                }
                if ("no-cache".equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if ("no-store".equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    iQg = com.byazt.cri.l.qg(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    iQg2 = com.byazt.cri.l.qg(strTrim2, -1);
                } else if ("private".equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if ("public".equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if ("must-revalidate".equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if ("max-stale".equalsIgnoreCase(strTrim)) {
                    iQg3 = com.byazt.cri.l.qg(strTrim2, Integer.MAX_VALUE);
                } else if ("min-fresh".equalsIgnoreCase(strTrim)) {
                    iQg4 = com.byazt.cri.l.qg(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                } else if ("immutable".equalsIgnoreCase(strTrim)) {
                    z9 = true;
                }
            }
        }
        return new q(z2, z3, iQg, iQg2, z4, z5, z6, iQg3, iQg4, z7, z8, z9, !z ? null : str);
    }

    public String toString() {
        String str = this.s;
        if (str != null) {
            return str;
        }
        String strCp = cp();
        this.s = strCp;
        return strCp;
    }

    private String cp() {
        StringBuilder sb = new StringBuilder();
        if (this.q) {
            sb.append("no-cache, ");
        }
        if (this.l) {
            sb.append("no-store, ");
        }
        if (this.w != -1) {
            sb.append("max-age=").append(this.w).append(", ");
        }
        if (this.x != -1) {
            sb.append("s-maxage=").append(this.x).append(", ");
        }
        if (this.fs) {
            sb.append("private, ");
        }
        if (this.rv) {
            sb.append("public, ");
        }
        if (this.tj) {
            sb.append("must-revalidate, ");
        }
        if (this.cp != -1) {
            sb.append("max-stale=").append(this.cp).append(", ");
        }
        if (this.d != -1) {
            sb.append("min-fresh=").append(this.d).append(", ");
        }
        if (this.oa) {
            sb.append("only-if-cached, ");
        }
        if (this.sz) {
            sb.append("no-transform, ");
        }
        if (this.k) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    @com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static final class n {
        public boolean fs;
        public boolean n;
        public boolean qg;
        public boolean w;
        public boolean x;
        public int s = -1;
        public int q = -1;
        public int l = -1;

        public n n() {
            this.n = true;
            return this;
        }

        public n n(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: ".concat(String.valueOf(i)));
            }
            long seconds = timeUnit.toSeconds(i);
            this.q = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public n qg() {
            this.w = true;
            return this;
        }

        public q s() {
            return new q(this);
        }
    }
}

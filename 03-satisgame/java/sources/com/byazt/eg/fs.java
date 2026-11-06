package com.byazt.eg;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 101})
public class fs {
    public final List<com.byazt.yt.n<Float>> a;
    public final com.byazt.ccr.cp cd;
    public final int cp;
    public final float cy;
    public final int d;
    public final List<com.byazt.aw.fs> fs;
    public final com.byazt.ccr.tj hd;
    public final float k;
    public final n l;
    public final com.byazt.ur.tj m;
    public final List<com.byazt.aw.s> n;
    public final float oa;
    public final boolean ou;
    public final qg py;
    public final long q;
    public final com.byazt.pp.w qg;
    public final com.byazt.ccr.d rv;
    public final String s;
    public final float sz;
    public final int tj;
    public final com.byazt.ccr.qg um;
    public final long w;
    public final com.byazt.aw.n wm;
    public final String x;

    public enum n {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum qg {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public fs(List<com.byazt.aw.s> list, com.byazt.pp.w wVar, String str, long j, n nVar, long j2, String str2, List<com.byazt.aw.fs> list2, com.byazt.ccr.d dVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.byazt.ccr.tj tjVar, com.byazt.ccr.cp cpVar, List<com.byazt.yt.n<Float>> list3, qg qgVar, com.byazt.ccr.qg qgVar2, boolean z, com.byazt.aw.n nVar2, com.byazt.ur.tj tjVar2) {
        this.n = list;
        this.qg = wVar;
        this.s = str;
        this.q = j;
        this.l = nVar;
        this.w = j2;
        this.x = str2;
        this.fs = list2;
        this.rv = dVar;
        this.tj = i;
        this.cp = i2;
        this.d = i3;
        this.oa = f;
        this.sz = f2;
        this.k = f3;
        this.cy = f4;
        this.hd = tjVar;
        this.cd = cpVar;
        this.a = list3;
        this.py = qgVar;
        this.um = qgVar2;
        this.ou = z;
        this.wm = nVar2;
        this.m = tjVar2;
    }

    public com.byazt.pp.w n() {
        return this.qg;
    }

    public float qg() {
        return this.oa;
    }

    public float s() {
        return this.sz / this.qg.cd();
    }

    public List<com.byazt.yt.n<Float>> q() {
        return this.a;
    }

    public long l() {
        return this.q;
    }

    public String w() {
        return this.s;
    }

    public String x() {
        return this.x;
    }

    public float fs() {
        return this.k;
    }

    public float rv() {
        return this.cy;
    }

    public List<com.byazt.aw.fs> tj() {
        return this.fs;
    }

    public n cp() {
        return this.l;
    }

    public qg d() {
        return this.py;
    }

    public long oa() {
        return this.w;
    }

    public List<com.byazt.aw.s> sz() {
        return this.n;
    }

    public com.byazt.ccr.d k() {
        return this.rv;
    }

    public int cy() {
        return this.d;
    }

    public int hd() {
        return this.cp;
    }

    public int cd() {
        return this.tj;
    }

    public com.byazt.ccr.tj um() {
        return this.hd;
    }

    public com.byazt.ccr.cp a() {
        return this.cd;
    }

    public com.byazt.ccr.qg py() {
        return this.um;
    }

    public String toString() {
        return n("");
    }

    public boolean ou() {
        return this.ou;
    }

    public com.byazt.aw.n wm() {
        return this.wm;
    }

    public com.byazt.ur.tj m() {
        return this.m;
    }

    public String n(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(w()).append("\n");
        fs fsVarN = this.qg.n(oa());
        if (fsVarN != null) {
            sb.append("\t\tParents: ").append(fsVarN.w());
            fs fsVarN2 = this.qg.n(fsVarN.oa());
            while (fsVarN2 != null) {
                sb.append("->").append(fsVarN2.w());
                fsVarN2 = this.qg.n(fsVarN2.oa());
            }
            sb.append(str).append("\n");
        }
        if (!tj().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(tj().size()).append("\n");
        }
        if (cd() != 0 && hd() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(cd()), Integer.valueOf(hd()), Integer.valueOf(cy())));
        }
        if (!this.n.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.byazt.aw.s> it = this.n.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}

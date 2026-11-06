package com.byazt.aw;

import android.graphics.Paint;
import com.byazt.sp.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 86})
public class cd implements s {
    public final qg fs;
    public final com.byazt.ccr.q l;
    public final String n;
    public final com.byazt.ccr.n q;
    public final com.byazt.ccr.qg qg;
    public final float rv;
    public final List<com.byazt.ccr.qg> s;
    public final boolean tj;
    public final com.byazt.ccr.qg w;
    public final n x;

    public enum n {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap n() {
            int i = AnonymousClass1.n[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* JADX INFO: renamed from: com.byazt.aw.cd$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 1026, 1027})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;
        public static final /* synthetic */ int[] qg;

        static {
            int[] iArr = new int[qg.values().length];
            qg = iArr;
            try {
                iArr[qg.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qg[qg.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                qg[qg.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[n.values().length];
            n = iArr2;
            try {
                iArr2[n.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[n.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[n.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum qg {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join n() {
            int i = AnonymousClass1.qg[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public cd(String str, com.byazt.ccr.qg qgVar, List<com.byazt.ccr.qg> list, com.byazt.ccr.n nVar, com.byazt.ccr.q qVar, com.byazt.ccr.qg qgVar2, n nVar2, qg qgVar3, float f, boolean z) {
        this.n = str;
        this.qg = qgVar;
        this.s = list;
        this.q = nVar;
        this.l = qVar;
        this.w = qgVar2;
        this.x = nVar2;
        this.fs = qgVar3;
        this.rv = f;
        this.tj = z;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new a(fsVar, sVar, this);
    }

    public String n() {
        return this.n;
    }

    public com.byazt.ccr.n qg() {
        return this.q;
    }

    public com.byazt.ccr.q s() {
        return this.l;
    }

    public com.byazt.ccr.qg q() {
        return this.w;
    }

    public List<com.byazt.ccr.qg> l() {
        return this.s;
    }

    public com.byazt.ccr.qg w() {
        return this.qg;
    }

    public n x() {
        return this.x;
    }

    public qg fs() {
        return this.fs;
    }

    public float rv() {
        return this.rv;
    }

    public boolean tj() {
        return this.tj;
    }
}

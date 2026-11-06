package com.byazt.ynb;

import android.graphics.Paint;
import com.byazt.ova.a;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 48})
public class lb implements hn {
    public final float aj;
    public final com.byazt.eqw.x c;
    public final pr fw;
    public final List<com.byazt.eqw.hw> hn;
    public final com.byazt.eqw.hw hw;
    public final String pr;
    public final com.byazt.eqw.hw uc;
    public final boolean vk;
    public final com.byazt.eqw.pr x;
    public final hw zo;

    public enum pr {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap pr() {
            switch (AnonymousClass1.pr[ordinal()]) {
                case 1:
                    return Paint.Cap.BUTT;
                case 2:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.ynb.lb$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 47, 481})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] hw;
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[hw.values().length];
            hw = iArr;
            try {
                iArr[hw.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hw[hw.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hw[hw.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[pr.values().length];
            pr = iArr2;
            try {
                iArr2[pr.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[pr.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[pr.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public enum hw {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join pr() {
            switch (AnonymousClass1.hw[ordinal()]) {
                case 1:
                    return Paint.Join.BEVEL;
                case 2:
                    return Paint.Join.MITER;
                case 3:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    public lb(String str, com.byazt.eqw.hw hwVar, List<com.byazt.eqw.hw> list, com.byazt.eqw.pr prVar, com.byazt.eqw.x xVar, com.byazt.eqw.hw hwVar2, pr prVar2, hw hwVar3, float f, boolean z) {
        this.pr = str;
        this.hw = hwVar;
        this.hn = list;
        this.x = prVar;
        this.c = xVar;
        this.uc = hwVar2;
        this.fw = prVar2;
        this.zo = hwVar3;
        this.aj = f;
        this.vk = z;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new a(zoVar, hnVar, this);
    }

    public String pr() {
        return this.pr;
    }

    public com.byazt.eqw.pr hw() {
        return this.x;
    }

    public com.byazt.eqw.x hn() {
        return this.c;
    }

    public com.byazt.eqw.hw x() {
        return this.uc;
    }

    public List<com.byazt.eqw.hw> c() {
        return this.hn;
    }

    public com.byazt.eqw.hw uc() {
        return this.hw;
    }

    public pr fw() {
        return this.fw;
    }

    public hw zo() {
        return this.zo;
    }

    public float aj() {
        return this.aj;
    }

    public boolean vk() {
        return this.vk;
    }
}

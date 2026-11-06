package com.byazt.ynb;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 50})
public class vk implements hn {
    public final com.byazt.eqw.hw aj;
    public final com.byazt.eqw.hw c;
    public final com.byazt.eqw.hw fw;
    public final com.byazt.eqw.hw hn;
    public final pr hw;
    public final String pr;
    public final com.byazt.eqw.hw uc;
    public final boolean vk;
    public final boolean w;
    public final com.byazt.eqw.m<PointF, PointF> x;
    public final com.byazt.eqw.hw zo;

    public enum pr {
        STAR(1),
        POLYGON(2);

        public final int hn;

        pr(int i) {
            this.hn = i;
        }

        public static pr pr(int i) {
            for (pr prVar : values()) {
                if (prVar.hn == i) {
                    return prVar;
                }
            }
            return null;
        }
    }

    public vk(String str, pr prVar, com.byazt.eqw.hw hwVar, com.byazt.eqw.m<PointF, PointF> mVar, com.byazt.eqw.hw hwVar2, com.byazt.eqw.hw hwVar3, com.byazt.eqw.hw hwVar4, com.byazt.eqw.hw hwVar5, com.byazt.eqw.hw hwVar6, boolean z, boolean z2) {
        this.pr = str;
        this.hw = prVar;
        this.hn = hwVar;
        this.x = mVar;
        this.c = hwVar2;
        this.uc = hwVar3;
        this.fw = hwVar4;
        this.zo = hwVar5;
        this.aj = hwVar6;
        this.vk = z;
        this.w = z2;
    }

    public String pr() {
        return this.pr;
    }

    public pr getType() {
        return this.hw;
    }

    public com.byazt.eqw.hw hw() {
        return this.hn;
    }

    public com.byazt.eqw.m<PointF, PointF> hn() {
        return this.x;
    }

    public com.byazt.eqw.hw x() {
        return this.c;
    }

    public com.byazt.eqw.hw c() {
        return this.uc;
    }

    public com.byazt.eqw.hw uc() {
        return this.fw;
    }

    public com.byazt.eqw.hw fw() {
        return this.zo;
    }

    public com.byazt.eqw.hw zo() {
        return this.aj;
    }

    public boolean aj() {
        return this.vk;
    }

    public boolean vk() {
        return this.w;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.g(zoVar, hnVar, this);
    }
}

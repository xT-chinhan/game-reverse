package com.byazt.ynb;

import com.byazt.ova.cz;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 101})
public class qa implements hn {
    public final com.byazt.eqw.hw c;
    public final com.byazt.eqw.hw hn;
    public final pr hw;
    public final String pr;
    public final boolean uc;
    public final com.byazt.eqw.hw x;

    public enum pr {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static pr pr(int i) {
            switch (i) {
                case 1:
                    return SIMULTANEOUSLY;
                case 2:
                    return INDIVIDUALLY;
                default:
                    throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
            }
        }
    }

    public qa(String str, pr prVar, com.byazt.eqw.hw hwVar, com.byazt.eqw.hw hwVar2, com.byazt.eqw.hw hwVar3, boolean z) {
        this.pr = str;
        this.hw = prVar;
        this.hn = hwVar;
        this.x = hwVar2;
        this.c = hwVar3;
        this.uc = z;
    }

    public String pr() {
        return this.pr;
    }

    public pr getType() {
        return this.hw;
    }

    public com.byazt.eqw.hw hw() {
        return this.x;
    }

    public com.byazt.eqw.hw hn() {
        return this.hn;
    }

    public com.byazt.eqw.hw x() {
        return this.c;
    }

    public boolean c() {
        return this.uc;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new cz(hnVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.hn + ", end: " + this.x + ", offset: " + this.c + "}";
    }
}

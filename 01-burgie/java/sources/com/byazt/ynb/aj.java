package com.byazt.ynb;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 61})
public class aj implements hn {
    public final boolean hn;
    public final pr hw;
    public final String pr;

    public enum pr {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static pr pr(int i) {
            switch (i) {
                case 1:
                    return MERGE;
                case 2:
                    return ADD;
                case 3:
                    return SUBTRACT;
                case 4:
                    return INTERSECT;
                case 5:
                    return EXCLUDE_INTERSECTIONS;
                default:
                    return MERGE;
            }
        }
    }

    public aj(String str, pr prVar, boolean z) {
        this.pr = str;
        this.hw = prVar;
        this.hn = z;
    }

    public String pr() {
        return this.pr;
    }

    public pr hw() {
        return this.hw;
    }

    public boolean hn() {
        return this.hn;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.k(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.hw + AbstractJsonLexerKt.END_OBJ;
    }
}

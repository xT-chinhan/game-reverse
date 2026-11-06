package com.byazt.ynb;

import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 74})
public class nt implements hn {
    public final boolean hn;
    public final List<hn> hw;
    public final String pr;

    public nt(String str, List<hn> list, boolean z) {
        this.pr = str;
        this.hw = list;
        this.hn = z;
    }

    public String pr() {
        return this.pr;
    }

    public List<hn> hw() {
        return this.hw;
    }

    public boolean hn() {
        return this.hn;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.x(zoVar, hnVar, this, ucVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.pr + "' Shapes: " + Arrays.toString(this.hw.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}

package com.byazt.al;

import android.graphics.Path;
import com.byazt.ova.qa;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 108})
public class m extends pr<com.byazt.ynb.g, Path> {
    public final Path c;
    public List<qa> uc;
    public final com.byazt.ynb.g x;

    public m(List<com.byazt.cz.pr<com.byazt.ynb.g>> list) {
        super(list);
        this.x = new com.byazt.ynb.g();
        this.c = new Path();
    }

    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public Path pr(com.byazt.cz.pr<com.byazt.ynb.g> prVar, float f) {
        this.x.pr(prVar.pr, prVar.hw, f);
        com.byazt.ynb.g gVarPr = this.x;
        List<qa> list = this.uc;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                gVarPr = this.uc.get(size).pr(gVarPr);
            }
        }
        com.byazt.ptr.aj.pr(gVarPr, this.c);
        return this.c;
    }

    public void pr(List<qa> list) {
        this.uc = list;
    }
}

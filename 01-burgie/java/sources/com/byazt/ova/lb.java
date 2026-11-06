package com.byazt.ova;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 48})
public class lb implements com.byazt.al.pr.InterfaceC0016pr, m {
    public final com.byazt.al.m c;
    public final boolean hn;
    public final String hw;
    public boolean uc;
    public final com.byazt.dx.zo x;
    public final Path pr = new Path();
    public final hw fw = new hw();

    public lb(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.yb ybVar) {
        this.hw = ybVar.pr();
        this.hn = ybVar.hn();
        this.x = zoVar;
        com.byazt.al.m mVarPr = ybVar.hw().pr();
        this.c = mVarPr;
        hnVar.pr(mVarPr);
        mVarPr.pr(this);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        hw();
    }

    private void hw() {
        this.uc = false;
        this.x.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    /* JADX WARN: Code duplicated, block: B:12:0x002c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002e  */
    /* JADX WARN: Code duplicated, block: B:22:0x003a A[SYNTHETIC] */
    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            hn hnVar = list.get(i);
            if (hnVar instanceof cz) {
                cz czVar = (cz) hnVar;
                if (czVar.getType() == com.byazt.ynb.qa.pr.SIMULTANEOUSLY) {
                    this.fw.pr(czVar);
                    czVar.pr(this);
                } else if (!(hnVar instanceof qa)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((qa) hnVar);
                }
            } else if (!(hnVar instanceof qa)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((qa) hnVar);
            }
        }
        this.c.pr((List<qa>) arrayList);
    }

    @Override // com.byazt.ova.m
    public Path x() {
        if (this.uc) {
            return this.pr;
        }
        this.pr.reset();
        if (this.hn) {
            this.uc = true;
            return this.pr;
        }
        Path pathFw = this.c.fw();
        if (pathFw == null) {
            return this.pr;
        }
        this.pr.set(pathFw);
        this.pr.setFillType(Path.FillType.EVEN_ODD);
        this.fw.pr(this.pr);
        this.uc = true;
        return this.pr;
    }
}

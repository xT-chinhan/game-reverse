package com.byazt.dqk;

import com.byazt.jv.fo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, 62})
public class fw extends com.byazt.nzn.x {
    public fo pr;

    public fw(fo foVar) {
        this.pr = foVar;
    }

    @Override // com.byazt.nzn.x
    public void pr(int i) {
        this.pr.qa().pr(i);
    }

    @Override // com.byazt.nzn.x
    public void hw(int i) {
        if (i < 5) {
            this.pr.qa().hw(5);
        } else {
            this.pr.qa().hw(i);
        }
    }

    @Override // com.byazt.nzn.x
    public List<com.byazt.nzn.hw> hn() {
        ArrayList arrayList = new ArrayList();
        List<com.byazt.jv.c> listHw = this.pr.qa().hw();
        for (int i = 0; i < listHw.size(); i++) {
            arrayList.add(new x(listHw.get(i)));
        }
        return arrayList;
    }

    @Override // com.byazt.nzn.x
    public List<com.byazt.nzn.hw> x() {
        ArrayList arrayList = new ArrayList();
        List<com.byazt.jv.c> listHn = this.pr.qa().hn();
        for (int i = 0; i < listHn.size(); i++) {
            arrayList.add(new x(listHn.get(i)));
        }
        return arrayList;
    }
}

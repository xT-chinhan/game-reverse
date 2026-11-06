package com.byazt.zn;

import android.text.TextUtils;
import com.byazt.hg.cr;
import com.byazt.hg.ie;
import com.byazt.hg.iy;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.y;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 94, 13})
public class hw extends pr {
    public int aj;
    public com.byazt.vl.hw c;
    public int fw;
    public boolean k;
    public boolean m;
    public int uc;
    public boolean vk;
    public com.byazt.hg.pr w;
    public int x;
    public com.byazt.n.x zo;

    public hw(of ofVar, boolean z) {
        if (ofVar == null) {
            return;
        }
        this.hw = ofVar;
        this.m = z;
        this.k = ie.pr(ofVar) == 2;
        hw(ofVar);
    }

    private void hw(of ofVar) {
        int iSx = ofVar.sx();
        iy iyVarFw = ie.fw(ofVar);
        cr crVarZo = ie.zo(ofVar);
        if (TextUtils.isEmpty(qv.pr(ofVar))) {
            this.x = 1;
        } else if (hn(ofVar)) {
            if (pr(iyVarFw) || pr(crVarZo)) {
                this.x = 2;
            } else {
                if (hw(iyVarFw) || hw(crVarZo)) {
                    ie.pr(ofVar, 1);
                }
                this.x = 1;
            }
        } else if (iSx == 1) {
            this.x = 1;
        } else {
            this.x = 2;
        }
        x(ofVar);
    }

    private boolean pr(iy iyVar) {
        return iyVar != null && pr(iyVar.zo()) == 2;
    }

    private boolean pr(cr crVar) {
        return crVar != null && crVar.fw() == 2;
    }

    private boolean hw(iy iyVar) {
        return iyVar != null && pr(iyVar.zo()) == 0;
    }

    private boolean hw(cr crVar) {
        return crVar != null && crVar.fw() == 0;
    }

    private int pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            return 0;
        }
    }

    private boolean hn(of ofVar) {
        return ie.pr(ofVar) == 2;
    }

    private void x(of ofVar) {
        c(ofVar);
        uc(ofVar);
    }

    private void c(of ofVar) {
        y yVar;
        if (ofVar.de() == null || (yVar = ofVar.de().get(0)) == null) {
            return;
        }
        String strPr = yVar.pr();
        if (TextUtils.isEmpty(strPr)) {
            return;
        }
        this.uc = yVar.hw();
        this.fw = yVar.hn();
        this.c = new com.byazt.vl.hw(strPr, yVar.fw());
    }

    private void uc(of ofVar) {
        this.zo = qv.ho(ofVar);
        this.aj = ls.m(ofVar);
        this.vk = ofVar.oc();
    }

    public com.byazt.vl.hw x() {
        return this.c;
    }

    public int c() {
        return this.uc;
    }

    public int uc() {
        return this.fw;
    }

    public com.byazt.n.x fw() {
        return this.zo;
    }

    public int zo() {
        return this.aj;
    }

    public boolean aj() {
        return this.vk;
    }

    public int vk() {
        return this.x;
    }

    public com.byazt.hg.pr w() {
        return this.w;
    }

    public void pr(com.byazt.hg.pr prVar) {
        this.w = prVar;
    }

    public boolean k() {
        return this.k;
    }

    public boolean m() {
        return this.m;
    }

    public void pr(boolean z) {
        this.m = z;
    }
}

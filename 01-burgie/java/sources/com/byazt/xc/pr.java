package com.byazt.xc;

import com.byazt.qam.fw;
import com.byazt.vlp.c;
import com.byazt.vlp.w;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 422, 37})
public class pr implements com.byazt.vlp.hw {
    public w hn;
    public c hw;
    public final fw pr;

    public pr(fw fwVar) {
        this.pr = fwVar;
    }

    @Override // com.byazt.vlp.hw
    public boolean pr() {
        return this.pr.pr();
    }

    @Override // com.byazt.vlp.hw
    public c hw() {
        if (this.hw == null) {
            final com.byazt.qe.hn hnVarAj = this.pr.aj();
            if (hnVarAj == null) {
                return null;
            }
            this.hw = new c() { // from class: com.byazt.xc.pr.1
                @Override // com.byazt.vlp.c
                public double pr() {
                    return hnVarAj.pr();
                }

                @Override // com.byazt.vlp.c
                public double hw() {
                    return hnVarAj.hw();
                }
            };
        }
        return this.hw;
    }

    @Override // com.byazt.vlp.hw
    public boolean hn() {
        return this.pr.hw();
    }

    @Override // com.byazt.vlp.hw
    public boolean x() {
        return this.pr.hn();
    }

    @Override // com.byazt.vlp.hw
    public String c() {
        return this.pr.vk();
    }

    @Override // com.byazt.vlp.hw
    public boolean uc() {
        return this.pr.x();
    }

    @Override // com.byazt.vlp.hw
    public String fw() {
        return this.pr.w();
    }

    @Override // com.byazt.vlp.hw
    public boolean zo() {
        return this.pr.c();
    }

    @Override // com.byazt.vlp.hw
    public String aj() {
        return this.pr.k();
    }

    @Override // com.byazt.vlp.hw
    public boolean vk() {
        return this.pr.uc();
    }

    @Override // com.byazt.vlp.hw
    public w w() {
        if (this.hn == null) {
            com.byazt.or.hw hwVarYb = this.pr.yb();
            if (hwVarYb == null) {
                return null;
            }
            this.hn = new x(hwVarYb);
        }
        return this.hn;
    }

    @Override // com.byazt.vlp.hw
    public String k() {
        return this.pr.ho();
    }

    @Override // com.byazt.vlp.hw
    public boolean m() {
        return this.pr.fw();
    }

    @Override // com.byazt.vlp.hw
    public Map<String, Object> g() {
        return this.pr.nt();
    }

    @Override // com.byazt.vlp.hw
    public boolean ho() {
        return this.pr.zo();
    }

    @Override // com.byazt.vlp.hw
    public boolean pr(int i) {
        return fw.pr(this.pr, i);
    }
}

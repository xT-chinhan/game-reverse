package com.byazt.pv;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1010, 62})
public abstract class fw {
    public String hw;
    public com.byazt.dc.hw pr;

    public void pr() {
        com.byazt.dc.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.pr(this.hw, com.byazt.tq.hw.STARTED);
        }
    }

    public void hw() {
        com.byazt.dc.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.pr(this.hw, com.byazt.tq.hw.REQED);
        }
    }

    public void pr(final boolean z) {
        com.byazt.dc.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.pr(this.hw, new com.byazt.ewt.x.pr() { // from class: com.byazt.pv.fw.1
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar2) {
                    if (hwVar2 instanceof hw) {
                        ((hw) hwVar2).hw = z;
                    }
                }
            });
            this.pr.pr(this.hw, com.byazt.tq.hw.RECEIVED);
        }
    }

    public void pr(final String str, final boolean z, final com.byazt.xn.hn hnVar) {
        com.byazt.dc.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.pr(this.hw, new com.byazt.ewt.x.pr() { // from class: com.byazt.pv.fw.2
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar2) {
                    if (hwVar2 instanceof hw) {
                        hw hwVar3 = (hw) hwVar2;
                        hwVar3.hn = z;
                        hwVar3.x = hnVar;
                        if (!TextUtils.isEmpty(str)) {
                            hwVar3.c.add(str);
                        }
                    }
                }
            });
            if (!TextUtils.isEmpty(str)) {
                ((com.byazt.dc.hn) com.byazt.ewt.c.pr(1)).pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.pv.fw.3
                    @Override // com.byazt.ewt.x.pr
                    public void pr(com.byazt.ewt.hw hwVar2) {
                        if (hwVar2 instanceof hn) {
                            ((hn) hwVar2).pr = fw.this.hw;
                        }
                    }
                });
            }
            this.pr.pr(this.hw, com.byazt.tq.hw.LOADED);
        }
    }
}

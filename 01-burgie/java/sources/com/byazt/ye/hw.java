package com.byazt.ye;

import android.content.Context;
import com.byazt.af.w;
import com.byazt.hg.g;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, 13})
public class hw implements com.byazt.ni.pr {
    public com.byazt.hws.pr c;
    public String hn;
    public Context hw;
    public w pr;
    public Map<String, Object> uc;
    public com.byazt.ni.pr x;

    public hw(com.byazt.ni.pr prVar, Context context, w wVar, String str, Map<String, Object> map, com.byazt.hws.pr prVar2) {
        this.x = prVar;
        this.hw = context;
        this.pr = wVar;
        this.hn = str;
        this.c = prVar2;
        this.uc = map;
    }

    @Override // com.byazt.ni.pr
    public boolean pr(final Map<String, Object> map) {
        g gVarQa = null;
        if (this.pr.c() == 9 && Objects.equals(this.uc.get("saas_status_while_click"), 2)) {
            if (this.pr.I_() != null) {
                gVarQa = this.pr.I_().hw();
            }
        } else {
            gVarQa = this.pr.qa();
        }
        if (!com.byazt.md.hn.pr(gVarQa, false)) {
            com.byazt.ni.pr prVar = this.x;
            return prVar != null && prVar.pr(map);
        }
        if (com.byazt.ea.w.c(com.byazt.lx.hw.pr(this.pr, this.uc))) {
            com.byazt.ni.pr prVar2 = this.x;
            return prVar2 != null && prVar2.pr(map);
        }
        if (com.byazt.ea.w.x(com.byazt.lx.hw.pr(this.pr, this.uc))) {
            com.byazt.ni.pr prVar3 = this.x;
            return prVar3 != null && prVar3.pr(map);
        }
        new com.byazt.md.hn(this.pr, gVarQa, this.hw, this.uc).pr(this.hn).pr(new com.byazt.md.hn.pr() { // from class: com.byazt.ye.hw.1
            @Override // com.byazt.md.hn.pr
            public void pr() {
                if (!hw.this.x.pr(map)) {
                    hw.this.c.pr(hw.this.uc, (com.byazt.rs.pr) null);
                }
            }
        });
        return true;
    }
}

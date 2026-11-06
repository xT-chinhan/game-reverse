package com.byazt.sb;

import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.tk.ou;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 527, 8})
public class s extends n {
    /* JADX INFO: Access modifiers changed from: private */
    public ou n() {
        ou ouVar = new ou(rv.getContext(), 1, com.byazt.vyf.s.cy().q());
        boolean zN = ouVar.n(0);
        n(zN ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            ouVar.qg(0);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void n(JSONObject jSONObject, int i) {
        if (System.currentTimeMillis() - com.byazt.hnb.qg.n().qg() > n(i)) {
            com.byazt.ag.qg.n(new x("reg_sensor") { // from class: com.byazt.sb.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.this.n();
                }
            });
        }
    }
}

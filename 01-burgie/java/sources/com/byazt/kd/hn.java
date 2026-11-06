package com.byazt.kd;

import com.byazt.ca.ny;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.xlm.fw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1299, 20})
public class hn extends pr {
    /* JADX INFO: Access modifiers changed from: private */
    public ny pr() {
        ny nyVar = new ny(a.getContext(), 1, zo.nt().x());
        boolean zPr = nyVar.pr(0);
        pr(zPr ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            nyVar.hw(0);
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public void pr(JSONObject jSONObject, int i) {
        if (System.currentTimeMillis() - com.byazt.na.pr.pr().hw() > pr(i)) {
            com.byazt.zp.zo.pr(new fw("reg_sensor") { // from class: com.byazt.kd.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    hn.this.pr();
                }
            });
        }
    }
}

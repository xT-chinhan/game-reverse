package com.byazt.le;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.ch.a;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.pj.x;
import com.byazt.sa.fw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 953, 13})
public class hw implements a, lb {
    public a c;
    public int fw;
    public com.byazt.ik.hn<View> hn;
    public x hw;
    public Context pr;
    public String uc;
    public pr x;

    interface pr {
        void pr(nt ntVar);
    }

    public hw(Context context, x xVar, String str, int i) {
        this.pr = context;
        this.hw = xVar;
        this.uc = str;
        this.fw = i;
    }

    public void pr(pr prVar) {
        this.x = prVar;
    }

    public void pr(a aVar) {
        this.c = aVar;
    }

    public void pr(final JSONObject jSONObject, final JSONObject jSONObject2, final fw fwVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw(jSONObject, jSONObject2, fwVar);
        } else {
            com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.le.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    hw.this.hw(jSONObject, jSONObject2, fwVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(JSONObject jSONObject, JSONObject jSONObject2, fw fwVar) {
        ho hoVar = new ho(this.pr);
        com.byazt.ik.hn<View> hnVarPr = hoVar.pr(jSONObject);
        this.hn = hnVarPr;
        if (hnVarPr == null) {
            x xVar = this.hw;
            if (xVar != null) {
                xVar.pr(-1, "ugeno render fail");
            }
            if (fwVar != null) {
                fwVar.pr(-1, "");
                return;
            }
            return;
        }
        hoVar.pr((a) this);
        hoVar.pr((lb) this);
        hoVar.hw(jSONObject2);
        this.hw.pr(0L);
        if (fwVar != null) {
            fwVar.pr(this.hn);
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        pr prVar2;
        if (ntVar != null && ntVar.hw() == 1 && (prVar2 = this.x) != null) {
            prVar2.pr(ntVar);
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
    }

    @Override // com.byazt.ch.a
    public void pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.pr(hnVar, motionEvent);
        }
    }
}

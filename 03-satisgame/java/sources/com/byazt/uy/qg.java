package com.byazt.uy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.hb.rv;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.oa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 819, 26})
public class qg implements rv.n {
    public com.byazt.ih.s l;
    public int n;
    public cy q;
    public cd qg;
    public Context s;
    public Handler w = new rv(Looper.getMainLooper(), this);

    public qg(Context context, cy cyVar, com.byazt.ih.s sVar) {
        this.s = context;
        this.q = cyVar;
        this.l = sVar;
    }

    public void n(cd cdVar) {
        this.qg = cdVar;
    }

    public void n() {
        cy cyVar = this.q;
        if (cyVar == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.byazt.mcb.qg.n(cyVar.s().optString("delay"), this.l.tj()));
            this.n = i;
            this.w.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.byazt.hb.rv.n
    public void n(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectS = this.q.s();
        if (TextUtils.equals(jSONObjectS.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectS.optString("nodeId");
            com.byazt.ih.s sVar = this.l;
            com.byazt.ih.s sVarQ = sVar.qg(sVar).q(strOptString);
            new oa(sVarQ.rv(), com.byazt.vh.n.n(jSONObjectS.optJSONObject("animatorSet"), sVarQ)).n();
        } else {
            cd cdVar = this.qg;
            if (cdVar != null) {
                cy cyVar = this.q;
                com.byazt.ih.s sVar2 = this.l;
                cdVar.n(cyVar, sVar2, sVar2);
            }
        }
        this.w.removeMessages(1001);
    }
}

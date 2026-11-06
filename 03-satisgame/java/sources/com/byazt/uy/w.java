package com.byazt.uy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.hb.rv;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.kwad.sdk.api.loader.ApiSpUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 819, 13})
public class w implements rv.n {
    public cy l;
    public boolean n;
    public Context q;
    public int qg;
    public cd s;
    public com.byazt.ih.s w;
    public Handler x = new rv(Looper.getMainLooper(), this);

    public w(Context context, cy cyVar, com.byazt.ih.s sVar) {
        this.q = context;
        this.l = cyVar;
        this.w = sVar;
    }

    public void n(cd cdVar) {
        this.s = cdVar;
    }

    public void n() {
        cy cyVar = this.l;
        if (cyVar == null) {
            return;
        }
        JSONObject jSONObjectS = cyVar.s();
        try {
            this.qg = Integer.parseInt(com.byazt.mcb.qg.n(jSONObjectS.optString(ApiSpUtils.SP_INTERVAL, "8000"), this.w.tj()));
            this.n = jSONObjectS.optBoolean("repeat");
            this.x.sendEmptyMessageDelayed(1001, this.qg);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.byazt.hb.rv.n
    public void n(Message message) {
        if (message.what != 1001) {
            return;
        }
        cd cdVar = this.s;
        if (cdVar != null) {
            cy cyVar = this.l;
            com.byazt.ih.s sVar = this.w;
            cdVar.n(cyVar, sVar, sVar);
        }
        if (this.n) {
            this.x.sendEmptyMessageDelayed(1001, this.qg);
        } else {
            this.x.removeMessages(1001);
        }
    }
}

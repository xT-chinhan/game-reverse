package com.byazt.ep;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.vh.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements cd {
    public Context n;
    public com.byazt.ih.s<View> qg;
    public com.byazt.mr.s.n s;

    @Override // com.byazt.vh.cd
    public void n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
    }

    public rv(Context context) {
        this.n = context;
    }

    public void n(com.byazt.mr.s.n nVar) {
        this.s = nVar;
    }

    public void n(final JSONObject jSONObject, final JSONObject jSONObject2, final com.byazt.ozc.x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(jSONObject, jSONObject2, xVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.ep.rv.1
                @Override // java.lang.Runnable
                public void run() {
                    rv.this.qg(jSONObject, jSONObject2, xVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ozc.x xVar) {
        k kVar = new k(this.n);
        sz szVar = new sz();
        szVar.n(this.n);
        kVar.n("ugen_download_dialog", szVar);
        com.byazt.ih.s<View> sVarN = kVar.n(jSONObject);
        this.qg = sVarN;
        if (sVarN != null) {
            kVar.n(this);
            kVar.qg(jSONObject2);
        }
        if (xVar == null) {
            return;
        }
        com.byazt.ih.s<View> sVar = this.qg;
        if (sVar == null) {
            xVar.n(-1, "UGenWidget is null");
        } else {
            xVar.n(sVar);
        }
    }

    @Override // com.byazt.vh.cd
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
        JSONObject jSONObjectS;
        if (cyVar == null || this.s == null) {
            return;
        }
        if (cyVar.qg() != 1 || (jSONObjectS = cyVar.s()) == null) {
        }
        String strOptString = jSONObjectS.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.s.qg(null);
                break;
            case "openAppFunctionDesc":
                this.s.l(null);
                break;
            case "closeDialog":
                this.s.s(null);
                break;
            case "downloadEvent":
                this.s.n(null);
                break;
            case "openAppPolicy":
                this.s.q(null);
                break;
        }
    }
}

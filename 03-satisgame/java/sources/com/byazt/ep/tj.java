package com.byazt.ep;

import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends com.byazt.ey.qg {
    public volatile n w;

    public tj(cd cdVar) {
        super(cdVar);
    }

    @Override // com.byazt.ey.qg
    public void s(cy cyVar, cd.qg qgVar, cd.n nVar) {
        if (this.w == null) {
            this.w = qg();
        }
        this.w.n(cyVar);
        this.w.n(qgVar);
        this.w.n(nVar);
        JSONObject jSONObjectS = cyVar.s();
        if (jSONObjectS == null) {
            return;
        }
        com.byazt.ukb.qg.n(jSONObjectS.optString("type"), (JSONObject) null, (Map<String, Object>) null, new com.byazt.xvf.s() { // from class: com.byazt.ep.tj.1
            @Override // com.byazt.xvf.s
            public void n(com.byazt.dm.qg qgVar2) {
            }

            @Override // com.byazt.xvf.s
            public void n(com.byazt.dm.n nVar2) {
                tj.this.n(nVar2);
            }
        }, this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.dm.n nVar) {
        if (this.l) {
            return;
        }
        n nVarQg = qg();
        nVarQg.n(n(nVarQg.s, nVar));
        nVar.n(nVarQg);
    }

    public cy n(cy cyVar, com.byazt.dm.n nVar) {
        com.byazt.fm.n nVar2;
        if (cyVar == null || nVar == null) {
            return cyVar;
        }
        cy cyVar2 = new cy();
        com.byazt.ih.s sVarN = cyVar.n();
        if (sVarN == null) {
            return cyVar;
        }
        cyVar2.n(cyVar.qg());
        com.byazt.fm.n nVarFs = nVar.fs();
        JSONObject jSONObjectN = n(sVarN, cyVar2, nVarFs);
        com.byazt.fm.s sVarN2 = com.byazt.fm.qg.INSTANCE.n(nVar.q());
        List<com.byazt.fm.n> listN = sVarN2.n(nVarFs, sVarN.tj(), new HashMap());
        cyVar2.n(jSONObjectN);
        if (!listN.isEmpty()) {
            com.byazt.fm.n nVar3 = listN.get(0);
            if (nVar3 == null) {
                return cyVar2;
            }
            cy cyVar3 = new cy();
            cyVar3.n(n(sVarN, cyVar3, nVar3));
            cyVar3.n(sVarN);
            cyVar2.n(cyVar3);
        }
        List<com.byazt.fm.n> listQg = sVarN2.qg(nVarFs, sVarN.tj(), new HashMap());
        if (listQg.isEmpty() || (nVar2 = listQg.get(0)) == null) {
            return cyVar2;
        }
        cy cyVar4 = new cy();
        cyVar4.n(n(sVarN, cyVar4, nVar2));
        cyVar4.n(sVarN);
        cyVar2.qg(cyVar4);
        return cyVar2;
    }

    private JSONObject n(com.byazt.ih.s sVar, cy cyVar, com.byazt.fm.n nVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (nVar == null) {
                return jSONObject;
            }
            Map<String, String> mapW = nVar.w();
            String strN = nVar.n();
            cyVar.n(sVar);
            jSONObject.put("type", strN);
            if (mapW != null && !mapW.isEmpty()) {
                for (Map.Entry<String, String> entry : mapW.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    private n qg() {
        if (this.w != null) {
            return this.w;
        }
        synchronized (n.class) {
            if (this.w != null) {
                return this.w;
            }
            this.w = new n();
            return this.w;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 855})
    class n implements com.byazt.xvf.qg {
        public cd.n n;
        public cd.qg q;
        public cy s;

        public n() {
        }

        public void n(cy cyVar) {
            this.s = cyVar;
        }

        public void n(cd.qg qgVar) {
            this.q = qgVar;
        }

        public void n(cd.n nVar) {
            this.n = nVar;
        }

        @Override // com.byazt.xvf.qg
        public void n() {
            tj.this.qg(this.s, this.q, this.n);
        }
    }
}

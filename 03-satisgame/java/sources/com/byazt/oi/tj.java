package com.byazt.oi;

import com.anythink.core.common.f.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements com.byazt.kmf.w {
    public List<com.byazt.yvo.qg> qg = new CopyOnWriteArrayList();
    public boolean n = false;

    private boolean n() {
        return com.byazt.nf.rv.qg().nq();
    }

    @Override // com.byazt.kmf.w
    public void n(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(a.C0017a.c, "started", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.qg.add(qgVar);
        com.byazt.yvo.s.n(qgVar, xVar.q, xVar);
    }

    @Override // com.byazt.kmf.w
    public void qg(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(a.C0017a.c, "foregrounded", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.qg.add(qgVar);
        com.byazt.yvo.s.n(qgVar, xVar.q, xVar);
    }

    @Override // com.byazt.kmf.w
    public void s(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(a.C0017a.c, "backgrounded", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.qg.add(qgVar);
        com.byazt.yvo.s.n(qgVar, xVar.q, xVar);
        if (this.n || xVar == null) {
            return;
        }
        n(xVar);
    }

    @Override // com.byazt.kmf.w
    public void q(com.byazt.wea.x xVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (this.n) {
            return;
        }
        this.n = true;
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(a.C0017a.c, "end", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.qg.add(qgVar);
        com.byazt.yvo.s.n(qgVar, xVar.q, xVar);
        n(xVar);
    }

    private void n(com.byazt.wea.x xVar) {
        if (xVar == null) {
            return;
        }
        com.byazt.yvo.q.n(this.qg);
        Iterator<com.byazt.yvo.qg> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (n()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", xVar.n());
                jSONObject.putOpt("node_line_name", "app_node_line");
                com.byazt.yvo.q.n(jSONObject, xVar, this.qg, a.C0017a.c);
            } catch (Throwable unused) {
            }
        }
    }
}

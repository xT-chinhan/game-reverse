package com.byazt.oi;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, 26})
public class qg implements com.byazt.kmf.n {
    public boolean l;
    public com.byazt.wea.qg q;
    public List<com.byazt.yvo.qg> s = new CopyOnWriteArrayList();
    public boolean n = false;
    public com.byazt.ot.n.qg qg = new com.byazt.ot.n.qg() { // from class: com.byazt.oi.qg.1
        @Override // com.byazt.ot.n.qg
        public void q() {
        }

        @Override // com.byazt.ot.n.qg
        public void qg() {
        }

        @Override // com.byazt.ot.n.qg
        public void s() {
        }

        @Override // com.byazt.ot.n.qg
        public void n() {
            if (com.byazt.vyf.s.cy().lh() || !qg.this.l || qg.this.n || qg.this.q == null || qg.this.q.q == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", qg.this.q.n());
                jSONObject.putOpt("download_type", Integer.valueOf(qg.this.q.x));
                jSONObject.putOpt("node_line_name", "download_node_line");
                com.byazt.yvo.q.n(jSONObject, qg.this.q, (List<com.byazt.yvo.qg>) qg.this.s, "download");
            } catch (Throwable unused) {
            }
        }
    };

    private boolean n() {
        com.byazt.wea.qg qgVar;
        if (com.byazt.nf.rv.qg().ih() || (qgVar = this.q) == null) {
            return com.byazt.nf.rv.qg().bs();
        }
        return qgVar.s();
    }

    private void n(com.byazt.wea.qg qgVar) {
        if (this.q == null) {
            this.q = qgVar;
        }
        if (!n() || this.n) {
            return;
        }
        com.byazt.vyf.s.cy().s().n(this.qg);
    }

    @Override // com.byazt.kmf.n
    public void n(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "created", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void qg(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "started", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void s(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "market_opened", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void q(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "market_closed", wVar != null ? wVar.n() : System.currentTimeMillis(), 1);
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void l(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "download_started", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void w(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "download_paused", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void x(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "download_failed", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void fs(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "download_canceled", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void rv(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.l = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "download_finished", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
    }

    @Override // com.byazt.kmf.n
    public void tj(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (this.n) {
            return;
        }
        this.n = true;
        com.byazt.vyf.s.cy().s().qg(this.qg);
        com.byazt.yvo.qg qgVar2 = new com.byazt.yvo.qg("download", "end", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar2);
        com.byazt.yvo.s.n(qgVar2, qgVar.q, qgVar);
        if (this.l) {
            qg(qgVar);
        }
    }

    private void qg(com.byazt.wea.qg qgVar) {
        if (qgVar == null || qgVar.q == null) {
            return;
        }
        com.byazt.yvo.q.n(this.s);
        Iterator<com.byazt.yvo.qg> it = this.s.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (n()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", qgVar.n());
                jSONObject.putOpt("download_type", Integer.valueOf(this.q.x));
                com.byazt.yvo.q.n(this.s, qgVar, "download_node_line", jSONObject);
                com.byazt.yvo.q.n(com.byazt.yvo.n.n("download") + qgVar.n(), qgVar.qg());
            } catch (Throwable unused) {
            }
        }
    }
}

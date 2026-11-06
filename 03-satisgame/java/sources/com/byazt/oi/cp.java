package com.byazt.oi;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, 29})
public class cp implements com.byazt.kmf.x {
    public com.byazt.wea.rv l;
    public boolean q;
    public List<com.byazt.yvo.qg> s = new CopyOnWriteArrayList();
    public boolean n = false;
    public com.byazt.ot.n.qg qg = new com.byazt.ot.n.qg() { // from class: com.byazt.oi.cp.1
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
            if (com.byazt.vyf.s.cy().lh() || cp.this.n || cp.this.l == null || cp.this.l.q == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", cp.this.l.n());
                if (!TextUtils.isEmpty(cp.this.l.fs)) {
                    jSONObject.putOpt("style_id", cp.this.l.fs);
                }
                jSONObject.putOpt("style_category", Integer.valueOf(cp.this.l.rv));
                jSONObject.putOpt("component_type", Integer.valueOf(cp.this.l.x));
                jSONObject.putOpt("render_sequence", Integer.valueOf(cp.this.l.tj));
                jSONObject.putOpt("display_area", Integer.valueOf(cp.this.l.cp));
                jSONObject.putOpt("node_line_name", "easy_play_node_line");
                com.byazt.yvo.q.n(jSONObject, cp.this.l, (List<com.byazt.yvo.qg>) cp.this.s, "easy_play");
            } catch (Throwable unused) {
            }
        }
    };

    private boolean n() {
        com.byazt.wea.rv rvVar;
        if (com.byazt.nf.rv.qg().rk() || (rvVar = this.l) == null) {
            return com.byazt.nf.rv.qg().kv();
        }
        return rvVar.s();
    }

    private void n(com.byazt.wea.rv rvVar) {
        if (this.l == null) {
            this.l = rvVar;
        }
        if (!n() || this.n) {
            return;
        }
        this.l = rvVar;
        com.byazt.vyf.s.cy().s().n(this.qg);
    }

    @Override // com.byazt.kmf.x
    public void n(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "created", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
    }

    @Override // com.byazt.kmf.x
    public void qg(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        n(rvVar);
        this.q = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "started", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
    }

    @Override // com.byazt.kmf.x
    public void s(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        n(rvVar);
        this.q = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "loaded", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
    }

    @Override // com.byazt.kmf.x
    public void q(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        n(rvVar);
        this.q = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "render_started", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
    }

    @Override // com.byazt.kmf.x
    public void l(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        n(rvVar);
        this.q = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "rendered", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
    }

    @Override // com.byazt.kmf.x
    public void w(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        n(rvVar);
        this.q = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "showed", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
    }

    @Override // com.byazt.kmf.x
    public void x(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        n(rvVar);
        this.q = true;
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "clicked", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
    }

    @Override // com.byazt.kmf.x
    public void fs(com.byazt.wea.rv rvVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (this.n) {
            return;
        }
        this.n = true;
        com.byazt.vyf.s.cy().s().qg(this.qg);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("easy_play", "end", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, rvVar.q, rvVar);
        if (this.q) {
            qg(rvVar);
        }
    }

    private void qg(com.byazt.wea.rv rvVar) {
        if (rvVar == null || rvVar.q == null) {
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
                jSONObject.putOpt("lifecycle_id", this.l.n());
                if (!TextUtils.isEmpty(this.l.fs)) {
                    jSONObject.putOpt("style_id", this.l.fs);
                }
                jSONObject.putOpt("style_category", Integer.valueOf(this.l.rv));
                jSONObject.putOpt("component_type", Integer.valueOf(this.l.x));
                jSONObject.putOpt("render_sequence", Integer.valueOf(this.l.tj));
                jSONObject.putOpt("display_area", Integer.valueOf(this.l.cp));
                com.byazt.yvo.q.n(this.s, rvVar, "easy_play_node_line", jSONObject);
                com.byazt.yvo.q.n(com.byazt.yvo.n.n("easy_play") + rvVar.n(), rvVar.w);
            } catch (Throwable unused) {
            }
        }
    }
}

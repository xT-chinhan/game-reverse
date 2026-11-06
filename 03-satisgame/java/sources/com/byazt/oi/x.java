package com.byazt.oi;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, 21})
public class x implements com.byazt.kmf.q {
    public com.byazt.wea.l q;
    public List<com.byazt.yvo.qg> s = new CopyOnWriteArrayList();
    public boolean n = false;
    public com.byazt.ot.n.qg qg = new com.byazt.ot.n.qg() { // from class: com.byazt.oi.x.1
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
            if (com.byazt.vyf.s.cy().lh() || x.this.n || x.this.q == null || x.this.q.q == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", x.this.q.n());
                jSONObject.putOpt("video_type", Integer.valueOf(x.this.q.x));
                jSONObject.putOpt("node_line_name", "video_node_line");
                com.byazt.yvo.q.n(jSONObject, x.this.q, (List<com.byazt.yvo.qg>) x.this.s, MediaFormat.KEY_VIDEO);
            } catch (Throwable unused) {
            }
        }
    };

    private boolean n() {
        com.byazt.wea.l lVar;
        if (com.byazt.nf.rv.qg().fe() || (lVar = this.q) == null) {
            return com.byazt.nf.rv.qg().nc();
        }
        return lVar.s();
    }

    private void n(com.byazt.wea.l lVar) {
        if (this.q == null) {
            this.q = lVar;
        }
        if (!n() || this.n) {
            return;
        }
        this.q = lVar;
        com.byazt.vyf.s.cy().s().n(this.qg);
    }

    @Override // com.byazt.kmf.q
    public void n(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "created", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void qg(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "initialized", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void s(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "started", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void q(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "prepared", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void l(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "played", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void w(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "buffered", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void x(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "paused", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void fs(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "stopped", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void rv(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        n(lVar);
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "completed", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
    }

    @Override // com.byazt.kmf.q
    public void tj(com.byazt.wea.l lVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (this.n) {
            return;
        }
        this.n = true;
        com.byazt.vyf.s.cy().s().qg(this.qg);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg(MediaFormat.KEY_VIDEO, "end", wVar != null ? wVar.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, lVar.q, lVar);
        qg(lVar);
    }

    private void qg(com.byazt.wea.l lVar) {
        if (lVar == null || lVar.q == null) {
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
                jSONObject.putOpt("lifecycle_id", this.q.n());
                jSONObject.putOpt("video_type", Integer.valueOf(this.q.x));
                com.byazt.yvo.q.n(this.s, lVar, "video_node_line", jSONObject);
                com.byazt.yvo.q.n(com.byazt.yvo.n.n(MediaFormat.KEY_VIDEO) + lVar.n(), lVar.qg());
            } catch (Throwable unused) {
            }
        }
    }
}

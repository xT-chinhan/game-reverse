package com.byazt.oi;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements com.byazt.kmf.l {
    public com.byazt.wea.w l;
    public boolean q;
    public List<com.byazt.yvo.qg> s = new CopyOnWriteArrayList();
    public boolean n = false;
    public com.byazt.ot.n.qg qg = new com.byazt.ot.n.qg() { // from class: com.byazt.oi.rv.1
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
            if (com.byazt.vyf.s.cy().lh() || rv.this.n || rv.this.l == null || rv.this.l.q == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", rv.this.l.n());
                jSONObject.putOpt("container_rect", rv.this.l.x);
                jSONObject.putOpt("image_rect", rv.this.l.fs);
                jSONObject.putOpt("video_rect", rv.this.l.rv);
                if (rv.this.l.tj > 0) {
                    jSONObject.putOpt("image_mode", Integer.valueOf(rv.this.l.tj));
                }
                jSONObject.putOpt("node_line_name", "view_node_line");
                com.byazt.yvo.q.n(jSONObject, rv.this.l, (List<com.byazt.yvo.qg>) rv.this.s, "view");
            } catch (Throwable unused) {
            }
        }
    };

    private boolean n() {
        com.byazt.wea.w wVar;
        if (com.byazt.nf.rv.qg().hw() || (wVar = this.l) == null) {
            return com.byazt.nf.rv.qg().vc();
        }
        return wVar.s();
    }

    private void n(com.byazt.wea.w wVar) {
        if (this.l == null) {
            this.l = wVar;
        }
        if (!n() || this.n) {
            return;
        }
        this.l = wVar;
        com.byazt.vyf.s.cy().s().n(this.qg);
    }

    @Override // com.byazt.kmf.l
    public void n(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.yvo.q.n(wVar2);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("view", "created", wVar2 != null ? wVar2.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, wVar.q, wVar);
    }

    @Override // com.byazt.kmf.l
    public void qg(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.yvo.q.n(wVar2);
        n(wVar);
        this.q = true;
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("view", "attached", wVar2 != null ? wVar2.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, wVar.q, wVar);
    }

    @Override // com.byazt.kmf.l
    public void s(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.yvo.q.n(wVar2);
        n(wVar);
        this.q = true;
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("view", "focused", wVar2 != null ? wVar2.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar2));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, wVar.q, wVar);
    }

    @Override // com.byazt.kmf.l
    public void q(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.yvo.q.n(wVar2);
        n(wVar);
        this.q = true;
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("view", "visibled", wVar2 != null ? wVar2.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, wVar.q, wVar);
    }

    @Override // com.byazt.kmf.l
    public void l(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.yvo.q.n(wVar2);
        n(wVar);
        this.q = true;
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("view", "invisibled", wVar2 != null ? wVar2.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, wVar.q, wVar);
    }

    @Override // com.byazt.kmf.l
    public void w(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.yvo.q.n(wVar2);
        n(wVar);
        this.q = true;
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("view", "detached", wVar2 != null ? wVar2.n() : System.currentTimeMillis());
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, wVar.q, wVar);
    }

    @Override // com.byazt.kmf.l
    public void x(com.byazt.wea.w wVar, com.byazt.bok.w wVar2) {
        com.byazt.yvo.q.n(wVar2);
        if (this.n) {
            return;
        }
        this.n = true;
        com.byazt.vyf.s.cy().s().qg(this.qg);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("view", "end", wVar2 != null ? wVar2.n() : System.currentTimeMillis(), com.byazt.yvo.q.n(wVar2));
        this.s.add(qgVar);
        com.byazt.yvo.s.n(qgVar, wVar.q, wVar);
        if (this.q) {
            qg(wVar);
        }
    }

    private void qg(com.byazt.wea.w wVar) {
        if (wVar == null || wVar.q == null) {
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
                jSONObject.putOpt("container_rect", this.l.x);
                jSONObject.putOpt("image_rect", this.l.fs);
                jSONObject.putOpt("video_rect", this.l.rv);
                if (this.l.tj > 0) {
                    jSONObject.putOpt("image_mode", Integer.valueOf(this.l.tj));
                }
                com.byazt.yvo.q.n(this.s, wVar, "view_node_line", jSONObject);
                com.byazt.yvo.q.n(com.byazt.yvo.n.n("view") + wVar.n(), wVar.w);
            } catch (Throwable unused) {
            }
        }
    }
}

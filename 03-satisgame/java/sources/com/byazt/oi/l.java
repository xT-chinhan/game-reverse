package com.byazt.oi;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, 18})
public class l implements com.byazt.kmf.s {
    public com.byazt.wea.q w;
    public int n = 0;
    public int qg = 0;
    public int s = 0;
    public volatile boolean l = false;
    public com.byazt.ot.n.qg q = new com.byazt.ot.n.qg() { // from class: com.byazt.oi.l.1
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
            if (com.byazt.vyf.s.cy().lh()) {
                return;
            }
            final com.byazt.wea.q qVar = l.this.w;
            com.byazt.ag.qg.l(new Runnable() { // from class: com.byazt.oi.l.1.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.wea.q qVar2;
                    try {
                        if (!l.this.l && (qVar2 = qVar) != null && qVar2.q != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.putOpt("ad_load_id", qVar.x);
                            jSONObject.putOpt("ad_show_id", qVar.n());
                            jSONObject.putOpt("node_line_name", "ad_node_line");
                            l.this.n(qVar.n(), jSONObject);
                            l.this.n(jSONObject, qVar);
                            com.byazt.wea.q qVar3 = qVar;
                            com.byazt.yvo.q.n(jSONObject, qVar3, qVar3.k, "ad_show");
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    };

    @Override // com.byazt.kmf.s
    public void n(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_show", "created", wVar != null ? wVar.n() : System.currentTimeMillis());
        qVar.k.add(qgVar);
        com.byazt.yvo.s.n(qgVar, qVar.q, qVar);
    }

    @Override // com.byazt.kmf.s
    public void qg(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (n() && !this.l) {
            this.w = qVar;
            com.byazt.vyf.s.cy().s().n(this.q);
        }
        this.n++;
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_show", "started", wVar != null ? wVar.n() : System.currentTimeMillis());
        qVar.k.add(qgVar);
        com.byazt.yvo.s.n(qgVar, qVar.q, qVar);
    }

    @Override // com.byazt.kmf.s
    public void q(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_show", "visibled", wVar != null ? wVar.n() : System.currentTimeMillis(), qVar.rv);
        qVar.k.add(qgVar);
        com.byazt.yvo.s.n(qgVar, qVar.q, qVar);
    }

    @Override // com.byazt.kmf.s
    public void l(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_show", "invisibled", wVar != null ? wVar.n() : System.currentTimeMillis(), qVar.rv);
        qVar.k.add(qgVar);
        com.byazt.yvo.s.n(qgVar, qVar.q, qVar);
    }

    @Override // com.byazt.kmf.s
    public void s(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (n() && !this.l) {
            this.w = qVar;
            com.byazt.vyf.s.cy().s().n(this.q);
        }
        boolean zIt = com.byazt.nf.rv.qg().it();
        if (!qVar.tj || zIt) {
            com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_show", "showed", wVar != null ? wVar.n() : System.currentTimeMillis());
            qgVar.n(qVar.cp);
            this.qg++;
            qVar.k.add(qgVar);
            com.byazt.yvo.s.n(qgVar, qVar.q, qVar);
            if (this.qg > 1) {
                qVar.l = 1;
            }
        }
    }

    @Override // com.byazt.kmf.s
    public void w(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (n() && !this.l) {
            this.w = qVar;
            com.byazt.vyf.s.cy().s().n(this.q);
        }
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_show", "clicked", wVar != null ? wVar.n() : System.currentTimeMillis());
        qVar.k.add(qgVar);
        com.byazt.yvo.s.n(qgVar, qVar.q, qVar);
        this.s++;
        if (this.qg == 0) {
            qVar.l = 2;
        }
    }

    @Override // com.byazt.kmf.s
    public void x(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        if (this.l) {
            return;
        }
        this.l = true;
        com.byazt.vyf.s.cy().s().qg(this.q);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_show", "end", wVar != null ? wVar.n() : System.currentTimeMillis(), qVar.fs);
        qVar.k.add(qgVar);
        com.byazt.yvo.s.n(qgVar, qVar.q, qVar);
        n(qVar);
    }

    private void n(com.byazt.wea.q qVar) {
        if (qVar == null || qVar.q == null) {
            return;
        }
        com.byazt.yvo.q.n(qVar.k);
        Iterator<com.byazt.yvo.qg> it = qVar.k.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (!(this.qg == 0 && this.s == 0 && this.n == 0) && n()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("ad_load_id", qVar.x);
                jSONObject.putOpt("ad_show_id", qVar.n());
                n(qVar.n(), jSONObject);
                n(jSONObject, qVar);
                com.byazt.yvo.q.n(qVar.k, qVar, "ad_node_line", jSONObject);
                com.byazt.yvo.q.n(com.byazt.yvo.n.n("ad_show") + qVar.n(), qVar.w);
                com.byazt.de.qg.q(qVar.n());
            } catch (Throwable unused) {
            }
        }
    }

    private boolean n() {
        com.byazt.wea.q qVar;
        if (com.byazt.nf.rv.qg().nh() || (qVar = this.w) == null) {
            return com.byazt.nf.rv.qg().se();
        }
        return qVar.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Object objQ = com.byazt.de.qg.q(str, 0);
        Object objQ2 = com.byazt.de.qg.q(str, 1);
        Object objQ3 = com.byazt.de.qg.q(str, 2);
        Object objQ4 = com.byazt.de.qg.q(str, 3);
        try {
            if (objQ instanceof JSONObject) {
                jSONObject.putOpt("key_element_info", objQ);
            }
            if (objQ2 instanceof JSONArray) {
                jSONObject.putOpt("no_action_array", objQ2);
            }
            if (objQ3 instanceof JSONObject) {
                jSONObject.putOpt("motion_info", objQ3);
            }
            if (objQ4 instanceof JSONObject) {
                jSONObject.putOpt("ad_user_interact_data", objQ4);
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, com.byazt.wea.q qVar) {
        if (qVar == null || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("has_send_show_event", Integer.valueOf(qVar.cp));
            jSONObject.putOpt("has_send_click_event", Integer.valueOf(qVar.d));
            jSONObject.putOpt("send_show_event_result", Integer.valueOf(qVar.oa));
            jSONObject.putOpt("send_click_event_result", Integer.valueOf(qVar.sz));
            if (qVar.q != null) {
                jSONObject.putOpt("has_media_cache_action", Integer.valueOf(qVar.q.jh()));
                jSONObject.putOpt("media_height_price_show", Integer.valueOf(qVar.q.xb()));
            }
        } catch (Exception unused) {
        }
    }
}

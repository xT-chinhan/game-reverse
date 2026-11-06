package com.byazt.oi;

import com.byazt.gct.nf;
import com.byazt.gct.pk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, 13})
public class w implements com.byazt.kmf.s {
    public com.byazt.wea.q qg;
    public com.byazt.kld.qg w;
    public volatile boolean s = false;
    public volatile boolean q = false;
    public volatile boolean l = false;
    public com.byazt.ot.n.qg n = new com.byazt.ot.n.qg() { // from class: com.byazt.oi.w.1
        @Override // com.byazt.ot.n.qg
        public void q() {
        }

        @Override // com.byazt.ot.n.qg
        public void s() {
        }

        @Override // com.byazt.ot.n.qg
        public void n() {
            if (com.byazt.vyf.s.cy().lh() || w.this.s) {
                return;
            }
            w.this.n();
        }

        @Override // com.byazt.ot.n.qg
        public void qg() {
            if (com.byazt.vyf.s.cy().lh() || w.this.s || !w.this.q) {
                return;
            }
            w.this.q();
        }
    };

    @Override // com.byazt.kmf.s
    public void l(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void n(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void q(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void qg(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void w(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void s(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (this.s) {
            return;
        }
        this.qg = qVar;
        qg();
        if (this.q) {
            com.byazt.vyf.s.cy().s().n(this.n);
            q();
        }
    }

    @Override // com.byazt.kmf.s
    public void x(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        if (this.s) {
            return;
        }
        this.s = true;
        com.byazt.vyf.s.cy().s().qg(this.n);
        n();
        this.w = null;
    }

    private void qg() {
        int i;
        boolean zS;
        com.byazt.wea.q qVar = this.qg;
        if (qVar == null || qVar.q == null || !nf.rv(this.qg.q)) {
            return;
        }
        pk pkVar = this.qg.q;
        com.byazt.pnm.w wVarXk = com.byazt.nf.rv.qg().xk();
        com.byazt.zq.qg qgVarXd = pkVar.xd();
        String strH = pkVar.h();
        com.byazt.vhv.q qVarX = com.byazt.vhv.q.x();
        boolean zS2 = qVarX.s();
        int iFs = qVarX.fs();
        boolean zQ = qVarX.q();
        int i2 = 0;
        if (wVarXk == null || qgVarXd == null) {
            i = wVarXk != null ? 2 : 1;
            zS = false;
        } else {
            int iA = qgVarXd.a();
            if (iA <= 0) {
                iA = com.byazt.vgx.w.d(pkVar);
            }
            boolean zS3 = wVarXk.s(iA);
            zS = s();
            this.l = wVarXk.rv();
            this.q = zS3 && zS && zS2 && zQ;
            i = 0;
            i2 = iA;
        }
        n(i2, strH, zS2, zQ, zS, i, iFs);
    }

    private void n(int i, String str, boolean z, boolean z2, boolean z3, int i2, int i3) {
        JSONObject jSONObjectN = com.byazt.vhv.qg.n(str);
        if (jSONObjectN == null) {
            return;
        }
        try {
            jSONObjectN.put("pitaya_init_success", com.byazt.gh.q.qg());
            jSONObjectN.put("pkg_state", i3);
            jSONObjectN.put("ext_plugin_code", com.byazt.vzq.s.qg());
            jSONObjectN.put("setting_delay", com.byazt.nf.rv.qg().mt());
            jSONObjectN.put("last_setting_time", com.byazt.ehw.qg.s());
            jSONObjectN.put("empty_type", i2);
            jSONObjectN.put("ad_type", i);
            jSONObjectN.put("is_enable", z);
            jSONObjectN.put("can_request_and_dl_ext", com.byazt.nf.rv.qg().oj());
            jSONObjectN.put("has_update", z2);
            if (com.byazt.vyf.n.sInitSuccessTime > 0) {
                jSONObjectN.put("delt_init", System.currentTimeMillis() - com.byazt.vyf.n.sInitSuccessTime);
            } else {
                jSONObjectN.put("delt_init", 0);
            }
            jSONObjectN.put("can_collect_sensor_event", z3);
            jSONObjectN.put("collect_accelerometer", this.l);
            jSONObjectN.put("is_sensor_event_recorded", this.q);
            jSONObjectN.put("package_version", com.byazt.vhv.q.x().l());
            if (this.qg.q != null) {
                jSONObjectN.put("aspect_ratio", this.qg.q.sl());
            }
        } catch (Exception unused) {
        }
    }

    private boolean s() {
        com.byazt.tk.q qVarN = com.byazt.tk.q.n(com.byazt.nf.rv.getContext());
        return (qVarN.n(15) == null || qVarN.n(10) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.qg == null) {
            return;
        }
        if (this.w == null) {
            this.w = new com.byazt.kld.qg();
        }
        this.qg.cd = this.w;
        this.w.n(this.l, false, true, this.qg.q);
    }

    public void n() {
        com.byazt.kld.qg qgVar = this.w;
        if (qgVar != null) {
            qgVar.n();
        }
    }
}

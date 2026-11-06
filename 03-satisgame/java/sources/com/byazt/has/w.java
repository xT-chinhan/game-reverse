package com.byazt.has;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.anythink.core.common.h.au;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.gct.df;
import com.byazt.gct.e;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, 13})
public class w extends n {
    public com.byazt.ys.n an;
    public com.byazt.xk.qg j;
    public final AtomicBoolean lh;
    public boolean ln;
    public boolean v;

    public static int qg(pk pkVar) {
        return 2;
    }

    @Override // com.byazt.has.qg
    public boolean ci() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean cx() {
        return true;
    }

    public w(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
        this.ln = false;
        this.lh = new AtomicBoolean(false);
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return cx() && nf.n(this.qg) == 1;
    }

    public static boolean n(pk pkVar) {
        return com.byazt.gks.n.n(pkVar);
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return cx.s(this.qg, x());
    }

    @Override // com.byazt.has.qg
    public void dn() {
        if (w()) {
            this.cd.qg(false);
            this.cd.l(false);
            this.rv.w(8);
            this.rv.l(8);
            this.rv.s(8);
        } else {
            this.cd.qg(this.qg.yv());
            this.cd.l(true);
            this.rv.w(0);
            this.rv.l(0);
            this.rv.s(0);
        }
        this.n.sh();
    }

    @Override // com.byazt.has.n
    public View rv() {
        if (this.q != 100.0f) {
            return com.byazt.cb.qg.wm(this.n);
        }
        if (this.s == 2) {
            return com.byazt.cb.qg.k(this.n);
        }
        return com.byazt.cb.qg.cy(this.n);
    }

    @Override // com.byazt.has.n
    public com.byazt.tkz.qg n(boolean z) {
        if (this.q != 100.0f) {
            this.rv = new com.byazt.tkz.x(this.n, this.qg, z);
        } else {
            this.rv = new com.byazt.tkz.fs(this.n, this.qg, z);
        }
        return this.rv;
    }

    @Override // com.byazt.has.n
    public void cd() {
        super.cd();
        this.rv.s(0);
    }

    @Override // com.byazt.has.n
    public boolean um() {
        if (this.v) {
            return true;
        }
        return (com.byazt.wq.qg.n().qg(this.qg) || e.s(this.qg)) ? false : true;
    }

    @Override // com.byazt.has.n
    public void n(int i, int i2, Intent intent) {
        super.n(i, i2, intent);
        if (e.s(this.qg) || i != 1 || intent == null || intent.getExtras() == null || this.v) {
            return;
        }
        long j = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int iOj = (int) (((long) oj()) - j);
        this.n.n(iOj, false);
        if (j <= 0) {
            tj(true);
            q(0);
            this.v = true;
            return;
        }
        n(iOj);
    }

    private void n(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j);
            if (this.tj == null || !this.tj.l()) {
                return;
            }
            this.tj.n("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.has.n
    public void qg(boolean z) {
        super.qg(z);
        if (!com.byazt.ikv.n.n().qg("is_reward_deep_link_to_live", false) || e.s(this.qg) || z) {
            return;
        }
        com.byazt.nf.rv.n().n(fl(), new com.byazt.mw.n.q() { // from class: com.byazt.has.w.1
            @Override // com.byazt.mw.n.q
            public void n(int i, String str) {
                w.this.tj(false);
            }

            @Override // com.byazt.mw.n.q
            public void n(com.byazt.mw.qg.s sVar) {
                if (sVar.s == null) {
                    return;
                }
                boolean zN = sVar.s.n();
                w.this.tj(zN);
                if (zN) {
                    w.this.n.q(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z);
            if (this.tj != null) {
                this.tj.n("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    private JSONObject fl() {
        JSONObject jSONObject = new JSONObject();
        df dfVarA = this.qg.a();
        if (dfVarA == null) {
            return jSONObject;
        }
        String strQ = dfVarA.q();
        if (TextUtils.isEmpty(strQ)) {
            return jSONObject;
        }
        try {
            String strOptString = new JSONObject(strQ).optString(au.b.a);
            jSONObject.put("req_id", dfVarA.w());
            jSONObject.put(au.b.a, strOptString);
            jSONObject.put("action", "query_box");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.byazt.has.n
    public void ou() {
        super.ou();
        vb();
        if (this.tj.l()) {
            return;
        }
        if (com.byazt.wq.qg.n().qg(this.qg)) {
            i();
            return;
        }
        if (e.n(this.qg) && this.j == null && !com.byazt.ikv.n.n().qg("is_reward_deep_link_to_live", false) && e.l(this.qg) != 1 && this.um.bb() >= ((long) e.x(this.qg)) * 1000) {
            this.lh.set(true);
            if (this.um != null && this.um.qg()) {
                this.n.dg();
            }
            this.j = new com.byazt.xk.qg(this.n, this.qg, new com.byazt.xk.qg.n() { // from class: com.byazt.has.w.2
                @Override // com.byazt.xk.qg.n
                public void n(Dialog dialog) {
                    w.this.j.dismiss();
                    w.this.n.u();
                    w.this.lh.set(false);
                }

                @Override // com.byazt.xk.qg.n
                public void qg(Dialog dialog) {
                    if (w.this.an != null) {
                        HashMap map = new HashMap();
                        map.put("is_auto_click", Boolean.TRUE);
                        ((com.byazt.fq.n) w.this.an.n(com.byazt.fq.n.class)).n(map);
                        w.this.an.n(null, new com.byazt.gct.tj());
                    }
                }
            });
            com.byazt.ys.n nVar = new com.byazt.ys.n(this.n, this.qg, this.d, 7) { // from class: com.byazt.has.w.3
                @Override // com.byazt.ys.qg, com.byazt.ys.l
                public void n(View view, com.byazt.gct.tj tjVar) {
                    super.n(view, tjVar);
                    w.this.j.dismiss();
                }
            };
            this.an = nVar;
            this.n.n((com.byazt.fq.s) nVar.n(com.byazt.fq.s.class));
            this.j.n(this.an);
            if (this.n.isFinishing()) {
                return;
            }
            this.j.show();
        }
    }

    @Override // com.byazt.has.n
    public boolean j() {
        return this.lh.get();
    }

    private void i() {
        if (this.ln || this.fs == null) {
            return;
        }
        if (((com.byazt.zct.n) this.fs.n(com.byazt.zct.n.class)).qg().cp()) {
            this.ln = true;
            qg(8, 0);
            return;
        }
        if (e.n(this.qg)) {
            int iL = e.l(this.qg);
            if (this.qg.ys() == 2) {
                qg(0, -1);
            }
            if (iL != 3) {
                return;
            }
            long jX = ((long) e.x(this.qg)) * 1000;
            if (this.um.bb() >= jX) {
                qg(8, 0);
                dw();
                this.ln = true;
                return;
            }
            qg(0, (int) ((jX - this.um.bb()) / 1000));
        }
    }

    private void qg(int i, int i2) {
        if (this.rv != null && (this.rv instanceof com.byazt.tkz.fs)) {
            ((com.byazt.tkz.fs) this.rv).n(i, i2);
        }
    }

    private void dw() {
        if (this.fs == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_auto_click", Boolean.TRUE);
        ((com.byazt.fq.n) this.fs.n(com.byazt.fq.n.class)).n(map);
        this.fs.n(null, new com.byazt.gct.tj());
    }

    public void vb() {
        if (e.n(this.qg)) {
            df dfVarA = this.qg.a();
            if (dfVarA != null || com.byazt.wq.qg.n().qg(this.qg)) {
                int iOj = oj();
                if (dfVarA != null) {
                    dfVarA.n(iOj);
                }
                q(iOj);
            }
        }
    }

    private void q(int i) {
        if (this.fs != null) {
            ((com.byazt.zct.n) this.fs.n(com.byazt.zct.n.class)).n(i);
        }
        if (this.wm != null) {
            ((com.byazt.zct.n) this.wm.n(com.byazt.zct.n.class)).n(i);
        }
        if (this.ou != null) {
            ((com.byazt.zct.n) this.ou.n(com.byazt.zct.n.class)).n(i);
        }
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }
}

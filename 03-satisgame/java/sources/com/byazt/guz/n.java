package com.byazt.guz;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.byazt.ep.fs;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.ih.s;
import com.byazt.il.PageWebView;
import com.byazt.jc.q;
import com.byazt.vh.a;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.vh.sz;
import com.byazt.vyf.l;
import com.byazt.xz.x;
import com.byazt.ys.qg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1230, 19})
public class n implements a, cd {
    public tj fs;
    public s l;
    public Context n;
    public pk q;
    public ViewGroup qg;
    public JSONObject rv;
    public com.byazt.ai.n s;
    public Map<String, Object> tj;
    public com.byazt.au.n w;
    public qg x;

    @Override // com.byazt.vh.cd
    public void n(s sVar, String str, x.n nVar) {
    }

    public n(Context context, ViewGroup viewGroup, com.byazt.ai.n nVar, pk pkVar) {
        this.n = context;
        this.qg = viewGroup;
        this.s = nVar;
        this.q = pkVar;
    }

    public void n(com.byazt.au.n nVar) {
        this.w = nVar;
    }

    public void n(DownloadListener downloadListener) {
        PageWebView.n(this.rv, downloadListener);
    }

    public void n() {
        com.byazt.ai.n nVar = this.s;
        if (nVar == null) {
            com.byazt.au.n nVar2 = this.w;
            if (nVar2 != null) {
                nVar2.n(-1);
                return;
            }
            return;
        }
        JSONObject jSONObjectN = fs.n().n(nVar.n(), this.s.qg());
        if (jSONObjectN == null) {
            q.n(this.s, new q.qg() { // from class: com.byazt.guz.n.1
                @Override // com.byazt.jc.q.qg
                public void n(JSONObject jSONObject) {
                    n.this.n(jSONObject);
                }

                @Override // com.byazt.jc.q.qg
                public void n() {
                    if (n.this.w != null) {
                        n.this.w.n(-1);
                    }
                }
            });
        } else {
            n(jSONObjectN);
        }
    }

    public void n(final JSONObject jSONObject) {
        final k kVar = new k(this.n);
        final JSONObject jSONObjectPv = this.q.pv();
        this.rv = jSONObjectPv;
        sz szVar = new sz();
        szVar.n(this.n);
        HashMap map = new HashMap();
        map.put("key_reward_page", this.tj);
        szVar.qg(map);
        kVar.n("reward_page", szVar);
        kVar.n((cd) this);
        l.q().post(new Runnable() { // from class: com.byazt.guz.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.l = kVar.n(jSONObject);
                if (n.this.l == null) {
                    if (n.this.w != null) {
                        n.this.w.n(-1);
                    }
                } else {
                    kVar.qg(jSONObjectPv);
                    n.this.qg.addView(n.this.l.rv(), new FrameLayout.LayoutParams(n.this.l.an(), n.this.l.ae()));
                    if (n.this.w != null) {
                        n.this.w.n(n.this.l.rv());
                    }
                }
            }
        });
    }

    @Override // com.byazt.vh.cd
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
        if (cyVar != null && cyVar.qg() == 1) {
            n(cyVar, cyVar.s());
        }
    }

    private void n(cy cyVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (!strOptString.equals("clickEvent")) {
            if (strOptString.equals("openPolicy")) {
                com.byazt.okk.n.n(this.n, this.q);
            }
        } else {
            qg qgVar = this.x;
            if (qgVar != null) {
                qgVar.n(cyVar.n().rv(), this.fs);
            }
        }
    }

    public void n(qg qgVar) {
        this.x = qgVar;
    }

    @Override // com.byazt.vh.a
    public void n(s sVar, MotionEvent motionEvent) {
        this.fs.s(motionEvent.getDeviceId());
        this.fs.qg(motionEvent.getToolType(0));
        this.fs.q(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.fs.s(motionEvent.getRawX());
                this.fs.q(motionEvent.getRawY());
                this.fs.qg(System.currentTimeMillis());
                return;
            } else {
                if (actionMasked != 2) {
                    return;
                }
                this.fs.s(motionEvent.getRawX());
                this.fs.q(motionEvent.getRawY());
                return;
            }
        }
        this.fs.l((int) motionEvent.getRawX());
        this.fs.w((int) motionEvent.getRawY());
        this.fs.n(motionEvent.getRawX());
        this.fs.qg(motionEvent.getRawY());
        this.fs.n(System.currentTimeMillis());
        this.fs.qg(motionEvent.getToolType(0));
        this.fs.s(motionEvent.getDeviceId());
        this.fs.q(motionEvent.getSource());
        this.fs.qg(true);
        com.byazt.vf.x xVar = (com.byazt.vf.x) com.byazt.qp.q.n("armor_service");
        if (xVar != null) {
            xVar.n(motionEvent);
        }
    }

    public void n(Map<String, Object> map) {
        this.tj = map;
    }

    public void qg() {
        PageWebView.n(this.rv);
    }
}

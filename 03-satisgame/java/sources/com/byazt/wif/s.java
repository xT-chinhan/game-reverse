package com.byazt.wif;

import android.content.Context;
import android.view.View;
import com.byazt.ep.cp;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.gct.v;
import com.byazt.llp.rv;
import com.byazt.qit.x;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 572, 8})
public class s {
    public com.byazt.pma.n l;
    public pk n;
    public Context qg;
    public n s;
    public boolean q = true;
    public boolean w = false;
    public int x = 0;
    public boolean fs = false;
    public int rv = -1;

    public s(Context context, pk pkVar) {
        this.qg = context;
        this.n = pkVar;
    }

    public void n(n nVar) {
        n(nVar, this.n);
    }

    public void n(n nVar, rv rvVar) {
        this.s = nVar;
        if (nVar == null) {
            return;
        }
        nVar.n(this.qg);
        nVar.n(rvVar);
        nVar.n(this.q);
    }

    public void n(boolean z) {
        this.q = z;
    }

    public void n(com.byazt.pma.n nVar) {
        this.l = nVar;
    }

    public void qg(boolean z) {
        this.w = z;
    }

    public void n(int i) {
        this.x = i;
    }

    public void qg(int i) {
        this.rv = i;
    }

    public void s(boolean z) {
        this.fs = z;
    }

    public boolean q(boolean z) {
        n nVar = this.s;
        if (nVar == null) {
            return true;
        }
        nVar.qg(z || this.fs);
        n nVar2 = this.s;
        if (nVar2 instanceof qg) {
            qg qgVar = (qg) nVar2;
            qgVar.s(this.w);
            qgVar.n(this.x);
        }
        int i = this.rv;
        if (i == 1) {
            this.s.q = 4;
            return true;
        }
        if (i == 0) {
            return false;
        }
        return this.s.n();
    }

    public void n(String str, com.byazt.pma.qg qgVar) {
        if (this.n == null) {
            return;
        }
        n((com.byazt.gct.q) null, str, qgVar);
    }

    public void n(com.byazt.gct.q qVar, final String str, final String str2, final com.byazt.pma.qg qgVar) {
        pk pkVar = this.n;
        if (pkVar == null) {
            return;
        }
        if (qVar != null || pkVar.lx() != 2 || (this.s instanceof l)) {
            n(qVar, str, qgVar);
        } else {
            com.byazt.qit.l.qg(new x("tt_download_check") { // from class: com.byazt.wif.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.this.n(com.byazt.nf.rv.n().n(s.this.n, str2), str, qgVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.gct.q qVar, String str, com.byazt.pma.qg qgVar) {
        String strNn;
        String strS;
        String strN;
        com.byazt.okk.n.InterfaceC0282n interfaceC0282nQg = qg(str, qgVar);
        try {
            if (qVar != null) {
                com.byazt.gct.w wVarCd = this.n.cd();
                if (wVarCd != null) {
                    qVar.n(wVarCd.q());
                    qVar.n(wVarCd.s());
                }
                strNn = qVar.fs();
                strS = qVar.n();
                strN = qVar.q();
            } else {
                strNn = this.n.nn();
                strS = com.byazt.oh.l.s(this.n);
                v vVarXu = this.n.xu();
                strN = vVarXu != null ? vVarXu.n() : "";
            }
            if (cp.rv(this.n)) {
                if (!cp.n(this.qg, this.n, strS)) {
                    pk pkVar = this.n;
                    n(pkVar, str, cp.qg(this.qg, pkVar, strS), 0, "");
                }
            } else {
                com.byazt.hm.n.qg(this.n, str, "pop_up", n());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", strS);
            jSONObject.put("dialog_icon_url", strN);
            jSONObject.put("dialog_app_description", this.n.m19if());
            String strN2 = n(strNn);
            qg(str);
            com.byazt.pma.n nVar = this.l;
            if (nVar != null) {
                nVar.n();
            }
            if (cp.n(this.qg, this.n, strS)) {
                n(str, interfaceC0282nQg, strN2, strN, jSONObject);
            } else {
                com.byazt.okk.n.n(this.qg, this.n.q(), strN2, jSONObject.toString(), interfaceC0282nQg, this.n);
            }
        } catch (JSONException unused) {
        }
    }

    private String n(String str) {
        int iD = um.d(this.n);
        try {
            if (iD != 4) {
                if (iD != 3) {
                    return str;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", um.sz(this.n));
            jSONObject2.put("ugen_md5", um.k(this.n));
            jSONObject2.put("download_num", qg(this.n.cl()));
            com.byazt.gct.l lVarK = this.n.k();
            if (lVarK == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put("app_size", s(lVarK.x()));
            jSONObject2.put("comment_num", n(lVarK.w()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    private void qg(final String str) {
        if (um.d(this.n) != 4) {
            return;
        }
        TTDelegateActivity.n(new com.byazt.ozc.x() { // from class: com.byazt.wif.s.2
            @Override // com.byazt.ozc.x
            public void n(int i, String str2) {
                s.this.n(str, 1, str2);
                TTDelegateActivity.n((com.byazt.ozc.x) null);
            }

            @Override // com.byazt.ozc.x
            public void n(com.byazt.ih.s<View> sVar) {
                s.this.n(str, 0, "");
                TTDelegateActivity.n((com.byazt.ozc.x) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, int i, String str2) {
        JSONObject jSONObjectN = n();
        try {
            jSONObjectN.put("ugen_dl_render_fail_msg", str2);
            jSONObjectN.put("ugen_dl_render_fail", i);
        } catch (Exception unused) {
        }
        com.byazt.hm.n.qg(this.n, str, "pop_up", jSONObjectN);
    }

    public String n(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(j / 100000000));
        }
        if (j >= 10000) {
            return String.format("%d万+", Long.valueOf(j / 10000));
        }
        return j > 0 ? String.valueOf(j) : "-";
    }

    public String qg(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(Math.round(j / 1.0E8d)));
        }
        if (j >= 10000) {
            return String.format("%d万+", Long.valueOf(Math.round(j / 10000.0d)));
        }
        return j > 0 ? String.valueOf(j) : "-";
    }

    public String s(long j) {
        return j <= 0 ? "-" : String.format("%.1fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private void n(String str, com.byazt.okk.n.InterfaceC0282n interfaceC0282n, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.byazt.okk.n.n(this.qg, this.n.q(), cp.n(this.qg, str2, this.n, str3), jSONObject.toString(), interfaceC0282n, s(str), this.n);
    }

    private com.byazt.ozc.x s(final String str) {
        return new com.byazt.ozc.x() { // from class: com.byazt.wif.s.3
            @Override // com.byazt.ozc.x
            public void n(int i, String str2) {
                s sVar = s.this;
                sVar.n(sVar.n, str, 6, i, str2);
                TTDelegateActivity.n((com.byazt.ozc.x) null);
            }

            @Override // com.byazt.ozc.x
            public void n(com.byazt.ih.s<View> sVar) {
                s sVar2 = s.this;
                sVar2.n(sVar2.n, str, 5, 0, "");
                TTDelegateActivity.n((com.byazt.ozc.x) null);
            }
        };
    }

    private com.byazt.okk.n.InterfaceC0282n qg(final String str, final com.byazt.pma.qg qgVar) {
        return new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.wif.s.4
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                com.byazt.pma.qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n();
                }
                if (s.this.l != null) {
                    s.this.l.s();
                    s.this.l.qg();
                }
                w.qg = true;
                com.byazt.hm.n.qg(s.this.n, str, "pop_up_download", s.this.n());
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
                com.byazt.hm.n.qg(s.this.n, str, "pop_up_cancel", s.this.n());
                if (s.this.l != null) {
                    s.this.l.qg();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(pk pkVar, String str, int i, int i2, String str2) {
        JSONObject jSONObjectN = n();
        if (6 == i) {
            try {
                jSONObjectN.put("easy_dl_render_fail_code", i2);
                if (pkVar != null) {
                    String strS = pkVar.tc().s();
                    jSONObjectN.put("easy_dl_render_fail_msg", str2);
                    jSONObjectN.put("easy_dl_render_fail_dsl", q(strS));
                }
            } catch (Exception unused) {
            }
        }
        jSONObjectN.put("show_easy_dl_dialog_code", i);
        com.byazt.hm.n.qg(this.n, str, "pop_up", jSONObjectN);
    }

    private String q(String str) {
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        if (sVarN == null) {
            return null;
        }
        return sVarN.qg(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            n nVar = this.s;
            jSONObject.put("download_type", nVar != null ? nVar.qg() : -2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

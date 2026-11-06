package com.byazt.rcj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.gct.df;
import com.byazt.gct.hd;
import com.byazt.gct.pk;
import com.byazt.gct.py;
import com.byazt.llp.oa;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 8})
public class s implements com.byazt.wj.n {
    public final Map<String, Object> cp;
    public boolean d;
    public String fs;
    public final boolean k;
    public com.byazt.wj.n n;
    public com.byazt.vku.l.n oa;
    public hd q;
    public String qg;
    public com.byazt.zx.qg rv;
    public Context s;
    public final boolean sz;
    public final oa tj;
    public ITTInnerDownloadAdapter x;
    public boolean l = false;
    public boolean w = false;

    public s(com.byazt.wj.n nVar, oa oaVar, String str, hd hdVar, Context context, Map<String, Object> map, boolean z, boolean z2) {
        this.n = nVar;
        this.tj = oaVar;
        this.qg = str;
        this.s = context;
        this.q = hdVar;
        this.cp = map;
        this.sz = z;
        this.k = z2;
    }

    @Override // com.byazt.wj.n
    public boolean n(Map<String, Object> map) {
        com.byazt.vku.l.n nVar;
        if (this.sz) {
            boolean zS = s(map);
            if (!zS && (nVar = this.oa) != null) {
                nVar.n(false);
            }
            return zS;
        }
        return qg(map);
    }

    public void n(com.byazt.zx.qg qgVar) {
        this.rv = qgVar;
    }

    public void n(boolean z) {
        this.l = z;
    }

    public void qg(boolean z) {
        this.w = z;
    }

    public void s(boolean z) {
        this.d = z;
    }

    public void n(ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        this.x = iTTInnerDownloadAdapter;
    }

    public void n(String str) {
        this.fs = str;
    }

    public void n(com.byazt.vku.l.n nVar) {
        this.oa = nVar;
    }

    private hd n() {
        hd hdVar = this.q;
        return hdVar == null ? new hd() : hdVar;
    }

    public Boolean n(Map<String, Object> map, String str, JSONObject jSONObject) {
        String strQg = qg(str);
        if (TextUtils.isEmpty(strQg)) {
            com.byazt.ukb.qg.n(this.cp, com.byazt.wr.l.q);
            return null;
        }
        hd.n((String) null);
        Uri uri = Uri.parse(strQg);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        HashMap map2 = new HashMap();
        map2.put("source", "DeepLinkConverter");
        map2.put("scheme", com.byazt.vgx.w.n(strQg));
        com.byazt.hm.n.n(s(), this.qg, map2, this.l);
        boolean zH = com.byazt.vgx.w.h();
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.l));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(zH));
        } catch (Exception unused) {
        }
        if (zH) {
            boolean zN = com.byazt.vgx.w.n(intent);
            boolean zBt = rv.qg().bt();
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(zN));
                jSONObject.putOpt("ignore", Boolean.valueOf(zBt));
            } catch (Exception unused2) {
            }
            if (zN || zBt) {
                return n(map, intent, true, jSONObject);
            }
            n(map, true, (Throwable) new RuntimeException("not installed"));
            n(1);
            return null;
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.byazt.hoz.n.n(strQg)));
            String strLn = com.byazt.vgx.w.ln(s());
            if (strLn != null && strLn.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(com.byazt.vgx.w.s(strLn)));
            }
            jSONObject.putOpt(SDMAdConst.NETWORK_CUSTOM_KEY.PKG, strLn);
        } catch (Throwable unused3) {
        }
        return n(map, intent, false, jSONObject);
    }

    private Boolean n(JSONObject jSONObject) {
        Boolean boolValueOf;
        try {
            jSONObject.putOpt("tag", this.fs);
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(this.fs) || !py.n(this.tj.oa(), this.fs)) {
            return null;
        }
        int iQg = py.qg(this.tj.oa(), this.fs);
        if (iQg == 1) {
            boolValueOf = Boolean.valueOf(qg());
        } else {
            boolValueOf = n(new HashMap(), py.s(this.tj.oa(), this.fs), jSONObject);
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(iQg));
            jSONObject.putOpt("dpl_result", boolValueOf);
        } catch (JSONException unused2) {
        }
        return boolValueOf;
    }

    private boolean qg() {
        oa oaVar = this.tj;
        if (!(oaVar instanceof pk)) {
            return false;
        }
        String strS = py.s(oaVar.oa(), this.fs);
        pk pkVar = (pk) this.tj;
        Context context = this.s;
        String str = this.qg;
        com.byazt.xwj.n nVar = new com.byazt.xwj.n(pkVar, context, str, com.byazt.vgx.w.q(str), new HashMap(), null, null);
        nVar.n(strS);
        nVar.n(this.rv);
        return nVar.n(new HashMap());
    }

    private Boolean n(final Map<String, Object> map, Intent intent, final boolean z, JSONObject jSONObject) {
        com.byazt.vgx.w.s(intent);
        final boolean zQg = com.byazt.ukb.qg.qg(map);
        n(intent, zQg);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.byazt.tk.n.n(this.s, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.rcj.s.1
            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n() {
                atomicBoolean.set(true);
                com.byazt.hm.n.n(s.this.s(), s.this.qg, (Throwable) null, s.this.l, true);
                if (s.this.k) {
                    com.byazt.hm.l.n().n(s.this.s(), s.this.qg, s.this.l, zQg, new com.byazt.okk.qg.n() { // from class: com.byazt.rcj.s.1.1
                        @Override // com.byazt.okk.qg.n
                        public void n(String str) {
                        }

                        @Override // com.byazt.okk.qg.n
                        public void n(long j) {
                            com.byazt.ukb.qg.n((Map<String, Object>) s.this.cp, com.byazt.wr.l.l);
                            if (s.this.oa != null) {
                                s.this.oa.n(false);
                            }
                        }

                        @Override // com.byazt.okk.qg.n
                        public void n(boolean z2) {
                            if (s.this.oa != null) {
                                s.this.oa.n(z2);
                            }
                        }
                    });
                } else {
                    com.byazt.hm.l.n().n(s.this.s(), s.this.qg, s.this.l, zQg, null);
                }
                s.this.n(0);
            }

            @Override // com.byazt.tk.n.InterfaceC0352n
            public void n(Throwable th) {
                atomicBoolean.set(false);
                s.this.n((Map<String, Object>) map, z, th);
                s.this.n(3);
                com.byazt.ukb.qg.n((Map<String, Object>) s.this.cp, com.byazt.wr.l.w);
            }
        }, TextUtils.equals(tj.rv, "internal"));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i) {
        if (s() == null || s().gf() != 1) {
            return;
        }
        com.byazt.hm.n.n(s(), this.qg, 1, 1, i, tj.fs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Map<String, Object> map, boolean z, Throwable th) {
        if (this.w && !z) {
            com.byazt.hm.n.s(s(), this.qg, "open_fallback_download");
        }
        com.byazt.hm.n.n(s(), this.qg, th, this.l, false);
    }

    public void n(final Intent intent, final boolean z) {
        final com.byazt.ot.n nVarS;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        oa oaVar = this.tj;
        if (oaVar == null || intent == null || this.s == null) {
            return;
        }
        hd hdVarSz = oaVar.sz();
        if (hdVarSz != null && hdVarSz.s() == 2 && !hdVarSz.n() && com.byazt.ikv.n.n().qg("dpl_reject_by_dialog", false)) {
            com.byazt.qq.q.n(s(), this.qg, z);
        } else if (this.tj.hd() && (nVarS = com.byazt.vyf.s.cy().s()) != null) {
            nVarS.n(new com.byazt.ot.n.s() { // from class: com.byazt.rcj.s.2
                @Override // com.byazt.ot.n.s, com.byazt.ot.n.InterfaceC0287n
                public void n() {
                    if (System.currentTimeMillis() - jCurrentTimeMillis <= 3000) {
                        s.this.qg(intent, z);
                    }
                    com.byazt.ot.n nVar = nVarS;
                    if (nVar != null) {
                        nVar.s();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final Intent intent, final boolean z) {
        oa oaVar = this.tj;
        if (oaVar == null || this.s == null || intent == null) {
            return;
        }
        String strS = oaVar.k() != null ? this.tj.k().s() : "";
        com.byazt.okk.n.n(this.s, this.tj.q(), strS, TextUtils.isEmpty(strS) ? "是否立即打开应用" : "是否立即打开".concat(String.valueOf(strS)), "立即打开", "退出", new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.rcj.s.3
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                HashMap map = new HashMap();
                map.put("source", "DeepLinkConverter");
                com.byazt.hm.n.n(s.this.s(), s.this.qg, (Map<String, Object>) map, false);
                com.byazt.tk.n.n(s.this.s, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.rcj.s.3.1
                    @Override // com.byazt.tk.n.InterfaceC0352n
                    public void n() {
                        com.byazt.hm.n.n(s.this.s(), s.this.qg, (Throwable) null, false, true);
                        com.byazt.hm.l.n().n(s.this.s(), s.this.qg, false, z, null);
                    }

                    @Override // com.byazt.tk.n.InterfaceC0352n
                    public void n(Throwable th) {
                        com.byazt.hm.n.n(s.this.s(), s.this.qg, th, false, false);
                    }
                }, TextUtils.equals(tj.rv, "internal"));
            }
        });
    }

    private String qg(String str) {
        oa oaVar;
        df dfVarA;
        if (TextUtils.isEmpty(str) || (oaVar = this.tj) == null || oaVar.I_() || (dfVarA = this.tj.a()) == null) {
            return str;
        }
        try {
            String strS = dfVarA.s();
            String strQ = dfVarA.q();
            Map<String, String> mapN = com.byazt.rd.s.n(str);
            mapN.put("live_short_touch_params", strS);
            mapN.put("extra_pangle_scheme_params", strQ);
            String strN = com.byazt.rd.s.n(str, mapN);
            com.byazt.ikv.n.n().n("is_reward_deep_link_to_live", true);
            return strN;
        } catch (Exception unused) {
            return str;
        }
    }

    private boolean qg(Map<String, Object> map) {
        Object objValueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean boolN = n(jSONObject);
            boolean z = true;
            try {
                if (boolN == null || !boolN.booleanValue()) {
                    hd hdVarN = n();
                    if (hdVarN == null) {
                        hdVarN = this.tj.sz();
                    }
                    if (hdVarN != null && !TextUtils.isEmpty(hdVarN.qg())) {
                        String strQg = hdVarN.qg();
                        Boolean boolN2 = n(map, strQg, jSONObject);
                        try {
                            jSONObject.putOpt("dpl_result", boolN2);
                            jSONObject.putOpt(ImagesContract.URL, strQg);
                        } catch (Exception unused) {
                        }
                        if ((boolN2 == null || !boolN2.booleanValue()) && hdVarN != null && hdVarN.l() == 1) {
                            com.byazt.hm.n.fs(s(), this.qg, "open_fallback_url", null);
                        }
                        if (boolN2 != null && !this.w) {
                            boolean zBooleanValue = boolN2.booleanValue();
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                                jSONObject.putOpt("req_id", this.tj.ou());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.tj.B_()));
                            } catch (Exception unused2) {
                            }
                            com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
                            return zBooleanValue;
                        }
                        if (!this.w || (boolN2 != null && boolN2.booleanValue())) {
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                                jSONObject.putOpt("req_id", this.tj.ou());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.tj.B_()));
                            } catch (Exception unused3) {
                            }
                            com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
                            return false;
                        }
                        try {
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                            jSONObject.putOpt("req_id", this.tj.ou());
                            jSONObject.putOpt("web_meta", Boolean.valueOf(this.tj.B_()));
                        } catch (Exception unused4) {
                        }
                        com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
                        com.byazt.wj.n nVar = this.n;
                        return nVar != null && nVar.n(map);
                    }
                    try {
                        jSONObject.putOpt("dpl_null", Boolean.TRUE);
                    } catch (Exception unused5) {
                    }
                    com.byazt.wj.n nVar2 = this.n;
                    z = nVar2 != null && nVar2.n(map);
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                    jSONObject.putOpt("req_id", this.tj.ou());
                    objValueOf = Boolean.valueOf(this.tj.B_());
                } else {
                    try {
                        jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    } catch (Exception unused6) {
                    }
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                    jSONObject.putOpt("req_id", this.tj.ou());
                    objValueOf = Boolean.valueOf(this.tj.B_());
                }
                jSONObject.putOpt("web_meta", objValueOf);
            } catch (Exception unused7) {
            }
            com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
            return z;
        } catch (Throwable th) {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                jSONObject.putOpt("req_id", this.tj.ou());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.tj.B_()));
            } catch (Exception unused8) {
            }
            com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v51 */
    /* JADX WARN: Type inference failed for: r13v52 */
    private boolean s(Map<String, Object> map) {
        Boolean boolValueOf;
        Boolean boolValueOf2;
        com.byazt.vku.l.n nVar;
        JSONObject jSONObject = new JSONObject();
        try {
            oa oaVar = this.tj;
            try {
                if (oaVar instanceof com.byazt.llp.fs) {
                    int iFs = ((com.byazt.llp.fs) oaVar).fs();
                    try {
                        if (iFs == 4) {
                            com.byazt.wj.n nVar2 = this.n;
                            boolean z = nVar2 != null && nVar2.n(map);
                            if (z && (nVar = this.oa) != null) {
                                nVar.n(true);
                            }
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                            jSONObject.putOpt("req_id", this.tj.ou());
                            boolValueOf2 = Boolean.valueOf(this.tj.B_());
                            map = z;
                        } else if (iFs == 1) {
                            jSONObject.putOpt("uchain", Boolean.TRUE);
                            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                            jSONObject.putOpt("req_id", this.tj.ou());
                            boolValueOf = Boolean.valueOf(this.tj.B_());
                        } else {
                            String strS = ((com.byazt.llp.fs) this.tj).s();
                            Boolean boolN = n(map, strS, jSONObject);
                            try {
                                if (!TextUtils.isEmpty(this.fs)) {
                                    jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                                    jSONObject.putOpt("tag", this.fs);
                                }
                                jSONObject.putOpt("convert_type", Integer.valueOf(iFs));
                                jSONObject.putOpt("dpl_result", boolN);
                                jSONObject.putOpt(ImagesContract.URL, strS);
                            } catch (Exception unused) {
                            }
                            if (boolN != null && !this.w) {
                                boolean zBooleanValue = boolN.booleanValue();
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                                jSONObject.putOpt("req_id", this.tj.ou());
                                boolValueOf2 = Boolean.valueOf(this.tj.B_());
                                map = zBooleanValue;
                            } else {
                                if (this.w && (boolN == null || !boolN.booleanValue())) {
                                    try {
                                        jSONObject.putOpt("uchain", Boolean.TRUE);
                                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                                        jSONObject.putOpt("req_id", this.tj.ou());
                                        jSONObject.putOpt("web_meta", Boolean.valueOf(this.tj.B_()));
                                    } catch (Exception unused2) {
                                    }
                                    com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
                                    return false;
                                }
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                                jSONObject.putOpt("req_id", this.tj.ou());
                                boolValueOf = Boolean.valueOf(this.tj.B_());
                            }
                        }
                        jSONObject.putOpt("web_meta", boolValueOf2);
                    } catch (Exception unused3) {
                    }
                    com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
                    return map;
                }
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                jSONObject.putOpt("req_id", this.tj.ou());
                boolValueOf = Boolean.valueOf(this.tj.B_());
                jSONObject.putOpt("web_meta", boolValueOf);
            } catch (Exception unused4) {
            }
            com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
            return false;
        } catch (Throwable th) {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.tj.l()));
                jSONObject.putOpt("req_id", this.tj.ou());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.tj.B_()));
            } catch (Exception unused5) {
            }
            com.byazt.eji.s.n().n("open_detail_page", "native", 0, jSONObject);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pk s() {
        return com.byazt.ukb.qg.n(this.tj, this.cp);
    }
}

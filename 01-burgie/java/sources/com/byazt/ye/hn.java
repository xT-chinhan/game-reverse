package com.byazt.ye;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.af.m;
import com.byazt.hg.cz;
import com.byazt.hg.er;
import com.byazt.hg.of;
import com.byazt.hg.yb;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.n;
import com.byazt.wt.ls;
import com.byazt.wt.v;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, 20})
public class hn implements com.byazt.ni.pr {
    public com.byazt.ga.hw aj;
    public com.byazt.nv.hn fw;
    public Context hn;
    public String hw;
    public boolean k;
    public final boolean m;
    public com.byazt.ni.pr pr;
    public final m vk;
    public final Map<String, Object> w;
    public yb x;
    public String zo;
    public boolean c = false;
    public boolean uc = false;

    public hn(com.byazt.ni.pr prVar, m mVar, String str, yb ybVar, Context context, Map<String, Object> map, boolean z) {
        this.pr = prVar;
        this.vk = mVar;
        this.hw = str;
        this.hn = context;
        this.x = ybVar;
        this.w = map;
        this.m = z;
    }

    @Override // com.byazt.ni.pr
    public boolean pr(Map<String, Object> map) {
        if (this.m) {
            return hn(map);
        }
        return hw(map);
    }

    public void pr(com.byazt.ga.hw hwVar) {
        this.aj = hwVar;
    }

    public void pr(boolean z) {
        this.c = z;
    }

    public void hw(boolean z) {
        this.uc = z;
    }

    public void hn(boolean z) {
        this.k = z;
    }

    public void pr(com.byazt.nv.hn hnVar) {
        this.fw = hnVar;
    }

    public void pr(String str) {
        this.zo = str;
    }

    private yb pr() {
        yb ybVar = this.x;
        if (ybVar == null) {
            return new yb();
        }
        return ybVar;
    }

    public Boolean pr(Map<String, Object> map, String str, JSONObject jSONObject) {
        String strHw = hw(str);
        if (TextUtils.isEmpty(strHw)) {
            com.byazt.lx.hw.pr(this.w, com.byazt.wb.c.x);
            return null;
        }
        yb.pr((String) null);
        Uri uri = Uri.parse(strHw);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        HashMap map2 = new HashMap();
        map2.put("source", "DeepLinkConverter");
        map2.put("scheme", ls.pr(strHw));
        com.byazt.pj.pr.pr(hn(), this.hw, map2, this.c);
        boolean zB = ls.b();
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.c));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(zB));
        } catch (Exception e) {
        }
        if (zB) {
            boolean zPr = ls.pr(intent);
            boolean zEe = a.hw().ee();
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(zPr));
                jSONObject.putOpt("ignore", Boolean.valueOf(zEe));
            } catch (Exception e2) {
            }
            if (!zPr && !zEe) {
                pr(map, true, (Throwable) new RuntimeException("not installed"));
                pr(1);
                return null;
            }
            return pr(map, intent, true, jSONObject);
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.byazt.dz.pr.pr(strHw)));
            String strIu = ls.iu(hn());
            if (strIu != null && strIu.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(ls.hn(strIu)));
            }
            jSONObject.putOpt("pkg", strIu);
        } catch (Throwable th) {
        }
        return pr(map, intent, false, jSONObject);
    }

    private Boolean pr(JSONObject jSONObject) {
        Boolean boolValueOf;
        try {
            jSONObject.putOpt("tag", this.zo);
        } catch (JSONException e) {
        }
        if (TextUtils.isEmpty(this.zo) || !cz.pr(this.vk.m(), this.zo)) {
            return null;
        }
        int iHw = cz.hw(this.vk.m(), this.zo);
        switch (iHw) {
            case 1:
                boolValueOf = Boolean.valueOf(hw());
                break;
            default:
                boolValueOf = pr(new HashMap(), cz.hn(this.vk.m(), this.zo), jSONObject);
                break;
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(iHw));
            jSONObject.putOpt("dpl_result", boolValueOf);
        } catch (JSONException e2) {
        }
        return boolValueOf;
    }

    private boolean hw() {
        m mVar = this.vk;
        if (mVar instanceof of) {
            String strHn = cz.hn(mVar.m(), this.zo);
            of ofVar = (of) this.vk;
            Context context = this.hn;
            String str = this.hw;
            com.byazt.ov.pr prVar = new com.byazt.ov.pr(ofVar, context, str, ls.x(str), new HashMap(), null, null);
            prVar.pr(strHn);
            prVar.pr(this.aj);
            return prVar.pr(new HashMap());
        }
        return false;
    }

    private Boolean pr(final Map<String, Object> map, Intent intent, final boolean z, JSONObject jSONObject) {
        ls.hn(intent);
        final boolean zHw = com.byazt.lx.hw.hw(map);
        pr(intent, zHw);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.byazt.ca.pr.pr(this.hn, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.ye.hn.1
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
                atomicBoolean.set(true);
                com.byazt.pj.pr.pr(hn.this.hn(), hn.this.hw, (Throwable) null, hn.this.c, true);
                com.byazt.pj.c.pr().pr(hn.this.hn(), hn.this.hw, hn.this.c, zHw, null);
                hn.this.pr(0);
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
                atomicBoolean.set(false);
                hn.this.pr((Map<String, Object>) map, z, th);
                hn.this.pr(3);
                com.byazt.lx.hw.pr((Map<String, Object>) hn.this.w, com.byazt.wb.c.uc);
            }
        }, TextUtils.equals(iu.zo, UMModuleRegister.INNER));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i) {
        if (hn() != null && hn().uv() == 1) {
            com.byazt.pj.pr.pr(hn(), this.hw, 1, 1, i, iu.fw());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Map<String, Object> map, boolean z, Throwable th) {
        if (this.uc && !z) {
            com.byazt.pj.pr.hn(hn(), this.hw, "open_fallback_download");
        }
        com.byazt.pj.pr.pr(hn(), this.hw, th, this.c, false);
    }

    public void pr(final Intent intent, final boolean z) {
        final com.byazt.wt.pr prVarHn;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        m mVar = this.vk;
        if (mVar == null || intent == null || this.hn == null) {
            return;
        }
        yb ybVarG = mVar.g();
        if (ybVarG != null && ybVarG.hn() == 2 && !ybVarG.pr() && com.byazt.sd.hw.pr().hw("dpl_reject_by_dialog", false)) {
            n.pr(hn(), this.hw, z);
        } else {
            if (!this.vk.yb() || (prVarHn = com.byazt.sd.zo.nt().hn()) == null) {
                return;
            }
            prVarHn.pr(new com.byazt.wt.pr.hn() { // from class: com.byazt.ye.hn.2
                @Override // com.byazt.wt.pr.hn, com.byazt.wt.pr.InterfaceC0225pr
                public void pr() {
                    if (System.currentTimeMillis() - jCurrentTimeMillis <= 3000) {
                        hn.this.hw(intent, z);
                    }
                    com.byazt.wt.pr prVar = prVarHn;
                    if (prVar != null) {
                        prVar.hn();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final Intent intent, final boolean z) {
        String strHn;
        String strConcat;
        m mVar = this.vk;
        if (mVar == null || this.hn == null || intent == null) {
            return;
        }
        if (mVar.ho() == null) {
            strHn = "";
        } else {
            strHn = this.vk.ho().hn();
        }
        if (TextUtils.isEmpty(strHn)) {
            strConcat = "是否立即打开应用";
        } else {
            strConcat = "是否立即打开".concat(String.valueOf(strHn));
        }
        com.byazt.wt.c.pr(this.hn, this.vk.x(), strHn, strConcat, "立即打开", "退出", new com.byazt.wt.c.pr() { // from class: com.byazt.ye.hn.3
            @Override // com.byazt.wt.c.pr
            public void pr() {
                HashMap map = new HashMap();
                map.put("source", "DeepLinkConverter");
                com.byazt.pj.pr.pr(hn.this.hn(), hn.this.hw, (Map<String, Object>) map, false);
                com.byazt.ca.pr.pr(hn.this.hn, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.ye.hn.3.1
                    @Override // com.byazt.ca.pr.InterfaceC0030pr
                    public void pr() {
                        com.byazt.pj.pr.pr(hn.this.hn(), hn.this.hw, (Throwable) null, false, true);
                        com.byazt.pj.c.pr().pr(hn.this.hn(), hn.this.hw, false, z, null);
                    }

                    @Override // com.byazt.ca.pr.InterfaceC0030pr
                    public void pr(Throwable th) {
                        com.byazt.pj.pr.pr(hn.this.hn(), hn.this.hw, th, false, false);
                    }
                }, TextUtils.equals(iu.zo, UMModuleRegister.INNER));
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
            }
        });
    }

    private String hw(String str) {
        m mVar;
        er erVarA;
        if (TextUtils.isEmpty(str) || (mVar = this.vk) == null || mVar.E_() || (erVarA = this.vk.a()) == null) {
            return str;
        }
        try {
            String strHn = erVarA.hn();
            String strX = erVarA.x();
            Map<String, String> mapPr = v.pr(str);
            mapPr.put("live_short_touch_params", strHn);
            mapPr.put("extra_pangle_scheme_params", strX);
            String strPr = v.pr(str, mapPr);
            com.byazt.sd.hw.pr().pr("is_reward_deep_link_to_live", true);
            return strPr;
        } catch (Exception e) {
            return str;
        }
    }

    private boolean hw(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean boolPr = pr(jSONObject);
            if (boolPr != null && boolPr.booleanValue()) {
                try {
                    jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                } catch (Exception e) {
                }
                try {
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.vk.c()));
                    jSONObject.putOpt("req_id", this.vk.ny());
                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.vk.x_()));
                } catch (Exception e2) {
                }
                com.byazt.xk.hw.pr().pr("open_detail_page", "native", 0, jSONObject);
                return true;
            }
            yb ybVarPr = pr();
            if (ybVarPr == null) {
                ybVarPr = this.vk.g();
            }
            if (ybVarPr != null && !TextUtils.isEmpty(ybVarPr.hw())) {
                String strHw = ybVarPr.hw();
                Boolean boolPr2 = pr(map, strHw, jSONObject);
                try {
                    jSONObject.putOpt("dpl_result", boolPr2);
                    jSONObject.putOpt(BreakpointSQLiteKey.URL, strHw);
                } catch (Exception e3) {
                }
                if ((boolPr2 == null || !boolPr2.booleanValue()) && ybVarPr != null && ybVarPr.c() == 1) {
                    com.byazt.pj.pr.zo(hn(), this.hw, "open_fallback_url", null);
                }
                if (boolPr2 != null && !this.uc) {
                    boolean zBooleanValue = boolPr2.booleanValue();
                    try {
                        jSONObject.putOpt("uchain", Boolean.TRUE);
                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.vk.c()));
                        jSONObject.putOpt("req_id", this.vk.ny());
                        jSONObject.putOpt("web_meta", Boolean.valueOf(this.vk.x_()));
                    } catch (Exception e4) {
                    }
                    com.byazt.xk.hw.pr().pr("open_detail_page", "native", 0, jSONObject);
                    return zBooleanValue;
                }
                if (!this.uc || (boolPr2 != null && boolPr2.booleanValue())) {
                    try {
                        jSONObject.putOpt("uchain", Boolean.TRUE);
                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.vk.c()));
                        jSONObject.putOpt("req_id", this.vk.ny());
                        jSONObject.putOpt("web_meta", Boolean.valueOf(this.vk.x_()));
                    } catch (Exception e5) {
                    }
                    com.byazt.xk.hw.pr().pr("open_detail_page", "native", 0, jSONObject);
                    return false;
                }
                try {
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.vk.c()));
                    jSONObject.putOpt("req_id", this.vk.ny());
                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.vk.x_()));
                } catch (Exception e6) {
                }
                com.byazt.xk.hw.pr().pr("open_detail_page", "native", 0, jSONObject);
                com.byazt.ni.pr prVar = this.pr;
                return prVar != null && prVar.pr(map);
            }
            try {
                jSONObject.putOpt("dpl_null", Boolean.TRUE);
            } catch (Exception e7) {
            }
            com.byazt.ni.pr prVar2 = this.pr;
            boolean z = prVar2 != null && prVar2.pr(map);
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.vk.c()));
                jSONObject.putOpt("req_id", this.vk.ny());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.vk.x_()));
            } catch (Exception e8) {
            }
            com.byazt.xk.hw.pr().pr("open_detail_page", "native", 0, jSONObject);
            return z;
        } catch (Throwable th) {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.vk.c()));
                jSONObject.putOpt("req_id", this.vk.ny());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.vk.x_()));
            } catch (Exception e9) {
            }
            com.byazt.xk.hw.pr().pr("open_detail_page", "native", 0, jSONObject);
            throw th;
        }
    }

    private boolean hn(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            m mVar = this.vk;
            if (!(mVar instanceof com.byazt.af.zo)) {
                return false;
            }
            int iZo = ((com.byazt.af.zo) mVar).zo();
            if (iZo == 4) {
                com.byazt.ni.pr prVar = this.pr;
                return prVar != null && prVar.pr(map);
            }
            if (iZo == 1) {
                return false;
            }
            String strHn = ((com.byazt.af.zo) this.vk).hn();
            Boolean boolPr = pr(map, strHn, jSONObject);
            try {
                if (!TextUtils.isEmpty(this.zo)) {
                    jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    jSONObject.putOpt("tag", this.zo);
                }
                jSONObject.putOpt("convert_type", Integer.valueOf(iZo));
                jSONObject.putOpt("dpl_result", boolPr);
                jSONObject.putOpt(BreakpointSQLiteKey.URL, strHn);
            } catch (Exception e) {
            }
            if (boolPr == null || this.uc) {
                return (!this.uc || (boolPr != null && boolPr.booleanValue())) ? false : false;
            }
            return boolPr.booleanValue();
        } finally {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.vk.c()));
                jSONObject.putOpt("req_id", this.vk.ny());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.vk.x_()));
            } catch (Exception e2) {
            }
            com.byazt.xk.hw.pr().pr("open_detail_page", "native", 0, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public of hn() {
        return com.byazt.lx.hw.pr(this.vk, this.w);
    }
}

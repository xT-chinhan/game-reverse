package com.byazt.wd;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.gct.y;
import com.byazt.tk.k;
import com.byazt.vf.fi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 584, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public com.byazt.eji.n s = new com.byazt.eji.n(10);
    public static final tj n = new tj();
    public static final AtomicBoolean q = new AtomicBoolean(false);
    public static final AtomicBoolean l = new AtomicBoolean(false);
    public static final AtomicInteger qg = new AtomicInteger(0);

    private int n(boolean z, boolean z2, boolean z3) {
        if (!z3) {
            return 4;
        }
        if (z2) {
            return 3;
        }
        return z ? 1 : 2;
    }

    private tj() {
    }

    public boolean n(com.byazt.gct.qg qgVar, com.byazt.zq.qg qgVar2, int i, com.byazt.mw.n.qg qgVar3, y yVar, cp cpVar) {
        boolean z;
        y yVar2;
        boolean zN;
        double dQg;
        s sVarN;
        y yVar3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            boolean zE = com.byazt.nf.rv.qg().e();
            String strPe = com.byazt.nf.rv.qg().pe();
            boolean z2 = !TextUtils.isEmpty(strPe);
            if (zE || z2) {
                this.s.n();
                zN = n(qgVar2);
                dQg = qg(qgVar2);
            } else {
                dQg = 0.0d;
                zN = false;
            }
            l lVarN = n(qgVar2.q(), yVar);
            if (!lVarN.qg()) {
                z = true;
                if (z2) {
                    yVar2 = yVar;
                    try {
                        n(qg.qg(qgVar2, yVar, i, strPe, zN, dQg, null));
                    } catch (Exception e) {
                        e = e;
                        com.byazt.eji.s.n().n("req_freq", e);
                    }
                } else {
                    yVar2 = yVar;
                }
                yVar2.n("checkCallFreq", System.currentTimeMillis() - jCurrentTimeMillis, z);
                return false;
            }
            if (zE) {
                cpVar.s(true);
                cpVar.n(n(qgVar2, i, yVar, zN, dQg, lVarN, strPe));
                qgVar2.q();
                yVar.n("callExempt", System.currentTimeMillis() - jCurrentTimeMillis, true);
                return false;
            }
            if (z2) {
                sVarN = n(qgVar2, i, zN, strPe, dQg, yVar.qg());
            } else {
                sVarN = rv.n().n(qgVar2.q(), qgVar2.an());
                qgVar2.q();
            }
            cpVar.s(sVarN.x());
            q qVarW = sVarN.w();
            boolean z3 = sVarN.x() || (qVarW != null && qVarW.qg());
            if (z2) {
                z = true;
                yVar3 = yVar;
                try {
                    n(qg.qg(qgVar2, yVar, i, strPe, sVarN.fs(), z3, qVarW, zN, dQg, sVarN));
                } catch (Exception e2) {
                    e = e2;
                    yVar2 = yVar3;
                }
            } else {
                z = true;
                yVar3 = yVar;
            }
            yVar3.n("callExempt", System.currentTimeMillis() - jCurrentTimeMillis, z);
            if (z3) {
                return false;
            }
            n(lVarN, qgVar2.q(), strPe, sVarN.fs());
            com.byazt.udc.n.n(qgVar2.q());
            qgVar.n(-8);
            qgVar3.n(-8, com.byazt.bxg.n.n(-8), qgVar);
            qg.incrementAndGet();
            return z;
        } catch (Exception e3) {
            e = e3;
            z = true;
            yVar2 = yVar;
        }
        com.byazt.eji.s.n().n("req_freq", e);
        yVar2.n("checkCallFreq", System.currentTimeMillis() - jCurrentTimeMillis, z);
        return false;
    }

    private com.byazt.phf.l n(com.byazt.zq.qg qgVar, int i, y yVar, boolean z, double d, l lVar, String str) {
        final n nVar = new n(qgVar, yVar, i, z, d, str, lVar);
        com.byazt.wlo.n.x().n(n(qgVar, i, yVar, z, d), new com.byazt.wlo.qg.n() { // from class: com.byazt.wd.tj.1
            @Override // com.byazt.wlo.qg.n
            public void n(s sVar) {
                nVar.n(sVar);
            }
        });
        return nVar;
    }

    private JSONObject n(com.byazt.zq.qg qgVar, int i, y yVar, boolean z, double d) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        if (yVar != null) {
            try {
                jSONObject.put("req_stage", yVar.l == 2 ? 1 : 0);
            } catch (JSONException e) {
                k.qg("TMe_exempt", "build pitaya params error:" + e.toString());
            }
        }
        if (qgVar != null) {
            jSONObject.putOpt("rit", qgVar.q());
            jSONObject.put("ad_count", qgVar.d());
        }
        jSONObject.put("ad_slot_type", i == 4 ? 3 : i);
        if (!z) {
            i2 = 0;
        }
        jSONObject.put("mediation_req_type", i2);
        jSONObject.put("ecpm", d);
        jSONObject.put("req_times_10s", this.s.qg());
        n(jSONObject, qgVar, i, z, d);
        jSONObject.put("device", com.byazt.kld.n.n());
        return jSONObject;
    }

    private void n(JSONObject jSONObject, com.byazt.zq.qg qgVar, int i, boolean z, double d) throws JSONException {
        if (jSONObject == null || qgVar == null) {
            return;
        }
        JSONObject jSONObjectN = n(qgVar, i, z, d);
        fi fiVar = (fi) com.byazt.qp.q.n("strategy");
        n(jSONObject, fiVar != null ? fiVar.n("strategy_req_drop", jSONObjectN) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        jSONObject.put("rit_session_hit_err_code", -1);
        jSONObject.put("slot_session_load_start_cnt", -1);
        jSONObject.put("slot_session_load_succ_cnt", -1);
        jSONObject.put("slot_session_show_cnt", -1);
        jSONObject.put("slot_session_fill_rate", -1);
        jSONObject.put("slot_session_ssr", -1);
        if (jSONObject2 == null || (jSONObjectOptJSONObject = jSONObject2.optJSONObject("all_results")) == null) {
            return;
        }
        Object objOpt = jSONObjectOptJSONObject.opt("hit_error_code");
        if (objOpt != null) {
            jSONObject.put("rit_session_hit_err_code", objOpt);
        }
        Object objOpt2 = jSONObjectOptJSONObject.opt("error_code");
        if (objOpt2 != null) {
            jSONObject.put("rit_session_error_code", objOpt2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ad_metri");
        if (jSONObjectOptJSONObject2 == null) {
            return;
        }
        Object objOpt3 = jSONObjectOptJSONObject2.opt("load_start_cnt");
        if (objOpt3 != null) {
            jSONObject.put("slot_session_load_start_cnt", objOpt3);
        }
        Object objOpt4 = jSONObjectOptJSONObject2.opt("load_succ_cnt");
        if (objOpt4 != null) {
            jSONObject.put("slot_session_load_succ_cnt", objOpt4);
        }
        Object objOpt5 = jSONObjectOptJSONObject2.opt("show_cnt");
        if (objOpt5 != null) {
            jSONObject.put("slot_session_show_cnt", objOpt5);
        }
        Object objOpt6 = jSONObjectOptJSONObject2.opt("fill_rate");
        if (objOpt6 != null) {
            jSONObject.put("slot_session_fill_rate", objOpt6);
        }
        Object objOpt7 = jSONObjectOptJSONObject2.opt("ssr");
        if (objOpt7 != null) {
            jSONObject.put("slot_session_ssr", objOpt7);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 584, 855})
    private static final class n implements com.byazt.phf.l {
        public final JSONObject a;
        public volatile s cd;
        public final String cp;
        public final AtomicBoolean cy;
        public final String d;
        public final boolean fs;
        public final AtomicBoolean hd;
        public final AtomicBoolean k;
        public final y l;
        public final long n;
        public final int oa;
        public final com.byazt.zq.qg q;
        public long qg;
        public final double rv;
        public final tj s;
        public final l sz;
        public final String tj;
        public volatile q um;
        public final int w;
        public final int x;

        private n(tj tjVar, com.byazt.zq.qg qgVar, y yVar, int i, boolean z, double d, String str, l lVar) {
            this.qg = -1L;
            int i2 = 0;
            this.k = new AtomicBoolean(false);
            this.cy = new AtomicBoolean(false);
            this.hd = new AtomicBoolean(false);
            this.a = new JSONObject();
            this.n = SystemClock.elapsedRealtime();
            this.s = tjVar;
            this.q = qgVar;
            this.l = yVar;
            this.w = i;
            this.x = i == 4 ? 3 : i;
            this.fs = z;
            this.rv = d;
            this.tj = str;
            this.cp = yVar == null ? null : yVar.qg();
            this.d = qgVar != null ? qgVar.q() : null;
            if (yVar != null && yVar.l == 2) {
                i2 = 1;
            }
            this.oa = i2;
            this.sz = lVar;
        }

        public void n(s sVar) {
            this.qg = SystemClock.elapsedRealtime() - this.n;
            this.cd = sVar;
        }

        @Override // com.byazt.phf.l
        public boolean n(String str) {
            s sVar = this.cd;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.n;
            n(this.cp, this.d, this.x, this.oa, str, sVar, this.qg, jElapsedRealtime);
            q qVarQg = qg(sVar);
            boolean zN = n(str, sVar, qVarQg);
            if (sVar != null) {
                sVar.n(this.qg);
                sVar.s(jElapsedRealtime);
            }
            n(str, sVar, qVarQg, zN);
            if (zN && this.k.compareAndSet(false, true)) {
                tj.n.n(this.sz, this.d, "exempt_pitaya", (JSONObject) null);
                com.byazt.udc.n.n(this.d);
                tj.qg.incrementAndGet();
            }
            return zN;
        }

        private void n(String str, String str2, int i, int i2, String str3, s sVar, long j, long j2) {
            try {
                this.a.putOpt(str3, Long.valueOf(j2));
            } catch (JSONException unused) {
            }
            boolean z = sVar != null;
            boolean z2 = sVar == null && TextUtils.equals("networkFinal", str3);
            if ((z || z2) && this.hd.compareAndSet(false, true)) {
                com.byazt.eji.s.n().n(str, str2, i, i2, sVar, j, this.a.toString());
            }
        }

        private boolean n(String str, s sVar, q qVar) {
            if (sVar == null) {
                return TextUtils.equals("networkFinal", str);
            }
            if (sVar.x()) {
                return false;
            }
            return qVar == null || !qVar.qg();
        }

        private q qg(s sVar) {
            if (sVar == null || sVar.x()) {
                return null;
            }
            q qVar = this.um;
            if (qVar != null) {
                return qVar;
            }
            tj tjVar = this.s;
            if (tjVar == null) {
                return null;
            }
            q qVarN = tjVar.n(this.q, this.cp, false);
            this.um = qVarN;
            return qVarN;
        }

        private void n(String str, s sVar, q qVar, boolean z) {
            if (this.s == null || this.q == null || this.l == null || TextUtils.isEmpty(this.tj)) {
                return;
            }
            boolean z2 = sVar != null;
            boolean z3 = sVar == null && TextUtils.equals("networkFinal", str);
            if ((z2 || z3) && this.cy.compareAndSet(false, true)) {
                this.s.n(qg.qg(this.q, this.l, this.w, this.tj, z2 ? sVar.fs() : null, !z, qVar, this.fs, this.rv, sVar, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(l lVar, String str, String str2, JSONObject jSONObject) {
        if (lVar == null || !lVar.qg()) {
            return;
        }
        if ((lVar.s() ? l : q).compareAndSet(false, true)) {
            if (!TextUtils.isEmpty(lVar.q())) {
                str = lVar.q();
            }
            String str3 = str;
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            com.byazt.eji.s.n(str3, System.currentTimeMillis(), lVar.s(), str2, jSONObject);
        }
    }

    private boolean n(com.byazt.zq.qg qgVar) {
        return n(qgVar != null ? qgVar.ou() : null, "mediation_req_type") != null;
    }

    private Object n(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && TextUtils.equals(str2, jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME))) {
                        return jSONObjectOptJSONObject.opt(e.a.d);
                    }
                }
            } catch (JSONException e) {
                k.qg("TMe_exempt", "findUserDataValue error:" + e.toString());
            }
        }
        return null;
    }

    private l n(String str) {
        if (!w.n()) {
            q.getAndSet(false);
        }
        if (w.n()) {
            return l.n(false, w.qg());
        }
        if (w.n(str)) {
            return l.n(false, w.qg());
        }
        return l.n();
    }

    private l qg(String str) {
        if (!w.s()) {
            l.getAndSet(false);
        }
        if (w.s()) {
            return l.n(true, w.q());
        }
        if (w.qg(str)) {
            return l.n(true, w.q());
        }
        return l.n();
    }

    private l n(String str, y yVar) {
        float fQ = com.byazt.ed.q.n().q();
        if (yVar != null && yVar.l == 2 && fQ > 0.0f) {
            return qg(str);
        }
        return n(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q n(com.byazt.zq.qg qgVar, String str, boolean z) {
        if (z || qgVar == null || str == null) {
            return q.n();
        }
        com.byazt.ivn.w wVarQg = com.byazt.nf.rv.qg();
        if (!s(qgVar)) {
            return q.n();
        }
        double dCx = wVarQg.cx();
        if (dCx <= 0.0d) {
            return new q(false, 0.0d, wVarQg.lq(), -1);
        }
        int iQg = qg(str, wVarQg.lq());
        if (iQg < 0) {
            return new q(false, dCx, wVarQg.lq(), -1);
        }
        return new q(iQg < ((int) Math.max(0.0d, Math.min(10000.0d, dCx * 10000.0d))), dCx, wVarQg.lq(), iQg);
    }

    private s n(com.byazt.zq.qg qgVar, int i, boolean z, String str, double d, String str2) {
        s sVar = new s();
        qgVar.q();
        JSONObject jSONObjectN = n(qgVar, i, z, d);
        fi fiVar = (fi) com.byazt.qp.q.n("strategy");
        JSONObject jSONObjectN2 = fiVar != null ? fiVar.n(str, jSONObjectN) : null;
        sVar.qg(jSONObjectN2);
        if (jSONObjectN2 != null) {
            sVar.n(jSONObjectN2.optBoolean("need_pass", false));
        }
        if (!sVar.x()) {
            sVar.n(n(qgVar, str2, n(jSONObjectN2)));
        }
        return sVar;
    }

    private JSONObject n(com.byazt.zq.qg qgVar, int i, boolean z, double d) {
        JSONObject jSONObject = new JSONObject();
        if (qgVar == null) {
            return jSONObject;
        }
        try {
            jSONObject.putOpt("rit", qgVar.q());
            if (i == 4) {
                i = 3;
            }
            jSONObject.put("ad_slot_type", i);
            if (z) {
                jSONObject.put("ecpm", d);
            }
        } catch (JSONException e) {
            k.qg("TMe_exempt", "buildExemptStrategyParams error:" + e.toString());
        }
        return jSONObject;
    }

    private boolean n(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("need_pass")) {
            return jSONObject.optBoolean("need_pass", false);
        }
        return false;
    }

    private double qg(com.byazt.zq.qg qgVar) {
        Object objN = n(qgVar != null ? qgVar.ou() : null, "m_temp_info");
        if (objN instanceof JSONObject) {
            double dOptDouble = ((JSONObject) objN).optDouble("m_e", Double.NaN);
            Double.isNaN(dOptDouble);
            if (Double.isNaN(dOptDouble)) {
                return 0.0d;
            }
            return dOptDouble;
        }
        if (objN instanceof String) {
            try {
                double dOptDouble2 = new JSONObject((String) objN).optDouble("m_e", Double.NaN);
                Double.isNaN(dOptDouble2);
                if (Double.isNaN(dOptDouble2)) {
                    return 0.0d;
                }
                return dOptDouble2;
            } catch (JSONException e) {
                k.qg("TMe_exempt", "getMediationSlotEcpm error:" + e.toString());
            }
        }
        return 0.0d;
    }

    private boolean n(boolean z, q qVar, com.byazt.zq.qg qgVar, String str) {
        if (z) {
            if (qVar == null || !qVar.qg()) {
                return true;
            }
            return s(qgVar);
        }
        if (s(qgVar)) {
            return n(str, com.byazt.nf.rv.qg().hf());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(qg qgVar) {
        if (qgVar == null) {
            return;
        }
        com.byazt.zq.qg qgVar2 = qgVar.n;
        y yVar = qgVar.qg;
        final String str = qgVar.l;
        if (TextUtils.isEmpty(str) || qgVar2 == null || yVar == null || !n(qgVar.q, qgVar.fs, qgVar2, yVar.qg())) {
            return;
        }
        int i = qgVar.s;
        final JSONObject jSONObject = qgVar.w;
        final q qVar = qgVar.fs;
        final boolean zN = n(jSONObject);
        final boolean z = qgVar.q;
        final int iQg = this.s.qg();
        final String strQg = yVar.qg();
        final int iD = qgVar2.d();
        boolean z2 = yVar.l == 2;
        final int iN = n(qgVar.x, qVar != null && qVar.qg(), qgVar.q);
        final boolean z3 = qgVar.x;
        final boolean z4 = qgVar.rv;
        final double d = qgVar.tj;
        final s sVar = qgVar.cp;
        final boolean z5 = qgVar.d;
        final String str2 = qgVar.oa;
        final boolean z6 = z2;
        com.byazt.eji.s.n().n("req_drop_feature_snapshot", qgVar2.q(), strQg, i, new com.byazt.rs.n() { // from class: com.byazt.wd.tj.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObjectOptJSONObject;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ecpm", d);
                jSONObject3.put("req_stage", z6 ? 1 : 0);
                jSONObject3.put("req_times_10s", iQg);
                jSONObject3.put("ad_count", iD);
                jSONObject3.put("mediation_req_type", z4 ? 1 : 0);
                if (z5) {
                    jSONObject3.put("decision_source", "pitaya");
                    jSONObject3.put("check_stage", str2);
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        jSONObject3.put("pkg_cost_ms", sVar2.qg());
                        jSONObject3.put("sdk_wait_pitaya_ms", sVar.n());
                        jSONObject3.put("req_check_elapsed_ms", sVar.rv());
                        com.byazt.rr.rv rvVarQ = sVar.q();
                        if (rvVarQ != null) {
                            jSONObject3.put("pitaya_business_name", rvVarQ.n());
                            jSONObject3.put("pitaya_package_version", rvVarQ.qg());
                        }
                        JSONObject jSONObjectS = sVar.s();
                        if (jSONObjectS != null) {
                            try {
                                tj.this.qg(jSONObject3, jSONObjectS);
                            } catch (Exception e) {
                                com.byazt.eji.s.n().n("p_req_drop_feature_snapshot", (JSONObject) null, e);
                            }
                        }
                        JSONObject jSONObject4 = jSONObject;
                        if (jSONObject4 != null && (jSONObjectOptJSONObject = jSONObject4.optJSONObject("result")) != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("need_pass"))) {
                            jSONObject3.put("pitaya_need_pass", sVar.x() ? 1 : 0);
                        }
                    }
                } else {
                    if (iN != 4) {
                        jSONObject3.put("decision_source", "dsl");
                    }
                    jSONObject3.put("dsl_need_pass", zN ? 1 : 0);
                    try {
                        tj.this.n(jSONObject3, jSONObject);
                        JSONObject jSONObjectQg = com.byazt.aun.q.n().qg();
                        JSONObject jSONObjectS2 = com.byazt.aun.q.n().s();
                        jSONObject3.put("feature_engine_data", jSONObjectQg);
                        jSONObject3.put("feature_data_v2", jSONObjectS2);
                    } catch (Exception e2) {
                        com.byazt.eji.s.n().n("b_req_drop_feature_snapshot", (JSONObject) null, e2);
                    }
                }
                jSONObject3.put("schema_version", "1.1");
                jSONObject3.put("client_request_id", strQg);
                jSONObject3.put("is_mediation", com.byazt.vyf.s.cy().oj() ? 1 : 0);
                jSONObject3.put("is_freq_hit", z ? 1 : 0);
                jSONObject3.put("decision_action", iN);
                jSONObject3.put("request_sent", z3 ? 1 : 0);
                jSONObject3.put("strategy_id", str);
                jSONObject3.put("strategy_result", jSONObject);
                q qVar2 = qVar;
                if (qVar2 != null) {
                    jSONObject3.put("exploration", qVar2.qg() ? 1 : 0);
                    if (qVar.qg()) {
                        jSONObject3.put("exploration_prob", qVar.s());
                        jSONObject3.put("policy_salt", qVar.q());
                        jSONObject3.put("exploration_bucket", qVar.l());
                    }
                } else {
                    jSONObject3.put("exploration", 0);
                }
                Object[] objArr = new Object[1];
                return jSONObject3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.put(next, jSONObject2.opt(next));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 584, 765})
    private static class qg {
        public final s cp;
        public final boolean d;
        public final q fs;
        public final String l;
        public final com.byazt.zq.qg n;
        public final String oa;
        public final boolean q;
        public final y qg;
        public final boolean rv;
        public final int s;
        public final double tj;
        public final JSONObject w;
        public final boolean x;

        /* JADX INFO: Access modifiers changed from: private */
        public static qg qg(com.byazt.zq.qg qgVar, y yVar, int i, String str, JSONObject jSONObject, boolean z, q qVar, boolean z2, double d, s sVar, String str2) {
            return new qg(qgVar, yVar, i, true, str, jSONObject, z, qVar, z2, d, sVar, true, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static qg qg(com.byazt.zq.qg qgVar, y yVar, int i, String str, JSONObject jSONObject, boolean z, q qVar, boolean z2, double d, s sVar) {
            return new qg(qgVar, yVar, i, true, str, jSONObject, z, qVar, z2, d, sVar, false, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static qg qg(com.byazt.zq.qg qgVar, y yVar, int i, String str, boolean z, double d, s sVar) {
            return new qg(qgVar, yVar, i, false, str, null, true, null, z, d, sVar, false, null);
        }

        private qg(com.byazt.zq.qg qgVar, y yVar, int i, boolean z, String str, JSONObject jSONObject, boolean z2, q qVar, boolean z3, double d, s sVar, boolean z4, String str2) {
            this.n = qgVar;
            this.qg = yVar;
            this.s = i;
            this.q = z;
            this.l = str;
            this.w = jSONObject;
            this.x = z2;
            this.fs = qVar;
            this.rv = z3;
            this.tj = d;
            this.cp = sVar;
            this.d = z4;
            this.oa = str2;
        }
    }

    private boolean n(String str, double d) {
        int iQg;
        if (d <= 0.0d || (iQg = qg(str, com.byazt.nf.rv.qg().lq())) < 0) {
            return false;
        }
        boolean z = iQg < ((int) Math.max(0.0d, Math.min(10000.0d, d * 10000.0d)));
        com.byazt.nf.rv.qg().lq();
        return z;
    }

    private int qg(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            StringBuilder sbAppend = new StringBuilder().append(str).append("#");
            if (str2 == null) {
                str2 = "";
            }
            String strQg = com.byazt.tk.l.qg(sbAppend.append(str2).toString());
            if (TextUtils.isEmpty(strQg)) {
                return -1;
            }
            return (int) (Long.parseLong(strQg.substring(0, Math.min(8, strQg.length())), 16) % 10000);
        } catch (Throwable th) {
            k.qg("TMe_exempt", "getReqFreqExplorationBucket error:" + th.toString());
            return -1;
        }
    }

    private boolean s(com.byazt.zq.qg qgVar) {
        JSONArray jSONArrayIc = com.byazt.nf.rv.qg().ic();
        if (jSONArrayIc != null && qgVar != null && jSONArrayIc.length() > 0) {
            if (jSONArrayIc.length() == 1 && TextUtils.equals(jSONArrayIc.optString(0), "all")) {
                return true;
            }
            String strQ = qgVar.q();
            String strAn = qgVar.an();
            for (int i = 0; i < jSONArrayIc.length(); i++) {
                String strOptString = jSONArrayIc.optString(i);
                if (!TextUtils.isEmpty(strOptString) && (TextUtils.equals(strOptString, strQ) || TextUtils.equals(strOptString, strAn + ":" + strQ))) {
                    return true;
                }
            }
        }
        return false;
    }
}

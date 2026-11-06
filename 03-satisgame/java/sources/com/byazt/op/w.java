package com.byazt.op;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.f.e;
import com.byazt.gct.dg;
import com.byazt.gct.hd;
import com.byazt.gct.ic;
import com.byazt.gct.pk;
import com.byazt.llp.cp;
import com.byazt.tk.k;
import com.byazt.tk.rv;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 502, 13})
public abstract class w extends com.byazt.op.n {
    public String l;
    public String q;
    public volatile SoftReference<pk> w;

    protected interface n {
        void n(boolean z);
    }

    @Override // com.byazt.op.n
    public boolean N_() {
        return false;
    }

    @Override // com.byazt.op.q
    public int n(cp cpVar, s sVar, String str, Map<String, Object> map) {
        return -1;
    }

    @Override // com.byazt.op.q
    @Deprecated
    public int qg(pk pkVar) {
        return 2;
    }

    @Override // com.byazt.op.n, com.byazt.op.q
    public void n(Function<SparseArray<Object>, Object> function) {
        super.n(function);
    }

    @Override // com.byazt.op.n
    public void a_(String str) {
        this.l = str;
    }

    @Override // com.byazt.op.q
    public int n(final Context context, final cp cpVar, final Map<String, Object> map) {
        s(cpVar);
        final int iL = cpVar.l();
        int i = (iL != 9 || !Objects.equals(map.get("saas_status_while_click"), 2) || cpVar.M_() == null || cpVar.M_().s() == null) ? iL : 2;
        if (!n(cpVar.tj(), i)) {
            return 6;
        }
        final String str = map != null ? (String) map.get("event_tag") : "";
        if (!w()) {
            n(com.byazt.ukb.qg.n(cpVar, map), str, iL, 1, i == 7 ? 1 : 2);
            return 1;
        }
        com.byazt.ukb.qg.n(cpVar, map).ih();
        if (this.n == null) {
            return 4;
        }
        this.qg = str;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (l() != 2 ? n(cpVar, new n() { // from class: com.byazt.op.w.1
            @Override // com.byazt.op.w.n
            public void n(boolean z) {
                boolean z2;
                if (atomicBoolean.compareAndSet(false, true)) {
                    w wVar = w.this;
                    wVar.n(context, cpVar, iL, wVar.qg, (Map<String, Object>) map);
                    z2 = false;
                } else {
                    z2 = true;
                }
                com.byazt.eji.s.n().n(com.byazt.ukb.qg.n(cpVar, (Map<String, Object>) map), System.currentTimeMillis() - jCurrentTimeMillis, z, z2);
            }
        }, true, map) : false) {
            ic icVarL_ = cpVar.L_();
            if (cpVar.l() == 9) {
                icVarL_ = cpVar.M_() != null ? cpVar.M_().q() : null;
            }
            ic icVar = icVarL_;
            if (icVar != null) {
                long jL = icVar.l();
                if (jL > 0) {
                    rv.s().postDelayed(new Runnable() { // from class: com.byazt.op.w.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                w.this.n(context, cpVar, iL, str, (Map<String, Object>) map);
                            }
                        }
                    }, jL);
                }
                if (icVar.w() == 1 && com.byazt.vyf.s.cy().s() != null) {
                    new com.byazt.okk.qg().n(new com.byazt.okk.qg.n() { // from class: com.byazt.op.w.3
                        @Override // com.byazt.okk.qg.n
                        public void n(boolean z) {
                        }

                        @Override // com.byazt.okk.qg.n
                        public void n(long j) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                w.this.n(context, cpVar, iL, str, (Map<String, Object>) map);
                            }
                        }

                        @Override // com.byazt.okk.qg.n
                        public void n(String str2) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                w.this.n(context, cpVar, iL, str, (Map<String, Object>) map);
                            }
                        }
                    });
                }
            }
            return 0;
        }
        return n(context, cpVar, i, str, map);
    }

    public boolean n(cp cpVar, final n nVar, boolean z, Map<String, Object> map) {
        if (this.l == null) {
            return false;
        }
        ic icVarL_ = cpVar.L_();
        if (cpVar.l() == 9) {
            icVarL_ = cpVar.M_() != null ? cpVar.M_().q() : null;
        }
        if (icVarL_ == null || icVarL_.s() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.l.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception unused) {
        }
        int iQg = icVarL_.qg();
        boolean z2 = iQg > 0;
        if (z) {
            z2 = iQg == 3;
        }
        if (z2) {
            this.w = new SoftReference<>(com.byazt.ukb.qg.n(cpVar, map));
            if (n(new com.byazt.wc.qg() { // from class: com.byazt.op.w.4
                @Override // com.byazt.wc.qg
                public void n(Object obj) {
                    boolean z3 = false;
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        if (map2.containsKey("code")) {
                            Object obj2 = map2.get("code");
                            if (obj2 instanceof String) {
                                try {
                                    if (Integer.parseInt((String) obj2) == 1) {
                                        z3 = true;
                                    }
                                } catch (NumberFormatException unused2) {
                                }
                            }
                        }
                    }
                    nVar.n(z3);
                }
            }, iQg == 3) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n(Context context, cp cpVar, int i, String str, Map<String, Object> map) {
        int iIntValue;
        int i2;
        int i3;
        int i4;
        int i5;
        com.byazt.ukb.qg.n(cpVar, map).ih();
        if (this.n != null) {
            int iQg = 0;
            Object objApply = this.n.apply(com.byazt.of.qg.n().n(0).n(Integer.class).n(0, new com.byazt.ikv.s().n("context", context).n("bundle", qg(context, cpVar, map))).qg());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            this.qg = str;
            this.q = cpVar.py();
            if (iIntValue == 0) {
                this.w = new SoftReference<>(com.byazt.ukb.qg.n(cpVar, map));
                int iN = com.byazt.hoz.s.n(map);
                if (iN == 101 || iN == 102) {
                    iIntValue |= iN << 8;
                } else {
                    i5 = 2;
                    if (n(cpVar, iN)) {
                        iQg = qg(cpVar);
                        i = 7;
                        if (iQg == 0) {
                            try {
                                new com.byazt.xd.n().n(str).n(context, map, cpVar);
                                iIntValue |= iN << 8;
                            } catch (Exception unused) {
                            }
                        }
                    } else if (cpVar.l() != 9) {
                    }
                }
                i2 = i;
                i4 = iQg;
                i3 = i5;
            } else {
                iQg = 3;
            }
            i5 = i;
            i2 = i;
            i4 = iQg;
            i3 = i5;
        } else {
            iIntValue = 4;
            i2 = i;
            i3 = i2;
            i4 = 1;
        }
        n(com.byazt.ukb.qg.n(cpVar, map), str, i2, i3, i4);
        return iIntValue;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:105:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:111:0x01de  */
    /* JADX WARN: Code duplicated, block: B:124:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:127:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:132:0x02f5 A[Catch: Exception -> 0x0318, TRY_LEAVE, TryCatch #4 {Exception -> 0x0318, blocks: (B:130:0x02ef, B:132:0x02f5), top: B:166:0x02ef }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0331 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:139:0x0332  */
    /* JADX WARN: Code duplicated, block: B:141:0x033c  */
    /* JADX WARN: Code duplicated, block: B:143:0x0348  */
    /* JADX WARN: Code duplicated, block: B:166:0x02ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0139  */
    /* JADX WARN: Code duplicated, block: B:80:0x013f A[Catch: Exception -> 0x014c, TryCatch #1 {Exception -> 0x014c, blocks: (B:75:0x0128, B:80:0x013f, B:82:0x0149), top: B:160:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0149 A[Catch: Exception -> 0x014c, TRY_LEAVE, TryCatch #1 {Exception -> 0x014c, blocks: (B:75:0x0128, B:80:0x013f, B:82:0x0149), top: B:160:0x0128 }] */
    private Bundle qg(Context context, cp cpVar, Map<String, Object> map) throws JSONException {
        int i;
        String strN;
        Map<String, Object> map2;
        JSONArray jSONArrayFs;
        JSONObject jSONObject;
        int i2;
        int i3;
        String string;
        Object obj;
        long jLongValue;
        Bundle bundle = new Bundle();
        if (cpVar != null) {
            try {
                bundle.putLong("room_id", Long.parseLong(cpVar.tj()));
            } catch (Exception unused) {
            }
            Bundle bundle2 = new Bundle();
            hd hdVarSz = cpVar.sz();
            if (cpVar.l() == 9) {
                hdVarSz = cpVar.M_() != null ? cpVar.M_().s() : null;
            }
            int iN = com.byazt.hoz.s.n(map);
            ic icVarL_ = cpVar.L_();
            if (cpVar.l() == 9) {
                icVarL_ = cpVar.M_() != null ? cpVar.M_().q() : null;
            }
            if (icVarL_ != null && icVarL_.s() == 0) {
                int iQg = icVarL_.qg();
                if (iQg == 1) {
                    iN = 101;
                } else if (iQg == 3) {
                    iN = 104;
                }
            }
            int iL = cpVar.l();
            int iQ = q(cpVar);
            dg dgVarCp = cpVar.cp();
            if (cpVar.l() == 9) {
                dgVarCp = cpVar.M_() != null ? cpVar.M_().w() : null;
            }
            String strD = cpVar.d();
            if (cpVar.l() == 9) {
                strD = cpVar.M_() != null ? cpVar.M_().l() : null;
            }
            if (!com.byazt.rcj.w.n(iN)) {
                if (iQ > 0 && l() != 2) {
                    JSONObject jSONObject2 = new JSONObject();
                    com.byazt.ikv.qg.n(cpVar.py(), new Integer(1), Integer.class);
                    jSONObject2.put("auth_reward_gold", iQ);
                    bundle2.putString("live_auth_extra_info", jSONObject2.toString());
                } else if (qg(cpVar) == 0) {
                    if (cpVar.l() == 7) {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } else if (cpVar.l() == 8) {
                        bundle2.putInt("live_popup_dou_deeplink_dialog", 1);
                        bundle2.putString("live_popup_dou_deeplink_url", hdVarSz != null ? hdVarSz.qg() : "");
                    }
                }
            } else {
                if (iN == 101 || iN == 102 || iN == 104) {
                    try {
                        jSONObject = new JSONObject();
                        if (dgVarCp != null) {
                            if (iN == 101) {
                                i = 1;
                            } else {
                                i = iN == 104 ? 3 : 2;
                            }
                            try {
                                jSONObject.put("live_auto_auth_login_source", i);
                                int i4 = iN;
                                jSONObject.put("live_auto_auth_success_has_ticket", com.byazt.hoz.s.n(strD));
                                jSONObject.put("live_auto_auth_promotion_id", dgVarCp.qg());
                                iN = i4;
                                if (iQ > 0) {
                                    if (jSONObject == null) {
                                        try {
                                            jSONObject = new JSONObject();
                                        } catch (Exception unused2) {
                                            i2 = iN;
                                            i3 = i;
                                            iN = i2;
                                            i = i3;
                                            if (dgVarCp != null) {
                                                if (!TextUtils.isEmpty(dgVarCp.x())) {
                                                    bundle2.putString("live_csj_libra_param", dgVarCp.x());
                                                }
                                                jSONArrayFs = dgVarCp.fs();
                                                if (jSONArrayFs != null) {
                                                    n(jSONArrayFs, cpVar);
                                                    bundle.putString("live_tob_task_center_config", jSONArrayFs.toString());
                                                    bundle.putString("live_tob_task_key", cpVar.py());
                                                }
                                            }
                                            if (hdVarSz != null) {
                                                strN = null;
                                            } else {
                                                strN = null;
                                            }
                                            if (TextUtils.isEmpty(strN)) {
                                                strN = n(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map)));
                                            }
                                            bundle2.putString("enter_from_merge", strN);
                                            bundle2.putString("enter_method", qg(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map))));
                                            bundle2.putInt("live_pangle_interaction_type", iN);
                                            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                            if (i != -1) {
                                                try {
                                                    if (!TextUtils.isEmpty(strD)) {
                                                        JSONObject jSONObject3 = new JSONObject(strD);
                                                        JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("enter_request");
                                                        JSONObject jSONObject4 = new JSONObject();
                                                        jSONObject4.put("live_auto_auth_login_source", i);
                                                        jSONObjectOptJSONObject.put("live_commerce_sdk_custom_params", jSONObject4);
                                                        jSONObject3.remove("enter_request");
                                                        jSONObject3.put("enter_request", jSONObjectOptJSONObject);
                                                        strD = jSONObject3.toString();
                                                    }
                                                } catch (Exception unused3) {
                                                }
                                            }
                                            map2 = map;
                                            bundle.putString("ecom_live_params", n(cpVar, strD, map2));
                                            if (!cpVar.H_()) {
                                                return bundle;
                                            }
                                            obj = map2.get("reward_countdown");
                                            if (obj instanceof Long) {
                                                jLongValue = ((Long) obj).longValue();
                                                if (jLongValue > 0) {
                                                    bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                                    bundle.putInt("android.app.activity.request_code", 1);
                                                    if (map2 != null) {
                                                        bundle.putInt("live_popup_reward_auth", 1);
                                                    }
                                                }
                                            }
                                            return bundle;
                                        }
                                    }
                                    i2 = iN;
                                    try {
                                        i3 = i;
                                        try {
                                            com.byazt.ikv.qg.n(cpVar.py(), new Integer(1), Integer.class);
                                            jSONObject.put("auth_reward_gold", iQ);
                                        } catch (Exception unused4) {
                                        }
                                    } catch (Exception unused5) {
                                        i3 = i;
                                    }
                                } else {
                                    i2 = iN;
                                    i3 = i;
                                }
                                if (jSONObject != null) {
                                    string = jSONObject.toString();
                                    if (!TextUtils.isEmpty(string)) {
                                        bundle2.putString("live_auth_extra_info", string);
                                    }
                                }
                                iN = i2;
                                i = i3;
                            } catch (Exception unused6) {
                                iN = iL;
                            }
                        } else {
                            iN = iL;
                        }
                    } catch (JSONException | Exception unused7) {
                        iN = iL;
                        i = -1;
                    }
                    if (dgVarCp != null) {
                        if (!TextUtils.isEmpty(dgVarCp.x())) {
                            bundle2.putString("live_csj_libra_param", dgVarCp.x());
                        }
                        jSONArrayFs = dgVarCp.fs();
                        if (jSONArrayFs != null) {
                            n(jSONArrayFs, cpVar);
                            bundle.putString("live_tob_task_center_config", jSONArrayFs.toString());
                            bundle.putString("live_tob_task_key", cpVar.py());
                        }
                    }
                    if (hdVarSz != null || TextUtils.isEmpty(hdVarSz.qg())) {
                        strN = null;
                    } else {
                        try {
                            Uri uri = Uri.parse(hdVarSz.qg());
                            JSONObject jSONObject5 = new JSONObject(uri.getQueryParameter("ad_data_params"));
                            String strOptString = jSONObject5.optString("log_extra");
                            HashMap map3 = new HashMap();
                            JSONObject jSONObject6 = new JSONObject();
                            if (!TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject7 = new JSONObject(strOptString);
                                jSONObject7.put("ad_event_aid", jSONObject5.optString("aid"));
                                jSONObject7.put("ad_event_source", com.byazt.rd.qg.n(uri, "source"));
                                jSONObject7.put("ad_event_gd_label", com.byazt.rd.qg.n(uri, "gd_label"));
                                jSONObject7.put("ad_event_union_user_id", com.byazt.rd.qg.n(uri, "union_user_id"));
                                jSONObject7.put("ad_event_app_siteid", com.byazt.vyf.s.cy().ou());
                                jSONObject7.put("ad_event_live_type", "1");
                                map3.put("log_extra", jSONObject7.toString());
                                jSONObject6.put("log_extra", jSONObject7.toString());
                            }
                            String strOptString2 = jSONObject5.optString("cid");
                            jSONObject6.put("creativeID", strOptString2);
                            bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject6.toString());
                            map3.put("is_other_channel", "union_ad");
                            map3.put(e.a.d, strOptString2);
                            bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                            String strN2 = com.byazt.rd.qg.n(uri, "pangle_live_room_data");
                            if (!TextUtils.isEmpty(strN2)) {
                                bundle.putString("pangle_live_room_data", strN2);
                            }
                            String strN3 = com.byazt.rd.qg.n(uri, "owner_open_id");
                            if (TextUtils.isEmpty(strN3)) {
                                strN3 = com.byazt.rd.qg.n(uri, "user_id");
                            }
                            bundle2.putString("anchor_id", strN3);
                            bundle2.putString("live.intent.extra.REQUEST_ID", com.byazt.rd.qg.n(uri, "request_id"));
                            strN = com.byazt.rd.qg.n(uri, "enter_from_merge");
                        } catch (Exception unused8) {
                            strN = null;
                        }
                    }
                    if (TextUtils.isEmpty(strN)) {
                        strN = n(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map)));
                    }
                    bundle2.putString("enter_from_merge", strN);
                    bundle2.putString("enter_method", qg(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map))));
                    bundle2.putInt("live_pangle_interaction_type", iN);
                    bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                    if (i != -1) {
                        if (!TextUtils.isEmpty(strD)) {
                            JSONObject jSONObject8 = new JSONObject(strD);
                            JSONObject jSONObjectOptJSONObject2 = jSONObject8.optJSONObject("enter_request");
                            JSONObject jSONObject9 = new JSONObject();
                            jSONObject9.put("live_auto_auth_login_source", i);
                            jSONObjectOptJSONObject2.put("live_commerce_sdk_custom_params", jSONObject9);
                            jSONObject8.remove("enter_request");
                            jSONObject8.put("enter_request", jSONObjectOptJSONObject2);
                            strD = jSONObject8.toString();
                        }
                    }
                    map2 = map;
                    bundle.putString("ecom_live_params", n(cpVar, strD, map2));
                } else {
                    if (iN == 103) {
                        try {
                            bundle2.putInt("live_popup_dou_auth_dialog", 1);
                        } catch (Exception unused9) {
                            i = -1;
                        }
                    } else {
                        iN = iL;
                    }
                    jSONObject = null;
                }
                i = -1;
                if (iQ > 0) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    i2 = iN;
                    i3 = i;
                    com.byazt.ikv.qg.n(cpVar.py(), new Integer(1), Integer.class);
                    jSONObject.put("auth_reward_gold", iQ);
                } else {
                    i2 = iN;
                    i3 = i;
                }
                if (jSONObject != null) {
                    string = jSONObject.toString();
                    if (!TextUtils.isEmpty(string)) {
                        bundle2.putString("live_auth_extra_info", string);
                    }
                }
                iN = i2;
                i = i3;
                if (dgVarCp != null) {
                    if (!TextUtils.isEmpty(dgVarCp.x())) {
                        bundle2.putString("live_csj_libra_param", dgVarCp.x());
                    }
                    jSONArrayFs = dgVarCp.fs();
                    if (jSONArrayFs != null) {
                        n(jSONArrayFs, cpVar);
                        bundle.putString("live_tob_task_center_config", jSONArrayFs.toString());
                        bundle.putString("live_tob_task_key", cpVar.py());
                    }
                }
                if (hdVarSz != null) {
                    strN = null;
                } else {
                    strN = null;
                }
                if (TextUtils.isEmpty(strN)) {
                    strN = n(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map)));
                }
                bundle2.putString("enter_from_merge", strN);
                bundle2.putString("enter_method", qg(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map))));
                bundle2.putInt("live_pangle_interaction_type", iN);
                bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                if (i != -1) {
                    if (!TextUtils.isEmpty(strD)) {
                        JSONObject jSONObject10 = new JSONObject(strD);
                        JSONObject jSONObjectOptJSONObject3 = jSONObject10.optJSONObject("enter_request");
                        JSONObject jSONObject11 = new JSONObject();
                        jSONObject11.put("live_auto_auth_login_source", i);
                        jSONObjectOptJSONObject3.put("live_commerce_sdk_custom_params", jSONObject11);
                        jSONObject10.remove("enter_request");
                        jSONObject10.put("enter_request", jSONObjectOptJSONObject3);
                        strD = jSONObject10.toString();
                    }
                }
                map2 = map;
                bundle.putString("ecom_live_params", n(cpVar, strD, map2));
            }
            iN = iL;
            i = -1;
            if (dgVarCp != null) {
                if (!TextUtils.isEmpty(dgVarCp.x())) {
                    bundle2.putString("live_csj_libra_param", dgVarCp.x());
                }
                jSONArrayFs = dgVarCp.fs();
                if (jSONArrayFs != null) {
                    n(jSONArrayFs, cpVar);
                    bundle.putString("live_tob_task_center_config", jSONArrayFs.toString());
                    bundle.putString("live_tob_task_key", cpVar.py());
                }
            }
            if (hdVarSz != null) {
                strN = null;
            } else {
                strN = null;
            }
            if (TextUtils.isEmpty(strN)) {
                strN = n(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map)));
            }
            bundle2.putString("enter_from_merge", strN);
            bundle2.putString("enter_method", qg(com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map))));
            bundle2.putInt("live_pangle_interaction_type", iN);
            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
            if (i != -1) {
                if (!TextUtils.isEmpty(strD)) {
                    JSONObject jSONObject12 = new JSONObject(strD);
                    JSONObject jSONObjectOptJSONObject4 = jSONObject12.optJSONObject("enter_request");
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("live_auto_auth_login_source", i);
                    jSONObjectOptJSONObject4.put("live_commerce_sdk_custom_params", jSONObject13);
                    jSONObject12.remove("enter_request");
                    jSONObject12.put("enter_request", jSONObjectOptJSONObject4);
                    strD = jSONObject12.toString();
                }
            }
            map2 = map;
            bundle.putString("ecom_live_params", n(cpVar, strD, map2));
        } else {
            map2 = map;
        }
        if (!cpVar.H_()) {
            return bundle;
        }
        obj = map2.get("reward_countdown");
        if (obj instanceof Long) {
            jLongValue = ((Long) obj).longValue();
            if (jLongValue > 0) {
                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                bundle.putInt("android.app.activity.request_code", 1);
                if (map2 != null && map2.containsKey("reward_live_scene") && ((Integer) map2.get("reward_live_scene")).intValue() == 1) {
                    bundle.putInt("live_popup_reward_auth", 1);
                }
            }
        }
        return bundle;
    }

    private void n(JSONArray jSONArray, cp cpVar) {
        com.byazt.um.n nVar;
        if (cpVar == null || jSONArray == null || (nVar = (com.byazt.um.n) com.byazt.ikv.qg.n(cpVar.py(), com.byazt.um.n.class)) == null || nVar.qg.isEmpty()) {
            return;
        }
        String strQ = cpVar.q();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (nVar.qg.contains(strQ + "_" + jSONObject.optString("type"))) {
                    jSONObject.put("status", 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int q(cp cpVar) {
        String strCy = cpVar.cy();
        Integer num = (Integer) com.byazt.ikv.qg.n(cpVar.py(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(strCy)) {
            return 0;
        }
        try {
            return new JSONObject(strCy).optInt("auth_reward_gold");
        } catch (Throwable th) {
            k.n(com.byazt.ea.s.TAG, th);
            return 0;
        }
    }

    public static String n(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        if (i == 1) {
            return "ad_union_banner";
        }
        if (i == 3 || i == 4) {
            return "ad_union_topview";
        }
        if (i == 2) {
            return "ad_union_former_insert";
        }
        return i == 6 ? "ad_union_patch" : EnterFromMerge.NO_VALUE.lowerName();
    }

    public static String qg(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    @Override // com.byazt.op.q
    public int n(Context context, pk pkVar, Map<String, Object> map) {
        long jLongValue;
        if (map != null) {
            try {
                Object obj = map.get("reward_countdown");
                if (obj instanceof Long) {
                    jLongValue = ((Long) obj).longValue();
                } else {
                    jLongValue = 0;
                }
            } catch (Exception unused) {
            }
        } else {
            jLongValue = 0;
        }
        if (context == null || pkVar == null) {
            return 5;
        }
        if (!(context instanceof Activity)) {
            return 7;
        }
        if (!com.byazt.gct.e.n(pkVar)) {
            return 5;
        }
        if (jLongValue < 0) {
            return 8;
        }
        if (com.byazt.gct.e.qg(pkVar) == 1) {
            return 9;
        }
        return n(context, (cp) pkVar, map);
    }

    @Override // com.byazt.op.q
    public boolean a_(pk pkVar) {
        return n((cp) pkVar);
    }

    @Override // com.byazt.op.q
    public String x() {
        return this.l;
    }

    @Override // com.byazt.op.q
    public int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 15;
        }
        if (this.n == null) {
            return 12;
        }
        if (!w()) {
            return 11;
        }
        Object objCx = com.byazt.vyf.s.cy().cx();
        if (objCx == null) {
            return 13;
        }
        try {
            Object objApply = this.n.apply(com.byazt.of.qg.n().n(8).n(Boolean.class).n(0, new com.byazt.ikv.s().n("context", objCx).n("scheme_uri", str)).qg());
            return objApply != null ? ((Boolean) objApply).booleanValue() : false ? 1 : 10;
        } catch (Exception unused) {
            return 14;
        }
    }

    @Override // com.byazt.op.q
    public int n(com.byazt.wc.qg qgVar, boolean z) {
        if (this.n == null) {
            return 12;
        }
        if (!w()) {
            return 11;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", "requestDyAuth");
        map.put("expand_method_param", new Object[]{com.byazt.vyf.s.cy().cx(), qgVar, Boolean.valueOf(z)});
        new StringBuilder("requestDyAuth:").append(this.n.apply(com.byazt.of.qg.n().n(7).n(Void.class).n(0, map).qg()));
        return 1;
    }

    @Override // com.byazt.op.n, com.byazt.op.q
    public void n(String str, pk pkVar, long j) {
        com.byazt.gks.n.n(str, pkVar, j);
    }

    @Override // com.byazt.op.q
    public void n(String str, boolean z) {
        if (this.n != null && w()) {
            HashMap map = new HashMap();
            map.put("expand_method_name", str);
            map.put("expand_method_param", new Object[]{Boolean.valueOf(z)});
            this.n.apply(com.byazt.of.qg.n().n(7).n(Void.class).n(0, map).qg());
        }
    }
}

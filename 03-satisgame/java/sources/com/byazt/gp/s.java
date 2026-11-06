package com.byazt.gp;

import android.text.TextUtils;
import android.view.View;
import com.anythink.core.common.f.a;
import com.anythink.core.d.b.e;
import com.byazt.vf.hu;
import com.byazt.vy.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 8})
public class s {
    private static boolean n(double d, double d2) {
        if (d <= 0.0d) {
            return false;
        }
        return d >= 1.0d || d2 <= d;
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, int i, String str, long j, int i2, int i3, String str2, int i4, int i5, long j2) {
        com.byazt.ng.l lVarN;
        com.byazt.ws.qg qgVarN;
        qg qgVarQg = qg.qg();
        qgVarQg.n("media_reward_verify").n(j2).n("adn_preload", Integer.valueOf((sVar == null || !sVar.oj()) ? 0 : 1)).n(MediationConstant.KEY_REASON, Integer.valueOf(i2)).n("play_again", Integer.valueOf(i));
        if (i3 != 0 && i3 != 20000) {
            qgVarQg.qg(i3).cp(str2);
        }
        HashMap map = new HashMap();
        map.put("reward_source", Integer.valueOf(i4));
        map.put("rv_open", Integer.valueOf(i5));
        boolean z = j >= 0;
        if (sVar != null && sVar.rg()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(d.s()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        if (qgVar != null && (lVarN = com.byazt.qt.qg.n()) != null && (qgVarN = lVarN.n(qgVar.a(), qgVar.um(), 101)) != null) {
            map.put("reward_callback_type", Integer.valueOf(qgVarN.wo()));
            map.put("reward_start_time", Integer.valueOf(qgVarN.pk()));
        }
        if (str != null) {
            qgVarQg.n("sub_adn_name", str);
        }
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, int i, String str, long j, boolean z, int i2, View view) {
        n(sVar, qgVar, i, str, j, (String) null, z, i2, view);
    }

    public static void n() {
        qg qgVarQg = qg.qg();
        qgVarQg.n("mediation_sdk_init");
        try {
            n(qgVarQg, (com.byazt.qn.qg) null, (com.byazt.ws.tj) null, (com.byazt.sg.s) null, (Map<String, Object>) null);
            tj.n(com.byazt.qt.qg.getContext(), qgVarQg, (Map<String, Object>) null);
        } catch (Throwable unused) {
        }
    }

    public static void n(final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar, final int i, final String str, final long j, final String str2, final boolean z, final int i2) {
        final qg qgVarS = qg.s();
        com.byazt.tk.rv.s().post(new Runnable() { // from class: com.byazt.gp.s.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, sVar, qgVar, i, str, j, str2, z, i2);
            }
        });
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, int i, String str, long j, String str2, boolean z, int i2, View view) {
        n(sVar, qgVar, i, str, j, str2, z, i2);
        n(sVar, qgVar, view);
    }

    private static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, View view) {
        com.byazt.ng.n.C0266n c0266nN;
        if (sVar == null || n(sVar) || (c0266nN = com.byazt.ng.n.n(sVar.ci(), sVar.rg())) == null) {
            return;
        }
        if (n(c0266nN.qg, Math.random())) {
            final boolean zN = n(c0266nN.q, Math.random());
            final boolean zN2 = n(c0266nN.l, Math.random());
            final boolean z = c0266nN.w;
            long j = c0266nN.s;
            final WeakReference weakReference = new WeakReference(sVar);
            final boolean z2 = qgVar != null;
            final WeakReference weakReference2 = new WeakReference(qgVar);
            final boolean z3 = view != null;
            final WeakReference weakReference3 = new WeakReference(view);
            com.byazt.tk.rv.s().postDelayed(new Runnable() { // from class: com.byazt.gp.s.12
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.sg.s sVar2 = (com.byazt.sg.s) weakReference.get();
                            if (sVar2 == null) {
                                return;
                            }
                            com.byazt.qn.qg qgVar2 = (com.byazt.qn.qg) weakReference2.get();
                            if (z2 && qgVar2 == null) {
                                return;
                            }
                            View view2 = (View) weakReference3.get();
                            if (!z3 || s.qg(view2)) {
                                s.qg(sVar2, qgVar2, view2, zN, zN2, z);
                            }
                        }
                    });
                }
            }, j);
        }
    }

    private static boolean n(com.byazt.sg.s sVar) {
        if (sVar == null || sVar.kc()) {
            return false;
        }
        int iCt = sVar.ct();
        return iCt == 9 || iCt == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(View view) {
        return view != null && view.isAttachedToWindow() && view.getVisibility() == 0 && view.getWindowVisibility() == 0 && view.getAlpha() > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, View view, boolean z, boolean z2, boolean z3) {
        int iUm;
        qg qgVarS = qg.s();
        qgVarS.n("media_ad_info");
        HashMap map = new HashMap();
        if (qgVar == null) {
            iUm = sVar == null ? 0 : sVar.ct();
        } else {
            iUm = qgVar.um();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strN = w.n(sVar, view, map, z, z2, z3, iUm, n(sVar, qgVar));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (strN == null) {
            return;
        }
        map.put("coll_dur", Long.valueOf(jCurrentTimeMillis2));
        qgVarS.n("ex_info", strN);
        n(qgVarS, qgVar, (com.byazt.ws.tj) null, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarS, map);
    }

    public static void n(int i, String str, long j) {
        try {
            tj.n(com.byazt.qt.qg.getContext(), qg.s().n("dc_pic_url_fail").qg(i).cp(str).n(j), (Map<String, Object>) null);
        } catch (Throwable unused) {
        }
    }

    public static void n(List<x.qg> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (x.qg qgVar : list) {
            if (qgVar != null && qgVar.n != null && qgVar.qg > 0) {
                x.fs fsVar = qgVar.n;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("file_name", fsVar.n);
                    jSONObject.put(a.C0017a.d, fsVar.q);
                    jSONObject.put("req_id", fsVar.qg);
                    jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, fsVar.s);
                    jSONObject.put("error_code", qgVar.qg);
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            }
        }
        if (jSONArray.length() == 0) {
            return;
        }
        qg qgVarN = qg.s().n("dc_pic_delete");
        HashMap map = new HashMap();
        map.put("pics", jSONArray);
        try {
            tj.n(com.byazt.qt.qg.getContext(), qgVarN, map);
        } catch (Throwable unused2) {
        }
    }

    public static String n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar) {
        if (sVar == null) {
            return "";
        }
        String strDi = sVar.di();
        return !TextUtils.isEmpty(strDi) ? strDi : "";
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, String str) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("media_show_dislike").cp(str);
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, int i, String str, long j, boolean z) {
        n(sVar, qgVar, i, str, j, (String) null, z);
    }

    public static void n(final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar, final int i, final String str, final long j, final String str2, final boolean z) {
        final qg qgVarS = qg.s();
        com.byazt.tk.rv.s().post(new Runnable() { // from class: com.byazt.gp.s.21
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, sVar, qgVar, i, str, j, str2, z);
            }
        });
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, boolean z, int i) {
        n(sVar, qgVar, z, i, (Map<String, Object>) null);
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, boolean z, int i, Map<String, Object> map) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("media_show").n("adn_preload", Integer.valueOf((sVar == null || !sVar.oj()) ? 0 : 1)).n("play_again", Integer.valueOf(i)).n("is_repeat", Integer.valueOf(z ? 1 : 0));
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map2);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map2);
    }

    public static void n(List<com.byazt.sg.s> list, List<com.byazt.sg.s> list2, List<com.byazt.sg.s> list3, com.byazt.qn.qg qgVar, int i) {
        boolean zAe;
        ArrayList<com.byazt.sg.s> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i2 = 0;
        com.byazt.sg.s sVar = arrayList.size() > 0 ? (com.byazt.sg.s) arrayList.get(0) : null;
        qg qgVarQg = qg.qg();
        qgVarQg.n("media_show_is_ready");
        if (i == 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                loop0: while (true) {
                    zAe = false;
                    for (com.byazt.sg.s sVar2 : arrayList) {
                        if (sVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", sVar2.lq());
                            jSONObject.put("type", com.byazt.sg.n.n(sVar2.ct(), sVar2.dg()));
                            jSONObject.put("adnSlotId", sVar2.el());
                            jSONObject.put("loadSort", sVar2.la());
                            jSONObject.put("showSort", sVar2.il());
                            if (qgVar != null) {
                                jSONObject.put("isReady", sVar2.ae(qgVar.a()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", sVar2.nf() ? 1 : 0);
                            if (sVar2.rm()) {
                                jSONObject.put("is_video_cache_success", sVar2.jw() ? 1 : 0);
                            }
                            jSONObject.put("mediationrit_req_type", sVar2.fs(qgVar != null ? qgVar.n() : null));
                            jSONObject.put("mediationrit_req_type_src", sVar2.rv(qgVar != null ? qgVar.n() : null));
                            jSONArray.put(jSONObject);
                            if (!zAe && qgVar != null) {
                                if (qgVar.um() == 5) {
                                    zAe = sVar2.ae(qgVar.a());
                                } else if (sVar2.ae(qgVar.a()) && !sVar2.nf()) {
                                    zAe = true;
                                }
                            }
                        }
                    }
                    break loop0;
                }
                if (!zAe) {
                    i2 = -1;
                }
                qgVarQg.qg(i2);
                qgVarQg.cp(jSONArray.toString());
            } catch (JSONException unused) {
            }
        } else {
            qgVarQg.qg(2);
            qgVarQg.cp(com.byazt.mj.n.n(i));
        }
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(List<com.byazt.sg.s> list, com.byazt.qn.qg qgVar, int i) {
        com.byazt.sg.s sVar = (list == null || list.size() <= 0) ? null : list.get(0);
        qg qgVarQg = qg.qg();
        qgVarQg.n("media_show_fail");
        if (i == 0) {
            qgVarQg.qg(40052);
            if (sVar != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.byazt.sg.s sVar2 : list) {
                        if (sVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", sVar2.lq());
                            jSONObject.put("type", com.byazt.sg.n.n(sVar2.ct(), sVar2.dg()));
                            jSONObject.put("adnSlotId", sVar2.el());
                            jSONObject.put("loadSort", sVar2.la());
                            jSONObject.put("showSort", sVar2.il());
                            int i2 = 1;
                            if (qgVar != null) {
                                jSONObject.put("isReady", sVar2.ae(qgVar.a()) ? 1 : 0);
                            }
                            if (!sVar2.nf()) {
                                i2 = 0;
                            }
                            jSONObject.put("hasShown", i2);
                            jSONArray.put(jSONObject);
                        }
                    }
                    qgVarQg.cp(jSONArray.toString());
                } catch (JSONException unused) {
                }
            }
        } else {
            qgVarQg.qg(i);
            qgVarQg.cp(com.byazt.mj.n.n(i));
        }
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map);
        qgVarQg.n("is_video_cache_success", 0);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(com.byazt.qn.qg qgVar, int i) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("media_carousel_fail").qg(i).cp(com.byazt.mj.n.n(i));
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, (com.byazt.sg.s) null, map);
        qgVarQg.n("is_video_cache_success", 0);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(final int i, final int i2, final long j, final String str, final String str2) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.22
            @Override // java.lang.Runnable
            public void run() {
                qgVarS.n("rit_map_query").setResult(i2).n(j).l(i);
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    qgVarS.fs(str);
                    map.put("origin_rit", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    qgVarS.qg(str2);
                    map.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
                }
                tj.n(com.byazt.qt.qg.getContext(), qgVarS, map);
            }
        });
    }

    public static void n(final com.byazt.ws.tj tjVar, final com.byazt.qn.qg qgVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.byazt.mj.n nVar, final long j, final boolean z2, final boolean z3, final long j2) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.23
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, tjVar, qgVar, str, z, i, i2, i3, i4, nVar, j, z2, z3, null, j2);
            }
        });
    }

    public static void n(final com.byazt.ws.tj tjVar, final com.byazt.qn.qg qgVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.byazt.mj.n nVar, final long j, final boolean z2, final boolean z3, final String str2, final long j2) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.24
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, tjVar, qgVar, str, z, i, i2, i3, i4, nVar, j, z2, z3, str2, j2);
            }
        });
    }

    public static void n(com.byazt.ws.tj tjVar, com.byazt.qn.qg qgVar, com.byazt.sg.s sVar, int i, String str) {
        qg qgVarQg = qg.qg();
        qg qgVarN = qgVarQg.n("bidding_info_invalid").qg(i).cp(str).n("ad_count", Integer.valueOf(qgVar != null ? qgVar.m() : 0));
        com.byazt.ng.q.n(com.byazt.qt.qg.n());
        qgVarN.n("grouping_params", com.byazt.ng.q.n(com.byazt.qt.n.d().py())).n("log_source", 2);
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, tjVar, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(final com.byazt.sg.s sVar, final int i, final String str, final long j, final com.byazt.qn.qg qgVar, final int i2, final int i3, final int i4, final String str2, final long j2, final long j3) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.25
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, sVar, i, str, j, qgVar, i2, i3, i4, str2, j2, j3);
            }
        });
    }

    public static void n(final com.byazt.mj.n nVar, final com.byazt.qn.qg qgVar, final com.byazt.ws.tj tjVar, final int i, final int i2, final int i3, final String str, final long j, final String str2, final String str3, final String str4, final long j2) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.26
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, nVar, qgVar, tjVar, i, i2, i3, str, j, str2, str3, str4, j2);
            }
        });
    }

    public static void n(com.byazt.mj.n nVar, com.byazt.qn.qg qgVar, com.byazt.ws.tj tjVar, int i, int i2, int i3, String str, long j) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("bidding_adm_load_fail").n(j).w(str).qg(nVar != null ? nVar.s : -1).cp(nVar != null ? nVar.q : "unknown error").n("adn_count", Integer.valueOf(i)).n("adn_preload", 0).n("mediationrit_req_type", Integer.valueOf(i2)).n("mediationrit_req_type_src", Integer.valueOf(i3));
        if (nVar instanceof com.byazt.pu.n) {
            qgVarQg.k = nVar.n;
            qgVarQg.d = nVar.qg;
        }
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, tjVar, (com.byazt.sg.s) null, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(final com.byazt.qn.qg qgVar, final com.byazt.mj.n nVar, final String str) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.27
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, qgVar, nVar, str);
            }
        });
    }

    public static void n(final com.byazt.ws.tj tjVar, final com.byazt.qn.qg qgVar, final int i, final int i2) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, tjVar, qgVar, i, i2);
            }
        });
    }

    public static void n(final com.byazt.qn.qg qgVar, final String str, final boolean z, final String str2, final int i, final Map<String, Object> map) {
        if (qgVar != null) {
            com.byazt.iav.n.n().n(qgVar.n(), com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).qg());
        }
        final qg qgVarS = qg.s();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.3
            @Override // java.lang.Runnable
            public void run() {
                qgVarS.n(System.currentTimeMillis() - jCurrentTimeMillis);
                com.byazt.yh.n.n().n(qgVarS, qgVar, str, z, str2, i, map);
            }
        });
    }

    public static void n(Map<String, Object> map, final com.byazt.qn.qg qgVar, final com.byazt.sg.s sVar, final long j, final int i, final int i2, final int i3, final String str, final int i4, final int i5, final com.byazt.ws.qg qgVar2, final JSONObject jSONObject) {
        final JSONObject jSONObject2;
        int i6;
        final qg qgVarS = qg.s();
        if (map != null) {
            int iIntValue = map.get("group_type") instanceof Integer ? ((Integer) map.get("group_type")).intValue() : 0;
            double dDoubleValue = map.get("ecpm") instanceof Double ? ((Double) map.get("ecpm")).doubleValue() : 0.0d;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("price_from", map.get("price_from"));
                jSONObject3.put("grout_type", iIntValue);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("target_ecpm_origin", dDoubleValue);
                jSONObject4.put("target_ecpm_upper", map.get("upper_cpm_x"));
                jSONObject3.put(e.a.h, jSONObject4);
                if (map.get("price_source") != null) {
                    jSONObject3.put("price_source", map.get("price_source"));
                }
                int iIntValue2 = map.get("rule_in_use") instanceof Integer ? ((Integer) map.get("rule_in_use")).intValue() : 0;
                boolean zBooleanValue = map.get("has_serverBidding") instanceof Boolean ? ((Boolean) map.get("has_serverBidding")).booleanValue() : false;
                if (iIntValue != 3 && iIntValue != 4) {
                    i6 = 0;
                } else if (!zBooleanValue) {
                    i6 = 1;
                } else if (dDoubleValue == 0.0d) {
                    i6 = 2;
                } else if (iIntValue2 == 0) {
                    i6 = 5;
                } else {
                    i6 = (iIntValue != 4 || (map.get("serverBidding_timeout") instanceof Boolean ? ((Boolean) map.get("serverBidding_timeout")).booleanValue() : false)) ? 4 : 3;
                }
                jSONObject3.put("pos_state", i6);
                jSONObject3.put(a.C0017a.o, map.get(a.C0017a.o));
                jSONObject3.put("rule_inuse", iIntValue2);
            } catch (JSONException unused) {
            }
            jSONObject2 = jSONObject3;
        } else {
            jSONObject2 = null;
        }
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, qgVar, sVar, j, i, i2, i3, str, i4, i5, qgVar2, jSONObject2, jSONObject);
            }
        });
    }

    public static void n(final com.byazt.qn.qg qgVar, final com.byazt.sg.s sVar, final long j) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, qgVar, sVar, j);
            }
        });
    }

    public static void n(final com.byazt.qn.qg qgVar, final com.byazt.sg.s sVar, final com.byazt.ws.tj tjVar) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.6
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, qgVar, sVar, tjVar);
            }
        });
    }

    public static void n(final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar, final com.byazt.ws.qg qgVar2, final long j, final String str, final boolean z, final int i, final boolean z2, final boolean z3) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.7
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, sVar, qgVar, qgVar2, j, str, z, i, z2, z3);
            }
        });
    }

    public static void qg(final com.byazt.qn.qg qgVar, final int i) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.8
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, qgVar, i);
            }
        });
    }

    public static void n(final boolean z) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.9
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                boolean z2 = com.byazt.ri.n.n().getBoolean("is_config_from_assert", false);
                if (z) {
                    i = z2 ? 2 : 1;
                }
                qgVarS.n("get_config_start").n(MediationConstant.KEY_REASON, Integer.valueOf(i));
                tj.n(com.byazt.qt.qg.getContext(), qgVarS, (Map<String, Object>) null);
            }
        });
    }

    public static void qg() {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.10
            @Override // java.lang.Runnable
            public void run() {
                qgVarS.n("init_adn_splash_info_request");
                tj.n(com.byazt.qt.qg.getContext(), qgVarS, (Map<String, Object>) null);
            }
        });
    }

    public static void n(final long j, final boolean z, final String str, final int i) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.11
            @Override // java.lang.Runnable
            public void run() {
                qgVarS.n("init_adn_splash_info_result").n("result", Integer.valueOf(z ? 1 : 0)).n(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
                if (!z) {
                    qgVarS.n("error_code", Integer.valueOf(i)).n("error_msg", str);
                }
                tj.n(com.byazt.qt.qg.getContext(), qgVarS, (Map<String, Object>) null);
            }
        });
    }

    public static void s() {
        qg qgVarQg = qg.qg();
        qgVarQg.n("start_up");
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, (Map<String, Object>) null);
    }

    public static void n(long j) {
        String str;
        qg qgVarQg = qg.qg();
        qgVarQg.n("sdk_init").s(j);
        com.byazt.gwu.s sVarFs = com.byazt.ri.n.fs();
        boolean z = sVarFs.getBoolean("check_unity3d", false);
        long j2 = sVarFs.getLong("check_unity3d_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z && jCurrentTimeMillis - j2 > 2592000000L) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                str = "unity_pure";
                try {
                    Class.forName("com.bytedance.android.NativeAdManager");
                    str = MediationConstant.ADN_UNITY;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = null;
            }
            if (str != null) {
                qgVarQg.n("develop_type", str);
            }
            sVarFs.n("check_unity3d", true);
            sVarFs.n("check_unity3d_time", jCurrentTimeMillis);
        }
        HashMap map = new HashMap();
        int iQ = com.byazt.gi.n.n().q();
        if (iQ > 0) {
            com.byazt.gi.n.n().l();
            map.put("discard_num", Integer.valueOf(iQ));
        }
        map.put("sdk_boost_type", Integer.valueOf(com.byazt.gv.n.l()));
        map.put("csj_plugin_version", com.byazt.it.s.q());
        JSONObject jSONObjectN = com.byazt.vy.a.n();
        if (jSONObjectN != null) {
            map.put("init_time", jSONObjectN);
        }
        com.byazt.vy.a.n(map);
        com.byazt.vy.a.qg(map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void qg(long j) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("sdk_backstage").n(j);
        HashMap map = new HashMap();
        if (com.byazt.gi.n.n().cp()) {
            if (com.byazt.gi.n.n().fs() > 0) {
                com.byazt.gi.n.n().n(com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).qg());
                map.put("call_init_method_duration", Long.valueOf(com.byazt.gi.n.n().fs()));
            }
        } else if (com.byazt.gi.n.n().d()) {
            map.put("call_init_method_duration", Long.valueOf(com.byazt.gi.n.n().fs()));
        }
        map.put("v2Enc_config", com.byazt.vy.a.n("v2Enc_config"));
        map.put("v4Enc_config", com.byazt.vy.a.n("v4Enc_config"));
        map.put("v2Enc_exchange", com.byazt.vy.a.n("v2Enc_exchange"));
        map.put("v4Enc_exchange", com.byazt.vy.a.n("v4Enc_exchange"));
        map.put("v2Enc_reward", com.byazt.vy.a.n("v2Enc_reward"));
        map.put("v4Enc_reward", com.byazt.vy.a.n("v4Enc_reward"));
        map.put("enable_label_return", Integer.valueOf(com.byazt.qt.qg.n().dh() ? 1 : 0));
        map.put("if_labelapi_call", Integer.valueOf(com.byazt.qt.n.d().n() ? 1 : 0));
        map.put("adn_init_duration", com.byazt.ya.l.n());
        map.put("sdk_boost_type", Integer.valueOf(com.byazt.gv.n.l()));
        map.put("layer_init_type", Integer.valueOf(q()));
        com.byazt.mh.l.n(map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    private static int q() {
        hu huVar = (hu) com.byazt.qp.q.n("m_d_s");
        if (huVar != null) {
            Object objN = huVar.n(3);
            if (objN instanceof Integer) {
                return ((Integer) objN).intValue();
            }
        }
        return -1;
    }

    public static void n(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.13
            @Override // java.lang.Runnable
            public void run() {
                qgVarS.n("callstack_dynamic");
                qgVarS.n("callstack_message", str);
                qgVarS.n("callstack_report_time", 1);
                tj.n(com.byazt.qt.qg.getContext(), qgVarS, (Map<String, Object>) null);
            }
        });
    }

    public static void n(final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar, final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.14
            @Override // java.lang.Runnable
            public void run() {
                qgVarS.n("callstack_static").n("callstack_message", str).n("callstack_report_time", Integer.valueOf(i));
                HashMap map = new HashMap();
                s.n(qgVarS, qgVar, (com.byazt.ws.tj) null, sVar, map);
                tj.n(com.byazt.qt.qg.getContext(), qgVarS, map);
            }
        });
    }

    public static void n(long j, int i, int i2, long j2, JSONObject jSONObject, Map<String, Object> map) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("sdk_init_end");
        qgVarQg.n(j);
        qgVarQg.s(j2);
        qgVarQg.n("adn_count", Integer.valueOf(i));
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        map2.put("is_from_local_config", Integer.valueOf(i2));
        JSONObject jSONObjectRv = com.byazt.ya.q.rv();
        if (jSONObjectRv != null) {
            map2.put("adapter_version_list", jSONObjectRv);
        }
        if (jSONObject != null) {
            map2.put("init_stage_time", jSONObject);
        }
        map2.put("init_count", Integer.valueOf(com.byazt.vy.a.qg()));
        map2.put("sdk_boost_type", Integer.valueOf(com.byazt.gv.n.l()));
        map2.put("layer_init_type", Integer.valueOf(q()));
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map2);
    }

    public static void n(int i, int i2, long j, boolean z, boolean z2, JSONObject jSONObject, long j2, JSONObject jSONObject2) {
        qg qgVarQg = qg.qg();
        boolean z3 = com.byazt.ri.n.n().getBoolean("is_config_from_assert", false);
        if (i != 1) {
            i = (z || (i == 0 && z3)) ? 2 : 0;
        }
        qgVarQg.setResult(i).n(j).n("get_config_final").w(i2).qg(i2).n("transparent_params", com.byazt.qt.qg.n().hd());
        HashMap map = new HashMap();
        com.byazt.cby.q.n(z2, qgVarQg, jSONObject, map);
        if (jSONObject2 != null) {
            map.put("cfg_handle_time", jSONObject2);
        }
        map.put("config_size", Long.valueOf(j2));
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(final com.byazt.qn.qg qgVar, final JSONObject jSONObject) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.15
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, qgVar, jSONObject);
            }
        });
    }

    public static void n(final com.byazt.qn.qg qgVar, final com.byazt.vp.qg qgVar2, final int i) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.16
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, qgVar, qgVar2, i);
            }
        });
    }

    public static void n(final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar, final List<com.byazt.sg.s> list, final List<com.byazt.sg.s> list2) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.17
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, sVar, qgVar, list, list2);
            }
        });
    }

    public static void n(final com.byazt.ws.tj tjVar, final com.byazt.qn.qg qgVar, final String str) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.18
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, tjVar, qgVar, str);
            }
        });
    }

    public static void n(final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar, final com.byazt.ws.tj tjVar, final long j) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.19
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, sVar, qgVar, tjVar, j);
            }
        });
    }

    public static void n(final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar, final com.byazt.ws.tj tjVar) {
        final qg qgVarS = qg.s();
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.gp.s.20
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yh.n.n().n(qgVarS, sVar, qgVar, tjVar);
            }
        });
    }

    public static void n(com.byazt.qn.qg qgVar, String str) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("cache_cannot_use").n("cache_invalid_info", str);
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, (com.byazt.sg.s) null, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(com.byazt.qn.qg qgVar, com.byazt.sg.s sVar, String str) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("rit_cache_cannot_use").n("cache_invalid_info", str);
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map);
        qgVarQg.n("mediationrit_req_type", 2);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(com.byazt.qn.qg qgVar) {
        qg qgVarQg = qg.qg();
        qgVarQg.n("media_will_show");
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, (com.byazt.sg.s) null, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, com.byazt.mj.n nVar, int i, int i2, String str, long j) {
        n(sVar, qgVar, nVar, i, i2, str, j, (String) null);
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, com.byazt.mj.n nVar, int i, int i2, String str, long j, String str2) {
        qg qgVarQg = qg.qg();
        qgVarQg.setResult(i).qg(nVar != null ? nVar.s : 0).cp(nVar != null ? nVar.q : null).n("media_show_fail_listen").n("play_again", Integer.valueOf(i2));
        if (str != null) {
            qgVarQg.n("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            qgVarQg.n("callstack_message", str2);
        }
        HashMap map = new HashMap();
        boolean z = j >= 0;
        if (sVar != null && sVar.rg()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(d.s()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, int i, int i2, int i3, String str) {
        qg qgVarQg = qg.qg();
        qgVarQg.setResult(i2).n("media_show_after").n("play_again", Integer.valueOf(i3)).n(MediationConstant.KEY_REASON, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            qgVarQg.n("callstack_message", str);
        }
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, (com.byazt.ws.tj) null, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    public static void n(String str, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, com.byazt.ws.tj tjVar, com.byazt.mj.n nVar) {
        qg qgVarQg = qg.qg();
        qg qgVarCp = qgVarQg.qg(nVar != null ? nVar.n : 0).cp(nVar != null ? nVar.qg : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        qgVarCp.l(str).n("custom_adn_init_fail");
        HashMap map = new HashMap();
        n(qgVarQg, qgVar, tjVar, sVar, map);
        tj.n(com.byazt.qt.qg.getContext(), qgVarQg, map);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x011f  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:152:0x011f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static void n(com.byazt.gp.qg r15, com.byazt.qn.qg r16, com.byazt.ws.tj r17, com.byazt.sg.s r18, java.util.Map<java.lang.String, java.lang.Object> r19) {
        /*
            Method dump skipped, instruction units count: 1347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.gp.s.n(com.byazt.gp.qg, com.byazt.qn.qg, com.byazt.ws.tj, com.byazt.sg.s, java.util.Map):void");
    }
}

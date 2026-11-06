package com.byazt.yh;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.f;
import com.byazt.gp.qg;
import com.byazt.it.s;
import com.byazt.qa.q;
import com.byazt.rb.l;
import com.byazt.vy.d;
import com.byazt.vy.py;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.loader.ApiSpUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2171, 19})
public class n {
    public static volatile n n;

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, String str, boolean z, String str2, int i, Map<String, Object> map) {
        String strN;
        int i2;
        if (i > 0) {
            strN = com.byazt.mj.n.n(i);
        } else {
            strN = "";
            i = 0;
        }
        if (i != 0) {
            i2 = z ? 2 : 3;
        } else {
            i2 = !z ? 1 : 0;
        }
        qgVar.n("mediation_request").n("server_bidding_extra", str2).n("mediation_req_type", Integer.valueOf(i2)).n("ad_count", Integer.valueOf(qgVar2 != null ? qgVar2.m() : 0)).qg(i).cp(strN);
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        if (qgVar2 != null && qgVar2.s() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", q.n().s());
                jSONObject.put(ApiSpUtils.SP_INTERVAL, q.n().q());
                jSONObject.put("primerit_list", q.n().qg());
                map2.put("preload_info", jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (qgVar2 != null && qgVar2.um() == 3 && (com.byazt.gi.n.n().cp() || com.byazt.gi.n.n().d())) {
            map2.put("init_splash_request_duration", Long.valueOf(com.byazt.gi.n.n().rv()));
        }
        if (qgVar2 != null && qgVar2.f() != null && !qgVar2.f().isEmpty()) {
            map2.putAll(qgVar2.f());
        }
        map2.put("csj_plugin_version", s.q());
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, (com.byazt.sg.s) null, map2);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map2);
    }

    public void n(qg qgVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar2, com.byazt.ws.qg qgVar3, long j, String str, boolean z, int i, boolean z2, boolean z3) {
        qgVar.n("mediation_fill").n(j).n("server_bidding_extra", str).n("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).n("ad_count", Integer.valueOf(i)).qg(0).cp("");
        HashMap map = new HashMap();
        if (qgVar2 != null && qgVar2.um() == 3) {
            if (com.byazt.gi.n.n().cp()) {
                com.byazt.gi.n.n().n(com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).qg());
                map.put("init_splash_fill_duration", Long.valueOf(com.byazt.gi.n.n().tj()));
            } else if (com.byazt.gi.n.n().d()) {
                map.put("init_splash_fill_duration", Long.valueOf(com.byazt.gi.n.n().tj()));
            }
        }
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, sVar, map);
        map.put("timeout_req", Integer.valueOf(z2 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z3 ? 1 : 0));
        if (qgVar2 != null && qgVar2.f() != null && !qgVar2.f().isEmpty()) {
            map.putAll(qgVar2.f());
        }
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, com.byazt.sg.s sVar, long j, int i, int i2, int i3, String str, int i4, int i5, com.byazt.ws.qg qgVar3, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectRv;
        qgVar.n("mediation_request_end").n(j).n("ad_count", Integer.valueOf(i4)).n(MediationConstant.KEY_REASON, Integer.valueOf(i5)).qg(i3);
        HashMap map = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, sVar, map);
        map.put("requested_adn_count", Integer.valueOf(i));
        map.put("requested_level_count", Integer.valueOf(i2));
        if (jSONObject != null) {
            map.put("auto_detail", jSONObject);
        }
        if (jSONObject2 != null) {
            map.put("req_time", jSONObject2);
        }
        if (qgVar3 != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("layer_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(qgVar3.l())));
                jSONObject3.putOpt("req_interval", Long.valueOf(qgVar3.x()));
                jSONObject3.putOpt("total_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(qgVar3.w())));
                map.put("preload_req", jSONObject3);
            } catch (Throwable unused) {
            }
        }
        if (qgVar2 != null && (jSONObjectRv = qgVar2.rv()) != null) {
            map.put("behavior", jSONObjectRv);
        }
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, com.byazt.mj.n nVar, String str) {
        JSONObject jSONObjectRv;
        qgVar.n("total_load_fail").n("server_bidding_extra", str);
        if (nVar.n == 10003) {
            qgVar.qg(10010).cp("延长瀑布流总超时时长或者缩短层超时并添加兜底代码位");
            n(qgVar);
        } else if (nVar.n == 810085) {
            qgVar.qg(nVar.n).cp(nVar.qg);
            n(qgVar);
        } else if (nVar instanceof com.byazt.pu.s) {
            com.byazt.pu.s sVar = (com.byazt.pu.s) nVar;
            qgVar.qg(nVar.n).cp(nVar.qg);
            qgVar.n("block_pacing", sVar.n());
            qgVar.n("waterfall_show_rule_id", sVar.qg());
        } else if (nVar instanceof com.byazt.pu.qg) {
            com.byazt.pu.qg qgVar3 = (com.byazt.pu.qg) nVar;
            qgVar.qg(nVar.n).cp(nVar.qg);
            qgVar.n("block_show_count", qgVar3.n());
            qgVar.n("waterfall_show_rule_id", qgVar3.qg());
        } else if (nVar instanceof com.byazt.pu.n) {
            qgVar.qg(nVar.n).cp(nVar.qg);
            n(qgVar);
        } else {
            qgVar.qg(10086).cp("Ad load fail all loadsorts! ");
            n(qgVar);
        }
        HashMap map = new HashMap();
        if (qgVar2 != null && (jSONObjectRv = qgVar2.rv()) != null) {
            map.put("behavior", jSONObjectRv);
        }
        if (qgVar2 != null && qgVar2.f() != null && !qgVar2.f().isEmpty()) {
            map.putAll(qgVar2.f());
        }
        qgVar.n("ad_count", Integer.valueOf(qgVar2 != null ? qgVar2.m() : 0));
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, (com.byazt.sg.s) null, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, tj tjVar, com.byazt.qn.qg qgVar2, String str, boolean z, int i, int i2, int i3, int i4, com.byazt.mj.n nVar, long j, boolean z2, boolean z3, String str2, long j2) {
        int iQ;
        if ((nVar instanceof com.byazt.pu.s) || (nVar instanceof com.byazt.pu.qg) || (nVar instanceof com.byazt.pu.n)) {
            qgVar.qg(nVar.n).cp(nVar.qg);
        }
        qgVar.n("media_request").w(str).n(j2).n("ad_count", Integer.valueOf(qgVar2 != null ? qgVar2.m() : 0)).n("adn_count", Integer.valueOf(i2)).n("mediationrit_req_type", Integer.valueOf(i3)).n("mediationrit_req_type_src", Integer.valueOf(i4)).n("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).n("media_req_type", Integer.valueOf(i));
        HashMap map = new HashMap();
        map.put("timeout_req", Integer.valueOf(z2 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z3 ? 1 : 0));
        if (qgVar2 != null && qgVar2.nf() && !TextUtils.isEmpty(str2)) {
            map.put("origin_link_id", str2);
        }
        if (qgVar2 != null && qgVar2.fi() != null && tjVar != null && MediationConstant.ADN_PANGLE.equals(tjVar.k()) && tjVar.oa() == 5 && (iQ = qgVar2.fi().q()) == 1) {
            map.put("support_render_control", Integer.valueOf(iQ));
        }
        if (j != -1) {
            map.put(f.a, Long.valueOf(SystemClock.elapsedRealtime() - j));
        }
        com.byazt.gp.s.n(qgVar, qgVar2, tjVar, (com.byazt.sg.s) null, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.sg.s sVar, int i, String str, long j, com.byazt.qn.qg qgVar2, int i2, int i3, int i4, String str2, long j2, long j3) {
        qgVar.n("media_fill").n(j).qg(i).cp(str).n("adn_count", Integer.valueOf(i2)).n("adn_preload", Integer.valueOf((sVar == null || !sVar.oj()) ? 0 : 1)).n("ad_count", Integer.valueOf(i3));
        qgVar.n("fill_type", Integer.valueOf(i4));
        if (str2 != null) {
            qgVar.n("sub_adn_name", str2);
        }
        HashMap map = new HashMap();
        boolean z = j2 >= 0;
        if (sVar != null && sVar.rg()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(d.s()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        if (j3 != -1) {
            map.put(f.b, Long.valueOf(j3));
        }
        if (sVar != null && MediationConstant.ADN_PANGLE.equals(sVar.lq()) && sVar.ct() == 5 && sVar.hu() == 1) {
            map.put("if_to_express", Integer.valueOf(sVar.hu()));
        }
        if (com.byazt.qt.qg.n().lq() && sVar != null && (5 == sVar.ct() || 9 == sVar.ct())) {
            qgVar.n("ex_info", com.byazt.gp.q.n().n(sVar));
        }
        Long lN = n(sVar);
        if (lN != null) {
            qgVar.n("cid", String.valueOf(lN));
        }
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, sVar, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    private Long n(com.byazt.sg.s sVar) {
        Map<String, Object> mapDh;
        if (sVar == null || (mapDh = sVar.dh()) == null || !(mapDh.get("creative_id") instanceof Long)) {
            return null;
        }
        return (Long) mapDh.get("creative_id");
    }

    public void n(qg qgVar, com.byazt.mj.n nVar, com.byazt.qn.qg qgVar2, tj tjVar, int i, int i2, int i3, String str, long j, String str2, String str3, String str4, long j2) {
        if (nVar instanceof com.byazt.pu.s) {
            com.byazt.pu.s sVar = (com.byazt.pu.s) nVar;
            qgVar.qg(nVar.n).cp(nVar.qg);
            qgVar.n("block_pacing", sVar.n());
            qgVar.n("adn_rit_show_rule_id", sVar.qg());
        } else if (nVar instanceof com.byazt.pu.qg) {
            com.byazt.pu.qg qgVar3 = (com.byazt.pu.qg) nVar;
            qgVar.qg(nVar.n).cp(nVar.qg);
            qgVar.n("block_show_count", qgVar3.n());
            qgVar.n("adn_rit_show_rule_id", qgVar3.qg());
        } else if (nVar instanceof com.byazt.pu.n) {
            qgVar.qg(nVar.n);
            qgVar.cp(nVar.qg);
            qg(qgVar);
        } else {
            qgVar.qg(nVar != null ? nVar.s : -1).cp(nVar != null ? nVar.q : "unknown error");
            qg(qgVar);
        }
        qgVar.n("media_fill_fail").n(j).w(str).n("adn_count", Integer.valueOf(i)).n("adn_preload", 0).n("mediationrit_req_type", Integer.valueOf(i2)).n("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap map = new HashMap();
        Object objN = nVar.n("is_dex_adapter");
        if (objN != null) {
            map.put("is_dex_adapter", objN);
        }
        boolean z = j2 >= 0;
        if (tjVar != null && tjVar.oj()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(d.s()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        com.byazt.gp.s.n(qgVar, qgVar2, tjVar, (com.byazt.sg.s) null, map);
        if (!TextUtils.isEmpty(str2)) {
            qgVar.rv(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            qgVar.n("level_tag", str3);
        }
        if (str4 != null) {
            qgVar.n("sub_adn_name", str4);
        }
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, tj tjVar, com.byazt.qn.qg qgVar2, int i, int i2) {
        qgVar.n("adapter_request_fail").n(0L).w((String) null).qg(com.anythink.core.common.l.q.o).cp("adapter create fail !").n("mediationrit_req_type", Integer.valueOf(i)).n("mediationrit_req_type_src", Integer.valueOf(i2));
        HashMap map = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, tjVar, (com.byazt.sg.s) null, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, int i) {
        qgVar.n("get_config_error").qg(i);
        HashMap map = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, (com.byazt.sg.s) null, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar2, List<com.byazt.sg.s> list, List<com.byazt.sg.s> list2) {
        Iterator<com.byazt.sg.s> it;
        HashMap map;
        Iterator<com.byazt.sg.s> it2;
        qgVar.n("bidding_win_event");
        HashMap map2 = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, sVar, map2);
        JSONArray jSONArray = new JSONArray();
        if (!py.n(list)) {
            Iterator<com.byazt.sg.s> it3 = list.iterator();
            while (it3.hasNext()) {
                com.byazt.sg.s next = it3.next();
                if (next != null) {
                    it2 = it3;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        map = map2;
                        try {
                            jSONObject.putOpt("mediation_rit", next.el());
                            jSONObject.putOpt(MediationConstant.EXTRA_ADN_NAME, next.lq());
                            jSONObject.putOpt("load_sort", Integer.valueOf(next.la()));
                            jSONObject.putOpt("show_sort", Integer.valueOf(next.il()));
                            jSONObject.putOpt("exchange_rate", next.cx());
                            jSONObject.putOpt("rit_cpm", Double.valueOf(next.ta()));
                            jSONObject.putOpt("m_aid", next.fi());
                            jSONObject.putOpt("req_bidding_type", Integer.valueOf(next.bz()));
                            jSONObject.putOpt("win_state", 1);
                            jSONObject.putOpt("ad_extra", next.df());
                            jSONObject.putOpt("win_callback", next.ae());
                            jSONObject.putOpt("loss_callback", next.f());
                            if (next.dm()) {
                                jSONObject.putOpt("pricing_type", Integer.valueOf(next.j()));
                            }
                            jSONArray.put(jSONObject);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        map = map2;
                    }
                } else {
                    map = map2;
                    it2 = it3;
                }
                it3 = it2;
                map2 = map;
            }
        }
        HashMap map3 = map2;
        if (!py.n(list2)) {
            Iterator<com.byazt.sg.s> it4 = list2.iterator();
            while (it4.hasNext()) {
                com.byazt.sg.s next2 = it4.next();
                if (next2 != null) {
                    it = it4;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = jSONArray;
                        try {
                            jSONObject2.putOpt("mediation_rit", next2.el());
                            jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, next2.lq());
                            jSONObject2.putOpt("load_sort", Integer.valueOf(next2.la()));
                            jSONObject2.putOpt("show_sort", Integer.valueOf(next2.il()));
                            jSONObject2.putOpt("exchange_rate", next2.cx());
                            jSONObject2.putOpt("rit_cpm", Double.valueOf(next2.ta()));
                            jSONObject2.putOpt("m_aid", next2.fi());
                            jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next2.bz()));
                            jSONObject2.putOpt("win_state", 0);
                            jSONObject2.putOpt("ad_extra", next2.df());
                            jSONObject2.putOpt("win_callback", next2.ae());
                            jSONObject2.putOpt("loss_callback", next2.f());
                            if (next2.dm()) {
                                jSONObject2.putOpt("pricing_type", Integer.valueOf(next2.j()));
                            }
                            jSONArray = jSONArray2;
                            jSONArray.put(jSONObject2);
                        } catch (Exception unused3) {
                            jSONArray = jSONArray2;
                        }
                    } catch (Exception unused4) {
                    }
                } else {
                    it = it4;
                }
                it4 = it;
            }
        }
        map3.put("others", jSONArray);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map3);
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, JSONObject jSONObject) {
        qgVar.n("start_bidding_request").n(2).n("ad_count", Integer.valueOf(qgVar2 != null ? qgVar2.m() : 0));
        HashMap map = new HashMap();
        if (jSONObject != null) {
            map.put("exchange_time", jSONObject);
        }
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, (com.byazt.sg.s) null, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, com.byazt.vp.qg qgVar3, int i) {
        if (qgVar3 == null) {
            return;
        }
        qgVar.n("return_bidding_result").n(qgVar3.x).setResult(qgVar3.w).qg(qgVar3.fs == null ? 0 : qgVar3.fs.n).cp(qgVar3.fs == null ? "" : qgVar3.fs.qg).n(2).n("fill_type", Integer.valueOf(i)).n("server_bidding_extra", qgVar3.q).n("ad_count", Integer.valueOf(qgVar3.rv));
        HashMap map = new HashMap();
        com.byazt.cby.q.n(qgVar3.tj, qgVar3.n, map);
        if (qgVar3.cp != null) {
            map.put("exchange_time", qgVar3.cp);
        }
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, (com.byazt.sg.s) null, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, tj tjVar, com.byazt.qn.qg qgVar2, String str) {
        qgVar.n("get_bidding_adm_to_adn").w(str);
        HashMap map = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, tjVar, (com.byazt.sg.s) null, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar2, tj tjVar, long j) {
        qgVar.n("bidding_adm_load").n(j);
        HashMap map = new HashMap();
        if (com.byazt.qt.qg.n().lq() && sVar != null && 5 == sVar.ct()) {
            qgVar.n("ex_info", com.byazt.gp.q.n().n(sVar));
        }
        com.byazt.gp.s.n(qgVar, qgVar2, tjVar, sVar, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.sg.s sVar, com.byazt.qn.qg qgVar2, tj tjVar) {
        qgVar.n("bidding_adm_cache");
        HashMap map = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, tjVar, sVar, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, com.byazt.sg.s sVar, tj tjVar) {
        qgVar.n("media_cache_success");
        HashMap map = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, tjVar, sVar, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(qg qgVar, com.byazt.qn.qg qgVar2, com.byazt.sg.s sVar, long j) {
        qgVar.n("mediation_video_cached").n(j);
        HashMap map = new HashMap();
        com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, sVar, map);
        com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
    }

    public void n(final qg qgVar, final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar2, final int i, final String str, final long j, final String str2, final boolean z, final int i2) {
        l.q(new Runnable() { // from class: com.byazt.yh.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.sg.s sVar2;
                com.byazt.sg.s sVar3 = sVar;
                qgVar.n("media_show_listen").n("adn_preload", Integer.valueOf((sVar3 == null || !sVar3.oj()) ? 0 : 1)).n("play_again", Integer.valueOf(i)).n("is_repeat", Integer.valueOf(z ? 1 : 0));
                String str3 = str;
                if (str3 != null) {
                    qgVar.n("sub_adn_name", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    qgVar.n("callstack_message", str2);
                }
                HashMap map = new HashMap();
                map.put("enable_label_return", Integer.valueOf(com.byazt.qt.qg.n().dh() ? 1 : 0));
                map.put("if_labelapi_call", Integer.valueOf(com.byazt.qt.n.d().n() ? 1 : 0));
                map.put("is_fill_quick_ad", Integer.valueOf(i2));
                com.byazt.mv.s.n(sVar, qgVar2, map);
                boolean z2 = j >= 0;
                com.byazt.sg.s sVar4 = sVar;
                if (sVar4 != null && sVar4.rg()) {
                    map.put("custom_adn_sample_ratio", Double.valueOf(d.s()));
                    map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
                    if (z2) {
                        map.put("custom_adn_rec_time", Long.valueOf(j));
                    }
                }
                com.byazt.sg.s sVar5 = sVar;
                if (sVar5 != null && !TextUtils.isEmpty(sVar5.oo())) {
                    com.byazt.ec.n.n(map, sVar.oo());
                }
                com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, sVar, map);
                com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
                if (com.byazt.qt.qg.n().oa() && (sVar2 = sVar) != null && MediationConstant.ADN_PANGLE.equals(sVar2.lq())) {
                    com.byazt.gp.tj.l();
                }
            }
        });
    }

    public void n(final qg qgVar, final com.byazt.sg.s sVar, final com.byazt.qn.qg qgVar2, final int i, final String str, final long j, final String str2, final boolean z) {
        l.q(new Runnable() { // from class: com.byazt.yh.n.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.sg.s sVar2 = sVar;
                qgVar.n("media_click_listen").n("adn_preload", Integer.valueOf((sVar2 == null || !sVar2.oj()) ? 0 : 1)).n("play_again", Integer.valueOf(i)).n("is_repeat", Integer.valueOf(z ? 1 : 0));
                String str3 = str;
                if (str3 != null) {
                    qgVar.n("sub_adn_name", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    qgVar.n("callstack_message", str2);
                }
                HashMap map = new HashMap();
                boolean z2 = j >= 0;
                com.byazt.sg.s sVar3 = sVar;
                if (sVar3 != null && sVar3.rg()) {
                    map.put("custom_adn_sample_ratio", Double.valueOf(d.s()));
                    map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
                    if (z2) {
                        map.put("custom_adn_rec_time", Long.valueOf(j));
                    }
                }
                com.byazt.sg.s sVar4 = sVar;
                if (sVar4 != null && !TextUtils.isEmpty(sVar4.oo())) {
                    com.byazt.ec.n.n(map, sVar.oo());
                }
                com.byazt.gp.s.n(qgVar, qgVar2, (tj) null, sVar, map);
                com.byazt.gp.tj.n(com.byazt.qt.qg.getContext(), qgVar, map);
            }
        });
    }

    private static void n(qg qgVar) {
        qgVar.n("block_pacing", "-1");
        qgVar.n("waterfall_show_rule_id", "-1");
        qgVar.n("block_show_count", "-1");
    }

    private static void qg(qg qgVar) {
        qgVar.n("block_pacing", "-1");
        qgVar.n("rit_adn_show_rule_id", "-1");
        qgVar.n("block_show_count", "-1");
    }
}

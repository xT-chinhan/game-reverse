package com.byazt.hi;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.vb;
import com.byazt.gct.y;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 21})
public class x {
    public static volatile boolean n = false;

    public static void n(Context context, vb vbVar, pk pkVar, boolean z, long j) {
        if (context == null || pkVar == null || vbVar == null || !com.byazt.nf.rv.qg().ei()) {
            return;
        }
        boolean z2 = vbVar.q() == 1;
        boolean z3 = vbVar.fs() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", vbVar.n());
            jSONObject.put("server_load_type", vbVar.qg());
            jSONObject.put("tmax_type", vbVar.j());
            if (z) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", vbVar.s());
            jSONObject.put("splash_creative_type", vbVar.q());
            if (vbVar.wm() > 0) {
                if (vbVar.wm() == 22) {
                    jSONObject.put("check_cloud_error_code", vbVar.ur());
                }
                jSONObject.put("splash_get_cache_error_code", vbVar.wm());
            }
            if (z2) {
                if (z3) {
                    jSONObject.put("cache_image_duration", vbVar.x());
                } else {
                    jSONObject.put("download_image_duration", vbVar.w());
                    jSONObject.put("download_client_start_time", vbVar.cy());
                    jSONObject.put("download_net_time", vbVar.hd());
                    jSONObject.put("download_client_end_time", vbVar.cd());
                    jSONObject.put("img_conttype", vbVar.t());
                    jSONObject.put("img_net_bframe_time", vbVar.bb());
                    jSONObject.put("img_net_aframe_time", vbVar.ln());
                }
                if (!z) {
                    jSONObject.put("client_start_time", vbVar.d());
                    jSONObject.put("network_time", vbVar.oa());
                    jSONObject.put("sever_time", vbVar.sz());
                    jSONObject.put("client_end_time", vbVar.k());
                }
                jSONObject.put("load_duration", vbVar.l());
                jSONObject.put("image_resolution", vbVar.tj());
                jSONObject.put("image_cachetype", vbVar.fs());
                jSONObject.put("image_size", vbVar.rv());
            }
            if (vbVar.m() > 0) {
                jSONObject.put("real_user_duration", j - vbVar.m());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", vbVar.hu());
            jSONObject.put("on_call_back_time", vbVar.h());
            jSONObject.put("load_suc_time", vbVar.lh());
            jSONObject.put("is_boost", com.byazt.gv.n.l());
        } catch (Exception unused) {
        }
        com.byazt.hm.n.n(pkVar, "splash_ad", "splash_ad_loadtime", j - vbVar.a(), jSONObject);
    }

    public static void n(vb vbVar) {
        if (vbVar == null) {
            return;
        }
        vbVar.n(System.currentTimeMillis() - vbVar.a());
    }

    public static void n(vb vbVar, vb vbVar2) {
        if (vbVar == null || vbVar2 == null) {
            return;
        }
        vbVar.d(System.currentTimeMillis());
        vbVar2.d(System.currentTimeMillis());
        if (com.byazt.vyf.l.s.get()) {
            vbVar.s(0);
            vbVar2.s(0);
            com.byazt.vyf.l.s.set(false);
        } else {
            vbVar.s(1);
            vbVar2.s(1);
        }
    }

    public static void n(vb vbVar, long j) {
        if (vbVar == null) {
            return;
        }
        vbVar.qg(j);
    }

    public static void qg(vb vbVar, long j) {
        if (vbVar == null) {
            return;
        }
        vbVar.s(j);
    }

    public static void n(vb vbVar, com.byazt.se.fs fsVar) {
        if (vbVar == null || fsVar == null) {
            return;
        }
        if (fsVar.l()) {
            vbVar.q(2);
        } else {
            vbVar.q(1);
        }
    }

    public static void n(vb vbVar, boolean z) {
        if (vbVar == null) {
            return;
        }
        if (z) {
            vbVar.l(1);
        } else {
            vbVar.l(2);
        }
    }

    public static void n(vb vbVar, com.byazt.qdx.qg qgVar, Map<String, String> map) {
        if (qgVar == null || vbVar == null) {
            return;
        }
        int iQg = qgVar.qg();
        if (vbVar.rv() == 0.0d) {
            vbVar.n(iQg / 1024.0f);
        }
        Bitmap bitmapN = qgVar.n();
        if (bitmapN != null && TextUtils.isEmpty(vbVar.tj())) {
            vbVar.n(bitmapN.getWidth() + "X" + bitmapN.getHeight());
        }
        if (map == null || map.size() <= 0 || vbVar.cp() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (Exception unused) {
                }
            }
        }
        vbVar.n(jSONObject);
    }

    public static void n(vb vbVar, com.byazt.se.w wVar) {
        if (vbVar == null || wVar == null) {
            return;
        }
        long jW = wVar.w();
        long jFs = wVar.fs();
        long jX = wVar.x();
        long jRv = wVar.rv();
        vbVar.q(jW);
        vbVar.l(jX);
        vbVar.w(jFs);
        vbVar.x(jRv);
    }

    public static void n(pk pkVar, vb vbVar, com.byazt.se.fs fsVar) {
        if (pkVar == null || vbVar == null || fsVar == null || fsVar.l() || vbVar.fs() == 1 || !com.byazt.nf.rv.qg().ei()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", vbVar.rv());
            jSONObject.put("image_resolution", vbVar.tj());
            jSONObject.put("download_client_start_time", vbVar.cy());
            jSONObject.put("download_net_time", vbVar.hd());
            jSONObject.put("download_client_end_time", vbVar.cd());
        } catch (Exception unused) {
        }
        com.byazt.hm.n.n(pkVar, "splash_ad", "download_image_duration", System.currentTimeMillis() - vbVar.um(), jSONObject);
    }

    public static void s(vb vbVar, long j) {
        if (vbVar == null) {
            return;
        }
        vbVar.cp(j);
    }

    public static void n(vb vbVar, com.byazt.se.fs fsVar, long j) {
        if (vbVar == null || fsVar == null) {
            return;
        }
        long jX = fsVar.x();
        vbVar.tj(j - jX);
        vbVar.a(fsVar.fs() - jX);
    }

    public static void n(boolean z, pk pkVar, com.byazt.zq.qg qgVar, final com.byazt.se.x xVar) {
        if (qgVar == null || xVar == null) {
            return;
        }
        n(pkVar, "outer_call_no_rsp", qgVar, z, new com.byazt.rs.n() { // from class: com.byazt.hi.x.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                int iX;
                int iQ;
                JSONObject jSONObject2 = new JSONObject();
                com.byazt.se.x xVar2 = xVar;
                if (xVar2 != null) {
                    iX = xVar2.x();
                    iQ = xVar.q();
                } else {
                    iX = 1;
                    iQ = -1;
                }
                try {
                    jSONObject2.put("if_have_cache", iX);
                    jSONObject2.put("if_have_rt_ads", iQ);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void n(com.byazt.zq.qg qgVar, final long j) {
        if (qgVar == null) {
            return;
        }
        com.byazt.eji.s.n().n("outer_call", qgVar.q(), com.byazt.vgx.w.x(), 3, new com.byazt.rs.n() { // from class: com.byazt.hi.x.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("publisher_timeout_control", j);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void n(vb vbVar, com.byazt.se.fs fsVar, long j, pk pkVar) {
        if (fsVar == null || vbVar == null || pkVar == null) {
            return;
        }
        if (!fsVar.l()) {
            fs.n(j, false, true, pkVar, 0L, "loadSuccess");
            if (!fsVar.w()) {
                n(vbVar, SystemClock.elapsedRealtime() - j);
                com.byazt.hm.n.n(pkVar, "splash_ad", SystemClock.elapsedRealtime() - j);
            } else {
                qg(vbVar, SystemClock.elapsedRealtime() - j);
            }
        }
        n(vbVar, fsVar.w());
        n(vbVar, fsVar.q(), fsVar.rv());
        n(vbVar, fsVar, System.currentTimeMillis());
        n(vbVar, fsVar.oa());
    }

    public static void n(vb vbVar, String str) {
        if (vbVar == null) {
            return;
        }
        vbVar.qg(str);
    }

    public static void n(boolean z, pk pkVar, com.byazt.zq.qg qgVar, final boolean z2, final boolean z3) {
        if (pkVar == null || qgVar == null) {
            return;
        }
        n(pkVar, "outer_call_send", qgVar, z, new com.byazt.rs.n() { // from class: com.byazt.hi.x.3
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (!z3) {
                        jSONObject2.put("image_CacheType", z2 ? 1 : 2);
                    }
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    private static void n(pk pkVar, String str, com.byazt.zq.qg qgVar, boolean z, com.byazt.rs.n nVar) {
        String strA;
        String str2;
        String str3;
        int i = z ? 4 : 3;
        String strQ = qgVar.q();
        if (pkVar != null) {
            String strQ2 = pkVar.q();
            String strF_ = pkVar.F_();
            strA = com.byazt.vgx.w.a(pkVar);
            str2 = strQ2;
            str3 = strF_;
        } else {
            strA = null;
            str2 = null;
            str3 = null;
        }
        com.byazt.eji.s.n().n(str, strQ, str2, TextUtils.isEmpty(strA) ? com.byazt.vgx.w.x() : strA, i, null, str3, null, null, 0, nVar);
    }

    public static void n(boolean z, pk pkVar, com.byazt.zq.qg qgVar) {
        if (pkVar == null || qgVar == null) {
            return;
        }
        n(pkVar, "load_timeout", qgVar, z, (com.byazt.rs.n) null);
    }

    public static void n(pk pkVar, com.byazt.se.q qVar) {
        if (qVar == null || pkVar == null || !com.byazt.nf.rv.qg().ei()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", qVar.n());
            jSONObject.put("render_sequence", qVar.qg());
            jSONObject.put("real_render_sequence", qVar.s());
        } catch (Exception unused) {
        }
        com.byazt.hm.n.qg(pkVar, "splash_ad", "splash_render_duration", qVar.w(), jSONObject);
    }

    public static void qg(pk pkVar, com.byazt.se.q qVar) {
        if (pkVar == null || qVar == null || !com.byazt.nf.rv.qg().ei()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", qVar.q());
            jSONObject.put("load_resource_duration", qVar.l());
            jSONObject.put("render_duration", qVar.w());
            jSONObject.put("ren_seq", qVar.qg());
            jSONObject.put("real_ren_seq", qVar.s());
            jSONObject.put("final_t", qVar.fs() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", qVar.rv());
            jSONObject.put("meta_load_Optimization", pkVar.rg());
            jSONObject.put("serial_render", qVar.tj());
        } catch (Exception unused) {
        }
        com.byazt.hm.n.s(pkVar, "splash_ad", "splash_total_duration", qVar.x(), jSONObject);
    }

    public static void n(pk pkVar, com.byazt.se.q qVar, com.byazt.se.rv rvVar) {
        if (pkVar == null || rvVar == null) {
            return;
        }
        if (nf.n(pkVar) == 1) {
            com.byazt.eo.n.n("Splash_FullLink", "自渲染 ");
            qVar.s(99);
        } else if (!rvVar.qg()) {
            int iS = nf.s(pkVar);
            com.byazt.eo.n.n("Splash_FullLink", "模版渲染 ".concat(String.valueOf(iS)));
            qVar.s(iS);
        } else {
            com.byazt.eo.n.n("Splash_FullLink", "模版兜底 ");
            qVar.s(99);
        }
    }

    public static void q(vb vbVar, long j) {
        if (vbVar != null) {
            vbVar.cy(System.currentTimeMillis() - j);
        }
    }

    public static void n(vb vbVar, vb vbVar2, y yVar, int i, int i2) {
        if (vbVar == null || vbVar2 == null) {
            return;
        }
        vbVar.n(i);
        vbVar.qg(i2);
        vbVar.k(yVar.rv);
        vbVar2.n(i);
        vbVar2.qg(i2);
        vbVar2.k(yVar.rv);
    }

    public static void n(vb vbVar, int i) {
        if (vbVar == null || vbVar.j() >= i) {
            return;
        }
        vbVar.x(i);
    }

    public static void n(int i, pk pkVar, String str, int i2) {
        if (i == 2) {
            if (n) {
                return;
            } else {
                n = true;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", i);
            if (i == 1) {
                jSONObject.put("show_cnt", i2);
            }
            com.byazt.hm.n.q(pkVar, str, jSONObject);
        } catch (JSONException unused) {
        }
    }
}

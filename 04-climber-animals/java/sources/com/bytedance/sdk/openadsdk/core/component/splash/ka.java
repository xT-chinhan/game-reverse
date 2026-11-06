package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.e.a;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qk;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f2421ms = false;

    public static void ms(Context context, qk qkVar, lm lmVar, boolean z, long j) {
        if (context == null || lmVar == null || qkVar == null || !re.xr().vm()) {
            return;
        }
        boolean z2 = qkVar.d() == 1;
        boolean z3 = qkVar.x() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", qkVar.ms());
            jSONObject.put("server_load_type", qkVar.xr());
            jSONObject.put("tmax_type", qkVar.pc());
            if (z) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", qkVar.ah());
            jSONObject.put("splash_creative_type", qkVar.d());
            if (qkVar.re() > 0) {
                if (qkVar.re() == 22) {
                    jSONObject.put("check_cloud_error_code", qkVar.le());
                }
                jSONObject.put("splash_get_cache_error_code", qkVar.re());
            }
            if (z2) {
                if (z3) {
                    jSONObject.put("cache_image_duration", qkVar.ab());
                } else {
                    jSONObject.put("download_image_duration", qkVar.c());
                    jSONObject.put("download_client_start_time", qkVar.ao());
                    jSONObject.put("download_net_time", qkVar.h());
                    jSONObject.put("download_client_end_time", qkVar.qv());
                    jSONObject.put("img_conttype", qkVar.op());
                    jSONObject.put("img_net_bframe_time", qkVar.cv());
                    jSONObject.put("img_net_aframe_time", qkVar.g());
                }
                if (!z) {
                    jSONObject.put("client_start_time", qkVar.sl());
                    jSONObject.put("network_time", qkVar.zb());
                    jSONObject.put("sever_time", qkVar.u());
                    jSONObject.put("client_end_time", qkVar.ub());
                }
                jSONObject.put("load_duration", qkVar.ka());
                jSONObject.put("image_resolution", qkVar.ch());
                jSONObject.put("image_cachetype", qkVar.x());
                jSONObject.put("image_size", qkVar.ny());
            }
            if (qkVar.i() > 0) {
                jSONObject.put("real_user_duration", j - qkVar.i());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", qkVar.w());
            jSONObject.put("on_call_back_time", qkVar.yu());
            jSONObject.put("load_suc_time", qkVar.of());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.d.ms.d());
        } catch (Exception e) {
            sl.ms(e);
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, "splash_ad", "splash_ad_loadtime", j - qkVar.t(), jSONObject);
    }

    public static void ms(qk qkVar) {
        if (qkVar == null) {
            return;
        }
        qkVar.ms(System.currentTimeMillis() - qkVar.t());
    }

    public static void ms(qk qkVar, qk qkVar2) {
        if (qkVar == null || qkVar2 == null) {
            return;
        }
        qkVar.sl(System.currentTimeMillis());
        qkVar2.sl(System.currentTimeMillis());
        if (nw.ah.get()) {
            qkVar.ah(0);
            qkVar2.ah(0);
            nw.ah.set(false);
        } else {
            qkVar.ah(1);
            qkVar2.ah(1);
        }
    }

    public static void ms(qk qkVar, long j) {
        if (qkVar == null) {
            return;
        }
        qkVar.xr(j);
    }

    public static void xr(qk qkVar, long j) {
        if (qkVar == null) {
            return;
        }
        qkVar.ah(j);
    }

    public static void ms(qk qkVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar) {
        if (qkVar == null || xVar == null) {
            return;
        }
        if (xVar.ka()) {
            qkVar.d(2);
        } else {
            qkVar.d(1);
        }
    }

    public static void ms(qk qkVar, boolean z) {
        if (qkVar == null) {
            return;
        }
        if (z) {
            qkVar.ka(1);
        } else {
            qkVar.ka(2);
        }
    }

    public static void ms(qk qkVar, com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar, Map<String, String> map) {
        if (xrVar == null || qkVar == null) {
            return;
        }
        int iXr = xrVar.xr();
        if (qkVar.ny() == 0.0d) {
            qkVar.ms(iXr / 1024.0f);
        }
        Bitmap bitmapMs = xrVar.ms();
        if (bitmapMs != null && TextUtils.isEmpty(qkVar.ch())) {
            qkVar.ms(bitmapMs.getWidth() + "X" + bitmapMs.getHeight());
        }
        if (map == null || map.size() <= 0 || qkVar.hi() != null) {
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
        qkVar.ms(jSONObject);
    }

    public static void ms(qk qkVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
        if (qkVar == null || cVar == null) {
            return;
        }
        long jC = cVar.c();
        long jX = cVar.x();
        long jAb = cVar.ab();
        long jNy = cVar.ny();
        qkVar.d(jC);
        qkVar.ka(jAb);
        qkVar.c(jX);
        qkVar.ab(jNy);
    }

    public static void ms(lm lmVar, qk qkVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar) {
        if (lmVar == null || qkVar == null || xVar == null || xVar.ka() || qkVar.x() == 1 || !re.xr().vm()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", qkVar.ny());
            jSONObject.put("image_resolution", qkVar.ch());
            jSONObject.put("download_client_start_time", qkVar.ao());
            jSONObject.put("download_net_time", qkVar.h());
            jSONObject.put("download_client_end_time", qkVar.qv());
        } catch (Exception e) {
            sl.ms(e);
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, "splash_ad", "download_image_duration", System.currentTimeMillis() - qkVar.y(), jSONObject);
    }

    public static void ah(qk qkVar, long j) {
        if (qkVar == null) {
            return;
        }
        qkVar.hi(j);
    }

    public static void ms(qk qkVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, long j) {
        if (qkVar == null || xVar == null) {
            return;
        }
        long jAb = xVar.ab();
        qkVar.ch(j - jAb);
        qkVar.t(xVar.x() - jAb);
    }

    public static void ms(boolean z, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
        if (xrVar == null || abVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = ms(xrVar, z ? 4 : 3, lmVar);
        if (xrVarMs == null) {
            return;
        }
        u.ms().ah(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ka.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                int iAb;
                int iD;
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar2 = abVar;
                if (abVar2 != null) {
                    iAb = abVar2.ab();
                    iD = abVar.d();
                } else {
                    iAb = 1;
                    iD = -1;
                }
                try {
                    jSONObject.put("if_have_cache", iAb);
                    jSONObject.put("if_have_rt_ads", iD);
                } catch (Throwable unused) {
                }
                return xrVarMs.xr(jSONObject.toString());
            }
        });
    }

    private static com.bytedance.sdk.openadsdk.core.t.ms.xr ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, int i, lm lmVar) {
        String strDf;
        String strNy;
        String strLx;
        if (lmVar != null) {
            strDf = lmVar.df();
            strLx = lmVar.lx();
            strNy = f.zb(lmVar);
        } else {
            strDf = null;
            strNy = null;
            strLx = null;
        }
        if (TextUtils.isEmpty(strNy)) {
            strNy = f.ny();
        }
        com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarAh = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().c(strNy).ms(i).ah(xrVar.d());
        if (strDf != null) {
            xrVarAh.d(strDf);
        }
        if (strLx != null) {
            xrVarAh.x(strLx);
        }
        return xrVarAh;
    }

    public static void ms(final com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final long j) {
        if (xrVar == null) {
            return;
        }
        u.ms().ms(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ka.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("publisher_timeout_control", j);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(3).ah(xrVar.d()).c(f.ny()).xr(jSONObject.toString());
            }
        });
    }

    public static void ms(qk qkVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, long j, lm lmVar) {
        if (xVar == null || qkVar == null || lmVar == null) {
            return;
        }
        if (!xVar.ka()) {
            c.ms(j, false, true, lmVar, 0L, "loadSuccess");
            if (!xVar.c()) {
                ms(qkVar, SystemClock.elapsedRealtime() - j);
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, "splash_ad", SystemClock.elapsedRealtime() - j);
            } else {
                xr(qkVar, SystemClock.elapsedRealtime() - j);
            }
        }
        ms(qkVar, xVar.c());
        ms(qkVar, xVar.d(), xVar.ny());
        ms(qkVar, xVar, System.currentTimeMillis());
        ms(qkVar, xVar.zb());
    }

    public static void ms(qk qkVar, String str) {
        if (qkVar == null) {
            return;
        }
        qkVar.xr(str);
    }

    public static void ms(boolean z, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, final boolean z2, final boolean z3) {
        if (lmVar == null || xrVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = ms(xrVar, z ? 4 : 3, lmVar);
        if (xrVarMs == null) {
            return;
        }
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ka.3
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!z3) {
                        jSONObject.put("image_CacheType", z2 ? 1 : 2);
                    }
                } catch (Throwable unused) {
                }
                return xrVarMs.xr(jSONObject.toString());
            }
        });
    }

    public static void ms(boolean z, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (lmVar == null || xrVar == null) {
            return;
        }
        final com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = ms(xrVar, z ? 4 : 3, lmVar);
        if (xrVarMs == null) {
            return;
        }
        u.ms().d(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.ka.4
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return xrVarMs;
            }
        });
    }

    public static void ms(lm lmVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.d dVar) {
        if (dVar == null || lmVar == null || !re.xr().vm()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", dVar.ms());
            jSONObject.put("render_sequence", dVar.xr());
            jSONObject.put("real_render_sequence", dVar.ah());
        } catch (Exception e) {
            sl.ms(e);
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(lmVar, "splash_ad", "splash_render_duration", dVar.c(), jSONObject);
    }

    public static void xr(lm lmVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.d dVar) {
        if (lmVar == null || dVar == null || !re.xr().vm()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", dVar.d());
            jSONObject.put("load_resource_duration", dVar.ka());
            jSONObject.put("render_duration", dVar.c());
            jSONObject.put("ren_seq", dVar.xr());
            jSONObject.put("real_ren_seq", dVar.ah());
            jSONObject.put("final_t", dVar.x() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", dVar.ny());
            jSONObject.put("meta_load_Optimization", lmVar.o());
            jSONObject.put("serial_render", dVar.ch());
        } catch (Exception e) {
            sl.ms(e);
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ah(lmVar, "splash_ad", "splash_total_duration", dVar.ab(), jSONObject);
    }

    public static void ms(lm lmVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.d dVar, ny nyVar) {
        if (lmVar == null || nyVar == null) {
            return;
        }
        if (lmVar.fm() == 1) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "自渲染 ");
            dVar.ah(99);
        } else if (!nyVar.xr()) {
            int iDu = lmVar.du();
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "模版渲染 ".concat(String.valueOf(iDu)));
            dVar.ah(iDu);
        } else {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "模版兜底 ");
            dVar.ah(99);
        }
    }

    public static void d(qk qkVar, long j) {
        if (qkVar != null) {
            qkVar.ao(System.currentTimeMillis() - j);
        }
    }

    public static void ms(qk qkVar, qk qkVar2, e eVar, int i, int i2) {
        if (qkVar == null || qkVar2 == null) {
            return;
        }
        qkVar.ms(i);
        qkVar.xr(i2);
        qkVar.ub(eVar.x);
        qkVar2.ms(i);
        qkVar2.xr(i2);
        qkVar2.ub(eVar.x);
    }

    public static void ms(qk qkVar, int i) {
        if (qkVar == null || qkVar.pc() >= i) {
            return;
        }
        qkVar.ab(i);
    }

    public static void ms(int i, lm lmVar, String str, int i2) {
        if (i == 2) {
            if (f2421ms) {
                return;
            } else {
                f2421ms = true;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a.C0080a.b, i);
            if (i == 1) {
                jSONObject.put("show_cnt", i2);
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.ah(lmVar, str, jSONObject);
        } catch (JSONException unused) {
        }
    }
}

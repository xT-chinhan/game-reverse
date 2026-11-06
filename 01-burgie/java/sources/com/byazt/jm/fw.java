package com.byazt.jm;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.hg.i;
import com.byazt.hg.ie;
import com.byazt.hg.jw;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.lb;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 62})
public class fw {
    public static volatile boolean pr = false;

    public static void pr(Context context, jw jwVar, of ofVar, boolean z, long j) {
        if (context == null || ofVar == null || jwVar == null || !a.hw().na()) {
            return;
        }
        boolean z2 = jwVar.x() == 1;
        boolean z3 = jwVar.zo() == 1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("splash_load_type", jwVar.pr());
            jSONObject.put("server_load_type", jwVar.hw());
            jSONObject.put("tmax_type", jwVar.n());
            if (z) {
                jSONObject.put("splash_final_type", "cache_ad");
            } else {
                jSONObject.put("splash_final_type", "real_time_ad");
            }
            jSONObject.put("active_type", jwVar.hn());
            jSONObject.put("splash_creative_type", jwVar.x());
            if (jwVar.fo() > 0) {
                if (jwVar.fo() == 22) {
                    jSONObject.put("check_cloud_error_code", jwVar.ve());
                }
                jSONObject.put("splash_get_cache_error_code", jwVar.fo());
            }
            if (z2) {
                if (z3) {
                    jSONObject.put("cache_image_duration", jwVar.fw());
                } else {
                    jSONObject.put("download_image_duration", jwVar.uc());
                    jSONObject.put("download_client_start_time", jwVar.nt());
                    jSONObject.put("download_net_time", jwVar.yb());
                    jSONObject.put("download_client_end_time", jwVar.lb());
                    jSONObject.put("img_conttype", jwVar.iu());
                    jSONObject.put("img_net_bframe_time", jwVar.gz());
                    jSONObject.put("img_net_aframe_time", jwVar.nl());
                }
                if (!z) {
                    jSONObject.put("client_start_time", jwVar.k());
                    jSONObject.put("network_time", jwVar.m());
                    jSONObject.put("sever_time", jwVar.g());
                    jSONObject.put("client_end_time", jwVar.ho());
                }
                jSONObject.put("load_duration", jwVar.c());
                jSONObject.put("image_resolution", jwVar.vk());
                jSONObject.put("image_cachetype", jwVar.zo());
                jSONObject.put("image_size", jwVar.aj());
            }
            if (jwVar.rc() > 0) {
                jSONObject.put("real_user_duration", j - jwVar.rc());
            }
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("switch_thread_time", jwVar.z());
            jSONObject.put("on_call_back_time", jwVar.b());
            jSONObject.put("load_suc_time", jwVar.y());
            jSONObject.put("is_boost", com.byazt.iq.pr.c());
        } catch (Exception e) {
        }
        com.byazt.pj.pr.pr(ofVar, "splash_ad", "splash_ad_loadtime", j - jwVar.a(), jSONObject);
    }

    public static void pr(jw jwVar) {
        if (jwVar == null) {
            return;
        }
        jwVar.pr(System.currentTimeMillis() - jwVar.a());
    }

    public static void pr(jw jwVar, jw jwVar2) {
        if (jwVar == null || jwVar2 == null) {
            return;
        }
        jwVar.k(System.currentTimeMillis());
        jwVar2.k(System.currentTimeMillis());
        if (lb.hn.get()) {
            jwVar.hn(0);
            jwVar2.hn(0);
            lb.hn.set(false);
        } else {
            jwVar.hn(1);
            jwVar2.hn(1);
        }
    }

    public static void pr(jw jwVar, long j) {
        if (jwVar == null) {
            return;
        }
        jwVar.hw(j);
    }

    public static void hw(jw jwVar, long j) {
        if (jwVar == null) {
            return;
        }
        jwVar.hn(j);
    }

    public static void pr(jw jwVar, com.byazt.zn.zo zoVar) {
        if (jwVar == null || zoVar == null) {
            return;
        }
        if (zoVar.c()) {
            jwVar.x(2);
        } else {
            jwVar.x(1);
        }
    }

    public static void pr(jw jwVar, boolean z) {
        if (jwVar == null) {
            return;
        }
        if (z) {
            jwVar.c(1);
        } else {
            jwVar.c(2);
        }
    }

    public static void pr(jw jwVar, com.byazt.bd.hw hwVar, Map<String, String> map) {
        if (hwVar == null || jwVar == null) {
            return;
        }
        int iHw = hwVar.hw();
        if (jwVar.aj() == 0.0d) {
            jwVar.pr(iHw / 1024.0f);
        }
        Bitmap bitmapPr = hwVar.pr();
        if (bitmapPr != null && TextUtils.isEmpty(jwVar.vk())) {
            jwVar.pr(bitmapPr.getWidth() + "X" + bitmapPr.getHeight());
        }
        if (map != null && map.size() > 0 && jwVar.w() == null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONObject.put(str, map.get(str));
                    } catch (Exception e) {
                    }
                }
            }
            jwVar.pr(jSONObject);
        }
    }

    public static void pr(jw jwVar, com.byazt.zn.uc ucVar) {
        if (jwVar == null || ucVar == null) {
            return;
        }
        long jUc = ucVar.uc();
        long jZo = ucVar.zo();
        long jFw = ucVar.fw();
        long jAj = ucVar.aj();
        jwVar.x(jUc);
        jwVar.c(jFw);
        jwVar.uc(jZo);
        jwVar.fw(jAj);
    }

    public static void pr(of ofVar, jw jwVar, com.byazt.zn.zo zoVar) {
        if (ofVar == null || jwVar == null || zoVar == null || zoVar.c() || jwVar.zo() == 1 || !a.hw().na()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", jwVar.aj());
            jSONObject.put("image_resolution", jwVar.vk());
            jSONObject.put("download_client_start_time", jwVar.nt());
            jSONObject.put("download_net_time", jwVar.yb());
            jSONObject.put("download_client_end_time", jwVar.lb());
        } catch (Exception e) {
        }
        com.byazt.pj.pr.pr(ofVar, "splash_ad", "download_image_duration", System.currentTimeMillis() - jwVar.qa(), jSONObject);
    }

    public static void hn(jw jwVar, long j) {
        if (jwVar == null) {
            return;
        }
        jwVar.w(j);
    }

    public static void pr(jw jwVar, com.byazt.zn.zo zoVar, long j) {
        if (jwVar == null || zoVar == null) {
            return;
        }
        long jFw = zoVar.fw();
        jwVar.vk(j - jFw);
        jwVar.a(zoVar.zo() - jFw);
    }

    public static void pr(boolean z, of ofVar, com.byazt.qe.hw hwVar, final com.byazt.zn.fw fwVar) {
        if (hwVar == null || fwVar == null) {
            return;
        }
        pr(ofVar, "outer_call_no_rsp", hwVar, z, new com.byazt.ttf.pr() { // from class: com.byazt.jm.fw.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                int iFw;
                int iX;
                JSONObject jSONObject2 = new JSONObject();
                com.byazt.zn.fw fwVar2 = fwVar;
                if (fwVar2 == null) {
                    iFw = 1;
                    iX = -1;
                } else {
                    iFw = fwVar2.fw();
                    iX = fwVar.x();
                }
                try {
                    jSONObject2.put("if_have_cache", iFw);
                    jSONObject2.put("if_have_rt_ads", iX);
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pr(com.byazt.qe.hw hwVar, final long j) {
        if (hwVar == null) {
            return;
        }
        com.byazt.xk.hw.pr().pr("outer_call", hwVar.x(), ls.fw(), 3, new com.byazt.ttf.pr() { // from class: com.byazt.jm.fw.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("publisher_timeout_control", j);
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pr(jw jwVar, com.byazt.zn.zo zoVar, long j, of ofVar) {
        if (zoVar == null || jwVar == null || ofVar == null) {
            return;
        }
        if (!zoVar.c()) {
            zo.pr(j, false, true, ofVar, 0L, "loadSuccess");
            if (!zoVar.uc()) {
                pr(jwVar, SystemClock.elapsedRealtime() - j);
                com.byazt.pj.pr.pr(ofVar, "splash_ad", SystemClock.elapsedRealtime() - j);
            } else {
                hw(jwVar, SystemClock.elapsedRealtime() - j);
            }
        }
        pr(jwVar, zoVar.uc());
        pr(jwVar, zoVar.x(), zoVar.aj());
        pr(jwVar, zoVar, System.currentTimeMillis());
        pr(jwVar, zoVar.m());
    }

    public static void pr(jw jwVar, String str) {
        if (jwVar == null) {
            return;
        }
        jwVar.hw(str);
    }

    public static void pr(boolean z, of ofVar, com.byazt.qe.hw hwVar, final boolean z2, final boolean z3) {
        if (ofVar == null || hwVar == null) {
            return;
        }
        pr(ofVar, "outer_call_send", hwVar, z, new com.byazt.ttf.pr() { // from class: com.byazt.jm.fw.3
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                int i;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (!z3) {
                        if (z2) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        jSONObject2.put("image_CacheType", i);
                    }
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    private static void pr(of ofVar, String str, com.byazt.qe.hw hwVar, boolean z, com.byazt.ttf.pr prVar) {
        int i;
        String strX;
        String strB_;
        String strFw;
        if (z) {
            i = 4;
        } else {
            i = 3;
        }
        String strX2 = hwVar.x();
        String strYb = null;
        if (ofVar == null) {
            strX = null;
            strB_ = null;
        } else {
            strX = ofVar.x();
            strB_ = ofVar.B_();
            strYb = ls.yb(ofVar);
        }
        if (!TextUtils.isEmpty(strYb)) {
            strFw = strYb;
        } else {
            strFw = ls.fw();
        }
        com.byazt.xk.hw.pr().pr(str, strX2, strX, strFw, i, null, strB_, null, null, 0, prVar);
    }

    public static void pr(boolean z, of ofVar, com.byazt.qe.hw hwVar) {
        if (ofVar == null || hwVar == null) {
            return;
        }
        pr(ofVar, "load_timeout", hwVar, z, (com.byazt.ttf.pr) null);
    }

    public static void pr(of ofVar, com.byazt.zn.x xVar) {
        if (xVar == null || ofVar == null || !a.hw().na()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_control", xVar.pr());
            jSONObject.put("render_sequence", xVar.hw());
            jSONObject.put("real_render_sequence", xVar.hn());
        } catch (Exception e) {
        }
        com.byazt.pj.pr.hw(ofVar, "splash_ad", "splash_render_duration", xVar.uc(), jSONObject);
    }

    public static void hw(of ofVar, com.byazt.zn.x xVar) {
        if (ofVar == null || xVar == null || !a.hw().na()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_material_duration", xVar.x());
            jSONObject.put("load_resource_duration", xVar.c());
            jSONObject.put("render_duration", xVar.uc());
            jSONObject.put("ren_seq", xVar.hw());
            jSONObject.put("real_ren_seq", xVar.hn());
            jSONObject.put("final_t", xVar.zo() ? "cache_ad" : "real_time_ad");
            jSONObject.put("load_t", xVar.aj());
            jSONObject.put("meta_load_Optimization", ofVar.su());
            jSONObject.put("serial_render", xVar.vk());
        } catch (Exception e) {
        }
        com.byazt.pj.pr.hn(ofVar, "splash_ad", "splash_total_duration", xVar.fw(), jSONObject);
    }

    public static void pr(of ofVar, com.byazt.zn.x xVar, com.byazt.zn.aj ajVar) {
        if (ofVar == null || ajVar == null) {
            return;
        }
        if (ie.pr(ofVar) == 1) {
            com.byazt.nz.pr.pr("Splash_FullLink", "自渲染 ");
            xVar.hn(99);
        } else if (!ajVar.hw()) {
            int iHn = ie.hn(ofVar);
            com.byazt.nz.pr.pr("Splash_FullLink", "模版渲染 ".concat(String.valueOf(iHn)));
            xVar.hn(iHn);
        } else {
            com.byazt.nz.pr.pr("Splash_FullLink", "模版兜底 ");
            xVar.hn(99);
        }
    }

    public static void x(jw jwVar, long j) {
        if (jwVar != null) {
            jwVar.nt(System.currentTimeMillis() - j);
        }
    }

    public static void pr(jw jwVar, jw jwVar2, i iVar, int i, int i2) {
        if (jwVar != null && jwVar2 != null) {
            jwVar.pr(i);
            jwVar.hw(i2);
            jwVar.ho(iVar.aj);
            jwVar2.pr(i);
            jwVar2.hw(i2);
            jwVar2.ho(iVar.aj);
        }
    }

    public static void pr(jw jwVar, int i) {
        if (jwVar != null && jwVar.n() < i) {
            jwVar.fw(i);
        }
    }

    public static void pr(int i, of ofVar, String str, int i2) {
        if (i == 2) {
            if (pr) {
                return;
            } else {
                pr = true;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", i);
            if (i == 1) {
                jSONObject.put("show_cnt", i2);
            }
            com.byazt.pj.pr.x(ofVar, str, jSONObject);
        } catch (JSONException e) {
        }
    }
}

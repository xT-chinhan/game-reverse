package com.byazt.ns;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.anythink.core.common.f.a;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.e;
import com.byazt.gct.nf;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.gct.su;
import com.byazt.gct.ta;
import com.byazt.gct.um;
import com.byazt.gct.v;
import com.byazt.nf.rv;
import com.byazt.okk.s;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.constants.BundleKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2117, 26})
public class qg {
    public static JSONObject n(float f, float f2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f);
            jSONObject.put("height", f2);
            if (z) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject n(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return null;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            Context context = rv.getContext();
            jSONObject.put("width", s.q(context, width) * 1.0f);
            jSONObject.put("height", s.q(context, height) * 1.0f);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject n(pk pkVar) {
        su suVarFs = nf.fs(pkVar);
        if (suVarFs == null) {
            return null;
        }
        String strQ = suVarFs.q();
        try {
            if (!TextUtils.isEmpty(strQ)) {
                return new JSONObject(strQ);
            }
            String strN = com.byazt.ysr.qg.n().n("ad", suVarFs.n(), suVarFs.qg());
            if (!TextUtils.isEmpty(strN)) {
                return new JSONObject(strN);
            }
            k.qg("TemplateUtils", "template is null");
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject n(pk pkVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z, String str, boolean z2) {
        JSONObject jSONObjectPv = pkVar.pv();
        try {
            jSONObjectPv.put("xSetting", com.byazt.gcl.s.n(pkVar, (AtomicBoolean) null));
            jSONObjectPv.put("xAdInfo", n(pkVar, str));
            JSONObject jSONObject3 = new JSONObject();
            com.byazt.gcl.s.n(jSONObject3, w.d(pkVar));
            jSONObject3.put("platform", "android");
            jSONObjectPv.put("xAppInfo", jSONObject3);
            jSONObjectPv.put("xCreative", qg(pkVar));
            if (jSONObject2 != null) {
                jSONObjectPv.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                float fOptDouble = (float) jSONObject.optDouble("width");
                float fOptDouble2 = (float) jSONObject.optDouble("height");
                boolean zOptBoolean = jSONObject.optBoolean("isLandscape");
                if (!Float.isNaN(fOptDouble) && !Float.isNaN(fOptDouble2)) {
                    if (z2 && rv.qg().yj()) {
                        float f = rv.getContext().getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        jSONObject.put("width", s.qg(f2, s.n(f, fOptDouble)));
                        jSONObject.put("height", s.qg(f2, s.n(f, fOptDouble2)));
                    } else {
                        if (!z2 && rv.qg().dd() && !zOptBoolean) {
                            jSONObject.put("width", Math.min(fOptDouble, s.q(rv.getContext(), s.l(rv.getContext()))));
                        }
                        jSONObject.put("height", fOptDouble2);
                    }
                } else {
                    jSONObject.put("width", 0.0d);
                    jSONObject.put("height", 0.0d);
                }
                try {
                    jSONObject.put("render_height_limit", nf.n(pkVar, jSONObject.optInt("width")));
                } catch (JSONException unused) {
                }
                jSONObjectPv.put("xSize", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            Context context = rv.getContext();
            jSONObject5.put("width", s.q(context, s.l(context)));
            jSONObject5.put("height", s.q(context, s.w(context)));
            jSONObject4.put("screen_size", jSONObject5);
            jSONObject4.put("content_size", jSONObject);
            jSONObject4.put("platform", "android");
            jSONObjectPv.put("xEnvInfo", jSONObject4);
            jSONObjectPv.put("gesture_through_enable", z && rv.qg().dx());
        } catch (Exception unused2) {
        }
        return jSONObjectPv;
    }

    public static JSONObject n(pk pkVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strQ = pkVar.q();
            if (!TextUtils.isEmpty(strQ)) {
                jSONObject.put("cid", strQ);
            }
            String strF_ = pkVar.F_();
            if (!TextUtils.isEmpty(strF_)) {
                jSONObject.put("log_extra", strF_);
            }
            String strWm = w.wm(pkVar);
            if (!TextUtils.isEmpty(strWm)) {
                jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, strWm);
            }
            jSONObject.put("isDirectDownload", pkVar.ri());
            jSONObject.put("dynamic_configs", pkVar.cy());
            if (!TextUtils.isEmpty(str) && str.contains("advance_reward")) {
                jSONObject.put("userData", str);
            }
            if (cd.oa(pkVar)) {
                jSONObject.put("voice_btn_position", cd.hd(pkVar));
            }
            jSONObject.put("if_show_win", pkVar.nd());
            String strHj = pkVar.hj();
            if (!TextUtils.isEmpty(strHj) && strHj.contains(",")) {
                jSONObject.put("isMultAd", 1);
            }
            jSONObject.put("is_derive_image", com.byazt.aci.n.q(pkVar));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject n(float f, float f2, boolean z, pk pkVar, boolean z2) {
        String strL;
        String strW;
        com.byazt.px.qg qgVarN;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            if (z2 && rv.qg().yj()) {
                float f3 = rv.getContext().getResources().getDisplayMetrics().density;
                float f4 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put("width", s.qg(f4, s.n(f3, f)));
                jSONObject2.put("height", s.qg(f4, s.n(f3, f2)));
            } else {
                jSONObject2.put("width", f);
                jSONObject2.put("height", f2);
            }
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", qg(pkVar));
            if (nf.x(pkVar) != null) {
                strL = nf.x(pkVar).l();
                strW = nf.x(pkVar).w();
            } else {
                strL = null;
                strW = null;
            }
            if (TextUtils.isEmpty(strL)) {
                strL = (nf.x(pkVar) == null || (qgVarN = com.byazt.mzw.qg.n(nf.x(pkVar).qg())) == null) ? null : qgVarN.l();
            }
            jSONObject.put("template_Plugin", strL);
            jSONObject.put("diff_template_Plugin", strW);
            jSONObject.put("dynamic_configs", pkVar.cy());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("keys");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (jSONObject.has(strOptString)) {
                        jSONObject3.put(strOptString, jSONObject.opt(strOptString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject qg(pk pkVar) {
        int[] iArrL;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", pkVar.jb());
            if (pkVar.xu() != null) {
                jSONObject.put("icon", pkVar.xu().n());
            }
            JSONArray jSONArray = new JSONArray();
            if (pkVar.jo() != null) {
                for (int i = 0; i < pkVar.jo().size(); i++) {
                    v vVar = pkVar.jo().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", vVar.s());
                    jSONObject2.put("width", vVar.qg());
                    jSONObject2.put(ImagesContract.URL, vVar.n());
                    jSONObject2.put("image_key", vVar.x());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", pkVar.ge());
            jSONObject.put("interaction_type", pkVar.rv());
            jSONObject.put("is_compliance_template", s(pkVar));
            jSONObject.put("title", pkVar.E_());
            jSONObject.put(BundleKey.DESCRIPTION, pkVar.m19if());
            jSONObject.put("source", pkVar.yr());
            if (pkVar.k() != null) {
                jSONObject.put("comment_num", pkVar.k().w());
                jSONObject.put("score", pkVar.k().l());
                jSONObject.put("app_size", pkVar.k().x());
                jSONObject.put(a.C0017a.c, pkVar.k().fs());
            }
            if (ta.k(pkVar) != null) {
                JSONObject jSONObjectUm = ta.sz(pkVar).um();
                if (pkVar.sn() > 0 && ta.x(pkVar) > pkVar.sn()) {
                    jSONObjectUm.put("video_duration", pkVar.sn());
                }
                if (com.byazt.aci.n.n(pkVar) && (iArrL = ta.l(pkVar)) != null && iArrL.length >= 2 && !com.byazt.aci.n.x(pkVar)) {
                    jSONObjectUm.put("cover_width", iArrL[0]);
                    jSONObjectUm.put("cover_height", iArrL[1]);
                }
                ta.x(pkVar);
                jSONObject.put(MediaFormat.KEY_VIDEO, jSONObjectUm);
            }
            if (cx.hd(pkVar)) {
                jSONObject.put("reward_full_play_time", cx.k(pkVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", cx.t(pkVar));
            if (nf.x(pkVar) != null) {
                jSONObject.put("dynamic_creative", nf.x(pkVar).x());
            }
            jSONObject.put("live_ad", w(pkVar));
            n(pkVar, jSONObject);
            if (com.byazt.wq.qg.n().qg(pkVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", pkVar.fw());
            jSONObject.put("can_show_interactive", pkVar.vc());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static JSONObject w(pk pkVar) {
        JSONObject jSONObject = new JSONObject();
        if (pkVar != null && com.byazt.gks.n.n(pkVar)) {
            try {
                jSONObject.put("live_show_time", oj.qg(pkVar));
                jSONObject.put("live_author_nickname", oj.s(pkVar));
                if (oj.q(pkVar) > 0) {
                    jSONObject.put("live_author_follower_count", oj.q(pkVar));
                }
                if (oj.l(pkVar) > 0) {
                    jSONObject.put("live_watch_count", oj.l(pkVar));
                }
                jSONObject.put("live_description", oj.w(pkVar));
                jSONObject.put("live_feed_url", oj.x(pkVar));
                jSONObject.put("live_cover_image_url", oj.fs(pkVar));
                jSONObject.put("live_avatar_url", oj.rv(pkVar));
                jSONObject.put("live_cover_image_width", oj.d(pkVar));
                jSONObject.put("live_cover_image_height", oj.oa(pkVar));
                jSONObject.put("live_avatar_width", oj.tj(pkVar));
                jSONObject.put("live_avatar_height", oj.cp(pkVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static void n(pk pkVar, JSONObject jSONObject) {
        if (w.d(pkVar) == 7 && e.n(pkVar)) {
            pkVar.ml().n(jSONObject);
        }
    }

    public static boolean s(pk pkVar) {
        return pkVar != null && um.rv(pkVar) == 2;
    }

    public static String q(pk pkVar) {
        if (nf.x(pkVar) == null) {
            return null;
        }
        return nf.x(pkVar).qg();
    }

    public static String qg(pk pkVar, String str) {
        List<v> listJo;
        if (pkVar != null && (listJo = pkVar.jo()) != null && listJo.size() > 0) {
            for (v vVar : listJo) {
                if (vVar != null && TextUtils.equals(str, vVar.n())) {
                    return vVar.x();
                }
            }
        }
        return null;
    }

    public static Map<String, String> l(pk pkVar) {
        HashMap map = null;
        if (pkVar == null) {
            return null;
        }
        List<v> listJo = pkVar.jo();
        if (listJo != null && listJo.size() > 0) {
            map = new HashMap();
            for (v vVar : listJo) {
                if (vVar != null) {
                    map.put(vVar.n(), vVar.x());
                }
            }
        }
        return map;
    }
}

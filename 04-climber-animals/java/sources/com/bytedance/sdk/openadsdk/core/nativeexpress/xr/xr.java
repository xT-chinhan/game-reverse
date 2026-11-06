package com.bytedance.sdk.openadsdk.core.nativeexpress.xr;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.anythink.core.common.e.a;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.rt;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.re;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.umeng.analytics.pro.bv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static JSONObject ms(float f, float f2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f);
            jSONObject.put("height", f2);
            if (z) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    public static JSONObject ms(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return null;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            Context context = re.getContext();
            jSONObject.put("width", ul.d(context, width) * 1.0f);
            jSONObject.put("height", ul.d(context, height) * 1.0f);
            return jSONObject;
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    public static JSONObject ms(lm lmVar) {
        rt rtVarPl = lmVar.pl();
        if (rtVarPl == null) {
            return null;
        }
        String strD = rtVarPl.d();
        try {
            if (!TextUtils.isEmpty(strD)) {
                return new JSONObject(strD);
            }
            String strMs = com.bytedance.sdk.openadsdk.core.nativeexpress.ms.xr.ms().ms(bv.aw, rtVarPl.ms(), rtVarPl.xr());
            if (!TextUtils.isEmpty(strMs)) {
                return new JSONObject(strMs);
            }
            sl.d("TemplateUtils", "template is null");
            return null;
        } catch (Exception e) {
            sl.ms(e);
            return null;
        }
    }

    public static JSONObject ms(lm lmVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        JSONObject jSONObjectRm = lmVar.rm();
        try {
            jSONObjectRm.put("xSetting", pc.ms(lmVar, (AtomicBoolean) null));
            jSONObjectRm.put("xAdInfo", c(lmVar));
            JSONObject jSONObject3 = new JSONObject();
            pc.ah(jSONObject3);
            jSONObject3.put("platform", "android");
            jSONObjectRm.put("xAppInfo", jSONObject3);
            jSONObjectRm.put("xCreative", xr(lmVar));
            if (jSONObject2 != null) {
                jSONObjectRm.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObjectRm.put("xSize", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            Context context = re.getContext();
            jSONObject5.put("width", ul.d(context, ul.d(context)));
            jSONObject5.put("height", ul.d(context, ul.ka(context)));
            jSONObject4.put("screen_size", jSONObject5);
            jSONObject4.put("content_size", jSONObject);
            jSONObject4.put("platform", "android");
            jSONObjectRm.put("xEnvInfo", jSONObject4);
            jSONObjectRm.put("gesture_through_enable", z && re.xr().cc());
        } catch (Exception e) {
            sl.ms(e);
        }
        return jSONObjectRm;
    }

    private static JSONObject c(lm lmVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strDf = lmVar.df();
            if (!TextUtils.isEmpty(strDf)) {
                jSONObject.put("cid", strDf);
            }
            String strLx = lmVar.lx();
            if (!TextUtils.isEmpty(strLx)) {
                jSONObject.put("log_extra", strLx);
            }
            String strAo = f.ao(lmVar);
            if (!TextUtils.isEmpty(strAo)) {
                jSONObject.put("download_url", strAo);
            }
            if (t.hi(lmVar)) {
                jSONObject.put("voice_btn_position", t.ub(lmVar));
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObject;
    }

    public static JSONObject ms(float f, float f2, boolean z, lm lmVar) {
        String strKa;
        String strC;
        com.bytedance.sdk.component.adexpress.ms.ah.xr xrVarMs;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            if (re.xr().zm()) {
                float f3 = re.getContext().getResources().getDisplayMetrics().density;
                float f4 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put("width", ul.xr(f4, ul.ms(f3, f)));
                jSONObject2.put("height", ul.xr(f4, ul.ms(f3, f2)));
            } else {
                jSONObject2.put("width", f);
                jSONObject2.put("height", f2);
            }
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", xr(lmVar));
            if (lmVar.si() != null) {
                strKa = lmVar.si().ka();
                strC = lmVar.si().c();
            } else {
                strKa = null;
                strC = null;
            }
            if (TextUtils.isEmpty(strKa)) {
                strKa = (lmVar == null || lmVar.si() == null || (xrVarMs = com.bytedance.sdk.component.adexpress.ms.xr.xr.ms(lmVar.si().xr())) == null) ? null : xrVarMs.ka();
            }
            jSONObject.put("template_Plugin", strKa);
            jSONObject.put("diff_template_Plugin", strC);
            jSONObject.put("dynamic_configs", lmVar.li());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject ms(JSONObject jSONObject, JSONObject jSONObject2) {
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

    public static JSONObject xr(lm lmVar) {
        int[] iArrKa;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", lmVar.bn());
            if (lmVar.qd() != null) {
                jSONObject.put("icon", lmVar.qd().ms());
            }
            JSONArray jSONArray = new JSONArray();
            if (lmVar.fk() != null) {
                for (int i = 0; i < lmVar.fk().size(); i++) {
                    g gVar = lmVar.fk().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", gVar.ah());
                    jSONObject2.put("width", gVar.xr());
                    jSONObject2.put("url", gVar.ms());
                    jSONObject2.put("image_key", gVar.ab());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", lmVar.kz());
            jSONObject.put("interaction_type", lmVar.jr());
            jSONObject.put("is_compliance_template", ah(lmVar));
            jSONObject.put("title", lmVar.eh());
            jSONObject.put(BundleKey.DESCRIPTION, lmVar.fs());
            jSONObject.put("source", lmVar.nq());
            if (lmVar.zh() != null) {
                jSONObject.put("comment_num", lmVar.zh().c());
                jSONObject.put("score", lmVar.zh().ka());
                jSONObject.put("app_size", lmVar.zh().ab());
                jSONObject.put(a.C0080a.c, lmVar.zh().x());
            }
            if (qr.u(lmVar) != null) {
                JSONObject jSONObjectY = qr.zb(lmVar).y();
                if (lmVar.tf() == 2 && qr.c(lmVar) > 60.0d) {
                    jSONObjectY.put("video_duration", 60);
                }
                if (com.bytedance.sdk.openadsdk.ka.ms.ms(lmVar) && (iArrKa = qr.ka(lmVar)) != null && iArrKa.length >= 2 && !com.bytedance.sdk.openadsdk.ka.ms.ab(lmVar)) {
                    jSONObjectY.put("cover_width", iArrKa[0]);
                    jSONObjectY.put("cover_height", iArrKa[1]);
                }
                jSONObject.put("video", jSONObjectY);
            }
            if (qf.h(lmVar)) {
                jSONObject.put("reward_full_play_time", qf.ub(lmVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", qf.yu(lmVar));
            if (lmVar.si() != null) {
                jSONObject.put("dynamic_creative", lmVar.si().ab());
            }
            jSONObject.put("live_ad", ab(lmVar));
            ms(lmVar, jSONObject);
            if (com.bytedance.sdk.openadsdk.core.live.xr.ms().xr(lmVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", lmVar.ze());
            jSONObject.put("can_show_interactive", lmVar.kb());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static JSONObject ab(lm lmVar) {
        JSONObject jSONObject = new JSONObject();
        if (lmVar != null && com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            try {
                jSONObject.put("live_show_time", com.bytedance.sdk.openadsdk.core.nw.ul.xr(lmVar));
                jSONObject.put("live_author_nickname", com.bytedance.sdk.openadsdk.core.nw.ul.ah(lmVar));
                if (com.bytedance.sdk.openadsdk.core.nw.ul.d(lmVar) > 0) {
                    jSONObject.put("live_author_follower_count", com.bytedance.sdk.openadsdk.core.nw.ul.d(lmVar));
                }
                if (com.bytedance.sdk.openadsdk.core.nw.ul.ka(lmVar) > 0) {
                    jSONObject.put("live_watch_count", com.bytedance.sdk.openadsdk.core.nw.ul.ka(lmVar));
                }
                jSONObject.put("live_description", com.bytedance.sdk.openadsdk.core.nw.ul.c(lmVar));
                jSONObject.put("live_feed_url", com.bytedance.sdk.openadsdk.core.nw.ul.ab(lmVar));
                jSONObject.put("live_cover_image_url", com.bytedance.sdk.openadsdk.core.nw.ul.x(lmVar));
                jSONObject.put("live_avatar_url", com.bytedance.sdk.openadsdk.core.nw.ul.ny(lmVar));
                jSONObject.put("live_cover_image_width", com.bytedance.sdk.openadsdk.core.nw.ul.sl(lmVar));
                jSONObject.put("live_cover_image_height", com.bytedance.sdk.openadsdk.core.nw.ul.zb(lmVar));
                jSONObject.put("live_avatar_width", com.bytedance.sdk.openadsdk.core.nw.ul.ch(lmVar));
                jSONObject.put("live_avatar_height", com.bytedance.sdk.openadsdk.core.nw.ul.hi(lmVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static void ms(lm lmVar, JSONObject jSONObject) {
        if (f.x(lmVar) == 7 && xn.ms(lmVar)) {
            lmVar.or().ms(jSONObject);
        }
    }

    public static boolean ah(lm lmVar) {
        return lmVar != null && nw.sl(lmVar) == 2;
    }

    public static String d(lm lmVar) {
        if (lmVar == null || lmVar.si() == null) {
            return null;
        }
        return lmVar.si().xr();
    }

    public static String ms(lm lmVar, String str) {
        List<g> listFk;
        if (lmVar != null && (listFk = lmVar.fk()) != null && listFk.size() > 0) {
            for (g gVar : listFk) {
                if (gVar != null && TextUtils.equals(str, gVar.ms())) {
                    return gVar.ab();
                }
            }
        }
        return null;
    }

    public static Map<String, String> ka(lm lmVar) {
        HashMap map = null;
        if (lmVar == null) {
            return null;
        }
        List<g> listFk = lmVar.fk();
        if (listFk != null && listFk.size() > 0) {
            map = new HashMap();
            for (g gVar : listFk) {
                if (gVar != null) {
                    map.put(gVar.ms(), gVar.ab());
                }
            }
        }
        return map;
    }
}

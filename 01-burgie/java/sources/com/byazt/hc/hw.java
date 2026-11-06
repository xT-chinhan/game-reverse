package com.byazt.hc;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.byazt.ca.ho;
import com.byazt.hg.cr;
import com.byazt.hg.f;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.hg.qv;
import com.byazt.hg.v;
import com.byazt.hg.y;
import com.byazt.sd.a;
import com.byazt.sd.nl;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2027, 13})
public class hw {
    public static JSONObject pr(float f, float f2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f);
            jSONObject.put("height", f2);
            if (z) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject pr(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                int width = view.getWidth();
                int height = view.getHeight();
                Context context = a.getContext();
                jSONObject.put("width", er.x(context, width) * 1.0f);
                jSONObject.put("height", er.x(context, height) * 1.0f);
                return jSONObject;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static JSONObject pr(of ofVar) {
        cr crVarZo = ie.zo(ofVar);
        if (crVarZo != null) {
            String strX = crVarZo.x();
            try {
                if (!TextUtils.isEmpty(strX)) {
                    return new JSONObject(strX);
                }
                String strPr = com.byazt.ir.hw.pr().pr(an.aw, crVarZo.pr(), crVarZo.hw());
                if (!TextUtils.isEmpty(strPr)) {
                    return new JSONObject(strPr);
                }
                ho.hw("TemplateUtils", "template is null");
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static JSONObject pr(of ofVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z, String str, boolean z2) {
        JSONObject jSONObject3 = ofVar.to();
        try {
            jSONObject3.put("xSetting", nl.pr(ofVar, (AtomicBoolean) null));
            jSONObject3.put("xAdInfo", pr(ofVar, str));
            JSONObject jSONObject4 = new JSONObject();
            nl.pr(jSONObject4, ls.k(ofVar));
            jSONObject4.put("platform", "android");
            jSONObject3.put("xAppInfo", jSONObject4);
            jSONObject3.put("xCreative", hw(ofVar));
            if (jSONObject2 != null) {
                jSONObject3.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                float fOptDouble = (float) jSONObject.optDouble("width");
                float fOptDouble2 = (float) jSONObject.optDouble("height");
                boolean zOptBoolean = jSONObject.optBoolean("isLandscape");
                if (!Float.isNaN(fOptDouble) && !Float.isNaN(fOptDouble2)) {
                    if (z2 && a.hw().kq()) {
                        float f = a.getContext().getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        jSONObject.put("width", er.hw(f2, er.pr(f, fOptDouble)));
                        jSONObject.put("height", er.hw(f2, er.pr(f, fOptDouble2)));
                    } else {
                        if (!z2 && a.hw().rj() && !zOptBoolean) {
                            jSONObject.put("width", Math.min(fOptDouble, er.x(a.getContext(), er.c(a.getContext()))));
                        }
                        jSONObject.put("height", fOptDouble2);
                    }
                } else {
                    jSONObject.put("width", 0.0d);
                    jSONObject.put("height", 0.0d);
                }
                try {
                    jSONObject.put("render_height_limit", ie.pr(ofVar, jSONObject.optInt("width")));
                } catch (JSONException e) {
                }
                jSONObject3.put("xSize", jSONObject);
            }
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObject6 = new JSONObject();
            Context context = a.getContext();
            jSONObject6.put("width", er.x(context, er.c(context)));
            jSONObject6.put("height", er.x(context, er.uc(context)));
            jSONObject5.put("screen_size", jSONObject6);
            jSONObject5.put("content_size", jSONObject);
            jSONObject5.put("platform", "android");
            jSONObject3.put("xEnvInfo", jSONObject5);
            jSONObject3.put("gesture_through_enable", z && a.hw().ok());
        } catch (Exception e2) {
        }
        return jSONObject3;
    }

    public static JSONObject pr(of ofVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strX = ofVar.x();
            if (!TextUtils.isEmpty(strX)) {
                jSONObject.put("cid", strX);
            }
            String strB_ = ofVar.B_();
            if (!TextUtils.isEmpty(strB_)) {
                jSONObject.put("log_extra", strB_);
            }
            String strA = ls.a(ofVar);
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("download_url", strA);
            }
            jSONObject.put("isDirectDownload", ofVar.ii());
            jSONObject.put("dynamic_configs", ofVar.nt());
            if (!TextUtils.isEmpty(str) && str.contains("advance_reward")) {
                jSONObject.put("userData", str);
            }
            if (lb.m(ofVar)) {
                jSONObject.put("voice_btn_position", lb.yb(ofVar));
            }
            jSONObject.put("if_show_win", ofVar.tp());
            String strKq = ofVar.kq();
            if (!TextUtils.isEmpty(strKq) && strKq.contains(",")) {
                jSONObject.put("isMultAd", 1);
            }
            jSONObject.put("is_derive_image", com.byazt.ja.pr.x(ofVar));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static JSONObject pr(float f, float f2, boolean z, of ofVar, boolean z2) {
        String strC;
        String strUc;
        com.byazt.hfm.hw hwVarPr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            if (z2 && a.hw().kq()) {
                float f3 = a.getContext().getResources().getDisplayMetrics().density;
                float f4 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put("width", er.hw(f4, er.pr(f3, f)));
                jSONObject2.put("height", er.hw(f4, er.pr(f3, f2)));
            } else {
                jSONObject2.put("width", f);
                jSONObject2.put("height", f2);
            }
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put(ProviderInteractionViews.ROLE_CREATIVE, hw(ofVar));
            if (ie.fw(ofVar) == null) {
                strC = null;
                strUc = null;
            } else {
                strC = ie.fw(ofVar).c();
                strUc = ie.fw(ofVar).uc();
            }
            if (TextUtils.isEmpty(strC)) {
                if (ie.fw(ofVar) != null && (hwVarPr = com.byazt.ce.hw.pr(ie.fw(ofVar).hw())) != null) {
                    strC = hwVarPr.c();
                } else {
                    strC = null;
                }
            }
            jSONObject.put("template_Plugin", strC);
            jSONObject.put("diff_template_Plugin", strUc);
            jSONObject.put("dynamic_configs", ofVar.nt());
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject pr(JSONObject jSONObject, JSONObject jSONObject2) {
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
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public static JSONObject hw(of ofVar) {
        int[] iArrC;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", ofVar.se());
            if (ofVar.mo() != null) {
                jSONObject.put("icon", ofVar.mo().pr());
            }
            JSONArray jSONArray = new JSONArray();
            if (ofVar.de() != null) {
                for (int i = 0; i < ofVar.de().size(); i++) {
                    y yVar = ofVar.de().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", yVar.hn());
                    jSONObject2.put("width", yVar.hw());
                    jSONObject2.put(BreakpointSQLiteKey.URL, yVar.pr());
                    jSONObject2.put("image_key", yVar.fw());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(ImageViewManager.NAME, jSONArray);
            jSONObject.put("image_mode", ofVar.jg());
            jSONObject.put("interaction_type", ofVar.aj());
            jSONObject.put("is_compliance_template", hn(ofVar));
            jSONObject.put(BundleKey.TITLE, ofVar.A_());
            jSONObject.put(BundleKey.DESCRIPTION, ofVar.jv());
            jSONObject.put("source", ofVar.zj());
            if (ofVar.ho() != null) {
                jSONObject.put("comment_num", ofVar.ho().uc());
                jSONObject.put("score", ofVar.ho().c());
                jSONObject.put("app_size", ofVar.ho().fw());
                jSONObject.put("app", ofVar.ho().zo());
            }
            if (qv.ho(ofVar) != null) {
                JSONObject jSONObjectQa = qv.g(ofVar).qa();
                if (ofVar.io() > 0 && qv.fw(ofVar) > ofVar.io()) {
                    jSONObjectQa.put(Constants.VIDEO_DURATION_FIELD, ofVar.io());
                }
                if (com.byazt.ja.pr.pr(ofVar) && (iArrC = qv.c(ofVar)) != null && iArrC.length >= 2 && !com.byazt.ja.pr.fw(ofVar)) {
                    jSONObjectQa.put("cover_width", iArrC[0]);
                    jSONObjectQa.put("cover_height", iArrC[1]);
                }
                qv.fw(ofVar);
                jSONObject.put("video", jSONObjectQa);
            }
            if (jn.yb(ofVar)) {
                jSONObject.put("reward_full_play_time", jn.ho(ofVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", jn.iu(ofVar));
            if (ie.fw(ofVar) != null) {
                jSONObject.put("dynamic_creative", ie.fw(ofVar).fw());
            }
            jSONObject.put("live_ad", uc(ofVar));
            pr(ofVar, jSONObject);
            if (com.byazt.eg.hw.pr().hw(ofVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", ofVar.jr());
            jSONObject.put("can_show_interactive", ofVar.hv());
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    private static JSONObject uc(of ofVar) {
        JSONObject jSONObject = new JSONObject();
        if (ofVar != null && com.byazt.lpk.pr.pr(ofVar)) {
            try {
                jSONObject.put("live_show_time", v.hw(ofVar));
                jSONObject.put("live_author_nickname", v.hn(ofVar));
                if (v.x(ofVar) > 0) {
                    jSONObject.put("live_author_follower_count", v.x(ofVar));
                }
                if (v.c(ofVar) > 0) {
                    jSONObject.put("live_watch_count", v.c(ofVar));
                }
                jSONObject.put("live_description", v.uc(ofVar));
                jSONObject.put("live_feed_url", v.fw(ofVar));
                jSONObject.put("live_cover_image_url", v.zo(ofVar));
                jSONObject.put("live_avatar_url", v.aj(ofVar));
                jSONObject.put("live_cover_image_width", v.k(ofVar));
                jSONObject.put("live_cover_image_height", v.m(ofVar));
                jSONObject.put("live_avatar_width", v.vk(ofVar));
                jSONObject.put("live_avatar_height", v.w(ofVar));
            } catch (Exception e) {
            }
            return jSONObject;
        }
        return jSONObject;
    }

    private static void pr(of ofVar, JSONObject jSONObject) {
        if (ls.k(ofVar) != 7 || !f.pr(ofVar)) {
            return;
        }
        ofVar.wn().pr(jSONObject);
    }

    public static boolean hn(of ofVar) {
        return ofVar != null && qa.aj(ofVar) == 2;
    }

    public static String x(of ofVar) {
        if (ie.fw(ofVar) == null) {
            return null;
        }
        return ie.fw(ofVar).hw();
    }

    public static String hw(of ofVar, String str) {
        List<y> listDe;
        if (ofVar == null || (listDe = ofVar.de()) == null || listDe.size() <= 0) {
            return null;
        }
        for (y yVar : listDe) {
            if (yVar != null && TextUtils.equals(str, yVar.pr())) {
                return yVar.fw();
            }
        }
        return null;
    }

    public static Map<String, String> c(of ofVar) {
        List<y> listDe;
        if (ofVar == null || (listDe = ofVar.de()) == null || listDe.size() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (y yVar : listDe) {
            if (yVar != null) {
                map.put(yVar.pr(), yVar.fw());
            }
        }
        return map;
    }
}

package com.byazt.aci;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.ag.qg;
import com.byazt.ej.k;
import com.byazt.ej.oa;
import com.byazt.gct.h;
import com.byazt.gct.pk;
import com.byazt.gct.rf;
import com.byazt.gct.ta;
import com.byazt.gct.v;
import com.byazt.nf.rv;
import com.byazt.qp.q;
import com.byazt.vf.fi;
import com.byazt.wt.UpieImageView;
import com.byazt.zsl.l;
import com.byazt.zsl.s;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 846, 19})
public class n {
    private static boolean n(int i) {
        return i == 5 || i == 3;
    }

    private static boolean qg(int i) {
        return i == 16 || i == 15 || i == 131;
    }

    public static boolean n(pk pkVar) {
        return qg(pkVar) || s(pkVar);
    }

    public static boolean qg(pk pkVar) {
        return pkVar != null && pkVar.ds() == 15;
    }

    public static boolean s(pk pkVar) {
        return pkVar != null && pkVar.ds() == 16;
    }

    public static Map<k, oa> n(pk pkVar, l lVar, oa oaVar, List<k> list) {
        List<l> listN;
        if (list == null || (listN = n(pkVar, lVar)) == null) {
            return null;
        }
        HashMap map = new HashMap(listN.size());
        for (l lVar2 : listN) {
            if (lVar2 == lVar) {
                map.put(lVar2, oaVar);
            } else {
                map.put(lVar2, com.byazt.du.n.n(pkVar, (long) lVar2.v().w()));
            }
        }
        list.clear();
        list.addAll(listN);
        return map;
    }

    public static List<l> n(pk pkVar, l lVar) {
        com.byazt.ej.l lVarV;
        if (s(pkVar) && lVar != null && (lVarV = lVar.v()) != null && lVarV.w() > 0.0d) {
            JSONObject jSONObjectWo = pkVar.wo();
            JSONArray jSONArrayOptJSONArray = jSONObjectWo == null ? null : jSONObjectWo.optJSONArray("multi_videos");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 1) {
                ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject == null) {
                        return null;
                    }
                    if (n(jSONObjectOptJSONObject)) {
                        if (i != jSONArrayOptJSONArray.length() - 1) {
                            return null;
                        }
                        arrayList.add(lVar);
                    } else {
                        l lVarN = n(jSONObjectOptJSONObject, lVar);
                        if (lVarN == null) {
                            return null;
                        }
                        arrayList.add(lVarN);
                    }
                }
                if (arrayList.size() == jSONArrayOptJSONArray.length() && arrayList.get(arrayList.size() - 1) == lVar) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    private static boolean n(JSONObject jSONObject) {
        return jSONObject.optBoolean("is_ad") || jSONObject.optInt("is_ad") == 1;
    }

    private static l n(JSONObject jSONObject, l lVar) {
        String strOptString = jSONObject.optString("video_url");
        double dOptDouble = jSONObject.optDouble("video_duration");
        if (TextUtils.isEmpty(strOptString) || dOptDouble <= 0.0d) {
            return null;
        }
        s sVar = new s();
        sVar.s(strOptString);
        sVar.n(dOptDouble);
        sVar.n(jSONObject.optLong("video_size"));
        sVar.n(jSONObject.optString("resolution"));
        sVar.w(jSONObject.optString("file_hash"));
        sVar.w(1);
        com.byazt.ej.l lVarV = lVar.v();
        if (lVarV != null) {
            sVar.l(lVarV.cy());
        }
        l lVar2 = new l(lVar.l(), sVar, null, lVar.m(), 0);
        lVar2.qg(lVar.k());
        lVar2.q(lVar.cd());
        lVar2.q(lVar.um());
        lVar2.qg(lVar.rv());
        lVar2.s(lVar.oa());
        lVar2.qg(lVar.tj());
        lVar2.s(lVar.cp());
        lVar2.w(lVar.hu());
        lVar2.x(lVar.h());
        lVar2.fs(lVar.t());
        return lVar2;
    }

    public static boolean q(pk pkVar) {
        return l(pkVar) || w(pkVar);
    }

    public static boolean l(pk pkVar) {
        return pkVar != null && pkVar.ds() == 17;
    }

    public static boolean w(pk pkVar) {
        return pkVar != null && pkVar.ds() == 18;
    }

    public static boolean x(pk pkVar) {
        int[] iArrL;
        if (pkVar == null || (iArrL = ta.l(pkVar)) == null || iArrL.length < 2) {
            return true;
        }
        int i = iArrL[0];
        int i2 = iArrL[1];
        int iQ = ta.q(pkVar);
        int iS = ta.s(pkVar);
        return (i >= i2 && iQ >= iS) || (i <= i2 && iQ <= iS);
    }

    public static boolean fs(pk pkVar) {
        if (pkVar != null && !pk.s(pkVar)) {
            if (q(pkVar)) {
                return true;
            }
            if (!rv.qg().m35do() && (h.qg(pkVar) || h.q(pkVar) || rf.qg(pkVar))) {
                return true;
            }
        }
        return false;
    }

    private static com.byazt.ts.n.C0356n n(pk pkVar, boolean z) {
        int[] iArrL = ta.l(pkVar);
        if (!z) {
            oa(pkVar);
        }
        String strRv = rv(pkVar);
        com.byazt.ts.n.C0356n c0356n = new com.byazt.ts.n.C0356n();
        if (TextUtils.isEmpty(strRv)) {
            strRv = "";
        }
        com.byazt.ts.n.C0356n c0356nQg = c0356n.n(strRv).n((iArrL == null || iArrL.length < 2) ? 1280 : iArrL[0]).qg((iArrL == null || iArrL.length < 2) ? 720 : iArrL[1]);
        if (qg(pkVar)) {
            com.byazt.zsl.n nVarHd = ta.hd(pkVar);
            c0356nQg.s(k(pkVar)).qg(nVarHd != null ? nVarHd.l() : "").n(((long) ta.x(pkVar)) * 1000);
        }
        if (q(pkVar)) {
            c0356nQg.s(k(pkVar));
        }
        return c0356nQg;
    }

    public static String rv(pk pkVar) {
        JSONObject jSONObjectWo;
        JSONObject jSONObjectOptJSONObject;
        if (pkVar == null || (jSONObjectWo = pkVar.wo()) == null || (jSONObjectOptJSONObject = jSONObjectWo.optJSONObject("sdk_template_info")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("lottie_tmp_url");
    }

    private static void oa(pk pkVar) {
        JSONObject jSONObjectWo;
        JSONObject jSONObjectOptJSONObject;
        if (pkVar == null || (jSONObjectWo = pkVar.wo()) == null || (jSONObjectOptJSONObject = jSONObjectWo.optJSONObject("sdk_template_info")) == null || !n(1, pkVar)) {
            return;
        }
        String strSz = sz(pkVar);
        if (TextUtils.isEmpty(strSz)) {
            return;
        }
        try {
            jSONObjectOptJSONObject.putOpt("lottie_tmp_url", strSz);
        } catch (JSONException unused) {
        }
    }

    public static boolean n(int i, pk pkVar) {
        fi fiVar;
        JSONObject jSONObjectN;
        return (pkVar == null || (fiVar = (fi) q.n("strategy")) == null || (jSONObjectN = fiVar.n("c_s_a_performance_lottie_downgrade", null, pkVar.sh())) == null || jSONObjectN.optInt("lottie_downgrade") != 1 || (jSONObjectN.optInt("s_ab_conf_info") & i) != i) ? false : true;
    }

    private static String sz(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        int iGe = pkVar.ge();
        boolean zN = n(iGe);
        boolean zQg = qg(iGe);
        if (!zN && !zQg) {
            return null;
        }
        if (s(pkVar)) {
            return zN ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140601/easy_client_20260723140601.json" : "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140715/easy_client_20260723140715.json";
        }
        if (qg(pkVar) || w(pkVar) || l(pkVar)) {
            return zN ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140150/easy_client_20260723140150.json" : "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/easy_show/easy_client_20260723140428/easy_client_20260723140428.json";
        }
        return null;
    }

    public static com.byazt.ts.n tj(pk pkVar) {
        return qg(pkVar, false);
    }

    public static com.byazt.ts.n cp(pk pkVar) {
        return qg(pkVar, true);
    }

    private static com.byazt.ts.n qg(pk pkVar, boolean z) {
        if (!q(pkVar) && !n(pkVar)) {
            return new com.byazt.ts.n.C0356n().s(k(pkVar)).n();
        }
        com.byazt.ts.n.C0356n c0356nN = n(pkVar, z);
        JSONObject jSONObjectPv = pkVar.pv();
        if (jSONObjectPv != null) {
            try {
                jSONObjectPv.put(TapEventParamConstants.PARAM_SUB_OS, "android");
            } catch (JSONException unused) {
            }
        }
        c0356nN.n(jSONObjectPv);
        return c0356nN.n();
    }

    public static com.byazt.ts.n n(pk pkVar, JSONObject jSONObject) {
        com.byazt.ts.n.C0356n c0356nN = n(pkVar, false);
        if (jSONObject != null) {
            try {
                jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "android");
            } catch (JSONException unused) {
            }
        }
        c0356nN.n(jSONObject);
        return c0356nN.n();
    }

    private static String k(pk pkVar) {
        List<v> listJo;
        if (pkVar == null || (listJo = pkVar.jo()) == null || listJo.size() <= 0) {
            return null;
        }
        return listJo.get(0).n();
    }

    public static void n(JSONObject jSONObject, pk pkVar) {
        if (jSONObject != null) {
            if (n(pkVar) || q(pkVar)) {
                try {
                    jSONObject.put("dynamic_join_type", pkVar.ds());
                    String strPk = pkVar.pk();
                    if (TextUtils.isEmpty(strPk)) {
                        return;
                    }
                    jSONObject.put("union_template_id", new JSONObject(strPk).optString("template_id"));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static void n(boolean z, com.byazt.vh.rv.n nVar) {
        JSONObject jSONObjectW;
        if (nVar == null || (jSONObjectW = nVar.w()) == null || !TextUtils.equals("${image[0].url}", jSONObjectW.optString("src"))) {
            return;
        }
        try {
            if (z) {
                jSONObjectW.put("type", "UpieImage");
            } else {
                jSONObjectW.put(TapEventParamConstants.PARAM_NAME, "UpieImage");
            }
        } catch (JSONException unused) {
        }
        nVar.qg("UpieImage");
    }

    public static void n(final ImageView imageView, final UpieImageView upieImageView) {
        if (imageView == null || upieImageView == null) {
            return;
        }
        qg.n(new Runnable() { // from class: com.byazt.aci.n.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.aci.n.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width <= 90 || height <= 90) {
                            return;
                        }
                        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        n.s(imageView, upieImageView);
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.aci.n.1.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        if (imageView == view) {
                            imageView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(ImageView imageView, UpieImageView upieImageView) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int i = 0;
            while (true) {
                if (i >= viewGroup.getChildCount()) {
                    i = -1;
                    break;
                } else if (imageView == viewGroup.getChildAt(i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams2.gravity = 17;
                    layoutParams = layoutParams2;
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(imageView.getWidth(), imageView.getHeight());
                }
                viewGroup.addView(upieImageView, i, layoutParams);
                viewGroup.removeView(imageView);
            }
        }
    }

    public static com.byazt.wt.n d(final pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return new com.byazt.wt.n() { // from class: com.byazt.aci.n.2
            @Override // com.byazt.wt.n
            public void n(Map<String, Object> map) {
                com.byazt.eji.s.n().n(pkVar, map.get(MediationConstant.EXTRA_DURATION));
            }

            @Override // com.byazt.wt.n
            public void n(int i, String str) {
                com.byazt.eji.s.n().qg(pkVar, i, str);
            }
        };
    }
}

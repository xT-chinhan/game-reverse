package com.byazt.li;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.gct.g;
import com.byazt.gct.pk;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.nf.rv;
import com.byazt.ou.l;
import com.byazt.rg.q;
import com.byazt.vgx.w;
import com.byazt.vh.cy;
import com.byazt.xz.x;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2442, 19})
public class n {
    public static volatile n n;

    private n() {
    }

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

    public boolean n(cy cyVar, pk pkVar, Context context, com.byazt.ih.s sVar, JSONObject jSONObject, qg qgVar, Map<String, Object> map) {
        s sVarN = s.n(cyVar, jSONObject, map);
        if (qgVar == null || !qgVar.n(sVarN.n(), sVar, sVarN)) {
            return n(sVarN, pkVar, context, sVar, qgVar);
        }
        return true;
    }

    public boolean n(x.n nVar, pk pkVar, Context context, com.byazt.ih.s sVar, JSONObject jSONObject, qg qgVar, Map<String, Object> map) {
        s sVarN = s.n(nVar, jSONObject, map);
        sVarN.n("v3_trigger_name");
        if (qgVar == null || !qgVar.n(sVarN.n(), sVar, sVarN)) {
            return n(sVarN, pkVar, context, sVar, qgVar);
        }
        return true;
    }

    private boolean n(s sVar, pk pkVar, Context context, com.byazt.ih.s sVar2, qg qgVar) {
        String strN = sVar != null ? sVar.n() : "";
        strN.hashCode();
        boolean z = false;
        switch (strN) {
            case "openAppPermission":
                q(pkVar, context);
                break;
            case "stopHaptic":
                n(context);
                break;
            case "openCommonUrl":
                n(sVar, context);
                break;
            case "renderScene":
                n(sVar, sVar2, pkVar, qgVar);
                break;
            case "openAppRegistration":
                w(pkVar, context);
                break;
            case "openNewAdPage":
                n(sVar, pkVar, context);
                break;
            case "haptic":
            case "playHaptic":
                n(sVar, context, pkVar);
                break;
            case "uchain":
                qg(sVar, pkVar, context);
                break;
            case "execEffect":
                n(sVar, sVar2);
                break;
            case "clickEvent":
            case "convert":
                n(sVar2, pkVar, context);
                break;
            case "openPrivacy":
            case "openPolicy":
                qg(pkVar, context);
                break;
            case "openAppFunctionDesc":
            case "openAppFunction":
                l(pkVar, context);
                break;
            case "resumeVideo":
                n(pkVar, false);
                break;
            case "pauseVideo":
                n(pkVar, true);
                break;
            case "ugen_view_visibility_tracker":
                n(sVar, pkVar);
                break;
            case "dismissScene":
                q(sVar2);
                break;
            case "muteVideo":
                n(pkVar);
                break;
            case "openAppPolicy":
                s(pkVar, context);
                break;
            case "dislike":
                n(pkVar, context);
                break;
            case "dismiss":
                n(sVar2);
                break;
            case "reloadWebView":
                qg(sVar2);
                break;
            default:
                if (z && qgVar != null) {
                    qgVar.n(strN);
                }
                return z;
        }
        z = true;
        if (z) {
            qgVar.n(strN);
        }
        return z;
    }

    private void n(com.byazt.ih.s sVar, pk pkVar, Context context) {
        com.byazt.ru.n.n(sVar != null ? sVar.rv() : null, pkVar, context);
    }

    private void n(pk pkVar) {
        NativeVideoTsView nativeVideoTsView;
        if (pkVar == null || (nativeVideoTsView = (NativeVideoTsView) com.byazt.ikv.qg.s(pkVar.ih(), NativeVideoTsView.class)) == null) {
            return;
        }
        boolean z = !nativeVideoTsView.cd();
        nativeVideoTsView.n(z, true);
        nativeVideoTsView.setIsQuiet(z);
    }

    private void n(pk pkVar, boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (pkVar == null || (nativeVideoTsView = (NativeVideoTsView) com.byazt.ikv.qg.s(pkVar.ih(), NativeVideoTsView.class)) == null) {
            return;
        }
        nativeVideoTsView.setPlayState(z);
    }

    private void n(pk pkVar, Context context) {
        if (pkVar == null) {
            return;
        }
        Dialog dialog = (Dialog) com.byazt.ikv.qg.s(pkVar.ih(), Dialog.class);
        com.byazt.wg.qg qgVar = (com.byazt.wg.qg) com.byazt.ikv.qg.s(pkVar.ih(), com.byazt.wg.qg.class);
        if (dialog != null) {
            dialog.show();
        } else if (qgVar != null) {
            qgVar.n();
        } else {
            TTDelegateActivity.n(context, pkVar);
        }
    }

    private void n(com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        q.q(sVar.rv());
    }

    private void qg(com.byazt.ih.s sVar) {
        com.byazt.ih.s sVarQg;
        if (sVar == null || (sVarQg = sVar.qg(sVar)) == null) {
            return;
        }
        s(sVarQg);
    }

    private void s(com.byazt.ih.s sVar) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        if (sVar instanceof com.byazt.il.n) {
            ((com.byazt.il.n) sVar).fs();
        }
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
    }

    private void qg(pk pkVar, Context context) {
        if (pkVar == null || context == null) {
            return;
        }
        com.byazt.okk.n.n(context, pkVar);
    }

    private void s(pk pkVar, Context context) {
        if (pkVar == null || context == null) {
            return;
        }
        com.byazt.okk.n.qg(pkVar, context, w.qg(pkVar));
    }

    private void q(pk pkVar, Context context) {
        if (pkVar == null || context == null) {
            return;
        }
        com.byazt.okk.n.s(pkVar, context, w.qg(pkVar));
    }

    private void l(pk pkVar, Context context) {
        if (pkVar == null || context == null) {
            return;
        }
        com.byazt.okk.n.n(context, pkVar, w.qg(pkVar));
    }

    private void w(pk pkVar, Context context) {
        if (pkVar == null || context == null) {
            return;
        }
        com.byazt.okk.n.n(pkVar, context, w.qg(pkVar));
    }

    private void n(s sVar, Context context) {
        if (sVar == null) {
            return;
        }
        String strN = sVar.n("webUrl");
        String strN2 = sVar.n("webTitle");
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        TTDelegateActivity.q(context, strN, strN2);
    }

    private void n(s sVar, Context context, pk pkVar) {
        if (sVar == null) {
            return;
        }
        JSONObject jSONObjectQg = sVar.qg("params");
        String strN = sVar.n("id");
        JSONArray jSONArrayS = sVar.s("pattern");
        if (jSONObjectQg != null) {
            com.byazt.bz.s.n(jSONObjectQg, context, pkVar);
        } else {
            com.byazt.bz.s.n(strN, jSONArrayS, context, pkVar);
        }
    }

    private void n(Context context) {
        if (context == null) {
            context = rv.getContext();
        }
        if (context == null) {
            return;
        }
        com.byazt.bz.s.qg(context);
    }

    private void n(s sVar, com.byazt.ih.s sVar2) {
        com.byazt.ih.s sVarQg;
        if (sVar == null || sVar2 == null) {
            return;
        }
        String strN = sVar.n("id");
        int iN = sVar.n("col", 4);
        int iN2 = sVar.n("row", 3);
        int iN3 = sVar.n(MediationConstant.EXTRA_DURATION, 600);
        if (TextUtils.isEmpty(strN) || (sVarQg = sVar2.qg(sVar2)) == null) {
            return;
        }
        com.byazt.ih.s sVarQ = sVarQg.q(strN);
        if (sVarQ instanceof com.byazt.ty.n) {
            ((com.byazt.ty.n) sVarQ).n(iN, iN2, iN3);
        }
    }

    private void n(s sVar, com.byazt.ih.s sVar2, pk pkVar, qg qgVar) {
        View viewRv;
        g gVarN;
        if (sVar == null || sVar2 == null) {
            return;
        }
        String strN = sVar.n("scene");
        String strN2 = sVar.n("ugen_id");
        String strN3 = sVar.n("ugen_md5");
        String strN4 = sVar.n("ugen_url");
        int iN = sVar.n("displayAreaAndroid", 0);
        int iN2 = sVar.n("render_sequence", 2);
        if (!TextUtils.equals("scene1", strN) || !q.n(iN) || (viewRv = sVar2.rv()) == null || pkVar == null || (gVarN = q.n(strN2, strN3, strN4, iN, iN2, 5)) == null || !gVarN.k()) {
            return;
        }
        new l(pkVar, null, gVarN, qgVar).n(viewRv);
    }

    private void q(com.byazt.ih.s sVar) {
        q.n(sVar.rv(), "fullscreen_tag");
    }

    private void n(s sVar, pk pkVar, Context context) {
        if (sVar == null || pkVar == null) {
            return;
        }
        new com.byazt.pnj.n(pkVar, context).n(sVar.n("second_page_type", 0), pkVar.xd());
    }

    private void qg(s sVar, pk pkVar, Context context) {
        HashMap map = new HashMap();
        map.put("material_meta", pkVar);
        map.put("context", context);
        map.put("event_tag", w.qg(pkVar));
        com.byazt.ukb.qg.n(pkVar, (HashMap<String, Object>) map, sVar);
    }

    private void n(s sVar, pk pkVar) {
        if (sVar == null || pkVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : sVar.qg().keySet()) {
                jSONObject.put(str, sVar.n(str));
            }
        } catch (JSONException unused) {
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("material_meta", pkVar);
        HashMap map3 = new HashMap();
        map3.put("ugen_event_params", jSONObject);
        String strQg = w.qg(pkVar);
        w.ur();
        com.byazt.ukb.qg.n(pkVar, map, "ugen_view_visibility_tracker", map2, strQg, map3, -1L);
    }
}

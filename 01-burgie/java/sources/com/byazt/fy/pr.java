package com.byazt.fy;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.ch.nt;
import com.byazt.dd.fw;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.uq.x;
import com.byazt.wt.c;
import com.byazt.wt.ls;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 967, 37})
public class pr {
    public static volatile pr pr;

    private pr() {
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    public boolean pr(nt ntVar, of ofVar, Context context, com.byazt.ik.hn hnVar, JSONObject jSONObject, hw hwVar, Map<String, Object> map) {
        hn hnVarPr = hn.pr(ntVar, jSONObject, map);
        if (hwVar != null && hwVar.pr(hnVarPr.pr(), hnVar, hnVarPr)) {
            return true;
        }
        return pr(hnVarPr, ofVar, context, hnVar, hwVar);
    }

    public boolean pr(fw.pr prVar, of ofVar, Context context, com.byazt.ik.hn hnVar, JSONObject jSONObject, hw hwVar, Map<String, Object> map) {
        hn hnVarPr = hn.pr(prVar, jSONObject, map);
        hnVarPr.pr("v3_trigger_name");
        if (hwVar != null && hwVar.pr(hnVarPr.pr(), hnVar, hnVarPr)) {
            return true;
        }
        return pr(hnVarPr, ofVar, context, hnVar, hwVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean pr(hn hnVar, of ofVar, Context context, com.byazt.ik.hn hnVar2, hw hwVar) {
        String strPr = hnVar != null ? hnVar.pr() : "";
        byte b = -1;
        boolean z = false;
        switch (strPr.hashCode()) {
            case -1822902106:
                if (strPr.equals("openAppPermission")) {
                    b = 8;
                }
                break;
            case -1681588935:
                if (strPr.equals("stopHaptic")) {
                    b = cc.m;
                }
                break;
            case -1657551782:
                if (strPr.equals("openCommonUrl")) {
                    b = 12;
                }
                break;
            case -1639156586:
                if (strPr.equals("renderScene")) {
                    b = 17;
                }
                break;
            case -1597668912:
                if (strPr.equals("openAppRegistration")) {
                    b = 11;
                }
                break;
            case -1298570264:
                if (strPr.equals("openNewAdPage")) {
                    b = 19;
                }
                break;
            case -1224502633:
                if (strPr.equals("haptic")) {
                    b = cc.k;
                }
                break;
            case -850733204:
                if (strPr.equals("uchain")) {
                    b = 20;
                }
                break;
            case -847712894:
                if (strPr.equals("execEffect")) {
                    b = cc.n;
                }
                break;
            case -800853518:
                if (strPr.equals("clickEvent")) {
                    b = 0;
                }
                break;
            case -511324706:
                if (strPr.equals("openPrivacy")) {
                    b = 6;
                }
                break;
            case -459025504:
                if (strPr.equals("openAppFunctionDesc")) {
                    b = 9;
                }
                break;
            case 257906716:
                if (strPr.equals("openPolicy")) {
                    b = 5;
                }
                break;
            case 270575969:
                if (strPr.equals("ugen_view_visibility_tracker")) {
                    b = 21;
                }
                break;
            case 293548143:
                if (strPr.equals("openAppFunction")) {
                    b = 10;
                }
                break;
            case 421035042:
                if (strPr.equals("dismissScene")) {
                    b = 18;
                }
                break;
            case 951590323:
                if (strPr.equals("convert")) {
                    b = 1;
                }
                break;
            case 1151744482:
                if (strPr.equals("muteVideo")) {
                    b = 2;
                }
                break;
            case 1237425033:
                if (strPr.equals("openAppPolicy")) {
                    b = 7;
                }
                break;
            case 1250743019:
                if (strPr.equals("playHaptic")) {
                    b = cc.l;
                }
                break;
            case 1671642405:
                if (strPr.equals(com.byazt.pfl.hw.AD_TAG_DISLIKE)) {
                    b = 3;
                }
                break;
            case 1671672458:
                if (strPr.equals("dismiss")) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                pr(hnVar2, ofVar, context);
                z = true;
                break;
            case 2:
                pr(ofVar);
                z = true;
                break;
            case 3:
                pr(ofVar, context);
                z = true;
                break;
            case 4:
                pr(hnVar2);
                z = true;
                break;
            case 5:
            case 6:
                hw(ofVar, context);
                z = true;
                break;
            case 7:
                hn(ofVar, context);
                z = true;
                break;
            case 8:
                x(ofVar, context);
                z = true;
                break;
            case 9:
            case 10:
                c(ofVar, context);
                z = true;
                break;
            case 11:
                uc(ofVar, context);
                z = true;
                break;
            case 12:
                pr(hnVar, context);
                z = true;
                break;
            case 13:
            case 14:
                pr(hnVar, context, ofVar);
                z = true;
                break;
            case 15:
                pr(context);
                z = true;
                break;
            case 16:
                pr(hnVar, hnVar2);
                z = true;
                break;
            case 17:
                pr(hnVar, hnVar2, ofVar);
                z = true;
                break;
            case 18:
                hw(hnVar2);
                z = true;
                break;
            case 19:
                pr(hnVar, ofVar, context);
                z = true;
                break;
            case 20:
                hw(hnVar, ofVar, context);
                z = true;
                break;
            case 21:
                pr(hnVar, ofVar);
                z = true;
                break;
        }
        if (z && hwVar != null) {
            hwVar.pr(strPr);
        }
        return z;
    }

    private void pr(com.byazt.ik.hn hnVar, of ofVar, Context context) {
        com.byazt.xb.pr.pr(hnVar != null ? hnVar.aj() : null, ofVar, context);
    }

    private void pr(of ofVar) {
        NativeVideoTsView nativeVideoTsView;
        if (ofVar == null || (nativeVideoTsView = (NativeVideoTsView) cz.hn(ofVar.le(), NativeVideoTsView.class)) == null) {
            return;
        }
        boolean z = !nativeVideoTsView.nt();
        nativeVideoTsView.hw(z, true);
        nativeVideoTsView.setIsQuiet(z);
    }

    private void pr(of ofVar, Context context) {
        if (ofVar == null) {
            return;
        }
        Dialog dialog = (Dialog) cz.hn(ofVar.le(), Dialog.class);
        com.byazt.pfl.hw hwVar = (com.byazt.pfl.hw) cz.hn(ofVar.le(), com.byazt.pfl.hw.class);
        if (dialog != null) {
            dialog.show();
        } else if (hwVar != null) {
            hwVar.pr();
        } else {
            TTDelegateActivity.pr(context, ofVar);
        }
    }

    private void pr(com.byazt.ik.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        x.x(hnVar.aj());
    }

    private void hw(of ofVar, Context context) {
        if (ofVar == null || context == null) {
            return;
        }
        c.pr(context, ofVar);
    }

    private void hn(of ofVar, Context context) {
        if (ofVar == null || context == null) {
            return;
        }
        c.hw(ofVar, context, ls.hw(ofVar));
    }

    private void x(of ofVar, Context context) {
        if (ofVar == null || context == null) {
            return;
        }
        c.hn(ofVar, context, ls.hw(ofVar));
    }

    private void c(of ofVar, Context context) {
        if (ofVar == null || context == null) {
            return;
        }
        c.pr(context, ofVar, ls.hw(ofVar));
    }

    private void uc(of ofVar, Context context) {
        if (ofVar == null || context == null) {
            return;
        }
        c.pr(ofVar, context, ls.hw(ofVar));
    }

    private void pr(hn hnVar, Context context) {
        if (hnVar == null) {
            return;
        }
        String strPr = hnVar.pr("webUrl");
        String strPr2 = hnVar.pr("webTitle");
        if (!TextUtils.isEmpty(strPr)) {
            TTDelegateActivity.x(context, strPr, strPr2);
        }
    }

    private void pr(hn hnVar, Context context, of ofVar) {
        if (hnVar == null) {
            return;
        }
        JSONObject jSONObjectHw = hnVar.hw("params");
        String strPr = hnVar.pr("id");
        JSONArray jSONArrayHn = hnVar.hn("pattern");
        if (jSONObjectHw != null) {
            com.byazt.tm.hn.pr(jSONObjectHw, context, ofVar);
        } else {
            com.byazt.tm.hn.pr(strPr, jSONArrayHn, context, ofVar);
        }
    }

    private void pr(Context context) {
        if (context == null) {
            context = a.getContext();
        }
        if (context == null) {
            return;
        }
        com.byazt.tm.hn.hw(context);
    }

    private void pr(hn hnVar, com.byazt.ik.hn hnVar2) {
        com.byazt.ik.hn hnVarHw;
        if (hnVar == null || hnVar2 == null) {
            return;
        }
        String strPr = hnVar.pr("id");
        int iPr = hnVar.pr("col", 4);
        int iPr2 = hnVar.pr("row", 3);
        int iPr3 = hnVar.pr("duration", 600);
        if (TextUtils.isEmpty(strPr) || (hnVarHw = hnVar2.hw(hnVar2)) == null) {
            return;
        }
        com.byazt.ik.hn hnVarX = hnVarHw.x(strPr);
        if (hnVarX instanceof com.byazt.ny.pr) {
            ((com.byazt.ny.pr) hnVarX).pr(iPr, iPr2, iPr3);
        }
    }

    private void pr(hn hnVar, com.byazt.ik.hn hnVar2, of ofVar) {
        View viewAj;
        bh bhVarPr;
        if (hnVar == null || hnVar2 == null) {
            return;
        }
        String strPr = hnVar.pr("scene");
        String strPr2 = hnVar.pr("ugen_id");
        String strPr3 = hnVar.pr("ugen_md5");
        String strPr4 = hnVar.pr("ugen_url");
        int iPr = hnVar.pr("displayAreaAndroid", 0);
        int iPr2 = hnVar.pr("render_sequence", 2);
        if (!TextUtils.equals("scene1", strPr) || !x.pr(iPr) || (viewAj = hnVar2.aj()) == null || ofVar == null || (bhVarPr = x.pr(strPr2, strPr3, strPr4, iPr, iPr2, 5)) == null || !bhVarPr.k()) {
            return;
        }
        new com.byazt.tg.c(ofVar, null, bhVarPr).pr(viewAj);
    }

    private void hw(com.byazt.ik.hn hnVar) {
        x.pr(hnVar.aj(), "fullscreen_tag");
    }

    private void pr(hn hnVar, of ofVar, Context context) {
        if (hnVar == null || ofVar == null) {
            return;
        }
        new com.byazt.tt.pr(ofVar, context).pr(hnVar.pr("second_page_type", 0), ofVar.p());
    }

    private void hw(hn hnVar, of ofVar, Context context) {
        HashMap map = new HashMap();
        map.put("material_meta", ofVar);
        map.put(d.R, context);
        map.put("event_tag", ls.hw(ofVar));
        com.byazt.lx.hw.pr(ofVar, (HashMap<String, Object>) map, hnVar);
    }

    private void pr(hn hnVar, of ofVar) {
        if (hnVar == null || ofVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : hnVar.hw().keySet()) {
                jSONObject.put(str, hnVar.pr(str));
            }
        } catch (JSONException e) {
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("material_meta", ofVar);
        HashMap map3 = new HashMap();
        map3.put("ugen_event_params", jSONObject);
        String strHw = ls.hw(ofVar);
        ls.ve();
        com.byazt.lx.hw.pr(ofVar, map, "ugen_view_visibility_tracker", map2, strHw, map3, -1L);
    }
}

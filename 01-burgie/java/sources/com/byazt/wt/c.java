package com.byazt.wt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static com.byazt.sd.g hw;
    public static final Map<String, pr> pr = Collections.synchronizedMap(new HashMap());

    public interface pr {
        void hn();

        void hw();

        void pr();
    }

    public static void pr(Context context, String str, String str2, String str3, pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        pr(str, prVar);
        TTDelegateActivity.pr(context, str, str2, str3);
    }

    public static void pr(final Context context, final String str, final String str2, final String str3, final pr prVar, final com.byazt.sa.fw fwVar, final of ofVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.wt.c.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zPr = com.byazt.sd.zo.nt().pr(true);
                if (!com.byazt.iy.hw.pr()) {
                    if (c.pr.containsKey(str)) {
                        return;
                    }
                    if (!ls.x() && !zPr) {
                        return;
                    }
                }
                c.pr(str, prVar);
                TTDelegateActivity.pr(context, str, str2, str3, fwVar, ofVar);
            }
        });
    }

    public static void pr(final Context context, final String str, final String str2, final String str3, final pr prVar, final of ofVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.wt.c.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zPr = com.byazt.sd.zo.nt().pr(true);
                if (!com.byazt.iy.hw.pr()) {
                    if (c.pr.containsKey(str)) {
                        return;
                    }
                    if (!ls.x() && !zPr) {
                        return;
                    }
                }
                c.pr(str, prVar);
                TTDelegateActivity.pr(context, str, str2, str3, ofVar);
            }
        });
    }

    public static void pr(String str) {
        Map<String, pr> map = pr;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void pr(Context context, String str, pr prVar, String str2, of ofVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        pr(str, prVar);
        TTDelegateActivity.pr(context, str, str2, ofVar);
    }

    public static void pr(final of ofVar, String str, final Context context, final String str2) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ofVar.xy();
        }
        pr(context, ofVar.x(), new pr() { // from class: com.byazt.wt.c.3
            @Override // com.byazt.wt.c.pr
            public void pr() {
                c.x(ofVar, context, str2);
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
            }
        }, str, ofVar);
    }

    public static void pr(of ofVar, Context context, String str) {
        pr(ofVar, hw(ofVar), context, str);
    }

    public static void pr(Context context, String str, pr prVar, String str2) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        pr(str, prVar);
        TTDelegateActivity.hw(context, str, str2);
    }

    public static void hw(final of ofVar, String str, final Context context, final String str2) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ofVar.xy();
        }
        pr(context, ofVar.x(), new pr() { // from class: com.byazt.wt.c.4
            @Override // com.byazt.wt.c.pr
            public void pr() {
                c.x(ofVar, context, str2);
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
            }
        }, str);
    }

    public static void hw(of ofVar, Context context, String str) {
        hw(ofVar, hw(ofVar), context, str);
    }

    public static void pr(Context context, String str, String str2, pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        pr(str, prVar);
        TTDelegateActivity.pr(context, str, str2);
    }

    public static void hn(final of ofVar, String str, final Context context, final String str2) {
        if (ofVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ofVar.xy();
        }
        pr(context, ofVar.x(), str, new pr() { // from class: com.byazt.wt.c.5
            @Override // com.byazt.wt.c.pr
            public void pr() {
                c.x(ofVar, context, str2);
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
            }
        });
    }

    public static void hn(of ofVar, Context context, String str) {
        hn(ofVar, hw(ofVar), context, str);
    }

    public static void pr(Context context, of ofVar, String str) {
        pr(context, hn(ofVar), ofVar, str);
    }

    public static void pr(final Context context, String str, final of ofVar, final String str2) {
        if (ofVar == null) {
            return;
        }
        String strX = ofVar.x();
        if (TextUtils.isEmpty(strX)) {
            return;
        }
        pr(strX, new pr() { // from class: com.byazt.wt.c.6
            @Override // com.byazt.wt.c.pr
            public void pr() {
                c.x(ofVar, context, str2);
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
            }
        });
        com.byazt.hg.uc ucVarLb = ofVar.lb();
        if (TextUtils.isEmpty(str)) {
            if (ucVarLb != null) {
                str = ucVarLb.aj();
            } else {
                return;
            }
        }
        TTDelegateActivity.hn(context, strX, str);
    }

    public static void hw(Context context, String str, String str2, pr prVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        pr(str2, prVar);
        TTDelegateActivity.hn(context, str2, str);
    }

    public static void pr(Context context, String str) {
        TTDelegateActivity.pr(context, str);
        com.byazt.xk.hw.pr().pr(str);
    }

    private static String hw(of ofVar) {
        com.byazt.hg.x xVarPr = com.byazt.jx.pr.pr(ofVar);
        if (xVarPr != null) {
            return xVarPr.zo();
        }
        return null;
    }

    private static String hn(of ofVar) {
        com.byazt.hg.x xVarPr = com.byazt.jx.pr.pr(ofVar);
        if (xVarPr != null && !TextUtils.isEmpty(xVarPr.c())) {
            return xVarPr.c();
        }
        return null;
    }

    public static void x(of ofVar, Context context, String str) {
        int iK = com.byazt.hg.qa.k(ofVar);
        if (ofVar != null && context != null) {
            if (ofVar.aj() != 4 && iK == 0) {
                return;
            }
            com.byazt.ri.pr prVarPr = com.byazt.jx.zo.pr(context, ofVar, str);
            if (prVarPr instanceof com.byazt.ri.pr) {
                prVarPr.fw().pr(false);
            }
            prVarPr.pr(ofVar, false);
        }
    }

    public static void pr(Context context, String str, String str2, String str3, String str4, String str5, pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        pr(str, prVar);
        TTDelegateActivity.pr(context, str, str2, str3, str4, str5);
    }

    public static void pr(Context context, String str, boolean z, pr prVar) {
        if (z) {
            TTDelegateActivity.pr(context, str, z);
        } else {
            if (TextUtils.isEmpty(str) || prVar == null) {
                return;
            }
            pr(str, prVar);
            TTDelegateActivity.pr(context, str, z);
        }
    }

    public static void hw(String str) {
        pr(str, 1);
    }

    public static void hn(String str) {
        pr(str, 2);
    }

    public static void x(String str) {
        pr(str, 3);
    }

    public static void pr(final String str, final pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        if (com.byazt.iy.hw.pr()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("addDialogListener") { // from class: com.byazt.wt.c.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.hn().pr(str, new com.byazt.ku.pr(prVar));
                    } catch (Throwable th) {
                    }
                }
            }, 5);
        } else {
            pr.put(str, prVar);
        }
    }

    public static pr c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return pr.remove(str);
    }

    private static void pr(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
        }
        if (com.byazt.iy.hw.pr()) {
            com.byazt.xlm.c.hw(new com.byazt.xlm.fw("doHandler") { // from class: com.byazt.wt.c.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.hn().pr(str, i);
                    } catch (Throwable th) {
                    }
                }
            }, 5);
            return;
        }
        pr prVarC = c(str);
        if (prVarC == null) {
            return;
        }
        switch (i) {
            case 1:
                prVarC.pr();
                break;
            case 2:
                prVarC.hw();
                break;
            case 3:
                prVarC.hn();
                break;
            default:
                prVarC.hn();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.sd.g hn() {
        if (hw == null) {
            hw = com.byazt.us.hn.pr(com.byazt.gt.pr.pr(com.byazt.sd.a.getContext()).pr(2));
        }
        return hw;
    }

    public static void pr(Context context, String str, of ofVar) {
        TTDelegateActivity.pr(context, str, ofVar);
    }

    public static void pr(Context context, final of ofVar) {
        if (ofVar == null) {
            return;
        }
        com.byazt.pj.pr.pr(ofVar, "pangle_logo", "open_policy", new com.byazt.ttf.pr() { // from class: com.byazt.wt.c.9
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", ofVar.td());
                jSONObject2.put("ad_slot_type", ls.k(ofVar));
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                return jSONObject2;
            }
        });
        TTDelegateActivity.hw(context, ofVar.td());
    }

    public static boolean pr(of ofVar) {
        if (ofVar == null || ofVar.C_() || ofVar.z_() == null || com.byazt.hg.qa.vk(ofVar) == 1 || ofVar.aj() != 4 || com.byazt.hg.qa.aj(ofVar) == 0) {
            return false;
        }
        int iIe = ofVar.ie();
        return iIe == 4 || iIe == 5;
    }
}

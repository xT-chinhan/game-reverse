package com.byazt.ea;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.hcx.m;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.hg.rc;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.byazt.wt.y;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.constants.BundleKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 109})
public class w {
    public static int pr(of ofVar) {
        com.byazt.ze.pr prVarSv;
        JSONObject jSONObjectHn;
        int iOptInt;
        if (ofVar == null || (prVarSv = ofVar.sv()) == null || (jSONObjectHn = prVarSv.hn()) == null || (iOptInt = jSONObjectHn.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return iOptInt;
    }

    public static boolean hw(of ofVar) {
        com.byazt.ze.pr prVarSv;
        JSONObject jSONObjectHn;
        if (ofVar == null || (prVarSv = ofVar.sv()) == null || (jSONObjectHn = prVarSv.hn()) == null || jSONObjectHn.optInt("reward_slide_type", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean hn(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        int iVj = ofVar.vj();
        com.byazt.qk.pr prVarMw = ofVar.mw();
        if (prVarMw == null || iVj != 1 || prVarMw.x() != 4) {
            return false;
        }
        return true;
    }

    public static boolean x(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        int iVj = ofVar.vj();
        com.byazt.qk.pr prVarMw = ofVar.mw();
        if (prVarMw == null || iVj != 1 || prVarMw.x() != 3) {
            return false;
        }
        return true;
    }

    public static boolean c(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        int iVj = ofVar.vj();
        com.byazt.qk.pr prVarMw = ofVar.mw();
        if (prVarMw == null || iVj != 1 || prVarMw.x() != 2) {
            return false;
        }
        return true;
    }

    public static boolean uc(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        return fw(ofVar) || zo(ofVar);
    }

    public static boolean fw(of ofVar) {
        return (ofVar == null || ofVar.vj() != 1 || lb.pr(ofVar)) ? false : true;
    }

    public static boolean zo(of ofVar) {
        return ofVar != null && ofVar.ie() > 0;
    }

    public static JSONObject pr(of ofVar, View view, boolean z) {
        JSONObject jSONObject = ofVar.to();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            boolean z2 = false;
            jSONObject2.put("voice_control", ofVar.ax() == 1);
            Context context = a.getContext();
            jSONObject4.put("width", er.x(context, er.c(context)));
            jSONObject4.put("height", er.x(context, er.uc(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("width", er.x(context, width) * 1.0f);
                jSONObject5.put("height", er.x(context, height) * 1.0f);
                jSONObject3.put("content_size", jSONObject5);
            }
            jSONObject3.put("screen_size", jSONObject4);
            jSONObject.put("env_info", jSONObject3);
            jSONObject.put("setting", jSONObject2);
            jSONObject.put("meta_hashcode", ofVar.nl());
            if (z && a.hw().ok()) {
                z2 = true;
            }
            jSONObject.put("gesture_through_enable", z2);
            jSONObject.put("is_adapt_two_finger", a.hw().xd());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(final boolean z, final String str, final hn hnVar) {
        if (hnVar != null) {
            com.byazt.ca.aj.hw().post(new com.byazt.xlm.fw("tt_ugen_tpl") { // from class: com.byazt.ea.w.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        hnVar.pr(str);
                    } else {
                        hnVar.pr();
                    }
                }
            });
        }
    }

    private static void hw(String str, final String str2, final hn hnVar) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            hw(false, (String) null, hnVar);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.byazt.tf.hn.hw(str).pr(new com.byazt.hcx.fw() { // from class: com.byazt.ea.w.2
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar != null) {
                    try {
                        if (mVar.fw() && mVar.zo() != null) {
                            com.byazt.cr.c cVarPr = y.pr("ugeno_template_kv");
                            String strZo = mVar.zo();
                            cVarPr.pr(str2, strZo);
                            w.hw(true, strZo, hnVar);
                            return;
                        }
                    } catch (Exception e) {
                        w.hw(false, (String) null, hnVar);
                        return;
                    }
                }
                w.hw(false, (String) null, hnVar);
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str3, Throwable th) {
                w.hw(false, (String) null, hnVar);
            }
        });
    }

    public static boolean aj(of ofVar) {
        if (ofVar == null || ofVar.eu() == null) {
            return false;
        }
        return true;
    }

    public static boolean pr(Context context, of ofVar, String str) {
        return hw(context, ofVar, str) == 1;
    }

    public static int hw(Context context, of ofVar, String str) {
        if (ofVar == null) {
            return -1;
        }
        rc rcVarEu = ofVar.eu();
        if (rcVarEu == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context != null && context.getResources().getConfiguration().orientation != 1) {
            return 9;
        }
        String strHw = rcVarEu.hw();
        if (pr(strHw, rcVarEu.hn(), (hn) null) != null) {
            return 1;
        }
        if (TextUtils.isEmpty(strHw)) {
            return 2;
        }
        return 3;
    }

    public static String pr(Context context, String str, of ofVar, String str2) {
        rc rcVarEu = ofVar.eu();
        JSONObject jSONObjectIg = ofVar.ig();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("icon_url", str2);
            }
            String strJv = ofVar.jv();
            if (!TextUtils.isEmpty(strJv)) {
                jSONObject.put(BundleKey.DESCRIPTION, strJv);
            }
            if (jSONObjectIg != null) {
                jSONObject.put("easy_pl_material", jSONObjectIg.toString());
            }
            if (rcVarEu != null) {
                jSONObject.put("ugen_dialog_url", rcVarEu.hw());
                jSONObject.put("ugen_dialog_md5", rcVarEu.hn());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", "false");
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static JSONObject pr(String str, String str2, hn hnVar) {
        if (TextUtils.isEmpty(str)) {
            if (hnVar != null) {
                hnVar.pr();
            }
            return null;
        }
        com.byazt.cr.c cVarPr = y.pr("ugeno_template_kv");
        if (cVarPr == null) {
            if (hnVar != null) {
                hnVar.pr();
            }
            return null;
        }
        try {
            String strHw = cVarPr.hw(str2, "");
            if (!TextUtils.isEmpty(strHw)) {
                if (hnVar != null) {
                    hnVar.pr(strHw);
                }
                return new JSONObject(strHw);
            }
            if (TextUtils.isEmpty(str)) {
                if (hnVar != null) {
                    hnVar.pr();
                }
                return null;
            }
            hw(str, str2, hnVar);
            return null;
        } catch (Exception e) {
            if (hnVar != null) {
                hnVar.pr();
            }
        }
    }
}

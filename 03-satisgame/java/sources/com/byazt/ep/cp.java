package com.byazt.ep;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.gct.cd;
import com.byazt.gct.m;
import com.byazt.gct.pk;
import com.byazt.qk.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.constants.BundleKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 29})
public class cp {
    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.gwu.s qg() {
        return com.byazt.lk.l.qg(com.byazt.vgx.s.q(), "ugeno_template_kv", 0, com.byazt.p001if.n.n());
    }

    public static int n(pk pkVar) {
        com.byazt.ul.n nVarFl;
        JSONObject jSONObjectS;
        int iOptInt;
        if (pkVar == null || (nVarFl = pkVar.fl()) == null || (jSONObjectS = nVarFl.s()) == null || (iOptInt = jSONObjectS.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return iOptInt;
    }

    public static boolean qg(pk pkVar) {
        com.byazt.ul.n nVarFl;
        JSONObject jSONObjectS;
        return (pkVar == null || (nVarFl = pkVar.fl()) == null || (jSONObjectS = nVarFl.s()) == null || jSONObjectS.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean s(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        int iEl = pkVar.el();
        com.byazt.ai.n nVarVb = pkVar.vb();
        return nVarVb != null && iEl == 1 && nVarVb.q() == 4;
    }

    public static boolean q(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        int iEl = pkVar.el();
        com.byazt.ai.n nVarVb = pkVar.vb();
        return nVarVb != null && iEl == 1 && nVarVb.q() == 3;
    }

    public static boolean l(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        int iEl = pkVar.el();
        com.byazt.ai.n nVarVb = pkVar.vb();
        return nVarVb != null && iEl == 1 && nVarVb.q() == 2;
    }

    public static boolean w(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        return x(pkVar) || fs(pkVar);
    }

    public static boolean x(pk pkVar) {
        return (pkVar == null || pkVar.el() != 1 || cd.n(pkVar)) ? false : true;
    }

    public static boolean fs(pk pkVar) {
        return pkVar != null && pkVar.cx() > 0;
    }

    public static JSONObject n(pk pkVar, View view, boolean z) {
        JSONObject jSONObjectPv = pkVar.pv();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            boolean z2 = false;
            jSONObject.put("voice_control", pkVar.kj() == 1);
            Context context = com.byazt.nf.rv.getContext();
            jSONObject3.put("width", com.byazt.okk.s.q(context, com.byazt.okk.s.l(context)));
            jSONObject3.put("height", com.byazt.okk.s.q(context, com.byazt.okk.s.w(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", com.byazt.okk.s.q(context, width) * 1.0f);
                jSONObject4.put("height", com.byazt.okk.s.q(context, height) * 1.0f);
                jSONObject2.put("content_size", jSONObject4);
            }
            jSONObject2.put("screen_size", jSONObject3);
            jSONObjectPv.put("env_info", jSONObject2);
            jSONObjectPv.put("setting", jSONObject);
            jSONObjectPv.put("meta_hashcode", pkVar.v());
            if (z && com.byazt.nf.rv.qg().dx()) {
                z2 = true;
            }
            jSONObjectPv.put("gesture_through_enable", z2);
            jSONObjectPv.put("is_adapt_two_finger", com.byazt.nf.rv.qg().kn());
        } catch (JSONException unused) {
        }
        return jSONObjectPv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(final boolean z, final String str, final s sVar) {
        if (sVar != null) {
            com.byazt.tk.rv.qg().post(new com.byazt.qit.x("tt_ugen_tpl") { // from class: com.byazt.ep.cp.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        sVar.n(str);
                    } else {
                        sVar.n();
                    }
                }
            });
        }
    }

    private static void qg(String str, final String str2, final s sVar) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            qg(false, (String) null, sVar);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.byazt.phf.s.qg(str).n(new com.byazt.qk.x() { // from class: com.byazt.ep.cp.2
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar != null) {
                    try {
                        if (oaVar.x() && oaVar.fs() != null) {
                            com.byazt.gwu.s sVarQg = cp.qg();
                            String strFs = oaVar.fs();
                            sVarQg.n(str2, strFs);
                            cp.qg(true, strFs, sVar);
                            return;
                        }
                    } catch (Exception unused) {
                        cp.qg(false, (String) null, sVar);
                        return;
                    }
                }
                cp.qg(false, (String) null, sVar);
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str3, Throwable th) {
                cp.qg(false, (String) null, sVar);
            }
        });
    }

    public static boolean rv(pk pkVar) {
        return (pkVar == null || pkVar.tc() == null) ? false : true;
    }

    public static boolean n(Context context, pk pkVar, String str) {
        return qg(context, pkVar, str) == 1;
    }

    public static int qg(Context context, pk pkVar, String str) {
        if (pkVar == null) {
            return -1;
        }
        m mVarTc = pkVar.tc();
        if (mVarTc == null) {
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
        String strQg = mVarTc.qg();
        if (n(strQg, mVarTc.s(), (s) null) == null) {
            return TextUtils.isEmpty(strQg) ? 2 : 3;
        }
        return 1;
    }

    public static String n(Context context, String str, pk pkVar, String str2) {
        m mVarTc = pkVar.tc();
        JSONObject jSONObjectPb = pkVar.pb();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, str2);
            }
            String strM19if = pkVar.m19if();
            if (!TextUtils.isEmpty(strM19if)) {
                jSONObject.put(BundleKey.DESCRIPTION, strM19if);
            }
            if (jSONObjectPb != null) {
                jSONObject.put("easy_pl_material", jSONObjectPb.toString());
            }
            if (mVarTc != null) {
                jSONObject.put("ugen_dialog_url", mVarTc.qg());
                jSONObject.put("ugen_dialog_md5", mVarTc.s());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", "false");
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static JSONObject n(String str, String str2, s sVar) {
        if (TextUtils.isEmpty(str)) {
            if (sVar != null) {
                sVar.n();
            }
            return null;
        }
        com.byazt.gwu.s sVarQg = qg();
        if (sVarQg == null) {
            if (sVar != null) {
                sVar.n();
            }
            return null;
        }
        try {
            String strQg = sVarQg.qg(str2, "");
            if (!TextUtils.isEmpty(strQg)) {
                if (sVar != null) {
                    sVar.n(strQg);
                }
                return new JSONObject(strQg);
            }
            if (!TextUtils.isEmpty(str)) {
                qg(str, str2, sVar);
                return null;
            }
            if (sVar != null) {
                sVar.n();
            }
            return null;
        } catch (Exception unused) {
            if (sVar != null) {
                sVar.n();
            }
        }
    }
}

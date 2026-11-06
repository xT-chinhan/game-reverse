package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 48})
public class lb {
    public String aj;
    public int c;
    public boolean fw;
    public int hn;
    public int hw;
    public String pr;
    public int uc;
    public int vk;
    public int x;
    public String zo;

    public lb(JSONObject jSONObject) {
        this.hw = 0;
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("reward_browse_type", 0);
            this.hw = iOptInt;
            if (iOptInt < 0 || iOptInt > 3) {
                this.hw = 0;
            }
            if (this.hw == 2) {
                this.hw = 3;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("direct_landing_page_info");
            if (jSONObjectOptJSONObject != null) {
                this.pr = jSONObjectOptJSONObject.optString("direct_landing_url");
                this.hn = jSONObjectOptJSONObject.optInt("display_duration", 0);
                this.x = jSONObjectOptJSONObject.optInt("close_time", 0);
                this.c = jSONObjectOptJSONObject.optInt("page_type");
                this.uc = jSONObjectOptJSONObject.optInt("show_type");
                this.fw = jSONObjectOptJSONObject.optBoolean("is_landing_with_sound", false);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward_browse_banner");
                if (jSONObjectOptJSONObject2 != null) {
                    this.zo = jSONObjectOptJSONObject2.optString("ugen_url");
                    this.aj = jSONObjectOptJSONObject2.optString("ugen_md5");
                }
                this.vk = jSONObjectOptJSONObject.optInt("close_btn_position");
            }
        }
    }

    public void pr(JSONObject jSONObject) {
        try {
            jSONObject.put("reward_browse_type", this.hw);
        } catch (Exception e) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("direct_landing_url", this.pr);
            jSONObject2.put("display_duration", this.hn);
            jSONObject2.put("close_time", this.x);
            jSONObject2.put("page_type", this.c);
            jSONObject2.put("show_type", this.uc);
            jSONObject2.put("close_btn_position", this.vk);
            jSONObject2.put("is_landing_with_sound", this.fw);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ugen_url", this.zo);
            jSONObject3.put("ugen_md5", this.aj);
            jSONObject2.put("reward_browse_banner", jSONObject3);
            jSONObject.put("direct_landing_page_info", jSONObject2);
        } catch (Exception e2) {
        }
    }

    public static boolean pr(of ofVar) {
        lb lbVarLb = lb(ofVar);
        return (lbVarLb == null || vk(ofVar) == 0 || TextUtils.isEmpty(lbVarLb.pr)) ? false : true;
    }

    public static boolean hw(of ofVar) {
        if (pr(ofVar)) {
            return aj(ofVar);
        }
        return false;
    }

    public static boolean hn(of ofVar) {
        lb lbVarLb = lb(ofVar);
        return lbVarLb != null && lbVarLb.hw == 1 && lbVarLb.c == 1;
    }

    public static boolean x(of ofVar) {
        lb lbVarLb = lb(ofVar);
        return lbVarLb != null && pr(ofVar) && lbVarLb.hw == 1 && lbVarLb.c == 2;
    }

    public static boolean c(of ofVar) {
        lb lbVarLb = lb(ofVar);
        if (lbVarLb == null || lbVarLb.c != 4) {
            return false;
        }
        int iK = com.byazt.wt.ls.k(ofVar);
        return iK == 3 || iK == 4 || iK == 5 || iK == 9;
    }

    public static boolean uc(of ofVar) {
        lb lbVarLb = lb(ofVar);
        return lbVarLb != null && lbVarLb.c == 3;
    }

    public static boolean fw(of ofVar) {
        lb lbVarLb = lb(ofVar);
        return lbVarLb != null && lbVarLb.uc == 3;
    }

    public static String zo(of ofVar) {
        lb lbVarLb = lb(ofVar);
        if (lbVarLb == null) {
            return "";
        }
        return lbVarLb.pr;
    }

    public static boolean aj(of ofVar) {
        lb lbVarLb = lb(ofVar);
        if (lbVarLb == null) {
            return false;
        }
        return lbVarLb.fw;
    }

    public static int vk(of ofVar) {
        lb lbVarLb = lb(ofVar);
        if (lbVarLb == null) {
            return 0;
        }
        return lbVarLb.hw;
    }

    private static lb lb(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.ag();
    }

    public static int w(of ofVar) {
        int i;
        lb lbVarLb = lb(ofVar);
        if (lbVarLb != null && (i = lbVarLb.hn) >= 0) {
            return i;
        }
        return 0;
    }

    public static int k(of ofVar) {
        int i;
        lb lbVarLb = lb(ofVar);
        if (lbVarLb == null || (i = lbVarLb.x) < 0) {
            return 0;
        }
        return i;
    }

    public static boolean m(of ofVar) {
        return lb(ofVar) != null && vk(ofVar) == 3 && pr(ofVar);
    }

    public static com.byazt.qk.pr g(of ofVar) {
        lb lbVarLb = lb(ofVar);
        if (lbVarLb == null || TextUtils.isEmpty(lbVarLb.zo)) {
            return null;
        }
        com.byazt.qk.pr prVar = new com.byazt.qk.pr();
        prVar.hn(lbVarLb.zo);
        prVar.hw(lbVarLb.aj);
        prVar.pr(lbVarLb.zo);
        return prVar;
    }

    public static boolean ho(of ofVar) {
        lb lbVarLb = lb(ofVar);
        return lbVarLb != null && lbVarLb.vk == 1;
    }

    public static boolean nt(of ofVar) {
        lb lbVarLb = lb(ofVar);
        return lbVarLb != null && lbVarLb.vk == 2;
    }

    public static int yb(of ofVar) {
        lb lbVarLb = lb(ofVar);
        if (lbVarLb == null) {
            return 0;
        }
        return lbVarLb.vk;
    }
}

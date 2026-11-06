package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 996})
public class f {
    public int c;
    public String hn;
    public int hw;
    public int pr;
    public boolean uc;
    public int x;

    public f(JSONObject jSONObject) {
        this.uc = false;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward_live");
        if (jSONObjectOptJSONObject != null) {
            this.uc = true;
            hw(jSONObjectOptJSONObject.optInt("reward_live_type", 1));
            hn(jSONObjectOptJSONObject.optInt("reward_live_style", 1));
            pr(jSONObjectOptJSONObject.optString("reward_live_text"));
            pr(jSONObjectOptJSONObject.optInt("reward_start_time", 5));
            x(jSONObjectOptJSONObject.optInt("reward_close_time", 10));
        }
    }

    public void pr(JSONObject jSONObject) {
        if (!this.uc) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("reward_live_type", this.pr);
            jSONObject2.put("reward_live_style", this.hw);
            jSONObject2.put("reward_live_text", this.hn);
            jSONObject2.put("reward_start_time", this.x);
            jSONObject2.put("reward_close_time", this.c);
            jSONObject2.put("isValid", this.uc);
            jSONObject.put("reward_live", jSONObject2);
        } catch (JSONException e) {
        }
    }

    public static boolean pr(of ofVar) {
        f fVarAj = aj(ofVar);
        if (fVarAj == null) {
            return false;
        }
        return fVarAj.uc;
    }

    public boolean pr() {
        return this.uc;
    }

    public static int hw(of ofVar) {
        f fVarAj = aj(ofVar);
        if (fVarAj == null) {
            return 1;
        }
        return fVarAj.pr;
    }

    public static boolean hn(of ofVar) {
        f fVarAj = aj(ofVar);
        return fVarAj == null || !fVarAj.uc || fVarAj.pr == 1;
    }

    public static boolean x(of ofVar) {
        int i;
        f fVarAj = aj(ofVar);
        return fVarAj != null && fVarAj.uc && com.byazt.eg.hw.pr().pr(ofVar) && ((i = fVarAj.pr) == 3 || i == 4);
    }

    private void hw(int i) {
        if (i != 2 && i != 3 && i != 4 && i != 1) {
            i = 1;
        }
        this.pr = i;
    }

    public static int c(of ofVar) {
        f fVarAj = aj(ofVar);
        if (fVarAj == null) {
            return 1;
        }
        return fVarAj.hw;
    }

    private void hn(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.hw = i;
    }

    public static String uc(of ofVar) {
        f fVarAj = aj(ofVar);
        if (fVarAj == null) {
            return "去抖音观看直播\n可提前5s获得奖励哦";
        }
        return fVarAj.hn;
    }

    private void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.hw == 3) {
                str = "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦";
            } else {
                str = "去抖音观看直播\n可提前5s获得奖励哦";
            }
        }
        this.hn = str;
    }

    public static int fw(of ofVar) {
        f fVarAj = aj(ofVar);
        if (fVarAj == null) {
            return 5;
        }
        return Math.max(fVarAj.x, 0);
    }

    public void pr(int i) {
        this.x = i;
    }

    public static int zo(of ofVar) {
        f fVarAj = aj(ofVar);
        if (fVarAj == null) {
            return 10;
        }
        return Math.max(fVarAj.c, 3);
    }

    private void x(int i) {
        if (i <= 3) {
            i = 3;
        }
        this.c = i;
    }

    private static f aj(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.wn();
    }
}

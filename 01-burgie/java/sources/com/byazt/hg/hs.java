package com.byazt.hg;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP})
public class hs {
    public String c;
    public String hn;
    public String hw;
    public int pr;
    public ArrayList<pj> uc;
    public String x;

    public hs(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.pr = 0;
        this.hn = "再看一个获取";
        this.x = "更多奖励";
        this.uc = new ArrayList<>();
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("play_again")) != null) {
            this.pr = jSONObjectOptJSONObject.optInt("again_type", 0);
            this.hn = jSONObjectOptJSONObject.optString("entrance_prefix", "再看一个获取");
            this.x = jSONObjectOptJSONObject.optString("entrance_suffix", "更多奖励");
            this.hw = jSONObjectOptJSONObject.optString("pre_sessions");
            this.c = jSONObjectOptJSONObject.optString("play_again_rit");
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("again_dialog_config");
            if (jSONArrayOptJSONArray != null) {
                this.uc = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.uc.add(new pj(jSONObjectOptJSONObject2));
                    }
                }
            }
        }
    }

    public void pr(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.pr);
        } catch (JSONException e) {
        }
        try {
            jSONObject2.put("entrance_prefix", this.hn);
        } catch (JSONException e2) {
        }
        try {
            jSONObject2.put("entrance_suffix", this.x);
        } catch (JSONException e3) {
        }
        try {
            jSONObject2.put("pre_sessions", this.hw);
        } catch (JSONException e4) {
        }
        try {
            jSONObject2.put("play_again_rit", this.c);
        } catch (JSONException e5) {
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<pj> arrayList = this.uc;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<pj> it = this.uc.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().pr());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException e6) {
            }
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static boolean pr(of ofVar) {
        hs hsVarUc = uc(ofVar);
        if (hsVarUc == null || o.pr(ofVar)) {
            return false;
        }
        int i = hsVarUc.pr;
        return (i == 1 || i == 2 || i == 3) && !TextUtils.isEmpty(hsVarUc.hw);
    }

    public static boolean hw(of ofVar) {
        hs hsVarUc = uc(ofVar);
        if (hsVarUc == null) {
            return false;
        }
        int i = hsVarUc.pr;
        return (i == 1 || i == 3) && pr(ofVar);
    }

    public static String hn(of ofVar) {
        hs hsVarUc = uc(ofVar);
        if (hsVarUc == null) {
            return null;
        }
        return hsVarUc.hw;
    }

    public static String x(of ofVar) {
        hs hsVarUc = uc(ofVar);
        if (hsVarUc == null) {
            return null;
        }
        return hsVarUc.c;
    }

    public static String pr(String str) {
        return str + "again";
    }

    public static String hw(String str) {
        return str + "custom_again";
    }

    public static String pr(of ofVar, String str, String str2) {
        hs hsVarUc = uc(ofVar);
        if (hsVarUc == null) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                return "再看一个获取" + str2 + str;
            }
            return "再看一个获取更多奖励";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(hsVarUc.hn) ? "再看一个获取" : hsVarUc.hn);
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            sb.append(str2);
            sb.append(str);
        } else {
            sb.append(TextUtils.isEmpty(hsVarUc.x) ? "更多奖励" : hsVarUc.x);
        }
        return sb.toString();
    }

    public static ArrayList<pj> c(of ofVar) {
        hs hsVarUc = uc(ofVar);
        if (hsVarUc != null) {
            return hsVarUc.uc;
        }
        return new ArrayList<>();
    }

    private static hs uc(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.zs();
    }
}

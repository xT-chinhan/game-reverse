package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private String ah;
    private ArrayList<gy> c;
    private String d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3061ms;
    private String xr;

    public k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.f3061ms = 0;
        this.ah = "再看一个获取";
        this.d = "更多奖励";
        this.c = new ArrayList<>();
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("play_again")) == null) {
            return;
        }
        this.f3061ms = jSONObjectOptJSONObject.optInt("again_type", 0);
        this.ah = jSONObjectOptJSONObject.optString("entrance_prefix", "再看一个获取");
        this.d = jSONObjectOptJSONObject.optString("entrance_suffix", "更多奖励");
        this.xr = jSONObjectOptJSONObject.optString("pre_sessions");
        this.ka = jSONObjectOptJSONObject.optString("play_again_rit");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("again_dialog_config");
        if (jSONArrayOptJSONArray != null) {
            this.c = new ArrayList<>();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.c.add(new gy(jSONObjectOptJSONObject2));
                }
            }
        }
    }

    public void ms(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.f3061ms);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        try {
            jSONObject2.put("entrance_prefix", this.ah);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
        try {
            jSONObject2.put("entrance_suffix", this.d);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.sl.ms(e3);
        }
        try {
            jSONObject2.put("pre_sessions", this.xr);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.sl.ms(e4);
        }
        try {
            jSONObject2.put("play_again_rit", this.ka);
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.sl.ms(e5);
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<gy> arrayList = this.c;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<gy> it = this.c.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().ms());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.sl.ms(e6);
            }
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static boolean ms(lm lmVar) {
        k kVarC = c(lmVar);
        if (kVarC == null || fm.ms(lmVar)) {
            return false;
        }
        int i = kVarC.f3061ms;
        return (i == 1 || i == 2 || i == 3) && !TextUtils.isEmpty(kVarC.xr);
    }

    public static boolean xr(lm lmVar) {
        k kVarC = c(lmVar);
        if (kVarC == null) {
            return false;
        }
        int i = kVarC.f3061ms;
        return (i == 1 || i == 3) && ms(lmVar);
    }

    public static String ah(lm lmVar) {
        k kVarC = c(lmVar);
        if (kVarC == null) {
            return null;
        }
        return kVarC.xr;
    }

    public static String d(lm lmVar) {
        k kVarC = c(lmVar);
        if (kVarC == null) {
            return null;
        }
        return kVarC.ka;
    }

    public static String ms(String str) {
        return str + "again";
    }

    public static String xr(String str) {
        return str + "custom_again";
    }

    public static String ms(lm lmVar, String str, String str2) {
        k kVarC = c(lmVar);
        if (kVarC == null) {
            return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) ? "再看一个获取更多奖励" : "再看一个获取" + str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(kVarC.ah) ? "再看一个获取" : kVarC.ah);
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            sb.append(str2);
            sb.append(str);
        } else {
            sb.append(TextUtils.isEmpty(kVarC.d) ? "更多奖励" : kVarC.d);
        }
        return sb.toString();
    }

    public static ArrayList<gy> ka(lm lmVar) {
        k kVarC = c(lmVar);
        if (kVarC != null) {
            return kVarC.c;
        }
        return new ArrayList<>();
    }

    private static k c(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.hy();
    }
}

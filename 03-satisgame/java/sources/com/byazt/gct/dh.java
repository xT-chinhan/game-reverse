package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, AVMDLDataLoader.KeyIsIsTestSpeedVersion})
public class dh {
    public String l;
    public int n;
    public String q;
    public String qg;
    public String s;
    public ArrayList<ry> w;

    public dh(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.n = 0;
        this.s = "再看一个获取";
        this.q = "更多奖励";
        this.w = new ArrayList<>();
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("play_again")) == null) {
            return;
        }
        this.n = jSONObjectOptJSONObject.optInt("again_type", 0);
        this.s = jSONObjectOptJSONObject.optString("entrance_prefix", "再看一个获取");
        this.q = jSONObjectOptJSONObject.optString("entrance_suffix", "更多奖励");
        this.qg = jSONObjectOptJSONObject.optString("pre_sessions");
        this.l = jSONObjectOptJSONObject.optString("play_again_rit");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("again_dialog_config");
        if (jSONArrayOptJSONArray != null) {
            this.w = new ArrayList<>();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.w.add(new ry(jSONObjectOptJSONObject2));
                }
            }
        }
    }

    public void n(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.n);
        } catch (JSONException unused) {
        }
        try {
            jSONObject2.put("entrance_prefix", this.s);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject2.put("entrance_suffix", this.q);
        } catch (JSONException unused3) {
        }
        try {
            jSONObject2.put("pre_sessions", this.qg);
        } catch (JSONException unused4) {
        }
        try {
            jSONObject2.put("play_again_rit", this.l);
        } catch (JSONException unused5) {
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<ry> arrayList = this.w;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<ry> it = this.w.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().n());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException unused6) {
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean n(pk pkVar) {
        dh dhVarW = w(pkVar);
        if (dhVarW == null || pe.n(pkVar)) {
            return false;
        }
        int i = dhVarW.n;
        return (i == 1 || i == 2 || i == 3) && !TextUtils.isEmpty(dhVarW.qg);
    }

    public static boolean qg(pk pkVar) {
        dh dhVarW = w(pkVar);
        if (dhVarW == null) {
            return false;
        }
        int i = dhVarW.n;
        return (i == 1 || i == 3) && n(pkVar);
    }

    public static String s(pk pkVar) {
        dh dhVarW = w(pkVar);
        if (dhVarW == null) {
            return null;
        }
        return dhVarW.qg;
    }

    public static String q(pk pkVar) {
        dh dhVarW = w(pkVar);
        if (dhVarW == null) {
            return null;
        }
        return dhVarW.l;
    }

    public static String n(String str) {
        return str + "again";
    }

    public static String qg(String str) {
        return str + "custom_again";
    }

    public static String n(pk pkVar, String str, String str2) {
        dh dhVarW = w(pkVar);
        if (dhVarW == null) {
            return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) ? "再看一个获取更多奖励" : "再看一个获取" + str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(dhVarW.s) ? "再看一个获取" : dhVarW.s);
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            sb.append(str2);
            sb.append(str);
        } else {
            sb.append(TextUtils.isEmpty(dhVarW.q) ? "更多奖励" : dhVarW.q);
        }
        return sb.toString();
    }

    public static ArrayList<ry> l(pk pkVar) {
        dh dhVarW = w(pkVar);
        if (dhVarW != null) {
            return dhVarW.w;
        }
        return new ArrayList<>();
    }

    private static dh w(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.kh();
    }
}

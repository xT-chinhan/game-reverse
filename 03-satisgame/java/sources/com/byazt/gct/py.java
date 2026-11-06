package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 866})
public class py {
    public Map<String, n> n = new HashMap();

    public py(JSONObject jSONObject, boolean z) {
        if (z) {
            try {
                jSONObject = jSONObject.optJSONObject("sub_convert_link");
            } catch (Exception unused) {
                return;
            }
        }
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                n nVar = new n(jSONObject.optJSONObject(next));
                if (nVar.qg()) {
                    this.n.put(next, nVar);
                }
            }
        }
    }

    public void n(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, n> entry : this.n.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().n());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception unused) {
        }
    }

    private static py n(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.oa();
    }

    public static boolean n(py pyVar, String str) {
        return (pyVar == null || !pyVar.n.containsKey(str) || TextUtils.isEmpty(s(pyVar, str))) ? false : true;
    }

    public static int qg(py pyVar, String str) {
        n nVar;
        if (pyVar == null || (nVar = pyVar.n.get(str)) == null) {
            return 0;
        }
        return nVar.n;
    }

    public static String s(py pyVar, String str) {
        n nVar;
        return (pyVar == null || (nVar = pyVar.n.get(str)) == null) ? "" : nVar.qg;
    }

    public static JSONObject q(py pyVar, String str) {
        n nVar;
        if (pyVar == null || (nVar = pyVar.n.get(str)) == null) {
            return null;
        }
        return nVar.n();
    }

    public static String n(pk pkVar, String str) {
        n nVar;
        py pyVarN = n(pkVar);
        return (pyVarN == null || (nVar = pyVarN.n.get(str)) == null) ? "" : nVar.s;
    }

    public static String l(py pyVar, String str) {
        n nVar;
        return (pyVar == null || (nVar = pyVar.n.get(str)) == null) ? "" : nVar.q;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1863})
    private static class n {
        public int n;
        public String q;
        public String qg;
        public String s;

        public n(JSONObject jSONObject) {
            try {
                this.n = jSONObject.optInt("type");
                this.qg = jSONObject.optString(ImagesContract.URL);
                this.s = jSONObject.optString("pid");
                this.q = jSONObject.optString("ecom_live_params");
            } catch (Exception unused) {
            }
        }

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.n);
                jSONObject.put(ImagesContract.URL, this.qg);
                jSONObject.put("pid", this.s);
                jSONObject.put("ecom_live_params", this.q);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean qg() {
            if (3 == this.n) {
                return !TextUtils.isEmpty(this.q);
            }
            return !TextUtils.isEmpty(this.qg);
        }
    }
}

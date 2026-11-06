package com.byazt.tm;

import android.content.Context;
import com.byakv.z.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1764, 26})
public class qg extends com.byazt.va.n {
    @Override // com.byazt.va.n
    public String s() {
        return "d_i0";
    }

    public qg(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.byazt.va.n
    public String qg() {
        JSONArray jSONArrayOptJSONArray = this.q.optJSONArray("path");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return "";
        }
        int length = jSONArrayOptJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                strArr[i] = jSONArrayOptJSONArray.getString(i);
            } catch (JSONException e) {
                com.byazt.nt.n.qg("__kite" + s() + "jsonArray parse error " + e.getMessage());
            }
        }
        if (com.byazt.nt.n.qg()) {
            com.byazt.nt.n.n("__kite" + s() + " plist size: " + length);
        }
        try {
            return n(strArr);
        } catch (Exception e2) {
            if (e2.getCause() != null) {
                this.s = e2.getCause().getMessage();
            } else {
                this.s = e2.getMessage();
            }
            return "";
        }
    }

    public String n(String[] strArr) {
        try {
            int[] dI0Result = TTEncryptUtils.getDI0Result(strArr);
            if (dI0Result == null || dI0Result.length <= 0) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < dI0Result.length; i++) {
                jSONObject.put(strArr[i], dI0Result[i]);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}

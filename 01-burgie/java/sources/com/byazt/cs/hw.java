package com.byazt.cs;

import android.content.Context;
import com.byakv.z.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1779, 13})
public class hw extends com.byazt.gq.pr {
    public hw(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.byazt.gq.pr
    public String hw() {
        JSONArray jSONArrayOptJSONArray = this.x.optJSONArray("path");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return "";
        }
        int length = jSONArrayOptJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                strArr[i] = jSONArrayOptJSONArray.getString(i);
            } catch (JSONException e) {
                com.byazt.wx.pr.hw("__kite" + hn() + "jsonArray parse error " + e.getMessage());
            }
        }
        if (com.byazt.wx.pr.hw()) {
            com.byazt.wx.pr.pr("__kite" + hn() + " plist size: " + length);
        }
        try {
            return pr(strArr);
        } catch (Exception e2) {
            if (e2.getCause() != null) {
                this.hn = e2.getCause().getMessage();
            } else {
                this.hn = e2.getMessage();
            }
            return "";
        }
    }

    public String pr(String[] strArr) {
        try {
            int[] dI0Result = TTEncryptUtils.getDI0Result(strArr);
            if (dI0Result != null && dI0Result.length > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < dI0Result.length; i++) {
                    jSONObject.put(strArr[i], dI0Result[i]);
                }
                return jSONObject.toString();
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.byazt.gq.pr
    public String hn() {
        return "d_i0";
    }
}

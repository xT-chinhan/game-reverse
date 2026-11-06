package com.byazt.cs;

import android.content.Context;
import android.text.TextUtils;
import com.byakv.z.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1779, 37})
public class pr extends com.byazt.gq.pr {
    public pr(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.byazt.gq.pr
    public String hw() {
        JSONArray jSONArrayOptJSONArray = this.x.optJSONArray("path");
        if (jSONArrayOptJSONArray == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String string = jSONArrayOptJSONArray.getString(i);
                jSONObject.put(string, pr(string));
            } catch (Exception e) {
                if (e.getCause() != null) {
                    this.hn = e.getCause().getMessage();
                } else {
                    this.hn = e.getMessage();
                }
            }
        }
        return jSONObject.toString();
    }

    public String pr(String str) {
        try {
            String dA0Result = TTEncryptUtils.getDA0Result(str);
            if (com.byazt.wx.pr.hw()) {
                com.byazt.wx.pr.pr("__kite", "p：" + str + " r:" + dA0Result);
            }
            if (!TextUtils.isEmpty(dA0Result)) {
                return dA0Result;
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.byazt.gq.pr
    public String hn() {
        return "d_a0";
    }
}

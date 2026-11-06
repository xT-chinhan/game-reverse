package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import com.byakv.z.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1764, 19})
public class n extends com.byazt.va.n {
    @Override // com.byazt.va.n
    public String s() {
        return "d_a0";
    }

    public n(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.byazt.va.n
    public String qg() {
        JSONArray jSONArrayOptJSONArray = this.q.optJSONArray("path");
        if (jSONArrayOptJSONArray == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String string = jSONArrayOptJSONArray.getString(i);
                jSONObject.put(string, n(string));
            } catch (Exception e) {
                if (e.getCause() != null) {
                    this.s = e.getCause().getMessage();
                } else {
                    this.s = e.getMessage();
                }
            }
        }
        return jSONObject.toString();
    }

    public String n(String str) {
        try {
            String dA0Result = TTEncryptUtils.getDA0Result(str);
            if (com.byazt.nt.n.qg()) {
                com.byazt.nt.n.n("__kite", "p：" + str + " r:" + dA0Result);
            }
            return !TextUtils.isEmpty(dA0Result) ? dA0Result : "";
        } catch (Exception unused) {
            return "";
        }
    }
}

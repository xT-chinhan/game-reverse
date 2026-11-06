package com.byazt.qk;

import android.text.TextUtils;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1482, 13})
public class hw extends com.byazt.hfm.pr {
    public hw() {
    }

    public hw(com.byazt.hfm.pr prVar) {
        if (prVar != null) {
            pr(prVar.hw());
            hw(prVar.hn());
            pr(prVar.getResources());
        }
    }

    @Override // com.byazt.hfm.pr
    public boolean uc() {
        return (TextUtils.isEmpty(hn()) || TextUtils.isEmpty(hw())) ? false : true;
    }

    @Override // com.byazt.hfm.pr
    public String zo() {
        if (uc()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(Common.System.NAME, hw());
                jSONObject.putOpt("version", hn());
                JSONArray jSONArray = new JSONArray();
                if (getResources() != null) {
                    for (com.byazt.hfm.pr.C0084pr c0084pr : getResources()) {
                        if (c0084pr != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.putOpt(BreakpointSQLiteKey.URL, c0084pr.pr());
                            jSONObject2.putOpt("md5", c0084pr.hw());
                            jSONObject2.putOpt("level", Integer.valueOf(c0084pr.hn()));
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                jSONObject.putOpt("resources", jSONArray);
                return jSONObject.toString();
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    public static hw c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return hw(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public static hw hw(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hw hwVar = new hw();
        hwVar.pr(jSONObject.optString(Common.System.NAME));
        hwVar.hw(jSONObject.optString("version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    com.byazt.hfm.pr.C0084pr c0084pr = new com.byazt.hfm.pr.C0084pr();
                    c0084pr.pr(jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL));
                    c0084pr.hw(jSONObjectOptJSONObject.optString("md5"));
                    c0084pr.pr(jSONObjectOptJSONObject.optInt("level"));
                    arrayList.add(c0084pr);
                }
            }
        }
        hwVar.pr(arrayList);
        if (!hwVar.uc()) {
            return null;
        }
        return hwVar;
    }
}

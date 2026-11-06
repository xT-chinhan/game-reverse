package com.byazt.uo;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 217, 13})
public final class hw {
    public final List<pr> hn;
    public final long hw;
    public final int pr;

    public hw(int i, long j, List<pr> list) {
        this.pr = i;
        this.hw = j;
        this.hn = list;
    }

    public void pr(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        jSONObject.put("active_ad_session_count", this.pr);
        jSONObject.put("active_ad_sessions", pr());
    }

    private JSONArray pr() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<pr> list = this.hn;
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.hn.get(i).hw());
        }
        return jSONArray;
    }
}

package com.byazt.lh;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1475, 8})
public class s {
    public HashMap<String, Object> n = new HashMap<>();
    public JSONObject qg;

    public s(JSONObject jSONObject) {
        this.qg = jSONObject;
    }

    public Object n(String str) {
        if (this.n.containsKey(str)) {
            return this.n.get(str);
        }
        return null;
    }

    public boolean qg(String str) {
        return this.n.containsKey(str);
    }

    public void n() {
        Iterator<String> itKeys = this.qg.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.qg.opt(next);
            int i = 0;
            if (TextUtils.equals("image", next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    this.n.put(next + i.E + i + i.E + next2, jSONObjectOptJSONObject.opt(next2));
                                }
                            }
                            i++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (objOpt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) objOpt);
                        Iterator<String> itKeys3 = jSONObject.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            Object objOpt2 = jSONObject.opt(next3);
                            if ((objOpt2 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i2 = 0; i2 < ((JSONArray) objOpt2).length(); i2++) {
                                    this.n.put(next + i.E + next3 + i.E + i2, ((JSONArray) objOpt2).opt(i2));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt2).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    this.n.put(next + i.E + next3 + i.E + next4, ((JSONObject) objOpt2).opt(next4));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                n(next, next3, objOpt2);
                            } else {
                                this.n.put(next + i.E + next3, objOpt2);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.n.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.n.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys5 = jSONObject2.keys();
                while (itKeys5.hasNext()) {
                    String next5 = itKeys5.next();
                    this.n.put(next + i.E + next5, jSONObject2.opt(next5));
                }
            }
        }
    }

    private void n(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if ((objOpt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (i < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            this.n.put(str + i.E + str2 + i.E + next + i.E + i + i.E + next2, jSONObjectOptJSONObject.opt(next2));
                        }
                        i++;
                    }
                }
            } else {
                this.n.put(str + i.E + str2 + i.E + next, objOpt);
            }
        }
    }
}

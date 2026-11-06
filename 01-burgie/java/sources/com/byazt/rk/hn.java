package com.byazt.rk;

import android.text.TextUtils;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1536, 20})
public class hn {
    public JSONObject hw;
    public HashMap<String, Object> pr = new HashMap<>();

    public hn(JSONObject jSONObject) {
        this.hw = jSONObject;
    }

    public Object pr(String str) {
        if (this.pr.containsKey(str)) {
            return this.pr.get(str);
        }
        return null;
    }

    public boolean hw(String str) {
        return this.pr.containsKey(str);
    }

    public void pr() {
        Iterator<String> itKeys = this.hw.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.hw.opt(next);
            int i = 0;
            if (TextUtils.equals(ImageViewManager.NAME, next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    this.pr.put(next + "." + i + "." + next2, jSONObjectOptJSONObject.opt(next2));
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
                                    this.pr.put(next + "." + next3 + "." + i2, ((JSONArray) objOpt2).opt(i2));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt2).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    this.pr.put(next + "." + next3 + "." + next4, ((JSONObject) objOpt2).opt(next4));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                pr(next, next3, objOpt2);
                            } else {
                                this.pr.put(next + "." + next3, objOpt2);
                            }
                        }
                    } catch (JSONException e) {
                    }
                }
            } else if (objOpt instanceof JSONObject) {
                if (objOpt != null) {
                    JSONObject jSONObject2 = (JSONObject) objOpt;
                    Iterator<String> itKeys5 = jSONObject2.keys();
                    while (itKeys5.hasNext()) {
                        String next5 = itKeys5.next();
                        this.pr.put(next + "." + next5, jSONObject2.opt(next5));
                    }
                }
            } else {
                this.pr.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.pr.put(next, objOpt);
                }
            }
        }
    }

    private void pr(String str, String str2, Object obj) {
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
                            this.pr.put(str + "." + str2 + "." + next + "." + i + "." + next2, jSONObjectOptJSONObject.opt(next2));
                        }
                        i++;
                    }
                }
            } else {
                this.pr.put(str + "." + str2 + "." + next, objOpt);
            }
        }
    }
}

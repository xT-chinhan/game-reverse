package com.bytedance.sdk.component.adexpress.dynamic.ah;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.utils.sl;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private HashMap<String, Object> f759ms = new HashMap<>();
    private JSONObject xr;

    public ah(JSONObject jSONObject) {
        this.xr = jSONObject;
    }

    public Object ms(String str) {
        if (this.f759ms.containsKey(str)) {
            return this.f759ms.get(str);
        }
        return null;
    }

    public boolean xr(String str) {
        return this.f759ms.containsKey(str);
    }

    public void ms() {
        Iterator<String> itKeys = this.xr.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.xr.opt(next);
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
                                    this.f759ms.put(next + j.z + i + j.z + next2, jSONObjectOptJSONObject.opt(next2));
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
                                    this.f759ms.put(next + j.z + next3 + j.z + i2, ((JSONArray) objOpt2).opt(i2));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt2).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    this.f759ms.put(next + j.z + next3 + j.z + next4, ((JSONObject) objOpt2).opt(next4));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                ms(next, next3, objOpt2);
                            } else {
                                this.f759ms.put(next + j.z + next3, objOpt2);
                            }
                        }
                    } catch (JSONException e) {
                        sl.ms(e);
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.f759ms.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.f759ms.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys5 = jSONObject2.keys();
                while (itKeys5.hasNext()) {
                    String next5 = itKeys5.next();
                    this.f759ms.put(next + j.z + next5, jSONObject2.opt(next5));
                }
            }
        }
    }

    private void ms(String str, String str2, Object obj) {
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
                            this.f759ms.put(str + j.z + str2 + j.z + next + j.z + i + j.z + next2, jSONObjectOptJSONObject.opt(next2));
                        }
                        i++;
                    }
                }
            } else {
                this.f759ms.put(str + j.z + str2 + j.z + next, objOpt);
            }
        }
    }
}

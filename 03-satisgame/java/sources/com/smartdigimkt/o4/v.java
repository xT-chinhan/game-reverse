package com.smartdigimkt.o4;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {
    public static void a(List list, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || jSONObject.length() == 0 || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.smartdigimkt.d3.c cVar = (com.smartdigimkt.d3.c) it.next();
            if (cVar != null) {
                try {
                    JSONObject jSONObject3 = cVar.R;
                    if (jSONObject3 == null && cVar.y != null) {
                        jSONObject3 = new JSONObject(cVar.y);
                    }
                    if (jSONObject3 != null && (jSONArrayOptJSONArray = (jSONObject2 = new JSONObject(jSONObject3.toString())).optJSONArray("seatbid")) != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ctrl");
                                JSONObject jSONObject4 = jSONObjectOptJSONObject2 != null ? new JSONObject(jSONObjectOptJSONObject2.toString()) : new JSONObject();
                                a(jSONObject, jSONObject4);
                                jSONObjectOptJSONObject.put("ctrl", jSONObject4);
                            }
                        }
                        cVar.R = jSONObject2;
                        cVar.y = jSONObject2.toString();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        Object objOpt;
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    if (jSONObject2.has(next) && (objOpt = jSONObject2.opt(next)) != null && objOpt != JSONObject.NULL) {
                        if (objOpt instanceof String) {
                            if (((String) objOpt).length() == 0) {
                                jSONObject2.put(next, jSONObject.opt(next));
                            }
                        } else if ((objOpt instanceof Number) && ((Number) objOpt).doubleValue() == 0.0d) {
                            jSONObject2.put(next, jSONObject.opt(next));
                        }
                    } else {
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}

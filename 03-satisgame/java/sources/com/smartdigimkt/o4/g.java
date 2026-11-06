package com.smartdigimkt.o4;

import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.smartdigimkt.sdk.api.AdError;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.smartdigimkt.a4.b {
    public final f a;
    public final boolean b;

    public g(String str, f fVar, boolean z) {
        this.a = fVar;
        this.b = z;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
        this.a.getClass();
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.a.a(com.smartdigimkt.z3.b.a("10008", adError.getErrorInfo()));
    }

    public static Pair a(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject instanceof JSONObject) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject != null) {
                    jSONObject = jSONObjectOptJSONObject;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return new Pair(com.smartdigimkt.z3.b.a("10008", "The bid response result is empty."), arrayList);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.anythink.core.common.l.f.R);
            int iOptInt = jSONObject.optInt("code", 0);
            String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            if (iOptInt == 0 && jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    com.smartdigimkt.d3.c cVarA = com.smartdigimkt.d3.b.a(jSONArrayOptJSONArray.optJSONObject(i));
                    if (cVarA != null) {
                        arrayList.add(cVarA);
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new Pair(null, arrayList);
                }
                return new Pair(com.smartdigimkt.z3.b.a("10008", "parse bidding result failed."), arrayList);
            }
            return new Pair(com.smartdigimkt.z3.b.a("10008", iOptInt + " " + strOptString), arrayList);
        }
        return new Pair(com.smartdigimkt.z3.b.a("10008", "The result is not a JSONObject."), arrayList);
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        try {
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject2 != null) {
                    jSONObject = jSONObjectOptJSONObject2;
                }
            } else {
                jSONObject = null;
            }
            if (!this.b && jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("placement_strategy")) != null && jSONObjectOptJSONObject.optInt("error_code", 0) == 40006) {
                this.a.a(new ArrayList(), jSONObject);
                return;
            }
            Pair pairA = a(obj);
            com.smartdigimkt.z3.a aVar = (com.smartdigimkt.z3.a) pairA.first;
            if (aVar != null) {
                this.a.a(aVar);
            } else {
                this.a.a((List) pairA.second, jSONObject);
            }
        } catch (Throwable th) {
            this.a.a(com.smartdigimkt.z3.b.a("10008", "onLoadFinish in error." + th));
        }
    }
}

package com.taptap.sdk.db.event.utils;

import com.anythink.core.common.f.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapEventParameterKit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a \u0010\u0004\u001a\u00020\u0005*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a \u0010\t\u001a\u00020\u0005*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000¨\u0006\f"}, d2 = {"obtainJSONObject", "Lorg/json/JSONObject;", e.a.b, "", "putProperties", "", "jsonObject", "override", "", "putProperty", e.a.d, "", "tap-db_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapEventParameterKitKt {
    public static final JSONObject obtainJSONObject(JSONObject jSONObject, String key) throws Exception {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.has(key)) {
            Object obj = jSONObject.get(key);
            if (!(obj instanceof JSONObject)) {
                throw new Exception("This JSONObject contains a key whose value is not of the JSONObject type");
            }
            return (JSONObject) obj;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put(key, jSONObject2);
        return jSONObject2;
    }

    public static final void putProperty(JSONObject jSONObject, String str, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        jSONObject.put(str, obj);
    }

    public static /* synthetic */ void putProperties$default(JSONObject jSONObject, JSONObject jSONObject2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        putProperties(jSONObject, jSONObject2, z);
    }

    public static final void putProperties(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject2 == null) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(next, "keys.next()");
                String str = next;
                Object obj = jSONObject2.get(str);
                Intrinsics.checkNotNullExpressionValue(obj, "jsonObject.get(key)");
                if (!jSONObject.has(str) || z) {
                    putProperty(jSONObject, str, obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

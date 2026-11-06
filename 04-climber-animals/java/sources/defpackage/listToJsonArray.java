package defpackage;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: MapUtilsKt, reason: from Kotlin metadata */
/* JADX INFO: compiled from: MapUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¨\u0006\b"}, d2 = {"listToJsonArray", "Lorg/json/JSONArray;", "list", "", "mapToJsonObject", "Lorg/json/JSONObject;", "map", "", "tap-login_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class listToJsonArray {
    public static final JSONObject mapToJsonObject(Map<?, ?> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "map");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            String strValueOf = String.valueOf(key);
            if (value == null) {
                jSONObject.put(strValueOf, JSONObject.NULL);
            } else if (value instanceof Map) {
                jSONObject.put(strValueOf, mapToJsonObject((Map) value));
            } else if (value instanceof List) {
                jSONObject.put(strValueOf, listToJsonArray((List) value));
            } else if (value instanceof Object[]) {
                jSONObject.put(strValueOf, listToJsonArray(ArraysKt.toList((Object[]) value)));
            } else if (value instanceof Boolean ? true : value instanceof Number ? true : value instanceof String) {
                jSONObject.put(strValueOf, value);
            } else {
                jSONObject.put(strValueOf, value.toString());
            }
        }
        return jSONObject;
    }

    public static final JSONArray listToJsonArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj == null) {
                jSONArray.put(JSONObject.NULL);
            } else if (obj instanceof Map) {
                jSONArray.put(mapToJsonObject((Map) obj));
            } else if (obj instanceof List) {
                jSONArray.put(listToJsonArray((List) obj));
            } else if (obj instanceof Object[]) {
                jSONArray.put(listToJsonArray(ArraysKt.toList((Object[]) obj)));
            } else if (obj instanceof Boolean ? true : obj instanceof Number ? true : obj instanceof String) {
                jSONArray.put(obj);
            } else {
                jSONArray.put(obj.toString());
            }
        }
        return jSONArray;
    }
}

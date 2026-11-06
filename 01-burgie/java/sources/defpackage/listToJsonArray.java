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
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            String jsonKey = String.valueOf(key);
            if (value == null) {
                jsonObject.put(jsonKey, JSONObject.NULL);
            } else if (value instanceof Map) {
                jsonObject.put(jsonKey, mapToJsonObject((Map) value));
            } else if (value instanceof List) {
                jsonObject.put(jsonKey, listToJsonArray((List) value));
            } else if (value instanceof Object[]) {
                jsonObject.put(jsonKey, listToJsonArray(ArraysKt.toList((Object[]) value)));
            } else if (value instanceof Boolean ? true : value instanceof Number ? true : value instanceof String) {
                jsonObject.put(jsonKey, value);
            } else {
                jsonObject.put(jsonKey, value.toString());
            }
        }
        return jsonObject;
    }

    public static final JSONArray listToJsonArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jsonArray = new JSONArray();
        List<?> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            if (element$iv == null) {
                jsonArray.put(JSONObject.NULL);
            } else if (element$iv instanceof Map) {
                jsonArray.put(mapToJsonObject((Map) element$iv));
            } else if (element$iv instanceof List) {
                jsonArray.put(listToJsonArray((List) element$iv));
            } else if (element$iv instanceof Object[]) {
                jsonArray.put(listToJsonArray(ArraysKt.toList((Object[]) element$iv)));
            } else if (element$iv instanceof Boolean ? true : element$iv instanceof Number ? true : element$iv instanceof String) {
                jsonArray.put(element$iv);
            } else {
                jsonArray.put(element$iv.toString());
            }
        }
        return jsonArray;
    }
}

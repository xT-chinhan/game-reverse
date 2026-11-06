package com.taptap.sdk.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004*\u00020\u0005H\u0002J\u0018\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007*\u00020\t¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/core/utils/JSONUtils;", "", "()V", "toList", "", "Lorg/json/JSONArray;", "toMap", "", "", "Lorg/json/JSONObject;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JSONUtils {
    public static final JSONUtils INSTANCE = new JSONUtils();

    private JSONUtils() {
    }

    public final Map<String, Object> toMap(JSONObject $this$toMap) throws JSONException {
        Object list;
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        HashMap results = new HashMap();
        Iterator<String> itKeys = $this$toMap.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            HashMap map = results;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Object value = $this$toMap.get(key);
            if (value == null ? true : Intrinsics.areEqual(value, JSONObject.NULL)) {
                list = null;
            } else if (value instanceof JSONObject) {
                list = toMap((JSONObject) value);
            } else if (value instanceof JSONArray) {
                list = toList((JSONArray) value);
            } else {
                list = $this$toMap.get(key);
            }
            map.put(key, list);
        }
        return results;
    }

    private final List<Object> toList(JSONArray $this$toList) throws JSONException {
        List results = new ArrayList();
        int length = $this$toList.length();
        for (int index = 0; index < length; index++) {
            Object value = $this$toList.get(index);
            if (value == null ? true : Intrinsics.areEqual(value, JSONObject.NULL)) {
                results.add(null);
            } else if (value instanceof JSONArray) {
                results.add(toList((JSONArray) value));
            } else if (value instanceof JSONObject) {
                results.add(toMap((JSONObject) value));
            } else {
                results.add(value);
            }
        }
        return results;
    }
}

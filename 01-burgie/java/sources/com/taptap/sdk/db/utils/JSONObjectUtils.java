package com.taptap.sdk.db.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONObjectUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004*\u00020\u0005H\u0002J\u0018\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007*\u00020\t¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/db/utils/JSONObjectUtils;", "", "()V", "toList", "", "Lorg/json/JSONArray;", "toMap", "", "", "Lorg/json/JSONObject;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class JSONObjectUtils {
    public static final JSONObjectUtils INSTANCE = new JSONObjectUtils();

    private JSONObjectUtils() {
    }

    public final Map<String, Object> toMap(JSONObject $this$toMap) throws JSONException {
        Intrinsics.checkNotNullParameter($this$toMap, "<this>");
        HashMap map = new HashMap();
        Iterator<String> itKeys = $this$toMap.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Object value = $this$toMap.get(key);
            if (value == null ? true : Intrinsics.areEqual(value, JSONObject.NULL)) {
                value = null;
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            } else if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }
            Pair pair = TuplesKt.to(key, value);
            map.put(pair.getFirst(), pair.getSecond());
        }
        return map;
    }

    private final List<Object> toList(JSONArray $this$toList) throws JSONException {
        Object temp;
        List list = new ArrayList();
        int length = $this$toList.length();
        for (int index = 0; index < length; index++) {
            Object value = $this$toList.get(index);
            if (value == null ? true : Intrinsics.areEqual(value, JSONObject.NULL)) {
                temp = null;
            } else if (value instanceof JSONArray) {
                temp = toList((JSONArray) value);
            } else {
                temp = value instanceof JSONObject ? toMap((JSONObject) value) : value;
            }
            list.add(temp);
        }
        return list;
    }
}

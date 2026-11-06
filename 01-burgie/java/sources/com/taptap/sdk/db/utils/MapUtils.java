package com.taptap.sdk.db.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObjectBuilder;

/* JADX INFO: compiled from: MapUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u0003\u001a\u00020\u0004*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/db/utils/MapUtils;", "", "()V", "toJsonElement", "Lkotlinx/serialization/json/JsonElement;", "", "", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MapUtils {
    public static final MapUtils INSTANCE = new MapUtils();

    private MapUtils() {
    }

    public final JsonElement toJsonElement(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            builder$iv.put(key, INSTANCE.toJsonElement(value));
        }
        return builder$iv.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JsonElement toJsonElement(Object $this$toJsonElement) {
        if ($this$toJsonElement == null) {
            return JsonNull.INSTANCE;
        }
        if ($this$toJsonElement instanceof Number) {
            return JsonElementKt.JsonPrimitive((Number) $this$toJsonElement);
        }
        if ($this$toJsonElement instanceof Boolean) {
            return JsonElementKt.JsonPrimitive((Boolean) $this$toJsonElement);
        }
        if ($this$toJsonElement instanceof String) {
            return JsonElementKt.JsonPrimitive((String) $this$toJsonElement);
        }
        if ($this$toJsonElement instanceof Map) {
            Iterable $this$associate$iv = ((Map) $this$toJsonElement).entrySet();
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $this$associate$iv) {
                Map.Entry entry = (Map.Entry) element$iv$iv;
                Object key = entry.getKey();
                Object value = entry.getValue();
                Pair pair = TuplesKt.to(String.valueOf(key), value);
                destination$iv$iv.put(pair.getFirst(), pair.getSecond());
            }
            return toJsonElement((Map<String, ? extends Object>) destination$iv$iv);
        }
        if (!($this$toJsonElement instanceof List)) {
            if (!($this$toJsonElement instanceof Object[])) {
                if (!($this$toJsonElement instanceof Set)) {
                    if ($this$toJsonElement instanceof JsonElement) {
                        return (JsonElement) $this$toJsonElement;
                    }
                    return JsonElementKt.JsonPrimitive($this$toJsonElement.toString());
                }
                JsonArrayBuilder builder$iv = new JsonArrayBuilder();
                for (Object element$iv : (Iterable) $this$toJsonElement) {
                    builder$iv.add(INSTANCE.toJsonElement(element$iv));
                }
                return builder$iv.build();
            }
            JsonArrayBuilder builder$iv2 = new JsonArrayBuilder();
            Object[] $this$forEach$iv = (Object[]) $this$toJsonElement;
            for (Object element$iv2 : $this$forEach$iv) {
                builder$iv2.add(INSTANCE.toJsonElement(element$iv2));
            }
            return builder$iv2.build();
        }
        JsonArrayBuilder builder$iv3 = new JsonArrayBuilder();
        for (Object element$iv3 : (Iterable) $this$toJsonElement) {
            builder$iv3.add(INSTANCE.toJsonElement(element$iv3));
        }
        return builder$iv3.build();
    }
}

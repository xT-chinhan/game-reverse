package com.taptap.sdk.db.utils;

import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MapUtils2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00042:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0002Jd\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r*\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2<\b\u0002\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/db/utils/MapUtils2;", "", "()V", "filterRecursively", "", "predicate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", Common.System.NAME, "key", Constants.VALUE_FIELD, "", "", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MapUtils2 {
    public static final MapUtils2 INSTANCE = new MapUtils2();

    private MapUtils2() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map filterRecursively$default(MapUtils2 mapUtils2, Map map, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = DefaultPropertiesVerifyFuncKt.defaultPropertiesVerifyFunc$default(0, 0, 0, 7, null);
        }
        return mapUtils2.filterRecursively((Map<String, ? extends Object>) map, (Function2<? super String, Object, Boolean>) function2);
    }

    public final Map<String, Object> filterRecursively(Map<String, ? extends Object> map, Function2<? super String, Object, Boolean> predicate) {
        Object objFilterRecursively;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        LinkedHashMap result = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (predicate.invoke(key, value).booleanValue()) {
                LinkedHashMap linkedHashMap = result;
                if (value instanceof Map) {
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                    objFilterRecursively = filterRecursively((Map<String, ? extends Object>) value, predicate);
                } else {
                    objFilterRecursively = value instanceof List ? filterRecursively((List<?>) value, predicate) : value;
                }
                linkedHashMap.put(key, objFilterRecursively);
            }
        }
        return result;
    }

    private final List<Object> filterRecursively(List<?> list, Function2<? super String, Object, Boolean> function2) {
        Object temp;
        List<?> $this$mapNotNull$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            if (element$iv$iv$iv instanceof Map) {
                MapUtils2 mapUtils2 = INSTANCE;
                Intrinsics.checkNotNull(element$iv$iv$iv, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                temp = mapUtils2.filterRecursively((Map<String, ? extends Object>) element$iv$iv$iv, function2);
            } else {
                temp = element$iv$iv$iv instanceof List ? INSTANCE.filterRecursively((List<?>) element$iv$iv$iv, function2) : element$iv$iv$iv;
            }
            Boolean boolInvoke = function2.invoke(null, temp);
            if (boolInvoke != null) {
                destination$iv$iv.add(boolInvoke);
            }
        }
        return (List) destination$iv$iv;
    }
}

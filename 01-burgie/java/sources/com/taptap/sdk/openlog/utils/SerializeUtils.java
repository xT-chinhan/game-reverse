package com.taptap.sdk.openlog.utils;

import com.tapsdk.tapad.group.constants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONObject;

/* JADX INFO: compiled from: SerializeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b\"\u0006\b\u0000\u0010\t\u0018\u00012\u0006\u0010\n\u001a\u0002H\tH\u0086\b¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0007\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/openlog/utils/SerializeUtils;", "", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "stringify", "", "T", Constants.VALUE_FIELD, "(Ljava/lang/Object;)Ljava/lang/String;", "map", "", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SerializeUtils {
    public static final SerializeUtils INSTANCE = new SerializeUtils();
    private static final Json json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.taptap.sdk.openlog.utils.SerializeUtils$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
            Json.setExplicitNulls(false);
            Json.setEncodeDefaults(true);
        }
    }, 1, null);

    private SerializeUtils() {
    }

    public final Json getJson() {
        return json;
    }

    public final /* synthetic */ <T> String stringify(T value) {
        StringFormat $this$encodeToString$iv = getJson();
        SerializersModule $this$serializer$iv$iv = $this$encodeToString$iv.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, (KType) null);
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$encodeToString$iv.encodeToString(kSerializerSerializer, value);
    }

    public final String stringify(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            Object it = entry.getValue();
            if (it != null) {
                result$iv.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap $this$filterValues$iv = result$iv;
        String string = new JSONObject($this$filterValues$iv).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject(map.filterVal… it != null }).toString()");
        return string;
    }
}

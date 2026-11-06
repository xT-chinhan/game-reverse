package com.taptap.sdk.kit.internal.extensions;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u001a\u0018\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003*\u00020\u0001\u001a\u001a\u0010\u0006\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u0002H\u0007H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"jsonString", "", "paramsMap", "", "", "jsonToStringMap", "toJson", "T", "(Ljava/lang/Object;)Ljava/lang/String;", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class JsonExtKt {
    public static final /* synthetic */ <T> String toJson(T t) {
        TapJson this_$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, (KType) null);
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, t);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
        }
        return strEncodeToString == null ? "json convert error" : strEncodeToString;
    }

    public static final String jsonString(Map<String, ? extends Object> paramsMap) {
        Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
        String string = new JSONObject(paramsMap).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject(paramsMap).toString()");
        return string;
    }

    public static final Map<String, String> jsonToStringMap(String $this$jsonToStringMap) {
        Intrinsics.checkNotNullParameter($this$jsonToStringMap, "<this>");
        try {
            JSONObject jsonObject = new JSONObject($this$jsonToStringMap);
            Map map = new LinkedHashMap();
            Iterator<String> itKeys = jsonObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "jsonObject.keys()");
            while (itKeys.hasNext()) {
                Object element$iv = itKeys.next();
                String key = (String) element$iv;
                Intrinsics.checkNotNullExpressionValue(key, "key");
                map.put(key, jsonObject.isNull(key) ? null : jsonObject.getString(key));
            }
            return map;
        } catch (JSONException e) {
            return MapsKt.emptyMap();
        }
    }
}

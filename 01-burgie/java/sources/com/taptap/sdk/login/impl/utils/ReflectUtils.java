package com.taptap.sdk.login.impl.utils;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: ReflectUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004\"\n\b\u0001\u0010\u0005\u0018\u0001*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u0002H\u0005H\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/ReflectUtils;", "", "()V", "convertAsTyped", "T", "R", "actualType", "Ljava/lang/Class;", "result", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ReflectUtils {
    public static final ReflectUtils INSTANCE = new ReflectUtils();

    private ReflectUtils() {
    }

    public final /* synthetic */ <T, R> T convertAsTyped(Class<T> actualType, R result) {
        T t;
        Intrinsics.checkNotNullParameter(actualType, "actualType");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!Intrinsics.areEqual(actualType, String.class)) {
            if (actualType.isAssignableFrom(result.getClass())) {
                t = (T) result;
            } else {
                throw new IllegalArgumentException("Unsupported return type: " + actualType.getName());
            }
        } else {
            t = null;
            try {
                Json json = TapJson.INSTANCE.getJson();
                SerializersModule serializersModule = json.getSerializersModule();
                Intrinsics.reifiedOperationMarker(6, "R");
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(serializersModule, (KType) null);
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                t = (T) json.encodeToString(kSerializerSerializer, result);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            }
            if (t == null) {
                t = (T) "";
            }
        }
        return t;
    }
}

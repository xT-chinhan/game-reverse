package com.taptap.sdk.core.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: DeSerializeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0002H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/core/utils/DeSerializeUtils;", "", "()V", "deserialize", "T", "", "(Ljava/lang/String;)Ljava/lang/Object;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeSerializeUtils {
    public static final DeSerializeUtils INSTANCE = new DeSerializeUtils();

    private DeSerializeUtils() {
    }

    public final /* synthetic */ <T> T deserialize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Json.Companion companion = Json.INSTANCE;
        SerializersModule serializersModule = companion.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(serializersModule, (KType) null);
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (T) companion.decodeFromString(kSerializerSerializer, str);
    }
}

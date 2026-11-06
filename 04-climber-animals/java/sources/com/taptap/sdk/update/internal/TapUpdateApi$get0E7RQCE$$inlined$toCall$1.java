package com.taptap.sdk.update.internal;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.taptap.sdk.update.internal.TapUpdateApi$get-0E7RQCE$$inlined$toCall$1, reason: invalid class name */
/* JADX INFO: compiled from: TapHttpExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "DataBean", "it", "Lkotlinx/serialization/json/JsonObject;", "invoke", "(Lkotlinx/serialization/json/JsonObject;)Ljava/lang/Object;", "com/taptap/sdk/kit/internal/http/TapHttpExtKt$toCall$1"}, k = 3, mv = {1, 5, 1}, xi = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD)
public final class TapUpdateApi$get0E7RQCE$$inlined$toCall$1<T> extends Lambda implements Function1<JsonObject, T> {
    public static final TapUpdateApi$get0E7RQCE$$inlined$toCall$1 INSTANCE = new TapUpdateApi$get0E7RQCE$$inlined$toCall$1();

    public TapUpdateApi$get0E7RQCE$$inlined$toCall$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(JsonObject jsonObject) {
        TapJson tapJson = TapJson.INSTANCE;
        try {
            if (jsonObject == null) {
                return null;
            }
            Json json = tapJson.getJson();
            SerializersModule serializersModule = json.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T?");
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(serializersModule, (KType) null);
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            KSerializer<Object> kSerializer = kSerializerSerializer;
            return (T) json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            return null;
        }
    }
}

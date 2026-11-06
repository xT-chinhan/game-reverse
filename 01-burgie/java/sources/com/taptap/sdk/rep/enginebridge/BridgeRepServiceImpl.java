package com.taptap.sdk.rep.enginebridge;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeResult;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.rep.TapTapRep;
import com.taptap.sdk.rep.internal.TapRepResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: BridgeRepServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/rep/enginebridge/BridgeRepServiceImpl;", "Lcom/taptap/sdk/rep/enginebridge/BridgeRepService;", "()V", "open", "", "openUrl", "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "Companion", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BridgeRepServiceImpl implements BridgeRepService {
    private static final String TAG = "BridgeRepService";

    @Override // com.taptap.sdk.rep.enginebridge.BridgeRepService
    public void open(String openUrl, final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLogger.logi(TAG, "call open from bridge, openUrl=" + openUrl);
        TapTapRep.open(openUrl, new TapRepResultCallback() { // from class: com.taptap.sdk.rep.enginebridge.BridgeRepServiceImpl.open.1
            @Override // com.taptap.sdk.rep.internal.TapRepResultCallback
            public void onRepSuccess() {
                TapLogger.logi(BridgeRepServiceImpl.TAG, "open success");
                EngineBridgeCallback engineBridgeCallback = callback;
                EngineBridgeResult engineBridgeResult = new EngineBridgeResult(0, (String) null, (Object) null, 4, (DefaultConstructorMarker) null);
                TapJson this_$iv$iv = TapJson.INSTANCE;
                String strEncodeToString = null;
                try {
                    StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, engineBridgeResult);
                } catch (Exception e$iv$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "json convert error";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }

            @Override // com.taptap.sdk.rep.internal.TapRepResultCallback
            public void onRepFail(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                TapLogger.logi(BridgeRepServiceImpl.TAG, "open fail, errorCode=" + errorCode + ", errorMessage=" + errorMessage);
                EngineBridgeCallback engineBridgeCallback = callback;
                EngineBridgeResult engineBridgeResult = new EngineBridgeResult(errorCode, errorMessage, (Object) null, 4, (DefaultConstructorMarker) null);
                TapJson this_$iv$iv = TapJson.INSTANCE;
                String strEncodeToString = null;
                try {
                    StringFormat $this$encodeToString$iv$iv$iv = this_$iv$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv$iv = $this$encodeToString$iv$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv$iv, Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = $this$encodeToString$iv$iv$iv.encodeToString(kSerializerSerializer, engineBridgeResult);
                } catch (Exception e$iv$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv$iv, 2, null);
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "json convert error";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }
        });
    }
}

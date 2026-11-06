package com.taptap.sdk.initializer.gate;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;
import com.anythink.core.common.f.e;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.exception.TapSdkNotInitializedException;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.TapHttpException;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpBackoff;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.utils.TapSignKit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapGatekeeperManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u001c\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0#J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J \u0010'\u001a\u00020\u001a*\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/taptap/sdk/initializer/gate/TapGatekeeperManager;", "", "()V", "GATEKEEPER_SP_NAME", "", "KEY_GATEKEEPER", "TAG", "URL_GATEKEEPER", "defaultGatekeeper", "Lcom/taptap/sdk/initializer/gate/TapGatekeeper;", "gatekeeperPref", "Landroid/content/SharedPreferences;", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tapGatekeeper", "getTapGatekeeper$tap_initializer_release", "()Lcom/taptap/sdk/initializer/gate/TapGatekeeper;", "setTapGatekeeper$tap_initializer_release", "(Lcom/taptap/sdk/initializer/gate/TapGatekeeper;)V", "tapHttp", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", "getTapHttp", "()Lcom/taptap/sdk/kit/internal/http/TapHttp;", "tapHttp$delegate", "Lkotlin/Lazy;", "initialize", "", "context", "Landroid/content/Context;", "initialize$tap_initializer_release", "isAutoEventEnable", "", "isHeartbeatEnable", "queryGatekeeper", "runnable", "Lkotlin/Function0;", "readGatekeeperFromCache", "validateInitialized", "writeGatekeeperToCache", "putProperty", "Lorg/json/JSONObject;", e.a.b, e.a.d, "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapGatekeeperManager {
    private static final String GATEKEEPER_SP_NAME = "com.taptap.sdk.GATEKEEPER_SETTING";
    private static final String KEY_GATEKEEPER = "key_gatekeeper";
    private static final String TAG = "TapGatekeeperManager";
    private static final String URL_GATEKEEPER = "sdk-core/v1/gatekeeper";
    private static TapGatekeeper defaultGatekeeper;
    private static SharedPreferences gatekeeperPref;
    private static TapGatekeeper tapGatekeeper;

    /* JADX INFO: renamed from: tapHttp$delegate, reason: from kotlin metadata */
    private static final Lazy tapHttp;
    public static final TapGatekeeperManager INSTANCE = new TapGatekeeperManager();
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    private TapGatekeeperManager() {
    }

    static {
        TapGatekeeper tapGatekeeper2 = new TapGatekeeper(new TapGatekeeperSwitch(true, true), (TapGateKeeperUrl) null, (Integer) null, 6, (DefaultConstructorMarker) null);
        defaultGatekeeper = tapGatekeeper2;
        tapGatekeeper = tapGatekeeper2;
        tapHttp = LazyKt.lazy(new Function0<TapHttp>() { // from class: com.taptap.sdk.initializer.gate.TapGatekeeperManager$tapHttp$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TapHttp invoke() {
                return TapHttp.INSTANCE.newBuilder("TapSDKCore", "4.5.0").build();
            }
        });
    }

    public final TapGatekeeper getTapGatekeeper$tap_initializer_release() {
        return tapGatekeeper;
    }

    public final void setTapGatekeeper$tap_initializer_release(TapGatekeeper tapGatekeeper2) {
        Intrinsics.checkNotNullParameter(tapGatekeeper2, "<set-?>");
        tapGatekeeper = tapGatekeeper2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapHttp getTapHttp() {
        return (TapHttp) tapHttp.getValue();
    }

    public final void initialize$tap_initializer_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInitialized.compareAndSet(false, true)) {
            TapLogger.logi(TapLogger.TAG, "TapGatekeeper initialize start");
            SharedPreferences sharedPreferences = context.getSharedPreferences(GATEKEEPER_SP_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
            gatekeeperPref = sharedPreferences;
            readGatekeeperFromCache();
            TapLogger.logi(TapLogger.TAG, "TapGatekeeper initialize end\nGatekeeperCache = " + tapGatekeeper);
        }
    }

    private final void validateInitialized() {
        if (!isInitialized.get()) {
            throw new TapSdkNotInitializedException("The TapGatekeeperManager has not been initialized successfully");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeGatekeeperToCache() {
        String strEncodeToString;
        validateInitialized();
        try {
            SharedPreferences sharedPreferences = gatekeeperPref;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gatekeeperPref");
                sharedPreferences = null;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            TapJson tapJson = TapJson.INSTANCE;
            TapGatekeeper tapGatekeeper2 = tapGatekeeper;
            try {
                Json json = tapJson.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapGatekeeper.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, tapGatekeeper2);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            editorEdit.putString(KEY_GATEKEEPER, strEncodeToString).apply();
        } catch (Exception e2) {
            TapLogger.loge$default(TAG, null, e2, 2, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0069 A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x0007, B:5:0x000b, B:6:0x0011, B:10:0x001b, B:15:0x002b, B:25:0x0065, B:27:0x0069, B:29:0x006e, B:21:0x003c, B:24:0x005d, B:28:0x006c), top: B:34:0x0007, inners: #1 }] */
    private final void readGatekeeperFromCache() {
        TapGatekeeper tapGatekeeper2;
        Object objDecodeFromString;
        String str = "";
        validateInitialized();
        try {
            SharedPreferences sharedPreferences = gatekeeperPref;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gatekeeperPref");
                sharedPreferences = null;
            }
            String string = sharedPreferences.getString(KEY_GATEKEEPER, "");
            if (string != null) {
                str = string;
            }
            if (str.length() > 0) {
                TapJson tapJson = TapJson.INSTANCE;
                if (str.length() == 0) {
                    objDecodeFromString = null;
                    tapGatekeeper2 = (TapGatekeeper) objDecodeFromString;
                    if (tapGatekeeper2 == null) {
                        tapGatekeeper2 = defaultGatekeeper;
                    }
                } else {
                    try {
                        Json json = tapJson.getJson();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapGatekeeper.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromString = json.decodeFromString(kSerializerSerializer, str);
                    } catch (Exception e) {
                        TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                        objDecodeFromString = null;
                    }
                    tapGatekeeper2 = (TapGatekeeper) objDecodeFromString;
                    if (tapGatekeeper2 == null) {
                        tapGatekeeper2 = defaultGatekeeper;
                    }
                }
            } else {
                tapGatekeeper2 = defaultGatekeeper;
            }
            tapGatekeeper = tapGatekeeper2;
        } catch (Throwable th) {
            TapLogger.loge$default(TAG, null, th, 2, null);
        }
    }

    public final void queryGatekeeper(Context context, Function0<Unit> runnable) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        JSONObject jSONObject = new JSONObject();
        TapGatekeeperManager tapGatekeeperManager = INSTANCE;
        tapGatekeeperManager.putProperty(jSONObject, "platform", "android");
        tapGatekeeperManager.putProperty(jSONObject, "package_name", context.getPackageName());
        tapGatekeeperManager.putProperty(jSONObject, "package_sign", TapSignKit.INSTANCE.getSign(context));
        BuildersKt__Builders_commonKt.launch$default(TapTapKit.INSTANCE.getTapApplicationScope(), null, null, new AnonymousClass1(jSONObject, runnable, null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.initializer.gate.TapGatekeeperManager$queryGatekeeper$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapGatekeeperManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.initializer.gate.TapGatekeeperManager$queryGatekeeper$1", f = "TapGatekeeperManager.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONObject $params;
        final /* synthetic */ Function0<Unit> $runnable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JSONObject jSONObject, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$params = jSONObject;
            this.$runnable = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$params, this.$runnable, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objMo73enqueueResultgIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AbsTapHttpParam<TapHttpJsonParam> absTapHttpParamRetryBackoff = TapGatekeeperManager.INSTANCE.getTapHttp().postJson(TapGatekeeperManager.URL_GATEKEEPER).addBody(this.$params).retryBackoff(new TapHttpBackoff.Exponential());
                this.label = 1;
                objMo73enqueueResultgIAlus = new TapHttpCall(absTapHttpParamRetryBackoff, new TapHttpParser.SdkDefaultParser(null, new Function1<JsonObject, TapGatekeeper>() { // from class: com.taptap.sdk.initializer.gate.TapGatekeeperManager$queryGatekeeper$1$invokeSuspend$$inlined$toCall$1
                    /* JADX WARN: Type inference failed for: r1v2, types: [com.taptap.sdk.initializer.gate.TapGatekeeper, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public final TapGatekeeper invoke(JsonObject jsonObject) {
                        TapJson tapJson = TapJson.INSTANCE;
                        try {
                            if (jsonObject == null) {
                                return null;
                            }
                            Json json = tapJson.getJson();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(TapGatekeeper.class));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            return json.decodeFromJsonElement(kSerializerSerializer, jsonObject);
                        } catch (Exception e) {
                            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                            return null;
                        }
                    }
                }, i2, 0 == true ? 1 : 0), new TapHttpRetry.SdkDefault(absTapHttpParamRetryBackoff.getBackoffHandler())).mo73enqueueResultgIAlus(600L, this);
                if (objMo73enqueueResultgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objMo73enqueueResultgIAlus = ((Result) obj).getValue();
            }
            Function0<Unit> function0 = this.$runnable;
            if (Result.m191isSuccessimpl(objMo73enqueueResultgIAlus)) {
                TapGatekeeperManager.INSTANCE.setTapGatekeeper$tap_initializer_release((TapGatekeeper) objMo73enqueueResultgIAlus);
                TapGatekeeperManager.INSTANCE.writeGatekeeperToCache();
                TapLogger.logi(TapLogger.TAG, "Refreshes the startup status of the module based on the server configuration\n" + TapGatekeeperManager.INSTANCE.getTapGatekeeper$tap_initializer_release());
                function0.invoke();
            }
            Function0<Unit> function1 = this.$runnable;
            Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objMo73enqueueResultgIAlus);
            if (thM187exceptionOrNullimpl != null && (thM187exceptionOrNullimpl instanceof TapHttpException.ServerError)) {
                TapHttpException.ServerError serverError = (TapHttpException.ServerError) thM187exceptionOrNullimpl;
                String error = serverError.getError().getError();
                String str = TapErrorConstants.ERROR_INVALID_CLIENT;
                if (Intrinsics.areEqual(error, TapErrorConstants.ERROR_INVALID_CLIENT)) {
                    TapGatekeeperManager.INSTANCE.setTapGatekeeper$tap_initializer_release(new TapGatekeeper((TapGatekeeperSwitch) null, (TapGateKeeperUrl) null, (Integer) null, 7, (DefaultConstructorMarker) null));
                    TapGatekeeperManager.INSTANCE.writeGatekeeperToCache();
                    String description = serverError.getError().getDescription();
                    if (description != null) {
                        str = description;
                    }
                    Log.e(TapLogger.TAG, str);
                    Toast.makeText(TapTapKit.INSTANCE.getContext(), serverError.getError().getMsg(), 1).show();
                    function1.invoke();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final boolean isAutoEventEnable() {
        TapGatekeeperSwitch tapGatekeeperSwitch = tapGatekeeper.getSwitch();
        if (tapGatekeeperSwitch != null) {
            return Intrinsics.areEqual((Object) tapGatekeeperSwitch.getAutoEvent(), (Object) true);
        }
        return false;
    }

    public final boolean isHeartbeatEnable() {
        TapGatekeeperSwitch tapGatekeeperSwitch = tapGatekeeper.getSwitch();
        if (tapGatekeeperSwitch != null) {
            return Intrinsics.areEqual((Object) tapGatekeeperSwitch.getHeartbeat(), (Object) true);
        }
        return false;
    }

    private final void putProperty(JSONObject jSONObject, String str, Object obj) throws JSONException {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        jSONObject.put(str, obj);
    }
}

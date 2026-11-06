package com.taptap.sdk.kit.internal.enginebridge;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.enginebridge.command.Command;
import com.taptap.sdk.kit.internal.enginebridge.command.CommandExecutor;
import com.taptap.sdk.kit.internal.enginebridge.exception.EngineBridgeException;
import com.taptap.sdk.kit.internal.enginebridge.internal.BridgeHolder;
import com.taptap.sdk.kit.internal.enginebridge.internal.EngineBridgeReflector;
import com.taptap.sdk.kit.internal.extensions.GameEngineExtKt;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: EngineBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0011J \u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0011\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\u001a\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002J \u0010\u001d\u001a\u00020\u00072\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020 H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridge;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridge;", "()V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "execCommand", "", "command", "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "execCommandAsync", "execCommandAsyncInternal", "Lcom/taptap/sdk/kit/internal/enginebridge/command/Command;", "execCommandInternal", "getCurrentActivity", "getCurrentActivity$tap_common_release", "handleResult", "result", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeResult;", TrackAction.INIT, TTDownloadField.TT_ACTIVITY, "nativeOnResult", "processUnityEngineCommand", "cmdStr", "processUnityEngineCommandAsync", "processUnrealEngineCommand", "processUnrealEngineCommandAsync", "registerService", "serviceClz", "Ljava/lang/Class;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "service", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EngineBridge implements IEngineBridge {
    public static final EngineBridge INSTANCE = new EngineBridge();
    private static WeakReference<Activity> activityRef;

    public final native synchronized void nativeOnResult(String command) throws EngineBridgeException;

    private EngineBridge() {
    }

    public final Activity getCurrentActivity$tap_common_release() {
        WeakReference<Activity> weakReference = activityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.taptap.sdk.kit.internal.enginebridge.IEngineBridge
    public void init(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activityRef = new WeakReference<>(activity);
    }

    @Override // com.taptap.sdk.kit.internal.enginebridge.IEngineBridge
    public void execCommand(String command, EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(command, "command");
        if (!GameEngineExtKt.isUnrealEngine()) {
            if (!GameEngineExtKt.isUnityEngine()) {
                throw new EngineBridgeException("unknown engine");
            }
            processUnityEngineCommand(command, callback);
            return;
        }
        processUnrealEngineCommand(command);
    }

    @Override // com.taptap.sdk.kit.internal.enginebridge.IEngineBridge
    public String execCommandAsync(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        if (GameEngineExtKt.isUnrealEngine()) {
            return processUnrealEngineCommandAsync(command);
        }
        if (GameEngineExtKt.isUnityEngine()) {
            return processUnityEngineCommandAsync(command);
        }
        throw new EngineBridgeException("unknown engine");
    }

    private final void processUnityEngineCommand(String cmdStr, EngineBridgeCallback callback) {
        Object objM534constructorimpl;
        Object objDecodeFromString;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnityEngineCommand: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge $this$processUnityEngineCommand_u24lambda_u240 = this;
            TapJson this_$iv = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                    objDecodeFromString = null;
                }
            }
            Command command = (Command) objDecodeFromString;
            if (command == null) {
                return;
            } else {
                objM534constructorimpl = Result.m534constructorimpl(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getMain(), null, new EngineBridge$processUnityEngineCommand$1$1($this$processUnityEngineCommand_u24lambda_u240, command, callback, null), 2, null));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnityCommand failed: cmd=" + cmdStr + ", cause=" + it.getMessage(), null, 4, null);
        }
    }

    private final String processUnityEngineCommandAsync(String cmdStr) {
        Object objDecodeFromString;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnityEngineCommandAsync: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge $this$processUnityEngineCommandAsync_u24lambda_u242 = this;
            TapJson this_$iv = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                    objDecodeFromString = null;
                }
            }
            Command command = (Command) objDecodeFromString;
            if (command == null) {
                return "";
            }
            return $this$processUnityEngineCommandAsync_u24lambda_u242.execCommandAsyncInternal(command);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable it = Result.m537exceptionOrNullimpl(Result.m534constructorimpl(ResultKt.createFailure(th)));
            if (it != null) {
                TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnityCommand failed: cmd=" + cmdStr + ", cause=" + it.getMessage(), null, 4, null);
            }
            return "";
        }
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.taptap.sdk.kit.internal.enginebridge.EngineBridge$processUnrealEngineCommand$1$callback$1] */
    private final void processUnrealEngineCommand(String cmdStr) {
        Object objM534constructorimpl;
        Object objDecodeFromString;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnrealEngineCommand: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            final EngineBridge $this$processUnrealEngineCommand_u24lambda_u244 = this;
            ?? r4 = new EngineBridgeCallback() { // from class: com.taptap.sdk.kit.internal.enginebridge.EngineBridge$processUnrealEngineCommand$1$callback$1
                @Override // com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback
                public void onResult(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    this.$this_runCatching.nativeOnResult(jsonString);
                }
            };
            TapJson this_$iv = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                    objDecodeFromString = null;
                }
            }
            Command command = (Command) objDecodeFromString;
            if (command == null) {
                return;
            } else {
                objM534constructorimpl = Result.m534constructorimpl(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EngineBridge$processUnrealEngineCommand$1$1($this$processUnrealEngineCommand_u24lambda_u244, command, r4, null), 3, null));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnrealCommand failed: cmd=" + cmdStr + ", cause=" + it.getMessage(), null, 4, null);
        }
    }

    private final String processUnrealEngineCommandAsync(String cmdStr) {
        Object objDecodeFromString;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnrealEngineCommandAsync: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge $this$processUnrealEngineCommandAsync_u24lambda_u246 = this;
            TapJson this_$iv = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    StringFormat $this$decodeFromString$iv$iv = this_$iv.getJson();
                    SerializersModule $this$serializer$iv$iv$iv = $this$decodeFromString$iv$iv.getSerializersModule();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = $this$decodeFromString$iv$iv.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e$iv) {
                    TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                    objDecodeFromString = null;
                }
            }
            Command command = (Command) objDecodeFromString;
            if (command == null) {
                return "";
            }
            return $this$processUnrealEngineCommandAsync_u24lambda_u246.execCommandAsyncInternal(command);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable it = Result.m537exceptionOrNullimpl(Result.m534constructorimpl(ResultKt.createFailure(th)));
            if (it != null) {
                TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnrealCommand failed: cmd=" + cmdStr + ", cause=" + it.getMessage(), null, 4, null);
            }
            return "";
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.enginebridge.EngineBridge$handleResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: EngineBridge.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.kit.internal.enginebridge.EngineBridge$handleResult$1", f = "EngineBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EngineBridgeCallback $callback;
        final /* synthetic */ EngineBridgeResult<String> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EngineBridgeResult<String> engineBridgeResult, EngineBridgeCallback engineBridgeCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = engineBridgeResult;
            this.$callback = engineBridgeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "handle bridge message: content=" + this.$result);
                    EngineBridgeCallback engineBridgeCallback = this.$callback;
                    if (engineBridgeCallback != null) {
                        TapJson this_$iv = TapJson.INSTANCE;
                        EngineBridgeResult<String> engineBridgeResult = this.$result;
                        String strEncodeToString = null;
                        try {
                            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                            strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, engineBridgeResult);
                        } catch (Exception e$iv) {
                            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
                        }
                        if (strEncodeToString == null) {
                            strEncodeToString = "";
                        }
                        engineBridgeCallback.onResult(strEncodeToString);
                        break;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResult(EngineBridgeResult<String> result, EngineBridgeCallback callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnonymousClass1(result, callback, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void execCommandInternal(final Command command, final EngineBridgeCallback callback) {
        Object objM534constructorimpl;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandInternal: " + command);
        try {
            Result.Companion companion = Result.INSTANCE;
            final EngineBridge $this$execCommandInternal_u24lambda_u248 = this;
            new CommandExecutor().execute(command, new EngineBridgeCallback() { // from class: com.taptap.sdk.kit.internal.enginebridge.EngineBridge$execCommandInternal$1$1
                @Override // com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback
                public void onResult(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandInternal success: cmd=" + command + ", result=" + jsonString);
                    $this$execCommandInternal_u24lambda_u248.handleResult(new EngineBridgeResult(0, "Success", jsonString), callback);
                }
            });
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLogger.loge(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandInternal failed: cmd=" + command + ", cause=" + it.getMessage(), it);
            INSTANCE.handleResult(new EngineBridgeResult<>(-1, "Failed", (Object) null, 4, (DefaultConstructorMarker) null), callback);
        }
    }

    private final String execCommandAsyncInternal(Command command) {
        Object objM534constructorimpl;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandAsyncInternal: " + command);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge engineBridge = this;
            Object result = new CommandExecutor().executeAsync(command);
            if (result instanceof String) {
                return (String) result;
            }
            if (Intrinsics.areEqual(result, Boolean.valueOf(result == null))) {
                return "";
            }
            TapJson this_$iv = TapJson.INSTANCE;
            String strEncodeToString = null;
            try {
                StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.nullableTypeOf(Object.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, result);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            }
            objM534constructorimpl = Result.m534constructorimpl(strEncodeToString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLogger.loge(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandAsyncInternal failed: cmd=" + command + ", cause=" + it.getMessage(), it);
        }
        return "";
    }

    @Override // com.taptap.sdk.kit.internal.enginebridge.IEngineBridge
    public void registerService(Class<? extends IEngineBridgeService> serviceClz, IEngineBridgeService service) {
        Intrinsics.checkNotNullParameter(serviceClz, "serviceClz");
        Intrinsics.checkNotNullParameter(service, "service");
        if (EngineBridgeReflector.INSTANCE.checkServiceValid(serviceClz) && serviceClz.isInterface()) {
            BridgeHolder.INSTANCE.registerService(serviceClz, service);
        } else {
            if (EngineBridgeReflector.INSTANCE.getValidService(serviceClz) != null) {
                BridgeHolder.INSTANCE.registerService(serviceClz, service);
                return;
            }
            throw new EngineBridgeException("注册IBridgeService出现错误");
        }
    }
}

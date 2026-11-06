package com.taptap.sdk.kit.internal.enginebridge;

import android.app.Activity;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.enginebridge.command.Command;
import com.taptap.sdk.kit.internal.enginebridge.command.CommandExecutor;
import com.taptap.sdk.kit.internal.enginebridge.exception.EngineBridgeException;
import com.taptap.sdk.kit.internal.enginebridge.internal.BridgeHolder;
import com.taptap.sdk.kit.internal.enginebridge.internal.EngineBridgeReflector;
import com.taptap.sdk.kit.internal.extensions.GameEngineExtKt;
import com.taptap.sdk.kit.internal.json.TapJson;
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
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: EngineBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0011J \u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0011\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\u001a\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002J \u0010\u001d\u001a\u00020\u00072\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020 H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridge;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridge;", "()V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "execCommand", "", "command", "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "execCommandAsync", "execCommandAsyncInternal", "Lcom/taptap/sdk/kit/internal/enginebridge/command/Command;", "execCommandInternal", "getCurrentActivity", "getCurrentActivity$tap_kit_release", "handleResult", "result", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeResult;", "init", "activity", "nativeOnResult", "processUnityEngineCommand", "cmdStr", "processUnityEngineCommandAsync", "processUnrealEngineCommand", "processUnrealEngineCommandAsync", "registerService", "serviceClz", "Ljava/lang/Class;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "service", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EngineBridge implements IEngineBridge {
    public static final EngineBridge INSTANCE = new EngineBridge();
    private static WeakReference<Activity> activityRef;

    public final native synchronized void nativeOnResult(String command) throws EngineBridgeException;

    private EngineBridge() {
    }

    public final Activity getCurrentActivity$tap_kit_release() {
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
        if (GameEngineExtKt.isUnrealEngine()) {
            processUnrealEngineCommand(command);
        } else {
            if (!GameEngineExtKt.isUnityEngine()) {
                throw new EngineBridgeException("unknown engine");
            }
            processUnityEngineCommand(command, callback);
        }
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

    /* JADX WARN: Code duplicated, block: B:18:0x005d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x005e A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #1 {all -> 0x007b, blocks: (B:3:0x0015, B:5:0x0021, B:16:0x0059, B:19:0x005e, B:12:0x002f, B:15:0x0050), top: B:29:0x0015, inners: #0 }] */
    private final void processUnityEngineCommand(String cmdStr, EngineBridgeCallback callback) {
        Object objM184constructorimpl;
        Object objDecodeFromString;
        Command command;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnityEngineCommand: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge engineBridge = this;
            TapJson tapJson = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
                command = (Command) objDecodeFromString;
                if (command == null) {
                    return;
                } else {
                    objM184constructorimpl = Result.m184constructorimpl(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getMain(), null, new EngineBridge$processUnityEngineCommand$1$1(this, command, callback, null), 2, null));
                }
            } else {
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = json.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    objDecodeFromString = null;
                }
                command = (Command) objDecodeFromString;
                if (command == null) {
                    return;
                } else {
                    objM184constructorimpl = Result.m184constructorimpl(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getMain(), null, new EngineBridge$processUnityEngineCommand$1$1(this, command, callback, null), 2, null));
                }
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnityCommand failed: cmd=" + cmdStr + ", cause=" + thM187exceptionOrNullimpl.getMessage(), null, 4, null);
        }
    }

    private final String processUnityEngineCommandAsync(String cmdStr) {
        Object objDecodeFromString;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnityEngineCommandAsync: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge engineBridge = this;
            TapJson tapJson = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = json.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    objDecodeFromString = null;
                }
            }
            Command command = (Command) objDecodeFromString;
            return command == null ? "" : execCommandAsyncInternal(command);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(Result.m184constructorimpl(ResultKt.createFailure(th)));
            if (thM187exceptionOrNullimpl != null) {
                TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnityCommand failed: cmd=" + cmdStr + ", cause=" + thM187exceptionOrNullimpl.getMessage(), null, 4, null);
            }
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0062 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0063 A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #0 {all -> 0x007b, blocks: (B:3:0x0015, B:5:0x0026, B:16:0x005e, B:19:0x0063, B:12:0x0034, B:15:0x0055), top: B:27:0x0015, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.taptap.sdk.kit.internal.enginebridge.EngineBridge$processUnrealEngineCommand$1$callback$1] */
    private final void processUnrealEngineCommand(String cmdStr) {
        Object objM184constructorimpl;
        Object objDecodeFromString;
        Command command;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnrealEngineCommand: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge engineBridge = this;
            ?? r2 = new EngineBridgeCallback() { // from class: com.taptap.sdk.kit.internal.enginebridge.EngineBridge$processUnrealEngineCommand$1$callback$1
                @Override // com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback
                public void onResult(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    this.$this_runCatching.nativeOnResult(jsonString);
                }
            };
            TapJson tapJson = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
                command = (Command) objDecodeFromString;
                if (command == null) {
                    return;
                } else {
                    objM184constructorimpl = Result.m184constructorimpl(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EngineBridge$processUnrealEngineCommand$1$1(this, command, r2, null), 3, null));
                }
            } else {
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = json.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    objDecodeFromString = null;
                }
                command = (Command) objDecodeFromString;
                if (command == null) {
                    return;
                } else {
                    objM184constructorimpl = Result.m184constructorimpl(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EngineBridge$processUnrealEngineCommand$1$1(this, command, r2, null), 3, null));
                }
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnrealCommand failed: cmd=" + cmdStr + ", cause=" + thM187exceptionOrNullimpl.getMessage(), null, 4, null);
        }
    }

    private final String processUnrealEngineCommandAsync(String cmdStr) {
        Object objDecodeFromString;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "processUnrealEngineCommandAsync: " + cmdStr);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge engineBridge = this;
            TapJson tapJson = TapJson.INSTANCE;
            String str = cmdStr;
            if (str == null || str.length() == 0) {
                objDecodeFromString = null;
            } else {
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Command.class));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    objDecodeFromString = json.decodeFromString(kSerializerSerializer, cmdStr);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    objDecodeFromString = null;
                }
            }
            Command command = (Command) objDecodeFromString;
            return command == null ? "" : execCommandAsyncInternal(command);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(Result.m184constructorimpl(ResultKt.createFailure(th)));
            if (thM187exceptionOrNullimpl != null) {
                TapLogger.loge$default(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execUnrealCommand failed: cmd=" + cmdStr + ", cause=" + thM187exceptionOrNullimpl.getMessage(), null, 4, null);
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
            String strEncodeToString;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "handle bridge message: content=" + this.$result);
            EngineBridgeCallback engineBridgeCallback = this.$callback;
            if (engineBridgeCallback != null) {
                TapJson tapJson = TapJson.INSTANCE;
                EngineBridgeResult<String> engineBridgeResult = this.$result;
                try {
                    Json json = tapJson.getJson();
                    KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(EngineBridgeResult.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
                    Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    strEncodeToString = json.encodeToString(kSerializerSerializer, engineBridgeResult);
                } catch (Exception e) {
                    TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    strEncodeToString = null;
                }
                if (strEncodeToString == null) {
                    strEncodeToString = "";
                }
                engineBridgeCallback.onResult(strEncodeToString);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResult(EngineBridgeResult<String> result, EngineBridgeCallback callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnonymousClass1(result, callback, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void execCommandInternal(final Command command, final EngineBridgeCallback callback) {
        Object objM184constructorimpl;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandInternal: " + command);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge engineBridge = this;
            new CommandExecutor().execute(command, new EngineBridgeCallback() { // from class: com.taptap.sdk.kit.internal.enginebridge.EngineBridge$execCommandInternal$1$1
                @Override // com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback
                public void onResult(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandInternal success: cmd=" + command + ", result=" + jsonString);
                    this.handleResult(new EngineBridgeResult(0, "Success", jsonString), callback);
                }
            });
            objM184constructorimpl = Result.m184constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            TapLogger.loge(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandInternal failed: cmd=" + command + ", cause=" + thM187exceptionOrNullimpl.getMessage(), thM187exceptionOrNullimpl);
            INSTANCE.handleResult(new EngineBridgeResult<>(-1, "Failed", (Object) null, 4, (DefaultConstructorMarker) null), callback);
        }
    }

    private final String execCommandAsyncInternal(Command command) {
        Object objM184constructorimpl;
        String strEncodeToString;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandAsyncInternal: " + command);
        try {
            Result.Companion companion = Result.INSTANCE;
            EngineBridge engineBridge = this;
            Object objExecuteAsync = new CommandExecutor().executeAsync(command);
            if (objExecuteAsync instanceof String) {
                return (String) objExecuteAsync;
            }
            if (Intrinsics.areEqual(objExecuteAsync, Boolean.valueOf(objExecuteAsync == null))) {
                return "";
            }
            try {
                Json json = TapJson.INSTANCE.getJson();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.nullableTypeOf(Object.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = json.encodeToString(kSerializerSerializer, objExecuteAsync);
            } catch (Exception e) {
                TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                strEncodeToString = null;
            }
            objM184constructorimpl = Result.m184constructorimpl(strEncodeToString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            TapLogger.loge(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "execCommandAsyncInternal failed: cmd=" + command + ", cause=" + thM187exceptionOrNullimpl.getMessage(), thM187exceptionOrNullimpl);
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

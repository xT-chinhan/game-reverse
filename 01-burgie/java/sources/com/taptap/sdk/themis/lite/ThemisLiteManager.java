package com.taptap.sdk.themis.lite;

import com.taptap.sdk.themis.lite.data.model.OneID;
import com.taptap.sdk.themis.lite.data.model.ThemisLiteConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: ThemisLiteManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nR\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/themis/lite/ThemisLiteManager;", "", "builder", "Lcom/taptap/sdk/themis/lite/ThemisLiteManager$Builder;", "(Lcom/taptap/sdk/themis/lite/ThemisLiteManager$Builder;)V", "config", "Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;", "(Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;)V", "_oneIDFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_tdidFlow", "json", "Lkotlinx/serialization/json/Json;", "oneIDFlow", "Lkotlinx/coroutines/flow/Flow;", "tdidFlow", "getTdidFlow", "()Lkotlinx/coroutines/flow/Flow;", "getCurrentTdid", "getOneID", "Lcom/taptap/sdk/themis/lite/data/model/OneID;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTdid", "initialize", "", "preOneID", "Builder", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ThemisLiteManager {
    private MutableStateFlow<String> _oneIDFlow;
    private MutableStateFlow<String> _tdidFlow;
    private final ThemisLiteConfig config;
    private final Json json;
    private Flow<String> oneIDFlow;
    private final Flow<String> tdidFlow;

    /* JADX INFO: renamed from: com.taptap.sdk.themis.lite.ThemisLiteManager$getOneID$1, reason: invalid class name */
    /* JADX INFO: compiled from: ThemisLiteManager.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.themis.lite.ThemisLiteManager", f = "ThemisLiteManager.kt", i = {0}, l = {83}, m = "getOneID", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThemisLiteManager.this.getOneID(this);
        }
    }

    public /* synthetic */ ThemisLiteManager(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ThemisLiteManager(ThemisLiteConfig config) {
        this.config = config;
        this.json = JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.taptap.sdk.themis.lite.ThemisLiteManager$json$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setIgnoreUnknownKeys(true);
            }
        }, 1, null);
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._tdidFlow = MutableStateFlow;
        this.tdidFlow = FlowKt.filterNotNull(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._oneIDFlow = MutableStateFlow2;
        this.oneIDFlow = FlowKt.filterNotNull(MutableStateFlow2);
    }

    public final Flow<String> getTdidFlow() {
        return this.tdidFlow;
    }

    private ThemisLiteManager(Builder builder) {
        this(builder.getConfig());
    }

    public final void initialize(String preOneID) {
        Intrinsics.checkNotNullParameter(preOneID, "preOneID");
        ThemisLite.InitThemis_v3(this.config.getAppID(), new ThemisLiteCallback() { // from class: com.taptap.sdk.themis.lite.ThemisLiteManager.initialize.1
            @Override // com.taptap.sdk.themis.lite.ThemisLiteCallback
            public void tdidCallback(String tdid) {
                ThemisLiteManager.this._tdidFlow.setValue(tdid);
            }

            @Override // com.taptap.sdk.themis.lite.ThemisLiteCallback
            public void gidDataCallback(String gidData) {
                Intrinsics.checkNotNullParameter(gidData, "gidData");
                ThemisLiteManager.this._oneIDFlow.setValue(gidData);
            }
        }, preOneID, this.config.getTimeout());
    }

    public final Object getTdid(Continuation<? super String> continuation) {
        return FlowKt.firstOrNull(this.tdidFlow, continuation);
    }

    public final String getCurrentTdid() {
        return this._tdidFlow.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getOneID(Continuation<? super OneID> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object objFirstOrNull;
        ThemisLiteManager themisLiteManager;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<String> flow = this.oneIDFlow;
                    anonymousClass2.L$0 = this;
                    anonymousClass2.label = 1;
                    objFirstOrNull = FlowKt.firstOrNull(flow, anonymousClass2);
                    if (objFirstOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    themisLiteManager = this;
                    break;
                    break;
                case 1:
                    themisLiteManager = (ThemisLiteManager) anonymousClass2.L$0;
                    ResultKt.throwOnFailure($result);
                    objFirstOrNull = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String jsonStr = (String) objFirstOrNull;
            if (jsonStr == null) {
                return null;
            }
            StringFormat $this$decodeFromString$iv = themisLiteManager.json;
            SerializersModule $this$serializer$iv$iv = $this$decodeFromString$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.nullableTypeOf(OneID.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (OneID) $this$decodeFromString$iv.decodeFromString(kSerializerSerializer, jsonStr);
        } catch (Throwable error) {
            error.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: compiled from: ThemisLiteManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/taptap/sdk/themis/lite/ThemisLiteManager$Builder;", "", "()V", "<set-?>", "Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;", "config", "getConfig$tap_core_release", "()Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;", "build", "Lcom/taptap/sdk/themis/lite/ThemisLiteManager;", "setAppID", "appID", "", "setInitGADID", "initGADID", "", "setInitThemisTapaid", "initThemisTapaid", "setTimeout", "timeout", "", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private ThemisLiteConfig config = new ThemisLiteConfig(null, 0, null, false, false, 31, null);

        /* JADX INFO: renamed from: getConfig$tap_core_release, reason: from getter */
        public final ThemisLiteConfig getConfig() {
            return this.config;
        }

        public final Builder setAppID(String appID) {
            Intrinsics.checkNotNullParameter(appID, "appID");
            Builder $this$setAppID_u24lambda_u240 = this;
            $this$setAppID_u24lambda_u240.config = ThemisLiteConfig.copy$default($this$setAppID_u24lambda_u240.config, appID, 0L, null, false, false, 30, null);
            return this;
        }

        public final Builder setTimeout(long timeout) {
            Builder $this$setTimeout_u24lambda_u241 = this;
            $this$setTimeout_u24lambda_u241.config = ThemisLiteConfig.copy$default($this$setTimeout_u24lambda_u241.config, null, timeout, null, false, false, 29, null);
            return this;
        }

        public final Builder setInitThemisTapaid(boolean initThemisTapaid) {
            Builder $this$setInitThemisTapaid_u24lambda_u242 = this;
            $this$setInitThemisTapaid_u24lambda_u242.config = ThemisLiteConfig.copy$default($this$setInitThemisTapaid_u24lambda_u242.config, null, 0L, null, initThemisTapaid, false, 23, null);
            return this;
        }

        public final Builder setInitGADID(boolean initGADID) {
            Builder $this$setInitGADID_u24lambda_u243 = this;
            $this$setInitGADID_u24lambda_u243.config = ThemisLiteConfig.copy$default($this$setInitGADID_u24lambda_u243.config, null, 0L, null, false, initGADID, 15, null);
            return this;
        }

        public final ThemisLiteManager build() {
            return new ThemisLiteManager(this, null);
        }
    }
}

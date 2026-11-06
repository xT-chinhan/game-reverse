package com.taptap.sdk.themis.lite;

import com.taptap.sdk.themis.lite.data.model.OneID;
import com.taptap.sdk.themis.lite.data.model.ThemisLiteConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: ThemisLiteManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nR\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/taptap/sdk/themis/lite/ThemisLiteManager;", "", "builder", "Lcom/taptap/sdk/themis/lite/ThemisLiteManager$Builder;", "(Lcom/taptap/sdk/themis/lite/ThemisLiteManager$Builder;)V", "config", "Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;", "(Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;)V", "_oneIDFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_tdidFlow", "tdidFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getTdidFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getCurrentTdid", "getOneID", "Lcom/taptap/sdk/themis/lite/data/model/OneID;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTdid", "initialize", "", "preOneID", "Builder", "tap-themis-lite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThemisLiteManager {
    private MutableStateFlow<String> _oneIDFlow;
    private MutableStateFlow<String> _tdidFlow;
    private final ThemisLiteConfig config;
    private final StateFlow<String> tdidFlow;

    /* JADX INFO: renamed from: com.taptap.sdk.themis.lite.ThemisLiteManager$getOneID$1, reason: invalid class name */
    /* JADX INFO: compiled from: ThemisLiteManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.themis.lite.ThemisLiteManager", f = "ThemisLiteManager.kt", i = {}, l = {77}, m = "getOneID", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
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

    private ThemisLiteManager(ThemisLiteConfig themisLiteConfig) {
        this.config = themisLiteConfig;
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._tdidFlow = MutableStateFlow;
        this.tdidFlow = MutableStateFlow;
        this._oneIDFlow = StateFlowKt.MutableStateFlow(null);
    }

    public final StateFlow<String> getTdidFlow() {
        return this.tdidFlow;
    }

    private ThemisLiteManager(Builder builder) {
        this(builder.getConfig());
    }

    public final void initialize(String preOneID) {
        Intrinsics.checkNotNullParameter(preOneID, "preOneID");
        ThemisLite.InitThemis_v2(this.config.getAppID(), new ThemisLiteCallback() { // from class: com.taptap.sdk.themis.lite.ThemisLiteManager.initialize.1
            @Override // com.taptap.sdk.themis.lite.ThemisLiteCallback
            public void getThemisTapaid(String tapaid) {
                Intrinsics.checkNotNullParameter(tapaid, "tapaid");
                ThemisLiteManager.this._tdidFlow.setValue(tapaid);
            }

            @Override // com.taptap.sdk.themis.lite.ThemisLiteCallback
            public void getThemisOneIDData(String oneIDData) {
                Intrinsics.checkNotNullParameter(oneIDData, "oneIDData");
                ThemisLiteManager.this._oneIDFlow.setValue(oneIDData);
            }
        }, this.config.getTimeout(), preOneID, this.config.getInitThemisTapaid(), this.config.getInitGADID());
    }

    public final Object getTdid(Continuation<? super String> continuation) {
        return FlowKt.firstOrNull(this._tdidFlow, continuation);
    }

    public final String getCurrentTdid() {
        return this._tdidFlow.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getOneID(Continuation<? super OneID> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
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
        Object objFirst = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow flowFilterNotNull = FlowKt.filterNotNull(this._oneIDFlow);
            anonymousClass1.label = 1;
            objFirst = FlowKt.first(flowFilterNotNull, anonymousClass1);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFirst);
        }
        String str = (String) objFirst;
        try {
            Json.Companion companion = Json.INSTANCE;
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.nullableTypeOf(OneID.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (OneID) companion.decodeFromString(kSerializerSerializer, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: compiled from: ThemisLiteManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/taptap/sdk/themis/lite/ThemisLiteManager$Builder;", "", "()V", "<set-?>", "Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;", "config", "getConfig$tap_themis_lite_release", "()Lcom/taptap/sdk/themis/lite/data/model/ThemisLiteConfig;", "build", "Lcom/taptap/sdk/themis/lite/ThemisLiteManager;", "setAppID", "appID", "", "setInitGADID", "initGADID", "", "setInitThemisTapaid", "initThemisTapaid", "setTimeout", "timeout", "", "tap-themis-lite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private ThemisLiteConfig config = new ThemisLiteConfig(null, 0, null, false, false, 31, null);

        /* JADX INFO: renamed from: getConfig$tap_themis_lite_release, reason: from getter */
        public final ThemisLiteConfig getConfig() {
            return this.config;
        }

        public final Builder setAppID(String appID) {
            Intrinsics.checkNotNullParameter(appID, "appID");
            this.config = ThemisLiteConfig.copy$default(this.config, appID, 0L, null, false, false, 30, null);
            return this;
        }

        public final Builder setTimeout(long timeout) {
            this.config = ThemisLiteConfig.copy$default(this.config, null, timeout, null, false, false, 29, null);
            return this;
        }

        public final Builder setInitThemisTapaid(boolean initThemisTapaid) {
            this.config = ThemisLiteConfig.copy$default(this.config, null, 0L, null, initThemisTapaid, false, 23, null);
            return this;
        }

        public final Builder setInitGADID(boolean initGADID) {
            this.config = ThemisLiteConfig.copy$default(this.config, null, 0L, null, false, initGADID, 15, null);
            return this;
        }

        public final ThemisLiteManager build() {
            return new ThemisLiteManager(this, null);
        }
    }
}

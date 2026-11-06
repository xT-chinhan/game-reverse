package com.taptap.sdk.initializer.manager;

import android.content.Context;
import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.initializer.api.TapInitState;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.initializer.repository.GatekeeperRepository;
import com.taptap.sdk.initializer.repository.local.PrefsGatekeeperStorage;
import com.taptap.sdk.initializer.repository.remote.GatekeeperApiService;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.retrofit2.Retrofit;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: GatekeeperManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002,-B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0017\u001a\u00020\rJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0000J\b\u0010!\u001a\u00020\u001bH\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\rH\u0007R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/taptap/sdk/initializer/manager/GatekeeperManager;", "", "builder", "Lcom/taptap/sdk/initializer/manager/GatekeeperManager$Builder;", "(Lcom/taptap/sdk/initializer/manager/GatekeeperManager$Builder;)V", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "listeners", "", "Lcom/taptap/sdk/initializer/manager/GatekeeperManager$OnGateKeeperChangeListener;", "onInitStateChange", "Lkotlin/Function1;", "Lcom/taptap/sdk/initializer/api/TapInitState;", "", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "repository", "Lcom/taptap/sdk/initializer/repository/GatekeeperRepository;", "getRepository", "()Lcom/taptap/sdk/initializer/repository/GatekeeperRepository;", "repository$delegate", "Lkotlin/Lazy;", TrackAction.CANCEL, "getBaseUrl", "", "isRND", "", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "getCurrentGateKeeper", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "initialize", "isGatekeeperLoadedSuccessfully", "provideNetworkApiService", "Lcom/taptap/sdk/initializer/repository/remote/GatekeeperApiService;", "region", "provideStorage", "Lcom/taptap/sdk/initializer/repository/local/PrefsGatekeeperStorage;", d.R, "Landroid/content/Context;", "setupGateKeeperFlow", "setupInitStateFlow", "showGatekeeperError", "Builder", "OnGateKeeperChangeListener", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GatekeeperManager {
    private final CoroutineScope coroutineScope;
    private final List<OnGateKeeperChangeListener> listeners;
    private final Function1<TapInitState, Unit> onInitStateChange;
    private final TapTapSdkOptions options;

    /* JADX INFO: renamed from: repository$delegate, reason: from kotlin metadata */
    private final Lazy repository;

    /* JADX INFO: compiled from: GatekeeperManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/initializer/manager/GatekeeperManager$OnGateKeeperChangeListener;", "", "onGateKeeperChange", "", "newValue", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnGateKeeperChangeListener {
        void onGateKeeperChange(GateKeeper newValue);
    }

    /* JADX INFO: compiled from: GatekeeperManager.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionType.values().length];
            try {
                iArr[RegionType.CN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RegionType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ GatekeeperManager(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private GatekeeperManager(TapTapSdkOptions options, List<? extends OnGateKeeperChangeListener> list, Function1<? super TapInitState, Unit> function1) {
        this.options = options;
        this.listeners = list;
        this.onInitStateChange = function1;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.repository = LazyKt.lazy(new Function0<GatekeeperRepository>() { // from class: com.taptap.sdk.initializer.manager.GatekeeperManager$repository$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GatekeeperRepository invoke() {
                Context context = this.this$0.options.getContext();
                GatekeeperApiService gatekeeperApiServiceProvideNetworkApiService = this.this$0.provideNetworkApiService(TapTapKit.INSTANCE.isRND(), this.this$0.options.getRegion());
                GatekeeperManager gatekeeperManager = this.this$0;
                return new GatekeeperRepository(context, gatekeeperApiServiceProvideNetworkApiService, gatekeeperManager.provideStorage(gatekeeperManager.options.getContext()), null, 8, null);
            }
        });
    }

    private GatekeeperManager(Builder builder) {
        this(builder.getOptions(), builder.getListeners$tap_core_release(), builder.getOnInitStateChange$tap_core_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GatekeeperRepository getRepository() {
        return (GatekeeperRepository) this.repository.getValue();
    }

    public final GatekeeperManager initialize() {
        GatekeeperManager $this$initialize_u24lambda_u240 = this;
        $this$initialize_u24lambda_u240.setupGateKeeperFlow();
        $this$initialize_u24lambda_u240.setupInitStateFlow();
        $this$initialize_u24lambda_u240.getRepository().initialize();
        return this;
    }

    public final void cancel() {
        getRepository().cancel();
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
    }

    public final GateKeeper getCurrentGateKeeper() {
        return getRepository().getCurrentGateKeeper();
    }

    @Deprecated(message = "请改用 GatekeeperRepository.initStateFlow 观察真实状态机")
    public final boolean isGatekeeperLoadedSuccessfully() {
        return getRepository().isGatekeeperLoadedSuccessfully();
    }

    @Deprecated(message = "请改用 GatekeeperRepository.initStateFlow 观察真实状态机")
    public final void showGatekeeperError() {
        getRepository().showGatekeeperError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PrefsGatekeeperStorage provideStorage(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.taptap.sdk.GATEKEEPER_SETTING", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ODE_PRIVATE\n            )");
        return new PrefsGatekeeperStorage(sharedPreferences, JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.taptap.sdk.initializer.manager.GatekeeperManager.provideStorage.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.setIgnoreUnknownKeys(true);
                Json.setLenient(true);
            }
        }, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GatekeeperApiService provideNetworkApiService(boolean isRND, RegionType region) {
        Retrofit retrofit = NetworkClientKt.provideRetrofitWithCallTimeout(getBaseUrl(isRND, region), 1000L);
        Object objCreate = retrofit.create(GatekeeperApiService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "retrofit.create(GatekeeperApiService::class.java)");
        return (GatekeeperApiService) objCreate;
    }

    private final String getBaseUrl(boolean isRND, RegionType regionType) {
        if (!isRND) {
            switch (WhenMappings.$EnumSwitchMapping$0[regionType.ordinal()]) {
                case 1:
                    return "https://tapsdk.tapapis.cn";
                case 2:
                    return "https://tapsdk.tapapis.com";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        switch (WhenMappings.$EnumSwitchMapping$0[regionType.ordinal()]) {
            case 1:
                return "https://tapsdk.api.xdrnd.cn";
            case 2:
                return "https://tapsdk.api.xdrnd.com";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.initializer.manager.GatekeeperManager$setupGateKeeperFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GatekeeperManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.initializer.manager.GatekeeperManager$setupGateKeeperFlow$1", f = "GatekeeperManager.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    static final class C03441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03441(Continuation<? super C03441> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GatekeeperManager.this.new C03441(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<GateKeeper> gateKeeperFlow = GatekeeperManager.this.getRepository().getGateKeeperFlow();
                    final GatekeeperManager gatekeeperManager = GatekeeperManager.this;
                    this.label = 1;
                    if (gateKeeperFlow.collect(new FlowCollector() { // from class: com.taptap.sdk.initializer.manager.GatekeeperManager.setupGateKeeperFlow.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((GateKeeper) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(GateKeeper gateKeeper, Continuation<? super Unit> continuation) {
                            Iterable $this$forEach$iv = gatekeeperManager.listeners;
                            for (Object element$iv : $this$forEach$iv) {
                                OnGateKeeperChangeListener listener = (OnGateKeeperChangeListener) element$iv;
                                listener.onGateKeeperChange(gateKeeper);
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private final void setupGateKeeperFlow() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03441(null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.initializer.manager.GatekeeperManager$setupInitStateFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GatekeeperManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.initializer.manager.GatekeeperManager$setupInitStateFlow$1", f = "GatekeeperManager.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID}, m = "invokeSuspend", n = {}, s = {})
    static final class C03451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03451(Continuation<? super C03451> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GatekeeperManager.this.new C03451(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<TapInitState> initStateFlow = GatekeeperManager.this.getRepository().getInitStateFlow();
                    final GatekeeperManager gatekeeperManager = GatekeeperManager.this;
                    this.label = 1;
                    if (initStateFlow.collect(new FlowCollector() { // from class: com.taptap.sdk.initializer.manager.GatekeeperManager.setupInitStateFlow.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((TapInitState) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(TapInitState state, Continuation<? super Unit> continuation) {
                            Function1 function1 = gatekeeperManager.onInitStateChange;
                            if (function1 != null) {
                                function1.invoke(state);
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private final void setupInitStateFlow() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03451(null), 3, null);
    }

    /* JADX INFO: compiled from: GatekeeperManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bR*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR:\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/taptap/sdk/initializer/manager/GatekeeperManager$Builder;", "", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "<set-?>", "", "Lcom/taptap/sdk/initializer/manager/GatekeeperManager$OnGateKeeperChangeListener;", "listeners", "getListeners$tap_core_release", "()Ljava/util/List;", "Lkotlin/Function1;", "Lcom/taptap/sdk/initializer/api/TapInitState;", "", "onInitStateChange", "getOnInitStateChange$tap_core_release", "()Lkotlin/jvm/functions/Function1;", "getOptions", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "addOnGateKeeperChangeListener", "listener", "build", "Lcom/taptap/sdk/initializer/manager/GatekeeperManager;", "setOnInitStateChangeListener", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private List<OnGateKeeperChangeListener> listeners;
        private Function1<? super TapInitState, Unit> onInitStateChange;
        private final TapTapSdkOptions options;

        public Builder(TapTapSdkOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.options = options;
            this.listeners = new ArrayList();
        }

        public final TapTapSdkOptions getOptions() {
            return this.options;
        }

        public final List<OnGateKeeperChangeListener> getListeners$tap_core_release() {
            return this.listeners;
        }

        public final Function1<TapInitState, Unit> getOnInitStateChange$tap_core_release() {
            return this.onInitStateChange;
        }

        public final Builder addOnGateKeeperChangeListener(OnGateKeeperChangeListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Builder $this$addOnGateKeeperChangeListener_u24lambda_u240 = this;
            $this$addOnGateKeeperChangeListener_u24lambda_u240.listeners.add(listener);
            return this;
        }

        public final Builder setOnInitStateChangeListener(Function1<? super TapInitState, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Builder $this$setOnInitStateChangeListener_u24lambda_u241 = this;
            $this$setOnInitStateChangeListener_u24lambda_u241.onInitStateChange = listener;
            return this;
        }

        public final GatekeeperManager build() {
            return new GatekeeperManager(this, null);
        }
    }
}

package com.taptap.sdk.initializer.repository;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.initializer.api.TapInitState;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.initializer.repository.local.GatekeeperStorage;
import com.taptap.sdk.initializer.repository.remote.GatekeeperApiService;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.d;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: GatekeeperRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\rJ\n\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0011H\u0007J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u001dH\u0007R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/taptap/sdk/initializer/repository/GatekeeperRepository;", "", d.R, "Landroid/content/Context;", "apiService", "Lcom/taptap/sdk/initializer/repository/remote/GatekeeperApiService;", "storage", "Lcom/taptap/sdk/initializer/repository/local/GatekeeperStorage;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/taptap/sdk/initializer/repository/remote/GatekeeperApiService;Lcom/taptap/sdk/initializer/repository/local/GatekeeperStorage;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_gateKeeperFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "_initStateFlow", "Lcom/taptap/sdk/initializer/api/TapInitState;", "cancelled", "", "commitLock", "gateKeeperFlow", "Lkotlinx/coroutines/flow/Flow;", "getGateKeeperFlow", "()Lkotlinx/coroutines/flow/Flow;", "initStateFlow", "getInitStateFlow", "memoryData", "scope", "Lkotlinx/coroutines/CoroutineScope;", TrackAction.CANCEL, "", "commitDegradedSuccess", "getCurrentGateKeeper", "getGateKeeperFromDisk", "initialize", "Lkotlinx/coroutines/Job;", "isGatekeeperLoadedSuccessfully", "showErrorToast", "tapNetworkException", "Lcom/taptap/sdk/common/network/throwable/TapNetworkException;", "showGatekeeperError", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GatekeeperRepository {
    private static final String DEFAULT_GATEKEEPER_ERROR_TOAST = "当前应用初始化信息错误, 请在 TapTap 开发者中心检查[当前应用包名]与[调用初始化接口设置的 clientId 、clientToken]是否匹配";
    public static final long NETWORK_CALL_TIMEOUT_MILLIS = 1000;
    private final MutableSharedFlow<GateKeeper> _gateKeeperFlow;
    private final MutableSharedFlow<TapInitState> _initStateFlow;
    private final GatekeeperApiService apiService;
    private boolean cancelled;
    private final Object commitLock;
    private final Context context;
    private final Flow<GateKeeper> gateKeeperFlow;
    private final Flow<TapInitState> initStateFlow;
    private final GateKeeper memoryData;
    private final CoroutineScope scope;
    private final GatekeeperStorage storage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GatekeeperRepository(Context context, GatekeeperApiService apiService, GatekeeperStorage storage) {
        this(context, apiService, storage, null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        Intrinsics.checkNotNullParameter(storage, "storage");
    }

    public GatekeeperRepository(Context context, GatekeeperApiService apiService, GatekeeperStorage storage, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.context = context;
        this.apiService = apiService;
        this.storage = storage;
        this.scope = CoroutineScopeKt.CoroutineScope(ioDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.commitLock = new Object();
        this.memoryData = new GateKeeper(new GateKeeper.Switch(true, true), (Integer) null, (GateKeeper.Urls) null, (GateKeeper.SdkConfig) null, 14, (DefaultConstructorMarker) null);
        MutableSharedFlow<GateKeeper> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_OLDEST);
        this._gateKeeperFlow = MutableSharedFlow;
        this.gateKeeperFlow = FlowKt.distinctUntilChanged(MutableSharedFlow);
        MutableSharedFlow<TapInitState> MutableSharedFlow2 = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_OLDEST);
        this._initStateFlow = MutableSharedFlow2;
        this.initStateFlow = FlowKt.distinctUntilChanged(MutableSharedFlow2);
    }

    public /* synthetic */ GatekeeperRepository(Context context, GatekeeperApiService gatekeeperApiService, GatekeeperStorage gatekeeperStorage, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, gatekeeperApiService, gatekeeperStorage, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final Flow<GateKeeper> getGateKeeperFlow() {
        return this.gateKeeperFlow;
    }

    public final Flow<TapInitState> getInitStateFlow() {
        return this.initStateFlow;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.initializer.repository.GatekeeperRepository$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatekeeperRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.initializer.repository.GatekeeperRepository$initialize$1", f = "GatekeeperRepository.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GatekeeperRepository.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0077  */
        /* JADX WARN: Code duplicated, block: B:33:0x007b  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:38:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:44:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:46:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:49:0x00d6 A[DONT_GENERATE] */
        /* JADX WARN: Code duplicated, block: B:51:0x00d8 A[Catch: all -> 0x00f6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:47:0x00d0, B:51:0x00d8), top: B:59:0x00d0 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Throwable throwable;
            AnonymousClass1 anonymousClass2;
            GateKeeper networkData;
            GatekeeperRepository gatekeeperRepository;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            GateKeeper gateKeeper = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    GatekeeperRepository.this._initStateFlow.tryEmit(TapInitState.InProgress.INSTANCE);
                    GateKeeper diskData = GatekeeperRepository.this.getGateKeeperFromDisk();
                    GatekeeperRepository gatekeeperRepository2 = GatekeeperRepository.this;
                    MutableSharedFlow mutableSharedFlow = gatekeeperRepository2._gateKeeperFlow;
                    if (diskData == null) {
                        diskData = gatekeeperRepository2.memoryData;
                    }
                    mutableSharedFlow.tryEmit(diskData);
                    try {
                        anonymousClass1.label = 1;
                        Object objWithTimeout = TimeoutKt.withTimeout(1000L, new GatekeeperRepository$initialize$1$networkData$1(GatekeeperRepository.this, null), anonymousClass1);
                        if (objWithTimeout != coroutine_suspended) {
                            $result = objWithTimeout;
                            try {
                                gateKeeper = (GateKeeper) $result;
                            } catch (TimeoutCancellationException e) {
                                $result = $result;
                                anonymousClass2 = anonymousClass1;
                                GatekeeperRepository.this.commitDegradedSuccess();
                                anonymousClass1 = anonymousClass2;
                            } catch (Throwable th) {
                                AnonymousClass1 anonymousClass3 = anonymousClass1;
                                throwable = th;
                                $result = $result;
                                anonymousClass2 = anonymousClass3;
                                if (throwable instanceof CancellationException) {
                                    throw throwable;
                                }
                                if ((throwable instanceof TapNetworkException) || !Intrinsics.areEqual(((TapNetworkException) throwable).getErr().getApiErr(), ApiErr.INVALID_CLIENT.INSTANCE)) {
                                    GatekeeperRepository.this.commitDegradedSuccess();
                                } else {
                                    GatekeeperRepository.this.showErrorToast((TapNetworkException) throwable);
                                    GatekeeperRepository.this._initStateFlow.tryEmit(new TapInitState.Failed(1001, ((TapNetworkException) throwable).getErr().getMsg()));
                                }
                                anonymousClass1 = anonymousClass2;
                            }
                            networkData = gateKeeper;
                            if (networkData != null) {
                                gatekeeperRepository = GatekeeperRepository.this;
                                synchronized (gatekeeperRepository.commitLock) {
                                    if (gatekeeperRepository.cancelled) {
                                        gatekeeperRepository.storage.saveGateKeeper(networkData);
                                        gatekeeperRepository._gateKeeperFlow.tryEmit(networkData);
                                        gatekeeperRepository._initStateFlow.tryEmit(TapInitState.Success.INSTANCE);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    } catch (TimeoutCancellationException e2) {
                        anonymousClass2 = anonymousClass1;
                        GatekeeperRepository.this.commitDegradedSuccess();
                        anonymousClass1 = anonymousClass2;
                        networkData = gateKeeper;
                        if (networkData != null) {
                            gatekeeperRepository = GatekeeperRepository.this;
                            synchronized (gatekeeperRepository.commitLock) {
                                if (gatekeeperRepository.cancelled) {
                                    gatekeeperRepository.storage.saveGateKeeper(networkData);
                                    gatekeeperRepository._gateKeeperFlow.tryEmit(networkData);
                                    gatekeeperRepository._initStateFlow.tryEmit(TapInitState.Success.INSTANCE);
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throwable = th2;
                        anonymousClass2 = anonymousClass1;
                        if (throwable instanceof CancellationException) {
                            throw throwable;
                        }
                        if (throwable instanceof TapNetworkException) {
                            GatekeeperRepository.this.commitDegradedSuccess();
                        } else {
                            GatekeeperRepository.this.commitDegradedSuccess();
                        }
                        anonymousClass1 = anonymousClass2;
                        networkData = gateKeeper;
                        if (networkData != null) {
                            gatekeeperRepository = GatekeeperRepository.this;
                            synchronized (gatekeeperRepository.commitLock) {
                                if (gatekeeperRepository.cancelled) {
                                    gatekeeperRepository.storage.saveGateKeeper(networkData);
                                    gatekeeperRepository._gateKeeperFlow.tryEmit(networkData);
                                    gatekeeperRepository._initStateFlow.tryEmit(TapInitState.Success.INSTANCE);
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                case 1:
                    anonymousClass2 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = anonymousClass2;
                        gateKeeper = (GateKeeper) $result;
                    } catch (TimeoutCancellationException e3) {
                        GatekeeperRepository.this.commitDegradedSuccess();
                        anonymousClass1 = anonymousClass2;
                        networkData = gateKeeper;
                        if (networkData != null) {
                            gatekeeperRepository = GatekeeperRepository.this;
                            synchronized (gatekeeperRepository.commitLock) {
                                if (gatekeeperRepository.cancelled) {
                                    gatekeeperRepository.storage.saveGateKeeper(networkData);
                                    gatekeeperRepository._gateKeeperFlow.tryEmit(networkData);
                                    gatekeeperRepository._initStateFlow.tryEmit(TapInitState.Success.INSTANCE);
                                    Unit unit4 = Unit.INSTANCE;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        throwable = th3;
                        if (throwable instanceof CancellationException) {
                            throw throwable;
                        }
                        if (throwable instanceof TapNetworkException) {
                            GatekeeperRepository.this.commitDegradedSuccess();
                        } else {
                            GatekeeperRepository.this.commitDegradedSuccess();
                        }
                        anonymousClass1 = anonymousClass2;
                        networkData = gateKeeper;
                        if (networkData != null) {
                            gatekeeperRepository = GatekeeperRepository.this;
                            synchronized (gatekeeperRepository.commitLock) {
                                if (gatekeeperRepository.cancelled) {
                                    gatekeeperRepository.storage.saveGateKeeper(networkData);
                                    gatekeeperRepository._gateKeeperFlow.tryEmit(networkData);
                                    gatekeeperRepository._initStateFlow.tryEmit(TapInitState.Success.INSTANCE);
                                    Unit unit5 = Unit.INSTANCE;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    networkData = gateKeeper;
                    if (networkData != null) {
                        gatekeeperRepository = GatekeeperRepository.this;
                        synchronized (gatekeeperRepository.commitLock) {
                            if (gatekeeperRepository.cancelled) {
                                gatekeeperRepository.storage.saveGateKeeper(networkData);
                                gatekeeperRepository._gateKeeperFlow.tryEmit(networkData);
                                gatekeeperRepository._initStateFlow.tryEmit(TapInitState.Success.INSTANCE);
                                Unit unit6 = Unit.INSTANCE;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job initialize() {
        return BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitDegradedSuccess() {
        synchronized (this.commitLock) {
            if (this.cancelled) {
                return;
            }
            this._initStateFlow.tryEmit(TapInitState.Success.INSTANCE);
        }
    }

    public final GateKeeper getCurrentGateKeeper() {
        GateKeeper gateKeeper = (GateKeeper) CollectionsKt.firstOrNull((List) this._gateKeeperFlow.getReplayCache());
        return gateKeeper == null ? this.memoryData : gateKeeper;
    }

    public final void cancel() {
        synchronized (this.commitLock) {
            this.cancelled = true;
            Unit unit = Unit.INSTANCE;
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    @Deprecated(message = "请改用 initStateFlow 观察真实状态机")
    public final boolean isGatekeeperLoadedSuccessfully() {
        return CollectionsKt.lastOrNull((List) this._initStateFlow.getReplayCache()) instanceof TapInitState.Success;
    }

    @Deprecated(message = "请改用 initStateFlow 观察真实状态机")
    public final void showGatekeeperError() {
        TapInitState state = (TapInitState) CollectionsKt.lastOrNull((List) this._initStateFlow.getReplayCache());
        if (state instanceof TapInitState.Failed) {
            SysExtKt.showToast(((TapInitState.Failed) state).getErrorMsg());
            TapLogger.loge$default("TapInitializer", ((TapInitState.Failed) state).getErrorMsg(), null, 4, null);
        } else {
            SysExtKt.showToast("当前应用还未初始化");
            TapLogger.loge$default("TapInitializer", "当前应用还未初始化: 请在调用 SDK 业务接口前，先调用 [TapTapSDK.init()] 接口", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GateKeeper getGateKeeperFromDisk() {
        return this.storage.getGateKeeper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorToast(TapNetworkException tapNetworkException) {
        SysExtKt.showToast(tapNetworkException.getErr().getMsg());
        String description = tapNetworkException.getErr().getDescription();
        if (description == null) {
            description = DEFAULT_GATEKEEPER_ERROR_TOAST;
        }
        TapLogger.loge$default("TapInitializer", description, null, 4, null);
    }
}

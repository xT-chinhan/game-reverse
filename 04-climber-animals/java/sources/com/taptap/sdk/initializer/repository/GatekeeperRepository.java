package com.taptap.sdk.initializer.repository;

import android.content.Context;
import android.widget.Toast;
import com.taptap.sdk.common.network.retry.RetryStrategy;
import com.taptap.sdk.common.network.retry.RetryUtils;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.initializer.data.response.GateKeeper;
import com.taptap.sdk.initializer.repository.local.GatekeeperStorage;
import com.taptap.sdk.initializer.repository.remote.GatekeeperApiService;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.umeng.analytics.pro.g;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: GatekeeperRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\n\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0006\u0010\u001f\u001a\u00020\u001dR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/taptap/sdk/initializer/repository/GatekeeperRepository;", "", g.X, "Landroid/content/Context;", "apiService", "Lcom/taptap/sdk/initializer/repository/remote/GatekeeperApiService;", "storage", "Lcom/taptap/sdk/initializer/repository/local/GatekeeperStorage;", "(Landroid/content/Context;Lcom/taptap/sdk/initializer/repository/remote/GatekeeperApiService;Lcom/taptap/sdk/initializer/repository/local/GatekeeperStorage;)V", "_gateKeeperFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/taptap/sdk/initializer/data/response/GateKeeper;", "gateKeeperFlow", "Lkotlinx/coroutines/flow/Flow;", "getGateKeeperFlow", "()Lkotlinx/coroutines/flow/Flow;", "gatekeeperError", "Lcom/taptap/sdk/common/network/throwable/TapNetworkException;", "loadGatekeeperSuccess", "", "memoryData", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getCurrentGateKeeper", "getGateKeeperFromDisk", "initialize", "Lkotlinx/coroutines/Job;", "isGatekeeperLoadedSuccessfully", "showErrorToast", "", "tapNetworkException", "showGatekeeperError", "Companion", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GatekeeperRepository {
    private static final String DEFAULT_GATEKEEPER_ERROR_TOAST = "当前应用初始化信息错误, 请在 TapTap 开发者中心检查[当前应用包名]与[调用初始化接口设置的 clientId 、clientToken]是否匹配";
    private final MutableSharedFlow<GateKeeper> _gateKeeperFlow;
    private final GatekeeperApiService apiService;
    private final Context context;
    private final Flow<GateKeeper> gateKeeperFlow;
    private TapNetworkException gatekeeperError;
    private boolean loadGatekeeperSuccess;
    private final GateKeeper memoryData;
    private final CoroutineScope scope;
    private final GatekeeperStorage storage;

    public GatekeeperRepository(Context context, GatekeeperApiService apiService, GatekeeperStorage storage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.context = context;
        this.apiService = apiService;
        this.storage = storage;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.memoryData = new GateKeeper(new GateKeeper.Switch(true, true), (Integer) null, (GateKeeper.Urls) null, (GateKeeper.SdkConfig) null, 14, (DefaultConstructorMarker) null);
        MutableSharedFlow<GateKeeper> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this._gateKeeperFlow = mutableSharedFlowMutableSharedFlow$default;
        this.gateKeeperFlow = FlowKt.distinctUntilChanged(mutableSharedFlowMutableSharedFlow$default);
        this.loadGatekeeperSuccess = true;
    }

    public final Flow<GateKeeper> getGateKeeperFlow() {
        return this.gateKeeperFlow;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.initializer.repository.GatekeeperRepository$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatekeeperRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.initializer.repository.GatekeeperRepository$initialize$1", f = "GatekeeperRepository.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            GateKeeper gateKeeper = null;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GateKeeper gateKeeperFromDisk = GatekeeperRepository.this.getGateKeeperFromDisk();
                    GatekeeperRepository gatekeeperRepository = GatekeeperRepository.this;
                    MutableSharedFlow mutableSharedFlow = gatekeeperRepository._gateKeeperFlow;
                    if (gateKeeperFromDisk == null) {
                        gateKeeperFromDisk = gatekeeperRepository.memoryData;
                    }
                    mutableSharedFlow.tryEmit(gateKeeperFromDisk);
                    this.label = 1;
                    obj = RetryUtils.INSTANCE.retry(new RetryStrategy.Exponential(0L, 0L, 3, null), new GatekeeperRepository$initialize$1$networkData$result$1(GatekeeperRepository.this, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GateKeeper gateKeeper2 = (GateKeeper) obj;
                GatekeeperRepository.this.loadGatekeeperSuccess = true;
                GatekeeperRepository.this.gatekeeperError = null;
                gateKeeper = gateKeeper2;
            } catch (Throwable th) {
                if (th instanceof TapNetworkException) {
                    TapNetworkException tapNetworkException = th;
                    if (Intrinsics.areEqual(tapNetworkException.getErr().getApiErr(), ApiErr.INVALID_CLIENT.INSTANCE)) {
                        GatekeeperRepository.this.loadGatekeeperSuccess = false;
                        GatekeeperRepository.this.gatekeeperError = tapNetworkException;
                        GatekeeperRepository.this.showErrorToast(tapNetworkException);
                    }
                }
            }
            if (gateKeeper != null) {
                GatekeeperRepository gatekeeperRepository2 = GatekeeperRepository.this;
                gatekeeperRepository2.storage.saveGateKeeper(gateKeeper);
                gatekeeperRepository2._gateKeeperFlow.tryEmit(gateKeeper);
            }
            return Unit.INSTANCE;
        }
    }

    public final Job initialize() {
        return BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final GateKeeper getCurrentGateKeeper() {
        GateKeeper gateKeeper = (GateKeeper) CollectionsKt.firstOrNull((List) this._gateKeeperFlow.getReplayCache());
        return gateKeeper == null ? this.memoryData : gateKeeper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GateKeeper getGateKeeperFromDisk() {
        return this.storage.getGateKeeper();
    }

    /* JADX INFO: renamed from: com.taptap.sdk.initializer.repository.GatekeeperRepository$showErrorToast$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GatekeeperRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.initializer.repository.GatekeeperRepository$showErrorToast$1", f = "GatekeeperRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapNetworkException $tapNetworkException;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08171(TapNetworkException tapNetworkException, Continuation<? super C08171> continuation) {
            super(2, continuation);
            this.$tapNetworkException = tapNetworkException;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GatekeeperRepository.this.new C08171(this.$tapNetworkException, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(GatekeeperRepository.this.context, this.$tapNetworkException.getErr().getMsg(), 0).show();
            String description = this.$tapNetworkException.getErr().getDescription();
            if (description == null) {
                description = GatekeeperRepository.DEFAULT_GATEKEEPER_ERROR_TOAST;
            }
            TapLogger.loge$default("TapInitializer", description, null, 4, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorToast(TapNetworkException tapNetworkException) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new C08171(tapNetworkException, null), 3, null);
    }

    public final void showGatekeeperError() {
        TapNetworkException tapNetworkException = this.gatekeeperError;
        if (tapNetworkException == null) {
            SysExtKt.showToast("当前应用还未初始化");
            TapLogger.loge$default("TapInitializer", "当前应用还未初始化: 请在调用 SDK 业务接口前，先调用 [TapTapSDK.init()] 接口", null, 4, null);
        } else if (tapNetworkException != null) {
            showErrorToast(tapNetworkException);
        }
    }

    /* JADX INFO: renamed from: isGatekeeperLoadedSuccessfully, reason: from getter */
    public final boolean getLoadGatekeeperSuccess() {
        return this.loadGatekeeperSuccess;
    }
}

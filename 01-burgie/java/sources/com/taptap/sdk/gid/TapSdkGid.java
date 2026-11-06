package com.taptap.sdk.gid;

import android.util.Log;
import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.common.services.GidService;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.gid.data.response.Gid;
import com.taptap.sdk.gid.repository.GidRepository;
import com.taptap.sdk.gid.service.disk.GidDiskServiceFactory;
import com.taptap.sdk.gid.service.network.DefaultGidNetworkService;
import com.taptap.sdk.gid.service.network.GidApiService;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.retrofit2.Retrofit;
import com.taptap.sdk.themis.lite.ThemisLiteManager;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
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
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: TapSdkGid.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0002*+B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010\u0016J\u0006\u0010\u001a\u001a\u00020\u0000J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\tJ\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010)\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/taptap/sdk/gid/TapSdkGid;", "", "builder", "Lcom/taptap/sdk/gid/TapSdkGid$Builder;", "(Lcom/taptap/sdk/gid/TapSdkGid$Builder;)V", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tdidCallbacks", "", "Lcom/taptap/sdk/common/services/GidService$TdidCallback;", "gidCallbacks", "Lcom/taptap/sdk/common/services/GidService$GidCallback;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;Ljava/util/List;Ljava/util/List;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "gidRepository", "Lcom/taptap/sdk/gid/repository/GidRepository;", "getCurrentGid", "Lcom/taptap/sdk/gid/data/response/Gid;", "getCurrentTdid", "", "getGid", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGidAsync", "", "getTdid", "initialize", "notifyListenersGidUpdated", Common.Predefined.GID, "notifyListenersTdidUpdated", Common.Predefined.TDID, "provideGidApiService", "Lcom/taptap/sdk/gid/service/network/GidApiService;", "isRND", "", "registerGidCallback", "callback", "registerTdidCallback", "setupGidFlowCollection", "setupTdidFlowCollection", "unregisterGidCallback", "unregisterTdidCallback", "Builder", "Runtime", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapSdkGid {
    private static volatile TapSdkGid INSTANCE = null;

    /* JADX INFO: renamed from: Runtime, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "TapSdkGid";
    private final CoroutineScope coroutineScope;
    private List<? extends GidService.GidCallback> gidCallbacks;
    private final GidRepository gidRepository;
    private TapTapSdkOptions options;
    private List<? extends GidService.TdidCallback> tdidCallbacks;

    /* JADX INFO: compiled from: TapSdkGid.kt */
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

    public /* synthetic */ TapSdkGid(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public TapSdkGid(TapTapSdkOptions options, List<? extends GidService.TdidCallback> tdidCallbacks, List<? extends GidService.GidCallback> gidCallbacks) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(tdidCallbacks, "tdidCallbacks");
        Intrinsics.checkNotNullParameter(gidCallbacks, "gidCallbacks");
        this.options = options;
        this.tdidCallbacks = tdidCallbacks;
        this.gidCallbacks = gidCallbacks;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.gidRepository = new GidRepository(GidDiskServiceFactory.INSTANCE.create(this.options.getContext(), this.options.getRegion(), true), new DefaultGidNetworkService(provideGidApiService(TapTapKit.INSTANCE.isRND(), this.options)), new ThemisLiteManager.Builder().setAppID(this.options.getRegion().getValue()).setTimeout(5000L).setInitThemisTapaid(this.options.getRegion() == RegionType.CN).setInitGADID(this.options.getRegion() == RegionType.GLOBAL).build());
    }

    private TapSdkGid(Builder builder) {
        this(builder.getOptions(), builder.getTdidCallbacks(), builder.getGidCallbacks());
    }

    public final TapSdkGid initialize() {
        TapSdkGid $this$initialize_u24lambda_u240 = this;
        $this$initialize_u24lambda_u240.setupTdidFlowCollection();
        $this$initialize_u24lambda_u240.setupGidFlowCollection();
        $this$initialize_u24lambda_u240.gidRepository.initialize();
        $this$initialize_u24lambda_u240.getGidAsync();
        return this;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.gid.TapSdkGid$setupTdidFlowCollection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TapSdkGid.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.gid.TapSdkGid$setupTdidFlowCollection$1", f = "TapSdkGid.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class C03431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03431(Continuation<? super C03431> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TapSdkGid.this.new C03431(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<String> tdidFlow = TapSdkGid.this.gidRepository.getTdidFlow();
                    final TapSdkGid tapSdkGid = TapSdkGid.this;
                    this.label = 1;
                    if (tdidFlow.collect(new FlowCollector() { // from class: com.taptap.sdk.gid.TapSdkGid.setupTdidFlowCollection.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((String) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(String tdid, Continuation<? super Unit> continuation) {
                            tapSdkGid.notifyListenersTdidUpdated(tdid);
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

    private final void setupTdidFlowCollection() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03431(null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.gid.TapSdkGid$setupGidFlowCollection$1, reason: invalid class name */
    /* JADX INFO: compiled from: TapSdkGid.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.gid.TapSdkGid$setupGidFlowCollection$1", f = "TapSdkGid.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TapSdkGid.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<Gid> gidFlow = TapSdkGid.this.gidRepository.getGidFlow();
                    final TapSdkGid tapSdkGid = TapSdkGid.this;
                    this.label = 1;
                    if (gidFlow.collect(new FlowCollector() { // from class: com.taptap.sdk.gid.TapSdkGid.setupGidFlowCollection.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Gid) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(Gid gid, Continuation<? super Unit> continuation) {
                            tapSdkGid.notifyListenersGidUpdated(gid.getId());
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

    private final void setupGidFlowCollection() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void getGidAsync() {
        try {
            this.gidRepository.getGidAsync();
        } catch (Throwable error) {
            Log.e(TAG, "获取 gid 失败", error);
        }
    }

    public final Gid getCurrentGid() {
        return this.gidRepository.getCurrentGid();
    }

    public final String getCurrentTdid() {
        return this.gidRepository.getCurrentTdid();
    }

    public final Object getGid(Continuation<? super Gid> continuation) {
        return this.gidRepository.getGid(continuation);
    }

    public final Object getTdid(Continuation<? super String> continuation) {
        return this.gidRepository.getTdid(continuation);
    }

    public final void registerTdidCallback(GidService.TdidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.tdidCallbacks = CollectionsKt.plus((Collection<? extends GidService.TdidCallback>) this.tdidCallbacks, callback);
    }

    public final void unregisterTdidCallback(GidService.TdidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.tdidCallbacks = CollectionsKt.minus(this.tdidCallbacks, callback);
    }

    public final void registerGidCallback(GidService.GidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.gidCallbacks = CollectionsKt.plus((Collection<? extends GidService.GidCallback>) this.gidCallbacks, callback);
    }

    public final void unregisterGidCallback(GidService.GidCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.gidCallbacks = CollectionsKt.minus(this.gidCallbacks, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListenersTdidUpdated(String tdid) {
        Iterable $this$forEach$iv = this.tdidCallbacks;
        for (Object element$iv : $this$forEach$iv) {
            GidService.TdidCallback callback = (GidService.TdidCallback) element$iv;
            try {
                Result.Companion companion = Result.INSTANCE;
                TapSdkGid tapSdkGid = this;
                callback.onTdidUpdated(tdid);
                Result.m534constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m534constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListenersGidUpdated(String gid) {
        Iterable $this$forEach$iv = this.gidCallbacks;
        for (Object element$iv : $this$forEach$iv) {
            GidService.GidCallback callback = (GidService.GidCallback) element$iv;
            try {
                Result.Companion companion = Result.INSTANCE;
                TapSdkGid tapSdkGid = this;
                callback.onGidUpdated(gid);
                Result.m534constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m534constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    private static final String provideGidApiService$getBaseUrl(boolean isRND, RegionType regionType) {
        if (isRND) {
            switch (WhenMappings.$EnumSwitchMapping$0[regionType.ordinal()]) {
                case 1:
                    return "https://gid.api.xdrnd.cn";
                case 2:
                    return "https://gid.api.xdrnd.com";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        switch (WhenMappings.$EnumSwitchMapping$0[regionType.ordinal()]) {
            case 1:
                return "https://gid.tapapis.cn";
            case 2:
                return "https://gid.tapapis.com";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final GidApiService provideGidApiService(boolean isRND, TapTapSdkOptions options) {
        Retrofit retrofit = NetworkClientKt.provideRetrofit$default(provideGidApiService$getBaseUrl(isRND, options.getRegion()), null, 2, null);
        Object objCreate = retrofit.create(GidApiService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "retrofit.create(GidApiService::class.java)");
        return (GidApiService) objCreate;
    }

    /* JADX INFO: compiled from: TapSdkGid.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011R*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/gid/TapSdkGid$Builder;", "", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "<set-?>", "", "Lcom/taptap/sdk/common/services/GidService$GidCallback;", "gidCallbacks", "getGidCallbacks", "()Ljava/util/List;", "getOptions", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "Lcom/taptap/sdk/common/services/GidService$TdidCallback;", "tdidCallbacks", "getTdidCallbacks", "build", "Lcom/taptap/sdk/gid/TapSdkGid;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private List<? extends GidService.GidCallback> gidCallbacks;
        private final TapTapSdkOptions options;
        private List<? extends GidService.TdidCallback> tdidCallbacks;

        public Builder(TapTapSdkOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.options = options;
            this.tdidCallbacks = new CopyOnWriteArrayList();
            this.gidCallbacks = new CopyOnWriteArrayList();
        }

        public final TapTapSdkOptions getOptions() {
            return this.options;
        }

        public final List<GidService.TdidCallback> getTdidCallbacks() {
            return this.tdidCallbacks;
        }

        public final List<GidService.GidCallback> getGidCallbacks() {
            return this.gidCallbacks;
        }

        public final TapSdkGid build() {
            return new TapSdkGid(this, null);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.gid.TapSdkGid$Runtime, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TapSdkGid.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/gid/TapSdkGid$Runtime;", "", "()V", "INSTANCE", "Lcom/taptap/sdk/gid/TapSdkGid;", "getINSTANCE$tap_core_release", "()Lcom/taptap/sdk/gid/TapSdkGid;", "setINSTANCE$tap_core_release", "(Lcom/taptap/sdk/gid/TapSdkGid;)V", "TAG", "", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TapSdkGid getINSTANCE$tap_core_release() {
            return TapSdkGid.INSTANCE;
        }

        public final void setINSTANCE$tap_core_release(TapSdkGid tapSdkGid) {
            TapSdkGid.INSTANCE = tapSdkGid;
        }
    }
}

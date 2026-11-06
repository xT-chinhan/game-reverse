package com.taptap.sdk.gid.repository;

import com.taptap.sdk.common.network.retry.RetryStrategy;
import com.taptap.sdk.common.network.retry.RetryUtils;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.gid.data.response.Gid;
import com.taptap.sdk.gid.service.GidService;
import com.taptap.sdk.gid.service.network.GidNetworkService;
import com.taptap.sdk.themis.lite.ThemisLiteManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: GidRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u000bH\u0002R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/taptap/sdk/gid/repository/GidRepository;", "", "gidDiskService", "Lcom/taptap/sdk/gid/service/GidService;", "gidNetworkService", "Lcom/taptap/sdk/gid/service/network/GidNetworkService;", "themisLiteManager", "Lcom/taptap/sdk/themis/lite/ThemisLiteManager;", "(Lcom/taptap/sdk/gid/service/GidService;Lcom/taptap/sdk/gid/service/network/GidNetworkService;Lcom/taptap/sdk/themis/lite/ThemisLiteManager;)V", "_gidStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/taptap/sdk/gid/data/response/Gid;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "gidFlow", "Lkotlinx/coroutines/flow/Flow;", "getGidFlow", "()Lkotlinx/coroutines/flow/Flow;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tdidFlow", "", "getTdidFlow", "getCurrentGid", "getCurrentTdid", "getGid", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGidAsync", "", "getGidFromDisk", "getTdid", "initialize", "saveToDisk", Common.Predefined.GID, "tap-gid_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GidRepository {
    private final MutableStateFlow<Gid> _gidStateFlow;
    private final CoroutineScope coroutineScope;
    private final GidService gidDiskService;
    private final Flow<Gid> gidFlow;
    private final GidNetworkService gidNetworkService;
    private final Mutex mutex;
    private final Flow<String> tdidFlow;
    private final ThemisLiteManager themisLiteManager;

    public GidRepository(GidService gidDiskService, GidNetworkService gidNetworkService, ThemisLiteManager themisLiteManager) {
        Intrinsics.checkNotNullParameter(gidDiskService, "gidDiskService");
        Intrinsics.checkNotNullParameter(gidNetworkService, "gidNetworkService");
        Intrinsics.checkNotNullParameter(themisLiteManager, "themisLiteManager");
        this.gidDiskService = gidDiskService;
        this.gidNetworkService = gidNetworkService;
        this.themisLiteManager = themisLiteManager;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        MutableStateFlow<Gid> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._gidStateFlow = MutableStateFlow;
        this.gidFlow = FlowKt.filterNotNull(MutableStateFlow);
        this.tdidFlow = FlowKt.filterNotNull(themisLiteManager.getTdidFlow());
    }

    public final Flow<Gid> getGidFlow() {
        return this.gidFlow;
    }

    public final Flow<String> getTdidFlow() {
        return this.tdidFlow;
    }

    public final void initialize() {
        String id;
        ThemisLiteManager themisLiteManager = this.themisLiteManager;
        Gid gidFromDisk = getGidFromDisk();
        if (gidFromDisk == null || (id = gidFromDisk.getId()) == null) {
            id = "";
        }
        themisLiteManager.initialize(id);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.gid.repository.GidRepository$getGidAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: GidRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.gid.repository.GidRepository$getGidAsync$1", f = "GidRepository.kt", i = {0, 1}, l = {180, 102}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GidRepository.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            GidRepository gidRepository;
            GidRepository gidRepository2;
            Mutex mutex2;
            Gid gid;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = GidRepository.this.mutex;
                        gidRepository = GidRepository.this;
                        this.L$0 = mutex;
                        this.L$1 = gidRepository;
                        this.label = 1;
                        if (mutex.lock(null, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            gidRepository2 = (GidRepository) this.L$1;
                            mutex2 = (Mutex) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                gid = (Gid) obj;
                            } catch (Throwable unused) {
                                gid = null;
                            }
                            if (gid != null) {
                                try {
                                    gidRepository2.saveToDisk(gid);
                                    gidRepository2._gidStateFlow.setValue(gid);
                                } catch (Throwable th) {
                                    th = th;
                                    mutex = mutex2;
                                    mutex.unlock(null);
                                    throw th;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        }
                        gidRepository = (GidRepository) this.L$1;
                        Mutex mutex3 = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                    }
                    RetryUtils retryUtils = RetryUtils.INSTANCE;
                    RetryStrategy.Exponential exponential = new RetryStrategy.Exponential(0L, 0L, 3, null);
                    GidRepository$getGidAsync$1$1$networkData$1 gidRepository$getGidAsync$1$1$networkData$1 = new GidRepository$getGidAsync$1$1$networkData$1(gidRepository, null);
                    this.L$0 = mutex;
                    this.L$1 = gidRepository;
                    this.label = 2;
                    Object objRetry = retryUtils.retry(exponential, gidRepository$getGidAsync$1$1$networkData$1, this);
                    if (objRetry == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gidRepository2 = gidRepository;
                    mutex2 = mutex;
                    obj = objRetry;
                    gid = (Gid) obj;
                    if (gid != null) {
                        gidRepository2.saveToDisk(gid);
                        gidRepository2._gidStateFlow.setValue(gid);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable unused2) {
                    gidRepository2 = gidRepository;
                    mutex2 = mutex;
                    gid = null;
                }
                Gid gidFromDisk = gidRepository.getGidFromDisk();
                if (gidFromDisk != null) {
                    gidRepository._gidStateFlow.setValue(gidFromDisk);
                }
            } catch (Throwable th2) {
                th = th2;
                mutex.unlock(null);
                throw th;
            }
        }
    }

    public final void getGidAsync() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final Gid getCurrentGid() {
        return this._gidStateFlow.getValue();
    }

    public final String getCurrentTdid() {
        return this.themisLiteManager.getCurrentTdid();
    }

    public final Object getGid(Continuation<? super Gid> continuation) {
        return FlowKt.firstOrNull(this.gidFlow, continuation);
    }

    public final Object getTdid(Continuation<? super String> continuation) {
        return this.themisLiteManager.getTdid(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveToDisk(Gid gid) {
        try {
            GidService gidService = this.gidDiskService;
            Json.Companion companion = Json.INSTANCE;
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(Gid.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            gidService.setGid(companion.encodeToString(kSerializerSerializer, gid));
        } catch (Throwable unused) {
        }
    }

    public final Gid getGidFromDisk() {
        try {
            Json.Companion companion = Json.INSTANCE;
            String gid = this.gidDiskService.getGid();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.nullableTypeOf(Gid.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (Gid) companion.decodeFromString(kSerializerSerializer, gid);
        } catch (Throwable unused) {
            return null;
        }
    }
}

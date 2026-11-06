package com.taptap.sdk.gid.repository;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.common.network.retry.RetryStrategy;
import com.taptap.sdk.common.network.retry.RetryUtils;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.gid.data.response.Gid;
import com.taptap.sdk.gid.service.GidService;
import com.taptap.sdk.gid.service.network.GidNetworkService;
import com.taptap.sdk.kit.internal.json.TapJson;
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
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: GidRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u000bH\u0002R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/gid/repository/GidRepository;", "", "gidDiskService", "Lcom/taptap/sdk/gid/service/GidService;", "gidNetworkService", "Lcom/taptap/sdk/gid/service/network/GidNetworkService;", "themisLiteManager", "Lcom/taptap/sdk/themis/lite/ThemisLiteManager;", "(Lcom/taptap/sdk/gid/service/GidService;Lcom/taptap/sdk/gid/service/network/GidNetworkService;Lcom/taptap/sdk/themis/lite/ThemisLiteManager;)V", "_gidStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/taptap/sdk/gid/data/response/Gid;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "gidFlow", "Lkotlinx/coroutines/flow/Flow;", "getGidFlow", "()Lkotlinx/coroutines/flow/Flow;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tdidFlow", "", "getTdidFlow", "getCurrentGid", "getCurrentTdid", "getGid", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGidAsync", "", "getGidFromDisk", "getTdid", "initialize", "saveToDisk", Common.Predefined.GID, "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        this.tdidFlow = themisLiteManager.getTdidFlow();
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
    @DebugMetadata(c = "com.taptap.sdk.gid.repository.GidRepository$getGidAsync$1", f = "GidRepository.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD, 102}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
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

        /* JADX WARN: Code duplicated, block: B:19:0x0077 A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #1 {all -> 0x00e8, blocks: (B:17:0x0071, B:19:0x0077), top: B:44:0x0071 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x00ab A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
        /* JADX WARN: Code duplicated, block: B:32:0x00ca  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v9 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v4, types: [com.taptap.sdk.gid.repository.GidRepository] */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v13 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v5 */
        /* JADX WARN: Type inference failed for: r9v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r9;
            ?? r8;
            ?? r7;
            ?? r6;
            ?? r10;
            ?? r11;
            ?? r12;
            ?? r13;
            ?? r14;
            Throwable th;
            Gid gid;
            AnonymousClass1 anonymousClass1;
            Object obj2;
            Mutex mutex;
            GidRepository gidRepository;
            Gid gidFromDisk;
            Object objRetry;
            Object obj3;
            Object obj4;
            ?? r15;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Gid gid2 = null;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        anonymousClass1 = this;
                        obj2 = obj;
                        Mutex mutex2 = GidRepository.this.mutex;
                        GidRepository gidRepository2 = GidRepository.this;
                        anonymousClass1.L$0 = mutex2;
                        anonymousClass1.L$1 = gidRepository2;
                        anonymousClass1.label = 1;
                        if (mutex2.lock(null, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r13 = mutex2;
                        mutex = null;
                        r14 = 0;
                        gidRepository = gidRepository2;
                        try {
                            gidFromDisk = gidRepository.getGidFromDisk();
                            if (gidFromDisk != null) {
                                gidRepository._gidStateFlow.setValue(gidFromDisk);
                                break;
                            }
                            RetryUtils retryUtils = RetryUtils.INSTANCE;
                            RetryStrategy.Exponential exponential = new RetryStrategy.Exponential(0L, 0L, 3, null);
                            GidRepository$getGidAsync$1$1$networkData$1 gidRepository$getGidAsync$1$1$networkData$1 = new GidRepository$getGidAsync$1$1$networkData$1(gidRepository, null);
                            anonymousClass1.L$0 = r13;
                            anonymousClass1.L$1 = gidRepository;
                            anonymousClass1.label = 2;
                            objRetry = retryUtils.retry(exponential, gidRepository$getGidAsync$1$1$networkData$1, anonymousClass1);
                            if (objRetry == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Mutex mutex3 = mutex;
                            obj3 = obj2;
                            obj4 = objRetry;
                            r15 = r13;
                            r9 = r14;
                            r8 = gidRepository;
                            r7 = 0;
                            r6 = mutex3;
                            try {
                                gid2 = (Gid) obj4;
                                boolean z = r6 == true ? 1 : 0;
                                r12 = r8;
                                r11 = r9;
                                r10 = r15;
                            } catch (Throwable th2) {
                                boolean z2 = r6 == true ? 1 : 0;
                                r6 = r7;
                                r7 = r8;
                                r8 = r9;
                                r9 = r15;
                                r10 = r9;
                                r11 = r8;
                                r12 = r7;
                            }
                            gid = gid2;
                            if (gid != null) {
                                try {
                                    r12.saveToDisk(gid);
                                    ((GidRepository) r12)._gidStateFlow.setValue(gid);
                                } catch (Throwable th3) {
                                    th = th3;
                                    r14 = r11;
                                    r13 = r10;
                                    r13.unlock(r14);
                                    throw th;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                            r10.unlock(r11);
                            return Unit.INSTANCE;
                        } catch (Throwable th4) {
                            th = th4;
                            r13.unlock(r14);
                            throw th;
                        }
                    case 1:
                        anonymousClass1 = this;
                        obj2 = obj;
                        mutex = null;
                        GidRepository gidRepository3 = (GidRepository) anonymousClass1.L$1;
                        Mutex mutex4 = (Mutex) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        r13 = mutex4;
                        r14 = 0;
                        gidRepository = gidRepository3;
                        gidFromDisk = gidRepository.getGidFromDisk();
                        if (gidFromDisk != null) {
                            gidRepository._gidStateFlow.setValue(gidFromDisk);
                            break;
                        }
                        RetryUtils retryUtils2 = RetryUtils.INSTANCE;
                        RetryStrategy.Exponential exponential2 = new RetryStrategy.Exponential(0L, 0L, 3, null);
                        GidRepository$getGidAsync$1$1$networkData$1 gidRepository$getGidAsync$1$1$networkData$2 = new GidRepository$getGidAsync$1$1$networkData$1(gidRepository, null);
                        anonymousClass1.L$0 = r13;
                        anonymousClass1.L$1 = gidRepository;
                        anonymousClass1.label = 2;
                        objRetry = retryUtils2.retry(exponential2, gidRepository$getGidAsync$1$1$networkData$2, anonymousClass1);
                        if (objRetry == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Mutex mutex5 = mutex;
                        obj3 = obj2;
                        obj4 = objRetry;
                        r15 = r13;
                        r9 = r14;
                        r8 = gidRepository;
                        r7 = 0;
                        r6 = mutex5;
                        gid2 = (Gid) obj4;
                        boolean z3 = r6 == true ? 1 : 0;
                        r12 = r8;
                        r11 = r9;
                        r10 = r15;
                        gid = gid2;
                        if (gid != null) {
                            r12.saveToDisk(gid);
                            ((GidRepository) r12)._gidStateFlow.setValue(gid);
                        }
                        Unit unit2 = Unit.INSTANCE;
                        r10.unlock(r11);
                        return Unit.INSTANCE;
                    case 2:
                        obj4 = obj;
                        GidRepository gidRepository4 = (GidRepository) this.L$1;
                        Mutex mutex6 = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj4);
                        r15 = mutex6;
                        r9 = 0;
                        r8 = gidRepository4;
                        r7 = 0;
                        r6 = 0;
                        obj3 = obj4;
                        gid2 = (Gid) obj4;
                        boolean z4 = r6 == true ? 1 : 0;
                        r12 = r8;
                        r11 = r9;
                        r10 = r15;
                        gid = gid2;
                        if (gid != null) {
                            r12.saveToDisk(gid);
                            ((GidRepository) r12)._gidStateFlow.setValue(gid);
                        }
                        Unit unit3 = Unit.INSTANCE;
                        r10.unlock(r11);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th5) {
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
            StringFormat $this$encodeToString$iv = Json.INSTANCE;
            SerializersModule $this$serializer$iv$iv = $this$encodeToString$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(Gid.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            gidService.setGid($this$encodeToString$iv.encodeToString(kSerializerSerializer, gid));
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Gid getGidFromDisk() {
        try {
            StringFormat $this$decodeFromString$iv = TapJson.INSTANCE.getJson();
            String string$iv = this.gidDiskService.getGid();
            SerializersModule $this$serializer$iv$iv = $this$decodeFromString$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.nullableTypeOf(Gid.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (Gid) $this$decodeFromString$iv.decodeFromString(kSerializerSerializer, string$iv);
        } catch (Throwable th) {
            return null;
        }
    }
}

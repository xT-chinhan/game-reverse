package com.taptap.sdk.db.repository;

import android.support.v4.app.NotificationCompat;
import com.taptap.sdk.common.network.retry.RetryStrategy;
import com.taptap.sdk.common.network.retry.RetryUtils;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.request.TrackEventRequest;
import com.taptap.sdk.db.storage.PersistentQueue;
import com.taptap.sdk.db.utils.JSONObjectUtils;
import com.taptap.sdk.db.utils.MapUtils;
import com.taptap.sdk.kit.internal.TapLogger;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/taptap/sdk/db/repository/EventRepository;", "", "eventQueue", "Lcom/taptap/sdk/db/storage/PersistentQueue;", "eventApi", "Lcom/taptap/sdk/db/repository/EventApi;", "(Lcom/taptap/sdk/db/storage/PersistentQueue;Lcom/taptap/sdk/db/repository/EventApi;)V", "buildTrackEventRequest", "Lcom/taptap/sdk/db/data/request/TrackEventRequest;", d.ar, "", "Lcom/taptap/sdk/db/data/model/Event;", "flushEvents", "", "maxSendEventCount", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventQueueSize", "isEventQueueNotEmpty", "", "submitEvent", NotificationCompat.CATEGORY_EVENT, "(Lcom/taptap/sdk/db/data/model/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventRepository {
    private static final String TAG = "EventRepository";
    private final EventApi eventApi;
    private final PersistentQueue eventQueue;

    /* JADX INFO: renamed from: com.taptap.sdk.db.repository.EventRepository$flushEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.repository.EventRepository", f = "EventRepository.kt", i = {0, 0, 1, 1}, l = {47, 57, 64}, m = "flushEvents", n = {"this", "pendingEvents", "this", "pendingEvents"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventRepository.this.flushEvents(0, this);
        }
    }

    public EventRepository(PersistentQueue eventQueue, EventApi eventApi) {
        Intrinsics.checkNotNullParameter(eventQueue, "eventQueue");
        Intrinsics.checkNotNullParameter(eventApi, "eventApi");
        this.eventQueue = eventQueue;
        this.eventApi = eventApi;
    }

    public final Object submitEvent(Event event, Continuation<? super Unit> continuation) {
        Object objEnqueue = this.eventQueue.enqueue(event, continuation);
        return objEnqueue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEnqueue : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [int] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.taptap.sdk.db.repository.EventRepository] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.taptap.sdk.db.repository.EventRepository] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.taptap.sdk.db.storage.PersistentQueue] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object flushEvents(int i, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        List<Event> list;
        EventRepository eventRepository;
        Object objRemoveAll;
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
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = anonymousClass2.label;
        try {
            switch (r2) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    EventRepository eventRepository2 = this;
                    List<Event> listPeek = eventRepository2.eventQueue.peek(i);
                    if (listPeek.isEmpty()) {
                        TapLogger.logi(TAG, "No pending events");
                        return Unit.INSTANCE;
                    }
                    TrackEventRequest trackEventRequestBuildTrackEventRequest = eventRepository2.buildTrackEventRequest(listPeek);
                    RetryUtils retryUtils = RetryUtils.INSTANCE;
                    RetryStrategy.Fixed fixed = new RetryStrategy.Fixed(3, 3000L);
                    AnonymousClass2 anonymousClass3 = eventRepository2.new AnonymousClass2(trackEventRequestBuildTrackEventRequest, null);
                    anonymousClass2.L$0 = eventRepository2;
                    anonymousClass2.L$1 = listPeek;
                    anonymousClass2.label = 1;
                    eventRepository = eventRepository2;
                    list = listPeek;
                    if (retryUtils.retry(fixed, "db_events_batch", anonymousClass3, anonymousClass2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    PersistentQueue persistentQueue = eventRepository.eventQueue;
                    anonymousClass2.L$0 = eventRepository;
                    anonymousClass2.L$1 = list;
                    anonymousClass2.label = 2;
                    objRemoveAll = persistentQueue.removeAll(list, anonymousClass2);
                    r2 = eventRepository;
                    i = list;
                    if (objRemoveAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    TapLogger.logi(TAG, "send events success, " + i + " removed from queue, " + r2.eventQueue.getQueueSize() + " left");
                    return Unit.INSTANCE;
                case 1:
                    List<Event> list2 = (List) anonymousClass2.L$1;
                    EventRepository eventRepository3 = (EventRepository) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    eventRepository = eventRepository3;
                    list = list2;
                    PersistentQueue persistentQueue2 = eventRepository.eventQueue;
                    anonymousClass2.L$0 = eventRepository;
                    anonymousClass2.L$1 = list;
                    anonymousClass2.label = 2;
                    objRemoveAll = persistentQueue2.removeAll(list, anonymousClass2);
                    r2 = eventRepository;
                    i = list;
                    if (objRemoveAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    TapLogger.logi(TAG, "send events success, " + i + " removed from queue, " + r2.eventQueue.getQueueSize() + " left");
                    return Unit.INSTANCE;
                case 2:
                    List list3 = (List) anonymousClass2.L$1;
                    EventRepository eventRepository4 = (EventRepository) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = eventRepository4;
                    i = list3;
                    TapLogger.logi(TAG, "send events success, " + i + " removed from queue, " + r2.eventQueue.getQueueSize() + " left");
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            if (!(th instanceof TapNetworkException) || th.getErr().getCode() != 400) {
                throw th;
            }
            TapLogger.logi(TAG, "send events fail with 400, remove invalid events: " + i.size());
            ?? r5 = r2.eventQueue;
            anonymousClass2.L$0 = null;
            anonymousClass2.L$1 = null;
            anonymousClass2.label = 3;
            if (r5.removeAll(i, anonymousClass2) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.repository.EventRepository$flushEvents$2, reason: invalid class name */
    /* JADX INFO: compiled from: EventRepository.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.repository.EventRepository$flushEvents$2", f = "EventRepository.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TrackEventRequest $trackEventRequest;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TrackEventRequest trackEventRequest, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$trackEventRequest = trackEventRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return EventRepository.this.new AnonymousClass2(this.$trackEventRequest, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (EventRepository.this.eventApi.sendEvents(this.$trackEventRequest, this) == coroutine_suspended) {
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

    public final int getEventQueueSize() {
        return this.eventQueue.getQueueSize();
    }

    public final boolean isEventQueueNotEmpty() {
        return this.eventQueue.isNotEmpty();
    }

    private final TrackEventRequest buildTrackEventRequest(List<Event> events) {
        List<Event> $this$map$iv = events;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Event event = (Event) item$iv$iv;
            destination$iv$iv.add(MapUtils.INSTANCE.toJsonElement((Map<String, ? extends Object>) JSONObjectUtils.INSTANCE.toMap(event.getProperties())));
        }
        return new TrackEventRequest(CollectionsKt.toList((List) destination$iv$iv));
    }
}

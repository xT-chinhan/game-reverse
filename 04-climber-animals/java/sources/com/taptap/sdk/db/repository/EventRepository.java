package com.taptap.sdk.db.repository;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.request.TrackEventRequest;
import com.taptap.sdk.db.storage.PersistentQueue;
import com.taptap.sdk.db.utils.JSONObjectUtils;
import com.taptap.sdk.db.utils.MapUtils;
import com.umeng.analytics.pro.g;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0019\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/db/repository/EventRepository;", "", "eventQueue", "Lcom/taptap/sdk/db/storage/PersistentQueue;", "Lcom/taptap/sdk/db/data/model/Event;", "eventApi", "Lcom/taptap/sdk/db/repository/EventApi;", "(Lcom/taptap/sdk/db/storage/PersistentQueue;Lcom/taptap/sdk/db/repository/EventApi;)V", "buildTrackEventRequest", "Lcom/taptap/sdk/db/data/request/TrackEventRequest;", g.ax, "", "flushEvents", "", "maxSendEventCount", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventQueueSize", "submitEvent", NotificationCompat.CATEGORY_EVENT, "(Lcom/taptap/sdk/db/data/model/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventRepository {
    private static final String TAG = "EventRepository";
    private final EventApi eventApi;
    private final PersistentQueue<Event> eventQueue;

    /* JADX INFO: renamed from: com.taptap.sdk.db.repository.EventRepository$flushEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventRepository.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.repository.EventRepository", f = "EventRepository.kt", i = {0, 0, 1, 1, 2}, l = {45, 47, 53}, m = "flushEvents", n = {"this", "pendingEvents", "this", "pendingEvents", "error"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
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

    public EventRepository(PersistentQueue<Event> eventQueue, EventApi eventApi) {
        Intrinsics.checkNotNullParameter(eventQueue, "eventQueue");
        Intrinsics.checkNotNullParameter(eventApi, "eventApi");
        this.eventQueue = eventQueue;
        this.eventApi = eventApi;
    }

    public final Object submitEvent(Event event, Continuation<? super Unit> continuation) {
        Object objEnqueue = this.eventQueue.enqueue(event, continuation);
        return objEnqueue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEnqueue : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.taptap.sdk.db.repository.EventRepository] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.taptap.sdk.db.repository.EventRepository, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.taptap.sdk.db.repository.EventRepository] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.taptap.sdk.db.repository.EventRepository, java.lang.Object] */
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
        Throwable th;
        ?? r3;
        ?? r10;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = anonymousClass1.label;
        try {
            if (r4 == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.eventQueue.peek(i);
                if (i.isEmpty()) {
                    Log.d(TAG, "No pending events");
                    return Unit.INSTANCE;
                }
                try {
                    TrackEventRequest trackEventRequestBuildTrackEventRequest = buildTrackEventRequest(i);
                    EventApi eventApi = this.eventApi;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = i;
                    anonymousClass1.label = 1;
                    if (eventApi.sendEvents(trackEventRequestBuildTrackEventRequest, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r3 = this;
                    r10 = i;
                } catch (Throwable th2) {
                    th = th2;
                    r4 = this;
                    Throwable th3 = th;
                    ?? r11 = i;
                    th = th3;
                    if ((th instanceof TapNetworkException) && ((TapNetworkException) th).getErr().getCode() == 400) {
                        Log.i(TAG, "send events fail, remove invalid events: " + r11);
                        PersistentQueue persistentQueue = r4.eventQueue;
                        anonymousClass1.L$0 = th;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.label = 3;
                        if (persistentQueue.removeAll(r11, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    Log.i(TAG, "send events fail", th);
                }
            } else {
                if (r4 == 1) {
                    List list = (List) anonymousClass1.L$1;
                    EventRepository eventRepository = (EventRepository) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    r3 = eventRepository;
                    r10 = list;
                } else {
                    if (r4 != 2) {
                        if (r4 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Log.i(TAG, "send events fail", th);
                        return Unit.INSTANCE;
                    }
                    List list2 = (List) anonymousClass1.L$1;
                    EventRepository eventRepository2 = (EventRepository) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    r4 = eventRepository2;
                    i = list2;
                }
                Log.i(TAG, "send events success, " + i + " removed from queue, " + r4.eventQueue.getQueueSize() + " left");
                return Unit.INSTANCE;
            }
            PersistentQueue persistentQueue2 = r3.eventQueue;
            anonymousClass1.L$0 = r3;
            anonymousClass1.L$1 = r10;
            anonymousClass1.label = 2;
            Object objRemoveAll = persistentQueue2.removeAll(r10, anonymousClass1);
            r4 = r3;
            i = r10;
            if (objRemoveAll == coroutine_suspended) {
                return coroutine_suspended;
            }
            Log.i(TAG, "send events success, " + i + " removed from queue, " + r4.eventQueue.getQueueSize() + " left");
        } catch (Throwable th4) {
            th = th4;
        }
        return Unit.INSTANCE;
    }

    public final int getEventQueueSize() {
        return this.eventQueue.getQueueSize();
    }

    private final TrackEventRequest buildTrackEventRequest(List<Event> events) {
        List<Event> list = events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(MapUtils.INSTANCE.toJsonElement((Map<String, ? extends Object>) JSONObjectUtils.INSTANCE.toMap(((Event) it.next()).getProperties())));
        }
        return new TrackEventRequest(CollectionsKt.toList(arrayList));
    }
}

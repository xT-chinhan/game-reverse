package com.taptap.sdk.db.processor;

import android.util.Log;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.EventTrigger;
import com.taptap.sdk.db.repository.EventRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: EventProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor$consumerJob$1", f = "EventProcessor.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
final class EventProcessor$consumerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EventProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventProcessor$consumerJob$1(EventProcessor eventProcessor, Continuation<? super EventProcessor$consumerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = eventProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventProcessor$consumerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventProcessor$consumerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow[] flowArr = {this.this$0.eventFlow(), this.this$0.timer()};
            this.label = 1;
            if (FlowKt.merge(flowArr).collect(new AnonymousClass1(this.this$0), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$consumerJob$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "triggerEvent", "Lcom/taptap/sdk/db/data/model/EventTrigger;", "emit", "(Lcom/taptap/sdk/db/data/model/EventTrigger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ EventProcessor this$0;

        AnonymousClass1(EventProcessor eventProcessor) {
            this.this$0 = eventProcessor;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:35:0x00cf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object emit(EventTrigger eventTrigger, Continuation<? super Unit> continuation) throws Throwable {
            EventProcessor$consumerJob$1$1$emit$1 eventProcessor$consumerJob$1$1$emit$1;
            AnonymousClass1<T> anonymousClass1;
            EventRepository eventRepository;
            int maxSendEventCount;
            if (continuation instanceof EventProcessor$consumerJob$1$1$emit$1) {
                eventProcessor$consumerJob$1$1$emit$1 = (EventProcessor$consumerJob$1$1$emit$1) continuation;
                if ((eventProcessor$consumerJob$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    eventProcessor$consumerJob$1$1$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    eventProcessor$consumerJob$1$1$emit$1 = new EventProcessor$consumerJob$1$1$emit$1(this, continuation);
                }
            } else {
                eventProcessor$consumerJob$1$1$emit$1 = new EventProcessor$consumerJob$1$1$emit$1(this, continuation);
            }
            Object obj = eventProcessor$consumerJob$1$1$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = eventProcessor$consumerJob$1$1$emit$1.label;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        anonymousClass1 = (AnonymousClass1) eventProcessor$consumerJob$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (anonymousClass1.this$0.repository.getEventQueueSize() >= anonymousClass1.this$0.config.getMaxAccumulatedEventCount()) {
                            eventRepository = anonymousClass1.this$0.repository;
                            maxSendEventCount = anonymousClass1.this$0.config.getMaxSendEventCount();
                            eventProcessor$consumerJob$1$1$emit$1.L$0 = null;
                            eventProcessor$consumerJob$1$1$emit$1.label = 3;
                            if (eventRepository.flushEvents(maxSendEventCount, eventProcessor$consumerJob$1$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            if (eventTrigger instanceof EventTrigger.TimerTick) {
                EventRepository eventRepository2 = this.this$0.repository;
                int maxSendEventCount2 = this.this$0.config.getMaxSendEventCount();
                eventProcessor$consumerJob$1$1$emit$1.label = 1;
                if (eventRepository2.flushEvents(maxSendEventCount2, eventProcessor$consumerJob$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (eventTrigger instanceof EventTrigger.NewEvent) {
                EventTrigger.NewEvent newEvent = (EventTrigger.NewEvent) eventTrigger;
                Log.d(EventProcessor.TAG, "receive new event: " + newEvent.getEvent());
                EventRepository eventRepository3 = this.this$0.repository;
                Event event = newEvent.getEvent();
                eventProcessor$consumerJob$1$1$emit$1.L$0 = this;
                eventProcessor$consumerJob$1$1$emit$1.label = 2;
                if (eventRepository3.submitEvent(event, eventProcessor$consumerJob$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anonymousClass1 = this;
                if (anonymousClass1.this$0.repository.getEventQueueSize() >= anonymousClass1.this$0.config.getMaxAccumulatedEventCount()) {
                    eventRepository = anonymousClass1.this$0.repository;
                    maxSendEventCount = anonymousClass1.this$0.config.getMaxSendEventCount();
                    eventProcessor$consumerJob$1$1$emit$1.L$0 = null;
                    eventProcessor$consumerJob$1$1$emit$1.label = 3;
                    if (eventRepository.flushEvents(maxSendEventCount, eventProcessor$consumerJob$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((EventTrigger) obj, (Continuation<? super Unit>) continuation);
        }
    }
}

package com.taptap.sdk.db.processor;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.e.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.EventTrigger;
import com.taptap.sdk.db.repository.EventRepository;
import com.umeng.analytics.pro.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: EventProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0019\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/taptap/sdk/db/processor/EventProcessor;", "", "config", "Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "repository", "Lcom/taptap/sdk/db/repository/EventRepository;", "(Lcom/taptap/sdk/db/processor/EventProcessor$Config;Lcom/taptap/sdk/db/repository/EventRepository;)V", "consumerJob", "Lkotlinx/coroutines/Job;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/taptap/sdk/db/data/model/Event;", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/taptap/sdk/db/data/model/EventTrigger;", "flushEvents", "shutdown", "", "submitEvent", NotificationCompat.CATEGORY_EVENT, "(Lcom/taptap/sdk/db/data/model/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timer", "Companion", "Config", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventProcessor {
    private static final String TAG = "EventProcessor";
    private final Config config;
    private final Job consumerJob;
    private final CoroutineScope coroutineScope;
    private final Channel<Event> eventChannel;
    private final EventRepository repository;

    public EventProcessor(Config config, EventRepository repository) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.config = config;
        this.repository = repository;
        CoroutineScope scope = config.getScope();
        this.coroutineScope = scope;
        this.eventChannel = ChannelKt.Channel$default(-2, null, null, 6, null);
        this.consumerJob = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new EventProcessor$consumerJob$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<EventTrigger> eventFlow() {
        final Flow flowReceiveAsFlow = FlowKt.receiveAsFlow(this.eventChannel);
        return new Flow<EventTrigger.NewEvent>() { // from class: com.taptap.sdk.db.processor.EventProcessor$eventFlow$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super EventTrigger.NewEvent> flowCollector, Continuation continuation) {
                Object objCollect = flowReceiveAsFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$eventFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", f.a.d, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$eventFlow$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor$eventFlow$$inlined$map$1$2", f = "EventProcessor.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) throws Throwable {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        EventTrigger.NewEvent newEvent = new EventTrigger.NewEvent((Event) obj);
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(newEvent, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$timer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/taptap/sdk/db/data/model/EventTrigger$TimerTick;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor$timer$1", f = "EventProcessor.kt", i = {0, 1}, l = {82, 83}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    static final class C08121 extends SuspendLambda implements Function2<FlowCollector<? super EventTrigger.TimerTick>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C08121(Continuation<? super C08121> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08121 c08121 = EventProcessor.this.new C08121(continuation);
            c08121.L$0 = obj;
            return c08121;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super EventTrigger.TimerTick> flowCollector, Continuation<? super Unit> continuation) {
            return ((C08121) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0047 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0048  */
        /* JADX WARN: Code duplicated, block: B:18:0x005a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x005b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:12:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r1
                goto L2f
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1f:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r8
                goto L4b
            L28:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            L2f:
                r1 = r8
            L30:
                com.taptap.sdk.db.processor.EventProcessor r4 = com.taptap.sdk.db.processor.EventProcessor.this
                com.taptap.sdk.db.processor.EventProcessor$Config r4 = com.taptap.sdk.db.processor.EventProcessor.access$getConfig$p(r4)
                long r4 = r4.getInterval()
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r1.L$0 = r9
                r1.label = r3
                java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r6)
                if (r4 != r0) goto L48
                return r0
            L48:
                r7 = r1
                r1 = r9
                r9 = r7
            L4b:
                com.taptap.sdk.db.data.model.EventTrigger$TimerTick r4 = com.taptap.sdk.db.data.model.EventTrigger.TimerTick.INSTANCE
                r5 = r9
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r9.L$0 = r1
                r9.label = r2
                java.lang.Object r4 = r1.emit(r4, r5)
                if (r4 != r0) goto L5b
                return r0
            L5b:
                r7 = r1
                r1 = r9
                r9 = r7
                goto L30
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taptap.sdk.db.processor.EventProcessor.C08121.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<EventTrigger> timer() {
        return FlowKt.flow(new C08121(null));
    }

    public final Object submitEvent(Event event, Continuation<? super Unit> continuation) {
        Object objSend = this.eventChannel.send(event, continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }

    public final void shutdown() {
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
        SendChannel.DefaultImpls.close$default(this.eventChannel, null, 1, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$flushEvents$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor$flushEvents$1", f = "EventProcessor.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventProcessor.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (EventProcessor.this.repository.flushEvents(EventProcessor.this.config.getMaxSendEventCount(), this) == coroutine_suspended) {
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
    }

    public final Job flushEvents() {
        return BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "", g.X, "Landroid/content/Context;", TTDownloadField.TT_FILE_NAME, "", "maxSize", "", "eventQueueCapacity", "", "maxSendEventCount", "maxAccumulatedEventCount", "interval", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Ljava/lang/String;JIIIJLkotlinx/coroutines/CoroutineScope;)V", "getContext", "()Landroid/content/Context;", "getEventQueueCapacity", "()I", "getFileName", "()Ljava/lang/String;", "getInterval", "()J", "getMaxAccumulatedEventCount", "getMaxSendEventCount", "getMaxSize", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Config {
        private final Context context;
        private final int eventQueueCapacity;
        private final String fileName;
        private final long interval;
        private final int maxAccumulatedEventCount;
        private final int maxSendEventCount;
        private final long maxSize;
        private final CoroutineScope scope;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getMaxSize() {
            return this.maxSize;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getEventQueueCapacity() {
            return this.eventQueueCapacity;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getMaxSendEventCount() {
            return this.maxSendEventCount;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getMaxAccumulatedEventCount() {
            return this.maxAccumulatedEventCount;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getInterval() {
            return this.interval;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final CoroutineScope getScope() {
            return this.scope;
        }

        public final Config copy(Context context, String fileName, long maxSize, int eventQueueCapacity, int maxSendEventCount, int maxAccumulatedEventCount, long interval, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new Config(context, fileName, maxSize, eventQueueCapacity, maxSendEventCount, maxAccumulatedEventCount, interval, scope);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.context, config.context) && Intrinsics.areEqual(this.fileName, config.fileName) && this.maxSize == config.maxSize && this.eventQueueCapacity == config.eventQueueCapacity && this.maxSendEventCount == config.maxSendEventCount && this.maxAccumulatedEventCount == config.maxAccumulatedEventCount && this.interval == config.interval && Intrinsics.areEqual(this.scope, config.scope);
        }

        public int hashCode() {
            return (((((((((((((this.context.hashCode() * 31) + this.fileName.hashCode()) * 31) + Long.hashCode(this.maxSize)) * 31) + Integer.hashCode(this.eventQueueCapacity)) * 31) + Integer.hashCode(this.maxSendEventCount)) * 31) + Integer.hashCode(this.maxAccumulatedEventCount)) * 31) + Long.hashCode(this.interval)) * 31) + this.scope.hashCode();
        }

        public String toString() {
            return "Config(context=" + this.context + ", fileName=" + this.fileName + ", maxSize=" + this.maxSize + ", eventQueueCapacity=" + this.eventQueueCapacity + ", maxSendEventCount=" + this.maxSendEventCount + ", maxAccumulatedEventCount=" + this.maxAccumulatedEventCount + ", interval=" + this.interval + ", scope=" + this.scope + ')';
        }

        public Config(Context context, String fileName, long j, int i, int i2, int i3, long j2, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.context = context;
            this.fileName = fileName;
            this.maxSize = j;
            this.eventQueueCapacity = i;
            this.maxSendEventCount = i2;
            this.maxAccumulatedEventCount = i3;
            this.interval = j2;
            this.scope = scope;
        }

        public final Context getContext() {
            return this.context;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final long getMaxSize() {
            return this.maxSize;
        }

        public final int getEventQueueCapacity() {
            return this.eventQueueCapacity;
        }

        public final int getMaxSendEventCount() {
            return this.maxSendEventCount;
        }

        public final int getMaxAccumulatedEventCount() {
            return this.maxAccumulatedEventCount;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }
    }
}

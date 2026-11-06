package com.taptap.sdk.db.processor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.data.model.EventTrigger;
import com.taptap.sdk.db.repository.EventRepository;
import com.umeng.analytics.pro.d;
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
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: EventProcessor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\n\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/taptap/sdk/db/processor/EventProcessor;", "", "config", "Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "repository", "Lcom/taptap/sdk/db/repository/EventRepository;", "(Lcom/taptap/sdk/db/processor/EventProcessor$Config;Lcom/taptap/sdk/db/repository/EventRepository;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleCallbacks", "com/taptap/sdk/db/processor/EventProcessor$lifecycleCallbacks$1", "Lcom/taptap/sdk/db/processor/EventProcessor$lifecycleCallbacks$1;", "triggerChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/taptap/sdk/db/data/model/EventTrigger;", "consumeQueueCompletely", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushEvents", "shutdown", "submitEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/taptap/sdk/db/data/model/Event;", "(Lcom/taptap/sdk/db/data/model/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Config", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventProcessor {
    private static final String TAG = "EventProcessor";
    private final Config config;
    private final CoroutineScope coroutineScope;
    private final EventProcessor$lifecycleCallbacks$1 lifecycleCallbacks;
    private final EventRepository repository;
    private final Channel<EventTrigger> triggerChannel;

    /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$consumeQueueCompletely$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor", f = "EventProcessor.kt", i = {0}, l = {117}, m = "consumeQueueCompletely", n = {"this"}, s = {"L$0"})
    static final class C03381 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03381(Continuation<? super C03381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventProcessor.this.consumeQueueCompletely(this);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$submitEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor", f = "EventProcessor.kt", i = {0, 0}, l = {83, 86}, m = "submitEvent", n = {"this", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$1"})
    static final class C03401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03401(Continuation<? super C03401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventProcessor.this.submitEvent(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.taptap.sdk.db.processor.EventProcessor$lifecycleCallbacks$1] */
    public EventProcessor(Config config, EventRepository repository) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.config = config;
        this.repository = repository;
        CoroutineScope coroutineScope = config.getCoroutineScope();
        this.coroutineScope = coroutineScope;
        this.triggerChannel = ChannelKt.Channel$default(-1, null, null, 6, null);
        ?? r0 = new TapActivityLifecycleCallbacks() { // from class: com.taptap.sdk.db.processor.EventProcessor$lifecycleCallbacks$1
            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                TapActivityLifecycleCallbacks.DefaultImpls.onActivityCreated(this, activity, savedInstanceState);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                TapActivityLifecycleCallbacks.DefaultImpls.onActivityDestroyed(this, activity);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                TapActivityLifecycleCallbacks.DefaultImpls.onActivityPaused(this, activity);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                TapActivityLifecycleCallbacks.DefaultImpls.onActivityResumed(this, activity);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                TapActivityLifecycleCallbacks.DefaultImpls.onActivitySaveInstanceState(this, activity, outState);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                TapActivityLifecycleCallbacks.DefaultImpls.onActivityStarted(this, activity);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                TapActivityLifecycleCallbacks.DefaultImpls.onActivityStopped(this, activity);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks
            public void onBackground(Context context) {
                TapActivityLifecycleCallbacks.DefaultImpls.onBackground(this, context);
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks
            public void onForeground(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                Log.d("EventProcessor", "App moved to foreground, triggering queue consumption");
                BuildersKt__Builders_commonKt.launch$default(this.this$0.coroutineScope, null, null, new EventProcessor$lifecycleCallbacks$1$onForeground$1(this.this$0, null), 3, null);
            }
        };
        this.lifecycleCallbacks = r0;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
        TapActivityLifecycleTracker.INSTANCE.registerActivityLifecycleCallbacks((TapActivityLifecycleCallbacks) r0);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$1, reason: invalid class name */
    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor$1", f = "EventProcessor.kt", i = {0, 1, 2, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 65, 66, 67}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv", "$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$1", "L$1", "L$1", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
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

        /* JADX WARN: Code duplicated, block: B:25:0x00a2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:29:0x00b3 A[Catch: all -> 0x0135, TryCatch #2 {all -> 0x0135, blocks: (B:27:0x00ab, B:29:0x00b3, B:31:0x00c1, B:36:0x00e0, B:38:0x00e4, B:43:0x0102, B:45:0x0106), top: B:68:0x00ab }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00c1 A[Catch: all -> 0x0135, TryCatch #2 {all -> 0x0135, blocks: (B:27:0x00ab, B:29:0x00b3, B:31:0x00c1, B:36:0x00e0, B:38:0x00e4, B:43:0x0102, B:45:0x0106), top: B:68:0x00ab }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00d0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:36:0x00e0 A[Catch: all -> 0x0135, TryCatch #2 {all -> 0x0135, blocks: (B:27:0x00ab, B:29:0x00b3, B:31:0x00c1, B:36:0x00e0, B:38:0x00e4, B:43:0x0102, B:45:0x0106), top: B:68:0x00ab }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00e4 A[Catch: all -> 0x0135, TryCatch #2 {all -> 0x0135, blocks: (B:27:0x00ab, B:29:0x00b3, B:31:0x00c1, B:36:0x00e0, B:38:0x00e4, B:43:0x0102, B:45:0x0106), top: B:68:0x00ab }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00f3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:43:0x0102 A[Catch: all -> 0x0135, TryCatch #2 {all -> 0x0135, blocks: (B:27:0x00ab, B:29:0x00b3, B:31:0x00c1, B:36:0x00e0, B:38:0x00e4, B:43:0x0102, B:45:0x0106), top: B:68:0x00ab }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0106 A[Catch: all -> 0x0135, TRY_LEAVE, TryCatch #2 {all -> 0x0135, blocks: (B:27:0x00ab, B:29:0x00b3, B:31:0x00c1, B:36:0x00e0, B:38:0x00e4, B:43:0x0102, B:45:0x0106), top: B:68:0x00ab }] */
        /* JADX WARN: Code duplicated, block: B:47:0x0115 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x0116  */
        /* JADX WARN: Code duplicated, block: B:50:0x0124  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0116 -> B:49:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0124 -> B:72:0x0093). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 346
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taptap.sdk.db.processor.EventProcessor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object submitEvent(Event event, Continuation<? super Unit> continuation) throws Throwable {
        C03401 c03401;
        EventProcessor eventProcessor;
        Channel<EventTrigger> channel;
        EventTrigger.NewEvent newEvent;
        if (continuation instanceof C03401) {
            c03401 = (C03401) continuation;
            if ((c03401.label & Integer.MIN_VALUE) != 0) {
                c03401.label -= Integer.MIN_VALUE;
            } else {
                c03401 = new C03401(continuation);
            }
        } else {
            c03401 = new C03401(continuation);
        }
        C03401 c03402 = c03401;
        Object $result = c03402.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03402.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                eventProcessor = this;
                Log.d(TAG, "Submitting event: " + event.getName());
                EventRepository eventRepository = eventProcessor.repository;
                c03402.L$0 = eventProcessor;
                c03402.L$1 = event;
                c03402.label = 1;
                if (eventRepository.submitEvent(event, c03402) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                channel = eventProcessor.triggerChannel;
                newEvent = new EventTrigger.NewEvent(event);
                c03402.L$0 = null;
                c03402.L$1 = null;
                c03402.label = 2;
                if (channel.send(newEvent, c03402) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                event = (Event) c03402.L$1;
                eventProcessor = (EventProcessor) c03402.L$0;
                ResultKt.throwOnFailure($result);
                channel = eventProcessor.triggerChannel;
                newEvent = new EventTrigger.NewEvent(event);
                c03402.L$0 = null;
                c03402.L$1 = null;
                c03402.label = 2;
                if (channel.send(newEvent, c03402) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.processor.EventProcessor$flushEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.processor.EventProcessor$flushEvents$1", f = "EventProcessor.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class C03391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03391(Continuation<? super C03391> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventProcessor.this.new C03391(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (EventProcessor.this.triggerChannel.send(EventTrigger.FlushQueue.INSTANCE, this) == coroutine_suspended) {
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

    public final void flushEvents() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03391(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:23:0x0058  */
    /* JADX WARN: Code duplicated, block: B:26:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0086 -> B:27:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object consumeQueueCompletely(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.taptap.sdk.db.processor.EventProcessor.C03381
            if (r0 == 0) goto L14
            r0 = r8
            com.taptap.sdk.db.processor.EventProcessor$consumeQueueCompletely$1 r0 = (com.taptap.sdk.db.processor.EventProcessor.C03381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.taptap.sdk.db.processor.EventProcessor$consumeQueueCompletely$1 r0 = new com.taptap.sdk.db.processor.EventProcessor$consumeQueueCompletely$1
            r0.<init>(r8)
        L19:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            java.lang.String r3 = "EventProcessor"
            switch(r2) {
                case 0: goto L39;
                case 1: goto L2f;
                default: goto L27;
            }
        L27:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L2f:
            java.lang.Object r2 = r8.L$0
            com.taptap.sdk.db.processor.EventProcessor r2 = (com.taptap.sdk.db.processor.EventProcessor) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Throwable -> L37
            goto L89
        L37:
            r1 = move-exception
            goto La6
        L39:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            java.lang.String r4 = "Starting to consume event queue"
            android.util.Log.d(r3, r4)
        L42:
            com.taptap.sdk.db.repository.EventRepository r4 = r2.repository
            boolean r4 = r4.isEventQueueNotEmpty()
            if (r4 == 0) goto Lab
            com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker r4 = com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker.INSTANCE
            boolean r4 = r4.isAppForeground()
            if (r4 != 0) goto L58
            java.lang.String r1 = "App moved to background, stopping queue consumption"
            android.util.Log.d(r3, r1)
            goto Lab
        L58:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Consuming event queue, current size: "
            java.lang.StringBuilder r4 = r4.append(r5)
            com.taptap.sdk.db.repository.EventRepository r5 = r2.repository
            int r5 = r5.getEventQueueSize()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
            com.taptap.sdk.db.repository.EventRepository r4 = r2.repository     // Catch: java.lang.Throwable -> L37
            com.taptap.sdk.db.processor.EventProcessor$Config r5 = r2.config     // Catch: java.lang.Throwable -> L37
            int r5 = r5.getMaxSendEventCount()     // Catch: java.lang.Throwable -> L37
            r8.L$0 = r2     // Catch: java.lang.Throwable -> L37
            r6 = 1
            r8.label = r6     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = r4.flushEvents(r5, r8)     // Catch: java.lang.Throwable -> L37
            if (r4 != r1) goto L89
            return r1
        L89:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37
            r4.<init>()     // Catch: java.lang.Throwable -> L37
            java.lang.String r5 = "Batch sent successfully, remaining queue size: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L37
            com.taptap.sdk.db.repository.EventRepository r5 = r2.repository     // Catch: java.lang.Throwable -> L37
            int r5 = r5.getEventQueueSize()     // Catch: java.lang.Throwable -> L37
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L37
            android.util.Log.d(r3, r4)     // Catch: java.lang.Throwable -> L37
            goto L42
        La6:
            java.lang.String r2 = "Failed to send events after retries, stopping current consumption"
            android.util.Log.w(r3, r2, r1)
        Lab:
            java.lang.String r1 = "Event queue consumption completed"
            android.util.Log.d(r3, r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taptap.sdk.db.processor.EventProcessor.consumeQueueCompletely(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void shutdown() {
        TapActivityLifecycleTracker.INSTANCE.unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
        SendChannel.DefaultImpls.close$default(this.triggerChannel, null, 1, null);
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
        Log.d(TAG, "EventProcessor shutdown");
    }

    /* JADX INFO: compiled from: EventProcessor.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "", d.R, "Landroid/content/Context;", "fileName", "", "maxSize", "", "eventQueueCapacity", "", "maxSendEventCount", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Ljava/lang/String;JIILkotlinx/coroutines/CoroutineScope;)V", "getContext", "()Landroid/content/Context;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getEventQueueCapacity", "()I", "getFileName", "()Ljava/lang/String;", "getMaxSendEventCount", "getMaxSize", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Config {
        private final Context context;
        private final CoroutineScope coroutineScope;
        private final int eventQueueCapacity;
        private final String fileName;
        private final int maxSendEventCount;
        private final long maxSize;

        public static /* synthetic */ Config copy$default(Config config, Context context, String str, long j, int i, int i2, CoroutineScope coroutineScope, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                context = config.context;
            }
            if ((i3 & 2) != 0) {
                str = config.fileName;
            }
            String str2 = str;
            if ((i3 & 4) != 0) {
                j = config.maxSize;
            }
            long j2 = j;
            if ((i3 & 8) != 0) {
                i = config.eventQueueCapacity;
            }
            int i4 = i;
            if ((i3 & 16) != 0) {
                i2 = config.maxSendEventCount;
            }
            int i5 = i2;
            if ((i3 & 32) != 0) {
                coroutineScope = config.coroutineScope;
            }
            return config.copy(context, str2, j2, i4, i5, coroutineScope);
        }

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
        public final CoroutineScope getCoroutineScope() {
            return this.coroutineScope;
        }

        public final Config copy(Context context, String fileName, long maxSize, int eventQueueCapacity, int maxSendEventCount, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            return new Config(context, fileName, maxSize, eventQueueCapacity, maxSendEventCount, coroutineScope);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.context, config.context) && Intrinsics.areEqual(this.fileName, config.fileName) && this.maxSize == config.maxSize && this.eventQueueCapacity == config.eventQueueCapacity && this.maxSendEventCount == config.maxSendEventCount && Intrinsics.areEqual(this.coroutineScope, config.coroutineScope);
        }

        public int hashCode() {
            return (((((((((this.context.hashCode() * 31) + this.fileName.hashCode()) * 31) + Long.hashCode(this.maxSize)) * 31) + Integer.hashCode(this.eventQueueCapacity)) * 31) + Integer.hashCode(this.maxSendEventCount)) * 31) + this.coroutineScope.hashCode();
        }

        public String toString() {
            return "Config(context=" + this.context + ", fileName=" + this.fileName + ", maxSize=" + this.maxSize + ", eventQueueCapacity=" + this.eventQueueCapacity + ", maxSendEventCount=" + this.maxSendEventCount + ", coroutineScope=" + this.coroutineScope + ')';
        }

        public Config(Context context, String fileName, long maxSize, int eventQueueCapacity, int maxSendEventCount, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            this.context = context;
            this.fileName = fileName;
            this.maxSize = maxSize;
            this.eventQueueCapacity = eventQueueCapacity;
            this.maxSendEventCount = maxSendEventCount;
            this.coroutineScope = coroutineScope;
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

        public final CoroutineScope getCoroutineScope() {
            return this.coroutineScope;
        }
    }
}

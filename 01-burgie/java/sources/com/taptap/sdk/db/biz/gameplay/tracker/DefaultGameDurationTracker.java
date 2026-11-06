package com.taptap.sdk.db.biz.gameplay.tracker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks;
import com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleTracker;
import com.taptap.sdk.db.EventContext;
import com.taptap.sdk.db.biz.gameplay.reporter.GameDurationReporter;
import com.taptap.sdk.db.biz.gameplay.storage.GameDurationStorage;
import com.taptap.sdk.db.data.model.GameDuration;
import com.taptap.sdk.kit.internal.TapLogger;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: DefaultGameDurationTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0010\u0018\u0000 *2\u00020\u0001:\u0001*B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J \u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010)\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/taptap/sdk/db/biz/gameplay/tracker/DefaultGameDurationTracker;", "Lcom/taptap/sdk/db/biz/gameplay/tracker/GameDurationTracker;", "storage", "Lcom/taptap/sdk/db/biz/gameplay/storage/GameDurationStorage;", "reporter", "Lcom/taptap/sdk/db/biz/gameplay/reporter/GameDurationReporter;", "activityLifecycleTracker", "Lcom/taptap/sdk/base/utils/lifecycle/TapActivityLifecycleTracker;", "eventContext", "Lcom/taptap/sdk/db/EventContext;", "(Lcom/taptap/sdk/db/biz/gameplay/storage/GameDurationStorage;Lcom/taptap/sdk/db/biz/gameplay/reporter/GameDurationReporter;Lcom/taptap/sdk/base/utils/lifecycle/TapActivityLifecycleTracker;Lcom/taptap/sdk/db/EventContext;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "deviceStartTimeAtInMillis", "", "lifecycleCallbacks", "com/taptap/sdk/db/biz/gameplay/tracker/DefaultGameDurationTracker$lifecycleCallbacks$1", "Lcom/taptap/sdk/db/biz/gameplay/tracker/DefaultGameDurationTracker$lifecycleCallbacks$1;", "timerJob", "Lkotlinx/coroutines/Job;", "userStartTimeAtInMillis", "getUserStartTimeAtInMillis", "()J", "setUserStartTimeAtInMillis", "(J)V", "enableAutoSubmitGameDurationEvent", "", "initialize", "startTimer", "startTracking", "stopTimer", "stopTracking", "submitGameDurationEvent", "userId", "", "onlyUserDuration", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitOldUserGameDurationEvent", "oldUserId", "newUserId", "updateLocalGameDuration", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultGameDurationTracker implements GameDurationTracker {
    private static final String TAG = "GameDurationTracker";
    private static final long TIMER_INTERVAL = 3000;
    private final TapActivityLifecycleTracker activityLifecycleTracker;
    private final CoroutineScope coroutineScope;
    private long deviceStartTimeAtInMillis;
    private final EventContext eventContext;
    private final DefaultGameDurationTracker$lifecycleCallbacks$1 lifecycleCallbacks;
    private final GameDurationReporter reporter;
    private final GameDurationStorage storage;
    private Job timerJob;
    private long userStartTimeAtInMillis;

    /* JADX INFO: renamed from: com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$submitGameDurationEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultGameDurationTracker.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker", f = "DefaultGameDurationTracker.kt", i = {0, 0, 0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO}, m = "submitGameDurationEvent", n = {"this", "onlyUserDuration", "deviceDuration", "this"}, s = {"L$0", "Z$0", "J$0", "L$0"})
    static final class C03351 extends ContinuationImpl {
        long J$0;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C03351(Continuation<? super C03351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultGameDurationTracker.this.submitGameDurationEvent(null, false, this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$lifecycleCallbacks$1] */
    public DefaultGameDurationTracker(GameDurationStorage storage, GameDurationReporter reporter, TapActivityLifecycleTracker activityLifecycleTracker, EventContext eventContext) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(activityLifecycleTracker, "activityLifecycleTracker");
        Intrinsics.checkNotNullParameter(eventContext, "eventContext");
        this.storage = storage;
        this.reporter = reporter;
        this.activityLifecycleTracker = activityLifecycleTracker;
        this.eventContext = eventContext;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.deviceStartTimeAtInMillis = -1L;
        this.userStartTimeAtInMillis = -1L;
        this.lifecycleCallbacks = new TapActivityLifecycleCallbacks() { // from class: com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$lifecycleCallbacks$1
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
            public void onForeground(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.this$0.startTracking();
            }

            @Override // com.taptap.sdk.base.utils.lifecycle.TapActivityLifecycleCallbacks
            public void onBackground(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.this$0.stopTracking();
            }
        };
    }

    @Override // com.taptap.sdk.db.biz.gameplay.tracker.GameDurationTracker
    public long getUserStartTimeAtInMillis() {
        return this.userStartTimeAtInMillis;
    }

    @Override // com.taptap.sdk.db.biz.gameplay.tracker.GameDurationTracker
    public void setUserStartTimeAtInMillis(long j) {
        this.userStartTimeAtInMillis = j;
    }

    @Override // com.taptap.sdk.db.biz.gameplay.tracker.GameDurationTracker
    public void initialize() {
        this.activityLifecycleTracker.registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
        if (this.activityLifecycleTracker.isAppForeground()) {
            startTracking();
        }
        enableAutoSubmitGameDurationEvent();
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$startTracking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultGameDurationTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$startTracking$1", f = "DefaultGameDurationTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03331(Continuation<? super C03331> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultGameDurationTracker.this.new C03331(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    long now = System.currentTimeMillis();
                    if (DefaultGameDurationTracker.this.deviceStartTimeAtInMillis < 0) {
                        DefaultGameDurationTracker.this.deviceStartTimeAtInMillis = now;
                        TapLogger.logd(DefaultGameDurationTracker.TAG, "Device tracking started");
                    }
                    String currentUserId = DefaultGameDurationTracker.this.eventContext.getCurrentUserId();
                    if (!(currentUserId == null || currentUserId.length() == 0) && DefaultGameDurationTracker.this.getUserStartTimeAtInMillis() < 0) {
                        DefaultGameDurationTracker.this.setUserStartTimeAtInMillis(now);
                        TapLogger.logd(DefaultGameDurationTracker.TAG, "User tracking started for user: " + DefaultGameDurationTracker.this.eventContext.getCurrentUserId());
                    }
                    DefaultGameDurationTracker.this.startTimer();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // com.taptap.sdk.db.biz.gameplay.tracker.GameDurationTracker
    public void startTracking() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03331(null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$stopTracking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultGameDurationTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$stopTracking$1", f = "DefaultGameDurationTracker.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C03341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03341(Continuation<? super C03341> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultGameDurationTracker.this.new C03341(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03341 c03341;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    DefaultGameDurationTracker defaultGameDurationTracker = DefaultGameDurationTracker.this;
                    defaultGameDurationTracker.updateLocalGameDuration(defaultGameDurationTracker.eventContext.getCurrentUserId());
                    DefaultGameDurationTracker defaultGameDurationTracker2 = DefaultGameDurationTracker.this;
                    this.label = 1;
                    if (defaultGameDurationTracker2.submitGameDurationEvent(defaultGameDurationTracker2.eventContext.getCurrentUserId(), false, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c03341 = this;
                    break;
                    break;
                case 1:
                    c03341 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            DefaultGameDurationTracker.this.deviceStartTimeAtInMillis = -1L;
            DefaultGameDurationTracker.this.setUserStartTimeAtInMillis(-1L);
            DefaultGameDurationTracker.this.stopTimer();
            TapLogger.logd(DefaultGameDurationTracker.TAG, "tracking stopped");
            return Unit.INSTANCE;
        }
    }

    @Override // com.taptap.sdk.db.biz.gameplay.tracker.GameDurationTracker
    public void stopTracking() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03341(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTimer() {
        stopTimer();
        this.timerJob = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03321(null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$startTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultGameDurationTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$startTimer$1", f = "DefaultGameDurationTracker.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class C03321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03321(Continuation<? super C03321> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03321 c03321 = DefaultGameDurationTracker.this.new C03321(continuation);
            c03321.L$0 = obj;
            return c03321;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03321 c03321;
            CoroutineScope $this$launch;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c03321 = this;
                    $this$launch = (CoroutineScope) c03321.L$0;
                    break;
                case 1:
                    c03321 = this;
                    $this$launch = (CoroutineScope) c03321.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (CoroutineScopeKt.isActive($this$launch)) {
                DefaultGameDurationTracker defaultGameDurationTracker = DefaultGameDurationTracker.this;
                defaultGameDurationTracker.updateLocalGameDuration(defaultGameDurationTracker.eventContext.getCurrentUserId());
                c03321.L$0 = $this$launch;
                c03321.label = 1;
                if (DelayKt.delay(DefaultGameDurationTracker.TIMER_INTERVAL, c03321) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopTimer() {
        Job job = this.timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.timerJob = null;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$submitOldUserGameDurationEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultGameDurationTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$submitOldUserGameDurationEvent$1", f = "DefaultGameDurationTracker.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
    static final class C03361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newUserId;
        final /* synthetic */ String $oldUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03361(String str, String str2, Continuation<? super C03361> continuation) {
            super(2, continuation);
            this.$oldUserId = str;
            this.$newUserId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultGameDurationTracker.this.new C03361(this.$oldUserId, this.$newUserId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            C03361 c03361;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z = true;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    DefaultGameDurationTracker.this.updateLocalGameDuration(this.$oldUserId);
                    this.label = 1;
                    if (DefaultGameDurationTracker.this.submitGameDurationEvent(this.$oldUserId, true, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c03361 = this;
                    break;
                    break;
                case 1:
                    c03361 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = c03361.$newUserId;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (!z && DefaultGameDurationTracker.this.deviceStartTimeAtInMillis > 0) {
                DefaultGameDurationTracker.this.setUserStartTimeAtInMillis(System.currentTimeMillis());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.taptap.sdk.db.biz.gameplay.tracker.GameDurationTracker
    public void submitOldUserGameDurationEvent(String oldUserId, String newUserId) {
        Intrinsics.checkNotNullParameter(oldUserId, "oldUserId");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C03361(oldUserId, newUserId, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0096 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.taptap.sdk.db.biz.gameplay.tracker.GameDurationTracker
    public Object submitGameDurationEvent(String userId, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C03351 c03351;
        DefaultGameDurationTracker defaultGameDurationTracker;
        boolean onlyUserDuration;
        long deviceDuration;
        DefaultGameDurationTracker defaultGameDurationTracker2;
        long deviceDuration2;
        GameDurationReporter gameDurationReporter;
        if (continuation instanceof C03351) {
            c03351 = (C03351) continuation;
            if ((c03351.label & Integer.MIN_VALUE) != 0) {
                c03351.label -= Integer.MIN_VALUE;
            } else {
                c03351 = new C03351(continuation);
            }
        } else {
            c03351 = new C03351(continuation);
        }
        C03351 c03352 = c03351;
        Object $result = c03352.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03352.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                defaultGameDurationTracker = this;
                onlyUserDuration = z;
                defaultGameDurationTracker.updateLocalGameDuration(userId);
                GameDuration gameDuration = defaultGameDurationTracker.storage.getGameDuration();
                deviceDuration = gameDuration.getDeviceDuration();
                List<GameDuration.User> listComponent2 = gameDuration.component2();
                if (!(!listComponent2.isEmpty())) {
                    defaultGameDurationTracker2 = defaultGameDurationTracker;
                } else {
                    GameDurationReporter gameDurationReporter2 = defaultGameDurationTracker.reporter;
                    c03352.L$0 = defaultGameDurationTracker;
                    c03352.Z$0 = onlyUserDuration;
                    c03352.J$0 = deviceDuration;
                    c03352.label = 1;
                    if (gameDurationReporter2.submitUserDurations(listComponent2, c03352) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deviceDuration2 = deviceDuration;
                    defaultGameDurationTracker.storage.resetUserDuration();
                    deviceDuration = deviceDuration2;
                    defaultGameDurationTracker2 = defaultGameDurationTracker;
                }
                if (!onlyUserDuration && deviceDuration / 1000 > 0) {
                    gameDurationReporter = defaultGameDurationTracker2.reporter;
                    c03352.L$0 = defaultGameDurationTracker2;
                    c03352.label = 2;
                    if (gameDurationReporter.submitDeviceDuration(deviceDuration, c03352) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    defaultGameDurationTracker2.storage.resetDeviceDuration();
                }
                return Unit.INSTANCE;
            case 1:
                deviceDuration2 = c03352.J$0;
                onlyUserDuration = c03352.Z$0;
                defaultGameDurationTracker = (DefaultGameDurationTracker) c03352.L$0;
                ResultKt.throwOnFailure($result);
                defaultGameDurationTracker.storage.resetUserDuration();
                deviceDuration = deviceDuration2;
                defaultGameDurationTracker2 = defaultGameDurationTracker;
                if (!onlyUserDuration) {
                    gameDurationReporter = defaultGameDurationTracker2.reporter;
                    c03352.L$0 = defaultGameDurationTracker2;
                    c03352.label = 2;
                    if (gameDurationReporter.submitDeviceDuration(deviceDuration, c03352) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    defaultGameDurationTracker2.storage.resetDeviceDuration();
                }
                return Unit.INSTANCE;
            case 2:
                defaultGameDurationTracker2 = (DefaultGameDurationTracker) c03352.L$0;
                ResultKt.throwOnFailure($result);
                defaultGameDurationTracker2.storage.resetDeviceDuration();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$enableAutoSubmitGameDurationEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultGameDurationTracker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.biz.gameplay.tracker.DefaultGameDurationTracker$enableAutoSubmitGameDurationEvent$1", f = "DefaultGameDurationTracker.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultGameDurationTracker.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    DefaultGameDurationTracker defaultGameDurationTracker = DefaultGameDurationTracker.this;
                    this.label = 1;
                    if (defaultGameDurationTracker.submitGameDurationEvent(defaultGameDurationTracker.eventContext.getCurrentUserId(), false, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    anonymousClass1 = this;
                    break;
                    break;
                case 1:
                    anonymousClass1 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            DefaultGameDurationTracker.this.startTimer();
            return Unit.INSTANCE;
        }
    }

    private final void enableAutoSubmitGameDurationEvent() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLocalGameDuration(String userId) {
        long now = System.currentTimeMillis();
        long j = this.deviceStartTimeAtInMillis;
        if (j > 0) {
            long deviceDuration = now - j;
            if (deviceDuration > 0) {
                this.deviceStartTimeAtInMillis = now;
                this.storage.incrementDeviceDuration(deviceDuration);
            }
        }
        String str = userId;
        if (!(str == null || str.length() == 0) && getUserStartTimeAtInMillis() > 0) {
            long userDuration = now - getUserStartTimeAtInMillis();
            if (userDuration > 0) {
                setUserStartTimeAtInMillis(now);
                this.storage.incrementUserDuration(userId, userDuration);
                TapLogger.logd(TAG, "累积用户(" + userId + ")游戏时长: +" + userDuration + " ms");
            }
        }
        GameDurationStorage.DefaultImpls.sync$default(this.storage, false, 1, null);
    }
}

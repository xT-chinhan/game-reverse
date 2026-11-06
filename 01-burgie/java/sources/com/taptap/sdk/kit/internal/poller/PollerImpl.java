package com.taptap.sdk.kit.internal.poller;

import com.taptap.sdk.kit.internal.poller.strategy.IPollerStrategy;
import com.taptap.sdk.kit.internal.poller.strategy.InfiniteStrategy;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PollerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J+\u0010\u0017\u001a\u00020\u00112\u001c\u0010\u0018\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/kit/internal/poller/PollerImpl;", "T", "Lcom/taptap/sdk/kit/internal/poller/Poller;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pollInterval", "", "pollStrategy", "Lcom/taptap/sdk/kit/internal/poller/strategy/IPollerStrategy;", "(Lkotlinx/coroutines/CoroutineScope;JLcom/taptap/sdk/kit/internal/poller/strategy/IPollerStrategy;)V", "_pollerStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/taptap/sdk/kit/internal/poller/PollerState;", "elapsedPollTime", "isPolling", "", "pollerJob", "Lkotlinx/coroutines/Job;", "pollerStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getPollerStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "canPoll", "startPoll", "pollBlock", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "stopPoll", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PollerImpl<T> implements Poller<T> {
    private final MutableStateFlow<PollerState<T>> _pollerStateFlow;
    private final CoroutineScope coroutineScope;
    private long elapsedPollTime;
    private boolean isPolling;
    private final long pollInterval;
    private final IPollerStrategy pollStrategy;
    private Job pollerJob;

    public PollerImpl(CoroutineScope coroutineScope, long pollInterval, IPollerStrategy pollStrategy) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(pollStrategy, "pollStrategy");
        this.coroutineScope = coroutineScope;
        this.pollInterval = pollInterval;
        this.pollStrategy = pollStrategy;
        this._pollerStateFlow = StateFlowKt.MutableStateFlow(PollerState.Initial.INSTANCE);
    }

    public /* synthetic */ PollerImpl(CoroutineScope coroutineScope, long j, InfiniteStrategy infiniteStrategy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, (i & 2) != 0 ? 300L : j, (i & 4) != 0 ? new InfiniteStrategy() : infiniteStrategy);
    }

    @Override // com.taptap.sdk.kit.internal.poller.Poller
    public StateFlow<PollerState<T>> getPollerStateFlow() {
        return this._pollerStateFlow;
    }

    @Override // com.taptap.sdk.kit.internal.poller.Poller
    public Job startPoll(Function1<? super Continuation<? super T>, ? extends Object> pollBlock) {
        Intrinsics.checkNotNullParameter(pollBlock, "pollBlock");
        this.isPolling = true;
        this.elapsedPollTime = 0L;
        Job job = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(this, pollBlock, null), 3, null);
        job.invokeOnCompletion(new Function1<Throwable, Unit>(this) { // from class: com.taptap.sdk.kit.internal.poller.PollerImpl$startPoll$2$1
            final /* synthetic */ PollerImpl<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable throwable) {
                ((PollerImpl) this.this$0)._pollerStateFlow.setValue(throwable instanceof CancellationException ? (PollerState) PollerState.Cancelled.INSTANCE : (PollerState) PollerState.Completed.INSTANCE);
                this.this$0.stopPoll();
            }
        });
        this.pollerJob = job;
        return job;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.poller.PollerImpl$startPoll$1, reason: invalid class name */
    /* JADX INFO: compiled from: PollerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.kit.internal.poller.PollerImpl$startPoll$1", f = "PollerImpl.kt", i = {0, 1}, l = {33, 37}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $pollBlock;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PollerImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PollerImpl<T> pollerImpl, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pollerImpl;
            this.$pollBlock = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$pollBlock, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0036  */
        /* JADX WARN: Code duplicated, block: B:19:0x0085 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x0086  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0086 -> B:9:0x0030). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            CoroutineScope $this$launch;
            CoroutineScope $this$launch2;
            AnonymousClass1 anonymousClass2;
            Object obj;
            Object $result2;
            Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    $this$launch = (CoroutineScope) anonymousClass1.L$0;
                    if (CoroutineScopeKt.isActive($this$launch) || !anonymousClass1.this$0.canPoll()) {
                        ((PollerImpl) anonymousClass1.this$0)._pollerStateFlow.setValue(PollerState.Completed.INSTANCE);
                        return Unit.INSTANCE;
                    }
                    Function1<Continuation<? super T>, Object> function1 = anonymousClass1.$pollBlock;
                    anonymousClass1.L$0 = $this$launch;
                    anonymousClass1.label = 1;
                    Object objInvoke = function1.invoke(anonymousClass1);
                    if (objInvoke == $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = objInvoke;
                    $this$launch2 = $this$launch;
                    anonymousClass2 = anonymousClass1;
                    obj = obj2;
                    ((PollerImpl) anonymousClass2.this$0)._pollerStateFlow.setValue(new PollerState.InProgress($result));
                    ((PollerImpl) anonymousClass2.this$0).elapsedPollTime += ((PollerImpl) anonymousClass2.this$0).pollInterval;
                    anonymousClass2.L$0 = $this$launch2;
                    anonymousClass2.label = 2;
                    if (DelayKt.delay(((PollerImpl) anonymousClass2.this$0).pollInterval, anonymousClass2) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    anonymousClass1 = anonymousClass2;
                    $this$launch = $this$launch2;
                    if (CoroutineScopeKt.isActive($this$launch)) {
                    }
                    ((PollerImpl) anonymousClass1.this$0)._pollerStateFlow.setValue(PollerState.Completed.INSTANCE);
                    return Unit.INSTANCE;
                case 1:
                    CoroutineScope $this$launch3 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$launch2 = $this$launch3;
                    anonymousClass2 = this;
                    obj = $result3;
                    $result2 = $result;
                    ((PollerImpl) anonymousClass2.this$0)._pollerStateFlow.setValue(new PollerState.InProgress($result));
                    ((PollerImpl) anonymousClass2.this$0).elapsedPollTime += ((PollerImpl) anonymousClass2.this$0).pollInterval;
                    anonymousClass2.L$0 = $this$launch2;
                    anonymousClass2.label = 2;
                    if (DelayKt.delay(((PollerImpl) anonymousClass2.this$0).pollInterval, anonymousClass2) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    anonymousClass1 = anonymousClass2;
                    $this$launch = $this$launch2;
                    if (CoroutineScopeKt.isActive($this$launch)) {
                        break;
                    }
                    ((PollerImpl) anonymousClass1.this$0)._pollerStateFlow.setValue(PollerState.Completed.INSTANCE);
                    return Unit.INSTANCE;
                case 2:
                    anonymousClass1 = this;
                    $this$launch = (CoroutineScope) anonymousClass1.L$0;
                    ResultKt.throwOnFailure($result);
                    if (CoroutineScopeKt.isActive($this$launch)) {
                        break;
                    }
                    ((PollerImpl) anonymousClass1.this$0)._pollerStateFlow.setValue(PollerState.Completed.INSTANCE);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // com.taptap.sdk.kit.internal.poller.Poller
    public void stopPoll() {
        this.isPolling = false;
        Job job = this.pollerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pollerJob = null;
    }

    @Override // com.taptap.sdk.kit.internal.poller.Poller
    /* JADX INFO: renamed from: isPolling, reason: from getter */
    public boolean getIsPolling() {
        return this.isPolling;
    }

    @Override // com.taptap.sdk.kit.internal.poller.Poller
    public boolean canPoll() {
        return this.isPolling && this.pollStrategy.canPoll(this.pollInterval, this.elapsedPollTime);
    }
}

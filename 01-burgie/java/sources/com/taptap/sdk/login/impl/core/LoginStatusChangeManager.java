package com.taptap.sdk.login.impl.core;

import android.support.v4.app.NotificationCompat;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.login.LoginAction;
import com.taptap.sdk.login.TapTapLoginCallback;
import com.taptap.sdk.login.impl.statemachine.state.LoginState;
import com.taptap.sdk.login.impl.statemachine.state.LoginStateManager;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: LoginStatusChangeManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/taptap/sdk/login/impl/core/LoginStatusChangeManager;", "", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "loginCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/taptap/sdk/login/TapTapLoginCallback;", "stateObserverJob", "Lkotlinx/coroutines/Job;", "mapStateToAction", "", "state", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;", "(Lcom/taptap/sdk/login/impl/statemachine/state/LoginState;)Ljava/lang/Integer;", "notifyLoginStatusChange", "", NotificationCompat.CATEGORY_STATUS, "registerLoginCallback", "callback", "startObserving", "stateManager", "Lcom/taptap/sdk/login/impl/statemachine/state/LoginStateManager;", "unregisterLoginCallback", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginStatusChangeManager {
    private static Job stateObserverJob;
    public static final LoginStatusChangeManager INSTANCE = new LoginStatusChangeManager();
    private static final CopyOnWriteArrayList<TapTapLoginCallback> loginCallbacks = new CopyOnWriteArrayList<>();
    private static final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    private LoginStatusChangeManager() {
    }

    public final void registerLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CopyOnWriteArrayList<TapTapLoginCallback> copyOnWriteArrayList = loginCallbacks;
        if (!copyOnWriteArrayList.contains(callback)) {
            copyOnWriteArrayList.add(callback);
        }
    }

    public final void unregisterLoginCallback(TapTapLoginCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginCallbacks.remove(callback);
    }

    public final void startObserving(LoginStateManager stateManager) {
        Intrinsics.checkNotNullParameter(stateManager, "stateManager");
        Job job = stateObserverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        stateObserverJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(stateManager, null), 3, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.login.impl.core.LoginStatusChangeManager$startObserving$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoginStatusChangeManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.login.impl.core.LoginStatusChangeManager$startObserving$1", f = "LoginStatusChangeManager.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LoginStateManager $stateManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LoginStateManager loginStateManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$stateManager = loginStateManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$stateManager, continuation);
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
                    final Flow $this$mapNotNull$iv = this.$stateManager.getStateFlow();
                    this.label = 1;
                    if (new Flow<Integer>() { // from class: com.taptap.sdk.login.impl.core.LoginStatusChangeManager$startObserving$1$invokeSuspend$$inlined$mapNotNull$1
                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super Integer> flowCollector, Continuation $completion) {
                            Object objCollect = $this$mapNotNull$iv.collect(new AnonymousClass2(flowCollector), $completion);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.taptap.sdk.login.impl.core.LoginStatusChangeManager$startObserving$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", Constants.VALUE_FIELD, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: com.taptap.sdk.login.impl.core.LoginStatusChangeManager$startObserving$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                            /* JADX INFO: compiled from: Emitters.kt */
                            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                            @DebugMetadata(c = "com.taptap.sdk.login.impl.core.LoginStatusChangeManager$startObserving$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "LoginStatusChangeManager.kt", i = {}, l = {225}, m = "emit", n = {}, s = {})
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
                            public final Object emit(Object value, Continuation continuation) throws Throwable {
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
                                AnonymousClass1 anonymousClass2 = anonymousClass1;
                                Object $result = anonymousClass2.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (anonymousClass2.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector $this$mapNotNull_u24lambda_u2d5 = this.$this_unsafeFlow;
                                        LoginState state = (LoginState) value;
                                        Integer numMapStateToAction = LoginStatusChangeManager.INSTANCE.mapStateToAction(state);
                                        if (numMapStateToAction != null) {
                                            anonymousClass2.label = 1;
                                            Object transformed = $this$mapNotNull_u24lambda_u2d5.emit(numMapStateToAction, anonymousClass2);
                                            if (transformed == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
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
                    }.collect(new FlowCollector() { // from class: com.taptap.sdk.login.impl.core.LoginStatusChangeManager.startObserving.1.2
                        public final Object emit(int action, Continuation<? super Unit> continuation) {
                            LoginStatusChangeManager.INSTANCE.notifyLoginStatusChange(action);
                            return Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit(((Number) value).intValue(), (Continuation<? super Unit>) $completion);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer mapStateToAction(LoginState state) {
        if (state instanceof LoginState.Success) {
            return Integer.valueOf(LoginAction.LOGIN_SUCCESS);
        }
        if (state instanceof LoginState.Failed) {
            return Integer.valueOf(LoginAction.LOGIN_FAIL);
        }
        if (state instanceof LoginState.Cancelled) {
            return Integer.valueOf(LoginAction.LOGIN_CANCEL);
        }
        if (state instanceof LoginState.LoggedOut) {
            return Integer.valueOf(LoginAction.LOGOUT);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyLoginStatusChange(int status) {
        Iterable $this$forEach$iv = loginCallbacks;
        for (Object element$iv : $this$forEach$iv) {
            TapTapLoginCallback callback = (TapTapLoginCallback) element$iv;
            try {
                callback.onLoginStatusChange(status);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}

package com.taptap.sdk.base;

import android.support.v4.app.NotificationCompat;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u00020\u0002:\u0005!\"#$%B!\b\u0002\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0002\u0010\u0010JC\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002)\u0010\u0012\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016J#\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0018*\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J+\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e*\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u0015*\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u0015*\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001eJ\u001e\u0010 \u001a\u00020\u0015*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000eH\u0002R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/taptap/sdk/base/StateMachine;", "STATE", "", "EVENT", "SIDE_EFFECT", "graph", "Lcom/taptap/sdk/base/StateMachine$Graph;", "(Lcom/taptap/sdk/base/StateMachine$Graph;)V", "state", "getState", "()Ljava/lang/Object;", "stateRef", "Ljava/util/concurrent/atomic/AtomicReference;", "transition", "Lcom/taptap/sdk/base/StateMachine$Transition;", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Transition;", "with", TrackAction.INIT, "Lkotlin/Function1;", "Lcom/taptap/sdk/base/StateMachine$GraphBuilder;", "", "Lkotlin/ExtensionFunctionType;", "getDefinition", "Lcom/taptap/sdk/base/StateMachine$Graph$State;", "(Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Graph$State;", "getTransition", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Transition;", "notifyOnEnter", "cause", "(Ljava/lang/Object;Ljava/lang/Object;)V", "notifyOnExit", "notifyOnTransition", "Companion", "Graph", "GraphBuilder", "Matcher", "Transition", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Graph<STATE, EVENT, SIDE_EFFECT> graph;
    private final AtomicReference<STATE> stateRef;

    public /* synthetic */ StateMachine(Graph graph, DefaultConstructorMarker defaultConstructorMarker) {
        this(graph);
    }

    private StateMachine(Graph<STATE, EVENT, SIDE_EFFECT> graph) {
        this.graph = graph;
        this.stateRef = new AtomicReference<>(graph.getInitialState());
    }

    public final STATE getState() {
        STATE state = this.stateRef.get();
        Intrinsics.checkNotNullExpressionValue(state, "stateRef.get()");
        return state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Transition<STATE, EVENT, SIDE_EFFECT> transition(EVENT event) {
        Transition<STATE, EVENT, SIDE_EFFECT> transition;
        Intrinsics.checkNotNullParameter(event, "event");
        synchronized (this) {
            STATE fromState = this.stateRef.get();
            Intrinsics.checkNotNullExpressionValue(fromState, "fromState");
            transition = getTransition(fromState, event);
            if (transition instanceof Transition.Valid) {
                this.stateRef.set((STATE) ((Transition.Valid) transition).getToState());
            }
        }
        notifyOnTransition(transition);
        if (transition instanceof Transition.Valid) {
            Transition.Valid valid = (Transition.Valid) transition;
            notifyOnExit(valid.getFromState(), event);
            notifyOnEnter(valid.getToState(), event);
        }
        return transition;
    }

    public final StateMachine<STATE, EVENT, SIDE_EFFECT> with(Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        return INSTANCE.create(Graph.copy$default(this.graph, getState(), null, null, 6, null), init);
    }

    private final Transition<STATE, EVENT, SIDE_EFFECT> getTransition(STATE state, EVENT event) {
        for (Map.Entry<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, Graph.State.TransitionTo<STATE, SIDE_EFFECT>>> entry : getDefinition(state).getTransitions().entrySet()) {
            Matcher<EVENT, EVENT> key = entry.getKey();
            Function2<STATE, EVENT, Graph.State.TransitionTo<STATE, SIDE_EFFECT>> value = entry.getValue();
            if (key.matches(event)) {
                Graph.State.TransitionTo<STATE, SIDE_EFFECT> transitionToInvoke = value.invoke(state, event);
                Object toState = transitionToInvoke.component1();
                Object sideEffect = transitionToInvoke.component2();
                return new Transition.Valid(state, event, toState, sideEffect);
            }
        }
        return new Transition.Invalid(state, event);
    }

    private final Graph.State<STATE, EVENT, SIDE_EFFECT> getDefinition(STATE state) {
        Map<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions = this.graph.getStateDefinitions();
        Map destination$iv$iv = new LinkedHashMap();
        for (Map.Entry<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> entry : stateDefinitions.entrySet()) {
            if (entry.getKey().matches(state)) {
                destination$iv$iv.put(entry.getKey(), entry.getValue());
            }
        }
        Collection destination$iv$iv2 = new ArrayList(destination$iv$iv.size());
        for (Map.Entry item$iv$iv : destination$iv$iv.entrySet()) {
            destination$iv$iv2.add((Graph.State) item$iv$iv.getValue());
        }
        Graph.State<STATE, EVENT, SIDE_EFFECT> state2 = (Graph.State) CollectionsKt.firstOrNull((List) destination$iv$iv2);
        if (state2 == null) {
            throw new IllegalStateException(("Missing definition for state " + state.getClass().getSimpleName() + '!').toString());
        }
        return state2;
    }

    private final void notifyOnEnter(STATE state, EVENT event) {
        Iterable $this$forEach$iv = getDefinition(state).getOnEnterListeners();
        for (Object element$iv : $this$forEach$iv) {
            Function2 it = (Function2) element$iv;
            it.invoke(state, event);
        }
    }

    private final void notifyOnExit(STATE state, EVENT event) {
        Iterable $this$forEach$iv = getDefinition(state).getOnExitListeners();
        for (Object element$iv : $this$forEach$iv) {
            Function2 it = (Function2) element$iv;
            it.invoke(state, event);
        }
    }

    private final void notifyOnTransition(Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT> transition) {
        Iterable $this$forEach$iv = this.graph.getOnTransitionListeners();
        for (Object element$iv : $this$forEach$iv) {
            Function1 it = (Function1) element$iv;
            it.invoke(transition);
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0003\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0004\u0010\u0003 \u0001*\u00020\u0002*\n\b\u0005\u0010\u0004 \u0001*\u00020\u00022\u00020\u0002:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00028\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Transition;", "STATE", "", "EVENT", "SIDE_EFFECT", "()V", NotificationCompat.CATEGORY_EVENT, "getEvent", "()Ljava/lang/Object;", "fromState", "getFromState", "Invalid", "Valid", "Lcom/taptap/sdk/base/StateMachine$Transition$Invalid;", "Lcom/taptap/sdk/base/StateMachine$Transition$Valid;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Transition<STATE, EVENT, SIDE_EFFECT> {
        public /* synthetic */ Transition(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract EVENT getEvent();

        public abstract STATE getFromState();

        private Transition() {
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u0002*\n\b\b\u0010\u0004 \u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005B)\b\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0007\u0012\u0006\u0010\b\u001a\u00028\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00018\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0012\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00018\bHÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u00072\b\b\u0002\u0010\b\u001a\u00028\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0007\u001a\u00028\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00028\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00018\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Transition$Valid;", "STATE", "", "EVENT", "SIDE_EFFECT", "Lcom/taptap/sdk/base/StateMachine$Transition;", "fromState", NotificationCompat.CATEGORY_EVENT, "toState", "sideEffect", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getEvent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFromState", "getSideEffect", "getToState", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Transition$Valid;", "equals", "", "other", "hashCode", "", "toString", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Valid<STATE, EVENT, SIDE_EFFECT> extends Transition<STATE, EVENT, SIDE_EFFECT> {
            private final EVENT event;
            private final STATE fromState;
            private final SIDE_EFFECT sideEffect;
            private final STATE toState;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, Object obj, Object obj2, Object obj3, Object obj4, int i, Object obj5) {
                if ((i & 1) != 0) {
                    obj = valid.fromState;
                }
                if ((i & 2) != 0) {
                    obj2 = valid.event;
                }
                if ((i & 4) != 0) {
                    obj3 = valid.toState;
                }
                if ((i & 8) != 0) {
                    obj4 = valid.sideEffect;
                }
                return valid.copy(obj, obj2, obj3, obj4);
            }

            public final STATE component1() {
                return this.fromState;
            }

            public final EVENT component2() {
                return this.event;
            }

            public final STATE component3() {
                return this.toState;
            }

            public final SIDE_EFFECT component4() {
                return this.sideEffect;
            }

            public final Valid<STATE, EVENT, SIDE_EFFECT> copy(STATE fromState, EVENT event, STATE toState, SIDE_EFFECT sideEffect) {
                Intrinsics.checkNotNullParameter(fromState, "fromState");
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(toState, "toState");
                return new Valid<>(fromState, event, toState, sideEffect);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics.areEqual(this.fromState, valid.fromState) && Intrinsics.areEqual(this.event, valid.event) && Intrinsics.areEqual(this.toState, valid.toState) && Intrinsics.areEqual(this.sideEffect, valid.sideEffect);
            }

            public int hashCode() {
                int iHashCode = ((((this.fromState.hashCode() * 31) + this.event.hashCode()) * 31) + this.toState.hashCode()) * 31;
                SIDE_EFFECT side_effect = this.sideEffect;
                return iHashCode + (side_effect == null ? 0 : side_effect.hashCode());
            }

            public String toString() {
                return "Valid(fromState=" + this.fromState + ", event=" + this.event + ", toState=" + this.toState + ", sideEffect=" + this.sideEffect + ')';
            }

            @Override // com.taptap.sdk.base.StateMachine.Transition
            public STATE getFromState() {
                return this.fromState;
            }

            @Override // com.taptap.sdk.base.StateMachine.Transition
            public EVENT getEvent() {
                return this.event;
            }

            public final STATE getToState() {
                return this.toState;
            }

            public final SIDE_EFFECT getSideEffect() {
                return this.sideEffect;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(STATE fromState, EVENT event, STATE toState, SIDE_EFFECT side_effect) {
                super(null);
                Intrinsics.checkNotNullParameter(fromState, "fromState");
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(toState, "toState");
                this.fromState = fromState;
                this.event = event;
                this.toState = toState;
                this.sideEffect = side_effect;
            }
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u0002*\n\b\b\u0010\u0004 \u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00028\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ4\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u0007HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0007\u001a\u00028\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00028\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Transition$Invalid;", "STATE", "", "EVENT", "SIDE_EFFECT", "Lcom/taptap/sdk/base/StateMachine$Transition;", "fromState", NotificationCompat.CATEGORY_EVENT, "(Ljava/lang/Object;Ljava/lang/Object;)V", "getEvent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFromState", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Transition$Invalid;", "equals", "", "other", "hashCode", "", "toString", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Invalid<STATE, EVENT, SIDE_EFFECT> extends Transition<STATE, EVENT, SIDE_EFFECT> {
            private final EVENT event;
            private final STATE fromState;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Invalid copy$default(Invalid invalid, Object obj, Object obj2, int i, Object obj3) {
                if ((i & 1) != 0) {
                    obj = invalid.fromState;
                }
                if ((i & 2) != 0) {
                    obj2 = invalid.event;
                }
                return invalid.copy(obj, obj2);
            }

            public final STATE component1() {
                return this.fromState;
            }

            public final EVENT component2() {
                return this.event;
            }

            public final Invalid<STATE, EVENT, SIDE_EFFECT> copy(STATE fromState, EVENT event) {
                Intrinsics.checkNotNullParameter(fromState, "fromState");
                Intrinsics.checkNotNullParameter(event, "event");
                return new Invalid<>(fromState, event);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invalid)) {
                    return false;
                }
                Invalid invalid = (Invalid) other;
                return Intrinsics.areEqual(this.fromState, invalid.fromState) && Intrinsics.areEqual(this.event, invalid.event);
            }

            public int hashCode() {
                return (this.fromState.hashCode() * 31) + this.event.hashCode();
            }

            public String toString() {
                return "Invalid(fromState=" + this.fromState + ", event=" + this.event + ')';
            }

            @Override // com.taptap.sdk.base.StateMachine.Transition
            public STATE getFromState() {
                return this.fromState;
            }

            @Override // com.taptap.sdk.base.StateMachine.Transition
            public EVENT getEvent() {
                return this.event;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invalid(STATE fromState, EVENT event) {
                super(null);
                Intrinsics.checkNotNullParameter(fromState, "fromState");
                Intrinsics.checkNotNullParameter(event, "event");
                this.fromState = fromState;
                this.event = event;
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u0002*\b\b\u0004\u0010\u0003*\u00020\u0002*\b\b\u0005\u0010\u0004*\u00020\u00022\u00020\u0002:\u0001#Bk\u0012\u0006\u0010\u0005\u001a\u00028\u0003\u00120\u0010\u0006\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u0007\u0012*\u0010\n\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0017\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J3\u0010\u0018\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u0007HÆ\u0003J-\u0010\u0019\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bHÆ\u0003J\u008c\u0001\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u000322\b\u0002\u0010\u0006\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u00072,\b\u0002\u0010\n\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R5\u0010\n\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R;\u0010\u0006\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Graph;", "STATE", "", "EVENT", "SIDE_EFFECT", "initialState", "stateDefinitions", "", "Lcom/taptap/sdk/base/StateMachine$Matcher;", "Lcom/taptap/sdk/base/StateMachine$Graph$State;", "onTransitionListeners", "", "Lkotlin/Function1;", "Lcom/taptap/sdk/base/StateMachine$Transition;", "", "(Ljava/lang/Object;Ljava/util/Map;Ljava/util/List;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getOnTransitionListeners", "()Ljava/util/List;", "getStateDefinitions", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/util/Map;Ljava/util/List;)Lcom/taptap/sdk/base/StateMachine$Graph;", "equals", "", "other", "hashCode", "", "toString", "", "State", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Graph<STATE, EVENT, SIDE_EFFECT> {
        private final STATE initialState;
        private final List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners;
        private final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Graph copy$default(Graph graph, Object obj, Map map, List list, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = graph.initialState;
            }
            if ((i & 2) != 0) {
                map = graph.stateDefinitions;
            }
            if ((i & 4) != 0) {
                list = graph.onTransitionListeners;
            }
            return graph.copy(obj, map, list);
        }

        public final STATE component1() {
            return this.initialState;
        }

        public final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> component2() {
            return this.stateDefinitions;
        }

        public final List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> component3() {
            return this.onTransitionListeners;
        }

        public final Graph<STATE, EVENT, SIDE_EFFECT> copy(STATE initialState, Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions, List<? extends Function1<? super Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNullParameter(stateDefinitions, "stateDefinitions");
            Intrinsics.checkNotNullParameter(onTransitionListeners, "onTransitionListeners");
            return new Graph<>(initialState, stateDefinitions, onTransitionListeners);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Graph)) {
                return false;
            }
            Graph graph = (Graph) other;
            return Intrinsics.areEqual(this.initialState, graph.initialState) && Intrinsics.areEqual(this.stateDefinitions, graph.stateDefinitions) && Intrinsics.areEqual(this.onTransitionListeners, graph.onTransitionListeners);
        }

        public int hashCode() {
            return (((this.initialState.hashCode() * 31) + this.stateDefinitions.hashCode()) * 31) + this.onTransitionListeners.hashCode();
        }

        public String toString() {
            return "Graph(initialState=" + this.initialState + ", stateDefinitions=" + this.stateDefinitions + ", onTransitionListeners=" + this.onTransitionListeners + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Graph(STATE initialState, Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions, List<? extends Function1<? super Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNullParameter(stateDefinitions, "stateDefinitions");
            Intrinsics.checkNotNullParameter(onTransitionListeners, "onTransitionListeners");
            this.initialState = initialState;
            this.stateDefinitions = stateDefinitions;
            this.onTransitionListeners = onTransitionListeners;
        }

        public final STATE getInitialState() {
            return this.initialState;
        }

        public final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> getStateDefinitions() {
            return this.stateDefinitions;
        }

        public final List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> getOnTransitionListeners() {
            return this.onTransitionListeners;
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0006\u0010\u0001*\u00020\u0002*\b\b\u0007\u0010\u0003*\u00020\u0002*\b\b\b\u0010\u0004*\u00020\u00022\u00020\u0002:\u0001\u0015B\u0007\b\u0000¢\u0006\u0002\u0010\u0005R)\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0081\u0001\u0010\u000e\u001ar\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\u00070\u0010\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\b0\u00110\b0\u000fj8\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\u00070\u0010\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\b0\u00110\b`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Graph$State;", "STATE", "", "EVENT", "SIDE_EFFECT", "()V", "onEnterListeners", "", "Lkotlin/Function2;", "", "getOnEnterListeners", "()Ljava/util/List;", "onExitListeners", "getOnExitListeners", "transitions", "Ljava/util/LinkedHashMap;", "Lcom/taptap/sdk/base/StateMachine$Matcher;", "Lcom/taptap/sdk/base/StateMachine$Graph$State$TransitionTo;", "Lkotlin/collections/LinkedHashMap;", "getTransitions", "()Ljava/util/LinkedHashMap;", "TransitionTo", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class State<STATE, EVENT, SIDE_EFFECT> {
            private final List<Function2<STATE, EVENT, Unit>> onEnterListeners = new ArrayList();
            private final List<Function2<STATE, EVENT, Unit>> onExitListeners = new ArrayList();
            private final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, TransitionTo<STATE, SIDE_EFFECT>>> transitions = new LinkedHashMap<>();

            public final List<Function2<STATE, EVENT, Unit>> getOnEnterListeners() {
                return this.onEnterListeners;
            }

            public final List<Function2<STATE, EVENT, Unit>> getOnExitListeners() {
                return this.onExitListeners;
            }

            public final LinkedHashMap<Matcher<EVENT, EVENT>, Function2<STATE, EVENT, TransitionTo<STATE, SIDE_EFFECT>>> getTransitions() {
                return this.transitions;
            }

            /* JADX INFO: compiled from: StateMachine.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\t\u0010\u0001 \u0001*\u00020\u0002*\n\b\n\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00028\t\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\n¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00028\tHÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00018\nHÆ\u0003¢\u0006\u0002\u0010\bJ0\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n0\u00002\b\b\u0002\u0010\u0004\u001a\u00028\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\nHÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\n¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00028\t¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Graph$State$TransitionTo;", "STATE", "", "SIDE_EFFECT", "toState", "sideEffect", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getSideEffect", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getToState", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Graph$State$TransitionTo;", "equals", "", "other", "hashCode", "", "toString", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final /* data */ class TransitionTo<STATE, SIDE_EFFECT> {
                private final SIDE_EFFECT sideEffect;
                private final STATE toState;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ TransitionTo copy$default(TransitionTo transitionTo, Object obj, Object obj2, int i, Object obj3) {
                    if ((i & 1) != 0) {
                        obj = transitionTo.toState;
                    }
                    if ((i & 2) != 0) {
                        obj2 = transitionTo.sideEffect;
                    }
                    return transitionTo.copy(obj, obj2);
                }

                public final STATE component1() {
                    return this.toState;
                }

                public final SIDE_EFFECT component2() {
                    return this.sideEffect;
                }

                public final TransitionTo<STATE, SIDE_EFFECT> copy(STATE toState, SIDE_EFFECT sideEffect) {
                    Intrinsics.checkNotNullParameter(toState, "toState");
                    return new TransitionTo<>(toState, sideEffect);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof TransitionTo)) {
                        return false;
                    }
                    TransitionTo transitionTo = (TransitionTo) other;
                    return Intrinsics.areEqual(this.toState, transitionTo.toState) && Intrinsics.areEqual(this.sideEffect, transitionTo.sideEffect);
                }

                public int hashCode() {
                    int iHashCode = this.toState.hashCode() * 31;
                    SIDE_EFFECT side_effect = this.sideEffect;
                    return iHashCode + (side_effect == null ? 0 : side_effect.hashCode());
                }

                public String toString() {
                    return "TransitionTo(toState=" + this.toState + ", sideEffect=" + this.sideEffect + ')';
                }

                public TransitionTo(STATE toState, SIDE_EFFECT side_effect) {
                    Intrinsics.checkNotNullParameter(toState, "toState");
                    this.toState = toState;
                    this.sideEffect = side_effect;
                }

                public final STATE getToState() {
                    return this.toState;
                }

                public final SIDE_EFFECT getSideEffect() {
                    return this.sideEffect;
                }
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0011*\b\b\u0003\u0010\u0001*\u00020\u0002*\n\b\u0004\u0010\u0003 \u0001*\u0002H\u00012\u00020\u0002:\u0001\u0011B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00040\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0003¢\u0006\u0002\u0010\rJ+\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00002\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00040\u0005X\u0088\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Matcher;", "T", "", "R", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "predicates", "", "Lkotlin/Function1;", "", "matches", Constants.VALUE_FIELD, "(Ljava/lang/Object;)Z", "where", "predicate", "Lkotlin/ExtensionFunctionType;", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Matcher<T, R extends T> {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Class<R> clazz;
        private final List<Function1<T, Boolean>> predicates;

        public /* synthetic */ Matcher(Class cls, DefaultConstructorMarker defaultConstructorMarker) {
            this(cls);
        }

        private Matcher(Class<R> cls) {
            this.clazz = cls;
            this.predicates = CollectionsKt.mutableListOf(new Function1<T, Boolean>(this) { // from class: com.taptap.sdk.base.StateMachine$Matcher$predicates$1
                final /* synthetic */ StateMachine.Matcher<T, R> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(((StateMachine.Matcher) this.this$0).clazz.isInstance(it));
                }
            });
        }

        public final Matcher<T, R> where(final Function1<? super R, Boolean> predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            this.predicates.add(new Function1<T, Boolean>() { // from class: com.taptap.sdk.base.StateMachine$Matcher$where$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return predicate.invoke((R) it);
                }
            });
            return this;
        }

        public final boolean matches(T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Iterable $this$all$iv = this.predicates;
            if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
                return true;
            }
            for (Object element$iv : $this$all$iv) {
                Function1 it = (Function1) element$iv;
                if (!((Boolean) it.invoke(value)).booleanValue()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0005\u0010\u0005*\u00020\u0001\"\n\b\u0006\u0010\u0006\u0018\u0001*\u0002H\u0005H\u0086\bJ4\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0005\u0010\u0005*\u00020\u0001\"\b\b\u0006\u0010\u0006*\u0002H\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bJ8\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0005\u0010\u0005*\u00020\u0001\"\n\b\u0006\u0010\u0006\u0018\u0001*\u0002H\u00052\u0006\u0010\n\u001a\u0002H\u0006H\u0086\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Matcher$Companion;", "", "()V", "any", "Lcom/taptap/sdk/base/StateMachine$Matcher;", "T", "R", "clazz", "Ljava/lang/Class;", "eq", Constants.VALUE_FIELD, "(Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Matcher;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final <T, R extends T> Matcher<T, R> any(Class<R> clazz) {
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                return new Matcher<>(clazz, null);
            }

            public final /* synthetic */ <T, R extends T> Matcher<T, R> any() {
                Intrinsics.reifiedOperationMarker(4, "R");
                return any(Object.class);
            }

            public final /* synthetic */ <T, R extends T> Matcher<T, R> eq(final R value) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.reifiedOperationMarker(4, "R");
                Matcher<T, R> matcherAny = any(Object.class);
                Intrinsics.needClassReification();
                return matcherAny.where((Function1) new Function1<R, Boolean>() { // from class: com.taptap.sdk.base.StateMachine$Matcher$Companion$eq$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(R where) {
                        Intrinsics.checkNotNullParameter(where, "$this$where");
                        return Boolean.valueOf(Intrinsics.areEqual(where, value));
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u0002*\b\b\u0004\u0010\u0003*\u00020\u0002*\b\b\u0005\u0010\u0004*\u00020\u00022\u00020\u0002:\u0001!B#\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0006J\u0013\u0010\b\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0003¢\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u00020\u000e2$\u0010\u0019\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e0\fJ\\\u0010\u001a\u001a\u00020\u000e\"\n\b\u0006\u0010\u001b\u0018\u0001*\u00028\u00032\u0006\u0010\u001a\u001a\u0002H\u001b25\b\b\u0010\u001c\u001a/\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u001b0\u001dR\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0000\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001fJO\u0010\u001a\u001a\u00020\u000e\"\n\b\u0006\u0010\u001b\u0018\u0001*\u00028\u000325\b\b\u0010\u001c\u001a/\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u001b0\u001dR\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0000\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000JY\u0010\u001a\u001a\u00020\u000e\"\b\b\u0006\u0010\u001b*\u00028\u00032\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u0002H\u001b0\u001323\u0010\u001c\u001a/\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u001b0\u001dR\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0000\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u001eR\u0012\u0010\b\u001a\u0004\u0018\u00018\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR§\u0001\u0010\n\u001a\u009a\u0001\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e \u000f*\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\f0\u000bjL\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e \u000f*\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RÃ\u0001\u0010\u0011\u001a¶\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003 \u000f*\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00130\u0013\u00120\u0012.\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005 \u000f*\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u00140\u00140\u0012jZ\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003 \u000f*\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00130\u0013\u00120\u0012.\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005 \u000f*\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u00140\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"Lcom/taptap/sdk/base/StateMachine$GraphBuilder;", "STATE", "", "EVENT", "SIDE_EFFECT", "graph", "Lcom/taptap/sdk/base/StateMachine$Graph;", "(Lcom/taptap/sdk/base/StateMachine$Graph;)V", "initialState", "Ljava/lang/Object;", "onTransitionListeners", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lcom/taptap/sdk/base/StateMachine$Transition;", "", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "stateDefinitions", "Ljava/util/LinkedHashMap;", "Lcom/taptap/sdk/base/StateMachine$Matcher;", "Lcom/taptap/sdk/base/StateMachine$Graph$State;", "Lkotlin/collections/LinkedHashMap;", "build", "(Ljava/lang/Object;)V", "onTransition", "listener", "state", "S", TrackAction.INIT, "Lcom/taptap/sdk/base/StateMachine$GraphBuilder$StateDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "stateMatcher", "StateDefinitionBuilder", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {
        private STATE initialState;
        private final ArrayList<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners;
        private final LinkedHashMap<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions;

        /* JADX WARN: Multi-variable type inference failed */
        public GraphBuilder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public GraphBuilder(Graph<STATE, EVENT, SIDE_EFFECT> graph) {
            List<Function1<Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> onTransitionListeners;
            Map<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> stateDefinitions;
            this.initialState = graph != null ? graph.getInitialState() : null;
            this.stateDefinitions = new LinkedHashMap<>((graph == null || (stateDefinitions = graph.getStateDefinitions()) == null) ? MapsKt.emptyMap() : stateDefinitions);
            this.onTransitionListeners = new ArrayList<>((graph == null || (onTransitionListeners = graph.getOnTransitionListeners()) == null) ? CollectionsKt.emptyList() : onTransitionListeners);
        }

        public /* synthetic */ GraphBuilder(Graph graph, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : graph);
        }

        public final void initialState(STATE initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            this.initialState = initialState;
        }

        public final <S extends STATE> void state(Matcher<STATE, ? extends S> stateMatcher, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> init) {
            Intrinsics.checkNotNullParameter(stateMatcher, "stateMatcher");
            Intrinsics.checkNotNullParameter(init, "init");
            LinkedHashMap<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> linkedHashMap = this.stateDefinitions;
            StateDefinitionBuilder stateDefinitionBuilder = new StateDefinitionBuilder();
            init.invoke(stateDefinitionBuilder);
            linkedHashMap.put(stateMatcher, stateDefinitionBuilder.build());
        }

        public final /* synthetic */ <S extends STATE> void state(Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> init) {
            Intrinsics.checkNotNullParameter(init, "init");
            Matcher.Companion this_$iv = Matcher.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "S");
            state((Matcher) this_$iv.any(Object.class), (Function1) init);
        }

        public final /* synthetic */ <S extends STATE> void state(final S state, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> init) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(init, "init");
            Matcher.Companion this_$iv = Matcher.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "S");
            Matcher matcherAny = this_$iv.any(Object.class);
            Intrinsics.needClassReification();
            state((Matcher) matcherAny.where(new Function1<S, Boolean>() { // from class: com.taptap.sdk.base.StateMachine$GraphBuilder$state$$inlined$eq$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(S where) {
                    Intrinsics.checkNotNullParameter(where, "$this$where");
                    return Boolean.valueOf(Intrinsics.areEqual(where, state));
                }
            }), (Function1) init);
        }

        public final void onTransition(Function1<? super Transition<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onTransitionListeners.add(listener);
        }

        public final Graph<STATE, EVENT, SIDE_EFFECT> build() {
            STATE state = this.initialState;
            if (state != null) {
                return new Graph<>(state, MapsKt.toMap(this.stateDefinitions), CollectionsKt.toList(this.onTransitionListeners));
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        /* JADX INFO: compiled from: StateMachine.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0004\u0018\u0000*\b\b\u0006\u0010\u0001*\u00028\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u0002H\b0\u0007\"\n\b\u0007\u0010\b\u0018\u0001*\u00028\u0004H\u0086\bJ\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005J.\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u0002H\u000b0\u0007\"\n\b\u0007\u0010\u000b\u0018\u0001*\u00028\u00042\u0006\u0010\f\u001a\u0002H\u000bH\u0086\b¢\u0006\u0002\u0010\rJR\u0010\u000e\u001a\u00020\u000f\"\n\b\u0007\u0010\b\u0018\u0001*\u00028\u00042\u0006\u0010\u0010\u001a\u0002H\b2+\b\b\u0010\u0011\u001a%\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u00130\u0012¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015JE\u0010\u000e\u001a\u00020\u000f\"\n\b\u0007\u0010\b\u0018\u0001*\u00028\u00042+\b\b\u0010\u0011\u001a%\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u00130\u0012¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000JO\u0010\u000e\u001a\u00020\u000f\"\b\b\u0007\u0010\b*\u00028\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u0002H\b0\u00072)\u0010\u0011\u001a%\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u0002H\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u00130\u0012¢\u0006\u0002\b\u0014J%\u0010\u0017\u001a\u00020\u00182\u001d\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0002\b\u0014J%\u0010\u001a\u001a\u00020\u00182\u001d\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0002\b\u0014J'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u0013*\u00028\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00018\u0005¢\u0006\u0002\u0010\u001dJ/\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u0013*\u00028\u00062\u0006\u0010\u001f\u001a\u00028\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00018\u0005¢\u0006\u0002\u0010 R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$GraphBuilder$StateDefinitionBuilder;", "S", "", "(Lcom/taptap/sdk/base/StateMachine$GraphBuilder;)V", "stateDefinition", "Lcom/taptap/sdk/base/StateMachine$Graph$State;", "any", "Lcom/taptap/sdk/base/StateMachine$Matcher;", "E", "build", "eq", "R", Constants.VALUE_FIELD, "(Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Matcher;", DebugKt.DEBUG_PROPERTY_VALUE_ON, "", NotificationCompat.CATEGORY_EVENT, "createTransitionTo", "Lkotlin/Function2;", "Lcom/taptap/sdk/base/StateMachine$Graph$State$TransitionTo;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "eventMatcher", "onEnter", "", "listener", "onExit", "dontTransition", "sideEffect", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Graph$State$TransitionTo;", "transitionTo", "state", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/taptap/sdk/base/StateMachine$Graph$State$TransitionTo;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class StateDefinitionBuilder<S extends STATE> {
            private final Graph.State<STATE, EVENT, SIDE_EFFECT> stateDefinition = new Graph.State<>();

            public StateDefinitionBuilder() {
            }

            public final /* synthetic */ <E extends EVENT> Matcher<EVENT, E> any() {
                Matcher.Companion this_$iv = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "E");
                return this_$iv.any(Object.class);
            }

            public final /* synthetic */ <R extends EVENT> Matcher<EVENT, R> eq(final R value) {
                Intrinsics.checkNotNullParameter(value, "value");
                Matcher.Companion this_$iv = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "R");
                Matcher matcherAny = this_$iv.any(Object.class);
                Intrinsics.needClassReification();
                return matcherAny.where(new Function1<R, Boolean>() { // from class: com.taptap.sdk.base.StateMachine$GraphBuilder$StateDefinitionBuilder$eq$$inlined$eq$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(R where) {
                        Intrinsics.checkNotNullParameter(where, "$this$where");
                        return Boolean.valueOf(Intrinsics.areEqual(where, value));
                    }
                });
            }

            public final <E extends EVENT> void on(Matcher<EVENT, ? extends E> eventMatcher, final Function2<? super S, ? super E, ? extends Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>> createTransitionTo) {
                Intrinsics.checkNotNullParameter(eventMatcher, "eventMatcher");
                Intrinsics.checkNotNullParameter(createTransitionTo, "createTransitionTo");
                this.stateDefinition.getTransitions().put(eventMatcher, new Function2<STATE, EVENT, Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>>() { // from class: com.taptap.sdk.base.StateMachine$GraphBuilder$StateDefinitionBuilder$on$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    @Override // kotlin.jvm.functions.Function2
                    public final StateMachine.Graph.State.TransitionTo<STATE, SIDE_EFFECT> invoke(STATE state, EVENT event) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        Intrinsics.checkNotNullParameter(event, "event");
                        return createTransitionTo.invoke((S) state, (E) event);
                    }
                });
            }

            public final /* synthetic */ <E extends EVENT> void on(Function2<? super S, ? super E, ? extends Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>> createTransitionTo) {
                Intrinsics.checkNotNullParameter(createTransitionTo, "createTransitionTo");
                Matcher.Companion this_$iv$iv = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "E");
                on((Matcher) this_$iv$iv.any(Object.class), (Function2) createTransitionTo);
            }

            public final /* synthetic */ <E extends EVENT> void on(final E event, Function2<? super S, ? super E, ? extends Graph.State.TransitionTo<? extends STATE, ? extends SIDE_EFFECT>> createTransitionTo) {
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(createTransitionTo, "createTransitionTo");
                Matcher.Companion this_$iv$iv = Matcher.INSTANCE;
                Intrinsics.reifiedOperationMarker(4, "E");
                Matcher matcherAny = this_$iv$iv.any(Object.class);
                Intrinsics.needClassReification();
                on((Matcher) matcherAny.where(new Function1<E, Boolean>() { // from class: com.taptap.sdk.base.StateMachine$GraphBuilder$StateDefinitionBuilder$on$$inlined$eq$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(E where) {
                        Intrinsics.checkNotNullParameter(where, "$this$where");
                        return Boolean.valueOf(Intrinsics.areEqual(where, event));
                    }
                }), (Function2) createTransitionTo);
            }

            public final boolean onEnter(final Function2<? super S, ? super EVENT, Unit> listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                return this.stateDefinition.getOnEnterListeners().add(new Function2<STATE, EVENT, Unit>() { // from class: com.taptap.sdk.base.StateMachine$GraphBuilder$StateDefinitionBuilder$onEnter$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                        invoke2(obj, obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(STATE state, EVENT cause) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        Intrinsics.checkNotNullParameter(cause, "cause");
                        listener.invoke((S) state, cause);
                    }
                });
            }

            public final boolean onExit(final Function2<? super S, ? super EVENT, Unit> listener) {
                Intrinsics.checkNotNullParameter(listener, "listener");
                return this.stateDefinition.getOnExitListeners().add(new Function2<STATE, EVENT, Unit>() { // from class: com.taptap.sdk.base.StateMachine$GraphBuilder$StateDefinitionBuilder$onExit$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                        invoke2(obj, obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(STATE state, EVENT cause) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        Intrinsics.checkNotNullParameter(cause, "cause");
                        listener.invoke((S) state, cause);
                    }
                });
            }

            public final Graph.State<STATE, EVENT, SIDE_EFFECT> build() {
                return this.stateDefinition;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Graph.State.TransitionTo transitionTo$default(StateDefinitionBuilder stateDefinitionBuilder, Object obj, Object obj2, Object obj3, int i, Object obj4) {
                if ((i & 2) != 0) {
                    obj3 = null;
                }
                return stateDefinitionBuilder.transitionTo(obj, obj2, obj3);
            }

            public final Graph.State.TransitionTo<STATE, SIDE_EFFECT> transitionTo(S s, STATE state, SIDE_EFFECT side_effect) {
                Intrinsics.checkNotNullParameter(s, "<this>");
                Intrinsics.checkNotNullParameter(state, "state");
                return new Graph.State.TransitionTo<>(state, side_effect);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Graph.State.TransitionTo dontTransition$default(StateDefinitionBuilder stateDefinitionBuilder, Object obj, Object obj2, int i, Object obj3) {
                if ((i & 1) != 0) {
                    obj2 = null;
                }
                return stateDefinitionBuilder.dontTransition(obj, obj2);
            }

            public final Graph.State.TransitionTo<STATE, SIDE_EFFECT> dontTransition(S s, SIDE_EFFECT side_effect) {
                Intrinsics.checkNotNullParameter(s, "<this>");
                return transitionTo(s, s, side_effect);
            }
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u007f\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0004\"\b\b\u0003\u0010\u0005*\u00020\u0001\"\b\b\u0004\u0010\u0006*\u00020\u0001\"\b\b\u0005\u0010\u0007*\u00020\u00012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\t2)\u0010\n\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0002Ja\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0004\"\b\b\u0003\u0010\u0005*\u00020\u0001\"\b\b\u0004\u0010\u0006*\u00020\u0001\"\b\b\u0005\u0010\u0007*\u00020\u00012)\u0010\n\u001a%\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/base/StateMachine$Companion;", "", "()V", "create", "Lcom/taptap/sdk/base/StateMachine;", "STATE", "EVENT", "SIDE_EFFECT", "graph", "Lcom/taptap/sdk/base/StateMachine$Graph;", TrackAction.INIT, "Lkotlin/Function1;", "Lcom/taptap/sdk/base/StateMachine$GraphBuilder;", "", "Lkotlin/ExtensionFunctionType;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <STATE, EVENT, SIDE_EFFECT> StateMachine<STATE, EVENT, SIDE_EFFECT> create(Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> init) {
            Intrinsics.checkNotNullParameter(init, "init");
            return create(null, init);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <STATE, EVENT, SIDE_EFFECT> StateMachine<STATE, EVENT, SIDE_EFFECT> create(Graph<STATE, EVENT, SIDE_EFFECT> graph, Function1<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> init) {
            GraphBuilder graphBuilder = new GraphBuilder(graph);
            init.invoke(graphBuilder);
            return new StateMachine<>(graphBuilder.build(), null);
        }
    }
}

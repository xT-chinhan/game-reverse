package com.taptap.sdk.startup;

import android.content.Context;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.startup.grpah.Graph;
import com.taptap.sdk.startup.task.InitializeTask;
import com.taptap.sdk.startup.task.Task;
import com.taptap.sdk.startup.task.TaskNode;
import com.taptap.sdk.startup.utils.ListUtils;
import com.taptap.sdk.startup.utils.TaskFactoryCollector;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StartUp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u000eJ\u001c\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u0011J&\u0010\u001a\u001a\u0004\u0018\u00010\u000b*\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\u001d\u001a\u00020\u0011*\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\u001e\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\f\u0010\u001f\u001a\u00020\u000e*\u00020\u001bH\u0002J&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0017*\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/taptap/sdk/startup/StartUp;", "", "builder", "Lcom/taptap/sdk/startup/StartUp$Builder;", "(Lcom/taptap/sdk/startup/StartUp$Builder;)V", d.R, "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tasks", "", "Lcom/taptap/sdk/startup/task/Task;", "(Landroid/content/Context;Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;Ljava/util/List;)V", "__inject", "", "buildGraph", "Lcom/taptap/sdk/startup/grpah/Graph;", "Lcom/taptap/sdk/startup/task/TaskNode;", "findTask", "clazz", "", "initialize", "validate", "Lkotlin/Function1;", "", "taskNode", "createTask", "Lkotlinx/coroutines/CoroutineScope;", "task", "createTaskNode", "execute", TrackAction.START, "updateTaskWhenSort", "Builder", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StartUp {
    private final Context context;
    private TapTapSdkOptions options;
    private List<Task> tasks;

    public /* synthetic */ StartUp(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public StartUp(Context context, TapTapSdkOptions options, List<Task> tasks) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        this.context = context;
        this.options = options;
        this.tasks = tasks;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private StartUp(Builder builder) {
        Context context = builder.getContext();
        TapTapSdkOptions options = builder.getOptions();
        if (options != null) {
            this(context, options, builder.getTasks$tap_core_release());
            __inject();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void __inject() {
        List<Task> list = this.tasks;
        Iterable $this$map$iv = new TaskFactoryCollector().collect();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Task task = (Task) item$iv$iv;
            destination$iv$iv.add(task.reduce(new Function1<Task, Task>() { // from class: com.taptap.sdk.startup.StartUp$__inject$1$1
                @Override // kotlin.jvm.functions.Function1
                public final Task invoke(final Task reduce) {
                    Intrinsics.checkNotNullParameter(reduce, "$this$reduce");
                    return Task.copy$default(reduce, null, null, false, 0, null, new Function2<Context, TapTapSdkOptions, Unit>() { // from class: com.taptap.sdk.startup.StartUp$__inject$1$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Context context, TapTapSdkOptions tapTapSdkOptions) {
                            invoke2(context, tapTapSdkOptions);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Context context, TapTapSdkOptions options) {
                            Intrinsics.checkNotNullParameter(context, "context");
                            Intrinsics.checkNotNullParameter(options, "options");
                            reduce.getClazz().newInstance().execute(context, options);
                        }
                    }, null, 95, null);
                }
            }));
        }
        this.tasks = CollectionsKt.plus((Collection) list, destination$iv$iv);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.startup.StartUp$initialize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: StartUp.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.startup.StartUp$initialize$1", f = "StartUp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03541(Continuation<? super C03541> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03541 c03541 = StartUp.this.new C03541(continuation);
            c03541.L$0 = obj;
            return c03541;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$runBlocking = (CoroutineScope) this.L$0;
                    StartUp.this.start($this$runBlocking);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void initialize() {
        BuildersKt__BuildersKt.runBlocking$default(null, new C03541(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void start(CoroutineScope $this$start) {
        buildGraph(this.tasks).sort(updateTaskWhenSort($this$start, this.context, this.options));
    }

    public final Function1<TaskNode, TaskNode> updateTaskWhenSort(final CoroutineScope $this$updateTaskWhenSort, final Context context, final TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter($this$updateTaskWhenSort, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        return new Function1<TaskNode, TaskNode>() { // from class: com.taptap.sdk.startup.StartUp.updateTaskWhenSort.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TaskNode invoke(TaskNode taskNode) {
                Intrinsics.checkNotNullParameter(taskNode, "taskNode");
                TaskNode newTaskNode = StartUp.this.createTaskNode($this$updateTaskWhenSort, taskNode, context, options);
                StartUp.this.tasks = CollectionsKt.filterNotNull(ListUtils.INSTANCE.updateOrInsert(StartUp.this.tasks, newTaskNode.getTask(), StartUp.this.validate(newTaskNode)));
                return newTaskNode;
            }
        };
    }

    public final TaskNode createTaskNode(final CoroutineScope $this$createTaskNode, TaskNode taskNode, final Context context, final TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter($this$createTaskNode, "<this>");
        Intrinsics.checkNotNullParameter(taskNode, "taskNode");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        if (taskNode instanceof TaskNode.Real) {
            return ((TaskNode.Real) taskNode).reduce(new Function1<TaskNode.Real, TaskNode.Real>() { // from class: com.taptap.sdk.startup.StartUp.createTaskNode.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final TaskNode.Real invoke(TaskNode.Real taskNode2) {
                    Intrinsics.checkNotNullParameter(taskNode2, "$this$taskNode");
                    return taskNode2.copy(StartUp.this.createTask($this$createTaskNode, taskNode2.getTask(), context, options));
                }
            });
        }
        if (taskNode instanceof TaskNode.Virtual) {
            return taskNode;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Task createTask(final CoroutineScope $this$createTask, final Task task, final Context context, final TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter($this$createTask, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        if (task == null) {
            return null;
        }
        return task.reduce(new Function1<Task, Task>() { // from class: com.taptap.sdk.startup.StartUp.createTask.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX INFO: renamed from: com.taptap.sdk.startup.StartUp$createTask$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StartUp.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.taptap.sdk.startup.StartUp$createTask$1$1", f = "StartUp.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE}, m = "invokeSuspend", n = {}, s = {})
            static final class C02731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Context $context;
                final /* synthetic */ TapTapSdkOptions $options;
                final /* synthetic */ Task $task;
                Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ StartUp this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02731(Task task, StartUp startUp, Context context, TapTapSdkOptions tapTapSdkOptions, Continuation<? super C02731> continuation) {
                    super(2, continuation);
                    this.$task = task;
                    this.this$0 = startUp;
                    this.$context = context;
                    this.$options = tapTapSdkOptions;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C02731(this.$task, this.this$0, this.$context, this.$options, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C02731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:10:0x003e  */
                /* JADX WARN: Code duplicated, block: B:23:0x006b A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:24:0x004b A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:27:0x0038 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0061 -> B:18:0x0064). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:23:0x006b
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        switch(r1) {
                            case 0: goto L22;
                            case 1: goto L11;
                            default: goto L9;
                        }
                    L9:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L11:
                        r1 = r10
                        r2 = 0
                        r3 = 0
                        r4 = 0
                        r5 = 0
                        java.lang.Object r6 = r1.L$1
                        java.util.Iterator r6 = (java.util.Iterator) r6
                        java.lang.Object r7 = r1.L$0
                        com.taptap.sdk.startup.StartUp r7 = (com.taptap.sdk.startup.StartUp) r7
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L64
                    L22:
                        kotlin.ResultKt.throwOnFailure(r11)
                        r1 = r10
                        com.taptap.sdk.startup.task.Task r2 = r1.$task
                        java.util.Set r2 = r2.getDependsOn()
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        com.taptap.sdk.startup.StartUp r3 = r1.this$0
                        r4 = 0
                        java.util.Iterator r5 = r2.iterator()
                        r7 = r3
                        r2 = r4
                        r6 = r5
                    L38:
                        boolean r3 = r6.hasNext()
                        if (r3 == 0) goto L6b
                        java.lang.Object r3 = r6.next()
                        java.lang.String r3 = (java.lang.String) r3
                        r4 = 0
                        com.taptap.sdk.startup.task.Task r3 = com.taptap.sdk.startup.StartUp.access$findTask(r7, r3)
                        if (r3 == 0) goto L69
                        r5 = 0
                        kotlinx.coroutines.Job r3 = r3.getJob()
                        if (r3 == 0) goto L67
                        r8 = 0
                        r1.L$0 = r7
                        r1.L$1 = r6
                        r9 = 1
                        r1.label = r9
                        java.lang.Object r3 = r3.join(r1)
                        if (r3 != r0) goto L61
                        return r0
                    L61:
                        r3 = r4
                        r4 = r5
                        r5 = r8
                    L64:
                        r5 = r4
                        r4 = r3
                    L67:
                    L69:
                        goto L38
                    L6b:
                        com.taptap.sdk.startup.StartUp r0 = r1.this$0
                        com.taptap.sdk.startup.task.Task r2 = r1.$task
                        android.content.Context r3 = r1.$context
                        com.taptap.sdk.initializer.api.option.TapTapSdkOptions r4 = r1.$options
                        com.taptap.sdk.startup.StartUp.access$execute(r0, r2, r3, r4)
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.taptap.sdk.startup.StartUp.AnonymousClass1.C02731.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final Task invoke(Task reduce) {
                Intrinsics.checkNotNullParameter(reduce, "$this$reduce");
                return Task.copy$default(reduce, null, null, false, 0, null, null, BuildersKt__Builders_commonKt.launch$default($this$createTask, null, null, new C02731(task, this, context, options, null), 3, null), 63, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Task findTask(String clazz) {
        Object next;
        Iterator<T> it = this.tasks.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Task) next).getClazz().getName(), clazz));
        Task task = (Task) next;
        if (task == null) {
            TapLogger.logi("TapStartUp", "can not found task: " + clazz);
        }
        return task;
    }

    public final Function1<Task, Boolean> validate(final TaskNode taskNode) {
        Intrinsics.checkNotNullParameter(taskNode, "taskNode");
        return new Function1<Task, Boolean>() { // from class: com.taptap.sdk.startup.StartUp.validate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Task element) {
                Class<? extends InitializeTask> clazz = element != null ? element.getClazz() : null;
                Task task = taskNode.getTask();
                return Boolean.valueOf(Intrinsics.areEqual(clazz, task != null ? task.getClazz() : null));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void execute(Task $this$execute, Context context, TapTapSdkOptions options) throws Exception {
        TimeSource.Monotonic $this$measureTimedValue$iv$iv = TimeSource.Monotonic.INSTANCE;
        long mark$iv$iv = $this$measureTimedValue$iv$iv.m1992markNowz9LOYto();
        $this$execute.getAction().invoke(context, options);
        Object result$iv$iv = Unit.INSTANCE;
        TimedValue timedValue = new TimedValue(result$iv$iv, TimeSource.Monotonic.ValueTimeMark.m1995elapsedNowUwyO8pc(mark$iv$iv), null);
        timedValue.component1();
        Unit unit = Unit.INSTANCE;
        long duration = timedValue.getDuration();
        Log.d("TapStartUp", "task: " + $this$execute.getName() + ", thread: " + Thread.currentThread().getName() + ", cost: " + ((Object) Duration.m1904toStringimpl(duration)));
    }

    private final Graph<TaskNode> buildGraph(List<Task> tasks) {
        Iterable $this$fold$iv;
        Graph.Builder builder;
        List<Task> $this$fold$iv2 = tasks;
        Graph.Builder builder2 = new Graph.Builder();
        Graph.Builder builder3 = builder2;
        for (Object element$iv : $this$fold$iv2) {
            Task task = (Task) element$iv;
            Graph.Builder acc = builder3;
            if (!task.getDependsOn().isEmpty()) {
                Iterable $this$forEach$iv = task.getDependsOn();
                int $i$f$forEach = 0;
                for (Object element$iv2 : $this$forEach$iv) {
                    String dependsOn = (String) element$iv2;
                    acc.putEdge(new TaskNode.Real(task), new TaskNode.Real(findTask(dependsOn)));
                    $this$fold$iv2 = $this$fold$iv2;
                    $i$f$forEach = $i$f$forEach;
                    builder2 = builder2;
                }
                $this$fold$iv = $this$fold$iv2;
                builder = builder2;
            } else {
                $this$fold$iv = $this$fold$iv2;
                builder = builder2;
                acc.putEdge(new TaskNode.Real(task), new TaskNode.Virtual(null, 1, null));
            }
            builder3 = acc;
            $this$fold$iv2 = $this$fold$iv;
            builder2 = builder;
        }
        Graph.Builder builder4 = builder3;
        return builder4.build();
    }

    /* JADX INFO: compiled from: StartUp.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/startup/StartUp$Builder;", "", d.R, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext$tap_core_release", "()Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "getOptions$tap_core_release", "()Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "setOptions$tap_core_release", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "tasks", "", "Lcom/taptap/sdk/startup/task/Task;", "getTasks$tap_core_release", "()Ljava/util/List;", "setTasks$tap_core_release", "(Ljava/util/List;)V", "build", "Lcom/taptap/sdk/startup/StartUp;", "setOptions", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private final Context context;
        private TapTapSdkOptions options;
        private List<Task> tasks;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.tasks = CollectionsKt.emptyList();
        }

        /* JADX INFO: renamed from: getContext$tap_core_release, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        public final List<Task> getTasks$tap_core_release() {
            return this.tasks;
        }

        public final void setTasks$tap_core_release(List<Task> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.tasks = list;
        }

        /* JADX INFO: renamed from: getOptions$tap_core_release, reason: from getter */
        public final TapTapSdkOptions getOptions() {
            return this.options;
        }

        public final void setOptions$tap_core_release(TapTapSdkOptions tapTapSdkOptions) {
            this.options = tapTapSdkOptions;
        }

        public final Builder setOptions(TapTapSdkOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            Builder $this$setOptions_u24lambda_u240 = this;
            $this$setOptions_u24lambda_u240.options = options;
            return this;
        }

        public final StartUp build() {
            return new StartUp(this, null);
        }
    }
}

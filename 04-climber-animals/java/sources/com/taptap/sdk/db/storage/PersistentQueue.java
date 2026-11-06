package com.taptap.sdk.db.storage;

import android.util.Log;
import com.taptap.sdk.db.processor.EventProcessor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PersistentQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 %*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001b\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u001a\u001a\u00020\u0015J\u001f\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020! \"*\n\u0012\u0004\u0012\u00020!\u0018\u00010 0 H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\f\u0010#\u001a\u00020$*\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/taptap/sdk/db/storage/PersistentQueue;", "T", "", "config", "Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "(Lcom/taptap/sdk/db/processor/EventProcessor$Config;)V", "mappedBuffer", "Ljava/nio/MappedByteBuffer;", "getMappedBuffer", "()Ljava/nio/MappedByteBuffer;", "mappedBuffer$delegate", "Lkotlin/Lazy;", "queue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "createMappedBufferFromFile", "file", "Ljava/io/File;", "enqueue", "item", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQueueSize", "", "load", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peek", "n", "removeAll", "", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "", "kotlin.jvm.PlatformType", "readContentFromMappedBuffer", "", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PersistentQueue<T> {
    private static final String TAG = "PersistentQueue";
    private final EventProcessor.Config config;

    /* JADX INFO: renamed from: mappedBuffer$delegate, reason: from kotlin metadata */
    private final Lazy mappedBuffer;
    private final ConcurrentLinkedDeque<T> queue;

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$enqueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue", f = "PersistentQueue.kt", i = {0}, l = {48}, m = "enqueue", n = {"removed"}, s = {"L$0"})
    static final class C08131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PersistentQueue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08131(PersistentQueue<T> persistentQueue, Continuation<? super C08131> continuation) {
            super(continuation);
            this.this$0 = persistentQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.enqueue(null, this);
        }
    }

    public PersistentQueue(EventProcessor.Config config) throws InterruptedException {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.queue = new ConcurrentLinkedDeque<>();
        this.mappedBuffer = LazyKt.lazy(new Function0<MappedByteBuffer>(this) { // from class: com.taptap.sdk.db.storage.PersistentQueue$mappedBuffer$2
            final /* synthetic */ PersistentQueue<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final MappedByteBuffer invoke() {
                return this.this$0.createMappedBufferFromFile(new File(((PersistentQueue) this.this$0).config.getContext().getFilesDir(), ((PersistentQueue) this.this$0).config.getFileName()));
            }
        });
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(this, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MappedByteBuffer getMappedBuffer() {
        return (MappedByteBuffer) this.mappedBuffer.getValue();
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue$1", f = "PersistentQueue.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;
        final /* synthetic */ PersistentQueue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PersistentQueue<T> persistentQueue, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = persistentQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.this$0.load(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            CollectionsKt.addAll(((PersistentQueue) this.this$0).queue, list);
            return Boxing.boxInt(Log.d(PersistentQueue.TAG, "load pending events: " + list));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object enqueue(T t, Continuation<? super T> continuation) {
        C08131 c08131;
        if (continuation instanceof C08131) {
            c08131 = (C08131) continuation;
            if ((c08131.label & Integer.MIN_VALUE) != 0) {
                c08131.label -= Integer.MIN_VALUE;
            } else {
                c08131 = new C08131(this, continuation);
            }
        } else {
            c08131 = new C08131(this, continuation);
        }
        Object obj = c08131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08131.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = c08131.L$0;
            ResultKt.throwOnFailure(obj);
            return obj2;
        }
        ResultKt.throwOnFailure(obj);
        T tPoll = getQueueSize() >= this.config.getEventQueueCapacity() ? this.queue.poll() : null;
        this.queue.add(t);
        c08131.L$0 = tPoll;
        c08131.label = 1;
        return save(c08131) == coroutine_suspended ? coroutine_suspended : tPoll;
    }

    public final List<T> peek(int n) {
        if (!(n >= 0)) {
            throw new IllegalArgumentException("n must be > 0".toString());
        }
        if (n == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.queue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
        for (int i = 0; it.hasNext() && i < n; i++) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public final int getQueueSize() {
        return this.queue.size();
    }

    public final Object removeAll(List<? extends T> list, Continuation<? super Unit> continuation) {
        this.queue.removeAll(list);
        Object objSave = save(continuation);
        return objSave == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSave : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue$load$2", f = "PersistentQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends T>>, Object> {
        int label;
        final /* synthetic */ PersistentQueue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PersistentQueue<T> persistentQueue, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = persistentQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends T>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                PersistentQueue<T> persistentQueue = this.this$0;
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(persistentQueue.readContentFromMappedBuffer(persistentQueue.getMappedBuffer())));
                try {
                    Object object = objectInputStream.readObject();
                    List listEmptyList = object instanceof List ? (List) object : null;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    CloseableKt.closeFinally(objectInputStream, null);
                    return listEmptyList;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(objectInputStream, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                Log.d(PersistentQueue.TAG, "load error: " + e.getMessage(), e);
                return CollectionsKt.emptyList();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object load(Continuation<? super List<? extends T>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, null), continuation);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$save$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue$save$2", f = "PersistentQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Comparable<?>>, Object> {
        int label;
        final /* synthetic */ PersistentQueue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08142(PersistentQueue<T> persistentQueue, Continuation<? super C08142> continuation) {
            super(2, continuation);
            this.this$0 = persistentQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08142(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Comparable<?>> continuation) {
            return ((C08142) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Integer numBoxInt;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PersistentQueue<T> persistentQueue = this.this$0;
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream2);
                    try {
                        objectOutputStream.writeObject(CollectionsKt.toList(((PersistentQueue) persistentQueue).queue));
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        if (byteArray.length < persistentQueue.getMappedBuffer().capacity()) {
                            persistentQueue.getMappedBuffer().clear();
                            numBoxInt = persistentQueue.getMappedBuffer().put(byteArray);
                        } else {
                            numBoxInt = Boxing.boxInt(Log.i(PersistentQueue.TAG, "not enough space for save, capacity = " + persistentQueue.getMappedBuffer().capacity() + ", byteArray = " + byteArray.length));
                        }
                        CloseableKt.closeFinally(objectOutputStream, null);
                        CloseableKt.closeFinally(byteArrayOutputStream, null);
                        return numBoxInt;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(objectOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(byteArrayOutputStream, th3);
                        throw th4;
                    }
                }
            } catch (Exception e) {
                return Boxing.boxInt(Log.e(PersistentQueue.TAG, "保存数据失败", e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object save(Continuation<? super Comparable<?>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C08142(this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MappedByteBuffer createMappedBufferFromFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, this.config.getMaxSize());
            CloseableKt.closeFinally(randomAccessFile, null);
            Intrinsics.checkNotNullExpressionValue(map, "RandomAccessFile(file, \"…          )\n            }");
            return map;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(randomAccessFile, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] readContentFromMappedBuffer(MappedByteBuffer mappedByteBuffer) {
        byte[] bArr = new byte[mappedByteBuffer.remaining()];
        mappedByteBuffer.get(bArr);
        return bArr;
    }
}

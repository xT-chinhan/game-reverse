package com.taptap.sdk.db.storage;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.data.model.Event;
import com.taptap.sdk.db.processor.EventProcessor;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: PersistentQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\u0019\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001c\u0010\u001e\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0086@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0017J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/taptap/sdk/db/storage/PersistentQueue;", "", "config", "Lcom/taptap/sdk/db/processor/EventProcessor$Config;", "(Lcom/taptap/sdk/db/processor/EventProcessor$Config;)V", "fileLock", "Lkotlinx/coroutines/sync/Mutex;", "persistentFile", "Ljava/io/File;", "queue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/taptap/sdk/db/data/model/Event;", "clearFile", "", "enqueue", "item", "(Lcom/taptap/sdk/db/data/model/Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQueueSize", "", "isNotEmpty", "", "load", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peek", "n", "readFromFile", "", "size", "", "removeAll", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "validateEvents", "result", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PersistentQueue {
    private static final String TAG = "PersistentQueue";
    private final EventProcessor.Config config;
    private final Mutex fileLock;
    private final File persistentFile;
    private final ConcurrentLinkedDeque<Event> queue;

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$enqueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue", f = "PersistentQueue.kt", i = {0}, l = {62}, m = "enqueue", n = {"removed"}, s = {"L$0"})
    static final class C03411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03411(Continuation<? super C03411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PersistentQueue.this.enqueue(null, this);
        }
    }

    public PersistentQueue(EventProcessor.Config config) throws InterruptedException {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.queue = new ConcurrentLinkedDeque<>();
        this.persistentFile = new File(config.getContext().getFilesDir(), config.getFileName());
        this.fileLock = MutexKt.Mutex$default(false, 1, null);
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue$1", f = "PersistentQueue.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PersistentQueue.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    anonymousClass1.label = 1;
                    Object objLoad = PersistentQueue.this.load(anonymousClass1);
                    if (objLoad == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objLoad;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List persistEvents = (List) $result;
            CollectionsKt.addAll(PersistentQueue.this.queue, persistEvents);
            return Boxing.boxInt(Log.d(PersistentQueue.TAG, "加载了 " + persistEvents.size() + " 个持久化事件"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object enqueue(Event item, Continuation<? super Event> continuation) {
        C03411 c03411;
        if (continuation instanceof C03411) {
            c03411 = (C03411) continuation;
            if ((c03411.label & Integer.MIN_VALUE) != 0) {
                c03411.label -= Integer.MIN_VALUE;
            } else {
                c03411 = new C03411(continuation);
            }
        } else {
            c03411 = new C03411(continuation);
        }
        C03411 c03412 = c03411;
        Object $result = c03412.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03412.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Event removed = null;
                if (getQueueSize() >= this.config.getEventQueueCapacity()) {
                    removed = this.queue.poll();
                }
                this.queue.add(item);
                c03412.L$0 = removed;
                c03412.label = 1;
                if (save(c03412) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return removed;
            case 1:
                Event removed2 = (Event) c03412.L$0;
                ResultKt.throwOnFailure($result);
                return removed2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final List<Event> peek(int n) {
        if (!(n >= 0)) {
            throw new IllegalArgumentException("n must be > 0".toString());
        }
        if (n == 0) {
            return CollectionsKt.emptyList();
        }
        List result = new ArrayList();
        Iterator<Event> it = this.queue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
        for (int count = 0; it.hasNext() && count < n; count++) {
            result.add(it.next());
        }
        return result;
    }

    public final int getQueueSize() {
        return this.queue.size();
    }

    public final boolean isNotEmpty() {
        return !this.queue.isEmpty();
    }

    public final Object removeAll(List<Event> list, Continuation<? super Unit> continuation) throws Throwable {
        this.queue.removeAll(list);
        Object objSave = save(continuation);
        return objSave == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSave : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/taptap/sdk/db/data/model/Event;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue$load$2", f = "PersistentQueue.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Event>>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PersistentQueue.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Event>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Event>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Event>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Mutex $this$withLock_u24default$iv;
            PersistentQueue persistentQueue;
            Object owner$iv;
            List listEmptyList;
            List listEmptyList2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$withLock_u24default$iv = PersistentQueue.this.fileLock;
                    persistentQueue = PersistentQueue.this;
                    owner$iv = null;
                    this.L$0 = $this$withLock_u24default$iv;
                    this.L$1 = persistentQueue;
                    this.label = 1;
                    if ($this$withLock_u24default$iv.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    persistentQueue = (PersistentQueue) this.L$1;
                    $this$withLock_u24default$iv = (Mutex) this.L$0;
                    ResultKt.throwOnFailure($result);
                    owner$iv = null;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                if (persistentQueue.persistentFile.exists()) {
                    long fileSize = persistentQueue.persistentFile.length();
                    if (fileSize <= 0) {
                        Log.d(PersistentQueue.TAG, "文件为空");
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else if (fileSize > persistentQueue.config.getMaxSize()) {
                        Log.e(PersistentQueue.TAG, "文件大小异常: " + fileSize + " > " + persistentQueue.config.getMaxSize() + "，清空文件");
                        persistentQueue.clearFile();
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        try {
                            byte[] byteArray = persistentQueue.readFromFile(fileSize);
                            Log.d(PersistentQueue.TAG, "读取数据: " + fileSize + " 字节（文件实际大小）");
                            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArray));
                            try {
                                ObjectInputStream objectInputStream2 = objectInputStream;
                                listEmptyList = persistentQueue.validateEvents(objectInputStream2.readObject());
                                CloseableKt.closeFinally(objectInputStream, null);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(objectInputStream, th);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            error = th3;
                            try {
                                Log.e(PersistentQueue.TAG, "加载失败，清空文件: " + error.getMessage(), error);
                                persistentQueue.clearFile();
                                listEmptyList = CollectionsKt.emptyList();
                            } finally {
                                $this$withLock_u24default$iv.unlock(owner$iv);
                            }
                        }
                        return listEmptyList;
                    }
                } else {
                    Log.d(PersistentQueue.TAG, "文件不存在，返回空列表");
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                $this$withLock_u24default$iv.unlock(owner$iv);
                return listEmptyList2;
            } catch (Throwable th4) {
                error = th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object load(Continuation<? super List<Event>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: com.taptap.sdk.db.storage.PersistentQueue$save$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PersistentQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.db.storage.PersistentQueue$save$2", f = "PersistentQueue.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C03422 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C03422(Continuation<? super C03422> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PersistentQueue.this.new C03422(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03422) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Mutex $this$withLock_u24default$iv;
            PersistentQueue persistentQueue;
            Object owner$iv;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$withLock_u24default$iv = PersistentQueue.this.fileLock;
                    persistentQueue = PersistentQueue.this;
                    owner$iv = null;
                    this.L$0 = $this$withLock_u24default$iv;
                    this.L$1 = persistentQueue;
                    this.label = 1;
                    if ($this$withLock_u24default$iv.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    persistentQueue = (PersistentQueue) this.L$1;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ByteArrayOutputStream bos = byteArrayOutputStream;
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
                        try {
                            ObjectOutputStream os = objectOutputStream;
                            os.writeObject(CollectionsKt.toList(persistentQueue.queue));
                            byte[] byteArray = bos.toByteArray();
                            CloseableKt.closeFinally(objectOutputStream, null);
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            long dataSize = byteArray.length;
                            if (dataSize > persistentQueue.config.getMaxSize()) {
                                Log.e(PersistentQueue.TAG, "数据过大: " + dataSize + " > " + persistentQueue.config.getMaxSize());
                            } else {
                                RandomAccessFile randomAccessFile = new RandomAccessFile(persistentQueue.persistentFile, "rw");
                                try {
                                    RandomAccessFile randomFile = randomAccessFile;
                                    randomFile.setLength(dataSize);
                                    MappedByteBuffer buffer = randomFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, dataSize);
                                    buffer.put(byteArray);
                                    CloseableKt.closeFinally(randomAccessFile, null);
                                    Log.d(PersistentQueue.TAG, "保存成功: " + persistentQueue.queue.size() + " 个事件, 文件大小: " + dataSize + " 字节");
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        CloseableKt.closeFinally(randomAccessFile, th);
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(objectOutputStream, th3);
                                throw th4;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            throw th5;
                        } catch (Throwable th6) {
                            CloseableKt.closeFinally(byteArrayOutputStream, th5);
                            throw th6;
                        }
                    }
                } catch (Throwable e) {
                    Log.e(PersistentQueue.TAG, "保存失败", e);
                }
                Unit unit = Unit.INSTANCE;
                $this$withLock_u24default$iv.unlock(owner$iv);
                return Unit.INSTANCE;
            } catch (Throwable th7) {
                $this$withLock_u24default$iv.unlock(owner$iv);
                throw th7;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object save(Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C03422(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] readFromFile(long size) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.persistentFile, "r");
        try {
            RandomAccessFile randomFile = randomAccessFile;
            MappedByteBuffer buffer = randomFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, size);
            byte[] data = new byte[(int) size];
            buffer.get(data);
            CloseableKt.closeFinally(randomAccessFile, null);
            return data;
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
    public final void clearFile() {
        try {
            Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.persistentFile), Charsets.UTF_8);
            BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
            try {
                BufferedWriter writer = bufferedWriter;
                writer.write("");
                writer.flush();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedWriter, null);
                Log.i(TAG, "已清空文件");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedWriter, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "清空文件失败", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Event> validateEvents(Object result) {
        Class<?> cls;
        Class<?> cls2;
        String name = null;
        if (!(result instanceof List)) {
            StringBuilder sbAppend = new StringBuilder().append("数据类型错误：期望 List<Event>，实际是 ");
            if (result != null && (cls2 = result.getClass()) != null) {
                name = cls2.getName();
            }
            throw new IllegalStateException(sbAppend.append(name).toString());
        }
        List $this$indexOfFirst$iv = (List) result;
        int index$iv = 0;
        Iterator it = $this$indexOfFirst$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                if (!(item$iv instanceof Event)) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int index = index$iv;
        if (index != -1) {
            StringBuilder sbAppend2 = new StringBuilder().append("List[").append(index).append("] 元素类型错误：期望 Event，实际是 ");
            Object obj = ((List) result).get(index);
            if (obj != null && (cls = obj.getClass()) != null) {
                name = cls.getName();
            }
            throw new IllegalStateException(sbAppend2.append(name).toString());
        }
        return (List) result;
    }
}

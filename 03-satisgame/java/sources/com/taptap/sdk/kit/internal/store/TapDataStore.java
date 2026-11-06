package com.taptap.sdk.kit.internal.store;

import android.content.Context;
import com.anythink.core.common.l.f;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.store.ITapData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapDataStore.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \"*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\"B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0017\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0006\u0010\u001d\u001a\u00020\tJ\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\b\u0002\u0010 \u001a\u00020\tH\u0007J\b\u0010!\u001a\u00020\u001aH\u0003R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/taptap/sdk/kit/internal/store/TapDataStore;", "T", "Lcom/taptap/sdk/kit/internal/store/ITapData;", "", "context", "Landroid/content/Context;", "storeFileName", "", "maxAccumulatedData", "", "mapSize", "", "(Landroid/content/Context;Ljava/lang/String;IJ)V", "accumulatedData", "Ljava/util/concurrent/CopyOnWriteArrayList;", "inFlightData", "getMapSize", "()J", "mappedByteBuffer", "Ljava/nio/MappedByteBuffer;", "getMaxAccumulatedData", "()I", "addData", f.R, "(Lcom/taptap/sdk/kit/internal/store/ITapData;)Lcom/taptap/sdk/kit/internal/store/ITapData;", "clearInFlightAndStats", "", "moveToAccumulated", "", "getAccumulatedDataCount", "obtainData", "", "maxCount", "syncData", "Companion", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapDataStore<T extends ITapData<T>> {
    private static final String TAG = "TapDataStore";
    private CopyOnWriteArrayList<T> accumulatedData;
    private final CopyOnWriteArrayList<T> inFlightData;
    private final long mapSize;
    private MappedByteBuffer mappedByteBuffer;
    private final int maxAccumulatedData;

    public TapDataStore(Context context, String storeFileName, int i, long j) throws IOException {
        MappedByteBuffer map;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storeFileName, "storeFileName");
        this.maxAccumulatedData = i;
        this.mapSize = j;
        this.accumulatedData = new CopyOnWriteArrayList<>();
        this.inFlightData = new CopyOnWriteArrayList<>();
        TapLogger.logd(TAG, "initialize start");
        File file = new File(context.getFilesDir(), storeFileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        if (channel != null) {
            try {
                map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            } catch (Exception e) {
                TapLogger.logd(TAG, e);
                map = null;
            }
        } else {
            map = null;
        }
        if (map == null) {
            TapLogger.loge$default(TAG, "initialize failure MappedByteBuffer = null", null, 4, null);
        } else {
            List listEmptyList = CollectionsKt.emptyList();
            try {
                byte[] bArr = new byte[map.remaining()];
                map.get(bArr);
                Object object = new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
                List list = object instanceof List ? (List) object : null;
                listEmptyList = list == null ? CollectionsKt.emptyList() : list;
            } catch (Exception e2) {
                TapLogger.logd(TAG, "If this is the first time you start, you can ignore this error message.", e2);
            }
            this.accumulatedData.addAll(CollectionsKt.distinct(listEmptyList));
            this.mappedByteBuffer = map;
        }
        TapLogger.logd(TAG, "initialize end accumulatedData.size = " + this.accumulatedData.size());
    }

    public final int getMaxAccumulatedData() {
        return this.maxAccumulatedData;
    }

    public final long getMapSize() {
        return this.mapSize;
    }

    public final int getAccumulatedDataCount() {
        return this.accumulatedData.size();
    }

    public final T addData(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        T t = this.accumulatedData.size() + this.inFlightData.size() >= this.maxAccumulatedData ? (T) CollectionsKt.removeFirst(this.accumulatedData) : null;
        this.accumulatedData.add(data);
        syncData();
        return t;
    }

    public static /* synthetic */ List obtainData$default(TapDataStore tapDataStore, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 200;
        }
        return tapDataStore.obtainData(i);
    }

    public final List<T> obtainData(int maxCount) {
        if (this.accumulatedData.size() > maxCount) {
            List<T> listSubList = this.accumulatedData.subList(0, maxCount);
            Intrinsics.checkNotNullExpressionValue(listSubList, "accumulatedData.subList(0, maxCount)");
            List<T> list = listSubList;
            this.inFlightData.addAll(list);
            this.accumulatedData.removeAll(list);
        } else {
            this.inFlightData.addAll(this.accumulatedData);
            this.accumulatedData.clear();
        }
        syncData();
        return this.inFlightData;
    }

    public final void clearInFlightAndStats(boolean moveToAccumulated) {
        if (moveToAccumulated) {
            this.accumulatedData.addAll(this.inFlightData);
            List listDistinct = CollectionsKt.distinct(this.accumulatedData);
            this.accumulatedData.clear();
            this.accumulatedData.addAll(listDistinct);
            CopyOnWriteArrayList<T> copyOnWriteArrayList = this.accumulatedData;
            final AnonymousClass1 anonymousClass1 = new Function2<T, T, Integer>() { // from class: com.taptap.sdk.kit.internal.store.TapDataStore.clearInFlightAndStats.1
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(T t, T p1) {
                    Intrinsics.checkNotNullExpressionValue(p1, "p1");
                    return Integer.valueOf(t.compareTo(p1));
                }
            };
            CollectionsKt.sortWith(copyOnWriteArrayList, new Comparator() { // from class: com.taptap.sdk.kit.internal.store.TapDataStore$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return TapDataStore.clearInFlightAndStats$lambda$0(anonymousClass1, obj, obj2);
                }
            });
        }
        this.inFlightData.clear();
        syncData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int clearInFlightAndStats$lambda$0(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final synchronized void syncData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(CollectionsKt.toList(this.accumulatedData));
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int length = byteArray.length;
                MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
                if (length < (mappedByteBuffer != null ? mappedByteBuffer.capacity() : 0)) {
                    MappedByteBuffer mappedByteBuffer2 = this.mappedByteBuffer;
                    if (mappedByteBuffer2 != null) {
                        mappedByteBuffer2.clear();
                    }
                    MappedByteBuffer mappedByteBuffer3 = this.mappedByteBuffer;
                    if (mappedByteBuffer3 != null) {
                        mappedByteBuffer3.put(byteArray);
                    }
                } else {
                    StringBuilder sb = new StringBuilder("syncData failure Not enough space， capacity = ");
                    MappedByteBuffer mappedByteBuffer4 = this.mappedByteBuffer;
                    TapLogger.logd(TAG, sb.append(mappedByteBuffer4 != null ? Integer.valueOf(mappedByteBuffer4.capacity()) : null).append(", byteArray = ").append(byteArray.length).toString());
                    Unit unit = Unit.INSTANCE;
                }
                CloseableKt.closeFinally(objectOutputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(objectOutputStream, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            TapLogger.logd(TAG, e);
        }
    }
}

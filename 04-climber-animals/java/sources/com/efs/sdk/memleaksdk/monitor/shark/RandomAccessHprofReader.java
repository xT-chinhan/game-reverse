package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bt, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J:\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u000e0\u0013¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;", "Ljava/io/Closeable;", "source", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;)V", "buffer", "Lcom/efs/sdk/memleaksdk/monitor/io/Buffer;", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", ILivePush.ClickType.CLOSE, "", "readRecord", "T", "recordPosition", "", "recordSize", "withRecordReader", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(JJLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class RandomAccessHprofReader implements Closeable {
    public static final a a = new a(0);
    private final l b;
    private final HprofRecordReader c;
    private final RandomAccessSource d;

    private RandomAccessHprofReader(RandomAccessSource randomAccessSource, HprofHeader hprofHeader) {
        this.d = randomAccessSource;
        l lVar = new l();
        this.b = lVar;
        this.c = new HprofRecordReader(hprofHeader, lVar);
    }

    public /* synthetic */ RandomAccessHprofReader(RandomAccessSource randomAccessSource, HprofHeader hprofHeader, byte b) {
        this(randomAccessSource, hprofHeader);
    }

    public final <T> T a(long j, long j2, Function1<? super HprofRecordReader, ? extends T> withRecordReader) throws IOException {
        long j3 = j2;
        Intrinsics.checkNotNullParameter(withRecordReader, "withRecordReader");
        if (!(j3 > 0)) {
            throw new IllegalArgumentException(("recordSize " + j3 + " must be > 0").toString());
        }
        long j4 = j;
        while (j3 > 0) {
            long jA = this.d.a(this.b, j4, j3);
            if (!(jA > 0)) {
                throw new IllegalStateException(("Requested " + j3 + " bytes after reading " + (j4 - j) + ", got 0 bytes instead.").toString());
            }
            j4 += jA;
            j3 -= jA;
        }
        T tInvoke = withRecordReader.invoke(this.c);
        if (this.b.a() == 0) {
            return tInvoke;
        }
        throw new IllegalStateException(("Buffer not fully consumed: " + this.b.a() + " bytes left").toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bt$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader$Companion;", "", "()V", "openReaderFor", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;", "hprofSourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSourceProvider;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "hprofFile", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final RandomAccessHprofReader a(RandomAccessSourceProvider hprofSourceProvider, HprofHeader hprofHeader) {
            Intrinsics.checkNotNullParameter(hprofSourceProvider, "hprofSourceProvider");
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            return new RandomAccessHprofReader(hprofSourceProvider.b(), hprofHeader, (byte) 0);
        }
    }
}

package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bz, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingHprofReader;", "", "sourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingSourceProvider;", "header", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingSourceProvider;Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;)V", "readRecords", "", "recordTags", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "listener", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class StreamingHprofReader {
    public static final a a = new a(0);
    private final StreamingSourceProvider b;
    private final HprofHeader c;

    private StreamingHprofReader(StreamingSourceProvider streamingSourceProvider, HprofHeader hprofHeader) {
        this.b = streamingSourceProvider;
        this.c = hprofHeader;
    }

    public /* synthetic */ StreamingHprofReader(StreamingSourceProvider streamingSourceProvider, HprofHeader hprofHeader, byte b) {
        this(streamingSourceProvider, hprofHeader);
    }

    public final long a(Set<? extends HprofRecordTag> recordTags, OnHprofRecordTagListener listener) {
        n nVar;
        Intrinsics.checkNotNullParameter(recordTags, "recordTags");
        Intrinsics.checkNotNullParameter(listener, "listener");
        n nVarA = this.b.a();
        try {
            n nVar2 = nVarA;
            HprofRecordReader hprofRecordReader = new HprofRecordReader(this.c, nVar2);
            hprofRecordReader.a(this.c.a);
            int i = PrimitiveType.INT.j;
            int i2 = hprofRecordReader.b[2];
            while (!nVar2.b()) {
                int iE = hprofRecordReader.E();
                hprofRecordReader.a(i);
                long jD = hprofRecordReader.D();
                if (iE == HprofRecordTag.STRING_IN_UTF8.K) {
                    if (recordTags.contains(HprofRecordTag.STRING_IN_UTF8)) {
                        listener.a(HprofRecordTag.STRING_IN_UTF8, jD, hprofRecordReader);
                    } else {
                        hprofRecordReader.a(jD);
                    }
                } else if (iE == HprofRecordTag.LOAD_CLASS.K) {
                    if (recordTags.contains(HprofRecordTag.LOAD_CLASS)) {
                        listener.a(HprofRecordTag.LOAD_CLASS, jD, hprofRecordReader);
                    } else {
                        hprofRecordReader.a(jD);
                    }
                } else if (iE == HprofRecordTag.STACK_FRAME.K) {
                    if (recordTags.contains(HprofRecordTag.STACK_FRAME)) {
                        listener.a(HprofRecordTag.STACK_FRAME, jD, hprofRecordReader);
                    } else {
                        hprofRecordReader.a(jD);
                    }
                } else {
                    if (iE == HprofRecordTag.STACK_TRACE.K) {
                        if (recordTags.contains(HprofRecordTag.STACK_TRACE)) {
                            listener.a(HprofRecordTag.STACK_TRACE, jD, hprofRecordReader);
                        } else {
                            hprofRecordReader.a(jD);
                        }
                    } else if (iE == HprofRecordTag.HEAP_DUMP.K || iE == HprofRecordTag.HEAP_DUMP_SEGMENT.K) {
                        nVar = nVar2;
                        long j = hprofRecordReader.a;
                        long j2 = 0;
                        int i3 = 0;
                        while (hprofRecordReader.a - j < jD) {
                            long j3 = hprofRecordReader.a;
                            int iE2 = hprofRecordReader.E();
                            long j4 = j;
                            if (iE2 == HprofRecordTag.ROOT_UNKNOWN.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_UNKNOWN)) {
                                    listener.a(HprofRecordTag.ROOT_UNKNOWN, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_JNI_GLOBAL.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_JNI_GLOBAL)) {
                                    listener.a(HprofRecordTag.ROOT_JNI_GLOBAL, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2 + i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_JNI_LOCAL.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_JNI_LOCAL)) {
                                    listener.a(HprofRecordTag.ROOT_JNI_LOCAL, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2 + i + i);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_JAVA_FRAME.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_JAVA_FRAME)) {
                                    listener.a(HprofRecordTag.ROOT_JAVA_FRAME, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2 + i + i);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_NATIVE_STACK.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_NATIVE_STACK)) {
                                    listener.a(HprofRecordTag.ROOT_NATIVE_STACK, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2 + i);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_STICKY_CLASS.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_STICKY_CLASS)) {
                                    listener.a(HprofRecordTag.ROOT_STICKY_CLASS, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_THREAD_BLOCK.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_THREAD_BLOCK)) {
                                    listener.a(HprofRecordTag.ROOT_THREAD_BLOCK, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2 + i);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_MONITOR_USED.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_MONITOR_USED)) {
                                    listener.a(HprofRecordTag.ROOT_MONITOR_USED, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_THREAD_OBJECT.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_THREAD_OBJECT)) {
                                    listener.a(HprofRecordTag.ROOT_THREAD_OBJECT, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2 + i + i);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_INTERNED_STRING.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_INTERNED_STRING)) {
                                    listener.a(HprofRecordTag.ROOT_INTERNED_STRING, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_FINALIZING.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_FINALIZING)) {
                                    listener.a(HprofRecordTag.ROOT_FINALIZING, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_DEBUGGER.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_DEBUGGER)) {
                                    listener.a(HprofRecordTag.ROOT_DEBUGGER, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_REFERENCE_CLEANUP.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_REFERENCE_CLEANUP)) {
                                    listener.a(HprofRecordTag.ROOT_REFERENCE_CLEANUP, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_VM_INTERNAL.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_VM_INTERNAL)) {
                                    listener.a(HprofRecordTag.ROOT_VM_INTERNAL, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_JNI_MONITOR.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_JNI_MONITOR)) {
                                    listener.a(HprofRecordTag.ROOT_JNI_MONITOR, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2 + i + i);
                                }
                            } else if (iE2 == HprofRecordTag.ROOT_UNREACHABLE.K) {
                                if (recordTags.contains(HprofRecordTag.ROOT_UNREACHABLE)) {
                                    listener.a(HprofRecordTag.ROOT_UNREACHABLE, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.a(i2);
                                }
                            } else if (iE2 == HprofRecordTag.CLASS_DUMP.K) {
                                if (recordTags.contains(HprofRecordTag.CLASS_DUMP)) {
                                    listener.a(HprofRecordTag.CLASS_DUMP, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.z();
                                }
                            } else if (iE2 == HprofRecordTag.INSTANCE_DUMP.K) {
                                if (recordTags.contains(HprofRecordTag.INSTANCE_DUMP)) {
                                    listener.a(HprofRecordTag.INSTANCE_DUMP, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.y();
                                }
                            } else if (iE2 == HprofRecordTag.OBJECT_ARRAY_DUMP.K) {
                                if (recordTags.contains(HprofRecordTag.OBJECT_ARRAY_DUMP)) {
                                    listener.a(HprofRecordTag.OBJECT_ARRAY_DUMP, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.A();
                                }
                            } else if (iE2 == HprofRecordTag.PRIMITIVE_ARRAY_DUMP.K) {
                                if (recordTags.contains(HprofRecordTag.PRIMITIVE_ARRAY_DUMP)) {
                                    listener.a(HprofRecordTag.PRIMITIVE_ARRAY_DUMP, -1L, hprofRecordReader);
                                } else {
                                    hprofRecordReader.B();
                                }
                            } else {
                                if (iE2 == HprofRecordTag.PRIMITIVE_ARRAY_NODATA.K) {
                                    throw new UnsupportedOperationException(HprofRecordTag.PRIMITIVE_ARRAY_NODATA + " cannot be parsed");
                                }
                                if (iE2 == HprofRecordTag.HEAP_DUMP_INFO.K) {
                                    if (recordTags.contains(HprofRecordTag.HEAP_DUMP_INFO)) {
                                        listener.a(HprofRecordTag.HEAP_DUMP_INFO, -1L, hprofRecordReader);
                                    } else {
                                        hprofRecordReader.C();
                                    }
                                } else {
                                    StringBuilder sbAppend = new StringBuilder().append("Unknown tag ");
                                    String str = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(iE2)}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
                                    StringBuilder sbAppend2 = sbAppend.append(str).append(" at ").append(j3).append(" after ");
                                    String str2 = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(this, *args)");
                                    throw new IllegalStateException(sbAppend2.append(str2).append(" at ").append(j2).toString());
                                }
                            }
                            j2 = j3;
                            i3 = iE2;
                            j = j4;
                        }
                    } else {
                        nVar = nVar2;
                        if (iE == HprofRecordTag.HEAP_DUMP_END.K) {
                            if (recordTags.contains(HprofRecordTag.HEAP_DUMP_END)) {
                                listener.a(HprofRecordTag.HEAP_DUMP_END, jD, hprofRecordReader);
                            }
                        } else {
                            hprofRecordReader.a(jD);
                        }
                    }
                    nVar2 = nVar;
                }
                nVar = nVar2;
                nVar2 = nVar;
            }
            long j5 = hprofRecordReader.a;
            CloseableKt.closeFinally(nVarA, null);
            return j5;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(nVarA, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bz$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingHprofReader$Companion;", "", "()V", "readerFor", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingHprofReader;", "hprofSourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingSourceProvider;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "hprofFile", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final StreamingHprofReader a(StreamingSourceProvider hprofSourceProvider, HprofHeader hprofHeader) {
            Intrinsics.checkNotNullParameter(hprofSourceProvider, "hprofSourceProvider");
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            return new StreamingHprofReader(hprofSourceProvider, hprofHeader, (byte) 0);
        }
    }
}

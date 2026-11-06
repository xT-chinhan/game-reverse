package com.bytedance.pangle.x;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.pangle.util.FieldUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
class sl implements hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final long f726ms = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final long ah;
    private final long d;
    private final FileDescriptor xr;

    sl(FileDescriptor fileDescriptor, long j, long j2) {
        this.xr = fileDescriptor;
        this.ah = j;
        this.d = j2;
    }

    @Override // com.bytedance.pangle.x.hi
    public long ms() {
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.x.hi
    public void ms(ch chVar, long j, int i) throws Throwable {
        long j2;
        long jMmap;
        int iIntValue;
        ByteBuffer byteBuffer;
        long j3 = this.ah + j;
        long j4 = f726ms;
        long j5 = (j3 / j4) * j4;
        int i2 = (int) (j3 - j5);
        long j6 = i + i2;
        try {
            ByteBuffer byteBuffer2 = null;
            if (com.bytedance.pangle.util.ny.hi()) {
                try {
                    iIntValue = ((Integer) FieldUtils.readField(OsConstants.class.getField("MAP_POPULATE"), (Object) null)).intValue();
                } catch (IllegalAccessException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    iIntValue = 0;
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e2);
                    iIntValue = 0;
                }
            } else {
                iIntValue = 0;
            }
            jMmap = Os.mmap(0L, j6, OsConstants.PROT_READ, OsConstants.MAP_SHARED | iIntValue, this.xr, j5);
            try {
                try {
                    if (com.bytedance.pangle.util.ny.zb()) {
                        try {
                            Class<?> cls = Class.forName("java.nio.DirectByteBuffer");
                            Class<?>[] clsArr = {Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE};
                            Constructor<?> constructor = cls.getConstructor(clsArr);
                            if (constructor == null) {
                                constructor = cls.getDeclaredConstructor(clsArr);
                            }
                            if (constructor != null) {
                                constructor.setAccessible(true);
                                byteBuffer = (ByteBuffer) constructor.newInstance(Integer.valueOf(i), Long.valueOf(((long) i2) + jMmap), this.xr, null, Boolean.TRUE);
                                byteBuffer2 = byteBuffer;
                            }
                        } catch (ClassNotFoundException e3) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e3);
                        } catch (IllegalAccessException e4) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e4);
                        } catch (InstantiationException e5) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e5);
                        } catch (InvocationTargetException e6) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e6);
                        } catch (Exception e7) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e7);
                        }
                    } else {
                        try {
                            Constructor<?> declaredConstructor = Class.forName("java.nio.DirectByteBuffer").getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            if (declaredConstructor != null) {
                                declaredConstructor.setAccessible(true);
                                byteBuffer = (ByteBuffer) declaredConstructor.newInstance(Long.valueOf(((long) i2) + jMmap), Integer.valueOf(i));
                                byteBuffer2 = byteBuffer;
                            }
                        } catch (ClassNotFoundException e8) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e8);
                        } catch (IllegalAccessException e9) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e9);
                        } catch (InstantiationException e10) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e10);
                        } catch (InvocationTargetException e11) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e11);
                        } catch (Exception e12) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e12);
                        }
                    }
                    chVar.ms(byteBuffer2);
                    if (jMmap != 0) {
                        try {
                            Os.munmap(jMmap, j6);
                        } catch (ErrnoException unused) {
                        }
                    }
                } catch (ErrnoException e13) {
                    e = e13;
                    throw new IOException("Failed to mmap " + j6 + " bytes", e);
                }
            } catch (Throwable th) {
                th = th;
                j2 = 0;
                if (jMmap != j2) {
                    try {
                        Os.munmap(jMmap, j6);
                    } catch (ErrnoException unused2) {
                    }
                }
                throw th;
            }
        } catch (ErrnoException e14) {
            e = e14;
            jMmap = 0;
        } catch (Throwable th2) {
            th = th2;
            j2 = 0;
            jMmap = 0;
            if (jMmap != j2) {
                Os.munmap(jMmap, j6);
            }
            throw th;
        }
    }
}

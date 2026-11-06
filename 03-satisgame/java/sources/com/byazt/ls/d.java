package com.byazt.ls;

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
@com.byazt.cp.n(n = {0, 1, 32, 113})
public class d implements cp {
    public static final long n = Os.sysconf(OsConstants._SC_PAGESIZE);
    public final long q;
    public final FileDescriptor qg;
    public final long s;

    public d(FileDescriptor fileDescriptor, long j, long j2) {
        this.qg = fileDescriptor;
        this.s = j;
        this.q = j2;
    }

    @Override // com.byazt.ls.cp
    public long n() {
        return this.q;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.byazt.ls.cp
    public void n(tj tjVar, long j, int i) throws Throwable {
        long j2;
        long jMmap;
        int iIntValue;
        ByteBuffer byteBuffer;
        long j3 = this.s + j;
        long j4 = n;
        long j5 = (j3 / j4) * j4;
        int i2 = (int) (j3 - j5);
        long j6 = i + i2;
        try {
            ByteBuffer byteBuffer2 = null;
            if (com.byazt.gx.rv.tj()) {
                try {
                    iIntValue = ((Integer) FieldUtils.readField(OsConstants.class.getField("MAP_POPULATE"), (Object) null)).intValue();
                } catch (IllegalAccessException e) {
                    com.byazt.vx.w.n(e);
                    iIntValue = 0;
                } catch (Exception e2) {
                    com.byazt.vx.w.n(e2);
                    iIntValue = 0;
                }
            } else {
                iIntValue = 0;
            }
            jMmap = Os.mmap(0L, j6, OsConstants.PROT_READ, OsConstants.MAP_SHARED | iIntValue, this.qg, j5);
            try {
                try {
                    if (com.byazt.gx.rv.d()) {
                        try {
                            Class<?> cls = Class.forName("java.nio.DirectByteBuffer");
                            Class<?>[] clsArr = {Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE};
                            Constructor<?> constructor = cls.getConstructor(clsArr);
                            if (constructor == null) {
                                constructor = cls.getDeclaredConstructor(clsArr);
                            }
                            if (constructor != null) {
                                constructor.setAccessible(true);
                                byteBuffer = (ByteBuffer) constructor.newInstance(Integer.valueOf(i), Long.valueOf(((long) i2) + jMmap), this.qg, null, Boolean.TRUE);
                                byteBuffer2 = byteBuffer;
                            }
                        } catch (ClassNotFoundException e3) {
                            com.byazt.vx.w.n(e3);
                        } catch (IllegalAccessException e4) {
                            com.byazt.vx.w.n(e4);
                        } catch (InstantiationException e5) {
                            com.byazt.vx.w.n(e5);
                        } catch (InvocationTargetException e6) {
                            com.byazt.vx.w.n(e6);
                        } catch (Exception e7) {
                            com.byazt.vx.w.n(e7);
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
                            com.byazt.vx.w.n(e8);
                        } catch (IllegalAccessException e9) {
                            com.byazt.vx.w.n(e9);
                        } catch (InstantiationException e10) {
                            com.byazt.vx.w.n(e10);
                        } catch (InvocationTargetException e11) {
                            com.byazt.vx.w.n(e11);
                        } catch (Exception e12) {
                            com.byazt.vx.w.n(e12);
                        }
                    }
                    tjVar.n(byteBuffer2);
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

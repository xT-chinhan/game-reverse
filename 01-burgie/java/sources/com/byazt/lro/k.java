package com.byazt.lro;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.util.FieldUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 250})
public class k implements w {
    public static final long pr = Os.sysconf(OsConstants._SC_PAGESIZE);
    public final long hn;
    public final FileDescriptor hw;
    public final long x;

    public k(FileDescriptor fileDescriptor, long j, long j2) {
        this.hw = fileDescriptor;
        this.hn = j;
        this.x = j2;
    }

    @Override // com.byazt.lro.w
    public long pr() {
        return this.x;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0078 A[Catch: Exception -> 0x00a3, InvocationTargetException -> 0x00a8, InstantiationException -> 0x00ad, IllegalAccessException -> 0x00b2, ClassNotFoundException -> 0x00b7, ErrnoException -> 0x0116, all -> 0x013b, TryCatch #2 {ErrnoException -> 0x0116, blocks: (B:14:0x004a, B:17:0x0054, B:19:0x0078, B:21:0x007e, B:50:0x0104, B:35:0x00bc, B:37:0x00d0, B:25:0x00a4, B:27:0x00a9, B:29:0x00ae, B:31:0x00b3, B:33:0x00b8, B:41:0x00ec, B:43:0x00f1, B:45:0x00f6, B:47:0x00fb, B:49:0x0100), top: B:75:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:21:0x007e A[Catch: Exception -> 0x00a3, InvocationTargetException -> 0x00a8, InstantiationException -> 0x00ad, IllegalAccessException -> 0x00b2, ClassNotFoundException -> 0x00b7, ErrnoException -> 0x0116, all -> 0x013b, TRY_LEAVE, TryCatch #2 {ErrnoException -> 0x0116, blocks: (B:14:0x004a, B:17:0x0054, B:19:0x0078, B:21:0x007e, B:50:0x0104, B:35:0x00bc, B:37:0x00d0, B:25:0x00a4, B:27:0x00a9, B:29:0x00ae, B:31:0x00b3, B:33:0x00b8, B:41:0x00ec, B:43:0x00f1, B:45:0x00f6, B:47:0x00fb, B:49:0x0100), top: B:75:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0 A[Catch: Exception -> 0x00eb, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00f5, IllegalAccessException -> 0x00fa, ClassNotFoundException -> 0x00ff, ErrnoException -> 0x0116, all -> 0x013b, TRY_LEAVE, TryCatch #2 {ErrnoException -> 0x0116, blocks: (B:14:0x004a, B:17:0x0054, B:19:0x0078, B:21:0x007e, B:50:0x0104, B:35:0x00bc, B:37:0x00d0, B:25:0x00a4, B:27:0x00a9, B:29:0x00ae, B:31:0x00b3, B:33:0x00b8, B:41:0x00ec, B:43:0x00f1, B:45:0x00f6, B:47:0x00fb, B:49:0x0100), top: B:75:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0115 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x0149  */
    /* JADX WARN: Code duplicated, block: B:77:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.byazt.lro.w
    public void pr(vk vkVar, long j, int i) throws Throwable {
        Throwable th;
        long jMmap;
        int iIntValue;
        Class<?> cls;
        Class<?>[] clsArr;
        Constructor<?> constructor;
        Constructor<?> declaredConstructor;
        long j2 = this.hn + j;
        long j3 = pr;
        long j4 = (j2 / j3) * j3;
        int i2 = (int) (j2 - j4);
        long j5 = i + i2;
        try {
            ByteBuffer byteBuffer = null;
            if (com.byazt.gs.aj.vk()) {
                try {
                    iIntValue = ((Integer) FieldUtils.readField(OsConstants.class.getField("MAP_POPULATE"), (Object) null)).intValue();
                } catch (IllegalAccessException e) {
                    com.byazt.dea.uc.pr(e);
                    iIntValue = 0;
                } catch (Exception e2) {
                    com.byazt.dea.uc.pr(e2);
                    iIntValue = 0;
                }
                jMmap = Os.mmap(0L, j5, OsConstants.PROT_READ, OsConstants.MAP_SHARED | iIntValue, this.hw, j4);
                try {
                    try {
                        if (com.byazt.gs.aj.k()) {
                            try {
                                cls = Class.forName("java.nio.DirectByteBuffer");
                                clsArr = new Class[]{Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE};
                                constructor = cls.getConstructor(clsArr);
                                if (constructor == null) {
                                    constructor = cls.getDeclaredConstructor(clsArr);
                                }
                                if (constructor != null) {
                                    constructor.setAccessible(true);
                                    byteBuffer = (ByteBuffer) constructor.newInstance(Integer.valueOf(i), Long.valueOf(((long) i2) + jMmap), this.hw, null, Boolean.TRUE);
                                }
                            } catch (ClassNotFoundException e3) {
                                com.byazt.dea.uc.pr(e3);
                            } catch (IllegalAccessException e4) {
                                com.byazt.dea.uc.pr(e4);
                            } catch (InstantiationException e5) {
                                com.byazt.dea.uc.pr(e5);
                            } catch (InvocationTargetException e6) {
                                com.byazt.dea.uc.pr(e6);
                            } catch (Exception e7) {
                                com.byazt.dea.uc.pr(e7);
                            }
                        } else {
                            try {
                                declaredConstructor = Class.forName("java.nio.DirectByteBuffer").getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                                if (declaredConstructor != null) {
                                    declaredConstructor.setAccessible(true);
                                    byteBuffer = (ByteBuffer) declaredConstructor.newInstance(Long.valueOf(((long) i2) + jMmap), Integer.valueOf(i));
                                }
                            } catch (ClassNotFoundException e8) {
                                com.byazt.dea.uc.pr(e8);
                            } catch (IllegalAccessException e9) {
                                com.byazt.dea.uc.pr(e9);
                            } catch (InstantiationException e10) {
                                com.byazt.dea.uc.pr(e10);
                            } catch (InvocationTargetException e11) {
                                com.byazt.dea.uc.pr(e11);
                            } catch (Exception e12) {
                                com.byazt.dea.uc.pr(e12);
                            }
                        }
                        vkVar.pr(byteBuffer);
                        if (jMmap != 0) {
                            try {
                                Os.munmap(jMmap, j5);
                                return;
                            } catch (ErrnoException e13) {
                                return;
                            }
                        }
                        return;
                    } catch (ErrnoException e14) {
                        e = e14;
                        throw new IOException("Failed to mmap " + j5 + " bytes", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jMmap != 0) {
                        throw th;
                    }
                    try {
                        Os.munmap(jMmap, j5);
                        throw th;
                    } catch (ErrnoException e15) {
                        throw th;
                    }
                }
            }
            iIntValue = 0;
            jMmap = Os.mmap(0L, j5, OsConstants.PROT_READ, OsConstants.MAP_SHARED | iIntValue, this.hw, j4);
            if (com.byazt.gs.aj.k()) {
                cls = Class.forName("java.nio.DirectByteBuffer");
                clsArr = new Class[]{Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE};
                constructor = cls.getConstructor(clsArr);
                if (constructor == null) {
                    constructor = cls.getDeclaredConstructor(clsArr);
                }
                if (constructor != null) {
                    constructor.setAccessible(true);
                    byteBuffer = (ByteBuffer) constructor.newInstance(Integer.valueOf(i), Long.valueOf(((long) i2) + jMmap), this.hw, null, Boolean.TRUE);
                }
            } else {
                declaredConstructor = Class.forName("java.nio.DirectByteBuffer").getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                if (declaredConstructor != null) {
                    declaredConstructor.setAccessible(true);
                    byteBuffer = (ByteBuffer) declaredConstructor.newInstance(Long.valueOf(((long) i2) + jMmap), Integer.valueOf(i));
                }
            }
            vkVar.pr(byteBuffer);
            if (jMmap != 0) {
                Os.munmap(jMmap, j5);
                return;
            }
            return;
        } catch (ErrnoException e16) {
            e = e16;
            jMmap = 0;
        } catch (Throwable th3) {
            th = th3;
            jMmap = 0;
            if (jMmap != 0) {
                throw th;
            }
            Os.munmap(jMmap, j5);
            throw th;
        }
        throw new IOException("Failed to mmap " + j5 + " bytes", e);
    }
}

package com.bytedance.pangle.util.xr;

import com.bytedance.pangle.util.ab;
import com.bytedance.pangle.util.ny;
import com.bytedance.pangle.util.xr.xr.ah;
import com.bytedance.pangle.util.xr.xr.d;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final d f703ms;
    private final com.bytedance.pangle.util.xr.ms.xr xr = new com.bytedance.pangle.util.xr.ms.xr();

    public ms(d dVar) {
        this.f703ms = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0115 A[Catch: all -> 0x013a, TryCatch #4 {all -> 0x013a, blocks: (B:24:0x00c8, B:26:0x012a, B:25:0x0115), top: B:61:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0178  */
    /* JADX WARN: Code duplicated, block: B:50:0x017d  */
    public void ms(boolean z, boolean z2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        File file2;
        File file3 = new File(this.f703ms.ah().getAbsolutePath() + ".rm_tmp");
        if (file3.exists()) {
            file3.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file3, "rw");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.f703ms.ah(), t.k);
                try {
                    List<ah> listMs = this.f703ms.ms().ms();
                    HashSet hashSet = new HashSet();
                    Iterator<ah> it = listMs.iterator();
                    int iAh = 0;
                    while (it.hasNext()) {
                        ah next = it.next();
                        if (ms(next, z, z2)) {
                            hashSet.add(next.sl());
                        } else {
                            long jZb = next.zb();
                            if ("resources.arsc".equals(next.sl())) {
                                long filePointer = randomAccessFile.getFilePointer() + next.d();
                                long jC = filePointer % 4096 == 0 ? 0L : 4096 - ((filePointer - ((long) next.c())) % 4096);
                                if (jC != 0) {
                                    int iC = next.c();
                                    int i = (int) jC;
                                    next.xr(i);
                                    file2 = file3;
                                    try {
                                        ms(randomAccessFile3, randomAccessFile, jZb, next.ka(), next.sl());
                                        this.f703ms.d().ms(randomAccessFile, i);
                                        ms(randomAccessFile3, randomAccessFile, jZb + next.ka() + 2, next.ch(), next.sl());
                                        randomAccessFile.write(new byte[i]);
                                        ms(randomAccessFile3, randomAccessFile, jZb + next.ka() + 2 + ((long) next.ch()) + ((long) iC), next.xr(), next.sl());
                                    } catch (Throwable th) {
                                        th = th;
                                        randomAccessFile2 = randomAccessFile3;
                                        file = file2;
                                        if (randomAccessFile2 != null) {
                                            randomAccessFile2.close();
                                        }
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                        ms(file);
                                        throw th;
                                    }
                                } else {
                                    file2 = file3;
                                    ms(randomAccessFile3, randomAccessFile, jZb, next.ah(), next.sl());
                                }
                            } else {
                                file2 = file3;
                                ms(randomAccessFile3, randomAccessFile, jZb, next.ah(), next.sl());
                            }
                            long j = iAh;
                            next.d(j);
                            iAh = (int) (j + next.ah());
                            it = it;
                            file3 = file2;
                        }
                    }
                    File file4 = file3;
                    try {
                        this.f703ms.ms().ms(hashSet);
                        this.xr.ms(this.f703ms, randomAccessFile);
                        file = file4;
                        try {
                            ms(this.f703ms.ah(), file);
                            randomAccessFile3.close();
                            randomAccessFile.close();
                            ms(file);
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            ms(file);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        file = file4;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    file = file3;
                }
            } catch (Throwable th5) {
                th = th5;
                file = file3;
            }
        } catch (Throwable th6) {
            th = th6;
            file = file3;
            randomAccessFile = null;
        }
    }

    private boolean ms(ah ahVar, boolean z, boolean z2) {
        if (z) {
            if (ny.c() && ahVar.sl().equals("classes.dex")) {
                return false;
            }
            if (ahVar.sl().startsWith("classes") && ahVar.sl().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && ahVar.sl().startsWith("lib/") && ahVar.sl().endsWith(".so");
    }

    void ms(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    void ms(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        ab.ms(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void ms(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}

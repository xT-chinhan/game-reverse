package com.byazt.jh;

import com.anythink.china.a.c;
import com.byazt.gx.rv;
import com.byazt.gx.x;
import com.byazt.vg.q;
import com.byazt.vg.s;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 585, 19})
public class n {
    public final q n;
    public final com.byazt.kq.qg qg = new com.byazt.kq.qg();

    public n(q qVar) {
        this.n = qVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0115 A[Catch: all -> 0x013a, TryCatch #4 {all -> 0x013a, blocks: (B:24:0x00c8, B:26:0x012a, B:25:0x0115), top: B:61:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0178  */
    /* JADX WARN: Code duplicated, block: B:50:0x017d  */
    public void n(boolean z, boolean z2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        File file2;
        File file3 = new File(this.n.s().getAbsolutePath() + ".rm_tmp");
        if (file3.exists()) {
            file3.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file3, "rw");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.n.s(), "r");
                try {
                    List<s> listN = this.n.n().n();
                    HashSet hashSet = new HashSet();
                    Iterator<s> it = listN.iterator();
                    int iS = 0;
                    while (it.hasNext()) {
                        s next = it.next();
                        if (n(next, z, z2)) {
                            hashSet.add(next.d());
                        } else {
                            long jOa = next.oa();
                            if ("resources.arsc".equals(next.d())) {
                                long filePointer = randomAccessFile.getFilePointer() + next.q();
                                long jW = filePointer % c.m == 0 ? 0L : c.m - ((filePointer - ((long) next.w())) % c.m);
                                if (jW != 0) {
                                    int iW = next.w();
                                    int i = (int) jW;
                                    next.qg(i);
                                    file2 = file3;
                                    try {
                                        n(randomAccessFile3, randomAccessFile, jOa, next.l(), next.d());
                                        this.n.q().n(randomAccessFile, i);
                                        n(randomAccessFile3, randomAccessFile, jOa + next.l() + 2, next.tj(), next.d());
                                        randomAccessFile.write(new byte[i]);
                                        n(randomAccessFile3, randomAccessFile, jOa + next.l() + 2 + ((long) next.tj()) + ((long) iW), next.qg(), next.d());
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
                                        n(file);
                                        throw th;
                                    }
                                } else {
                                    file2 = file3;
                                    n(randomAccessFile3, randomAccessFile, jOa, next.s(), next.d());
                                }
                            } else {
                                file2 = file3;
                                n(randomAccessFile3, randomAccessFile, jOa, next.s(), next.d());
                            }
                            long j = iS;
                            next.q(j);
                            iS = (int) (j + next.s());
                            it = it;
                            file3 = file2;
                        }
                    }
                    File file4 = file3;
                    try {
                        this.n.n().n(hashSet);
                        this.qg.n(this.n, randomAccessFile);
                        file = file4;
                        try {
                            n(this.n.s(), file);
                            randomAccessFile3.close();
                            randomAccessFile.close();
                            n(file);
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            n(file);
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

    private boolean n(s sVar, boolean z, boolean z2) {
        if (z) {
            if (rv.l() && sVar.d().equals("classes.dex")) {
                return false;
            }
            if (sVar.d().startsWith("classes") && sVar.d().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && sVar.d().startsWith("lib/") && sVar.d().endsWith(".so");
    }

    public void n(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public void n(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        x.n(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void n(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}

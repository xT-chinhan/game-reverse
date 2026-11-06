package com.byazt.au;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.gs.aj;
import com.byazt.gs.fw;
import com.byazt.jl.hn;
import com.byazt.jl.x;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 479, 37})
public class pr {
    public final com.byazt.rm.hw hw = new com.byazt.rm.hw();
    public final x pr;

    public pr(x xVar) {
        this.pr = xVar;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0181  */
    /* JADX WARN: Code duplicated, block: B:52:0x0186  */
    public void pr(boolean z, boolean z2) throws Throwable {
        File file;
        RandomAccessFile randomAccessFile;
        long jUc;
        File file2 = new File(this.pr.hn().getAbsolutePath() + ".rm_tmp");
        if (file2.exists()) {
            file2.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.pr.hn(), "r");
                try {
                    List<hn> listPr = this.pr.pr().pr();
                    HashSet hashSet = new HashSet();
                    Iterator<hn> it = listPr.iterator();
                    int iHn = 0;
                    while (it.hasNext()) {
                        hn next = it.next();
                        if (pr(next, z, z2)) {
                            hashSet.add(next.k());
                        } else {
                            long jM = next.m();
                            if ("resources.arsc".equals(next.k())) {
                                long filePointer = randomAccessFile.getFilePointer() + next.x();
                                if (filePointer % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
                                    jUc = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM - ((filePointer - ((long) next.uc())) % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                                } else {
                                    jUc = 0;
                                }
                                if (jUc != 0) {
                                    int iUc = next.uc();
                                    int i = (int) jUc;
                                    next.hw(i);
                                    it = it;
                                    file2 = file2;
                                    try {
                                        pr(randomAccessFile3, randomAccessFile, jM, next.c(), next.k());
                                        this.pr.x().pr(randomAccessFile, i);
                                        pr(randomAccessFile3, randomAccessFile, jM + next.c() + 2, next.vk(), next.k());
                                        randomAccessFile.write(new byte[i]);
                                        pr(randomAccessFile3, randomAccessFile, jM + next.c() + 2 + ((long) next.vk()) + ((long) iUc), next.hw(), next.k());
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
                                        pr(file);
                                        throw th;
                                    }
                                }
                                long j = iHn;
                                next.x(j);
                                iHn = (int) (j + next.hn());
                                it = it;
                                file2 = file2;
                            }
                            pr(randomAccessFile3, randomAccessFile, jM, next.hn(), next.k());
                            long j2 = iHn;
                            next.x(j2);
                            iHn = (int) (j2 + next.hn());
                            it = it;
                            file2 = file2;
                        }
                    }
                    File file3 = file2;
                    try {
                        this.pr.pr().pr(hashSet);
                        this.hw.pr(this.pr, randomAccessFile);
                        file = file3;
                        try {
                            pr(this.pr.hn(), file);
                            randomAccessFile3.close();
                            randomAccessFile.close();
                            pr(file);
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile3;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            pr(file);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        file = file3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    file = file2;
                }
            } catch (Throwable th5) {
                th = th5;
                file = file2;
            }
        } catch (Throwable th6) {
            th = th6;
            file = file2;
            randomAccessFile = null;
        }
    }

    private boolean pr(hn hnVar, boolean z, boolean z2) {
        if (z) {
            if (aj.c() && hnVar.k().equals("classes.dex")) {
                return false;
            }
            if (hnVar.k().startsWith("classes") && hnVar.k().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && hnVar.k().startsWith("lib/") && hnVar.k().endsWith(".so");
    }

    public void pr(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    public void pr(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        fw.pr(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void pr(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}

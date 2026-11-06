package com.byazt.kq;

import com.anythink.china.a.c;
import com.byazt.vg.q;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1391, 19})
public class n {
    public q n(String str) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                if (randomAccessFile2.length() < 22) {
                    throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
                }
                q qVar = new q(str);
                n(randomAccessFile2, qVar);
                if (qVar.qg().n() != 0) {
                    qg(randomAccessFile2, qVar);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused) {
                    }
                    return qVar;
                }
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
                return qVar;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void n(RandomAccessFile randomAccessFile, q qVar) throws IOException {
        randomAccessFile.seek(s(randomAccessFile, qVar) + 4);
        com.byazt.vg.qg qgVar = new com.byazt.vg.qg();
        randomAccessFile.skipBytes(6);
        qgVar.n(qVar.q().qg(randomAccessFile));
        randomAccessFile.skipBytes(4);
        qgVar.n(qVar.q().n(randomAccessFile));
        qVar.n(qgVar);
    }

    private void qg(RandomAccessFile randomAccessFile, q qVar) throws IOException {
        com.byazt.vg.n nVar = new com.byazt.vg.n();
        ArrayList arrayList = new ArrayList();
        long jQg = qVar.qg().qg();
        long jN = qVar.qg().n();
        randomAccessFile.seek(jQg);
        for (int i = 0; i < jN; i++) {
            com.byazt.vg.s sVar = new com.byazt.vg.s();
            if (qVar.q().n(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            sVar.n(qVar.q().qg(randomAccessFile));
            randomAccessFile.skipBytes(4);
            sVar.n(qVar.q().n(randomAccessFile));
            sVar.qg(qVar.q().n(randomAccessFile));
            sVar.s(qVar.q().n(randomAccessFile));
            int iQg = qVar.q().qg(randomAccessFile);
            sVar.s(iQg);
            sVar.q(qVar.q().qg(randomAccessFile));
            int iQg2 = qVar.q().qg(randomAccessFile);
            randomAccessFile.skipBytes(8);
            sVar.q(qVar.q().n(randomAccessFile));
            if (iQg > 0) {
                byte[] bArr = new byte[iQg];
                randomAccessFile.readFully(bArr);
                sVar.n(n(bArr));
                randomAccessFile.skipBytes(sVar.cp());
                if (iQg2 > 0) {
                    randomAccessFile.skipBytes(iQg2);
                }
                long filePointer = randomAccessFile.getFilePointer();
                randomAccessFile.seek(sVar.oa() + 28);
                sVar.qg(qVar.q().qg(randomAccessFile));
                randomAccessFile.seek(filePointer);
                arrayList.add(sVar);
            } else {
                throw new IOException("Invalid entry name in file header");
            }
        }
        nVar.n(arrayList);
        qVar.n(nVar);
    }

    private long s(RandomAccessFile randomAccessFile, q qVar) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        return ((long) qVar.q().n(randomAccessFile)) == 101010256 ? j : q(randomAccessFile, qVar);
    }

    private long q(RandomAccessFile randomAccessFile, q qVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = c.q;
        if (length2 < c.q) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (qVar.q().n(randomAccessFile) == 101010256) {
                return length;
            }
            length3--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private String n(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}

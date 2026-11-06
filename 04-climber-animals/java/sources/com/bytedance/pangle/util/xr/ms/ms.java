package com.bytedance.pangle.util.xr.ms;

import com.bytedance.pangle.util.xr.xr.d;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public d ms(String str) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.k);
            try {
                if (randomAccessFile2.length() < 22) {
                    throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
                }
                d dVar = new d(str);
                ms(randomAccessFile2, dVar);
                if (dVar.xr().ms() != 0) {
                    xr(randomAccessFile2, dVar);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused) {
                    }
                    return dVar;
                }
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
                return dVar;
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

    private void ms(RandomAccessFile randomAccessFile, d dVar) throws IOException {
        randomAccessFile.seek(ah(randomAccessFile, dVar) + 4);
        com.bytedance.pangle.util.xr.xr.xr xrVar = new com.bytedance.pangle.util.xr.xr.xr();
        randomAccessFile.skipBytes(6);
        xrVar.ms(dVar.d().xr(randomAccessFile));
        randomAccessFile.skipBytes(4);
        xrVar.ms(dVar.d().ms(randomAccessFile));
        dVar.ms(xrVar);
    }

    private void xr(RandomAccessFile randomAccessFile, d dVar) throws IOException {
        com.bytedance.pangle.util.xr.xr.ms msVar = new com.bytedance.pangle.util.xr.xr.ms();
        ArrayList arrayList = new ArrayList();
        long jXr = dVar.xr().xr();
        long jMs = dVar.xr().ms();
        randomAccessFile.seek(jXr);
        for (int i = 0; i < jMs; i++) {
            com.bytedance.pangle.util.xr.xr.ah ahVar = new com.bytedance.pangle.util.xr.xr.ah();
            if (dVar.d().ms(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            ahVar.ms(dVar.d().xr(randomAccessFile));
            randomAccessFile.skipBytes(4);
            ahVar.ms(dVar.d().ms(randomAccessFile));
            ahVar.xr(dVar.d().ms(randomAccessFile));
            ahVar.ah(dVar.d().ms(randomAccessFile));
            int iXr = dVar.d().xr(randomAccessFile);
            ahVar.ah(iXr);
            ahVar.d(dVar.d().xr(randomAccessFile));
            int iXr2 = dVar.d().xr(randomAccessFile);
            randomAccessFile.skipBytes(8);
            ahVar.d(dVar.d().ms(randomAccessFile));
            if (iXr > 0) {
                byte[] bArr = new byte[iXr];
                randomAccessFile.readFully(bArr);
                ahVar.ms(ms(bArr));
                randomAccessFile.skipBytes(ahVar.hi());
                if (iXr2 > 0) {
                    randomAccessFile.skipBytes(iXr2);
                }
                long filePointer = randomAccessFile.getFilePointer();
                randomAccessFile.seek(ahVar.zb() + 28);
                ahVar.xr(dVar.d().xr(randomAccessFile));
                randomAccessFile.seek(filePointer);
                arrayList.add(ahVar);
            } else {
                throw new IOException("Invalid entry name in file header");
            }
        }
        msVar.ms(arrayList);
        dVar.ms(msVar);
    }

    private long ah(RandomAccessFile randomAccessFile, d dVar) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        return ((long) dVar.d().ms(randomAccessFile)) == 101010256 ? j : d(randomAccessFile, dVar);
    }

    private long d(RandomAccessFile randomAccessFile, d dVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (dVar.d().ms(randomAccessFile) == 101010256) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private String ms(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}

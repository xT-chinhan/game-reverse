package com.byazt.kq;

import com.byazt.vg.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1391, 26})
public class qg {
    public void n(q qVar, RandomAccessFile randomAccessFile) throws Throwable {
        if (qVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long filePointer = randomAccessFile.getFilePointer();
                n(qVar, byteArrayOutputStream2);
                n(qVar, byteArrayOutputStream2.size(), (int) filePointer, byteArrayOutputStream2);
                randomAccessFile.write(byteArrayOutputStream2.toByteArray());
                byteArrayOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void n(q qVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (qVar.n() == null || qVar.n().n() == null || qVar.n().n().size() <= 0) {
            return;
        }
        Iterator<com.byazt.vg.s> it = qVar.n().n().iterator();
        while (it.hasNext()) {
            n(it.next(), byteArrayOutputStream, qVar.q());
        }
    }

    private void n(com.byazt.vg.s sVar, ByteArrayOutputStream byteArrayOutputStream, s sVar2) throws IOException {
        if (sVar == null) {
            throw new IOException("input parameters is null, cannot write local file header");
        }
        byte[] bArr = {0, 0};
        sVar2.n((OutputStream) byteArrayOutputStream, 33639248);
        sVar2.n(byteArrayOutputStream, 0);
        sVar2.n(byteArrayOutputStream, 0);
        sVar2.n(byteArrayOutputStream, 0);
        sVar2.n(byteArrayOutputStream, sVar.n());
        sVar2.n(byteArrayOutputStream, 2081);
        sVar2.n(byteArrayOutputStream, 545);
        sVar2.n((OutputStream) byteArrayOutputStream, (int) sVar.x());
        sVar2.n((OutputStream) byteArrayOutputStream, (int) sVar.fs());
        sVar2.n((OutputStream) byteArrayOutputStream, (int) sVar.rv());
        byte[] bArrN = new byte[0];
        if (sVar.d() != null && sVar.d().trim().length() > 0) {
            bArrN = n(sVar.d());
        }
        sVar2.n(byteArrayOutputStream, bArrN.length);
        int iCp = sVar.cp();
        sVar2.n(byteArrayOutputStream, iCp);
        sVar2.n(byteArrayOutputStream, 0);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        sVar2.n((OutputStream) byteArrayOutputStream, (int) sVar.oa());
        if (bArrN.length > 0) {
            byteArrayOutputStream.write(bArrN);
        }
        if (iCp > 0) {
            byteArrayOutputStream.write(new byte[iCp]);
        }
    }

    private void n(q qVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        qVar.q().n((OutputStream) byteArrayOutputStream, 101010256);
        qVar.q().n(byteArrayOutputStream, 0);
        qVar.q().n(byteArrayOutputStream, 0);
        int size = qVar.n().n().size();
        qVar.q().n(byteArrayOutputStream, size);
        qVar.q().n(byteArrayOutputStream, size);
        qVar.q().n((OutputStream) byteArrayOutputStream, i);
        qVar.q().n((OutputStream) byteArrayOutputStream, i2);
        qVar.q().n(byteArrayOutputStream, 0);
    }

    private byte[] n(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}

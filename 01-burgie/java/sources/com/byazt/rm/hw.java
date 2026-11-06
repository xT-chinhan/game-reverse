package com.byazt.rm;

import com.bumptech.glide.load.Key;
import com.byazt.jl.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2349, 13})
public class hw {
    public void pr(x xVar, RandomAccessFile randomAccessFile) throws Throwable {
        if (xVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long filePointer = randomAccessFile.getFilePointer();
                pr(xVar, byteArrayOutputStream2);
                pr(xVar, byteArrayOutputStream2.size(), (int) filePointer, byteArrayOutputStream2);
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

    private void pr(x xVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (xVar.pr() == null || xVar.pr().pr() == null || xVar.pr().pr().size() <= 0) {
            return;
        }
        Iterator<com.byazt.jl.hn> it = xVar.pr().pr().iterator();
        while (it.hasNext()) {
            pr(it.next(), byteArrayOutputStream, xVar.x());
        }
    }

    private void pr(com.byazt.jl.hn hnVar, ByteArrayOutputStream byteArrayOutputStream, hn hnVar2) throws IOException {
        if (hnVar == null) {
            throw new IOException("input parameters is null, cannot write local file header");
        }
        byte[] bArr = {0, 0};
        hnVar2.pr((OutputStream) byteArrayOutputStream, 33639248);
        hnVar2.pr(byteArrayOutputStream, 0);
        hnVar2.pr(byteArrayOutputStream, 0);
        hnVar2.pr(byteArrayOutputStream, 0);
        hnVar2.pr(byteArrayOutputStream, hnVar.pr());
        hnVar2.pr(byteArrayOutputStream, 2081);
        hnVar2.pr(byteArrayOutputStream, 545);
        hnVar2.pr((OutputStream) byteArrayOutputStream, (int) hnVar.fw());
        hnVar2.pr((OutputStream) byteArrayOutputStream, (int) hnVar.zo());
        hnVar2.pr((OutputStream) byteArrayOutputStream, (int) hnVar.aj());
        byte[] bArrPr = new byte[0];
        if (hnVar.k() != null && hnVar.k().trim().length() > 0) {
            bArrPr = pr(hnVar.k());
        }
        hnVar2.pr(byteArrayOutputStream, bArrPr.length);
        int iW = hnVar.w();
        hnVar2.pr(byteArrayOutputStream, iW);
        hnVar2.pr(byteArrayOutputStream, 0);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        hnVar2.pr((OutputStream) byteArrayOutputStream, (int) hnVar.m());
        if (bArrPr.length > 0) {
            byteArrayOutputStream.write(bArrPr);
        }
        if (iW > 0) {
            byteArrayOutputStream.write(new byte[iW]);
        }
    }

    private void pr(x xVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        xVar.x().pr((OutputStream) byteArrayOutputStream, 101010256);
        xVar.x().pr(byteArrayOutputStream, 0);
        xVar.x().pr(byteArrayOutputStream, 0);
        int size = xVar.pr().pr().size();
        xVar.x().pr(byteArrayOutputStream, size);
        xVar.x().pr(byteArrayOutputStream, size);
        xVar.x().pr((OutputStream) byteArrayOutputStream, i);
        xVar.x().pr((OutputStream) byteArrayOutputStream, i2);
        xVar.x().pr(byteArrayOutputStream, 0);
    }

    private byte[] pr(String str) {
        return str.getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
    }
}

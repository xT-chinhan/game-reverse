package com.bytedance.pangle.util.xr.ms;

import com.bytedance.pangle.util.xr.xr.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public void ms(d dVar, RandomAccessFile randomAccessFile) throws Throwable {
        if (dVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long filePointer = randomAccessFile.getFilePointer();
                ms(dVar, byteArrayOutputStream2);
                ms(dVar, byteArrayOutputStream2.size(), (int) filePointer, byteArrayOutputStream2);
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

    private void ms(d dVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (dVar.ms() == null || dVar.ms().ms() == null || dVar.ms().ms().size() <= 0) {
            return;
        }
        Iterator<com.bytedance.pangle.util.xr.xr.ah> it = dVar.ms().ms().iterator();
        while (it.hasNext()) {
            ms(it.next(), byteArrayOutputStream, dVar.d());
        }
    }

    private void ms(com.bytedance.pangle.util.xr.xr.ah ahVar, ByteArrayOutputStream byteArrayOutputStream, ah ahVar2) throws IOException {
        if (ahVar == null) {
            throw new IOException("input parameters is null, cannot write local file header");
        }
        byte[] bArr = {0, 0};
        ahVar2.ms((OutputStream) byteArrayOutputStream, 33639248);
        ahVar2.ms(byteArrayOutputStream, 0);
        ahVar2.ms(byteArrayOutputStream, 0);
        ahVar2.ms(byteArrayOutputStream, 0);
        ahVar2.ms(byteArrayOutputStream, ahVar.ms());
        ahVar2.ms(byteArrayOutputStream, 2081);
        ahVar2.ms(byteArrayOutputStream, 545);
        ahVar2.ms((OutputStream) byteArrayOutputStream, (int) ahVar.ab());
        ahVar2.ms((OutputStream) byteArrayOutputStream, (int) ahVar.x());
        ahVar2.ms((OutputStream) byteArrayOutputStream, (int) ahVar.ny());
        byte[] bArrMs = new byte[0];
        if (ahVar.sl() != null && ahVar.sl().trim().length() > 0) {
            bArrMs = ms(ahVar.sl());
        }
        ahVar2.ms(byteArrayOutputStream, bArrMs.length);
        int iHi = ahVar.hi();
        ahVar2.ms(byteArrayOutputStream, iHi);
        ahVar2.ms(byteArrayOutputStream, 0);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        ahVar2.ms((OutputStream) byteArrayOutputStream, (int) ahVar.zb());
        if (bArrMs.length > 0) {
            byteArrayOutputStream.write(bArrMs);
        }
        if (iHi > 0) {
            byteArrayOutputStream.write(new byte[iHi]);
        }
    }

    private void ms(d dVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        dVar.d().ms((OutputStream) byteArrayOutputStream, 101010256);
        dVar.d().ms(byteArrayOutputStream, 0);
        dVar.d().ms(byteArrayOutputStream, 0);
        int size = dVar.ms().ms().size();
        dVar.d().ms(byteArrayOutputStream, size);
        dVar.d().ms(byteArrayOutputStream, size);
        dVar.d().ms((OutputStream) byteArrayOutputStream, i);
        dVar.d().ms((OutputStream) byteArrayOutputStream, i2);
        dVar.d().ms(byteArrayOutputStream, 0);
    }

    private byte[] ms(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}

package com.byazt.km;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 5})
public class q {
    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static byte[] n(String str) {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                if (com.byazt.wv.n.fs()) {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes("UTF-8"));
                        gZIPOutputStream = gZIPOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        try {
                            cp.qg(th);
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            if (com.byazt.wv.n.fs()) {
                                return com.byakv.z.TTEncryptUtils.n(byteArray, byteArray.length);
                            }
                            return byteArray;
                        } catch (Throwable th2) {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e) {
                                    cp.qg(e);
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    byteArrayOutputStream.write(str.getBytes("UTF-8"));
                }
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
            } catch (IOException e2) {
                cp.qg(e2);
            }
        } catch (Throwable th3) {
            th = th3;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        if (com.byazt.wv.n.fs()) {
            return com.byakv.z.TTEncryptUtils.n(byteArray, byteArray.length);
        }
        return byteArray;
    }
}

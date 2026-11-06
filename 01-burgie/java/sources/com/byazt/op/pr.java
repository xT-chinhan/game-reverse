package com.byazt.op;

import com.byazt.cb.hw;
import com.byazt.sl.hn;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2367, 37})
public class pr {
    public static String pr(String str, String str2) {
        return str + File.separator + str2;
    }

    public static byte[] pr(hn hnVar) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        File fileC = hnVar.ny().c();
        String strHw = hnVar.hw();
        if (fileC == null || strHw == null) {
            return null;
        }
        File file = new File(fileC, strHw);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i != -1) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            hw.pr(fileInputStream);
                            hw.pr(byteArrayOutputStream);
                            return byteArray;
                        }
                    }
                } catch (OutOfMemoryError e) {
                    hw.pr(fileInputStream);
                    hw.pr(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    hw.pr(fileInputStream);
                    hw.pr(byteArrayOutputStream);
                    return null;
                }
            } catch (OutOfMemoryError e2) {
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
            }
        } catch (OutOfMemoryError e3) {
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
    }
}

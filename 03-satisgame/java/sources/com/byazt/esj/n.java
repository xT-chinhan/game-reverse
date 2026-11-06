package com.byazt.esj;

import com.byazt.gxb.s;
import com.byazt.wvr.qg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2536, 19})
public class n {
    public static String n(String str, String str2) {
        return str + File.separator + str2;
    }

    public static byte[] n(s sVar) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        File fileL = sVar.ou().l();
        String strQg = sVar.qg();
        if (fileL != null && strQg != null) {
            File file = new File(fileL, strQg);
            if (file.exists() && file.isFile()) {
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
                                    qg.n(fileInputStream);
                                    qg.n(byteArrayOutputStream);
                                    return byteArray;
                                }
                            }
                        } catch (Throwable unused) {
                            qg.n(fileInputStream);
                            qg.n(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable unused2) {
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable unused3) {
                    fileInputStream = null;
                    byteArrayOutputStream = null;
                }
            }
        }
        return null;
    }
}

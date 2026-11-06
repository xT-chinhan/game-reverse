package com.bytedance.sdk.openadsdk.core.jw;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class sl {
    public static byte[] ms(byte[] bArr) {
        byte[] byteArray = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr2 = new byte[4096];
            while (true) {
                int i = byteArrayInputStream.read(bArr2, 0, 4096);
                if (i > 0) {
                    gZIPOutputStream.write(bArr2, 0, i);
                } else {
                    gZIPOutputStream.close();
                    byteArrayInputStream.close();
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return byteArray;
        }
    }

    public static String xr(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                try {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.bytedance.sdk.component.utils.sl.d("gzip compress error.", th.getMessage());
                    try {
                    } catch (Throwable th3) {
                        return null;
                    }
                } finally {
                    try {
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Throwable th4) {
                        com.bytedance.sdk.component.utils.sl.ms(th4);
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = null;
        }
    }
}

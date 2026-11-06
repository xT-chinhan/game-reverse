package com.mcto.sspsdk.internal;

import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class d7 {
    public static final byte[] b = {59, 32};
    public static final byte[] c = {com.umeng.analytics.pro.cc.k, 10};
    public static final byte[] d = {45, 45};
    public static final byte[] e = {34};
    public static final byte[] f = "Content-Disposition: form-data; name=\"".getBytes();
    public static final byte[] g = "Content-Type: application/octet-stream".getBytes();
    public static final byte[] h = "filename=".getBytes();
    public int a = -1;

    public static void a(BufferedOutputStream bufferedOutputStream, byte[] bArr, HashMap map) throws IOException {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            if (str2 != null && str2.length() != 0) {
                bufferedOutputStream.write(d);
                bufferedOutputStream.write(bArr);
                byte[] bArr2 = c;
                bufferedOutputStream.write(bArr2);
                bufferedOutputStream.write(f);
                bufferedOutputStream.write(str.getBytes());
                bufferedOutputStream.write(e);
                bufferedOutputStream.write(bArr2);
                bufferedOutputStream.write(bArr2);
                bufferedOutputStream.write(str2.getBytes());
                bufferedOutputStream.write(bArr2);
                bufferedOutputStream.flush();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void a(BufferedOutputStream bufferedOutputStream, byte[] bArr, ArrayList arrayList) throws Throwable {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aa aaVar = (aa) it.next();
            File file = aaVar.b;
            if (file.exists() && file.length() > 0) {
                bufferedOutputStream.write(d);
                bufferedOutputStream.write(bArr);
                byte[] bArr2 = c;
                bufferedOutputStream.write(bArr2);
                bufferedOutputStream.write(f);
                bufferedOutputStream.write("files".getBytes());
                byte[] bArr3 = e;
                bufferedOutputStream.write(bArr3);
                bufferedOutputStream.write(b);
                bufferedOutputStream.write(h);
                bufferedOutputStream.write(bArr3);
                bufferedOutputStream.write(aaVar.a.getBytes());
                bufferedOutputStream.write(bArr3);
                bufferedOutputStream.write(bArr2);
                bufferedOutputStream.write(g);
                bufferedOutputStream.write(bArr2);
                bufferedOutputStream.write(bArr2);
                if (Build.VERSION.SDK_INT >= 19) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr4 = new byte[4096];
                            while (true) {
                                int i = fileInputStream.read(bArr4);
                                if (i == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr4, 0, i);
                                }
                                r9.a("ssp_sdk", "ssp_multi_post", e);
                            }
                            fileInputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        r9.a("ssp_sdk", "ssp_multi_post", e2);
                    }
                } else {
                    FileInputStream fileInputStream2 = null;
                    try {
                        FileInputStream fileInputStream3 = new FileInputStream(file);
                        try {
                            byte[] bArr5 = new byte[4096];
                            while (true) {
                                int i2 = fileInputStream3.read(bArr5);
                                if (i2 == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr5, 0, i2);
                                }
                            }
                            fileInputStream3.close();
                            try {
                                fileInputStream3.close();
                            } catch (IOException e3) {
                                e = e3;
                                r9.a("ssp_sdk", "ssp_multi_post", e);
                            }
                        } catch (Exception e4) {
                            e = e4;
                            fileInputStream2 = fileInputStream3;
                            try {
                                r9.a("ssp_sdk", "ssp_multi_post", e);
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e5) {
                                        e = e5;
                                        r9.a("ssp_sdk", "ssp_multi_post", e);
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e6) {
                                        r9.a("ssp_sdk", "ssp_multi_post", e6);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileInputStream2 = fileInputStream3;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                bufferedOutputStream.write(c);
                bufferedOutputStream.flush();
            }
        }
    }
}

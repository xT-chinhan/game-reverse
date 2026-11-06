package com.bytedance.sdk.component.c.ah.ms.ms;

import com.bytedance.sdk.component.utils.sl;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bytedance.sdk.component.c.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1177ms;
    private ms xr;

    public xr(File file, long j, ExecutorService executorService) {
        this.f1177ms = j;
        try {
            this.xr = ms.ms(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            sl.xr("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.c.ah
    public InputStream ms(String str) {
        ms msVar = this.xr;
        if (msVar == null) {
            return null;
        }
        try {
            ms.ah ahVarMs = msVar.ms(str);
            if (ahVarMs != null) {
                return ahVarMs.ms(0);
            }
        } catch (IOException e) {
            sl.xr("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.c.ms
    public boolean ms(String str, byte[] bArr) throws Throwable {
        ms msVar = this.xr;
        if (msVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable = null;
        ms.C0243ms c0243ms = null;
        try {
            try {
                ms.C0243ms c0243msXr = msVar.xr(str);
                try {
                    if (c0243msXr == null) {
                        sl.xr("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(null);
                        return false;
                    }
                    OutputStream outputStreamMs = c0243msXr.ms(0);
                    if (outputStreamMs == ms.ah) {
                        sl.xr("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(outputStreamMs);
                        return false;
                    }
                    outputStreamMs.write(bArr);
                    c0243msXr.ms();
                    this.xr.ms();
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(outputStreamMs);
                    return true;
                } catch (IOException e) {
                    e = e;
                    c0243ms = c0243msXr;
                    try {
                        sl.xr("LruCountDiskCache", e.toString());
                        if (c0243ms != null) {
                            try {
                                c0243ms.xr();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(0);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable = closeable;
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(closeable);
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            com.bytedance.sdk.component.c.ah.ah.xr.ms(closeable);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.c.ms
    /* JADX INFO: renamed from: xr, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] ms(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamMs;
        ms msVar = this.xr;
        InputStream inputStream = null;
        if (msVar == null || str == null) {
            return null;
        }
        try {
            ms.ah ahVarMs = msVar.ms(str);
            if (ahVarMs == null) {
                com.bytedance.sdk.component.c.ah.ah.xr.ms(null);
                com.bytedance.sdk.component.c.ah.ah.xr.ms(null);
                return null;
            }
            inputStreamMs = ahVarMs.ms(0);
            if (inputStreamMs != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStreamMs.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                        } catch (IOException e) {
                            e = e;
                            sl.xr("LruCountDiskCache", e.toString());
                            com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStreamMs);
                            com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamMs;
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                        com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    sl.xr("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStreamMs);
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    inputStream = inputStreamMs;
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStreamMs);
            com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStreamMs = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStream);
            com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
            throw th;
        }
        sl.xr("LruCountDiskCache", e.toString());
        com.bytedance.sdk.component.c.ah.ah.xr.ms(inputStreamMs);
        com.bytedance.sdk.component.c.ah.ah.xr.ms(byteArrayOutputStream);
        return null;
    }

    @Override // com.bytedance.sdk.component.c.ms
    /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
    public boolean xr(String str) {
        try {
            try {
                ms.ah ahVarMs = this.xr.ms(str);
                boolean z = ahVarMs != null;
                com.bytedance.sdk.component.c.ah.ah.xr.ms(ahVarMs);
                return z;
            } catch (IOException e) {
                sl.xr("LruCountDiskCache", e.getMessage());
                com.bytedance.sdk.component.c.ah.ah.xr.ms(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.c.ah.ah.xr.ms(null);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.c.ms
    public void ms(double d) {
        this.xr.ms((long) (this.f1177ms * d));
    }
}

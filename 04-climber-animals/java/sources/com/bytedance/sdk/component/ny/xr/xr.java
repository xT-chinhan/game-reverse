package com.bytedance.sdk.component.ny.xr;

import android.text.TextUtils;
import com.anythink.dlopt.common.a.a;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.c;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import com.efs.sdk.base.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public File f1297ms;
    public File xr;

    public xr(sl slVar) {
        super(slVar);
    }

    public void ms(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f1297ms = new File(str, str2);
        this.xr = new File(str, str2 + a.f);
    }

    public void ms(final com.bytedance.sdk.component.ny.ms.ms msVar) {
        File file = this.f1297ms;
        if (file == null || this.xr == null) {
            if (msVar != null) {
                msVar.ms(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.f1297ms.length() != 0 && msVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.ny.xr xrVar = new com.bytedance.sdk.component.ny.xr(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            xrVar.ms(this.f1297ms);
            msVar.ms(this, xrVar);
            return;
        }
        long length = this.xr.length();
        final long j = length >= 0 ? length : 0L;
        u.ms msVar2 = new u.ms();
        msVar2.ms((Object) xr());
        xr("Range", "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.c)) {
            msVar.ms(this, new IOException("Url is Empty"));
            return;
        }
        try {
            msVar2.ms(this.c);
            ms(msVar2);
            this.ah.ms(msVar2.ms().xr()).ms(new com.bytedance.sdk.component.xr.ms.ah() { // from class: com.bytedance.sdk.component.ny.xr.xr.1
                @Override // com.bytedance.sdk.component.xr.ms.ah
                public void onFailure(com.bytedance.sdk.component.xr.ms.xr xrVar2, IOException iOException) {
                    com.bytedance.sdk.component.ny.ms.ms msVar3 = msVar;
                    if (msVar3 != null) {
                        msVar3.ms(xr.this, iOException);
                    }
                    xr.this.ka();
                }

                @Override // com.bytedance.sdk.component.xr.ms.ah
                public void onResponse(com.bytedance.sdk.component.xr.ms.xr xrVar2, ao aoVar) throws IOException {
                    RandomAccessFile randomAccessFile;
                    long j2;
                    if (msVar == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    if (aoVar == null) {
                        return;
                    }
                    c cVarAb = aoVar.ab();
                    if (cVarAb != null) {
                        for (int i = 0; i < cVarAb.ms(); i++) {
                            map.put(cVarAb.ms(i), cVarAb.xr(i));
                        }
                    }
                    com.bytedance.sdk.component.ny.xr xrVar3 = new com.bytedance.sdk.component.ny.xr(aoVar.d(), aoVar.ah(), aoVar.ka(), map, null, aoVar.xr(), aoVar.ms());
                    if (aoVar.d()) {
                        long jMs = aoVar.c().ms();
                        if (jMs <= 0) {
                            jMs = xr.ab(map);
                        }
                        boolean zC = xr.c(map);
                        int i2 = -1;
                        if (zC) {
                            jMs += j;
                            String str = (String) map.get("Content-Range");
                            if (!TextUtils.isEmpty(str)) {
                                String str2 = "bytes " + j + "-" + (jMs - 1);
                                if (TextUtils.indexOf(str, str2) == -1) {
                                    xr.this.ka();
                                    msVar.ms(xr.this, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + xr.this.xr + "]."));
                                    return;
                                }
                            }
                        }
                        if (jMs > 0 && xr.this.xr.exists() && xr.this.xr.length() == jMs) {
                            if (xr.this.xr.renameTo(xr.this.f1297ms)) {
                                xrVar3.ms(xr.this.f1297ms);
                                msVar.ms(xr.this, xrVar3);
                                return;
                            } else {
                                msVar.ms(xr.this, new IOException("Rename fail"));
                                return;
                            }
                        }
                        InputStream inputStreamAh = null;
                        try {
                            randomAccessFile = new RandomAccessFile(xr.this.xr, "rw");
                            try {
                                if (zC) {
                                    randomAccessFile.seek(j);
                                    j2 = j;
                                } else {
                                    randomAccessFile.setLength(0L);
                                    j2 = 0;
                                }
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable unused2) {
                            randomAccessFile = null;
                        }
                        try {
                            inputStreamAh = aoVar.c().ah();
                            if (xr.x(map) && !(inputStreamAh instanceof GZIPInputStream)) {
                                inputStreamAh = new GZIPInputStream(inputStreamAh);
                            }
                            try {
                                byte[] bArr = new byte[16384];
                                long j3 = 0;
                                int i3 = 0;
                                while (true) {
                                    int i4 = inputStreamAh.read(bArr, i3, 16384 - i3);
                                    boolean z = true;
                                    if (i4 == i2) {
                                        break;
                                    }
                                    i3 += i4;
                                    InputStream inputStream = inputStreamAh;
                                    j3 += (long) i4;
                                    try {
                                        if (j3 % 16384 != 0 && j3 != jMs - j) {
                                            z = false;
                                        }
                                        if (z) {
                                            randomAccessFile.seek(j2);
                                            randomAccessFile.write(bArr, 0, i3);
                                            j2 += (long) i3;
                                            i3 = 0;
                                        }
                                        inputStreamAh = inputStream;
                                        i2 = -1;
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStreamAh = inputStream;
                                        try {
                                            com.bytedance.sdk.component.utils.sl.ms(th);
                                            msVar.ms(xr.this, new IOException(th.getMessage()));
                                            if (!zC) {
                                                xr.this.ka();
                                            }
                                            try {
                                                return;
                                            } catch (Throwable unused3) {
                                                return;
                                            }
                                        } finally {
                                            if (inputStreamAh != null) {
                                                try {
                                                    inputStreamAh.close();
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                            try {
                                                randomAccessFile.close();
                                            } catch (Throwable unused5) {
                                            }
                                        }
                                    }
                                }
                                InputStream inputStream2 = inputStreamAh;
                                if (!zC) {
                                    jMs = xr.this.xr.length();
                                }
                                if (jMs > 0 && xr.this.xr.exists() && xr.this.xr.length() == jMs) {
                                    if (xr.this.xr.renameTo(xr.this.f1297ms)) {
                                        xrVar3.ms(xr.this.f1297ms);
                                        msVar.ms(xr.this, xrVar3);
                                    } else {
                                        msVar.ms(xr.this, new IOException("Rename fail"));
                                    }
                                } else {
                                    msVar.ms(xr.this, new IOException(" tempFile.length() == fileSize is" + (xr.this.xr.length() == jMs)));
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused6) {
                                    }
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable unused7) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        msVar.ms(xr.this, xrVar3);
                    }
                }
            });
        } catch (IllegalArgumentException unused) {
            msVar.ms(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    @Override // com.bytedance.sdk.component.ny.xr.d
    public com.bytedance.sdk.component.ny.xr ms() {
        RandomAccessFile randomAccessFile;
        long j;
        InputStream inputStream;
        InputStream inputStream2;
        String str;
        int i;
        File file = this.f1297ms;
        if (file == null || this.xr == null) {
            return null;
        }
        long j2 = 0;
        if (file.exists() && this.f1297ms.length() != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.ny.xr xrVar = new com.bytedance.sdk.component.ny.xr(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            xrVar.ms(this.f1297ms);
            return xrVar;
        }
        long length = this.xr.length();
        if (length < 0) {
            length = 0;
        }
        u.ms msVar = new u.ms();
        msVar.ms((Object) xr());
        xr("Range", "bytes=" + length + "-");
        String str2 = "DownloadExecutor";
        if (TextUtils.isEmpty(this.c)) {
            com.bytedance.sdk.component.utils.sl.d("DownloadExecutor", "execute: Url is Empty");
            return null;
        }
        try {
            msVar.ms(this.c);
            ms(msVar);
            try {
                ao aoVarMs = this.ah.ms(msVar.ms().xr()).ms();
                if (aoVarMs == null || !aoVarMs.d()) {
                    return new com.bytedance.sdk.component.ny.xr(false, aoVarMs == null ? -2 : aoVarMs.ah(), aoVarMs == null ? "ok response is null" : aoVarMs.ka(), null, null, 0L, 0L);
                }
                HashMap map = new HashMap();
                c cVarAb = aoVarMs.ab();
                if (cVarAb != null) {
                    for (int i2 = 0; i2 < cVarAb.ms(); i2++) {
                        map.put(cVarAb.ms(i2), cVarAb.xr(i2));
                    }
                }
                com.bytedance.sdk.component.ny.xr xrVar2 = new com.bytedance.sdk.component.ny.xr(aoVarMs.d(), aoVarMs.ah(), aoVarMs.ka(), map, null, aoVarMs.xr(), aoVarMs.ms());
                long jMs = aoVarMs.c().ms();
                if (jMs <= 0) {
                    jMs = ab(map);
                }
                long length2 = this.xr.length();
                boolean zC = c(map);
                if (zC) {
                    jMs += length2;
                    String str3 = (String) map.get("Content-Range");
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = "bytes " + length2 + "-" + (jMs - 1);
                        if (TextUtils.indexOf(str3, str4) == -1) {
                            com.bytedance.sdk.component.ny.d.ka.ms("DownloadExecutor", "execute: The Content-Range Header is invalid Assume[" + str4 + "] vs Real[" + str3 + "], please remove the temporary file [" + this.xr + "].");
                            ka();
                            return new com.bytedance.sdk.component.ny.xr(false, -7, "realRangeValue failed", null, null, 0L, 0L);
                        }
                    }
                    j2 = 0;
                }
                if (jMs > j2 && this.xr.exists() && this.xr.length() == jMs) {
                    if (this.xr.renameTo(this.f1297ms)) {
                        xrVar2.ms(this.f1297ms);
                        return xrVar2;
                    }
                    com.bytedance.sdk.component.ny.d.ka.ms("DownloadExecutor", "Rename fail");
                    return new com.bytedance.sdk.component.ny.xr(false, -6, "rename failed", null, null, 0L, 0L);
                }
                try {
                    randomAccessFile = new RandomAccessFile(this.xr, "rw");
                    try {
                        if (zC) {
                            randomAccessFile.seek(length);
                            j = length;
                        } else {
                            randomAccessFile.setLength(0L);
                            j = 0;
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    randomAccessFile = null;
                }
                try {
                    InputStream inputStreamAh = aoVarMs.c().ah();
                    try {
                        if (x(map) && !(inputStreamAh instanceof GZIPInputStream)) {
                            inputStreamAh = new GZIPInputStream(inputStreamAh);
                        }
                        try {
                            byte[] bArr = new byte[16384];
                            long j3 = 0;
                            int i3 = 0;
                            while (true) {
                                str = str2;
                                i = inputStreamAh.read(bArr, i3, 16384 - i3);
                                boolean z = true;
                                inputStream2 = inputStreamAh;
                                if (i == -1) {
                                    break;
                                }
                                i3 += i;
                                long j4 = length;
                                j3 += (long) i;
                                try {
                                    if (j3 % 16384 != 0 && j3 != jMs - j4) {
                                        z = false;
                                    }
                                    if (z) {
                                        randomAccessFile.seek(j);
                                        randomAccessFile.write(bArr, 0, i3);
                                        j += (long) i3;
                                        i3 = 0;
                                    }
                                    str2 = str;
                                    inputStreamAh = inputStream2;
                                    length = j4;
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream = inputStream2;
                                    try {
                                        com.bytedance.sdk.component.utils.sl.ms(th);
                                        if (!zC) {
                                            ka();
                                        }
                                        return new com.bytedance.sdk.component.ny.xr(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L);
                                    } finally {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable unused3) {
                                            }
                                        }
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable unused4) {
                                        }
                                    }
                                }
                            }
                            long j5 = length;
                            if (i != 0) {
                                randomAccessFile.seek(j);
                                randomAccessFile.write(bArr, 0, i3);
                            }
                            if (!zC || j5 == 0) {
                                jMs = this.xr.length();
                            }
                            if (jMs <= 0 || !this.xr.exists() || this.xr.length() != jMs) {
                                String str5 = " tempFile.length() == fileSize is" + (this.xr.length() == jMs);
                                com.bytedance.sdk.component.ny.d.ka.ms(str, str5);
                                com.bytedance.sdk.component.ny.xr xrVar3 = new com.bytedance.sdk.component.ny.xr(false, -4, str5, null, null, 0L, 0L);
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable unused6) {
                                }
                                return xrVar3;
                            }
                            if (this.xr.renameTo(this.f1297ms)) {
                                xrVar2.ms(this.f1297ms);
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable unused8) {
                                }
                                return xrVar2;
                            }
                            com.bytedance.sdk.component.ny.xr xrVar4 = new com.bytedance.sdk.component.ny.xr(false, -5, "rename failed", null, null, 0L, 0L);
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable unused9) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable unused10) {
                            }
                            return xrVar4;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = inputStreamAh;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStreamAh;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                ka();
                return new com.bytedance.sdk.component.ny.xr(false, -1, e.getMessage(), null, null, 0L, 0L);
            }
        } catch (IllegalArgumentException unused11) {
            com.bytedance.sdk.component.utils.sl.d("DownloadExecutor", "Url is not a valid HTTP or HTTPS URL");
            return new com.bytedance.sdk.component.ny.xr(false, -8, "Url is not a valid HTTP or HTTPS URL", null, null, 0L, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long ab(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), Constants.CP_GZIP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        try {
            this.f1297ms.delete();
        } catch (Throwable unused) {
        }
        try {
            this.xr.delete();
        } catch (Throwable unused2) {
        }
    }
}

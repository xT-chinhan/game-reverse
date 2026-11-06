package com.byazt.vcq;

import android.text.TextUtils;
import com.anythink.china.a.c;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import com.byazt.tbt.w;
import com.byazt.tk.k;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1112, 19})
public class n extends s {
    public File n;
    public File qg;

    public n(d dVar) {
        super(dVar);
    }

    public void n(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.n = new File(str, str2);
        this.qg = new File(str, str2 + ".temp");
    }

    @Override // com.byazt.vcq.s
    public void n(final com.byazt.dgx.n nVar) {
        File file = this.n;
        if (file == null || this.qg == null) {
            if (nVar != null) {
                nVar.n(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.n.length() != 0 && nVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.phf.q qVar = new com.byazt.phf.q(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            qVar.n(this.n);
            nVar.n(this, qVar);
            return;
        }
        long length = this.qg.length();
        final long j = length >= 0 ? length : 0L;
        sz.n nVar2 = new sz.n();
        nVar2.n((Object) qg());
        qg("Range", "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.w)) {
            nVar.n(this, new IOException("Url is Empty"));
            return;
        }
        try {
            nVar2.qg(this.w);
            n(nVar2);
            this.s.n(nVar2.n().qg()).n(new com.byazt.tbt.s() { // from class: com.byazt.vcq.n.1
                @Override // com.byazt.tbt.s
                public void onFailure(com.byazt.tbt.qg qgVar, IOException iOException) {
                    com.byazt.dgx.n nVar3 = nVar;
                    if (nVar3 != null) {
                        nVar3.n(n.this, iOException);
                    }
                    n.this.l();
                }

                @Override // com.byazt.tbt.s
                public void onResponse(com.byazt.tbt.qg qgVar, cy cyVar) throws IOException {
                    RandomAccessFile randomAccessFile;
                    long j2;
                    if (nVar == null) {
                        return;
                    }
                    HashMap map = new HashMap();
                    if (cyVar == null) {
                        return;
                    }
                    w wVarFs = cyVar.fs();
                    if (wVarFs != null) {
                        for (int i = 0; i < wVarFs.n(); i++) {
                            map.put(wVarFs.n(i), wVarFs.qg(i));
                        }
                    }
                    com.byazt.phf.q qVar2 = new com.byazt.phf.q(cyVar.l(), cyVar.q(), cyVar.w(), map, null, cyVar.qg(), cyVar.n());
                    if (cyVar.l()) {
                        long jN = cyVar.x().n();
                        if (jN <= 0) {
                            jN = n.x(map);
                        }
                        boolean zW = n.w(map);
                        int i2 = -1;
                        if (zW) {
                            jN += j;
                            String str = (String) map.get("Content-Range");
                            if (!TextUtils.isEmpty(str)) {
                                String str2 = "bytes " + j + "-" + (jN - 1);
                                if (TextUtils.indexOf(str, str2) == -1) {
                                    n.this.l();
                                    nVar.n(n.this, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + n.this.qg + "]."));
                                    return;
                                }
                            }
                        }
                        if (jN > 0 && n.this.qg.exists() && n.this.qg.length() == jN) {
                            if (n.this.qg.renameTo(n.this.n)) {
                                qVar2.n(n.this.n);
                                nVar.n(n.this, qVar2);
                                return;
                            } else {
                                nVar.n(n.this, new IOException("Rename fail"));
                                return;
                            }
                        }
                        InputStream inputStreamS = null;
                        try {
                            randomAccessFile = new RandomAccessFile(n.this.qg, "rw");
                            try {
                                if (zW) {
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
                            inputStreamS = cyVar.x().s();
                            if (n.fs(map) && !(inputStreamS instanceof GZIPInputStream)) {
                                inputStreamS = new GZIPInputStream(inputStreamS);
                            }
                            try {
                                byte[] bArr = new byte[16384];
                                long j3 = 0;
                                int i3 = 0;
                                while (true) {
                                    int i4 = inputStreamS.read(bArr, i3, 16384 - i3);
                                    boolean z = true;
                                    if (i4 == i2) {
                                        break;
                                    }
                                    i3 += i4;
                                    InputStream inputStream = inputStreamS;
                                    j3 += (long) i4;
                                    try {
                                        if (j3 % c.o != 0 && j3 != jN - j) {
                                            z = false;
                                        }
                                        if (z) {
                                            randomAccessFile.seek(j2);
                                            randomAccessFile.write(bArr, 0, i3);
                                            j2 += (long) i3;
                                            i3 = 0;
                                        }
                                        inputStreamS = inputStream;
                                        i2 = -1;
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStreamS = inputStream;
                                        try {
                                            nVar.n(n.this, new IOException(th.getMessage()));
                                            if (!zW) {
                                                n.this.l();
                                            }
                                            try {
                                                return;
                                            } catch (Throwable unused3) {
                                                return;
                                            }
                                        } finally {
                                            if (inputStreamS != null) {
                                                try {
                                                    inputStreamS.close();
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
                                InputStream inputStream2 = inputStreamS;
                                if (!zW) {
                                    jN = n.this.qg.length();
                                }
                                if (jN > 0 && n.this.qg.exists() && n.this.qg.length() == jN) {
                                    if (n.this.qg.renameTo(n.this.n)) {
                                        qVar2.n(n.this.n);
                                        nVar.n(n.this, qVar2);
                                    } else {
                                        nVar.n(n.this, new IOException("Rename fail"));
                                    }
                                } else {
                                    nVar.n(n.this, new IOException(" tempFile.length() == fileSize is" + (n.this.qg.length() == jN)));
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
                        nVar.n(n.this, qVar2);
                    }
                }
            });
        } catch (IllegalArgumentException unused) {
            nVar.n(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:198:0x02d2 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x02bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.byazt.vcq.s
    public com.byazt.phf.q n() {
        long j;
        RandomAccessFile randomAccessFile;
        long j2;
        Throwable th;
        int i;
        InputStream inputStream;
        boolean z;
        File file = this.n;
        if (file == null || this.qg == null) {
            return new com.byazt.phf.q(false, -10, "file == null: " + (this.n == null) + " tempFile == null: " + (this.qg == null), null, null, 0L, 0L);
        }
        if (file.exists() && this.n.length() != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.phf.q qVar = new com.byazt.phf.q(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            qVar.n(this.n);
            return qVar;
        }
        long length = this.qg.length();
        if (length < 0) {
            length = 0;
        }
        sz.n nVar = new sz.n();
        nVar.n((Object) qg());
        qg("Range", "bytes=" + length + "-");
        if (TextUtils.isEmpty(this.w)) {
            k.qg("DownloadExecutor", "execute: Url is Empty");
            return new com.byazt.phf.q(false, -9, "url is Empty", null, null, 0L, 0L);
        }
        try {
            nVar.qg(this.w);
            n(nVar);
            try {
                cy cyVarQg = this.s.n(nVar.n().qg()).qg();
                if (cyVarQg == null || !cyVarQg.l()) {
                    return new com.byazt.phf.q(false, cyVarQg == null ? -2 : cyVarQg.q(), cyVarQg == null ? "ok response is null" : cyVarQg.w(), null, null, 0L, 0L);
                }
                HashMap map = new HashMap();
                w wVarFs = cyVarQg.fs();
                if (wVarFs != null) {
                    for (int i2 = 0; i2 < wVarFs.n(); i2++) {
                        map.put(wVarFs.n(i2), wVarFs.qg(i2));
                    }
                }
                com.byazt.phf.q qVar2 = new com.byazt.phf.q(cyVarQg.l(), cyVarQg.q(), cyVarQg.w(), map, null, cyVarQg.qg(), cyVarQg.n());
                long jN = cyVarQg.x().n();
                if (jN <= 0) {
                    jN = x(map);
                }
                long length2 = this.qg.length();
                boolean zW = w(map);
                if (zW) {
                    jN += length2;
                    String str = (String) map.get("Content-Range");
                    if (!TextUtils.isEmpty(str) && TextUtils.indexOf(str, "bytes " + length2 + "-" + (jN - 1)) == -1) {
                        l();
                        return new com.byazt.phf.q(false, -7, "realRangeValue failed", null, null, 0L, 0L);
                    }
                    j = 0;
                } else {
                    j = 0;
                }
                if (jN > j && this.qg.exists() && this.qg.length() == jN) {
                    if (!this.qg.renameTo(this.n)) {
                        return new com.byazt.phf.q(false, -6, "rename failed", null, null, 0L, 0L);
                    }
                    qVar2.n(this.n);
                    return qVar2;
                }
                InputStream inputStreamS = null;
                try {
                    randomAccessFile = new RandomAccessFile(this.qg, "rw");
                    try {
                        if (zW) {
                            randomAccessFile.seek(length);
                            j2 = length;
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
                    inputStreamS = cyVarQg.x().s();
                    if (fs(map) && !(inputStreamS instanceof GZIPInputStream)) {
                        inputStreamS = new GZIPInputStream(inputStreamS);
                    }
                    try {
                        byte[] bArr = new byte[16384];
                        int i3 = 0;
                        long j3 = 0;
                        while (true) {
                            i = inputStreamS.read(bArr, i3, 16384 - i3);
                            inputStream = inputStreamS;
                            if (i == -1) {
                                break;
                            }
                            i3 += i;
                            RandomAccessFile randomAccessFile2 = randomAccessFile;
                            long j4 = j3 + ((long) i);
                            try {
                                if (j4 % c.o == 0 || j4 == jN - length) {
                                    randomAccessFile = randomAccessFile2;
                                    try {
                                        randomAccessFile.seek(j2);
                                        randomAccessFile.write(bArr, 0, i3);
                                        j2 += (long) i3;
                                        i3 = 0;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        th = th;
                                        inputStreamS = inputStream;
                                        if (!zW) {
                                            try {
                                                l();
                                            } finally {
                                                if (inputStreamS != null) {
                                                    try {
                                                        inputStreamS.close();
                                                    } catch (Throwable unused3) {
                                                    }
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                        }
                                        return new com.byazt.phf.q(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                                    }
                                } else {
                                    randomAccessFile = randomAccessFile2;
                                }
                                inputStreamS = inputStream;
                                j3 = j4;
                            } catch (Throwable th3) {
                                th = th3;
                                randomAccessFile = randomAccessFile2;
                            }
                        }
                        if (i != 0) {
                            randomAccessFile.seek(j2);
                            z = false;
                            randomAccessFile.write(bArr, 0, i3);
                        } else {
                            z = false;
                        }
                        if (!zW || length == 0) {
                            jN = this.qg.length();
                        }
                        if (jN <= 0 || !this.qg.exists() || this.qg.length() != jN) {
                            com.byazt.phf.q qVar3 = new com.byazt.phf.q(false, -4, " tempFile.length() == fileSize is" + (this.qg.length() == jN ? true : z), null, null, 0L, 0L);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused5) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable unused6) {
                            }
                            return qVar3;
                        }
                        if (this.qg.renameTo(this.n)) {
                            qVar2.n(this.n);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused7) {
                                }
                            }
                            try {
                                randomAccessFile.close();
                            } catch (Throwable unused8) {
                            }
                            return qVar2;
                        }
                        com.byazt.phf.q qVar4 = new com.byazt.phf.q(false, -5, "rename failed", null, null, 0L, 0L);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused9) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused10) {
                        }
                        return qVar4;
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        if (!zW) {
                            l();
                        }
                        return new com.byazt.phf.q(false, -3, "Error occured when FileRequest.parseHttpResponse", null, null, 0L, 0L, th);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (IOException e) {
                l();
                return new com.byazt.phf.q(false, -1, e.getMessage(), null, null, 0L, 0L, e);
            }
        } catch (IllegalArgumentException unused11) {
            k.qg("DownloadExecutor", "Url is not a valid HTTP or HTTPS URL");
            return new com.byazt.phf.q(false, -8, "Url is not a valid HTTP or HTTPS URL", null, null, 0L, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(Map<String, String> map) {
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
    public static long x(Map<String, String> map) {
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
    public static boolean fs(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            this.n.delete();
        } catch (Throwable unused) {
        }
        try {
            this.qg.delete();
        } catch (Throwable unused2) {
        }
    }
}

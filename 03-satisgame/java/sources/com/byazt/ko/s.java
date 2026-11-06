package com.byazt.ko;

import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 8})
public abstract class s {
    public boolean n;
    public boolean q;
    public boolean qg;
    public boolean s;

    public abstract boolean n(JSONObject jSONObject) throws JSONException, SecurityException;

    public s(boolean z, boolean z2) {
        this.qg = z;
        this.s = z2;
        this.q = false;
    }

    public s(boolean z, boolean z2, boolean z3) {
        this.qg = z;
        this.s = z2;
        this.q = z3;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:? A[SYNTHETIC] */
    public String n(String str, String str2) throws Throwable {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        int i;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api.embed/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLockLock = null;
        try {
            File file = new File(str3);
            if (!file.exists() && !file.mkdirs()) {
                return str2;
            }
            File file2 = new File(str4);
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rwd");
            try {
                fileLockLock = randomAccessFile2.getChannel().lock();
                if (file2.isFile() && (i = randomAccessFile2.read((bArr = new byte[129]), 0, 129)) > 0 && i < 129) {
                    String str5 = new String(bArr, 0, i, "UTF-8");
                    if (rv.n(str5)) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (Exception unused2) {
                        }
                        return str5;
                    }
                }
                byte[] bytes = str2.getBytes("UTF-8");
                randomAccessFile2.setLength(0L);
                randomAccessFile2.write(bytes);
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception unused3) {
                    }
                }
                try {
                    randomAccessFile2.close();
                } catch (Exception unused4) {
                }
                return str2;
            } catch (IOException e) {
                randomAccessFile = randomAccessFile2;
                e = e;
            } catch (Throwable th) {
                randomAccessFile = randomAccessFile2;
                th = th;
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception unused5) {
                    }
                }
                if (randomAccessFile != null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (Exception unused6) {
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            if (com.byazt.fo.q.l().n.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                throw new SecurityException(e);
            }
            com.byazt.km.cp.qg(e);
            if (fileLockLock != null) {
                try {
                    fileLockLock.release();
                } catch (Exception unused7) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception unused8) {
                }
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            if (randomAccessFile != null) {
                throw th;
            }
            randomAccessFile.close();
            throw th;
        }
    }
}

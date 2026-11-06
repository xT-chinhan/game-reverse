package com.byazt.mzw;

import com.byazt.tk.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1346, 101})
public class fs {
    public static com.byazt.px.n n;

    public static void n() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(l.x(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.byazt.px.n nVarN = com.byazt.px.n.n(new JSONObject(new String(bArr, "utf-8")));
                    if (nVarN != null) {
                        n = nVarN;
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        k.n("Version", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static synchronized com.byazt.px.n qg() {
        return n;
    }

    public static synchronized void n(com.byazt.px.n nVar) {
        if (nVar != null) {
            if (nVar.w()) {
                n = nVar;
            }
        }
    }

    public static void s() {
        l.n(l.x(), qg(), "temp_pkg_info.json");
    }

    public static boolean n(String str) {
        return l.n(qg(), str);
    }

    public static boolean qg(com.byazt.px.n nVar) {
        return l.s(qg(), nVar);
    }

    public static void q() {
        l.qg(l.x(), qg(), "temp_pkg_info.json");
        n = null;
    }
}

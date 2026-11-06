package com.byazt.mty;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 669, 18})
public class l implements com.byazt.uyg.n, com.byazt.uyg.qg {
    public static Method n = null;
    public static Method qg = null;
    public static boolean s = false;
    public final boolean l;
    public final com.byazt.eau.s q;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            n = cls.getDeclaredMethod("readMapXml", InputStream.class);
            qg = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            n.setAccessible(true);
            qg.setAccessible(true);
            s = true;
        } catch (Exception unused) {
            s = false;
        }
    }

    public static boolean n() {
        return s;
    }

    public l(com.byazt.eau.s sVar) {
        this.q = sVar;
        this.l = false;
    }

    public l(com.byazt.eau.s sVar, boolean z) {
        this.q = sVar;
        this.l = z;
    }

    @Override // com.byazt.uyg.n
    public Map<String, Object> n(File file) throws Throwable {
        if (s && file.exists()) {
            BufferedInputStream bufferedInputStream = null;
            if (!file.canRead()) {
                return null;
            }
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 49152);
                try {
                    Map<String, Object> mapN = new com.byazt.ga.qg().n((Map) n.invoke(null, bufferedInputStream2), this.q, this.l);
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return mapN;
                } catch (Exception unused2) {
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return Collections.emptyMap();
    }

    @Override // com.byazt.uyg.qg
    public void n(Map<String, Object> map, File file) throws Throwable {
        if (!s || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                qg.invoke(null, new com.byazt.ga.qg().n(map, this.q, this.l), fileOutputStream2);
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Exception unused2) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

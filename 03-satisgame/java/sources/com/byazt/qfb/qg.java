package com.byazt.qfb;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.eo.q;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.byazt.tk.w;
import com.byazt.vyf.s;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2004, 26})
public class qg {
    public String n;

    public static qg n() {
        return new qg();
    }

    private qg() {
        qg();
    }

    private void qg() {
        File fileN;
        Context context = rv.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.byazt.xu.qg.n()) && (fileN = w.n(context, "TTCache", false, null)) != null) {
                fileN.mkdirs();
                this.n = fileN.getPath();
            }
            if (TextUtils.isEmpty(this.n)) {
                File file = new File(w.n(context, false, null), "TTCache");
                file.mkdirs();
                this.n = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    public void n(Thread thread, Throwable th, String str) {
        boolean zContains = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            if (string != null) {
                if (TextUtils.isEmpty(str)) {
                    str = TTAdConstant.class.getPackage().getName();
                }
                zContains = string.contains(str);
            }
            q.n().n(thread, th);
        } catch (Throwable unused) {
        }
        if (zContains) {
            n(thread, th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x010f A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x010a A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void n(Thread thread, Throwable th) {
        FileOutputStream fileOutputStream;
        boolean z;
        int i;
        FileInputStream fileInputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.n)) {
                qg();
            }
            if (TextUtils.isEmpty(this.n)) {
                return;
            }
            File file = new File(this.n, "tt_crash_count.properties");
            if (file.exists() && file.isFile() && file.canRead()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream3);
                    String property = properties.getProperty("crash_count", "0");
                    String property2 = properties.getProperty("crash_last_time", "0");
                    int iIntValue = Integer.valueOf(property).intValue();
                    int i2 = 0;
                    boolean z2 = true;
                    if (System.currentTimeMillis() - Long.valueOf(property2).longValue() < 300000) {
                        i = iIntValue + 1;
                        z = false;
                    } else {
                        z = true;
                        i = 1;
                    }
                    if (i < 3) {
                        z2 = false;
                    }
                    if (!z2) {
                        i2 = i;
                    }
                    k.qg("TTCrashHandler", "==" + i2 + ", " + z2 + ", " + z);
                    if (z2) {
                        try {
                            file.delete();
                        } catch (Throwable unused) {
                        }
                    } else {
                        properties.setProperty("crash_count", String.valueOf(i2));
                        if (z) {
                            properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            properties.store(fileOutputStream, "tt_crash_info");
                            fileOutputStream2 = fileOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream3;
                            k.n("TTCrashHandler", "crash count error", th);
                        }
                    }
                    if (z2) {
                        s();
                    }
                    fileOutputStream = fileOutputStream2;
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                }
            } else {
                Properties properties2 = new Properties();
                properties2.setProperty("crash_count", "1");
                properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                fileOutputStream = new FileOutputStream(file);
                try {
                    properties2.store(fileOutputStream, "tt_crash_info");
                    k.qg("TTCrashHandler", "==first");
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        k.n("TTCrashHandler", "crash count error", th);
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    private void s() {
        try {
            com.byazt.mz.n.n().s();
        } catch (Throwable unused) {
        }
        try {
            com.byazt.tf.n.n().qg();
        } catch (Throwable unused2) {
        }
        try {
            com.byazt.ivn.q.n();
        } catch (Throwable unused3) {
        }
        try {
            com.byazt.mzw.qg.qg();
            com.byazt.cr.qg.qg().w();
        } catch (Throwable unused4) {
        }
        try {
            Function<SparseArray<Object>, Object> functionFi = s.cy().fi();
            if (functionFi != null) {
                functionFi.apply(com.byazt.of.qg.n().n(7).n(Void.class).qg());
            }
        } catch (Throwable unused5) {
        }
        try {
            com.byazt.ed.qg.n().cp();
            com.byazt.ed.s.n().hd();
            com.byazt.ed.q.n().cy();
        } catch (Throwable unused6) {
        }
    }
}

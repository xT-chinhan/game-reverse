package com.byazt.xhd;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.x;
import com.byazt.tk.w;
import com.byazt.vyf.l;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 504, 8})
public class s {
    public static Boolean n = null;
    public static Method qg = null;
    public static boolean s = n().exists();

    public static File n() {
        return new File(w.n(rv.getContext(), false, null), ".csj_so");
    }

    public static File qg() {
        return new File(w.n(rv.getContext(), false, null), ".c_c_s_f");
    }

    public static void n(final String str) {
        if (rv.qg().fp() == 1) {
            if (!qg.n(str) && rv.qg().yk() == 1) {
                l.n = false;
                if ("maparmor".equals(str) || "panglearmor".equals(str)) {
                    throw new qg.s("SoVerfailed: ".concat(String.valueOf(str)));
                }
            }
        } else if (rv.qg().fp() == 2) {
            com.byazt.qit.l.n(new x("har") { // from class: com.byazt.xhd.s.1
                @Override // java.lang.Runnable
                public void run() {
                    qg.n(str);
                }
            }, 5000);
        }
        try {
            if (s && !TextUtils.equals(str, "pangleflipped") && qg(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            if (th instanceof qg.s) {
                throw th;
            }
            th.printStackTrace();
            n(str, th);
        }
    }

    private static boolean qg(String str) {
        try {
            if (qg == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                qg = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) s.class.getClassLoader();
            if (qg != null && baseDexClassLoader != null) {
                String strFindLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (s.class) {
                    qg.invoke(null, strFindLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            s = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, "lock load failed!");
            } catch (JSONException unused) {
            }
            com.byazt.eji.s.n().n("so_load_fail", jSONObject, th);
        }
        return false;
    }

    private static boolean n(String str, Throwable th) {
        String strX = tj.x();
        String str2 = "lib" + str + ".so";
        File file = new File(strX, "/lib/".concat(String.valueOf(str2)));
        if (file.exists() && file.length() > 0) {
            return n(str, file.getAbsolutePath());
        }
        File file2 = new File(strX, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            n(file2, file, str2);
            File file3 = new File(strX, "/lib/".concat(String.valueOf(str2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                    return n(str, file3.getAbsolutePath());
                }
            }
            n(str, str2 + " unzip failed !", th);
            return false;
        }
        n(str, "load so filed! apk not exist! ", th);
        return false;
    }

    private static boolean n(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            n(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void n(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.byazt.wl.qg.n() + "/" + str);
            if (entry == null) {
                entry = zipFile.getEntry("lib/armeabi/".concat(String.valueOf(str)));
            }
            if (entry == null) {
                return;
            }
            file2.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[102400];
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i != -1) {
                                    bufferedOutputStream.write(bArr, 0, i);
                                } else {
                                    com.byazt.wvr.qg.n(bufferedInputStream);
                                    com.byazt.wvr.qg.n(bufferedOutputStream);
                                    com.byazt.wvr.qg.n(fileOutputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.byazt.wvr.qg.n(bufferedInputStream);
                            com.byazt.wvr.qg.n(bufferedOutputStream);
                            com.byazt.wvr.qg.n(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (Throwable unused) {
        }
    }

    private static void n(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            l.n = false;
        }
        if (s()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str2);
            if (qg().exists()) {
                int iN = n.n(str);
                if (iN == 3) {
                    return;
                } else {
                    jSONObject.putOpt("cloud_state", Integer.valueOf(iN));
                }
            } else {
                jSONObject.putOpt("cloud_state", 0);
            }
        } catch (Throwable th2) {
            try {
                jSONObject.putOpt("cloud_exception", th2.getMessage());
            } catch (Exception unused) {
            }
        }
        com.byazt.eji.s.n().n("so_load_fail", jSONObject, th);
    }

    public static boolean s() {
        Boolean bool = n;
        if (bool != null) {
            return bool.booleanValue();
        }
        n = Boolean.FALSE;
        try {
            Context context = rv.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.flags & 1) != 0) {
                n = Boolean.TRUE;
            }
        } catch (Exception unused) {
        }
        return n.booleanValue();
    }
}

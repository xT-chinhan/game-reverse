package com.byazt.zp;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.lb;
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
@com.byazt.vzx.pr(pr = {0, 1, 1229, 62})
public class fw {
    public static boolean hn;
    public static Method hw;
    public static Boolean pr = null;

    static {
        hn = false;
        hn = pr().exists();
    }

    public static File pr() {
        return new File(com.byazt.ca.uc.pr(a.getContext(), false, null), ".csj_so");
    }

    public static void pr(final String str) {
        if (a.hw().oq() == 1) {
            if (!uc.pr(str) && a.hw().kp() == 1) {
                lb.pr = false;
                if ("maparmor".equals(str) || "panglearmor".equals(str)) {
                    throw new uc.hn("SoVerfailed: ".concat(String.valueOf(str)));
                }
            }
        } else if (a.hw().oq() == 2) {
            com.byazt.xlm.c.pr(new com.byazt.xlm.fw("har") { // from class: com.byazt.zp.fw.1
                @Override // java.lang.Runnable
                public void run() {
                    uc.pr(str);
                }
            }, 5000);
        }
        try {
            if (hn && !TextUtils.equals(str, "pangleflipped") && hw(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            if (th instanceof uc.hn) {
                throw th;
            }
            th.printStackTrace();
            pr(str, th);
        }
    }

    private static boolean hw(String str) {
        try {
            if (hw == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                hw = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) fw.class.getClassLoader();
            if (hw != null && baseDexClassLoader != null) {
                String strFindLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (fw.class) {
                    hw.invoke(null, strFindLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            hn = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, "lock load failed!");
            } catch (JSONException e) {
            }
            com.byazt.xk.hw.pr().pr("so_load_fail", jSONObject, th);
        }
        return false;
    }

    private static boolean pr(String str, Throwable th) {
        String strUc = iu.uc();
        String str2 = "lib" + str + ".so";
        File file = new File(strUc, "/lib/".concat(String.valueOf(str2)));
        if (file.exists() && file.length() > 0) {
            return pr(str, file.getAbsolutePath());
        }
        File file2 = new File(strUc, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            pr(file2, file, str2);
            File file3 = new File(strUc, "/lib/".concat(String.valueOf(str2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable th2) {
                    return pr(str, file3.getAbsolutePath());
                }
            }
            pr(str, str2 + " unzip failed !", th);
            return false;
        }
        pr(str, "load so filed! apk not exist! ", th);
        return false;
    }

    private static boolean pr(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            pr(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void pr(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.byazt.sp.hw.pr() + "/" + str);
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
                                    com.byazt.cb.hw.pr(bufferedInputStream);
                                    com.byazt.cb.hw.pr(bufferedOutputStream);
                                    com.byazt.cb.hw.pr(fileOutputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.byazt.cb.hw.pr(bufferedInputStream);
                            com.byazt.cb.hw.pr(bufferedOutputStream);
                            com.byazt.cb.hw.pr(fileOutputStream);
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
        } catch (Throwable th6) {
        }
    }

    private static void pr(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            lb.pr = false;
        }
        if (!hw()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str2);
            } catch (JSONException e) {
            }
            com.byazt.xk.hw.pr().pr("so_load_fail", jSONObject, th);
        }
    }

    public static boolean hw() {
        Boolean bool = pr;
        if (bool != null) {
            return bool.booleanValue();
        }
        pr = Boolean.FALSE;
        try {
            Context context = a.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.flags & 1) != 0) {
                pr = Boolean.TRUE;
            }
        } catch (Exception e) {
        }
        return pr.booleanValue();
    }
}

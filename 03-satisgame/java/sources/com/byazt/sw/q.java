package com.byazt.sw;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.byazt.gx.fs;
import com.byazt.gx.x;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 96, 5})
public class q implements l.n {
    public static volatile IBinder n;
    public static volatile Object qg;

    public interface n {
    }

    private static String[] n(String... strArr) {
        return strArr;
    }

    @Override // com.byazt.sw.l.n
    public boolean n(String str, int i) {
        n();
        qg(str, i);
        boolean zN = n("speed", str, i);
        s(str, i);
        return zN;
    }

    private static void n() {
        PackageManager packageManager;
        Field fieldN;
        IBinder iBinderAsBinder;
        if (n == null && (fieldN = n((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object objN = n(fieldN, packageManager);
            qg = objN;
            if ((objN instanceof IInterface) && (iBinderAsBinder = ((IInterface) qg).asBinder()) != null) {
                n = iBinderAsBinder;
            }
        }
    }

    private static boolean n(String str, String str2, int i) {
        String str3 = com.byazt.zi.s.fs(str2, i) + File.separator + com.byazt.sw.qg.n(com.byazt.zi.s.l(str2, i));
        for (int i2 = 1; i2 <= 3; i2++) {
            n(n(str), (n) null);
            if (com.byazt.sw.qg.n(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void qg(String str, int i) {
        if (str == null) {
            return;
        }
        String strQg = com.byazt.zi.s.qg(str, i);
        String strL = com.byazt.zi.s.l(str, i);
        n(strQg, strL);
        n(Zeus.getAppApplication().getPackageName(), strL, com.byazt.sw.qg.n());
    }

    private static void n(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT == 30) {
            qg(str, str2, str3);
        } else if (Build.VERSION.SDK_INT == 29) {
            s(str, str2, str3);
        }
    }

    private static void qg(String str, String str2, String str3) {
        if (qg == null || str == null || str2 == null || str3 == null) {
            return;
        }
        n(qg, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void s(String str, String str2, String str3) {
        if (qg == null || str == null || str2 == null || str3 == null) {
            return;
        }
        n(qg, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static void s(String str, int i) {
        if (str == null) {
            return;
        }
        qg(com.byazt.zi.s.x(str, i), com.byazt.zi.s.w(str, i));
        qg(com.byazt.zi.s.l(str, i));
        qg();
    }

    private static void qg() {
        n(s(), (n) null);
    }

    private static void n(String[] strArr, n nVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeFileDescriptor(FileDescriptor.in);
        parcelObtain.writeFileDescriptor(FileDescriptor.out);
        parcelObtain.writeFileDescriptor(FileDescriptor.err);
        parcelObtain.writeStringArray(strArr);
        parcelObtain.writeStrongBinder(null);
        new qg(nVar).writeToParcel(parcelObtain, 0);
        try {
            n.transact(1598246212, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    private static String[] n(String str) {
        return n("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static String[] s() {
        return n("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void n(String str, String str2) {
        try {
            fs.n(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void qg(String str, String str2) {
        try {
            x.n(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void qg(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 96, 524})
    private static class qg extends ResultReceiver {
        public n n;

        public qg(n nVar) {
            super(null);
            this.n = nVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    public static Field n(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return n(obj.getClass(), str);
    }

    public static Field n(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object n(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object n(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

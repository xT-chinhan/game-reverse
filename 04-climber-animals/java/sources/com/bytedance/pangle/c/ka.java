package com.bytedance.pangle.c;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
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
public class ka implements c.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile IBinder f622ms;
    private static volatile Object xr;

    public interface ms {
    }

    private static String[] ms(String... strArr) {
        return strArr;
    }

    @Override // com.bytedance.pangle.c.c.ms
    public boolean ms(String str, int i) {
        ms();
        xr(str, i);
        boolean zMs = ms("speed", str, i);
        ah(str, i);
        return zMs;
    }

    private static void ms() {
        PackageManager packageManager;
        Field fieldMs;
        IBinder iBinderAsBinder;
        if (f622ms == null && (fieldMs = ms((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object objMs = ms(fieldMs, packageManager);
            xr = objMs;
            if ((objMs instanceof IInterface) && (iBinderAsBinder = ((IInterface) xr).asBinder()) != null) {
                f622ms = iBinderAsBinder;
            }
        }
    }

    private static boolean ms(String str, String str2, int i) {
        String str3 = com.bytedance.pangle.ka.ah.x(str2, i) + File.separator + com.bytedance.pangle.c.xr.ms(com.bytedance.pangle.ka.ah.ka(str2, i));
        for (int i2 = 1; i2 <= 3; i2++) {
            ms(ms(str), (ms) null);
            if (com.bytedance.pangle.c.xr.ms(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void xr(String str, int i) {
        if (str == null) {
            return;
        }
        String strXr = com.bytedance.pangle.ka.ah.xr(str, i);
        String strKa = com.bytedance.pangle.ka.ah.ka(str, i);
        ms(strXr, strKa);
        ms(Zeus.getAppApplication().getPackageName(), strKa, com.bytedance.pangle.c.xr.ms());
    }

    private static void ms(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT == 30) {
            xr(str, str2, str3);
        } else if (Build.VERSION.SDK_INT == 29) {
            ah(str, str2, str3);
        }
    }

    private static void xr(String str, String str2, String str3) {
        if (xr == null || str == null || str2 == null || str3 == null) {
            return;
        }
        ms(xr, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void ah(String str, String str2, String str3) {
        if (xr == null || str == null || str2 == null || str3 == null) {
            return;
        }
        ms(xr, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static void ah(String str, int i) {
        if (str == null) {
            return;
        }
        xr(com.bytedance.pangle.ka.ah.ab(str, i), com.bytedance.pangle.ka.ah.c(str, i));
        xr(com.bytedance.pangle.ka.ah.ka(str, i));
        xr();
    }

    private static void xr() {
        ms(ah(), (ms) null);
    }

    private static void ms(String[] strArr, ms msVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeFileDescriptor(FileDescriptor.in);
        parcelObtain.writeFileDescriptor(FileDescriptor.out);
        parcelObtain.writeFileDescriptor(FileDescriptor.err);
        parcelObtain.writeStringArray(strArr);
        parcelObtain.writeStrongBinder(null);
        new xr(msVar).writeToParcel(parcelObtain, 0);
        try {
            f622ms.transact(1598246212, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    private static String[] ms(String str) {
        return ms("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static String[] ah() {
        return ms("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void ms(String str, String str2) {
        try {
            com.bytedance.pangle.util.x.ms(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void xr(String str, String str2) {
        try {
            com.bytedance.pangle.util.ab.ms(str, str2);
        } catch (Exception unused) {
        }
    }

    private static void xr(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static class xr extends ResultReceiver {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ms f623ms;

        public xr(ms msVar) {
            super(null);
            this.f623ms = msVar;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    public static Field ms(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return ms(obj.getClass(), str);
    }

    public static Field ms(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object ms(Field field, Object obj) {
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

    public static Object ms(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}

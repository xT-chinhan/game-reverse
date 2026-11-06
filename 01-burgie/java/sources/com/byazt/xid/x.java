package com.byazt.xid;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.byazt.gs.fw;
import com.byazt.gs.zo;
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
@com.byazt.vzx.pr(pr = {0, 1, 582, 121})
public class x implements c.pr {
    public static volatile IBinder pr = null;
    public static volatile Object hw = null;

    public interface pr {
    }

    @Override // com.byazt.xid.c.pr
    public boolean pr(String str, int i) {
        pr();
        hw(str, i);
        boolean zPr = pr("speed", str, i);
        hn(str, i);
        return zPr;
    }

    private static void pr() {
        PackageManager packageManager;
        Field fieldPr;
        IBinder iBinderAsBinder;
        if (pr != null || (fieldPr = pr((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) == null) {
            return;
        }
        Object objPr = pr(fieldPr, packageManager);
        hw = objPr;
        if ((objPr instanceof IInterface) && (iBinderAsBinder = ((IInterface) hw).asBinder()) != null) {
            pr = iBinderAsBinder;
        }
    }

    private static boolean pr(String str, String str2, int i) {
        String str3 = com.byazt.wo.hn.zo(str2, i) + File.separator + com.byazt.xid.hw.pr(com.byazt.wo.hn.c(str2, i));
        for (int i2 = 1; i2 <= 3; i2++) {
            pr(pr(str), (pr) null);
            if (com.byazt.xid.hw.pr(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void hw(String str, int i) {
        if (str == null) {
            return;
        }
        String strHw = com.byazt.wo.hn.hw(str, i);
        String strC = com.byazt.wo.hn.c(str, i);
        pr(strHw, strC);
        pr(Zeus.getAppApplication().getPackageName(), strC, com.byazt.xid.hw.pr());
    }

    private static void pr(String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT == 30) {
            hw(str, str2, str3);
        } else if (Build.VERSION.SDK_INT == 29) {
            hn(str, str2, str3);
        }
    }

    private static void hw(String str, String str2, String str3) {
        if (hw == null || str == null || str2 == null || str3 == null) {
            return;
        }
        pr(hw, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void hn(String str, String str2, String str3) {
        if (hw == null || str == null || str2 == null || str3 == null) {
            return;
        }
        pr(hw, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    private static void hn(String str, int i) {
        if (str == null) {
            return;
        }
        hw(com.byazt.wo.hn.fw(str, i), com.byazt.wo.hn.uc(str, i));
        hw(com.byazt.wo.hn.c(str, i));
        hw();
    }

    private static void hw() {
        pr(hn(), (pr) null);
    }

    private static void pr(String[] strArr, pr prVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeFileDescriptor(FileDescriptor.in);
        parcelObtain.writeFileDescriptor(FileDescriptor.out);
        parcelObtain.writeFileDescriptor(FileDescriptor.err);
        parcelObtain.writeStringArray(strArr);
        parcelObtain.writeStrongBinder(null);
        new hw(prVar).writeToParcel(parcelObtain, 0);
        try {
            pr.transact(1598246212, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception e) {
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    private static String[] pr(String str) {
        return pr("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static String[] hn() {
        return pr("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static String[] pr(String... strArr) {
        return strArr;
    }

    private static void pr(String str, String str2) {
        try {
            zo.pr(str, str2);
        } catch (Exception e) {
        }
    }

    private static void hw(String str, String str2) {
        try {
            fw.pr(str, str2);
        } catch (Exception e) {
        }
    }

    private static void hw(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 582, 759})
    private static class hw extends ResultReceiver {
        public pr pr;

        public hw(pr prVar) {
            super(null);
            this.pr = prVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    public static Field pr(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return pr(obj.getClass(), str);
    }

    public static Field pr(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object pr(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception e) {
            return null;
        }
    }

    public static Object pr(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception e) {
            return null;
        }
    }
}

package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.umeng.analytics.pro.cc;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class pbln {
    private static final String pr = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "a8a947", new byte[]{92, 9, 34, 66, 24, 37, 102});

    public static boolean pr(Context context) {
        boolean z;
        IBinder iBinder;
        IBinder iBinder2;
        boolean z2;
        Bundle bundle;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8af88d", new byte[]{40, 109, 17, 94, 8, 122, 63, cc.l, 62, 102, 61, 102, 27, 88, 73, 114, 56, 84, 62, 103, 39, 45, 56, 109, 46, 93}), (Uri) null), 128).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.applicationInfo.metaData) != null && bundle.get((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e9aebc", new byte[]{108, 43, 29, 2, 88, 112, 107, 17, 62, 35, 113, 41, 1, 24, 82, 122})) != null) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        if (!z) {
            String packageName = context.getPackageName();
            String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bd6c3", new byte[]{33, 99, 3, 75, 74, 45, 38, 90});
            try {
                byte[] bArr = new byte[25];
                bArr[0] = 118;
                bArr[1] = 111;
                bArr[2] = 17;
                bArr[3] = 94;
                bArr[4] = 1;
                bArr[5] = 42;
                bArr[6] = 97;
                bArr[7] = 12;
                bArr[8] = 56;
                bArr[9] = 123;
                try {
                    bArr[10] = 57;
                    bArr[11] = 82;
                    bArr[12] = cc.n;
                    bArr[13] = 94;
                    bArr[14] = 24;
                    bArr[15] = 42;
                    bArr[16] = 102;
                    bArr[17] = 71;
                    bArr[18] = 26;
                    bArr[19] = 105;
                    bArr[20] = 121;
                    bArr[21] = 96;
                    bArr[22] = 18;
                    bArr[23] = 73;
                    bArr[24] = 28;
                    Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fcf814", bArr)).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eb4057", new byte[]{115, 101, 83, 119, cc.m, 50, 112, 74, 102, 101}), String.class);
                    declaredMethod.setAccessible(true);
                    iBinder = null;
                    try {
                        iBinder2 = (IBinder) declaredMethod.invoke(null, str);
                    } catch (Exception e) {
                        iBinder2 = iBinder;
                    }
                } catch (Exception e2) {
                    iBinder = null;
                }
            } catch (Exception e3) {
                iBinder = null;
            }
            if (iBinder2 == null) {
                z2 = false;
            } else {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(pr);
                    parcelObtain.writeInt(2);
                    parcelObtain.writeString(packageName);
                    parcelObtain.writeStrongBinder(new Binder());
                    if (iBinder2.transact(1598837584, parcelObtain, parcelObtain2, 0)) {
                        parcelObtain2.readException();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        z2 = true;
                    } else {
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        z2 = false;
                    }
                } catch (Throwable th) {
                }
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }
}

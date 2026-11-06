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
import com.bytedance.sdk.component.utils.sl;
import com.umeng.analytics.pro.ek;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class pblr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4857ms = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "dcb54b", new byte[]{89, 82, 33, 78, 24, 112, 99});

    public static boolean ms(Context context) {
        boolean z;
        IBinder iBinder;
        IBinder iBinder2;
        boolean z2;
        Bundle bundle;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4d96b", new byte[]{113, 56, 19, 95, 6, 124, 102, 91, 60, 103, 100, 51, 25, 89, 71, 116, 97, 1, 60, 102, 126, 120, 58, 108, 32, 91}), (Uri) null), 128).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.applicationInfo.metaData) != null && bundle.get((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a45d3a", new byte[]{104, 38, 73, 3, 9, 114, 111, 28, 106, 34, 117, 36, 85, 25, 3, 120})) != null) {
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
            String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c51076", new byte[]{115, 52, 86, 77, 30, 40, 116, ek.k});
            try {
                byte[] bArr = new byte[25];
                bArr[0] = 113;
                bArr[1] = 53;
                bArr[2] = 79;
                bArr[3] = 4;
                bArr[4] = 3;
                bArr[5] = 122;
                bArr[6] = 102;
                bArr[7] = 86;
                bArr[8] = 102;
                bArr[9] = 33;
                try {
                    bArr[10] = 62;
                    bArr[11] = 8;
                    bArr[12] = 78;
                    bArr[13] = 4;
                    bArr[14] = 26;
                    bArr[15] = 122;
                    bArr[16] = 97;
                    bArr[17] = 29;
                    bArr[18] = 68;
                    bArr[19] = 51;
                    bArr[20] = 126;
                    bArr[21] = 58;
                    bArr[22] = 76;
                    bArr[23] = 19;
                    bArr[24] = 30;
                    Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a98b3d", bArr)).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "307ec0", new byte[]{37, 55, 80, 34, 89, 53, 38, 24, 101, 48}), String.class);
                    declaredMethod.setAccessible(true);
                    iBinder = null;
                    try {
                        iBinder2 = (IBinder) declaredMethod.invoke(null, str);
                    } catch (Exception e) {
                        e = e;
                        sl.ms(e);
                        iBinder2 = iBinder;
                    }
                } catch (Exception e2) {
                    e = e2;
                    iBinder = null;
                }
            } catch (Exception e3) {
                e = e3;
                iBinder = null;
            }
            if (iBinder2 == null) {
                z2 = false;
            } else {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(f4857ms);
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
                    try {
                        sl.ms(th);
                    } catch (Throwable th2) {
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                        throw th2;
                    }
                }
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }
}

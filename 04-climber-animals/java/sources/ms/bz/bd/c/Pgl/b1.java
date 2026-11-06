package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import com.umeng.analytics.pro.ek;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes4.dex */
public final class b1 {
    private String ah;
    private c1 d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ServiceConnection f4829ms;
    private final Context xr;

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b1.this.d = new c1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            b1.this.d = null;
        }
    }

    public b1(Context context) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3f5022", new byte[]{ek.k, 81, 111, 96});
        this.f4829ms = new pgla();
        this.xr = context;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0078  */
    private String ms(c1 c1Var, String str) {
        Signature[] signatureArr;
        String string;
        String string2;
        String packageName = this.xr.getPackageName();
        if (this.ah == null) {
            try {
                signatureArr = this.xr.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception unused) {
                signatureArr = null;
            }
            if (signatureArr == null || signatureArr.length <= 0) {
                string = null;
            } else {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6611f1", new byte[]{20, 28, 99, 20}));
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    } else {
                        string = null;
                    }
                } catch (Exception unused2) {
                }
            }
            this.ah = string;
        }
        String str2 = this.ah;
        c1Var.getClass();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                parcelObtain.writeInterfaceToken((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c0b15e", new byte[]{113, 61, 28, 11, 2, 119, 121, 5, 50, 113, 60, 61, 1, com.anythink.core.common.s.a.c.b, 4, 123, 100, 95, 26, 78, 98, 55, 31, 108, 46}));
                parcelObtain.writeString(packageName);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str);
                c1Var.f4831ms.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string2 = parcelObtain2.readString();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        } catch (Exception unused3) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dbedb6", new byte[]{122, 112, 31});
            string2 = null;
        }
        return string2;
    }

    public final void ms(pblk.pblb pblbVar) {
        boolean z;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3731c4", new byte[]{1, 52, 78, 75, 83, 55, 112, 4, 119, 111, 98, 58, 78, 5, 113, 34, 57, 24, 86, 105, 48, 48, 65, 65}));
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9d1db5", new byte[]{43, 105, 79, 94, 85, 39, 35, 81, 97, 36, 102, 105, 82, 21, 83, 43, 62}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3db5b6", new byte[]{33, 105, 28, ek.m, 85, 36, 41, 81, 50, 117, 108, 105, 1, 68, 83, 40, 52, 11, 26, 97, 39, 104, 5, 72, 91, 56, 3, com.anythink.core.common.s.a.c.b, 33, 115, 43, 101, 20})));
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc78e3", new byte[]{115, 98, 80, 69, 85, 42, 46, 65, 105, 101, 60, 105, 65, 85, 78, 37, 112, 12, 105, 120, 119, 111, 77, 72, 20, 11, 80, 103, 72, 87, 91, 69, 123, 127, 127, 22, 86, 107, 69, 77}));
        boolean z2 = false;
        try {
            if (this.xr.bindService(intent, this.f4829ms, 1)) {
                try {
                    try {
                        SystemClock.sleep(com.tapsdk.tapad.e.a.f);
                    } catch (Exception unused) {
                    }
                    c1 c1Var = this.d;
                    if (c1Var != null) {
                        String strMs = ms(c1Var, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c4b5af", new byte[]{93, 3, 56, 101}));
                        if (pblbVar != null) {
                            pblbVar.ms(strMs);
                        }
                    }
                    z2 = true;
                } catch (Throwable unused2) {
                    z = true;
                    try {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "54937e", new byte[]{43, 38});
                        if (!z) {
                            return;
                        }
                    } finally {
                        if (z) {
                            this.xr.unbindService(this.f4829ms);
                        }
                    }
                }
            }
            if (!z2) {
            }
        } catch (Throwable unused3) {
            z = false;
        }
    }
}

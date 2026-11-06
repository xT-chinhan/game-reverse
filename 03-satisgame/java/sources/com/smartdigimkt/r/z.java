package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Parcel;
import android.text.TextUtils;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public final Context a;
    public com.smartdigimkt.q.a b;
    public c0 c;
    public final y d = new y(this);

    public z(Context context) {
        this.a = context;
    }

    public final boolean a(com.smartdigimkt.q.b bVar) {
        if (this.a == null) {
            return false;
        }
        this.b = bVar;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            return this.a.bindService(intent, this.d, 1);
        } catch (Throwable th) {
            a("", "bindService failed: " + th.getMessage());
            return false;
        }
    }

    public final void a(String str, String str2) {
        if (this.b != null) {
            if (!TextUtils.isEmpty(str)) {
                this.b.a(str, false);
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "oaid is null or empty.";
            }
            this.b.a(str2);
        }
    }

    public final String a() {
        Signature[] signatureArr;
        String packageName = this.a.getPackageName();
        String string = null;
        try {
            signatureArr = this.a.getPackageManager().getPackageInfo(packageName, 64).signatures;
        } catch (Exception e) {
            e.printStackTrace();
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                    }
                    string = sb.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        a0 a0Var = (a0) this.c;
        a0Var.getClass();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            parcelObtain.writeString(packageName);
            parcelObtain.writeString(string);
            parcelObtain.writeString("OUID");
            a0Var.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}

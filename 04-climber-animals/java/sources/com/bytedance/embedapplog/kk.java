package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class kk implements pl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final pl f498ms;
    private ce<Boolean> xr;

    kk() {
        this(null);
    }

    kk(pl plVar) {
        this.xr = new ce<Boolean>() { // from class: com.bytedance.embedapplog.kk.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.embedapplog.ce
            /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
            public Boolean ms(Object... objArr) {
                long longVersionCode;
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        longVersionCode = packageInfo.getLongVersionCode();
                    } else {
                        longVersionCode = packageInfo.versionCode;
                    }
                    return Boolean.valueOf(longVersionCode >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    oh.ms(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.f498ms = plVar;
    }

    @Override // com.bytedance.embedapplog.pl
    public boolean ms(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolXr = this.xr.xr(context);
        if (this.f498ms != null && !boolXr.booleanValue()) {
            return this.f498ms.ms(context);
        }
        return boolXr.booleanValue();
    }

    @Override // com.bytedance.embedapplog.pl
    public pl.ms xr(final Context context) {
        if (this.f498ms != null && !this.xr.xr(new Object[0]).booleanValue()) {
            return this.f498ms.xr(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new ch(context, intent, new ch.xr<ao, String>() { // from class: com.bytedance.embedapplog.kk.2
            @Override // com.bytedance.embedapplog.ch.xr
            /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
            public ao ms(IBinder iBinder) {
                return ao.ms.ms(iBinder);
            }

            @Override // com.bytedance.embedapplog.ch.xr
            public String ms(ao aoVar) {
                if (aoVar == null) {
                    return null;
                }
                String strAh = kk.this.ah(context);
                if (TextUtils.isEmpty(strAh)) {
                    return null;
                }
                return aoVar.ms(context.getPackageName(), strAh, "OUID");
            }
        }).ms();
        pl.ms msVar = new pl.ms();
        msVar.xr = str;
        return msVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ah(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            signatureArr = packageInfo != null ? packageInfo.signatures : null;
        } catch (Exception e) {
            oh.ms(e);
        }
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(com.tapsdk.tapad.internal.utils.i.b);
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                oh.ms(e2);
            }
        }
        return null;
    }
}

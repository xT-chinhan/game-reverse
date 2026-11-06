package com.byazt.xev;

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
@com.byazt.vzx.pr(pr = {0, 1, 75, 36})
public final class ny implements yb {
    public hw<Boolean> hw;
    public final yb pr;

    public ny() {
        this(null);
    }

    public ny(yb ybVar) {
        this.hw = new hw<Boolean>() { // from class: com.byazt.xev.ny.1
            @Override // com.byazt.xev.hw
            /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
            public Boolean pr(Object... objArr) {
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
                } catch (PackageManager.NameNotFoundException e) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    com.byazt.ec.w.pr(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.pr = ybVar;
    }

    @Override // com.byazt.xev.yb
    public boolean hw(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolHw = this.hw.hw(context);
        if (this.pr != null && !boolHw.booleanValue()) {
            return this.pr.hw(context);
        }
        return boolHw.booleanValue();
    }

    @Override // com.byazt.xev.yb
    public yb.pr hn(final Context context) {
        if (this.pr != null && !this.hw.hw(new Object[0]).booleanValue()) {
            return this.pr.hn(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new z(context, intent, new z.hw<com.byazt.otj.c, String>() { // from class: com.byazt.xev.ny.2
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.otj.c hw(IBinder iBinder) {
                return com.byazt.otj.c.pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public String pr(com.byazt.otj.c cVar) throws Exception {
                if (cVar != null) {
                    String strPr = ny.this.pr(context);
                    if (TextUtils.isEmpty(strPr)) {
                        return null;
                    }
                    return cVar.pr(context.getPackageName(), strPr, "OUID");
                }
                return null;
            }
        }).pr();
        yb.pr prVar = new yb.pr();
        prVar.hw = str;
        return prVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String pr(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                signatureArr = packageInfo.signatures;
            } else {
                signatureArr = null;
            }
        } catch (Exception e) {
            com.byazt.ec.w.pr(e);
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
                    return sb.toString();
                }
            } catch (Exception e2) {
                com.byazt.ec.w.pr(e2);
            }
        }
        return null;
    }
}

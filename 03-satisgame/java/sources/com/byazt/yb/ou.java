package com.byazt.yb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 849})
public final class ou implements hd {
    public final hd n;
    public qg<Boolean> qg;

    public ou() {
        this(null);
    }

    public ou(hd hdVar) {
        this.qg = new qg<Boolean>() { // from class: com.byazt.yb.ou.1
            @Override // com.byazt.yb.qg
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public Boolean n(Object... objArr) {
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
                    com.byazt.km.cp.n(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.n = hdVar;
    }

    @Override // com.byazt.yb.hd
    public boolean qg(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolQg = this.qg.qg(context);
        if (this.n != null && !boolQg.booleanValue()) {
            return this.n.qg(context);
        }
        return boolQg.booleanValue();
    }

    @Override // com.byazt.yb.hd
    public hd.n s(final Context context) {
        if (this.n != null && !this.qg.qg(new Object[0]).booleanValue()) {
            return this.n.s(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new hu(context, intent, new hu.qg<com.byazt.bo.l, String>() { // from class: com.byazt.yb.ou.2
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public com.byazt.bo.l qg(IBinder iBinder) {
                return com.byazt.bo.l.n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public String n(com.byazt.bo.l lVar) throws Exception {
                if (lVar == null) {
                    return null;
                }
                String strN = ou.this.n(context);
                if (TextUtils.isEmpty(strN)) {
                    return null;
                }
                return lVar.n(context.getPackageName(), strN, "OUID");
            }
        }).n();
        hd.n nVar = new hd.n();
        nVar.qg = str;
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            signatureArr = packageInfo != null ? packageInfo.signatures : null;
        } catch (Exception e) {
            com.byazt.km.cp.n(e);
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
                com.byazt.km.cp.n(e2);
            }
        }
        return null;
    }
}

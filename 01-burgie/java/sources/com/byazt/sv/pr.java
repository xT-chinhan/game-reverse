package com.byazt.sv;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.ewn.AbsServerManager;
import com.byazt.lj.hn;
import com.byazt.mrs.c;
import com.byazt.owr.x;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 787, 37})
public class pr extends Fragment {
    public void pr() {
        try {
            startActivityForResult(uc(), 1000);
        } catch (Throwable th) {
            try {
                startActivityForResult(hw(), 1000);
            } catch (Throwable th2) {
                try {
                    startActivityForResult(hn(), 1000);
                } catch (Throwable th3) {
                    startActivityForResult(x(), 1000);
                }
            }
        }
    }

    public Intent hw() {
        Context contextC = c();
        if (contextC == null) {
            return null;
        }
        String packageName = contextC.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(c.hn)) {
                Intent intent = new Intent();
                intent.putExtra(BillingClientConstants.PACKAGE_NAME, packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra(BillingClientConstants.PACKAGE_NAME, packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextC.getPackageName()));
    }

    private Context c() {
        Context contextOf = hn.of();
        if (contextOf == null && getActivity() != null && !getActivity().isFinishing()) {
            return getActivity().getApplicationContext();
        }
        return contextOf;
    }

    public Intent hn() {
        Context contextC = c();
        if (contextC == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextC.getPackageName()));
    }

    private Intent uc() {
        Context contextC = c();
        if (contextC == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextC.getPackageName();
        intent.putExtra(AbsServerManager.PACKAGE_QUERY_BINDER, packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = contextC.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public static Intent x() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (x.pr()) {
            x.pr(true);
        } else {
            x.pr(false);
        }
    }
}

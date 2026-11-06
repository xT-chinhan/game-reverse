package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.ka.d;
import com.ss.android.socialbase.downloader.constants.ka;
import com.ss.android.socialbase.downloader.downloader.ah;

/* JADX INFO: loaded from: classes3.dex */
public class ms extends Fragment {
    public void ms() {
        try {
            try {
                try {
                    startActivityForResult(c(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(ah(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(d(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(xr(), 1000);
        }
    }

    public Intent xr() {
        Context contextKa = ka();
        if (contextKa == null) {
            return null;
        }
        String packageName = contextKa.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(ka.ah)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                return intent2;
            }
            lowerCase.contains("meizu");
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextKa.getPackageName()));
    }

    private Context ka() {
        Context contextK = ah.k();
        return (contextK != null || getActivity() == null || getActivity().isFinishing()) ? contextK : getActivity().getApplicationContext();
    }

    public Intent ah() {
        Context contextKa = ka();
        if (contextKa == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextKa.getPackageName()));
    }

    private Intent c() {
        Context contextKa = ka();
        if (contextKa == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextKa.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = contextKa.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public static Intent d() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (d.ms()) {
            d.ms(true);
        } else {
            d.ms(false);
        }
    }
}

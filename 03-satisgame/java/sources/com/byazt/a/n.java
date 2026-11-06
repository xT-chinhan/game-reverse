package com.byazt.a;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.gc.AbsServerManager;
import com.byazt.j.q;
import com.byazt.sk.l;
import com.byazt.xv.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 19})
public class n extends Fragment {
    public void n() {
        try {
            try {
                try {
                    startActivityForResult(w(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(s(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(q(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(qg(), 1000);
        }
    }

    public Intent qg() {
        Context contextL = l();
        if (contextL == null) {
            return null;
        }
        String packageName = contextL.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(l.s)) {
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
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextL.getPackageName()));
    }

    private Context l() {
        Context contextU = s.u();
        return (contextU != null || getActivity() == null || getActivity().isFinishing()) ? contextU : getActivity().getApplicationContext();
    }

    public Intent s() {
        Context contextL = l();
        if (contextL == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextL.getPackageName()));
    }

    private Intent w() {
        Context contextL = l();
        if (contextL == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextL.getPackageName();
        intent.putExtra(AbsServerManager.PACKAGE_QUERY_BINDER, packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = contextL.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public static Intent q() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (q.n()) {
            q.n(true);
        } else {
            q.n(false);
        }
    }
}

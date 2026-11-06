package com.tapsdk.tapad.stub.activity;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.install.InstallPermissionCompat;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.plugin.utils.SystemBarUtils;
import com.tapsdk.tapad.internal.utils.IntentUtil;
import java.io.File;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class Stub_Install_or_OpenApp_Translucent_Activity extends Activity {
    private static final String EXTRA_FILE_PATH = "install_file_path";
    private static final String EXTRA_SESSION_TOKEN = "install_session_token";
    private static final int OP_REQUEST_INSTALL_PACKAGES = 66;
    private static final String PERMISSION_PREFS = "tapad_install_perm";
    private static final String PRE_AUTHED = "install_perm_pre_authed";
    private static final int REQUEST_INSTALL_PERMISSION = 1001;
    private String filePath = "";
    private Intent pendingInstallIntent;
    private int sessionToken;

    private void fail(int i, String str) {
        DirichletRuntime.getInstance().triggerInstallEvent(2, this.sessionToken, i, -1, -1, str);
        finish();
    }

    private boolean hasInstallPermissionPreAuthed() {
        try {
            return getSharedPreferences(PERMISSION_PREFS, 0).getBoolean(PRE_AUTHED, false);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean isZteOrNubiaDevice() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.contains("zte") || lowerCase.contains("nubia");
    }

    private void launchInstaller(Intent intent) {
        try {
            startActivity(intent);
            DirichletRuntime.getInstance().triggerInstallEvent(1, this.sessionToken, 0, -1, -1, null);
            finish();
        } catch (Throwable th) {
            fail(6, message(th));
        }
    }

    private void markInstallPermissionPreAuthed() {
        try {
            getSharedPreferences(PERMISSION_PREFS, 0).edit().putBoolean(PRE_AUTHED, true).apply();
        } catch (Throwable th) {
        }
    }

    private static String message(Throwable th) {
        String message = th == null ? null : th.getMessage();
        return (message == null || message.length() == 0) ? "android install failure" : message;
    }

    private boolean needsInstallPermissionPreAuth(InstallPermissionCompat.State state) {
        if (Build.VERSION.SDK_INT < 26 || state == InstallPermissionCompat.State.NOT_REQUIRED || state == InstallPermissionCompat.State.NOT_DECLARED || state == InstallPermissionCompat.State.UNKNOWN) {
            return false;
        }
        if (state != InstallPermissionCompat.State.GRANTED) {
            return isZteOrNubiaDevice();
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) getSystemService("appops");
            if (appOpsManager != null) {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getMethod("checkOpRawNoThrow", cls, cls, String.class).invoke(appOpsManager, 66, Integer.valueOf(Process.myUid()), getPackageName())).intValue() == 3;
            }
        } catch (Throwable th) {
        }
        return isZteOrNubiaDevice() && !hasInstallPermissionPreAuthed();
    }

    public static Intent newIntent(Context context, File file, int i) {
        Intent intent = new Intent(context, (Class<?>) Stub_Install_or_OpenApp_Translucent_Activity.class);
        intent.putExtra(EXTRA_SESSION_TOKEN, i);
        intent.putExtra(EXTRA_FILE_PATH, file == null ? "" : file.getAbsolutePath());
        return intent;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        super.onActivityResult(i, i2, intent);
        if (i != 1001 || (intent2 = this.pendingInstallIntent) == null) {
            return;
        }
        this.pendingInstallIntent = null;
        InstallPermissionCompat.State state = InstallPermissionCompat.getState(this);
        if (state == InstallPermissionCompat.State.NOT_DECLARED) {
            fail(4, "REQUEST_INSTALL_PACKAGES is not declared");
            return;
        }
        if (state == InstallPermissionCompat.State.GRANTED || state == InstallPermissionCompat.State.NOT_REQUIRED) {
            markInstallPermissionPreAuthed();
        }
        launchInstaller(intent2);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SystemBarUtils.setupTranslucentAdActivity(this);
        setContentView(R.layout.tapad_install_foward);
        Intent intent = getIntent();
        this.sessionToken = intent != null ? intent.getIntExtra(EXTRA_SESSION_TOKEN, 0) : 0;
        String stringExtra = intent == null ? "" : intent.getStringExtra(EXTRA_FILE_PATH);
        this.filePath = stringExtra;
        if (this.sessionToken <= 0 || stringExtra == null || stringExtra.length() == 0) {
            fail(1, "invalid install request");
            return;
        }
        File file = new File(this.filePath);
        if (!file.isFile()) {
            fail(2, "apk file not found");
            return;
        }
        try {
            Uri installFileUri = IntentUtil.getInstallFileUri(this, file);
            if (installFileUri == null) {
                fail(3, "apk uri unavailable");
                return;
            }
            Intent installTaskIntent = IntentUtil.getInstallTaskIntent(installFileUri);
            if (installTaskIntent == null) {
                fail(5, "system package installer unavailable");
                return;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                installTaskIntent.addFlags(1);
            }
            InstallPermissionCompat.State state = InstallPermissionCompat.getState(this);
            if (state == InstallPermissionCompat.State.NOT_DECLARED) {
                fail(4, "REQUEST_INSTALL_PACKAGES is not declared");
                return;
            }
            if (needsInstallPermissionPreAuth(state)) {
                this.pendingInstallIntent = installTaskIntent;
                try {
                    startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 1001);
                    return;
                } catch (Throwable th) {
                    this.pendingInstallIntent = null;
                    message(th);
                }
            }
            launchInstaller(installTaskIntent);
        } catch (Throwable th2) {
            fail(3, message(th2));
        }
    }
}

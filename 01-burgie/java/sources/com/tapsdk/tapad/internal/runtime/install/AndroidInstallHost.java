package com.tapsdk.tapad.internal.runtime.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ewn.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.internal.install.InstallPermissionCompat;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.file.WasmPrivateFileApi;
import com.tapsdk.tapad.stub.activity.Stub_Install_or_OpenApp_Translucent_Activity;
import java.io.File;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidInstallHost {
    private static final int MAX_REQUEST_CHARS = 65536;
    private static final Pattern PACKAGE_NAME = Pattern.compile("[A-Za-z][A-Za-z0-9_]*(\\.[A-Za-z][A-Za-z0-9_]*)+");
    private static final String TAG = "AndroidInstallHost";
    private final Context context;
    private final Handler mainHandler;
    private final SparseArray<BroadcastReceiver> packageWatches = new SparseArray<>();

    public AndroidInstallHost(Context context, Handler handler) {
        this.context = context.getApplicationContext();
        this.mainHandler = handler;
    }

    private void invokeMediaHook() {
        try {
            DirichletRuntime.getInstance().invokeMediaPreConversionHook("install", null);
        } catch (Throwable th) {
        }
    }

    private boolean isPackageInstalled(String str) {
        if (!validPackageName(str)) {
            return false;
        }
        try {
            return this.context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    private int requestInstall(final int i, String str) {
        if (i > 0 && !TextUtils.isEmpty(str) && str.length() <= 65536) {
            try {
                final File fileResolveFile = resolveFile(new JSONObject(str));
                if (fileResolveFile == null || !fileResolveFile.isFile()) {
                    return -2;
                }
                return this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.install.AndroidInstallHost$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m289lambda$requestInstall$0$comtapsdktapadinternalruntimeinstallAndroidInstallHost(fileResolveFile, i);
                    }
                }) ? 1 : -3;
            } catch (Throwable th) {
            }
        }
        return -1;
    }

    private File resolveFile(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("filePath", "");
        if (!TextUtils.isEmpty(strOptString)) {
            File file = new File(strOptString);
            if (file.isFile() && file.getName().toLowerCase(Locale.US).endsWith(".apk")) {
                return file;
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("cacheQuery");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        return WasmPrivateFileApi.resolveCachedApk(this.context, jSONObjectOptJSONObject);
    }

    private static String safeMessage(Throwable th) {
        String message = th == null ? null : th.getMessage();
        return TextUtils.isEmpty(message) ? "android install host failure" : message;
    }

    private void unregister(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            this.context.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    private void unwatchPackage(int i) {
        BroadcastReceiver broadcastReceiver = this.packageWatches.get(i);
        this.packageWatches.remove(i);
        unregister(broadcastReceiver);
    }

    private static boolean validPackageName(String str) {
        return str != null && str.length() <= 255 && PACKAGE_NAME.matcher(str).matches();
    }

    private boolean watchPackage(final int i, final String str) {
        if (i > 0 && validPackageName(str)) {
            unwatchPackage(i);
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tapsdk.tapad.internal.runtime.install.AndroidInstallHost.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent == null || intent.getData() == null || !str.equals(intent.getData().getSchemeSpecificPart())) {
                        return;
                    }
                    DirichletRuntime.getInstance().triggerInstallEvent(3, i, "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction()) ? 2 : 1, -1, -1, null);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    this.context.registerReceiver(broadcastReceiver, intentFilter, null, this.mainHandler, 4);
                } else {
                    this.context.registerReceiver(broadcastReceiver, intentFilter, null, this.mainHandler);
                }
                this.packageWatches.put(i, broadcastReceiver);
                return true;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public boolean canRequestPackageInstalls() {
        InstallPermissionCompat.State state = InstallPermissionCompat.getState(this.context);
        return state == InstallPermissionCompat.State.NOT_REQUIRED || state == InstallPermissionCompat.State.GRANTED;
    }

    public int execute(int i, int i2, String str, String str2) {
        switch (i) {
            case 1:
                return requestInstall(i2, str);
            case 2:
                return watchPackage(i2, str) ? 1 : 0;
            case 3:
                unwatchPackage(i2);
                return 1;
            case 4:
                return isPackageInstalled(str) ? 1 : 0;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: lambda$requestInstall$0$com-tapsdk-tapad-internal-runtime-install-AndroidInstallHost, reason: not valid java name */
    /* synthetic */ void m289lambda$requestInstall$0$comtapsdktapadinternalruntimeinstallAndroidInstallHost(File file, int i) {
        try {
            invokeMediaHook();
            Intent intentNewIntent = Stub_Install_or_OpenApp_Translucent_Activity.newIntent(this.context, file, i);
            intentNewIntent.addFlags(C.ENCODING_PCM_MU_LAW);
            this.context.startActivity(intentNewIntent);
        } catch (Throwable th) {
            DirichletRuntime.getInstance().triggerInstallEvent(2, i, 7, -1, -1, safeMessage(th));
        }
    }

    public void release() {
        for (int size = this.packageWatches.size() - 1; size >= 0; size--) {
            unregister(this.packageWatches.valueAt(size));
        }
        this.packageWatches.clear();
    }
}

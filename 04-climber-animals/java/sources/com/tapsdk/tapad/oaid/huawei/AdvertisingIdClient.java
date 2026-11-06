package com.tapsdk.tapad.oaid.huawei;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class AdvertisingIdClient {
    private static final String SETTINGS_AD_ID = "pps_oaid";
    private static final String SETTINGS_TRACK_LIMIT = "pps_track_limit";
    private static final String TAG = "AdvertisingIdClient";

    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        public Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public String getId() {
            return this.advertisingId;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    static final class a implements Runnable {
        final Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdvertisingIdClient.requestAdvertisingIdInfo(this.a);
            } catch (Throwable th) {
                Log.w("AdIdClient", "update Id err: " + th.getClass().getSimpleName());
            }
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException {
        try {
            if (!TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "pps_oaid_c"))) {
                Info infoA = b.a(context);
                return infoA != null ? infoA : requestAdvertisingIdInfo(context);
            }
            String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
            String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                updateAdvertisingIdInfo(context);
                return new Info(string, Boolean.valueOf(string2).booleanValue());
            }
            return requestAdvertisingIdInfo(context);
        } catch (Throwable th) {
            Log.w("AdIdClient", "get Id err: " + th.getClass().getSimpleName());
        }
    }

    private static Info getIdInfoViaAIDL(Context context) throws IOException {
        try {
            context.getPackageManager().getPackageInfo(c.a(context), 128);
            com.tapsdk.tapad.oaid.huawei.a aVar = new com.tapsdk.tapad.oaid.huawei.a();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(c.a(context));
            try {
                if (!context.bindService(intent, aVar, 1)) {
                    throw new IOException("bind failed");
                }
                try {
                    com.tapsdk.tapad.oaid.huawei.f.a aVarA = com.tapsdk.tapad.oaid.huawei.f.a.AbstractC0647a.a(aVar.a());
                    Info info = new Info(aVarA.i(), aVarA.m());
                    try {
                        context.unbindService(aVar);
                    } catch (Throwable th) {
                        Log.w("AdIdClient", "unbind " + th.getClass().getSimpleName());
                    }
                    return info;
                } catch (RemoteException unused) {
                    throw new IOException("bind hms service RemoteException");
                } catch (InterruptedException unused2) {
                    throw new IOException("bind hms service InterruptedException");
                }
            } catch (Throwable th2) {
                try {
                    context.unbindService(aVar);
                } catch (Throwable th3) {
                    Log.w("AdIdClient", "unbind " + th3.getClass().getSimpleName());
                }
                throw th2;
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Service not found");
        } catch (Exception unused4) {
            throw new IOException("Service not found: Exception");
        }
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo(c.a(context), 128);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(c.a(context));
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) throws IOException {
        if (b.c(context)) {
            Log.i(TAG, "requestAdvertisingIdInfo via provider");
            return b.b(context);
        }
        Log.i(TAG, "requestAdvertisingIdInfo via aidl");
        return getIdInfoViaAIDL(context);
    }

    private static void updateAdvertisingIdInfo(Context context) {
        e.a.execute(new a(context));
    }

    public static boolean verifyAdId(Context context, String str, boolean z) throws AdIdVerifyException {
        try {
            Info infoRequestAdvertisingIdInfo = requestAdvertisingIdInfo(context);
            if (infoRequestAdvertisingIdInfo != null) {
                return TextUtils.equals(str, infoRequestAdvertisingIdInfo.getId()) && z == infoRequestAdvertisingIdInfo.isLimitAdTrackingEnabled();
            }
            Log.w("AdIdClient", "info is null");
            return false;
        } catch (Throwable unused) {
            throw new AdIdVerifyException("Something wrong with verification, please try later.");
        }
    }
}

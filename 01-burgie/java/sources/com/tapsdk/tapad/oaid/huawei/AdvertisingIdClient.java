package com.tapsdk.tapad.oaid.huawei;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.tapsdk.tapad.oaid.huawei.aidl.OpenDeviceIdentifierService;
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

    public static Info getAdvertisingIdInfo(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                if (!TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "pps_oaid_c"))) {
                    Info infoA = HuaweiB.a(context);
                    return infoA != null ? infoA : requestAdvertisingIdInfo(context);
                }
                String string = Settings.Global.getString(context.getContentResolver(), SETTINGS_AD_ID);
                String string2 = Settings.Global.getString(context.getContentResolver(), SETTINGS_TRACK_LIMIT);
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    updateAdvertisingIdInfo(context);
                    return new Info(string, Boolean.valueOf(string2).booleanValue());
                }
            } catch (Throwable th) {
            }
        }
        return requestAdvertisingIdInfo(context);
    }

    private static Info getIdInfoViaAIDL(Context context) throws IOException {
        try {
            context.getPackageManager().getPackageInfo(HuaweiC.a(context), 128);
            HuaweiA huaweiA = new HuaweiA();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(HuaweiC.a(context));
            try {
                if (!context.bindService(intent, huaweiA, 1)) {
                    throw new IOException("bind failed");
                }
                try {
                    try {
                        OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(huaweiA.a());
                        Info info = new Info(openDeviceIdentifierServiceAsInterface.getOaid(), openDeviceIdentifierServiceAsInterface.isOaidTrackLimited());
                        try {
                            context.unbindService(huaweiA);
                            return info;
                        } catch (Throwable th) {
                            return info;
                        }
                    } catch (InterruptedException e) {
                        throw new IOException("bind hms service InterruptedException");
                    }
                } catch (RemoteException e2) {
                    throw new IOException("bind hms service RemoteException");
                }
            } catch (Throwable th2) {
                try {
                    context.unbindService(huaweiA);
                } catch (Throwable th3) {
                }
                throw th2;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            throw new IOException("Service not found");
        } catch (Exception e4) {
            throw new IOException("Service not found: Exception");
        }
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo(HuaweiC.a(context), 128);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(HuaweiC.a(context));
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (PackageManager.NameNotFoundException | Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Info requestAdvertisingIdInfo(Context context) {
        return HuaweiB.c(context) ? HuaweiB.b(context) : getIdInfoViaAIDL(context);
    }

    private static void updateAdvertisingIdInfo(final Context context) {
        HuaweiE.a.execute(new Runnable(context) { // from class: com.tapsdk.tapad.oaid.huawei.AdvertisingIdClient$AdvertisingIdClient$1
            final Context a;

            {
                this.a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdvertisingIdClient.requestAdvertisingIdInfo(this.a);
                } catch (Throwable th) {
                }
            }
        });
    }
}

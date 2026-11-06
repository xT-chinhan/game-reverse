package com.smartdigimkt.u0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PowerManager;
import com.smartdigimkt.z0.u;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final int a;

    public a(int i) {
        this.a = i;
    }

    public final boolean a(Context context) {
        boolean zIsActiveNetworkMetered;
        boolean z;
        int i = this.a & 7;
        if (i != 0) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            int i2 = u.a;
            if (i2 >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null) {
                    return false;
                }
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (!(!(networkCapabilities == null || !networkCapabilities.hasCapability(16)))) {
                    return false;
                }
            }
            if (i != 1) {
                if (i == 3) {
                    z = !activeNetworkInfo.isRoaming();
                } else {
                    if (i2 >= 16) {
                        zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
                    } else {
                        int type = activeNetworkInfo.getType();
                        zIsActiveNetworkMetered = (type == 1 || type == 7 || type == 9) ? false : true;
                    }
                    if (i == 2) {
                        z = !zIsActiveNetworkMetered;
                    } else {
                        if (i != 4) {
                            throw new IllegalStateException();
                        }
                        z = zIsActiveNetworkMetered;
                    }
                }
                if (!z) {
                    return false;
                }
            }
        }
        if ((this.a & 16) != 0) {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return false;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            if (intExtra != 2 && intExtra != 5) {
                return false;
            }
        }
        if ((this.a & 8) != 0) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            int i3 = u.a;
            if (i3 >= 23) {
                if (powerManager.isDeviceIdleMode()) {
                    return false;
                }
            } else if (i3 >= 20) {
                if (powerManager.isInteractive()) {
                    return false;
                }
            } else if (powerManager.isScreenOn()) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return super.toString();
    }
}

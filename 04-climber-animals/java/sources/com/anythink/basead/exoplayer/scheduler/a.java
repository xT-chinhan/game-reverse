package com.anythink.basead.exoplayer.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PowerManager;
import com.anythink.basead.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final int f = 8;
    private static final int g = 16;
    private static final int h = 7;
    private static final String i = "Requirements";
    private static final String[] j = null;
    private final int k;

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.scheduler.a$a, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0038a {
    }

    private static void e() {
    }

    private a(int i2, boolean z, boolean z2) {
        this(i2 | (z ? 16 : 0) | (z2 ? 8 : 0));
    }

    public a(int i2) {
        this.k = i2;
    }

    public final int a() {
        return this.k & 7;
    }

    public final boolean b() {
        return (this.k & 16) != 0;
    }

    public final boolean c() {
        return (this.k & 8) != 0;
    }

    public final int d() {
        return this.k;
    }

    private boolean c(Context context) {
        if (!b()) {
            return true;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean d(Context context) {
        if (!c()) {
            return true;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (af.a >= 23) {
            return !powerManager.isDeviceIdleMode();
        }
        if (af.a >= 20) {
            return !powerManager.isInteractive();
        }
        return !powerManager.isScreenOn();
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        if (af.a < 23) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return !(networkCapabilities == null || !networkCapabilities.hasCapability(16));
    }

    private static boolean a(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        if (af.a >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }

    public final String toString() {
        return super.toString();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    /* JADX WARN: Code duplicated, block: B:52:0x007d  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ac  */
    public final boolean a(Context context) {
        boolean zIsActiveNetworkMetered;
        boolean z;
        Intent intentRegisterReceiver;
        int intExtra;
        boolean z2;
        int i2 = this.k & 7;
        if (i2 != 0) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                zIsActiveNetworkMetered = false;
            } else {
                if (af.a >= 23) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null) {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                        if (!(networkCapabilities == null || !networkCapabilities.hasCapability(16))) {
                            z = true;
                        }
                    }
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    zIsActiveNetworkMetered = false;
                } else if (i2 == 1) {
                    zIsActiveNetworkMetered = true;
                } else if (i2 == 3) {
                    if (activeNetworkInfo.isRoaming()) {
                        zIsActiveNetworkMetered = false;
                    } else {
                        zIsActiveNetworkMetered = true;
                    }
                } else {
                    if (af.a >= 16) {
                        zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
                    } else {
                        int type = activeNetworkInfo.getType();
                        zIsActiveNetworkMetered = (type == 1 || type == 7 || type == 9) ? false : true;
                    }
                    if (i2 == 2) {
                        if (zIsActiveNetworkMetered) {
                            zIsActiveNetworkMetered = false;
                        } else {
                            zIsActiveNetworkMetered = true;
                        }
                    } else if (i2 != 4) {
                        throw new IllegalStateException();
                    }
                }
            }
        } else {
            zIsActiveNetworkMetered = true;
        }
        if (zIsActiveNetworkMetered) {
            if (!b() || ((intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) != null && ((intExtra = intentRegisterReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5))) {
                if (c()) {
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (af.a < 23 ? af.a < 20 ? powerManager.isScreenOn() : powerManager.isInteractive() : powerManager.isDeviceIdleMode()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0027  */
    private boolean b(Context context) {
        boolean z;
        boolean zIsActiveNetworkMetered;
        int i2 = this.k & 7;
        if (i2 == 0) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        if (af.a >= 23) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (!(networkCapabilities == null || !networkCapabilities.hasCapability(16))) {
                    z = true;
                }
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 3) {
            return !activeNetworkInfo.isRoaming();
        }
        if (af.a >= 16) {
            zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
        } else {
            int type = activeNetworkInfo.getType();
            zIsActiveNetworkMetered = (type == 1 || type == 7 || type == 9) ? false : true;
        }
        if (i2 == 2) {
            return !zIsActiveNetworkMetered;
        }
        if (i2 == 4) {
            return zIsActiveNetworkMetered;
        }
        throw new IllegalStateException();
    }
}

package com.byazt.mx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 20})
public class hn {
    public static volatile hn pr = null;
    public boolean c;
    public Network hn;
    public ConnectivityManager hw;
    public hw x;

    public interface pr {
        void pr(Network network);
    }

    public static hn pr(Context context) {
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null) {
                    pr = new hn(context);
                }
            }
        }
        return pr;
    }

    private hn(Context context) {
        try {
            this.hw = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
        }
    }

    private static boolean pr(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public int pr() {
        NetworkCapabilities networkCapabilities;
        NetworkInfo activeNetworkInfo = null;
        try {
            ConnectivityManager connectivityManager = this.hw;
            if (connectivityManager != null) {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = this.hw.getActiveNetwork();
                    if (activeNetwork == null || (networkCapabilities = this.hw.getNetworkCapabilities(activeNetwork)) == null) {
                        return 0;
                    }
                    boolean zHasTransport = networkCapabilities.hasTransport(4);
                    boolean zHasTransport2 = networkCapabilities.hasTransport(0);
                    boolean zHasTransport3 = networkCapabilities.hasTransport(1);
                    if (zHasTransport) {
                        return 4;
                    }
                    if (pr(this.hw) && zHasTransport3) {
                        return 3;
                    }
                    if (zHasTransport3) {
                        return 1;
                    }
                    return zHasTransport2 ? 2 : 5;
                }
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return pr(this.hw) ? 3 : 1;
                }
                return type == 0 ? 2 : 5;
            }
            return 0;
        } catch (Exception e) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 506})
    static class hw extends ConnectivityManager.NetworkCallback {
        public AtomicBoolean hn = new AtomicBoolean(false);
        public final hn hw;
        public pr pr;

        public hw(pr prVar, hn hnVar) {
            this.pr = prVar;
            this.hw = hnVar;
        }

        public void pr(pr prVar) {
            this.pr = prVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.hn.compareAndSet(false, true)) {
                try {
                    this.hw.hn = network;
                    this.pr.pr(network);
                    this.hw.c = false;
                } catch (Exception e) {
                    this.hw.hn = null;
                    this.pr.pr(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.hw.c = true;
        }
    }

    public void pr(pr prVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.hw;
        if (connectivityManager == null) {
            prVar.pr(null);
            return;
        }
        Network network = this.hn;
        if (network != null && !this.c && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            prVar.pr(this.hn);
            return;
        }
        hw hwVar = this.x;
        if (hwVar != null) {
            hwVar.pr(prVar);
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        hw hwVar2 = new hw(prVar, pr);
        this.x = hwVar2;
        try {
            this.hw.requestNetwork(networkRequestBuild, hwVar2);
        } catch (Exception e) {
            prVar.pr(null);
        }
    }

    public synchronized void hw() {
        ConnectivityManager connectivityManager = this.hw;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                hw hwVar = this.x;
                if (hwVar == null) {
                    this.x = null;
                    this.hn = null;
                } else {
                    connectivityManager.unregisterNetworkCallback(hwVar);
                    this.x = null;
                    this.hn = null;
                }
            } catch (Throwable th) {
                this.x = null;
                this.hn = null;
                throw th;
            }
        } catch (Exception e) {
            this.x = null;
        }
    }
}

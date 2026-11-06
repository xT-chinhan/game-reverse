package com.bytedance.sdk.openadsdk.core.pc.ms;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.bytedance.sdk.component.utils.sl;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ah f3273ms;
    private Network ah;
    private xr d;
    private boolean ka;
    private ConnectivityManager xr;

    public interface ms {
        void ms(Network network);
    }

    public static ah ms(Context context) {
        if (f3273ms == null) {
            synchronized (ah.class) {
                if (f3273ms == null) {
                    f3273ms = new ah(context);
                }
            }
        }
        return f3273ms;
    }

    private ah(Context context) {
        try {
            this.xr = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    private static boolean ms(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int ms() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.xr;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.xr.getActiveNetwork()) == null || (networkCapabilities = this.xr.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(4);
            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
            boolean zHasTransport3 = networkCapabilities.hasTransport(1);
            if (zHasTransport) {
                return 4;
            }
            if (ms(this.xr) && zHasTransport3) {
                return 3;
            }
            if (zHasTransport3) {
                return 1;
            }
            return zHasTransport2 ? 2 : 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    static class xr extends ConnectivityManager.NetworkCallback {
        private AtomicBoolean ah = new AtomicBoolean(false);

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ms f3274ms;
        private final ah xr;

        public xr(ms msVar, ah ahVar) {
            this.f3274ms = msVar;
            this.xr = ahVar;
        }

        public void ms(ms msVar) {
            this.f3274ms = msVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.ah.compareAndSet(false, true)) {
                try {
                    this.xr.ah = network;
                    this.f3274ms.ms(network);
                    this.xr.ka = false;
                } catch (Exception unused) {
                    this.xr.ah = null;
                    this.f3274ms.ms(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.xr.ka = true;
        }
    }

    public void ms(ms msVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.xr;
        if (connectivityManager == null) {
            msVar.ms(null);
            return;
        }
        Network network = this.ah;
        if (network != null && !this.ka && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            msVar.ms(this.ah);
            return;
        }
        xr xrVar = this.d;
        if (xrVar != null) {
            xrVar.ms(msVar);
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        xr xrVar2 = new xr(msVar, f3273ms);
        this.d = xrVar2;
        try {
            this.xr.requestNetwork(networkRequestBuild, xrVar2);
        } catch (Exception unused) {
            msVar.ms(null);
        }
    }

    public synchronized void xr() {
        ConnectivityManager connectivityManager = this.xr;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                xr xrVar = this.d;
                if (xrVar == null) {
                    this.d = null;
                    this.ah = null;
                } else {
                    connectivityManager.unregisterNetworkCallback(xrVar);
                    this.d = null;
                    this.ah = null;
                }
            } catch (Throwable th) {
                this.d = null;
                this.ah = null;
                throw th;
            }
        } catch (Exception unused) {
            this.d = null;
            this.ah = null;
        }
    }
}

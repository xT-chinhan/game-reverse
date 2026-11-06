package com.byazt.tv;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 970, 8})
public class s {
    public static volatile s n;
    public boolean l;
    public qg q;
    public ConnectivityManager qg;
    public Network s;

    public interface n {
        void n(Network network);
    }

    public static s n(Context context) {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s(context);
                }
            }
        }
        return n;
    }

    private s(Context context) {
        try {
            this.qg = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
    }

    private static boolean n(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int n() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.qg;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.qg.getActiveNetwork()) == null || (networkCapabilities = this.qg.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(4);
            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
            boolean zHasTransport3 = networkCapabilities.hasTransport(1);
            if (zHasTransport) {
                return 4;
            }
            if (n(this.qg) && zHasTransport3) {
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

    @com.byazt.cp.n(n = {0, 1, 970, 782})
    static class qg extends ConnectivityManager.NetworkCallback {
        public n n;
        public final s qg;
        public AtomicBoolean s = new AtomicBoolean(false);

        public qg(n nVar, s sVar) {
            this.n = nVar;
            this.qg = sVar;
        }

        public void n(n nVar) {
            this.n = nVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.s.compareAndSet(false, true)) {
                try {
                    this.qg.s = network;
                    this.n.n(network);
                    this.qg.l = false;
                } catch (Exception unused) {
                    this.qg.s = null;
                    this.n.n(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.qg.l = true;
        }
    }

    public void n(n nVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.qg;
        if (connectivityManager == null) {
            nVar.n(null);
            return;
        }
        Network network = this.s;
        if (network != null && !this.l && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            nVar.n(this.s);
            return;
        }
        qg qgVar = this.q;
        if (qgVar != null) {
            qgVar.n(nVar);
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        qg qgVar2 = new qg(nVar, n);
        this.q = qgVar2;
        try {
            this.qg.requestNetwork(networkRequestBuild, qgVar2);
        } catch (Exception unused) {
            nVar.n(null);
        }
    }

    public synchronized void qg() {
        ConnectivityManager connectivityManager = this.qg;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                qg qgVar = this.q;
                if (qgVar == null) {
                    this.q = null;
                    this.s = null;
                } else {
                    connectivityManager.unregisterNetworkCallback(qgVar);
                    this.q = null;
                    this.s = null;
                }
            } catch (Throwable th) {
                this.q = null;
                this.s = null;
                throw th;
            }
        } catch (Exception unused) {
            this.q = null;
            this.s = null;
        }
    }
}

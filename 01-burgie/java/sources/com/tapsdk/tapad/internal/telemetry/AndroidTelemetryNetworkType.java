package com.tapsdk.tapad.internal.telemetry;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import com.tapsdk.tapad.internal.utils.NetworkUtils;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidTelemetryNetworkType {
    private static final AndroidTelemetryNetworkType INSTANCE = new AndroidTelemetryNetworkType();
    private volatile int currentType;
    private boolean started;

    private AndroidTelemetryNetworkType() {
    }

    public static AndroidTelemetryNetworkType getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(Context context) {
        this.currentType = NetworkUtils.getNetworkType(context);
    }

    public int current() {
        return this.currentType;
    }

    public synchronized void start(final Context context) {
        if (!this.started && context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            this.started = true;
            refresh(context);
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.tapsdk.tapad.internal.telemetry.AndroidTelemetryNetworkType.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            AndroidTelemetryNetworkType.this.refresh(context);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            AndroidTelemetryNetworkType.this.refresh(context);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            AndroidTelemetryNetworkType.this.refresh(context);
                        }
                    };
                    if (Build.VERSION.SDK_INT >= 24) {
                        connectivityManager.registerDefaultNetworkCallback(networkCallback);
                        return;
                    }
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), networkCallback);
                }
            } catch (Throwable th) {
            }
        }
    }
}

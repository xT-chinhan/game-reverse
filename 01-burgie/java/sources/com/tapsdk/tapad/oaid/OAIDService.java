package com.tapsdk.tapad.oaid;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class OAIDService implements ServiceConnection {
    private final RemoteCaller caller;
    private final Context context;
    private final IGetter getter;

    @FunctionalInterface
    public interface RemoteCaller {
        String callRemoteInterface(IBinder iBinder);
    }

    private OAIDService(Context context, IGetter iGetter, RemoteCaller remoteCaller) {
        if (context instanceof Application) {
            this.context = context;
        } else {
            this.context = context.getApplicationContext();
        }
        this.getter = iGetter;
        this.caller = remoteCaller;
    }

    public static void bind(Context context, Intent intent, IGetter iGetter, RemoteCaller remoteCaller) {
        new OAIDService(context, iGetter, remoteCaller).bind(intent);
    }

    private static String serviceName(ComponentName componentName) {
        return componentName != null ? componentName.getClassName() : "<unknown>";
    }

    /* JADX INFO: renamed from: lambda$onServiceConnected$0$com-tapsdk-tapad-oaid-OAIDService, reason: not valid java name */
    /* synthetic */ void m394lambda$onServiceConnected$0$comtapsdktapadoaidOAIDService(IBinder iBinder, ComponentName componentName) {
        try {
            try {
                String strCallRemoteInterface = this.caller.callRemoteInterface(iBinder);
                if (TextUtils.isEmpty(strCallRemoteInterface)) {
                    throw new OAIDException("OAID/AAID acquire failed");
                }
                this.getter.onOAIDGetComplete(strCallRemoteInterface);
                try {
                    this.context.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + serviceName(componentName));
                } catch (Exception e) {
                    OAIDLog.print(e);
                }
            } catch (Exception e2) {
                this.getter.onOAIDGetError(e2);
                try {
                    this.context.unbindService(this);
                    OAIDLog.print("Service has been unbound: " + serviceName(componentName));
                } catch (Exception e3) {
                    OAIDLog.print(e3);
                }
            }
        } catch (Throwable th) {
            try {
                this.context.unbindService(this);
                OAIDLog.print("Service has been unbound: " + serviceName(componentName));
            } catch (Exception e4) {
                OAIDLog.print(e4);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
        OAIDLog.print("Service has been connected: " + serviceName(componentName));
        if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.oaid.OAIDService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m394lambda$onServiceConnected$0$comtapsdktapadoaidOAIDService(iBinder, componentName);
            }
        })) {
            return;
        }
        this.getter.onOAIDGetError(new OAIDException("OAID executor is saturated"));
        try {
            this.context.unbindService(this);
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        OAIDLog.print("Service has been disconnected: " + serviceName(componentName));
    }

    private void bind(Intent intent) {
        try {
            if (!this.context.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            OAIDLog.print("Service has been bound: " + intent);
        } catch (Exception e) {
            this.getter.onOAIDGetError(e);
        }
    }
}

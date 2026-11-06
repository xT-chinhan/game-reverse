package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: loaded from: classes3.dex */
public class OpenDeviceId {
    private static String c = "OpenDeviceId library";
    private static boolean d = false;
    private IDeviceidInterface b;
    private ServiceConnection e;
    private Context a = null;
    private CallBack f = null;

    public interface CallBack<T> {
        void a(T t, OpenDeviceId openDeviceId);
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.f = callBack;
        this.e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                OpenDeviceId.this.b = IDeviceidInterface.Stub.a(iBinder);
                if (OpenDeviceId.this.f != null) {
                    OpenDeviceId.this.f.a("Deviceid Service Connected", OpenDeviceId.this);
                }
                OpenDeviceId.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                OpenDeviceId.this.b = null;
                OpenDeviceId.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.e, 1)) {
            a("bindService Successful!");
            return 1;
        }
        a("bindService Failed!");
        return -1;
    }

    public String a() {
        if (this.a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.b != null) {
                return this.b.a();
            }
            return null;
        } catch (RemoteException e) {
            b("getOAID error, RemoteException!");
            e.printStackTrace();
            return null;
        }
    }

    public String b() {
        if (this.a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.b != null) {
                return this.b.b();
            }
            return null;
        } catch (RemoteException e) {
            b("getUDID error, RemoteException!");
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            b("getUDID error, Exception!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.b.c();
        } catch (RemoteException e) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        if (this.a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.a.getPackageName();
        a("liufeng, getVAID package：" + packageName);
        if (packageName != null && !packageName.equals("")) {
            try {
                if (this.b != null) {
                    return this.b.a(packageName);
                }
                return null;
            } catch (RemoteException e) {
                b("getVAID error, RemoteException!");
                e.printStackTrace();
                return null;
            }
        }
        a("input package is null!");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0056 A[Catch: RemoteException -> 0x004b, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x004b, blocks: (B:14:0x0042, B:19:0x004e, B:21:0x0056), top: B:31:0x0042 }] */
    public String e() {
        if (this.a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = this.a.getPackageName();
        a("liufeng, getAAID package：" + packageName);
        String str = null;
        if (packageName != null && !packageName.equals("")) {
            try {
                if (this.b == null) {
                    return null;
                }
                String strB = this.b.b(packageName);
                if (strB != null) {
                    try {
                        if ("".equals(strB)) {
                            if (this.b.c(packageName)) {
                                return this.b.b(packageName);
                            }
                        }
                    } catch (RemoteException e) {
                        str = strB;
                    }
                } else if (this.b.c(packageName)) {
                    return this.b.b(packageName);
                }
                return strB;
            } catch (RemoteException e2) {
            }
            b("getAAID error, RemoteException!");
            return str;
        }
        a("input package is null!");
        return null;
    }

    public void f() {
        try {
            this.a.unbindService(this.e);
            a("unBind Service successful");
        } catch (IllegalArgumentException e) {
            b("unBind Service exception");
        }
        this.b = null;
    }

    public void a(boolean z) {
        d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (d) {
            Log.i(c, str);
        }
    }

    private void b(String str) {
        if (d) {
            Log.e(c, str);
        }
    }
}

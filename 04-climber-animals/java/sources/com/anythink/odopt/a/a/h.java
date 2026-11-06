package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static final String a = "OaidAidlUtil";
    private static final String b = "com.huawei.hwid";
    private static final String c = "com.uodis.opendevice.OPENIDS_SERVICE";
    private Context d;
    private ServiceConnection e;
    private g f;
    private com.anythink.odopt.a.a g;

    public h(Context context) {
        this.d = context;
    }

    private void a() {
        com.anythink.odopt.a.a aVar;
        if (this.d == null) {
            com.anythink.odopt.a.a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.a("mContext is null.");
                return;
            }
            return;
        }
        this.e = new a(this, (byte) 0);
        Intent intent = new Intent(c);
        intent.setPackage(b);
        if (this.d.bindService(intent, this.e, 1) || (aVar = this.g) == null) {
            return;
        }
        aVar.a("Service binding failed.");
    }

    private void b() {
        ServiceConnection serviceConnection;
        Context context = this.d;
        if (context == null || (serviceConnection = this.e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
        this.f = null;
        this.d = null;
        this.g = null;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        com.anythink.odopt.a.a aVar2;
        this.g = aVar;
        if (this.d == null) {
            if (aVar != null) {
                aVar.a("mContext is null.");
                return;
            }
            return;
        }
        this.e = new a(this, (byte) 0);
        Intent intent = new Intent(c);
        intent.setPackage(b);
        if (this.d.bindService(intent, this.e, 1) || (aVar2 = this.g) == null) {
            return;
        }
        aVar2.a("Service binding failed.");
    }

    private final class a implements ServiceConnection {
        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        private a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.f = g.a.a(iBinder);
            try {
                if (h.this.f != null) {
                    try {
                        if (h.this.g != null) {
                            h.this.g.a(h.this.f.a(), h.this.f.b());
                        }
                    } catch (RemoteException e) {
                        if (h.this.g != null) {
                            h.this.g.a(e.getMessage());
                        }
                    } catch (Exception e2) {
                        if (h.this.g != null) {
                            h.this.g.a(e2.getMessage());
                        }
                    }
                }
            } finally {
                h.c(h.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            h.this.f = null;
        }
    }

    static /* synthetic */ void c(h hVar) {
        ServiceConnection serviceConnection;
        Context context = hVar.d;
        if (context == null || (serviceConnection = hVar.e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
        hVar.f = null;
        hVar.d = null;
        hVar.g = null;
    }
}

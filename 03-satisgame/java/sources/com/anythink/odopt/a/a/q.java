package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    private static final String a = "action.com.oplus.stdid.ID_SERVICE";
    private static final String b = "com.coloros.mcs";
    private static final String c = "com.oplus.stdid.IdentifyService";
    private Context d;
    private r e;
    private com.anythink.odopt.a.a f;
    private String g;
    private ServiceConnection h;

    public q(Context context) {
        this.d = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        this.f = aVar;
        this.h = new a(this, (byte) 0);
        try {
            Intent intent = new Intent(a);
            intent.setComponent(new ComponentName(b, c));
            if (this.d.bindService(intent, this.h, 1)) {
                return;
            }
            aVar.a("Service binding failed.");
        } catch (Throwable th) {
            aVar.a("Bind Service failed: " + th.getMessage());
        }
    }

    private void a() {
        try {
            Context context = this.d;
            if (context == null) {
                com.anythink.odopt.a.a aVar = this.f;
                if (aVar != null) {
                    aVar.a("context is null.");
                }
                b();
                return;
            }
            if (this.e == null) {
                com.anythink.odopt.a.a aVar2 = this.f;
                if (aVar2 != null) {
                    aVar2.a("realmeOaidInterface is null.");
                }
                b();
                return;
            }
            String packageName = context.getPackageName();
            if (this.g == null) {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.d.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
                }
                this.g = sb.toString();
            }
            String strA = this.e.a(packageName, this.g, "OUID");
            com.anythink.odopt.a.a aVar3 = this.f;
            if (aVar3 != null) {
                aVar3.a(strA, false);
            }
            b();
        } catch (Throwable th) {
            try {
                com.anythink.odopt.a.a aVar4 = this.f;
                if (aVar4 != null) {
                    aVar4.a("realme get oaid failed: " + th.getMessage());
                }
            } finally {
                b();
            }
        }
    }

    private void b() {
        Context context = this.d;
        if (context == null) {
            return;
        }
        try {
            context.unbindService(this.h);
        } catch (Throwable unused) {
        }
        this.e = null;
    }

    private class a implements ServiceConnection {
        private a() {
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            q.this.e = r.a.a(iBinder);
            q.a(q.this);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            q.this.e = null;
        }
    }

    static /* synthetic */ void a(q qVar) {
        try {
            Context context = qVar.d;
            if (context == null) {
                com.anythink.odopt.a.a aVar = qVar.f;
                if (aVar != null) {
                    aVar.a("context is null.");
                }
                qVar.b();
                return;
            }
            if (qVar.e == null) {
                com.anythink.odopt.a.a aVar2 = qVar.f;
                if (aVar2 != null) {
                    aVar2.a("realmeOaidInterface is null.");
                }
                qVar.b();
                return;
            }
            String packageName = context.getPackageName();
            if (qVar.g == null) {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(qVar.d.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
                }
                qVar.g = sb.toString();
            }
            String strA = qVar.e.a(packageName, qVar.g, "OUID");
            com.anythink.odopt.a.a aVar3 = qVar.f;
            if (aVar3 != null) {
                aVar3.a(strA, false);
            }
            qVar.b();
        } catch (Throwable th) {
            try {
                com.anythink.odopt.a.a aVar4 = qVar.f;
                if (aVar4 != null) {
                    aVar4.a("realme get oaid failed: " + th.getMessage());
                }
            } finally {
                qVar.b();
            }
        }
    }
}

package com.anythink.odopt.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.anythink.core.common.u.af;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final String a = "k";
    private Context b;
    private ServiceConnection c;
    private j d;
    private com.anythink.odopt.a.a e;

    public k(Context context) {
        this.b = context;
    }

    public final void a(com.anythink.odopt.a.a aVar) {
        com.anythink.odopt.a.a aVar2;
        byte b2 = 0;
        try {
            if (this.b != null) {
                String str = (String) Class.forName(af.b("frp1klkrqru1dgv1lghqwlilhu1DgyhuwlvlqjLgFolhqw'Lqir")).getDeclaredField("id").get(Class.forName(af.b("frp1klkrqru1dgv1lghqwlilhu1DgyhuwlvlqjLgFolhqw")).getMethod(af.b("jhwDgyhuwlvlqjLgLqir"), Context.class).invoke(null, this.b.getApplicationContext()));
                if (!TextUtils.isEmpty(str)) {
                    aVar.a(str, false);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        this.e = aVar;
        if (this.b == null) {
            return;
        }
        this.c = new b(this, b2);
        try {
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (this.b.bindService(intent, this.c, 1) || (aVar2 = this.e) == null) {
                return;
            }
            aVar2.a("Service binding failed.");
        } catch (Throwable th) {
            com.anythink.odopt.a.a aVar3 = this.e;
            if (aVar3 != null) {
                aVar3.a(th.getMessage());
            }
        }
    }

    private void a() {
        com.anythink.odopt.a.a aVar;
        if (this.b == null) {
            return;
        }
        this.c = new b(this, (byte) 0);
        try {
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (this.b.bindService(intent, this.c, 1) || (aVar = this.e) == null) {
                return;
            }
            aVar.a("Service binding failed.");
        } catch (Throwable th) {
            com.anythink.odopt.a.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.a(th.getMessage());
            }
        }
    }

    private void b() {
        ServiceConnection serviceConnection;
        Context context = this.b;
        if (context == null || (serviceConnection = this.c) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
        this.d = null;
        this.b = null;
        this.e = null;
    }

    private final class b implements ServiceConnection {
        private b() {
        }

        /* synthetic */ b(k kVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                k.this.d = j.a.a(iBinder);
                if (k.this.d != null) {
                    k.this.d.a(new a(k.this, (byte) 0));
                }
            } catch (Throwable th) {
                try {
                    if (k.this.e != null) {
                        k.this.e.a("onServiceConnected() >>> failed: " + th.getMessage());
                    }
                } finally {
                    k.c(k.this);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            k.this.d = null;
        }
    }

    private final class a extends i.a {
        @Override // com.anythink.odopt.a.a.i
        public final void a(int i, long j, boolean z, float f, double d, String str) {
        }

        /* synthetic */ a(k kVar, byte b) {
            this();
        }

        private a() {
        }

        @Override // com.anythink.odopt.a.a.i
        public final void a(int i, Bundle bundle) {
            if (i != 0 || bundle == null) {
                return;
            }
            String string = bundle.getString("oa_id_flag");
            if (k.this.e != null) {
                if (!TextUtils.isEmpty(string)) {
                    k.this.e.a(string, false);
                } else {
                    k.this.e.a("oaid is empty.");
                }
            }
        }
    }

    static /* synthetic */ void c(k kVar) {
        ServiceConnection serviceConnection;
        Context context = kVar.b;
        if (context == null || (serviceConnection = kVar.c) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
        kVar.d = null;
        kVar.b = null;
        kVar.e = null;
    }
}

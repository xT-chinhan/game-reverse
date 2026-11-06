package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
public final class pbls {
    private final Context ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    pblt f4858ms;
    ServiceConnection xr = new pgla();

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pbls.this.f4858ms = new pblt(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pbls(Context context) {
        this.ah = context;
    }

    public final void ms(pblk.pblb pblbVar) {
        Intent intent = new Intent();
        intent.setClassName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "170752", new byte[]{35, 58, 78, ek.k, ek.n, 48, 59, 88, 101, 98, 54, 60, com.anythink.core.common.s.a.c.b, 70, 3, 33, 33, 19, 115, 113, 41, 54, 70}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3be88e", new byte[]{33, 111, 27, 2, 29, 103, 57, ek.k, 48, 109, 52, 105, 21, 73, ek.l, 118, 35, 70, 38, 126, 43, 99, 19, 2, 35, 119, 38, 74, 55, 109, 43, 100, 37, 73, 21, 100, 57, com.anythink.core.common.s.a.c.b, 49}));
        if (this.ah.bindService(intent, this.xr, 1)) {
            try {
                pblt pbltVar = this.f4858ms;
                if (pbltVar != null) {
                    String strMs = pbltVar.ms();
                    if (pblbVar != null) {
                        pblbVar.ms(strMs);
                    }
                }
            } catch (Throwable unused) {
            }
            this.ah.unbindService(this.xr);
        }
    }
}

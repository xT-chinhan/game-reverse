package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.ek;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class pgla {
    private final Context ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f4865ms = new LinkedBlockingQueue<>(1024);
    ServiceConnection xr = new ServiceConnectionC0695pgla();

    /* JADX INFO: renamed from: ms.bz.bd.c.Pgl.pgla$pgla, reason: collision with other inner class name */
    final class ServiceConnectionC0695pgla implements ServiceConnection {
        ServiceConnectionC0695pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pgla.this.f4865ms.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pgla(Context context) {
        this.ah = context;
    }

    public final void ms(pblk.pblb pblbVar) {
        try {
            this.ah.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3ea594", new byte[]{33, 104, 31, ek.m, 7, 48, 37, 87, 126, 104, 49, 102, 92, 114, 19, 51, 32, 72, 53, 104, 39, 105, 6, com.anythink.core.common.s.a.c.b, 20, 58, 20, 109, 20}), 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6cdd9c", new byte[]{36, 110, 26, 94, 7, 103, 32, 81, 123, 57, 52, 96, 89, 17, 5, 96, 60, 77, 59, 122, 6, 66, 52, 53, 53, 71, 10, 102, 28, ek.n}));
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8d5b25", new byte[]{42, 105, 75, 88, 12, 49, 46, 86, 42, com.anythink.core.common.s.a.c.c, 58, 103, 8, 37, 24, 50, 43, 73, 97, com.anythink.core.common.s.a.c.c, 44, 104, 82, 23, 31, 59, 31, 108, com.anythink.core.common.s.a.c.b}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2ba9a7", new byte[]{32, 111, 31, 3, 95, 51, 36, 80, 126, 100, 48, 97, 92, 126, 75, 48, 33, 79, 53, 100, 38, 110, 6, 76, 76, 57, 21, 106, 20, 39, ek.n, 117, 2, 93, 82, 37, 60, 70, 62, 125, 34, 114, 11, 105, 119, 4, 2, 70, 34, 127, 42, 99, 23})));
        if (this.ah.bindService(intent, this.xr, 1)) {
            try {
                String strMs = new pblb(this.f4865ms.take()).ms();
                if (pblbVar != null) {
                    pblbVar.ms(strMs);
                }
            } catch (Exception unused2) {
            } finally {
                this.ah.unbindService(this.xr);
            }
        }
    }
}

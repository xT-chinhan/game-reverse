package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.umeng.analytics.pro.ek;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class pblo {
    private final Context ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f4854ms = new LinkedBlockingQueue<>(1024);
    ServiceConnection xr = new pgla();

    final class pgla implements ServiceConnection {
        pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pblo.this.f4854ms.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pblo(Context context) {
        this.ah = context;
    }

    public final void ms(pblk.pblb pblbVar) {
        int i = Build.VERSION.SDK_INT;
        if (i != 28 && i < 33) {
            try {
                this.ah.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "14c6a7", new byte[]{35, 57, 29, 12, 86, 53, 51, 2, 55, 111, 110, 62, 7, 75, 90}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60b046", new byte[]{36, 61, 28, 10, 30, 46, 49, 24, 32, 46, 40, 34, 20, 74, ek.m, 36, 35, 24, 48, 101, 105, 29, 33, 97, 37, 8, 17, 34, 12, 83, 2, 0, 39, 109, 40, 4}));
            intent.setPackage((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "885660", new byte[]{42, 53, 75, 12, 1, 50, 58, ek.l, 97, 111, 103, 50, 81, 75, ek.k}));
            if (this.ah.bindService(intent, this.xr, 1)) {
                try {
                    String strMs = new pblp(this.f4854ms.take()).ms();
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
}

package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.analytics.pro.ek;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class l1 {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static l1 f4836ms;
    private ArrayList ah = new ArrayList();
    private Context xr;

    private l1(Context context) {
        this.xr = null;
        this.xr = context;
    }

    public static l1 ms(Context context) {
        if (f4836ms == null) {
            synchronized (l1.class) {
                if (f4836ms == null) {
                    f4836ms = new l1(context);
                }
            }
        }
        return f4836ms;
    }

    public final int ah() {
        Intent intentRegisterReceiver = this.xr.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "23ce10", new byte[]{34, com.anythink.core.common.s.a.c.c, 20, 3, 1, 46, 53, 92, 59, 59, 55, 52, 30, 5, com.anythink.core.common.s.a.c.b, 38, 50, 6, 59, 58, 45, 127, 50, 48, 58, 19, 20, 32, 11, 10, 0, 25, 49, com.anythink.core.common.s.a.c.c, 41, 2, 21})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5257f1", new byte[]{52, 60, 83, 68, 94, 35, 50}), -1);
    }

    public final void d() {
        byte b;
        int i;
        int iAh;
        int iMs;
        try {
            b = pble.ms() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b = -1;
        }
        if (b != 1) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3651bd", new byte[]{33, 60, 67, 70, 86, 51, 54, 18, 112, 98, 42, 22, 71, 81, 73, 118, 34, ek.l, 87, 117, 35, 32, 83, 86, 110, 103, 34, 30, 106, 102, 98, 61, 72, 5, 95, 114, 51, 28, 99, 115, 45, 33, 72, 65});
            return;
        }
        try {
            synchronized (this) {
                try {
                    iAh = ah();
                    iMs = ms();
                } catch (Throwable th) {
                    throw th;
                }
            }
            i = (iAh * 10000) + iMs;
        } catch (Exception unused2) {
            i = com.anythink.core.common.m.o.m;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf == null) {
            return;
        }
        this.ah.add(numValueOf);
        try {
            int size = this.ah.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.ah.subList(size - 10, size));
                this.ah.clear();
                this.ah = arrayList;
            }
        } catch (Throwable unused3) {
        }
    }

    public final synchronized int[] ka() {
        int size = this.ah.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{((Integer) this.ah.get(0)).intValue()};
        }
        try {
            ArrayList arrayList = this.ah;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List listSubList = arrayList.subList(i, size);
            int[] iArr = new int[listSubList.size()];
            for (int i2 = 0; i2 < listSubList.size(); i2++) {
                iArr[i2] = ((Integer) listSubList.get(i2)).intValue();
            }
            return iArr;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public final int ms() {
        Intent intentRegisterReceiver = this.xr.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9368eb", new byte[]{41, com.anythink.core.common.s.a.c.c, 65, 94, 85, 124, 62, 92, 110, 102, 60, 52, 75, 88, 20, 116, 57, 6, 110, 103, 38, 127, 103, 109, 110, 65, 31, 32, 94, 87, 11, 25, 100, 98, 125, 80, 30})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return Math.round(((intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c0f0db", new byte[]{126, 55, 3, 65, 87}), -1) / intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a2b4be", new byte[]{99, 51, ek.n, 76, 88}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public final int xr() {
        Intent intentRegisterReceiver = this.xr.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "113d43", new byte[]{33, 61, 68, 2, 4, 45, 54, 94, 107, 58, 52, 54, 78, 4, 69, 37, 49, 4, 107, 59, 46, 125, 98, 49, com.anythink.core.common.s.a.c.c, ek.n, 23, 34, 91, 11, 3, 27, 97, 62, 44, 1, 22})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8b0e1e", new byte[]{58, 116, 66, 5, 27, 97}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }
}

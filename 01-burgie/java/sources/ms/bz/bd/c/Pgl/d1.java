package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.analytics.pro.cc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 {
    private static d1 pr;
    private ArrayList hn = new ArrayList();
    private Context hw;

    private d1(Context context) {
        this.hw = null;
        this.hw = context;
    }

    public static d1 pr(Context context) {
        if (pr == null) {
            synchronized (d1.class) {
                if (pr == null) {
                    pr = new d1(context);
                }
            }
        }
        return pr;
    }

    public final synchronized int[] c() {
        int size = this.hn.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{((Integer) this.hn.get(0)).intValue()};
        }
        try {
            ArrayList arrayList = this.hn;
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
        } catch (Throwable th) {
            return new int[0];
        }
    }

    public final int hn() {
        Intent intentRegisterReceiver = this.hw.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "157dc7", new byte[]{33, 57, 64, 2, 83, 41, 54, 90, 111, 58, 52, 50, 74, 4, 18, 33, 49, 0, 111, 59, 46, 121, 102, 49, 104, 20, 23, 38, 95, 11, 3, 31, 101, 62, 123, 5, 22})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "553f51", new byte[]{52, 59, 85, 21, cc.k, 35, 50}), -1);
    }

    public final int hw() {
        Intent intentRegisterReceiver = this.hw.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2ab2a0", new byte[]{34, 109, 21, 84, 81, 46, 53, cc.l, 58, 108, 55, 102, 31, 82, cc.n, 38, 50, 84, 58, 109, 45, 45, 51, 103, 106, 19, 20, 114, 10, 93, 0, 75, 48, 104, 121, 2, 21})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2b7b1b", new byte[]{48, 116, 69, 2, 27, 102}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public final int pr() {
        Intent intentRegisterReceiver = this.hw.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3e6860", new byte[]{35, 105, 65, 94, 6, 46, 52, 10, 110, 102, 54, 98, 75, 88, 71, 38, 51, 80, 110, 103, 44, 41, 103, 109, 61, 19, 21, 118, 94, 87, 1, 79, 100, 98, 46, 2, 20})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return Math.round(((intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "740a1a", new byte[]{42, 51, 85, cc.n, 2}), -1) / intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eeeab9", new byte[]{103, 100, 23, 25, 88}), -1)) * 100.0f) * 10.0f) / 10;
    }

    public final void x() {
        byte b;
        int i;
        int iHn;
        int iPr;
        try {
            b = pblc.pr() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable th) {
            b = -1;
        }
        if (b != 1) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7cf015", new byte[]{37, 105, cc.n, 71, 5, 98, 50, 71, 35, 99, 46, 67, 20, 80, 26, 39, 38, 91, 4, 116, 39, 117, 0, 87, 61, 54, 38, 75, 57, 103, 102, 104, 27, 4, 12, 35, 55, 73, 48, 114, 41, 116, 27, 64});
            return;
        }
        try {
            synchronized (this) {
                try {
                    iHn = hn();
                    iPr = pr();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            i = (iHn * 10000) + iPr;
        } catch (Exception e) {
            i = -10001;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf == null) {
            return;
        }
        this.hn.add(numValueOf);
        try {
            int size = this.hn.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.hn.subList(size - 10, size));
                this.hn.clear();
                this.hn = arrayList;
            }
        } catch (Throwable th3) {
        }
    }
}

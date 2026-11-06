package com.byazt.yd;

import android.content.Context;
import android.os.Handler;
import com.byazt.yw.tj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 169, 8})
public final class s {
    public List<n> n;

    private s(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.n = arrayList;
        arrayList.add(new qg(handler, 0L, 15000L));
    }

    public static s n(Handler handler, Context context) {
        return new s(handler, context);
    }

    public void n() {
        tj.n("[ScheduleTaskManager] execute, task size=" + this.n.size());
        Iterator<n> it = this.n.iterator();
        while (it.hasNext()) {
            try {
                it.next().n();
            } catch (Throwable unused) {
            }
        }
    }
}

package com.bytedance.ms.xr.c;

import android.content.Context;
import android.os.Handler;
import com.bytedance.ms.xr.x.ch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private List<ms> f561ms;

    private ah(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.f561ms = arrayList;
        arrayList.add(new xr(handler, 0L, 15000L));
    }

    public static ah ms(Handler handler, Context context) {
        return new ah(handler, context);
    }

    public void ms() {
        ch.ms("[ScheduleTaskManager] execute, task size=" + this.f561ms.size());
        Iterator<ms> it = this.f561ms.iterator();
        while (it.hasNext()) {
            try {
                it.next().ms();
            } catch (Throwable unused) {
            }
        }
    }
}

package com.byazt.sx;

import android.content.Context;
import android.os.Handler;
import com.byazt.wf.vk;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 892, 20})
public final class hn {
    public List<pr> pr;

    private hn(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.pr = arrayList;
        arrayList.add(new hw(handler, 0L, IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS));
    }

    public static hn pr(Handler handler, Context context) {
        return new hn(handler, context);
    }

    public void pr() {
        vk.pr("[ScheduleTaskManager] execute, task size=" + this.pr.size());
        Iterator<pr> it = this.pr.iterator();
        while (it.hasNext()) {
            it.next().pr();
        }
    }
}

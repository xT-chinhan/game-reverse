package com.mcto.sspsdk.ssp.taskpage;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements View.OnClickListener {
    public long a = 0;
    public final /* synthetic */ TaskAdItemView b;

    public g(TaskAdItemView taskAdItemView) {
        this.b = taskAdItemView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.a < 500) {
            return;
        }
        this.a = jElapsedRealtime;
        this.b.onClick(view);
    }
}

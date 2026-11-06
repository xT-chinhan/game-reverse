package com.byazt.tv;

import android.content.Context;
import com.byazt.sds.fw;
import com.byazt.vlj.zo;
import com.byazt.wf.aj;
import com.byazt.wf.vk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1488, 121})
public final class x implements Runnable {
    public Context pr;

    private x(Context context) {
        this.pr = context;
    }

    public static void pr(Context context, int i) {
        try {
            if (!zo.pr().x().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception e) {
        }
        fw.hw().postDelayed(new x(context), i);
    }

    public static void pr(Context context) {
        pr(context, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.byazt.sds.hn(this.pr).pr(aj.hw(this.pr));
        } catch (Throwable th) {
            try {
                vk.hw(th);
            } finally {
                com.byazt.sx.hn.pr(fw.hw(), this.pr).pr();
            }
        }
    }
}

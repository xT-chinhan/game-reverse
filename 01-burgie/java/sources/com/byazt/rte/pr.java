package com.byazt.rte;

import android.content.Context;
import com.byazt.ca.ho;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 37})
public abstract class pr implements c {
    public final String hn;
    public final com.byazt.ew.pr hw;
    public final Context pr;

    public pr(Context context, com.byazt.ew.pr prVar, String str) {
        this.pr = context;
        this.hw = prVar;
        this.hn = str;
    }

    public boolean pr() {
        if (this.pr == null) {
            return false;
        }
        try {
            return hw().resolveActivity(this.pr.getPackageManager()) != null;
        } catch (Throwable th) {
            if (com.byazt.p000do.pr.pr()) {
                ho.pr("AbsDevicePlan", "check is valid failed!", th);
            }
        }
    }
}

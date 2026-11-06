package com.byazt.vy;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 8})
public class s {

    public interface n {
    }

    public static void n(Context context, Intent intent, n nVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}

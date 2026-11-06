package com.byazt.mj;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1480, 5})
public final class q {
    public static Toast n;

    public static void n(Context context, String str) {
        n(context, str, 0);
    }

    public static void n(Context context, String str, int i) {
        Toast toastN = n(context);
        if (toastN != null) {
            toastN.setDuration(i);
            toastN.setText(String.valueOf(str));
            toastN.show();
            return;
        }
        com.byazt.rb.qg.qg("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    private static Toast n(Context context) {
        if (context == null) {
            return n;
        }
        Toast toastMakeText = Toast.makeText(context.getApplicationContext(), "", 0);
        n = toastMakeText;
        return toastMakeText;
    }
}

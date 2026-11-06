package com.mcto.sspsdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class u9 extends BroadcastReceiver {
    public final /* synthetic */ x9 a;

    public u9(x9 x9Var) {
        this.a = x9Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            x9 x9Var = this.a;
            Boolean boolValueOf = Boolean.valueOf(TextUtils.equals(ha.a(), "1"));
            List list = (List) x9Var.c.get("android.net.conn.CONNECTIVITY_CHANGE");
            if (list != null) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    ((w9) it.next()).a(boolValueOf);
                }
            }
        }
    }
}

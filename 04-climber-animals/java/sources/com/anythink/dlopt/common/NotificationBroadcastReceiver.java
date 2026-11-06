package com.anythink.dlopt.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class NotificationBroadcastReceiver extends BroadcastReceiver {
    private static final String a = "NotificationBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        intent.getStringExtra(com.anythink.dlopt.common.b.a.d);
        String stringExtra = intent.getStringExtra(com.anythink.dlopt.common.b.a.e);
        String stringExtra2 = intent.getStringExtra(com.anythink.dlopt.common.b.a.f);
        int intExtra = intent.getIntExtra(com.anythink.dlopt.common.b.a.g, -1);
        if (TextUtils.isEmpty(action)) {
            return;
        }
        action.hashCode();
        if (action.equals(com.anythink.dlopt.common.b.a.b)) {
            b.a(context).a(stringExtra, stringExtra2, intExtra);
        } else if (action.equals(com.anythink.dlopt.common.b.a.c)) {
            b.a(context).a(stringExtra, stringExtra2);
        }
    }
}

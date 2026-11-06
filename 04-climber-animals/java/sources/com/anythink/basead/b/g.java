package com.anythink.basead.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            String stringExtra = intent.getStringExtra(com.anythink.dlopt.common.b.f);
            String stringExtra2 = intent.getStringExtra(com.anythink.dlopt.common.b.g);
            action.hashCode();
            switch (action) {
                case "at_offer_action_1":
                    h.a(context.getApplicationContext()).a(stringExtra, stringExtra2);
                    break;
                case "at_offer_action_2":
                    h.a(context.getApplicationContext()).b(stringExtra, stringExtra2);
                    break;
                case "at_offer_action_3":
                    h.a(context.getApplicationContext()).c(stringExtra, stringExtra2);
                    break;
                case "at_offer_action_4":
                    h.a(context.getApplicationContext()).d(stringExtra, stringExtra2);
                    break;
            }
        }
    }
}

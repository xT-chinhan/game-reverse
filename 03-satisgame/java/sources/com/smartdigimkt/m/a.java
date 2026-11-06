package com.smartdigimkt.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.smartdigimkt.j.u;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        intent.getStringExtra("sdm_broadcast_receiver_extra_url");
        String stringExtra = intent.getStringExtra("sdm_broadcast_receiver_extra_unique_id");
        String stringExtra2 = intent.getStringExtra("sdm_broadcast_receiver_extra_request_status");
        intent.getIntExtra("sdm_broadcast_receiver_extra_notification_id", -1);
        try {
            u.a(context).a(stringExtra, stringExtra2);
        } catch (Throwable unused) {
        }
    }
}

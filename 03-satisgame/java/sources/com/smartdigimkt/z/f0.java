package com.smartdigimkt.z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            String stringExtra = intent.getStringExtra("receiver_extra_offer_id");
            String stringExtra2 = intent.getStringExtra("receiver_extra_click_id");
            action.hashCode();
            switch (action) {
                case "at_offer_action_1":
                    com.smartdigimkt.b3.c cVar = (com.smartdigimkt.b3.c) g0.a(context.getApplicationContext()).b.get(stringExtra);
                    if (cVar != null) {
                        com.smartdigimkt.h0.m mVar = new com.smartdigimkt.h0.m();
                        com.smartdigimkt.h0.b bVar = new com.smartdigimkt.h0.b();
                        mVar.i = bVar;
                        bVar.a = stringExtra2;
                        s.a(18, cVar, mVar);
                        break;
                    }
                    break;
                case "at_offer_action_2":
                    com.smartdigimkt.b3.c cVar2 = (com.smartdigimkt.b3.c) g0.a(context.getApplicationContext()).b.get(stringExtra);
                    if (cVar2 != null) {
                        com.smartdigimkt.h0.m mVar2 = new com.smartdigimkt.h0.m();
                        com.smartdigimkt.h0.b bVar2 = new com.smartdigimkt.h0.b();
                        mVar2.i = bVar2;
                        bVar2.a = stringExtra2;
                        s.a(19, cVar2, mVar2);
                        break;
                    }
                    break;
                case "at_offer_action_3":
                    com.smartdigimkt.b3.c cVar3 = (com.smartdigimkt.b3.c) g0.a(context.getApplicationContext()).b.get(stringExtra);
                    if (cVar3 != null) {
                        com.smartdigimkt.h0.m mVar3 = new com.smartdigimkt.h0.m();
                        com.smartdigimkt.h0.b bVar3 = new com.smartdigimkt.h0.b();
                        mVar3.i = bVar3;
                        bVar3.a = stringExtra2;
                        s.a(20, cVar3, mVar3);
                        break;
                    }
                    break;
                case "at_offer_action_4":
                    g0 g0VarA = g0.a(context.getApplicationContext());
                    com.smartdigimkt.b3.c cVar4 = (com.smartdigimkt.b3.c) g0VarA.b.remove(stringExtra);
                    if (cVar4 != null) {
                        com.smartdigimkt.h0.m mVar4 = new com.smartdigimkt.h0.m();
                        com.smartdigimkt.h0.b bVar4 = new com.smartdigimkt.h0.b();
                        mVar4.i = bVar4;
                        bVar4.a = stringExtra2;
                        s.a(21, cVar4, mVar4);
                        g0.a(cVar4, mVar4);
                    }
                    if (g0VarA.b.size() == 0) {
                        g0VarA.b();
                        break;
                    }
                    break;
                case "at_offer_action_5":
                    g0 g0VarA2 = g0.a(context.getApplicationContext());
                    com.smartdigimkt.b3.c cVar5 = (com.smartdigimkt.b3.c) g0VarA2.b.remove(stringExtra);
                    g0VarA2.b.size();
                    if (cVar5 != null) {
                        g0.a(cVar5, new com.smartdigimkt.h0.m());
                    }
                    if (g0VarA2.b.size() == 0) {
                        g0VarA2.b();
                        break;
                    }
                    break;
            }
        }
    }
}

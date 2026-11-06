package com.smartdigimkt.z;

import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public static volatile g0 d;
    public final Context a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public f0 c;

    public g0(Context context) {
        this.a = context;
    }

    public static g0 a(Context context) {
        if (d == null) {
            synchronized (g0.class) {
                if (d == null) {
                    d = new g0(context);
                }
            }
        }
        return d;
    }

    public final void b() {
        if (this.c != null) {
            com.smartdigimkt.x2.d dVarA = com.smartdigimkt.x2.d.a(this.a);
            f0 f0Var = this.c;
            synchronized (dVarA.b) {
                ArrayList arrayList = (ArrayList) dVarA.b.remove(f0Var);
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        com.smartdigimkt.x2.c cVar = (com.smartdigimkt.x2.c) arrayList.get(size);
                        cVar.d = true;
                        for (int i = 0; i < cVar.a.countActions(); i++) {
                            String action = cVar.a.getAction(i);
                            ArrayList arrayList2 = (ArrayList) dVarA.c.get(action);
                            if (arrayList2 != null) {
                                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                    com.smartdigimkt.x2.c cVar2 = (com.smartdigimkt.x2.c) arrayList2.get(size2);
                                    if (cVar2.b == f0Var) {
                                        cVar2.d = true;
                                        arrayList2.remove(size2);
                                    }
                                }
                                if (arrayList2.size() <= 0) {
                                    dVarA.c.remove(action);
                                }
                            }
                        }
                    }
                }
            }
            this.c = null;
        }
    }

    public final void a() {
        if (this.a != null && this.c == null) {
            this.c = new f0();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("at_offer_action_1");
            intentFilter.addAction("at_offer_action_2");
            intentFilter.addAction("at_offer_action_3");
            intentFilter.addAction("at_offer_action_4");
            intentFilter.addAction("at_offer_action_5");
            com.smartdigimkt.x2.d dVarA = com.smartdigimkt.x2.d.a(this.a);
            f0 f0Var = this.c;
            synchronized (dVarA.b) {
                com.smartdigimkt.x2.c cVar = new com.smartdigimkt.x2.c(intentFilter, f0Var);
                ArrayList arrayList = (ArrayList) dVarA.b.get(f0Var);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    dVarA.b.put(f0Var, arrayList);
                }
                arrayList.add(cVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) dVarA.c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        dVarA.c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            }
        }
    }

    public static void a(com.smartdigimkt.b3.c cVar, com.smartdigimkt.h0.m mVar) {
        com.smartdigimkt.b3.e eVar = cVar.w;
        if (eVar == null || eVar.G1 != 1) {
            return;
        }
        if (mVar.i == null) {
            mVar.i = new com.smartdigimkt.h0.b();
        }
        mVar.i.c = 1001;
        s.a(9, cVar, mVar);
    }
}

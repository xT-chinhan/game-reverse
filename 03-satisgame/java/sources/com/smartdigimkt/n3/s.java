package com.smartdigimkt.n3;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends w {
    public static volatile s g;

    public s(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.n3.w
    public final void a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((com.smartdigimkt.f3.c) it.next()).a().toString());
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA == null) {
            com.smartdigimkt.f4.d dVar = new com.smartdigimkt.f4.d(0, arrayList2);
            dVar.r = true;
            dVar.a(0, (com.smartdigimkt.a4.b) null);
            return;
        }
        int i = aVarA.z;
        if (i != 1) {
            com.smartdigimkt.f4.d dVar2 = new com.smartdigimkt.f4.d(i, arrayList2);
            dVar2.r = true;
            dVar2.a(0, (com.smartdigimkt.a4.b) null);
        } else {
            com.smartdigimkt.h4.a aVar = new com.smartdigimkt.h4.a(arrayList2);
            String str = aVarA.C;
            aVar.a = 1;
            aVar.b = str;
            aVar.e = true;
            aVar.a((com.smartdigimkt.h4.c) null);
        }
    }
}

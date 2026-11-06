package com.bytedance.sdk.openadsdk.core.sl;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.ms.ah.d;
import com.bytedance.sdk.component.adexpress.ms.xr.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static void ms(List<lm> list, final ab.ms msVar) {
        d dVarA;
        if (msVar == null) {
            return;
        }
        if (list == null || list.size() <= 0) {
            if (msVar != null) {
                msVar.xr();
            }
            msVar.xr();
            return;
        }
        ArrayList<d> arrayList = new ArrayList();
        for (lm lmVar : list) {
            if (lmVar != null && !lmVar.na() && (dVarA = lmVar.a()) != null) {
                arrayList.add(dVarA);
            }
        }
        if (arrayList.size() <= 0) {
            msVar.xr();
            return;
        }
        for (d dVar : arrayList) {
            String str = dVar.c;
            final String str2 = dVar.f888ms;
            final String str3 = dVar.ah;
            final String str4 = dVar.xr;
            final String str5 = dVar.d;
            final String str6 = dVar.ka;
            final String strC = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() != null ? com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().c() : "" : str;
            com.bytedance.sdk.component.ch.ab.ms(new ny("saveTemplate") { // from class: com.bytedance.sdk.openadsdk.core.sl.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ab.ms().ms(str2, str3, str4, str5, str6, strC, msVar);
                }
            }, 10);
        }
    }
}

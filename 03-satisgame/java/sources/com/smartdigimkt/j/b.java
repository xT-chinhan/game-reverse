package com.smartdigimkt.j;

import android.content.Context;
import com.smartdigimkt.dlopt.api.ATApkDialogClickListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final /* synthetic */ ATApkDialogClickListener a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ f c;

    public b(f fVar, ATApkDialogClickListener aTApkDialogClickListener, Context context) {
        this.c = fVar;
        this.a = aTApkDialogClickListener;
        this.b = context;
    }

    public final void a(ArrayList arrayList) {
        com.smartdigimkt.k.r rVar;
        if (arrayList.size() == 0) {
            f fVar = this.c;
            ATApkDialogClickListener aTApkDialogClickListener = this.a;
            fVar.getClass();
            com.smartdigimkt.q3.f.a().a(new e(aTApkDialogClickListener, 0));
            return;
        }
        int i = 0;
        while (true) {
            try {
                if (i >= arrayList.size()) {
                    rVar = null;
                    break;
                }
                rVar = (com.smartdigimkt.k.r) arrayList.get(i);
                if (!this.c.c.contains(rVar.o)) {
                    break;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
        if (rVar == null) {
            this.c.c.clear();
            rVar = (com.smartdigimkt.k.r) arrayList.get(0);
        }
        this.c.c.add(rVar.o);
        com.smartdigimkt.q3.f.a().a(new a(this, rVar));
    }
}

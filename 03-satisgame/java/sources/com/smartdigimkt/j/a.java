package com.smartdigimkt.j;

import android.content.Context;
import com.smartdigimkt.dlopt.api.ATApkDialogClickListener;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ com.smartdigimkt.k.r a;
    public final /* synthetic */ b b;

    public a(b bVar, com.smartdigimkt.k.r rVar) {
        this.b = bVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.s == com.smartdigimkt.k.c.FINISH && ((u) this.b.c.a).a(this.a.o)) {
            b bVar = this.b;
            f fVar = bVar.c;
            Context context = bVar.b;
            com.smartdigimkt.k.r rVar = this.a;
            Object[] objArr = {rVar.c};
            fVar.getClass();
            String strA = f.a(context, "btn_install_tip", objArr);
            b bVar2 = this.b;
            bVar2.c.getClass();
            f.a(fVar, context, rVar, strA, f.a(bVar2.b, "btn_install", new Object[0]), 1, this.b.a);
            b bVar3 = this.b;
            f fVar2 = bVar3.c;
            ATApkDialogClickListener aTApkDialogClickListener = bVar3.a;
            fVar2.getClass();
            com.smartdigimkt.q3.f.a().a(new e(aTApkDialogClickListener, 1));
            return;
        }
        if (this.a.s == com.smartdigimkt.k.c.INSTALLED) {
            b bVar4 = this.b;
            f fVar3 = bVar4.c;
            Context context2 = bVar4.b;
            com.smartdigimkt.k.r rVar2 = this.a;
            Object[] objArr2 = {rVar2.c};
            fVar3.getClass();
            String strA2 = f.a(context2, "btn_open_tip", objArr2);
            b bVar5 = this.b;
            bVar5.c.getClass();
            f.a(fVar3, context2, rVar2, strA2, f.a(bVar5.b, "btn_open", new Object[0]), 2, this.b.a);
            b bVar6 = this.b;
            f fVar4 = bVar6.c;
            ATApkDialogClickListener aTApkDialogClickListener2 = bVar6.a;
            fVar4.getClass();
            com.smartdigimkt.q3.f.a().a(new e(aTApkDialogClickListener2, 2));
        }
    }
}

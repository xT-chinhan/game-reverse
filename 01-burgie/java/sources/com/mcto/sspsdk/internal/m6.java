package com.mcto.sspsdk.internal;

import android.content.Context;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m6 {
    public static void a(QyAdSlot qyAdSlot, p pVar, Context context, t6 t6Var) {
        if (pVar.n()) {
            new i0(ik.a().a(qyAdSlot.getCodeId(), pVar.u0), pVar, qyAdSlot, context, new k6(t6Var, pVar));
            return;
        }
        ea eaVar = new ea(pVar, qyAdSlot, context, new m(pVar));
        l6 l6Var = new l6(t6Var, eaVar, pVar);
        QYNiceImageView qYNiceImageView = new QYNiceImageView(context);
        qYNiceImageView.a(new da(eaVar, qYNiceImageView, l6Var));
        qYNiceImageView.a(pVar.h());
        eaVar.f = qYNiceImageView;
    }
}

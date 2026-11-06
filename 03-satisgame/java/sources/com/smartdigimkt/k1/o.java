package com.smartdigimkt.k1;

import android.content.Context;
import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;
import com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ p b;

    public o(p pVar, ViewGroup viewGroup) {
        this.b = pVar;
        this.a = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.b;
        if (BaseSdkSplashATView.isSinglePicture(pVar.e, pVar.b.s)) {
            p pVar2 = this.b;
            Context context = this.a.getContext();
            p pVar3 = this.b;
            pVar2.j = new SinglePictureSplashATView(context, pVar3.b, pVar3.e, pVar3.i);
        } else {
            p pVar4 = this.b;
            Context context2 = this.a.getContext();
            p pVar5 = this.b;
            pVar4.j = new AsseblemSplashATView(context2, pVar5.b, pVar5.e, pVar5.i);
        }
        p pVar6 = this.b;
        pVar6.j.setDontCountDown(pVar6.k);
        this.a.addView(this.b.j);
    }
}

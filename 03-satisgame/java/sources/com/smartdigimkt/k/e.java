package com.smartdigimkt.k;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ o b;

    public e(o oVar, r rVar) {
        this.b = oVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.z2.g gVar;
        com.smartdigimkt.b3.f fVarA;
        String str = this.a.F;
        if (TextUtils.isEmpty(str) && (gVar = this.b.b) != null && (fVarA = gVar.a(this.a.o)) != null) {
            str = fVarA.G;
        }
        String str2 = this.a.o;
        if (TextUtils.isEmpty(str)) {
            this.b.a(this.a, "at_offer_action_1");
            this.b.a(this.a, "at_offer_action_2");
        } else if (str.equals("at_offer_action_1")) {
            this.b.a(this.a, "at_offer_action_2");
        }
    }
}

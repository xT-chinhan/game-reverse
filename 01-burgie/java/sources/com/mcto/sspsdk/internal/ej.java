package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.component.imageview2.QYImageView2;

/* JADX INFO: loaded from: classes2.dex */
public final class ej implements w3 {
    public final /* synthetic */ fj a;

    public ej(fj fjVar) {
        this.a = fjVar;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        fj fjVar = this.a;
        fjVar.l = ((QYImageView2) fjVar.m).c();
        fj fjVar2 = this.a;
        int iIntValue = ((Integer) obj).intValue();
        li liVar = fjVar2.o;
        if (liVar != null) {
            liVar.a(iIntValue);
        }
    }
}

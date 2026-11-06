package com.smartdigimkt.x1;

import com.smartdigimkt.n1.c1;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.smartdigimkt.i2.k {
    public final /* synthetic */ k a;

    public i(k kVar) {
        this.a = kVar;
    }

    @Override // com.smartdigimkt.i2.k
    public final void a(int i, int i2) {
        boolean z;
        a aVar;
        boolean z2 = true;
        switch (i2) {
            case 27:
                k kVar = this.a;
                com.smartdigimkt.a3.a aVar2 = kVar.c;
                z = aVar2.s.R0 == 2;
                if (!z) {
                    com.smartdigimkt.i2.l.a(kVar.n, true, aVar2, false);
                }
                z2 = z;
                break;
            case 28:
                if (this.a.q < 2) {
                    z = false;
                    z2 = z;
                } else {
                    z = false;
                }
                break;
            case 29:
                if (this.a.q < 1) {
                    z = false;
                    z2 = z;
                } else {
                    z = false;
                }
                break;
            case 30:
                z = false;
                break;
            case 31:
                if (this.a.r < 1) {
                    z = false;
                    z2 = z;
                } else {
                    z = false;
                }
                break;
            default:
                z = false;
                z2 = z;
                break;
        }
        if (z2 && (aVar = this.a.e) != null) {
            aVar.a(i, i2);
        }
        if (z) {
            RedPacketPage redPacketPage = this.a.p;
            if (redPacketPage != null) {
                com.smartdigimkt.o3.d.a(redPacketPage);
                c1 c1Var = this.a.h;
                if (c1Var != null) {
                    c1Var.a(false);
                }
            }
            this.a.n.setVisibility(0);
            this.a.n.setOnClickListener(new h(this));
        }
    }
}

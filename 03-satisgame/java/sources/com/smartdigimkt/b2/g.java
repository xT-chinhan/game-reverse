package com.smartdigimkt.b2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {
    public com.smartdigimkt.x1.d i;
    public boolean j = false;

    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
        int i2 = aVar.s.K0;
        if (i2 == 2) {
            this.i = new com.smartdigimkt.x1.g(context, cVar, aVar, eVar, i, viewGroup);
            return;
        }
        if (i2 == 3) {
            this.i = new com.smartdigimkt.x1.k(context, cVar, aVar, eVar, i, viewGroup);
        } else if (i2 == 4) {
            this.i = new com.smartdigimkt.x1.v(context, cVar, aVar, eVar, i, viewGroup);
        } else {
            if (i2 != 5) {
                return;
            }
            this.i = new com.smartdigimkt.x1.o(context, cVar, aVar, eVar, i, viewGroup);
        }
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        com.smartdigimkt.x1.d dVar;
        Object obj;
        com.smartdigimkt.x1.d dVar2;
        if (i == 102) {
            if (this.j || (dVar = this.i) == null) {
                return;
            }
            dVar.d();
            return;
        }
        if (i == 103) {
            if (!this.j) {
                com.smartdigimkt.x1.d dVar3 = this.i;
                if (dVar3 != null) {
                    dVar3.a(this.f);
                    return;
                }
                return;
            }
            if (com.smartdigimkt.z.c0.d(this.b, this.c)) {
                return;
            }
            int iA = com.smartdigimkt.z.c0.a(this.c, this.d.getContext());
            com.smartdigimkt.b3.c cVar = this.b;
            com.smartdigimkt.a3.a aVar = this.c;
            com.smartdigimkt.b3.e eVar = cVar.w;
            com.smartdigimkt.n3.k.a(cVar, aVar, iA, false, 0, "", 0, eVar != null ? eVar.K0 : 1);
            return;
        }
        if (i == 112) {
            com.smartdigimkt.x1.d dVar4 = this.i;
            if (dVar4 != null) {
                dVar4.j = false;
                dVar4.k = null;
                this.i = null;
                return;
            }
            return;
        }
        if (i != 113) {
            if (i == 125 && (obj = map.get("video_reset_player_view_type")) != null && (obj instanceof Integer) && ((Integer) obj).intValue() == 1 && (dVar2 = this.i) != null) {
                dVar2.j = false;
                dVar2.k = null;
                this.i = null;
                return;
            }
            return;
        }
        this.j = true;
        com.smartdigimkt.x1.d dVar5 = this.i;
        if (dVar5 != null) {
            dVar5.a();
        }
    }
}

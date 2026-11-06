package com.smartdigimkt.h0;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.smartdigimkt.z.s;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Dialog b;
    public final /* synthetic */ j c;

    public i(j jVar, Context context, Dialog dialog) {
        this.c = jVar;
        this.a = context;
        this.b = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            j jVar = this.c;
            String str = jVar.c;
            com.smartdigimkt.b3.c cVar = jVar.a;
            com.smartdigimkt.n3.k.a(str, cVar.a, jVar.b, 8, (String) null, 0L, 0L, cVar, 0, 0L);
            if (s.b(this.a, this.c.a)) {
                j jVar2 = this.c;
                String str2 = jVar2.c;
                com.smartdigimkt.b3.c cVar2 = jVar2.a;
                com.smartdigimkt.n3.k.a(str2, cVar2.a, jVar2.b, 9, (String) null, 0L, 0L, cVar2, 0, jVar2.e);
            } else {
                j jVar3 = this.c;
                String str3 = jVar3.c;
                com.smartdigimkt.b3.c cVar3 = jVar3.a;
                com.smartdigimkt.n3.k.a(str3, cVar3.a, jVar3.b, 13, (String) null, 0L, 0L, cVar3, 0, 0L);
            }
            this.b.dismiss();
            com.smartdigimkt.j.g gVar = this.c.d;
            if (gVar != null) {
                gVar.getClass();
            }
        } catch (Throwable unused) {
        }
    }
}

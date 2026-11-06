package com.mcto.sspsdk.internal;

import android.widget.ImageView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class xe {
    public final /* synthetic */ gf a;

    public xe(gf gfVar) {
        this.a = gfVar;
    }

    public final void a() {
        gf gfVar = this.a;
        QYNiceImageView qYNiceImageView = gfVar.v;
        if (qYNiceImageView != null && !gfVar.m) {
            qYNiceImageView.setVisibility(8);
        }
        gf gfVar2 = this.a;
        int i = gfVar2.l;
        gfVar2.a(8);
        ImageView imageView = gfVar2.y;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        gf gfVar3 = this.a;
        gfVar3.a = 3;
        gfVar3.e();
        gf gfVar4 = this.a;
        if (gfVar4.D != null) {
            if (!gfVar4.h.compareAndSet(false, true)) {
                this.a.D.c();
            } else {
                gf gfVar5 = this.a;
                gfVar5.D.b(gfVar5.B);
            }
        }
    }
}

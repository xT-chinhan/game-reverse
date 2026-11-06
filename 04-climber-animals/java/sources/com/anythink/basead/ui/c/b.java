package com.anythink.basead.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.ui.GuideToClickView;
import com.anythink.basead.ui.simpleview.SimpleCircleView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    private GuideToClickView o;
    private SimpleCircleView p;

    public b(Context context, w wVar, x xVar, com.anythink.basead.ui.improveclick.c.a aVar, int i, ViewGroup viewGroup) {
        super(context, wVar, xVar, aVar, i, viewGroup);
    }

    @Override // com.anythink.basead.ui.c.a
    public final void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.p = new SimpleCircleView(this.a);
        GuideToClickView guideToClickView = new GuideToClickView(this.a);
        this.o = guideToClickView;
        guideToClickView.hideBackground();
        viewGroup.addView(this.p, -1, -1);
        viewGroup.addView(this.o, -1, -1);
        b(this.c.o.aP());
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (b.this.e != null) {
                    b.this.e.a(14, 26);
                } else {
                    b.this.d();
                }
            }
        });
        if (this.h != null) {
            this.h.a(true);
        }
    }

    @Override // com.anythink.basead.ui.c.a
    public final void d() {
        super.d();
        GuideToClickView guideToClickView = this.o;
        if (guideToClickView != null) {
            am.a(guideToClickView);
        }
        SimpleCircleView simpleCircleView = this.p;
        if (simpleCircleView != null) {
            am.a(simpleCircleView);
        }
        c();
        if (this.n != null) {
            this.n.refresh(this.m);
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.b.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (b.this.h != null) {
                        b.this.h.b();
                    }
                }
            });
        }
        if (this.h != null) {
            this.h.a(false);
        }
    }
}

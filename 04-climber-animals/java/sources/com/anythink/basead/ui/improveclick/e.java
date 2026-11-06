package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.GuideToClickView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c {
    GuideToClickView a;
    boolean b = false;
    boolean c = false;

    @Override // com.anythink.basead.ui.improveclick.c
    final void a() {
    }

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, c.a aVar) {
        super.a(context, wVar, xVar, viewGroup, relativeLayout, view, i, aVar);
        GuideToClickView guideToClickView = new GuideToClickView(this.d);
        this.a = guideToClickView;
        guideToClickView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (e.this.k != null) {
                    e.this.k.a(1, 12);
                }
            }
        });
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a(int i, Map<String, Object> map) {
        if (i == 103) {
            if (a(map) || this.h != 1 || this.b || !this.c || this.a == null) {
                return;
            }
            b();
            return;
        }
        if (i == 113) {
            this.b = true;
            GuideToClickView guideToClickView = this.a;
            if (guideToClickView != null) {
                guideToClickView.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 116) {
            if (this.h != 3 || com.anythink.basead.b.e.b(this.e)) {
                return;
            }
            b();
            return;
        }
        switch (i) {
            case 106:
                if (this.h == 3 && com.anythink.basead.b.e.b(this.e)) {
                    b();
                    break;
                }
                break;
            case 107:
            case 108:
                this.c = true;
                break;
        }
    }

    private void b() {
        GuideToClickView guideToClickView;
        if (this.i == null || (guideToClickView = this.a) == null) {
            return;
        }
        am.a(guideToClickView);
        this.i.addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c() {
        GuideToClickView guideToClickView = this.a;
        if (guideToClickView != null) {
            guideToClickView.setVisibility(8);
        }
    }
}

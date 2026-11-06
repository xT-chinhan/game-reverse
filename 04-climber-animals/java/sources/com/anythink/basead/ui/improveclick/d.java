package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d extends c {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int l = 5;
    com.anythink.basead.ui.c.a m;
    boolean n = false;

    public interface a {
        View a();

        void a(boolean z);

        void b();

        View c();

        void d();
    }

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, c.a aVar) {
        super.a(context, wVar, xVar, viewGroup, relativeLayout, view, i, aVar);
        int iAO = xVar.o.aO();
        if (iAO == 2) {
            this.m = new com.anythink.basead.ui.c.b(context, wVar, xVar, aVar, i, viewGroup);
            return;
        }
        if (iAO == 3) {
            this.m = new com.anythink.basead.ui.c.c(context, wVar, xVar, aVar, i, viewGroup);
        } else if (iAO == 4) {
            this.m = new com.anythink.basead.ui.c.e(context, wVar, xVar, aVar, i, viewGroup);
        } else {
            if (iAO != 5) {
                return;
            }
            this.m = new com.anythink.basead.ui.c.d(context, wVar, xVar, aVar, i, viewGroup);
        }
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a(int i, Map<String, Object> map) {
        com.anythink.basead.ui.c.a aVar;
        if (i == 102) {
            if (this.n || (aVar = this.m) == null) {
                return;
            }
            aVar.a();
            return;
        }
        if (i == 103) {
            if (!this.n) {
                com.anythink.basead.ui.c.a aVar2 = this.m;
                if (aVar2 != null) {
                    aVar2.a(this.i);
                    return;
                }
                return;
            }
            if (com.anythink.basead.b.e.e(this.e, this.f)) {
                return;
            }
            com.anythink.core.common.u.e.a(this.e, this.f, com.anythink.basead.b.e.a(this.f, this.g.getContext()));
            return;
        }
        if (i == 112) {
            a();
            return;
        }
        if (i == 113) {
            this.n = true;
            com.anythink.basead.ui.c.a aVar3 = this.m;
            if (aVar3 != null) {
                aVar3.d();
                return;
            }
            return;
        }
        if (i != 125) {
            return;
        }
        Object obj = map.get(g.a.j);
        if (((obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue()) == 1) {
            a();
        }
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a() {
        com.anythink.basead.ui.c.a aVar = this.m;
        if (aVar != null) {
            aVar.e();
            this.m = null;
        }
    }

    private void a(a aVar) {
        com.anythink.basead.ui.c.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }
}

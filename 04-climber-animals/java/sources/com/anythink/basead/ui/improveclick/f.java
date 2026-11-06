package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends c {
    boolean a = false;
    boolean b = false;
    com.anythink.basead.ui.guidetoclickv2.a c;

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, c.a aVar) {
        super.a(context, wVar, xVar, viewGroup, relativeLayout, view, i, aVar);
        this.c = new com.anythink.basead.ui.guidetoclickv2.a(context, wVar, xVar, i, relativeLayout, view, aVar);
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a(int i, Map<String, Object> map) {
        if (i == 107 || i == 108) {
            if (this.h != 1) {
                return;
            }
        } else {
            if (i == 110) {
                if (this.c != null) {
                    if (this.b || this.h == 1 || this.h == 2) {
                        this.c.a();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 111) {
                if (this.c != null) {
                    if (this.b || this.h == 1 || this.h == 2) {
                        this.c.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 113) {
                this.a = true;
            } else {
                if (i == 114) {
                    this.b = true;
                    com.anythink.basead.ui.guidetoclickv2.a aVar = this.c;
                    if (aVar != null) {
                        aVar.a(map);
                        this.c.a();
                        return;
                    }
                    return;
                }
                if (i != 119) {
                    return;
                }
            }
        }
        a();
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a() {
        com.anythink.basead.ui.guidetoclickv2.a aVar = this.c;
        if (aVar != null) {
            aVar.c();
            this.c = null;
        }
    }
}

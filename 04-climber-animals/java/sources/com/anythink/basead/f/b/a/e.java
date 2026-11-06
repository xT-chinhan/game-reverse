package com.anythink.basead.f.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.basead.ui.BaseMediaATView;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.x;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e extends d {
    com.anythink.basead.f.c.d a;

    @Override // com.anythink.basead.f.a
    public final void a(View view, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, View view2) {
    }

    @Override // com.anythink.basead.f.a
    public final ViewGroup b() {
        return null;
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final boolean p() {
        return true;
    }

    public e(Context context, bj bjVar, x xVar, com.anythink.basead.f.c.d dVar, boolean z) {
        super(context, bjVar, xVar, z);
        this.a = dVar;
        if (dVar != null) {
            dVar.b();
        }
        this.z = this.a.c();
    }

    @Override // com.anythink.basead.f.a
    public final View a(Context context, boolean z, BaseMediaATView.a aVar) {
        com.anythink.basead.f.c.d dVar = this.a;
        if (dVar == null) {
            return null;
        }
        dVar.a(z ? 1 : 0);
        return this.a.d();
    }

    @Override // com.anythink.basead.f.b.a.d
    protected final View H() {
        return this.a.d();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void a(int i, int i2) {
        super.a(i, i2);
        if (this.B <= 0) {
            this.B = (int) ((this.A * 3.0f) / 4.0f);
        }
        com.anythink.basead.f.c.d dVar = this.a;
        if (dVar != null) {
            dVar.a(i2, i);
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void a(com.anythink.basead.g.a aVar) {
        super.a(aVar);
        com.anythink.basead.f.c.d dVar = this.a;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void a(boolean z) {
        super.a(z);
        com.anythink.basead.f.c.d dVar = this.a;
        if (dVar != null) {
            dVar.b(z ? 1 : 2);
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void a(String str) {
        super.a(str);
        if (this.a != null) {
            if (!TextUtils.isEmpty(this.y)) {
                String str2 = this.y;
                str2.hashCode();
                switch (str2) {
                    case "1":
                        this.a.c(3);
                        break;
                    case "2":
                        this.a.c(1);
                        break;
                    case "3":
                        this.a.c(2);
                        break;
                }
                return;
            }
            this.a.c(3);
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void s() {
        super.s();
        com.anythink.basead.f.c.d dVar = this.a;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void t() {
        super.t();
        com.anythink.basead.f.c.d dVar = this.a;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void r() {
        super.r();
        try {
            com.anythink.basead.f.c.d dVar = this.a;
            if (dVar != null) {
                dVar.i();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

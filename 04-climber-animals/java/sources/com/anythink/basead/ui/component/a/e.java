package com.anythink.basead.ui.component.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.anythink.basead.ui.ScanningAnimButton;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c {
    @Override // com.anythink.basead.ui.component.a.c, com.anythink.basead.ui.component.a.d
    public final void b(ViewGroup viewGroup) {
        LayoutInflater.from(viewGroup.getContext()).inflate(q.a(viewGroup.getContext(), "myoffer_large_cta_button_layout", "layout"), viewGroup);
        this.a = (ScanningAnimButton) viewGroup.findViewById(q.a(viewGroup.getContext(), "myoffer_cta_button_major", "id"));
    }

    @Override // com.anythink.basead.ui.component.a.c, com.anythink.basead.ui.component.a.d
    public final void a(ViewGroup viewGroup, w wVar, x xVar, boolean z, com.anythink.basead.ui.f.b.a aVar) {
        super.a(viewGroup, wVar, xVar, z, aVar);
        if (this.a != null) {
            if (!TextUtils.isEmpty(wVar.D())) {
                this.a.setText(wVar.D());
            } else {
                this.a.setText(com.anythink.basead.b.e.a(viewGroup.getContext(), wVar));
            }
            if (wVar.r() != null) {
                this.a.startAnimation(wVar.r().aF());
            }
        }
    }
}

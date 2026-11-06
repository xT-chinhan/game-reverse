package com.anythink.basead.ui.component.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.ui.ScanningAnimButton;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    @Override // com.anythink.basead.ui.component.a.d
    public final void c(ViewGroup viewGroup) {
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final void b(ViewGroup viewGroup) {
        LayoutInflater.from(viewGroup.getContext()).inflate(q.a(viewGroup.getContext(), "myoffer_close_cta_button_layout", "layout"), viewGroup);
        this.a = (ScanningAnimButton) viewGroup.findViewById(q.a(viewGroup.getContext(), "myoffer_cta_button_major", "id"));
        this.b = (ScanningAnimButton) viewGroup.findViewById(q.a(viewGroup.getContext(), "myoffer_cta_button_minor", "id"));
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final void a(ViewGroup viewGroup, w wVar, x xVar, boolean z, final com.anythink.basead.ui.f.b.a aVar) {
        if (this.b != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams.width > 0 && layoutParams.width < q.a(viewGroup.getContext(), 240.0f)) {
                layoutParams.width = q.a(viewGroup.getContext(), 296.0f);
                viewGroup.setLayoutParams(layoutParams);
            }
            this.b.setVisibility(0);
            if (!TextUtils.isEmpty(xVar.o.bk())) {
                this.b.setText(xVar.o.bk());
            }
            this.b.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.component.a.b.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.anythink.basead.ui.f.b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(-100, 13);
                    }
                }
            });
            this.b.setEnabled(false);
        }
        if (this.a != null) {
            if (!TextUtils.isEmpty(wVar.D())) {
                this.a.setText(wVar.D());
            } else {
                this.a.setText(com.anythink.basead.b.e.a(viewGroup.getContext(), wVar));
            }
            if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).setClipChildren(false);
            }
            if (wVar.r() != null) {
                this.a.startAnimation(wVar.r().aF());
            }
            if (aVar != null) {
                this.a.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.component.a.b.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        aVar.a(1, 1);
                    }
                });
            }
        }
    }

    @Override // com.anythink.basead.ui.component.a.a, com.anythink.basead.ui.component.a.d
    public final void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        if (this.b != null) {
            this.b.setEnabled(true);
            Context context = viewGroup.getContext();
            this.b.setBackgroundResource(q.a(context, "myoffer_splash_bg_rectangle_btn_cta_close_minor_active", "drawable"));
            this.b.setTextColor(context.getResources().getColor(q.a(context, "color_cta_text", "color")));
        }
    }
}

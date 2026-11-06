package com.smartdigimkt.v1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.smartdigimkt.i2.k;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {
    @Override // com.smartdigimkt.v1.h
    public final void a(ViewGroup viewGroup) {
    }

    @Override // com.smartdigimkt.v1.h
    public final void a(ViewGroup viewGroup, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, boolean z, k kVar) {
        if (this.b != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            int i = layoutParams.width;
            if (i > 0 && i < com.smartdigimkt.r4.k.a(viewGroup.getContext(), 240.0f)) {
                layoutParams.width = com.smartdigimkt.r4.k.a(viewGroup.getContext(), 296.0f);
                viewGroup.setLayoutParams(layoutParams);
            }
            this.b.setVisibility(0);
            if (!TextUtils.isEmpty(aVar.s.d1)) {
                this.b.setText(aVar.s.d1);
            }
            this.b.setOnClickListener(new b(kVar));
            this.b.setEnabled(false);
        }
        if (this.a != null) {
            if (TextUtils.isEmpty(cVar.h)) {
                this.a.setText(c0.a(viewGroup.getContext(), cVar));
            } else {
                this.a.setText(cVar.h);
            }
            if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).setClipChildren(false);
            }
            com.smartdigimkt.b3.e eVar = cVar.w;
            if (eVar != null) {
                this.a.startAnimation(eVar.z0);
            }
            if (kVar != null) {
                this.a.setOnClickListener(new c(kVar));
            }
        }
    }

    @Override // com.smartdigimkt.v1.h
    public final void b(ViewGroup viewGroup) {
        LayoutInflater.from(viewGroup.getContext()).inflate(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_close_cta_button_layout", "layout"), viewGroup);
        this.a = (ScanningAnimButton) viewGroup.findViewById(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_cta_button_major", "id"));
        this.b = (ScanningAnimButton) viewGroup.findViewById(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_cta_button_minor", "id"));
    }

    @Override // com.smartdigimkt.v1.a, com.smartdigimkt.v1.h
    public final void c(ViewGroup viewGroup) {
        ScanningAnimButton scanningAnimButton = this.b;
        if (scanningAnimButton != null) {
            scanningAnimButton.setEnabled(true);
            Context context = viewGroup.getContext();
            this.b.setBackgroundResource(com.smartdigimkt.r4.k.a(context, "myoffer_splash_bg_rectangle_btn_cta_close_minor_active", "drawable"));
            this.b.setTextColor(context.getResources().getColor(com.smartdigimkt.r4.k.a(context, "color_cta_text", "color")));
        }
    }
}

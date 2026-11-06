package com.smartdigimkt.v1;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class g extends a {
    @Override // com.smartdigimkt.v1.h
    public final void a(ViewGroup viewGroup) {
        ScanningAnimButton scanningAnimButton = this.b;
        if (scanningAnimButton != null) {
            scanningAnimButton.setTextColor(Color.parseColor("#FFFFFF"));
            this.b.setBackgroundResource(k.a(viewGroup.getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem_minor_white", "drawable"));
        }
    }

    @Override // com.smartdigimkt.v1.h
    public void b(ViewGroup viewGroup) {
        LayoutInflater.from(viewGroup.getContext()).inflate(k.a(viewGroup.getContext(), "myoffer_cta_button_layout", "layout"), viewGroup);
        this.a = (ScanningAnimButton) viewGroup.findViewById(k.a(viewGroup.getContext(), "myoffer_cta_button_major", "id"));
        this.b = (ScanningAnimButton) viewGroup.findViewById(k.a(viewGroup.getContext(), "myoffer_cta_button_minor", "id"));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0018  */
    @Override // com.smartdigimkt.v1.h
    public void a(ViewGroup viewGroup, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, boolean z, com.smartdigimkt.i2.k kVar) {
        boolean z2;
        if (cVar == null) {
            z2 = false;
        } else {
            int i = cVar.w.I0;
            if (i == 2) {
                z2 = z;
            } else if (i == 3) {
                z2 = !z;
            } else if (i != 4) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        ScanningAnimButton scanningAnimButton = this.b;
        if (scanningAnimButton != null) {
            if (z2) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                int i2 = layoutParams.width;
                if (i2 > 0 && i2 < k.a(viewGroup.getContext(), 240.0f)) {
                    layoutParams.width = k.a(viewGroup.getContext(), 296.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                this.b.setVisibility(0);
                if (!TextUtils.isEmpty(aVar.s.J0)) {
                    this.b.setText(aVar.s.J0);
                }
                if (kVar != null) {
                    this.b.setOnClickListener(new e(z, kVar));
                }
            } else {
                scanningAnimButton.setVisibility(8);
            }
        }
        if (this.a != null) {
            if (!TextUtils.isEmpty(cVar.h)) {
                this.a.setText(cVar.h);
            } else {
                this.a.setText(c0.a(viewGroup.getContext(), cVar));
            }
            if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).setClipChildren(false);
            }
            com.smartdigimkt.b3.e eVar = cVar.w;
            if (eVar != null) {
                this.a.startAnimation(eVar.z0);
            }
            if (kVar == null || !z2) {
                return;
            }
            this.a.setOnClickListener(new f(z, kVar));
        }
    }
}

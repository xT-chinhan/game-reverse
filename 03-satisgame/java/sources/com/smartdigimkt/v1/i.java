package com.smartdigimkt.v1;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.smartdigimkt.i2.k;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends g {
    @Override // com.smartdigimkt.v1.g, com.smartdigimkt.v1.h
    public final void a(ViewGroup viewGroup, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, boolean z, k kVar) {
        super.a(viewGroup, cVar, aVar, z, kVar);
        if (this.a != null) {
            if (TextUtils.isEmpty(cVar.h)) {
                this.a.setText(c0.a(viewGroup.getContext(), cVar));
            } else {
                this.a.setText(cVar.h);
            }
            com.smartdigimkt.b3.e eVar = cVar.w;
            if (eVar != null) {
                this.a.startAnimation(eVar.z0);
            }
        }
    }

    @Override // com.smartdigimkt.v1.g, com.smartdigimkt.v1.h
    public final void b(ViewGroup viewGroup) {
        LayoutInflater.from(viewGroup.getContext()).inflate(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_large_cta_button_layout", "layout"), viewGroup);
        this.a = (ScanningAnimButton) viewGroup.findViewById(com.smartdigimkt.r4.k.a(viewGroup.getContext(), "myoffer_cta_button_major", "id"));
    }
}

package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.i0;

/* JADX INFO: loaded from: classes3.dex */
public class JumpConfirmG2CV2View extends BaseG2CV2View {
    public LinearLayout h;

    public JumpConfirmG2CV2View(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_jump_confirm", "layout"), this);
        setBackgroundResource(k.a(getContext(), "myoffer_g2c_jump_confirm_bg", "drawable"));
        this.h = (LinearLayout) findViewById(k.a(getContext(), "myoffer_ll_jump_confirm_container", "id"));
        ((TextView) findViewById(k.a(getContext(), "myoffer_g2c_jump_confirm_ignore", "id"))).setOnClickListener(new i0(this));
        if (i != 2) {
            this.h.setPadding(k.a(getContext(), 18.0f), 0, 0, 0);
        }
    }
}

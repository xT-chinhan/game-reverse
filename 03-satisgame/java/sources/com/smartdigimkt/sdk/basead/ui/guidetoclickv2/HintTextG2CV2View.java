package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.f0;

/* JADX INFO: loaded from: classes3.dex */
public class HintTextG2CV2View extends BaseG2CV2View {
    public HintTextG2CV2View(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_hint_text", "layout"), this);
        View viewFindViewById = findViewById(k.a(getContext(), "myoffer_g2c_click_text", "id"));
        View viewFindViewById2 = findViewById(k.a(getContext(), "myoffer_g2c_hint_text", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new f0(this));
        }
        if (i != 2) {
            if (i2 == 2) {
                if (viewFindViewById != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
                    layoutParams.addRule(11, 0);
                    layoutParams.addRule(14);
                    layoutParams.setMargins(0, k.a(getContext(), 12.0f), 0, 0);
                    viewFindViewById.setLayoutParams(layoutParams);
                }
                if (viewFindViewById2 == null || !(viewFindViewById2 instanceof TextView)) {
                    return;
                }
                ((TextView) viewFindViewById2).setGravity(17);
                return;
            }
            return;
        }
        if (viewFindViewById != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(14);
            layoutParams2.setMargins(0, k.a(getContext(), 12.0f), 0, 0);
            viewFindViewById.setLayoutParams(layoutParams2);
        }
        if (viewFindViewById2 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
            layoutParams3.setMargins(k.a(getContext(), 60.0f), k.a(getContext(), 18.0f), k.a(getContext(), 60.0f), 0);
            viewFindViewById2.setLayoutParams(layoutParams3);
            if (viewFindViewById2 instanceof TextView) {
                TextView textView = (TextView) viewFindViewById2;
                textView.setGravity(17);
                textView.setTextSize(1, 14.0f);
            }
        }
    }
}

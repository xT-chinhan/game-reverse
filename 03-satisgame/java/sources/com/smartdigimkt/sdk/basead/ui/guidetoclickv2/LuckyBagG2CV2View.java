package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.SimpleGuideToClickView;
import com.smartdigimkt.y1.j0;
import com.smartdigimkt.y1.k0;
import com.smartdigimkt.y1.l0;
import com.smartdigimkt.y1.m0;
import com.smartdigimkt.y1.n0;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class LuckyBagG2CV2View extends BaseLifecycleG2CV2View {
    public SimpleGuideToClickView i;
    public ImageView j;
    public ImageView k;
    public View l;

    public LuckyBagG2CV2View(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View
    public int getClickArea() {
        return 43;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_lucky_bag", "layout"), this);
        setBackgroundColor(Color.parseColor("#80000000"));
        this.k = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        this.l = findViewById(k.a(getContext(), "myoffer_g2c_item_container", "id"));
        this.i = (SimpleGuideToClickView) findViewById(k.a(getContext(), "myoffer_g2c_item_g2c_fingerview", "id"));
        ImageView imageView = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_lucky_bag_icon", "id"));
        this.j = imageView;
        if (imageView != null) {
            String strB = d.a().b(b.d.m);
            if (!TextUtils.isEmpty(strB)) {
                d0.a().a(new o(3, strB), -1, -1, new j0(this));
            }
        }
        SimpleGuideToClickView simpleGuideToClickView = this.i;
        if (simpleGuideToClickView != null) {
            simpleGuideToClickView.init(k.a(getContext(), "myoffer_simple_guide_to_click", "layout"), k.a(getContext(), 4.0f), k.a(getContext(), 6.0f), k.a(getContext(), 8.0f), k.a(getContext(), 12.0f));
            ImageView imageView2 = (ImageView) this.i.findViewById(k.a(getContext(), "myoffer_guide_to_click_finger", "id"));
            if (imageView2 != null) {
                String strB2 = d.a().b(b.d.k);
                if (!TextUtils.isEmpty(strB2)) {
                    d0.a().a(new o(3, strB2), -1, -1, new k0(imageView2));
                }
            }
        }
        this.l.setOnClickListener(new l0(this));
        setOnClickListener(new m0());
        ImageView imageView3 = this.k;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new n0(this));
        }
    }
}

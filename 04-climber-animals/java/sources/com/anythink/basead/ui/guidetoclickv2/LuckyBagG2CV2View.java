package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.anythink.basead.ui.SimpleGuideToClickView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class LuckyBagG2CV2View extends BaseLifecycleG2CV2View {
    SimpleGuideToClickView d;
    ImageView e;
    ImageView f;
    View g;

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View
    final int e() {
        return 43;
    }

    public LuckyBagG2CV2View(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_lucky_bag", "layout"), this);
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        this.g = findViewById(q.a(getContext(), "myoffer_g2c_item_container", "id"));
        this.d = (SimpleGuideToClickView) findViewById(q.a(getContext(), "myoffer_g2c_item_g2c_fingerview", "id"));
        ImageView imageView = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_lucky_bag_icon", "id"));
        this.e = imageView;
        if (imageView != null) {
            String strA = g.a().a(com.anythink.core.common.a.b.d.m);
            if (!TextUtils.isEmpty(strA)) {
                com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.LuckyBagG2CV2View.1
                    @Override // com.anythink.core.common.res.b.a
                    public final void onFail(String str, String str2) {
                    }

                    @Override // com.anythink.core.common.res.b.a
                    public final void onSuccess(String str, Bitmap bitmap) {
                        if (LuckyBagG2CV2View.this.e != null) {
                            LuckyBagG2CV2View.this.e.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        }
        SimpleGuideToClickView simpleGuideToClickView = this.d;
        if (simpleGuideToClickView != null) {
            simpleGuideToClickView.init(q.a(getContext(), "myoffer_simple_guide_to_click", "layout"), q.a(getContext(), 4.0f), q.a(getContext(), 6.0f), q.a(getContext(), 8.0f), q.a(getContext(), 12.0f));
            final ImageView imageView2 = (ImageView) this.d.findViewById(q.a(getContext(), "myoffer_guide_to_click_finger", "id"));
            if (imageView2 != null) {
                String strA2 = g.a().a(com.anythink.core.common.a.b.d.k);
                if (!TextUtils.isEmpty(strA2)) {
                    com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA2), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.LuckyBagG2CV2View.2
                        @Override // com.anythink.core.common.res.b.a
                        public final void onFail(String str, String str2) {
                        }

                        @Override // com.anythink.core.common.res.b.a
                        public final void onSuccess(String str, Bitmap bitmap) {
                            ImageView imageView3 = imageView2;
                            if (imageView3 != null) {
                                imageView3.setImageBitmap(bitmap);
                            }
                        }
                    });
                }
            }
        }
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.LuckyBagG2CV2View.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LuckyBagG2CV2View.this.removeAllViews();
                LuckyBagG2CV2View.this.d();
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.LuckyBagG2CV2View.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        ImageView imageView3 = this.f;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.LuckyBagG2CV2View.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyBagG2CV2View.this.c();
                }
            });
        }
    }
}

package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.s;

/* JADX INFO: loaded from: classes.dex */
public class GTCV2InnerCountDownView extends RelativeLayout {
    s a;
    TextView b;
    TextView c;
    TextView d;
    ImageView e;
    ImageView f;
    ImageView g;
    final long h;
    final long i;
    private a j;

    public interface a {
        void a();

        void b();
    }

    public GTCV2InnerCountDownView(Context context) {
        super(context);
        this.h = 120000L;
        this.i = 500L;
        a();
    }

    public GTCV2InnerCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 120000L;
        this.i = 500L;
        a();
    }

    public GTCV2InnerCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 120000L;
        this.i = 500L;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_inner_count_down_view", "layout"), this);
        this.e = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        this.f = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_gift_icon", "id"));
        this.g = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_ribbon", "id"));
        this.b = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_ct_min", "id"));
        this.c = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_ct_sec", "id"));
        this.d = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_ct_cta", "id"));
        String strA = g.a().a(com.anythink.core.common.a.b.d.g);
        if (!TextUtils.isEmpty(strA)) {
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (GTCV2InnerCountDownView.this.f != null) {
                        GTCV2InnerCountDownView.this.f.setImageBitmap(bitmap);
                    }
                }
            });
        }
        String strA2 = g.a().a(com.anythink.core.common.a.b.d.h);
        if (TextUtils.isEmpty(strA2)) {
            return;
        }
        com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA2), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.2
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, Bitmap bitmap) {
                if (GTCV2InnerCountDownView.this.g != null) {
                    GTCV2InnerCountDownView.this.g.setImageBitmap(bitmap);
                }
            }
        });
    }

    public void initSetting(final a aVar) {
        this.j = aVar;
        s sVar = new s() { // from class: com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(120000L);
            }

            @Override // com.anythink.core.common.v.s
            public final void a(long j) {
                long j2 = j / 1000;
                int i = (int) (j2 / 60);
                int i2 = (int) (j2 % 60);
                if (GTCV2InnerCountDownView.this.b != null) {
                    GTCV2InnerCountDownView.this.b.setText(String.format("%02d", Integer.valueOf(i)));
                }
                if (GTCV2InnerCountDownView.this.c != null) {
                    GTCV2InnerCountDownView.this.c.setText(String.format("%02d", Integer.valueOf(i2)));
                }
            }

            @Override // com.anythink.core.common.v.s
            public final void a() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        };
        this.a = sVar;
        sVar.b();
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        });
    }

    public final void onResume() {
        s sVar = this.a;
        if (sVar != null) {
            sVar.e();
        }
    }

    public final void onPause() {
        s sVar = this.a;
        if (sVar != null) {
            sVar.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public final void release() {
        s sVar = this.a;
        if (sVar != null) {
            sVar.c();
        }
    }
}

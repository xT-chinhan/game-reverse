package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.p;
import com.smartdigimkt.y1.q;
import com.smartdigimkt.y1.r;
import com.smartdigimkt.y1.s;
import com.smartdigimkt.y1.t;
import com.smartdigimkt.y1.u;
import com.smartdigimkt.y1.v;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class GTCV2InnerCountDownView extends RelativeLayout {
    public r a;
    public TextView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;

    public GTCV2InnerCountDownView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_inner_count_down_view", "layout"), this);
        this.e = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_close_iv", "id"));
        this.f = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_gift_icon", "id"));
        this.g = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_ribbon", "id"));
        this.b = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_ct_min", "id"));
        this.c = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_ct_sec", "id"));
        this.d = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_ct_cta", "id"));
        String strB = d.a().b(b.d.g);
        if (!TextUtils.isEmpty(strB)) {
            d0.a().a(new o(3, strB), -1, -1, new p(this));
        }
        String strB2 = d.a().b(b.d.h);
        if (TextUtils.isEmpty(strB2)) {
            return;
        }
        d0.a().a(new o(3, strB2), -1, -1, new q(this));
    }

    public void initSetting(v vVar) {
        r rVar = new r(this, vVar);
        this.a = rVar;
        rVar.a(rVar.e, rVar.b);
        setOnClickListener(new s());
        this.d.setOnClickListener(new t(vVar));
        this.e.setOnClickListener(new u(vVar));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public final void onPause() {
        r rVar = this.a;
        if (rVar != null) {
            rVar.b();
        }
    }

    public final void onResume() {
        r rVar = this.a;
        if (rVar == null || (!rVar.c)) {
            return;
        }
        rVar.a(rVar.e, rVar.b);
    }

    public final void release() {
        r rVar = this.a;
        if (rVar != null) {
            rVar.c();
        }
    }

    public GTCV2InnerCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GTCV2InnerCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}

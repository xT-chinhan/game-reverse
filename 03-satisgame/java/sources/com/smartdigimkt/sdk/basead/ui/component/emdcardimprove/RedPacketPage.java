package com.smartdigimkt.sdk.basead.ui.component.emdcardimprove;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.i2.k;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.p1.h;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.w1.i;
import com.smartdigimkt.w1.j;
import com.smartdigimkt.w1.l;
import com.smartdigimkt.w1.n;
import com.smartdigimkt.z.d0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class RedPacketPage extends RelativeLayout {
    public final RelativeLayout a;
    public final RelativeLayout b;
    public final RoundImageView c;
    public final RoundImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final TextView n;
    public h o;
    public ValueAnimator p;
    public ValueAnimator q;
    public final ArrayList r;
    public int s;
    public k t;

    public RedPacketPage(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            h hVar = this.o;
            if (hVar != null) {
                hVar.a();
                return;
            }
            return;
        }
        h hVar2 = this.o;
        if (hVar2 != null) {
            hVar2.pause();
        }
    }

    public void setAdBless(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.h.setText(str);
        this.i.setText(str);
    }

    public void setAdIconUrl(String str) {
        if (this.c == null || this.d == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
        } else {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            m.a(getContext()).a(new o(1, str), layoutParams.width, layoutParams.height, new n(this, str));
        }
    }

    public void setAdNotice(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setText(str);
        } else if (i == 4) {
            this.g.setText(getResources().getString(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_hint_link4_text", "string")));
        }
    }

    public void setAdTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setText(str);
        this.f.setText(str);
    }

    public void setCTAText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.setText(str);
    }

    public void setOpenIconClickClickAction(int i) {
        this.s = i;
    }

    public void setRedPacketClickListener(k kVar) {
        this.t = kVar;
    }

    public void stopAnimation() {
        h hVar = this.o;
        if (hVar != null) {
            hVar.stop();
            this.o = null;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.p = null;
        }
        ValueAnimator valueAnimator2 = this.q;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.q = null;
        }
    }

    public RedPacketPage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(com.smartdigimkt.r4.k.a(getContext(), "myoffer_endcard_improve_red_packet", "layout"), this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_receive_page", "id"));
        this.b = relativeLayout;
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_cover", "id"));
        this.a = relativeLayout2;
        this.k = (ImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_half_topbg", "id"));
        this.l = (ImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_half_bottombg", "id"));
        RoundImageView roundImageView = (RoundImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_ad_icon", "id"));
        this.c = roundImageView;
        RoundImageView roundImageView2 = (RoundImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_ad_icon_2", "id"));
        this.d = roundImageView2;
        this.e = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_ad_title", "id"));
        TextView textView = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_ad_title_2", "id"));
        this.f = textView;
        this.h = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_ad_bless", "id"));
        TextView textView2 = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_ad_bless_2", "id"));
        this.i = textView2;
        TextView textView3 = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_ad_hint_link", "id"));
        this.g = textView3;
        ImageView imageView = (ImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_open_icon", "id"));
        this.j = imageView;
        this.m = (ImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_anim_open_icon", "id"));
        TextView textView4 = (TextView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_cta", "id"));
        this.n = textView4;
        roundImageView.setRadiusInDip(18);
        roundImageView.setNeedRadiu(true);
        roundImageView2.setRadiusInDip(12);
        roundImageView2.setNeedRadiu(true);
        ArrayList arrayList = new ArrayList();
        this.r = arrayList;
        arrayList.add(Integer.valueOf(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_frame1", "drawable")));
        arrayList.add(Integer.valueOf(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_frame2", "drawable")));
        arrayList.add(Integer.valueOf(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_frame3", "drawable")));
        arrayList.add(Integer.valueOf(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_frame4", "drawable")));
        arrayList.add(Integer.valueOf(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_frame5", "drawable")));
        arrayList.add(Integer.valueOf(com.smartdigimkt.r4.k.a(getContext(), "myoffer_red_packet_frame6", "drawable")));
        if (imageView != null) {
            h hVar = this.o;
            if (hVar != null) {
                hVar.stop();
            }
            h hVar2 = new h(imageView);
            this.o = hVar2;
            hVar2.e = 0.85f;
            hVar2.start();
        }
        imageView.setOnClickListener(new i(this));
        relativeLayout2.setOnClickListener(new j(this));
        setOnClickListener(new com.smartdigimkt.w1.k(this));
        l lVar = new l(this);
        textView4.setOnClickListener(lVar);
        textView.setOnClickListener(lVar);
        roundImageView2.setOnClickListener(lVar);
        textView2.setOnClickListener(lVar);
        textView3.setOnClickListener(lVar);
        relativeLayout.setOnClickListener(new com.smartdigimkt.w1.m(this));
        String strB = d.a().b(b.d.a);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        d0.a().a(new o(3, strB), -1, -1, new com.smartdigimkt.w1.d(this));
    }
}

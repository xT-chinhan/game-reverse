package com.anythink.basead.ui.component.emdcardimprove;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.a.a.e;
import com.anythink.basead.ui.f.b;
import com.anythink.core.common.d.t;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RedPacketPage extends RelativeLayout {
    RelativeLayout a;
    RelativeLayout b;
    RoundImageView c;
    RoundImageView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    ImageView j;
    ImageView k;
    ImageView l;
    ImageView m;
    TextView n;
    ValueAnimator o;
    ValueAnimator p;
    b.a q;
    private e r;
    private List<Integer> s;
    private int t;

    public RedPacketPage(Context context) {
        this(context, null);
    }

    public RedPacketPage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_endcard_improve_red_packet", "layout"), this);
        this.b = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_red_packet_receive_page", "id"));
        this.a = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_red_packet_cover", "id"));
        this.k = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_half_topbg", "id"));
        this.l = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_half_bottombg", "id"));
        this.c = (RoundImageView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_icon", "id"));
        this.d = (RoundImageView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_icon_2", "id"));
        this.e = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_title", "id"));
        this.f = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_title_2", "id"));
        this.h = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_bless", "id"));
        this.i = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_bless_2", "id"));
        this.g = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_hint_link", "id"));
        this.j = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_open_icon", "id"));
        this.m = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_anim_open_icon", "id"));
        this.n = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_cta", "id"));
        this.c.setRadiusInDip(18);
        this.c.setNeedRadiu(true);
        this.d.setRadiusInDip(12);
        this.d.setNeedRadiu(true);
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        arrayList.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame1", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame2", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame3", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame4", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame5", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame6", "drawable")));
        a(this.j);
        this.j.setOnClickListener(new AnonymousClass2());
        this.a.setOnClickListener(new AnonymousClass3());
        setOnClickListener(new AnonymousClass4());
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        this.n.setOnClickListener(anonymousClass5);
        this.f.setOnClickListener(anonymousClass5);
        this.d.setOnClickListener(anonymousClass5);
        this.i.setOnClickListener(anonymousClass5);
        this.g.setOnClickListener(anonymousClass5);
        this.b.setOnClickListener(new AnonymousClass6());
        String strA = g.a().a(com.anythink.core.common.a.b.d.a);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.anythink.core.common.res.b.a(t.b().g()).a(new com.anythink.core.common.res.e(3, strA), new AnonymousClass1());
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_endcard_improve_red_packet", "layout"), this);
        this.b = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_red_packet_receive_page", "id"));
        this.a = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_red_packet_cover", "id"));
        this.k = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_half_topbg", "id"));
        this.l = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_half_bottombg", "id"));
        this.c = (RoundImageView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_icon", "id"));
        this.d = (RoundImageView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_icon_2", "id"));
        this.e = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_title", "id"));
        this.f = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_title_2", "id"));
        this.h = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_bless", "id"));
        this.i = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_bless_2", "id"));
        this.g = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_ad_hint_link", "id"));
        this.j = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_open_icon", "id"));
        this.m = (ImageView) findViewById(q.a(getContext(), "myoffer_red_packet_anim_open_icon", "id"));
        this.n = (TextView) findViewById(q.a(getContext(), "myoffer_red_packet_cta", "id"));
        this.c.setRadiusInDip(18);
        this.c.setNeedRadiu(true);
        this.d.setRadiusInDip(12);
        this.d.setNeedRadiu(true);
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        arrayList.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame1", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame2", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame3", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame4", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame5", "drawable")));
        this.s.add(Integer.valueOf(q.a(getContext(), "myoffer_red_packet_frame6", "drawable")));
        a(this.j);
        this.j.setOnClickListener(new AnonymousClass2());
        this.a.setOnClickListener(new AnonymousClass3());
        setOnClickListener(new AnonymousClass4());
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        this.n.setOnClickListener(anonymousClass5);
        this.f.setOnClickListener(anonymousClass5);
        this.d.setOnClickListener(anonymousClass5);
        this.i.setOnClickListener(anonymousClass5);
        this.g.setOnClickListener(anonymousClass5);
        this.b.setOnClickListener(new AnonymousClass6());
        String strA = g.a().a(com.anythink.core.common.a.b.d.a);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.anythink.core.common.res.b.a(t.b().g()).a(new com.anythink.core.common.res.e(3, strA), new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (RedPacketPage.this.k != null) {
                RedPacketPage.this.k.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (RedPacketPage.this.q != null) {
                RedPacketPage.this.q.a(14, 27);
            }
            RedPacketPage.this.stopAnimation();
            if (RedPacketPage.this.t == 1) {
                RedPacketPage.this.j.setVisibility(8);
                RedPacketPage.this.m.setVisibility(0);
                RedPacketPage redPacketPage = RedPacketPage.this;
                redPacketPage.o = ValueAnimator.ofInt(0, redPacketPage.s.size() - 1);
                RedPacketPage.this.o.setDuration(RedPacketPage.this.s.size() * 80);
                RedPacketPage.this.o.setRepeatCount(1);
                RedPacketPage.this.o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (RedPacketPage.this.m == null || iIntValue >= RedPacketPage.this.s.size()) {
                            return;
                        }
                        RedPacketPage.this.m.setImageResource(((Integer) RedPacketPage.this.s.get(iIntValue)).intValue());
                    }
                });
                RedPacketPage.this.o.addListener(new AnimatorListenerAdapter() { // from class: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage.2.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        final int y = (int) RedPacketPage.this.a.getY();
                        RedPacketPage.this.p = ValueAnimator.ofInt(0, y);
                        RedPacketPage.this.p.setDuration(300L);
                        RedPacketPage.this.p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage.2.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                float f = -iIntValue;
                                RedPacketPage.this.k.setTranslationY(f);
                                RedPacketPage.this.c.setTranslationY(f);
                                RedPacketPage.this.e.setTranslationY(f);
                                RedPacketPage.this.h.setTranslationY(f);
                                RedPacketPage.this.k.setTranslationY(f);
                                float f2 = iIntValue;
                                RedPacketPage.this.l.setTranslationY(f2);
                                if (RedPacketPage.this.b != null) {
                                    RedPacketPage.this.b.setAlpha(((f2 * 1.0f) / y) * 0.8f);
                                }
                            }
                        });
                        RedPacketPage.this.p.addListener(new AnimatorListenerAdapter() { // from class: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage.2.2.2
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator2) {
                                super.onAnimationEnd(animator2);
                                if (RedPacketPage.this.a != null) {
                                    RedPacketPage.this.a.setVisibility(8);
                                }
                                if (RedPacketPage.this.b != null) {
                                    RedPacketPage.this.b.setAlpha(1.0f);
                                    RedPacketPage.this.b.setVisibility(0);
                                }
                                RedPacketPage.this.a(RedPacketPage.this.n);
                            }
                        });
                        if (RedPacketPage.this.b != null) {
                            RedPacketPage.this.b.setAlpha(0.0f);
                            RedPacketPage.this.b.setVisibility(0);
                        }
                        RedPacketPage.this.p.start();
                        RedPacketPage.this.m.setVisibility(8);
                    }
                });
                RedPacketPage.this.o.start();
            }
        }
    }

    private void b() {
        this.j.setOnClickListener(new AnonymousClass2());
        this.a.setOnClickListener(new AnonymousClass3());
        setOnClickListener(new AnonymousClass4());
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        this.n.setOnClickListener(anonymousClass5);
        this.f.setOnClickListener(anonymousClass5);
        this.d.setOnClickListener(anonymousClass5);
        this.i.setOnClickListener(anonymousClass5);
        this.g.setOnClickListener(anonymousClass5);
        this.b.setOnClickListener(new AnonymousClass6());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (RedPacketPage.this.q != null) {
                RedPacketPage.this.q.a(14, 28);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage$4, reason: invalid class name */
    final class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (RedPacketPage.this.q != null) {
                RedPacketPage.this.q.a(14, 29);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (RedPacketPage.this.q != null) {
                RedPacketPage.this.q.a(14, 30);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage$6, reason: invalid class name */
    final class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (RedPacketPage.this.q != null) {
                RedPacketPage.this.q.a(14, 31);
            }
        }
    }

    public void setRedPacketClickListener(b.a aVar) {
        this.q = aVar;
    }

    public void setAdTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.setText(str);
        this.f.setText(str);
    }

    public void setAdBless(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.h.setText(str);
        this.i.setText(str);
    }

    public void setAdNotice(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setText(str);
        } else if (i == 4) {
            this.g.setText(getResources().getString(q.a(getContext(), "myoffer_red_packet_hint_link4_text", "string")));
        }
    }

    public void setCTAText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.setText(str);
    }

    public void setAdIconUrl(final String str) {
        if (this.c == null || this.d == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, str), layoutParams.width, layoutParams.height, new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.component.emdcardimprove.RedPacketPage.7
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str2, String str3) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str2, Bitmap bitmap) {
                    if (TextUtils.equals(str2, str)) {
                        if (RedPacketPage.this.c != null) {
                            RedPacketPage.this.c.setImageBitmap(bitmap);
                        }
                        if (RedPacketPage.this.d != null) {
                            RedPacketPage.this.d.setImageBitmap(bitmap);
                        }
                    }
                }
            });
            return;
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    public void setOpenIconClickClickAction(int i) {
        this.t = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        e eVar = this.r;
        if (eVar != null) {
            eVar.d();
        }
        e eVar2 = new e(view);
        this.r = eVar2;
        eVar2.g();
        this.r.a();
    }

    private void c() {
        e eVar = this.r;
        if (eVar != null) {
            eVar.b();
        }
    }

    private void d() {
        e eVar = this.r;
        if (eVar != null) {
            eVar.c();
        }
    }

    public void stopAnimation() {
        e eVar = this.r;
        if (eVar != null) {
            eVar.d();
            this.r = null;
        }
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.o = null;
        }
        ValueAnimator valueAnimator2 = this.p;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.p = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            e eVar = this.r;
            if (eVar != null) {
                eVar.c();
                return;
            }
            return;
        }
        e eVar2 = this.r;
        if (eVar2 != null) {
            eVar2.b();
        }
    }
}

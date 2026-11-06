package com.anythink.basead.ui.c;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.component.emdcardimprove.RPSecondEndCardView;
import com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView;
import com.anythink.basead.ui.simpleview.SimplePlayer;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {
    ViewGroup o;
    SimplePlayer p;
    SecondEndCardView q;
    com.anythink.basead.ui.f.a r;
    int s;
    private boolean t;

    static /* synthetic */ boolean a(e eVar) {
        eVar.t = true;
        return true;
    }

    public e(Context context, w wVar, x xVar, com.anythink.basead.ui.improveclick.c.a aVar, int i, ViewGroup viewGroup) {
        super(context, wVar, xVar, aVar, i, viewGroup);
        this.t = false;
        this.s = 1;
    }

    @Override // com.anythink.basead.ui.c.a
    public final void a(ViewGroup viewGroup) {
        String strAZ;
        super.a(viewGroup);
        this.o = viewGroup;
        y yVarR = this.b.r();
        if (yVarR != null) {
            strAZ = yVarR.aZ();
            this.s = yVarR.be();
        } else {
            strAZ = "";
        }
        b(this.c.o.aP());
        this.n.setCountDownEndDrawable(am.a(this.a, q.a(this.a, "myoffer_base_skip_icon", "drawable")));
        SimplePlayer simplePlayer = new SimplePlayer(this.a);
        this.p = simplePlayer;
        viewGroup.addView(simplePlayer, -1, -1);
        this.p.load(strAZ, true);
        this.p.setSimplePlayerViewListener(new SimplePlayer.a() { // from class: com.anythink.basead.ui.c.e.1
            @Override // com.anythink.basead.ui.simpleview.SimplePlayer.a
            public final void a() {
                e.a(e.this);
            }

            @Override // com.anythink.basead.ui.simpleview.SimplePlayer.a
            public final void b() {
                if (!e.this.t && e.this.p != null) {
                    am.a(e.this.p);
                }
                e.this.e();
                e.this.n.refresh(e.this.m);
                if (e.this.n != null) {
                    e.this.n.setVisibility(0);
                    e.this.n.setCountDownEndDrawable(am.a(e.this.a, q.a(e.this.a, "myoffer_base_close_icon", "drawable")));
                    e.this.n.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.e.1.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            if (e.this.h != null) {
                                e.this.h.b();
                            }
                        }
                    });
                }
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.e != null) {
                    e.this.e.a(14, 32);
                }
            }
        });
        RPSecondEndCardView rPSecondEndCardView = new RPSecondEndCardView(this.a);
        this.q = rPSecondEndCardView;
        if (yVarR != null) {
            rPSecondEndCardView.setAdTitle(yVarR.bb());
            this.q.setAdIcon(yVarR.ba());
            this.q.setAdPoster(yVarR.bc());
            String strBd = yVarR.bd();
            if (TextUtils.isEmpty(strBd)) {
                if (this.b.K() == 4) {
                    this.q.setCTAText(this.a.getResources().getString(q.a(this.a, "myoffer_rp_second_hint_link4_text", "string")));
                }
            } else {
                this.q.setCTAText(strBd);
            }
        }
        this.q.setBackgroundColor(Color.parseColor("#CC000000"));
        View viewInflate = LayoutInflater.from(this.a).inflate(q.a(this.a, "myoffer_include_4_element", "layout"), (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        viewGroup.addView(viewInflate, layoutParams);
        com.anythink.basead.ui.f.a aVar = new com.anythink.basead.ui.f.a(this.b, this.c);
        this.r = aVar;
        aVar.b(viewGroup);
    }

    @Override // com.anythink.basead.ui.c.a
    protected final void a(long j) {
        super.a(j);
        if (this.l >= this.m) {
            com.anythink.basead.ui.f.b.a(this.n, true, this.c, false);
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.e.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.n.setCountDownEndDrawable(am.a(e.this.a, q.a(e.this.a, "myoffer_base_close_icon", "drawable")));
                    e.this.n.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.e.3.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            if (e.this.h != null) {
                                e.this.h.b();
                            }
                        }
                    });
                    if (e.this.p != null) {
                        e.this.p.stopVideo();
                    }
                    if (e.this.h != null) {
                        e.this.h.a(true);
                    }
                    if (e.this.q != null && e.this.q.getParent() == null) {
                        e.this.o.addView(e.this.q, 1, new FrameLayout.LayoutParams(-1, -1));
                        e.this.q.setSecondECClickListener(new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.ui.c.e.3.2
                            @Override // com.anythink.basead.ui.f.b.a
                            public final void a(int i, int i2) {
                                boolean z = true;
                                boolean z2 = false;
                                switch (i2) {
                                    case 33:
                                    case 35:
                                        if (e.this.s < 2) {
                                            z = false;
                                            break;
                                        }
                                    case 34:
                                        z2 = z;
                                        break;
                                }
                                if (!z2 || e.this.e == null) {
                                    return;
                                }
                                e.this.e.a(i, i2);
                            }
                        });
                    }
                    com.anythink.basead.ui.f.b.a(e.this.n, true, e.this.c, false);
                    e.this.a(true);
                }
            });
        }
    }

    private void b(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.a).inflate(q.a(this.a, "myoffer_include_4_element", "layout"), (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        viewGroup.addView(viewInflate, layoutParams);
    }
}

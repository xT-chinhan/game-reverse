package com.anythink.basead.ui.c;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.component.emdcardimprove.SecondEndCardView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    SecondEndCardView o;
    com.anythink.basead.ui.f.a p;
    int q;
    boolean r;
    boolean s;
    private View t;

    public d(Context context, w wVar, x xVar, com.anythink.basead.ui.improveclick.c.a aVar, int i, ViewGroup viewGroup) {
        super(context, wVar, xVar, aVar, i, viewGroup);
        this.q = 1;
    }

    @Override // com.anythink.basead.ui.c.a
    public final void a(final ViewGroup viewGroup) {
        super.a(viewGroup);
        this.t = this.g;
        this.q = this.c.o.aW();
        SecondEndCardView secondEndCardView = new SecondEndCardView(this.a);
        this.o = secondEndCardView;
        secondEndCardView.setAdTitle(this.b.x());
        this.o.setAdDesc(this.b.y());
        if (!TextUtils.isEmpty(this.b.z())) {
            this.o.setAdIcon(this.b.z());
        } else {
            this.o.setAdIcon(this.b.B());
        }
        if (!TextUtils.isEmpty(this.b.D())) {
            this.o.setCTAText(this.b.D());
        } else {
            this.o.setCTAText(this.a.getString(com.anythink.basead.b.e.a(this.a, this.b)));
        }
        boolean z = this.f != 1;
        this.r = z;
        this.o.addApkComplianceElements(!z);
        if (!this.r) {
            this.o.setBackgroundColor(Color.parseColor("#CC000000"));
        }
        View viewC = this.h != null ? this.h.c() : null;
        if (viewC == null) {
            viewC = b();
        }
        if (viewC != null) {
            if ((viewC instanceof TextView) && TextUtils.isEmpty(this.c.o.bk())) {
                ((TextView) viewC).setText(q.a(this.a, "myoffer_sub_close_default_skip_text", "string"));
            }
            if (viewC instanceof ImageView) {
                viewC.setBackgroundResource(q.a(this.a, "myoffer_base_skip_icon", "drawable"));
            }
            viewC.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.d.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (d.this.h != null) {
                        d.this.h.a(true);
                    }
                    if (d.this.o != null && d.this.o.getParent() == null) {
                        if (d.this.r) {
                            if (d.this.g != null) {
                                d.this.g.setVisibility(4);
                                if (d.this.g.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) d.this.g.getParent()).addView(d.this.o, -1, -1);
                                }
                            }
                        } else {
                            viewGroup.addView(d.this.o, -1, -1);
                        }
                        d dVar = d.this;
                        dVar.t = dVar.o;
                        d.this.p = new com.anythink.basead.ui.f.a(d.this.b, d.this.c);
                        d.this.p.b(d.this.o);
                        d.this.o.setSecondECClickListener(new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.ui.c.d.1.1
                            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                            /* JADX WARN: Code duplicated, block: B:8:0x0010  */
                            @Override // com.anythink.basead.ui.f.b.a
                            public final void a(int i, int i2) {
                                boolean z2 = true;
                                boolean z3 = false;
                                switch (i2) {
                                    case 36:
                                        z3 = z2;
                                        break;
                                    case 37:
                                        if (d.this.q < 2) {
                                            z2 = false;
                                        }
                                        z3 = z2;
                                        break;
                                    case 38:
                                        if (d.this.q < 3) {
                                            z2 = false;
                                        }
                                        z3 = z2;
                                        break;
                                }
                                if (!z3 || d.this.e == null) {
                                    return;
                                }
                                d.this.e.a(i, i2);
                            }
                        });
                    }
                    d dVar2 = d.this;
                    dVar2.b(dVar2.c.o.aY());
                    if (d.this.r && d.this.n != null) {
                        am.a(d.this.n);
                        ViewGroup.LayoutParams layoutParams = d.this.n.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
                        layoutParams2.addRule(11);
                        layoutParams2.setMargins(0, q.a(d.this.a, 8.0f), q.a(d.this.a, 8.0f), 0);
                        d.this.o.addCloseView(d.this.n, layoutParams2);
                    }
                    d.this.a(true);
                }
            });
        }
        this.s = false;
    }

    @Override // com.anythink.basead.ui.c.a
    public final void d() {
        super.d();
        this.s = true;
    }

    @Override // com.anythink.basead.ui.c.a
    protected final void a(long j) {
        super.a(j);
        if (this.l >= this.m) {
            com.anythink.basead.ui.f.b.a(this.n, true, this.c, false);
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.d.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (!d.this.s && d.this.q == 4) {
                        if (d.this.e != null) {
                            d.this.e.a(1, 39);
                        }
                    } else if (d.this.h != null) {
                        d.this.h.b();
                    }
                }
            });
        }
    }

    @Override // com.anythink.basead.ui.c.a
    protected final View f() {
        return this.t;
    }
}

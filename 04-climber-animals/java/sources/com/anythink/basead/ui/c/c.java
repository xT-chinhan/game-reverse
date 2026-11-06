package com.anythink.basead.ui.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.ui.component.emdcardimprove.RedPacketPage;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    com.anythink.basead.ui.f.a o;
    int p;
    int q;
    private RedPacketPage r;

    public c(Context context, w wVar, x xVar, com.anythink.basead.ui.improveclick.c.a aVar, int i, ViewGroup viewGroup) {
        super(context, wVar, xVar, aVar, i, viewGroup);
    }

    @Override // com.anythink.basead.ui.c.a
    public final void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        this.p = this.c.o.aV() / 10;
        this.q = this.c.o.aV() % 10;
        this.r = new RedPacketPage(this.a);
        com.anythink.basead.ui.f.a aVar = new com.anythink.basead.ui.f.a(this.b, this.c);
        this.o = aVar;
        aVar.b(this.r);
        this.r.setOpenIconClickClickAction(this.c.o.aU());
        this.r.setRedPacketClickListener(new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.ui.c.c.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code duplicated, block: B:9:0x0010  */
            @Override // com.anythink.basead.ui.f.b.a
            public final void a(int i, int i2) {
                boolean z;
                boolean z2 = true;
                switch (i2) {
                    case 27:
                        z = c.this.c.o.aU() == 2;
                        if (!z) {
                            com.anythink.basead.ui.f.b.a(c.this.n, true, c.this.c, false);
                        }
                        z2 = z;
                        break;
                    case 28:
                        if (c.this.p < 2) {
                            z2 = false;
                        }
                        z = false;
                        break;
                    case 29:
                        if (c.this.p <= 0) {
                            z2 = false;
                        }
                        z = false;
                        break;
                    case 30:
                        z = false;
                        break;
                    case 31:
                        if (c.this.q <= 0) {
                            z2 = false;
                        }
                        z = false;
                        break;
                    default:
                        z = false;
                        z2 = z;
                        break;
                }
                if (z2 && c.this.e != null) {
                    c.this.e.a(i, i2);
                }
                if (z) {
                    if (c.this.r != null) {
                        am.a(c.this.r);
                        if (c.this.h != null) {
                            c.this.h.a(false);
                        }
                    }
                    c.this.n.setVisibility(0);
                    c.this.n.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.c.1.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            if (c.this.h != null) {
                                c.this.h.b();
                            }
                        }
                    });
                }
            }
        });
        if (this.b != null) {
            String strX = this.b.x();
            if ((this.b instanceof r) && !TextUtils.isEmpty(((r) this.b).aK())) {
                strX = ((r) this.b).aK();
            }
            String string = "";
            if (!TextUtils.isEmpty(strX)) {
                if (!TextUtils.isEmpty(this.c.o.aQ())) {
                    string = this.c.o.aQ().replace("{__sender__}", "");
                } else {
                    string = this.a.getResources().getString(q.a(this.a, "myoffer_red_packet_title_text", "string"), strX);
                }
            }
            this.r.setAdTitle(string);
            this.r.setAdBless(this.c.o.aR());
            if (!TextUtils.isEmpty(this.b.z())) {
                this.r.setAdIconUrl(this.b.z());
            } else {
                this.r.setAdIconUrl(this.b.B());
            }
            this.r.setAdNotice(this.c.o.aT(), this.b.K());
            this.r.setCTAText(this.c.o.bf());
        }
        viewGroup.addView(this.r, -1, -1);
        b(this.c.o.aP());
        if (this.n != null) {
            com.anythink.basead.ui.f.b.a(this.n, false, this.c, false);
        }
        if (this.h != null) {
            this.h.a(true);
        }
    }

    @Override // com.anythink.basead.ui.c.a
    public final void a() {
        super.a();
        if (this.h != null) {
            this.h.d();
        }
    }

    @Override // com.anythink.basead.ui.c.a
    protected final void a(long j) {
        super.a(j);
        if (this.l >= this.m) {
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.c.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (c.this.h != null) {
                        c.this.h.b();
                    }
                }
            });
        }
    }
}

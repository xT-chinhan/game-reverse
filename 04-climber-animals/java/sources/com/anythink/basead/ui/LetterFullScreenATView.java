package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LetterFullScreenATView extends FullScreenATView {
    com.anythink.basead.b.d.a ak;
    int al;
    int am;
    int an;
    int ao;
    int ap;
    int aq;

    public LetterFullScreenATView(Context context) {
        super(context);
        this.al = q.a(getContext(), 13.0f);
        this.am = q.a(getContext(), 60.0f);
        this.an = q.a(getContext(), 53.0f);
        this.ao = q.a(getContext(), 17.0f);
    }

    public LetterFullScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str, i, i2);
        this.al = q.a(getContext(), 13.0f);
        this.am = q.a(getContext(), 60.0f);
        this.an = q.a(getContext(), 53.0f);
        this.ao = q.a(getContext(), 17.0f);
        if (this.s != null) {
            HashMap map = new HashMap();
            map.put(g.a.a, 1);
            this.s.a(map);
        }
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseATView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_letter_full_screen", "layout"), this);
        setGravity(13);
        if (this.f == null || this.f.o == null || this.f.o.H() != 0) {
            return;
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.LetterFullScreenATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LetterFullScreenATView.this.a(1, 7);
            }
        });
    }

    private void ag() {
        this.al = (this.c - ((int) (((double) ((this.d - this.an) - this.am)) * 0.49714285714285716d))) / 2;
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void c() {
        super.c();
        com.anythink.basead.b.d.a aVar = new com.anythink.basead.b.d.a(getContext());
        this.ak = aVar;
        aVar.a(this.g, this.f, new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.ui.LetterFullScreenATView.2
            @Override // com.anythink.basead.ui.f.b.a
            public final void a(int i, int i2) {
                LetterFullScreenATView.this.a(i, i2);
            }
        });
        this.ak.a(this, this.M.getId());
        this.ak.a(this.c - (this.al * 2));
        this.ap = (this.c - (this.al * 2)) - (this.ao * 2);
        if (!b(this.E)) {
            this.aq = this.ak.b();
            this.ap = ((this.ap + this.ak.a()) - this.aq) - this.ak.b();
        }
        this.q = this.ak.d();
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void I() {
        this.E = 9;
        PanelView panelViewAa = aa();
        if (panelViewAa != null) {
            panelViewAa.setLayoutType(this.E);
            ((LinearLayout.LayoutParams) panelViewAa.findViewById(q.a(getContext(), "myoffer_iv_banner_icon", "id")).getLayoutParams()).bottomMargin = q.a(getContext(), 30.0f);
        }
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final int y() {
        return this.E;
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void U() {
        af();
        if (!b(this.E)) {
            ((RelativeLayout.LayoutParams) this.O.getLayoutParams()).bottomMargin = this.aq;
            this.O.getLayoutParams().height = this.ap;
            this.O.setPadding(0, 0, 0, (this.ak.a() - this.aq) - this.ak.b());
            R();
        } else {
            PanelView panelViewAa = aa();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
            layoutParams.addRule(3, this.O.getId());
            layoutParams.height = -2;
            layoutParams.bottomMargin = this.ak.b();
            layoutParams.addRule(12, 0);
            panelViewAa.setPadding(0, q.a(getContext(), 30.0f), 0, (((this.ak.b() / TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA) * 69) + this.ak.a()) - layoutParams.bottomMargin);
            panelViewAa.setBackgroundColor(-1);
            this.O.getLayoutParams().height = this.ap;
        }
        this.ak.a(this.M);
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void V() {
        super.V();
        Drawable drawableB = this.O.b();
        if (drawableB != null) {
            setBackgroundDrawable(drawableB);
        }
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void Q() {
        if (!b(this.E)) {
            aa().setVisibility(8);
        } else {
            super.Q();
        }
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final boolean b(int i) {
        if (this.g.n()) {
            return false;
        }
        return (TextUtils.isEmpty(this.g.z()) && TextUtils.isEmpty(this.g.x()) && TextUtils.isEmpty(this.g.y())) ? false : true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(1140850688);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    protected final RelativeLayout.LayoutParams q() {
        int i = (this.ap * 2) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, i, 0, 0);
        return layoutParams;
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void b() {
        this.al = (this.c - ((int) (((double) ((this.d - this.an) - this.am)) * 0.49714285714285716d))) / 2;
        super.b();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
        int i = this.ao;
        layoutParams.setMargins(i, this.am, i, this.an);
        int i2 = this.al;
        setPadding(i2, 0, i2, 0);
    }
}

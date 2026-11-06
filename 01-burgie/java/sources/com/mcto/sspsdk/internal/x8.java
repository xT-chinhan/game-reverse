package com.mcto.sspsdk.internal;

import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class x8 extends s8 {
    public final AtomicBoolean v;
    public uf w;

    public x8(ve veVar, p pVar, long j, a aVar, re reVar) {
        super(veVar, pVar, j, aVar, reVar);
        this.v = new AtomicBoolean(false);
    }

    @Override // com.mcto.sspsdk.internal.s8
    public final void a(p pVar) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.qy_layout_reward_interactive_dialog_gold, (ViewGroup) null);
        this.d = constraintLayout;
        constraintLayout.setOnClickListener(this);
        this.d.findViewById(R.id.qy_reward_interactive_container);
        TextView textView = (TextView) this.d.findViewById(R.id.qy_reward_interactive_desc);
        h6.a(this.a.getContext(), textView, this.c.p);
        textView.setText(nk.a(this.a.getContext(), this.c.h.replace("%erc", "" + pVar.X)));
        TextView textView2 = (TextView) this.d.findViewById(R.id.qy_reward_interactive_button);
        textView2.setText(this.c.o.replace("%erc", "" + pVar.X));
        TextView textView3 = (TextView) this.d.findViewById(R.id.qy_reward_interactive_title);
        this.e = textView3;
        textView3.setText(sg.a(this.c.i, "%nrt", (this.m / 1000) + "秒"));
        h6.a(this.a.getContext(), this.e, this.c.p);
        this.f = (TextView) this.d.findViewById(R.id.qy_reward_interactive_countdown);
        b(pVar);
        if (pVar.n()) {
            return;
        }
        textView2.setOnClickListener(this);
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        if (this.c.e == 0) {
            this.d.findViewById(R.id.qy_reward_interactive_background).setOnClickListener(this);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void d() {
        ld ldVar = this.h;
        if (ldVar != null) {
            ldVar.c();
        }
        this.v.set(false);
    }

    @Override // com.mcto.sspsdk.internal.s8, com.mcto.sspsdk.internal.j7
    public final void e() {
        ld ldVar = this.h;
        if (ldVar != null) {
            ldVar.a();
        }
        this.v.set(true);
    }

    @Override // com.mcto.sspsdk.internal.s8
    public final void i() {
        uf ufVar = this.w;
        if (ufVar != null) {
            ufVar.c();
            if (this.w.getParent() != null) {
                this.a.removeView(this.w);
            }
            this.w = null;
        }
    }

    @Override // com.mcto.sspsdk.internal.s8
    public final void m() {
        if (this.c.w != 1) {
            n();
            return;
        }
        this.d.setVisibility(8);
        try {
            uf ufVar = new uf(this.a.getContext());
            this.w = ufVar;
            ufVar.setId(R.id.qy_reward_gold_rain_view);
            this.w.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.w.setBackgroundResource(R.color.qy_dialog_bg);
            uf ufVar2 = this.w;
            int i = R.drawable.qy_ic_gold_3;
            if (i != 0) {
                ufVar2.a = i;
            } else {
                ufVar2.getClass();
            }
            uf ufVar3 = this.w;
            ufVar3.getClass();
            ufVar3.f = 70;
            ufVar3.g = 100;
            if (!this.n || this.c.e == 2) {
                this.w.setOnClickListener(this);
            }
            uf ufVar4 = this.w;
            ufVar4.p = new w8(this);
            this.a.addView(ufVar4);
            this.w.a();
        } catch (Exception e) {
            e.getMessage();
            n();
        }
    }

    public final void n() {
        this.d.setVisibility(0);
        j();
        l();
        int i = this.c.c;
        if (i <= 0) {
            this.f.setVisibility(8);
            return;
        }
        this.h = new v8(this, ((long) i) * 1000);
        if (this.v.get()) {
            return;
        }
        ld ldVar = this.h;
        synchronized (ldVar) {
            ldVar.c();
        }
    }

    @Override // com.mcto.sspsdk.internal.s8
    public final boolean a(View view, int i) {
        return i == R.id.qy_reward_gold_rain_view && this.c.e == 2;
    }
}

package com.mcto.sspsdk.internal;

import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.taptap.sdk.compliance.constants.BundleKey;

/* JADX INFO: loaded from: classes2.dex */
public class u8 extends s8 {
    public int v;

    public u8(ve veVar, p pVar, long j, a aVar, re reVar) {
        super(veVar, pVar, j, aVar, reVar);
        this.v = 0;
    }

    @Override // com.mcto.sspsdk.internal.s8
    public void a(p pVar) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.qy_layout_reward_interactive_dialog, (ViewGroup) null);
        this.d = constraintLayout;
        constraintLayout.setOnClickListener(this);
        QYNiceImageView qYNiceImageView = (QYNiceImageView) this.d.findViewById(R.id.qy_reward_interactive_app_icon);
        qYNiceImageView.a(14, 0, 0);
        qYNiceImageView.a(pVar.Q);
        ((TextView) this.d.findViewById(R.id.qy_reward_interactive_app_name)).setText(pVar.P);
        ((TextView) this.d.findViewById(R.id.qy_reward_interactive_ad_title)).setText(pVar.i().optString(BundleKey.TITLE));
        TextView textView = (TextView) this.d.findViewById(R.id.qy_reward_interactive_desc);
        textView.setText(this.c.h);
        h6.a(this.a.getContext(), textView, this.c.p);
        TextView textView2 = (TextView) this.d.findViewById(R.id.qy_reward_interactive_button);
        textView2.setText(this.c.o);
        this.o = r0.a(this.d.findViewById(R.id.qy_reward_interactive_ripple), 1.3f, 1.3f, 0.1f);
        this.o.playTogether(r0.a(this.d.findViewById(R.id.qy_reward_interactive_hand), 0.8f, 0.8f));
        this.o.start();
        TextView textView3 = (TextView) this.d.findViewById(R.id.qy_reward_interactive_title);
        this.e = textView3;
        textView3.setText(sg.a(this.c.i, "%nrt", (this.m / 1000) + "秒"));
        h6.a(this.a.getContext(), this.e, this.c.p);
        TextView textView4 = (TextView) this.d.findViewById(R.id.qy_reward_interactive_countdown);
        this.f = textView4;
        a aVar = this.c;
        if (aVar.m == 1) {
            this.v = 1;
            textView4.setText(aVar.n);
        }
        this.f.setOnClickListener(this);
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
        TextView textView;
        ld ldVar = this.h;
        if (ldVar != null) {
            ldVar.c();
        }
        if (this.l != 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.l;
            a aVar = this.c;
            if (aVar.q == 1) {
                long j = this.m - jElapsedRealtime;
                if (j < 1000) {
                    this.j = true;
                    this.b.a.d(2);
                    destroy();
                } else {
                    this.m = j;
                    if (!this.j && (textView = this.g) != null) {
                        textView.setText(aVar.t.replace("%nrt", (this.m / 1000) + "秒"));
                        this.i = null;
                    }
                    ImageView imageView = this.r;
                    if (imageView != null && this.c.k == 2) {
                        imageView.setVisibility(0);
                    }
                    TextView textView2 = this.f;
                    if (textView2 != null) {
                        a aVar2 = this.c;
                        if (aVar2.m == 2) {
                            this.v = 1;
                            textView2.setText(aVar2.n);
                        }
                        if (this.v == 0) {
                            this.f.setVisibility(4);
                        }
                    }
                    this.e.setText(sg.a(this.c.j, "%nrt", (this.m / 1000) + "秒"));
                }
            }
            this.l = 0L;
        }
    }

    @Override // com.mcto.sspsdk.internal.s8
    public final void m() {
        j();
        l();
        int i = this.c.c;
        if (i > 0) {
            t8 t8Var = new t8(this, ((long) i) * 1000);
            this.h = t8Var;
            synchronized (t8Var) {
                t8Var.c();
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.s8
    public final boolean a(View view, int i) {
        if (i != R.id.qy_reward_interactive_countdown || this.v != 1) {
            return false;
        }
        a(view);
        destroy();
        return true;
    }
}

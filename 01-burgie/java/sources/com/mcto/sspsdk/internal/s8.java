package com.mcto.sspsdk.internal;

import android.animation.AnimatorSet;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s8 implements j7, View.OnClickListener {
    public final ve a;
    public final re b;
    public final a c;
    public ConstraintLayout d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ld h;
    public CharSequence i;
    public long m;
    public final boolean n;
    public AnimatorSet o;
    public ViewGroup q;
    public ImageView r;
    public long s;
    public boolean j = false;
    public boolean k = false;
    public long l = 0;
    public boolean p = false;
    public final CountDownLatch t = new CountDownLatch(1);
    public final q8 u = new q8(this);

    public s8(ve veVar, p pVar, long j, a aVar, re reVar) {
        this.a = veVar;
        this.b = reVar;
        this.c = aVar;
        this.m = j;
        this.n = pVar.n();
        a(pVar);
    }

    public final void a(View view) {
        if (this.b != null) {
            ld ldVar = this.h;
            if (ldVar != null) {
                ldVar.a();
                this.h = null;
            }
            this.l = SystemClock.elapsedRealtime();
            int id = view.getId();
            a4 a4Var = new a4();
            a4Var.b = z3.GRAPHIC;
            a4Var.a = this.a;
            a4Var.g = SystemClock.elapsedRealtime() - this.s;
            a4Var.e = gj.a(view);
            b4 b4Var = new b4(a4Var);
            if (id == R.id.qy_reward_interactive_button) {
                b4Var.b = h() + "_button";
            } else if (id == R.id.qy_reward_push_card) {
                b4Var.b = "inner_push";
            } else if (id == R.id.qy_dialog_positive_btn) {
                b4Var.b = "edg_" + h() + "_button";
            } else if (id == R.id.qy_dialog_negative_btn) {
                b4Var.b = "edg_" + h() + "_close_ad";
                b4Var.a = z3.FUNCTIONAL_BTN;
                this.l = 0L;
            } else if (id == R.id.qy_reward_interactive_close || id == R.id.qy_reward_interactive_countdown) {
                b4Var.b = h() + "_close";
                b4Var.a = z3.FUNCTIONAL_BTN;
                this.l = 0L;
            } else {
                b4Var.b = h() + "_graphic";
            }
            this.b.a.b(b4Var);
        }
    }

    public abstract void a(p pVar);

    public abstract boolean a(View view, int i);

    public final void b(p pVar) {
        if (this.c.v == 1) {
            ViewGroup viewGroup = (ViewGroup) this.d.findViewById(R.id.qy_reward_push_card);
            this.q = viewGroup;
            viewGroup.setVisibility(0);
            QYNiceImageView qYNiceImageView = (QYNiceImageView) this.q.findViewById(R.id.qy_reward_push_card_icon);
            qYNiceImageView.a(pVar.Q);
            qYNiceImageView.a(7, 0, 0);
            ((TextView) this.q.findViewById(R.id.qy_reward_push_card_title)).setText(pVar.P);
            ((TextView) this.q.findViewById(R.id.qy_reward_push_card_sub_title)).setText(pVar.i().optString(BundleKey.TITLE));
            if (hk.d(this.a.getContext()) || this.a.getContext().getResources().getConfiguration().orientation != 2) {
                return;
            }
            ImageView imageView = (ImageView) this.d.findViewById(R.id.qy_reward_interactive_close);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
            int i = R.id.qy_reward_push_card;
            layoutParams.topToTop = i;
            layoutParams.bottomToBottom = i;
            layoutParams.rightToRight = 0;
            layoutParams.leftToLeft = -1;
            layoutParams.leftToRight = -1;
            layoutParams.setMargins(0, 0, hk.a(this.a.getContext(), 12.0f), 0);
            imageView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final boolean c() {
        return this.k;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void destroy() {
        TextView textView;
        if (this.p) {
            return;
        }
        this.p = true;
        if (!this.j && !TextUtils.isEmpty(this.i) && (textView = this.g) != null) {
            textView.setText(this.i);
            this.i = null;
        }
        i();
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ld ldVar = this.h;
        if (ldVar != null) {
            ldVar.a();
            this.h = null;
        }
        this.a.removeView(this.d);
        this.k = false;
        re reVar = this.b;
        if (reVar != null) {
            reVar.a(this);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public void e() {
        ld ldVar = this.h;
        if (ldVar != null) {
            ldVar.a();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public void f() {
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final int g() {
        return this.c.d;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final String h() {
        return "d" + this.c.a;
    }

    public void i() {
    }

    public final void j() {
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            viewGroup.animate().alpha(1.0f).translationY(0.0f).setDuration(700L).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    public final void k() {
        this.s = SystemClock.elapsedRealtime();
        this.k = true;
        this.a.addView(this.d, new ViewGroup.LayoutParams(-1, -1));
        m();
        try {
            if (!TextUtils.isEmpty(this.c.t)) {
                TextView textView = (TextView) this.a.findViewById(R.id.qy_count_down_desc);
                this.g = textView;
                this.i = textView.getText();
                this.g.setText(this.c.t.replace("%nrt", (this.m / 1000) + "秒"));
            }
        } catch (Exception e) {
        }
        re reVar = this.b;
        if (reVar != null) {
            reVar.b(this);
        }
    }

    public final void l() {
        ImageView imageView;
        if (this.c.k == 0 || (imageView = (ImageView) this.d.findViewById(R.id.qy_reward_interactive_close)) == null) {
            return;
        }
        this.r = imageView;
        imageView.setOnClickListener(this);
        a aVar = this.c;
        int i = aVar.k;
        if (i == 1) {
            imageView.setVisibility(0);
        } else if (i == 3) {
            imageView.postDelayed(new r8(imageView), ((long) aVar.l) * 1000);
        }
    }

    public abstract void m();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (R.id.qy_reward_interactive_container == id || a(view, id)) {
            return;
        }
        a(view);
        if (id == R.id.qy_reward_interactive_close) {
            destroy();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final d b() {
        a aVar = this.c;
        if (aVar.s == 1) {
            return aVar.u;
        }
        return null;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public void a() {
        k();
    }
}

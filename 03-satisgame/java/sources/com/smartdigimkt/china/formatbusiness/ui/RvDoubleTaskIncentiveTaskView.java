package com.smartdigimkt.china.formatbusiness.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b2.m;
import com.smartdigimkt.b2.n;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.d;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.b3.h;
import com.smartdigimkt.b3.o;
import com.smartdigimkt.b3.p;
import com.smartdigimkt.e.i0;
import com.smartdigimkt.e.j0;
import com.smartdigimkt.n1.o4;
import com.smartdigimkt.n1.p4;
import com.smartdigimkt.n1.y2;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public class RvDoubleTaskIncentiveTaskView extends CountDownSkipIncentiveTaskView {
    public static final /* synthetic */ int q = 0;
    public final i0 n;
    public o o;
    public d p;

    public RvDoubleTaskIncentiveTaskView(Context context, i0 i0Var) {
        super(context);
        this.n = i0Var;
    }

    public static boolean b(c cVar) {
        if (cVar == null) {
            return false;
        }
        int i = cVar.o;
        if (i == 3) {
            return TextUtils.isEmpty(cVar.k) && TextUtils.isEmpty(cVar.m);
        }
        if (i == 6) {
            return TextUtils.isEmpty(cVar.A);
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final String a(long j) {
        if (!n()) {
            return super.a(j);
        }
        if (!a(this.c)) {
            return getContext().getString(k.a(getContext(), "myoffer_inctask_double_cta_continue", "string"));
        }
        return getContext().getString(k.a(getContext(), "myoffer_inctask_double_cta_continue_experience", "string"), Integer.valueOf(Math.max(1, (int) Math.ceil(j / 1000.0d))));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final void c() {
        if (!n()) {
            super.c();
            return;
        }
        if (!b(this.c)) {
            super.c();
            return;
        }
        i0 i0Var = this.n;
        if (i0Var != null) {
            i0Var.m = true;
            a aVar = i0Var.c;
            c cVar = i0Var.b;
            BaseIncentiveTaskView baseIncentiveTaskView = i0Var.j;
            if (baseIncentiveTaskView instanceof CountDownSkipIncentiveTaskView) {
                ((CountDownSkipIncentiveTaskView) baseIncentiveTaskView).isShowingTaskCompletedManualClaimUi();
            }
            com.smartdigimkt.n3.k.b(16, 53, aVar, cVar, null, false);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final void d() {
        TextView textView;
        if (n() && (textView = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_cta", "id"))) != null) {
            if (a(this.c)) {
                textView.setText(getContext().getString(k.a(getContext(), "myoffer_inctask_double_cta_continue_experience", "string"), Integer.valueOf(Math.max(1, (int) Math.ceil(a(this.d) / 1000.0d)))));
            } else {
                textView.setText(getContext().getString(k.a(getContext(), "myoffer_inctask_double_cta_continue", "string")));
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final void e() {
        a aVar;
        e eVar;
        if (n()) {
            i0 i0Var = this.n;
            if (i0Var != null && (aVar = i0Var.c) != null && (eVar = aVar.s) != null && h.a(eVar.R1)) {
                i0Var.s = true;
                i0Var.m = true;
            }
            boolean z = a(this.c) && this.e != null;
            TextView textView = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_cta", "id"));
            if (textView != null) {
                if (a(this.c)) {
                    e eVar2 = this.d;
                    int iC = p.c(eVar2 != null ? eVar2.R1 : null);
                    if (z) {
                        textView.setText(a(this.e.e));
                    } else if (iC >= 1) {
                        textView.setText(getContext().getString(k.a(getContext(), "myoffer_inctask_double_cta_continue_experience", "string"), Integer.valueOf(iC)));
                    } else {
                        textView.setText(getContext().getString(k.a(getContext(), "myoffer_inctask_double_cta_continue", "string")));
                    }
                } else {
                    textView.setText(getContext().getString(k.a(getContext(), "myoffer_inctask_double_cta_continue", "string")));
                }
            }
            if (a(this.c)) {
                e eVar3 = this.d;
                int iC2 = p.c(eVar3 != null ? eVar3.R1 : null);
                if (iC2 >= 1) {
                    long jA = a(this.d);
                    if (jA <= 0) {
                        jA = ((long) iC2) * 1000;
                    }
                    com.smartdigimkt.d2.h hVar = this.e;
                    boolean z2 = hVar != null;
                    if (jA > 0 && hVar == null) {
                        String str = String.format(getContext().getString(k.a(getContext(), "myoffer_inctask_cts_hint", "string")), Integer.valueOf((int) Math.ceil(jA / 1000.0d)));
                        TextView textView2 = this.f;
                        if (textView2 != null) {
                            textView2.setText(str);
                        }
                        this.e = new com.smartdigimkt.d2.h(this, jA);
                    }
                    if (this.e != null) {
                        if (!z2) {
                            d();
                        }
                        com.smartdigimkt.d2.h hVar2 = this.e;
                        hVar2.a(hVar2.e, hVar2.b);
                        this.e.b();
                    }
                }
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final void f() {
        i0 i0Var;
        if (n() && o() && (i0Var = this.n) != null) {
            com.smartdigimkt.n3.k.b(16, 53, i0Var.c, i0Var.b, null, false);
        }
        com.smartdigimkt.d2.c cVar = this.b;
        if (cVar != null) {
            ((n) cVar).a(-1L);
        }
        i0 i0Var2 = this.n;
        if (i0Var2 != null) {
            i0Var2.b();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final String g() {
        return !n() ? super.g() : getContext().getString(k.a(getContext(), "myoffer_inctask_double_completed_cta", "string"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public int getCountDownSkipLayoutResId() {
        return k.a(getContext(), "myoffer_inctask_count_down_skip_double", "layout");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final String h() {
        return !n() ? super.h() : getContext().getString(k.a(getContext(), "myoffer_inctask_double_completed_title", "string"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final boolean i() {
        if (!n() || !j() || !a(this.c)) {
            return false;
        }
        e eVar = this.d;
        return p.c(eVar != null ? eVar.R1 : null) >= 1;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView, com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void initSetting(c cVar, e eVar, long j, com.smartdigimkt.d2.c cVar2) {
        int i;
        TextView textView;
        super.initSetting(cVar, eVar, j, cVar2);
        if (n()) {
            Context context = getContext();
            TextView textView2 = (TextView) findViewById(k.a(context, "myoffer_inctask_overlay_title", "id"));
            if (textView2 != null) {
                textView2.setText(context.getString(k.a(context, "myoffer_inctask_double_overlay_title", "string")));
            }
            TextView textView3 = (TextView) findViewById(k.a(context, "myoffer_inctask_overlay_subtitle", "id"));
            if (textView3 != null) {
                textView3.setText(context.getString(k.a(context, "myoffer_inctask_double_overlay_subtitle", "string")));
            }
            TextView textView4 = (TextView) findViewById(k.a(context, "myoffer_inctask_cta", "id"));
            if (textView4 != null) {
                textView4.setText(context.getString(k.a(context, "myoffer_inctask_double_cta_initial", "string")));
            }
            c cVar3 = this.c;
            if (cVar3 != null && (((i = cVar3.o) == 1 || i == 4) && (textView = (TextView) findViewById(k.a(context, "myoffer_inctask_title", "id"))) != null)) {
                textView.setText(context.getString(k.a(context, "myoffer_inctask_double_task_title_link14", "string")));
            }
            TextView textView5 = (TextView) findViewById(k.a(context, "myoffer_inctask_double_second_reward_text", "id"));
            if (textView5 != null) {
                textView5.setVisibility(0);
                textView5.setText(context.getString(k.a(context, "myoffer_inctask_double_second_reward_hint", "string")));
            }
        }
        q();
        b();
        d dVar = eVar != null ? eVar.R1 : null;
        this.p = dVar;
        this.o = p.a(dVar);
        post(new j0(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final boolean j() {
        return !n() ? this instanceof m : o();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final boolean k() {
        i0 i0Var;
        return n() && (i0Var = this.n) != null && i0Var.s;
    }

    public final void l() {
        ImageView imageView = (ImageView) findViewById(k.a(getContext(), "myoffer_inctask_close_view", "id"));
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.smartdigimkt.china.formatbusiness.ui.RvDoubleTaskIncentiveTaskView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.c(view);
                }
            });
        }
    }

    public final boolean m() {
        i0 i0Var;
        return n() && j() && a(this.c) && this.e != null && !this.l && (i0Var = this.n) != null && i0Var.s;
    }

    public final boolean n() {
        e eVar = this.d;
        return h.a(eVar != null ? eVar.R1 : null);
    }

    public final boolean o() {
        e eVar;
        int i;
        int i2;
        if (this.c == null || (eVar = this.d) == null || !h.a(eVar.R1)) {
            return false;
        }
        c cVar = this.c;
        if ((cVar != null && ((i2 = cVar.o) == 1 || i2 == 4)) || (i = cVar.o) == 2) {
            return true;
        }
        if (i == 3 || i == 6) {
            return !b(cVar);
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView, com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void onPause() {
        if (m() && !com.smartdigimkt.j2.d.b && com.smartdigimkt.j2.d.a.get() <= 0 && com.smartdigimkt.j2.d.c.get() <= 0) {
            com.smartdigimkt.d2.h hVar = this.e;
            if (!(!hVar.c)) {
                hVar.a(hVar.e, hVar.b);
            }
        }
        super.onPause();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView, com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void onResume() {
        if (m()) {
            this.e.b();
        }
        super.onResume();
        b();
    }

    public final void p() {
        i0 i0Var = this.n;
        if (i0Var != null) {
            if (p.a(i0Var.c.s.R1).b != 2) {
                i0Var.b();
                return;
            }
            com.smartdigimkt.b2.e eVar = i0Var.h;
            if (eVar instanceof y2) {
                ((y2) eVar).a.c(1);
            }
        }
    }

    public final void q() {
        TextView textView;
        if (n() && (textView = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_cta", "id"))) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.smartdigimkt.china.formatbusiness.ui.RvDoubleTaskIncentiveTaskView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.b(view);
                }
            });
        }
    }

    public final void r() {
        d dVar;
        String string;
        e eVar;
        Context context = getContext();
        i0 i0Var = this.n;
        if (i0Var != null) {
            a aVar = i0Var.c;
            dVar = (aVar == null || (eVar = aVar.s) == null) ? null : eVar.R1;
        } else {
            dVar = this.p;
        }
        Runnable runnable = new Runnable() { // from class: com.smartdigimkt.china.formatbusiness.ui.RvDoubleTaskIncentiveTaskView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        };
        i0 i0Var2 = this.n;
        a aVar2 = i0Var2 != null ? i0Var2.c : null;
        c cVar = i0Var2 != null ? i0Var2.b : null;
        if (context == null) {
            return;
        }
        o oVarA = p.a(dVar);
        boolean z = oVarA.b == 2;
        String str = oVarA.d;
        if (TextUtils.isEmpty(str)) {
            string = context.getString(k.a(context, z ? "myoffer_rv_double_retention_main_disallow" : "myoffer_rv_double_retention_main_allow", "string"));
        } else {
            string = str;
        }
        String string2 = oVarA.e;
        if (TextUtils.isEmpty(string2)) {
            string2 = context.getString(k.a(context, "myoffer_rv_double_retention_leave", "string"));
        }
        String string3 = oVarA.f;
        if (TextUtils.isEmpty(string3)) {
            string3 = context.getString(k.a(context, "myoffer_rv_double_retention_stay", "string"));
        }
        p4.a(context, string, string3, string2, runnable, aVar2, cVar, o4.TASK_CARD_CLOSE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a7, code lost:
    
        if (r7 != 1) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(android.view.View r7) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.china.formatbusiness.ui.RvDoubleTaskIncentiveTaskView.c(android.view.View):void");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final long a(e eVar) {
        if (!n()) {
            return super.a(eVar);
        }
        int iC = p.c(eVar != null ? eVar.R1 : null);
        return iC > 0 ? ((long) iC) * 1000 : super.a(eVar);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView
    public final boolean a(long j, long j2, e eVar) {
        c cVar;
        if (!n()) {
            return super.a(j, j2, eVar);
        }
        if (o()) {
            c cVar2 = this.c;
            if ((cVar2 != null && cVar2.o == 3 && (!TextUtils.isEmpty(cVar2.k) || !TextUtils.isEmpty(cVar2.m))) || ((cVar = this.c) != null && cVar.o == 6 && (!TextUtils.isEmpty(cVar.A)))) {
                int iC = p.c(eVar != null ? eVar.R1 : null);
                if (iC >= 1 && iC <= 15 && j > 0) {
                    return true;
                }
            }
            return false;
        }
        int iC2 = p.c(eVar != null ? eVar.R1 : null);
        if (iC2 < 1 || iC2 > 15) {
            return super.a(j, j2, eVar);
        }
        return j > 0;
    }

    public static boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        int i = cVar.o;
        return i == 3 || i == 6;
    }
}

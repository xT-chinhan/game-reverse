package com.mcto.sspsdk.internal;

import android.view.View;
import android.view.ViewGroup;
import com.mcto.sspsdk.R;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class pc extends ve {
    public static final /* synthetic */ int m0 = 0;
    public final rg j0;
    public final AtomicBoolean k0;
    public final AtomicBoolean l0;

    public pc(oc ocVar) {
        super(ocVar);
        this.k0 = new AtomicBoolean(false);
        this.l0 = new AtomicBoolean(false);
        rg rgVar = ocVar.j;
        this.j0 = rgVar;
        lc lcVar = new lc(this);
        if (rgVar.c) {
            lcVar.a(Boolean.TRUE);
            return;
        }
        synchronized (rgVar.d) {
            if (rgVar.c) {
                lcVar.a(Boolean.TRUE);
            } else {
                rgVar.e = lcVar;
            }
        }
    }

    public static void a(pc pcVar, ViewGroup viewGroup) {
        pcVar.getClass();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getId() == -1) {
                childAt.toString();
                childAt.setId(View.generateViewId());
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.ve, com.mcto.sspsdk.internal.sc
    public final void b() {
        super.b();
        if (this.M.get() && this.k0.get() && this.l0.compareAndSet(false, true)) {
            this.f0.a(-999, 0);
        }
    }

    @Override // com.mcto.sspsdk.internal.ve
    public final void e() {
        super.e();
        rg rgVar = this.j0;
        if (rgVar.b != null) {
            rgVar.b.destroy();
        }
    }

    @Override // com.mcto.sspsdk.internal.ve
    public final void k() {
        super.k();
        try {
            if (this.c.o()) {
                this.j0.b.getCustomizeVideo().reportVideoFinish();
            }
        } catch (Exception e) {
            r9.a("ssp_sdk", "report adn complete", e);
        }
    }

    @Override // com.mcto.sspsdk.internal.ve
    public final void m() {
        super.m();
        try {
            if (this.c.o()) {
                this.j0.b.getCustomizeVideo().reportVideoAutoStart();
            }
        } catch (Exception e) {
            r9.a("ssp_sdk", "report adn Start", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0013  */
    @Override // com.mcto.sspsdk.internal.ve
    public final void n() {
        View viewFindViewById;
        if (h()) {
            e eVar = this.c.L0;
            if (eVar.C != 1 && eVar.B != 1) {
                viewFindViewById = findViewById(R.id.qy_count_down_desc);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(this);
                }
            }
        } else {
            viewFindViewById = findViewById(R.id.qy_count_down_desc);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(this);
            }
        }
        View viewFindViewById2 = findViewById(R.id.qy_count_down_close);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(this);
        }
    }

    public final void o() {
        View viewFindViewById;
        if (this.j0.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        View viewFindViewById2 = findViewById(R.id.qy_card_download_btn);
        if (viewFindViewById2 != null) {
            arrayList.add(viewFindViewById2);
        }
        if (this.e == 0) {
            arrayList.add(this.n);
            arrayList.add(this.g);
        } else {
            setOnClickListener(this);
            if (this.e != 2) {
                arrayList.add(this.g);
            }
        }
        View viewFindViewById3 = findViewById(R.id.qy_trueview_welfare_container);
        if (viewFindViewById3 != null) {
            arrayList.add(viewFindViewById3);
        }
        View viewFindViewById4 = this.e == 2 ? findViewById(R.id.qy_reward_interactive_button) : null;
        if (viewFindViewById4 == null) {
            viewFindViewById4 = findViewById(R.id.qy_reward_interactive_background);
        }
        if (viewFindViewById4 != null) {
            arrayList.add(viewFindViewById4);
        }
        View viewFindViewById5 = findViewById(R.id.qy_reward_push_card);
        if (viewFindViewById5 != null) {
            arrayList.add(viewFindViewById5);
        }
        if (h()) {
            e eVar = this.c.L0;
            if ((eVar.C == 1 || eVar.B == 1) && (viewFindViewById = findViewById(R.id.qy_count_down_desc)) != null) {
                arrayList.add(viewFindViewById);
            }
        }
        this.j0.b.registerViewForInteraction(this, arrayList, new ArrayList(), (View) null, new mc(this));
        post(new nc(this));
    }

    @Override // com.mcto.sspsdk.internal.ve
    public final void a(j7 j7Var) {
        a(j7Var.h());
        o();
    }
}

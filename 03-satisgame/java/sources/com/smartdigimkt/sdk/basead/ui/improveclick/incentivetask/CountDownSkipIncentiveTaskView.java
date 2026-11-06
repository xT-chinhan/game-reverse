package com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.b2.n;
import com.smartdigimkt.b2.p;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.d2.d;
import com.smartdigimkt.d2.f;
import com.smartdigimkt.d2.g;
import com.smartdigimkt.d2.h;
import com.smartdigimkt.d2.i;
import com.smartdigimkt.d2.j;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.SimpleGuideToClickView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class CountDownSkipIncentiveTaskView extends BaseIncentiveTaskView {
    public c c;
    public e d;
    public h e;
    public TextView f;
    public TextView g;
    public TextView h;
    public RoundImageView i;
    public ImageView j;
    public boolean k;
    public boolean l;
    public SimpleGuideToClickView m;

    public CountDownSkipIncentiveTaskView(Context context) {
        super(context);
        this.k = false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public final void a() {
        LayoutInflater.from(getContext()).inflate(getCountDownSkipLayoutResId(), this);
        this.f = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_title", "id"));
        this.g = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_desc", "id"));
        this.h = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_cta", "id"));
        this.i = (RoundImageView) findViewById(k.a(getContext(), "myoffer_inctask_icon", "id"));
        this.j = (ImageView) findViewById(k.a(getContext(), "myoffer_inctask_close_view", "id"));
        this.m = (SimpleGuideToClickView) findViewById(k.a(getContext(), "myoffer_g2c_item_g2c_fingerview", "id"));
    }

    public boolean a(long j, long j2, e eVar) {
        return j < j2;
    }

    public void c() {
        com.smartdigimkt.d2.c cVar = this.b;
        if (cVar != null) {
            p pVar = ((n) cVar).a;
            pVar.m = true;
            com.smartdigimkt.b2.e eVar = pVar.h;
            if (eVar != null) {
                eVar.a(16, pVar.n == 3 ? 53 : 13);
            }
        }
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        com.smartdigimkt.d2.c cVar = this.b;
        if (cVar != null) {
            ((n) cVar).a(-1L);
            ((n) this.b).a();
        }
    }

    public String g() {
        return getContext().getString(k.a(getContext(), "myoffer_inctask_cts_completed_cta", "string"));
    }

    public int getCountDownSkipLayoutResId() {
        return k.a(getContext(), "myoffer_inctask_count_down_skip", "layout");
    }

    public String h() {
        return getContext().getString(k.a(getContext(), "myoffer_inctask_cts_completed", "string"));
    }

    public boolean i() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b  */
    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void initSetting(c cVar, e eVar, long j, com.smartdigimkt.d2.c cVar2) {
        TextView textView;
        RoundImageView roundImageView;
        this.c = cVar;
        this.d = eVar;
        super.initSetting(cVar, eVar, j, cVar2);
        if (j > 0) {
            long j2 = eVar.x;
            if (j2 <= 0) {
                j2 = 30000;
            }
            if (j >= j2) {
                j = eVar.x;
                if (j <= 0) {
                    j = 30000;
                }
            }
        } else {
            j = eVar.x;
            if (j <= 0) {
                j = 30000;
            }
        }
        long j3 = j - eVar.g1;
        long jA = a(eVar);
        if (a(jA, j3, eVar)) {
            String str = String.format(getContext().getString(k.a(getContext(), "myoffer_inctask_cts_hint", "string")), Integer.valueOf((int) Math.ceil(jA / 1000.0d)));
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(str);
            }
            this.e = new h(this, jA);
        } else {
            String string = getContext().getString(k.a(getContext(), "myoffer_inctask_cts_hint2", "string"));
            TextView textView3 = this.f;
            if (textView3 != null) {
                textView3.setText(string);
            }
        }
        String str2 = cVar.e;
        if (!TextUtils.isEmpty(str2) && (roundImageView = this.i) != null) {
            roundImageView.setNeedRadiu(true);
            this.i.setRadiusInDip(20);
            m.a(getContext()).a(new o(1, str2), -1, -1, new d(this, str2));
        }
        if (!TextUtils.isEmpty(cVar.c) && (textView = this.g) != null) {
            textView.setText(cVar.c);
            this.g.setVisibility(0);
        }
        TextView textView4 = this.h;
        if (textView4 != null) {
            textView4.setOnClickListener(new com.smartdigimkt.d2.e(this));
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setOnClickListener(new f(this));
        }
        SimpleGuideToClickView simpleGuideToClickView = this.m;
        if (simpleGuideToClickView != null) {
            simpleGuideToClickView.init(k.a(getContext(), "myoffer_simple_guide_to_click_s", "layout"), k.a(getContext(), 4.0f), k.a(getContext(), 6.0f), k.a(getContext(), 8.0f), k.a(getContext(), 12.0f));
            ImageView imageView2 = (ImageView) this.m.findViewById(k.a(getContext(), "myoffer_guide_to_click_finger", "id"));
            if (imageView2 != null) {
                String strB = com.smartdigimkt.m1.d.a().b(b.d.k);
                if (TextUtils.isEmpty(strB)) {
                    return;
                }
                d0.a().a(new o(3, strB), -1, -1, new g(imageView2));
            }
        }
    }

    public boolean isShowingTaskCompletedManualClaimUi() {
        return this.l;
    }

    public boolean j() {
        return this instanceof com.smartdigimkt.b2.m;
    }

    public boolean k() {
        return false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void onPause() {
        super.onPause();
        this.k = false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void onResume() {
        super.onResume();
        if (k() || this.l) {
            return;
        }
        if (this.k) {
            showTaskCompletedManualClaimUi();
        } else {
            this.k = true;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void release() {
        this.l = false;
        super.release();
        h hVar = this.e;
        if (hVar != null) {
            hVar.c();
            this.e = null;
        }
    }

    public void showTaskCompletedManualClaimUi() {
        if (this.l) {
            return;
        }
        this.l = true;
        h hVar = this.e;
        if (hVar != null) {
            hVar.c();
            this.e = null;
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(h());
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setText(g());
            this.h.setOnClickListener(new i(this));
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setOnClickListener(new j(this));
        }
    }

    public CountDownSkipIncentiveTaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
    }

    public CountDownSkipIncentiveTaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = false;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(View view) {
        if (!j()) {
            view.setOnClickListener(null);
        }
        b();
        c();
        if (j()) {
            this.k = false;
            e();
        } else {
            this.k = true;
            if (this.e != null) {
                d();
                h hVar = this.e;
                hVar.a(hVar.e, hVar.b);
            } else {
                showTaskCompletedManualClaimUi();
            }
        }
        SimpleGuideToClickView simpleGuideToClickView = this.m;
        if (simpleGuideToClickView != null) {
            simpleGuideToClickView.setVisibility(8);
        }
    }

    public String a(long j) {
        return String.format(getContext().getString(k.a(getContext(), "myoffer_inctask_cts_time", "string")), Integer.valueOf((int) Math.ceil(j / 1000.0d)));
    }

    public long a(e eVar) {
        if (eVar == null) {
            return 0L;
        }
        return eVar.h1;
    }
}

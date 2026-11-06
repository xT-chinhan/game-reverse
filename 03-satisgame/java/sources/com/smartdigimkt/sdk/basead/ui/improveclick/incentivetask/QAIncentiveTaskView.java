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
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.d2.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.m1.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.z.d0;

/* JADX INFO: loaded from: classes3.dex */
public class QAIncentiveTaskView extends BaseIncentiveTaskView {
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public ImageView i;
    public long j;

    public QAIncentiveTaskView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public final void a() {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_inctask_qa", "layout"), this);
        this.c = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_title", "id"));
        this.d = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_subtitle", "id"));
        this.e = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_answer_hint", "id"));
        this.f = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_answer_right", "id"));
        this.g = (TextView) findViewById(k.a(getContext(), "myoffer_inctask_answer_wrong", "id"));
        this.h = findViewById(k.a(getContext(), "myoffer_inctask_close_view", "id"));
        ImageView imageView = (ImageView) findViewById(k.a(getContext(), "myoffer_inctask_right_hint", "id"));
        this.i = imageView;
        if (imageView != null) {
            String strB = k.a() ? d.a().b(b.d.o) : d.a().b(b.d.n);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            d0.a().a(new o(3, strB), -1, -1, new com.smartdigimkt.d2.k(this));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void initSetting(c cVar, e eVar, long j, com.smartdigimkt.d2.c cVar2) {
        String str;
        super.initSetting(cVar, eVar, j, cVar2);
        long j2 = eVar.h1;
        long j3 = eVar.x;
        if (j3 <= 0) {
            j3 = 30000;
        }
        long jMin = (j > 0 ? Math.min(j3, j) : j3) - eVar.g1;
        if (j2 > jMin) {
            j2 = jMin;
        }
        if (j2 == 0) {
            com.smartdigimkt.d2.c cVar3 = this.b;
            if (cVar3 != null) {
                ((n) cVar3).a();
                return;
            }
            return;
        }
        this.j = (j < j3 ? j3 - j : 0L) + j2;
        double d = j2 / 1000.0d;
        String str2 = String.format(getContext().getString(k.a(getContext(), "myoffer_inctask_qa_title", "string")), Integer.valueOf((int) Math.ceil(d)));
        String str3 = String.format(getContext().getString(k.a(getContext(), "myoffer_inctask_qa_subtitle", "string")), Integer.valueOf((int) Math.ceil(d)));
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str2);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(str3);
        }
        if (this.f != null) {
            if (TextUtils.isEmpty(cVar.c)) {
                str = !TextUtils.isEmpty(cVar.d) ? cVar.d : "";
            } else {
                str = cVar.c;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f.setText(str);
            }
            this.f.setOnClickListener(new m(this));
        }
        if (this.g != null) {
            if (!TextUtils.isEmpty(eVar.q0)) {
                this.g.setText(eVar.q0);
            }
            this.g.setOnClickListener(new com.smartdigimkt.d2.n(this));
        }
        View view = this.h;
        if (view != null) {
            view.setOnClickListener(new com.smartdigimkt.d2.o(this));
        }
    }

    public QAIncentiveTaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QAIncentiveTaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

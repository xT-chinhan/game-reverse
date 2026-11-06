package com.smartdigimkt.c1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.x.k;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends Dialog {
    public com.smartdigimkt.b3.c a;
    public com.smartdigimkt.a3.a b;
    public k c;
    public RelativeLayout d;
    public EditText e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public String q;
    public TextView r;
    public final a s;

    public g(int i, Activity activity) {
        super(activity, i);
        this.s = new a(this);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        setContentView(com.smartdigimkt.r4.k.a(context, "myoffer_feedback", "layout"));
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            if (context.getResources().getDisplayMetrics().widthPixels > context.getResources().getDisplayMetrics().heightPixels) {
                window.setGravity(5);
                window.setLayout((int) ((context.getResources().getDisplayMetrics().density * 376.0f) + 0.5f), -1);
            } else {
                window.setGravity(80);
                window.setLayout(-1, -2);
            }
        }
        Context context2 = getContext();
        this.f = (ImageView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_iv_close", "id"));
        this.d = (RelativeLayout) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_container", "id"));
        this.e = (EditText) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_et", "id"));
        this.g = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_commit", "id"));
        this.h = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_1", "id"));
        this.i = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_2", "id"));
        this.j = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_3", "id"));
        this.k = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_4", "id"));
        this.l = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_5", "id"));
        this.m = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_6", "id"));
        this.n = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_7", "id"));
        this.o = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_8", "id"));
        this.p = (TextView) findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_feedback_tv_9", "id"));
        this.f.setOnClickListener(new c(this));
        this.h.setOnClickListener(this.s);
        this.i.setOnClickListener(this.s);
        this.j.setOnClickListener(this.s);
        this.k.setOnClickListener(this.s);
        this.l.setOnClickListener(this.s);
        this.m.setOnClickListener(this.s);
        this.n.setOnClickListener(this.s);
        this.o.setOnClickListener(this.s);
        this.p.setOnClickListener(this.s);
        this.e.addTextChangedListener(new d(this));
        this.g.setOnClickListener(new e(this));
        this.d.setVisibility(0);
        com.smartdigimkt.a3.a aVar = this.b;
        com.smartdigimkt.b3.c cVar = this.a;
        if (aVar != null && cVar != null) {
            com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), "66");
            cVar2.a = "1004737";
            cVar2.a(aVar);
            if (cVar instanceof com.smartdigimkt.b3.b) {
                com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) cVar;
                cVar2.l = String.valueOf(bVar.c0);
                cVar2.m = String.valueOf(bVar.a);
            }
            cVar2.q = "";
            cVar2.r = String.valueOf(aVar.c);
            com.smartdigimkt.n3.k.a(cVar2);
        }
        setOnDismissListener(new b(this));
    }
}

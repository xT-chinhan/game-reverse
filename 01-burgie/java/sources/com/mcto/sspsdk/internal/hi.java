package com.mcto.sspsdk.internal;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hi extends sc {
    public TextView b;
    public TextView c;
    public View d;
    public gi e;
    public boolean f;

    public hi(Context context) {
        super(context);
        this.f = false;
    }

    public void a(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.mcto.sspsdk.internal.sc
    public final void b() {
        d();
    }

    public abstract void d();

    public abstract void e();

    @Override // com.mcto.sspsdk.internal.sc
    public final void a() {
        e();
    }
}

package com.mcto.sspsdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.interaction.QyTwistView;

/* JADX INFO: loaded from: classes2.dex */
public class bj extends hi {
    public QyTwistView g;

    public bj(Context context) {
        super(context);
    }

    public void a(int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.qy_layout_splash_twist, (ViewGroup) this, true);
        QyTwistView qyTwistView = (QyTwistView) findViewById(R.id.qy_splash_action_icon);
        this.g = qyTwistView;
        this.d = qyTwistView;
        qyTwistView.a(i);
        this.b = (TextView) findViewById(R.id.qy_splash_action_title);
        this.c = (TextView) findViewById(R.id.qy_splash_action_sub_title);
    }

    @Override // com.mcto.sspsdk.internal.hi
    public final void d() {
        this.g.a();
        this.g.a(new aj(this));
    }

    @Override // com.mcto.sspsdk.internal.hi
    public final void e() {
        this.g.b();
    }

    public bj(Context context, int i) {
        super(context);
    }
}

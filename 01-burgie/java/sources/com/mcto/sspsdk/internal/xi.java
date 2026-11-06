package com.mcto.sspsdk.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.interaction.QySharkView;

/* JADX INFO: loaded from: classes2.dex */
public class xi extends hi {
    public QySharkView g;

    public xi(Context context) {
        super(context);
    }

    public void a(int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.qy_layout_splash_shark, (ViewGroup) this, true);
        QySharkView qySharkView = (QySharkView) findViewById(R.id.qy_splash_action_icon);
        this.g = qySharkView;
        this.d = qySharkView;
        this.b = (TextView) findViewById(R.id.qy_splash_action_title);
        this.c = (TextView) findViewById(R.id.qy_splash_action_sub_title);
    }

    @Override // com.mcto.sspsdk.internal.hi
    public final void d() {
        this.g.a(new wi(this));
        this.g.a();
    }

    @Override // com.mcto.sspsdk.internal.hi
    public final void e() {
        this.g.b();
    }

    public xi(Context context, int i) {
        super(context);
    }
}

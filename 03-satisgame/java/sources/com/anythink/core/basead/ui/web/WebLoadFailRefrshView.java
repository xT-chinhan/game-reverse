package com.anythink.core.basead.ui.web;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public class WebLoadFailRefrshView extends LinearLayout {
    private View.OnClickListener a;

    public WebLoadFailRefrshView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(p.a(getContext(), "web_load_fail_refresh", "layout"), this);
        setOrientation(1);
        setGravity(17);
        findViewById(p.a(getContext(), "web_load_fail_refresh", "id")).setOnClickListener(new AnonymousClass1());
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(p.a(getContext(), "web_load_fail_refresh", "layout"), this);
        setOrientation(1);
        setGravity(17);
        findViewById(p.a(getContext(), "web_load_fail_refresh", "id")).setOnClickListener(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLoadFailRefrshView$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (WebLoadFailRefrshView.this.a != null) {
                WebLoadFailRefrshView.this.a.onClick(view);
            }
        }
    }

    public void setOnRefreshListener(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }
}

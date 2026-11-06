package com.smartdigimkt.sdk.basead.ui.web;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.smartdigimkt.j2.r;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class WebLoadFailRefrshView extends LinearLayout {
    public View.OnClickListener a;

    public WebLoadFailRefrshView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "web_load_fail_refresh", "layout"), this);
        setOrientation(1);
        setGravity(17);
        findViewById(k.a(getContext(), "web_load_fail_refresh", "id")).setOnClickListener(new r(this));
    }

    public void setOnRefreshListener(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }
}

package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.widget.ImageView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.p;
import com.anythink.core.common.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSdkSplashATView extends BaseSplashATView {
    protected RoundImageView l;
    protected MuteImageView m;
    ImageView n;
    ImageView o;
    protected boolean p;

    protected abstract void b();

    public BaseSdkSplashATView(Context context) {
        super(context);
        this.p = false;
    }

    public BaseSdkSplashATView(Context context, x xVar, w wVar, com.anythink.core.common.inner.e.a aVar) {
        super(context, xVar, wVar, aVar);
        this.p = false;
    }

    protected void f() {
        b();
        this.l = (RoundImageView) findViewById(p.a(getContext(), "myoffer_ad_logo", "id"));
        this.n = (ImageView) findViewById(p.a(getContext(), "myoffer_player_view_cover_img_id", "id"));
        this.o = (ImageView) findViewById(p.a(getContext(), "myoffer_player_view_cover_icon_id", "id"));
        c();
    }

    protected void c() {
        this.p = true;
    }
}

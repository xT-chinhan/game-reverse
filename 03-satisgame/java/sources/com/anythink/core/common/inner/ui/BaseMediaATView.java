package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.u.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMediaATView extends FrameLayout {
    protected w a;
    protected y b;
    protected x c;
    protected a d;
    protected boolean e;
    protected FrameLayout f;
    protected CloseImageView g;
    protected int h;
    protected com.anythink.core.common.inner.ui.e.a i;
    private int j;
    private int k;

    public interface a {
        void a();
    }

    public void destroy() {
    }

    public BaseMediaATView(Context context) {
        super(context);
        this.j = 0;
        this.k = 0;
    }

    public BaseMediaATView(Context context, w wVar, x xVar, boolean z, a aVar) {
        super(context);
        this.j = 0;
        this.k = 0;
        this.a = wVar;
        this.b = xVar.t;
        this.e = z;
        this.d = aVar;
        this.c = xVar;
        LayoutInflater.from(getContext()).inflate(p.a(getContext(), "base_myoffer_media_ad_view", "layout"), this);
        this.f = (FrameLayout) findViewById(p.a(getContext(), "base_media_view_content", "id"));
        this.g = (CloseImageView) findViewById(p.a(getContext(), "base_media_ad_close", "id"));
    }

    public int getMediaViewWidth() {
        return this.j;
    }

    public int getMediaViewHeight() {
        return this.k;
    }

    public void init(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.h = i3;
        if (i2 <= 0) {
            if (i3 == 1 || i3 == 2) {
                this.k = (int) (i * 0.5f);
            } else {
                this.k = (int) (i * 0.75f);
            }
        }
        CloseImageView closeImageView = this.g;
        if (closeImageView != null) {
            if (this.e) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
            this.g.setOnClickListener(new AnonymousClass1());
        }
    }

    private void a() {
        if (this.k <= 0) {
            int i = this.h;
            if (i == 1 || i == 2) {
                this.k = (int) (this.j * 0.5f);
            } else {
                this.k = (int) (this.j * 0.75f);
            }
        }
    }

    private void b() {
        CloseImageView closeImageView = this.g;
        if (closeImageView == null) {
            return;
        }
        if (this.e) {
            closeImageView.setVisibility(0);
        } else {
            closeImageView.setVisibility(8);
        }
        this.g.setOnClickListener(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.BaseMediaATView$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (BaseMediaATView.this.d != null) {
                BaseMediaATView.this.d.a();
            }
        }
    }

    public List<View> getClickViews() {
        return new ArrayList();
    }
}

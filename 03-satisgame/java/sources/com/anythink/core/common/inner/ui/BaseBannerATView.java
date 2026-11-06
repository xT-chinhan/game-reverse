package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBannerATView extends BaseATView {
    public final String TAG;
    protected com.anythink.core.common.inner.e.a a;
    protected CloseImageView b;
    protected com.anythink.core.common.inner.ui.e.a c;

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a(e eVar) {
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a(boolean z) {
    }

    public BaseBannerATView(Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
    }

    public BaseBannerATView(Context context, x xVar, w wVar, com.anythink.core.common.inner.e.a aVar) {
        super(context, xVar, wVar);
        this.TAG = getClass().getSimpleName();
        this.a = aVar;
    }

    protected final void b() {
        CloseImageView closeImageView = this.b;
        if (closeImageView != null) {
            closeImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.core.common.inner.ui.BaseBannerATView.1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0 || BaseBannerATView.this.a == null) {
                        return true;
                    }
                    BaseBannerATView.this.a.b();
                    return true;
                }
            });
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void e() {
        if (this.a != null) {
            new e();
        }
    }
}

package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.anythink.core.common.d.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLifecycleG2CV2View extends BaseG2CV2View {
    private GTCV2InnerCountDownView d;

    abstract int e();

    public BaseLifecycleG2CV2View(Context context) {
        super(context);
    }

    public BaseLifecycleG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseLifecycleG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void init(long j, int i, int i2, com.anythink.basead.ui.improveclick.c.a aVar, BaseG2CV2View.b bVar) {
        super.init(j, i, i2, aVar, bVar);
        if (this.c instanceof com.anythink.basead.ui.improveclick.c.b) {
            ((com.anythink.basead.ui.improveclick.c.b) this.c).b();
        }
    }

    protected final void d() {
        if (this.d == null) {
            this.d = new GTCV2InnerCountDownView(getContext());
            addView(this.d, new ViewGroup.MarginLayoutParams(-1, -1));
            this.d.initSetting(new GTCV2InnerCountDownView.a() { // from class: com.anythink.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View.1
                @Override // com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.a
                public final void a() {
                    if (BaseLifecycleG2CV2View.this.c != null) {
                        BaseLifecycleG2CV2View.this.c.a(11, BaseLifecycleG2CV2View.this.e());
                    }
                }

                @Override // com.anythink.basead.ui.guidetoclickv2.GTCV2InnerCountDownView.a
                public final void b() {
                    BaseLifecycleG2CV2View.this.c();
                }
            });
        }
        t.b().d(this.b);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void resumeAnimPlay() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.d;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onResume();
        } else {
            super.resumeAnimPlay();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void pauseAnimPlay() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.d;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onPause();
        } else {
            super.pauseAnimPlay();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected void a() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.d;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onResume();
        } else {
            super.a();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected void b() {
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.d;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.onPause();
        } else {
            super.b();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        GTCV2InnerCountDownView gTCV2InnerCountDownView = this.d;
        if (gTCV2InnerCountDownView != null) {
            gTCV2InnerCountDownView.release();
        }
        if (this.c instanceof com.anythink.basead.ui.improveclick.c.b) {
            ((com.anythink.basead.ui.improveclick.c.b) this.c).a();
        }
    }
}

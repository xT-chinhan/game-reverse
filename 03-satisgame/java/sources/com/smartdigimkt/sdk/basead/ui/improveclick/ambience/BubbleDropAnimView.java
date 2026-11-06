package com.smartdigimkt.sdk.basead.ui.improveclick.ambience;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.anythink.core.common.a.b;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b2.e;
import com.smartdigimkt.c2.d;
import com.smartdigimkt.c2.f;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.z.d0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BubbleDropAnimView extends BaseAmbienceView {
    public BubbleDropChildView b;
    public ObjectAnimator c;
    public Bitmap d;
    public int e;
    public boolean f;
    public boolean g;

    public BubbleDropAnimView(Context context) {
        super(context);
        this.f = false;
        this.g = false;
    }

    public final void a() {
        BubbleDropChildView bubbleDropChildView = this.b;
        if (bubbleDropChildView == null) {
            return;
        }
        if (this.c == null && !this.f) {
            bubbleDropChildView.setVisibility(0);
            this.b.initRedPacketList(this.d);
            BubbleDropChildView bubbleDropChildView2 = this.b;
            int i = this.e;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(bubbleDropChildView2, "translationY", -i, i);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setRepeatCount(0);
            this.c.setDuration(4000L);
            this.c.setInterpolator(new LinearInterpolator());
            this.c.addListener(new f(this));
        }
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null && !objectAnimator.isStarted() && !this.f) {
            this.b.setTranslationY(-this.e);
            this.c.start();
        }
        this.g = false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BaseAmbienceView
    public void initSetting(a aVar, e eVar) {
        this.a = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0043  */
    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BaseAmbienceView
    public void initView() {
        Bitmap bitmapB;
        RelativeLayout.LayoutParams layoutParams;
        BubbleDropChildView bubbleDropChildView = new BubbleDropChildView(getContext());
        this.b = bubbleDropChildView;
        bubbleDropChildView.initSetting(new d(this));
        com.smartdigimkt.m1.d dVarA = com.smartdigimkt.m1.d.a();
        Map map = dVarA.g;
        if (map == null || map.isEmpty()) {
            bitmapB = null;
        } else {
            String str = (String) dVarA.g.get(b.d.b);
            if (TextUtils.isEmpty(str)) {
                bitmapB = null;
            } else {
                bitmapB = d0.a().b(new o(3, str), 0, 0);
            }
        }
        this.d = bitmapB;
        if (bitmapB == null || bitmapB.isRecycled()) {
            release();
            return;
        }
        if (k.b(getContext())) {
            layoutParams = new RelativeLayout.LayoutParams(getContext().getResources().getDisplayMetrics().heightPixels, -1);
            layoutParams.addRule(13);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        addView(this.b, layoutParams);
        this.b.post(new com.smartdigimkt.c2.e(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BaseAmbienceView
    public void onPause() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.pause();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BaseAmbienceView
    public void onResume() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            if (objectAnimator.isPaused()) {
                this.c.resume();
            } else {
                a();
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.improveclick.ambience.BaseAmbienceView
    public void release() {
        if (this.g) {
            return;
        }
        BubbleDropChildView bubbleDropChildView = this.b;
        if (bubbleDropChildView != null) {
            bubbleDropChildView.release();
        }
        BubbleDropChildView bubbleDropChildView2 = this.b;
        if (bubbleDropChildView2 != null) {
            bubbleDropChildView2.setTranslationY(-this.e);
        }
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.c.cancel();
            this.c = null;
        }
        this.g = true;
    }

    public BubbleDropAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = false;
    }

    public BubbleDropAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
        this.g = false;
    }
}

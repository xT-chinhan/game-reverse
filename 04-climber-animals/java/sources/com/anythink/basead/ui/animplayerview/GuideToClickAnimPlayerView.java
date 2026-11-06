package com.anythink.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.GuideToClickView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GuideToClickAnimPlayerView extends BaseAnimPlayerView {
    private GuideToClickView h;

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void a() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void b() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void c() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void d() {
    }

    public GuideToClickAnimPlayerView(Context context) {
        super(context);
    }

    public GuideToClickAnimPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideToClickAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        Bitmap bitmap;
        super.init(wVar, xVar, z, list, eVar);
        Context applicationContext = getContext().getApplicationContext();
        g();
        GuideToClickView guideToClickView = new GuideToClickView(applicationContext);
        this.h = guideToClickView;
        addView(guideToClickView, -1, -1);
        if (this.d == null || this.d.size() <= 0 || (bitmap = this.d.get(0)) == null || bitmap.isRecycled()) {
            return;
        }
        this.h.setFingerImageResource(bitmap);
    }

    private void a(Context context) {
        Bitmap bitmap;
        g();
        GuideToClickView guideToClickView = new GuideToClickView(context);
        this.h = guideToClickView;
        addView(guideToClickView, -1, -1);
        if (this.d == null || this.d.size() <= 0 || (bitmap = this.d.get(0)) == null || bitmap.isRecycled()) {
            return;
        }
        this.h.setFingerImageResource(bitmap);
    }
}

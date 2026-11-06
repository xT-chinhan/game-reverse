package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.sdk.basead.ui.GuideToClickView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GuideToClickAnimPlayerView extends BaseAnimPlayerView {
    public GuideToClickView C;

    public GuideToClickAnimPlayerView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void init(c cVar, a aVar, boolean z, List<Bitmap> list) {
        Bitmap bitmap;
        super.init(cVar, aVar, z, list);
        Context applicationContext = getContext().getApplicationContext();
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
        GuideToClickView guideToClickView = new GuideToClickView(applicationContext);
        this.C = guideToClickView;
        addView(guideToClickView, -1, -1);
        List list2 = this.v;
        if (list2 == null || list2.size() <= 0 || (bitmap = (Bitmap) this.v.get(0)) == null || bitmap.isRecycled()) {
            return;
        }
        this.C.setFingerImageResource(bitmap);
    }

    public GuideToClickAnimPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideToClickAnimPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

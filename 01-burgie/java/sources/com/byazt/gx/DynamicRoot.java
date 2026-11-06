package com.byazt.gx;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.byazt.rk.zo;
import com.taptap.sdk.update.download.DownloadTask;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS})
public class DynamicRoot extends DynamicBaseWidgetImp {
    public hw pr;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        return super.zo();
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public hw pr(Bitmap bitmap) {
        pr prVar = new pr(bitmap, this.pr);
        this.pr = prVar;
        return prVar;
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public GradientDrawable getDrawable() {
        hw hwVar = new hw();
        this.pr = hwVar;
        return hwVar;
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public GradientDrawable pr(GradientDrawable.Orientation orientation, int[] iArr) {
        hw hwVar = new hw(orientation, iArr);
        this.pr = hwVar;
        return hwVar;
    }
}

package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.adsdk.lottie.nw;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends ab {
    private final Map<String, Object> ch;
    private int ny;
    private int x;

    public zb(com.bytedance.adsdk.lottie.x xVar, x xVar2, Context context) {
        super(xVar, xVar2);
        this.x = -1;
        this.ny = -1;
        HashMap map = new HashMap();
        this.ch = map;
        if (this.ab != null) {
            float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
            this.x = (int) (this.ab.ms() * fMs);
            this.ny = (int) (this.ab.xr() * fMs);
            map.put("ugen_url", this.ab.d());
            map.put("ugen_md5", this.ab.ka());
            map.put("ugen_v", this.ab.c());
            map.put("ugen_w", Integer.valueOf(this.x));
            map.put("ugen_h", Integer.valueOf(this.ny));
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ab, com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        nw nwVarMs = this.xr.ms();
        View viewMs = nwVarMs != null ? nwVarMs.ms("view:", this.ch) : null;
        if (this.x <= 0 || viewMs == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        ms(i);
        float fX = x();
        ms(viewMs, this.x, this.ny);
        viewMs.setAlpha(fX);
        viewMs.draw(canvas);
        canvas.restore();
    }

    private static void ms(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}

package com.byazt.vf;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1181, 13})
public class hw extends pr {
    public int c;
    public int hn;
    public Paint uc;
    public int x;

    public hw(com.byazt.ik.hn hnVar, JSONObject jSONObject) {
        super(hnVar, jSONObject);
        Paint paint = new Paint();
        this.uc = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.byazt.vf.pr
    public void hw() {
        this.hn = com.byazt.aa.pr.pr(this.pr.optString("backgroundColor"), -1);
    }

    @Override // com.byazt.vf.pr
    public void pr(Canvas canvas) {
        hn(canvas);
    }

    @Override // com.byazt.vf.pr
    public void hw(Canvas canvas) {
        hn(canvas);
    }

    private void hn(Canvas canvas) {
        try {
            if (this.hw.r() > 0.0f) {
                this.uc.setColor(this.hn);
                this.uc.setAlpha((int) ((1.0f - this.hw.r()) * 255.0f));
                ((ViewGroup) this.hw.aj().getParent()).setClipChildren(true);
                int i = this.x;
                int i2 = this.c;
                canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * this.hw.r(), this.uc);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vf.pr
    public void pr(int i, int i2) {
        this.x = i / 2;
        this.c = i2 / 2;
    }

    @Override // com.byazt.vf.pr
    public List<PropertyValuesHolder> hn() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(x(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}

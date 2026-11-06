package com.byazt.pw;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1113, 26})
public class qg extends n {
    public int l;
    public int q;
    public int s;
    public Paint w;

    public qg(com.byazt.ih.s sVar, JSONObject jSONObject) {
        super(sVar, jSONObject);
        Paint paint = new Paint();
        this.w = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.byazt.pw.n
    public void qg() {
        this.s = com.byazt.hb.n.n(this.n.optString("backgroundColor"), -1);
    }

    @Override // com.byazt.pw.n
    public void n(Canvas canvas) {
        s(canvas);
    }

    @Override // com.byazt.pw.n
    public void qg(Canvas canvas) {
        s(canvas);
    }

    private void s(Canvas canvas) {
        try {
            if (this.qg.sh() > 0.0f) {
                this.w.setColor(this.s);
                this.w.setAlpha((int) ((1.0f - this.qg.sh()) * 255.0f));
                ((ViewGroup) this.qg.rv().getParent()).setClipChildren(true);
                int i = this.q;
                int i2 = this.l;
                canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * this.qg.sh(), this.w);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.pw.n
    public void n(int i, int i2) {
        this.q = i / 2;
        this.l = i2 / 2;
    }

    @Override // com.byazt.pw.n
    public List<PropertyValuesHolder> s() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(q(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}

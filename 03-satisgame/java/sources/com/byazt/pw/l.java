package com.byazt.pw;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1113, 18})
public class l extends n {
    public Path cp;
    public Path d;
    public boolean fs;
    public Paint l;
    public PorterDuffXfermode oa;
    public float q;
    public boolean rv;
    public float s;
    public Path tj;
    public float w;
    public String x;

    public l(com.byazt.ih.s sVar, JSONObject jSONObject) {
        super(sVar, jSONObject);
        this.fs = true;
        this.rv = true;
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.qg.rv().setLayerType(2, null);
        this.oa = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.tj = new Path();
        this.cp = new Path();
        this.d = new Path();
        this.l.setXfermode(this.oa);
    }

    @Override // com.byazt.pw.n
    public void qg() {
        this.w = (float) this.n.optDouble("start", 0.0d);
        this.x = this.n.optString("direction", "center");
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
        if (this.qg.rf() > 0.0f) {
            int iRf = (int) (this.s * this.qg.rf());
            int iRf2 = (int) (this.q * this.qg.rf());
            this.l.setXfermode(this.oa);
            String str = this.x;
            str.hashCode();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, iRf2, this.s, this.q, this.l);
                    break;
                case "center":
                    this.tj.reset();
                    this.cp.reset();
                    this.d.reset();
                    this.tj.addCircle(this.s / 2.0f, this.q / 2.0f, iRf, Path.Direction.CW);
                    Path path = this.cp;
                    float f = this.s;
                    path.addRect(f / 2.0f, 0.0f, f, this.q, Path.Direction.CW);
                    this.cp.op(this.tj, Path.Op.DIFFERENCE);
                    this.d.addRect(0.0f, 0.0f, this.s / 2.0f, this.q, Path.Direction.CW);
                    this.d.op(this.tj, Path.Op.DIFFERENCE);
                    canvas.drawPath(this.cp, this.l);
                    canvas.drawPath(this.d, this.l);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.s, this.q - iRf2, this.l);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.s - iRf, this.q, this.l);
                    break;
                case "right":
                    canvas.drawRect(iRf, 0.0f, this.s, this.q, this.l);
                    break;
            }
            return;
        }
        this.l.setXfermode(this.oa);
        canvas.drawRect(0.0f, 0.0f, this.s, this.q, this.l);
    }

    @Override // com.byazt.pw.n
    public void n(int i, int i2) {
        if (i > 0 && this.fs) {
            this.s = i;
            this.fs = false;
        }
        if (i2 <= 0 || !this.rv) {
            return;
        }
        this.q = i2;
        this.rv = false;
    }

    @Override // com.byazt.pw.n
    public List<PropertyValuesHolder> s() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(q(), this.w, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}

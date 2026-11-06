package com.byazt.vf;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1181, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public boolean aj;
    public Paint c;
    public String fw;
    public float hn;
    public Path k;
    public PorterDuffXfermode m;
    public float uc;
    public Path vk;
    public Path w;
    public float x;
    public boolean zo;

    public c(com.byazt.ik.hn hnVar, JSONObject jSONObject) {
        super(hnVar, jSONObject);
        this.zo = true;
        this.aj = true;
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.hw.aj().setLayerType(2, null);
        this.m = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.vk = new Path();
        this.w = new Path();
        this.k = new Path();
        this.c.setXfermode(this.m);
    }

    @Override // com.byazt.vf.pr
    public void hw() {
        this.uc = (float) this.pr.optDouble(TrackAction.START, 0.0d);
        this.fw = this.pr.optString("direction", "center");
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
        if (this.hw.nw() > 0.0f) {
            int iNw = (int) (this.hn * this.hw.nw());
            int iNw2 = (int) (this.x * this.hw.nw());
            this.c.setXfermode(this.m);
            switch (this.fw) {
                case "right":
                    canvas.drawRect(iNw, 0.0f, this.hn, this.x, this.c);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.hn - iNw, this.x, this.c);
                    break;
                case "bottom":
                    canvas.drawRect(0.0f, iNw2, this.hn, this.x, this.c);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.hn, this.x - iNw2, this.c);
                    break;
                case "center":
                    this.vk.reset();
                    this.w.reset();
                    this.k.reset();
                    this.vk.addCircle(this.hn / 2.0f, this.x / 2.0f, iNw, Path.Direction.CW);
                    Path path = this.w;
                    float f = this.hn;
                    path.addRect(f / 2.0f, 0.0f, f, this.x, Path.Direction.CW);
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.w.op(this.vk, Path.Op.DIFFERENCE);
                    }
                    this.k.addRect(0.0f, 0.0f, this.hn / 2.0f, this.x, Path.Direction.CW);
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.k.op(this.vk, Path.Op.DIFFERENCE);
                    }
                    canvas.drawPath(this.w, this.c);
                    canvas.drawPath(this.k, this.c);
                    break;
            }
            return;
        }
        this.c.setXfermode(this.m);
        canvas.drawRect(0.0f, 0.0f, this.hn, this.x, this.c);
    }

    @Override // com.byazt.vf.pr
    public void pr(int i, int i2) {
        if (i > 0 && this.zo) {
            this.hn = i;
            this.zo = false;
        }
        if (i2 > 0 && this.aj) {
            this.x = i2;
            this.aj = false;
        }
    }

    @Override // com.byazt.vf.pr
    public List<PropertyValuesHolder> hn() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(x(), this.uc, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}

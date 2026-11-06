package com.byazt.cg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.byazt.dx.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 108})
public class m extends fw {
    public int aj;
    public final Map<String, Object> vk;
    public int zo;

    public m(com.byazt.dx.zo zoVar, zo zoVar2, Context context) {
        super(zoVar, zoVar2);
        this.zo = -1;
        this.aj = -1;
        HashMap map = new HashMap();
        this.vk = map;
        if (this.fw != null) {
            float fPr = com.byazt.ptr.vk.pr();
            this.zo = (int) (this.fw.pr() * fPr);
            this.aj = (int) (this.fw.hw() * fPr);
            map.put("ugen_url", this.fw.x());
            map.put("ugen_md5", this.fw.c());
            map.put("ugen_v", this.fw.uc());
            map.put("ugen_w", Integer.valueOf(this.zo));
            map.put("ugen_h", Integer.valueOf(this.aj));
        }
    }

    @Override // com.byazt.cg.fw, com.byazt.cg.hn
    public void hw(Canvas canvas, Matrix matrix, int i) {
        View viewPr;
        ny nyVarPr = this.hw.pr();
        if (nyVarPr == null) {
            viewPr = null;
        } else {
            viewPr = nyVarPr.pr("view:", this.vk);
        }
        if (this.zo > 0 && viewPr != null) {
            canvas.save();
            canvas.concat(matrix);
            pr(i);
            float fZo = zo();
            pr(viewPr, this.zo, this.aj);
            viewPr.setAlpha(fZo);
            viewPr.draw(canvas);
            canvas.restore();
        }
    }

    private static void pr(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}

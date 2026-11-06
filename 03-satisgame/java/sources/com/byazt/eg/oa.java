package com.byazt.eg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.byazt.pp.ou;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends x {
    public int fs;
    public int rv;
    public final Map<String, Object> tj;

    public oa(com.byazt.pp.fs fsVar, fs fsVar2, Context context) {
        super(fsVar, fsVar2);
        this.fs = -1;
        this.rv = -1;
        HashMap map = new HashMap();
        this.tj = map;
        if (this.x != null) {
            float fN = com.byazt.nu.tj.n();
            this.fs = (int) (this.x.n() * fN);
            this.rv = (int) (this.x.qg() * fN);
            map.put("ugen_url", this.x.q());
            map.put("ugen_md5", this.x.l());
            map.put("ugen_v", this.x.w());
            map.put("ugen_w", Integer.valueOf(this.fs));
            map.put("ugen_h", Integer.valueOf(this.rv));
        }
    }

    @Override // com.byazt.eg.x, com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        ou ouVarN = this.qg.n();
        View viewN = ouVarN != null ? ouVarN.n("view:", this.tj) : null;
        if (this.fs <= 0 || viewN == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        n(i);
        float fFs = fs();
        n(viewN, this.fs, this.rv);
        viewN.setAlpha(fFs);
        viewN.draw(canvas);
        canvas.restore();
    }

    private static void n(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i2, C.ENCODING_PCM_32BIT));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}

package com.byazt.qdx;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.imu.q;
import com.byazt.si.a;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 844, 19})
public class n {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.byazt.qdx.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 844, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0311n implements qg {
        @Override // com.byazt.qdx.n.qg
        public void n(int i, String str, Throwable th) {
        }

        @Override // com.byazt.qdx.n.qg
        public void n(cy cyVar, com.byazt.qdx.qg qgVar) {
        }
    }

    public interface qg {
        void n(int i, String str, Throwable th);

        void n(cy cyVar, com.byazt.qdx.qg qgVar);
    }

    public void n() {
    }

    public void n(q qVar, qg qgVar, int i, int i2, String str) {
        n(qVar, qgVar, i, i2, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void n(q qVar, qg qgVar, int i, int i2, String str, int i3, a aVar, boolean z) {
        n(qVar, qgVar, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, aVar, z);
    }

    public void n(q qVar, final qg qgVar, int i, int i2, ImageView.ScaleType scaleType, String str) {
        com.byazt.imu.s.n(qVar.n).qg(qVar.qg).n(i).qg(i2).s(str).n(Bitmap.Config.RGB_565).n(scaleType).qg(!TextUtils.isEmpty(str)).n(new m() { // from class: com.byazt.qdx.n.1
            @Override // com.byazt.si.m
            public void n(cy cyVar) {
                n.this.n(cyVar, qgVar);
            }

            @Override // com.byazt.si.m
            public void n(int i3, String str2, Throwable th) {
                n.this.n(i3, str2, th, qgVar);
            }
        });
        n();
    }

    public void n(q qVar, final qg qgVar, int i, int i2, ImageView.ScaleType scaleType, String str, int i3, a aVar, boolean z) {
        com.byazt.imu.s.n(qVar.n).qg(qVar.qg).n(i).qg(i2).s(str).n(Bitmap.Config.RGB_565).n(scaleType).n(aVar).n(z).qg(!TextUtils.isEmpty(str)).n(new m() { // from class: com.byazt.qdx.n.2
            @Override // com.byazt.si.m
            public void n(cy cyVar) {
                n.this.n(cyVar, qgVar);
            }

            @Override // com.byazt.si.m
            public void n(int i4, String str2, Throwable th) {
                n.this.n(i4, str2, th, qgVar);
            }
        }, i3);
        n();
    }

    public void n(cy cyVar, qg qgVar) {
        if (qgVar != null) {
            Object objS = cyVar.s();
            int iN = n(cyVar);
            if (objS instanceof byte[]) {
                qgVar.n(cyVar, new com.byazt.qdx.qg((byte[]) objS, iN));
            } else if (objS instanceof Bitmap) {
                qgVar.n(cyVar, new com.byazt.qdx.qg((Bitmap) objS, iN));
            } else {
                qgVar.n(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int n(cy cyVar) {
        Map<String, String> mapX = cyVar.x();
        if (mapX == null) {
            return 0;
        }
        try {
            String str = mapX.get("image_size");
            if (str == null || !(str instanceof String)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void n(int i, String str, Throwable th, qg qgVar) {
        if (qgVar != null) {
            qgVar.n(i, str, th);
        }
    }

    public static C0311n qg() {
        return new C0311n();
    }
}

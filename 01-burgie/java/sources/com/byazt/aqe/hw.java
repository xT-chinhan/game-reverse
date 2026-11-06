package com.byazt.aqe;

import android.graphics.Bitmap;
import android.os.Build;
import com.byazt.ld.y;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1295, 13})
public class hw implements y {
    public com.byazt.bbo.hn<String, Bitmap> hn;
    public int hw;
    public int pr;

    public hw(int i, int i2) {
        this.hw = i;
        this.pr = i2;
        this.hn = new com.byazt.bbo.hn<String, Bitmap>(i) { // from class: com.byazt.aqe.hw.1
            @Override // com.byazt.bbo.hn
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int hw(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return hw.pr(bitmap);
            }
        };
    }

    @Override // com.byazt.ld.pr
    public boolean pr(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.hn.pr(str, bitmap);
        return true;
    }

    @Override // com.byazt.ld.pr
    public Bitmap pr(String str) {
        return this.hn.pr(str);
    }

    @Override // com.byazt.ld.pr
    public void pr() {
        pr(0.0d);
    }

    @Override // com.byazt.ld.pr
    public boolean hw(String str) {
        return this.hn.pr(str) != null;
    }

    @Override // com.byazt.ld.pr
    public void pr(double d) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.hn.pr((int) (((double) this.hw) * d));
        } else {
            this.hn.pr();
        }
    }

    public static int pr(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}

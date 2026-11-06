package com.byazt.aqe;

import android.graphics.Bitmap;
import com.byazt.ld.y;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1295, 121})
public class x implements y {
    public final com.byazt.bbo.hw hw;
    public final y pr;

    public x(y yVar) {
        this(yVar, null);
    }

    public x(y yVar, com.byazt.bbo.hw hwVar) {
        this.pr = yVar;
        this.hw = hwVar;
    }

    @Override // com.byazt.ld.pr
    public boolean pr(String str, Bitmap bitmap) {
        boolean zPr = this.pr.pr(str, bitmap);
        if (this.hw != null) {
            Boolean.valueOf(zPr);
        }
        return zPr;
    }

    @Override // com.byazt.ld.pr
    public Bitmap pr(String str) {
        return this.pr.pr(str);
    }

    @Override // com.byazt.ld.pr
    public void pr() {
        this.pr.pr();
    }

    @Override // com.byazt.ld.pr
    public boolean hw(String str) {
        return this.pr.hw(str);
    }

    @Override // com.byazt.ld.pr
    public void pr(double d) {
        this.pr.pr(d);
    }
}

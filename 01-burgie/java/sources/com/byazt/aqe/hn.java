package com.byazt.aqe;

import android.os.Build;
import com.byazt.ld.ww;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1295, 20})
public class hn implements ww {
    public com.byazt.bbo.hn<String, byte[]> hn;
    public int hw;
    public int pr;

    public hn(int i, int i2) {
        this.hw = i;
        this.pr = i2;
        this.hn = new com.byazt.bbo.hn<String, byte[]>(i) { // from class: com.byazt.aqe.hn.1
            @Override // com.byazt.bbo.hn
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int hw(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.byazt.ld.pr
    public boolean pr(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.hn.pr(str, bArr);
        return true;
    }

    @Override // com.byazt.ld.pr
    public byte[] pr(String str) {
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
}

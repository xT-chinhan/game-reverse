package com.byazt.nk;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 62})
public class fw extends com.byazt.xv.hw {
    public boolean w;

    public fw(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        int iIntValue;
        int iIntValue2;
        if (this.c == null || this.c.isEmpty()) {
            return false;
        }
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof Integer) {
                iIntValue = ((Integer) obj).intValue();
            } else {
                iIntValue = -1;
            }
        } else {
            iIntValue = -1;
        }
        if (objArr.length > 1) {
            Object obj2 = objArr[1];
            if (obj2 instanceof Integer) {
                iIntValue2 = ((Integer) obj2).intValue();
            } else {
                iIntValue2 = -1;
            }
        } else {
            iIntValue2 = -1;
        }
        if (iIntValue <= 0) {
            this.w = false;
        }
        if (this.c.containsKey("percent")) {
            Object obj3 = this.c.get("percent");
            float fPr = com.byazt.aa.hn.pr(obj3 != null ? String.valueOf(obj3) : "", -1.0f);
            if (fPr >= 0.0f) {
                if (iIntValue >= (fPr / 100.0f) * iIntValue2 && !this.w) {
                    this.w = true;
                    if (this.pr != null) {
                        this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
                    }
                }
            }
        } else {
            Object obj4 = this.c.get(an.aU);
            if (iIntValue >= com.byazt.aa.hn.pr(obj4 != null ? String.valueOf(obj4) : "", -1) && !this.w) {
                this.w = true;
                if (this.pr != null) {
                    this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
                }
            }
        }
        return true;
    }
}

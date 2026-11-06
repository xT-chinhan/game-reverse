package com.byazt.nk;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 20})
public class hn extends com.byazt.xv.hw {
    public boolean w;

    public hn(Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    /* JADX WARN: Code duplicated, block: B:18:0x0032  */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        String str;
        int iIntValue;
        int iIntValue2;
        int iPr;
        Object obj;
        int iPr2 = 0;
        if (this.c == null || this.c.isEmpty()) {
            return false;
        }
        if (objArr.length > 0) {
            Object obj2 = objArr[0];
            if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        if (objArr.length > 1) {
            Object obj3 = objArr[1];
            if (obj3 instanceof Integer) {
                iIntValue = ((Integer) obj3).intValue();
            } else {
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        if (objArr.length > 2) {
            Object obj4 = objArr[2];
            if (obj4 instanceof Integer) {
                iIntValue2 = ((Integer) obj4).intValue();
            } else {
                iIntValue2 = 0;
            }
        } else {
            iIntValue2 = 0;
        }
        String strValueOf = (!this.c.containsKey("id") || (obj = this.c.get("id")) == null) ? "" : String.valueOf(obj);
        if (!TextUtils.equals(strValueOf, str)) {
            return false;
        }
        if (!this.c.containsKey("state")) {
            iPr = 0;
        } else {
            Object obj5 = this.c.get("state");
            iPr = com.byazt.aa.hn.pr(obj5 != null ? String.valueOf(obj5) : "", 0);
        }
        if (iPr != iIntValue) {
            return false;
        }
        if (this.c.containsKey("repeat")) {
            Object obj6 = this.c.get("repeat");
            iPr2 = com.byazt.aa.hn.pr(obj6 != null ? String.valueOf(obj6) : "", 0);
        }
        switch (iPr) {
            case 1:
                if (iPr2 == 1 || !this.w) {
                    this.w = true;
                    if (this.pr != null) {
                        this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
                    }
                }
                return true;
            case 2:
                float fPr = 0.0f;
                if (this.c.containsKey("percent")) {
                    Object obj7 = this.c.get("percent");
                    fPr = com.byazt.aa.hn.pr(obj7 != null ? String.valueOf(obj7) : "", 0.0f);
                }
                if (iIntValue2 >= fPr && (iPr2 == 1 || !this.w)) {
                    this.w = true;
                    if (this.pr != null) {
                        this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
                    }
                }
                return true;
            default:
                return true;
        }
    }
}

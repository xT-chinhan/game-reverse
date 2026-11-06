package com.byazt.nk;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.taptap.sdk.db.constant.Common;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 121})
public class x extends com.byazt.xv.hw {
    public String w;

    public x(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        String str;
        String str2;
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        if (objArr.length > 1) {
            Object obj2 = objArr[1];
            if (obj2 instanceof String) {
                str2 = (String) obj2;
            } else {
                str2 = "";
            }
        } else {
            str2 = "";
        }
        if (this.c == null || this.c.size() <= 0) {
            return false;
        }
        Object obj3 = this.c.get("id");
        if (obj3 == null) {
            obj3 = this.c.get(Common.System.NAME);
        }
        String strValueOf = obj3 != null ? String.valueOf(obj3) : "";
        Object obj4 = this.c.get("state");
        this.w = obj4 != null ? String.valueOf(obj4) : "";
        if (TextUtils.isEmpty(strValueOf) || this.hw.hw(this.hw) == null || !TextUtils.equals(str, strValueOf) || !TextUtils.equals(str2, this.w)) {
            return false;
        }
        if (this.pr != null) {
            this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
        }
        return true;
    }
}

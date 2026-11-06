package com.byazt.cv;

import android.content.Context;
import android.text.TextUtils;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1039, 8})
public class s extends com.byazt.et.qg {
    public boolean cp;

    public s(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001d  */
    /* JADX WARN: Code duplicated, block: B:18:0x002f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0041  */
    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        String str;
        int iIntValue;
        int iIntValue2;
        int iN;
        Object obj;
        int iN2 = 0;
        if (this.l == null || this.l.isEmpty()) {
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
        if (!TextUtils.equals((!this.l.containsKey("id") || (obj = this.l.get("id")) == null) ? "" : String.valueOf(obj), str)) {
            return false;
        }
        if (this.l.containsKey(WebLoginFragment.QUERY_KEY_ID)) {
            Object obj5 = this.l.get(WebLoginFragment.QUERY_KEY_ID);
            iN = com.byazt.hb.s.n(obj5 != null ? String.valueOf(obj5) : "", 0);
        } else {
            iN = 0;
        }
        if (iN != iIntValue) {
            return false;
        }
        if (this.l.containsKey("repeat")) {
            Object obj6 = this.l.get("repeat");
            iN2 = com.byazt.hb.s.n(obj6 != null ? String.valueOf(obj6) : "", 0);
        }
        if (iN != 1) {
            if (iN == 2) {
                float fN = 0.0f;
                if (this.l.containsKey("percent")) {
                    Object obj7 = this.l.get("percent");
                    fN = com.byazt.hb.s.n(obj7 != null ? String.valueOf(obj7) : "", 0.0f);
                }
                if (iIntValue2 >= fN && (iN2 == 1 || !this.cp)) {
                    this.cp = true;
                    if (this.n != null) {
                        this.n.n(this.qg, this.w, this.s.qg(), this.s);
                    }
                }
            }
        } else if (iN2 == 1 || !this.cp) {
            this.cp = true;
            if (this.n != null) {
                this.n.n(this.qg, this.w, this.s.qg(), this.s);
            }
        }
        return true;
    }
}

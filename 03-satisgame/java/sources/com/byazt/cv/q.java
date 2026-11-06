package com.byazt.cv;

import android.content.Context;
import android.text.TextUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1039, 5})
public class q extends com.byazt.et.qg {
    public String cp;

    public q(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001d  */
    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
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
        if (this.l != null && this.l.size() > 0) {
            Object obj3 = this.l.get("id");
            if (obj3 == null) {
                obj3 = this.l.get(TapEventParamConstants.PARAM_NAME);
            }
            String strValueOf = obj3 != null ? String.valueOf(obj3) : "";
            Object obj4 = this.l.get(WebLoginFragment.QUERY_KEY_ID);
            this.cp = obj4 != null ? String.valueOf(obj4) : "";
            if (!TextUtils.isEmpty(strValueOf) && this.qg.qg(this.qg) != null && TextUtils.equals(str, strValueOf) && TextUtils.equals(str2, this.cp)) {
                if (this.n != null) {
                    this.n.n(this.qg, this.w, this.s.qg(), this.s);
                }
                return true;
            }
        }
        return false;
    }
}

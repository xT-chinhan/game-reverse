package com.byazt.bu;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 873, 13})
public abstract class hw {
    public Context hw;
    public x pr;

    public hw(Context context, String str) {
        try {
            this.hw = context == null ? a.getContext() : context.getApplicationContext();
            if (this.pr == null) {
                this.pr = new x(this.hw, str);
            }
        } catch (Throwable th) {
        }
    }

    public x pr() {
        return this.pr;
    }

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        switch (str) {
            case "sdk_launch":
            case "union_meta_cache":
            case "meta_req_record_v1":
            case "dpl_status_record":
            case "union_tmax_record":
                return true;
            default:
                return false;
        }
    }
}

package com.byazt.gha;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 960, 26})
public abstract class qg {
    public q n;
    public Context qg;

    public qg(Context context, String str) {
        try {
            this.qg = context == null ? rv.getContext() : context.getApplicationContext();
            if (this.n == null) {
                this.n = new q(this.qg, str);
            }
        } catch (Throwable unused) {
        }
    }

    public q n() {
        return this.n;
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "dpl_status_record":
            case "tt_feature_bucket":
            case "union_meta_cache":
            case "union_tmax_record":
            case "hty_show":
            case "sdk_launch":
            case "meta_req_record_v1":
                return true;
            default:
                return false;
        }
    }
}

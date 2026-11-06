package com.byazt.xev;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 20})
public abstract class hn<SERVICE> implements yb {
    public hw<Boolean> hw = new hw<Boolean>() { // from class: com.byazt.xev.hn.1
        @Override // com.byazt.xev.hw
        /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
        public Boolean pr(Object... objArr) {
            return Boolean.valueOf(zo.pr((Context) objArr[0], hn.this.pr));
        }
    };
    public final String pr;

    public abstract Intent pr(Context context);

    public abstract z.hw<SERVICE, String> pr();

    public hn(String str) {
        this.pr = str;
    }

    @Override // com.byazt.xev.yb
    public boolean hw(Context context) {
        if (context == null) {
            return false;
        }
        return this.hw.hw(context).booleanValue();
    }

    @Override // com.byazt.xev.yb
    public yb.pr hn(Context context) {
        return pr((String) new z(context, pr(context), pr()).pr());
    }

    private yb.pr pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        yb.pr prVar = new yb.pr();
        prVar.hw = str;
        return prVar;
    }
}

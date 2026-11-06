package com.byazt.okf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.eld.k;
import com.byazt.uk.zo;
import com.byazt.vi.hn;
import com.byazt.vzx.pr;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 1576, 1577})
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void pr() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            hn.pr().pr("handleIntent is null");
            com.byazt.mdu.hn.pr((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra(an.ax);
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            hn.pr().pr("getPackage or id is null");
            com.byazt.mdu.hn.pr((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            zo.pr((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.byazt.mdu.hn.pr((Activity) this);
            return;
        }
        int iOptInt = k.aj().optInt("ab", 0);
        zo.pr(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            com.byazt.mdu.hn.pr((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.byazt.mdu.hn.pr((Activity) this);
    }
}

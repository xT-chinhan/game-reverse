package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.downloadlib.ab.x;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.ka.ah;

/* JADX INFO: loaded from: classes3.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void ms() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            ah.ms().ms("handleIntent is null");
            com.ss.android.socialbase.appdownloader.ah.ms((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            ah.ms().ms("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.ah.ms((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            x.ms((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.ss.android.socialbase.appdownloader.ah.ms((Activity) this);
            return;
        }
        int iOptInt = hi.ny().optInt("ab", 0);
        x.ms(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            com.ss.android.socialbase.appdownloader.ah.ms((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.ah.ms((Activity) this);
    }
}

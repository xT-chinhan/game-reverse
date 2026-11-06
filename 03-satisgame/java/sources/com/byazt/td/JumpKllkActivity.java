package com.byazt.td;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.ch.s;
import com.byazt.cp.n;
import com.byazt.rz.fs;
import com.byazt.ug.d;
import com.ss.android.downloadlib.activity.TTDelegateActivity;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 1715, 1716})
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void n() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            s.n().n("handleIntent is null");
            com.byazt.e.s.n((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra(f.W);
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            s.n().n("getPackage or id is null");
            com.byazt.e.s.n((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            fs.n((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.byazt.e.s.n((Activity) this);
            return;
        }
        int iOptInt = d.rv().optInt("ab", 0);
        fs.n(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            com.byazt.e.s.n((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.byazt.e.s.n((Activity) this);
    }
}

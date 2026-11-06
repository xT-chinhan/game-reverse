package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
public final class g5 extends z2 {
    public g5(int i) {
        super(i);
    }

    @Override // com.mcto.sspsdk.internal.z2
    public final boolean a(g7 g7Var) {
        Context context = this.b;
        String str = g7Var.b;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + g7Var.d));
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
            }
            context.startActivity(intent);
            nj.a();
            return true;
        } catch (Exception e) {
            r9.a("ssp_download", "launcherMarket: ", e);
            return false;
        }
    }

    @Override // com.mcto.sspsdk.internal.z2
    public final g7 b(u0 u0Var) {
        String str;
        g7 g7Var = new g7();
        if (nj.a() == 2) {
            str = "com.bbk.appstore";
        } else if (nj.a() == 3) {
            str = Build.VERSION.SDK_INT >= 29 ? "com.heytap.market" : "com.oppo.market";
        } else if (nj.a() == 1) {
            str = "com.huawei.appmarket";
        } else if (nj.a() == 5) {
            str = "com.hihonor.appmarket";
        } else {
            str = nj.a() == 4 ? "com.xiaomi.market" : null;
        }
        g7Var.b = str;
        String str2 = u0Var.i;
        g7Var.d = str2;
        g7Var.a = !TextUtils.isEmpty(str2);
        return g7Var;
    }
}

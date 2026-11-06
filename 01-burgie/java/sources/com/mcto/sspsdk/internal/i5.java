package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class i5 extends z2 {
    public static final String[] c = {BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO, BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO, BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO};

    public i5(int i) {
        super(i);
    }

    @Override // com.mcto.sspsdk.internal.z2
    public final boolean a(g7 g7Var) {
        Context context = this.b;
        String str = g7Var.c;
        String str2 = g7Var.b;
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                intent.addFlags(134217728);
            }
            if (nj.a() == 2) {
                intent.setClassName(str2, "com.vivo.browser.BrowserActivity");
            } else if (nj.a() == 3) {
                intent.setPackage(str2);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            r9.a("ssp_download", "download by ov browser fail!", e);
            return false;
        }
    }

    @Override // com.mcto.sspsdk.internal.z2
    public final g7 b(u0 u0Var) {
        g7 g7Var = new g7();
        String str = "com.vivo.browser";
        if (nj.a() != 3) {
            if (nj.a() != 2 || !e1.c("com.vivo.browser")) {
                str = null;
                break;
            }
        } else {
            Iterator it = Arrays.asList(c).iterator();
            do {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                str = (String) it.next();
            } while (!e1.c(str));
        }
        g7Var.b = str;
        g7Var.c = u0Var.d;
        g7Var.a = (TextUtils.isEmpty(str) || TextUtils.isEmpty(g7Var.c)) ? false : true;
        return g7Var;
    }
}

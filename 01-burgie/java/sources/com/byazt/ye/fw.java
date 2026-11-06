package com.byazt.ye;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.byazt.af.m;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.hg.of;
import com.byazt.sd.iu;
import com.bykv.vk.component.ttvideo.player.C;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, 62})
public class fw implements com.byazt.ni.pr {
    public Map<String, Object> c;
    public String hn;
    public Context hw;
    public com.byazt.hg.c pr;
    public m x;

    public fw(com.byazt.hg.c cVar, Context context, m mVar, Map<String, Object> map) {
        this.pr = cVar;
        this.hw = context;
        this.x = mVar;
        this.c = map;
    }

    public void pr(String str) {
        this.hn = str;
    }

    @Override // com.byazt.ni.pr
    public boolean pr(Map<String, Object> map) {
        return pr();
    }

    private boolean pr() {
        com.byazt.hg.c cVar = this.pr;
        if (cVar == null) {
            com.byazt.lx.hw.pr(this.c, com.byazt.wb.c.zo);
            return false;
        }
        String strPr = cVar.pr();
        if (this.x.uc() != 3 || TextUtils.isEmpty(strPr)) {
            com.byazt.lx.hw.pr(this.c, com.byazt.wb.c.zo);
            return false;
        }
        boolean zHw = hw(strPr);
        if (zHw) {
            hw();
            com.byazt.lx.hw.pr(this.c, com.byazt.wb.c.hn);
        } else {
            pr(false);
            com.byazt.lx.hw.pr(this.c, com.byazt.wb.c.aj);
        }
        return zHw;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.byazt.ye.fw$1] */
    private void hw() {
        new CountDownTimer(3000L, 3000L) { // from class: com.byazt.ye.fw.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (com.byazt.sd.zo.nt() == null || com.byazt.sd.zo.nt().pr()) {
                    fw.this.pr(true);
                } else {
                    fw.this.pr(false);
                }
            }
        }.start();
    }

    public boolean hw(String str) {
        if (this.hw == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            com.byazt.ca.pr.startActivity(this.hw, intent, TextUtils.equals(iu.zo, UMModuleRegister.INNER));
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (z) {
            com.byazt.pj.pr.hw(hn(), this.hn, "quickapp_success");
        } else {
            com.byazt.pj.pr.hw(hn(), this.hn, "quickapp_fail");
        }
    }

    private of hn() {
        return com.byazt.lx.hw.pr(this.x, this.c);
    }
}

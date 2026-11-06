package com.byazt.nl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.af.w;
import com.byazt.pj.c;
import com.byazt.sd.iu;
import com.byazt.sd.lb;
import com.bykv.vk.component.ttvideo.player.C;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 574, 37})
public class pr {
    public String pr = "";

    public pr pr(String str) {
        this.pr = str;
        return this;
    }

    public void pr(final Context context, final Map<String, Object> map, final w wVar) {
        if (wVar == null || wVar.g() == null) {
            return;
        }
        final String strHw = wVar.g().hw();
        if (TextUtils.isEmpty(strHw)) {
            return;
        }
        lb.uc().postDelayed(new Runnable() { // from class: com.byazt.nl.pr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(strHw));
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    HashMap map2 = new HashMap();
                    map2.put("source", "LiveDoubleOpenProcessor");
                    map2.put("scheme", strHw);
                    com.byazt.pj.pr.pr(com.byazt.lx.hw.pr(wVar, (Map<String, Object>) map), pr.this.pr, (Map<String, Object>) map2, false);
                    com.byazt.ca.pr.pr(context, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.nl.pr.1.1
                        @Override // com.byazt.ca.pr.InterfaceC0030pr
                        public void pr() {
                            com.byazt.pj.pr.pr(com.byazt.lx.hw.pr(wVar, (Map<String, Object>) map), pr.this.pr, (Throwable) null, false, true);
                            c.pr().pr(com.byazt.lx.hw.pr(wVar, (Map<String, Object>) map), pr.this.pr, false, false, null);
                        }

                        @Override // com.byazt.ca.pr.InterfaceC0030pr
                        public void pr(Throwable th) {
                            com.byazt.pj.pr.pr(com.byazt.lx.hw.pr(wVar, (Map<String, Object>) map), pr.this.pr, th, false, false);
                        }
                    }, TextUtils.equals(iu.zo, UMModuleRegister.INNER));
                } catch (Throwable th) {
                }
            }
        }, 50L);
    }
}

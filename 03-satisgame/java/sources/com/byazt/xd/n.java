package com.byazt.xd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.llp.cp;
import com.byazt.nf.tj;
import com.byazt.vyf.l;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1147, 19})
public class n {
    public String n = "";

    public n n(String str) {
        this.n = str;
        return this;
    }

    public void n(final Context context, final Map<String, Object> map, final cp cpVar) {
        if (cpVar == null || cpVar.sz() == null) {
            return;
        }
        final String strQg = cpVar.sz().qg();
        if (TextUtils.isEmpty(strQg)) {
            return;
        }
        l.q().postDelayed(new Runnable() { // from class: com.byazt.xd.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(strQg));
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    HashMap map2 = new HashMap();
                    map2.put("source", "LiveDoubleOpenProcessor");
                    map2.put("scheme", strQg);
                    com.byazt.hm.n.n(com.byazt.ukb.qg.n(cpVar, (Map<String, Object>) map), n.this.n, (Map<String, Object>) map2, false);
                    com.byazt.tk.n.n(context, intent, new com.byazt.tk.n.InterfaceC0352n() { // from class: com.byazt.xd.n.1.1
                        @Override // com.byazt.tk.n.InterfaceC0352n
                        public void n() {
                            com.byazt.hm.n.n(com.byazt.ukb.qg.n(cpVar, (Map<String, Object>) map), n.this.n, (Throwable) null, false, true);
                            com.byazt.hm.l.n().n(com.byazt.ukb.qg.n(cpVar, (Map<String, Object>) map), n.this.n, false, false, null);
                        }

                        @Override // com.byazt.tk.n.InterfaceC0352n
                        public void n(Throwable th) {
                            com.byazt.hm.n.n(com.byazt.ukb.qg.n(cpVar, (Map<String, Object>) map), n.this.n, th, false, false);
                        }
                    }, TextUtils.equals(tj.rv, "internal"));
                } catch (Throwable unused) {
                }
            }
        }, 50L);
    }
}

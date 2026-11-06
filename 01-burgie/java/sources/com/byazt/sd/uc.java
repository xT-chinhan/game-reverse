package com.byazt.sd;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 5})
public class uc {
    public AtomicBoolean hn;
    public String hw;
    public volatile String pr;
    public com.byazt.wt.pr.hw x;

    @com.byazt.vzx.pr(pr = {0, 1, 23, 129})
    private static final class pr {
        public static final uc pr = new uc();
    }

    private uc() {
        this.pr = null;
        this.hw = null;
        this.hn = new AtomicBoolean(false);
        fw();
    }

    private void fw() {
        zo();
        final com.byazt.vkw.hn hnVar = (com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog");
        this.x = new com.byazt.wt.pr.hw() { // from class: com.byazt.sd.uc.1
            @Override // com.byazt.wt.pr.hw
            public void pr() {
                hnVar.hw();
            }

            @Override // com.byazt.wt.pr.hw
            public void hw() {
                hnVar.hn();
            }

            @Override // com.byazt.wt.pr.hw
            public void hn() {
            }

            @Override // com.byazt.wt.pr.hw
            public void x() {
            }
        };
        com.byazt.wt.pr prVarHn = zo.nt().hn();
        if (prVarHn != null) {
            prVarHn.pr(this.x);
        }
    }

    private void zo() {
        final boolean zFw = zo.nt().fw();
        boolean zZo = zo.nt().zo();
        final boolean zVk = zo.nt().vk();
        ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).pr(new com.byazt.lq.hn() { // from class: com.byazt.sd.uc.2
            @Override // com.byazt.lq.hn
            public void pr(com.byazt.lq.hw hwVar) {
                if (hwVar != null) {
                    com.byazt.wt.fo.pr(hwVar.pr());
                }
                if (!zVk && zFw && !uc.this.hn.get()) {
                    uc.this.pr(new com.byazt.igw.x(hwVar));
                }
            }
        });
        if (zZo) {
            com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.sd.uc.3
                @Override // java.lang.Runnable
                public void run() {
                    uc.this.pr(new com.byazt.igw.x(com.byazt.wt.fo.hn(((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).pr(false))));
                }
            });
        } else if (!zVk && zFw) {
            com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.sd.uc.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!uc.this.hn.get()) {
                        uc.this.pr(new com.byazt.igw.x("timeout"));
                    }
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.igw.x xVar) {
        this.hn.set(true);
        com.byazt.wt.fo.pr(xVar);
    }

    public static uc pr() {
        return pr.pr;
    }

    public String hw() {
        if (TextUtils.isEmpty(this.pr)) {
            this.pr = ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).pr();
            com.byazt.hs.hn.hn(16, this.pr);
            com.byazt.mp.x.pr().vk(this.pr == null ? "" : this.pr);
        }
        return this.pr;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String hn() {
        if (TextUtils.isEmpty(this.hw)) {
            this.hw = ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).x();
        }
        return this.hw;
    }

    public String x() {
        return ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).pr("sdk_version_name", "");
    }

    public static String c() {
        return "164362";
    }

    public static String uc() {
        return "unionser_slardar_applog";
    }

    public static void pr(String str, JSONObject jSONObject) {
        ((com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog")).hw(str, jSONObject);
    }
}

package com.byazt.ic;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.byazt.cr.c;
import com.byazt.hcx.fw;
import com.byazt.hcx.m;
import com.byazt.ld.nt;
import com.byazt.ld.ny;
import com.byazt.ld.rc;
import com.byazt.tf.hn;
import com.byazt.to.x;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.umeng.analytics.pro.an;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1038, 13})
public class hw {
    public static volatile hw x;
    public final c hn = new x.pr().pr("lottie_tpl_info").pr(com.byazt.bg.pr.pr().hn().getContext()).pr(1).pr(com.byazt.bg.pr.pr().hn().vk()).pr();
    public static final String pr = "tt_derive" + File.separator + "lottie" + File.separator + MediaFormat.KEY_AUDIO;
    public static final String hw = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";

    public interface pr<T> {
        void pr(int i, String str);

        void pr(T t);
    }

    private hw() {
    }

    public static hw pr() {
        if (x == null) {
            synchronized (hw.class) {
                if (x == null) {
                    x = new hw();
                }
            }
        }
        return x;
    }

    public void pr(Context context, com.byazt.ic.pr prVar) {
        if (prVar != null) {
            String strHn = prVar.hn();
            if (!TextUtils.isEmpty(strHn)) {
                hw(strHn, null);
            }
            String strPr = prVar.pr();
            if (!TextUtils.isEmpty(strPr) && TextUtils.isEmpty(pr(strPr))) {
                pr(strPr, (pr<String>) null);
            }
        }
    }

    public void pr(final String str, final pr<String> prVar) {
        hn.hw(str).pr(new fw() { // from class: com.byazt.ic.hw.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar != null) {
                    try {
                        if (mVar.fw()) {
                            String strZo = mVar.zo();
                            JSONObject jSONObjectC = mVar.c();
                            if (jSONObjectC != null) {
                                jSONObjectC.optString(an.aE);
                                hw.this.pr(str, strZo);
                                pr prVar2 = prVar;
                                if (prVar2 != null) {
                                    prVar2.pr(strZo);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        pr prVar3 = prVar;
                        if (prVar3 != null) {
                            prVar3.pr(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                pr prVar4 = prVar;
                if (prVar4 != null) {
                    boolean z = true;
                    StringBuilder sbAppend = new StringBuilder("lottieJsonUrl加载失败1, response is not null:").append(mVar != null).append(", isSuccess:");
                    if (mVar == null || !mVar.fw()) {
                        z = false;
                    }
                    prVar4.pr(10001, sbAppend.append(z).toString());
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str2, Throwable th) {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(10001, "lottieJsonUrl加载失败3, " + th.getMessage());
                }
            }
        });
    }

    public void pr(Context context, String str, final pr<Bitmap> prVar) {
        ny nyVarC = com.byazt.bg.pr.pr().c();
        if (nyVarC == null) {
            if (prVar != null) {
                prVar.pr(-1, "imageCenter is null");
                return;
            }
            return;
        }
        nyVarC.pr(str).hn(pr(context)).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.ic.hw.2
            @Override // com.byazt.ld.rc
            public void pr(nt<Bitmap> ntVar) {
                pr prVar2;
                try {
                    Bitmap bitmapHn = ntVar.hn();
                    if (bitmapHn != null && (prVar2 = prVar) != null) {
                        prVar2.pr(bitmapHn);
                    }
                } catch (Throwable th) {
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str2, Throwable th) {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(i, "load lottie pic fail: ".concat(String.valueOf(str2)));
                }
            }
        }, 4);
    }

    public void hw(String str, final pr<Bitmap> prVar) {
        ny nyVarC = com.byazt.bg.pr.pr().c();
        if (nyVarC == null) {
            if (prVar != null) {
                prVar.pr(-1, "imageCenter is null");
                return;
            }
            return;
        }
        nyVarC.pr(str).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.ic.hw.3
            @Override // com.byazt.ld.rc
            public void pr(nt<Bitmap> ntVar) {
                pr prVar2;
                try {
                    Bitmap bitmapHn = ntVar.hn();
                    if (bitmapHn != null && (prVar2 = prVar) != null) {
                        prVar2.pr(bitmapHn);
                    }
                } catch (Throwable th) {
                }
            }

            @Override // com.byazt.ld.rc
            public void pr(int i, String str2, Throwable th) {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(i, "load ad pic fail: ".concat(String.valueOf(str2)));
                }
            }
        }, 4);
    }

    public String pr(String str) {
        String strHw = com.byazt.ca.c.hw(str);
        if (TextUtils.isEmpty(strHw)) {
            return null;
        }
        return this.hn.hw(strHw, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, String str2) {
        String strHw = com.byazt.ca.c.hw(str);
        if (!TextUtils.isEmpty(strHw)) {
            this.hn.pr(strHw, str2);
        }
    }

    public String pr(Context context) {
        return com.byazt.ca.fw.pr(context, com.byazt.bg.pr.pr().hn().vk(), hw).getAbsolutePath();
    }
}

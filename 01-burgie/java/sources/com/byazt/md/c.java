package com.byazt.md;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.af.k;
import com.byazt.ca.b;
import com.byazt.ca.ho;
import com.byazt.hg.of;
import com.byazt.hg.u;
import com.byazt.pj.fw;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.sd.iu;
import com.byazt.wb.uc;
import com.byazt.wt.ls;
import com.byazt.wt.ny;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static volatile boolean fw = false;
    public final boolean aj;
    public boolean c;
    public int hn;
    public final Context hw;
    public Toast pr;
    public u uc;
    public Map<String, Object> vk;
    public String x;
    public final k zo;

    public interface pr {
        void pr(com.byazt.wb.pr prVar);
    }

    public static boolean pr() {
        return fw;
    }

    public static void pr(boolean z) {
        fw = z;
    }

    public c(k kVar, Context context, boolean z) {
        this.zo = kVar;
        this.hw = context;
        this.aj = z;
    }

    public c pr(String str) {
        this.x = str;
        return this;
    }

    public c pr(int i) {
        this.hn = i;
        return this;
    }

    public c hw(boolean z) {
        this.c = z;
        return this;
    }

    public c pr(Map<String, Object> map) {
        this.vk = map;
        return this;
    }

    public boolean pr(pr prVar) {
        if (this.uc == null) {
            k kVar = this.zo;
            this.uc = kVar != null ? kVar.F_() : null;
        }
        if (this.uc == null) {
            return false;
        }
        if (this.aj) {
            k kVar2 = this.zo;
            if (kVar2 instanceof com.byazt.af.x) {
                return pr(((com.byazt.af.x) kVar2).vk(), prVar);
            }
        }
        return hw(prVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean hw(pr prVar) {
        switch (this.uc.hw()) {
            case 1:
                if (this.c) {
                    if (TextUtils.isEmpty(this.uc.zo())) {
                        return true;
                    }
                    if (hn() == 1) {
                        pr(prVar, this.uc);
                        return true;
                    }
                }
                return false;
            case 2:
                int iHn = hn();
                if (iHn == 0) {
                    return false;
                }
                if (iHn == 1) {
                    pr(prVar, this.uc);
                    return true;
                }
                if (TextUtils.isEmpty(this.uc.pr())) {
                    return false;
                }
                pr(prVar, this.uc, 2000L);
                return true;
            default:
                return false;
        }
    }

    private boolean pr(int i, pr prVar) {
        switch (i) {
            case 1:
                pr(prVar, this.uc);
                return true;
            case 2:
                if (TextUtils.isEmpty(this.uc.pr())) {
                    return false;
                }
                pr(prVar, this.uc, 2000L);
                return true;
            case 3:
                if (!this.c) {
                    return false;
                }
                pr(prVar, this.uc);
                return true;
            default:
                return false;
        }
    }

    private int hn() {
        u uVar = this.uc;
        if (uVar == null) {
            return 0;
        }
        if (uVar.uc() == 1 && x.hn().pr()) {
            return TextUtils.isEmpty(this.uc.fw()) ? 0 : 1;
        }
        return 2;
    }

    private void pr(final pr prVar, u uVar) {
        x();
        k kVar = this.zo;
        if ((kVar instanceof com.byazt.af.x) && !TextUtils.isEmpty(((com.byazt.af.x) kVar).fw()) && !TextUtils.isEmpty(((com.byazt.af.x) this.zo).aj())) {
            x xVarHn = x.hn();
            k kVar2 = this.zo;
            xVarHn.pr(kVar2, ((com.byazt.af.x) kVar2).aj(), ((com.byazt.af.x) this.zo).fw(), prVar, this.x, this.c, this.vk);
        } else {
            a.pr().pr(uVar, this.zo.zo(), this.zo.B_(), new hw(prVar, uVar, this.pr) { // from class: com.byazt.md.c.1
                @Override // com.byazt.md.c.hw, com.byazt.sd.fo.hn
                public void pr(JSONObject jSONObject) {
                    String strOptString = jSONObject.optString("userName");
                    String strOptString2 = jSONObject.optString("path");
                    if (!TextUtils.isEmpty(strOptString)) {
                        if (c.this.pr != null) {
                            c.this.pr.cancel();
                        }
                        x.hn().pr(c.this.zo, strOptString, strOptString2, prVar, c.this.x, c.this.c, c.this.vk);
                        return;
                    }
                    pr(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, " userName or path is null!");
                }

                @Override // com.byazt.md.c.hw, com.byazt.sd.fo.hn
                public void pr(int i, String str) {
                    uc ucVar;
                    c.this.uc.hw(0);
                    if (c.this.pr != null) {
                        c.this.pr.cancel();
                    }
                    if (i == 606) {
                        ucVar = uc.vk;
                    } else {
                        ucVar = uc.aj;
                    }
                    pr prVar2 = prVar;
                    if (prVar2 != null) {
                        prVar2.pr(ucVar);
                    }
                }
            }, 1, 2000L);
        }
    }

    private void pr(pr prVar, u uVar, long j) {
        x();
        a.pr().pr(uVar, this.zo.zo(), this.zo.B_(), new hw(prVar, uVar, this.pr), 2, j);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 238, 401})
    class hw implements fo.hn<JSONObject> {
        public final u hw;
        public final pr pr;
        public final Toast x;

        public hw(pr prVar, u uVar, Toast toast) {
            this.pr = prVar;
            this.hw = uVar;
            this.x = toast;
        }

        @Override // com.byazt.sd.fo.hn
        public void pr(int i, String str) {
            uc ucVar;
            this.hw.hw(0);
            Toast toast = this.x;
            if (toast != null) {
                toast.cancel();
            }
            if (i == 606) {
                ucVar = uc.uc;
            } else {
                ucVar = uc.c;
            }
            pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(ucVar);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.byazt.sd.fo.hn
        public void pr(JSONObject jSONObject) {
            String strOptString = jSONObject.optString("scheme");
            if (!TextUtils.isEmpty(strOptString)) {
                c.this.pr(strOptString, this.hw, this.pr);
            } else {
                pr(MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, " scheme is null!");
            }
        }
    }

    private void x() {
        zo.pr(new Runnable() { // from class: com.byazt.md.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (c.this.pr != null) {
                        c.this.pr.cancel();
                    }
                    c cVar = c.this;
                    cVar.pr = b.pr(cVar.hw, "即将跳转微信...", 1, 17, 0, 0);
                    c.this.pr.show();
                } catch (Throwable th) {
                    ho.pr("toast error:" + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, final u uVar, final pr prVar) {
        Toast toast = this.pr;
        if (toast != null) {
            toast.cancel();
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        final String strPr = ny.hw(hw()) ? this.x : ls.pr(this.hn);
        HashMap map = new HashMap();
        map.put("source", "WechatClickProcesser");
        map.put("scheme", ls.pr(str));
        com.byazt.pj.pr.pr(hw(), strPr, (Map<String, Object>) map, false);
        com.byazt.ca.pr.pr(this.hw, intent, new com.byazt.ca.pr.InterfaceC0030pr() { // from class: com.byazt.md.c.3
            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr() {
                uVar.hw(1);
                com.byazt.pj.pr.pr(c.this.hw(), strPr, (Throwable) null, false, true);
                com.byazt.pj.c.pr().pr(c.this.hw(), strPr, false, false, new fw.pr() { // from class: com.byazt.md.c.3.1
                    @Override // com.byazt.pj.fw.pr
                    public void pr(long j) {
                        if (prVar != null) {
                            prVar.pr(uc.zo);
                        }
                    }

                    @Override // com.byazt.pj.fw.pr
                    public void pr(String str2) {
                    }

                    @Override // com.byazt.pj.fw.pr
                    public void pr(boolean z) {
                    }
                });
            }

            @Override // com.byazt.ca.pr.InterfaceC0030pr
            public void pr(Throwable th) {
                com.byazt.pj.pr.pr(c.this.hw(), strPr, th, false, false);
                uVar.hw(0);
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(uc.fw);
                }
            }
        }, TextUtils.equals(iu.zo, UMModuleRegister.INNER));
    }

    public of hw() {
        return com.byazt.lx.hw.pr(this.zo, this.vk);
    }
}

package com.byazt.ye;

import android.content.Context;
import com.byazt.af.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements com.byazt.ni.pr {
    public final boolean aj;
    public Map<String, Object> c;
    public int fw;
    public boolean hn;
    public Context hw;
    public com.byazt.ni.pr pr;
    public com.byazt.hws.pr uc;
    public String x;
    public final k zo;

    public zo(k kVar, Context context, boolean z, String str, Map<String, Object> map, com.byazt.hws.pr prVar, int i, boolean z2) {
        this.zo = kVar;
        this.hw = context;
        this.hn = z;
        this.x = str;
        this.c = map;
        this.uc = prVar;
        this.fw = i;
        this.aj = z2;
    }

    @Override // com.byazt.ni.pr
    public boolean pr(final Map<String, Object> map) {
        boolean zPr;
        if (com.byazt.md.c.pr()) {
            zPr = false;
        } else {
            zPr = new com.byazt.md.c(this.zo, this.hw, this.aj).pr(this.x).pr(this.fw).hw(this.hn).pr(this.c).pr(new com.byazt.md.c.pr() { // from class: com.byazt.ye.zo.1
                @Override // com.byazt.md.c.pr
                public void pr(com.byazt.wb.pr prVar) {
                    boolean zPr2;
                    if (zo.this.pr != null) {
                        zPr2 = zo.this.pr.pr(map);
                    } else {
                        zPr2 = false;
                    }
                    if (!zPr2) {
                        com.byazt.lx.hw.pr((Map<String, Object>) zo.this.c, prVar);
                        if (zo.this.aj) {
                            zo.this.uc.hw(zo.this.c, null);
                        } else {
                            zo.this.uc.pr(zo.this.c, (com.byazt.rs.pr) null);
                        }
                    }
                }
            });
        }
        com.byazt.md.c.pr(false);
        if (zPr) {
            return true;
        }
        com.byazt.ni.pr prVar = this.pr;
        return prVar != null && prVar.pr(map);
    }
}

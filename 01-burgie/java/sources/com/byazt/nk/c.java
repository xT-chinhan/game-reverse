package com.byazt.nk;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import com.byazt.ch.cz;
import com.byazt.ch.g;
import com.byazt.ch.ny;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.xv.hw implements ny {
    public com.byazt.ca.ny w;

    public c(Context context) {
        super(context);
        this.w = new com.byazt.ca.ny(context, 1, zo.nt().x());
    }

    private int k() {
        JSONObject jSONObjectPr;
        if (this.hw == null) {
            return 0;
        }
        JSONObject jSONObjectVk = this.hw.vk();
        if (jSONObjectVk != null) {
            return jSONObjectVk.optInt("meta_hashcode", 0);
        }
        g gVarLs = this.hw.ls();
        if (gVarLs == null || (jSONObjectPr = gVarLs.pr()) == null) {
            return 0;
        }
        return jSONObjectPr.optInt("meta_hashcode", 0);
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        Map<String, Object> mapHw;
        this.hw.pr(this);
        if (this.w == null) {
            this.w = new com.byazt.ca.ny(this.vk, 1, zo.nt().x());
        }
        g gVarLs = this.hw.ls();
        if (gVarLs != null && (mapHw = gVarLs.hw()) != null) {
            Object obj = mapHw.get("shake_value");
            if (obj instanceof Integer) {
                this.w.pr(((Integer) obj).floatValue());
            }
            Object obj2 = mapHw.get("calculation_method");
            if (obj2 instanceof Integer) {
                this.w.c(((Integer) obj2).intValue());
            }
            Object obj3 = mapHw.get("shake_interact_conf");
            if (obj3 instanceof JSONObject) {
                this.w.hn((JSONObject) obj3);
            }
            Object obj4 = mapHw.get("rotation_angle");
            if (obj4 instanceof Integer) {
                this.w.hw(((Integer) obj4).floatValue());
            }
            Object obj5 = mapHw.get("twist_config");
            if (obj5 instanceof JSONObject) {
                this.w.pr((JSONObject) obj5);
            }
            Object obj6 = mapHw.get("twist_interact_conf");
            if (obj6 instanceof JSONObject) {
                this.w.hw((JSONObject) obj6);
            }
            Object obj7 = mapHw.get("calculation_method_twist");
            if (obj7 instanceof Integer) {
                this.w.uc(((Integer) obj7).intValue());
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.byazt.ch.ny
    public void pr() {
    }

    @Override // com.byazt.ch.ny
    public void hw() {
    }

    @Override // com.byazt.ch.ny
    public void hn() {
    }

    @Override // com.byazt.ch.ny
    public void pr(cz czVar) {
    }

    @Override // com.byazt.ch.ny
    public void pr(JSONObject jSONObject) {
    }

    @Override // com.byazt.ch.ny
    public void x() {
        if (this.w != null && this.hw.aj().isShown()) {
            this.w.pr(new com.byazt.ca.ny.pr() { // from class: com.byazt.nk.c.1
                @Override // com.byazt.ca.ny.pr
                public void pr(int i) {
                    if (c.this.pr != null && i == 1) {
                        c.this.pr.pr(c.this.hw, c.this.uc, c.this.hn.hw(), c.this.hn);
                    }
                }
            });
            this.w.pr(k());
        }
    }

    @Override // com.byazt.ch.ny
    public void c() {
        com.byazt.ca.ny nyVar = this.w;
        if (nyVar != null) {
            nyVar.hw(k());
        }
    }

    @Override // com.byazt.ch.ny
    public void pr(boolean z) {
        com.byazt.ca.ny nyVar = this.w;
        if (nyVar != null) {
            if (z) {
                nyVar.pr(k());
            } else {
                nyVar.hw(k());
            }
        }
    }
}

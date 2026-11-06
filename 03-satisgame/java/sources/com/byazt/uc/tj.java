package com.byazt.uc;

import com.byazt.uj.hu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements com.byazt.uk.n {
    public com.byazt.uk.n[] n;
    public boolean q;
    public String qg;
    public com.byazt.qy.n s;

    public tj(String str) {
        this.qg = str;
    }

    public void n(com.byazt.uk.n[] nVarArr) {
        this.n = nVarArr;
    }

    public void n(boolean z) {
        this.q = z;
    }

    public boolean s() {
        return this.q;
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        com.byazt.qy.n nVar = new com.byazt.qy.n();
        this.s = nVar;
        nVar.n(this.qg);
        Object[] objArr = new Object[this.n.length];
        int i = 0;
        while (true) {
            com.byazt.uk.n[] nVarArr = this.n;
            if (i < nVarArr.length) {
                com.byazt.uk.n nVar2 = nVarArr[i];
                if (nVar2 != null) {
                    objArr[i] = nVar2.n(map);
                }
                i++;
            } else {
                this.s.n(objArr);
                return hu.n(this.qg).n(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return com.byazt.mn.qg.METHOD;
    }

    @Override // com.byazt.uk.n
    public String qg() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qg).append("(");
        com.byazt.uk.n[] nVarArr = this.n;
        if (nVarArr != null && nVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.byazt.uk.n[] nVarArr2 = this.n;
                if (i >= nVarArr2.length) {
                    break;
                }
                sb.append(nVarArr2[i].qg()).append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }
}

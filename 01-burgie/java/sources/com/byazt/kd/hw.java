package com.byazt.kd;

import android.os.Message;
import com.byazt.ca.aj;
import com.byazt.ca.iu;
import com.byazt.ca.ny;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.vkw.qi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1299, 13})
public class hw extends pr implements qi.pr {
    public ny hw;
    public final iu pr = new iu(aj.pr().getLooper(), this);

    public void pr(JSONObject jSONObject, int i) {
        int iPr = pr(i);
        if (hw(i)) {
            pr(jSONObject, com.byazt.na.pr.pr().hw(), iPr);
        } else if (hn(i)) {
            pr(jSONObject, com.byazt.na.pr.pr().hn(), iPr);
        }
    }

    private void pr(JSONObject jSONObject, long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            this.hw = pr();
            this.pr.removeCallbacksAndMessages(null);
            this.pr.sendEmptyMessage(1);
        }
    }

    private ny pr() {
        ny nyVar = new ny(a.getContext(), 1, zo.nt().x());
        if (!nyVar.pr(0)) {
            pr(0, System.currentTimeMillis(), 0L);
            nyVar.hw(0);
            return null;
        }
        return nyVar;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1:
                ny nyVar = this.hw;
                if (nyVar != null) {
                    nyVar.pr(new ny.hn() { // from class: com.byazt.kd.hw.1
                        @Override // com.byazt.ca.ny.hn
                        public void pr() {
                            hw.this.pr(1, System.currentTimeMillis(), 0L);
                            if (hw.this.pr != null) {
                                hw.this.pr.removeCallbacksAndMessages(null);
                            }
                            if (hw.this.hw != null) {
                                hw.this.hw.hw(0);
                            }
                        }
                    });
                    this.pr.sendEmptyMessageDelayed(2, pr(a.hw().xg()));
                    break;
                }
                break;
            case 2:
                ny nyVar2 = this.hw;
                if (nyVar2 != null) {
                    nyVar2.hw(0);
                }
                pr(3, 0L, System.currentTimeMillis());
                break;
        }
    }
}

package com.byazt.izk;

import com.byazt.ee.yb;
import com.byazt.sd.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN, 13})
public final class hw extends com.byazt.ee.x<JSONObject, JSONObject> {
    public static WeakReference<pr> pr;
    public WeakReference<nl> hw;

    public interface pr {
        void pr();

        void pr(int i);
    }

    private hw(nl nlVar) {
        this.hw = new WeakReference<>(nlVar);
    }

    public static void pr(yb ybVar, final nl nlVar) {
        ybVar.pr("onClickBrowseCloseCallback", new com.byazt.ee.x.hw() { // from class: com.byazt.izk.hw.1
            @Override // com.byazt.ee.x.hw
            public com.byazt.ee.x pr() {
                return new hw(nlVar);
            }
        });
    }

    @Override // com.byazt.ee.x
    public void pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        pr prVar;
        WeakReference<pr> weakReference = pr;
        if (weakReference == null) {
            prVar = null;
        } else {
            prVar = weakReference.get();
        }
        if (this.hw == null || jSONObject == null) {
            if (prVar != null) {
                prVar.pr();
                return;
            }
            return;
        }
        int iOptInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (iOptInt == Integer.MIN_VALUE) {
            if (prVar != null) {
                prVar.pr();
            }
        } else if (prVar != null) {
            prVar.pr(iOptInt);
        }
    }

    public static void pr(pr prVar) {
        pr = new WeakReference<>(prVar);
    }

    @Override // com.byazt.ee.x
    public void x() {
    }
}

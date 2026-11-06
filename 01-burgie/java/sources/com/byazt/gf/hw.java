package com.byazt.gf;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.jy.uc;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 13})
public class hw {
    public static hw pr;
    public Handler hn;
    public Map<String, com.byazt.jy.x> hw = new ConcurrentHashMap();

    private hw() {
        if (com.byazt.uw.hn.pr() != null) {
            this.hn = new Handler(com.byazt.uw.hn.pr().getLooper()) { // from class: com.byazt.gf.hw.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 1 && (message.obj instanceof String)) {
                        String str = (String) message.obj;
                        pr.pr().pr(str);
                        com.byazt.jy.x xVarPr = hw.this.pr(str);
                        if (xVarPr != null) {
                            hw.this.pr(xVarPr);
                        }
                    }
                }
            };
        }
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    private void pr(List<com.byazt.jy.x> list) {
        hn();
        if (list != null) {
            for (com.byazt.jy.x xVar : list) {
                if (xVar != null && !TextUtils.isEmpty(xVar.pr())) {
                    this.hw.put(xVar.pr(), xVar);
                    pr(xVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.jy.x xVar) {
        uc ucVarX;
        if (xVar == null || this.hn == null || zo.nt().y() || (ucVarX = xVar.x()) == null || !ucVarX.hn() || ucVarX.hw() <= 0) {
            return;
        }
        String strPr = xVar.pr();
        this.hn.removeMessages(1, strPr);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = strPr;
        this.hn.sendMessageDelayed(messageObtain, ucVarX.hw() * 1000);
    }

    private void hn() {
        this.hn.removeMessages(1);
    }

    public void pr(JSONArray jSONArray) {
        pr(com.byazt.uw.hw.pr(jSONArray));
    }

    public List<com.byazt.jy.x> hw() {
        return new ArrayList(this.hw.values());
    }

    public com.byazt.jy.x pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hw.get(str);
    }
}

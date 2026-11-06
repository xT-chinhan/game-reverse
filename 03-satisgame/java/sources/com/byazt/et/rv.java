package com.byazt.et;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends qg implements fs {
    public String cp;
    public String d;

    public rv(Context context) {
        super(context);
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        if (this.l != null && !this.l.isEmpty()) {
            Object obj = this.l.get(TapEventParamConstants.PARAM_NAME);
            if (obj != null) {
                this.cp = String.valueOf(obj);
            }
            Object obj2 = this.l.get(WebLoginFragment.QUERY_KEY_ID);
            if (obj2 != null) {
                this.d = String.valueOf(obj2);
            }
        }
        com.byazt.ih.s sVarQg = this.qg.qg(this.qg);
        if (sVarQg == null) {
            return false;
        }
        qg(sVarQg);
        return false;
    }

    private void qg(com.byazt.ih.s sVar) {
        List<com.byazt.ih.s<View>> listX;
        List<qg> listL;
        if (sVar == null) {
            return;
        }
        com.byazt.xz.tj tjVarYw = sVar.yw();
        if (tjVarYw != null && (listL = tjVarYw.l("timer")) != null && !listL.isEmpty()) {
            for (qg qgVar : listL) {
                if (qgVar instanceof x) {
                    x xVar = (x) qgVar;
                    if (TextUtils.isEmpty(this.cp) || TextUtils.equals(this.cp, xVar.l())) {
                        xVar.n(this);
                    }
                }
            }
        }
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            qg(it.next());
        }
    }

    @Override // com.byazt.et.fs
    public void n(String str) {
        if (TextUtils.equals(this.d, "start") || TextUtils.isEmpty(this.d)) {
            if ((TextUtils.isEmpty(this.cp) || TextUtils.equals(this.cp, str)) && this.n != null) {
                this.n.n(this.qg, this.w, this.s.qg(), this.s);
            }
        }
    }

    @Override // com.byazt.et.fs
    public void qg(String str) {
        if (TextUtils.equals(this.d, "complete") || TextUtils.isEmpty(this.d)) {
            if ((TextUtils.isEmpty(this.cp) || TextUtils.equals(this.cp, str)) && this.n != null) {
                this.n.n(this.qg, this.w, this.s.qg(), this.s);
            }
        }
    }

    @Override // com.byazt.et.fs
    public void s(String str) {
        if (TextUtils.equals(this.d, "pause") || TextUtils.isEmpty(this.d)) {
            if ((TextUtils.isEmpty(this.cp) || TextUtils.equals(this.cp, str)) && this.n != null) {
                this.n.n(this.qg, this.w, this.s.qg(), this.s);
            }
        }
    }

    @Override // com.byazt.et.fs
    public void q(String str) {
        if (TextUtils.equals(this.d, "resume") || TextUtils.isEmpty(this.d)) {
            if ((TextUtils.isEmpty(this.cp) || TextUtils.equals(this.cp, str)) && this.n != null) {
                this.n.n(this.qg, this.w, this.s.qg(), this.s);
            }
        }
    }
}

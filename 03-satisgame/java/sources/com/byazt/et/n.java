package com.byazt.et;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.xz.cy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 19})
public class n extends qg implements com.byazt.kg.qg {
    public String cp;

    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        Object obj;
        com.byazt.ih.s sVarW;
        com.byazt.kg.n nVarTj;
        if (this.l == null || this.l.size() <= 0 || (obj = this.l.get(TapEventParamConstants.PARAM_NAME)) == null) {
            return false;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return false;
        }
        Object obj2 = this.l.get(WebLoginFragment.QUERY_KEY_ID);
        if (obj2 != null) {
            this.cp = String.valueOf(obj2);
        }
        com.byazt.ih.s sVarQg = this.qg.qg(this.qg);
        if (sVarQg != null && (sVarW = sVarQg.w(strValueOf)) != null && (nVarTj = sVarW.tj(strValueOf)) != null) {
            nVarTj.n(this);
        }
        return false;
    }

    @Override // com.byazt.kg.qg
    public void n() {
        if (s()) {
            return;
        }
        if ((TextUtils.equals(this.cp, "start") || TextUtils.isEmpty(this.cp)) && this.n != null) {
            this.n.n(this.qg, this.w, this.s.qg(), this.s);
        }
    }

    @Override // com.byazt.kg.qg
    public void qg() {
        if (s()) {
            return;
        }
        if ((TextUtils.equals(this.cp, "complete") || TextUtils.isEmpty(this.cp)) && this.n != null) {
            this.n.n(this.qg, this.w, this.s.qg(), this.s);
        }
    }

    private boolean s() {
        cy cyVarS;
        return (this.qg == null || this.qg.f() == null || (cyVarS = this.qg.f().s()) == null || !cyVarS.n("animateState", "")) ? false : true;
    }
}

package com.mcto.sspsdk.internal;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview2.QYImageView2;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zh implements Runnable {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ di b;

    public zh(di diVar, ArrayList arrayList) {
        this.b = diVar;
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Integer num;
        di diVar = this.b;
        p pVar = (p) this.a.get(0);
        pi piVar = new pi(diVar.c, diVar.b);
        piVar.l = new ai(diVar);
        if (lj.b(pVar.G)) {
            r9.a("ssp_splash", "creative url is empty.", null);
            piVar.m.a(0);
            return;
        }
        piVar.e = pVar;
        piVar.g = pVar.h;
        piVar.h = pVar.L0.b;
        pVar.d0 = piVar.f.isAutoDownloadInLandingPage();
        piVar.j = new fj(piVar.a);
        boolean zOptBoolean = pVar.i().optBoolean("isSkippable", true);
        piVar.i = zOptBoolean;
        fj fjVar = piVar.j;
        QyAdSlot qyAdSlot = piVar.f;
        fjVar.getClass();
        fjVar.c = zOptBoolean;
        JSONObject jSONObjectI = pVar.i();
        fjVar.d = jSONObjectI;
        e eVar = pVar.L0;
        fjVar.g = eVar;
        fjVar.f = pVar;
        fjVar.i = pVar.h;
        fjVar.k = eVar.t;
        fjVar.p = eVar.d;
        int iOptInt = jSONObjectI.optInt("timerStyle", -1);
        fjVar.e = iOptInt;
        if (iOptInt == -1) {
            fjVar.e = qyAdSlot.d();
        }
        fjVar.h = qyAdSlot.getSplashLogo();
        HashMap map = fjVar.g.L;
        int iIntValue = (map == null || map.isEmpty() || (num = (Integer) fjVar.g.L.get(0)) == null) ? 0 : num.intValue();
        if (iIntValue == 0 && ((i = fjVar.g.q) == 1 || i == 2 || i == 3)) {
            fjVar.j = 0;
        } else if (iIntValue != 4) {
            fjVar.j = 1;
        } else {
            fjVar.j = 2;
        }
        p pVar2 = fjVar.f;
        String str = pVar2.G;
        String str2 = pVar2.I;
        if ("video".equals(str2)) {
            a0 a0Var = new a0(fjVar.getContext());
            fjVar.m = a0Var;
            String strA = n4.a().a(str, str2);
            if (strA != null && new File(strA).exists()) {
                a0Var.a(strA);
            } else {
                a0Var.a(str);
            }
            MediaPlayer mediaPlayer = a0Var.b.g;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
            cj cjVar = new cj(fjVar);
            x xVar = a0Var.b;
            xVar.h = cjVar;
            xVar.i = new dj(fjVar, str, str2);
        } else if (ImageViewManager.NAME.equals(str2)) {
            String strA2 = n4.a().a(str, str2);
            QYImageView2 qYImageView2 = new QYImageView2(fjVar.getContext());
            fjVar.m = qYImageView2;
            qYImageView2.a(new ej(fjVar));
            if (TextUtils.isEmpty(strA2) || !new File(strA2).exists()) {
                qYImageView2.b(str);
            } else {
                qYImageView2.a(strA2);
            }
            qYImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if ("html".equals(str2)) {
            Log.e("ssp_splash", "interactiveStyle_1: error type");
            fjVar.o.a(0);
        }
        View view = fjVar.m;
        if (view != null) {
            view.setId(R.id.qy_splash_main_creative);
        }
        piVar.j.o = piVar.m;
    }
}

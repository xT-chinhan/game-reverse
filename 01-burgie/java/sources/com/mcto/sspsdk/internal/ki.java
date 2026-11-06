package com.mcto.sspsdk.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class ki extends e3 {
    public final Handler e;
    public final AtomicBoolean f;
    public final ii g;

    public ki(Context context, QyAdSlot qyAdSlot, IQYNative.QYNativeAdListener qYNativeAdListener) {
        super(context, qyAdSlot, qYNativeAdListener);
        this.e = new Handler(Looper.getMainLooper());
        this.f = new AtomicBoolean(false);
        this.g = new ii(this);
    }

    @Override // com.mcto.sspsdk.internal.e3, com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar, int i, String str) {
        if (this.f.compareAndSet(false, true)) {
            super.a(vhVar, i, str);
            if (i == 11 || !this.a.isSupportPreRequest()) {
                return;
            }
            fi.a(this.a, 100);
        }
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        ImageView imageView;
        ImageView imageView2;
        ArrayList arrayList = vhVar.b;
        if (arrayList == null) {
            return;
        }
        ti tiVar = new ti(this.b, this.a, (p) arrayList.get(0));
        ji jiVar = new ji(this, tiVar, vhVar);
        p pVar = tiVar.d;
        String str = pVar.I;
        String str2 = pVar.G;
        if ("video".equals(str)) {
            tiVar.x = new a0(tiVar.a);
            String strA = n4.a().a(str2, str);
            if (strA != null && new File(strA).exists()) {
                tiVar.x.a(strA);
            } else {
                tiVar.x.a(str2);
            }
            MediaPlayer mediaPlayer = tiVar.x.b.g;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
            a0 a0Var = tiVar.x;
            qi qiVar = new qi(jiVar);
            x xVar = a0Var.b;
            xVar.h = qiVar;
            xVar.i = new ri(str2, str, jiVar);
            tiVar.c = a0Var;
            return;
        }
        if (ImageViewManager.NAME.equals(str)) {
            String strA2 = n4.a().a(str2, str);
            if (!lj.b(strA2) && !new File(strA2).exists()) {
                File file = new File(strA2);
                imageView2 = new ImageView(tiVar.a);
                imageView2.setImageURI(Uri.fromFile(file));
                if (this.f.compareAndSet(false, true)) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(tiVar);
                    if (this.c != null) {
                        imageView = imageView2;
                        imageView = imageView2;
                        this.d.post(new c3(this, arrayList2));
                        imageView = imageView2;
                    }
                }
            } else {
                QYNiceImageView qYNiceImageView = new QYNiceImageView(tiVar.a);
                qYNiceImageView.a(str2);
                qYNiceImageView.a(new si(jiVar));
                imageView = qYNiceImageView;
            }
            imageView = imageView2;
            imageView = imageView2;
            imageView = imageView2;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tiVar.c = imageView;
            return;
        }
        Log.e("ssp_native_ad", "interactiveStyle_1: error type");
        a(vhVar, 9, "not support render");
    }
}

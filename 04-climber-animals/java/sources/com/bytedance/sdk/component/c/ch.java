package com.bytedance.sdk.component.c;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@ATSApi
public interface ch {
    @ATSMethod(12)
    ch ah(int i);

    @ATSMethod(7)
    ch ah(String str);

    @ATSMethod(20)
    ch ah(boolean z);

    @ATSMethod(18)
    ch d(int i);

    @ATSMethod(19)
    ch ka(int i);

    @ATSMethod(10)
    ch ms(int i);

    @ATSMethod(9)
    ch ms(Bitmap.Config config);

    @ATSMethod(8)
    ch ms(ImageView.ScaleType scaleType);

    @ATSMethod(13)
    ch ms(t tVar);

    @ATSMethod(21)
    ch ms(u uVar);

    @ATSMethod(17)
    ch ms(x xVar);

    @ATSMethod(6)
    ch ms(xr xrVar);

    @ATSMethod(4)
    ch ms(String str);

    @ATSMethod(16)
    ch ms(ExecutorService executorService);

    @ATSMethod(14)
    ch ms(boolean z);

    @ATSMethod(3)
    ny ms(ImageView imageView);

    @ATSMethod(2)
    ny ms(ao aoVar);

    @ATSMethod(1)
    ny ms(ao aoVar, int i);

    @ATSMethod(11)
    ch xr(int i);

    @ATSMethod(5)
    ch xr(String str);

    @ATSMethod(15)
    ch xr(boolean z);
}

package com.byazt.qvl;

import android.util.SparseArray;
import com.byazt.xjg.ho;
import com.byazt.xjg.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1416, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.NativeExpressAdListener pr;

    public c(TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this.pr = nativeExpressAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 153101:
                this.pr.onError(valueSetHw.intValue(0), valueSetHw.stringValue(1));
                return null;
            case 153102:
                List arrayList = (List) valueSetHw.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new m(ho.pr(it.next())));
                }
                this.pr.onNativeExpressAdLoad(arrayList2);
                return null;
            default:
                return null;
        }
    }
}

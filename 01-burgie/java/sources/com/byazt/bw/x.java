package com.byazt.bw;

import android.app.Application;
import android.util.SparseArray;
import com.byazt.dv.Stub_SingleTask_Activity_T;
import com.byazt.dv.Stub_Standard_Activity;
import com.byazt.dv.Stub_Standard_Activity_T;
import com.byazt.dv.Stub_Standard_Landscape_Activity;
import com.byazt.dv.Stub_Standard_Portrait_Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 121})
public final class x implements Function<SparseArray<Object>, Object> {
    public static volatile x pr;
    public final pr hn = new pr();
    public hn hw;

    private x() {
    }

    public static x pr() {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new x();
                }
            }
        }
        return pr;
    }

    public Application.ActivityLifecycleCallbacks hw() {
        return this.hn;
    }

    public void pr(hn hnVar) {
        this.hw = hnVar;
    }

    private Function<SparseArray<Object>, Object> pr(int i) {
        switch (i) {
            case 2:
                return com.byazt.ay.hn.pr();
            case 3:
                return com.byazt.me.hn.pr(TTAppContextHolder.getContext());
            case 4:
                return com.byazt.os.pr.pr();
            default:
                return null;
        }
    }

    private void pr(final hw hwVar) {
        this.hn.pr(new pr.InterfaceC0028pr() { // from class: com.byazt.bw.x.1
            @Override // com.byazt.bw.pr.InterfaceC0028pr
            public void pr() {
                hwVar.pr();
            }

            @Override // com.byazt.bw.pr.InterfaceC0028pr
            public void hw() {
                hwVar.hw();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> functionPr;
        switch (((Integer) sparseArray.get(-99999987)).intValue()) {
            case -99999986:
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(10000, 5);
                return sparseArray2;
            case 2:
                return this.hn.pr();
            case 3:
                return TTAppContextHolder.getContext();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                hn hnVar = this.hw;
                if (hnVar == null || (functionPr = hnVar.pr(4)) == null) {
                    return null;
                }
                return functionPr.apply(sparseArray);
            case 9:
                Object obj = sparseArray.get(0);
                if (obj instanceof Function) {
                    pr(new hw((Function) obj));
                }
                return null;
            case 10:
                hn hnVar2 = this.hw;
                return hnVar2 == null ? pr(((Integer) sparseArray.get(0)).intValue()) : hnVar2.pr(((Integer) sparseArray.get(0)).intValue());
            case 14:
                return this.hn.hw();
            case 15:
                HashMap map = new HashMap();
                map.put("STUB_STANDARD_ACTIVITY_T", Stub_Standard_Activity_T.class.getName());
                map.put("STUB_STANDARD_PORTRAIT_ACTIVITY_T", Stub_Standard_Portrait_Activity.class.getName());
                map.put("STUB_STANDARD_ACTIVITY", Stub_Standard_Activity.class.getName());
                map.put("STUB_STANDARD_LANDSCAPE_ACTIVITY", Stub_Standard_Landscape_Activity.class.getName());
                map.put("STUB_SINGLE_TASK_ACTIVITY_T", Stub_SingleTask_Activity_T.class.getName());
                return map;
            case 16:
                return TTAppContextHolder.class;
            case 17:
                return c.pr();
            case 18:
                com.byazt.vzx.pr prVar = (com.byazt.vzx.pr) ((Class) sparseArray.get(0)).getAnnotation(com.byazt.vzx.pr.class);
                if (prVar == null) {
                    return null;
                }
                return prVar.pr();
            default:
                return null;
        }
    }
}

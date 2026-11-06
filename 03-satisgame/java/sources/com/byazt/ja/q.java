package com.byazt.ja;

import android.app.Application;
import android.util.SparseArray;
import com.byazt.tj.Stub_SingleTask_Activity_T;
import com.byazt.tj.Stub_Standard_Activity;
import com.byazt.tj.Stub_Standard_Activity_T;
import com.byazt.tj.Stub_Standard_Landscape_Activity;
import com.byazt.tj.Stub_Standard_Portrait_Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 5})
public final class q implements Function<SparseArray<Object>, Object> {
    public static volatile q n;
    public s qg;
    public final n s = new n();

    private q() {
    }

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public Application.ActivityLifecycleCallbacks qg() {
        return this.s;
    }

    public void n(s sVar) {
        this.qg = sVar;
    }

    private Function<SparseArray<Object>, Object> n(int i) {
        if (i == 2) {
            return com.byazt.ea.s.n();
        }
        if (i == 3) {
            return com.byazt.im.s.n(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.byazt.bsi.n.n();
    }

    private void n(final qg qgVar) {
        this.s.n(new n.InterfaceC0206n() { // from class: com.byazt.ja.q.1
            @Override // com.byazt.ja.n.InterfaceC0206n
            public void n() {
                qgVar.n();
            }

            @Override // com.byazt.ja.n.InterfaceC0206n
            public void qg() {
                qgVar.qg();
            }
        });
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> functionN;
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 2:
                    return this.s.n();
                case 3:
                    return TTAppContextHolder.getContext();
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    s sVar = this.qg;
                    if (sVar != null && (functionN = sVar.n(4)) != null) {
                        return functionN.apply(sparseArray);
                    }
                    return null;
                case 9:
                    Object obj = sparseArray.get(0);
                    if (obj instanceof Function) {
                        n(new qg((Function) obj));
                    }
                    return null;
                case 10:
                    s sVar2 = this.qg;
                    return sVar2 == null ? n(((Integer) sparseArray.get(0)).intValue()) : sVar2.n(((Integer) sparseArray.get(0)).intValue());
                default:
                    switch (iIntValue) {
                        case 14:
                            return this.s.qg();
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
                            return l.n();
                        case 18:
                            com.byazt.cp.n nVar = (com.byazt.cp.n) ((Class) sparseArray.get(0)).getAnnotation(com.byazt.cp.n.class);
                            if (nVar != null) {
                                return nVar.n();
                            }
                            return null;
                        default:
                            return null;
                    }
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(10000, 5);
        return sparseArray2;
    }
}

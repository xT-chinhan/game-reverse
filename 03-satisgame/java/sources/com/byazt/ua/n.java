package com.byazt.ua;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.nw.fs;
import com.byazt.nw.l;
import com.byazt.nw.rv;
import com.byazt.nw.w;
import com.byazt.nw.x;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 958, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public com.byazt.dd.qg l;
    public s n;
    public Function<SparseArray<Object>, Object> q;
    public int qg;
    public int s;
    public com.byazt.qn.qg w;
    public tj x;

    public n(com.byazt.qn.qg qgVar, com.byazt.dd.qg qgVar2, s sVar) {
        this.qg = qgVar.um();
        this.w = qgVar;
        this.s = qgVar2.k();
        this.l = qgVar2;
        this.n = sVar;
        this.x = qgVar2.fs();
    }

    public String n(Context context, String str, Object obj) {
        if (this.q != null) {
            Object objApply = this.q.apply(com.byazt.of.qg.n().n(8139).n(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).n(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, str).n(8044, obj).n(String.class).qg());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        Class cls = (Class) pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue == 8108) {
            this.n.n(new com.byazt.mj.n(pluginValueSetQg.intValue(8014), pluginValueSetQg.stringValue(8015)));
        } else if (iIntValue == 8112) {
            Function function = (Function) pluginValueSetQg.objectValue(8303, Function.class);
            int iIntValue2 = pluginValueSetQg.intValue(8014);
            String strStringValue = pluginValueSetQg.stringValue(8015);
            ArrayList arrayList = new ArrayList(1);
            if (function instanceof com.byazt.sg.s) {
                arrayList.add((com.byazt.sg.s) function);
            } else if (function instanceof Function) {
                Object objApply = function.apply(com.byazt.of.qg.n().n(-99999977).qg());
                if (objApply instanceof com.byazt.sg.s) {
                    arrayList.add((com.byazt.sg.s) objApply);
                }
            }
            this.n.n(arrayList, new com.byazt.mj.n(iIntValue2, strStringValue));
        } else if (iIntValue == 8107) {
            List list = (List) pluginValueSetQg.objectValue(8303, List.class);
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof com.byazt.sg.s) {
                        arrayList2.add((com.byazt.sg.s) obj);
                    } else if (obj instanceof Function) {
                        Object objApply2 = ((Function) obj).apply(com.byazt.of.qg.n().n(-99999977).qg());
                        if (objApply2 instanceof com.byazt.sg.s) {
                            arrayList2.add((com.byazt.sg.s) objApply2);
                        }
                    }
                }
            }
            this.n.n(arrayList2);
        } else {
            if (iIntValue == 8127) {
                return n();
            }
            if (iIntValue == 8110) {
                return Boolean.valueOf(this.l.n());
            }
            if (iIntValue == 8136) {
                return Boolean.valueOf(this.l.wm());
            }
            if (iIntValue == 8141) {
                return Boolean.valueOf(this.l.m());
            }
            if (iIntValue == 8137) {
                return this.l.hu();
            }
            if (iIntValue == 8226) {
                return Integer.valueOf(this.l.um());
            }
            if (iIntValue == 8138) {
                this.q = (Function) pluginValueSetQg.objectValue(8043, Function.class);
            } else if (iIntValue == 8210) {
                return Boolean.valueOf(this.n.n());
            }
        }
        return com.byazt.ef.n.n(cls);
    }

    private com.byazt.sg.s n() {
        switch (this.qg) {
            case 1:
                return new com.byazt.nw.s(this.l);
            case 2:
                return new w(this.l);
            case 3:
                return new rv(this.l);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                int i = this.s;
                if (i == 4) {
                    return new x(this.l, this.n);
                }
                if (i == 3) {
                    return new com.byazt.nw.s(this.l);
                }
                if (i == 5) {
                    return new x(this.l, this.n);
                }
                return new x(this.l, this.n);
            case 7:
                int i2 = this.s;
                if (i2 == 6) {
                    return new fs(this.l);
                }
                if (i2 == 7) {
                    return new l(this.l);
                }
                if (i2 == 8) {
                    return new w(this.l);
                }
                return new fs(this.l);
            case 8:
                return new l(this.l);
            case 9:
                return new x(this.l, this.n);
            case 10:
                int i3 = this.s;
                if (i3 == 1) {
                    return new w(this.l);
                }
                if (i3 == 2) {
                    return new l(this.l);
                }
                return null;
        }
    }
}

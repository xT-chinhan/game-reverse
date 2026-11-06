package com.byazt.zo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends com.byazt.gf.q {
    public final com.byazt.vyf.x n;
    public tj qg;

    public rv(com.byazt.vyf.x xVar) {
        this.n = xVar;
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        Object objApply;
        if (i == -99999986) {
            com.byazt.vyf.x xVar = this.n;
            if (xVar != null) {
                return (T) xVar.n();
            }
        } else if (i == 6) {
            Bundle bundle = pluginValueSet != null ? (Bundle) pluginValueSet.objectValue(10, Bundle.class) : null;
            Class cls2 = pluginValueSet != null ? (Class) pluginValueSet.objectValue(9, Class.class) : null;
            if (bundle != null && TextUtils.equals(bundle.getString("mediation_manager"), "mediation_manager")) {
                if (this.qg == null) {
                    this.qg = new tj();
                }
                return (T) this.qg;
            }
            if (com.byazt.lpr.q.n(cls2, bundle)) {
                com.byazt.vyf.x xVar2 = this.n;
                if (xVar2 != null) {
                    Object objApply2 = xVar2.apply(pluginValueSet.sparseArray());
                    if (objApply2 instanceof com.byazt.lpr.q.n) {
                        return (T) com.byazt.lpr.q.n(new cp((com.byazt.lpr.q.n) objApply2), cls2, bundle);
                    }
                }
                return null;
            }
            com.byazt.vyf.x xVar3 = this.n;
            if (xVar3 != null) {
                return (T) xVar3.apply(pluginValueSet.sparseArray());
            }
        } else if (i == 4) {
            Object objObjectValue = pluginValueSet != null ? pluginValueSet.objectValue(8, Object.class) : null;
            if (com.byazt.nf.tj.fs() && (objObjectValue instanceof Function)) {
                Function function = (Function) objObjectValue;
                PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(com.byazt.of.n.n((Function<SparseArray<Object>, Object>) function)).qg();
                if (pluginValueSetQg != null && pluginValueSetQg.intValue(10000) == 1 && (objApply = function.apply(com.byazt.of.qg.n().n(5).n(Object.class).qg())) != null) {
                    com.byazt.qt.n.d().n(objApply);
                }
            }
            if (com.byazt.vyf.s.cy().sh()) {
                n(objObjectValue);
            }
            com.byazt.vyf.x xVar4 = this.n;
            if (xVar4 != null) {
                return (T) xVar4.apply(pluginValueSet.sparseArray());
            }
        } else {
            com.byazt.vyf.x xVar5 = this.n;
            if (xVar5 != null) {
                return (T) xVar5.apply(pluginValueSet.sparseArray());
            }
        }
        return null;
    }

    @DungeonFlag
    private void n(Object obj) {
        if (obj instanceof Function) {
            Function<SparseArray<Object>, Object> function = (Function) obj;
            if (n(function, "mediation_qa_common")) {
                com.byazt.iav.qg.n().n(function);
                com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
                qgVarN.n(10009).n(Void.class);
                qgVarN.n(20009, com.byazt.iav.qg.n());
                function.apply(qgVarN.qg());
            }
        }
    }

    private boolean n(Function function, String str) {
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        qgVarN.n(10008).n(String.class);
        return str.equals(function.apply(qgVarN.qg()));
    }
}

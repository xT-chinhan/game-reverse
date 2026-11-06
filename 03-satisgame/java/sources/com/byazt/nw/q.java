package com.byazt.nw;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 5})
public abstract class q extends com.byazt.sg.s {
    public com.byazt.dd.n cp;
    public Function<SparseArray<Object>, Object> tj;

    public abstract <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public q(com.byazt.dd.n nVar) {
        this.cp = nVar;
    }

    public boolean tv() {
        com.byazt.dd.n nVar = this.cp;
        if (nVar != null) {
            return nVar.n();
        }
        return false;
    }

    public static Integer n(Function<SparseArray<Object>, Object> function) {
        Integer numN;
        if (function == null || (numN = com.byazt.lpr.n.n(function.apply(com.byazt.of.qg.n().n(8121).n(20068, 1).n(Object.class).qg()))) == null) {
            return 1;
        }
        return numN;
    }

    @Override // com.byazt.sg.s
    public void hd() {
        super.hd();
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8148).n(Void.class).qg());
        }
    }

    @Override // com.byazt.sg.s
    public void cy() {
        super.cy();
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8149).n(Void.class).qg());
        }
    }

    @Override // com.byazt.sg.s
    public void cd() {
        super.cd();
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8109).n(Void.class).qg());
        }
    }

    @Override // com.byazt.sg.s
    public boolean l() {
        if (this.tj == null) {
            return false;
        }
        this.tj.apply(com.byazt.of.qg.n().n(8120).n(Boolean.class).qg());
        return false;
    }

    @Override // com.byazt.sg.s
    public void qg(Map<String, Object> map) {
        if (o() && this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8142).n(Void.class).n(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).qg());
        }
    }

    @Override // com.byazt.sg.s
    public void n(Map<String, Object> map) {
        if (o() && this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(8144).n(Void.class).n(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).qg());
        }
    }

    @Override // com.byazt.sg.s
    public Map<String, Object> bb() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8239).n(Map.class).qg());
            s(objApply instanceof Map ? (Map) objApply : null);
        }
        return super.bb();
    }

    @Override // com.byazt.sg.s
    public long dz() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8245).n(Long.class).qg());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
            return 0L;
        }
        return super.dz();
    }

    @Override // com.byazt.sg.s
    public long c() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8246).n(Long.class).qg());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
            return 0L;
        }
        return super.c();
    }

    @Override // com.byazt.sg.s, com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8128) {
            this.tj = (Function) pluginValueSet.objectValue(8035, Function.class);
        } else if (i == 8208) {
            String strStringValue = pluginValueSet.stringValue(8058);
            if (!TextUtils.isEmpty(strStringValue)) {
                sz(strStringValue);
            }
        } else if (i == 8209) {
            cp(pluginValueSet.intValue(8060));
        } else if (i == 8140) {
            d(pluginValueSet.intValue(8059));
        }
        return (T) n(i, pluginValueSet, cls);
    }
}

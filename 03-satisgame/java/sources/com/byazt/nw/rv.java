package com.byazt.nw;

import android.app.Activity;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends q {
    public com.byazt.kt.w d;

    public rv(com.byazt.dd.n nVar) {
        super(nVar);
    }

    private com.byazt.kt.l to() {
        return (com.byazt.kt.l) this.rv;
    }

    @Override // com.byazt.sg.s
    public Integer w() {
        return n(this.tj);
    }

    @Override // com.byazt.sg.s
    public void n(ViewGroup viewGroup) {
        super.n(viewGroup);
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(6152).n(Void.class).n(20060, viewGroup).qg());
        }
    }

    @Override // com.byazt.sg.s
    public void n(ViewGroup viewGroup, Activity activity) {
        super.n(viewGroup, activity);
        if (this.tj != null) {
            this.tj.apply(com.byazt.of.qg.n().n(6154).n(Void.class).n(20060, viewGroup).n(20033, activity).qg());
        }
    }

    @Override // com.byazt.sg.s
    public String di() {
        if (this.tj != null) {
            Object objApply = this.tj.apply(com.byazt.of.qg.n().n(8147).n(String.class).qg());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.di();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.nw.q
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(ta());
        }
        int iIntValue = 0;
        if (i == 1009) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.byazt.kt.w wVar = this.d;
                if (!(wVar instanceof com.byazt.vv.qg)) {
                    return null;
                }
                ((com.byazt.vv.qg) wVar).q();
                return null;
            }
            if (to() == null) {
                return null;
            }
            to().q();
            return null;
        }
        if (i == 1017) {
            if (to() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                iIntValue = pluginValueSet.intValue(8014, 0);
                strStringValue = pluginValueSet.stringValue(8015);
            } else {
                strStringValue = "";
            }
            to().n(new com.byazt.mj.n(iIntValue, strStringValue));
            return null;
        }
        if (i == 1011) {
            boolean zBooleanValue = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue) {
                com.byazt.kt.w wVar2 = this.d;
                if (!(wVar2 instanceof com.byazt.vv.qg)) {
                    return null;
                }
                ((com.byazt.vv.qg) wVar2).qg(2);
                return null;
            }
            if (to() == null) {
                return null;
            }
            to().qg(2);
            return null;
        }
        if (i == 1008) {
            if (pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false) {
                com.byazt.kt.w wVar3 = this.d;
                if (!(wVar3 instanceof com.byazt.vv.qg)) {
                    return null;
                }
                ((com.byazt.vv.qg) wVar3).l();
                return null;
            }
            if (to() == null) {
                return null;
            }
            to().l();
            return null;
        }
        if (i == 1019) {
            boolean zBooleanValue2 = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue2) {
                com.byazt.kt.w wVar4 = this.d;
                if (!(wVar4 instanceof com.byazt.vv.qg)) {
                    return null;
                }
                ((com.byazt.vv.qg) wVar4).n(1);
                return null;
            }
            if (to() == null) {
                return null;
            }
            to().n(1);
            return null;
        }
        if (i == 1074) {
            if (to() != null) {
                return (T) to().getActivity();
            }
            return null;
        }
        if (i == 1051) {
            to();
            return null;
        }
        if (i == 1052) {
            to();
            return null;
        }
        if (i == 6156) {
            if (to() == null) {
                return null;
            }
            to().l_();
            return null;
        }
        if (i != 8111) {
            return null;
        }
        n(pluginValueSet.doubleValue(8016));
        return null;
    }
}

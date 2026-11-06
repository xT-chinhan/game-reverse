package com.byazt.pl;

import com.byazt.kf.rv;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 307, 21})
public class x extends qg {
    public volatile com.byazt.kf.s rv;

    public x(String str, com.byazt.nw.qg qgVar) {
        super(str, qgVar);
    }

    public void n(double d, Map<String, Object> map) {
        if (!qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
            if (this.rv == null) {
                this.rv = new rv(this, this.s);
            }
            n(this.rv, d, map);
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void s() {
        if (this.rv == null) {
            this.rv = new rv(this, this.s);
        }
        n(this.rv, (com.byazt.mj.n) null);
    }

    public void q() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.1
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    x.this.qg(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.1.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.me.n nVar = (com.byazt.me.n) x.this.rv.rn();
                            if (nVar != null) {
                                nVar.n();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void l() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.2
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    x.this.s(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.2.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.me.n nVar = (com.byazt.me.n) x.this.rv.rn();
                            if (nVar != null) {
                                nVar.i_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void sz() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.3
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.me.n nVar = (com.byazt.me.n) x.this.rv.rn();
                    if (nVar != null) {
                        nVar.j_();
                    }
                }
            });
        }
    }

    public final void k() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.4
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.me.n nVar = (com.byazt.me.n) x.this.rv.rn();
                    if (nVar != null) {
                        nVar.q();
                    }
                }
            });
        }
    }

    public final void cy() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.5
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.me.n nVar = (com.byazt.me.n) x.this.rv.rn();
                    if (nVar != null) {
                        nVar.l();
                    }
                }
            });
        }
    }

    public final void hd() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.6
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.me.n nVar = (com.byazt.me.n) x.this.rv.rn();
                    if (nVar != null) {
                        nVar.w();
                    }
                }
            });
        }
    }

    public final void n(final com.byazt.fd.n nVar) {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.x.7
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.me.n nVar2 = (com.byazt.me.n) x.this.rv.rn();
                    if (nVar2 != null) {
                        nVar2.n(nVar);
                    }
                }
            });
        }
    }

    @Override // com.byazt.pl.qg
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            n(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            n(dDoubleValue, map);
        } else if (i == 8112) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callAdVideoCache");
            s();
        } else if (i == 1008) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callRewardedAdShow");
            q();
        } else if (i == 1009) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callRewardClick");
            l();
        } else if (i == 1014) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callRewardedAdClosed");
            sz();
        } else if (i == 1026) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callRewardVideoComplete");
            k();
        } else if (i == 1021) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callRewardVideoError");
            cy();
        } else if (i == 1037) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callRewardSkippedVideo");
            hd();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
            final float fFloatValue = pluginValueSet.floatValue(8018);
            final String strStringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom reward loader : callRewardVerify rewardVerify:" + zBooleanValue + " amount:" + fFloatValue + " name:" + strStringValue2 + " map:" + map2);
            n(new com.byazt.fd.n() { // from class: com.byazt.pl.x.8
                @Override // com.byazt.fd.n
                public boolean n() {
                    return zBooleanValue;
                }

                @Override // com.byazt.fd.n
                public float qg() {
                    return fFloatValue;
                }

                @Override // com.byazt.fd.n
                public String s() {
                    return strStringValue2;
                }

                @Override // com.byazt.fd.n
                public Map<String, Object> q() {
                    return map2;
                }
            });
        }
        return null;
    }
}

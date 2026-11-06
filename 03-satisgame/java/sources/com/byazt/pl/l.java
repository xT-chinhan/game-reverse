package com.byazt.pl;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 307, 18})
public class l extends qg {
    public volatile com.byazt.kf.s rv;

    public l(String str, com.byazt.nw.qg qgVar) {
        super(str, qgVar);
    }

    public void n(double d, Map<String, Object> map) {
        if (!qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
            if (this.rv == null) {
                this.rv = new com.byazt.kf.w(this, this.s);
            }
            n(this.rv, d, map);
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void s() {
        if (this.rv == null) {
            this.rv = new com.byazt.kf.w(this, this.s);
        }
        n(this.rv, (com.byazt.mj.n) null);
    }

    public void q() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.1
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    l.this.qg(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.1.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.pf.n nVar = (com.byazt.pf.n) l.this.rv.rn();
                            if (nVar != null) {
                                nVar.n();
                            }
                        }
                    });
                }
            });
        }
    }

    public void l() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.2
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    l.this.s(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.2.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.pf.n nVar = (com.byazt.pf.n) l.this.rv.rn();
                            if (nVar != null) {
                                nVar.g_();
                            }
                        }
                    });
                }
            });
        }
    }

    public void sz() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.3
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.pf.n nVar = (com.byazt.pf.n) l.this.rv.rn();
                    if (nVar != null) {
                        nVar.h_();
                    }
                }
            });
        }
    }

    public void k() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.4
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.pf.n nVar = (com.byazt.pf.n) l.this.rv.rn();
                    if (nVar != null) {
                        nVar.q();
                    }
                }
            });
        }
    }

    public void cy() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.5
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.pf.n nVar = (com.byazt.pf.n) l.this.rv.rn();
                    if (nVar != null) {
                        nVar.l();
                    }
                }
            });
        }
    }

    public void hd() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.6
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.pf.n nVar = (com.byazt.pf.n) l.this.rv.rn();
                    if (nVar != null) {
                        nVar.w();
                    }
                }
            });
        }
    }

    public void n(final com.byazt.fd.n nVar) {
        if (nVar == null || this.rv == null) {
            return;
        }
        n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.l.7
            @Override // com.byazt.xo.n.InterfaceC0394n
            public void n() {
                com.byazt.pf.n nVar2 = (com.byazt.pf.n) l.this.rv.rn();
                if (nVar2 != null) {
                    nVar2.n(nVar);
                }
            }
        });
    }

    @Override // com.byazt.pl.qg
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            n(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            n(dDoubleValue, map);
        } else if (i == 8112) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callAdVideoCache");
            s();
        } else if (i == 1008) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callFullVideoAdShow");
            q();
        } else if (i == 1009) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callFullVideoAdClick");
            l();
        } else if (i == 1014) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callFullVideoAdClosed");
            sz();
        } else if (i == 1026) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callFullVideoComplete");
            k();
        } else if (i == 1021) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callFullVideoError");
            cy();
        } else if (i == 1037) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callFullVideoSkippedVideo");
            hd();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
            final float fFloatValue = pluginValueSet.floatValue(8018);
            final String strStringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom full loader : callFullVideoRewardVerify rewardVerify:" + zBooleanValue + " amount:" + fFloatValue + " name:" + strStringValue2 + " map:" + map2);
            n(new com.byazt.fd.n() { // from class: com.byazt.pl.l.8
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

package com.byazt.pl;

import com.byazt.kf.tj;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 307, 101})
public class fs extends qg {
    public com.byazt.kf.s rv;

    public fs(String str, com.byazt.nw.qg qgVar) {
        super(str, qgVar);
    }

    public void n(double d, Map<String, Object> map) {
        if (!qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter callLoadSuccess");
            tj tjVar = new tj(this, this.s);
            this.rv = tjVar;
            n(tjVar, d, map);
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void s() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.fs.1
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    fs.this.s(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.fs.1.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.vv.qg qgVar = (com.byazt.vv.qg) fs.this.rv.rn();
                            if (qgVar != null) {
                                qgVar.q();
                            }
                        }
                    });
                }
            });
        }
    }

    public void q() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.fs.2
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    fs.this.qg(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.fs.2.1
                        @Override // com.byazt.xo.n.InterfaceC0394n
                        public void n() {
                            com.byazt.vv.qg qgVar = (com.byazt.vv.qg) fs.this.rv.rn();
                            if (qgVar != null) {
                                qgVar.l();
                            }
                        }
                    });
                }
            });
        }
    }

    public void l() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.fs.3
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.vv.qg qgVar = (com.byazt.vv.qg) fs.this.rv.rn();
                    if (qgVar != null) {
                        qgVar.n(1);
                    }
                }
            });
        }
    }

    public void sz() {
        if (this.rv != null) {
            n(new com.byazt.xo.n.InterfaceC0394n() { // from class: com.byazt.pl.fs.4
                @Override // com.byazt.xo.n.InterfaceC0394n
                public void n() {
                    com.byazt.vv.qg qgVar = (com.byazt.vv.qg) fs.this.rv.rn();
                    if (qgVar != null) {
                        qgVar.qg(2);
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
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom splash loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            n(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom splash loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            n(dDoubleValue, map);
        } else if (i == 1009) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom splash loader : callSplashAdClicked");
            s();
        } else if (i == 1008) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom splash loader : callSplashAdShow");
            q();
        } else if (i == 1019) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom splash loader : callSplashAdSkip");
            l();
        } else if (i == 1011) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom splash loader : callSplashAdDismiss");
            sz();
        }
        return null;
    }
}

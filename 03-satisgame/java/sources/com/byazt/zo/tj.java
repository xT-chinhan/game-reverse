package com.byazt.zo;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends com.byazt.pch.q {
    @Override // com.byazt.pch.q
    public void n(Activity activity, List<com.byazt.pch.l> list, int i, int i2, Function<SparseArray<Object>, Object> function) {
        com.byazt.qn.qg qgVarN;
        com.byazt.rb.qg.qg("TMe", "mediationManager preload activity = " + activity + " list = " + list + " parallelNum = " + i + " requestIntervalS = " + i2 + " classLoader = " + function);
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.byazt.pch.l lVar : list) {
                if (lVar != null && (qgVarN = com.byazt.kv.n.n(lVar.n(), lVar.n(com.byazt.vgx.s.qg()), function)) != null) {
                    arrayList.add(new com.byazt.jp.oa(qgVarN, lVar.qg()));
                }
            }
            if (arrayList.size() > 0) {
                com.byazt.jp.tj.n(activity, arrayList, i, i2);
                return;
            } else {
                com.byazt.rb.qg.q("TMe", "参数错误");
                return;
            }
        }
        com.byazt.rb.qg.q("TMe", "参数错误");
    }

    @Override // com.byazt.pch.q
    public void n(String str) {
        com.byazt.rb.qg.qg("TMe", "mediationManager setPulisherDid configUserInfoForSegment = ".concat(String.valueOf(str)));
        com.byazt.jp.tj.n(str);
    }

    @Override // com.byazt.pch.q
    public void n(Context context) {
        com.byazt.rb.qg.qg("TMe", "mediationManager requestPermissionIfNecessary context = ".concat(String.valueOf(context)));
        com.byazt.jp.tj.n(context);
    }

    @Override // com.byazt.pch.q
    public void n(Context context, int[] iArr) {
        com.byazt.rb.qg.qg("TMe", "mediationManager requestPermissionIfNecessary context = " + context + " permissions = " + iArr);
        com.byazt.jp.tj.n(context, iArr);
    }

    @Override // com.byazt.pch.q
    public void n(int i) {
        com.byazt.rb.qg.qg("TMe", "mediationManager setThemeStatus themeStatus = ".concat(String.valueOf(i)));
        com.byazt.jp.tj.n(i);
    }

    @Override // com.byazt.pch.q
    public int n(final com.byazt.pe.q qVar) {
        com.byazt.rb.qg.qg("TMe", "mediationManager showOpenOrInstallAppDialog");
        return com.byazt.jp.tj.n(new com.byazt.jp.s() { // from class: com.byazt.zo.tj.1
            @Override // com.byazt.jp.s
            public void n(int i) {
                com.byazt.pe.q qVar2 = qVar;
                if (qVar2 != null) {
                    qVar2.n(i);
                }
            }
        });
    }

    @Override // com.byazt.pch.q
    public void n(com.byazt.xmw.s sVar) {
        com.byazt.jp.tj.n(s.n(sVar));
    }

    @Override // com.byazt.pch.q
    public void n(com.byazt.zq.q qVar) {
        com.byazt.rb.qg.qg("TMe", "mediationManager updatePrivacyConfig customController = ".concat(String.valueOf(qVar)));
        com.byazt.jp.tj.n(qVar);
    }

    @Override // com.byazt.pch.q
    public void n(Map<String, Object> map) {
        com.byazt.rb.qg.qg("TMe", "mediationManager updateLocalExtra map = ".concat(String.valueOf(map)) == null ? AbstractJsonLexerKt.NULL : map.toString());
        com.byazt.qt.n.d().qg(map);
    }

    @Override // com.byazt.pch.q
    public void n(Context context, com.byazt.pch.n nVar, final com.byazt.pe.s sVar, Function<SparseArray<Object>, Object> function) {
        if (context != null && nVar != null) {
            com.byazt.rb.qg.qg("TMe", "mediationManager loadNativeToken context = " + context + " adSlot = " + nVar + " pluginIMediationNativeAdTokenCallback = " + sVar + " classLoader = " + function);
            nVar.n(com.byazt.vgx.s.qg());
            com.byazt.qn.qg qgVarN = com.byazt.kv.n.n(5, nVar, function);
            if (qgVarN != null) {
                final com.byazt.np.rv rvVar = new com.byazt.np.rv(context);
                rvVar.n(qgVarN, new com.byazt.kv.s() { // from class: com.byazt.zo.tj.2
                    @Override // com.byazt.kv.s
                    public void n(String str) {
                        com.byazt.pe.s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.n(str, new com.byazt.ux.n(rvVar));
                        }
                    }

                    @Override // com.byazt.kv.s
                    public void n(com.byazt.mj.n nVar2) {
                        com.byazt.pe.s sVar2;
                        if (nVar2 == null || (sVar2 = sVar) == null) {
                            return;
                        }
                        sVar2.n(nVar2.n, nVar2.qg);
                    }
                });
                return;
            }
            return;
        }
        com.byazt.rb.qg.q("TMe", "参数错误");
    }

    @Override // com.byazt.pch.q
    public void n(Context context, com.byazt.pch.n nVar, final com.byazt.pe.n nVar2, Function<SparseArray<Object>, Object> function) {
        if (context != null && nVar != null) {
            com.byazt.rb.qg.qg("TMe", "mediationManager loadDrawToken context = " + context + " adSlot = " + nVar + " pluginIMediationDrawAdTokenCallback = " + nVar2 + " classLoader = " + function);
            nVar.n(com.byazt.vgx.s.qg());
            com.byazt.qn.qg qgVarN = com.byazt.kv.n.n(9, nVar, function);
            if (qgVarN != null) {
                final com.byazt.np.x xVar = new com.byazt.np.x(context);
                xVar.n(qgVarN, new com.byazt.kv.s() { // from class: com.byazt.zo.tj.3
                    @Override // com.byazt.kv.s
                    public void n(String str) {
                        com.byazt.pe.n nVar3 = nVar2;
                        if (nVar3 != null) {
                            nVar3.n(str, new com.byazt.xr.q(xVar));
                        }
                    }

                    @Override // com.byazt.kv.s
                    public void n(com.byazt.mj.n nVar3) {
                        com.byazt.pe.n nVar4;
                        if (nVar3 == null || (nVar4 = nVar2) == null) {
                            return;
                        }
                        nVar4.n(nVar3.n, nVar3.qg);
                    }
                });
                return;
            }
            return;
        }
        com.byazt.rb.qg.q("TMe", "参数错误");
    }

    @Override // com.byazt.pch.q
    public Map<String, Object> n() {
        com.byazt.rb.qg.qg("TMe", "getMediationExtraInfo");
        return com.byazt.jp.tj.oa();
    }

    @Override // com.byazt.pch.q
    public Object n(int i, PluginValueSet pluginValueSet) {
        String strS;
        String strN;
        if (i == 8259) {
            return n();
        }
        if (i == 1001) {
            return Boolean.valueOf(com.byazt.jp.tj.n());
        }
        if (i == 1002) {
            return Boolean.valueOf(com.byazt.jp.tj.n(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1002)));
        }
        if (i == 1003) {
            return Boolean.valueOf(com.byazt.jp.tj.qg(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1003)));
        }
        if (i == 1004) {
            return com.byazt.jp.tj.q();
        }
        if (i == 1005) {
            return com.byazt.jp.tj.tj();
        }
        if (i == 1006) {
            return com.byazt.jp.tj.rv();
        }
        if (i == 1007) {
            return com.byazt.jp.tj.cp();
        }
        if (i == 1008) {
            com.byazt.jp.tj.qg(2);
        } else if (i == 1009) {
            com.byazt.jp.tj.d();
        } else {
            if (i == 1010) {
                return Boolean.valueOf(com.byazt.jp.tj.q(pluginValueSet.stringValue(1001)));
            }
            if (i == 1011) {
                String strStringValue = pluginValueSet.stringValue(1001);
                com.byazt.sbw.n nVarL = com.byazt.jp.tj.l(strStringValue);
                com.byazt.ju.q qVarW = com.byazt.jp.tj.w(strStringValue);
                if (nVarL != null) {
                    strS = nVarL.s();
                    strN = nVarL.q();
                } else if (qVarW != null) {
                    String strQg = qVarW.qg();
                    strN = qVarW.n();
                    strS = strQg;
                } else {
                    strS = "";
                    strN = "";
                }
                HashMap map = new HashMap(2);
                map.put("networdSdkVersion", strS);
                map.put("adapterSdkVersion", strN);
                return map;
            }
            if (i == 2001) {
                if (pluginValueSet == null) {
                    return null;
                }
                com.byazt.iav.n.n((Function<SparseArray<Object>, Object>) pluginValueSet.objectValue(2002, Function.class));
                return com.byazt.iav.n.n();
            }
            if (i == 1012) {
                return Boolean.valueOf(com.byazt.qt.n.d().ou().qg());
            }
        }
        return null;
    }
}

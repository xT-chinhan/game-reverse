package com.byazt.vo;

import android.app.Activity;
import android.os.Bundle;
import com.byazt.fvm.k;
import com.byazt.np.d;
import com.byazt.nq.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 19})
public class n extends k {
    public d n;
    public com.byazt.tmn.n qg;

    @Override // com.byazt.fvm.k
    public void n(com.byazt.tmn.qg qgVar) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
    }

    @Override // com.byazt.fvm.k
    public long q() {
        return LongCompanionObject.MAX_VALUE;
    }

    @Override // com.byazt.fvm.k
    public void qg(com.byazt.tmn.n nVar) {
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
    }

    @Override // com.byazt.fvm.k
    public int s() {
        return 0;
    }

    public n(d dVar) {
        this.n = dVar;
        w();
    }

    private void w() {
        d dVar = this.n;
        if (dVar == null) {
            return;
        }
        dVar.n(new com.byazt.me.n() { // from class: com.byazt.vo.n.1
            @Override // com.byazt.me.n
            public void n(com.byazt.mj.n nVar) {
            }

            @Override // com.byazt.me.n
            public void n() {
                if (n.this.qg != null) {
                    n.this.qg.n(null);
                }
            }

            @Override // com.byazt.me.n
            public void i_() {
                if (n.this.qg != null) {
                    n.this.qg.qg(null);
                }
            }

            @Override // com.byazt.me.n
            public void j_() {
                if (n.this.qg != null) {
                    n.this.qg.s(null);
                }
            }

            @Override // com.byazt.me.n
            public void q() {
                if (n.this.qg != null) {
                    n.this.qg.n();
                }
            }

            @Override // com.byazt.me.n
            public void l() {
                if (n.this.qg != null) {
                    n.this.qg.qg();
                }
            }

            @Override // com.byazt.me.n
            public void n(com.byazt.fd.n nVar) {
                n nVar2 = n.this;
                nVar2.n(nVar, nVar2.qg, "CSJMRewardAd normal");
            }

            @Override // com.byazt.me.n
            public void w() {
                if (n.this.qg != null) {
                    n.this.qg.s();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.fd.n nVar, com.byazt.tmn.n nVar2, String str) {
        Bundle bundle;
        String str2;
        com.byazt.xll.s.n(nVar, str);
        if (nVar2 == null || nVar == null) {
            return;
        }
        boolean zN = nVar.n();
        float fQg = nVar.qg();
        String strS = nVar.s();
        Map<String, Object> mapQ = nVar.q();
        if (mapQ == null) {
            mapQ = new HashMap<>();
        }
        Object obj = mapQ.get(MediationConstant.KEY_REWARD_TYPE);
        int iIntValue = 0;
        int iIntValue2 = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        Object obj2 = mapQ.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj2 instanceof Bundle) {
            bundle = (Bundle) obj2;
        } else {
            bundle = new Bundle();
        }
        bundle.putString("reward_extra_key_reward_name", strS);
        bundle.putFloat("reward_extra_key_reward_amount", fQg);
        Object obj3 = mapQ.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj3 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj3).booleanValue());
        }
        Object obj4 = mapQ.get("transId");
        if (obj4 instanceof String) {
            bundle.putString("transId", (String) obj4);
        }
        Object obj5 = mapQ.get(MediationConstant.KEY_REASON);
        if (obj5 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj5).intValue());
        }
        Object obj6 = mapQ.get("gromoreExtra");
        if (obj6 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj6);
        }
        Object obj7 = mapQ.get(MediationConstant.KEY_ERROR_CODE);
        if (obj7 instanceof Integer) {
            Integer num = (Integer) obj7;
            iIntValue = num.intValue();
            bundle.putInt(MediationConstant.KEY_ERROR_CODE, num.intValue());
        }
        Object obj8 = mapQ.get(MediationConstant.KEY_ERROR_MSG);
        if (obj8 instanceof String) {
            String str3 = (String) obj8;
            bundle.putString(MediationConstant.KEY_ERROR_MSG, str3);
            str2 = str3;
        } else {
            str2 = "";
        }
        Object obj9 = mapQ.get(MediationConstant.KEY_ADN_NAME);
        if (obj9 instanceof String) {
            bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj9);
        }
        Object obj10 = mapQ.get("ecpm");
        if (obj10 instanceof String) {
            bundle.putString("ecpm", (String) obj10);
        }
        Object obj11 = mapQ.get(MediationConstant.BAIDU_REWARD_TYPE);
        if (obj11 instanceof Integer) {
            bundle.putInt(MediationConstant.BAIDU_REWARD_TYPE, ((Integer) obj11).intValue());
        }
        nVar2.n(zN, iIntValue2, bundle);
        if (com.byazt.mt.qg.n("6.4.0.0")) {
            nVar2.n(zN, (int) fQg, strS != null ? strS : "", iIntValue, str2);
        }
    }

    @Override // com.byazt.fvm.k
    public void n(com.byazt.tmn.n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.fvm.k
    public void n(final com.byazt.mi.s sVar) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(new com.byazt.kv.qg() { // from class: com.byazt.vo.n.2
                @Override // com.byazt.kv.qg
                public void qg() {
                }

                @Override // com.byazt.kv.qg
                public void n() {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n();
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(long j, long j2, int i, int i2, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(long j, long j2, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.qg(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void qg(long j, long j2, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.s(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(long j, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(j, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.fvm.k
    public void n(Activity activity) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(activity);
        }
    }

    @Override // com.byazt.fvm.k
    public void n(Activity activity, Object obj, String str) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(activity, obj, str);
        }
    }

    @Override // com.byazt.fvm.k
    public int n() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.cy();
        }
        return -1;
    }

    @Override // com.byazt.fvm.k
    public Map<String, Object> qg() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.hd();
        }
        return null;
    }

    @Override // com.byazt.fvm.k
    public w l() {
        return new com.byazt.xll.n(new qg(this.n));
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(qgVar);
        }
    }
}

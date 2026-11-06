package com.byazt.pl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 307, 8})
public class s extends qg {
    public s(String str, com.byazt.nw.qg qgVar) {
        super(str, qgVar);
    }

    public void qg(List<Function<SparseArray<Object>, Object>> list) {
        if (list != null) {
            if (!qg()) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<Function<SparseArray<Object>, Object>> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.byazt.kf.q(this, it.next()));
                }
                n(arrayList);
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        n(new com.byazt.cn.n(49010, "list is null"));
    }

    public void n(com.byazt.cn.n nVar) {
        if (!n()) {
            n(new com.byazt.mj.n(49010, com.byazt.mj.n.n(49010), nVar == null ? -1 : nVar.n(), nVar == null ? "" : nVar.qg()));
        } else {
            com.byazt.rb.qg.q(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
        }
    }

    public boolean s() {
        return this.qg != null && this.qg.qg() == 1;
    }

    public boolean q() {
        return this.qg != null && this.qg.qg() == 2;
    }

    @Override // com.byazt.pl.qg
    public <T> T n(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8222) {
            boolean zS = s();
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw loader : isExpressRender: " + zS);
            return (T) Boolean.valueOf(zS);
        }
        if (i == 8223) {
            boolean zQ = q();
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw loader : isNativeAd: " + zQ);
            return (T) Boolean.valueOf(zQ);
        }
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            n(iIntValue, strStringValue);
            return null;
        }
        if (i != 8107) {
            return null;
        }
        List<Function<SparseArray<Object>, Object>> list = (List) pluginValueSet.objectValue(8303, List.class);
        com.byazt.rb.qg.qg(MediationConstant.TAG, "Adn custom draw loader : callLoadSucceed  list size:" + (list != null ? list.size() : 0));
        qg(list);
        return null;
    }
}

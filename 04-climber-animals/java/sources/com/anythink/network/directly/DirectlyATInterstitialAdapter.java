package com.anythink.network.directly;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.network.adx.AdxATInterstitialAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DirectlyATInterstitialAdapter extends AdxATInterstitialAdapter {
    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return "Directly";
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        this.c = 2;
        if (map.containsKey("unit_type") && (obj = map.get("unit_type")) != null) {
            this.c = Integer.parseInt(obj.toString());
            this.c = this.c != 0 ? 1 : 2;
        }
        super.loadCustomNetworkAd(context, map, map2);
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        fixDirectlyInterstitial();
        super.show(activity);
    }

    public void fixDirectlyInterstitial() {
        w wVarD;
        if (this.b == null || (wVarD = this.b.d()) == null) {
            return;
        }
        wVarD.g(this.c);
        bj bjVar = (bj) wVarD;
        if (bjVar.aI() == 5 && this.c == 2) {
            bjVar.t(3);
        }
    }
}

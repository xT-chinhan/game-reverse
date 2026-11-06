package com.anythink.network.directly;

import android.content.Context;
import com.anythink.network.adx.AdxATInterstitialAdapter;
import com.smartdigimkt.sdk.api.SDMSDK;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DirectlyATInterstitialAdapter extends AdxATInterstitialAdapter {
    @Override // com.anythink.core.api.bridge.ATBaseAdInternalAdapter
    public JSONObject getInnerBidToken(Context context, Map<String, Object> map, Map<String, String> map2) {
        return SDMSDK.getInstance().getSDMAdManager().getDirectlyBidTokenJSONObject(context, map, map2);
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public String getNetworkName() {
        return "Directly";
    }
}

package com.byazt.bm;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 20})
public class hn implements LocationProvider {
    public ValueSet pr;

    public static SparseArray<Object> pr(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr();
        hnVarPr.pr(262001, locationProvider.getLatitude());
        hnVarPr.pr(262002, locationProvider.getLongitude());
        return hnVarPr.hw().sparseArray();
    }

    public hn(ValueSet valueSet) {
        this.pr = valueSet == null ? com.byazt.ij.hn.pr : valueSet;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.pr.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.pr.doubleValue(262002);
    }
}

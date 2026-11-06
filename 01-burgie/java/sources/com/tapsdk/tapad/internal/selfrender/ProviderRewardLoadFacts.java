package com.tapsdk.tapad.internal.selfrender;

import com.tapsdk.tapad.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ProviderRewardLoadFacts {
    private final String requestId;
    private final String trackId;

    public ProviderRewardLoadFacts(String str, String str2) {
        this.requestId = safe(str);
        this.trackId = safe(str2);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public String requestId() {
        return this.requestId;
    }

    public JSONObject toJson() {
        return new JSONObject().put(Constants.Bidding.REQUEST_ID, this.requestId).put("track_id", this.trackId).put("candidate_context_required", true).put("wall_time_ms", System.currentTimeMillis());
    }

    public String trackId() {
        return this.trackId;
    }
}

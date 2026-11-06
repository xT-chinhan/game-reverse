package com.taptap.sdk.kit.internal.callback;

import kotlin.Metadata;

/* JADX INFO: compiled from: LeaderboardCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/kit/internal/callback/LeaderboardCallback;", "", "onLeaderboardChange", "", "selectedLeaderboardId", "", "selectedLeaderBoardName", "rank", "", "rankDisplay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface LeaderboardCallback {
    void onLeaderboardChange(String selectedLeaderboardId, String selectedLeaderBoardName, Long rank, String rankDisplay);
}

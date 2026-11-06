package com.byazt.xll;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK, 8})
public class s {
    public static void n(com.byazt.fd.n nVar, String str) {
        com.byazt.rb.qg.qg("TMe_reward", "RewardUtils  ".concat(String.valueOf(str)));
        if (nVar != null) {
            com.byazt.rb.qg.qg("TMe_reward", "rewardItem.getRewardName " + nVar.s());
            com.byazt.rb.qg.qg("TMe_reward", "rewardItem.getAmount " + nVar.qg());
            com.byazt.rb.qg.qg("TMe_reward", "rewardItem.getCustomData() " + nVar.q());
            com.byazt.rb.qg.qg("TMe_reward", "rewardItem.rewardVerify() " + nVar.n());
            return;
        }
        com.byazt.rb.qg.qg("TMe_reward", "rewardItem is null ");
    }
}

package com.mcto.sspsdk.internal;

import com.bytedance.android.live.base.api.push.ILivePush;

/* JADX INFO: loaded from: classes2.dex */
public enum z3 {
    CLICK_AREA_PLAYER("player", 3, 1),
    BUTTON("button", 3, 2),
    /* JADX INFO: Fake field, exist only in values array */
    SWITCH_FULL_SCREEN("switch_full", 0, 2),
    GRAPHIC("graphic", 3, 1),
    LIMIT_GRAPHIC("graphic", 3, 5),
    LAYER_BUTTON("layer_button", 3, 2),
    LAYER_GRAPHIC("layer_graphic", 3, 1),
    NEGATIVE("negative", 8, 2),
    CLOSE(ILivePush.ClickType.CLOSE, 8, 2),
    HALF_WEBVIEW("half_webview", 3, 2),
    SHAKE("shark", 3, 2),
    SHAKE_TEMPLATE("shark_t", 3, 2),
    TWIST("twist", 3, 2),
    TWIST_TEMPLATE("twist_t", 3, 2),
    DIRECT_ACTION_BTN("direct_action", 3, 2),
    DOWN_CONFIRM_ACTION_BTN("confirm_action", 0, 2),
    DOWN_CONFIRM_DETAIL_BTN("confirm_detail", 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    BACKGROUND("background", 3, 1),
    SLIDE("slide", 3, 1),
    AUTO_ACT("act", 3, 1),
    CLOSE_ACT("zoom", 3, 1),
    /* JADX INFO: Fake field, exist only in values array */
    REWARD_ACTION_DIALOG("action_dialog", 5, 5),
    /* JADX INFO: Fake field, exist only in values array */
    REWARD_ACTION_DIALOG_BTN("action_dialog_button", 5, 5),
    REWARD_EXIT_DIALOG("exit_dialog", 3, 5),
    /* JADX INFO: Fake field, exist only in values array */
    REWARD_GIFT("reward_gift", 5, 1),
    /* JADX INFO: Fake field, exist only in values array */
    PUSH_CARD("inner_push", 5, 5),
    FUNCTIONAL_BTN("dlg_fun", 0, 0);

    public final String a;
    public final int b;
    public final int c;

    z3(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }
}

package com.mar.sdk.gg.push;

/* JADX INFO: loaded from: classes2.dex */
public enum CrossPushStyle {
    GAME_ACTION1(1, "交叉互推动作1"),
    GAME_ACTION2(2, "交叉互推动作2"),
    GAME_ACTION3(3, "交叉互推动作3"),
    GAME_ACTION4(4, "交叉互推动作4"),
    GAME_ACTION5(5, "交叉互推动作5");

    String desc;
    int type;

    CrossPushStyle(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

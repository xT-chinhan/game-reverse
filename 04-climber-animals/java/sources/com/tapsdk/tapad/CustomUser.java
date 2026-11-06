package com.tapsdk.tapad;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class CustomUser {
    public final int avatarLevel;
    public final int avatarPayedToolCnt;
    public final int avatarSex;
    public final int beginMissionFinished;
    public final int newUserStatus;
    public final int payedUserStatus;
    public final int realAge;
    public final int realSex;

    public static class Builder {
        private int realAge = -1;
        private int realSex = -1;
        private int avatarSex = -1;
        private int avatarLevel = -1;
        private int newUserStatus = -1;
        private int payedUserStatus = -1;
        private int beginMissionFinished = -1;
        private int avatarPayedToolCnt = -1;

        public CustomUser build() {
            return new CustomUser(this);
        }

        public Builder withAvatarLevel(int i) {
            this.avatarLevel = i;
            return this;
        }

        public Builder withAvatarPayedToolCnt(int i) {
            this.avatarPayedToolCnt = i;
            return this;
        }

        public Builder withAvatarSex(int i) {
            this.avatarSex = i;
            return this;
        }

        public Builder withBeginMissionFinished(int i) {
            this.beginMissionFinished = i;
            return this;
        }

        public Builder withNewUserStatus(int i) {
            this.newUserStatus = i;
            return this;
        }

        public Builder withPayedUserStatus(int i) {
            this.payedUserStatus = i;
            return this;
        }

        public Builder withRealAge(int i) {
            this.realAge = i;
            return this;
        }

        public Builder withRealSex(int i) {
            this.realSex = i;
            return this;
        }
    }

    public CustomUser(Builder builder) {
        this.realAge = builder.realAge;
        this.realSex = builder.realSex;
        this.avatarSex = builder.avatarSex;
        this.avatarLevel = builder.avatarLevel;
        this.newUserStatus = builder.newUserStatus;
        this.payedUserStatus = builder.payedUserStatus;
        this.beginMissionFinished = builder.beginMissionFinished;
        this.avatarPayedToolCnt = builder.avatarPayedToolCnt;
    }

    public String toString() {
        return "CustomUser{realAge=" + this.realAge + ", realSex=" + this.realSex + ", avatarSex=" + this.avatarSex + ", avatarLevel=" + this.avatarLevel + ", newUserStatus=" + this.newUserStatus + ", payedUserStatus=" + this.payedUserStatus + ", beginMissionFinished=" + this.beginMissionFinished + ", avatarPayedToolCnt=" + this.avatarPayedToolCnt + AbstractJsonLexerKt.END_OBJ;
    }
}

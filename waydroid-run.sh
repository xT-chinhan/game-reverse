#!/usr/bin/env bash
# Chạy game TapTap trong Waydroid (Android ảo) trên Linux.
#   ./waydroid-run.sh            # khởi động Android + mở cửa sổ, liệt kê game
#   ./waydroid-run.sh 5          # mở game số 5 (CATO)
#   ./waydroid-run.sh stop       # tắt Android ảo
# Mật khẩu sudo: đặt biến môi trường PW=... (không đặt thì sudo tự hỏi).
set -e
PW=${PW:-}
sudo() { if [ -n "$PW" ]; then echo "$PW" | command sudo -S -p '' "$@"; else command sudo "$@"; fi; }
export XDG_RUNTIME_DIR=/run/user/$(id -u)
export WAYLAND_DISPLAY=wayland-wd

declare -A G=(
  [1]="com.hnyg.bjdwxcf.topon|01 Burgie (nấu ăn)"
  [2]="com.yuzuhouse.test|02 Yuzu House (pet/avatar, cũng mở web được)"
  [3]="com.molehole.zaiwanyiguan|03 Satisgame (nhiều mini-game, cần mạng+TapTap)"
  [4]="com.dodofast.climberanimals|04 Climber Animals (chơi mạng, cần đăng nhập)"
  [5]="com.teamwoll.cato.taptap|05 CATO (bản thử, có tiếng Việt, chơi offline)"
)

if [ "$1" = "stop" ]; then
  waydroid session stop 2>/dev/null || true
  pkill -f 'weston.*wayland-wd' 2>/dev/null || true
  sudo systemctl stop waydroid-container
  echo "Đã tắt Android ảo."; exit 0
fi

# 1) container
sudo systemctl is-active --quiet waydroid-container || sudo systemctl start waydroid-container
# 2) cửa sổ Weston (nơi hiển thị Android)
pgrep -f 'weston.*wayland-wd' >/dev/null || {
  nohup weston --backend=x11 --width=1280 --height=720 --socket=wayland-wd >/tmp/weston-wd.log 2>&1 &
  for i in $(seq 1 20); do [ -S "$XDG_RUNTIME_DIR/wayland-wd" ] && break; sleep 0.5; done
}
# 3) session
waydroid status 2>/dev/null | grep -q 'Session:.*RUNNING' || {
  nohup waydroid session start >/tmp/waydroid-session.log 2>&1 &
  echo -n "Đang khởi động Android"
  for i in $(seq 1 60); do
    [ "$(sudo waydroid shell -- getprop sys.boot_completed 2>/dev/null | tr -d '\r')" = "1" ] && break
    echo -n .; sleep 2
  done; echo
}

if [ -n "$1" ] && [ -n "${G[$1]}" ]; then
  id=${G[$1]%%|*}
  echo "Mở ${G[$1]#*|} ..."
  waydroid app launch "$id"
  echo "Nhìn cửa sổ Weston để chơi. Tắt: ./waydroid-run.sh stop"
else
  echo "Android ảo đã sẵn sàng. Chọn game:"
  for k in 1 2 3 4 5; do echo "  $k) ${G[$k]#*|}"; done
  echo "Chạy:  ./waydroid-run.sh <số>"
fi

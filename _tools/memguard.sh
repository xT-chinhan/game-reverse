#!/bin/bash
# cầu chì: RAM trống < 1200MB -> tắt Android ảo để máy không sập
while true; do
  a=$(awk '/MemAvailable/{print int($2/1024)}' /proc/meminfo)
  if [ "$a" -lt 1200 ]; then echo "$(date +%T) MemAvailable=${a}MB -> stop waydroid" >> /tmp/memguard.log; waydroid session stop; exit 0; fi
  sleep 2
done

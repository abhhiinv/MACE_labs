#!/bin/bash
# Log every login with timestamp
LOGFILE="$HOME/.login_log"
echo "[$(date)] LOGIN  — user=$USER, tty=$(tty), host=$(hostname)" >> "$LOGFILE"
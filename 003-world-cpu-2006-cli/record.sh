#!/usr/bin/env bash
set -e

APP="./wc2026.sh"

TYPE_DELAY=0.025
PAUSE_BEFORE_ENTER=0.8
PAUSE_AFTER_RUN=0.1
PAUSE_AFTER_TABLE=3.0

PROMPT="philip@canada-mini-host:~/tools$ "

type_text() {
  local text="$1"
  local i

  for ((i = 0; i < ${#text}; i++)); do
    printf "%s" "${text:i:1}"
    sleep "$TYPE_DELAY"
  done
}

format_cmd() {
  printf "%q " "$@"
}

run_cmd() {
  local rendered
  rendered="$(format_cmd "$@")"
  rendered="${rendered% }"

  echo
  printf "\033[1;32m%s\033[0m" "$PROMPT"
  type_text "$rendered"
  sleep "$PAUSE_BEFORE_ENTER"
  echo

  "$@"

  echo
  sleep "$PAUSE_AFTER_RUN"
}

say() {
  echo
  echo "============================================================"
  echo " $1"
  echo "============================================================"
  echo
}

show_group() {
  local group="$1"
  run_cmd "$APP" group "$group"
  sleep "$PAUSE_AFTER_TABLE"
}

record_match() {
  local group="$1"
  local home="$2"
  local away="$3"
  local score="$4"

  say "Record result: $home vs $away, score $score"
  run_cmd "$APP" record --home "$home" --away "$away" --score "$score"

  say "Updated Group $group standings"
  show_group "$group"
}

clear

say "FIFA World Cup 2026 CLI Demo"
run_cmd "$APP" --help

say "Show all World Cup groups"
run_cmd "$APP" groups
sleep "$PAUSE_AFTER_TABLE"

record_match "A" "MEX" "RSA" "2-0"

record_match "B" "QAT" "SUI" "1-1"

record_match "C" "BRA" "MAR" "1-1"
record_match "C" "HAI" "SCO" "0-1"

record_match "D" "USA" "PAR" "4-1"
record_match "D" "AUS" "TUR" "2-0"

record_match "E" "GER" "CUW" "7-1"
record_match "E" "CIV" "ECU" "1-0"

record_match "F" "NED" "JPN" "2-2"

say "Final group overview"
run_cmd "$APP" groups
sleep "$PAUSE_AFTER_TABLE"

say "Final detailed standings by group"


say "Global power ranking across all 48 teams"
run_cmd "$APP" rank

say "Demo completed"



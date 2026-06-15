#!/usr/bin/env bash
# ──────────────────────────────────────────────────────────────
#  wc2026 — FIFA World Cup 2026 CLI launcher
#
#  Usage:
#    ./wc2026.sh groups              Show all 12 groups
#    ./wc2026.sh group C             Show Group C detail
#    ./wc2026.sh record --home BRA --away MAR --score 3-1
#    ./wc2026.sh rank --top 10       Global rankings
#    ./wc2026.sh --help              Show help
# ──────────────────────────────────────────────────────────────
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAR_NAME="wc2026-cli-1.0.0-SNAPSHOT-jar-with-dependencies.jar"
JAR_PATH="${SCRIPT_DIR}/cli/target/${JAR_NAME}"

# ── Pre-flight checks ────────────────────────────────────────

if ! command -v java &>/dev/null; then
    echo "❌ Java is not installed. Please install Java 17+."
    exit 1
fi

# Auto-build if JAR doesn't exist
if [[ ! -f "${JAR_PATH}" ]]; then
    echo "🔨 Building wc2026-cli (first time only)..."
    mvn -f "${SCRIPT_DIR}/pom.xml" package -DskipTests -q 2>/dev/null
    if [[ ! -f "${JAR_PATH}" ]]; then
        echo "❌ Build failed. Run 'mvn package' manually to see errors."
        exit 1
    fi
    echo "✅ Build complete."
    echo ""
fi

# ── Launch ────────────────────────────────────────────────────

exec java \
    -Dorg.slf4j.simpleLogger.defaultLogLevel=off \
    -jar "${JAR_PATH}" \
    "$@"

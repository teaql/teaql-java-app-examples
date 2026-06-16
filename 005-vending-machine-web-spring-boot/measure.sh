#!/bin/bash
set -e

source /home/philip/.sdkman/bin/sdkman-init.sh
sdk install java 25.0.2-graalce < /dev/null || true
sdk use java 25.0.2-graalce

echo "Starting measurements..."

# Make sure we fail on error for builds
# set -e

extract_startup_time() {
    log_file=$1
    # Extracts the "Started ... in X.XXX seconds"
    grep "Started .* in .* seconds" "$log_file" | sed -n 's/.*in \([0-9.]*\) seconds.*/\1/p'
}

extract_max_mem() {
    time_file=$1
    # Extracts "Maximum resident set size (kbytes): XXXXX"
    grep "Maximum resident set size" "$time_file" | awk '{print $6}'
}

extract_build_time() {
    time_file=$1
    grep "Elapsed (wall clock) time" "$time_file" | awk '{print $8}'
}

#echo "=== 1. Standard JAR ==="
#echo "Building Standard JAR..."
#/usr/bin/time -v -o jar-build-time.txt mvn clean package -DskipTests > jar-build.log 2>&1
#echo "Running Standard JAR..."
#/usr/bin/time -v -o jar-run-time.txt java -jar target/vending-machine-service-0.0.1-SNAPSHOT.jar > jar-run.log 2>&1 &
#PID=$!
#while ! grep -q "Started .* in .* seconds" jar-run.log && ! grep -q "Application startup failed" jar-run.log; do
#    sleep 0.5
#    if ! kill -0 $PID 2>/dev/null; then break; fi
#done
#kill -TERM $PID 2>/dev/null
#wait $PID 2>/dev/null || true
#echo "JAR Max Mem (KB): $(extract_max_mem jar-run-time.txt)"
#echo "JAR Startup Time (s): $(extract_startup_time jar-run.log)"
#echo "JAR Build Time: $(extract_build_time jar-build-time.txt)"

echo "=== 2. Native Image (Release) ==="
echo "Building Native Release..."
/usr/bin/time -v -o native-release-build-time.txt mvn clean native:compile -Pnative -DskipTests > native-release-build.log 2>&1
echo "Running Native Release..."
if [ -f "target/vending-machine-service" ]; then
    /usr/bin/time -v -o native-release-run-time.txt ./target/vending-machine-service > native-release-run.log 2>&1 &
    PID=$!
    while ! grep -q "Started .* in .* seconds" native-release-run.log && ! grep -q "Application startup failed" native-release-run.log; do
        sleep 0.5
        if ! kill -0 $PID 2>/dev/null; then break; fi
    done
    kill -TERM $PID 2>/dev/null
    wait $PID 2>/dev/null || true
    echo "Native Release Max Mem (KB): $(extract_max_mem native-release-run-time.txt)"
    echo "Native Release Startup Time (s): $(extract_startup_time native-release-run.log)"
    echo "Native Release Build Time: $(extract_build_time native-release-build-time.txt)"
else
    echo "Native release build failed!"
    tail -n 20 native-release-build.log
fi

echo "=== 3. Native Image (Debug) ==="
echo "Building Native Debug..."
/usr/bin/time -v -o native-debug-build-time.txt mvn clean native:compile -Pnative,native-debug -DskipTests > native-debug-build.log 2>&1
echo "Running Native Debug..."
if [ -f "target/vending-machine-service" ]; then
    /usr/bin/time -v -o native-debug-run-time.txt ./target/vending-machine-service > native-debug-run.log 2>&1 &
    PID=$!
    while ! grep -q "Started .* in .* seconds" native-debug-run.log && ! grep -q "Application startup failed" native-debug-run.log; do
        sleep 0.5
        if ! kill -0 $PID 2>/dev/null; then break; fi
    done
    kill -TERM $PID 2>/dev/null
    wait $PID 2>/dev/null || true
    echo "Native Debug Max Mem (KB): $(extract_max_mem native-debug-run-time.txt)"
    echo "Native Debug Startup Time (s): $(extract_startup_time native-debug-run.log)"
    echo "Native Debug Build Time: $(extract_build_time native-debug-build-time.txt)"
else
    echo "Native debug build failed!"
    tail -n 20 native-debug-build.log
fi

echo "All Done!"

@echo off
echo =========================================
echo    DEXTER BENCHMARKING FRAMEWORK
echo         Build and Launch Script
echo =========================================
echo.

echo [1/3] Cleaning previous builds...
if exist bin\gui\DexterBenchmarkGUI*.class (
    del /q bin\gui\DexterBenchmarkGUI*.class
    echo      Cleaned old GUI classes
) else (
    echo      No old classes to clean
)
echo.

echo [2/3] Compiling DEXTER Benchmark GUI ULTIMATE...
javac -d bin -cp bin src\main\java\gui\DexterBenchmarkGUI_ULTIMATE.java

if %ERRORLEVEL% EQU 0 (
    echo      Compilation successful!
) else (
    echo      Compilation failed!
    echo     Please check your Java code for errors.
    pause
    exit /b 1
)
echo.

echo [3/3] Launching DEXTER Benchmark GUI ULTIMATE...
echo      Starting performance testing suite...
echo.
start "DEXTER Benchmarking Framework" java -cp bin gui.DexterBenchmarkGUI_ULTIMATE

echo =========================================
echo    DEXTER GUI launched successfully!
echo    Ready for performance testing!
echo =========================================
echo.
echo Press any key to close this window...
pause >nul

@echo off
echo =========================================
echo    DEXTER BENCHMARKING FRAMEWORK
echo         Test and Launch Script
echo =========================================
echo.

echo [1/3] Cleaning previous test outputs...
if exist bin\tests\Test.class (
    del /q bin\tests\Test.class
    echo      Cleaned old test classes
) else (
    echo      No old test classes to clean
)
echo.

echo [2/3] Compiling Test.java...
javac -d bin -cp bin src\main\java\tests\Test.java

if %ERRORLEVEL% EQU 0 (
    echo      Compilation successful!
) else (
    echo      Compilation failed!
    echo      Please check your Java test code for errors.
    exit /b 1
)
echo.

echo [3/3] Running Test...
echo      Executing test cases in terminal...
echo.
echo =========================================
echo    DEXTER TEST OUTPUT:
echo =========================================
java -cp bin tests.Test
echo.
echo =========================================
echo    Test execution completed!
echo =========================================

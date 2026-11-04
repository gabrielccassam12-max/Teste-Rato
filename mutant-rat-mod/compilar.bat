@echo off
rem Compila o mod e abre a pasta com o .jar pronto.
rem Precisa do Java 21 instalado (https://adoptium.net -> Temurin 21 LTS).
cd /d "%~dp0"
call gradlew.bat build
if errorlevel 1 (
  echo.
  echo Deu erro na compilacao. Copie a mensagem acima e mande pro Claude.
  pause
  exit /b 1
)
echo.
echo Pronto! O mod esta em build\libs\mutant-rat-1.0.0.jar
explorer build\libs
pause

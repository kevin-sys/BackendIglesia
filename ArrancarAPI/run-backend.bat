@echo off
echo.
echo ******************************************************
echo *        Bienvenido(a) a GODCHURCH Backend            *
echo *        Realizado por Kevin Gomez Cantillo 2023      *
echo ******************************************************
echo.

:menu
echo Menu de opciones:
echo.
echo 1. Iniciar la aplicacion Spring Boot
echo 2. Iniciar las pruebas de Spring Boot
echo 3. Salir

set /p option="Que deseas hacer: "

if "%option%"=="1" (
    echo.
    echo Iniciando la aplicacion Spring Boot...
    echo.

    cd "C:\Users\pc\Documents\2023-I\PROCESOS_DE_SOFT_PRAC_AGIL\Primer_Corte\Backend"
    call mvnw spring-boot:run

    echo.
    echo La aplicacion Spring Boot se ha ejecutado exitosamente.
    echo.
    pause
    goto menu
)
if "%option%"=="2" (
    echo.
    echo Iniciando Testing en Spring Boot...
    echo.

    cd "C:\Users\pc\Documents\2023-I\PROCESOS_DE_SOFT_PRAC_AGIL\Primer_Corte\Backend"
    call mvnw test

    echo.
    echo Las pruebas en Spring Boot se han ejecutado exitosamente.
    echo.
    pause
    goto menu
)
if "%option%"=="3" (
    echo.
    echo Gracias por usar GODCHURCH Backend, Hasta luego
    echo.
    pause
) else (
    echo.
    echo Opcion invalida. Por favor, ingrese una opcion valida.
    echo.
    goto menu
)

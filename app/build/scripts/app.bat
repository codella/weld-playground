@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  app startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and APP_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\app.jar;%APP_HOME%\lib\guava-32.1.3-jre.jar;%APP_HOME%\lib\weld-se-core-6.0.0.Beta1.jar;%APP_HOME%\lib\smallrye-config-3.7.1.jar;%APP_HOME%\lib\flogger-system-backend-0.8.jar;%APP_HOME%\lib\flogger-0.8.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.37.0.jar;%APP_HOME%\lib\error_prone_annotations-2.21.1.jar;%APP_HOME%\lib\weld-environment-common-6.0.0.Beta1.jar;%APP_HOME%\lib\weld-lite-extension-translator-6.0.0.Beta1.jar;%APP_HOME%\lib\weld-core-impl-6.0.0.Beta1.jar;%APP_HOME%\lib\weld-spi-6.0.Beta2.jar;%APP_HOME%\lib\weld-api-6.0.Beta2.jar;%APP_HOME%\lib\jakarta.enterprise.cdi-el-api-4.1.0.Beta1.jar;%APP_HOME%\lib\jakarta.enterprise.cdi-api-4.1.0.Beta1.jar;%APP_HOME%\lib\jboss-classfilewriter-1.3.0.Final.jar;%APP_HOME%\lib\smallrye-config-core-3.7.1.jar;%APP_HOME%\lib\smallrye-common-expression-2.2.0.jar;%APP_HOME%\lib\smallrye-common-function-2.2.0.jar;%APP_HOME%\lib\smallrye-common-constraint-2.2.0.jar;%APP_HOME%\lib\smallrye-config-common-3.7.1.jar;%APP_HOME%\lib\jboss-logging-3.5.0.Final.jar;%APP_HOME%\lib\checker-compat-qual-2.5.3.jar;%APP_HOME%\lib\jakarta.interceptor-api-2.2.0-RC1.jar;%APP_HOME%\lib\jboss-logging-processor-2.2.1.Final.jar;%APP_HOME%\lib\jakarta.enterprise.lang-model-4.1.0.Beta1.jar;%APP_HOME%\lib\jakarta.annotation-api-3.0.0-M1.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.1.jar;%APP_HOME%\lib\microprofile-config-api-3.1.jar;%APP_HOME%\lib\smallrye-common-annotation-2.2.0.jar;%APP_HOME%\lib\smallrye-common-classloader-2.2.0.jar;%APP_HOME%\lib\asm-9.6.jar;%APP_HOME%\lib\jakarta.el-api-5.0.1.jar;%APP_HOME%\lib\jboss-logging-annotations-2.2.1.Final.jar;%APP_HOME%\lib\jdeparser-2.0.3.Final.jar


@rem Execute app
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %APP_OPTS%  -classpath "%CLASSPATH%" org.jboss.weld.environment.se.StartMain %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable APP_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%APP_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
@IF "%DEBUG%" == "" ECHO OFF
@SET DIR=%~dp0
@SET APP_BASE_NAME=%~n0
@SET APP_HOME=%DIR%
@SET CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar
@SET JAVA_EXE=java

"%JAVA_EXE%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

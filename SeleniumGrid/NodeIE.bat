cd /d%~dp0
java -jar selenium-server-standalone-2.48.2.jar -role node -hub http://localhost:4444/grid/register -Dwebdriver.ie.driver=IEDriverServer.exe

pause 1000
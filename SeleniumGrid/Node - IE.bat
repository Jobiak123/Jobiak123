cd /d%~dp0
java -jar selenium-server-standalone-2.43.1.jar -role node -hub http://localhost:4444/grid/register -Dwebdriver.ie.driver=IEDriverServer.exe -nodeConfig NodeConfig.json

pause 1000
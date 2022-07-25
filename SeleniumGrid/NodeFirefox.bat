cd /d%~dp0
java -jar selenium-server-standalone-2.48.2.jar -role node -hub http://localhost:4444/grid/register -port 5570 -browser browserName=firefox

pause 1500
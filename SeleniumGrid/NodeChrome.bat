cd /d%~dp0
java -jar selenium-server-standalone-2.48.2.jar -role node -hub http://localhost:4444/grid/register -Dwebdriver.chrome.driver=chromedriver.exe -port 5566 -browser browserName=chrome,maxInstances=5

pause 1000
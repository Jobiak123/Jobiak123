cd /d%~dp0
java -jar selenium-server-standalone-2.43.1.jar -role node -hub http://localhost:4444/grid/register -Dwebdriver.chrome.driver=chromedriver.exe -port 5566 -browser browserName=chrome,maxInstances=5 -nodeConfig NodeConfig.json 

pause 1000
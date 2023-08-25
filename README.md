# github-automation-test

Java WebDriver test automation project for GitHub

Commands:
mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml -Denvironment=dev clean test
mvn -Dbrowser=edge -Dsurefire.suiteXmlFiles=src/test/resources/testng-all.xml -Denvironment=dev clean test
mvn -Dbrowser=firefox -Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml -Denvironment=dev clean test
mvn -Dbrowser=safari -Dsurefire.suiteXmlFiles=src/test/resources/testng-all.xml -Denvironment=dev clean test

Jenkins:
Open: jenkins --enable-future-java
Close: control+c

mvn clean verify verify serenity:aggregate -Dcontext=chrome -Dwebdriver.driver=chrome -f pom.xml
open ./target/site/serenity/index.html

## Practical Modern Java

ch09 compile
> javac --module-source-path ./src/ch09 --module com.siva.first -d ./bin

ch09 run
> java --module-path ./bin --module com.siva.first/test.FirstModule
> java --module-path ./bin --module com.siva.first/dao.PingDB

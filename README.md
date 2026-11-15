# Сайт на Tomcat

Установите JDK 22. В переменных среды Windows задайте `JAVA_HOME` — папку JDK, а в `Path` добавьте `%JAVA_HOME%\bin`.
Затем откройте PowerShell в папке проекта. Maven загрузится автоматически; первый запуск требует интернета.

Установка зависимостей и сборка:

```powershell
.\mvnw.cmd package
```

Запуск встроенного Tomcat:

```powershell
.\mvnw.cmd exec:java
```

Открыть [http://localhost:8080/my-site/](http://localhost:8080/my-site/). Остановка — `Ctrl+C`.

Для запуска на установленном Tomcat 10.1 скопировать `target/06-tomcat-site-1.0-SNAPSHOT.war` в его папку `webapps` под
именем `my-site.war` и запустить сервер.

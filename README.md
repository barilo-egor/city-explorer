Java: 11 <br/>
JDK: 11 <br/>
mysql-server </br>
linux </br>
<hr/>
1. Клонировать проект. </br>
2. Заменить след. проперти:</br>
<ul>
  <li>Порт, на котором будет запущен бот. </br>
  <b><i>project-directory</i>/city-explorer-bot/src/resources/bot.properties</b></br>
  <code>server.port</code></br>
  <li>Там же уже установлены токен и логин бота.</br>
  <code>bot.username=citytestreslivbot</code></br>
  <code>bot.token=1788643410:AAEqwpGV5IpuyaD74ExcguGNOB-O44Fh0nE</code></br>
  <li>Порт, на котором будет запущен веб сервис. </br>
  <b><i>project-directory</i>/city-explorer-restweb/src/resources/restweb.properties</b></br>
  <code>server.port</code></br>
  <li>Логин и пароль пользователя MySQL. </br>
  <b><i>project-directory</i>/city-explorer-core/src/resources/application.properties</b></br>
  <code>spring.datasource.username</code></br>
  <code>spring.datasource.password</code></br>
</ul>
3. Сделать <code>mvn package</code> главного модуля(city-explorer). </br>
4. Запустить бот и веб-сервис: </br>
    Команда для запуска бота для linux (из директории с jar файлом) - <code>java -jar city-explorer-bot-1.0-exec.jar</code> </br>
    Команда для запуска веб-сервиса для linux (из директории с jar файлом) - <code>java -jar city-explorer-restweb-1.0-exec.jar</code> </br>
    Пути к jar файлам: </br>
<ul>
  <li><b><i>project-directory</i>/city-explorer-bot/target/city-explorer-bot-1.0-exec.jar</b></br>
  <li><b><i>project-directory</i>/city-explorer-restweb/target/city-explorer-restweb-1.0-exec.jar</b></br>
</ul>

Веб сервис будет доступен по адресу <code>http://localhost:PORT/</code> </br>
Бот будет доступен по логину @citytestreslivbot - <a href="https://t.me/citytestreslivbot">link</a>

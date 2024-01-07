#### Основные технологии:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring%20BOOT-43B02A.svg?&style=for-the-badge&logo=spring&logoColor=white)
![Selenium](https://img.shields.io/badge/selenium-43B02A.svg?&style=for-the-badge&logo=selenium&logoColor=white)
![Docker](https://img.shields.io/badge/docker-blue.svg?&style=for-the-badge&logo=docker&logoColor=white)
![Google-Sheets](https://img.shields.io/badge/GOOGLE%20SHEETS-43B02A.svg?&style=for-the-badge&logo=google%20SHEETS&logoColor=white)

---

#### Мотивация проекта:

Собрать статистику заполненности спортивных залов, чтобы выбрать наилучшее время посещения, когда зал относительно
свободен.  
Данные берутся с сайтов фитнес-клубов, но поскольку информация о кол-ве посетителей подгружается динамически, уже после
загрузки страниц, нет возможно парсить стандартными способами, поэтому используется Selenium.

#### Запуск проекта:

Образ рабочего приложения загружен на docker-hub, для запуска можно использовать `docker-compose.yml` внутри проекта.
Либо запустить проект через idea. Также внутри проекта есть `Dockerfile` для сборки контейнера.

При запуске обратить внимание на переменные в `application.yaml`.

#### Автор проекта:  [Grishuchkov Danila](https://github.com/grishuchkov)


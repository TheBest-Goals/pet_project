# 🛒 Roblox Digital Store — Backend API

RESTful API сервис для маркетплейса цифровых товаров Roblox (Робуксы, геймпассы, предметы, аккаунты). Проект реализован на архитектуре Spring Boot с автоматической миграцией базы данных и контейнеризацией.

🔗 **Frontend репозиторий:** [pet_project_frontend](https://github.com/TheBest-Goals/pet_project_frontend)

---

## 🛠 Технологический стек

- **Language:** Java 17+
- **Framework:** Spring Boot 3 (Spring Data JPA, Spring Security, Spring Web)
- **API Documentation:** Swagger UI / OpenAPI 3
- **Authentication:** JWT (JSON Web Tokens)
- **Database:** PostgreSQL
- **Database Migration:** Flyway
- **Containerization:** Docker & Docker Compose
- **Testing:** JUnit 5, Mockito

---

## 📖 Интерактивная документация API (Swagger)

После локального запуска бэкенда интерактивная документация эндпоинтов и возможность их тестирования доступны по адресу:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

---

## 🚀 Основные возможности

- 🔐 **Аутентификация и авторизация:** Регистрация, вход, генерация и валидация JWT-токенов, разделение прав доступа (пользователь / администратор).
- 📦 **Управление товарами:** CRUD-операции над товарами каталога (цена, доступность, описание).
- 🛒 **Система заказов:** Обработка покупных транзакций и проверка наличия товаров на складе.
- 🛡 **Безопасность и обработка ошибок:** Кастомный `GlobalExceptionHandler` и валидация входящих DTO.
- 🗄 **Автоматические миграции:** Схемы таблиц накатываются автоматически через Flyway при запуске приложения.

---

## 💻 Локальный запуск

### Предварительные требования
- Installed [Docker Desktop](https://www.docker.com/)
- JDK 17+

### Инструкция по запуску

1. **Клонируйте репозиторий:**
   ```bash
   git clone [https://github.com/TheBest-Goals/pet_project.git](https://github.com/TheBest-Goals/pet_project.git)
   cd pet_project

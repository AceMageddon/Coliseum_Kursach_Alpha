# Coliseum

A turn-based gladiator arena game for the desktop, built with Java, JavaFX and Spring Boot. Player accounts and progress are stored in PostgreSQL. University course project, 2021 (курсовая работа).

<!-- Screenshot: add docs/screenshot.png and embed it here -->

## The game

- **Accounts.** Register with an email address and confirm it with a one-time code sent by email, then name your gladiator. Log in later, or reset a forgotten password with another emailed code.
- **Hub.** Go into battle, upgrade your gear (armour, healing gourd, shield), or check the list of champions.
- **Turn-based combat.** On your turn, attack, block, drink from the healing gourd or unleash fire, and choose where to strike: head, body, either arm or either leg. Each enemy gets random weak limbs, and hint lines can give them away ("Is their right arm shaking a little?"). Enemy health and damage scale with your level.

## How it's built

One desktop process runs JavaFX and Spring Boot together:

- `DemoApplication` extends `javafx.application.Application` and starts the Spring context in `init()`. FXML views are loaded with `fxmlLoader.setControllerFactory(springContext::getBean)`, so the JavaFX controllers are Spring beans with dependency injection.
- Persistence uses Spring Data JPA on PostgreSQL. There is an entity, repository and service for each of `Player`, `Enemy`, `Info` (hint texts), `Memory` (level, high score and battle state) and `Safeplayer` (the player's upgraded base stats, used to restore them after a fight).
- `SendEmailService` (Spring Mail) sends the registration and password-reset codes generated in `hub/Menu`.
- There are 18 FXML views in [`src/main/resources/fxml`](src/main/resources/fxml): login, registration and code entry, password reset, hub, upgrades, the player's and the opponent's turns, results and the leaderboard.
- [`SQL/`](SQL) holds sample table data as CSV (enemies, hint texts, progress, players with placeholder accounts).

## Run

You need JDK 15+, Maven, PostgreSQL and the JavaFX SDK (the project was built with 15.0.1).

1. Create a PostgreSQL database named `coliseumstats`. Tables are created on start (`spring.jpa.hibernate.ddl-auto=update`), and `SQL/` has sample data to import.
2. Set the environment variables listed in [`application.properties.example`](src/main/resources/application.properties.example): `DB_USERNAME` and `DB_PASSWORD`, plus `MAIL_USERNAME` and `MAIL_PASSWORD` for the email codes (Gmail requires an App Password).
3. Run `com.example.demo.DemoApplication` from your IDE with the VM options `--module-path <path-to-javafx-sdk>/lib --add-modules javafx.controls,javafx.fxml`.

## Known limitations

This is a 2021 student project. Passwords are stored in plain text, and game state lives in static fields (`data/Data`) rather than in objects passed between controllers.

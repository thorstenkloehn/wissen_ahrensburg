# Projektübersicht: Wissen Ahrensburg

"Wissen Ahrensburg" ist ein Android-basiertes Open-Source-Wissendatenbank-Projekt, das der Stadt Ahrensburg gewidmet ist. Die Anwendung wird mit modernen Android-Entwicklungspraktiken erstellt, wobei der Schwerpunkt auf Kotlin und Jetpack Compose liegt.

## Schlüsseltechnologien
- **Sprache:** Kotlin 2.2.10
- **UI-Framework:** Jetpack Compose mit Material Design 3
- **Build-System:** Gradle (Kotlin DSL) mit Version Catalogs (`libs.versions.toml`)
- **Minimale SDK:** 24 (Android 7.0)
- **Ziel-SDK (Target SDK):** 36

## Architektur
Das Projekt folgt einer standardmäßigen Android-Einzelmodulstruktur:
- `app/src/main/java/de/wissenahrensburg/wissen_ahrensburg/`: Enthält den Hauptquellcode.
  - `MainActivity.kt`: Der Haupteinstiegspunkt, verwaltet den State der Wissendatenbank (`wissenobjekt`) und die Haupt-UI.
  - `Logo.kt`: Enthält das `AhrensburgLogo`, eine mit `Canvas` gezeichnete Komponente (Schloss + Buch).
  - `model/Wissendatenbank.kt`: Datenklasse für Einträge (Titel, Beschreibung, Adresse).
  - `model/WissenLoader.kt`: Hilfsklasse zum Einladen und Parsen der CSV-Daten.
  - `ui/theme/`: Material 3 Design-System (Farben, Typografie).
- `app/src/main/res/raw/`: Enthält Rohdatenressourcen.
  - `wissen_datenbank.csv`: Die primäre Datenquelle mit Informationen über Sehenswürdigkeiten und Orte in Ahrensburg.

## Features & UI-Komponenten
- **AhrensburgLogo:** Custom Canvas-Zeichnung des Schlosses.
- **WissenCard:** Material 3 Card zur Darstellung der Einträge mit Standort-Icon.
- **Daten-Loading:** Automatisches Laden der CSV-Daten via `LaunchedEffect`.
- **Lazy List:** Performante Anzeige der Einträge mittels `LazyColumn`.

## Bauen und Ausführen

### Voraussetzungen
- Android SDK
- JDK 11 (wie in `compileOptions` konfiguriert)

### Wichtige Befehle
- **Debug-APK erstellen:** `./gradlew assembleDebug`
- **Auf Gerät/Emulator installieren:** `./gradlew installDebug`
- **Unit-Tests ausführen:** `./gradlew test`
- **Instrumentierte Tests ausführen:** `./gradlew connectedAndroidTest`
- **Projekt bereinigen:** `./gradlew clean`

## Entwicklungskonventionen
- **UI:** Verwenden Sie Jetpack Compose für alle neuen UI-Komponenten. Folgen Sie den Material 3 Richtlinien.
- **Theme:** Nutzen Sie das in `ui/theme/Theme.kt` definierte Theme für ein konsistentes Styling.
- **Abhängigkeiten:** Verwalten Sie alle Abhängigkeiten über die Datei `gradle/libs.versions.toml`.
- **Ressourcen:** Standardmäßige Android-Ressourcen befinden sich in `app/src/main/res/`.
- **Testen:** 
  - Unit-Tests: `app/src/test/`
  - Instrumentierte Tests: `app/src/androidTest/`

## Projektstatus
- **UI:** Die Anwendung verfügt über eine Landing-Page mit Logo und einer scrollbaren Liste (`LazyColumn`), die die Wissenseinträge in Karten (`WissenCard`) darstellt.
- **Daten:** Das Datenmodell (`Wissendatenbank`) ist implementiert. Der `WissenLoader` lädt die Daten erfolgreich aus der `wissen_datenbank.csv`.
- **Nächste Schritte:** Implementierung einer Detailansicht für die Einträge und Suchfunktion.

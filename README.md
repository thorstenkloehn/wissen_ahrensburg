# Wissen Ahrensburg

"Wissen Ahrensburg" ist ein Android-basiertes Open-Source-Wissendatenbank-Projekt, das der Stadt Ahrensburg gewidmet ist. Die Anwendung nutzt moderne Android-Entwicklungspraktiken mit einem Fokus auf Kotlin und Jetpack Compose.

## 🚀 Technologien

- **Sprache:** [Kotlin](https://kotlinlang.org/) 2.2.10
- **UI-Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) mit Material Design 3
- **Build-System:** Gradle (Kotlin DSL) mit Version Catalogs (`libs.versions.toml`)
- **Minimale SDK:** 24 (Android 7.0)
- **Ziel-SDK (Target SDK):** 36

## 🏗 Architektur

Das Projekt folgt einer standardmäßigen Android-Einzelmodulstruktur:

- `app/src/main/java/de/wissenahrensburg/wissen_ahrensburg/`: Hauptquellcode.
  - `MainActivity.kt`: Haupteinstiegspunkt der App.
  - `Logo.kt`: Benutzerdefinierte UI-Komponenten (z. B. das `AhrensburgLogo`, gezeichnet mit Compose Canvas).
  - `ui/theme/`: Material 3 Theme-Definitionen (Farben, Typografie, Themes).

## 🛠 Bauen und Ausführen

### Voraussetzungen
- Android SDK
- JDK 11 (wie in `compileOptions` konfiguriert)

### Wichtige Befehle
- **Debug-APK erstellen:** `./gradlew assembleDebug`
- **Auf Gerät/Emulator installieren:** `./gradlew installDebug`
- **Unit-Tests ausführen:** `./gradlew test`
- **Instrumentierte Tests ausführen:** `./gradlew connectedAndroidTest`
- **Projekt bereinigen:** `./gradlew clean`

## 📝 Entwicklungskonventionen

- **UI:** Verwenden Sie Jetpack Compose für alle neuen UI-Komponenten. Folgen Sie den Material 3 Richtlinien.
- **Theme:** Nutzen Sie das in `ui/theme/Theme.kt` definierte Theme für ein konsistentes Styling.
- **Abhängigkeiten:** Verwalten Sie alle Abhängigkeiten über die Datei `gradle/libs.versions.toml`.
- **Ressourcen:** Standardmäßige Android-Ressourcen befinden sich in `app/src/main/res/`.
- **Testen:**
  - Unit-Tests befinden sich unter `app/src/test/`.
  - Instrumentierte Tests befinden sich unter `app/src/androidTest/`.

## 📈 Projektstatus

Das Projekt verfügt derzeit über eine Landing-Page mit einem benutzerdefinierten Logo. Dieses stellt das Ahrensburger Schloss und ein symbolisches Buch dar, was den Zweck als Wissensdatenbank unterstreicht.

## 📄 Lizenz

Dieses Projekt ist Open Source. (Bitte fügen Sie hier bei Bedarf spezifische Lizenzinformationen hinzu, z. B. MIT oder Apache 2.0).

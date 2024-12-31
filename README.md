# MemoryCardGame
Ich erstelle mit Java ein Memory Card Game

![Spielstartschirm](/MatchCards/src/img/image.png)



## Beschreibung

**MemoryCardGame** ist ein spannendes Memory-Spiel, entwickelt mit Java. Dein Ziel ist es, so viele passende Kartenpaare wie möglich zu finden, indem du dir ihre Position merkst und geschickt auswählst.

## Features

- **MemoryGame**: Spiele alleine und versuche, alle Paare zu finden.
- **Benutzerfreundliche Oberfläche**: Einfaches und übersichtliches Design mit klar strukturiertem Spielfeld.
- **Punktesystem**: Verfolge die Anzahl der gemachten Fehler.
- **Spielstand zurücksetzen**: Starte jederzeit ein neues Spiel mit einem Klick auf den "Restart Game"-Button.
- **Attraktive Grafiken**: Pokemon Energiekarten können jederzeit durch Bilder eurer Wahl ersetzt werden.

## Installation

### Voraussetzungen

- **Java Development Kit (JDK)**: Stelle sicher, dass Java auf deinem Computer installiert ist. Du kannst das JDK [hier](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) herunterladen.
- **IDE (optional)**: Eine integrierte Entwicklungsumgebung wie **Visual Studio Code** oder **IntelliJ IDEA** erleichtert das Arbeiten am Projekt.

### Schritte

1. **Repository klonen**:
    ```bash
    git clone https://github.com/NotAisu/MemoryCardGame.git
    ```

2. **Projektstruktur**:
    ```
    MemoryCardGame/
    ├── src/
    │   ├── App.java
    │   ├── MatchCards.java
    │   ├── game/
    │   │   └── GameLogic.java
    │   └── model/
    │       └── Card.java
    ├── img/
    │   ├── back.jpg
    │   ├── darkness.jpg
    │   ├── double.jpg
    │   ├── fairy.jpg
    │   ├── fighting.jpg
    │   ├── fire.jpg
    │   ├── grass.jpg
    │   ├── lightning.jpg
    │   ├── metal.jpg
    │   ├── psychic.jpg
    │   └── water.jpg
    ├── bin/
    └── README.md
    ```

3. **Kompilieren und Ausführen**:
    Navigiere zum `src`-Verzeichnis und kompiliere die `.java`-Dateien:
    ```bash
    cd src
    javac App.java game/GameLogic.java model/Card.java
    ```
    Starte das Spiel:
    ```bash
    java App
    ```

## Nutzung

1. **Spiel starten**: Führe das Programm aus, um das Spiel zu starten.
2. **Spiel spielen**: Klicke auf zwei Karten, um sie aufzudecken. Wenn sie übereinstimmen, bleiben sie aufgedeckt; andernfalls werden sie wieder verdeckt.
3. **Punkte und Fehler verfolgen**: Die Anzahl der Fehler wird oben angezeigt.
4. **Spiel neu starten**: Starte das Spiel jederzeit mit dem "Restart Game"-Button neu.

## Herausforderungen

Während der Entwicklung von **MemoryCardGame** bin ich auf einige Herausforderungen gestoßen:

1. **Bildpfade und Ressourcen laden**

2. **Initialisierung der Karten-Buttons**

3. **Benutzerinteraktion und Spiellogik**

4. **Benutzeroberfläche und Layout**:

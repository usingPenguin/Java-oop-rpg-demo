# Java OOP RPG Demo

Ein kleines Java-Projekt zur Veranschaulichung grundlegender Konzepte der objektorientierten Programmierung.

Dieses einfache Beispiel ist entstanden, als ich einem Kommilitonen verschiedene Java-OOP-Themen erklärt habe. Aus einzelnen Beispielen zu Klassen, Vererbung, abstrakten Klassen, Interfaces und `ArrayList`s hat sich daraus ein kleines textbasiertes RPG-Kampfsystem entwickelt.

## Ziel des Projekts

Das Projekt soll zeigen, wie man typische OOP-Konzepte in Java praktisch anwenden kann:

- Klassen und Objekte
- Konstruktoren
- Vererbung mit `extends`
- abstrakte Klassen
- Interfaces mit `implements`
- `static` Felder und Methoden
- `ArrayList`
- Enums
- einfache Spiellogik
- zufällige Ereignisse mit `Random`

## Projektidee

Der Spieler kämpft sich durch eines von 3 Level. Jedes Level enthält verschiedene Gegner, zum Beispiel Goblins oder Hexen.

Gegner erben von einer abstrakten Oberklasse `Enemy`. Bestimmte Gegner können zusätzliche Fähigkeiten besitzen, indem sie Interfaces implementieren, zum Beispiel:

```java
public interface Healable {
    void heal(double amount);
}

## TODO

- [ ] Code mit JavaDoc dokumentieren
- [ ] README mit Klassendiagramm erweitern
- [ ] Weitere Gegnertypen hinzufügen
- [ ] Weitere Fähigkeiten/Interfaces ergänzen
- [ ] Balancing der Gegnerwerte verbessern
- [ ] Tests für zentrale Spiellogik schreiben
- [ ] Konsolenausgaben einheitlicher gestalten

# Aufgabe 1)
Die Beschreibung eines Desing Patterns besteht meistens aus den Beschreiungen des gelösten Problems, der Lösung und der Konsequenzen bzw. Folgen.   
Die Beschreibung des gelösten Problems besagt, was das Problem war, was gelöst wurde, warum das gemacht wurde und wann man es anwenden sollte.  
Die Beschreibung beihaltet, auf was alles eingewirkt wird und wie und eine empfohlene Struktur.  
Die Beschreibung der Konsequenzen beinhaltet Vor- und Nachteile der Anwendung und mögliche Seiteneffekte, die eintreten können, sollte man das Muster benutzen.
 # Aufgabe 2)
Antipatterns sind Beispiele, wie man etwas NICHT designen sollte.  
Beispiele:  
God-Objekt -> Das Objekt hat zu viele unkategorisierte Methoden bzw. stellt nicht mehr eine spezifische Art einer Sache oder eine direkte Sache dar.   
Objekt-Orgy -> Das Objekt ist nicht genug eingekapselt und kan z.B. von überall aus aufgerufen werden -> führt zu unübersichtlichkeit und vielen undurchsichtigen Fehlern.  
Big-ball-of-mud -> Ein System, das keine wahrnehmbare Struktur hat und alles durcheinander ist z.B. Wenn ein ganzes Projekt in nur einer Datei geschrieben wird mit einer Klasse.
# Aufgabe 3)
Ein Singleton ist etwas was es nur einmal geben soll -> 
Hierbei schreibt man eine Klasse mit privatem Konstruktor, welcher von einer statischen variable aufgerufen wird oder man macht einen globalen zugriff auf eine statische Klassenmethode.  
Vorteile: Einfach umzusetzen  
Nachteile: Wird oft zu sorglos aufgerufen, erschwert Testen   

# Aufgabe 4)
Das Decorator Pattern wird verwendet.
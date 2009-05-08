import com.brysonian.*;

Parrot parrot;

void setup() {
  parrot = new Parrot();
  String[] voices = parrot.availableVoices();
  println(voices);
}

void draw() {
  
}

void mousePressed() {
  parrot.speak("Hello there!");
}


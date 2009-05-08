import com.brysonian.*;

Parrot parrot;

void setup() {
  parrot = new Parrot();
}

void draw() {
  
}

void mousePressed() {
  int voiceCount = parrot.availableVoices().length;
  int voiceIndex = floor(random(0, voiceCount));
  parrot.setVoice(voiceIndex);
  parrot.speak("Hello there!");
}
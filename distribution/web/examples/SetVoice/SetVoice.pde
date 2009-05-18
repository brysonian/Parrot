import com.repetitionrepetition.*;

Parrot parrot;

void setup() {
  // use the name of the voice
  // you can also use the index of the voice (found using parrot.availableVoices())
  // or the voice name constants Parrot.GOODNEWS
  parrot = new Parrot("GOODNEWS");
  
}

void draw() {
  
}

void mousePressed() {
  parrot.speak("Hello there!");
}

void keyPressed() {
 // set the voice
 parrot.setVoice(Parrot.BADNEWS); 
  
}
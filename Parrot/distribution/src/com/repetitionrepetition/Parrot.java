/*
  Simple wrapper to interface with Apple's text-to-speech classes
  
  (c) copyright
  
  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public
  License as published by the Free Software Foundation; either
  version 2.1 of the License, or (at your option) any later version.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General
  Public License along with this library; if not, write to the
  Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA  02111-1307  USA
 */

package com.repetitionrepetition;


import java.util.HashMap;

import processing.core.PApplet;
import com.apple.cocoa.application.NSSpeechSynthesizer;
import com.apple.cocoa.foundation.*;


/**
 * This is a simple class to wrap the features of NSSpeechSynthesizer
 *  
 * @author Chandler McWilliams
 * 
 */
public class Parrot {

	protected String[] voices = {
			"AGNES",
			"ALBERT",
			"ALEX",
			"BADNEWS",
			"BAHH",
			"BELLS",
			"BOING",
			"BRUCE",
			"BUBBLES",
			"CELLOS",
			"DERANGED",
			"FRED",
			"GOODNEWS",
			"HYSTERICAL",
			"JUNIOR",
			"KATHY",
			"ORGAN",
			"PRINCESS",
			"RALPH",
			"TRINOIDS",
			"VICKI",
			"VICTORIA",
			"WHISPER",
			"ZARVOX"};
	
	public static final String AGNES 		= "AGNES";
	public static final String ALBERT 		= "ALBERT";
	public static final String ALEX 		= "ALEX";
	public static final String BADNEWS 		= "BADNEWS";
	public static final String BAHH 		= "BAHH";
	public static final String BELLS 		= "BELLS";
	public static final String BOING 		= "BOING";
	public static final String BRUCE 		= "BRUCE";
	public static final String BUBBLES 		= "BUBBLES";
	public static final String CELLOS 		= "CELLOS";
	public static final String DERANGED 	= "DERANGED";
	public static final String FRED 		= "FRED";
	public static final String GOODNEWS 	= "GOODNEWS";
	public static final String HYSTERICAL 	= "HYSTERICAL";
	public static final String JUNIOR 		= "JUNIOR";
	public static final String KATHY 		= "KATHY";
	public static final String ORGAN 		= "ORGAN";
	public static final String PRINCESS 	= "PRINCESS";
	public static final String RALPH 		= "RALPH";
	public static final String TRINOIDS 	= "TRINOIDS";
	public static final String VICKI 		= "VICKI";
	public static final String VICTORIA 	= "VICTORIA";
	public static final String WHISPER 		= "WHISPER";
	public static final String ZARVOX 		= "ZARVOX";
	
    public static HashMap fqVoices = null;

	public final String VERSION = "0.1.0";
	protected NSSpeechSynthesizer synth;
	
	/**
	 * Constructor
	 */
	public Parrot() {
		synth = new NSSpeechSynthesizer();
	}

	/**
	 * Alt Constructor. Pass voice to use
	 */
	public Parrot(String voice) {
		String fqVoice = getFQVoice(voice);
		synth = new NSSpeechSynthesizer(fqVoice);
	}
	
	/**
	 * Return the fully qualified name of the voice to use
	 * Also lazy inits the fqVoices hashmap
	 */
	public String getFQVoice(String voice) {
		if (fqVoices == null) {
			fqVoices = new HashMap();
			fqVoices.put("AGNES", "com.apple.speech.synthesis.voice.Agnes");
			fqVoices.put("ALBERT", "com.apple.speech.synthesis.voice.Albert");
			fqVoices.put("ALEX", "com.apple.speech.synthesis.voice.Alex");
			fqVoices.put("BADNEWS", "com.apple.speech.synthesis.voice.BadNews");
			fqVoices.put("BAHH", "com.apple.speech.synthesis.voice.Bahh");
			fqVoices.put("BELLS", "com.apple.speech.synthesis.voice.Bells");
			fqVoices.put("BOING", "com.apple.speech.synthesis.voice.Boing");
			fqVoices.put("BRUCE", "com.apple.speech.synthesis.voice.Bruce");
			fqVoices.put("BUBBLES", "com.apple.speech.synthesis.voice.Bubbles");
			fqVoices.put("CELLOS", "com.apple.speech.synthesis.voice.Cellos");
			fqVoices.put("DERANGED", "com.apple.speech.synthesis.voice.Deranged");
			fqVoices.put("FRED", "com.apple.speech.synthesis.voice.Fred");
			fqVoices.put("GOODNEWS", "com.apple.speech.synthesis.voice.GoodNews");
			fqVoices.put("HYSTERICAL", "com.apple.speech.synthesis.voice.Hysterical");
			fqVoices.put("JUNIOR", "com.apple.speech.synthesis.voice.Junior");
			fqVoices.put("KATHY", "com.apple.speech.synthesis.voice.Kathy");
			fqVoices.put("ORGAN", "com.apple.speech.synthesis.voice.Organ");
			fqVoices.put("PRINCESS", "com.apple.speech.synthesis.voice.Princess");
			fqVoices.put("RALPH", "com.apple.speech.synthesis.voice.Ralph");
			fqVoices.put("TRINOIDS", "com.apple.speech.synthesis.voice.Trinoids");
			fqVoices.put("VICKI", "com.apple.speech.synthesis.voice.Vicki");
			fqVoices.put("VICTORIA", "com.apple.speech.synthesis.voice.Victoria");
			fqVoices.put("WHISPER", "com.apple.speech.synthesis.voice.Whisper");
			fqVoices.put("ZARVO", "com.apple.speech.synthesis.voice.Zarvox");
		}
		return (String) fqVoices.get(voice);
	}

	/**
	 * stops the current voice from speaking 
	 * 
	 */
	public void stopSpeaking() {
		synth.stopSpeaking();
	}
	
	/**
	 * returns true if currently speaking 
	 * 
	 * @return boolean
	 */
	public boolean isSpeaking() {
		return synth.isSpeaking();
	}

	/**
	 * returns true if any application is currently speaking 
	 * 
	 * @return boolean
	 */
	public boolean isAnyApplicationSpeaking() {
		return NSSpeechSynthesizer.isAnyApplicationSpeaking();
	}

	
	/**
	 * returns the name of the current voice 
	 * 
	 * @return string
	 */
	public String voice() {
		String fqVoice = synth.voice();
		int loc = fqVoice.lastIndexOf('.');
		return fqVoice.substring(loc).toUpperCase();
	}
	
	/**
	 * sets the current voice using the voice's name
	 * @param voice
	 * 			Name of the voice to use
	 * 
	 * @return boolean
	 */
	public boolean setVoice(String voice) {
		String fqVoice = getFQVoice(voice);
		return synth.setVoice(fqVoice);
	}

	/**
	 * sets the current voice using the voice's index
	 * 
	 * @param voice
	 * 			Index of the voice to use
	 * 
	 * @return boolean
	 */
	public boolean setVoice(int voice) {
		return setVoice(voices[voice]);
	}

	/**
	 * returns the name of the default voice 
	 * 
	 * @return String
	 */
	public String defaultVoice() {
		// get the abbreviated name
		String fqVoice = NSSpeechSynthesizer.defaultVoice();
		int loc = fqVoice.lastIndexOf('.');
		return fqVoice.substring(loc).toUpperCase();
	}

	/**
	 * returns an array of available voices
	 * 
	 * @return String[]
	 */
	public String[] availableVoices() {
		return voices;

	}
	
	
	
	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public String version() {
		return VERSION;
	}

	/**
	 * 
	 * @param str
	 *          What to speak
	 */
	public void speak(String str) {
		synth.startSpeakingString(str);
	}

}

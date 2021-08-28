package edu.archive;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AE {
	
	public static ArrayList<String> in = new ArrayList<>();
	public static ArrayList<String> out = new ArrayList<>();
	public static String folder = "/Users/yzm9199/Downloads/";
	
    public static void main(String[] args) throws IOException {

    	getNormalizedSymptom(folder+"in.txt");
//    	getNormalizedSymptomOnset(folder+"in.txt");
    	
    	printArrayListFile(out, folder+"out.txt");
    	
    }

    public static void printArrayListFile(ArrayList<String> _list, String _file) throws FileNotFoundException, UnsupportedEncodingException {

        try (PrintWriter writer = new PrintWriter(_file, "UTF-8")) {
            for (String str : _list) {
                writer.println(str);
                writer.flush();
            }
            writer.close();
        }
    }
    
    public static void getNormalizedSymptom (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	System.out.println(line);
	        	String id = line.split("\t")[0];
	        	line = line.split("\t")[1].toLowerCase();
	        	
//	        	String id = "";
//	        	line = line.toLowerCase();
	        	
	        	if(line.contains("headache")) {
	        		out.add(id+"\theadache");
	        	}
	        	else if((line.contains("chest")&&(line.contains("burn")||line.contains("pain")))||line.contains("heartburn")||line.contains("angina")) {
	        		out.add(id+"\tchest pain");
	        	}
	        	else if((line.contains("abdom")||line.contains("stomach"))&&(line.contains("pain")||line.contains("burn")||line.contains("cramp"))) {
	        		out.add(id+"\tabdominal pain");
	        	}
	        	else if(line.contains("myalgia")||line.contains("arthralgias")||((line.contains("muscle")||line.contains("joint"))&&line.contains("pain"))) {
	        		out.add(id+"\tmuscle/joint pain");
	        	}
//	        	else if(line.contains("injection")&&line.contains("pain")) {
//	        		out.add(id+"\tinjection_site_pain");
//	        	}
	        	else if(line.contains("diarrhea")||line.contains("diarrhoea")||(line.contains("stomach")&&(line.contains("upset")||line.contains("discomfort")||line.contains("sick")))) {
	        		out.add(id+"\tdiarrhea");
	        	}
//	        	else if(line.contains("seizure")) {
//	        		out.add(id+"\tseizure");
//	        	}
	        	else if(line.contains("ache")||line.contains("aching")||line.contains("pain")||line.contains("burn")) {
	        		out.add(id+"\tpain/burning");
	        	}
	        	else if(line.contains("encephalitis")||line.contains("encephalopathy")) {
	        		out.add(id+"\tencephalitis/encephalopathy");
	        	}
	        	else if(line.contains("chill")||line.contains("fever")||line.contains("pyrexia")) {
	        		out.add(id+"\tpyrexia");
	        	}
	        	else if(line.contains("vomit")||line.contains("emesis")||line.contains("nausea")) {
	        		out.add(id+"\tnausea/vomit");
	        	}
	        	else if(line.contains("fatigue")||line.contains("tired")||line.contains("weakness")) {
	        		out.add(id+"\tfatigue/weakness");
	        	}
	        	else if(line.contains("angiooedema")||line.contains("lump")||line.contains("swelling")||line.contains("swollen")) {
	        		out.add(id+"\tswelling");
	        	}
//	        	else if(line.contains("sore")) {
//	        		out.add(id+"\tsoreness");
//	        	}
	        	else if(line.contains("atelectasis")||(line.contains("respirat")&&(line.contains("distress")||line.contains("failure")))) {
	        		out.add(id+"\trespiratory distress/failure");
	        	}
	        	else if(line.contains("infarct")||line.contains("_mi")||line.contains("aneurysm")||line.contains("cva")||line.contains("hemorrhag")||line.contains("haemorrhag")) {
	        		out.add(id+"\tinfarction/aneurysm/hemorrhage");
	        	}
	        	else if(line.contains("hypoxi")||line.contains("desaturation")) {
	        		out.add(id+"\thypoxia");
	        	}
	        	else if(line.contains("hypotens")) {
	        		out.add(id+"\thypotension");
	        	}
	        	else if(line.contains("dizz")||line.contains("lightheaded")) {
	        		out.add(id+"\tdizziness");
	        	}
	        	else if(line.contains("allerg")||line.contains("anaphylaxis")||line.contains("anaphylactic")) {
	        		out.add(id+"\tallergic reaction");
	        	}
	        	else if(line.contains("dvt")||line.contains("thromb")||line.contains("embol")||line.contains("clot")) {
	        		out.add(id+"\tthrombus/embolism");
	        	}
	        	else if(line.contains("rash")||line.contains("hive")||line.contains("erythema")||line.equals("redness")||line.equals("red")) {
	        		out.add(id+"\trash/redness");
	        	}
	        	else if((line.contains("attack")&&line.contains("heart"))||(line.contains("arrest")&&line.contains("cardia"))) {
	        		out.add(id+"\tcardiac attack/arrest");
	        	}
	        	else if(line.contains("tachycardia")) {
	        		out.add(id+"\ttachycardia");
	        	}
	        	else if(line.contains("irregular_heart")||line.contains("flutter")||line.contains("palpitation")||(line.contains("heart")&&(line.contains("race")||(line.contains("rate")&&(line.contains("increase")||line.contains("elevate")||line.contains("fast")||line.contains("rapid")))))||line.contains("afib")||line.contains("fibrillation")||line.contains("arrythmia")||line.contains("arrhythmia")) {
	        		out.add(id+"\tarrhythmia/palpitation");
	        	}
	        	else if(line.contains("carditis")) {
	        		out.add(id+"\tcarditis");
	        	}
	        	else if(line.contains("itch")||line.contains("eczema")) {
	        		out.add(id+"\titching");
	        	}
	        	else if(line.contains("hemoptysis")||line.contains("cough")||line.contains("bronchitis")||line.contains("bronchospasm")) {
	        		out.add(id+"\tcough");
	        	}
	        	else if(line.contains("flush")||line.contains("flash")||line.contains("sweat")||line.contains("diaphoresis")||line.contains("hyperhidrosis")) {
	        		out.add(id+"\tflush/sweating");
	        	}
	        	else if(line.contains("numbness")||line.contains("tingling")||line.contains("hypoesthesia")) {
	        		out.add(id+"\tnumbness");
	        	}
	        	else if(line.contains("tinnitus")||line.contains("hearing_loss")) {
	        		out.add(id+"\ttinnitus/hearing loss");
	        	}
	        	else if(line.contains("tightness")||(line.contains("breath")&&(line.contains("difficult")||line.contains("shortness")||line.contains("problem")))) {
	        		out.add(id+"\ttightness");
	        	}
	        	else if(line.contains("appendicitis")) {
	        		out.add(id+"\tacute appendicitis");
	        	}
	        	else if(line.contains("acute")&&line.contains("pancreatitis")) {
	        		out.add(id+"\tacute pancreatitis");
	        	}
//	        	else {
//	        		out.add(id+"\t.");
//	        	}
	        }
	    }
	}
	
	public static void getNormalizedSymptomOnset (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {

	        	System.out.println(line);
	        	String[] t = line.split(",");
	        	String o = ".";
	        	int a = 0; int b = 0;
	        	
	        	Pattern pat = Pattern.compile("(?i)([0-9a-zA-Z]+)(\\s|-)?(min|hr|minute|hour)(s)?");
	        	for(String i:t) {
	        		Matcher mat = pat.matcher(i);
	        		if(i.contains("every")) {
	        			continue;
	        		}
	        		else if(mat.find()) {
	        			
	        			if(mat.group(3).equals("hr")||mat.group(3).equals("hour")){
	        				i = mat.group(1).toLowerCase();
	        				if(i.equals("few")) {i = "3";}
	        				else if(i.equals("several")||i.equals("couple")) {i = "6";}
	        				else if(i.equals("an")||i.equals("a")||i.equals("1st")||i.equals("the")||i.equals("fir")||i.equals("next")||i.equals("following")||i.equals("one")||i.equals("another")||i.equals("first")||i.equals("about")) {i = "1";}
	        				else if(i.equals("half")) {i="1";}
	        				else if(i.equals("eight")) {i="8";}
	        				else if(i.equals("eleven")) {i="11";}
	        				else if(i.equals("fifteen")) {i="15";}
	        				else if(i.equals("five")) {i="5";}
	        				else if(i.equals("ten")||i.equals("10th")) {i="10";}
	        				else if(i.equals("four")) {i="4";}
	        				else if(i.equals("seven")) {i="7";}
	        				else if(i.equals("thirteen")) {i="13";}
	        				else if(i.equals("thirty")) {i="30";}
	        				else if(i.equals("three")) {i="3";}
	        				else if(i.equals("twelve")) {i="12";}
	        				else if(i.equals("twenty")) {i="20";}
	        				else if(i.equals("two")) {i="2";}
	        				else if(i.equals("six")) {i="6";}
	        				else if(i.equals("sixteen")) {i="16";}
	        				else if(i.equals("nine")) {i="9";}
	        				else if(i.equals("3rd")) {i="3";}
	        				else if(i.equals("of")||i.equals("c")||i.equals("morning")||i.equals("early")||i.equals("than")||i.equals("t")) {continue;}

	        				if (a<Integer.parseInt(i)) {
	        					a = Integer.parseInt(i);
	        				}
	        			}
	        			else if(mat.group(3).equals("min")||mat.group(3).equals("minute")){
	        				i = mat.group(1).toLowerCase();
	        				if(i.equals("few")) {i = "5";}
	        				else if(i.equals("several")||i.equals("couple")) {i = "15";}
	        				else if(i.equals("an")||i.equals("a")||i.equals("1st")||i.equals("the")||i.equals("fir")||i.equals("next")||i.equals("following")||i.equals("one")||i.equals("another")||i.equals("first")||i.equals("about")) {i = "1";}
	        				else if(i.equals("half")) {i="1";}
	        				else if(i.equals("eight")) {i="8";}
	        				else if(i.equals("17th")) {i="17";}
	        				else if(i.equals("fifteen")) {i="15";}
	        				else if(i.equals("five")) {i="5";}
	        				else if(i.equals("forty")) {i="40";}
	        				else if(i.equals("four")) {i="4";}
	        				else if(i.equals("six")) {i="6";}
	        				else if(i.equals("ten")) {i="10";}
	        				else if(i.equals("thirty")) {i="30";}
	        				else if(i.equals("three")) {i="3";}
	        				else if(i.equals("twelve")) {i="12";}
	        				else if(i.equals("twenty")) {i="20";}
	        				else if(i.equals("two")) {i="2";}
	        				else if(i.equals("seven")) {i="7";}
	        				else if(i.equals("of")||i.equals("co")||i.equals("this")||i.equals("early")||i.equals("than")||i.equals("t")) {continue;}
	        				
	        				if (b<Integer.parseInt(i)) {
	        					b = Integer.parseInt(i);
	        				}
	        			}
	        		}
	        		else if(i.startsWith("PT")&&!o.contains("hour")&&!o.contains("minute")&&!i.contains("S[")&&!i.contains("HR]")) {
	        			if(o.equals(".")) {
	        				o = i;
	        			}
	        			else if(!o.contains(i)){
	        				o = o+","+i;
	        			}
	        		}
	        		else if(i.contains("later")&&i.contains("hour")) {
	        			if (a<3) {
        					a = 3;
        				}
	        		}
	        		else if(i.contains("later")&&i.contains("minute")) {
	        			if (b<15) {
        					b = 15;
        				}
	        		}
//	        		else System.out.println("!!"+i);
	        	}
	        	
//	        	Pattern pat = Pattern.compile("P[0-9X]+D");
//	        	for(String i:t) {
//	        		Matcher mat = pat.matcher(i);
//	        		if(mat.find()) {
//	        			if(o.equals(".")) {
//	        				o = i;
//	        			}
//	        			else if(!o.contains(i)){
//	        				o = o+","+i;
//	        			}
//	        		}
//	        		else System.out.println("!!"+i);
//	        	}
	        	
	        	if(a!=0&&b!=0) {
	        		out.add(b+" minutes");
	        	}
	        	else if(a!=0&&a<=96&&b==0) {
	        		out.add(a+" hours");
	        	}
	        	else if(b!=0) {
	        		out.add(b+" minutes");
	        	}
	        	else {
	        		out.add(o);
	        	}
	        }
	    }
	}
}

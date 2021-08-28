package edu.mayo.gene;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.parsers.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AE {
	
	public static String[] groups = {};
	public static ArrayList<String> in = new ArrayList<>();
	public static ArrayList<String> out = new ArrayList<>();
	public static HashMap<String,String> id = new HashMap<String,String>();
	public static HashMap<String,HashMap<String,String>> FH = new HashMap<String,HashMap<String,String>>();
	public static String[] inhibitors = {"AKT1_inhibitors","ALK_inhibitors","Aurora_kinase_inhibitors","AXL_inhibitors","Bcr-Abl_inhibitors","BRAF_inhibitors","BTK_inhibitors","CDK_inhibitors","EGFR_inhibitors","ERBB2_inhibitors","ERBB4_inhibitors","FGFR_inhibitors","FLT3_inhibitors","IGFR_inhibitors","JAK_inhibitors","KIT_inhibitors","MEK_inhibitors","MET_inhibitors","mTOR_inhibitors","PDGFR_inhibitors","PI3K_inhibitors","PLK1_inhibitors","RET_inhibitors","ROS1_inhibitors","SRC_inhibitors","SYK_inhibitors","TEK_inhibitors","TRK_inhibitors","VEGFR_inhibitors"};
	public static String[] stopwords = {"and", "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that", "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing", "a", "an", "the", "but", "if", "because", "as", "until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "nor", "only", "own", "same", "so", "than", "too", "very", "can", "will", "just", "don", "should", "now"};
//	public static String folder = "/infodev1/phi-projects/dhs/workspace-sf/Sunyang_Share/data/yq/grant/title/";
//	public static String folder = "/infodev1/phi-projects/dhs/workspace-yiqing/metamap/RWD/";
//	public static String folder = "H:\\foundation\\genetics_results\\RWD\\";
//	public static String folder = "/Users/yzm9199/Downloads/plot_timeline/data/";
	public static String folder = "/Users/yzm9199/Downloads/";
	
    public static void main(String[] args) throws IOException, ParseException, ParserConfigurationException, SAXException, java.text.ParseException {
    	
//    	parseJSON(folder+"fl.json");
//    	removeDuplicates(out);
//    	printArrayListFile(out, folder+"in.txt");
    	
//    	readTXT(folder+"demographic.txt");
//    	cleanTXT(folder+"in.txt"); //replace " in excel first
//    	replaceString(folder+"in.txt");
//    	splitTXT(folder+"in.txt");
//    	removePuncNumbers(folder+"in.txt");
//    	replaceDrug(folder+"in.txt");
//    	nGramDrug(folder+"in.txt");
//    	splitFile("/Users/yzm9199/Downloads/DRUG_20210301.csv");
    	
//    	getHemOncDrug();
//    	getHemOncCategory0(folder+"in.txt", folder+"out.txt");
//    	getHemOncCategory(folder+"in.txt");
//    	getHemOncBrand(folder+"in.txt");
//    	getHemOncDrugCategory(folder+"in.txt");
//    	getHemOncDrugStatus(folder+"temp.txt");
//    	getHemOncInhibitors();
    	
//    	getRxClass(folder+"in.txt");
//    	getNormalizedMed(folder+"in.txt");
//    	getChemName(folder+"in.txt");
//    	getCategory(folder+"in.txt");
//    	getCancerMed(folder+"in.txt");
    	
//    	getCancerDx(folder+"in.txt");
//    	getCancerGT(folder+"in.txt");
//    	getCancerProc(folder+"in.txt");
    	
//    	readFileFilterDate(folder+"in.txt");
//    	getInfo(folder+"temp.txt");
    	
//    	getMed(folder+"in.txt");
//    	getRecommendMed(folder+"in.txt");
//    	compareMed(folder+"in.txt");
//    	getMedSum(folder+"temp.txt");
//    	getMedFilterDate(folder+"in.txt");
    	
//    	getADE(folder+"temp.txt");
//    	getDx(folder+"temp.txt");
//    	getResist(folder+"temp.txt");
    	
//    	getOncoGene(folder+"in.txt");
//    	readGene(folder+"in.txt");
    	
//    	getFH(folder+"in.txt");//error:meternal, grandmother
//    	getFHSum(folder+"in.txt");
//    	printFHSum(folder+"in.txt");
    	
//    	SFIPF(folder+"in.txt");
//    	PMI(folder+"in.txt");
    	
//    	getInsurance(folder+"in.txt");
    	
//    	String CDM = folder+"CDM/";
//		File[] listOfFiles = new File(CDM).listFiles();
//		String in = ""; 
//
//	    for (int i = 0; i < listOfFiles.length; i++) {
//	      if (listOfFiles[i].isFile()&&listOfFiles[i].getName().endsWith(".txt")) {
//			in = CDM+listOfFiles[i].getName();
//			readCDM(CDM, in);
//	      } else if (listOfFiles[i].isDirectory()) {
//	        System.out.println("Directory " + listOfFiles[i].getName());
//	      }
//	    }
	    
//    	getLab(folder+"in.txt");
    	
//    	countType(folder+"in.txt");
//    	rankTemporal(folder+"in.txt");
    	
//    	recordedGene(folder+"temp.txt");
    	
//    	getSmallPanel(folder+"temp.txt");
    	
//    	getVisit(folder+"in.txt");
    	
//    	getSUTimeMatcher(folder+"in.txt");
    	
//    	getIRB(folder+"in.txt");
    	
//    	matchIRB(folder+"temp.txt");
    	
//    	getRdata(folder+"temp.txt");
    	
//    	getSum(folder+"temp.txt");
    	
//    	readSum(folder+"in.txt");
    	
    	reMapID(folder+"temp.txt");
//    	reMapID2(folder+"temp.txt");
    	
//    	supportX(folder+"temp.txt");
    	
//    	getNeg(folder+"temp.txt");
    	
//    	getCNSum(folder+"temp.txt");
    	
//    	getMayoClinicalTrials();
//    	getClinicalTrials();
    	
//    	getTempoSum(folder+"temp.txt");
    	
//    	getContext(folder+"in.txt");
    	
//    	readFileFilterCtx(folder+"in.txt");
    	
//    	removeDuplicates(out);
//    	System.out.println(out.size());
    	printArrayListFile(out, folder+"out.txt");
    	
//    	readClob(folder+"CDM2.txt");
    	
    }

    public static void readCSV(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	    }
    }
    
    public static void readFileFilterDate(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	if(line.split("\t")[1].equals("CollDate")) {
	        		continue;
	        	}
	        	SimpleDateFormat formatter=new SimpleDateFormat("M/d/yyyy"); 
	        	Date CollDate = formatter.parse(line.split("\t")[1]);
	        	String[] dd = line.split("\t")[2].split(",");
	        	String ade = "";
	        	for(String d : dd) {
	        		if(d.contains("[")) {
//	        			System.out.println(d);
	        			Date date = formatter.parse(d.substring(d.indexOf("[")+1, d.length()-1));
		        		long days = TimeUnit.DAYS.convert(date.getTime() - CollDate.getTime(), TimeUnit.MILLISECONDS);
		        		if ( days > -365) {
			        		if(ade.equals("")) {
			        			ade = d;
			        		}
			        		else ade = ade +","+d;
			            } 
	        		}
//	        		System.out.println(ade);
	        	}
	        	
	        	out.add(ade);
	        	
	        }
	    }
	}
    
    public static void readFileFilterCtx(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	if(line.split("\t")[1].equals(".")&&!line.split("\t")[2].equals(".")) {
	        		out.add(line.split("\t")[0]+"\t"+line.split("\t")[2]);
	        	}
	        }
	    }
	}
    
	public static void replaceString (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	Pattern pat = Pattern.compile("(?i)(spontaneous report|concomitant medication|single dose|first dose|injection site|year old|left arm|lot number|unspecified route|body ache|COVID immunization|tested positive|batch number|lot batch|second dose|adverse event|blood pressure|heart rate|right arm|side effect|left side|muscle ache|lymph node|sore throat|arm pain|muscle pain|chest tightness|abdominal pain|medical history)");
	        	Matcher mat = pat.matcher(line);
	        	while(mat.find()){
        			line = line.replaceAll(mat.group(),mat.group().replace(" ","_").toLowerCase());
        		}
        		
	        	out.add(line);
	        	
	        }
	    }
	}
	
	public static void reMapID (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	System.out.println(line);
//	        	line = line.replace("\"", "").replace("  ", " ").toLowerCase();
	        	
	        	if(id.get(line.split("\t")[0].trim())!=null) {
	        		String s = id.get(line.split("\t")[0].trim());
	        		if(!s.contains(line.split("\t")[1].trim())) {
	        			s = s + "," + line.split("\t")[1].trim();
	        		}
	        		id.put(line.split("\t")[0].trim(), s);
	        	}
	        	else {
	        		id.put(line.split("\t")[0].trim(), line.split("\t")[1].trim());
//		        	id.put(line.split("\t")[0], line);
	        	}
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Downloads/in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
//	        	line = line.replace("\"", "").replace("  ", " ").toLowerCase();
	        	
	        	String mrn = line.trim();
	        	
	        	//equal
	        	if(id.get(mrn)==null) {
	        		out.add(".");
//	        		out.add(mrn);
	        	}
	        	else out.add(id.get(mrn));
	        	System.out.println(mrn+"\t"+id.get(mrn));
	        	
	        	//contain
//	        	String o ="";
//	        	for ( Map.Entry<String, String> entry : id.entrySet()  ) {
//		        	if(mrn.toLowerCase().contains(entry.getKey().toLowerCase())) {
//		        		o = entry.getValue();
//		        	}
//	        	}
//	        	out.add(mrn+"\t"+o);
	        }
	    }
	}
    
	public static void reMapID2 (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	in.add(line);
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Downloads/in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	String record = ".";
	        	for(String s:in) {
		        	if(line.contains(s)) {
		        		record = "Lung";
		        	}
	        	}
	        	out.add(record);
        		System.out.println(line+"\t"+record);
	        }
	    }
	}
	
	public static void getSUTimeMatcher (String file) throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        Pattern pat = Pattern.compile("([0-9]{4}-[0-9]{2})(-[0-9]{2})?([A-Z0-9-:]+)?\\[");
	 
	        while ((line = br.readLine()) != null) {
//	        	line = "2019-05-28	3. 1/22/2019: She received cycle 1, day 14 of systemic MTX as inpatient, and cleared the MTX in 3 days.	2019-01-22[1/22/2019],P1D[day],P3D[3 days]";
	        	
	        	line = line.replace("\"", "").replace("],", "|");
	        	String date = line.split("\t")[0];
	        	String sentence = line.split("\t")[1];
	        	String date1 = line.split("\t")[2];
	        	String date2="";
	        	
	        	String output = ".";
	        	if(date1.startsWith("Time")||date1.trim().equals("")) {
	        		continue;
	        	}
	        	
	        	String[] dates = date1.split("\\|");
        		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        		SimpleDateFormat formatter1=new SimpleDateFormat("M/d/yy");
        		
	        	for(String d:dates) {
	        		String add = "";
	                Pattern pat0 = Pattern.compile("([0-9]{4}-[0-9]{2})(-[0-9]{2})?([A-Z0-9-]+)?\\[([0|1]?[0-9]/[0-9]{1,2}/[0-9]{2,4})");
	        		Matcher mat0 = pat0.matcher(d);
	        		Pattern pat1 = Pattern.compile("([0|1]?[0-9]/[0-9]{1,2}/[0-9]{2})\\]");
	        		Matcher mat1 = pat1.matcher(d+"]");
	        		if(mat0.find()){
	        			add = mat0.group().split(" ")[0].substring(mat0.group().split(" ")[0].indexOf("[")+1);
	        		}
	        		else if(mat1.find()){
	        			add = mat1.group().replace("]", "");
	        		}
	        		else {
	        			Matcher mat = pat.matcher(d);
			        	if(mat.find()){
			        	   Pattern pat2 = Pattern.compile("[A-Z-]{2,}");
			        	   Matcher mat2 = pat2.matcher(mat.group());
			        	   if(mat2.find()){
			        		   add = mat.group().substring(0, mat.group().indexOf(mat2.group()));
			        	   }
			 	    	   else add = mat.group();
			 	    	  
			        	   if(add.contains("T")) {
			        		   add = add.split("T")[0];
			        	   }
			        	   
			        	   add = add.replace("[", "").replace("]", "");
			        	   
			 	    	   if(mat.group(2)==null) {
			 	    		  add = add +"-01";
			 	    	   }
//			 	    	   System.out.println(add);
		        		}
		 	    	}
	        		
	        		if(add.contains("/")) {
		        		add = formatter.format(formatter1.parse(add));
	        		}
	        		
	        		
	        		if(output.equals(".")&&!add.equals("")) {
		        		   output = add;
	        	    }
	        	    else if(!add.equals("")&&!output.contains(add)) {
	        	    	output = output+","+add;
	        	    }
	        		
	        		if(!add.equals("")) {
	        			if(date2.equals("")) {
		        			date2 = d;
		        		}
		        		else date2 = date2 +","+d;
	        		}
	        	}
	        	
	        	//clean matcher
	        	String output1 = "";
	        	if(!output.contains(",")) {
	        		output1 = output;
	        	}
	        	else if(output.split(",").length>3) {
	        		output1 = ".";
	        	}
	        	else if(output.split(",").length==2) {
	        		output1 = output.split(",")[0];
	        	}
	        	else {
		        	Date a = formatter.parse(output.split(",")[0]);
		        	Date b = formatter.parse(output.split(",")[1]);
		        	long days = TimeUnit.DAYS.convert(b.getTime() - a.getTime(), TimeUnit.MILLISECONDS);
		        	if(days<=5&&days>=0) {
		        		output1 = output.split(",")[0];
		        	}
		        	else if(sentence.contains("until")||sentence.contains("through")||sentence.contains("to")){
		        		if(a.before(b)) {
		        			output1 = output.split(",")[0];
		        		}
		        		else output1 = output.split(",")[1];
		        	}
		        	else {
		        		output1 = ".";
		        	}
	    		}
	        	
	        	if(!output1.equals(".")&&!output1.equals("Hx")) {
	        		Date a = formatter.parse(output1);
	        		Date c = formatter.parse(date);
	        		Date b1 = formatter.parse("1930-01-01");
	        		Date b2 = formatter.parse("1960-01-01");
	        		Date b3 = formatter.parse("2031-01-01");
	        		
	        		String match=date2.split(",")[0];
	        		if(a.before(b1)) {
	        			output1 = "20"+output1.substring(2);
	        		}
	        		else if(a.after(c)&&a.before(b3)) {
	        			
	        			if(sentence.contains("until")||sentence.contains("through")||sentence.contains("to")) {
	        				output1 = formatter.format(c);
	        			}
	        			else {
	        				match = match.substring(match.indexOf("[")).replace("[", "").replace("]", "");
	        				Pattern pat1 = Pattern.compile("[A-Z][A-Za-z]+ [0-9]{1,2}");
		        			Matcher mat1 = pat1.matcher(match);
		        			if(mat1.find()&&!match.contains("/")) {
		        				Pattern pat2 = Pattern.compile("[0-9]{4}");
			        			Matcher mat2 = pat2.matcher(match);
			        			if(!mat2.find()) {
			        				long days = TimeUnit.DAYS.convert(a.getTime() - c.getTime(), TimeUnit.MILLISECONDS);
			    		        	if(days>90) {
			    		        		int y = Integer.parseInt(formatter.format(c).split("-")[0])-1;
			    		        		output1 = y+"-"+output1.split("-")[1]+"-"+output1.split("-")[2];
			    		        	}
			        			}
		        			}
	        			}
	        		}
	        		else if(!(a.after(b2)&&a.before(b3))) {
	        			output1 = ".";
	        		}
	        	}

	        	out.add(output1);
	        }
	    }
	}
	
	public static void getRdata (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	id.put(line.split("\t")[0].trim(), line.split("\t")[1].trim());
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Downloads/in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	String[] split = line.trim().split("\t");
	        	String mrn = split[0];
	        	String gene = "."; String mut = ".";
	        	System.out.println(line);
	        	for(int i =1; i<split.length; i++) {
	        		if(!split[i].equals("NA")) {
	        			if(split[i].contains(",")) {
	        				for(String s : split[i].split(",")) {
	        					if(!gene.equals(".")){
			        				gene = gene+"|"+id.get(String.valueOf(i));
			        				mut = mut+"|"+id.get(String.valueOf(i))+"@"+s;
			        			}
			        			else {
			        				gene = id.get(String.valueOf(i));
			        				mut = gene+"@"+s;
			        			}
	        				}
	        			}
	        			else {
	        				if(!gene.equals(".")){
		        				gene = gene+"|"+id.get(String.valueOf(i));
		        				mut = mut+"|"+id.get(String.valueOf(i))+"@"+split[i];
		        			}
		        			else {
		        				gene = id.get(String.valueOf(i));
		        				mut = gene+"@"+split[i];
		        			}
	        			}
	        		}
	        	}
	        	
	        	out.add(mrn+"\t"+gene+"\t"+mut);
	        	
	        }
	    }
	}
	
	public static void recordedGene (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	System.out.println(line);
	        	String mrn = line.split("\t")[0];
	        	String date = line.split("\t")[1];
	        	String gene = line.split("\t")[2];
	        	
	        	HashMap<String,String> record = new HashMap<String,String>();
	        	if(FH.get(mrn)!=null) {
	        		record = FH.get(mrn);
	        		record.put(gene, date);
		        	FH.put(mrn, record);
	        	}
	        	else {
	        		record.put(gene, date);
		        	FH.put(mrn, record);
	        	}
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Downloads/in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	String date = line.split("\t")[1];
	        	String gene = line.split("\t")[2];
	        	System.out.println(line);
	        	if(FH.get(mrn)==null) {
	        		out.add(".");
	        	}
	        	else if(FH.get(mrn).get(gene)==null) {
	        		out.add(".");
	        	}
	        	else out.add(FH.get(mrn).get(gene));
	        	System.out.println(mrn+"\t"+id.get(mrn));
	        }
	    }
	}
	
	public static void rankTemporal(String file) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
		   
		   try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		
		        String line = "";
		        int id = 0; int rank = 0; int exclude = 0;
		        while ((line = br.readLine()) != null) {
					if(line.split("\t")[0].equals("ID")) {
						continue;	        		
					}

					int ID = Integer.parseInt(line.split("\t")[0]);
		        	String topic = line.split("\t")[2];
		        	
		        	if(id!=ID) {
		        		id = ID;
		        		rank = 1;
		        	}
		        	else {
		        		rank++;
		        	}
		        	
		        	if(rank==1&&(topic.equals("negative")||topic.equals("positive")||topic.equals("vus"))) {
		        		exclude = ID;	  
		        		System.out.print(exclude);     		
					}

		        	if(ID!=exclude) {
		        		out.add(topic+"\t"+Integer.toString(rank));
		        	}
		        }
		   }
	   }
	   public static void countType(String file) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
		   
		   int a = 0; //2020
		   int b = 0; //2019
		   int c = 0; //2018
		   int d = 0; //2017
		   int e = 0; //2016
		   int f = 0; //2015
		   
		   try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		
		        String line = "";
	  	    
		        while ((line = br.readLine()) != null) {
//		        	String[] l = line.split(",");
//		        	for(String x:l) {
//
//		        	}
	        		if(line.endsWith("/20")) {a++;}
	        		if(line.endsWith("/19")) {b++;}
	        		if(line.endsWith("/18")) {c++;}
	        		if(line.endsWith("/17")) {d++;}
	        		if(line.endsWith("/16")) {e++;}
	        		if(line.endsWith("/15")) {f++;}
		        }
		    }
		   
		   out.add(Integer.toString(f));
		   out.add(Integer.toString(e));
		   out.add(Integer.toString(d));
		   out.add(Integer.toString(c));
		   out.add(Integer.toString(b));
		   out.add(Integer.toString(a));

	   }
	   
	public static void getInsurance (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	System.out.println(line);
	        	String group = line.split(" ")[0].toUpperCase().trim();
	        	Pattern pat = Pattern.compile("\\b(AARP|AETNA|AHCCCS|ANTHEM|BC|BCBS|BCMN|BLUE|BS|CHAMPVA|CIGNA|CM|COMP|CONTINENTAL|COVENTRY|EMB|GOLDEN|GUNDERSEN|HOSPICE|HUMANA|MAUC|MAYO|MCMN|MEDICA|MEDICAID|MEDICARE|MMSI|NALC|OG|P1|PREFERRED|PREFERREDONE|SANFORD|SECURE|SECURITY|SELECTCARE|SNF|TRICARE|UCARE|UHC|UMR|UNITED|WC|WEA|WPS)\\b");
	        	Matcher mat = pat.matcher(line);
	        	if(group.equals("AARP")||group.equals("AETNA")||group.equals("AHCCCS")||group.equals("ANTHEM")||group.equals("BC")||group.equals("BCBS")||group.equals("BCMN")||group.equals("BS")||group.equals("CHAMPVA")||group.equals("CIGNA")||group.equals("CM")||group.equals("COMP")||group.equals("CONTINENTAL")||group.equals("COVENTRY")||group.equals("EMB")||group.equals("GOLDEN")||group.equals("GUNDERSEN")||group.equals("HOSPICE")||group.equals("HUMANA")||group.equals("MAUC")||group.equals("MAYO")||group.equals("MCMN")||group.equals("MEDICA")||group.equals("MEDICAID")||group.equals("MEDICARE")||group.equals("MMSI")||group.equals("NALC")||group.equals("OG")||group.equals("P1")||group.equals("PREFERRED")||group.equals("PREFERREDONE")||group.equals("SANFORD")||group.equals("SECURE")||group.equals("SECURITY")||group.equals("SELECTCARE")||group.equals("SNF")||group.equals("TRICARE")||group.equals("UCARE")||group.equals("UHC")||group.equals("UMR")||group.equals("UNITED")||group.equals("WC")||group.equals("WEA")||group.equals("WPS")){
	        		out.add(group);
	        	}
	        	else if(group.equals("BLUE")){
	        		group = "BLUE CROSS";
	        		out.add(group);
	        	}
	        	else if(mat.find()){
		        	group = mat.group();
		        	out.add(group);
	        	}
	        	else out.add(line);
	        }
	    }
	}
	
    public static void parseJSON(String file) throws FileNotFoundException, IOException, ParseException {
    	
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader(file))
		{
            Object obj = jsonParser.parse(reader);

            JSONArray patientList = (JSONArray) obj;
            System.out.println(patientList);
            
            for(Object pt : patientList) {
        		//Get patient object within list
        		JSONObject patientObject = (JSONObject) pt;
        		
        		//Get patient info
        		String mrn = patientObject.get("PATIENT_CLINIC_NUMBER").toString();	
        		String firstName = patientObject.get("PATIENT_FIRST_NAME").toString();
        		String lastName = patientObject.get("PATIENT_LAST_NAME").toString();
        		String race = patientObject.get("PATIENT_RACE_NAME").toString().replace("African American","Black or African American").replace("American born African","Black or African American").replaceAll("African(?!\\s)","Black or African American").replace("American Indian/Alaskan Native Northern Plains region native","American Indian/ Alaska Native").replace("American Indian/Alaskan Native","American Indian/ Alaska Native").replace("Asian Chinese","Asian").replace("Asian Filipino","Asian").replace("Asian Indian","Asian").replace("Asian Japanese","Asian").replace("Asian Korean","Asian").replace("Asian Other","Asian").replace("Asian Vietnamese","Asian").replace("Caribbean Black","Black or African American").replace("Choose Not to Disclose","Unknown or Not Reported").replace("Native Hawaii/Pacific Islander","Native Hawaiian or Other Pacific Islander").replace("Native Hawaiian/Pacific Islander","Native Hawaiian or Other Pacific Islander").replace("Other","Unknown or Not Reported").replace("Unable to Provide","Unknown or Not Reported").replaceAll("Unknown(?!\\s)","Unknown or Not Reported");
                String ethnicity = patientObject.get("PATIENT_ETHNICITY_NAME").toString().replace("Mexican", "Hispanic or Latino").replace("Central American", "Hispanic or Latino").replace("Cuban", "Hispanic or Latino").replace("Puerto Rican", "Hispanic or Latino").replace("South American", "Hispanic or Latino").replace("Other Spanish culture of origin regardless of race (except Spain)", "Hispanic or Latino").replace("Choose Not to Disclose", "Unknown");
        		String death = "";
        		if(patientObject.get("PATIENT_DEATH_DATE")!=null) {
        			death = patientObject.get("PATIENT_DEATH_DATE").toString();	
        		}
        		else death = "";
        		System.out.println(mrn+"\t"+race+"\t"+ethnicity+"\t"+death); 
                out.add(mrn+"\t"+race+"\t"+ethnicity+"\t"+death);

        		//Get insurance info
//        		String mrn = patientObject.get("PATIENT_CLINIC_NUMBER").toString();	
//        		String INSURANCE_EFFECTIVE_FROM_DTM = patientObject.get("INSURANCE_EFFECTIVE_FROM_DTM").toString();
//        		String INSURANCE_EFFECTIVE_TO_DTM = patientObject.get("INSURANCE_EFFECTIVE_TO_DTM").toString();
//        		String ENCOUNTER_DTM = patientObject.get("ENCOUNTER_DTM").toString();
//        		String INSURANCE_PAYOR_DK = patientObject.get("INSURANCE_PAYOR_DK").toString();
//        		String INSURANCE_PRIORITY = patientObject.get("INSURANCE_PRIORITY").toString();
//        		String INSURANCE_GROUP_NAME = patientObject.get("INSURANCE_GROUP_NAME").toString().trim();
//        		String INSURANCE_CARRIER_NAME = patientObject.get("INSURANCE_CARRIER_NAME").toString().trim();
//        		String FINANCIAL_CLASS_NAME = patientObject.get("FINANCIAL_CLASS_NAME").toString().trim();
//        		String INSURANCE_COVERAGE_TYPE = patientObject.get("INSURANCE_COVERAGE_TYPE").toString().trim();
//        		String INSURANCE_PAYOR_GROUP_TIER_1 = patientObject.get("INSURANCE_PAYOR_GROUP_TIER_1").toString().trim();
//        		String INSURANCE_PAYOR_GROUP_TIER_2 = patientObject.get("INSURANCE_PAYOR_GROUP_TIER_2").toString().trim();
//        		String INSURANCE_PAYOR_GROUP_TIER_3 = patientObject.get("INSURANCE_PAYOR_GROUP_TIER_3").toString().trim();
//        		String INSURANCE_PAYOR_GROUP_TIER_4 = patientObject.get("INSURANCE_PAYOR_GROUP_TIER_4").toString().trim();
//        		String INSURANCE_COUNT = patientObject.get("INSURANCE_COUNT").toString();
//        		System.out.println(mrn+"\t"+INSURANCE_EFFECTIVE_FROM_DTM+"\t"+INSURANCE_EFFECTIVE_TO_DTM+"\t"+ENCOUNTER_DTM+"\t"+INSURANCE_PAYOR_DK+"\t"+INSURANCE_PRIORITY+"\t"+INSURANCE_GROUP_NAME+"\t"+INSURANCE_CARRIER_NAME+"\t"+FINANCIAL_CLASS_NAME+"\t"+INSURANCE_COVERAGE_TYPE+"\t"+INSURANCE_PAYOR_GROUP_TIER_1+"\t"+INSURANCE_PAYOR_GROUP_TIER_2+"\t"+INSURANCE_PAYOR_GROUP_TIER_3+"\t"+INSURANCE_PAYOR_GROUP_TIER_4+"\t"+INSURANCE_COUNT); 
//                out.add(mrn+"\t"+INSURANCE_EFFECTIVE_FROM_DTM+"\t"+INSURANCE_EFFECTIVE_TO_DTM+"\t"+ENCOUNTER_DTM+"\t"+INSURANCE_PAYOR_DK+"\t"+INSURANCE_PRIORITY+"\t"+INSURANCE_GROUP_NAME+"\t"+INSURANCE_CARRIER_NAME+"\t"+FINANCIAL_CLASS_NAME+"\t"+INSURANCE_COVERAGE_TYPE+"\t"+INSURANCE_PAYOR_GROUP_TIER_1+"\t"+INSURANCE_PAYOR_GROUP_TIER_2+"\t"+INSURANCE_PAYOR_GROUP_TIER_3+"\t"+INSURANCE_PAYOR_GROUP_TIER_4+"\t"+INSURANCE_COUNT);

        		//Get procedure info
//        		String mrn = patientObject.get("PATIENT_CLINIC_NUMBER").toString();	
//        		String PATIENT_AGE_AT_EVENT = patientObject.get("PATIENT_AGE_AT_EVENT").toString();
//        		String PROCEDURE_DTM = patientObject.get("PROCEDURE_DTM").toString();
//        		String PROCEDURE_METHOD_CODE = patientObject.get("PROCEDURE_METHOD_CODE").toString();
//        		String PROCEDURE_CODE = patientObject.get("PROCEDURE_CODE").toString().trim();
//        		System.out.println(mrn+"\t"+PATIENT_AGE_AT_EVENT+"\t"+PROCEDURE_DTM+"\t"+PROCEDURE_METHOD_CODE+"\t"+PROCEDURE_CODE); 
//        		out.add(mrn+"\t"+PATIENT_AGE_AT_EVENT+"\t"+PROCEDURE_DTM+"\t"+PROCEDURE_METHOD_CODE+"\t"+PROCEDURE_CODE); 
        		
        		//Get dx info
//        		String mrn = patientObject.get("PATIENT_CLINIC_NUMBER").toString();	
//        		String PATIENT_AGE_AT_EVENT = patientObject.get("PATIENT_AGE_AT_EVENT").toString();
//        		String DIAGNOSIS_DTM = patientObject.get("DIAGNOSIS_DTM").toString();
//        		String DIAGNOSIS_METHOD_CODE = patientObject.get("DIAGNOSIS_METHOD_CODE").toString();
//        		String DIAGNOSIS_CODE = patientObject.get("DIAGNOSIS_CODE").toString().trim();
//        		System.out.println(mrn+"\t"+PATIENT_AGE_AT_EVENT+"\t"+DIAGNOSIS_DTM+"\t"+DIAGNOSIS_METHOD_CODE+"\t"+DIAGNOSIS_CODE); 
//        		out.add(mrn+"\t"+PATIENT_AGE_AT_EVENT+"\t"+DIAGNOSIS_DTM+"\t"+DIAGNOSIS_METHOD_CODE+"\t"+DIAGNOSIS_CODE);
        		
        		//Get med info
//        		String mrn = patientObject.get("PATIENT_CLINIC_NUMBER").toString();	
//        		String PATIENT_AGE_AT_EVENT = patientObject.get("PATIENT_AGE_AT_EVENT").toString();
//        		String STARTED_DTM = patientObject.get("STARTED_DTM").toString();
//        		String ENDED_DTM = patientObject.get("ENDED_DTM").toString();
//        		String ADMINISTERED_DTM = patientObject.get("ADMINISTERED_DTM").toString();
//        		String MED_NAME_DK = patientObject.get("MED_NAME_DK").toString();
//        		String ADMINISTERED_STATUS = patientObject.get("ADMINISTERED_STATUS").toString();
//        		String ADMINISTERED_FREQUENCY = patientObject.get("ADMINISTERED_FREQUENCY").toString();
//        		String ADMINISTERED_ROUTE = patientObject.get("ADMINISTERED_ROUTE").toString();
//        		String ADMINISTERED_FORM = patientObject.get("ADMINISTERED_FORM").toString();
//        		String ADMINISTERED_DOSE = patientObject.get("ADMINISTERED_DOSE").toString();
//        		String ADMINISTERED_DOSE_UNITS = patientObject.get("ADMINISTERED_DOSE_UNITS").toString();
//        		String ADMINISTERED_STRENGTH = patientObject.get("ADMINISTERED_STRENGTH").toString();
//        		String ADMINISTERED_STRENGTH_UNITS = patientObject.get("ADMINISTERED_STRENGTH_UNITS").toString();
//        		String ADMINISTERED_QUANTITY = patientObject.get("ADMINISTERED_QUANTITY").toString();
//        		String ADMINISTERED_MEDS_COMMENTS = patientObject.get("ADMINISTERED_MEDS_COMMENTS").toString();
//        		System.out.println(mrn+"\t"+PATIENT_AGE_AT_EVENT+"\t"+STARTED_DTM+"\t"+ENDED_DTM+"\t"+ADMINISTERED_DTM+"\t"+MED_NAME_DK+"\t"+ADMINISTERED_STATUS+"\t"+ADMINISTERED_FREQUENCY+"\t"+ADMINISTERED_ROUTE+"\t"+ADMINISTERED_FORM+"\t"+ADMINISTERED_DOSE+"\t"+ADMINISTERED_DOSE_UNITS+"\t"+ADMINISTERED_STRENGTH+"\t"+ADMINISTERED_STRENGTH_UNITS+"\t"+ADMINISTERED_QUANTITY+"\t"+ADMINISTERED_MEDS_COMMENTS); 
//        		out.add(mrn+"\t"+PATIENT_AGE_AT_EVENT+"\t"+STARTED_DTM+"\t"+ENDED_DTM+"\t"+ADMINISTERED_DTM+"\t"+MED_NAME_DK+"\t"+ADMINISTERED_STATUS+"\t"+ADMINISTERED_FREQUENCY+"\t"+ADMINISTERED_ROUTE+"\t"+ADMINISTERED_FORM+"\t"+ADMINISTERED_DOSE+"\t"+ADMINISTERED_DOSE_UNITS+"\t"+ADMINISTERED_STRENGTH+"\t"+ADMINISTERED_STRENGTH_UNITS+"\t"+ADMINISTERED_QUANTITY+"\t"+ADMINISTERED_MEDS_COMMENTS);
        		
        		//Get refer info
//        		String mrn = patientObject.get("PATIENT_CLINIC_NUMBER").toString();	
//        		String REFERRAL_DTM = patientObject.get("REFERRAL_DTM").toString();
//        		String REFERRAL_STATUS_DTM = patientObject.get("REFERRAL_STATUS_DTM").toString();
//        		String REFERRAL_UPDATE_DTM = patientObject.get("REFERRAL_UPDATE_DTM").toString();
//        		String APPOINTMENT_BEGIN_DTM = patientObject.get("APPOINTMENT_BEGIN_DTM").toString();
//        		String APPOINTMENT_END_DTM = patientObject.get("APPOINTMENT_END_DTM").toString();
//        		String REFERRAL_TYPE_DK = patientObject.get("REFERRAL_TYPE_DK").toString();
//        		String REFERRAL_STATUS_DK = patientObject.get("REFERRAL_STATUS_DK").toString();
//        		String APPOINTMENT_DISPOSITION_DK = patientObject.get("APPOINTMENT_DISPOSITION_DK").toString();
//        		String REFERRAL_REASON_DK = patientObject.get("REFERRAL_REASON_DK").toString();
//        		String DEPARTMENT_SPECIALTY_DK = patientObject.get("DEPARTMENT_SPECIALTY_DK").toString();
//        		String ENCOUNTER_TYPE = patientObject.get("ENCOUNTER_TYPE").toString().trim();
//        		String REFERRAL_DISPOSITION = patientObject.get("REFERRAL_DISPOSITION").toString().trim();
//        		String REFERRAL_INTERNAL_EXTERNAL_INDICATOR = patientObject.get("REFERRAL_INTERNAL_EXTERNAL_INDICATOR").toString().trim();
//        		System.out.println(mrn+"\t"+REFERRAL_DTM+"\t"+REFERRAL_STATUS_DTM+"\t"+REFERRAL_UPDATE_DTM+"\t"+APPOINTMENT_BEGIN_DTM+"\t"+APPOINTMENT_END_DTM+"\t"+REFERRAL_TYPE_DK+"\t"+REFERRAL_STATUS_DK+"\t"+APPOINTMENT_DISPOSITION_DK+"\t"+REFERRAL_REASON_DK+"\t"+DEPARTMENT_SPECIALTY_DK+"\t"+ENCOUNTER_TYPE+"\t"+REFERRAL_DISPOSITION+"\t"+REFERRAL_INTERNAL_EXTERNAL_INDICATOR); 
//        		out.add(mrn+"\t"+REFERRAL_DTM+"\t"+REFERRAL_STATUS_DTM+"\t"+REFERRAL_UPDATE_DTM+"\t"+APPOINTMENT_BEGIN_DTM+"\t"+APPOINTMENT_END_DTM+"\t"+REFERRAL_TYPE_DK+"\t"+REFERRAL_STATUS_DK+"\t"+APPOINTMENT_DISPOSITION_DK+"\t"+REFERRAL_REASON_DK+"\t"+DEPARTMENT_SPECIALTY_DK+"\t"+ENCOUNTER_TYPE+"\t"+REFERRAL_DISPOSITION+"\t"+REFERRAL_INTERNAL_EXTERNAL_INDICATOR);

        		//get PPI
//        		String mrn = patientObject.get("PATIENT_CLINIC_NUMBER").toString();	
//        		String ANSWER_DTM = patientObject.get("ANSWER_DTM").toString();
//        		String FORM_DK = patientObject.get("FORM_DK").toString();
//        		String QUESTION_DK = patientObject.get("QUESTION_DK").toString();
//        		String ANSWER_PROVIDED_FLAG = patientObject.get("ANSWER_PROVIDED_FLAG").toString();
//        		String ANSWER_TXT = patientObject.get("ANSWER_TXT").toString().trim();
//        		System.out.println(mrn+"\t"+ANSWER_DTM+"\t"+FORM_DK+"\t"+QUESTION_DK+"\t"+ANSWER_PROVIDED_FLAG+"\t"+ANSWER_TXT); 
//        		out.add(mrn+"\t"+ANSWER_DTM+"\t"+FORM_DK+"\t"+QUESTION_DK+"\t"+ANSWER_PROVIDED_FLAG+"\t"+ANSWER_TXT);
        		
            }
            
        }
	}
    
    public static void readClob(String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	        String header = "";
	        String name = "";
	        String output = "";
	        while ((line = br.readLine()) != null) {
        		
	        	if(line.split("\t").length>5) {
	        		name = line.split("\t")[0]+"_"+line.split("\t")[1].split(" ")[0]+"_"+line.split("\t")[2]+"_"+line.split("\t")[3]+"_"+line.split("\t")[4];
	        		header = line.split("\t")[5];
	        	}
	        	
	        	
    			if(line.split("\t").length>5) {
    				output = header;
    			}
    			else if(line.equals("</CLINDOC>")){
    				try (PrintWriter writer = new PrintWriter(folder+"CDM/"+name+".txt", "UTF-8")) {
    					System.out.println(name);
    					output = output+"\n"+line;
    					writer.println(output);
                        writer.flush();
                        writer.close();
    				}
    			}
    			else if(line.startsWith("<ITEM")){
    				output = output+"\n"+line;
    			}
    			else {
    				output = output+" "+line;
    			}
	        }
	    }
    }
    
    public static void readCDM(String CDM, String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	String mrn = file.replace(CDM, "").split("_")[0];
	        	String date = file.replace(CDM, "").split("_")[1];
	        	
//	        	Pattern pat = Pattern.compile("(?i)(abemaciclib|abiraterone|ado(-| )trastuzumab emtansine|alisertib|allopurinol|alpelisib|anastrozole|antibody(-| )drug conjugates|atezolizumab|avelumab|azacitidine|bacillus calmette(-| )guerin|bevacizumab|bicalutamide|binimetinib|bleomycin|cabozantinib|capecitabine|carboplatin|cediranib|cisplatin|cobimetinib|cortisone|crizotinib|cyclophosphamide|dacarbazine|daunorubicin|denosumab|dexamethasone|docetaxel|doxorubicin|edrecolomab|enzalutamide|epirubicin|eribulin|etoposide|everolimus|exemestane|filgrastim|fluorouracil|fulvestrant|ganitumab|gemcitabine|goserelin|hydrocortisone|hydroxyurea|ifosfamide|imatinib|ipilimumab|irinotecan|ixabepilone|ketoconazole|lapatinib|lenvatinib|letrozole|leuprolide|matched text|melphalan|mercaptopurine|mesna|methotrexate|methylprednisolone|mitomycin|mogamulizumab|neratinib|niraparib|nivolumab|octreotide|olaparib|olaratumab|oxaliplatin|paclitaxel|palbociclib|pazopanib|pegylated liposomal doxorubicin|pembrolizumab|pemetrexed|pertuzumab|pirarubicin|ponatinib|prednisolone|prednisone|raloxifene|ramucirumab|regorafenib|ribociclib|rituximab|rucaparib|sacituzumab govitecan|sirolimus|sorafenib|sunitinib|tamoxifen|temozolomide|temsirolimus|topotecan|trametinib|trastuzumab|trastuzumab(-| )dkst|trimethoprim(/|-| )sulfamethoxazole|valacyclovir|valganciclovir|vincristine|vinorelbine|zidovudine|zoledronic acid)");
//	        	Pattern pat = Pattern.compile("(?i)(everolimus|alectinib|pemetrexed|brigatinib|bevacizumab|ramucirumab|afatinib|gemcitabine|durvalumab|gefitinib|pembrolizumab|lorlatinib|trametinib|mechlorethamine|vinorelbine|nivolumab|carboplatin|necitumumab|entrectinib|dabrafenib|osimertinib|erlotinib|paclitaxel|docetaxel|atezolizumab|methotrexate|dacomitinib|crizotinib|ceritinib|etoposide|topotecan)");
	        	Pattern pat = Pattern.compile("(?i)(abemaciclib|abexinostat|abiraterone|acalabrutinib|aclarubicin|ado trastuzumab emtansine|ado-trastuzumab emtansine|afatinib|afuresertib|aldesleukin|alectinib|alemtuzumab|alisertib|all trans retinoic acid|all-trans retinoic acid|alpelisib|altretamine|alvocidib|amg 330|aminoglutethimide|aminopterin|amrubicin|amsacrine|anastrozole|antithymocyte globulin|antithymocyte globulin, horse atg|antithymocyte globulin, rabbit atg|apatinib|asciminib|asparaginase|atezolizumab|avapritinib|avelumab|axicabtagene ciloleucel|axitinib|azacitidine|bacillus calmette guerin|bacillus calmette-guerin|barasertib|bb2121|belagenpumatucel l|belagenpumatucel-l|belinostat|belotecan|bendamustine|bevacizumab|bevacizumab|bevacizumab awwb|bevacizumab bvzr|bevacizumab-awwb|bevacizumab-bvzr|bexarotene|binimetinib|bl22 immunotoxin|bleomycin|blinatumomab|bortezomib|bosutinib|brentuximab vedotin|brigatinib|buparlisib|busulfan|cabazitaxel|cabozantinib|calaspargase|capecitabine|capivasertib|carboplatin|carfilzomib|carmustine|carmustine wafer|carmustine wafer, polifeprosan 20|catumaxomab|cediranib|cemiplimab|ceritinib|cetuximab|chidamide|chlorambucil|cisplatin|cladribine|clinical study drug|clofarabine|cobimetinib|coltuximab ravtansine|copanlisib|cortisone|crenolanib|crizotinib|custirsen|cyclophosphamide|cyclosporine modified|cyclosporine non modified|cyclosporine non-modified|cyproterone acetate|cytarabine|cytarabine and daunorubicin liposomal|cytarabine liposomal|dabrafenib|dabrafenib+trametinib|dacarbazine|dacomitinib|dactinomycin|dasatinib|daunorubicin|daunorubicin liposomal|decitabine|degarelix|denileukin diftitox|denintuzumab mafodotin|dexamethasone|dinaciclib|docetaxel|dovitinib|doxifluridine|doxorubicin|doxorubicin pegylated liposomal|durvalumab|dutasteride|duvelisib|enasidenib|encorafenib|enfortumab vedotin|ensartinib|entinostat|entospletinib|entrectinib|epirubicin|erdafitinib|eribulin|erlotinib|estramustine|etoposide|everolimus|exemestane|fam trastuzumab deruxtecan|fam-trastuzumab deruxtecan|fedratinib|filanesib|finasteride|floxuridine|fludarabine|fluorouracil|fluoxymesterone|forodesine|fostamatinib|fotemustine|fruquintinib|fulvestrant|galeterone|ganetespib|gefitinib|gemcitabine|gemtuzumab ozogamicin|gilteritinib|glasdegib|goserelin|guadecitabine|hematopoetic progenitor cells|hematopoetic progenitor cells, cord blood|heptaplatin|herceptin|histrelin|hydrocortisone|hydroxyurea|ibritumomab tiuxetan|ibrutinib|icotinib|idarubicin|idelalisib|ifosfamide|imatinib|imetelstat|infigratinib|inotuzumab ozogamicin|interferon alfa 2a|interferon alfa 2b|interferon alfa-2a|interferon alfa-2b|interferon gamma 1b|interferon gamma-1b|ipatasertib|ipilimumab|ipiliumamab|irinotecan|irinotecan liposome|isotretinoin|ivosidenib|ixabepilone|ixazomib|ketoconazole|lanreotide|lapatinib|lapuleucel t|lapuleucel-t|larotrectinib|lenalidomide|lenvatinib|lestaurtinib|letrozole|leuprolide|lobaplatin|lomustine|lorlatinib|masitinib|mechlorethamine|megestrol|melphalan|mercaptopurine|methotrexate|methylprednisolone|midostaurin|mitomycin|mitoxantrone|mocetinostat|momelotinib|motesanib|moxetumomab pasudotox|necitumumab|nedaplatin|nelarabine|neratinib|nilotinib|nimustine|nintedanib|niraparib|nivolumab|nolatrexed|non pegylated liposomal doxorubicin|non-pegylated liposomal doxorubicin|obinutuzumab|octreotide|octreotide lar|ofatumumab|olaparib|olaratumab|omacetaxine|oprozomib|orteronel|osimertinib|oxaliplatin|paclitaxel|paclitaxel protein-bound|paclitaxel, nanoparticle albumin bound|paclitaxel, nanoparticle albumin-bound|pacritinib|palbociclib|panitumumab|panobinostat|pazopanib|pegaspargase|peginterferon alfa 2a|peginterferon alfa 2b|peginterferon alfa-2a|peginterferon alfa-2b|pegylated liposomal doxorubicin|pembrolizumab|pemetrexed|pentostatin|perifosine|pertuzumab|pictilisib|pidilizumab|pirarubicin|pixantrone|plicamycin|polatuzumab vedotin|pomalidomide|ponatinib|pracinostat|pralatrexate|prednisolone|prednisone|procarbazine|quisinostat|quizartinib|radotinib|raloxifene|raltitrexed|ramucirumab|ranimustine|refametinib|regorafenib|retaspimycin|ribociclib|ricolinostat|rilotumumab|rituximab|rituximab abbs|rituximab pvvr|rituximab-abbs|rituximab-pvvr|rociletinib|romidepsin|ropeginterferon alfa 2b|ropeginterferon alfa-2b|rucaparib|ruxolitinib|sacituzumab govitecan|sapacitabine|selinexor|selumetinib|semustine|sipuleucel t|sipuleucel-t|sirolimus|sonidegib|sorafenib|spebrutinib|streptozocin|sunitinib|tacrolimus|talazoparib|talimogene laherparepvec|tamibarotene|tamoxifen|tazemetostat|tegafur and uracil|tegafur gimeracil oteracil|tegafur, gimeracil, oteracil|telotristat|temozolomide|temsirolimus|teniposide|tesetaxel|thalidomide|thioguanine|thiotepa|tipifarnib|tisagenlecleucel|tivantinib|tivozanib|tofacitinib|topotecan|toremifene|tosedostat|tositumomab & i 131|tositumomab & i-131|trabectedin|trametinib|trastuzumab|trastuzumab and hyaluronidase|trastuzumab anns|trastuzumab dkst|trastuzumab dttb|trastuzumab pkrb|trastuzumab qyyp|trastuzumab-anns|trastuzumab-dkst|trastuzumab-dttb|trastuzumab-pkrb|trastuzumab-qyyp|trebananib|tremelimumab|treosulfan|trifluridine and tipiracil|trimethoprim sulfamethoxazole|trimethoprim-sulfamethoxazole|triptorelin|uracil mustard|vadastuximab talirine|valacyclovir|valganciclovir|valproate|valrubicin|vandetanib|veliparib|veltuzumab|vemurafenib|vemurafenib+cobimetinib|venetoclax|vinblastine|vincristine|vincristine liposomal|vindesine|vinflunine|vinorelbine|vismodegib|volasertib|vorinostat|vosaroxin|zanubrutinib|ziv aflibercept|ziv-aflibercept)");
	        	Matcher mat = pat.matcher(line);
	        	
				if(mat.find()) {
					out.add(mrn+"\t"+date+"\t"+mat.group().toLowerCase());
					System.out.println(mrn+"_"+date+"\t"+line);
				}
	        }
	    }
    }
    
    public static void getIRB(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = ""; int i = 0;
	        while ((line = br.readLine()) != null) {
	        	String output = ""; i++;
	        	System.out.println(i);
	        	System.out.println(line);
        		Pattern pat = Pattern.compile("IRB\\s?[#:A-Za-z\\s]{0,}\\s?([0-9]{2,}-[0-9]+)");
        		Matcher mat = pat.matcher(line);
        		while(mat.find()) {
        			System.out.println(mat.group(1));
        			if(!output.equals("")) {
        				output = output+"|"+mat.group(1);
        			}
        			else output = mat.group(1);
        		}
        		
        		out.add(output);
	        }
	    }
    }
    
    public static void matchIRB(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    		
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	System.out.println(line);
	        	
	        	id.put(line.split("\t")[0].trim(), line.split("\t")[1].trim());
	        }
	    }
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	
	        String line = ""; 
	        while ((line = br.readLine()) != null) {
	        	String output = "";
	        	if(line.contains("|")) {
	        		out.add("Y");
	        	}
	        	else {
	        		while(line.startsWith("0")) {
		        		line = line.replaceFirst("0", "");
		        	}
	        		line = line.replace("-", "").replace("_", "").replace(".", "");
	        		System.out.println(line);
	        		
	        		if(id.get(line)==null) {
		        		out.add(".");
		        	}
		        	else out.add(id.get(line));
	        	}
	        }
	    }
    }
    public static void getVisit(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	        while ((line = br.readLine()) != null) {
	        	System.out.println(line);
	        	if(line.equals("null")) {
		        	out.add("0");
		        	continue;
		        }

		        String[] meds = line.split(",");
		        
		        String date = "";
		        int visit = 0;
		        
		        for(String m:meds) {
		        	m = m.substring(m.indexOf("[")+1,m.indexOf("]"));
		        	if(!date.equals(m)){
		        		date = m;
		        		visit++;
		        		System.out.println(m);
		        	}
		        }
		        
		        out.add(String.valueOf(visit));
	        }
	        
	    }
    }
    
    public static void getSmallPanel(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	String date = line.split("\t")[1];
	        	String gene = line.split("\t")[2];
	        	String mut = line.split("\t")[3].trim();
	        	
	        	//turnaround
//	        	date = line.split("\t")[3];
	        	
	        	if(date.toLowerCase().contains("date")) {
	        		continue;
	        	}
	        	
//	        	SimpleDateFormat formatter=new SimpleDateFormat("M/d/yy"); 
//	        	Date IndexDate = formatter.parse("1/1/16");
	        	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
	        	Date IndexDate = formatter.parse("2016-01-01");
	        	Date MedDate = formatter.parse(date);
	        	long days = TimeUnit.DAYS.convert(MedDate.getTime() - IndexDate.getTime(), TimeUnit.MILLISECONDS);
	        	
	        	if(days<0) {
	        		continue;
	        	}
	        	
	        	if(mut.equals(".")||mut.equals("Wild-type")||mut.equals("Negative")) {
	        		continue;
	        	}
	        	
	        	//mut
//	        	if(id.get(mrn)!=null) {
//	        		String s = id.get(mrn);
//	        		if(mut.equals(".")) {
//	        			s = s + ","+ gene+"["+date+"]";
//	        		}
//	        		else s = s + ","+ gene+"_"+mut+"["+date+"]";
//	        	}
//	        	else {
//	        		if(mut.equals(".")) {
//	        			id.put(mrn, gene+"["+date+"]");
//	        		}
//	        		else id.put(mrn, gene+"_"+mut+"["+date+"]");
//	        	}
	        	
	        	String gene1 = "";
	        	for(String g:gene.split("\\|")) {
	        		if(gene1.equals("")) {
	        			gene1 = g;
	        		}
	        		else if(!gene1.contains(g)) {
	        			gene1 = gene1+"|"+g;
	        		}
	        	}
	        	
	        	//turnaround
//	        	date = line.split("\t")[1];
	        	
	        	if(id.get(mrn)!=null) {
	        		String s = id.get(mrn);
	        		if(date.equals(".")) {
	        			System.out.println(date);
	        			s = s + ","+ gene1;
	        		}
	        		else s = s + ","+ gene1+"["+date+"]";
	        		id.put(mrn, s);
	        	}
	        	else {
	        		if(date.equals(".")) {
	        			System.out.println(date);
	        			id.put(mrn, gene1);
	        		}
	        		else id.put(mrn, gene1+"["+date+"]");
	        	}
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Downloads/in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.trim();
	        	if(id.get(mrn)==null) {
	        		out.add(".");
//	        		out.add(mrn);
	        	}
	        	else out.add(id.get(mrn));
//	        	System.out.println(mrn+"\t"+id.get(mrn));
	        }
	    }
    }
    
    public static void getLab(String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	String date = line.split("\t")[1];
	        	String comments = line.split("\t")[2].replace("changes","change").replace("Gene:","|").replace("DNA change:", "@").replace("Amino Acid change:", "@").replace("Classification:"," @").replace("  ", " ");
//	        	System.out.println(comments);
	        	
	        	//LUNGP,LUNGR,LNGPR,CAPN,RASFP,MELP
//	        	String result = ".";
//	        	for(String c : comments.split("\\|")) {
//	        		c = c.trim();
//	        		if(!c.endsWith("MUTATION")&&!c.endsWith("UNCERTAIN SIGNIFICANCE")) {
//	        			if(c.contains("UNCERTAIN SIGNIFICANCE")){
//	        				c = c.substring(0, c.indexOf("UNCERTAIN SIGNIFICANCE")+22);
//	        			}
//	        			else if (c.contains("MUTATION")) {
//	        				c = c.substring(0, c.indexOf("MUTATION")+8);
//	        			}
//	        		}
//	        		
//	        		if(c.contains("@")) {
//	        			if(result.equals(".")) {
//	        				result =  c;
//	        			}
//	        			else result =  result +"|"+c;
//		        		System.out.println(c);
//		        	}
//	        	}
//	        	out.add(mrn+"\t"+date+"\t"+result);
	        	
//        		String gene = ".";
//        		Pattern pat = Pattern.compile("Gene: ([A-Z0-9]{2,})");
//        		Matcher mat = pat.matcher(comments);
//        		while(mat.find()) {
//        			if(!gene.equals(".")) {
//        				gene = gene +"|"+mat.group(1);
//        			}
//        			else gene = mat.group(1);
//        		}
//        		
//        		String dna = ".";
//        		pat = Pattern.compile("DNA change: (c.[A-Za-z0-9>_]{1,})( \\(exon [0-9]{1,}\\))?");
//	        	mat = pat.matcher(comments);
//	        	while(mat.find()) {
//	        		if(mat.group(2)==null){
//	        			if(!dna.equals(".")) {
//	        				dna = dna +"|"+mat.group(1);
//	        			}
//	        			else dna = mat.group(1);
//	        		}
//	        		else {
//	        			if(!dna.equals(".")) {
//	        				dna = dna +"|"+mat.group(1)+mat.group(2);
//	        			}
//	        			else dna = mat.group(1)+mat.group(2);
//	        		}
//        		}
//	        	
//        		String aa = ".";
//        		pat = Pattern.compile("Amino Acid change: (p.[A-Za-z0-9]{1,})( \\([A-Za-z0-9]{1,}\\))?");
//	        	mat = pat.matcher(comments);
//	        	while(mat.find()) {
//	        		if(mat.group(2)==null){
//	        			if(!aa.equals(".")) {
//	        				aa = aa +"|"+mat.group(1);
//	        			}
//	        			else aa = mat.group(1);
//	        		}
//	        		else {
//	        			if(!aa.equals(".")) {
//	        				aa = aa +"|"+mat.group(1)+mat.group(2);
//	        			}
//	        			else aa = mat.group(1)+mat.group(2);
//	        		}
//        		}
//	        	
//	        	String [] genes = gene.split("\\|");
//	        	String [] dnas = dna.split("\\|");
//	        	String [] aas = aa.split("\\|");
//	        	String gene1="."; String dna1="."; String aa1=".";
//	        	for (int i=0; i<genes.length; i++) {
//	        		if(genes[i].equals("BRAF")||genes[i].contains("RAS")) {
//	        			if(!gene1.equals(".")) {
//	        				gene1 = gene1+"|"+genes[i];
//	        				dna1 = dna1+"|"+dnas[i];
//	        				aa1 = aa1+"|"+aas[i];
//	        			}
//	        			else {
//	        				gene1 = genes[i];
//	        				dna1 = dnas[i];
//	        				aa1 = aas[i];
//	        			}
//	        		}
//	        	}
//	        	gene = gene1; dna = dna1; aa = aa1;
//	        	
//	        	if(!gene.equals(".")) {
//	        		System.out.println(mrn+"\t"+date+"\t"+gene+"\t"+dna+"\t"+aa);
//	        		out.add(mrn+"\t"+date+"\t"+gene+"\t"+dna+"\t"+aa);
//	        	}
//	        	else {
//	        		out.add(mrn+"\t"+date+"\t.");
//	        	}

	        	//fusion
//        		String fusion = ".\t.\t.";
//        		Pattern pat = Pattern.compile("The following fusion was identified: ([A-Z0-9]{3,}\\-)([A-Z0-9]{3,})");
//        		Matcher mat = pat.matcher(comments);
//	        	if(mat.find()) {
//	        		fusion = mat.group(2)+"_FUS\t"+mat.group(1)+mat.group(2);
//        		}
//	        	out.add(mrn+"\t"+date+"\t"+fusion);
	        			
	        	//LUNGP,LUNGR,LNGPR,CAPN,RASFP,MELP diagnosis
//        		String diagnosis = ".";
//        		Pattern pat = Pattern.compile("Provided diagnosis: ([A-Za-z0-9\\s-,/;()]+) (A (gene )?fusion|A rearrangement|The following|No (additional )?reportable)");
//        		Matcher mat = pat.matcher(comments);
//	        	if(mat.find()) {
//	        		diagnosis = mat.group(1);
//        		}
//	        	out.add(mrn+"\t"+date+"\t"+diagnosis);

	        	//EGFRR,EGFRD,EGFRT,T790M,BRAFT,KRASO
//	        	if(comments.contains("EGFR status:")) {
//        			String status = comments.substring(comments.indexOf("EGFR status:")+12);
//        			if(status.contains("Current data ")) {
//        				status = status.substring(0,status.indexOf("Current data "));
//            		}
//        			else if(status.contains("Test Performed")) {
//        				status = status.substring(0,status.indexOf("Test Performed"));
//            		}
//        			else if(status.contains("This specimen")) {
//        				status = status.substring(0,status.indexOf("This specimen"));
//            		}
//        			System.out.println(mrn+"\t"+status.trim());
//        			out.add(mrn+"\t"+date+"\tEGFR\t"+status.trim());
//        		}
//        		else if(comments.contains("BRAF status:")) {
//        			String status = comments.substring(comments.indexOf("BRAF status:")+12);
//        			if(status.contains("Current data ")) {
//        				status = status.substring(0,status.indexOf("Current data "));
//            		}
//        			else if(status.contains("Test Performed")) {
//        				status = status.substring(0,status.indexOf("Test Performed"));
//            		}
//        			else if(status.contains("This specimen")) {
//        				status = status.substring(0,status.indexOf("This specimen"));
//            		}
//        			System.out.println(mrn+"\t"+status.trim());
//        			out.add(mrn+"\t"+date+"\tBRAF\t"+status.trim());
//        		}
//        		else if(comments.contains("KRAS status:")) {
//        			String status = comments.substring(comments.indexOf("KRAS status:")+12);
//        			if(status.contains("Current data ")) {
//        				status = status.substring(0,status.indexOf("Current data "));
//            		}
//        			else if(status.contains("Test Performed")) {
//        				status = status.substring(0,status.indexOf("Test Performed"));
//            		}
//        			else if(status.contains("This specimen")) {
//        				status = status.substring(0,status.indexOf("This specimen"));
//            		}
//        			System.out.println(mrn+"\t"+status.trim());
//        			out.add(mrn+"\t"+date+"\tKRAS\t"+status.trim());
//        		}
	        	
	        	//EGFR,BRAF,KRAS diagnosis
        		String diagnosis = ".";
        		Pattern pat = Pattern.compile("Provided diagnosis: ([A-Za-z0-9\\s-,/;()#]+)(\\.)? (A (gene )?fusion|A rearrangement|The following|No (additional )?reportable|(EGFR|BRAF|KRAS) status:)");
        		Matcher mat = pat.matcher(comments);
	        	if(mat.find()) {
	        		diagnosis = mat.group(1);
        		}
	        	out.add(mrn+"\t"+date+"\t"+diagnosis);
	        	if(diagnosis.equals(".")) {
	        		System.out.println(comments);
	        	}
	        }
	    }
    }
    
    public static void readTXT(String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
        		String mrn = line.split("\t")[0];
	        	String race = line.split("\t")[3].replace("African American","Black or African American").replace("American born African","Black or African American").replaceAll("African(?!\\s)","Black or African American").replace("American Indian/Alaskan Native Northern Plains region native","American Indian/ Alaska Native").replace("American Indian/Alaskan Native","American Indian/ Alaska Native").replace("Asian Chinese","Asian").replace("Asian Filipino","Asian").replace("Asian Indian","Asian").replace("Asian Japanese","Asian").replace("Asian Korean","Asian").replace("Asian Other","Asian").replace("Asian Vietnamese","Asian").replace("Caribbean Black","Black or African American").replace("Choose Not to Disclose","Unknown or Not Reported").replace("Native Hawaii/Pacific Islander","Native Hawaiian or Other Pacific Islander").replace("Native Hawaiian/Pacific Islander","Native Hawaiian or Other Pacific Islander").replace("Other","Unknown or Not Reported").replace("Unable to Provide","Unknown or Not Reported").replaceAll("Unknown(?!\\s)","Unknown or Not Reported");
	        	String ethn = line.split("\t")[4].replace("Mexican", "Hispanic or Latino").replace("Central American", "Hispanic or Latino").replace("Cuban", "Hispanic or Latino").replace("Puerto Rican", "Hispanic or Latino").replace("South American", "Hispanic or Latino").replace("Other Spanish culture of origin regardless of race (except Spain)", "Hispanic or Latino").replace("Choose Not to Disclose", "Unknown");
	        	String death = line.split("\t")[5];
	        	id.put(mrn, race+"\t"+ethn+"\t"+death);
	        	System.out.println(mrn+"\t"+race+"\t"+ethn+"\t"+death);
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line;
	        	out.add(mrn+"\t"+id.get(mrn));
	        	System.out.println(mrn+"\t"+id.get(mrn));
	        }
	    }
	}
    
    public static void cleanTXT(String file) throws IOException, ParserConfigurationException, SAXException{
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; String line1 = "";

	        while ((line = br.readLine()) != null) {
	        	line = matchAndReplaceNonEnglishChar(line);
	        	if(line.contains("\"")&&!line.endsWith("\"")) {
	        		line1 = line;
	        		System.out.println(line1);
	        	}
	        	else if (line.split("\t").length<3) {
	        		System.out.println(line);
	        		line1 = line1+" "+line;
	        		if(line1.contains("\"")&&!line1.endsWith("\"")) {
		        		continue;
		        	}
	        		else {
	        			out.add(line1.trim());
		        		line1 = "";
	        		}
	        	}
	        	else{
	        		out.add(line);
	        	}
	        	
	        }
	    }
	}
    
    public static void SFIPF(String file) throws IOException, ParserConfigurationException, SAXException{
    	
    	HashMap<String,Integer> count = new HashMap<String,Integer>();
    	int pt = 0;
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; 
	        
	        while ((line = br.readLine()) != null) {
	        	if(line.startsWith("PATIENT")) {
	        		continue;
	        	}
        		String mrn = line.split("\t")[0];
	        	String s = removeStopWords(line.replace("\t", "").replace(mrn, "").replaceAll("[\\p{Punct}]+"," ").replaceAll("\\s+", " ").trim());
	        	
	        	if(count.get(s)!=null){
	        		int i = count.get(s);
	        		i++;
	        		count.put(s, i);
	        	}
	        	else count.put(s, 1);
	        	
	        	if(id.get(s)!=null){
	        		String add = id.get(s);
	        		add = add +"\t"+ mrn;
	        		id.put(s, add);
	        	}
	        	else {
	        		id.put(s, mrn);
	        		pt++;
	        	}
	        }
	    }
//	    System.out.println(pt);
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; 

	        while ((line = br.readLine()) != null) {
	        	if(line.startsWith("PATIENT")) {
	        		continue;
	        	}
        		String mrn = line.split("\t")[0];
	        	String s = removeStopWords(line.replace("\t", "").replace(mrn, "").replaceAll("[\\p{Punct}]+"," ").replaceAll("\\s+", " ").trim());
	        	int pf = count.get(s);
	        	System.out.println(s);
	        	int sf = id.get(s).split("\t").length;
	        	double sfipf = ((double)1/sf)*((double)Math.log(pt)/pf);
	        	System.out.println(s+"\t"+sf+"\t"+pf+"\t"+sfipf);
	        	out.add(line+"\t"+s+"\t"+sf+"\t"+pf+"\t"+sfipf);
	        }
	    }
	}
    
    public static void PMI(String file) throws IOException, ParserConfigurationException, SAXException{
    	
    	HashMap<String,Integer> No = new HashMap<String,Integer>();
    	HashMap<String,Integer> Nco = new HashMap<String,Integer>();
    	int Nc=0; int N=0;
    	ArrayList<String> word = new ArrayList<>();
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; 
	        
	        while ((line = br.readLine()) != null) {
	        	if(line.startsWith("ANNOTATION")) {
	        		continue;
	        	}
        		String s = line.replaceAll("(?i)vus", "vusvus").toLowerCase().split("\t")[0];
        		for(String a : s.split(" ")) {
        			if(a.length()>3) {
        				word.add(a);
        			}
        		}
	        	in.add(s);
	        	N++;
	        }
	    }
	    removeDuplicates(word);
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; 

	        while ((line = br.readLine()) != null) {
	        	if(line.startsWith("ANNOTATION")) {
	        		continue;
	        	}
	        	
        		String s = line.replaceAll("(?i)vus", "vusvus").toLowerCase().split("\t")[0];	        	
        		String category = line.toLowerCase().split("\t")[1];
	        	for(String w : word) {
	        		if(s.contains(w)) {
		        		if(No.get(w)!=null) {
		        			int c = No.get(w);
		        			c++;
		        			No.put(w, c);
		        		}
		        		else No.put(w, 1);
		        	}
        		}
	        	
//	        	if(category.equals("discuss")) {
        		if(category.equals("estimate")) {
//        		if(category.equals("insurance")) {
//        		if(category.equals("negative")) {
//        		if(category.equals("order")) {
//        		if(category.equals("positive")) {
//        		if(category.equals("vus")) {
	        		for(String w : word) {
		        		if(s.contains(w)) {
			        		if(Nco.get(w)!=null) {
			        			int c = Nco.get(w);
			        			c++;
			        			Nco.put(w, c);
			        		}
			        		else Nco.put(w, 1);
			        	}
	        		}
	        		Nc++;
	        	}
	        }
	    }
	    
	    for(String w : word) {
	    	if(Nco.get(w)!=null) {
		    	System.out.println(w+"\t"+Nco.get(w)+"\t"+No.get(w)+"\t"+Nc+"\t"+N);
		    	double ineq = Math.log((double)Nco.get(w))*(Math.log(((double)Nco.get(w)+0.01)/(double)Nco.get(w))-Math.log((double)Nc/(double)N));
		    	out.add(w+"\t"+ineq);
	    	}
		}
	}
    
    public static void supportX(String file) throws IOException, ParserConfigurationException, SAXException{
    	
    	HashMap<String,Integer> count = new HashMap<String,Integer>();
    	ArrayList<String> in = new ArrayList<>();
    	
    	try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Downloads/in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	line = line.replace("\"", "").toLowerCase();
	        	in.add(line);

	        }
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; 
	        
	        while ((line = br.readLine()) != null) {
	        	
	        	line = line.toLowerCase();
	        	
	        	for(String i : in) {
	        		int c = 0;
	        		
	        		if(count.get(i)!=null) {
	        			c = count.get(i);
	        		}
	        		
	        		if(line.contains(i+"|")||line.contains("|"+i)) {
	        			c++;
	        			count.put(i, c);
		        		System.out.println(i+"\t"+c);
	        		}
	        	}
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Downloads/in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	line = line.toLowerCase();
	        	out.add(line+"\t"+count.get(line));

	        }
	    }
	}
    
    public static void getMed(String file) throws FileNotFoundException, IOException, java.text.ParseException {
	    	
		    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		
		        String line = "";
	
		        while ((line = br.readLine()) != null) {
		        	String drug = line.toLowerCase();
		        	
//		        	if(line.startsWith("PATIENT")) {
//		        		continue;
//		        	}
		        	
		        	//OB
//		        	if(!(drug.equals("5 fu")||drug.equals("5-fu")||drug.equals("abemaciclib")||drug.equals("abraxane")||drug.equals("ado trastuzumab emtansine")||drug.equals("ado-trastuzumab emtansine")||drug.equals("afinitor")||drug.equals("alkeran")||drug.equals("alpelisib")||drug.equals("anastrozole")||drug.equals("aredia")||drug.equals("arimidex")||drug.equals("aromasin")||drug.equals("atezolizumab")||drug.equals("avastin")||drug.equals("bevacizumab")||drug.equals("bleomycin")||drug.equals("capecitabine")||drug.equals("carboplatin")||drug.equals("cisplatin")||drug.equals("cyclophosphamide")||drug.equals("docetaxel")||drug.equals("doxil")||drug.equals("doxorubicin")||drug.equals("ellence")||drug.equals("enhertu")||drug.equals("epirubicin")||drug.equals("eribulin")||drug.equals("everolimus")||drug.equals("exemestane")||drug.equals("fareston")||drug.equals("faslodex")||drug.equals("femara")||drug.equals("fluorouracil")||drug.equals("fulvestrant")||drug.equals("gemcitabine")||drug.equals("gemzar")||drug.equals("goserelin acetate")||drug.equals("halaven")||drug.equals("herceptin")||drug.equals("herceptin hylecta")||drug.equals("hycamtin")||drug.equals("ibrance")||drug.equals("ixabepilone")||drug.equals("ixempra")||drug.equals("kadcyla")||drug.equals("keytruda")||drug.equals("kisqali")||drug.equals("lapatinib")||drug.equals("letrozole")||drug.equals("lynparza")||drug.equals("megestrol")||drug.equals("melphalan")||drug.equals("methotrexate")||drug.equals("mvasi")||drug.equals("neratinib")||drug.equals("nerlynx")||drug.equals("niraparib")||drug.equals("olaparib")||drug.equals("paclitaxel")||drug.equals("palbociclib")||drug.equals("pamidronate")||drug.equals("pembrolizumab")||drug.equals("perjeta")||drug.equals("pertuzumab")||drug.equals("piqray")||drug.equals("ribociclib")||drug.equals("rubraca")||drug.equals("rucaparib")||drug.equals("talazoparib")||drug.equals("talzenna")||drug.equals("tamoxifen")||drug.equals("taxol")||drug.equals("taxotere")||drug.equals("tecentriq")||drug.equals("thiotepa")||drug.equals("topotecan")||drug.equals("toremifene")||drug.equals("trastuzumab")||drug.equals("trastuzumab and hyaluronidase")||drug.equals("trexall")||drug.equals("tykerb")||drug.equals("verzenio")||drug.equals("vinblastine")||drug.equals("xeloda")||drug.equals("zejula")||drug.equals("zoladex"))){
//		        		 out.add(".");
//		        		 continue;
//		        	}
		        	
		        	//Lung
//		        	if(!(drug.contains("afatinib")||drug.contains("everolimus")||drug.contains("alectinib")||drug.contains("pemetrexed")||drug.contains("brigatinib")||drug.contains("bevacizumab")||drug.contains("ramucirumab")||drug.contains("afatinib")||drug.contains("gemcitabine")||drug.contains("durvalumab")||drug.contains("gefitinib")||drug.contains("pembrolizumab")||drug.contains("lorlatinib")||drug.contains("trametinib")||drug.contains("mechlorethamine")||drug.contains("vinorelbine")||drug.contains("nivolumab")||drug.contains("carboplatin")||drug.contains("necitumumab")||drug.contains("entrectinib")||drug.contains("dabrafenib")||drug.contains("osimertinib")||drug.contains("erlotinib")||drug.contains("paclitaxel")||drug.contains("docetaxel")||drug.contains("atezolizumab")||drug.contains("methotrexate")||drug.contains("dacomitinib")||drug.contains("crizotinib")||drug.contains("ceritinib")||drug.contains("etoposide")||drug.contains("topotecan")||drug.contains("abraxane")||drug.contains("afinitor")||drug.contains("alecensa")||drug.contains("alimta")||drug.contains("alunbrig")||drug.contains("avastin")||drug.contains("cyramza")||drug.contains("doxorubicin")||drug.contains("gilotrif")||drug.contains("gemzar")||drug.contains("imfinzi")||drug.contains("iressa")||drug.contains("keytruda")||drug.contains("lorbrena")||drug.contains("mekinist")||drug.contains("mustargen")||drug.contains("mvasi")||drug.contains("navelbine")||drug.contains("opdivo")||drug.contains("paraplat")||drug.contains("paraplatin")||drug.contains("portrazza")||drug.contains("rozlytrek")||drug.contains("tafinlar")||drug.contains("tagrisso")||drug.contains("tarceva")||drug.contains("taxol")||drug.contains("taxotere")||drug.contains("tecentriq")||drug.contains("trexall")||drug.contains("vizimpro")||drug.contains("xalkori")||drug.contains("zykadia")||drug.contains("etopophos")||drug.contains("etoposide")||drug.contains("hycamtin"))) {
//		        		 out.add(".");
//		        		 continue;
//		        	}
//
//	        		out.add("Lung");
//	        		System.out.println(drug);
		        	
		        	//Lung
//		        	Pattern pat = Pattern.compile("(afatinib|everolimus|alectinib|pemetrexed|brigatinib|bevacizumab|ramucirumab|afatinib|gemcitabine|durvalumab|gefitinib|pembrolizumab|lorlatinib|trametinib|mechlorethamine|vinorelbine|nivolumab|carboplatin|necitumumab|entrectinib|dabrafenib|osimertinib|erlotinib|paclitaxel|docetaxel|atezolizumab|methotrexate|dacomitinib|crizotinib|ceritinib|etoposide|topotecan|abraxane|afinitor|alecensa|alimta|alunbrig|avastin|cyramza|doxorubicin|gilotrif|gemzar|imfinzi|iressa|keytruda|lorbrena|mekinist|mustargen|mvasi|navelbine|opdivo|paraplat|paraplatin|portrazza|rozlytrek|tafinlar|tagrisso|tarceva|taxol|taxotere|tecentriq|trexall|vizimpro|xalkori|zykadia|etopophos|etoposide|hycamtin)");

		        	//All
		        	Pattern pat = Pattern.compile("(abemaciclib|abexinostat|abiraterone|acalabrutinib|aclarubicin|ado trastuzumab emtansine|ado-trastuzumab emtansine|afatinib|afuresertib|aldesleukin|alectinib|alemtuzumab|alisertib|all trans retinoic acid|all-trans retinoic acid|alpelisib|altretamine|alvocidib|amg 330|aminoglutethimide|aminopterin|amrubicin|amsacrine|anastrozole|antithymocyte globulin|antithymocyte globulin, horse atg|antithymocyte globulin, rabbit atg|apatinib|asciminib|asparaginase|atezolizumab|avapritinib|avelumab|axicabtagene ciloleucel|axitinib|azacitidine|bacillus calmette guerin|bacillus calmette-guerin|barasertib|bb2121|belagenpumatucel l|belagenpumatucel-l|belinostat|belotecan|bendamustine|bevacizumab|bevacizumab|bevacizumab awwb|bevacizumab bvzr|bevacizumab-awwb|bevacizumab-bvzr|bexarotene|binimetinib|bl22 immunotoxin|bleomycin|blinatumomab|bortezomib|bosutinib|brentuximab vedotin|brigatinib|buparlisib|busulfan|cabazitaxel|cabozantinib|calaspargase|capecitabine|capivasertib|carboplatin|carfilzomib|carmustine|carmustine wafer|carmustine wafer, polifeprosan 20|catumaxomab|cediranib|cemiplimab|ceritinib|cetuximab|chidamide|chlorambucil|cisplatin|cladribine|clinical study drug|clofarabine|cobimetinib|coltuximab ravtansine|copanlisib|cortisone|crenolanib|crizotinib|custirsen|cyclophosphamide|cyclosporine modified|cyclosporine non modified|cyclosporine non-modified|cyproterone acetate|cytarabine|cytarabine and daunorubicin liposomal|cytarabine liposomal|dabrafenib|dabrafenib+trametinib|dacarbazine|dacomitinib|dactinomycin|dasatinib|daunorubicin|daunorubicin liposomal|decitabine|degarelix|denileukin diftitox|denintuzumab mafodotin|dexamethasone|dinaciclib|docetaxel|dovitinib|doxifluridine|doxorubicin|doxorubicin pegylated liposomal|durvalumab|dutasteride|duvelisib|enasidenib|encorafenib|enfortumab vedotin|ensartinib|entinostat|entospletinib|entrectinib|epirubicin|erdafitinib|eribulin|erlotinib|estramustine|etoposide|everolimus|exemestane|fam trastuzumab deruxtecan|fam-trastuzumab deruxtecan|fedratinib|filanesib|finasteride|floxuridine|fludarabine|fluorouracil|fluoxymesterone|forodesine|fostamatinib|fotemustine|fruquintinib|fulvestrant|galeterone|ganetespib|gefitinib|gemcitabine|gemtuzumab ozogamicin|gilteritinib|glasdegib|goserelin|guadecitabine|hematopoetic progenitor cells|hematopoetic progenitor cells, cord blood|heptaplatin|herceptin|histrelin|hydrocortisone|hydroxyurea|ibritumomab tiuxetan|ibrutinib|icotinib|idarubicin|idelalisib|ifosfamide|imatinib|imetelstat|infigratinib|inotuzumab ozogamicin|interferon alfa 2a|interferon alfa 2b|interferon alfa-2a|interferon alfa-2b|interferon gamma 1b|interferon gamma-1b|ipatasertib|ipilimumab|ipiliumamab|irinotecan|irinotecan liposome|isotretinoin|ivosidenib|ixabepilone|ixazomib|ketoconazole|lanreotide|lapatinib|lapuleucel t|lapuleucel-t|larotrectinib|lenalidomide|lenvatinib|lestaurtinib|letrozole|leuprolide|lobaplatin|lomustine|lorlatinib|masitinib|mechlorethamine|megestrol|melphalan|mercaptopurine|methotrexate|methylprednisolone|midostaurin|mitomycin|mitoxantrone|mocetinostat|momelotinib|motesanib|moxetumomab pasudotox|necitumumab|nedaplatin|nelarabine|neratinib|nilotinib|nimustine|nintedanib|niraparib|nivolumab|nolatrexed|non pegylated liposomal doxorubicin|non-pegylated liposomal doxorubicin|obinutuzumab|octreotide|octreotide lar|ofatumumab|olaparib|olaratumab|omacetaxine|oprozomib|orteronel|osimertinib|oxaliplatin|paclitaxel|paclitaxel protein-bound|paclitaxel, nanoparticle albumin bound|paclitaxel, nanoparticle albumin-bound|pacritinib|palbociclib|panitumumab|panobinostat|pazopanib|pegaspargase|peginterferon alfa 2a|peginterferon alfa 2b|peginterferon alfa-2a|peginterferon alfa-2b|pegylated liposomal doxorubicin|pembrolizumab|pemetrexed|pentostatin|perifosine|pertuzumab|pictilisib|pidilizumab|pirarubicin|pixantrone|plicamycin|polatuzumab vedotin|pomalidomide|ponatinib|pracinostat|pralatrexate|prednisolone|prednisone|procarbazine|quisinostat|quizartinib|radotinib|raloxifene|raltitrexed|ramucirumab|ranimustine|refametinib|regorafenib|retaspimycin|ribociclib|ricolinostat|rilotumumab|rituximab|rituximab abbs|rituximab pvvr|rituximab-abbs|rituximab-pvvr|rociletinib|romidepsin|ropeginterferon alfa 2b|ropeginterferon alfa-2b|rucaparib|ruxolitinib|sacituzumab govitecan|sapacitabine|selinexor|selumetinib|semustine|sipuleucel t|sipuleucel-t|sirolimus|sonidegib|sorafenib|spebrutinib|streptozocin|sunitinib|tacrolimus|talazoparib|talimogene laherparepvec|tamibarotene|tamoxifen|tazemetostat|tegafur and uracil|tegafur gimeracil oteracil|tegafur, gimeracil, oteracil|telotristat|temozolomide|temsirolimus|teniposide|tesetaxel|thalidomide|thioguanine|thiotepa|tipifarnib|tisagenlecleucel|tivantinib|tivozanib|tofacitinib|topotecan|toremifene|tosedostat|tositumomab & i 131|tositumomab & i-131|trabectedin|trametinib|trastuzumab|trastuzumab and hyaluronidase|trastuzumab anns|trastuzumab dkst|trastuzumab dttb|trastuzumab pkrb|trastuzumab qyyp|trastuzumab-anns|trastuzumab-dkst|trastuzumab-dttb|trastuzumab-pkrb|trastuzumab-qyyp|trebananib|tremelimumab|treosulfan|trifluridine and tipiracil|trimethoprim sulfamethoxazole|trimethoprim-sulfamethoxazole|triptorelin|uracil mustard|vadastuximab talirine|valacyclovir|valganciclovir|valproate|valrubicin|vandetanib|veliparib|veltuzumab|vemurafenib|vemurafenib+cobimetinib|venetoclax|vinblastine|vincristine|vincristine liposomal|vindesine|vinflunine|vinorelbine|vismodegib|volasertib|vorinostat|vosaroxin|zanubrutinib|ziv aflibercept|ziv-aflibercept)");
		        	Matcher mat = pat.matcher(drug);
		        	String output= ".";
		        	while(mat.find()) {
		        		System.out.println(output +"\t"+ mat.group());
		        		if(!output.equals(".")) {
		        			if(!output.contains(mat.group())) {
		        				output = output +","+ mat.group();
		        			}
		        		}
		        		else output = mat.group();
		        	}
		        	out.add(output);
	        		
//		        	System.out.println(line);
//		        	String sec = line.split("\t")[2];
//		        	String hx = line.split("\t")[8];
		        	
		        	//Current
//		        	if(sec.equals("20104")||sec.equals("20133")||sec.equals("20160")) {
//		        		out.add(line.split("\t")[0]+"\t"+line.split("\t")[1]+"\t"+line.split("\t")[5]+"\t"+line.split("\t")[6]);
//		        	}
		        	
		        	//Hx
//		        	if(!(sec.equals("20104")||sec.equals("20133")||sec.equals("20160"))&&!hx.equals(".")) {
//		        		out.add(line.split("\t")[0]+"\t"+line.split("\t")[8]+"\t"+line.split("\t")[5]+"\t"+line.split("\t")[6]);
//		        	}
		        	
		        	//CN
//		        	if(!(sec.equals("20104")||sec.equals("20133")||sec.equals("20160"))&&hx.equals(".")) {
//		        		out.add(line.split("\t")[0]+"\t"+line.split("\t")[1]+"\t"+line.split("\t")[4]+"\t"+line.split("\t")[5]+"\t"+line.split("\t")[6]);
//		        	}
		        }
		    }
	    }

    public static void getMedSum(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	System.out.println(line);
        		String mrn = line.split("\t")[0];
//	        	String date = line.split("\t")[1].split("T")[0];
//	        	String drug = line.split("\t")[2].toLowerCase();
//	        	String category = line.split("\t")[3].replace(", ", "|");
	        	String drug = line.split("\t")[2];
	        	String date = line.split("\t")[1];
	        	String category = line.split("\t")[3];
	        	
	        	if(line.startsWith("PATIENT")) {
	        		continue;
	        	}

	        	//get MedSum
//	        	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd"); 
//	        	Date MedDate = formatter.parse(date);
//	        	SimpleDateFormat formatter1=new SimpleDateFormat("m/d/yyyy"); 
//	        	Date MedDate = formatter1.parse(date);
//	        	Date ReportDate = formatter1.parse(line.split("\t")[4]);
//	        	long days = TimeUnit.DAYS.convert(MedDate.getTime() - ReportDate.getTime(), TimeUnit.MILLISECONDS);
//	        	if(days<-30) {
//	        		continue;
//	        	}
	        	
//	        	if(!category.contains("inhibitor")) {
//	        	if(category.equals("TRUE")) {
//	        		continue;
//	        	}
	        	
//	        	if(id.get(mrn)!=null) {
//	        		String s = id.get(mrn);
//	        		if(!s.contains(drug+"_"+category+"["+date+"]")) {
//	        			s = s + "," + drug+"_"+category+"["+date+"]";
//	        		}
//	        		id.put(mrn, s);
//	        	}
//	        	else id.put(mrn, drug+"_"+category+"["+date+"]");
//	        	System.out.println(mrn+"\t"+drug+"_"+category+"["+date+"]");
	        	
	        	if(id.get(mrn+"_"+drug)!=null) {
	        		String s = id.get(mrn+"_"+drug);
	        		if(!s.contains(category+"_"+date)) {
	        			s = s + "," + category+"_"+date;
	        		}
	        		id.put(mrn+"_"+drug, s);
	        	}
	        	else id.put(mrn+"_"+drug, category+"_"+date);
	        	System.out.println(mrn+"_"+drug+"\t"+category+"_"+date);
	        }
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
//	        	System.out.println(line);
	        	String mrn = line.split("\t")[0];
	        	out.add(line+"\t"+id.get(mrn));
	        	System.out.println(line+"\t"+id.get(mrn));
	        }
	    }
	    
//	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//    	
//        String line = "";
//
//        while ((line = br.readLine()) != null) {
//    		String mrn = line.split("\t")[0];
//        	String[] drugs = line.split("\t")[1].split(",");
//        	ArrayList<String> pt = new ArrayList<>();
//        	
//        	for(String d : drugs) {
//        		
//        	}
//        	
//        	if(id.get(mrn)!=null) {
//        		String s = id.get(mrn);
//        		if(!s.contains(drug+"["+date+"]")) {
//        			s = s + "," + drug+"["+date+"]";
//        		}
//        		id.put(mrn, s);
//        	}
//        	else id.put(mrn, drug+"["+date+"]");
//        	System.out.println(mrn+"\t"+drug+"["+date+"]");
//        }
//    }
    }
    
    public static void getCNSum(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	System.out.println(line);
        		String mrn = line.split("\t")[0];
	        	String text = line.split("\t")[1];
	        	
	        	if(line.startsWith("PATIENT")) {
	        		continue;
	        	}

	        	if(id.get(mrn)!=null) {
	        		String s = id.get(mrn);
	        		if(!s.contains(text)) {
	        			s = s + "||" + text;
	        		}
	        		id.put(mrn, s);
	        	}
	        	else id.put(mrn, text);
	        	System.out.println(mrn+"\t"+text);
	        }
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
//	        	System.out.println(line);
	        	String mrn = line.split("\t")[0];
	        	out.add(id.get(mrn));
	        	System.out.println(line+"\t"+id.get(mrn));
	        }
	    }
	    
//	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//    	
//        String line = "";
//
//        while ((line = br.readLine()) != null) {
//    		String mrn = line.split("\t")[0];
//        	String[] drugs = line.split("\t")[1].split(",");
//        	ArrayList<String> pt = new ArrayList<>();
//        	
//        	for(String d : drugs) {
//        		
//        	}
//        	
//        	if(id.get(mrn)!=null) {
//        		String s = id.get(mrn);
//        		if(!s.contains(drug+"["+date+"]")) {
//        			s = s + "," + drug+"["+date+"]";
//        		}
//        		id.put(mrn, s);
//        	}
//        	else id.put(mrn, drug+"["+date+"]");
//        	System.out.println(mrn+"\t"+drug+"["+date+"]");
//        }
//    }
    }
    
    public static void getMedFilterDate(String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String id = line.split("\t")[0];
	        	String test = line.split("\t")[1];
	        	String drug = line.split("\t")[2];
	        	SimpleDateFormat formatter0=new SimpleDateFormat("M/d/yy"); 
	        	SimpleDateFormat formatter=new SimpleDateFormat("M/d/yyyy");
	        	
	        	String afterTest = ""; String beforeTest = "";
	        	if(drug.contains("null")||test.equals("ReceivedDate")) {
	        		continue;
	        	}
	        	else {
	        		Date ResultDate = formatter0.parse(test);
	        		String[] drugs = drug.split(",");
	        		System.out.println(ResultDate);
	        		for(String d:drugs) {
	        			String med = d.substring(0, d.indexOf("_"));
	        			String category = d.substring(d.indexOf("_")+1, d.indexOf("["));
	        			String date = d.substring(d.indexOf("[")+1, d.indexOf("]"));
	        			Date MedDate = formatter.parse(date);
	        			if(MedDate.after(ResultDate)) {
	        				System.out.println(id+"\t"+med+"\t"+category+"\t"+date);
	        				out.add(id+"\t"+med+"\t"+category+"\t"+date);
	        			}
	        		}
	        	}
	        }
	    }
    }
    
    public static void getDx(String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
//        		String mrn = line.split("\t")[0];
//	        	String date = line.split("\t")[1];
//	        	String dise = line.split("\t")[4].toLowerCase();
//	        	
//	        	if(dise.equals("surgery")||dise.contains("metasta")||(dise.endsWith("oma")&&!dise.equals("coma"))||dise.contains("cancer")||dise.contains("carcinoma")) {
//	        		continue;
//	        	}
//	        	
//	        	out.add(line);
	        	
	        	String cancer_type = line.split("\t")[2];
	        	String codeType = line.split("\t")[1];
	        	String code = line.split("\t")[0];
	        	id.put(codeType+"\t"+code, cancer_type);
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
//	        	String mrn = line.split("\t")[0];
//	        	out.add(line+"\t"+id.get(mrn));
//	        	System.out.println(line+"\t"+id.get(mrn));
	        	
	        	if(line.split("\t").length<2) {
	        		out.add(line);
	        	}
	        	else {
	        		String codeType = line.split("\t")[0];
		        	String code = line.split("\t")[1];
		        	
		        	if(codeType.contains("ICD")&&codeType.contains("10")) {
		        		codeType = "I10";
		        	}
		        	
		        	if(codeType.contains("ICD")&&codeType.contains("9")) {
		        		codeType = "I9";
		        	}
		        	
		        	if(id.get(codeType+"\t"+code)!=null) {
		        		System.out.println(line+"\t"+id.get(codeType+"\t"+code));
		        		out.add(line+"\t"+id.get(codeType+"\t"+code));
		        	}
		        	else {
		        		out.add(line);
		        	}
	        	}
	        }
	    }
    }
    
    public static void getResist(String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
        		String mrn = line.split("\t")[0];
	        	String date = line.split("\t")[1].split("T")[0];
//	        	String resist = line.split("\t")[4].toLowerCase().replace("platinum ", "");
	        	String resist = line.split("\t")[2].toUpperCase();
	        	
	        	if(id.get(mrn)!=null) {
	        		String s = id.get(mrn);
	        		if(!s.contains(resist+"["+date+"]")) {
	        			s = s + "," + resist+"["+date+"]";
	        		}
	        		id.put(mrn, s);
	        	}
	        	else id.put(mrn, resist+"["+date+"]");
	        	System.out.println(mrn+"\t"+resist+"["+date+"]");
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	out.add(line+"\t"+id.get(mrn));
	        	System.out.println(line+"\t"+id.get(mrn));
	        }
	    }
    }
    
    public static void getADE(String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
        		String mrn = line.split("\t")[0];
	        	String date = line.split("\t")[1];
	        	String ade = line.split("\t")[4].toLowerCase().replace("rashes", "rash").replace("mouth sores", "mouth sore").replace("bruising", "bruise").replace("bleeding", "bleed").replace("vomiting", "vomit").replace("breathing", "breathe").replace("weakened immune system", "immune system");
	        	
	        	if(!ade.equals("immune")) {
		        	if(id.get(mrn)!=null) {
		        		String s = id.get(mrn);
		        		if(!s.contains(ade+"["+date+"]")) {
		        			s = s + "," + ade+"["+date+"]";
		        		}
		        		id.put(mrn, s);
		        	}
		        	else id.put(mrn, ade+"["+date+"]");
		        	System.out.println(mrn+"\t"+ade+"["+date+"]");
	        	}
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	out.add(line+"\t"+id.get(mrn));
	        	System.out.println(line+"\t"+id.get(mrn));
	        }
	    }
    }
    
	public static void getRecommendMed(String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	String drug = line.split("\t")[1].split("\\|")[0];
	        	if(id.get(mrn)!=null) {
	        		String s = id.get(mrn);
	        		if(!s.contains(drug)) {
	        			s = s + "," + drug;
	        		}
	        		id.put(mrn, s);
	        	}
	        	else id.put(mrn, drug);
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	out.add(line+"\t"+id.get(mrn));
	        	System.out.println(line+"\t"+id.get(mrn));
	        }
	    }
	}

	public static void getInfo(String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	id.put(mrn, line);
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	out.add(line+"\t"+id.get(mrn));
	        	System.out.println(line+"\t"+id.get(mrn));
	        }
	    }
	}

	public static void compareMed(String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	String recommend = line.split("\t")[0];
	        	String[] med = line.split("\t")[1].split(",");
	        	String s = ".";
	        	for(String m:med) {
	        		System.out.println(m.split("\\[")[0].trim());
	        		if(recommend.toLowerCase().contains(m.split("\\[")[0].trim())) {
	        			if(s.equals(".")) {
	        				s = m;
	        			}
	        			else if(!s.contains(m.split("\\[")[0].trim())) {
		        			s = s + "," + m;
		        		}
	        		}
	        	}
	        	out.add(s);
	        }
	    }
	}

	public static void readGene (String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	String gene = line.split("\t")[2];
	        	
//	        	Pattern pat = Pattern.compile("(BRCA)[0-9]{0,2}");
////	        	Pattern pat = Pattern.compile("(EGFR|BRAF|KRAS|HRAS|NRAS|ALK|ERBB2|MET)[0-9]{0,2}");
//	        	Matcher mat = pat.matcher(gene);
//	        	String output= "";
//	        	while(mat.find()) {
//	        		if(output.equals("")) {
//	        			output = mat.group();
//	        		}
//	        		else output = output + "," + mat.group();
//	        	}
	        	
	        	String output= ".";
	        	if(gene.toUpperCase().equals(gene)) {
	        		output = gene;
	        	}
	        	out.add(mrn+"\t"+output);
	        }
	    }
	    
	}
 
    public static void getFH(String file) throws IOException, ParserConfigurationException, SAXException{
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; 
	        
	        while ((line = br.readLine()) != null) {
		        	
        		String mrn = line.split("\t")[0];
	        	String date = line.split("\t")[1].split("T")[0];
	        	String fam = line.split("\t")[2];
	        	String sentence0 = line.split("\t")[3];
	        	String sentence = "";
	        	for (int i = 4; i < line.split("\t").length; i++) {
	        		sentence0 = sentence0 + " " + line.split("\t")[i];
	        	}
//	        	sentence = "B-cell lymphoma A A mother's sister";
//	        	sentence = sentence.replaceAll("father"," father ").replaceAll("mother"," mother ").replaceAll("parents"," parents ").replaceAll("parent"," parent ").replaceAll("nieces"," nieces ").replaceAll("niece"," niece ").replaceAll("nephews"," nephews ").replaceAll("nephew"," nephew ").replaceAll("uncles"," uncles ").replaceAll("uncle"," uncle ").replaceAll("sons"," sons ").replaceAll("son"," son ").replaceAll("sisters"," sisters ").replaceAll("sister"," sister ").replaceAll("siblings"," siblings ").replaceAll("sibling"," sibling ").replaceAll("daughters"," daughters ").replaceAll("daughter"," daughter ").replaceAll("cousins"," cousins ").replaceAll("cousin"," cousin ").replaceAll("children"," children ").replaceAll("children"," children ").replaceAll("child"," child ").replaceAll("brothers"," brothers ").replaceAll("brother"," brother ").replaceAll("aunts"," aunts ").replaceAll("aunt"," aunt ").replaceAll("grandparents"," grandparents ").replaceAll("grandparent"," grandparent ").replaceAll("grandmother"," grandmother ").replaceAll("grandfather"," grandfather ");
	        	sentence = sentence0.replaceAll(fam, " "+fam+" ").replaceAll("[\\p{Punct}&&[^\\.,;]]+"," ").replaceAll("\\.", " . ").replace(",", " , ").replace(";", " . ");
    			sentence = removeStopWords(matchAndReplaceNonEnglishChar(sentence)).replaceAll("\\s+", " ");
    			
    			String[] word = sentence.split(" ");
    			sentence = word[0];
    			for (int i = 1; i < word.length; i++) {
    				if(!word[i].equals("sA")&&!word[i].matches("[A-Z&&[^BT]]")&&!word[i].matches("[0-9]")) {
    					sentence = sentence + " " + word[i];
    				}
	        	}
    			
    			// extract FAMG
    			Pattern pat = Pattern.compile("\\b(?i)(father s sister)");
    			Matcher mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$paternal_aunt|FAMG$");
	        	}
	        	
	        	pat = Pattern.compile("\\b(?i)(mother s sister)");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$maternal_aunt|FAMG$");
	        	}
	        	
	        	pat = Pattern.compile("\\b(?i)(father s brother)");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$paternal_uncle|FAMG$");
	        	}
	        	
	        	pat = Pattern.compile("\\b(?i)(mother s brother)");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$maternal_uncle|FAMG$");
	        	}
	        	
	        	pat = Pattern.compile("\\b(?i)(father s)");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "paternal");
	        	}
	        	
	        	pat = Pattern.compile("\\b(?i)(mother s)");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "maternal");
	        	}
	        	
	        	pat = Pattern.compile("\\b(?i)(fathers|mothers|parents|sons|sisters|siblings|daughters|children|cousins|brothers|nieces|nephews|uncles|aunts|grandparents|grandmothers|grandfathers)\\b");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$"+mat.group().toLowerCase().replace(" ", "_")+"|FAMG$");
//	        		System.out.println(mat.group());
	        	}
	        	
	        	pat = Pattern.compile("\\b(?i)(father|mother|parent|son|sister|sibling|daughter|child|cousin|brother|niece|nephew|uncle|aunt|grandparent|grandmother|grandfather)\\b");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$"+mat.group().toLowerCase().replace(" ", "_")+"|FAMG$");
//	        		System.out.println(mat.group());
	        	}
	        	while(sentence.contains("|FAMG$s")) {
	            	sentence = sentence.replace("|FAMG$s", "|FAMG$");
	        	}
	        	while(sentence.contains("|FAMG$|FAMG$")) {
	            	sentence = sentence.replace("|FAMG$|FAMG$", "|FAMG$");
	        	}
	        	while(sentence.contains("$$")) {
	        		sentence = sentence.replace("$$", "$");
	        	}
	        	while(sentence.contains("_$")) {
	        		sentence = sentence.replace("_$", "_");
	        	}
	        	
	            pat = Pattern.compile("(?i)(grand\\s?)\\$([A-Za-z_\\s]{1,})\\|FAMG\\$");
	            mat = pat.matcher(sentence);
	            while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$"+mat.group(1).trim().toLowerCase()+mat.group(2).toLowerCase()+"|FAMG$");
	        	}

	            pat = Pattern.compile("(?i)(paternal|maternal)([A-Za-z\\s]{0,10})\\$([A-Za-z_\\s]{1,})\\|FAMG\\$");
	            mat = pat.matcher(sentence);
	            while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$"+mat.group(1).toLowerCase()+"_"+mat.group(3).toLowerCase()+"|FAMG$");
//	        		System.out.println(sentence);
	        	}

	            pat = Pattern.compile("\\$([A-Za-z_\\s]{1,})\\|FAMG\\$\\s?(?i)(paternal|maternal)");
	            mat = pat.matcher(sentence);
	            while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$"+mat.group(2).toLowerCase()+"_"+mat.group(1).toLowerCase()+"|FAMG$");
	        	}
	            
	        	pat = Pattern.compile("([A-Za-z]{1,})\\$son\\|FAMG\\$");
	        	mat = pat.matcher(sentence);
	            while (mat.find()) {
		            sentence = sentence.replace(mat.group(),mat.group(1)+"son");
	            }
	            
	        	pat = Pattern.compile("\\$(son|daughter|brother|sister)\\|FAMG\\$\\s?in\\s?law");
	        	mat = pat.matcher(sentence);
	            while (mat.find()) {
		            sentence = sentence.replace(mat.group(),mat.group(1)+" in law");
	            }
	            
	            pat = Pattern.compile("\\$([A-Za-z_\\s]{1,})\\|FAMG\\$( || and | or )[A-Za-z]{0,}\\s?\\$([A-Za-z_\\s]{1,})\\|FAMG\\$");
	            mat = pat.matcher(sentence);
	            while (mat.find()) {
	            	sentence = sentence.replace(mat.group(), "$"+mat.group(1)+"_and_"+mat.group(3)+"|FAMG$");
//	            	System.out.println(mat.group());
	            }

	            pat = Pattern.compile("\\$([A-Za-z_\\s]{1,})\\|FAMG\\$ s ([A-Za-z\\s]{0,10})(side|\\$([A-Za-z_\\s]{1,})\\|FAMG\\$)");
    			mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "$"+mat.group().replaceAll(" ", "_")+"|DISTFAMG$");
	        	}
	        	
	        	while(sentence.contains("|FAMG$_")) {
	            	sentence = sentence.replace("|FAMG$_", "_");
	        	}
	        	
	        	while(sentence.contains("|FAMG$|DISTFAMG$")) {
	            	sentence = sentence.replace("|FAMG$|DISTFAMG$", "|DISTFAMG$");
	        	}
	        	
	            // extract DISE
	            Pattern pat1 = Pattern.compile("\\b(?i)([a-z]{4,}) cell (cancer|tumor|tumour|carcinoma|cytoma|sarcoma|blastoma|trophoblastic|histiocytosis|leukemia|lymphoma|melanoma|glioma|matosis|malignancy|neoplasm)(s)?\\b");
	            Matcher mat1 = pat1.matcher(sentence);
	        	while(mat1.find()) {
	        		sentence = sentence.replace(mat1.group(), "$"+mat1.group().replace(" ", "_")+"|DISE$");
//	        		out.add(mat1.group().trim());
	        	}
	        	
		        pat1 = Pattern.compile("\\b(?i)(chronic |acute |benign )?([a-z]{4,})\\s?(cancer|tumor|tumour|carcinoma|cytoma|sarcoma|blastoma|trophoblastic|histiocytosis|leukemia|lymphoma|melanoma|glioma|matosis|malignancy|neoplasm)(s)?\\b");
	        	mat1 = pat1.matcher(sentence);
	        	while(mat1.find()) {
	        		if(mat1.group(2).matches("(deceased|recently|away|died|presents|getting|without|Other|with|includes|have|type|been|were|myRisk|from|given|family|known|increased|undergoing|recent|since|including|different|other|some|related|various|their|with|additional|common|known|with|have|developed|with|from|with|with|history|after|with|with|related)")) {
	        			sentence = sentence.replace(mat1.group(3), "$"+mat1.group(3)+"|DISE$");
//	        			out.add(mat1.group(3));
	        		}
	        		else if(mat1.group(2).matches("(American|patient|husband|Health|Southern|northern|Clinic|about|potential|year|discuss|regarding|risk)")) {
	        			continue;
	        		}
	        		else {	
	        			sentence = sentence.replace(mat1.group(), "$"+mat1.group().toLowerCase().replace(" ", "_")+"|DISE$");
//	        			out.add(mat1.group());
	        		}
	        	}
	        	
	            pat1 = Pattern.compile("\\b(?i)(cancer|tumor|tumour|carcinoma|sarcoma|blastoma|leukemia|lymphoma|melanoma|glioma|malignancy|neoplasm)(s)?\\b");
	            mat1 = pat1.matcher(sentence);
	        	while(mat1.find()) {
	        		sentence = sentence.replace(mat1.group(), "$"+mat1.group()+"|DISE$");
//	        		out.add(mat1.group().trim());
	        	}
	        	
		        pat1 = Pattern.compile("\\b(?i)([a-z]{4,}) ca\\b");
	        	mat1 = pat1.matcher(sentence);
	        	while(mat1.find()) {
	        		sentence = sentence.replace(mat1.group(), "$"+mat1.group(1).toLowerCase()+"_cancer"+"|DISE$");
//	        		out.add(mat1.group(1)+" cancer");
	        	}
	        	while(sentence.contains("|DISE$s")) {
	            	sentence = sentence.replace("|DISE$s", "|DISE$");
	        	}
	        	while(sentence.contains("|DISE$|DISE$")) {
	            	sentence = sentence.replace("|DISE$|DISE$", "|DISE$");
	        	}
	        	while(sentence.contains("$$")) {
	        		sentence = sentence.replace("$$", "$");
	        	}
	        	while(sentence.contains("_$")) {
	        		sentence = sentence.replace("_$", "_");
	        	}
	        	
	        	pat1 = Pattern.compile("(?i)(no|none) [a-z\\s]{0,25}\\$([A-Za-z_]{1,})\\|DISE\\$");
	            mat1 = pat1.matcher(sentence);
	        	while(mat1.find()) {
	        		sentence = sentence.replace(mat1.group(), "$"+mat1.group(1)+"_"+mat1.group(2)+"|NODISE$");
//	        		out.add(mat1.group().trim());
	        	}
	        	
	        	// extract and count SEM
	       		String[] sentences = null;
        		if(sentence.contains(".")) {
//        			System.out.println(sentence);
        			sentences = sentence.split("\\.");
        			
        			for(String s:sentences) {
        	        	if(s.contains("|DISE$")&&s.contains("|FAMG$")) {
	        	            String sem = ""; String famg = "";  String dise = "";
	        	            Pattern pat2 = Pattern.compile("\\$([A-Za-z_]{1,})\\|(FAMG|DISE)\\$");
	        	            Matcher mat2 = pat2.matcher(s);
	        	        	while(mat2.find()) {
//	        	        		System.out.println(mat2.group());
	        	        		if(sem.equals("")) {
	        	        			sem = "$"+mat2.group(2)+"$";
	        	        		}
	        	        		else sem = sem +" $"+mat2.group(2)+"$";
	        	        		
	        	        		if(mat2.group(2).equals("FAMG")) {
	        	        			if(famg.equals("")) {
	            	        			famg = mat2.group(1);
	            	        		}
	            	        		else famg = famg +","+mat2.group(1);
	        	        		}
	        	        		
	        	        		if(mat2.group(2).equals("DISE")) {
	        	        			if(dise.equals("")) {
	            	        			dise = mat2.group(1);
	            	        		}
	            	        		else dise = dise +","+mat2.group(1);
	        	        		}
	        	        		
	        	        	}
        	        	
        	        		out.add(mrn+"\t"+date+"\t"+sentence0+"\t"+s.trim()+"\t"+sem+"\t"+countOccurences(sem, "$FAMG$")+"\t"+countOccurences(sem, "$DISE$")+"\t"+famg+"\t"+dise);
        	        	}
        			}
        		}
        		else if(sentence.contains("|DISE$")&&sentence.contains("|FAMG$")) {
    	        	String sem = ""; String famg = "";  String dise = "";
    	            Pattern pat2 = Pattern.compile("\\$([A-Za-z_]{1,})\\|(FAMG|DISE)\\$");
    	            Matcher mat2 = pat2.matcher(sentence);
    	        	while(mat2.find()) {
    	        		
    	        		if(sem.equals("")) {
    	        			sem = "$"+mat2.group(2)+"$";
    	        		}
    	        		else sem = sem +" $"+mat2.group(2)+"$";
    	        		
    	        		if(mat2.group(2).equals("FAMG")) {
    	        			if(famg.equals("")) {
        	        			famg = mat2.group(1);
        	        		}
        	        		else famg = famg +","+mat2.group(1);
    	        		}
    	        		
    	        		if(mat2.group(2).equals("DISE")) {
    	        			if(dise.equals("")) {
        	        			dise = mat2.group(1);
        	        		}
        	        		else dise = dise +","+mat2.group(1);
    	        		}
    	        		
    	        	}
//    	        	System.out.println(mrn+"\t"+sentence+"\t"+sem);
	        		out.add(mrn+"\t"+date+"\t"+sentence0+"\t"+sentence.trim()+"\t"+sem+"\t"+countOccurences(sem, "$FAMG$")+"\t"+countOccurences(sem, "$DISE$")+"\t"+famg+"\t"+dise);
	        	}
	        }
	    }
	}
    
    public static void getFHSum(String file) throws IOException, ParserConfigurationException, SAXException{
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = ""; 
	        
	        while ((line = br.readLine()) != null) {
		        	
	        	if(line.startsWith("PATIENT")) {
   	        		continue;
   	        	}
	        	
        		String mrn = line.split("\t")[0];
        		String date = line.split("\t")[1];
        		String sentence = line.split("\t")[3];
   	        	String sem = line.split("\t")[4];
   	        	int famg0 = Integer.parseInt(line.split("\t")[5]);
        		String famg = line.split("\t")[7];
   	        	String dise = line.split("\t")[8];
   	        	
//   	        	System.out.println(famg+"\t"+dise);
   	        	if(famg0==1) {
   	        		if(famg.contains("_and_")) {
   	        			String[] famgs = famg.replaceAll("_and_", ",").split(",");
   	        			for(String f : famgs) {
   	        				if(f.endsWith("s")) {
   	        					f = f.substring(0, f.length()-1);
   	        				}
   	        				System.out.println(f+"\t"+dise);
   	        				if(dise.contains(",")) {
        						for(String dd:dise.split(",")){
        							out.add(mrn+"\t"+date+"\t"+sentence+"\t"+f+"\t"+dd);
        						}
  	        				}
        					else out.add(mrn+"\t"+date+"\t"+sentence+"\t"+f+"\t"+dise);
   	        			}
   	        		}
   	        		else {
   	        				if(famg.endsWith("s")) {
   	        					famg = famg.substring(0, famg.length()-1);
	        				}
   	        				System.out.println(famg+"\t"+dise);
   	        				if(dise.contains(",")) {
        						for(String dd:dise.split(",")){
        							out.add(mrn+"\t"+date+"\t"+sentence+"\t"+famg+"\t"+dd);
        						}
	        				}
   	        				else out.add(mrn+"\t"+date+"\t"+sentence+"\t"+famg+"\t"+dise);
   	        		}
   	        	}
   	        	else {
   	        		sentence = sentence.replaceAll("[0-9\\p{Punct}&&[^$_|]]+"," ").replaceAll("\\s+"," ");
   	        		String[] famgs = famg.split(","); 	
   	        		String[] dises = dise.split(",");
   	        		for(String f : famgs) {
   	        			for(String d : dises) {
   	        				int i = searchedWord(sentence, "$"+f+"|FAMG$");
   	   	        			int j = searchedWord(sentence, "$"+d+"|DISE$");
   	   	        			if(sem.startsWith("$DISE$")&&i-j<4&&i-j>0) {
	   	   	        			if(f.contains("_and_")) {
	   	    	        			String[] fs = famg.replaceAll("_and_", ",").split(",");
	   	    	        			for(String ff : fs) {
	   	    	        				if(ff.endsWith("s")) {
	   	    	        					ff = ff.substring(0, ff.length()-1);
	   	    	        				}
	   	    	        				System.out.println(ff+"\t"+d);
	   	    	        				out.add(mrn+"\t"+date+"\t"+sentence+"\t"+ff+"\t"+d);
	   	    	        			}
	   	    	        		}
	   	    	        		else {
	   	    	        			if(f.endsWith("s")) {
	   	   	        					f = f.substring(0, f.length()-1);
	   	   	        				}
	   	    	        			System.out.println(f+"\t"+d);
	   	    	        			out.add(mrn+"\t"+date+"\t"+sentence+"\t"+f+"\t"+d);
	   	    	        		}
   	   	        			}
   	   	        			else if(sem.startsWith("$FAMG$")&&j-i<4&&j-i>0){
//   	   	        				System.out.println(i+"\t$"+f+"|FAMG$\t"+j+"\t$"+d+"|DISE$");
	   	   	        			if(f.contains("_and_")) {
	   	    	        			String[] fs = famg.replaceAll("_and_", ",").split(",");
	   	    	        			for(String ff : fs) {
	   	    	        				if(ff.endsWith("s")) {
	   	    	        					ff = ff.substring(0, ff.length()-1);
	   	    	        				}
	   	    	        				System.out.println(ff+"\t"+d);
	   	    	        				out.add(mrn+"\t"+date+"\t"+sentence+"\t"+ff+"\t"+d);
	   	    	        			}
	   	    	        		}
	   	    	        		else {
	   	    	        			if(f.endsWith("s")) {
	   	   	        					f = f.substring(0, f.length()-1);
	   	   	        				}
	   	    	        			System.out.println(f+"\t"+d);
	   	    	        			out.add(mrn+"\t"+date+"\t"+sentence+"\t"+f+"\t"+d);
	   	    	        		}
   	    	        		}
   	   	        		}
   	        		}
   	        	}
	        }
	    }
    }
    
	public static void printFHSum (String file) throws FileNotFoundException, IOException {
		
    	HashMap<String,HashMap<String,String>> paternal = new HashMap<String,HashMap<String,String>>();
    	HashMap<String,HashMap<String,String>> maternal = new HashMap<String,HashMap<String,String>>();
    	HashMap<String,HashMap<String,String>> sibling = new HashMap<String,HashMap<String,String>>();
    	HashMap<String,HashMap<String,String>> other = new HashMap<String,HashMap<String,String>>();
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"temp.txt"))) {
	
	        String line = "";
	        	
	        while ((line = br.readLine()) != null) {
	        	
        		String mrn = line.split("\t")[0];
        		String famg = line.split("\t")[3];
   	        	String dise = line.split("\t")[4];
   	        	HashMap<String,String> p = new HashMap<String,String>();
   	        	
   	        	if(!dise.contains("breast")&&!dise.contains("ovar")&&!dise.contains("cerv")&&!dise.contains("uter")&&!dise.contains("colo")&&!dise.contains("pancrea")&&!dise.contains("rect")) {
   	        		continue;
   	        	}
   	        	
        		if(famg.contains("paternal")||famg.equals("father")) {
        			if(paternal.get(mrn)!=null) {
        				p = paternal.get(mrn);
        				if(p.get(famg)!=null) {
        					if(!p.get(famg).contains(dise)) {
        						String a = p.get(famg) + "," + dise;
            					p.put(famg, a);
        					}
        				}
        				else p.put(famg, dise);
        				paternal.put(mrn, p);
        			}
        			else {
        				p.put(famg, dise);
        				paternal.put(mrn, p);
        			}
        			System.out.println(p);
        		}
        		else if(famg.contains("maternal")||famg.equals("mother")) {
        			if(maternal.get(mrn)!=null) {
        				p = maternal.get(mrn);
        				if(p.get(famg)!=null) {
        					
        				}
        				else p.put(famg, dise);
        				maternal.put(mrn, p);
        			}
        			else {
        				p.put(famg, dise);
        				maternal.put(mrn, p);
        			}
        		}
        		else if(famg.contains("sibling")||famg.equals("brother")||famg.equals("sister")) {
        			if(sibling.get(mrn)!=null) {
        				p = sibling.get(mrn);
        				if(p.get(famg)!=null) {
        					if(!p.get(famg).contains(dise)) {
        						String a = p.get(famg) + "," + dise;
            					p.put(famg, a);
        					}
        				}
        				else p.put(famg, dise);
        				sibling.put(mrn, p);
        			}
        			else {
        				p.put(famg, dise);
        				sibling.put(mrn, p);
        			}
        		}
        		else {
        			if(other.get(mrn)!=null) {
        				p = other.get(mrn);
        				if(p.get(famg)!=null) {
        					if(!p.get(famg).contains(dise)) {
        						String a = p.get(famg) + "," + dise;
            					p.put(famg, a);
        					}
        				}
        				else p.put(famg, dise);
        				other.put(mrn, p);
        			}
        			else {
        				p.put(famg, dise);
        				other.put(mrn, p);
        			}
        		}
	        }
	        
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";
	        	
	        while ((line = br.readLine()) != null) {
	        	String p = ""; String m = ""; String s = ""; String o = "";
	        	int Np = 0; int Nm = 0; int Ns = 0; int No = 0; 
	        	if(paternal.get(line)!=null) {
	        		p = paternal.get(line).toString();
	        		Np = countOccurences(p.replaceAll("=", " = "), "=");
	        	}
	        	if(maternal.get(line)!=null) {
	        		m = maternal.get(line).toString();
	        		Nm = countOccurences(m.replaceAll("=", " = "), "=");
	        	}
	        	if(sibling.get(line)!=null) {
	        		s = sibling.get(line).toString();
	        		Ns = countOccurences(s.replaceAll("=", " = "), "=");
	        	}
	        	if(other.get(line)!=null) {
	        		o = other.get(line).toString();
	        		No = countOccurences(o.replaceAll("=", " = "), "=");
	        	}
	        	out.add(line+"\t"+p+"\t"+Np+"\t"+m+"\t"+Nm+"\t"+s+"\t"+Ns+"\t"+o+"\t"+No);
				System.out.println(line+"\t"+p+"\t"+Np+"\t"+m+"\t"+Nm+"\t"+s+"\t"+Ns+"\t"+o+"\t"+No);

	        }
	    }
	}
	
    public static void getSIDER() throws IOException, ParserConfigurationException, SAXException{
    	for (int i = 1; i < 167; i++) {
    	    String url ="http://sideeffects.embl.de/se/?page="+i; 
            Document doc = Jsoup.connect(url).get();
            Elements list = doc.select("ul.drugList").select("li");

            for (org.jsoup.nodes.Element l : list) {
            	
            	Elements link = l.select("a[href]");
                System.out.println(link.text());
                out.add(link.text());
            }
    	}
	}
    
    public static void getMayoClinicalTrials() throws IOException, ParserConfigurationException, SAXException{
    	String[] id = {"15-005692","19-005397","15-008231","16-008106","14-007429","17-002303","19-010598","15-007000","19-005263","12-002847","19-002006","10-004705","17-006002","16-003600","16-006015","18-004528","16-008368","12-007862","17-000325","13-006421","16-000383","16-000295","15-002704","15-004076","16-009443","17-000137","13-002454","15-009683","16-009051","17-000083","17-000083","14-000196","17-003347","19-001642","15-002590","13-004398","14-005666","15-008308","17-003758","19-002484","75-87","07-004144","07-005522","08-002807","07-007992","08-006431","776-01","09-004171","10-004585","09-008628","09-005470","919-04","11-001158","10-001281","11-000470","10-008061","11-000252","10-006192","11-001516","12-000043","12-003829","11-005505","12-002308","12-008166","12-004166","11-007114","16-004696","13-009137","13-008111","12-003940","12-007344","13-003230","11-001987","11-001987","15-003334","12-008547","13-005315","11-007407","13-008965","13-008965","13-006433","13-007743","12-010199","12-005272","13-009615","13-003730","14-003065","14-002616","18-000913","13-000808","13-009783","17-010030","17-010030","13-007529","13-003150","13-005106","14-002481","13-001863","13-005102","13-007530","13-007530","13-009098","13-009678","14-000401","14-003565","14-000561","17-005896","17-005896","13-009493","13-008314","12-007859","14-004298","14-002511","13-002492","12-005362","15-006212","14-000601","15-007304","13-007632","14-000308","14-004369","14-007730","13-002910","14-007253","14-004992","14-009102","16-004307","12-007265","17-008694","18-010102","14-006631","12-008570","14-004581","14-008328","16-004349","13-006592","16-000902","14-008096","14-004778","14-009235","14-002510","14-007316","14-002986","14-002307","16-002135","15-002004","14-000428","16-006425","15-003917","15-002198","15-000351","14-003571","15-006666","15-006013","15-007019","15-002864","17-000393","16-003152","16-009587","15-004377","15-004377","15-007958","15-007958","18-001458","15-006775","17-005070","16-000573","15-006705","15-007550","16-002058","15-009231","17-009575","16-000586","16-004140","15-006142","16-001142","16-000295","15-003188","16-001568","15-009538","15-008978","18-006628","18-006628","16-001431","16-001556","16-000769","15-004991","16-004456","16-004281","16-003118","15-007262","15-009700","15-009237","16-000585","16-004935","16-001778","17-004174","16-002191","16-003278","16-007453","16-004675","17-007205","17-007205","15-008089","18-000223","16-004322","15-005311","118-01","16-009457","16-007836","16-000438","16-009146","16-005438","16-005794","17-007464","17-005829","19-006717","16-002474","16-007512","15-000340","16-009086","16-002110","17-002105","17-002107","17-000106","18-011037","16-004083","17-008658","16-010555","17-005766","17-001459","16-006165","17-010609","16-009942","18-002227","17-002684","17-002684","17-000613","16-003030","16-009428","17-003810","17-003933","17-000127","18-000268","16-010553","16-010630","17-001268","17-001268","17-011074","16-009033","17-003039","16-004179","18-011002","18-011002","16-005474","16-002462","16-002462","16-001243","17-002137","16-005856","18-005844","18-000619","17-001423","17-002322","16-007782","16-008457","17-001343","17-007127","17-007127","17-006593","15-007000","18-004696","17-008898","16-008343","18-000708","18-006029","18-008859","20-003391","17-009273","17-005399","16-010066","17-009151","18-003782","17-005709","16-002965","17-003292","18-008045","17-009435","17-000793","16-007277","16-007277","18-006126","16-006072","18-000945","18-003847","19-002421","19-002421","17-006940","17-004492","17-010523","17-007110","16-002518","16-009691","17-008364","17-001020","17-006635","17-009282","16-008600","17-001666","18-003800","18-006386","19-004157","17-008515","17-002704","18-003801","18-001877","18-010052","18-000848","14-002566","17-006678","17-006678","18-001319","18-001564","17-008096","18-002213","17-010993","16-009337","17-004124","18-000521","17-005302","18-003720","18-002525","18-003250","17-007786","18-006869","18-003844","18-005888","18-005488","18-004855","18-005040","18-006060","18-006455","17-009383","18-006362","18-006038","18-010027","18-006041","18-006249","18-004262","19-003207","18-011203","18-011203","18-001318","18-003888","18-008687","18-009703","18-010674","18-010674","18-008702","19-002924","14-002919","19-000587","17-007708","19-004633","19-010862","19-000930","19-007321","17-007458","20-001187","19-008116","19-000578","19-002245","18-000991","19-006158","18-006090","19-005977","19-003173","19-003080","17-011198","19-005198","19-005198","19-011000","19-008252","19-001323","18-000734","19-008233","17-010660","18-007218","19-010052","19-004764","19-012508","19-012227","19-002657","19-010587","20-000071","19-011101","19-005001","19-004245","19-007775","20-002118","20-000573","19-006637","20-004600","19-010887","19-008858","20-008563","19-012801","19-012801","19-011871","20-003367","17-011342","16-002405","16-008106","15-000346","14-003521","10-004585","15-003163","15-008581","15-004559","15-000169","17-002951","16-001212","19-006093","18-007900","18-002576","15-006351","06-005263","09-000742","11-007268","11-007364","16-004913","15-000684","14-008514","15-003376","15-005860","15-005692","16-007840","16-002138","17-002325","17-003777","16-007773","18-000833","17-006773","17-002668","17-002668","18-010770","19-005251","19-008520","14-009613","20-008352","15-006348","17-001119","19-010567","13-000268","15-006775","14-000924","18-007113","15-007084","17-004507","17-002444","15-006203","17-001646","14-001719","18-000567","13-009767","17-002048","17-002697","16-006081","15-002123","15-002714","12-005263","10-000806","15-005755","17-003874","18-000065","15-007120","18-008163","19-004196","19-005001","19-004014","19-010348","19-004459","14-002919","15-000934","17-005571","18-002213","17-000393","14-007404","16-001219","14-006152","13-009003","15-000796","15-001099","15-000563","14-009826"};

    	try (PrintWriter writer = new PrintWriter(folder+"out.txt", "UTF-8")) {
    		for (int i = 0; i < id.length; i++) {
        		
        		String output="";
        		ArrayList<String> o = new ArrayList<>();
        		
        	    String url ="https://www.mayo.edu/research/clinical-trials/search-results?keyword="+id[i]; 
        	    System.out.println("url:"+url);
        	    Document doc = Jsoup.connect(url).get();
                Elements list = doc.select("a");

                for (org.jsoup.nodes.Element l : list) {
                	
                    if(l.attr("href").contains("clinical-trials/cls")&&!l.attr("href").contains("?")) {
                    	o.add(l.attr("href"));
                    }
                    
//                    removeDuplicates(o);
                }
                
                if(o.size()==0) {
                	o.add("");
                	continue;
                }
                
                String url1 = "https://www.mayo.edu"+o.get(0);
                System.out.println("url1:"+url1);
                output = url1;
                Document doc1 = Jsoup.connect(url1).get();
                Elements list1 = doc1.select("a");
                
                for (org.jsoup.nodes.Element l : list1) {
                	
                    if(l.attr("href").contains("nctid=")) {
                    	String[] ls = l.attr("href").split("&");
                    	for(String s:ls) {
                    		if(s.contains("nctid=")&&!s.equals("nctid=")) {
                    			output = s.replace("nctid=", "https://clinicaltrials.gov/ct2/show/");
                    		}
                    	}
                    }
                }
                
                System.out.println(output);
                
//                out.add(id[i]+"\t"+output);
                writer.println(id[i]+"\t"+output);
                writer.flush();
        	}
    		writer.close();
    	}
    	
	}
	   
    public static void getClinicalTrials() throws IOException, ParserConfigurationException, SAXException{
    	String[] id = {"NCT00082745","NCT00291096","NCT00392327","NCT00450814","NCT00499330","NCT00644228","NCT00670358","NCT00887146","NCT00948675","NCT00983619","NCT00983697","NCT00983697","NCT01012817","NCT01042379","NCT01077453","NCT01137643","NCT01196390","NCT01229865","NCT01261247","NCT01262235","NCT01286168","NCT01295827","NCT01342770","NCT01415882","NCT01431209","NCT01440088","NCT01453205","NCT01460134","NCT01515787","NCT01546571","NCT01574716","NCT01592370","NCT01628640","NCT01659203","NCT01668719","NCT01670877","NCT01694277","NCT01712217","NCT01723774","NCT01737502","NCT01737502","NCT01767675","NCT01781468","NCT01787409","NCT01814813","NCT01822496","NCT01828346","NCT01842308","NCT01863550","NCT01863550","NCT01879306","NCT01893307","NCT01901094","NCT01905657","NCT01905813","NCT01919749","NCT01932697","NCT01937117","NCT01938001","NCT01939223","NCT01949337","NCT01953588","NCT01953926","NCT01957956","NCT01964430","NCT01968109","NCT01968109","NCT01969643","NCT01975519","NCT01991977","NCT02017717","NCT02020707","NCT02020720","NCT02024607","NCT02024607","NCT02029690","NCT02031419","NCT02037529","NCT02038946","NCT02048371","NCT02048722","NCT02048813","NCT02049905","NCT02052778","NCT02052778","NCT02057133","NCT02063698","NCT02068794","NCT02073123","NCT02083484","NCT02086552","NCT02086695","NCT02091141","NCT02101775","NCT02111941","NCT02122185","NCT02122861","NCT02123511","NCT02128282","NCT02129101","NCT02142738","NCT02143401","NCT02143726","NCT02147990","NCT02152137","NCT02152982","NCT02157792","NCT02179086","NCT02188745","NCT02194738","NCT02219789","NCT02222363","NCT02229539","NCT02231723","NCT02265341","NCT02266745","NCT02268253","NCT02283658","NCT02286492","NCT02292758","NCT02300545","NCT02301039","NCT02301104","NCT02301611","NCT02305758","NCT02306161","NCT02311933","NCT02312245","NCT02320305","NCT02332980","NCT02335411","NCT02343120","NCT02349412","NCT02357810","NCT02360215","NCT02362035","NCT02364713","NCT02368886","NCT02376699","NCT02383212","NCT02383368","NCT02383927","NCT02387125","NCT02392637","NCT02393690","NCT02402244","NCT02413489","NCT02414139","NCT02432690","NCT02445976","NCT02447003","NCT02453737","NCT02457910","NCT02460198","NCT02464007","NCT02464228","NCT02465060","NCT02465060","NCT02466009","NCT02475213","NCT02475213","NCT02483858","NCT02490878","NCT02499120","NCT02499120","NCT02513394","NCT02513394","NCT02519348","NCT02520011","NCT02523014","NCT02523014","NCT02539719","NCT02546531","NCT02551991","NCT02559492","NCT02562716","NCT02563002","NCT02565758","NCT02567435","NCT02568267","NCT02574455","NCT02581631","NCT02583165","NCT02585713","NCT02588261","NCT02595424","NCT02595424","NCT02595944","NCT02598726","NCT02601209","NCT02601950","NCT02603341","NCT02606461","NCT02609776","NCT02609776","NCT02624986","NCT02627443","NCT02628067","NCT02631733","NCT02635009","NCT02649387","NCT02655016","NCT02657369","NCT02657889","NCT02657928","NCT02658929","NCT02659020","NCT02663518","NCT02674750","NCT02684617","NCT02684838","NCT02700230","NCT02702492","NCT02705105","NCT02705313","NCT02709512","NCT02709889","NCT02718066","NCT02720068","NCT02720068","NCT02722434","NCT02729298","NCT02730312","NCT02730546","NCT02736357","NCT02749903","NCT02750826","NCT02753127","NCT02776683","NCT02780089","NCT02781012","NCT02792725","NCT02796261","NCT02814669","NCT02817633","NCT02818920","NCT02831959","NCT02841540","NCT02860000","NCT02873195","NCT02880228","NCT02883062","NCT02888743","NCT02889978","NCT02889978","NCT02898207","NCT02907918","NCT02908451","NCT02908477","NCT02912559","NCT02921256","NCT02923570","NCT02923778","NCT02924376","NCT02926911","NCT02927249","NCT02928224","NCT02935634","NCT02945579","NCT02947685","NCT02949219","NCT02949219","NCT02952534","NCT02960594","NCT02963168","NCT02975934","NCT02977780","NCT02978222","NCT02979899","NCT02981303","NCT02988817","NCT02989857","NCT02990481","NCT02993731","NCT02993731","NCT03002805","NCT03003546","NCT03012100","NCT03015792","NCT03016819","NCT03016819","NCT03017820","NCT03021460","NCT03021460","NCT03024996","NCT03033225","NCT03035279","NCT03035331","NCT03037385","NCT03038672","NCT03043313","NCT03051035","NCT03068455","NCT03071913","NCT03075553","NCT03076372","NCT03076372","NCT03080883","NCT03080883","NCT03087708","NCT03102320","NCT03106415","NCT03115333","NCT03120624","NCT03120624","NCT03122886","NCT03126630","NCT03129139","NCT03132532","NCT03132792","NCT03155997","NCT03157128","NCT03161431","NCT03162536","NCT03170960","NCT03175224","NCT03179904","NCT03180307","NCT03180502","NCT03184870","NCT03188393","NCT03197506","NCT03202628","NCT03211117","NCT03217266","NCT03219333","NCT03230318","NCT03233204","NCT03237390","NCT03237390","NCT03240211","NCT03241186","NCT03241186","NCT03242824","NCT03244384","NCT03249090","NCT03251378","NCT03251378","NCT03253185","NCT03258398","NCT03267433","NCT03267940","NCT03276832","NCT03278106","NCT03281369","NCT03281902","NCT03288480","NCT03297710","NCT03300817","NCT03301636","NCT03318939","NCT03325101","NCT03336216","NCT03337087","NCT03339934","NCT03345095","NCT03353753","NCT03360708","NCT03367741","NCT03375489","NCT03377179","NCT03377179","NCT03384940","NCT03391232","NCT03396471","NCT03396471","NCT03409458","NCT03414970","NCT03414983","NCT03418038","NCT03420014","NCT03420014","NCT03425643","NCT03432741","NCT03455556","NCT03456063","NCT03456700","NCT03463473","NCT03465722","NCT03470922","NCT03471364","NCT03474640","NCT03489525","NCT03502785","NCT03504423","NCT03514407","NCT03516981","NCT03525678","NCT03550391","NCT03553836","NCT03554083","NCT03574779","NCT03578081","NCT03587740","NCT03588039","NCT03595228","NCT03609177","NCT03639714","NCT03647163","NCT03647163","NCT03654729","NCT03656536","NCT03658772","NCT03660826","NCT03673501","NCT03678883","NCT03678883","NCT03695380","NCT03732950","NCT03737695","NCT03737695","NCT03737981","NCT03750227","NCT03761095","NCT03765736","NCT03768414","NCT03778229","NCT03778294","NCT03781063","NCT03785249","NCT03822117","NCT03829410","NCT03833661","NCT03839524","NCT03865212","NCT03872206","NCT03879629","NCT03880019","NCT03888105","NCT03889275","NCT03902600","NCT03906331","NCT03906331","NCT03914300","NCT03927027","NCT03933735","NCT03934814","NCT03941730","NCT03953235","NCT03967223","NCT03979508","NCT03994796","NCT04007744","NCT04029922","NCT04044768","NCT04052555","NCT04066491","NCT04067960","NCT04072445","NCT04114981","NCT04117945","NCT04148092","NCT04197934","NCT04197934","NCT04217694","NCT04236154","NCT04257617","NCT04291105","NCT04294225","NCT04379414","NCT04383938","NCT04396535","NCT04436835","NCT04443413","NCT04475640","NCT04526106","NCT04526691","NCT04549246","NCT04549246","NCT04562480","NCT04581382","NCT04630379"};
    	try (PrintWriter writer = new PrintWriter(folder+"out.txt", "UTF-8")) {
    		for (int i = 0; i < id.length; i++) {
        		
        		String condition="NA";
        		String intervention="NA";
        		String phase="NA";
        		ArrayList<String> o = new ArrayList<>();
        		
        	    String url ="https://clinicaltrials.gov/ct2/show/"+id[i]; 
        	    System.out.println("url:"+url);
        	    Document doc = Jsoup.connect(url).get();
                Elements list = doc.select("div.tr-indent2").select("table");

                for (org.jsoup.nodes.Element l : list) {
                	
                	if(l.text().startsWith("Condition or disease")) {
                		Elements list1 = l.select("th");
                		for (org.jsoup.nodes.Element l1 : list1) {
                			if(l1.text().equals("Condition or disease")) {
                				condition = "Condition/disease";
                			}
                			if(l1.text().equals("Intervention/treatment")) {
                				intervention = "Intervention/treatment";
                			}
                			if(l1.text().equals("Phase")) {
                				phase = "Phase";
                			}
                		}
                		
                		list1 = l.select("td");
                		int j =0;
                		for (org.jsoup.nodes.Element l1 : list1) {
                			Elements list2 = l1.select("span");
                			for (org.jsoup.nodes.Element l2 : list2) {
                				if(!condition.equals("NA")&&j<1) {
                    				condition = condition+"|"+l2.text();
                    			}
                				else if(!intervention.equals("NA")&&j<2) {
                					intervention = intervention+"|"+l2.text();
                    			}
                				else if(!phase.equals("NA")&&j<3) {
                					phase = phase+"|"+l2.text();
                    			}
                			}
                			j++;
                		}
                		
                		condition = condition.replace("Condition/disease|", "");
                		intervention = intervention.replace("Intervention/treatment|", "");
                		phase = phase.replace("Phase|", "");
                		
                		System.out.println(condition);
            			System.out.println(intervention);
            			System.out.println(phase);
            			
                	}
                }
                
                writer.println(id[i]+"\t"+condition+"\t"+intervention+"\t"+phase);
                writer.flush();
        	}
    		writer.close();
    	}
    	
	}
    
    public static void getDrugBank() throws IOException, ParserConfigurationException, SAXException{
    	for (int i = 1; i < 167; i++) {
    	    String url ="http://sideeffects.embl.de/se/?page="+i; 
            Document doc = Jsoup.connect(url).get();
            Elements list = doc.select("ul.drugList").select("li");

            for (org.jsoup.nodes.Element l : list) {
            	
            	Elements link = l.select("a[href]");
                System.out.println(link.text());
                out.add(link.text());
            }
    	}
	}
    
    public static void getRxClass(String file) throws IOException, ParserConfigurationException, SAXException{
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	    	    String url ="https://rxnav.nlm.nih.gov/REST/rxclass/class/byRxcui.xml?rxcui="+line.split("\t")[0]; 
	            Document doc = Jsoup.connect(url).get();
//	            System.out.println(doc.toString());
	            FileOutputStream outputStream = new FileOutputStream(folder+"temp.txt");
	            byte[] strToBytes = doc.toString().getBytes();
	            outputStream.write(strToBytes);
	            outputStream.close();
	            
	            File inputFile = new File(folder+"temp.txt");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            org.w3c.dom.Document xmldoc = dBuilder.parse(inputFile);
	            
	            xmldoc.getDocumentElement().normalize();
//	            System.out.println("Root element :" + xmldoc.getDocumentElement().getNodeName());
	            NodeList nList = xmldoc.getElementsByTagName("rxclassDrugInfo");
//	            System.out.println("----------------------------");
	            
	            String output = ""; 
	            for (int temp = 0; temp < nList.getLength(); temp++) {
	               Node nNode = nList.item(temp);
//	               System.out.println("\nCurrent Element :" + nNode.getNodeName());
	               
	               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                  Element eElement = (Element) nNode;
	                  String relaSource = eElement.getElementsByTagName("relaSource").item(0).getTextContent().trim();
	        		  if(relaSource.equals("MESH")){
	        			  String rxcui = eElement.getElementsByTagName("rxcui").item(0).getTextContent().trim();
	        			  String name = eElement.getElementsByTagName("name").item(0).getTextContent().trim();	
	        			  String className = eElement.getElementsByTagName("className").item(0).getTextContent().trim();
	        			  String classId = eElement.getElementsByTagName("classId").item(0).getTextContent().trim();
	        			  if(!getClassContext(classId).equals("")) {
	        				  className = getClassContext(classId);
	        			  }
	        			  if(output.equals("")) {
	        				  output = rxcui+","+name.replace(",","_")+","+className;
	        			  }
	        			  else output = output + "|" + rxcui+","+name.replace(",","_")+","+className;
	        		  }
	               }
	            }
	            
	    	    if(output.equals("")) {
	    	        for (int temp = 0; temp < nList.getLength(); temp++) {
	    	            Node nNode = nList.item(temp);
//	    	            System.out.println("\nCurrent Element :" + nNode.getNodeName());
	    	            
	    	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	    	               Element eElement = (Element) nNode;
	    	               String relaSource = eElement.getElementsByTagName("relaSource").item(0).getTextContent().trim();
	    	     		  if(relaSource.equals("ATC")){
	    	     			  String rxcui = eElement.getElementsByTagName("rxcui").item(0).getTextContent().trim();
	    	     			  String name = eElement.getElementsByTagName("name").item(0).getTextContent().trim();	
	    	     			  String className = eElement.getElementsByTagName("className").item(0).getTextContent().trim();	
	    	     			  String classId = eElement.getElementsByTagName("classId").item(0).getTextContent().trim();
		        			  if(!getClassContext(classId).equals("")) {
		        				  className = getClassContext(classId);
		        			  }
	    	     			  if(output.equals("")) {
	    	     				  output = rxcui+","+name.replace(",","_")+","+className;
	    	     			  }
	    	     			  else output = output + "|" + rxcui+","+name.replace(",","_")+","+className;
	    	     		  }
	    	            }
	    	         }
	    	    }
	            
	    	    if(output.equals("")) {
	    	        for (int temp = 0; temp < nList.getLength(); temp++) {
	    	            Node nNode = nList.item(temp);
//	    	            System.out.println("\nCurrent Element :" + nNode.getNodeName());
	    	            
	    	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	    	               Element eElement = (Element) nNode;
	    	               String relaSource = eElement.getElementsByTagName("relaSource").item(0).getTextContent().trim();
	    	     		  if(relaSource.equals("VA")){
	    	     			  String rxcui = eElement.getElementsByTagName("rxcui").item(0).getTextContent().trim();
	    	     			  String name = eElement.getElementsByTagName("name").item(0).getTextContent().trim();	
	    	     			  String className = eElement.getElementsByTagName("className").item(0).getTextContent().trim();	
	    	     			  String classId = eElement.getElementsByTagName("classId").item(0).getTextContent().trim();
//	    	     			  System.out.println(className+"\t"+classId+"\t"+getClassContext(classId));
		        			  if(!getClassContext(classId).equals("")) {
		        				  className = getClassContext(classId);
		        			  }
	    	     			  if(output.equals("")) {
	    	     				  output = rxcui+","+name.replace(",","_")+","+className;
	    	     			  }
	    	     			  else output = output + "|" + rxcui+","+name.replace(",","_")+","+className;
	    	     		  }
	    	            }
	    	         }
	    	    }
	    	    
	        	String cui = line.split("\t")[0]; String name = line.split("\t")[1]; String drugClass = "";
	        	if(output.equals("")){
	        		if(name.toLowerCase().contains("vaccine")||name.toLowerCase().contains("influenza")||name.toLowerCase().contains("virus")||name.toLowerCase().contains("valent")) {
	        			System.out.println(name);
	        			drugClass = "VACCINES";
	        		}
	        		else if(name.toLowerCase().contains("multivit")||name.toLowerCase().contains("vitamin")) {
	        			drugClass = "VITAMINS";
	        		}
	        		else if(name.toLowerCase().contains("irb")) {
	        			drugClass = "IRB";
	        		}
	        		else if(name.toLowerCase().contains("lactobacillus")) {
	        			drugClass = "DIGESTIVES, INCL. ENZYMES";
	        		}
	        		else {
	        			drugClass = "NA";
	        		}
	        		out.add(line+"\t"+drugClass);
	        	}
	        	else {
	            	String[] classCUI = output.split("\\|");
	            	for(String c:classCUI) {
//	            		System.out.println(c);
	            		if(Integer.parseInt(c.split(",")[0])<Integer.parseInt(cui)) {
	                		cui = c.split(",")[0];
	                		name = c.split(",")[1];
	            		}
	            		
	            		if(drugClass.equals("")) {
	            			drugClass = c.split(",")[2];
	            		}
	            		else if(!drugClass.contains(c.split(",")[2])) {
	            			drugClass = drugClass+"|"+c.split(",")[2];
	            		}
	            	}
	            	
	            	System.out.println(line+"\t"+cui+"\t"+name+"\t"+drugClass);
	            	out.add(cui+"\t"+name+"\t"+drugClass);
	        	}
	        }
	    }
	    

    }
      
    public static void getNormalizedMed(String file) throws IOException, ParserConfigurationException, SAXException{
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
//	        	line="iron sucrose 100 mg iron/5 mL intravenous solution";
        		line = line.toLowerCase().replaceAll("[*0-9\\.%]+", "#").replaceAll("[#,:\\*]", "").replaceAll("\\(.*\\)", "").replaceAll("[a-z]{1,3}/[a-z]{1,3}", "").replaceAll("//", "").replaceAll("\\s{2,}", " ").replace(" / ", "/").replace("-", "/").trim();
        		line = line.replace("nacl", "sodium chloride").replace("kcl", "potasium chloride");
        		
        		if(line.toLowerCase().contains("vaccine")||line.toLowerCase().contains("flu vac")||line.toLowerCase().contains("influenza")||line.toLowerCase().contains("virus")||line.toLowerCase().contains("valent")) {
        			out.add(".\tvaccine");
        			continue;
        		}
        		if(line.toLowerCase().contains("multivit")||line.toLowerCase().contains("vitamin")) {
        			out.add(".\tvitamin");;
        			continue;
        		}
        		if(line.toLowerCase().contains("irb")) {
        			out.add(".\tIRB");
        			continue;
        		}
        		if(line.toLowerCase().contains("")||line.toLowerCase().contains("bulgaricus")) {
        			out.add(".\tlactobacillus");
        			continue;
        		}
        		
        		if(line.contains("ivpb")) {
        			line = line.substring(0, line.indexOf("ivpb")).trim();
        		}
        		
        		if(line.endsWith("/")) {
        			line = line.substring(0,line.length()-1).trim();
        		}
        		String rxcui = getRxCUI(line);
        		System.out.println(rxcui);
	            
	            while(rxcui.equals("")&&line.contains("/")&&line.contains(" ")) {
	            	line = line.substring(0, line.lastIndexOf(" "));
	            	rxcui = getRxCUI(line);
	            }
	            
	            while(rxcui.equals("")&&!line.contains("/")&&line.contains(" ")) {
	            	line = line.substring(0, line.lastIndexOf(" ")).replaceAll("[\\p{Punct}]","");
	            	rxcui = getRxCUI(line);
	            }
	            
	            if(rxcui.equals("")&&line.contains("/")&&!line.contains(" ")) {
	            	String [] ingredients = line.split("/");
	            	if(ingredients.length==2) {
		            	line = ingredients[1]+"/"+ingredients[0];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(ingredients.length==3&&rxcui.equals("")) {
		            	line = ingredients[0]+"/"+ingredients[2]+"/"+ingredients[1];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(ingredients.length==3&&rxcui.equals("")) {
		            	line = ingredients[1]+"/"+ingredients[0]+"/"+ingredients[2];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(ingredients.length==3&&rxcui.equals("")) {
		            	line = ingredients[1]+"/"+ingredients[2]+"/"+ingredients[0];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(ingredients.length==3&&rxcui.equals("")) {
		            	line = ingredients[2]+"/"+ingredients[0]+"/"+ingredients[1];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(ingredients.length==3&&rxcui.equals("")) {
		            	line = ingredients[2]+"/"+ingredients[1]+"/"+ingredients[0];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(ingredients.length==3&&rxcui.equals("")) {
		            	line = ingredients[0]+"/"+ingredients[1];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(ingredients.length==3&&rxcui.equals("")) {
		            	line = ingredients[1]+"/"+ingredients[0];
		            	rxcui = getRxCUI(line);
	            	}
	            	if(rxcui.equals("")) {
		            	line = ingredients[0].replaceAll("[\\p{Punct}]","");
		            	rxcui = getRxCUI(line);
	            	}
	            }
	            
//	            System.out.println("\nCurrent Element :" + rxcui);
	            out.add(rxcui+"\t"+line);
	        }
	    }
    }
    
    public static String getRxCUI(String line) throws IOException, ParserConfigurationException, SAXException{
		String url ="https://rxnav.nlm.nih.gov/REST/rxcui.xml?name="+line.replace("/", "%20/%20").replace(" ", "%20"); 
		System.out.println(url);
		
		try {
			Document doc = Jsoup.connect(url).get();
	        FileOutputStream outputStream = new FileOutputStream(folder+"temp.txt");
	        byte[] strToBytes = doc.toString().getBytes();
	        outputStream.write(strToBytes);
	        outputStream.close();
	        
		} catch (HttpStatusException e) {
		    System.err.println("HttpStatusException");
		    e.printStackTrace(); // I'd rather (re)throw it though.
		}
		
        File inputFile = new File(folder+"temp.txt");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document xmldoc = dBuilder.parse(inputFile);
        
        xmldoc.getDocumentElement().normalize();
        String rxcui = "";
        if(xmldoc.getElementsByTagName("rxnormId").getLength()>0) {
            rxcui = xmldoc.getElementsByTagName("rxnormId").item(0).getTextContent().trim();
        }
        return rxcui;
    }
    
    public static String getClassContext(String line) throws IOException, ParserConfigurationException, SAXException{
		String url ="https://rxnav.nlm.nih.gov/REST/rxclass//classContext.xml?classId="+line; 
//		System.out.println(url);
        Document doc = Jsoup.connect(url).get();
        FileOutputStream outputStream = new FileOutputStream(folder+"temp.txt");
        byte[] strToBytes = doc.toString().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
        
        File inputFile = new File(folder+"temp.txt");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document xmldoc = dBuilder.parse(inputFile);
        
        xmldoc.getDocumentElement().normalize();
        String RxClass = ""; int pos = 0;
        NodeList nList = xmldoc.getElementsByTagName("classPath");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
//            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               String classType = eElement.getElementsByTagName("classType").item(0).getTextContent().trim();
     		   if((classType.equals("MESHPA")||classType.contains("ATC")||classType.equals("VA"))&&eElement.getElementsByTagName("className").getLength()>pos){
     			  pos = eElement.getElementsByTagName("className").getLength();
     			  if(pos<3) {
     				 RxClass = eElement.getElementsByTagName("className").item(0).getTextContent().trim();
     			  }
     			  else RxClass = eElement.getElementsByTagName("className").item(pos-3).getTextContent().trim();
     		   }
            }
         }
         
         return RxClass;
    }
    
    public static void getOncoGene(String file) throws FileNotFoundException, IOException {
			
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = ""; 
	
	        while ((line = br.readLine()) != null) {
	        	
	        	String topic = ".";
	        	line = line.replaceAll("BRCA1 and 2|BRCA1 or BRCA2|BRCA1 and BRCA2|BRCA1/BRCA2|BRCA1 or 2", "BRCA1/2");
	        	
	        	if(line.startsWith("PATIENT")) {
	        		out.add("GENE\tANNOTATION\tTOPIC\tMOD\tVAR");
	        		continue;
	        	}
	        	
//	        	String gene = line.split("\t")[7];
//	        	if(gene.equals("met")||gene.equals("Met")) {
//	        		out.add("");
//	        		continue;
//	        	}
//	        	String sentence = line.split("\t")[8];
//	        	for (int i = 9; i < line.split("\t").length; i++) {
//	        		sentence = sentence + " " + line.split("\t")[i];
//	        	}
//
//	        	if(!sentence.replace(gene+" inhibitor", "inhibitor").contains(gene)) {
//	        		out.add("");
//	        		continue;
//	        	}
	        	
//	        	String gene = "BRCA1";
//	        	String sentence = "Of note, she has a history of breast cancer, and since she was last seen, we have received results of her mutation testing, and there are no mutations identified in 25 genes associated with hereditary cancer predispositions which included BARD1, BRCA1, BRCA2, CHEK2, RAD51C, RAD51D and TP53.";
	        	
	        	System.out.println(line);
	        	String gene = line.split("\t")[0];
	        	String sentence = line.split("\t")[1];
	        	
	        	sentence = sentence.replaceAll("(?i)(variant )?(of )?un[a-z\\s]+significance", "vus").replaceAll("(?i)( neg |not have|not has|wild type|wild-type|wild)", " negative ");
	        	
	        	if(gene.toLowerCase().equals("tp53")) {
	        		sentence = sentence.replaceAll("(?i)p53", gene).replaceAll("(?i)t"+gene, gene);
        		}
	        	if(gene.toLowerCase().equals("erbb2")) {
	        		sentence = sentence.replaceAll("(?i)her2", gene);
        		}
	        	if(gene.toLowerCase().equals("her2")) {
	        		sentence = sentence.replaceAll("(?i)erbb2", gene);
        		}
	        	
	        	sentence = removeStopWords(sentence).replaceAll("[\\p{Punct}&&[^$\\|\\./*>]]+", " ");
	        	if(sentence.endsWith(".")) {
	        		sentence = sentence.substring(0, sentence.length()-1);
	        	}

	        	Pattern pat = Pattern.compile("\\b(?i)(([A-Z][0-9]{2,}[A-Z](>[A-Z])?)|c\\.[a-z0-9>_]{1,}|p\\.[a-z0-9*>_]{1,}|loss|frameshift|translocat|splice( site)?( [ATGC>0-9]{1,})?|rearrange|insert|delet|amplification|duplication|fusion)[a-z]{0,}\\b");
	        	Matcher mat = pat.matcher(sentence);
	        	Pattern pat1 = Pattern.compile("\\b(?i)(mutation|alteration|variant)(s)?\\b");
	        	Matcher mat1 = pat1.matcher(sentence);
	        	Pattern pat2 = Pattern.compile("\\b(RAD51C|RAD51D|ABL1|ACVR1B|AKT1|AKT2|AKT3|ALK|APC|AR|ARAF|ARFRP1|ARID1A|ARID1B|ARID2|ASXL1|ATM|ATR|ATRX|AURKA|AURKB|AXIN1|AXL|B2M|BAP1|BARD1|BCL2|BCL2L1|BCL2L2|BCL6|BCL7A|BCOR|BCORL1|BIRC3|BLM|BRAF|BRCA1/2|BRCA1|BRCA2|BRD4|BRIP1|BRSK1|BTG1|BTG2|C11orf30|C17orf39|CALR|CAMTA1|CARD11|CBL|CCND1|CCND2|CCND3|CCNE1|CCT6B|CD274|CD36|CD58|CD70|CDC73|CDH1|CDK12| CDK4/6|CDK4|CDK6|CDK8|CDKN1A|CDKN1B|CDKN2A/B|CDKN2A|CDKN2B|CDKN2C|CEBPA|CHD2|CHD4|CHEK2|CIC|CIITA|CKS1B|CPS1|CREBBP|CRKL|CSF1R|CTCF|CTNNA1|CTNNB1|CUL3|CUX1|CXCR4|CYLD|DAXX|DDR2|DDX3X|DICER1|DNMT3A|EED|EGFR|EMSY|EP300|EPHA3|EPHA5|EPHA7|EPHB1|HER2|ERBB2|ERBB3|ERBB4|ERRFI1|ESR1|ETV1|ETV6|EWSR1|EZH2|FAF1|FAM123B|FANCA|FANCC|FANCD2|FANCE|FANCF|FANCG|FANCL|FAS|FAT1|FBXW7|FGF10|FGF14|FGF19|FGF23|FGF3|FGF4|FGF6|FGFR1|FGFR2|FGFR3|FGFR4|FH|FLCN|FLT1|FLT3|FLT4|FOXL2|FOXP1|FRS2|FUBP1|GABRA6|GATA1|GATA2|GATA3|GATA4|GATA6|GLI1|GNA11|GNA12|GNAQ|GNAS|GRIN2A|GRM3|GSK3B|H3F3A|HEY1|HGF|HIST1H1C|HIST1H1D|HIST1H2AM|HMGA2|HNF1A|HRAS|ID3|IDH1|IDH2|IGF1R|IGF2|IGH|IGK|IKBKE|IKZF3|IL7R|INHBA|INPP4B|IRF2|IRF4|IRS2|JAK1|JAK2|JAK3|JAZF1|JUN|KDM4C|KDM5A|KDM5C|KDM6A|KDR|KEAP1|KEL|KIT|KLHL6|KMT2C|KRAS|LEF1|LPP|LRP1B|LYN|LZTR1|MAGI2|MALT1|MAP2K1|MAP2K1|MAP2K2|MAP2K4|MAP3K1|MAP3K14|MAP3K6|MCL1|MDM2|MDM4|MED12|MEF2B|MEN1|MET|MITF|MLH1|MLL|MLL2|MLL3|MLLT10|MPL|MRE11A|MSH2|MSH6|MTOR|MUTYH|MYB|MYC|MYCL1|MYCN|MYD88|MYST3|NCOR2|NF1|NF2|NFE2L2|NFKBIA|NKX2-1|NOD1|NOTCH1|NOTCH2|NOTCH3|NPM1|NRAS|NSD1|NTRK1|NTRK3|NUP93|NUP98|PALB2|PARK2|PASK|PAX3|PAX5|PBRM1|PDCD1LG2|PDGFRA|PDGFRB|PHF6|PICALM|PIK3C2B|PIK3CA|PIK3CB|PIK3CG|PIK3R1|PIK3R2|PIM1|PLCG2|PMS2|POLD1|POLE|POT1|PPP2R1A|PRDM1|PREX2|PRKAR1A|PRKCI|PRKDC|PRSS8|PTCH1|PTEN|PTPN11|PTPN2|PTPN6|QKI|RAC1|RAD21|RAD50|RAD51|RAF1|RANBP2|RARA|RB1|RBM10|RET|RICTOR|RNF43|ROS1|RPTOR|RUNX1|RUNX1T1|SDHA|SDHB|SETD2|SF3B1|SGK1|SLIT2|SMAD2|SMAD3|SMAD4|SMARCA4|SMARCB1|SMO|SNCAIP|SOCS1|SOCS3|SOX2|SOX9|SPEN|SPOP|SPTA1|SRC|SRSF2|SS18|STAG2|STAT3|STAT4|STAT6|STK11|SUFU|SUZ12|TAF1|TAF15|TBL1XR1|TBX3|TERC|TERT|TET2|TGFBR2|TMEM30A|TMPRSS2|TNFAIP3|TNFRSF11A|TNFRSF14|TOP1|TOP2A|TP53|TP63|TRAF2|TSC1|TSC2|TSHR|TYK2|U2AF1|VEGFA|VHL|WHSC1|WT1|XPO1|ZBTB2|ZMYM3|ZNF217|ZNF703)\\b");
	        	Matcher mat2 = pat2.matcher(sentence);
	        	Pattern pat3 = Pattern.compile("\\(.*\\)");
	        	Matcher mat3 = pat3.matcher(sentence);
	        	Pattern pat4 = Pattern.compile("\\b(?i)(pursue|elect|send|sent|pending|order|submit|submitted)(ing|es|ed|le|ility|e|s|d)?\\b");
	        	Pattern pat5 = Pattern.compile("\\b(?i)(analyze|review|discuss|recommend|encourag|explain|women|individual|male|female|lifetime)(ing|es|ed|le|ility|e|s|d)?\\b");
	        	Pattern pat6 = Pattern.compile("\\b(?i)(panel|Jewish|HBOC|autosomal|etiology|pathway|NCCN|includ)(ing|es|ed|le|ility|e|s|d)?\\b"); 
	        	Pattern pat7 = Pattern.compile("\\b(?i)(underlying|evaluation|personal|table|model|odds|probability|estimat)(ing|es|ed|le|ility|e|s|d)?\\b");
	        	Pattern pat8 = Pattern.compile("\\b(?i)(father|mother|parent|son|sister|sibling|daughter|child|cousin|brother|niece|nephew|uncle|aunt|grandparent|grandmother|grandfather|paternal|maternal|relative|family [a-z\\s]{0,20}history)(s)?\\b");
	        	Pattern pat9 = Pattern.compile("\\b(?i)(negative|(not|no|none) [a-z\\s]{0,15}pathogenic|not|no|none|normal|known|pathogenic|positive|vus|un[a-z]{0,10} significance|might|would|if)\\b");
	        	Pattern pat10 = Pattern.compile("\\b(?i)(approximately|hereditary|risk|suggestive|susceptib|likelihood|screen|chance|possib|associated)(ing|es|ed|le|ility|e|s|d)?\\b");
	        			
	        	while(mat2.find()) {//get gene name
//	        		System.out.println(mat2.group());
	        		if(!mat2.group().equals(gene)) {
	        			sentence = sentence.replace(mat2.group(), "$GENE$");
	        		}
	        		else sentence = sentence.replace(mat2.group(), "$"+mat2.group()+"|GENE$");
	        	}
	        	
	        	String var = "";
	        	while(mat.find()) {//get variant
//	        		System.out.println(mat.group());
	        		if(!var.equals("")){
	        			var = var+","+mat.group();
	        		}
	        		else var = mat.group();
	        		sentence = sentence.replace(mat.group(), "$"+mat.group().replace(" ", "_")+"|MUT$");
	        	}
	        	
	        	if(!sentence.contains("MUT$")) {//get mutation
	        		while(mat1.find()) {
//		        		System.out.println(mat1.group());
		        		sentence = sentence.replace(mat1.group(), "$"+mat1.group().replace(" ", "_")+"|MUT$");
		        	}
	        	}
	        	
	        	while(mat3.find()) {//remove bracket
	        		if(!mat3.group().contains("$")&&!mat3.group().matches("NCCN|PARP|HBOC")) {
	        			sentence = sentence.replaceAll(mat3.group(), "");
	        		}
	        	}
	        	if(!mat3.find()) {
	        		sentence = sentence.replaceAll("\\(|\\)", "");
	        	}

	        	sentence = removeNumbers(sentence).replaceAll("\\s+", " ").trim();
	        	
	        	while(sentence.contains("|MUT$s")) {
	            	sentence = sentence.replace("|MUT$s", "|MUT$");
	        	}
	        	while(sentence.contains("|MUT$|MUT$")) {
	            	sentence = sentence.replace("|MUT$|MUT$", "|MUT$");
	        	}
	        	while(sentence.contains("|GENE$s")) {
	            	sentence = sentence.replace("|GENE$s", "|GENE$");
	        	}
	        	while(sentence.contains("|GENE$|GENE$")) {
	            	sentence = sentence.replace("|GENE$|GENE$", "|GENE$");
	        	}
	        	while(sentence.contains("$$")) {
	        		sentence = sentence.replace("$$", "$");
	        	}

	        	if(!mat3.find()) {
	        		sentence = sentence.replaceAll("\\(|\\)", "");
	        	}
	        	
	        	pat3 = Pattern.compile("\\b(?i)PARP(i)?\\b");
	        	mat3 = pat3.matcher(sentence);
	        	String mod = "";
	        	while(mat3.find()) {
	        		sentence = sentence.replace(mat3.group(), "$PARP$").replace("$$", "$");
	        		mod = "PARP";
	        	}
	        	pat3 = Pattern.compile("\\b(?i)germ(-|\\s)?line\\b");
	        	mat3 = pat3.matcher(sentence);
	        	while(mat3.find()) {
	        		sentence = sentence.replace(mat3.group(), "$germline$").replace("$$", "$");
	        		if(mod.equals("")) {
	        			mod = "germline";
	        		}
	        		else if(!mod.contains("germline")) {
	        			mod = mod+",germline";
	        		}
	        	}
	        	pat3 = Pattern.compile("\\b(?i)somatic\\b");
	        	mat3 = pat3.matcher(sentence);
	        	while(mat3.find()) {
	        		sentence = sentence.replace(mat3.group(), "$somatic$").replace("$$", "$");
	        		if(mod.equals("")) {
	        			mod = "somatic";
	        		}
	        		else if(!mod.contains("somatic")) {
	        			mod = mod+",somatic";
	        		}
	        	}
	        	
	        	String [] sentences = sentence.split("\\.");
	        	sentence = "";
	        	for(String s : sentences) {
	        		System.out.println(s);
	        		if(s.contains("$")) {
	        			if(sentence.equals("")) {
	        				sentence = s;
	        			}
	        			else sentence = sentence+"."+s;
		        	}
	        	}

	        	Matcher mat4 = pat4.matcher(sentence);
	        	Matcher mat5 = pat5.matcher(sentence);
	        	Matcher mat6 = pat6.matcher(sentence);
	        	Matcher mat7 = pat7.matcher(sentence);
	        	Matcher mat8 = pat8.matcher(sentence);
	        	Matcher mat9 = pat9.matcher(sentence);
	        	Matcher mat10 = pat10.matcher(sentence);
	        	System.out.println(sentence);
	        	
	        	String pos = "";
	        	while(mat9.find()){
	        		pos = "Y";
	        	}

	        	String output = ""; 
	        	if(sentence.toLowerCase().startsWith("it showed no ")||sentence.toLowerCase().startsWith("no ")){
	        		if(sentence.toLowerCase().contains("gene")||mat.find()){
	        			topic = "negative";
	    	        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
	    	        	mat = pat.matcher(sentence);
	    	        	while(mat.find()) {
	    	        		sentence = sentence.replace(mat.group(), "MUT");
	    	        	}
	    	        	
	    	        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
	    	        	mat = pat.matcher(sentence);
	    	        	while(mat.find()) {
	    	        		sentence = sentence.replace(mat.group(), "BRCA");
	    	        	}
	    	        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	            		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	            	}
	            	else {
	    	        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
	    	        	mat = pat.matcher(sentence);
	    	        	while(mat.find()) {
	    	        		sentence = sentence.replace(mat.group(), "MUT");
	    	        	}
	    	        	
	    	        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
	    	        	mat = pat.matcher(sentence);
	    	        	while(mat.find()) {
	    	        		sentence = sentence.replace(mat.group(), "BRCA");
	    	        	}
	    	        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	            		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	            	}
	            	continue;
        		}
	        	else if(sentence.contains("$"+gene+"|GENE$ mutant")){
	        		topic = "mutant";
		        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "MUT");
		        	}
		        	
		        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "BRCA");
		        	}
		        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	        		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	        		continue;
	        	}
	        	else if(sentence.toLowerCase().contains("insurance")||sentence.toLowerCase().contains("medicaid")||sentence.toLowerCase().contains("medicare")){
	        		topic = "insurance";
		        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "MUT");
		        	}
		        	
		        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "BRCA");
		        	}
		        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	        		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	        		continue;
	        	}
        		else if(mat4.find()){
        			topic = "order";
    	        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
    	        	mat = pat.matcher(sentence);
    	        	while(mat.find()) {
    	        		sentence = sentence.replace(mat.group(), "MUT");
    	        	}
    	        	
    	        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
    	        	mat = pat.matcher(sentence);
    	        	while(mat.find()) {
    	        		sentence = sentence.replace(mat.group(), "BRCA");
    	        	}
    	        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	        		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	        		continue;
	        	}
        		else if(((mat5.find()&&!sentence.contains("old"))||mat6.find())&&pos.equals("")){
        			topic = "discuss";
    	        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
    	        	mat = pat.matcher(sentence);
    	        	while(mat.find()) {
    	        		sentence = sentence.replace(mat.group(), "MUT");
    	        	}
    	        	
    	        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
    	        	mat = pat.matcher(sentence);
    	        	while(mat.find()) {
    	        		sentence = sentence.replace(mat.group(), "BRCA");
    	        	}
    	        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	        		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	        		continue;
        		}
        		else if((mat8.find()||(!sentence.toLowerCase().contains("cardio")&&mat7.find())&&pos.equals(""))){
	        		topic = "estimate";
		        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "MUT");
		        	}
		        	
		        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "BRCA");
		        	}
		        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	        		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	        		continue;
	        	}
        		else if(mat10.find()&&pos.equals("")){
	        		topic = "estimate+discuss";
		        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "MUT");
		        	}
		        	
		        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
		        	mat = pat.matcher(sentence);
		        	while(mat.find()) {
		        		sentence = sentence.replace(mat.group(), "BRCA");
		        	}
		        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	        		out.add(gene+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
	        		continue;
	        	}
	        	else {
	        		
   	        		String geneName = "";
		        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
		        	mat = pat.matcher(sentence);

		        	pat1 = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
		        	mat1 = pat1.matcher(sentence);
		        	while(mat1.find()) {
		        		gene = mat1.group();
		        		geneName = mat1.group(1);
		        	}
		        	
		        	int min = 5;
	        		while(mat.find()){//gene - mutation relationship
	        			if(!getRelationship2(output, sentence, min, gene, mat.group()).equals("")) {
		        			output = getRelationship2(output, sentence, min, gene, mat.group());
		        			min = Integer.valueOf(output.split("\t")[0]);
	        			}
		        		while (countOccurences(sentence, gene)>1){
		        			sentence = sentence.replaceFirst(geneName, "").replaceAll("\\s+", " ");
		        			if(!getRelationship2(output, sentence, min, gene, mat.group()).equals("")&&Integer.valueOf(getRelationship2(output, sentence, min, gene, mat.group()).split("\t")[0])<min) {
			        			output = getRelationship2(output, sentence, min, gene, mat.group());
		        				min = Integer.valueOf(output.split("\t")[0]);
		        			}
		        		}
		        	}
	        	}
	        	
	        	String output1="";
	        	if(!output.equals("")) {
	        		System.out.println(output);
	        		int min = 5;
	        		mat9 = pat9.matcher(sentence);
		        	while(mat9.find()){
		        		if(!getRelationship3(output1, sentence, min, gene, output.split("\t")[2], mat9.group()).equals("")) {
		        			output1 = getRelationship3(output1, sentence, min, gene, output.split("\t")[2], mat9.group());
		        			min = Integer.valueOf(output1.split("\t")[0]);
		        		}
		        		while (countOccurences(sentence, mat9.group())>1){
		        			sentence = sentence.replaceFirst(mat9.group(), "").replaceAll("\\s+", " ");
		        			if(!getRelationship3(output1, sentence, min, gene, output.split("\t")[2], mat9.group()).equals("")&&Integer.valueOf(getRelationship3(output1, sentence, min, gene, output.split("\t")[2], mat9.group()).split("\t")[0])<min) {
			        			output1 = getRelationship3(output1, sentence, min, gene, output.split("\t")[2], mat9.group());
			        			min = Integer.valueOf(output1.split("\t")[0]);
			        		}
		        		}
		        	}
		        	
		        	if(!output1.equals("")) {
		        		
		        		System.out.println(output1);
		        		
		        		if(output1.split("\t")[1].toLowerCase().equals("vus")||output1.split("\t")[1].toLowerCase().startsWith("un")) {
		        			topic = "vus";
		        		}
		        		else if(output1.split("\t")[1].toLowerCase().equals("negative")||output1.split("\t")[1].toLowerCase().startsWith("no")||output1.split("\t")[1].toLowerCase().startsWith("not")) {
		        			topic = "negative";
		        		}
		        		else if(output1.split("\t")[1].toLowerCase().equals("would")||output1.split("\t")[1].toLowerCase().equals("if")||output1.split("\t")[1].toLowerCase().equals("might")){
		        			topic = "possible";
		        		}
		        		else if(output1.split("\t")[1].toLowerCase().equals("known")||output1.split("\t")[1].toLowerCase().equals("pathogenic")||output1.split("\t")[1].toLowerCase().equals("positive")){
		        			topic = "positive";
		        		}
		        		else {
		        			topic = "positive";
		        		}
	        		}
		        	else {
		        		topic = "positive";
		        	}
		        	System.out.println(topic);
	        	}
	        	else {
	        		
	        		int min = 5;
	        		mat9 = pat9.matcher(sentence);
		        	while(mat9.find()){
		        		System.out.println(mat9.group());
		        		if(!getRelationship2(output, sentence, min, gene, mat9.group()).equals("")) {
		        			output = getRelationship2(output, sentence, min, gene, mat9.group());
		        			min = Integer.valueOf(output.split("\t")[0]);
		    			}
		        		while (countOccurences(sentence, mat9.group())>1){
		        			sentence = sentence.replaceFirst(mat9.group(), "").replaceAll("\\s+", " ");
		        			if(!getRelationship2(output, sentence, min, gene, mat9.group()).equals("")) {
		            			output = getRelationship2(output, sentence, min, gene, mat9.group());
		            			min = Integer.valueOf(output.split("\t")[0]);
		        			}
		        		}
		        	}

		        	if(!output.equals("")) {
		        		
		        		System.out.println(output);
		        		
		        		if(output.split("\t")[2].toLowerCase().equals("positive")||output.split("\t")[2].toLowerCase().equals("pathogenic")) {
		        			topic = "positive";
		        		}
		        		else if(output.split("\t")[2].toLowerCase().equals("vus")) {
		        			topic = "vus";
		        		}
		        		else if(output.split("\t")[2].toLowerCase().equals("would")||output.split("\t")[2].toLowerCase().equals("if")||output.split("\t")[2].toLowerCase().equals("might")){
		        			topic = "possible";
		        		}
		        		else {
		        			topic = "negative";
		        		}
	        		}
		        	else {
		        		mat9 = pat9.matcher(sentence);
		        		System.out.println(countOccurences(sentence, "$GENE$"));
			        	while(mat9.find()) {
			        		if(countOccurences(sentence, "$GENE$")>=4&&(mat9.group().contains("no")||mat9.group().contains("negative"))) {
			        			topic = "negative";
			        		}
			        	}
		        	}
	        	}
	        	
//	        	gene = line.split("\t")[7];
	        	pat = Pattern.compile("\\$([A-Za-z0-9\\.*>_]+)\\|MUT\\$");
	        	mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "MUT");
	        	}
	        	
	        	pat = Pattern.compile("\\$([A-Za-z0-9/]+)\\|GENE\\$");
	        	mat = pat.matcher(sentence);
	        	while(mat.find()) {
	        		sentence = sentence.replace(mat.group(), "BRCA");
	        	}
	        	sentence = sentence.replaceAll("[\\p{Punct}\\d]+", " ").replaceAll("\\s{2,}"," ");
	        	out.add(gene.replace("$", "").replace("|GENE", "")+"\t"+sentence+"\t"+topic+"\t"+mod+"\t"+var);
//	        	System.out.println(gene+"\t"+sentence+"\t"+topic);
	        }
	    }
	}
    
    public static void getNeg (String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	line = line.replaceAll("[\\p{Punct}]+"," ").replaceAll("\\s+", " ").trim();
//	        	line = "1 20 2017 Poorly differentiated non small_cell carcinoma not";
	        	String a = ""; String b = ""; String output = "";
	        	Pattern pat0 = Pattern.compile("\\b(?i)small cell\\b");
        		Matcher mat0 = pat0.matcher(line);
        		while(mat0.find()) {
        			line = line.replace(mat0.group(), "small_cell");
        			if(a.equals("")) {
        				a = mat0.group();
        			}
        			else a = a +","+mat0.group();
        		}
        		Pattern pat1 = Pattern.compile("\\b(?i)(non|negative|no|not|indetermined|undecided)\\b");
        		Matcher mat1 = pat1.matcher(line);
        		while(mat1.find()) {
        			if(b.equals("")) {
        				b = mat1.group();
        			}
        			else b = b +","+mat1.group();
        		}
        		
        		if(b.equals("")) {
        			out.add(line);
        			continue;
        		}
        		
        		int dis = 6;
        		if(a.contains(",")) {
        			for(String bb : b.split(",")) {
        				if(!getRelationship2(output, line, 5, "small_cell", bb).equals("")) {
        					if(dis>Integer.valueOf(getRelationship2(output, line, 5, "small_cell", bb).split("\t")[0])) {
            					output = getRelationship2(output, line, 5, "small_cell", bb);
            					dis = Integer.valueOf(output.split("\t")[0]);
            				}
        				}
            		}
        			if(!output.equals("")) {
        				output = output.split("\t")[0]+"\t"+output.split("\t")[2];
        			}
        			else {
        				line = line.replaceFirst("small_cell", "");
        				for(String bb : b.split(",")) {
        					if(!getRelationship2(output, line, 5, "small_cell", bb).equals("")) {
            					if(dis>Integer.valueOf(getRelationship2(output, line, 5, "small_cell", bb).split("\t")[0])) {
                					output = getRelationship2(output, line, 5, "small_cell", bb);
                					dis = Integer.valueOf(output.split("\t")[0]);
                				}
            				}
                		}
            			if(!output.equals("")) {
            				output = output.split("\t")[0]+"\t"+output.split("\t")[2];
            			}
            			else {
            				line = line.replaceFirst("small_cell", "");
            				for(String bb : b.split(",")) {
            					if(!getRelationship2(output, line, 5, "small_cell", bb).equals("")) {
                					if(dis>Integer.valueOf(getRelationship2(output, line, 5, "small_cell", bb).split("\t")[0])) {
                    					output = getRelationship2(output, line, 5, "small_cell", bb);
                    					dis = Integer.valueOf(output.split("\t")[0]);
                    				}
                				}
            				}
                			if(!output.equals("")) {
                				output = output.split("\t")[0]+"\t"+output.split("\t")[2];
                			}
            			}
        			}
        		}
        		else {
        			for(String bb : b.split(",")) {
        				if(!getRelationship2(output, line, 5, "small_cell", bb).equals("")) {
        					if(dis>Integer.valueOf(getRelationship2(output, line, 5, "small_cell", bb).split("\t")[0])) {
            					output = getRelationship2(output, line, 5, "small_cell", bb);
            					dis = Integer.valueOf(output.split("\t")[0]);
            				}
        				}
        			}
        			if(!output.equals("")) {
        				output = output.split("\t")[0]+"\t"+output.split("\t")[2];
        			}
        		}
        		
        		out.add(line+"\t"+output);
        		System.out.println(line+"\t"+output);
	        }
	    }
    }

    
    public static void getContext (String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String sentence = line.split("\t")[0].toLowerCase().replaceAll("\\p{Punct}", " ").replaceAll("[0-9]", "").replaceAll("  ", " ");
	        	String dx = line.split("\t")[1];
	        	
	        	
	        	if(dx.equals(".")) {
	        		out.add(".");
	        	}
	        	else if(sentence.contains("covid")&&sentence.contains("positive")) {
	        		out.add("covid_positive");
	        	}
	        	else if(dx.contains("medical_history")||dx.contains("h_o")) {
	        		out.add("medical_history");
	        	}
	        	else {
	        		String context = ".";
	        		int n = searchedWord(sentence, "history");
	        		if(n!=-1) {
	        			for (String d:dx.split(",")) {
	        				sentence = sentence.replace(d.replace("_"," "),d);
	        				int a = searchedWord(sentence, d);
	        				if(a!=-1&&a-n<=5&&a-n>0) {
	        					context = "history";
	        					System.out.println(d+"\t"+a+"\t"+n+"\t"+sentence);
	        				}
	        			}
	        		}
	        		
	        		sentence = sentence.replace("previous","prior");
	        		n = searchedWord(sentence, "prior");
	        		if(n!=-1) {
	        			for (String d:dx.split(",")) {
	        				sentence = sentence.replace(d.replace("_"," "),d);
	        				int a = searchedWord(sentence, d);
	        				if(a!=-1&&a-n<=5&&a-n>0) {
	        					context = "prior";
	        					System.out.println(d+"\t"+a+"\t"+n+"\t"+sentence);
	        				}
	        			}
	        		}
	        		
	        		//negation
	        		n = searchedWord(sentence, "no");
	        		if(n!=-1) {
	        			for (String d:dx.split(",")) {
	        				sentence = sentence.replace(d.replace("_"," "),d);
	        				int a = searchedWord(sentence, d);
	        				if(a!=-1&&a-n<=5&&a-n>0) {
	        					context = "negate";
	        					System.out.println(d+"\t"+a+"\t"+n+"\t"+sentence);
	        				}
	        			}
	        		}
	        		
	        		n = searchedWord(sentence, "not");
	        		if(n!=-1) {
	        			for (String d:dx.split(",")) {
	        				sentence = sentence.replace(d.replace("_"," "),d);
	        				int a = searchedWord(sentence, d);
	        				if(a!=-1&&a-n<=5&&a-n>0) {
	        					context = "negate";
	        					System.out.println(d+"\t"+a+"\t"+n+"\t"+sentence);
	        				}
	        			}
	        		}

	        		sentence = sentence.replace("denied","deny").replace("denies","deny").replace("denying","deny");
	        		n = searchedWord(sentence, "deny");
	        		if(n!=-1) {
	        			for (String d:dx.split(",")) {
	        				sentence = sentence.replace(d.replace("_"," "),d);
	        				int a = searchedWord(sentence, d);
	        				if(a!=-1&&a-n<=5&&a-n>0) {
	        					context = "negate";
	        					System.out.println(d+"\t"+a+"\t"+n+"\t"+sentence);
	        				}
	        			}
	        		}
	        		
	        		out.add(context);
	        	}
	        }
	    }
    }
    
    public static void readSum (String file) throws FileNotFoundException, IOException, java.text.ParseException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	//long table
	        	String id = line.split("\t")[0];
	        	String[] dx = line.split("\t")[1].split(",");
	        	for(String s:dx) {
	        		out.add(id+"\t"+s);
	        	}
	        		
	        	//task
//	        	String[] split = line.split("\\|");
//	        	for(String s:split) {
//	        		out.add(s);
//	        	}
	        	
	        	//get med sum
//	        	line = line.replace("\"", "");
//	        	ArrayList<String> meds = new ArrayList<>();
//				SimpleDateFormat formatter=new SimpleDateFormat("M/d/yyyy"); 
//		    	
//				if(line.contains("ReportDate")) {
//		    		out.add(".");
//		    		continue;
//		    	}
//				
//            	Date ReportDate = formatter.parse(line.split("\t")[1]);
//
//            	String lung = "N";
//            	
//		    	if(!line.split("\t")[3].equals("null")) {
//	        		for(String drug:line.split("\t")[3].split(",")) {
//	        			System.out.println(drug);
//	    	        	Date DrugDate = formatter.parse(drug.substring(drug.indexOf("[")+1,drug.indexOf("]")));
//	    	        	if(!DrugDate.before(ReportDate)&&(lung.equals("N")||drug.contains("afatinib")||drug.contains("everolimus")||drug.contains("alectinib")||drug.contains("pemetrexed")||drug.contains("brigatinib")||drug.contains("bevacizumab")||drug.contains("ramucirumab")||drug.contains("afatinib")||drug.contains("gemcitabine")||drug.contains("durvalumab")||drug.contains("gefitinib")||drug.contains("pembrolizumab")||drug.contains("lorlatinib")||drug.contains("trametinib")||drug.contains("mechlorethamine")||drug.contains("vinorelbine")||drug.contains("nivolumab")||drug.contains("carboplatin")||drug.contains("necitumumab")||drug.contains("entrectinib")||drug.contains("dabrafenib")||drug.contains("osimertinib")||drug.contains("erlotinib")||drug.contains("paclitaxel")||drug.contains("docetaxel")||drug.contains("atezolizumab")||drug.contains("methotrexate")||drug.contains("dacomitinib")||drug.contains("crizotinib")||drug.contains("ceritinib")||drug.contains("etoposide")||drug.contains("topotecan")||drug.contains("abraxane")||drug.contains("afinitor")||drug.contains("alecensa")||drug.contains("alimta")||drug.contains("alunbrig")||drug.contains("avastin")||drug.contains("cyramza")||drug.contains("doxorubicin")||drug.contains("gilotrif")||drug.contains("gemzar")||drug.contains("imfinzi")||drug.contains("iressa")||drug.contains("keytruda")||drug.contains("lorbrena")||drug.contains("mekinist")||drug.contains("mustargen")||drug.contains("mvasi")||drug.contains("navelbine")||drug.contains("opdivo")||drug.contains("paraplat")||drug.contains("paraplatin")||drug.contains("portrazza")||drug.contains("rozlytrek")||drug.contains("tafinlar")||drug.contains("tagrisso")||drug.contains("tarceva")||drug.contains("taxol")||drug.contains("taxotere")||drug.contains("tecentriq")||drug.contains("trexall")||drug.contains("vizimpro")||drug.contains("xalkori")||drug.contains("zykadia")||drug.contains("etopophos")||drug.contains("etoposide")||drug.contains("hycamtin"))) {
////			        		meds.add(drug);
//			        		meds.add(drug.substring(0,drug.indexOf("[")));
//			        	}
//	        		}
//	        	}
//	        	
//		    	if(!line.split("\t")[4].equals("null")) {
//	        		for(String drug:line.split("\t")[4].split(",")) {
//	        			System.out.println(drug);
//	        			Date DrugDate = formatter.parse(drug.substring(drug.indexOf("[")+1,drug.indexOf("]")));
//	    	        	if(!DrugDate.before(ReportDate)&&(lung.equals("N")||drug.contains("afatinib")||drug.contains("everolimus")||drug.contains("alectinib")||drug.contains("pemetrexed")||drug.contains("brigatinib")||drug.contains("bevacizumab")||drug.contains("ramucirumab")||drug.contains("afatinib")||drug.contains("gemcitabine")||drug.contains("durvalumab")||drug.contains("gefitinib")||drug.contains("pembrolizumab")||drug.contains("lorlatinib")||drug.contains("trametinib")||drug.contains("mechlorethamine")||drug.contains("vinorelbine")||drug.contains("nivolumab")||drug.contains("carboplatin")||drug.contains("necitumumab")||drug.contains("entrectinib")||drug.contains("dabrafenib")||drug.contains("osimertinib")||drug.contains("erlotinib")||drug.contains("paclitaxel")||drug.contains("docetaxel")||drug.contains("atezolizumab")||drug.contains("methotrexate")||drug.contains("dacomitinib")||drug.contains("crizotinib")||drug.contains("ceritinib")||drug.contains("etoposide")||drug.contains("topotecan")||drug.contains("abraxane")||drug.contains("afinitor")||drug.contains("alecensa")||drug.contains("alimta")||drug.contains("alunbrig")||drug.contains("avastin")||drug.contains("cyramza")||drug.contains("doxorubicin")||drug.contains("gilotrif")||drug.contains("gemzar")||drug.contains("imfinzi")||drug.contains("iressa")||drug.contains("keytruda")||drug.contains("lorbrena")||drug.contains("mekinist")||drug.contains("mustargen")||drug.contains("mvasi")||drug.contains("navelbine")||drug.contains("opdivo")||drug.contains("paraplat")||drug.contains("paraplatin")||drug.contains("portrazza")||drug.contains("rozlytrek")||drug.contains("tafinlar")||drug.contains("tagrisso")||drug.contains("tarceva")||drug.contains("taxol")||drug.contains("taxotere")||drug.contains("tecentriq")||drug.contains("trexall")||drug.contains("vizimpro")||drug.contains("xalkori")||drug.contains("zykadia")||drug.contains("etopophos")||drug.contains("etoposide")||drug.contains("hycamtin"))) {
////			        		meds.add(drug);
//			        		meds.add(drug.substring(0,drug.indexOf("[")));
//			        	}
//	        		}
//	        	}
//	        	
//		    	if(!line.split("\t")[5].equals("null")) {
//	        		for(String drug:line.split("\t")[5].split(",")) {
//	        			System.out.println(drug);
//	        			Date DrugDate = formatter.parse(drug.substring(drug.indexOf("[")+1,drug.indexOf("]")));
//	    	        	if(!DrugDate.before(ReportDate)&&(lung.equals("N")||drug.contains("afatinib")||drug.contains("everolimus")||drug.contains("alectinib")||drug.contains("pemetrexed")||drug.contains("brigatinib")||drug.contains("bevacizumab")||drug.contains("ramucirumab")||drug.contains("afatinib")||drug.contains("gemcitabine")||drug.contains("durvalumab")||drug.contains("gefitinib")||drug.contains("pembrolizumab")||drug.contains("lorlatinib")||drug.contains("trametinib")||drug.contains("mechlorethamine")||drug.contains("vinorelbine")||drug.contains("nivolumab")||drug.contains("carboplatin")||drug.contains("necitumumab")||drug.contains("entrectinib")||drug.contains("dabrafenib")||drug.contains("osimertinib")||drug.contains("erlotinib")||drug.contains("paclitaxel")||drug.contains("docetaxel")||drug.contains("atezolizumab")||drug.contains("methotrexate")||drug.contains("dacomitinib")||drug.contains("crizotinib")||drug.contains("ceritinib")||drug.contains("etoposide")||drug.contains("topotecan")||drug.contains("abraxane")||drug.contains("afinitor")||drug.contains("alecensa")||drug.contains("alimta")||drug.contains("alunbrig")||drug.contains("avastin")||drug.contains("cyramza")||drug.contains("doxorubicin")||drug.contains("gilotrif")||drug.contains("gemzar")||drug.contains("imfinzi")||drug.contains("iressa")||drug.contains("keytruda")||drug.contains("lorbrena")||drug.contains("mekinist")||drug.contains("mustargen")||drug.contains("mvasi")||drug.contains("navelbine")||drug.contains("opdivo")||drug.contains("paraplat")||drug.contains("paraplatin")||drug.contains("portrazza")||drug.contains("rozlytrek")||drug.contains("tafinlar")||drug.contains("tagrisso")||drug.contains("tarceva")||drug.contains("taxol")||drug.contains("taxotere")||drug.contains("tecentriq")||drug.contains("trexall")||drug.contains("vizimpro")||drug.contains("xalkori")||drug.contains("zykadia")||drug.contains("etopophos")||drug.contains("etoposide")||drug.contains("hycamtin"))) {
////			        		meds.add(drug);
//			        		meds.add(drug.substring(0,drug.indexOf("[")));
//			        	}
//	        		}
//	        	}
//	        	
//		    	if(!line.split("\t")[6].equals("null")) {
//	        		for(String drug:line.split("\t")[6].split(",")) {
//	        			System.out.println(drug);
//	        			Date DrugDate = formatter.parse(drug.substring(drug.indexOf("[")+1,drug.indexOf("]")));
//	    	        	if(!DrugDate.before(ReportDate)&&(lung.equals("N")||drug.contains("afatinib")||drug.contains("everolimus")||drug.contains("alectinib")||drug.contains("pemetrexed")||drug.contains("brigatinib")||drug.contains("bevacizumab")||drug.contains("ramucirumab")||drug.contains("afatinib")||drug.contains("gemcitabine")||drug.contains("durvalumab")||drug.contains("gefitinib")||drug.contains("pembrolizumab")||drug.contains("lorlatinib")||drug.contains("trametinib")||drug.contains("mechlorethamine")||drug.contains("vinorelbine")||drug.contains("nivolumab")||drug.contains("carboplatin")||drug.contains("necitumumab")||drug.contains("entrectinib")||drug.contains("dabrafenib")||drug.contains("osimertinib")||drug.contains("erlotinib")||drug.contains("paclitaxel")||drug.contains("docetaxel")||drug.contains("atezolizumab")||drug.contains("methotrexate")||drug.contains("dacomitinib")||drug.contains("crizotinib")||drug.contains("ceritinib")||drug.contains("etoposide")||drug.contains("topotecan")||drug.contains("abraxane")||drug.contains("afinitor")||drug.contains("alecensa")||drug.contains("alimta")||drug.contains("alunbrig")||drug.contains("avastin")||drug.contains("cyramza")||drug.contains("doxorubicin")||drug.contains("gilotrif")||drug.contains("gemzar")||drug.contains("imfinzi")||drug.contains("iressa")||drug.contains("keytruda")||drug.contains("lorbrena")||drug.contains("mekinist")||drug.contains("mustargen")||drug.contains("mvasi")||drug.contains("navelbine")||drug.contains("opdivo")||drug.contains("paraplat")||drug.contains("paraplatin")||drug.contains("portrazza")||drug.contains("rozlytrek")||drug.contains("tafinlar")||drug.contains("tagrisso")||drug.contains("tarceva")||drug.contains("taxol")||drug.contains("taxotere")||drug.contains("tecentriq")||drug.contains("trexall")||drug.contains("vizimpro")||drug.contains("xalkori")||drug.contains("zykadia")||drug.contains("etopophos")||drug.contains("etoposide")||drug.contains("hycamtin"))) {
////			        		meds.add(drug);
//			        		meds.add(drug.substring(0,drug.indexOf("[")));
//			        	}
//	        		}
//	        	}
//	        	
//	        	removeDuplicates(meds);
//	        	
//	        	String output = ".";
//	        	for(String med:meds) {
//	        		if(output.equals(".")) {
//	        			output = med;
//	        		}
//	        		else output = output+","+med;
//	        	}
//	        	out.add(output);
	        }
	    }
    }
    
    public static void getSum (String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	System.out.println(line);
	        	String mrn = line.split("\t")[0].trim();
	        	String data = line.split("\t")[1].trim();
	        	
	        	if(id.get(mrn)!=null) {
	        		String s = id.get(mrn);
	        		s = s + "," + data;
	        		id.put(mrn, s);
	        	}
	        	else {
	        		id.put(mrn, data);
	        	}
	        	
	        	//include date
//	        	String mrn = line.split("\t")[0];
//	        	String date = line.split("\t")[1].split("T")[0];
//	        	String data = line.split("\t")[2].trim();
//	        	
//	        	if(id.get(mrn)!=null) {
//	        		String s = id.get(mrn);
////	        		s = s + "," + data+"["+date+"]";
//	        		if(!s.contains(data)) {
//	        			s = s + "," + data+"["+date+"]";
//	        		}
//	        		id.put(mrn, s);
//	        	}
//	        	else {
//	        		id.put(mrn, data+"["+date+"]");
//	        	}
	        	
	        	//include topic
//	        	if(line.split("\t")[3].equals(".")) {
//	        		continue;
//	        	}
//	        	String topic = line.split("\t")[3];
//	        	if(line.split("\t").length>4) {
//	        		topic = topic+"["+data+"_"+line.split("\t")[4]+"|"+date+"]";
//	        	}
//	        	else topic = topic+"["+data+"|"+date+"]";
//
//	        	if(id.get(mrn)!=null) {
//	        		String s = id.get(mrn);
//	        		if(!s.contains(topic)) {
//	        			s = s + "," + topic;
//	        		}
//	        		id.put(mrn, s);
//	        	}
//	        	else {
//	        		id.put(mrn, topic);
//	        	}
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String mrn = line.split("\t")[0];
	        	out.add(id.get(mrn));
	        	System.out.println(line+"\t"+id.get(mrn));
	        }
	    }
    }

    public static void getTempoSum (String file) throws FileNotFoundException, IOException {
    	
    	HashMap<String,TreeMap<String,String>> tempo = new HashMap<String,TreeMap<String,String>>();
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	System.out.println(line);
	        	String mrn = line.split("\t")[0].trim();
	        	String date = line.split("\t")[1].trim();
	        	String med = line.split("\t")[2].trim();
	        	String topic = line.split("\t")[3].trim();
//	        	String sentences = line.split("\t")[4].trim();
	        	
	        	if(tempo.get(mrn+"_"+med)!=null) {
	        		TreeMap<String,String> s = tempo.get(mrn+"_"+med);
	        		for ( Map.Entry<String, String> entry : s.entrySet()  ) {
	        			String key = entry.getKey();
	        			String value = entry.getValue();
	        			System.out.println(s);
	        			if (Integer.parseInt(date)-Integer.parseInt(key)<=30) {
	        				value = value + "," + topic;
//	        				value = value + "+" + sentences;
	        				s.put(key, value);
//	        				System.out.println(mrn+"_"+med+"\t"+key+"\t"+value);
	        				break;
	        			}
	        			else {
	        		  		if(topic.equals("CDM")||topic.equals("Current")||topic.equals("UDP")||topic.equals("Hx")||topic.equals("Positive")||topic.startsWith("CN")) {
	        		  			s.put(date, topic);
//	        		  			s.put(date, sentences);
//		        				System.out.println("new:"+mrn+"_"+med+"\t"+date+"\t"+topic);
		        				break;
	        		  		}
	        			}
	        		}

	        		tempo.put(mrn+"_"+med, s);
	        	}
	        	else {
	        		if(topic.equals("CDM")||topic.equals("Current")||topic.equals("UDP")||topic.equals("Hx")||topic.equals("Positive")||topic.startsWith("CN")) {
	        			TreeMap<String,String> s = new TreeMap<String,String>(Collections.reverseOrder());
		        		s.put(date,topic);
//		        		s.put(date,sentences);
		        		tempo.put(mrn+"_"+med, s);
	        		}
	        	}
	        	
	        }
	    }
	    
	    for ( Entry<String, TreeMap<String, String>> entry : tempo.entrySet()  ) {
			String key = entry.getKey();
			TreeMap<String, String> value = entry.getValue();
			for ( Entry<String, String> entry1 : value.entrySet()  ) {
				String date = entry1.getKey();
				String topic = entry1.getValue();
				out.add(key+"\t"+date+"\t"+topic);
				System.out.println(key+"\t"+date+"\t"+topic);
			}
	    }
    }
    
	public static void getCancerDx(String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	line = line.toLowerCase();
	        	String output=".";
	        	if((line.contains("malign")||line.contains("neoplas")||line.contains("cancer")||line.contains("tumor")||line.contains("tumour")||line.contains("ca ")||line.endsWith(" ca")
	        	||line.contains("carcinoma")||line.contains("sarcoma")||line.contains("cytoma")||line.contains("blastoma")||(line.contains("gestational")&&line.contains("trophoblastic"))||(line.contains("histiocytosis")&&line.contains("langerhans"))
	        	||line.contains("leukemia")||line.contains("lymphoma")||line.contains("melanoma")||line.contains("glioma")||line.contains("matosis")||line.contains("metasta"))&&!(line.contains("family")||line.contains("screen"))) {
	        		
	        		if(line.contains("primary")){
	        			System.out.println(line);
						output = "Cancer,primary";
	        		}
	        		else if(line.contains("benign")){
	        			output = "Cancer,benign";
	        		}
	        		else if(line.contains("metastatic")){
	        			output = "Cancer,metastatic";
	        		}
	        		else if(line.contains("secondary")){
	        			output = "Cancer,secondary";
	        		}
	        		else {
	        			output = "Cancer,unspecified";
	        		}
	        	}
	        	
	        	if(line.contains("lung")||line.contains("pleura")||line.contains("mesoth")) {
	        		output = output + "\tLung";
	        	}
	        	
	        	out.add(output);
	        	
	        }
	    }
	}

    public static void getCancerProc(String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	line = line.toLowerCase();
	        	if(line.startsWith("resection")||line.startsWith("bypass")||line.startsWith("excision")||line.contains("remov")||(line.contains("tomy")&&!line.startsWith("anes"))||(line.contains("scopy")&&!line.startsWith("anes"))){
	        		System.out.println(line);
	        		out.add(line+"\tY");
	        	}
	        	else {
	        		out.add(line);
	        	}
	        }
	    }
	}

	public static void getCancerGT(String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	line = line.toLowerCase();
	        	if((line.contains("gene")&&!line.contains("general"))||(line.contains("cancer")&&!(line.contains("ca ")||line.contains("antigen")))) {
	        		System.out.println(line);
	        		out.add(line+"\tGenetic Test");
	        	}
	        	else {
	        		out.add(line);
	        	}
	        }
	    }
	}
    
	public static void getCancerMed(String file) throws FileNotFoundException, IOException {
    	HashMap<String,String> cancerMed = new HashMap<String,String>();
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"Med.txt"))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	if(line.split("\t").length>5) {
	        		String rxCUI = line.split("\t")[0];
	        		String rxName = line.split("\t")[1];
	        		String HemOnc = line.split("\t")[4]+"\t"+line.split("\t")[5];
	        		if(!rxCUI.equals("")){
	        			cancerMed.put(rxCUI, HemOnc);
	        		}
	        		else cancerMed.put(rxName, HemOnc);
	        	}
        	}
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	if(line.split("\t").length<2){
		        	String MED_NAME_DESCRIPTION = line.split("\t")[0];
		        	if(cancerMed.get(MED_NAME_DESCRIPTION)!=null) {
		        		out.add(line+"\t"+cancerMed.get(MED_NAME_DESCRIPTION));
		        		System.out.println(line+"\t"+cancerMed.get(MED_NAME_DESCRIPTION));
		        	}
		        	else out.add(line);
	        	}
	        	else {
		        	String STANDARD_MED_NAME_DESCRIPTION = line.split("\t")[1];
		        	if(cancerMed.get(STANDARD_MED_NAME_DESCRIPTION)!=null) {
			        	out.add(line+"\t"+cancerMed.get(STANDARD_MED_NAME_DESCRIPTION));
			        	System.out.println(line+"\t"+cancerMed.get(STANDARD_MED_NAME_DESCRIPTION));
		        	}
		        	else out.add(line);
	        	}
	        }
	    }
	}
    
	public static void getChemName (String file) throws FileNotFoundException, IOException {
		
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Documents/HemOncBrand.txt"))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	
	        	line = line.replace("\"", "").toLowerCase();
	        	
	        	//Brand
	        	for(String s : line.split("\t")[0].trim().split(",")) {
	        		String chem = line.split("\t")[1].trim();
	        		if(chem.contains(",")) {
	        			chem = chem.split(",")[0];
	        		}
	        		id.put(s, chem);
	        		System.out.println(s+"\t"+chem);
	        	}
	        	
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	line = line.replace("\"", "").replace("-", " ").replace("  ", " ").toLowerCase();
	        	
	        	//modify line
//	        	for (Map.Entry<String,String> entry : id.entrySet()) { 
//	        		line = line.replaceAll(entry.getKey(), entry.getValue());
//	        	}
//	        	
////	        	if(line.contains("opaganib")) {
////        			System.out.println(line);
////        		}
//	        	
//	        	out.add(line);
	        	
	        	//tag line
	        	String mrn = line.trim();
	        	if(id.get(mrn)==null) {
	        		out.add(mrn);
	        	}
	        	else out.add(id.get(mrn));
	        	System.out.println(mrn+"\t"+id.get(mrn));
	        }
	    }
	}
	
    public static void getCategory(String file) throws FileNotFoundException, IOException {
    	HashMap<String,String> cancerMed = new HashMap<String,String>();
    	
	    try (BufferedReader br = new BufferedReader(new FileReader("/Users/yzm9199/Documents/HemOncCategory.txt"))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
	        	if(line.startsWith("Med")) {
	        		continue;
	        	}
	        	
	        	if(line.split("\t").length>2) {
	        		String Category = line.split("\t")[1];
	        		String med = line.split("\t")[0];
	        		String Status = line.split("\t")[2];
	        		if(cancerMed.get(med)==null) {
	        			cancerMed.put(med, Category+"\t"+Status);
	        		}
	        		else {
	        			if(!cancerMed.get(med).split("\t")[0].contains(Category)){
	        				Category = cancerMed.get(med).split("\t")[0]+","+Category;
	        				cancerMed.put(med, Category+"\t"+Status);
	        			}
	        		}
	        	}
	        	else if(line.split("\t").length>1) {
	        		String Category = line.split("\t")[1];
	        		String med = line.split("\t")[0];
	        		
	        		if(cancerMed.get(med)==null) {
	        			cancerMed.put(med, Category);
	        		}
	        		else {
	        			if(!cancerMed.get(med).contains(Category)){
	        				Category = cancerMed.get(med)+","+Category;
	        				cancerMed.put(med, Category);
	        			}
	        		}
	        		if(!med.replaceAll("-", " ").equals(med)) {
	        			med = med.replaceAll("-", " ");
	        			if(cancerMed.get(med)==null) {
		        			cancerMed.put(med, Category);
		        		}
		        		else {
		        			if(!cancerMed.get(med).contains(Category)){
		        				Category = cancerMed.get(med)+","+Category;
		        				cancerMed.put(med, Category);
		        			}
		        		}
	        		}
	        	}
        	}
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	
//	        	String match = "";
//	        	for (String med : cancerMed.keySet()) {
//		        	if(line.trim().toLowerCase().contains(med.toLowerCase())) {
//		        		match = med;
//		        	}
//	        	}
//	        	
//	        	if(!match.equals("")) {
////	        	if(!match.equals("")&&(cancerMed.get(match).contains("TKI")||cancerMed.get(match).contains("PDL1")||cancerMed.get(match).contains("Cytotoxic")||cancerMed.get(match).contains("inhibitors")||cancerMed.get(match).contains("Endocrine")||cancerMed.get(match).contains("Biologics")||cancerMed.get(match).contains("WHO Essential Cancer Medicine"))) {
//	        		out.add(line+"\t"+match+"\t"+cancerMed.get(match));
//	        		System.out.println(line+"\t"+match+"\t"+cancerMed.get(match));
//	        	}
//	        	else out.add(line);
	        	
	        	//get total category
	        	System.out.println(line);
	        	String match = ""; String category = "";
	        	for (String med : cancerMed.keySet()) {
		        	if(line.trim().toLowerCase().contains(med.toLowerCase())) {
		        		if(match.equals("")) {
		        			match = med;
		        		}
		        		else {
		        			match = match+"|"+med;
		        		}
		        	}
	        	}
	        	if(!match.equals("")) {
	        		String[] m = match.split("\\|");
	        		for(String s:m) {
	        			if(category.equals("")) {
	        				category = cancerMed.get(s);
		        		}
		        		else if(!category.contains(cancerMed.get(s))){
		        			category = category+","+cancerMed.get(s);
		        		}
	        		}
	        	}
	        	
	        	category=category.replaceAll("chemotherapy", "Chemotherapy");
	        	while(category.contains("Chemotherapy,Chemotherapy")){
	        		category=category.replaceAll("Chemotherapy,Chemotherapy", "Chemotherapy");
	        	}
	        	System.out.println(match+"\t"+category);
	        	out.add(match+"\t"+category);
	        }
	    }
	}
    
    public static void getHemOncDrug() throws IOException{
        String url = "https://hemonc.org/wiki/Drug_index";
        System.out.println("Fetching "+url);
        
        Document doc = Jsoup.connect(url).get();
        Elements list = doc.select("li");

        for (org.jsoup.nodes.Element l : list) {
        	
        	Elements link = l.select("a[href]");
        	Elements link1 = l.select("b");
        	String status=".";
        	if(!link1.text().equals("")) {
        		status=link1.text();
        	}
//            System.out.println(link.text().replace(")", "").replace(" (", "\t")+"\t"+link1.text());
//            out.add(link.text().replace(")", "").replace(" (", "\t")+"\t"+link1.text());
        	if(link.toString().contains("page does not exist")) {
        		out.add(link.text()+"\tDeleted"+"\t"+status);
        	}
        	else out.add(link.text()+"\t"+link.attr("href")+"\t"+status);
        }
    }
    
    public static void getHemOncInhibitors() throws IOException{
        String url = "https://hemonc.org/wiki/Category:";
        
        for(String i : inhibitors) {
            System.out.println("Fetching "+url+i);
            
            Document doc = Jsoup.connect(url+i).get();
            Elements list = doc.select("li");
            String record = "Y";

            for (org.jsoup.nodes.Element l : list) {
            	
            	Elements link = l.select("a[href]");
            	
                if(link.text().equals("Kinase inhibitors")) {
                	record = "N";
                }
                
                if(record.equals("Y")) {
                	if(link.text().contains("(")){
                		System.out.println(link.text().substring(0, link.text().indexOf("("))+"\t"+i.replace("_", " "));
                		out.add(link.text().substring(0, link.text().indexOf("("))+"\t"+i.replace("_", " "));
                	}
                	else {
                		System.out.println(link.text()+"\t"+i.replace("_", " "));
                		out.add(link.text()+"\t"+i.replace("_", " "));
                	}
                }
            }
        }

    }
    
    public static void getHemOncCategory0(String file, String _file) throws IOException{
        try (PrintWriter writer = new PrintWriter(_file, "UTF-8")) {
    	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    	
    	        String line = "";

    	        while ((line = br.readLine()) != null) {
    	            String category = ".";
    	            System.out.println("Fetching "+line);
    	            if(!line.startsWith("https://")||line.equals("https://hemonc.org/wiki/Category:Drugs")||line.equals("https://hemonc.org/wiki/Category:Intervention_index")){
    	            	writer.println(line+"\t"+category);
                        writer.flush();
                        out.add(line+"\t"+category);
    	        		continue;
    	        	}
    	            else if(line.equals("https://hemonc.org/wiki/Category:Steroids")) {
    	            	category = "Emesis prevention:Supportive medications:Drugs|Immunosuppressants:Drugs by class effect:Drugs";
    	            	writer.println(line+"\t"+category);
                        writer.flush();
                        out.add(line+"\t"+category);
    	        		continue;
    	            }
    	            
    	            Document doc = Jsoup.connect(line).get();
    	            Elements list = doc.select("div.mw-normal-catlinks").select("li");
    	            
    	            for (org.jsoup.nodes.Element l : list) {
    	            	String category0 = "";
    	            	Elements link = l.select("a[href]");
    	                if(link.attr("abs:href").contains("/wiki/Category:")) {
    	                	category0 = link.text();
    	                	while(!link.attr("abs:href").contains("Intervention_index")&&!link.attr("abs:href").contains("Condition")) {
    	                		doc = Jsoup.connect(link.attr("abs:href")).get();
    	         	            list = doc.select("div.mw-normal-catlinks").select("li");
    	         	            for (org.jsoup.nodes.Element l1 : list) {
    	         	            	link = l1.select("a[href]");
    	         	                if(link.attr("abs:href").contains("/wiki/Category:")&&!link.attr("abs:href").contains("Intervention_index")&&!link.attr("abs:href").contains("Condition")) {
    	         	                	category0 = category0+":"+link.text();
    	         	                	System.out.println(category0);
    	         	                }
    	         	            }
    	                	}
    	                }
    	                
    	                if(category.equals(".")) {
    	                	category = category0;
    	                }
    	                else category = category+"|"+category0;
    	            }
    	            System.out.println(category);
                	writer.println(line+"\t"+category);
                    writer.flush();
    	        }
    	    }
            writer.close();
        }
        


    }
    
    public static void getHemOncCategory(String file) throws IOException{

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String url = line.split("\t")[1];
	        	System.out.println("Fetching "+url);
	        	if(!url.startsWith("/wiki")){
	        		out.add(line+"\t.\t.");
	        		continue;
	        	}
	            
	            Document doc = Jsoup.connect("https://hemonc.org"+url).get();
	            Elements list = doc.select("li");

	            for (org.jsoup.nodes.Element l : list) {
	            	
	            	Elements link = l.select("a[href]");
	                if(link.attr("abs:href").contains("Category")) {
	                	System.out.println(line+"\t"+link.text()+"\t"+link.attr("abs:href"));
	                	out.add(line+"\t"+link.text()+"\t"+link.attr("abs:href"));
	                }
	            }
	        }
	    }
    }
    
    public static void getHemOncBrand(String file) throws IOException{

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String drug = line.split("\t")[0];
	        	String url = line.split("\t")[1];
	        	String brand = ".";
	        	System.out.println("Fetching "+url);
	        	if(!url.startsWith("/wiki")){
	        		out.add(drug+"\t"+brand);
	        		continue;
	        	}
	            
	            Document doc = Jsoup.connect("https://hemonc.org"+url).get();
	            Elements list = doc.select("ul");

	            for (org.jsoup.nodes.Element l : list) {
	            	
	            	Elements link = l.select("b");
	                if(link.text().contains("Brand name:")) {
	                	brand = l.text().substring(l.text().indexOf("Brand name:")+12);
	                	continue;
	                }
	            }
	            System.out.println(drug+"\t"+brand);
	            out.add(drug+"\t"+brand);
	        }
	    }
    }
    
    public static void getHemOncDrugCategory(String file) throws IOException{
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
	        	String category = line.split("\t")[0]+"_"+line.split("\t")[1];
	        	if(line.split("\t").length>2) {
		        	String url = line.split("\t")[2];
		            System.out.println("Fetching "+url);
		            Document doc = Jsoup.connect(url).get();
		            
		            Elements list = doc.select("div.mw-category").select("li");

		            if(list.size()==0) {
		            	list = doc.select("div.mw-content-ltr").select("li");
			            for (org.jsoup.nodes.Element l : list) {
			            	
			            	Elements link = l.select("a[href]");
			                System.out.println(category+"\t"+link.text());
			                out.add(category+"\t"+link.text());
			            }
		            }
		            else {
			            for (org.jsoup.nodes.Element l : list) {
			            	
			            	Elements link = l.select("a[href]");
			                System.out.println(category+"\t"+link.text());
			                out.add(category+"\t"+link.text());
			            }
			           
			            list = doc.select("div.mw-subcategories").select("li");

			            for (org.jsoup.nodes.Element l : list) {
			            	
			            	url = l.select("a[href]").attr("abs:href");
				            System.out.println("Fetching "+url);
				            doc = Jsoup.connect(url).get();
				            
				            Elements list1 = doc.select("div.mw-category").select("li");

				            for (org.jsoup.nodes.Element l1 : list1) {
				            	
				            	Elements link = l1.select("a[href]");
				                System.out.println(category+"\t"+link.text());
				                out.add(category+"\t"+link.text());
				            }
			            }
		            }
	        	}
	        }
	    }
    }
    
    public static void getHemOncDrugStatus(String file) throws FileNotFoundException, IOException {
    	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";

	        while ((line = br.readLine()) != null) {
        		String med = line.split("\t")[0];
        		String status = "";
        		if(line.split("\t").length>2) {
        			status = line.split("\t")[2];
        		}
	        	id.put(med, status);
	        }
	    }
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(folder+"in.txt"))) {
	    	
	        String line = "";

	        while ((line = br.readLine()) != null) {
        		String med = line.split("\t")[1];
	        	out.add(line+"\t"+id.get(med));
	        	System.out.println(line+"\t"+id.get(med));
	        }
	    }
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
    
	public static void printMapFile(HashMap<String,String> map, String _file) throws FileNotFoundException, UnsupportedEncodingException {

        try (PrintWriter writer = new PrintWriter(_file, "UTF-8")) {
        	for (Map.Entry<String,String> entry : map.entrySet()) {
//                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                writer.println(entry.getKey()+"\t"+entry.getValue());
                writer.flush();
        	}
        	
            writer.close();
        }

    }

	public static <T> void removeDuplicates(ArrayList<T> list) {
	    int size = list.size();
	    int out = 0;
	    {
	        final Set<T> encountered = new HashSet<T>();
	        for (int in = 0; in < size; in++) {
	            final T t = list.get(in);
	            final boolean first = encountered.add(t);
	            if (first) {
	                list.set(out++, t);
	            }
	        }
	    }
	    while (out < size) {
	        list.remove(--size);
	    }
	}
	
	public static int searchedWord(String sentence, String searchedWord) {
		
	    if (sentence == null|| searchedWord == null) throw new IllegalArgumentException("May not be null");
	    String[] words = sentence.split(" ");
	    int searchedIndex = -1;
	    for (int i=0; i<words.length; i++) {
	        if (words[i].equals(searchedWord)) searchedIndex = i;
	        if (searchedIndex!=-1) break;
	    }

	    int output = searchedIndex;
//	    System.out.println(output);
	    return output;
	}
	
	public static String removeStopWords(String input){
		
		ArrayList<String> wordsList = new ArrayList<String>();
	    input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");

        for (String word : words) {
            wordsList.add(word);
        }
        
        // remove stop words here from the temp list
        for (int i = 0; i < wordsList.size(); i++) {
            // get the item as string
            for (int j = 0; j < stopwords.length; j++) {
                if (wordsList.contains(stopwords[j])) {
                    wordsList.remove(stopwords[j]);//remove it
                }
            }
        }
        
        // output
        String output = "";
        if(wordsList.size()>0) {
    		output = wordsList.get(0);
            for (int i = 1; i < wordsList.size(); i++) {
            	output = output + " " + wordsList.get(i);
            }
        }
        return output;
	}
	
	public static String removeNumbers(String input){
		
		ArrayList<String> wordsList = new ArrayList<String>();
	    input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");

        for (String word : words) {
        	if(!word.matches("\\d+")&&!word.matches("[A-Za-z]")) {
        		wordsList.add(word);
        	}
        }
        
        // output
        String output = "";
        if(wordsList.size()>0) {
    		output = wordsList.get(0);
            for (int i = 1; i < wordsList.size(); i++) {
            	output = output + " " + wordsList.get(i);
            }
        }
        return output;
	}
	
	public static void removePuncNumbers(String file) throws FileNotFoundException, IOException{
		 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    	
		        String line = ""; 

		        while ((line = br.readLine()) != null) {
		        	line = line.replaceAll("[^a-zA-Z ]", " ").replaceAll("  ", " ").trim();
		        	out.add(line);
		        }
		 }
	}
	
	public static void replaceDrug(String file) throws FileNotFoundException, IOException{
		 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    	
		        String line = ""; 

		        while ((line = br.readLine()) != null) {
		        	
		        	line = line.replaceAll("[^a-zA-Z0-9 ]", " ").trim();

		        	//All
		        	Pattern pat = Pattern.compile("(?i)\\b(FOLFIRINOX[0-9]{0,}|FOLFIRI[0-9]{0,}|FOLFOXFIRI[0-9]{0,}|FOLFOX[0-9]{0,}|FU|carbo|cis|gen|nab|pembrolizuma|[A-Za-z]+nib|[A-Za-z]+mab|Abemaciclib|Abexinostat|Abiraterone|Acalabrutinib|Aclarubicin|Ado trastuzumab emtansine|Afatinib|Afuresertib|Aldesleukin|Alectinib|Alemtuzumab|Alisertib|All trans retinoic acid|Alpelisib|Altretamine|Alvocidib|AMG 330|Aminoglutethimide|Aminopterin|Amrubicin|Amsacrine|Anastrozole|Antithymocyte globulin|Apatinib|Asciminib|Asparaginase|Atezolizumab|Avapritinib|Avelumab|Axicabtagene ciloleucel|Axitinib|Azacitidine|Bacillus Calmette Guerin|Barasertib|BB2121|Belagenpumatucel L|Belinostat|Belotecan|Bendamustine|Bevacizumab|Bevacizumab awwb|Bevacizumab bvzr|Bexarotene|Binimetinib|BL22 immunotoxin|Bleomycin|Blinatumomab|Bortezomib|Bosutinib|Brentuximab vedotin|Brigatinib|Buparlisib|Busulfan|Cabazitaxel|Cabozantinib|Calaspargase|Capecitabine|Capivasertib|Carboplatin|Carfilzomib|Carmustine|Carmustine wafer|Catumaxomab|Cediranib|Cemiplimab|Ceritinib|Cetuximab|Chidamide|Chlorambucil|Cisplatin|Cladribine|Clofarabine|Cobimetinib|Coltuximab ravtansine|Copanlisib|Cortisone|Crenolanib|Crizotinib|Custirsen|Cyclophosphamide|Cyclosporine modified|Cyclosporine non modified|Cyproterone acetate|Cytarabine|Cytarabine and daunorubicin liposomal|Cytarabine liposomal|Dabrafenib|Dacarbazine|Dacomitinib|Dactinomycin|Dasatinib|Daunorubicin|Daunorubicin liposomal|Decitabine|Degarelix|Denileukin diftitox|Denintuzumab mafodotin|Dexamethasone|Dinaciclib|Docetaxel|Dovitinib|Doxifluridine|Doxorubicin|Durvalumab|Dutasteride|Duvelisib|Enasidenib|Encorafenib|Enfortumab vedotin|Ensartinib|Entinostat|Entospletinib|Entrectinib|Epirubicin|Erdafitinib|Eribulin|Erlotinib|Estramustine|Etoposide|Everolimus|Exemestane|Fam trastuzumab deruxtecan|Fedratinib|Filanesib|Finasteride|Floxuridine|Fludarabine|Fluorouracil|Fluoxymesterone|Forodesine|Fostamatinib|Fotemustine|Fruquintinib|Fulvestrant|Galeterone|Ganetespib|Gefitinib|Gemcitabine|Gemtuzumab ozogamicin|Gilteritinib|Glasdegib|Goserelin|Guadecitabine|Hematopoetic progenitor cells|Heptaplatin|Histrelin|Hydrocortisone|Hydroxyurea|Ibritumomab tiuxetan|Ibrutinib|Icotinib|Idarubicin|Idelalisib|Ifosfamide|Imatinib|Imetelstat|Infigratinib|Inotuzumab ozogamicin|Interferon alfa 2a|Interferon alfa 2b|Interferon gamma 1b|Ipatasertib|Ipilimumab|Irinotecan|Irinotecan liposome|Isotretinoin|Ivosidenib|Ixabepilone|Ixazomib|Ketoconazole|Lanreotide|Lapatinib|Lapuleucel T|Larotrectinib|Lenalidomide|Lenvatinib|Lestaurtinib|Letrozole|Leuprolide|Lobaplatin|Lomustine|Lorlatinib|Masitinib|Mechlorethamine|Melphalan|Mercaptopurine|Methotrexate|Methylprednisolone|Midostaurin|Mitomycin|Mitoxantrone|Mocetinostat|Momelotinib|Motesanib|Moxetumomab pasudotox|Necitumumab|Nedaplatin|Nelarabine|Neratinib|Nilotinib|Nimustine|Nintedanib|Niraparib|Nivolumab|Nolatrexed|Obinutuzumab|Octreotide|Octreotide LAR|Ofatumumab|Olaparib|Olaratumab|Omacetaxine|Oprozomib|Orteronel|Osimertinib|Oxaliplatin|Paclitaxel|Pacritinib|Palbociclib|Panitumumab|Panobinostat|Pazopanib|Pegaspargase|Peginterferon alfa 2a|Peginterferon alfa 2b|Pembrolizumab|Pemetrexed|Pentostatin|Perifosine|Pertuzumab|Pictilisib|Pidilizumab|Pirarubicin|Pixantrone|Plicamycin|Polatuzumab vedotin|Pomalidomide|Ponatinib|Pracinostat|Pralatrexate|Prednisolone|Prednisone|Procarbazine|Quisinostat|Quizartinib|Radotinib|Raloxifene|Raltitrexed|Ramucirumab|Ranimustine|Refametinib|Regorafenib|Retaspimycin|Ribociclib|Ricolinostat|Rilotumumab|Rituximab|Rituximab abbs|Rituximab pvvr|Rociletinib|Romidepsin|Ropeginterferon alfa 2b|Rucaparib|Ruxolitinib|Sacituzumab govitecan|Sapacitabine|Selinexor|Selumetinib|Semustine|Sipuleucel T|Sirolimus|Sonidegib|Sorafenib|Spebrutinib|Streptozocin|Sunitinib|Tacrolimus|Talazoparib|Talimogene laherparepvec|Tamibarotene|Tamoxifen|Tazemetostat|Tegafur and uracil|Tegafur gimeracil oteracil|Telotristat|Temozolomide|Temsirolimus|Teniposide|Tesetaxel|Thalidomide|Thioguanine|Thiotepa|Tipifarnib|Tisagenlecleucel|Tivantinib|Tivozanib|Tofacitinib|Topotecan|Toremifene|Tosedostat|Tositumomab & I 131|Trabectedin|Trametinib|Trastuzumab|Trastuzumab and hyaluronidase|Trastuzumab anns|Trastuzumab dkst|Trastuzumab dttb|Trastuzumab pkrb|Trastuzumab qyyp|Trebananib|Tremelimumab|Treosulfan|Trifluridine and tipiracil|Trimethoprim Sulfamethoxazole|Triptorelin|Uracil mustard|Vadastuximab talirine|Valacyclovir|Valganciclovir|Valproate|Valrubicin|Vandetanib|Veliparib|Veltuzumab|Vemurafenib|Venetoclax|Vinblastine|Vincristine|Vincristine liposomal|Vindesine|Vinflunine|Vinorelbine|Vismodegib|Volasertib|Vorinostat|Vosaroxin|Zanubrutinib|Ziv aflibercept|Megestrol|Dabrafenib trametinib|Vemurafenib cobimetinib|Herceptin|Bevacizumab|Ipiliumamab|Plenaxis|ReoPro|Verzenio|PCI 24781|Zytiga|Calquence|Tylenol|Aclacinomycin|Actimab A|Zovirax|TG1042|Kadcyla|Gilotrif|GSK2110183|Proleukin|Alecensa|Campath|Fosamax|MLN8237|ATRA|Zyloprim|Piqray|Xanax|Hexalen|Flavopiridol|MORAb 009|Ethyol|Amicar|Cytadren|Quinamed|Calsed|Amsidine|Agrylin|Arimidex|Stemgen|FEIBA NF|Atgam|Grafalon|Thymoglobulin|Erleada|Aitan|Eliquis|APG101|Emend|Acova|Trisenox|ABL001|Vitamin C|Elspar|Erwinaze|Aggrenox|GSK1572932A|Tecentriq|Atropen|Mepron|Ayvakit|Doptelet|Bavencio|Yescarta|Inlyta|Vidaza|BCG|AZD1152|PGN401|Lucanix|Beleodaq|Camptobell|Fasenra|Bevyxxa|Avastin|Mvasi|Zirabev|Targretin|Casodex|MEK162|Angiomax|CAT 3888|Blenoxane|Blincyto|Velcade|Bosulif|Adcetris|Alunbrig|BKM120|Suprefact|Myleran|Jevtana|Cabometyx|Cometriq|Asparlas|Caphosol|Kengreal|Xeloda|AZD5363|Cablivi|Paraplatin|Kyprolis|BCNU|Gliadel|Cancidas|Removab|Recentin|Libtayo|Zykadia|Zyrtec|Erbitux|Epidaza|Leukeran|DCNU|Chlor Trimeton|Pletal|Tagamet|Cipro|Platinol|IMC A12|Leustatin|Biaxin|Tavist|Bonefos|Clolar|Plavix|Cotellic|CoR, SAR3419|Aliqopa|CP 868,596|Adakveo|Xalkori|OGX 011|Vitamin B12|Cytoxan|Neoral|Sandimmune|Androcur|Ara C|Vyxeos|DepoCyt|Cytogam|Pradaxa|Tafinlar|DTIC|Vizimpro|Cosmegen|Fragmin|Danocrine|Aczone|Darzalex|Aranesp|Nubeqa|Sprycel|Cerubidine|DaunoXome|Dacogen|Exjade|Jadenu|Ferriprox|Desferal|Defitelio|Firmagon|Ontak|SGN CD19A|Xgeva|DDAVP|Decadron|Polaramine|Zinecard|DES|SCH 727965|Unituxin|Benadryl|Persantine|XAA296|Taxotere|Colace|Anzemet|Motilium|TKI 258|Didox|Adriamycin|Doxil|Marinol|Imfinzi|Avodart|Copiktra|Soliris|Savaysa|Panorex|Empliciti|Promacta|Gamifant|Hemlibra|Stimuvax|Idhifa|LGX818|Padcev|Lovenox|X 396|SNDX 275|GS 9973|Rozlytrek|Xtandi|Ellence|Procrit|Retacrit|LymphoCide|Integrilin|Balversa|Halaven|Tarceva|Emcyt|NKTR 102|Vepesid|Afinitor|Aromasin|NovoSeven RT|Alprolix|Coagadex|Andexxa|Corifact|Famvir|Pepcid|Enhertu|Inrebic|Injectafer|Ferrlecit|Feosol|Feraheme|RiaSTAP|ARRY 520|Neupogen|Nivestym|Zarxio|Proscar|5 FU|FUDR|Diflucan|Fludara|Halotestin|Eulexin|Folate|Leucovorin|Arixtra|Lentaron|Fodosine|Emend for Injection|Tavalisse|Muphoran|HMPL 013|Faslodex|Lasix|TOK 001|LY2157299|STA 9090|AMG 479|Iressa|Gemzar|CP 4126, CO 101|Mylotarg|Xospata|Daurismo|CDX 011|Voraxaze|Zoladex|Kytril|Sancuso|Sustol|SGI 110|Haldol|Hemacord|Sunpla|AE37|Vantas|Cortef|Hydrea|Boniva|Zevalin|Imbruvica|Conmana|Idamycin|Praxbind|RG7388|Zydelig|Ifex|Gleevec|GRN163L|BT062|Indocin|BGJ398|Besponsa|Roferon A|Intron A|Actimmune|Azedra|GDC 0068|Yervoy|Camptosar|Onivyde|INFeD|Venofer|SAR 650984|Accutane|Sporanox|Tibsovo|Ixempra|Ninlaro|Nizoral|Epivir|Somatuline|Prevacid|Tykerb|DN24 02|Vitrakvi|Fablyn|Revlimid|Granocyte|Lenvima|Refludan|CEP 701|Prevymis|Femara|Lupron|Ergamisol|Levaquin|Fusilev|Endari|ABT 869|OSI 906|XM22|D 19466|CCNU|Imodium|Ativan|Lorbrena|BB 10901|Reblozyl|Mulpleta|Lutathera|HGS ETR1|AB1010|Mustargen|MPA|Megace|Alkeran|Demerol|Nucala|6 MP|Mesnex|MTX|Uvadex|Solumedrol|Reglan|Rydapt|Mepact|TL139|IMGN853|Mutamycin|Lysodren|Novantrone|MGCD0103|Poteligeo|CYT387|AMG 706|Lumoxiti|CellCept|Cesamet|Portrazza|Aqupla|Arranon|Nerlynx|Akynzeo|Tasigna|Nilandron|ACNU|Vargatef|Zejula|Opdivo|Thymitaq|Myocet|Nilevar|Optune|Gazyva|Sandostatin|Sandostatin LAR|Arzerra|Zyprexa|Lynparza|NOX A12|Lartruvo|Synribo|Prilosec|MetMAb|Zofran|Neumega|ONX 0912|TAK 700|Tagrisso|BAY 1213790|TRU 016|Eloxatin|Taxol|Abraxane|Genexol PM|SB1518|Ibrance|Kepivance|Aloxi|Aredia|Vectibix|Farydak|Protonix|Votrient|Oncaspar|Neulasta|Udenyca|Fulphila|Pegasys|Sylatron|Keytruda|Alimta|Nebupent|Nipent|PRM 151|KRX 0401|Perjeta|Turalio|Dilantin|PI 88|Vitamin K|GDC 0941|CT 011|DCDT2980S|THP|Pixuvri|Mozobil|Mithracin|NPI 2358|Polivy|Pomalyst|Iclusig|Photofrin|SB939|Folotyn|Effient|Pravachol|Sterapred|Millipred|Matulane|Compazine|Phenergan|Qualaquin|JNJ 26481585|AC220|Aciphex|Xofigo|Supect|Evista|Tomudex|Iribo|Cyramza|Cymerin|Zantac|Elitek|Ultomiris|BAY 869766|Stivarga|Reolysin|IPI 504|RhoGAM|Kisqali|ACY 1215, Rocilinostat|AP23573|AMG 102|Actonel|Rituxan|Truxima|Ruxience|Rituximab Hycela|Xarelto|CO 1686|Varubi|Istodax|Nplate|AOP2014|Rubraca|Jakafi|IMMU 132|Quadramet|CS 682|MLN0128|Leukine|Scopoderm|CYC202|Xpovio|LOXO 292|AZD6244|AVE5026|MeCCNU|Senna|Sylvant|Provenge|Rapamune|Odomzo|Nexavar|CC 292|Zanosar|Metastron|Sutent|HMPL 012|BIVV009|LY2127399|Prograf|Elzonris|Talzenna|Imlygic|Amnoid|Nolvadex|Tazverik|Granix|UFT|Teysuno, S 1|Xermelo|Temodar|Torisel|Vumon|DJ 927|XL647|Thalomid|Tabloid|Tepadina|Thioplex|Brilinta|Ticlid|CS 1008|Innohep|Zarnestra|GS 4059|Aggrastat|Kymriah|ARQ 197|AV 951|Actemra|Xeljanz|Hycamtin|Fareston|CHR 2797|Bexxar|Yondelis|Mekinist|Cyklokapron|Kanjinti|Ogivri|Ontruzant|Herzuma|Trazimera|Herceptin Hylecta|AMG 386|ticilimumab|Ovastat|Lonsurf|Bactrim DS|Trelstar LA|Navoban|TG 1101|TGR 1202|UFH|Vistogard|SGN CD33A|Valtrex|Valcyte|Depakote|Valstar|Caprelsa|CDX 1127|ABT 888|hA20|Zelboraf|Venclexta|Velban|Oncovin|Marqibo|Eldisine|Javlor|Navelbine|Erivedge|BI 6727|Zontivity|Vfend|Zolinza|SNS 595|Oxbryta|XL765|Coumadin|Brukinsa|Zaltrap|Zometa|SAR3419|CP 868|CP 4126|ACY 1215|Teysuno|CP 596|CO 101|Rocilinostat)\\b");
		        	Matcher mat = pat.matcher(line);
		        	while(mat.find()) {
		        		line = line.replace(mat.group(), "Drug");
		        		System.out.println(mat.group());
		        	}
		        	
		        	line = line.replaceAll("[^a-zA-Z ]", " ").trim();
		        	
		        	while(line.contains("  ")) {
		        		line = line.replaceAll("  ", " ");
		        	}
		        	
		        	out.add(line);
		        }
		 }
	}
	
	public static void nGramDrug(String file) throws FileNotFoundException, IOException{
		 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    	
		        String line = ""; 

		        while ((line = br.readLine()) != null) {
		        	
		        	line = line.replaceAll("drug drug", "drug").replaceAll("drug drug", "drug").replaceAll("drug drug", "drug").replaceAll("drug drug", "drug");
		        	String[] words = line.split(" ");
		        	int index = searchedWord(line, "drug");
	        		System.out.println(line+"\t"+index);
	        		
	        		String output = "";
	        		if(index>=0) {
	        			output = "drug";
	        			if(index-5>=0) {
	        				for (int i = index-1; i >=index-5; i--) {
		        				output =  words[i]+" "+output;
		        			}
	        			}
	        			else{
	        				for (int i = index-1; i >=0; i--) {
		        				output =  words[i]+" "+output;
		        			}
	        			}
	        			
	        			if(index+5<=words.length-1) {
	        				for (int i = index+1; i <=index+5; i++) {
		        				output =  output+" "+words[i];
		        			}
	        			}
	        			else {
	        				for (int i = index+1; i <=words.length-1; i++) {
		        				output =  output+" "+words[i];
		        			}
	        			}
	        		}
	        		System.out.println(output);
	        		out.add(output);
		        }
		 }
	}
	
	public static int countOccurences(String str, String word) 
	{
	    // split the string by spaces in a
	    String a[] = str.split(" ");
	
	    // search for pattern in a
	    int count = 0;
	    for (int i = 0; i < a.length; i++) 
	    {
	    // if match found increase count
	    if (word.equals(a[i]))
	        count++;
	    }
	
	    return count;
	}
	
	public static String getRelationship2(String output, String sentence, int min, String aa, String bb) 
	{
		int a = searchedWord(sentence, aa);
		int b = searchedWord(sentence, bb);
		if(Math.abs(a-b)<min&&b!=-1) {
			output = Math.abs(a-b)+"\t"+aa+"\t"+bb+"\t"+sentence;
			//min gene mut sentence
		}
		
		return output;
	}
	
	public static String getRelationship3(String output1, String sentence, int min, String aa, String bb, String cc) 
	{
		sentence = sentence.replace(cc, cc.replaceAll(" ", "_"));
		cc = cc.replaceAll(" ", "_");
		
		int a = searchedWord(sentence, aa);
		int b = searchedWord(sentence, bb);
		int c = searchedWord(sentence, cc);
		if((Math.abs(b-c)<min&&Math.abs(b-c)<=Math.abs(a-c))&&c!=-1) {
			min = b-c;
			output1 = Math.abs(b-c)+"\t"+cc+"\t"+aa+"\t"+bb;
		}
		else if((Math.abs(a-c)<min&&Math.abs(b-c)>Math.abs(a-c))&&c!=-1) {
			min = a-c;
			output1 = Math.abs(a-c)+"\t"+cc+"\t"+aa+"\t"+bb;
		}
		
		return output1;
	}
	
	public static String matchAndReplaceNonEnglishChar(String tmpsrcdta){
			
			String subjectString = "Nereida nuÃ±ez";
			subjectString = StringUtils.stripAccents(tmpsrcdta);
	//		subjectString = Normalizer.normalize(tmpsrcdta, Normalizer.Form.NFD);
			String resultString = subjectString.replaceAll("[^\\p{ASCII}]", " ");
//			if(resultString.equals(subjectString)) {
//				System.out.println(resultString);
//			}
			return resultString;
	}
	
	public static void splitFile(String file) throws FileNotFoundException, IOException {
		
	    ArrayList<String> temp = new ArrayList<>();
	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	
	            temp.add(line);
	
	        }
	    }
	    int splitNum = (int) Math.floor(temp.size() / 1048576) + 1;
	    System.out.println(temp.size());
	    System.out.println(splitNum);
	    for (int i = 0; i < splitNum; i++) {
	        PrintWriter writer = new PrintWriter(file + i+".csv", "UTF-8");
	        for (int j = 0; j < 1048576; j++) {
	            writer.println(matchAndReplaceNonEnglishChar(temp.get(i * 1048576 + j)));
	            writer.flush();
	        }
	        writer.close();
	    }
	}

	public static void splitTXT(String file) throws FileNotFoundException, IOException {
		
	    ArrayList<String> temp = new ArrayList<>();
	
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	
	        String line = "";
	
	        while ((line = br.readLine()) != null) {
	        	String id = line.split("\t")[0]+"\t"+line.split("\t")[1];
	        	String[] lines = line.split("\t")[2].split("\\.");
	        	
	        	for (String l : lines) {
	        		if(!l.trim().equals("")) {
	        			 out.add(id+"\t"+l.trim());
	        		}
	        	}
	        }
	    }
	}
}
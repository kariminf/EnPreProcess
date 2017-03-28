/*
 * AllSumarizer v2
 * This file is part of AllSummarizer project; an implementation of the method
 * described in this paper:
 * http://dx.doi.org/10.1117/12.2004001
 * 
 * Copyright (C) 2013  Abdelkrime Aries <kariminfo0@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package kariminf.langpi.basic.nynorsk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import kariminf.langpi.basic.SWEliminator;



public class NnSWEliminator implements SWEliminator {

	private final String  pathToStopWords = "/ressources/stopWords/norwegian.stop";
	private List<String> stopList = 
			getStopList(pathToStopWords);//stopwords.txt
	
	public Boolean isNotStopWord(String word) {
			
		word = word.toLowerCase().trim();
		if (!stopList.contains(word)) //
			return true;

		return false;
	}
	
	private Boolean isStopWord(String word) {
	    word = word.toLowerCase().trim();
	    if (stopList.contains(word)) //a non-word character
			return true;
		
		return false;
	}
	
	public void deleteSW(List<String> wordsList){
		for(int i=wordsList.size()-1; i >=0; i--)
			if (isStopWord(wordsList.get(i)))
				wordsList.remove(i);
	}
	
	private static List<String> getStopList(String path) {
		
		List<String> stopwords = new ArrayList<String>();
	    try {

	    	InputStream in = NnSWEliminator.class.getResourceAsStream(path);
	    	BufferedReader input = new BufferedReader(
		                new InputStreamReader(in));
	      for(String line = input.readLine(); line != null; line = input.readLine()) {
	    	  if (line.startsWith("#")) continue;
	    	  stopwords.add(line);
	      }
	      input.close();

	      return stopwords;
	      
	    } catch(IOException e) {
	      e.printStackTrace();
	      System.exit(1);
	      return null;
	    } 
	  }
	
	
	public static void main(String[] args) {
		List<String> tstList = new ArrayList<String>();
		tstList.add("fitjar");
		tstList.add("kommune");
		tstList.add("består");
		tstList.add("av");
		tstList.add("den");
		tstList.add("nordlege");
		tstList.add("halvdelen");
		tstList.add("øya");
		tstList.add("stord");
		tstList.add("og");
		tstList.add("fitjarøyane");
		tstList.add("som");
		tstList.add("ligg");
		tstList.add("mellom");
		tstList.add("stord");
		tstList.add("bømlo");
		
		SWEliminator eliminator = new NnSWEliminator();
		eliminator.deleteSW(tstList);
		
		System.out.println(tstList.toString());
		

	}


}
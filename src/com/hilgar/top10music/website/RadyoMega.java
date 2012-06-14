package com.hilgar.top10music.website;

import java.io.IOException;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hilgar.top10music.util.Helper;

public class RadyoMega {

	public String[] getList (String urlString){
		String data = "";
		Document doc = null;
		Document doc2 = null;
		try {
			doc = Jsoup.connect(urlString).get();
			doc.outputSettings().charset(Charset.forName("utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0;
		Elements els = doc.getElementsByClass("MsoNormal");
		String top10TmpSong[] = new String[els.size()];
		for (Element el : els) {
			top10TmpSong[count] = Helper.clearTurkishChars(el.text());
			count++;
		}

		String top10[] = new String[10];
		for (int i = 0; i < top10.length; i++) {
			top10[i] = top10TmpSong[i].replaceAll("[^a-zA-ZöÖüÜşŞğĞıİçÇ]"," ").trim();
		}
		return top10;
    }
	
	
}

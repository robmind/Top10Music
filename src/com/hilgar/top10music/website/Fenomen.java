package com.hilgar.top10music.website;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hilgar.top10music.util.Helper;

public class Fenomen {

	public String[] getList (String urlString){
		String data = "";
		Document doc = null;
		Document doc2 = null;
		try {
			doc = Jsoup.connect(urlString).get();
			doc2 = Jsoup.connect(urlString).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0;
		Elements els = doc.getElementsByClass("yazi");
		String top10TmpSong[] = new String[els.size()];
		for (Element el : els) {
			top10TmpSong[count] = Helper.clearTurkishChars(el.text());
			count++;
		}
		
		int count2 = 0;
		Elements els2 = doc2.getElementsByClass("mavi");
		String  top10TmpSinger[] = new String[els2.size()];
		for (Element el2 : els2) {
			top10TmpSinger[count2] = el2.text();
			count2++;
		}
		
		String top10[] = new String[10];
		for (int i = 0; i < top10.length; i++) {
			top10[i] = top10TmpSinger[i] + " " + top10TmpSong[i == 0 ? 2 : i * 2 + 2];
		}
		return top10;
    }
}

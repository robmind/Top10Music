package com.hilgar.top10music.website;

import java.io.IOException;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hilgar.top10music.util.Helper;

public class Virgin {

	public String[] getList (String urlString){
 		String data = "";
		Document doc = null;
		Document doc2 = null;
		try {
			doc = Jsoup.connect(urlString).get();
			doc.outputSettings().charset(Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0;
		Elements els = doc.getElementsByClass("clearfix");
		String top10TmpSong[] = new String[els.size()];
		for (Element el : els) {
			top10TmpSong[count] = Helper.clearTurkishChars(el.text());;
			count++;
		}
		// 8, 11, 14, 17, 20, 23, 26, 29, 32
		String top10[] = new String[top10TmpSong.length];
		/*for (int i = 0; i < top10.length; i++) {
			top10[i] = top10TmpSong[i + 8];
		}*/
		int count2 = 8;
		int count3 = 0;
		for (int counter = 0; counter < 60; counter = counter + 1){
			top10[count3] = top10TmpSong[++counter+count2++-1];
			count3++;
		}
		
		return top10;
    }
}

package com.hilgar.top10music.website;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hilgar.top10music.util.Helper;

public class KANALD {

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
		Elements els = doc.getElementsByClass("mediumText");
		String top10TmpSong[] = new String[els.size()];
		for (Element el : els) {
			top10TmpSong[count] = Helper.clearTurkishChars(el.text());
			count++;
		}

		String top10[] = new String[10];
		for (int i = 0; i < top10.length; i++) {
			top10[i] = top10TmpSong[i];
		}
		
		String top10List[] = new String[10];
		int i = 0;
		Pattern patternRecordID = Pattern.compile("<b style=\"color:#320099\">(.*?)</b>");
		Elements newsHeadlines = doc.select("b");
		int counts = 0;
		for (Element element : newsHeadlines) {
			Matcher matcherRecordID = patternRecordID.matcher(element.toString());
			
			while (matcherRecordID.find()) {
				if (i < 10){
					top10List[i] = top10[i] + " " + matcherRecordID.group(1);
					i++;
				}
            }
			if (20 < counts) break;counts++;
		}
		
		return top10List;
    }
}

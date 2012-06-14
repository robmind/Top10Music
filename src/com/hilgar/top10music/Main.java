package com.hilgar.top10music;

import com.hilgar.top10music.config.WebSiteList;
import com.hilgar.top10music.website.Best;
import com.hilgar.top10music.website.Fenomen;
import com.hilgar.top10music.website.KANALD;
import com.hilgar.top10music.website.Kral;
import com.hilgar.top10music.website.PAL;
import com.hilgar.top10music.website.RadyoMega;
import com.hilgar.top10music.website.Virgin;

public class Main {
	public static void main(String[] args) {
		//System.out.println(WebSiteList.getNameOfSiteName("FENOMEN"));
		PAL pal = new PAL();
		String[] top10PAL = kral.getList(WebSiteList.getNameOfSiteUrl("PAL"));
		for (int i = 0; i < 10; i++) {
			System.out.println(top10PAL[i]);
		}
		
	}
}

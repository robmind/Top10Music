package com.hilgar.top10music.config;

public enum WebSiteList {
	    FENOMEN ("Radyo Fenomen", "http://www.radyofenomen.com/top10.asp"),
	    KRAL ("KRAL FM", "http://www.kraltv.com.tr/liste.asp"),
	    VIRGIN ("Virgin Radyo", "http://www.virginradioturkiye.com/charts/Chart30"),
	    KANALD ("RADYO D", "http://www.radyod.com.tr/radyoDtop40.asp"),
	    RADYOMEGA ("RADYO MEGA", "http://www.radyomega.fm/mega-20.html"),
	    BEST ("Best FM", "http://www.bestfm.com.tr/Best20.aspx"),
	    PAL ("PAL STATION", "http://www.palstation106.com/haftalik_hot_40_listesi.html");

	    private final String _siteName;
	    private final String _siteUrl;
	    WebSiteList(String siteName, String siteUrl) {
	        this._siteName = siteName;
	        this._siteUrl = siteUrl;
	    }
	    private String _site_Name() { return _siteName; }
	    private String _site_Url() { return _siteUrl; }

	    public static String getNameOfSiteName (String value){
	        for (WebSiteList sname : WebSiteList.values())
	        	if (value.compareTo(sname.toString()) == 0)
	        		return sname._siteName;
	        return Description.EmtpyName;
	    }
	    
	    public static String getNameOfSiteUrl (String value){
	        for (WebSiteList sname : WebSiteList.values())
	        	if (value.compareTo(sname.toString()) == 0)
	        		return sname._siteUrl;
	        return Description.EmtpyName;
	    }
	}
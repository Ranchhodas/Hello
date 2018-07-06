package edu.csuft.lichao.spider;
/**
 * ÅÀ³æ³ÌÐòµÄÆô¶¯Æ÷
 * 
 * @author Rancho
 *
 */ 

public class App {
	
	// alt+/
		public static void main(String[] args) {
			Spider spider=new Spider("https://movie.douban.com/top250");
			spider.run();
			
		}

}

package edu.csuft.lichao.spider;
/**
 * ��������������
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

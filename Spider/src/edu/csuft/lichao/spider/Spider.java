package edu.csuft.lichao.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 爬虫
 * 
 * @author Rancho
 *
 */

public class Spider {
	
	String url;
	
	/**
	 * 存储所有影片列表
	 */
	List<Film> filmList = new ArrayList<>();
	
	/**
	 *爬虫的构造方法 
	 * @param url  目标页面
	 */
	public Spider(String url) {
		
		this.url=url;
	}
	
	/**
	 * 执行
	 */
	public void run() {
		
		//抓去数据
		try {
			Document doc = Jsoup.connect(url).get();
//			System.out.println(doc.title());
//			System.out.println(doc.text());
//			System.out.println(doc.html());
			
			//<a></a> pageRank
			Elements items = doc.select(".grid_view .item");
			System.out.println(items.size());
			
			//遍历
			for(Element item :items) {
				Film film = new Film();
				
				film.title = item.select(".title").get(0).text();
				film.poster = item.select("img").get(0).attr("src");
				film.info = item.select(".info .bd p").get(0).text();
				film.quote = item.select("p").get(1).text();
				film.rating = item.select(" .star span").last().text();
				String num = item.select(" .rating_num").first().text();
				String id = item.select(" .pic em").first().text();
				film.id=Integer.parseInt(id);
				film.star = Double.parseDouble(num);
				
				
				System.out.println(film);
				filmList.add(film);
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		Document doc = Jsoup.connect(url).get();
		
	}
	



}

package edu.csuft.lichao.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ����
 * 
 * @author Rancho
 *
 */

public class Spider {
	
	String url;
	
	/**
	 * �洢����ӰƬ�б�
	 */
	List<Film> filmList = new ArrayList<>();
	
	/**
	 *����Ĺ��췽�� 
	 * @param url  Ŀ��ҳ��
	 */
	public Spider(String url) {
		
		this.url=url;
	}
	
	/**
	 * ִ��
	 */
	public void run() {
		
		//ץȥ����
		try {
			Document doc = Jsoup.connect(url).get();
//			System.out.println(doc.title());
//			System.out.println(doc.text());
//			System.out.println(doc.html());
			
			//<a></a> pageRank
			Elements items = doc.select(".grid_view .item");
			System.out.println(items.size());
			
			//����
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

package edu.csuft.lichao.spider;





/**
 * 影片的信息
 * @author Rancho
 *
 */
public class Film {
	
	/**
	 * 排名
	 */
	int id;
	
	/**
	 * 片名
	 */
	String title;
	
	/**
	 * 导演
	 */
	String info;
	
	/**
	 * 评分
	 */
	double  star;
	
	/**
	 * 评价
	 */
	String rating;
	/**
	 * 海报路径
	 */
	String poster;
	
	/**
	 * 概要
	 */
	String quote;
	
	
@Override
public String toString() {
	return "Film [id=" + id + ", title=" + title + ", info=" + info + ", star=" + star + ", rating=" + rating
				+ ", poster=" + poster + ", quote=" + quote + "]";

	

}
	
	
}

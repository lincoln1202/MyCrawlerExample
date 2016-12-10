package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				 +"/crazyck101/posts?fields=id,link,message,reactions.type(HAHA).limit(0).summary(total_count)&since=1480849200&until=1480856400"
				+ "&access_token=EAACEdEose0cBAO8qWCrA5ZA0Kv8ber4t1iZCm1F7uo95OFpda9PYKwOI8vC4bEZBNJSlBrAsSsaYVutMsXskpAyxfBCpw8NBXdwCAjK0pRYMZB6ZCpA6ZB8QjUG9hHgZAHVDhtXMUMwLMRlARbWpSYljjRwqBpLQs2sxafCmVcRfAZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,按讚(HAHA)人數"+"\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String message = data.select("total_count").text();


			// FIXIT



			output += id + ","+message+ "\n";
		}

		System.out.println( output );
	} 
}

package huy.my_books.common;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetDataHTML {

	public String getData(String urlfile) {
		String result = "";
		try {
			URL url = new URL(urlfile);
			InputStream is = url.openConnection().getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = reader.readLine()) != null) {
				result += line;
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public String getDataDicChapter(String htmlFile) {

		// strip out your required data with a regex
		Pattern pattern = Pattern.compile(".*<div class=\"chapter-c\">(.*?)</div>.*");
		Matcher matcher = pattern.matcher(htmlFile);

		if (matcher.find()) {
			System.out.println(matcher.group(1));
		}

		return "";
	}

	public void getInfoBook(String htmlFile) {
		String nameBook;
		String nameActor;
		String[] nameCatelogy;
		String statusBook;
		String infoBook;
		int numVote;
		String starVote;

		Pattern pattern = Pattern.compile(".*<h3 class=\"title\" itemprop=\"name\">(.*?)</h3>.*");
		Matcher matcher = pattern.matcher(htmlFile);
		if (matcher.find()) {
			System.out.println(matcher.group(1));
			nameBook = matcher.group(1);
		}

		pattern = Pattern.compile(".*<h3>Tác giả:</h3>(.*?)</div>.*");
		matcher = pattern.matcher(htmlFile);
		if (matcher.find()) {
			System.out.println(matcher.group(1));
			nameActor = matcher.group(1);
		}

		pattern = Pattern.compile(".*<span itemprop=\"ratingValue\">(.*?)</span>.*");
		matcher = pattern.matcher(htmlFile);
		if (matcher.find()) {
			System.out.println(matcher.group(1));
			starVote = matcher.group(1);
		}

	}

	public void getInfoBookJsuop(String nameLink) {
		Document doc;
		String nameBook;
		String nameActor;
		List<String> nameCatelogy = new ArrayList<String>();
		String statusBook;
		String infoBook;
		int numVote;
		String starVote;
		try {

			doc = Jsoup.connect(nameLink).get();

			nameBook = doc.select("h3[itemprop=name]").get(0).text();
			System.out.println("\nnameBook : " + nameBook);

			nameActor = doc.select("a[itemprop=author]").get(0).text();
			System.out.println("\nnameActor : " + nameActor);

			Pattern pattern = Pattern.compile(".*<div><h3>Thể loại:</h3>(.*?)</h3>.*");
			Matcher matcher = pattern.matcher(getData(nameLink));
			if (matcher.find()) {
				Document docCatelogy = Jsoup.parse(matcher.group(1).toString());

				Elements nameCatelogys = docCatelogy.select("a[itemprop=genre]");
				for (Element item : nameCatelogys) {
					System.out.println("\nnameCatelogy : " + item.text());
					nameCatelogy.add(item.text());

				}
			}

			statusBook = doc.select("span[class=text-success]").get(0).text();
			System.out.println("\nstatusBook : " + statusBook);

			infoBook = doc.select("div[itemprop=description]").get(0).text();
			System.out.println("\ninfoBook : " + infoBook);

			numVote = Integer.parseInt(doc.select("span[itemprop=ratingCount]").get(0).text());
			System.out.println("\nnumVote : " + numVote);

			starVote = doc.select("span[itemprop=ratingValue]").get(0).text();
			System.out.println("\nstarVote : " + starVote);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GetDataHTML getdata = new GetDataHTML();

		// //
		// getdata.getInfoBook(getdata.getData("http://truyenfull.vn/nga-duc-phong-thien/trang-1/"));
		getdata.getInfoBookJsuop("http://truyenfull.vn/nga-duc-phong-thien/trang-1/");

		int count = 0;
		Document doc;
		try {

			// need http protocol
			doc = Jsoup.connect("http://truyenfull.vn/nga-duc-phong-thien/trang-1/").get();

			// get all links
			Elements links = doc.select("ul[class=list-chapter]").select("a[href]");
			for (Element link : links) {

				System.out.println("\nlink : " + link.attr("href"));
				getdata.getDataDicChapter(getdata.getData(link.attr("href")));

				count++;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(count);
	}

}

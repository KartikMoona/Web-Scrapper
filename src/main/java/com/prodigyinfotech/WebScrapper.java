package com.tech;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrapper {

    private static final String website_to_scrape = "https://books.toscrape.com/";
    private static final String query_class_for_product = ".product_pod";
    private static final String title_of_file = "Web-Scrapper for books";
    private static final String comma = ",";

    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect(website_to_scrape).get(); //Using the DOM API of Jsoup.
            Elements books = document.select(query_class_for_product);
            //Using cssQuery to target the class through which all the books are assigned.

            System.out.println(title_of_file);
            for (Element book : books) {
                String title = book.select("h3 > a").text();
                //for selecting the products title as they were stored in the 3rd header tag and in anchor html tag
                String price = book.select(".price_color").text();
                //for selecting the price as the price tag was stored in the price color class

                System.out.println(title + comma + price);
            }
        } catch (IOException exception) {
            //When the above URL will fail then this input output exception will occur.
            System.err.println(exception.getMessage());
        }
    }
}

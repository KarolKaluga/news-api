import com.google.gson.Gson;
import model.*;

import java.io.*;
import java.net.URL;
import java.util.List;

public class RestClient {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=fe8ace6e181e4569bdfcf207960ee142");
        InputStreamReader reader = new InputStreamReader(url.openStream());

        ArticleInfo articleInfo= new Gson().fromJson(reader, ArticleInfo.class);
        List<Article> articles=articleInfo.getArticles();
        InfoToFile infoToFile = new InfoToFile();

        String fileName="articlesInfo.txt";
        try(
                FileWriter fileWriter=new FileWriter(fileName);
                BufferedWriter writer=new BufferedWriter(fileWriter);
                ) {
            for (Article article : articles) {
                infoToFile.writeInfo(writer,article);
            }
        }catch (IOException e){
            System.err.println("Błąd przy zapisu pliku "+fileName);
        }
    }
}

import model.Article;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InfoToFile {
    public void writeInfo(BufferedWriter writer, Article article) throws IOException {
        String title = article.getTitle();
        String description = article.getDescription();
        String author = article.getAuthor();
        if (title != null)
            writer.write(title);
        else
            writer.write("null");
        writer.write(":");
        if (description != null)
            writer.write(description);
        else
            writer.write("null");
        writer.write(":");
        if (author != null)
            writer.write(author);
        else
            writer.write("null");
        writer.newLine();
    }
}

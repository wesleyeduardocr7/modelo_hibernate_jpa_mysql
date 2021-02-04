package aplicacao.utils;
import java.io.*;

public class QueryUtils {

    public static String getQuery(String nomeArquivoDaQuery) {

        StringBuilder sql = new StringBuilder();

        String diretorio = ("src/main/resources/queries/"+nomeArquivoDaQuery);

        File arquivo = new File(diretorio);

        try {

            FileReader fr = new FileReader( arquivo );
            BufferedReader br = new BufferedReader( fr );

            while( br.ready() ){
                String linha = br.readLine();
                sql.append(linha + " ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sql.toString();
    }
}
